package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.ClientID;
import com.sofka.ddd.domain.sale.values.ContactNumber;

public class ClientContactNumberUpdated extends DomainEvent {

    private final ClientID clientID;
    private final ContactNumber contactNumber;

    public ClientContactNumberUpdated(ClientID clientID, ContactNumber contactNumber) {
        super("ddd.domain.sale.ClientContactNumberUpdated");
        this.clientID= clientID;
        this.contactNumber = contactNumber;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }
}
