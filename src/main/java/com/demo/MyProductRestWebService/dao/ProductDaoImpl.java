package com.demo.MyProductRestWebService.dao;


import com.demo.MyProductRestWebService.beans.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAllProducts() {
        return jdbcTemplate.query("select * from product", (rs,rowNum)->{
                    Product p = new Product();
                    p.setId(rs.getInt(1));
                    p.setName(rs.getString(2));
                    p.setQuantity(rs.getInt(3));
                    p.setPrice(rs.getDouble(4));
                    p.setExpirydate(rs.getDate(5).toLocalDate());
                    p.setCid(rs.getInt(6));
                    return p;
                }
        );

    }

    @Override
    public Product getById(int pid) {
        try {
            Product pro = jdbcTemplate.queryForObject("select * from product where id=?", new Object[]{pid}, (rs, rowNum) -> {
                        Product p = new Product();
                        p.setId(rs.getInt(1));
                        p.setName(rs.getString(2));
                        p.setQuantity(rs.getInt(3));
                        p.setPrice(rs.getDouble(4));
                        p.setExpirydate(rs.getDate(5).toLocalDate());
                        p.setCid(rs.getInt(6));
                        return p;
                    }
            );
            return pro;
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public boolean save(Product p) {
        int c = jdbcTemplate.update("insert into product values(?,?,?,?,?,?);", new Object[]{
                p.getId(), p.getName(), p.getQuantity(), p.getPrice(), p.getExpirydate(), p.getCid()
        });
        if(c>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        int c = jdbcTemplate.update("delete from product where id=?;", new Object[]{id});
        if(c>0) {
            return true;
        }
        return false;

    }

    @Override
    public boolean modifyById(Product p) {
        int c = jdbcTemplate.update("update product set name=?,quantity=?,price=?,expirydate=?,cid=? where id=?", new Object[]{
                p.getName(),p.getQuantity(),p.getPrice(),p.getExpirydate(),p.getCid(),p.getId()
        });
        if(c>0) {
            return true;
        }
        return false;
    }
}
