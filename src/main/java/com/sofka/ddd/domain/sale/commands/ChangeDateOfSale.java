package com.sofka.ddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.sale.values.DateOfSale;
import com.sofka.ddd.domain.sale.values.SaleID;

public class ChangeDateOfSale extends Command {

    private final SaleID saleID;
    private final DateOfSale dateOfSale;

    public ChangeDateOfSale(SaleID saleID, DateOfSale dateOfSale) {
        this.saleID = saleID;
        this.dateOfSale = dateOfSale;
    }

    public SaleID getSaleID() {
        return saleID;
    }

    public DateOfSale getDateOfSale() {
        return dateOfSale;
    }
}
