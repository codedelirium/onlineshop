package com.onlineshop.dao.impl;

import com.onlineshop.dao.IBillDao;
import com.onlineshop.pojo.Bill;
import com.onlineshop.pojo.BillItem;
import com.onlineshop.service.IGoodService;
import com.onlineshop.service.impl.GoodServiceImpl;
import mysql.db.ConnectionHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements IBillDao {
    private static PreparedStatement pre = null;
    private static ResultSet res = null;

    @Override
    public int addBill(Bill bill) {
        String sql = "insert into tb_bill(user_id, status, time, total) values(?,?,?,?) ";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setInt(1,bill.getUser_id());
            pre.setInt(2,bill.getStatus());
            pre.setDate(3,bill.getTime());
            pre.setInt(4,bill.getTotal());
            if(pre.executeUpdate()==1) {
                res = pre.getGeneratedKeys();
                if(res.next()){
                    bill.setId(res.getInt(1));
                    return bill.getId();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionHandler.close(pre);
        }
        return -1;
    }

    @Override
    public void addItemds(List<BillItem> items) {
        String sql = "insert into tb_bill_detail(amount, price, bill_id, good_id) VALUES (?,?,?,?)";
        try {
            for (BillItem item :items) {
                pre = ConnectionHandler.getConnection().prepareStatement(sql);
                pre.setInt(1,item.getAmount());
                pre.setInt(2,item.getPrice());
                pre.setInt(3,item.getBid());
                pre.setInt(4,item.getGood().getId());
                pre.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Bill> getBillsByUser(int status, int uid) {
        List<Bill> bills = new ArrayList<>();
        String sql = "select * from tb_bill where user_id = ? and status = ?";
        try{
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setInt(1,uid);
            pre.setInt(2,status);
            res = pre.executeQuery();
            while(res.next()){
                Bill b = new Bill();
                b.setTime(res.getDate("time"));
                b.setId(res.getInt("id"));
                b.setUser_id(res.getInt("user_id"));
                b.setStatus(res.getInt("status"));
                b.setTotal(res.getInt("total"));
                bills.add(b);
            }
            return bills;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<BillItem> getItemds(int bid) {
        List<BillItem> items = new ArrayList<>();
        IGoodService gs = new GoodServiceImpl();
        String sql ="select * from tb_bill_detail where bill_id = ?";
        try{
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setInt(1,bid);
            res = pre.executeQuery();
            while(res.next()){
                BillItem item = new BillItem();
                item.setPrice(res.getInt("price"));
                item.setBid(res.getInt("bill_id"));
                item.setAmount(res.getInt("amount"));
                item.setGood(gs.getGoodById(res.getInt("good_id")));
                items.add(item);
            }
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bill> getAllBills() {
        List<Bill> billList = new ArrayList<>();
        String sql = "select * from tb_bill where status != 0";
        try{
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                Bill bill = new Bill();
                bill.setId(res.getInt("id"));
                bill.setUser_id(res.getInt("user_id"));
                bill.setTime(res.getDate("time"));
                bill.setTotal(res.getInt("total"));
                bill.setStatus(res.getInt("status"));
                billList.add(bill);
            }
            return billList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String altBill(int bid, int status) {

        String sql = "update tb_bill set status = ? where id = ?";
        try{
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setInt(1,status);
            pre.setInt(2,bid);
            if(pre.executeUpdate()==1){
                if(status == 1)
                    return "IT WORKED！";
                else if(status == 2)
                    return "IT WORKED！";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "WRONG！";
    }

}
