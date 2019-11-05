package com.onlineshop.service.impl;

import com.onlineshop.dao.ICartDao;
import com.onlineshop.dao.impl.CartDaoImpl;
import com.onlineshop.pojo.Cart;
import com.onlineshop.pojo.Category;
import com.onlineshop.service.ICartService;

import java.util.List;

public class CartServiceImpl implements ICartService {
    private static ICartDao cartDao = new CartDaoImpl();
    @Override
    public boolean addCart(Cart cart) {
        return cartDao.addCart(cart);
    }

    @Override
    public boolean delCart(int cid) {
        return cartDao.delCart(cid);
    }

    @Override
    public boolean altCart(int cid, int new_amount) {
        Cart cart = (Cart) cartDao.getCartsById(cid);
        int p = cart.getPrice();
        return cartDao.altCart(cid, new_amount,p*new_amount);
    }

    @Override
    public List<Cart> getCartsById(int uid) {
        return cartDao.getCartsById(uid);
    }
}
