package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.course.Course;
import com.sofka.ddd.domain.course.commands.AddInstructor;

public class AddInstructorUseCase extends UseCase<RequestCommand<AddInstructor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddInstructor> addInstructorRequestCommand) {
        var command = addInstructorRequestCommand.getCommand();
        var course = Course.from(command.getCourseID(),retrieveEvents(command.getCourseID().value()));
        course.addInstructor(command.getInstructorID(),command.getName(),command.getEmail(),command.getSpecialty());

        emit().onResponse(new ResponseEvents(course.getUncommittedChanges()));
    }
}
