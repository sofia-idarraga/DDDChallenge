package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.Description;
import com.sofka.ddd.domain.course.values.MaterialID;
import com.sofka.ddd.domain.course.values.Name;
import com.sofka.ddd.domain.course.values.Quantity;

public class MaterialAdded extends DomainEvent {

    private final MaterialID materialID;
    private final Name name;
    private final Quantity quantity;
    private final Description description;

    public MaterialAdded(MaterialID materialID, Name name, Quantity quantity, Description description) {
        super("ddd.domain.course.MaterialAdded");
        this.materialID = materialID;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
    }

    public MaterialID getMaterialID() {
        return materialID;
    }

    public Name getName() {
        return name;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Description getDescription() {
        return description;
    }
}
