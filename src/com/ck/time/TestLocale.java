package com.ck.time;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class TestLocale {

    public static void main(String[] args) {

        // 获取默认的Locale
        // Locale locale = Locale.getDefault();

        // 直接使用Locale的静态对象
        // Locale locale = Locale.SIMPLIFIED_CHINESE;

        // 使用Locale的构造函数创建Locale对象
        Locale locale = new Locale("zh","CN");

        //ResourceBundle rb = ResourceBundle.getBundle("res.MessageBundle", locale);

        testDiffDateLocales();

    }



    /**
     * 2种不同的Locale的创建方法
     */
    private static void testDiffDateLocales() {
        // date为2013-09-19 14:22:30
        // Date date = new Date(113, 8, 19, 14, 22, 30);
        // 创建一个时间
        Date date = new Date();

        // 创建“简体中文”的Locale
        Locale localeCN = Locale.SIMPLIFIED_CHINESE;
        // 创建“英文/美国”的Locale
        Locale localeUS = new Locale("en", "US");

        // 获取“简体中文”对应的date字符串
        String cn = DateFormat.getDateInstance(DateFormat.MEDIUM, localeCN).format(date);
        // 获取“英文/美国”对应的date字符串
        String us = DateFormat.getDateInstance(DateFormat.MEDIUM, localeUS).format(date);

        System.out.printf("cn=%s\nus=%s\n", cn, us);
    }

    /**
     * 显示所有的Locales
     */
    private static void testAllLocales() {
        Locale[] ls = Locale.getAvailableLocales();

        System.out.print("All Locales: ");
        for (Locale locale:ls) {
            System.out.printf(locale+", ");
        }
        System.out.println();
    }
}

