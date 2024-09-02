package com.demo.MyProductRestWebService.controller;

import com.demo.MyProductRestWebService.beans.Category;
import com.demo.MyProductRestWebService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories()
    {
        List<Category> clist=categoryService.getAll();
        return ResponseEntity.ok(clist);
    }

    @GetMapping("/category")
    public ResponseEntity<Category> getAllCategoryById(@RequestParam("cid") int cid){
        Optional<Category> op= categoryService.FindById(cid);
        if(op.isPresent()){
            return ResponseEntity.ok(op.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/category/{cid}")
    public ResponseEntity<String> addCategory(@RequestBody Category c){
        boolean status = categoryService.addCategory(c);
        if(status){
            return ResponseEntity.ok("Inserted Successfully");
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/category/{cid}")
    public ResponseEntity<String> deleteCategory(@PathVariable("cid") int cid)
    {
        boolean status = categoryService.removeCategory(cid);
        if(status){
            return ResponseEntity.ok("Deleted Successfully"+cid);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @PutMapping("/category/{cid}")
    public ResponseEntity<String> updateCategory(@RequestBody Category c) {
        boolean status = categoryService.modifyCategory(c);
        if(status){
            return ResponseEntity.ok("Inserted Successfully");
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}