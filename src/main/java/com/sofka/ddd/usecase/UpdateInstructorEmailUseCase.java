package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.course.Course;
import com.sofka.ddd.domain.course.commands.UpdateInstructorEmail;

public class UpdateInstructorEmailUseCase extends UseCase<RequestCommand<UpdateInstructorEmail>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateInstructorEmail> updateInstructorEmailRequestCommand) {
        var command= updateInstructorEmailRequestCommand.getCommand();
        var course = Course.from(command.getCourseID(), retrieveEvents(command.getCourseID().value()));
        course.updateInstructorEmail(command.getInstructorID(),command.getEmail());

        emit().onResponse(new ResponseEvents(course.getUncommittedChanges()));
    }
}
