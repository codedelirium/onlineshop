package com.onlineshop.service;

import com.onlineshop.pojo.Category;

import java.util.List;

public interface ICategoryService {
    public boolean addCategory(Category cg);
    public boolean delCateGory(int cid);
    public boolean altCategory(int cid,String new_name);
    public List<Category> getAllCgs();
}
