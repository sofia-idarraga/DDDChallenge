package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.Email;
import com.sofka.ddd.domain.course.values.InstructorID;
import com.sofka.ddd.domain.course.values.Name;
import com.sofka.ddd.domain.course.values.Specialty;

public class AddInstructor extends Command {

    private CourseID courseID;
    private final InstructorID instructorID;
    private final Name name;
    private final Email email;
    private final Specialty specialty;

    public AddInstructor(CourseID courseID, InstructorID instructorID, Name name, Email email, Specialty specialty) {
        this.instructorID = instructorID;
        this.name = name;
        this.email = email;
        this.specialty = specialty;
    }

    public CourseID getCourseID() {
        return courseID;
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
