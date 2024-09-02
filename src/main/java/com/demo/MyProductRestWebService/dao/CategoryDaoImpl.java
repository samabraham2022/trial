package com.demo.MyProductRestWebService.dao;


import com.demo.MyProductRestWebService.beans.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private JdbcClient jdbcClient;

    @Override
    public List<Category> findAll() {
        return jdbcClient.sql("select * from category")
                .query((rs,rownum)->{
                    Category c=new Category();
                    c.setCid(rs.getInt(1));
                    c.setCname(rs.getString(2));
                    c.setDesc(rs.getString(3));
                    return c;
                }).list();
    }

    @Override
    public Optional<Category> FindById(int cid) {
        return jdbcClient.sql("select  * from category where cid=?")
                .param(cid)
                //if we want we can use rowmapper but abhi dono ke coloumn same hain isliye
                .query(Category.class)
                //kya pta mile ya nhi id isliye optional
                .optional();
    }

    @Override
    public boolean addCategory(Category c) {
        int n= jdbcClient.sql("insert into category value(?,?,?)")
                .param(1, c.getCid())
                .param(2, c.getCname())
                .param(3, c.getDesc())
                .update();
        return n>0;
    }

    @Override
    public boolean modifyCategory(Category c) {
        int n= jdbcClient.sql("update category set cname=?,cdesc=? where cid=?")
                .param(1, c.getCname())
                .param(2, c.getDesc())
                .param(3, c.getCid())
                .update();

//        or
//        int n = jdbcClient.sql("update category set cname=:cname ,cdesc=:cdesc where cid=:cid")
//                .param("cname",)
//                .param("cdesc")
//                .param("cid",)
//                .update();
//        return n>0;
        return n>0;
    }

    @Override
    public boolean deleteById(int cid) {
        int n= jdbcClient.sql("delete from category where cid=?")
                .param(1,cid)
                .update();
        return n>0;
    }


}