package com.mrcai.app.model.mapper;

import com.mrcai.app.model.WaterLevelInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
@Mapper
public interface WaterLevelMapper {

    WaterLevelInfo getWaterLevel(@Param("areaId")int areaId, @Param("hardwareId")int hardwareId);

    void addWaterLevel(@Param("areaId")int areaId, @Param("hardwareId")int hardwareId, @Param("waterLevel")double waterLevel, @Param("time")int time);

    List<WaterLevelInfo> getWaterLevelByTime(@Param("areaId")int areaId, @Param("hardwareId")int hardwareId, @Param("startTime")int startTime, @Param("endTime")int endTime);
}
