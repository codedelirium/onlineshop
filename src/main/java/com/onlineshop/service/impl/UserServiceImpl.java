package com.onlineshop.service.impl;

import com.onlineshop.dao.IUserDao;
import com.onlineshop.dao.impl.UserDaoImpl;
import com.onlineshop.pojo.User;
import com.onlineshop.service.IUserService;
import mysql.db.ConnectionHandler;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private static IUserDao userDao = new UserDaoImpl();

    @Override
    public User login(int id ,String pwd) {
        User user = null;
        try {
            user = userDao.getUser(id,pwd);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean register(int id ,String name,String pwd) {

        return userDao.addUser(id,name,pwd);
    }

    @Override
    public boolean altUser(int id,String new_pwd) {
        return userDao.updateUser(id,new_pwd);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public boolean payBill(int id, int m) {
        return userDao.altMoney(id,m);
    }

}
