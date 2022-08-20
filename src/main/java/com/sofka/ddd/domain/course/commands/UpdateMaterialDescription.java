package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.Description;
import com.sofka.ddd.domain.course.values.MaterialID;

public class UpdateMaterialDescription extends Command {

    private final CourseID courseID;
    private final MaterialID materialID;
    private final Description description;

    public UpdateMaterialDescription(CourseID courseID, MaterialID materialID, Description description) {
        this.courseID = courseID;
        this.materialID = materialID;
        this.description = description;
    }

    public CourseID getCourseID() {
        return courseID;
    }

    public MaterialID getMaterialID() {
        return materialID;
    }

    public Description getDescription() {
        return description;
    }
}
