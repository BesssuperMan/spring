package com.yjxxt.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {
    @RequestMapping("index")
    @ResponseBody
    public String test01(){
        return "hello,haha";
    }
}
