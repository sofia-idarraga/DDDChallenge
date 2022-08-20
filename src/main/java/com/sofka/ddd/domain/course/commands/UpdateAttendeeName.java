package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.AttendeeID;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.Name;

public class UpdateAttendeeName extends Command {

    private final CourseID courseID;
    private final AttendeeID attendeeID;
    private final Name name;

    public UpdateAttendeeName(CourseID courseID, AttendeeID attendeeID, Name name) {
        this.courseID = courseID;
        this.attendeeID = attendeeID;
        this.name = name;
    }

    public CourseID getCourseID() {
        return courseID;
    }

    public AttendeeID getAttendeeID() {
        return attendeeID;
    }

    public Name getName() {
        return name;
    }
}
