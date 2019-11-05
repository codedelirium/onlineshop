package com.onlineshop.dao;

import com.onlineshop.pojo.Good;

import java.util.List;

public interface IGoodDao {

    //增加商品
    public boolean addGood(Good new_good);
    //删除商品
    public boolean delGood(int gid);
    //修改商品信息
    public boolean altGood(int gid,Good new_good);
    ///显示商品
    //显示所有商品
    public List<Good> getAllGoods();
    //根据分类显示商品
    public List<Good> getGoodsByType(int type);

    public Good getGoodById(int id);
}
