package com.mrcai.app.controller;

import com.mrcai.app.service.HardwareService;
import com.mrcai.app.service.UserService;
import com.mrcai.app.model.HardwareInfo;
import com.mrcai.app.model.User;
import com.mrcai.app.model.response.Response;
import com.mrcai.app.model.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mrcai.app.util.*;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/14.
 */
@RestController
@RequestMapping(value = "/hardware/{userName}/{token}")
public class HardwareController {

    @Autowired
    HardwareService hardwareService;
    @Autowired
    UserService userService;

    /**
     *  查询监测站信息
     * @param aid   区域id
     * @param hid   硬件id
     * @return
     */
    @GetMapping(value = "/get")
    public Response getHardwareInfo(int aid, int hid, @PathVariable(value = "userName") Long userName,
                                    @PathVariable(value = "token") String token){
        HardwareInfo hardwareInfo = hardwareService.getHardwareInfo(aid, hid);
        if (hardwareInfo == null)
            return ResponseType.actionFaild(null);
        User user = userService.findUserByUserName(userName);
        if (user == null)
            return ResponseType.actionFaild("用户不存在");
        if (!user.getToken().equals(token))
            return ResponseType.tokenRrror(null);
        return new Response(ResponseInfo.ACTION_SUCCEED_DESCRIPTION, ResponseInfo.ACTION_SUCCEED, hardwareInfo);
    }

    /**
     * 添加监测站（Post）
     * @param map
     * @return
     */
    @PostMapping(value = "/add")
    public Response addHardwarebypost(@RequestBody Map map, @PathVariable(value = "userName") Long userName,
                                      @PathVariable(value = "token") String token){
        Integer aid = (Integer) map.get("aid");
        Integer pid = (Integer) map.get("pid");
        String name = (String) map.get("name");
        String addr = (String) map.get("addr");
        String info = (String) map.get("info");
        double longitude = (double) map.get("longitude");
        double latitude = (double) map.get("latitude");
        if (aid == null || pid == null || name == null || addr == null || info == null)
            return ResponseType.jsonParamError(null);
        if (hardwareService.isExist(aid, pid))
            return ResponseType.hardwareAlreadyExist(null);
        User user = userService.findUserByUserName(userName);
        if (user == null)
            return ResponseType.actionFaild("用户不存在");
        if (!user.getToken().equals(token))
            return ResponseType.tokenRrror(null);
        HardwareInfo hardwareInfo = hardwareService.addHardware(aid, pid, name, addr, info, longitude, latitude);
        return new Response(ResponseInfo.ACTION_SUCCEED_DESCRIPTION, ResponseInfo.ACTION_SUCCEED, hardwareInfo);
    }

    /**
     * 删除监测站
     * @param aid
     * @param hid
     * @param userName
     * @param token
     * @return
     */
    @GetMapping(value = "/delete")
    public Response deleteHardware(int aid, int hid, @PathVariable(value = "userName") Long userName,
                                    @PathVariable(value = "token") String token){
        User user = userService.findUserByUserName(userName);
        if (user == null)
            return ResponseType.actionFaild("用户不存在");
        if (!user.getToken().equals(token))
            return ResponseType.tokenRrror(null);
        if (!hardwareService.deleteHardware(aid, hid))
            return ResponseType.actionFaild("数据库操作失败");
        return new Response(ResponseInfo.ACTION_SUCCEED_DESCRIPTION, ResponseInfo.ACTION_SUCCEED, null);
    }

}
