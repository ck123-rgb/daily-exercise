package com.ck.time.practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 计算两个日期之间相差多少天
 */
public class CalculateDate {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String []args) throws Exception{
        String first = "2017-9-2";
        String second = "2017-9-3";
        Date firstdate = format.parse(first);
        Date seconddate = format.parse(second);
        int cnt = longOfTwoDate(firstdate, seconddate);
        System.out.println(cnt);
    }

    public static int longOfTwoDate(Date first, Date second) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(first);
        int cnt = 0;

        // compareTo()方法比较
        // a1 > a2为正数  a1 < a2为负数  a1 = a2为0
        while (calendar.getTime().compareTo(second) != 0) {
            calendar.add(Calendar.DATE, 1); // 没循环一个日期加上一天
            cnt++; // 计算天数加上一
        }
        return cnt;
    }

}
