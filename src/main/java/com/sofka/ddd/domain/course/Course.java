package com.sofka.ddd.domain.course;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.events.AttendeeAdded;
import com.sofka.ddd.domain.course.events.AttendeeAgeUpdated;
import com.sofka.ddd.domain.course.events.AttendeeEmailUpdated;
import com.sofka.ddd.domain.course.events.AttendeeNameUpdated;
import com.sofka.ddd.domain.course.events.CoffeeShopNameUpdated;
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
import com.sofka.ddd.domain.course.values.Age;
import com.sofka.ddd.domain.course.values.AttendeeID;
import com.sofka.ddd.domain.course.values.CourseID;
import com.sofka.ddd.domain.course.values.CourseName;
import com.sofka.ddd.domain.course.values.DateOfCourse;
import com.sofka.ddd.domain.course.values.Description;
import com.sofka.ddd.domain.course.values.Email;
import com.sofka.ddd.domain.course.values.InstructorID;
import com.sofka.ddd.domain.course.values.MaterialID;
import com.sofka.ddd.domain.course.values.Name;
import com.sofka.ddd.domain.course.values.Price;
import com.sofka.ddd.domain.course.values.Quantity;
import com.sofka.ddd.domain.course.values.Specialty;
import com.sofka.ddd.domain.generics.CoffeeShopName;

import java.util.List;
import java.util.Objects;
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
        appendChange(new CourseCreated(coffeeShopName, price, dateOfCourse, courseName));
    }

    private Course(CourseID courseID) {
        super(courseID);
        subscribe(new CourseChange(this));
    }

    public static Course from(CourseID courseID, List<DomainEvent> events){
        var course = new Course(courseID);
        events.forEach(course::applyEvent);
        return course;
    }

    //-------------- FINDERS

    public Optional<Attendee> getAttendeeById(AttendeeID attendeeID) {
        return attendees.stream().filter((attendee -> attendee.identity().equals(attendeeID))).findFirst();
    }

    public Optional<Material> getMaterialById(MaterialID materialID) {
        return materials.stream().filter((material -> material.identity().equals(materialID))).findFirst();
    }
    //------------

    //----------- BEHAVIORS

    public void updateCoffeeShopName(CoffeeShopName coffeeShopName) {
        Objects.requireNonNull(coffeeShopName);
        appendChange(new CoffeeShopNameUpdated(coffeeShopName)).apply();
    }

    public void updateDateOfCourse(DateOfCourse dateOfCourse) {
        Objects.requireNonNull(dateOfCourse);
        appendChange(new DateOfCourseChanged(dateOfCourse)).apply();
    }

    public void changePrice(Price price) {
        Objects.requireNonNull(price);
        appendChange(new PriceChanged(price)).apply();
    }

    public void changeCourseName(CourseName name) {
        Objects.requireNonNull(name);
        appendChange(new CourseNameChanged(name)).apply();
    }

    public void addInstructor(InstructorID instructorID, Name name, Email email, Specialty specialty) {
        Objects.requireNonNull(instructorID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(specialty);
        appendChange(new InstructorAdded(instructorID, name, email, specialty)).apply();
    }

    public void changeInstructorSpecialty(InstructorID instructorID, Specialty specialty) {
        Objects.requireNonNull(instructorID);
        Objects.requireNonNull(specialty);
        appendChange(new InstructorSpecialtyChanged(instructorID, specialty)).apply();
    }

    public void updateInstructorEmail(InstructorID instructorID, Email email) {
        Objects.requireNonNull(instructorID);
        Objects.requireNonNull(email);
        appendChange(new InstructorEmailUpdated(instructorID, email)).apply();
    }

    public void addAttendee(AttendeeID attendeeID, Name name, Email email, Age age) {
        Objects.requireNonNull(attendeeID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(age);
        appendChange(new AttendeeAdded(attendeeID, name, email, age)).apply();
    }

    public void updateAttendeeName(AttendeeID attendeeID, Name name) {
        Objects.requireNonNull(attendeeID);
        Objects.requireNonNull(name);
        appendChange(new AttendeeNameUpdated(attendeeID, name)).apply();
    }

    public void updateAttendeeEmail(AttendeeID attendeeID, Email email) {
        Objects.requireNonNull(attendeeID);
        Objects.requireNonNull(email);
        appendChange(new AttendeeEmailUpdated(attendeeID, email)).apply();
    }

    public void updateAttendeeAge(AttendeeID attendeeID, Age age) {
        Objects.requireNonNull(attendeeID);
        Objects.requireNonNull(age);
        appendChange(new AttendeeAgeUpdated(attendeeID, age)).apply();
    }

    public void addMaterial(MaterialID materialID, Name name, Quantity quantity, Description description) {
        Objects.requireNonNull(materialID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(quantity);
        Objects.requireNonNull(description);
        appendChange(new MaterialAdded(materialID, name, quantity, description)).apply();
    }

    public void updateMaterialName(MaterialID materialID, Name name) {
        Objects.requireNonNull(materialID);
        Objects.requireNonNull(name);
        appendChange(new MaterialNameUpdated(materialID, name)).apply();
    }

    public void updateMaterialQuantity(MaterialID materialID, Quantity quantity) {
        Objects.requireNonNull(materialID);
        Objects.requireNonNull(quantity);
        appendChange(new MaterialQuantityUpdated(materialID, quantity)).apply();
    }

    public void updateMaterialDescription(MaterialID materialID, Description description) {
        Objects.requireNonNull(materialID);
        Objects.requireNonNull(description);
        appendChange(new MaterialDescriptionUpdated(materialID, description)).apply();
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
