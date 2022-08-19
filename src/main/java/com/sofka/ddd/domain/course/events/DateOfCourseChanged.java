package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.DateOfCourse;

public class DateOfCourseChanged extends DomainEvent {

    private final DateOfCourse dateOfCourse;

    public DateOfCourseChanged( DateOfCourse dateOfCourse) {
        super("ddd.domain.course.DateOfCourseChanged");
        this.dateOfCourse = dateOfCourse;
    }

    public DateOfCourse getDateOfCourse() {
        return dateOfCourse;
    }
}
