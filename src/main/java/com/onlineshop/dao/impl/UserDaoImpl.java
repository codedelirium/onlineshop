package com.onlineshop.dao.impl;

import com.onlineshop.dao.IUserDao;
import com.onlineshop.pojo.User;
import mysql.db.ConnectionHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    private static PreparedStatement pre = null;
    private static ResultSet res = null;
    @Override
    public boolean addUser(int id ,String name,String pwd) {
        String sql = "insert into tb_user(id, name, pwd, money, type) value(?,?,?,50000,0)";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setInt(1,id);
            pre.setString(2,name);
            pre.setString(3,pwd);
            if(pre.execute()){
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
    public boolean updateUser(int id,String new_pwd) {
        String sql = "update tb_user set pwd = ? where id = ?";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setString(1,new_pwd);
            pre.setInt(2,id);
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
    public boolean delUser(int uid) {
        return false;
    }

    @Override
    public User getUser(int id, String pwd) {
        String sql = "select * from tb_user where id = ? and pwd = ?";
        try {
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setInt(1,id);
            pre.setString(2,pwd);
            res = pre.executeQuery();
            if(res.next()){
                User user = new User();
                user.setId(res.getInt("id"));
                user.setMoney(res.getInt("money"));
                user.setName(res.getString("name"));
                user.setPwd(res.getString("pwd"));
                user.setType(res.getInt("type"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionHandler.close(res,pre);
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "select * from tb_user where type = 0";
        try{
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                User u = new User();
                u.setId(res.getInt("id"));
                u.setName(res.getString("name"));
                u.setPwd(res.getString("pwd"));
                u.setMoney(res.getInt("money"));
                u.setType(res.getInt("type"));
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean altMoney(int id, int m) {
        String sql = "update tb_user set money = money-? where id = ?";
        try{
            pre = ConnectionHandler.getConnection().prepareStatement(sql);
            pre.setInt(1,m);
            pre.setInt(2,id);
            if(pre.executeUpdate()==1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
