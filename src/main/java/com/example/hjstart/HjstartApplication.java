package com.example.hjstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HjstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(HjstartApplication.class, args);
        System.out.print("\u001B[31m\u001B[1m启动成功\u001B[0m");
    }

}
