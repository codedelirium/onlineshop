package com.onlineshop.service;

import com.onlineshop.pojo.Cart;
import com.onlineshop.pojo.Category;

import java.util.List;

public interface ICartService {
    //增加购物车内容
    public boolean addCart(Cart cart);
    //删除购物车内容
    public boolean delCart(int cid);
    //修改购物车内容
    public boolean altCart(int cid,int new_amount);
    //查找购物车内容
    public List<Cart> getCartsById(int uid);
}
