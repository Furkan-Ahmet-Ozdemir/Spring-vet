package com.vet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("index")
    public String viewHomePage2(){
        return "index";
    }
}
