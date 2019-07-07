package com.lwr.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class IdGenerateUtil{
    private static Random ra =new Random(); 
    
    public static Serializable generate(){
        String dateString = DateUtil.formatDate(new Date(), "yyyyMMddHHmmssSSS");
        int num = ra.nextInt(899)+100;
        return dateString + String.valueOf(num);
    }
    
}
