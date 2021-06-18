package com.ck.test;

import java.util.Map;
import java.util.Properties;

public class Test {

    public static void main(String[] args) {
        /*System.out.println("启动了");
        for (String arg : args) {  // 配置的启动时参数会出现在args数组中
            System.out.println(arg);
        }*/

        // VM options 需要以 -D 或 -X 或 -XX 开头，每个参数使用空格隔开。
        // Map<String, String> getenv = System.getenv(); // 获取所有的JVM系统参数
        //String myVMarg = System.getProperty("MyVMarg"); // 获取指定的JVM参数
        //Properties p = System.getProperties(); // 获取所有的JVM参数并将其转化为properties对象

        //System.out.println(p.getProperty("MyE"));
    }
}
