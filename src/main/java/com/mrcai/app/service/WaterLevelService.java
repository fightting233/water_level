package com.mrcai.app.service;

import com.mrcai.app.model.mapper.WaterLevelMapper;
import com.mrcai.app.model.WaterLevelInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
@Service
public class WaterLevelService {

    @Autowired
    WaterLevelMapper waterLevelMapper;

    public WaterLevelInfo getWaterLevel(int areaId, int hardwareId){
        return waterLevelMapper.getWaterLevel(areaId, hardwareId);
    }

    public void addWaterLevel(int areaId, int hardwareId, double waterLevel, int time){
        waterLevelMapper.addWaterLevel(areaId, hardwareId, waterLevel, time);
    }

    public List<WaterLevelInfo> getWaterLevelByTime(int areaId, int hardwareId, int startTime, int endTime){
        return waterLevelMapper.getWaterLevelByTime(areaId, hardwareId,startTime, endTime);
    }

}
