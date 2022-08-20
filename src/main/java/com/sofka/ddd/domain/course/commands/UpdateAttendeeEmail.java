package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.AttendeeID;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.Email;

public class UpdateAttendeeEmail extends Command {

    private CourseID courseID;
    private final AttendeeID attendeeID;
    private final Email email;

    public UpdateAttendeeEmail(CourseID courseID,AttendeeID attendeeID, Email email) {
        this.attendeeID = attendeeID;
        this.email = email;
    }

    public CourseID getCourseID() {
        return courseID;
    }

    public AttendeeID getAttendeeID() {
        return attendeeID;
    }

    public Email getEmail() {
        return email;
    }
}
