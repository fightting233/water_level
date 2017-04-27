package com.mrcai.app.auth;

/**
 * Created by Administrator on 2017/4/19.
 */
public class Payload {
    /**
     * 发行商
     */
//    private String iss;
    /**
     * 发行时间,unix时间戳格式
     */
//    private long iat;
    /**
     * 过期时间,unix时间戳格式
     */
    private long exp;
    /**
     * 所属用户
     */
    private long name;
//
//    public String getIss() {
//        return iss;
//    }
//
//    public void setIss(String iss) {
//        this.iss = iss;
//    }
//
//    public long getIat() {
//        return iat;
//    }
//
//    public void setIat(long iat) {
//        this.iat = iat;
//    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }
}
