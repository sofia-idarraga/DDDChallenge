package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.AttendeeID;
import com.sofka.ddd.domain.course.values.Email;

public class AttendeeEmailUpdated extends DomainEvent {

    private final AttendeeID attendeeID;
    private final Email email;

    public AttendeeEmailUpdated(String type, AttendeeID attendeeID, Email email) {
        super("ddd.domain.course.AttendeeEmailUpdated");
        this.attendeeID = attendeeID;
        this.email = email;
    }

    public AttendeeID getAttendeeID() {
        return attendeeID;
    }

    public Email getEmail() {
        return email;
    }
}
