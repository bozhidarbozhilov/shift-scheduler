package com.bozhilov.shiftscheduler.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController{

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }


    @GetMapping("/home")
    public String getHome(){return super.view("user/home");}
}
