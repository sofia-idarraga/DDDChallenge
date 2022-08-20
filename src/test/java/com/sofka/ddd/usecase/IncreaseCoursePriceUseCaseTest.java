package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.ddd.domain.course.events.CourseCreated;
import com.sofka.ddd.domain.course.events.MaterialAdded;
import com.sofka.ddd.domain.course.events.PriceChanged;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.CourseName;
import com.sofka.ddd.domain.course.values.DateOfCourse;
import com.sofka.ddd.domain.course.values.Description;
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
class IncreaseCoursePriceUseCaseTest {

    private final String COURSE_ID = "111";

    @Mock
    private DomainEventRepository repository;

    @Test
    void increasePriceTest(){
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

        IncreaseCoursePriceUseCase useCase = new IncreaseCoursePriceUseCase();
        Mockito.when(repository.getEventsBy(COURSE_ID))
                .thenReturn(List.of(courseCreated, materialAdded));

        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(COURSE_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(materialAdded))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong increasing price"))
                .getDomainEvents();

        PriceChanged event = (PriceChanged) events.get(0);

        //Assert
        assertEquals(COURSE_ID, event.aggregateRootId());
        assertEquals("12",event.getPrice().value());
        Mockito.verify(repository).getEventsBy(COURSE_ID);
        System.out.println("New Price: " + event.getPrice().value());
    }
}