package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.CourseName;
import com.sofka.ddd.domain.course.values.DateOfCourse;
import com.sofka.ddd.domain.course.values.Price;
import com.sofka.ddd.domain.generics.CoffeeShopName;

public class CreateCourse extends Command {

    private final CourseID courseID;
    private final CoffeeShopName coffeeShopName;
    private final Price price;
    private final DateOfCourse dateOfCourse;
    private final CourseName courseName;

    public CreateCourse(CourseID courseID, CoffeeShopName coffeeShopName, Price price, DateOfCourse dateOfCourse, CourseName courseName) {
        this.courseID = courseID;
        this.coffeeShopName = coffeeShopName;
        this.price = price;
        this.dateOfCourse = dateOfCourse;
        this.courseName = courseName;
    }

    public CourseID getCourseID() {
        return courseID;
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
