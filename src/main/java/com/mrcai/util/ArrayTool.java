package com.mrcai.util;

/**
 * Created by Administrator on 2017/4/19.
 */
public class ArrayTool {
    /**
     * 用于拼接byte串，每个串用'.'分割
     * @param bytesArray
     * @return
     */
    public static byte[] appendArray(byte[][] bytesArray){
        int position = 0;
        int resultLength = 0;
        for(byte[] bytes : bytesArray){
            resultLength = resultLength + bytes.length;
        }
        byte[] result = new byte[resultLength + bytesArray.length - 1];
        for(int index = 0; index < bytesArray.length; index++){
            byte[] bytes = bytesArray[index];
            System.arraycopy(bytes, 0, result, position, bytes.length);
            if(index + 1 != bytesArray.length)
                result[position + bytes.length] = '!';
            position = position + bytes.length + 1;
        }
        return result;
    }

    public static byte[][] cutArray(byte[] signByte){
        int beginPosition = 0;
        int endPosition = 0;
        int number = 1;
        while(endPosition < signByte.length){
            if(signByte[endPosition] == '!'){
                number++;
            }
            endPosition++;
        }
        byte[][] result = new byte[number][];
        endPosition = 0;
        number = 0;
        while(endPosition < signByte.length){
            if(signByte[endPosition] == '!'){
                result[number]  =new byte[endPosition - beginPosition];
                System.arraycopy(signByte, beginPosition, result[number], 0, endPosition - beginPosition);
                beginPosition = endPosition + 1;
                number++;
            }
            endPosition++;
        }
        result[number]  =new byte[endPosition - beginPosition];
        System.arraycopy(signByte, beginPosition, result[number], 0, endPosition - beginPosition);
        return result;
    }
}
