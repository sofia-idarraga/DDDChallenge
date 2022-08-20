package com.sofka.ddd.domain.course;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.ddd.domain.course.events.AttendeeAdded;
import com.sofka.ddd.domain.course.events.AttendeeAgeUpdated;
import com.sofka.ddd.domain.course.events.AttendeeEmailUpdated;
import com.sofka.ddd.domain.course.events.AttendeeNameUpdated;
import com.sofka.ddd.domain.course.events.CourseCreated;
import com.sofka.ddd.domain.course.events.CourseNameChanged;
import com.sofka.ddd.domain.course.events.DateOfCourseChanged;
import com.sofka.ddd.domain.course.events.InstructorAdded;
import com.sofka.ddd.domain.course.events.InstructorEmailUpdated;
import com.sofka.ddd.domain.course.events.InstructorSpecialtyChanged;
import com.sofka.ddd.domain.course.events.MaterialAdded;
import com.sofka.ddd.domain.course.events.MaterialDescriptionUpdated;
import com.sofka.ddd.domain.course.events.MaterialNameUpdated;
import com.sofka.ddd.domain.course.events.MaterialQuantityUpdated;
import com.sofka.ddd.domain.course.events.PriceChanged;
import com.sofka.ddd.domain.sale.events.CoffeeShopNameUpdated;

import java.util.HashSet;

public class CourseChange extends EventChange {

    public CourseChange(Course course) {
        apply((CourseCreated event) -> {
            course.coffeeShopName = event.getCoffeeShopName();
            course.price = event.getPrice();
            course.dateOfCourse = event.getDateOfCourse();
            course.courseName = event.getCourseName();
            course.attendees = new HashSet<>();
            course.materials = new HashSet<>();
        });

        apply((CoffeeShopNameUpdated event) -> {
            course.coffeeShopName = event.getCoffeeShopName();
        });

        apply((DateOfCourseChanged event) -> {
            course.dateOfCourse = event.getDateOfCourse();
        });

        apply((InstructorAdded event) -> {
            course.instructor = new Instructor(
                    event.getInstructorID(),
                    event.getName(),
                    event.getEmail(),
                    event.getSpecialty()
            );
        });

        apply((AttendeeAdded event) -> {
            var numberOfAttendees = course.attendees.size();
            if (numberOfAttendees == 10) {
                throw new IllegalArgumentException("Maximum amount of attendees reached");

            }
            course.attendees.add(new Attendee(
                    event.getAttendeeID(),
                    event.getName(),
                    event.getEmail(),
                    event.getAge()
            ));
        });

        apply((MaterialAdded event) -> {
            course.materials.add(new Material(
                    event.getMaterialID(),
                    event.getName(),
                    event.getQuantity(),
                    event.getDescription()
            ));
        });

        apply((PriceChanged event) -> {
            course.price = event.getPrice();
        });

        apply((CourseNameChanged event) -> {
            course.courseName = event.courseName();
        });

        apply((InstructorSpecialtyChanged event) -> {
            var instructor = course.instructor();
            instructor.changeSpecialty(event.getSpecialty());
        });

        apply((InstructorEmailUpdated event) -> {
            var instructor = course.instructor();
            instructor.updateEmail(event.getEmail());
        });

        apply((AttendeeNameUpdated event) -> {
            var attendee = course.getAttendeeById(event.getAttendeeID())
                    .orElseThrow(() -> new IllegalArgumentException("Attendee ID doesn't exist"));
            attendee.updateName(event.getName());
        });

        apply((AttendeeEmailUpdated event) -> {
            var attendee = course.getAttendeeById(event.getAttendeeID())
                    .orElseThrow(() -> new IllegalArgumentException("Attendee ID doesn't exist"));
            attendee.updateEmail(event.getEmail());
        });

        apply((AttendeeAgeUpdated event) -> {
            var attendee = course.getAttendeeById(event.getAttendeeID())
                    .orElseThrow(() -> new IllegalArgumentException("Attendee ID doesn't exist"));
            attendee.updateAge(event.getAge());
        });

        apply((MaterialNameUpdated event) -> {
            var material = course.getMaterialById(event.getMaterialID())
                    .orElseThrow(() -> new IllegalArgumentException("Material ID doesn't exist"));

            material.updateName(event.getName());
        });

        apply((MaterialQuantityUpdated event)->{
            var material = course.getMaterialById(event.getMaterialID())
                    .orElseThrow(() -> new IllegalArgumentException("Material ID doesn't exist"));
            material.updateQuantity(event.getQuantity());
        });

        apply((MaterialDescriptionUpdated event)->{
            var material = course.getMaterialById(event.getMaterialID())
                    .orElseThrow(() -> new IllegalArgumentException("Material ID doesn't exist"));
            material.updateDescription(event.getDescription());
        });

    }
}
