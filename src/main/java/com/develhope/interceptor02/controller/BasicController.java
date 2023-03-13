package com.develhope.interceptor02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/")
    public String welcome(){
        System.out.println("Welcome!");
        return "Welcome!";
    }
}
