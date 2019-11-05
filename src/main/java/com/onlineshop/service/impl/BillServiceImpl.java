package com.onlineshop.service.impl;

import com.onlineshop.dao.IBillDao;
import com.onlineshop.dao.impl.BillDaoImpl;
import com.onlineshop.pojo.Bill;
import com.onlineshop.pojo.BillItem;
import com.onlineshop.service.IBillService;
import com.onlineshop.service.IUserService;
import mysql.db.ConnectionHandler;

import java.util.List;

public class BillServiceImpl implements IBillService {
    private static IBillDao billDao = new BillDaoImpl();

    @Override
    public List<Bill> getAllBills() {
        return billDao.getAllBills();
    }

    @Override
    public List<Bill> getBillsByStatus(int uid, int status) {
        return billDao.getBillsByUser(status,uid);
    }

    @Override
    public List<BillItem> getItemsByBid(int bid) {
        return billDao.getItemds(bid);
    }

    @Override
    public int addBill(Bill bill) {
        return billDao.addBill(bill);
    }

    @Override
    public void addItems(List<BillItem> items) {
        billDao.addItemds(items);
    }

    @Override
    public String payBill(int bid) {
        return billDao.altBill(bid,1);
    }

    @Override
    public String shippedBill(int bid) {
        return billDao.altBill(bid,2);
    }
}
