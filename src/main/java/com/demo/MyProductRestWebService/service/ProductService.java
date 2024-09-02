package com.demo.MyProductRestWebService.service;

import com.demo.MyProductRestWebService.beans.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getById(int pid);

    boolean save(Product p);

    boolean deletById(int id);

    boolean modifyById(Product p);
}
