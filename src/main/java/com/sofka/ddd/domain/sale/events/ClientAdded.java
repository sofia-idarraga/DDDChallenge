package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.ClientID;
import com.sofka.ddd.domain.sale.values.ContactNumber;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.VipStatus;

public class ClientAdded extends DomainEvent {

    private final ClientID clientID;
    private final Name name;
    private final ContactNumber contactNumber;
    private final VipStatus vipStatus;

    public ClientAdded(ClientID clientID, Name name, ContactNumber contactNumber, VipStatus vipStatus){
        super("ddd.domain.sale.ClientAdded");
        this.clientID = clientID;
        this.name = name;
        this.contactNumber = contactNumber;
        this.vipStatus = vipStatus;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }

    public VipStatus getVipStatus() {
        return vipStatus;
    }
}
