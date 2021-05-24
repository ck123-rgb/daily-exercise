package com.ck.math;

/**
 * 斐波那契数列
 */
public class Fibonacci {


    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Fibonacci().fibonacciToRecursive(n));
    }

    /**
     * 使用递归的方法实现斐波那契数列
     * @param n
     * @return
     */
    public int fibonacciToRecursive(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fibonacciToRecursive(n-1) + fibonacciToRecursive(n-2);
    }

    /**
     * 使用for循环实现斐波那契数列
     * @param n
     * @return
     */
    public int fibonacciToFor(int n) {
        int[] res = {0, 1};
        if(n < 2) {
            return res[n];
        }

        int first = 0;
        int second = 1;
        int fibn = 0;
        for(int i = 2; i <= n; i++) {
            fibn = first + second;
            first = second;
            second = fibn;
        }
        // 获取当前JVM所剩下的内存
        long P1=Runtime.getRuntime().freeMemory();
        return fibn;
    }

}
