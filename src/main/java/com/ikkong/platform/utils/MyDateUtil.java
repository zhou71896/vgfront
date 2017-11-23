package com.ikkong.platform.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class MyDateUtil {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static java.text.SimpleDateFormat dateSdf = new SimpleDateFormat("yyyyMMdd");
    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";
    // 日期格式化
    private static DateFormat dateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);

    /**
     * @Author: zry
     * @Update: 添加获取当前时间
     * @param;  * @param null
     * @Description: yyyy-MM-dd
     * @Date: 10:57 2017/10/20 0020
     */

    public static Date getNowDate(){
        return getDateFormat(dateFormat.format(new Date()));
    }

    /**
     * @Author: zry
     * @Update: 添加获取当前时间
     * @param;  * @param null
     * @Description:
     * @Date: 10:57 2017/10/20 0020
     */

    public static Date getDateFormat(String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
