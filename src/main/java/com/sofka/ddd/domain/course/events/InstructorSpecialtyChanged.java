package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.InstructorID;
import com.sofka.ddd.domain.course.values.Specialty;

public class InstructorSpecialtyChanged extends DomainEvent {

    private final InstructorID instructorID;
    private final Specialty specialty;

    public InstructorSpecialtyChanged(InstructorID instructorID, Specialty specialty) {
        super("ddd.domain.course.InstructorSpecialtyChanged ");
        this.instructorID = instructorID;
        this.specialty = specialty;
    }

    public InstructorID getInstructorID() {
        return instructorID;
    }

    public Specialty getSpecialty() {
        return specialty;
    }
}
