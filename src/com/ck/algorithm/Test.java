package com.ck.algorithm;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};
        int length = arr.length;
        int m = 7;
        int[] arr2 = new int[length-m];
        int[] arr3 = new int[m];
        int a = 0;

        for (int i = 0; i < length; i++) {
            if ((i + 1) <= m) {
                arr3[i] = arr[i];
            } else {
                arr2[i-m] = arr[i];
            }
        }

        for (int i = 0; i < length; i++) {
            if ((i+1) <= length - m) {
                arr[i] = arr2[i];
            } else {
                arr[i] = arr3[i-(length-m)];
            }
        }

        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr));

    }


}
