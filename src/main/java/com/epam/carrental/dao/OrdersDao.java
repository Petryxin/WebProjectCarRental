package com.epam.carrental.dao;

import com.epam.carrental.model.Orders;

import java.util.List;

public interface OrdersDao extends BaseDao<Orders> {
    Orders getById(Integer orderId);
    List<Orders> getOrdersByUserId(Integer id);

}
