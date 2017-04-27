package com.mrcai.app.auth;

/**
 * Created by Administrator on 2017/4/19.
 */
public class Heard {

    /**
     * Token类型
     */
    private String type;
    /**
     * secret的加密算法
     */
    private String alg;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }
}
