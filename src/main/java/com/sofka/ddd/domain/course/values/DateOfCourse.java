package com.sofka.ddd.domain.course.values;

import co.com.sofka.domain.generic.ValueObject;
import org.apache.commons.validator.GenericValidator;

import java.util.Objects;

public class DateOfCourse implements ValueObject<String> {

    private final String value;

    public DateOfCourse(String value){
        this.value = value;
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The VO Date of Course can't be blank");
        }
        if(!GenericValidator.isDate(this.value, "dd/MM/yyyy", true)){
            throw new IllegalArgumentException("The VO Date of Sale don't match the pattern: dd/MM/yyyy");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateOfCourse dateOfCourse = (DateOfCourse) o;
        return Objects.equals(value, dateOfCourse.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
