package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.ddd.domain.course.commands.AddAttendee;
import com.sofka.ddd.domain.course.events.AttendeeAdded;
import com.sofka.ddd.domain.course.events.CourseCreated;
import com.sofka.ddd.domain.course.values.Age;
import com.sofka.ddd.domain.course.values.AttendeeID;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.CourseName;
import com.sofka.ddd.domain.course.values.DateOfCourse;
import com.sofka.ddd.domain.course.values.Email;
import com.sofka.ddd.domain.course.values.Name;
import com.sofka.ddd.domain.course.values.Price;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AddAttendeeUseCaseTest {

    private final String COURSE_ID = "111";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addAttendeeTest() {
        //Arrange
        var courseID = CourseID.of(COURSE_ID);
        var courseName = new CourseName("All about ColdBrew");
        var dateOfCourse = new DateOfCourse("20/08/2022");
        var price = new Price("10");
        var coffeeShopName = new CoffeeShopName("Starbucks");

        CourseCreated courseCreated = new CourseCreated(coffeeShopName, price, dateOfCourse, courseName);
        courseCreated.setAggregateRootId(COURSE_ID);

        var attendeeID = new AttendeeID();
        var attendeeName = new Name("Sofia Idarraga");
        var email = new Email("sofiaidarraga@email.com");
        var attendeeAge = new Age("24");

        AddAttendee command = new AddAttendee(courseID, attendeeID, attendeeName, email, attendeeAge);
        AddAttendeeUseCase useCase = new AddAttendeeUseCase();

        Mockito.when(repository.getEventsBy(COURSE_ID))
                .thenReturn(List.of(courseCreated));

        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(COURSE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding attendee"))
                .getDomainEvents();

        AttendeeAdded event = (AttendeeAdded) events.get(0);

        //Assert
        assertEquals("Sofia Idarraga", event.getName().value());
        assertEquals(COURSE_ID, event.aggregateRootId());
        assertEquals(attendeeID.value(), event.getAttendeeID().value());
        assertEquals("sofiaidarraga@email.com", event.getEmail().value());
        Mockito.verify(repository).getEventsBy(COURSE_ID);
        System.out.println("AttendeeId: " + attendeeID.value());
    }
}