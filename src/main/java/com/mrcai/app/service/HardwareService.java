package com.mrcai.app.service;

import com.mrcai.mapper.HardwareMapper;
import com.mrcai.model.HardwareInfo;
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

    public HardwareInfo addHardware(int areaId, int hardwareId, String hardwareName, String hardwareAddr, String hardwareInfo){
        if (isExist(areaId, hardwareId))
            return null;
        hardwareMapper.addHardware(areaId, hardwareId, hardwareName, hardwareAddr, hardwareInfo);
        HardwareInfo hardwareInfo1 = new HardwareInfo();
        hardwareInfo1.setAreaId(areaId);
        hardwareInfo1.setHardwareId(hardwareId);
        hardwareInfo1.setHardwareName(hardwareName);
        hardwareInfo1.setHardwareAddr(hardwareAddr);
        hardwareInfo1.setHardwareInfo(hardwareInfo);
        return hardwareInfo1;
    }

    private boolean isExist(Integer areaId, Integer hardwareId) {
        if (getHardwareInfo(areaId, hardwareId) == null)
            return false;
        return true;
    }

}
