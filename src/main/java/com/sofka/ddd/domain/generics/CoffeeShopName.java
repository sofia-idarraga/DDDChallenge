package com.sofka.ddd.domain.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CoffeeShopName implements ValueObject<String> {

    private final String value;

    public CoffeeShopName(String value) {
        if(value.isBlank()){
            throw new IllegalArgumentException("The VO Coffee Shop name cant be blank");
        }
        if(value.length() < 3){
            throw new IllegalArgumentException("The VO Coffee Shop name can't have less than 5 letters");
        }
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeShopName name = (CoffeeShopName) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
