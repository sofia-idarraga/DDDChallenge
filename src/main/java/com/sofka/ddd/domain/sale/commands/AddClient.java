package com.sofka.ddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.sale.values.ClientID;
import com.sofka.ddd.domain.sale.values.ContactNumber;
import com.sofka.ddd.domain.sale.values.Name;
import com.sofka.ddd.domain.sale.values.SaleID;
import com.sofka.ddd.domain.sale.values.VipStatus;

public class AddClient extends Command {

    private final SaleID saleID;
    private final ClientID clientID;
    private final Name name;
    private final ContactNumber contactNumber;
    private final VipStatus vipStatus;

    public AddClient(SaleID saleID, ClientID clientID, Name name, ContactNumber contactNumber, VipStatus vipStatus) {
        this.saleID = saleID;
        this.clientID = clientID;
        this.name = name;
        this.contactNumber = contactNumber;
        this.vipStatus = vipStatus;
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

    public ContactNumber getContactNumber() {
        return contactNumber;
    }

    public VipStatus getVipStatus() {
        return vipStatus;
    }
}
