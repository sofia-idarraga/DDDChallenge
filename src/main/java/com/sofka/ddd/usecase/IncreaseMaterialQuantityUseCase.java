package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.ddd.domain.course.Course;
import com.sofka.ddd.domain.course.Material;
import com.sofka.ddd.domain.course.events.AttendeeAdded;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.Quantity;

import static java.lang.Integer.parseInt;

public class IncreaseMaterialQuantityUseCase extends UseCase<TriggeredEvent<AttendeeAdded>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<AttendeeAdded> attendeeAddedTriggeredEvent) {
        var event = attendeeAddedTriggeredEvent.getDomainEvent();
        var course = Course.from(CourseID.of(event.aggregateRootId()),this.retrieveEvents());
        course.increaseMaterialQuantity();
        emit().onResponse(new ResponseEvents(course.getUncommittedChanges()));
    }
}
