package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.sale.Sale;
import com.sofka.ddd.domain.sale.commands.AddClient;

public class AddClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents>{

    @Override
    public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleID(),retrieveEvents(command.getSaleID().value()));
        sale.addClient(command.getClientID(),command.getName(),command.getContactNumber(),command.getVipStatus());

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
