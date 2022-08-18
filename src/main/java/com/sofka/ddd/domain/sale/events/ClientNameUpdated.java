package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.ClientID;
import com.sofka.ddd.domain.sale.values.Name;

public class ClientNameUpdated extends DomainEvent {

    private final ClientID clientID;
    public final Name name;

    public ClientNameUpdated(ClientID clientID, Name name) {
        super("ddd.domain.sale.ClientNameUpdated");
        this.clientID= clientID;
        this.name = name;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }
}
