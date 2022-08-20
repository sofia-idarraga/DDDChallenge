package com.sofka.ddd.domain.course;

import co.com.sofka.domain.generic.Entity;
import com.sofka.ddd.domain.course.values.Email;
import com.sofka.ddd.domain.course.values.InstructorID;
import com.sofka.ddd.domain.course.values.Name;
import com.sofka.ddd.domain.course.values.Specialty;

public class Instructor extends Entity<InstructorID> {

    private Name name;
    private Email email;
    private Specialty specialty;

    public Instructor(InstructorID entityId, Name name, Email email, Specialty specialty) {
        super(entityId);
        this.name = name;
        this.email = email;
        this.specialty = specialty;
    }

    public void changeSpecialty(Specialty specialty){
        this.specialty = specialty;
    }

    public void updateEmail(Email email){
        this.email = email;
    }

    public Name name() {
        return name;
    }

    public Email email() {
        return email;
    }

    public Specialty specialty() {
        return specialty;
    }
}
