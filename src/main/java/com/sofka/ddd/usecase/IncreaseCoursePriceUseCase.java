package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.ddd.domain.course.Course;
import com.sofka.ddd.domain.course.events.MaterialAdded;
import com.sofka.ddd.domain.course.values.CourseID;

public class IncreaseCoursePriceUseCase extends UseCase<TriggeredEvent<MaterialAdded>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<MaterialAdded> materialAddedTriggeredEvent) {
        var event = materialAddedTriggeredEvent.getDomainEvent();
        var course = Course.from(CourseID.of(event.aggregateRootId()), this.retrieveEvents());
        course.increaseCoursePrice(course.getMaterialById(event.getMaterialID()).get());
        emit().onResponse(new ResponseEvents(course.getUncommittedChanges()));
    }
}
