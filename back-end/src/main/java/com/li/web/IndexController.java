package com.li.web;

import com.li.handler.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//控制器
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {


        return "index";
    }

    @GetMapping("/blog")
    public String blog() {


        return "blog";
    }
}
