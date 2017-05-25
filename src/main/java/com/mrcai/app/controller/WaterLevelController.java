package com.mrcai.app.controller;

import com.mrcai.app.service.UserService;
import com.mrcai.app.service.WaterLevelService;
import com.mrcai.app.model.User;
import com.mrcai.app.model.response.Response;
import com.mrcai.app.model.WaterLevelInfo;
import com.mrcai.app.model.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mrcai.app.util.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
@RestController
@RequestMapping(value = "/waterlevel/{userName}/{token}")
public class WaterLevelController {

    @Autowired
    WaterLevelService waterLevelService;
    @Autowired
    UserService userService;

    /**
     * 查询实时水位信息
     * @param aid   区域id
     * @param hid   硬件id
     * @return
     */
    @GetMapping(value = "/getNow")
    public Response getWaterLevel(int aid, int hid, @PathVariable(value = "userName") Long userName,
                                  @PathVariable(value = "token") String token){
        WaterLevelInfo waterLevelInfo = waterLevelService.getWaterLevel(aid, hid);
        if (waterLevelInfo == null)
            return ResponseType.actionFaild(null);
        User user = userService.findUserByUserName(userName);
        if (user == null)
            return ResponseType.actionFaild("用户不存在");
        if (!user.getToken().equals(token))
            return ResponseType.tokenRrror(null);
        return new Response(ResponseInfo.ACTION_SUCCEED_DESCRIPTION, ResponseInfo.ACTION_SUCCEED, waterLevelInfo);
    }

    /**
     * 根据时间段查询
     * @param aid 区域id
     * @param hid 硬件id
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param userName 用户名
     * @param token token
     * @return
     */
    @GetMapping(value = "/getByTime")
    public Response getWaterlevelByTime(int aid, int hid, int startTime, int endTime,
                                        @PathVariable(value = "userName") Long userName,
                                        @PathVariable(value = "token") String token){
        List<WaterLevelInfo> waterLevelInfoList = waterLevelService.getWaterLevelByTime(aid, hid, startTime, endTime);
        if (waterLevelInfoList == null)
            return ResponseType.actionFaild(null);
        User user = userService.findUserByUserName(userName);
        if (user == null)
            return ResponseType.actionFaild("用户不存在");
        if (!user.getToken().equals(token))
            return ResponseType.tokenRrror(null);
        return new Response(ResponseInfo.ACTION_SUCCEED_DESCRIPTION, ResponseInfo.ACTION_SUCCEED, waterLevelInfoList);
    }

    @GetMapping(value = "/add")
    public Response addWaterLevel(int aid, int hid, double waterLevel){
        waterLevelService.addWaterLevel(aid, hid, waterLevel, (int)(System.currentTimeMillis() / 1000));
        return new Response(ResponseInfo.ACTION_SUCCEED_DESCRIPTION, ResponseInfo.ACTION_SUCCEED, "");
    }

    @GetMapping(value = "/getRecent")
    public double[] getWaterlevelRecent(int aid, int hid, int startTime, int endTime){
        List<WaterLevelInfo> waterLevelInfoList = waterLevelService.getWaterLevelByTime(aid, hid, startTime, endTime);
        double[] waterLevelList = new double[waterLevelInfoList.size()];
        for (int i = 0; i < waterLevelInfoList.size(); i++) {
            waterLevelList[i] = waterLevelInfoList.get(i).getWaterLevel();
        }
        return waterLevelList;
    }

}
