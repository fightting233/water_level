package com.mrcai.app.model.mapper;

import com.mrcai.app.model.HardwareInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/3/14.
 */
@Mapper
public interface HardwareMapper {

    HardwareInfo getHardwareInfo(@Param("areaId")int areaId, @Param("hardwareId")int hardwareId);

    void addHardware(@Param("areaId")int areaId, @Param("hardwareId")int hardwareId,
                     @Param("hardwareName")String hardwareName, @Param("hardwareAddr")String hardwareAddr,
                     @Param("hardwareInfo")String hardwareInfo,@Param("longitude")double longitude,
                     @Param("latitude")double latitude);

    void deleteHardware(@Param("areaId")int areaId, @Param("hardwareId")int hardwareId);

}
