package org.microservice.chi;

import org.microservice.model.Bank;
import org.microservice.model.Order;
import org.microservice.model.Repayment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Fileling
{
    List<Bank> getBanks() throws IOException;
    List<Order> getOrders() throws IOException;
    List<Repayment> getRepayments() throws IOException;
}
