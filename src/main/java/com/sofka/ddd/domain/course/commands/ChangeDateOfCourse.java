package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.DateOfCourse;

public class ChangeDateOfCourse extends Command {

    private final CourseID courseID;
    private final DateOfCourse dateOfCourse;

    public ChangeDateOfCourse(CourseID courseID, DateOfCourse dateOfCourse) {
        this.courseID = courseID;
        this.dateOfCourse = dateOfCourse;
    }

    public CourseID getCourseID() {
        return courseID;
    }

    public DateOfCourse getDateOfCourse() {
        return dateOfCourse;
    }
}
