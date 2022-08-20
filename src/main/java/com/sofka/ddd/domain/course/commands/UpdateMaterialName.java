package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.MaterialID;
import com.sofka.ddd.domain.course.values.Name;

public class UpdateMaterialName extends Command {

    private final CourseID courseID;
    private final MaterialID materialID;
    private final Name name;

    public UpdateMaterialName(CourseID courseID, MaterialID materialID, Name name) {
        this.courseID = courseID;
        this.materialID = materialID;
        this.name = name;
    }

    public CourseID getCourseID() {
        return courseID;
    }

    public MaterialID getMaterialID() {
        return materialID;
    }

    public Name getName() {
        return name;
    }
}
