package com.ck.io.other;

import java.io.Console;

/**
 * Java Console类用于从控制台获取输入。它提供了读取文本和密码的方法。
 *
 * 如果您使用Console类读取密码，则不会向用户显示该密码。
 */
public class ConsoleDemo {

    public static void main(String[] args) {
        Console console = System.console();
        System.out.println("请输入姓名：");
        String name = console.readLine();
        System.out.println("Welcome " + name);
    }
}
