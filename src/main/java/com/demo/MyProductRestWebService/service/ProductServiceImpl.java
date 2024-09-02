package com.demo.MyProductRestWebService.service;

import com.demo.MyProductRestWebService.beans.Product;
import com.demo.MyProductRestWebService.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public Product getById(int pid) {
        return productDao.getById(pid);
    }

    @Override
    public boolean save(Product p) {
        return productDao.save(p);
    }

    @Override
    public boolean deletById(int id) {
        return productDao.deleteById(id);
    }

    @Override
    public boolean modifyById(Product p) {
        return productDao.modifyById(p);
    }
}
