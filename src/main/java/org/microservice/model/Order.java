package org.microservice.model;
import java.util.Date;

public class Order
{
    int id;
    int clientId;
    int bankId;
    double sum;
    Date date;
    int time;

    public Order(int id, int clientId, int bankId, double sum, Date date, int time)
    {
        this.id = id;
        this.clientId = clientId;
        this.bankId = bankId;
        this.sum = sum;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
