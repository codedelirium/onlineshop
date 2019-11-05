package com.onlineshop.dao.impl;

import com.onlineshop.dao.ICategoryDao;
import com.onlineshop.pojo.Category;
import mysql.db.ConnectionHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    private static PreparedStatement pre = null;
    private static ResultSet res = null;
    @Override
    public boolean addCategory(Category cg) {
        String sql = "insert into tb_category(name) value(?)";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setString(1,cg.getName());
            if(pre.execute())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionHandler.close(pre);
        }
        return false;
    }

    @Override
    public boolean delCateGory(int cid) {
        String sql = "delete from tb_category where id = ?";
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
    public boolean altCategory(int cid ,String new_name) {

        String sql = "update tb_category set name = ? where id = ?";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setString(1,new_name);
            pre.setInt(2,cid);
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
    public List<Category> getAllCgs() {
        List<Category> categories = new ArrayList<Category>();
        String sql = "select * from tb_category";
        try{
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                Category c = new Category();
                c.setId(res.getInt("id"));
                c.setName(res.getString("name"));
                categories.add(c);
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
