package org.microservice.credithistory;

import org.microservice.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryRequester implements CreditHistory
{
    @Override
    public List<History> getHistory(int clientId) throws IOException {
        List<History> histories = new ArrayList<History>();
        TxtWorker txtWorker = new TxtWorker();
        List<Bank> banks= txtWorker.getBanks();
        List<Order> orders = txtWorker.getOrders();
        List<Repayment> repayments = txtWorker.getRepayments();
        List<Order> myOrder = orders.stream().filter(b -> b.getClientId()==clientId).collect(Collectors.toList());

        for (Order order : myOrder ) {
            List<Repayment> myRepayment = repayments.stream().filter(r -> r.getIdOrder()==order.getId()).collect(Collectors.toList());
            List<Pay> payList = new ArrayList<Pay>();
            String nameBank = banks.stream().filter(bank -> bank.getId()==order.getBankId()).findFirst().orElse(null).getName();
            double sumPay = 0;
            for (Repayment rep: myRepayment ) {
                sumPay += rep.getSum();
                payList.add(new Pay (rep.getDate(), rep.getSum()));
            }
            History history = new History(order.getId(), nameBank, order.getSum(), order.getDate(), order.getTime(), payList, order.getSum()-sumPay);
            histories.add(history);
        }

        return histories;
    }
}
