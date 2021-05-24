package com.ck.array.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {10,12,2,45,3,89,12,5};
        int temp = 0;

        // 需要进行 length-1 次冒泡
        // 外层循环控制冒泡的次数
        for (int i = 0; i < arr.length-1; i++) {

            // 内层循环，控制要换的次数
            // 当外层每循环一次，数组中的排序就进行了一次，
            // 就相当于已经排出了一个顺序，所以减去i，会减少很多次的循环（不减去i，代码不会出错）
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }

        System.out.println(Arrays.toString(arr));

    }

}
