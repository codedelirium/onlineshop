package com.onlineshop.service;

import com.onlineshop.pojo.User;

import java.util.List;

public interface IUserService {

    public User login(int id,String pwd);
    public boolean register(int id,String name,String pwd);
    public boolean altUser(int id,String new_pwd);
    public List<User> getAllUsers();

    public boolean payBill(int id,int m);
}
