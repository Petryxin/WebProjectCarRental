package com.epam.carrental.dao;

import com.epam.carrental.model.RepairBill;

import java.util.List;

public interface RepairBillDao extends BaseDao<RepairBill> {
    List<RepairBill> getBillsByUserId(Integer userId);
}
