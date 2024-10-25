package com.li.web.admin;

import com.li.po.Type;
import com.li.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    //    @PageableDefault通常用于设置分页查询的默认参数。
//    其中size = 10表示默认每页的大小为 10 条数据；sort = {"id"}表示默认按照 “id” 字段进行排序；direction = Sort.Direction.DESC表示默认的排序方向为降序
    @GetMapping("/types")
    public String types(
            @PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
            , Model model
    ) {

        model.addAttribute("page", typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(){
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String post(Type type){
        Type saveType = typeService.saveType(type);
        if (saveType == null){
//
        }else {
//
        }
        return "redirect:/admin/types";
    }


}
