package com.onlineshop.service.impl;

import com.onlineshop.dao.ICategoryDao;
import com.onlineshop.dao.impl.CategoryDaoImpl;
import com.onlineshop.pojo.Category;
import com.onlineshop.service.ICartService;
import com.onlineshop.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService
{
    private static ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public boolean addCategory(Category cg) {
        return categoryDao.addCategory(cg);
    }

    @Override
    public boolean delCateGory(int cid) {
        return categoryDao.delCateGory(cid);
    }

    @Override
    public boolean altCategory(int cid, String new_name) {
        return categoryDao.altCategory(cid,new_name);
    }

    @Override
    public List<Category> getAllCgs() {
        return categoryDao.getAllCgs();
    }

}
