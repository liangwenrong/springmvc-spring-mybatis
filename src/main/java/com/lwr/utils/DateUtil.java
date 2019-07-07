package com.lwr.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
    public static Date parseDate(String dateString, String pattern) {
        if(dateString==null) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

}
