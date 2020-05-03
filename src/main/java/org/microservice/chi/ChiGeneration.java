package org.microservice.chi;

import org.microservice.model.*;
import org.microservice.utils.Common;
import org.microservice.utils.PropertyManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChiGeneration
{
    static void BankGeneration() throws IOException {
        BankList bankList = new BankList();
        for (int i = 0; i < 20; ++i) {
            Bank bank = new Bank(1 + i, "Bank"+(1 + i));
            bankList.getBanks().add(bank);
        }
        String strJson = Common.getPrettyGson().toJson(bankList);
        String path = PropertyManager.getPropertyAsString("path.file.banks", "./dbfiles/banks.txt");
        FileOutputStream fileInputStream = new FileOutputStream(path, false);
        fileInputStream.write(strJson.getBytes());
        fileInputStream.flush();
        fileInputStream.close();
    }

    static void OrderGeneration() throws IOException, ParseException {
        OrderList orderList = new OrderList();

        for (int i = 0; i < 20; ++i) {
            Date date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( (1+i)+"."+(i%12+1)+".2020" );
            Order order = new Order(i + 1, (int)(Math.random()*100),  1+ (int)(Math.random()*20), 10000+Math.random()*10000000, date, i+4);
            orderList.getOrders().add(order);
        }
        String strJson = Common.getPrettyGson().toJson(orderList);
        String path = PropertyManager.getPropertyAsString("path.file.orders", "./dbfiles/orders.txt");
        FileOutputStream fileInputStream = new FileOutputStream(path, false);
        fileInputStream.write(strJson.getBytes());
        fileInputStream.flush();
        fileInputStream.close();
    }

    static void RepaymentGeneration() throws ParseException, IOException {
        RepaymentList repaymentList = new RepaymentList();

        for (int i = 0; i < 80; ++i) {
            int orderId = 1 + (int)(Math.random() * 20);
            Date date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( ((i+1)%5+orderId)+"."+((orderId-1)%12+1)+".2020" );
            Repayment repayment = new Repayment(i, orderId,  date, Math.random()*1000);
            repaymentList.getRepaymentList().add(repayment);
        }
        String strJson = Common.getPrettyGson().toJson(repaymentList);
        String path = PropertyManager.getPropertyAsString("path.file.repayments", "./dbfiles/repayments.txt");
        FileOutputStream fileInputStream = new FileOutputStream(path, false);
        fileInputStream.write(strJson.getBytes());
        fileInputStream.flush();
        fileInputStream.close();
    }
}
