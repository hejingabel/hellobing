package com.example.hjstart.contrller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestContrller {
    @GetMapping("/world")
    public String hello(){
        return "hhhhhhhhhh";
    }
}
