package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.ddd.domain.course.commands.AddMaterial;
import com.sofka.ddd.domain.course.events.CourseCreated;
import com.sofka.ddd.domain.course.events.MaterialAdded;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddMaterialUseCaseTest {

    private final String COURSE_ID = "111";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addMaterialTest(){

        //Arrange
        var courseID = CourseID.of(COURSE_ID);
        var courseName = new CourseName("All about ColdBrew");
        var dateOfCourse = new DateOfCourse("20/08/2022");
        var price = new Price("10");
        var coffeeShopName = new CoffeeShopName("Starbucks");

        CourseCreated courseCreated = new CourseCreated(coffeeShopName, price, dateOfCourse, courseName);
        courseCreated.setAggregateRootId(COURSE_ID);

        var materialID = new MaterialID();
        var name = new Name("Coffee");
        var quantity = new Quantity("2");
        var description = new Description("Grinded coffee, 500g per Quantity");

        AddMaterial command = new AddMaterial(courseID,materialID,name,quantity,description);
        AddMaterialUseCase useCase = new AddMaterialUseCase();

        Mockito.when(repository.getEventsBy(COURSE_ID))
                .thenReturn(List.of(courseCreated));

        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(COURSE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding material"))
                .getDomainEvents();

        MaterialAdded event = (MaterialAdded) events.get(0);

        //Assert
        assertEquals("Coffee",event.getName().value());
        assertEquals(COURSE_ID, event.aggregateRootId());
        assertEquals(materialID.value(), event.getMaterialID().value());
        assertEquals("Grinded coffee, 500g per Quantity", event.getDescription().value());
        Mockito.verify(repository).getEventsBy(COURSE_ID);
        System.out.println("MaterialId: "+materialID.value());
    }

}