package com.ck.time;

import java.util.Calendar;

public class TestCalendar {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        // 获取时间
        // 赋值时年月日时分秒常用的6个值，注意月份下标从0开始，所以取月份要+1
        /*System.out.println("年："+calendar.get(Calendar.YEAR));
        System.out.println("月："+(calendar.get(Calendar.MONTH) + 1));
        System.out.println("日："+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("时："+calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("分："+calendar.get(Calendar.MINUTE));
        System.out.println("秒："+calendar.get(Calendar.SECOND));*/

        // 设置时间
        // 如果想设置为某个日期，可以一次设置年月日时分秒，由于月份下标从0开始赋值月份要-1
        // cal.set(year, month, date, hourOfDay, minute, second);
        // calendar.set(2019, 1, 15, 23, 59, 59);

        /*calendar.set(Calendar.YEAR, 2018);
        calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);*/

        // calendar.getTime() 通过calendar获取一个Date对象
        // System.out.println(calendar.getTime());

        System.out.println(calendar.getTime());

        // 计算时间
        // 第一个参数是你要计算的是年 月 日 还是 时 分 秒
        // 第二个参数是你要在现在的基础上时加还是减 正数为加 负数为减
        calendar.add(Calendar.DATE,-1);

        System.out.println(calendar.getTime());

    }

}
