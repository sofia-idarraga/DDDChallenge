package com.sofka.ddd.domain.course.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.course.values.MaterialID;
import com.sofka.ddd.domain.course.values.Name;

public class MaterialNameUpdated extends DomainEvent {

    private final MaterialID materialID;
    private final Name name;

    public MaterialNameUpdated(MaterialID materialID, Name name) {
        super("ddd.domain.course.MaterialNameUpdated");
        this.materialID = materialID;
        this.name = name;
    }

    public MaterialID getMaterialID() {
        return materialID;
    }

    public Name getName() {
        return name;
    }
}
