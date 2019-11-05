package com.onlineshop.dao;

import com.onlineshop.pojo.Bill;
import com.onlineshop.pojo.BillItem;

import java.util.List;

public interface IBillDao {
    //添加新订单
    public int addBill(Bill bill);
    //添加订单详情
    public void addItemds(List<BillItem> items);

    //查询订单(user)
    public List<Bill> getBillsByUser(int status,int uid);

    //查询订单详情(user)
    public List<BillItem> getItemds(int bid);

    //查询订单(admin)
    public List<Bill> getAllBills();

    //
    public String altBill(int bid,int status);
}
