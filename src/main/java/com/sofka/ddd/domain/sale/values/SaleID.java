package com.sofka.ddd.domain.sale.values;

import co.com.sofka.domain.generic.Identity;

public class SaleID extends Identity {
    public SaleID(){

    }

    private SaleID(String id){
        super(id);
    }
    public static SaleID of(String id) {
        return new SaleID(id);
    }
}
