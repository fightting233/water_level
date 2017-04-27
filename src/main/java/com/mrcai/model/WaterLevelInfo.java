package com.mrcai.model;

/**
 * Created by Administrator on 2017/3/14.
 */
public class WaterLevelInfo {

    private int areaId;
    private int hardwareId;
    private double waterLevel;
    private int time;

    public int getAreaId() {
        return areaId;
    }

    public int getHardwareId() {
        return hardwareId;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public int getTime() {
        return time;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public void setHardwareId(int hardwareId) {
        this.hardwareId = hardwareId;
    }

    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
