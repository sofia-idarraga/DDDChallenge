package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.CourseName;

public class CourseNameChanged extends DomainEvent {

    private final CourseName courseName;

    public CourseNameChanged(CourseName courseName) {
        super("ddd.domain.course.CourseNameChanged");
        this.courseName = courseName;
    }
}
