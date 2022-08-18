package com.sofka.ddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.sale.values.ClientID;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.SaleID;

public class UpdateClientName extends Command {

    private final SaleID saleID;
    private final ClientID clientID;
    public final Name name;

    public UpdateClientName(SaleID saleID, ClientID clientID, Name name) {
        this.saleID = saleID;
        this.clientID = clientID;
        this.name = name;
    }

    public SaleID getSaleID() {
        return saleID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }
}
