package com.sofka.ddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.sale.values.BaristaID;
import com.sofka.ddd.domain.sale.values.Hour;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.SaleID;

public class AddBarista extends Command {

    private final SaleID saleID;
    private final BaristaID baristaID;
    private final Name name;
    private final Hour entranceHour;
    private final Hour outHour;

    public AddBarista(SaleID saleID, BaristaID baristaID, Name name, Hour entranceHour, Hour outHour) {
        this.saleID = saleID;
        this.baristaID = baristaID;
        this.name = name;
        this.entranceHour = entranceHour;
        this.outHour = outHour;
    }

    public SaleID getSaleID() {
        return saleID;
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
