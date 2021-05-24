package com.ck;

public class TestFor {


    public static void main(String[] args) {

            new TestFor().toFor();


    }

    public void toFor() {

        // for循环中的运行顺序
        // 1、先初始化A B且整个循环只会初始化一次
        // 2、再进行条件判断
        // 3、运行for循环中的代码块
        // 4、运行c

        // 5、再进行判断是否满足条件
        // 6、运行for循环中的代码块
        // 7、运行c
        // 以此类推

        int i = 0;
        for (getA("A"),getA("B"); getB(i); getA("C")) {
            i++;
            System.out.println(getA("D"));
            StringBuffer s = new StringBuffer().append("a");
        }

    }

    public boolean getA(String s) {
        System.out.println(s);
        return true;
    }

    public boolean getB(int i) {
        if (i < 2) {
            System.out.println("判断i");
            return true;
        }
        System.out.println("判断i");
        return false;
    }


}
