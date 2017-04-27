package com.mrcai.app.controller;

import com.mrcai.app.service.UserService;
import com.mrcai.model.response.Response;
import com.mrcai.util.ObjectToValue;
import com.mrcai.util.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Administrator on 2017/4/6.
 */
@RestController
@RequestMapping(value = "user/{userName}")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public Response login(@PathVariable(value = "userName") Long userName, @RequestBody Map map){
        Long phoneNumber = ObjectToValue.objectToLong(map.get("userName"));
        String password = (String) map.get("password");
        if (phoneNumber == null || password == null || !userName.equals(phoneNumber))
            return ResponseType.jsonParamError(userName);
        else if (!userService.isExist(userName))
            return ResponseType.userNotExisit(userName);
        else if (!userService.checkPassword(userName, password))
            return ResponseType.passwordError(userName);
        return ResponseType.loginSucceed(userService.updateToken(userName));
    }

    @PostMapping(value = "/add")
    public Response register(@PathVariable(value = "userName") Long userName, @RequestBody Map map){
        Long phoneNumber = ObjectToValue.objectToLong(map.get("userName"));
        String password = (String) map.get("password");
        Integer userType = ObjectToValue.objectToInt(map.get("userType"));
        if(phoneNumber == null || !phoneNumber.equals(userName) || password == null || userType == null)
            return ResponseType.jsonParamError(userName);
        else if (userService.isExist(userName))
            return ResponseType.userAlreadyExist(userName);
        else if (userService.addUser(userName, password, userType))
            return ResponseType.userAddSucceed(userName);
        return ResponseType.actionFaild(userName);
    }

}
