package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.InstructorID;
import com.sofka.ddd.domain.course.values.Specialty;

public class ChangeInstructorSpecialty extends Command {

    private final CourseID courseID;
    private final InstructorID instructorID;
    private final Specialty specialty;

    public ChangeInstructorSpecialty(CourseID courseID, InstructorID instructorID, Specialty specialty) {
        this.courseID = courseID;
        this.instructorID = instructorID;
        this.specialty = specialty;
    }

    public CourseID getCourseID() {
        return courseID;
    }

    public InstructorID getInstructorID() {
        return instructorID;
    }

    public Specialty getSpecialty() {
        return specialty;
    }
}
