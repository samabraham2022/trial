package com.demo.MyProductRestWebService.service;



import com.demo.MyProductRestWebService.beans.Category;

import java.util.Optional;
import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Optional<Category> FindById(int cid);

    boolean addCategory(Category c);

    boolean modifyCategory(Category c);

    boolean removeCategory(int cid);
}