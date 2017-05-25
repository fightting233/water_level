package com.mrcai.app.model.response;

/**
 * Created by Administrator on 2017/3/15.
 */
public class ResponseInfo {

    public static final int ACTION_SUCCEED = 1001;
    public static final String ACTION_SUCCEED_DESCRIPTION = "操作成功";

    public static final int ACTION_FAILED = 1000;
    public static final String ACTION_FAILED_DESCRIPTION = "操作失败";

    static public final int JSON_PARAM_ERROR = 2000;
    static public final String JSON_PARAM_ERROR_DESCRIPTION = "json参数有误";

    static public final int HARDWARE_ALREADY_EXIST = 1010;
    static public final String HARDWARE_ALREADY_EXIST_DESCRIPTION = "监测站已存在";

    static public final int HARDWARE_NOT_EXIST = 1020;
    static public final String HARDWARE_NOT_EXIST_DESCRIPTION = "监测站不存在";

    static public final int TOKEN_ERROR = 2050;
    static public final String TOKEN_ERROR_DESCRIPTION = "token错误";

    static public final int USER_REGISTER_SUCCEED = 1004;
    static public final String USER_REGISTER_SUCCEED_DESCRIPTION = "添加用户成功";

    static public final int USER_NOT_EXIST = 2002;
    static public final String USER_NOT_EXIST_DESCRIPTION = "用户不存在";

    static public final int PASSWORD_ERROR = 2009;
    static public final String PASSWORD_ERROR_DESCRIPTION = "密码错误";

    static public final int LOGIN_SUCCEED = 1005;
    static public final String LOGIN_SUCCEED_DESCRIPTION = "登录成功";

    static public final int USER_ALREADY_EXIST = 2004;
    static public final String USER_ALREADY_EXIST_DESCRIPTION = "用户已存在";

}
