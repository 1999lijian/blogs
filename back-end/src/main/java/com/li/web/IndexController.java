package com.li.web;

import com.li.handler.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//控制器
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {

//        int i = 9/0;

        String blog = null;
        if (blog == null) {
            throw new NotFoundException("博客不存在");
        }
        return "index";
    }
}
