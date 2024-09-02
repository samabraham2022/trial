package com.demo.MyProductRestWebService.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginUser")
public class LoginController {


    @GetMapping("/login")
    public String validateUser(){
        return "In Validate user";
    }
}
