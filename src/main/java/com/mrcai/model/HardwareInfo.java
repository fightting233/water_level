package com.mrcai.model;

/**
 * Created by Administrator on 2017/3/14.
 */
public class HardwareInfo {

    private int areaId;
    private int hardwareId;
    private String hardwareName;
    private String hardwareAddr;
    private String hardwareInfo;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(int hardwareId) {
        this.hardwareId = hardwareId;
    }

    public String getHardwareName() {
        return hardwareName;
    }

    public void setHardwareName(String hardwareName) {
        this.hardwareName = hardwareName;
    }

    public String getHardwareAddr() {
        return hardwareAddr;
    }

    public void setHardwareAddr(String hardwareAddr) {
        this.hardwareAddr = hardwareAddr;
    }

    public String getHardwareInfo() {
        return hardwareInfo;
    }

    public void setHardwareInfo(String hardwareInfo) {
        this.hardwareInfo = hardwareInfo;
    }
}
