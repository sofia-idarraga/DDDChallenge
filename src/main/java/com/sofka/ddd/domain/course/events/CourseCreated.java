package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.Instructor;
import com.sofka.ddd.domain.course.values.CourseName;
import com.sofka.ddd.domain.course.values.DateOfCourse;
import com.sofka.ddd.domain.course.values.Price;
import com.sofka.ddd.domain.generics.CoffeeShopName;

public class CourseCreated extends DomainEvent {

    private final CoffeeShopName coffeeShopName;
    private final Price price;
    private final DateOfCourse dateOfCourse;
    private final CourseName courseName;


    public CourseCreated(CoffeeShopName coffeeShopName, Price price, DateOfCourse dateOfCourse, CourseName courseName) {
        super("ddd.domain.course.CourseCreated");
        this.coffeeShopName = coffeeShopName;
        this.price = price;
        this.dateOfCourse = dateOfCourse;
        this.courseName = courseName;
    }

    public CoffeeShopName getCoffeeShopName() {
        return coffeeShopName;
    }

    public Price getPrice() {
        return price;
    }

    public DateOfCourse getDateOfCourse() {
        return dateOfCourse;
    }

    public CourseName getCourseName() {
        return courseName;
    }
}
