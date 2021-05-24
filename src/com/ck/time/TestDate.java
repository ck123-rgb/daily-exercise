package com.ck.time;

import java.util.Date;

public class TestDate {

    public static void main(String[] args) {
        Date date = new Date(); // 获取系统当前时间，会有默认格式化输出
        long time = date.getTime(); // 获取当前毫秒数


        long l = 1610180412000l;
        date.setTime(l); // 设置时间

        boolean before = date.before(new Date()); // 如果调用此方法的时间小于传入的时间返回true
        boolean after = date.after(new Date()); // 如果调用此方法的时间大于传入的时间返回true
        System.out.println(date);
        System.out.println(time);
        System.out.println(before);
    }
}
