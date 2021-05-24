package com.ck.time;

import java.util.Date;

public class TestPrintf {

    public static void main(String args[]) {
        // 初始化 Date 对象
        Date date = new Date();

        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n",date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR",date);

        /**
         * c   包括全部日期和时间信息          星期六 十月 27 14:21:20 CST 2007
         *
         * F   "年-月-日"格式                 2007-10-27
         *
         * D   "月/日/年"格式                 10/27/07
         *
         * r   "HH:MM:SS PM"格式（12时制）    02:25:51 下午
         *
         * T   "HH:MM:SS"格式（24时制）       14:28:16
         *
         * R   "HH:MM"格式（24时制）          14:28
         *
         */
    }
}
