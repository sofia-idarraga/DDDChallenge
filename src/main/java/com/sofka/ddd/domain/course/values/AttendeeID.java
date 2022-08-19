package com.sofka.ddd.domain.course.values;

import co.com.sofka.domain.generic.Identity;

public class AttendeeID extends Identity {

    public AttendeeID() {

    }

    private AttendeeID(String id) {
        super(id);
    }

    public static AttendeeID of(String id) {
        return new AttendeeID(id);
    }

}
