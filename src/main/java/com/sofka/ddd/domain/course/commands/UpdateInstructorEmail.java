package com.sofka.ddd.domain.course.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.Email;
import com.sofka.ddd.domain.course.values.InstructorID;

public class UpdateInstructorEmail extends Command {

    private final CourseID courseID;
    private final InstructorID instructorID;
    private final Email email;

    public UpdateInstructorEmail(CourseID courseID, InstructorID instructorID, Email email) {
        this.courseID = courseID;
        this.instructorID = instructorID;
        this.email = email;
    }

    public CourseID getCourseID() {
        return courseID;
    }

    public InstructorID getInstructorID() {
        return instructorID;
    }

    public Email getEmail() {
        return email;
    }


}
