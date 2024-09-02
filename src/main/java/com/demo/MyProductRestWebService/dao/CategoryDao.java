package com.demo.MyProductRestWebService.dao;


import com.demo.MyProductRestWebService.beans.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {
    List<Category> findAll();

    Optional<Category> FindById(int cid);

    boolean addCategory(Category c);

    boolean modifyCategory(Category c);

    boolean deleteById(int cid);
}