package com.ck.time.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateDate2 {

    public static void main(String[] args) throws ParseException {
        new CalculateDate2().testBetweenDays2();
    }

    /**
     * 计算连个日期之间相差的天数
     */
    public void testBetweenDays() throws ParseException {
        // 日期字符串
        String dateStr1 = "2018-12-27 00:00:00";
        String dateStr2 = "2018-12-31 00:00:00";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 获取日期
        Date date1 = sf.parse(dateStr1);
        Date date2 = sf.parse(dateStr2);

        // 获取相差的天数
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        long timeInMillis1 = calendar.getTimeInMillis();
        calendar.setTime(date2);
        long timeInMillis2 = calendar.getTimeInMillis();

        long betweenDays =  (timeInMillis2 - timeInMillis1) / (1000L*3600L*24L);
        System.out.println(betweenDays);
    }

    /**
     * 计算连个日期之间相差的天数
     */
    public void testBetweenDays2() throws ParseException {
        // 日期字符串
        String dateStr1 = "2018-12-27 00:00:00";
        String dateStr2 = "2018-12-31 00:00:00";

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 获取日期
        Date date1 = sf.parse(dateStr1);
        Date date2 = sf.parse(dateStr2);

        long betweenDays = (date2.getTime() - date1.getTime()) / (1000L*3600L*24L);
        System.out.println(betweenDays);
    }

}
