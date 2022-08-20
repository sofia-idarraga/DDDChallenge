package com.sofka.ddd.domain.course;

import co.com.sofka.domain.generic.Entity;
import com.sofka.ddd.domain.course.values.Description;
import com.sofka.ddd.domain.course.values.MaterialID;
import com.sofka.ddd.domain.course.values.Name;
import com.sofka.ddd.domain.course.values.Quantity;

public class Material extends Entity<MaterialID> {

    private Name name;
    private Quantity quantity;
    private Description description;

    public Material(MaterialID entityId, Name name, Quantity quantity, Description description) {
        super(entityId);
        this.name = name;
        this.quantity = quantity;
        this.description = description;
    }

    public void updateName(Name name) {
        this.name = name;
    }

    public void updateQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public void updateDescription(Description description) {
        this.description = description;
    }

    public Name name() {
        return name;
    }

    public Quantity quantity() {
        return quantity;
    }

    public Description description() {
        return description;
    }
}
