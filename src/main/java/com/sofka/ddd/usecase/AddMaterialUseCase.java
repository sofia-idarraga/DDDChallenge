package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.course.Course;
import com.sofka.ddd.domain.course.commands.AddMaterial;

public class AddMaterialUseCase extends UseCase<RequestCommand<AddMaterial>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddMaterial> addMaterialRequestCommand) {
        var command = addMaterialRequestCommand.getCommand();
        var course = Course.from(command.getCourseID(),retrieveEvents(command.getCourseID().value()));
        course.addMaterial(command.getMaterialID(),command.getName(),command.getQuantity(),command.getDescription());

        emit().onResponse(new ResponseEvents(course.getUncommittedChanges()));

    }
}
