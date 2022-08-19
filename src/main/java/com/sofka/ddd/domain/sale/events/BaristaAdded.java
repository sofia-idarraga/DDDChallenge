package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.BaristaID;
import com.sofka.ddd.domain.sale.values.Hour;
import com.sofka.ddd.domain.sale.values.Name;

public class BaristaAdded extends DomainEvent {

    private final BaristaID baristaID;
    private final Name name;

    private final Hour entranceHour;

    private final Hour outHour;

    public BaristaAdded(BaristaID baristaID, Name name, Hour entranceHour, Hour outHour) {
        super("ddd.domain.sale.BaristaAdded");
        this.baristaID = baristaID;
        this.name = name;
        this.entranceHour = entranceHour;
        this.outHour = outHour;
    }

    public BaristaID getBaristaID() {
        return baristaID;
    }

    public Name getName() {
        return name;
    }

    public Hour getEntranceHour() {
        return entranceHour;
    }

    public Hour getOutHour() {
        return outHour;
    }
}
