package com.mrcai.util;

/**
 * Created by Administrator on 2017/3/15.
 */

public class ObjectToValue {

    public static Long objectToLong(Object object){
        if(object == null){
            return null;
        }else if(object instanceof Long){
            return (Long)object;
        }else if(object instanceof Integer){
            return Long.valueOf((Integer)object);
        }
        return null;
    }

    public static Integer objectToInt(Object object){
        if(object == null){
            return null;
        }else if(object instanceof Long){
            return null;
        }else if(object instanceof Integer){
            return (Integer)object;
        }
        return null;
    }

    public static Float objectToFloat(Object object){
        if(object == null){
            return null;
        }else if(object instanceof Float){
            return (Float) object;
        }else if(object instanceof Integer){
            int temp = (Integer) object;
            float number = temp;
            return number;
        }else if(object instanceof Double){
            double temp =(Double)object;
            float number = (float)temp;
            return number;
        }
        return null;
    }

    public static String objectToString(Object object){
        if(object == null)
            return null;
        return String.valueOf(object);
    }

    public static Boolean objectToBoolean(Object object){
        if(object == null)
            return null;
        else if(object instanceof Boolean)
            return (Boolean)object;
        return null;
    }
}
