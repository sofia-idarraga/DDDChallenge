package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.Email;
import com.sofka.ddd.domain.course.values.InstructorID;
import com.sofka.ddd.domain.course.values.Name;
import com.sofka.ddd.domain.course.values.Specialty;

public class InstructorAdded extends DomainEvent {

    private final InstructorID instructorID;
    private final Name name;
    private final Email email;
    private final Specialty specialty;

    public InstructorAdded(InstructorID instructorID, Name name, Email email, Specialty specialty) {
        super("ddd.domain.course.InstructorAdded");
        this.instructorID = instructorID;
        this.name = name;
        this.email = email;
        this.specialty = specialty;
    }

    public InstructorID getInstructorID() {
        return instructorID;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public Specialty getSpecialty() {
        return specialty;
    }
}
