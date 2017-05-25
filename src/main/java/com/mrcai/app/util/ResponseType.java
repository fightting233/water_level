package com.mrcai.app.util;

import com.mrcai.app.model.response.Response;
import com.mrcai.app.model.response.ResponseInfo;

/**
 * Created by Administrator on 2017/3/15.
 */
public class ResponseType {

    public static Response jsonParamError(Object object){
        return new Response(ResponseInfo.JSON_PARAM_ERROR_DESCRIPTION, ResponseInfo.JSON_PARAM_ERROR, object);
    }

    public static Response actionFaild(Object object){
        return new Response(ResponseInfo.ACTION_FAILED_DESCRIPTION, ResponseInfo.ACTION_FAILED, object);
    }

    public static Response hardwareAlreadyExist(Object object){
        return new Response(ResponseInfo.HARDWARE_ALREADY_EXIST_DESCRIPTION, ResponseInfo.HARDWARE_ALREADY_EXIST, object);
    }

    public static Response hardwareNotExist(Object object){
        return new Response(ResponseInfo.HARDWARE_NOT_EXIST_DESCRIPTION, ResponseInfo.HARDWARE_NOT_EXIST, object);
    }

    public static Response tokenRrror(Object object){
        return new Response(ResponseInfo.TOKEN_ERROR_DESCRIPTION, ResponseInfo.ACTION_SUCCEED, object);
    }

    public static Response userNotExisit(Long userName){
        return  new Response( ResponseInfo.USER_NOT_EXIST_DESCRIPTION,
                ResponseInfo.USER_NOT_EXIST,String.valueOf(userName));
    }

    public static Response passwordError(Long userName){
        return new Response(ResponseInfo.PASSWORD_ERROR_DESCRIPTION,
                ResponseInfo.PASSWORD_ERROR, String.valueOf(userName));
    }

    public static Response loginSucceed(String token){
        return new Response(ResponseInfo.LOGIN_SUCCEED_DESCRIPTION,
                ResponseInfo.LOGIN_SUCCEED, token);
    }

    public static Response userAlreadyExist(Object object){
        return new Response(ResponseInfo.USER_ALREADY_EXIST_DESCRIPTION, ResponseInfo.USER_ALREADY_EXIST, object);
    }

    public static Response userAddSucceed(long userNumber){
        return new Response(ResponseInfo.USER_REGISTER_SUCCEED_DESCRIPTION,
                ResponseInfo.USER_REGISTER_SUCCEED, String.valueOf(userNumber));
    }

}
