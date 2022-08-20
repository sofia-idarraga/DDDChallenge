package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.course.Course;
import com.sofka.ddd.domain.course.commands.AddAttendee;

public class AddAttendeeUseCase extends UseCase<RequestCommand<AddAttendee>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddAttendee> addAttendeeRequestCommand) {
        var command = addAttendeeRequestCommand.getCommand();
        var course = Course.from(command.getCourseID(),retrieveEvents(command.getCourseID().value()));
        course.addAttendee(command.getAttendeeID(),command.getName(),command.getEmail(),command.getAge());

        emit().onResponse(new ResponseEvents(course.getUncommittedChanges()));
    }
}
