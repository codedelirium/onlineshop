package com.onlineshop.dao;

import com.onlineshop.pojo.User;

import java.util.List;

public interface IUserDao {
    //增加用户
    public boolean addUser(int id ,String name,String pwd);
    //修改密码
    public boolean updateUser(int id,String new_pwd);
    //删除用户
    public boolean delUser(int uid);

    public User getUser(int id,String pwd);
    //显示所有用户
    public List<User> getAllUsers();

    public boolean altMoney(int id ,int m);

}
