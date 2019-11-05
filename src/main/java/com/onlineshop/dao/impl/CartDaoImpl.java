package com.onlineshop.dao.impl;


import com.onlineshop.dao.ICartDao;
import com.onlineshop.pojo.Cart;
import com.onlineshop.pojo.Good;
import com.onlineshop.service.IGoodService;
import com.onlineshop.service.impl.GoodServiceImpl;
import mysql.db.ConnectionHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements ICartDao {
    private static PreparedStatement pre = null;
    private static ResultSet res = null;
    @Override
    public boolean addCart(Cart cart) {
        String sql = "insert into tb_cart(amount, price,total,good_id, user_id) value(?,?,?,?,?)";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setInt(1,cart.getAmount());
            pre.setInt(2,cart.getPrice());
            pre.setInt(3,cart.getTotal());
            pre.setInt(4,cart.getGood().getId());
            pre.setInt(5,cart.getUser_id());
            if(pre.executeUpdate()==1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionHandler.close(pre);
        }
        return false;
    }

    @Override
    public boolean delCart(int cid) {
        String sql = "delete from tb_cart where id = ?";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setInt(1,cid);
            if(pre.executeUpdate()==1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionHandler.close(pre);
        }
        return false;
    }

    @Override
    public boolean altCart(int cid, int new_amount,int new_total) {

        String sql = "update tb_cart set amount = ? ,total = ?where id = ?";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setInt(1,new_amount);
            pre.setInt(2,new_total);
            pre.setInt(3,cid);
            if(pre.executeUpdate()==1){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionHandler.close(pre);
        }
        return false;
    }

    @Override
    public List<Cart> getCartsById(int uid) {
        List<Cart> carts = new ArrayList<>();
        IGoodService gs = new GoodServiceImpl();
        String sql = "select * from tb_cart where user_id = ? ";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setInt(1,uid);
            res = pre.executeQuery();
            while (res.next()){
                Cart cart = new Cart();
                cart.setGood(gs.getGoodById(res.getInt("good_id")));
                cart.setId(res.getInt("id"));
                cart.setUser_id(res.getInt("user_id"));
                cart.setAmount(res.getInt("amount"));
                cart.setPrice(res.getInt("price"));
                cart.setTotal(res.getInt("total"));
                carts.add(cart);
            }
            return carts;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionHandler.close(res,pre);
        }
        return null;
    }
}
