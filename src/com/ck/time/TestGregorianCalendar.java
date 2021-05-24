package com.ck.time;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestGregorianCalendar {

    public static void main(String args[]) {

        int year;
        // 初始化 Gregorian 日历
        // 使用当前时间和日期
        // 默认为本地时间和时区
        GregorianCalendar gcalendar = new GregorianCalendar();
        // 显示当前时间和日期的信息
        System.out.println("年：" + gcalendar.get(Calendar.YEAR));
        System.out.println("月：" + (gcalendar.get(Calendar.MONTH) + 1));
        System.out.println("日：" + gcalendar.get(Calendar.DATE));

        System.out.println("时：" + gcalendar.get(Calendar.HOUR));
        System.out.println("分：" + gcalendar.get(Calendar.MINUTE));
        System.out.println("秒：" + gcalendar.get(Calendar.SECOND));

        year = gcalendar.get(Calendar.YEAR);

        // 测试当前年份是否为闰年
        if(gcalendar.isLeapYear(year)) {
            System.out.println("当前年份是闰年");
        }
        else {
            System.out.println("当前年份不是闰年");
        }
    }
}
