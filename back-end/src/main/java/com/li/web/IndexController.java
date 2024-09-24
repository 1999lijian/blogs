package com.li.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//控制器
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
//        int i = 9/0;

        return "index";
    }
}
