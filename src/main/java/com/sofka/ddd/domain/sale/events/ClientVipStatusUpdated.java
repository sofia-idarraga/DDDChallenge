package com.sofka.ddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.sale.values.ClientID;
import com.sofka.ddd.domain.sale.values.VipStatus;

public class ClientVipStatusUpdated extends DomainEvent {

    private final ClientID clientID;
    private final VipStatus vipStatus;

    public ClientVipStatusUpdated(ClientID clientID, VipStatus vipStatus) {
        super("ddd.domain.sale.ClientVipStatusUpdated");
        this.clientID = clientID;
        this.vipStatus = vipStatus;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public VipStatus getVipStatus() {
        return vipStatus;
    }
}
