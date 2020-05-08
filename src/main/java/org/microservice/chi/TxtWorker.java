package org.microservice.chi;

import org.apache.commons.io.IOUtils;
import org.microservice.model.*;
import org.microservice.utils.Common;
import org.microservice.utils.PropertyManager;

import java.io.*;
import java.util.List;

public class TxtWorker implements FileProcessor
{
    @Override
    public List<Bank> getBanks() throws IOException
    {
        String path = PropertyManager.getPropertyAsString("path.file.banks", "./dbfiles/banks.txt");
        FileInputStream fileInputStream = new FileInputStream(path);
        String bankStr = IOUtils.toString(fileInputStream, "UTF-8");
        BankList bankList = Common.getPrettyGson().fromJson(bankStr, BankList.class);
        fileInputStream.close();
        return bankList.getBanks();
    }

    @Override
    public List<Order> getOrders() throws IOException
    {
        String path = PropertyManager.getPropertyAsString("path.file.orders", "./dbfiles/orders.txt");
        FileInputStream fileInputStream = new FileInputStream(path);
        String orderStr = IOUtils.toString(fileInputStream, "UTF-8");
        OrderList orderList = Common.getPrettyGson().fromJson(orderStr, OrderList.class);
        fileInputStream.close();
        return orderList.getOrders();
    }

    @Override
    public List<Repayment> getRepayments() throws IOException {
        String path = PropertyManager.getPropertyAsString("path.file.repayments", "./dbfiles/repayments.txt");
        FileInputStream fileInputStream = new FileInputStream(path);
        String replaymentStr = IOUtils.toString(fileInputStream, "UTF-8");
        RepaymentList repaymentList = Common.getPrettyGson().fromJson(replaymentStr, RepaymentList.class);
        fileInputStream.close();
        return repaymentList.getRepaymentList();
    }
}
