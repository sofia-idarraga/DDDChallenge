package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.generics.CoffeeShopName;

public class UpdateCoffeeShopName extends Command {

    private final CoffeeShopName coffeeShopName;
    private final CourseID courseID;

    public UpdateCoffeeShopName(CourseID courseID, CoffeeShopName coffeeShopName) {
        this.courseID = courseID;
        this.coffeeShopName = coffeeShopName;
    }

    public CoffeeShopName getCoffeeShopName() {
        return coffeeShopName;
    }

    public CourseID getCourseID() {
        return courseID;
    }
}
