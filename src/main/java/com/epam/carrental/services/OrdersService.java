package com.epam.carrental.services;

import com.epam.carrental.model.Orders;

import java.util.List;

public class OrdersService {
    public int getAmount(int numberOfDays, int paymentPerDay) {
        return numberOfDays *  paymentPerDay;
    }

    public Orders getOrderById(Integer orderId, List<Orders> orderList) {
        return orderList.stream().filter(u -> u.getId().equals(orderId)).findAny().orElse(null);
    }
}
