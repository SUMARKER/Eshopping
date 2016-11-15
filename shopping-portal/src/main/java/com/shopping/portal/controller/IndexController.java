package com.shopping.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/11/15.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String ShowIndex(){
        return "index";
    }
}
