package com.ck.algorithm.fibonacci;

/**
 * 斐波拉契数列
 *
 * 通项公式 F0 = 0 F1 = 1 Fn = F(n-1) + F(n-2)
 */
public class Fibonacci {

    /**
     * 使用递归方法计算斐波拉契数列
     * @param n
     * @return
     */
    public int toRecursion(int n) {

        if (n < 2 && n >0) {
            return n;
        }

        return toRecursion(n-1) + toRecursion(n-2);
    }

    /**
     *
     * @param n
     * @return
     */
    public int toFor(int n) {

        if (n < 0) {

        }

        if (n <2 && n >0) {
            return 1;
        }

        int first = 1;
        int second = 1;
        int fibo = 0;

        for (int i = 3; i <= n; i++) {
            fibo = first + second;
            first = second;
            second = fibo;
        }

        return fibo;

    }

}
