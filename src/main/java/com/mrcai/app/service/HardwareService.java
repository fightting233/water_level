package com.mrcai.app.service;

import com.mrcai.app.model.mapper.HardwareMapper;
import com.mrcai.app.model.HardwareInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/14.
 */
@Service
public class HardwareService {

    @Autowired
    HardwareMapper hardwareMapper;

    public HardwareInfo getHardwareInfo(int areaId, int hardwareId){
        return hardwareMapper.getHardwareInfo(areaId, hardwareId);
    }

    public HardwareInfo addHardware(int areaId, int hardwareId, String hardwareName, String hardwareAddr,
                                    String hardwareInfo, double longitude, double latitude){
        if (isExist(areaId, hardwareId))
            return null;
        hardwareMapper.addHardware(areaId, hardwareId, hardwareName, hardwareAddr, hardwareInfo, longitude, latitude);
        return hardwareMapper.getHardwareInfo(areaId, hardwareId);
    }

    public boolean deleteHardware(int areaId, int hardwareId){
        hardwareMapper.deleteHardware(areaId, hardwareId);
        return !isExist(areaId, hardwareId);
    }

    public boolean isExist(Integer areaId, Integer hardwareId) {
        if (getHardwareInfo(areaId, hardwareId) == null)
            return false;
        return true;
    }

}
