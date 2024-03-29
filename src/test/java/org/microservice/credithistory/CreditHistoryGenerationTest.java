package org.microservice.credithistory;

import org.junit.Test;
import org.microservice.model.Bank;
import org.microservice.model.History;
import org.microservice.model.Order;
import org.microservice.model.Repayment;
import org.microservice.processings.FileProcessor;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class CreditHistoryGenerationTest
{
    @Test
    public void testBankGeneration()
    {
        try {
            CreditHistoryGeneration.BankGeneration();
            FileProcessor txt = new TxtWorker();
            List<Bank> bankList = txt.getBanks();
        } catch (IOException e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testOrderGeneration()
    {
        try {
            CreditHistoryGeneration.OrderGeneration();
            FileProcessor txt = new TxtWorker();
            List<Order> orderList = txt.getOrders();
        } catch (IOException | ParseException e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testReplaymentGeneration()
    {
        try {
            CreditHistoryGeneration.RepaymentGeneration();
            FileProcessor txt = new TxtWorker();
            List<Repayment> repaymentList = txt.getRepayments();
            int a=3;
        } catch (IOException | ParseException e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testSearchHistory() {
        HistoryRequester historyRequester = new HistoryRequester();
        try {
            List<History> histories = historyRequester.getHistory(81);
            int a = 3;
        } catch (IOException e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}