package com.sofka.ddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.sale.values.ClientID;
import com.sofka.ddd.domain.sale.values.ContactNumber;
import com.sofka.ddd.domain.sale.values.SaleID;

public class UpdateClientContactNumber extends Command {

    private final SaleID saleID;
    private final ClientID clientID;
    public final ContactNumber contactNumber;

    public UpdateClientContactNumber(SaleID saleID, ClientID clientID, ContactNumber contactNumber) {
        this.saleID = saleID;
        this.clientID = clientID;
        this.contactNumber = contactNumber;
    }

    public SaleID getSaleID() {
        return saleID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }
}
