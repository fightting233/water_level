package com.mrcai.mapper;

import com.mrcai.model.HardwareInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/3/14.
 */
@Mapper
public interface HardwareMapper {

    HardwareInfo getHardwareInfo(@Param("areaId")int areaId, @Param("hardwareId")int hardwareId);

    void addHardware(@Param("areaId")int areaId, @Param("hardwareId")int hardwareId, @Param("hardwareName")String hardwareName, @Param("hardwareAddr")String hardwareAddr,@Param("hardwareInfo")String hardwareInfo);

}
