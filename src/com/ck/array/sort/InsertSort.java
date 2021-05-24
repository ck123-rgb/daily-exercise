package com.ck.array.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {


        int[] arr = {10,12,2,45,3,89,12,5};
        int i, j, temp;

        // 假定第一个数已经拍好了序，从第二个数开始比价，如果比前面的数小则交换位置
        // 所以i从i开始，默认第一已经排好序
        for (i = 1; i < arr.length; i++) {
            temp = arr[i]; // 取出当前值，
            j = i;
            // 如果j大于0，并且当前数小于前一个数
            while(j>0 && temp < arr[j-1]) {
                // 如果当前数小于于前面一个数，
                // 就把前面的数赋值到当前位置，前面一个数的位置就空出来了
                // 这时当前值前面的位置就空出来了
                arr[j] = arr[j-1];
                j--; //
            }

            // 把当前值换到前面空出来的位置
            arr[j] = temp;


        }

        System.out.println(Arrays.toString(arr));
    }
}
