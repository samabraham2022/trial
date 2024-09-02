package com.demo.MyProductRestWebService.controller;


import com.demo.MyProductRestWebService.beans.Product;
import com.demo.MyProductRestWebService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> plist = productService.getAllProducts();
        return ResponseEntity.ok(plist);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") int pid){

        if(productService.getById(pid)!=null) {
            return ResponseEntity.ok(productService.getById(pid));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/product/{id}")
    public ResponseEntity<String> addProduct(@RequestBody Product p){
        boolean status = productService.save(p);
        if(status){
            return ResponseEntity.ok("Data Inserted Successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        boolean status = productService.deletById(id);
        if(status){
            return ResponseEntity.ok("Data Deleted Successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/product/{pid}")
    public ResponseEntity<String> updateProduct(@RequestBody Product p){
        boolean status = productService.modifyById(p);
        if(status){
            return ResponseEntity.ok("Data Modified Successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}
