package com.sofka.ddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.sale.Sale;
import com.sofka.ddd.domain.sale.commands.ChangeDateOfSale;

public class ChangeDateOfSaleUseCase extends UseCase<RequestCommand<ChangeDateOfSale>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeDateOfSale> changeDateOfSaleRequestCommand) {
        var command = changeDateOfSaleRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleID(), retrieveEvents(command.getSaleID().value()));
        sale.changeDateOfSale(command.getDateOfSale());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

    }
}
