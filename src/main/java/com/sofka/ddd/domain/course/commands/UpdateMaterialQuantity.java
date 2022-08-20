package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.MaterialID;
import com.sofka.ddd.domain.course.values.Quantity;

public class UpdateMaterialQuantity extends Command {

    private final CourseID courseID;
    private final MaterialID materialID;
    private final Quantity quantity;

    public UpdateMaterialQuantity(CourseID courseID, MaterialID materialID, Quantity quantity) {
        this.courseID = courseID;
        this.materialID = materialID;
        this.quantity = quantity;
    }

    public CourseID getCourseID() {
        return courseID;
    }

    public MaterialID getMaterialID() {
        return materialID;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
