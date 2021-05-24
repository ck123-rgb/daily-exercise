package com.ck.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestSimpleDateFormat {

    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        String datestr = "2021-01-09 18:25:56";

        // 按照自己的需求来格式化时间
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        // ft.setTimeZone(); // 设置时区

        Date parse = ft.parse(datestr); // 将时间字符串转换为日期对象

        // 设置格式化模板
        // 可以通过构造方法设置格式化模板，也可以通过applyPattern();方法设置
        // 一但通过applyPattern();方法设置，那么通过构造方法设置的日期模板就会被替换
        ft.applyPattern("yyyy:MM:dd HH:mm:ss");

        System.out.println(ft.format(date));
        /*System.out.println(date.getTime());
        System.out.println(parse.getTime());*/

        /**
         * y     年
         * M     年中的月份
         * D     年中的天数
         * d     月份中的天数
         * H     一天中的小时数（0-23）
         * h     am/pm 中的小时数（1-12）
         * m     小时中的分钟数
         * s     分钟中的秒数
         * S     毫秒数
         */

    }
}
