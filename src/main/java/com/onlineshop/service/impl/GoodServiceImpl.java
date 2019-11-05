package com.onlineshop.service.impl;

import com.onlineshop.dao.IGoodDao;
import com.onlineshop.dao.impl.GoodDaoImpl;
import com.onlineshop.pojo.Good;
import com.onlineshop.service.IGoodService;

import java.util.List;

public class GoodServiceImpl implements IGoodService {
    private static IGoodDao goodDao = new GoodDaoImpl();
    @Override
    public boolean addGood(Good good) {
        return goodDao.addGood(good);
    }

    @Override
    public boolean delGood(int gid) {
        return goodDao.delGood(gid);
    }

    @Override
    public boolean altGood(Good new_good) {
        return goodDao.altGood(new_good.getId(),new_good);
    }

    @Override
    public List<Good> getAllGoods() {
        return goodDao.getAllGoods();
    }

    @Override
    public List<Good> getGoodsByType(int type) {
        return goodDao.getGoodsByType(type);
    }

    @Override
    public Good getGoodById(int id) {
        return goodDao.getGoodById(id);
    }
}
