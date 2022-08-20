package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.course.Course;
import com.sofka.ddd.domain.course.commands.CreateCourse;

public class CreateCourseUseCase extends UseCase<RequestCommand<CreateCourse>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateCourse> createCourseRequestCommand) {
        var command = createCourseRequestCommand.getCommand();
        var course = new Course(
                command.getCourseID(),
                command.getCoffeeShopName(),
                command.getPrice(),
                command.getDateOfCourse(),
                command.getCourseName()
        );

        emit().onResponse(new ResponseEvents(course.getUncommittedChanges()));
    }
}
