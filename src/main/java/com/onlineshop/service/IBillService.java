package com.onlineshop.service;

import com.onlineshop.pojo.Bill;
import com.onlineshop.pojo.BillItem;

import java.util.List;

public interface IBillService {

    //管理员查找订单
    public List<Bill> getAllBills();
    //用户查找订单
    public List<Bill> getBillsByStatus(int uid,int status);
    //根据订单id查找items
    public List<BillItem> getItemsByBid(int bid);

    //添加订单
    public int addBill(Bill bill);
    //添加订单详情
    public void addItems(List<BillItem> items);

    //改订单状态(user)
    public String payBill(int bid );
    //admin
    public String shippedBill(int bid);


}
