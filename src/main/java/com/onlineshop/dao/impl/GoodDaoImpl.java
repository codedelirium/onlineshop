package com.onlineshop.dao.impl;

import com.onlineshop.dao.IGoodDao;
import com.onlineshop.pojo.Good;
import com.onlineshop.pojo.User;
import mysql.db.ConnectionHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDaoImpl implements IGoodDao {
    private static PreparedStatement pre = null;
    private static ResultSet res = null;
    @Override
    public boolean addGood(Good new_good) {
        String sql = "insert into tb_good(name, price, description, reserve, type) value(?,?,?,?,?)";
        try{
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setString(1,new_good.getName());
            pre.setInt(2,new_good.getPrice());
            pre.setString(3,new_good.getDescription());
            pre.setInt(4,new_good.getReserve());
            pre.setInt(5,new_good.getType());
            if(pre.executeUpdate()==1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delGood(int gid) {
        return false;
    }

    @Override
    public boolean altGood(int gid, Good new_good) {
        return false;
    }

    @Override
    public List<Good> getAllGoods() {
        List<Good> goods = new ArrayList<Good>();
        String sql = "select * from tb_good";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                Good good = new Good();
                good.setName(res.getString("name"));
                good.setId(res.getInt("id"));
                good.setImage(res.getString("image"));
                good.setDescription(res.getString("description"));
                good.setPrice(res.getInt("price"));
                good.setReserve(res.getInt("reserve"));
                good.setType(res.getInt("type"));
                goods.add(good);
            }
            return goods;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionHandler.close(res,pre);
        }
        return null;
    }

    @Override
    public List<Good> getGoodsByType(int type) {
        List<Good> goods = new ArrayList<Good>();
        String sql = "select * from tb_good where type = ? ";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setInt(1,type);
            res = pre.executeQuery();
            while(res.next()){
                Good good = new Good();
                good.setId(res.getInt("id"));
                good.setImage(res.getString("image"));
                good.setDescription(res.getString("description"));
                good.setPrice(res.getInt("price"));
                good.setReserve(res.getInt("reserve"));
                good.setType(res.getInt("type"));
                good.setName(res.getString("name"));
                goods.add(good);
            }
            return goods;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionHandler.close(res,pre);
        }
        return null;
    }

    @Override
    public Good getGoodById(int id) {
        String sql = "select * from tb_good where id = ? ";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setInt(1,id);
            res = pre.executeQuery();
            if(res.next()){
                Good good = new Good();
                good.setId(id);
                good.setName(res.getString("name"));
                good.setImage(res.getString("image"));
                good.setDescription(res.getString("description"));
                good.setPrice(res.getInt("price"));
                good.setReserve(res.getInt("reserve"));
                good.setType(res.getInt("type"));
                return good;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionHandler.close(res,pre);
        }
        return null;
    }
}
