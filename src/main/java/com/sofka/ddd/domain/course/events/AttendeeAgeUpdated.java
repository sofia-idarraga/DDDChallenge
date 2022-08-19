package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.Age;
import com.sofka.ddd.domain.course.values.AttendeeID;

public class AttendeeAgeUpdated extends DomainEvent {

    private final AttendeeID attendeeID;
    private final Age age;

    public AttendeeAgeUpdated(AttendeeID attendeeID, Age age) {
        super("ddd.domain.course.AttendeeAgeUpdated");
        this.attendeeID = attendeeID;
        this.age = age;
    }

    public AttendeeID getAttendeeID() {
        return attendeeID;
    }

    public Age getAge() {
        return age;
    }
}
