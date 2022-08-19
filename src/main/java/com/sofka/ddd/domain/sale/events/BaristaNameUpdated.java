package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.BaristaID;
import com.sofka.ddd.domain.sale.values.Name;

public class BaristaNameUpdated extends DomainEvent {

    public final BaristaID baristaID;
    public final Name name;

    public BaristaNameUpdated(BaristaID baristaID, Name name) {
        super("ddd.domain.sale.BaristaNameUpdated");
        this.baristaID = baristaID;
        this.name = name;
    }

    public BaristaID getBaristaID() {
        return baristaID;
    }

    public Name getName() {
        return name;
    }
}
