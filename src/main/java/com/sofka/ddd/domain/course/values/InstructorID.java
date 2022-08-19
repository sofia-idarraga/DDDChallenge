package com.sofka.ddd.domain.course.values;

import co.com.sofka.domain.generic.Identity;

public class InstructorID extends Identity {

    public InstructorID() {

    }

    private InstructorID(String id) {
        super(id);
    }

    public static InstructorID of(String id) {
        return new InstructorID(id);
    }
}
