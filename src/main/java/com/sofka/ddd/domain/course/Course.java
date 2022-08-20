package com.sofka.ddd.domain.course;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.ddd.domain.course.Instructor;
import com.sofka.ddd.domain.course.events.CourseCreated;
import com.sofka.ddd.domain.course.values.AttendeeID;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.CourseName;
import com.sofka.ddd.domain.course.values.DateOfCourse;
import com.sofka.ddd.domain.course.values.MaterialID;
import com.sofka.ddd.domain.course.values.Price;
import com.sofka.ddd.domain.generics.CoffeeShopName;

import java.util.Optional;
import java.util.Set;

public class Course extends AggregateEvent<CourseID> {

    protected CoffeeShopName coffeeShopName;
    protected Price price;
    protected DateOfCourse dateOfCourse;
    protected CourseName courseName;
    protected Instructor instructor;
    protected Set<Attendee> attendees;
    protected Set<Material> materials;

    public Course(CourseID entityId, CoffeeShopName coffeeShopName, Price price, DateOfCourse dateOfCourse, CourseName courseName) {
        super(entityId);
        appendChange(new CourseCreated(coffeeShopName,price,dateOfCourse,courseName));
    }

    private Course(CourseID courseID){
        super(courseID);
        subscribe(new CourseChange(this));
    }

    //-------------- FINDERS

    public Optional<Attendee> getAttendeeById(AttendeeID attendeeID){
        return attendees.stream().filter((attendee -> attendee.identity().equals(attendeeID))).findFirst();
    }

    public Optional<Material> getMaterialById(MaterialID materialID){
        return materials.stream().filter((material -> material.identity().equals(materialID))).findFirst();
    }
    //------------

    //----- ACCESS


    public CoffeeShopName coffeeShopName() {
        return coffeeShopName;
    }

    public Price price() {
        return price;
    }

    public DateOfCourse dateOfCourse() {
        return dateOfCourse;
    }

    public CourseName courseName() {
        return courseName;
    }

    public Instructor instructor() {
        return instructor;
    }

    public Set<Attendee> attendees() {
        return attendees;
    }

    public Set<Material> materials() {
        return materials;
    }
}
