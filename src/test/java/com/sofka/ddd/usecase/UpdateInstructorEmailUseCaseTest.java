package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.ddd.domain.course.commands.UpdateInstructorEmail;
import com.sofka.ddd.domain.course.events.CourseCreated;
import com.sofka.ddd.domain.course.events.InstructorAdded;
import com.sofka.ddd.domain.course.events.InstructorEmailUpdated;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.CourseName;
import com.sofka.ddd.domain.course.values.DateOfCourse;
import com.sofka.ddd.domain.course.values.Email;
import com.sofka.ddd.domain.course.values.InstructorID;
import com.sofka.ddd.domain.course.values.Name;
import com.sofka.ddd.domain.course.values.Price;
import com.sofka.ddd.domain.course.values.Specialty;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
class UpdateInstructorEmailUseCaseTest {

    private final String COURSE_ID = "111";

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateInstructorEmailTest() {

        //Arrange
        var courseID = CourseID.of(COURSE_ID);
        var dateOfCourse = new DateOfCourse("20/08/2022");
        var price = new Price("10");
        var coffeeShopName = new CoffeeShopName("Starbucks");
        var courseName = new CourseName("All about ColdBrew");
        CourseCreated courseCreated = new CourseCreated(coffeeShopName, price, dateOfCourse, courseName);
        courseCreated.setAggregateRootId(COURSE_ID);

        var instructorID = new InstructorID();
        var instructorName = new Name("David Jaramillo");
        var email = new Email("djaramillo@email.com");
        var specialty = new Specialty("ColdBrew");
        InstructorAdded instructorAdded = new InstructorAdded(instructorID,instructorName,email,specialty);

        var newEmail = new Email("davidjaramillo@email.com");
        UpdateInstructorEmail command = new UpdateInstructorEmail(courseID,instructorID,newEmail);
        UpdateInstructorEmailUseCase useCase = new UpdateInstructorEmailUseCase();

        Mockito.when(repository.getEventsBy(COURSE_ID))
                .thenReturn(List.of(courseCreated, instructorAdded));

        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(COURSE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong updating instructor email"))
                .getDomainEvents();

        InstructorEmailUpdated event = (InstructorEmailUpdated) events.get(0);

        assertNotEquals("djaramillo@email.com", event.getEmail().value());
        assertEquals("davidjaramillo@email.com", event.getEmail().value());
        assertEquals(instructorID.value(), event.getInstructorID().value());
        assertEquals(COURSE_ID, event.aggregateRootId());
        Mockito.verify(repository).getEventsBy(COURSE_ID);
        System.out.println("InstructorID: " + instructorID.value());
    }

}