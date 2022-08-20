package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.ddd.domain.course.commands.CreateCourse;
import com.sofka.ddd.domain.course.events.CourseCreated;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.CourseName;
import com.sofka.ddd.domain.course.values.DateOfCourse;
import com.sofka.ddd.domain.course.values.Price;
import com.sofka.ddd.domain.generics.CoffeeShopName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static junit.framework.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
class CreateCourseUseCaseTest {

    @Test
    public void createCourseTest() {
        //Arrange
        var id = new CourseID();
        var courseName = new CourseName("All about ColdBrew");
        var dateOfCourse = new DateOfCourse("20/08/2022");
        var price = new Price("10");
        var name = new CoffeeShopName("Starbucks");

        CreateCourse command = new CreateCourse(id, name, price, dateOfCourse, courseName);
        CreateCourseUseCase useCase = new CreateCourseUseCase();

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong creating the course"))
                .getDomainEvents();

        CourseCreated event = (CourseCreated) events.get(0);

        //Assert
        assertEquals(command.getCoffeeShopName().value(), event.getCoffeeShopName().value());
        assertEquals("20/08/2022", event.getDateOfCourse().value());
        assertEquals("10", event.getPrice().value());

    }


}