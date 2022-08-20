package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.AttendeeID;
import com.sofka.ddd.domain.course.values.Name;

public class AttendeeNameUpdated extends DomainEvent {

    private final AttendeeID attendeeID;
    private final Name name;

    public AttendeeNameUpdated(AttendeeID attendeeID, Name name) {
        super("ddd.domain.course.AttendeeNameUpdated");
        this.attendeeID = attendeeID;
        this.name = name;
    }

    public AttendeeID getAttendeeID() {
        return attendeeID;
    }

    public Name getName() {
        return name;
    }
}
