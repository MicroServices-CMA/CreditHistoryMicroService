package org.microservice.processings;

import org.microservice.model.Bank;
import org.microservice.model.Order;
import org.microservice.model.Repayment;

import java.io.IOException;
import java.util.List;

public interface FileProcessor
{
    List<Bank> getBanks() throws IOException;
    List<Order> getOrders() throws IOException;
    List<Repayment> getRepayments() throws IOException;
}
