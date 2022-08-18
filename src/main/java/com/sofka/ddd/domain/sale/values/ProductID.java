package com.sofka.ddd.domain.sale.values;

import co.com.sofka.domain.generic.Identity;

public class ProductID extends Identity {

    public ProductID(){

    }

    private ProductID(String id){
        super(id);
    }

    public static ProductID of(String id) {
        return new ProductID(id);
    }

}