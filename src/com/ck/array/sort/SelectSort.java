package com.ck.array.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {10,12,2,45,3,89,12,5};

        // 外层循环每循环一个，就往前面排出一个最小值
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            // j的值比i要大1,因为外层每循环一个，就会排好一个数，再从0开始没有意义
            for (int j = i+1; j < arr.length; j ++) {
                if (arr[j]<arr[min])
                    min=j;
            }
            // 如果min和i是同一个值就没有更换的必要了
            if (min!=i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
