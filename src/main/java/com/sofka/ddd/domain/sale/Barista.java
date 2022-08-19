package com.sofka.ddd.domain.sale;

import co.com.sofka.domain.generic.Entity;
import com.sofka.ddd.domain.sale.values.BaristaID;
import com.sofka.ddd.domain.sale.values.Hour;
import com.sofka.ddd.domain.sale.values.Name;


import java.util.Objects;

public class Barista extends Entity<BaristaID> {

    private Name name;

    private Hour entranceHour;

    private Hour outHour;

    public Barista(BaristaID entityId, Name name, Hour entranceHour, Hour outHour) {
        super(entityId);
        this.name = name;
        this.entranceHour = entranceHour;
        this.outHour = outHour;
    }

    public Name name() {
        return name;
    }

    public Hour entranceHour() {
        return entranceHour;
    }

    public Hour outHour() {
        return outHour;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public void changeEntranceHour(Hour entranceHour) {
        this.entranceHour = Objects.requireNonNull(entranceHour);
    }

    public void changeOutHour(Hour outHour) {
        this.outHour = Objects.requireNonNull(outHour);
    }


}
