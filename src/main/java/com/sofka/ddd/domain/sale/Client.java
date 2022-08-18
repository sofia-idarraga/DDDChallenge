package com.sofka.ddd.domain.sale;

import co.com.sofka.domain.generic.Entity;
import com.sofka.ddd.domain.sale.values.ClientID;
import com.sofka.ddd.domain.sale.values.ContactNumber;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.VipStatus;

import java.util.Objects;

public class Client extends Entity<ClientID> {

    private Name name;
    private ContactNumber contactNumber;
    private VipStatus vipStatus;

    public Client(ClientID entityId, Name name, ContactNumber contactNumber, VipStatus vipStatus) {
        super(entityId);
        this.name = name;
        this.contactNumber = contactNumber;
        this.vipStatus = vipStatus;
    }

    public Name name() {
        return name;
    }

    public ContactNumber contactNumber() {
        return contactNumber;
    }

    public VipStatus vipStatus() {
        return vipStatus;
    }

    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateContactNumber(ContactNumber contactNumber) {
        this.contactNumber = Objects.requireNonNull(contactNumber);
    }

    public void updateVipStatus(VipStatus vipStatus) {
        this.vipStatus = Objects.requireNonNull(vipStatus);
    }
}
