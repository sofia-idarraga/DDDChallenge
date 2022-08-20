package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.Description;
import com.sofka.ddd.domain.course.values.MaterialID;
import com.sofka.ddd.domain.course.values.Name;
import com.sofka.ddd.domain.course.values.Quantity;

public class AddMaterial extends Command {
    private final CourseID courseID;
    private final MaterialID materialID;
    private final Name name;
    private final Quantity quantity;
    private final Description description;

    public AddMaterial(CourseID courseID, MaterialID materialID, Name name, Quantity quantity, Description description) {
        this.courseID = courseID;
        this.materialID = materialID;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
    }

    public MaterialID getMaterialID() {
        return materialID;
    }

    public Name getName() {
        return name;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Description getDescription() {
        return description;
    }

    public CourseID getCourseID() {
        return courseID;
    }
}
