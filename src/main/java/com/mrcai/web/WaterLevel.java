package com.mrcai.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/13.
 */
@Controller
public class WaterLevel {


    @RequestMapping("/")
    public String test(){
        return "test";
    }
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
