package org.microservice.model;

import java.util.ArrayList;
import java.util.List;

public class OrderList
{
    List<Order> orders;

    public OrderList() {
        this.orders = new ArrayList<Order>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
