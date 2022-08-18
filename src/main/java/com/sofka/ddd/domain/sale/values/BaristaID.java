package com.sofka.ddd.domain.sale.values;

import co.com.sofka.domain.generic.Identity;

public class BaristaID extends Identity {
    public BaristaID(){

    }

    private BaristaID(String id){
        super(id);
    }

    public static BaristaID of(String id){
        return new BaristaID(id);
    }
}