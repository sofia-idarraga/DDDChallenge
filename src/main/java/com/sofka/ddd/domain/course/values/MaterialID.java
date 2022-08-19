package com.sofka.ddd.domain.course.values;

import co.com.sofka.domain.generic.Identity;

public class MaterialID extends Identity {

    public MaterialID(){

    }

    private MaterialID(String id){
        super(id);
    }

    public static MaterialID of(String id){
        return new MaterialID(id);
    }
}
