package com.mrcai.app.auth;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.mrcai.model.User;
import com.mrcai.util.ArrayTool;
import com.mrcai.util.MD5Tool;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 * Created by Administrator on 2017/4/19.
 */
public class Token {

    static private final long TOKEN_LIFE_TIME = 2678400L;
    static private final String SECRET_KEY = "token_turing_key";
    static private final String COMPANY_ISS = "turing.com";

    private Payload payload;
    /**
     * 信息校验位，由生成signal的时候自动赋值
     */
    private String secret;

    public Token(){
    }

    public Token(Payload payload){
        setPayload(payload);
        secret = createSecret();
    }


    /**
     * 用于判断token是否有效
     * 检查信息和信息摘要是否相同
     * @return
     */
    public boolean checkSignature(){
        return createSecret().equals(secret);
    }


    public boolean checkInfo(long userName){
        if(!checkSignature()){
            return false;
        }
//        if(!isExpires()){
//            return false;
//        }
        if(!isRightUser(userName)){
            return false;
        }
        return true;
    }

    /**
     * 用于判断是否属于该用户
     * @param userName
     * 是则返回true
     * 不是这返回false
     * @return
     */
    public boolean isRightUser(long userName){
        return payload.getName() ==  userName;
    }

    /**
     * 判断Token是否过期
     * 过期返回false
     * 没有过期返回true
     * @return
     */
    public boolean isExpires(){
        if(payload.getExp() < System.currentTimeMillis()){
            return false;
        }
        return true;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }


    /**
     * 直接得到加密后的secret
     * @return
     */
    private String createSecret(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(payload.getExp()).append(payload.getName()).append(SECRET_KEY);
        return MD5Tool.getMD5(stringBuilder.toString());
    }

    public byte[] getSignature(){
        return Token.tokenToSignature(this);
    }


    /**
     * 通过signature返回一个Token
     * @param signature
     * @return
     */
    public static Token signatureToToken(String signature){
        if(signature == null) {
            return null;
        }
        return signatureToToken(signature.getBytes());
    }

    /**
     * 将Token解析成一个用于传输的byte串
     * @param token
     * @return
     */
    public static byte[] tokenToSignature(Token token) {
        if(token == null){
            return null;
        }
        token.secret = token.createSecret();
        byte[][] bytesArray = new byte[2][];
        bytesArray[0] = Base64.encodeBase64(JSON.toJSONString(token.payload).getBytes());
        bytesArray[1] = Base64.encodeBase64(token.secret.getBytes());
        return ArrayTool.appendArray(bytesArray);
    }

    /**
     * 将的到的byte串解析成一个Token，如果发现数据有问题，那么会返回一个null
     * @param signature
     * @return
     */
    public static Token signatureToToken(byte[] signature) {
        if(signature == null){//签名为空
            return null;
        }
        byte[][] bytesArray = ArrayTool.cutArray(signature);
        if(bytesArray.length != 2){//如果发现数据不正确
            return null;
        }
        Token token = new Token();
        try {
            token.payload = JSON.parseObject(new String(Base64.decodeBase64(bytesArray[0])), Payload.class);
            token.secret = new String(Base64.decodeBase64(bytesArray[1]));
        }catch (JSONException exception){
            return null;
        }
        return token;
    }

    public static Token userToToken(User user){
        Payload payload = new Payload();
        payload.setExp(System.currentTimeMillis() + TOKEN_LIFE_TIME);
        payload.setName(user.getUserName());
        return new Token(payload);
    }


}