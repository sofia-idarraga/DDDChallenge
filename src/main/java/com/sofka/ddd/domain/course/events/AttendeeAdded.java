package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.Age;
import com.sofka.ddd.domain.course.values.AttendeeID;
import com.sofka.ddd.domain.course.values.Email;
import com.sofka.ddd.domain.course.values.Name;

public class AttendeeAdded extends DomainEvent {

    private final AttendeeID attendeeID;
    private final Name name;
    private final Email email;
    private final Age age;

    public AttendeeAdded(AttendeeID attendeeID, Name name, Email email, Age age) {
        super("ddd.domain.course.AttendeeAdded");
        this.attendeeID = attendeeID;
        this.name = name;
        this.email = email;
        this.age = age;
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
