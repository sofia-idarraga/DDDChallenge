package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.BaristaID;
import com.sofka.ddd.domain.sale.values.Hour;

public class BaristaEntranceHourChanged extends DomainEvent {

    public final BaristaID baristaID;
    public final Hour entranceHour;

    public BaristaEntranceHourChanged( BaristaID baristaID, Hour entranceHour) {
        super("ddd.domain.sale.BaristaEntranceHourChanged");
        this.baristaID = baristaID;
        this.entranceHour = entranceHour;
    }

    public BaristaID getBaristaID() {
        return baristaID;
    }

    public Hour getEntranceHour() {
        return entranceHour;
    }
}
