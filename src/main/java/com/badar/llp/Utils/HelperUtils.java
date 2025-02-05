package com.badar.llp.Utils;

public class HelperUtils {
    public static <T> Boolean isNull(T param){
        return param == null;
    }

    public static <T> Boolean isNotNull(T param){
        return param != null;
    }
}
