package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.sale.Sale;
import com.sofka.ddd.domain.sale.commands.AddBarista;

public class AddBaristaUseCase extends UseCase<RequestCommand<AddBarista>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddBarista> addBaristaRequestCommand) {
        var command = addBaristaRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleID(),retrieveEvents(command.getSaleID().value()));
        sale.addBarista(command.getBaristaID(),command.getName(),command.getEntranceHour(),command.getOutHour());

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

    }
}
