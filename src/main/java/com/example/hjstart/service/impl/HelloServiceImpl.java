package com.example.hjstart.service.impl;

import com.example.hjstart.service.HelloService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public void test(Model model, String inform, String msg) {
        log.info("进入方法test");
        model.addAttribute("msg", inform + msg);
    }
}
