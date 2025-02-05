package com.badar.llp.Utils;

public class HelperUtils {
    public <T> Boolean isNull(T param){
        return param == null;
    }

    public <T> Boolean isNotNull(T param){
        return param != null;
    }
}
