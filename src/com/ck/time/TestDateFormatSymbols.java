package com.ck.time;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Java特使时间处理类
 */
public class TestDateFormatSymbols {

    public static final String DATE_VIP_FORMAT = "yyyyMMdd";

    public static void main(String[] args) {
        String vipStr = getVipFmt("20210109");
        System.out.println(vipStr);
        String vipStr1 = getVipStr(vipStr);
        System.out.println(vipStr1);
    }

    /**
     * 将日期对象格式化成日期字符串
     * @param targetDate 目标时间
     * @param formatStr 格式化规则
     * @return
     */
    public static String format(Date targetDate, String formatStr){
        // 如果格式化规则为空，返回null
        if (targetDate == null || "".equals(formatStr)){
            return null;
        }
        // 创建一个日期格式化类
        SimpleDateFormat sf = new SimpleDateFormat(formatStr);
        // 返回格式化之后的时间
        return sf.format(targetDate);
    }

    /**
     * 将日期字符串转换为日期类Date
     * @param strDate 日期字符创
     * @param pattern
     * @return
     */
    public static Date parse(String strDate, String pattern){
        // 创建时间格式化类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            // 将日期字符串转为日期对象
            return simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将日期转成日期字符串
     * @param date
     * @return
     */
    public static String formatVipDateStr(Date date) {
        return format(date, DATE_VIP_FORMAT);
    }

    /**
     * 将日期字符串转成日期对象
     * @param date
     * @return
     */
    public static Date parseVipDateStr(String date) {
        return parse(date, DATE_VIP_FORMAT);

    }

    /**
     * 将01MAY2019 转换为yyyyMMdd
     */
    public static String  getVipStr(String date){
        try {
            // 创建一个日期格式化类
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
            // 创建一个类DateFormatSymbols
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
            // 设置所有月份英文名称
            dateFormatSymbols.setShortMonths(new String[]{"JAN", "FEB", "MAR"
                    , "APR", "MAY", "JUN"
                    , "JUL", "AUG", "SEP"
                    , "OCT", "NOV", "DEC"});
            // 通过日期格式化类设置DateFormatSymbols
            dateFormat.setDateFormatSymbols(dateFormatSymbols);

            // 将日期字符串转换为日期对象
            Date parse = dateFormat.parse(date);
            // 将日期对象转成字符串并返回
            return formatVipDateStr(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将yyyyMMdd转为01MAY2019
     */
    public static String  getVipFmt(String dateStr){
        try {

            //获取date对象
            Date date = parseVipDateStr(dateStr);
            // 创建一个日期格式化类
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
            // 创建一个DateFormatSymbols
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
            // 设置所有的月份
            dateFormatSymbols.setShortMonths(new String[]{"JAN", "FEB", "MAR"
                    , "APR", "MAY", "JUN"
                    , "JUL", "AUG", "SEP"
                    , "OCT", "NOV", "DEC"});
            // 设置DateFormatSymbols
            dateFormat.setDateFormatSymbols(dateFormatSymbols);
            // 将日期对象转成日期字符串
            String format = dateFormat.format(date);
            return format;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
