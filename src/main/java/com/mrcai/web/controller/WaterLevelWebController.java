package com.mrcai.web.controller;

import com.alibaba.fastjson.JSON;
import com.mrcai.app.model.WaterLevelInfo;
import com.mrcai.web.service.WaterLevelWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
@Controller
@RequestMapping(value = "/web")
public class WaterLevelWebController {

    @Autowired
    WaterLevelWebService service;

    @RequestMapping(value = "/getRecentDay", method = RequestMethod.POST)
    @ResponseBody
    public String getRecentDay(){
        Map<String, List> map = service.getWaterLevelRecentDay();
        String json = JSON.toJSONString(map);
        return json;
    }

    @RequestMapping(value = "/getRecentWeek", method = RequestMethod.POST)
    @ResponseBody
    public String getRecentWeek(){
        Map<String, List> map = service.getWaterLevelRecentWeek();
        String json = JSON.toJSONString(map);
        return json;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public String get(){
        Map map = service.get(161521366, 002, 1492969122,  (int)(System.currentTimeMillis() / 1000));
        String json = JSON.toJSONString(map);
        return json;
    }

}
