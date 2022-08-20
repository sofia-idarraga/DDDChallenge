package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.Age;
import com.sofka.ddd.domain.course.values.AttendeeID;
import com.sofka.ddd.domain.course.values.CourseID;

public class UpdateAttendeeAge extends Command {

    private final CourseID courseID;
    private final AttendeeID attendeeID;
    private final Age age;

    public CourseID getCourseID() {
        return courseID;
    }

    public AttendeeID getAttendeeID() {
        return attendeeID;
    }

    public Age getAge() {
        return age;
    }

    public UpdateAttendeeAge(CourseID courseID, AttendeeID attendeeID, Age age) {
        this.courseID = courseID;
        this.attendeeID = attendeeID;
        this.age = age;
    }
}
