package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.Email;
import com.sofka.ddd.domain.course.values.InstructorID;

public class InstructorEmailUpdated extends DomainEvent {

    private final InstructorID instructorID;
    private final Email email;

    public InstructorEmailUpdated(InstructorID instructorID, Email email) {
        super("ddd.domain.course.InstructorEmailUpdated");
        this.instructorID = instructorID;
        this.email = email;
    }

    public InstructorID getInstructorID() {
        return instructorID;
    }

    public Email getEmail() {
        return email;
    }
}
