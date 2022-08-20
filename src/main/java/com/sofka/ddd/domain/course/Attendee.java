package com.sofka.ddd.domain.course;

import co.com.sofka.domain.generic.Entity;
import com.sofka.ddd.domain.course.values.Age;
import com.sofka.ddd.domain.course.values.AttendeeID;
import com.sofka.ddd.domain.course.values.Email;
import com.sofka.ddd.domain.course.values.Name;

public class Attendee extends Entity<AttendeeID> {

    private Name name;
    private Email email;
    private Age age;

    public Attendee(AttendeeID entityId, Name name, Email email, Age age) {
        super(entityId);
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public void updateName(Name name){
        this.name = name;
    }

    public void updateEmail(Email email){
        this.email = email;
    }

    public void updateAge(Age age){
        this.age = age;
    }

    public Name name() {
        return name;
    }

    public Email email() {
        return email;
    }

    public Age age() {
        return age;
    }
}
