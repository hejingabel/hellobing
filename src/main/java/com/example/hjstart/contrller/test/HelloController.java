package com.example.hjstart.contrller.test;

import com.example.hjstart.service.HelloService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @Resource
    private HelloService helloService;
    @GetMapping("/test/{inform}")
    public String test(Model model, @PathVariable("inform") String inform, @RequestParam("msg") String msg) {
        helloService.test(model,inform,msg);
        return "test";
    }
}
