package com.lucifer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "name") String name) {
        return "Hello ".concat(name);
    }
}
