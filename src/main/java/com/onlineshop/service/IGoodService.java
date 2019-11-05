package com.onlineshop.service;

import com.onlineshop.pojo.Good;

import java.util.List;

public interface IGoodService {
    public boolean addGood(Good good);
    public boolean delGood(int gid);
    public boolean altGood(Good new_good);
    public List<Good> getAllGoods();
    public List<Good> getGoodsByType(int type);
    public Good getGoodById(int id);

}
