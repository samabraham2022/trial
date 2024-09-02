package com.demo.MyProductRestWebService.dao;

import com.demo.MyProductRestWebService.beans.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();

    Product getById(int pid);

    boolean save(Product p);

    boolean deleteById(int id);

    boolean modifyById(Product p);
}
