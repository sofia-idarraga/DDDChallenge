package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.Age;
import com.sofka.ddd.domain.course.values.AttendeeID;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.Email;
import com.sofka.ddd.domain.course.values.Name;

public class AddAttendee extends Command {

    private final CourseID courseID;
    private final AttendeeID attendeeID;
    private final Name name;
    private final Email email;
    private final Age age;

    public AddAttendee(CourseID courseID, AttendeeID attendeeID, Name name, Email email, Age age) {
        this.courseID = courseID;
        this.attendeeID = attendeeID;
        this.name = name;
        this.email = email;
        this.age = age;
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

    public Email getEmail() {
        return email;
    }

    public Age getAge() {
        return age;
    }


}
