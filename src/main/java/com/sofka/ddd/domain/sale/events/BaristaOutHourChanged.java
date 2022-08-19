package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.BaristaID;
import com.sofka.ddd.domain.sale.values.Hour;

public class BaristaOutHourChanged extends DomainEvent {

    private final BaristaID baristaID;
    private final Hour outHour;

    public BaristaOutHourChanged(BaristaID baristaID, Hour outHour) {
        super("ddd.domain.sale.BaristaEntranceHourChanged");
        this.baristaID = baristaID;
        this.outHour = outHour;
    }

    public BaristaID getBaristaID() {
        return baristaID;
    }

    public Hour getOutHour() {
        return outHour;
    }
}
