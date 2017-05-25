package com.mrcai.web.controller.model;

/**
 * Created by Administrator on 2017/3/14.
 */
public class WaterLevelWeb {

    public WaterLevelWeb(int areaId, int hardwareId, double waterLevel, String time) {
        this.areaId = areaId;
        this.hardwareId = hardwareId;
        this.waterLevel = waterLevel;
        this.time = time;
    }

    private int areaId;
    private int hardwareId;
    private double waterLevel;
    private String time;

    public int getAreaId() {
        return areaId;
    }

    public int getHardwareId() {
        return hardwareId;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public String getTime() {
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

    public void setTime(String time) {
        this.time = time;
    }
}
