package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.ddd.domain.course.events.AttendeeAdded;
import com.sofka.ddd.domain.course.events.CourseCreated;
import com.sofka.ddd.domain.course.events.MaterialAdded;
import com.sofka.ddd.domain.course.events.MaterialQuantityUpdated;
import com.sofka.ddd.domain.course.values.Age;
import com.sofka.ddd.domain.course.values.AttendeeID;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.CourseName;
import com.sofka.ddd.domain.course.values.DateOfCourse;
import com.sofka.ddd.domain.course.values.Description;
import com.sofka.ddd.domain.course.values.Email;
import com.sofka.ddd.domain.course.values.MaterialID;
import com.sofka.ddd.domain.course.values.Name;
import com.sofka.ddd.domain.course.values.Price;
import com.sofka.ddd.domain.course.values.Quantity;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class IncreaseMaterialQuantityUseCaseTest {

    private final String COURSE_ID = "111";
    @Mock
    private DomainEventRepository repository;

    @Test
    void increaseMaterialTest() {
        //Arrange
        var courseID = CourseID.of(COURSE_ID);
        var dateOfCourse = new DateOfCourse("20/08/2022");
        var price = new Price("10");
        var coffeeShopName = new CoffeeShopName("Starbucks");
        var courseName = new CourseName("All about ColdBrew");
        CourseCreated courseCreated = new CourseCreated(coffeeShopName, price, dateOfCourse, courseName);
        courseCreated.setAggregateRootId(COURSE_ID);

        var materialID = new MaterialID();
        var name = new Name("Coffee");
        var quantity = new Quantity("2");
        var description = new Description("Grinded coffee, 500g per Quantity");
        MaterialAdded materialAdded = new MaterialAdded(materialID, name, quantity, description);
        materialAdded.setAggregateRootId(COURSE_ID);

        var attendeeID = new AttendeeID();
        var attendeeName = new Name("Sofia Idarraga");
        var email = new Email("sofiaidarraga@email.com");
        var attendeeAge = new Age("24");
        AttendeeAdded attendeeAdded = new AttendeeAdded(attendeeID, attendeeName, email, attendeeAge);
        attendeeAdded.setAggregateRootId(COURSE_ID);

        IncreaseMaterialQuantityUseCase useCase = new IncreaseMaterialQuantityUseCase();

        Mockito.when(repository.getEventsBy(COURSE_ID))
                .thenReturn(List.of(courseCreated, materialAdded, attendeeAdded));

        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(COURSE_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(attendeeAdded))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong increasing material"))
                .getDomainEvents();

        MaterialQuantityUpdated event = (MaterialQuantityUpdated) events.get(0);

        assertEquals(COURSE_ID, event.aggregateRootId());
        assertEquals("3", event.getQuantity().value());
        assertEquals(materialID.value(), event.getMaterialID().value());
        Mockito.verify(repository).getEventsBy(COURSE_ID);
        System.out.println("MaterialID: " + materialID.value());
    }

}