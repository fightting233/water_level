package com.mrcai.web.service;

import com.mrcai.app.model.mapper.WaterLevelMapper;
import com.mrcai.app.model.WaterLevelInfo;
import com.mrcai.web.controller.model.WaterLevelWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/3/14.
 */
@Service
public class WaterLevelWebService {

    @Autowired
    WaterLevelMapper waterLevelMapper;

    public WaterLevelInfo getWaterLevel(int areaId, int hardwareId){
        return waterLevelMapper.getWaterLevel(areaId, hardwareId);
    }

    public Map<String, List> getWaterLevelRecentDay(){
        List<WaterLevelInfo> waterLevelInfoList = waterLevelMapper.getWaterLevelByTime(161521366, 002,
                (int)(System.currentTimeMillis() / 1000 - 24 * 3600),
                (int)(System.currentTimeMillis() / 1000));
        List<Double> levels = new ArrayList<>();
        List<String> times = new ArrayList<>();
        Map<String, List> map = new HashMap();
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < waterLevelInfoList.size(); i++) {
            levels.add(waterLevelInfoList.get(i).getWaterLevel());
            Long time = (long)waterLevelInfoList.get(i).getTime() * 1000;
            String date = format.format(new Date(time));
            times.add(date);
        }
        map.put("level", levels);
        map.put("time", times);
        return map;
    }

    public Map<String, List> getWaterLevelRecentWeek(){
        List<WaterLevelInfo> waterLevelInfoList = waterLevelMapper.getWaterLevelByTime(161521366, 002,
                (int)(System.currentTimeMillis() / 1000 - 7 * 24 * 3600),
                (int)(System.currentTimeMillis() / 1000));
        List<Double> levels = new ArrayList<>();
        List<String> times = new ArrayList<>();
        Map<String, List> map = new HashMap();
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < waterLevelInfoList.size(); i++) {
            levels.add(waterLevelInfoList.get(i).getWaterLevel());
            Long time = (long)waterLevelInfoList.get(i).getTime() * 1000;
            String date = format.format(new Date(time));
            times.add(date);
        }
        map.put("level", levels);
        map.put("time", times);
        return map;
    }

    public Map get(int areaId, int hardwareId, int startTime, int endTime){
        List<WaterLevelInfo> waterLevelInfoList = waterLevelMapper.getWaterLevelByTime(areaId, hardwareId,startTime, endTime);
        List<WaterLevelWeb> waterLevelWebList = new ArrayList<>();
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        WaterLevelInfo waterLevelInfo;
        for (int i = 0; i < waterLevelInfoList.size(); i++) {
            waterLevelInfo = waterLevelInfoList.get(i);
            Long time = (long)waterLevelInfo.getTime() * 1000;
            String date = format.format(new Date(time));
            WaterLevelWeb waterLevelWeb = new WaterLevelWeb(waterLevelInfo.getAreaId(), waterLevelInfo.getHardwareId(), waterLevelInfo.getWaterLevel(),date);
            waterLevelWebList.add(waterLevelWeb);
        }
        Map map = new HashMap();
        map.put("draw", 1);
        map.put("recordsTotal", waterLevelWebList.size());
        map.put("recordsFiltered", waterLevelWebList.size());
        map.put("data", waterLevelWebList);
        return map;
    }

}
