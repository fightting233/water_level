package com.mrcai.app.model.response;

/**
 * Created by Administrator on 2017/3/14.
 */
public class Response {

    private String result;
    private int resultCode;
    private Object content;

    public Response(String result, int resultCode, Object content){
        this.result = result;
        this.resultCode = resultCode;
        this.content = content;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}
