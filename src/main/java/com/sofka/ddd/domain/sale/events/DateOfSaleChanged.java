package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.DateOfSale;

public class DateOfSaleChanged extends DomainEvent {

    private final DateOfSale dateOfSale;

    public DateOfSaleChanged(DateOfSale dateOfSale){
        super("ddd.domain.sale.DateOfSaleChanged");
        this.dateOfSale = dateOfSale;
    }

    public DateOfSale getDateOfSale() {
        return dateOfSale;
    }
}
