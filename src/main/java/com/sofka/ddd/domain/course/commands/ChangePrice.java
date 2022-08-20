package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.Price;

public class ChangePrice extends Command {

    private final CourseID courseID;
    private final Price price;

    public ChangePrice(CourseID courseID, Price price) {
        this.courseID = courseID;
        this.price = price;
    }

    public CourseID getCourseID() {
        return courseID;
    }

    public Price getPrice() {
        return price;
    }
}
