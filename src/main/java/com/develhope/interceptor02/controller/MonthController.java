package com.develhope.interceptor02.controller;

import com.develhope.interceptor02.entities.Month;
import com.develhope.interceptor02.interceptors.MonthInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {


    @GetMapping("")
    public Month getMonth(HttpServletRequest request) {
        return (Month) request.getAttribute("monthNumber");
    }
}
