package org.microservice.model;

import java.util.Date;
import java.util.List;

public class History
{
    int orderId;
    String nameBank;
    double sum;
    Date date;
    List<Pay> pays;
    double debt;

    public History(int orderId, String nameBank, double sum, Date date, List<Pay> pays, double debt) {
        this.orderId = orderId;
        this.nameBank = nameBank;
        this.sum = sum;
        this.date = date;
        this.pays = pays;
        this.debt = debt;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Pay> getPays() {
        return pays;
    }

    public void setPays(List<Pay> pays) {
        this.pays = pays;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }
}
