package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.CourseName;

public class ChangeCourseName extends Command {

    private final CourseID courseID;
    private final CourseName courseName;

    public ChangeCourseName(CourseID courseID, CourseName courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public CourseID getCourseID() {
        return courseID;
    }

    public CourseName getCourseName() {
        return courseName;
    }
}
