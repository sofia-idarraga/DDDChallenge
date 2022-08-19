package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.Description;
import com.sofka.ddd.domain.course.values.MaterialID;

public class MaterialDescriptionUpdated extends DomainEvent {

    private final MaterialID materialID;
    private final Description description;

    public MaterialDescriptionUpdated(MaterialID materialID, Description description) {
        super("ddd.domain.course.MaterialDescriptionUpdated");
        this.materialID = materialID;
        this.description = description;
    }

    public MaterialID getMaterialID() {
        return materialID;
    }

    public Description getDescription() {
        return description;
    }
}
