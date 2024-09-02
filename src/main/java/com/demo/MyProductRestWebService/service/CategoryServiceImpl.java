package com.demo.MyProductRestWebService.service;


import com.demo.MyProductRestWebService.beans.Category;
import com.demo.MyProductRestWebService.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAll() {
        return categoryDao.findAll();
    }

    @Override
    public Optional<Category> FindById(int cid) {
        return categoryDao.FindById(cid);
    }

    @Override
    public boolean addCategory(Category c) {
        return categoryDao.addCategory(c);
    }

    @Override
    public boolean modifyCategory(Category c) {
        return categoryDao.modifyCategory(c);
    }

    @Override
    public boolean removeCategory(int cid) {
        return categoryDao.deleteById(cid);
    }


}