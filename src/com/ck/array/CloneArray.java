package com.ck.array;

import java.util.Arrays;

public class CloneArray {

    // 克隆数组
    public static void main(String[] args) {

        new CloneArray().toClone();

    }

    /**
     * 使用clone方法clone数组
     */
    public void toClone() {
        int[] a1 = {1, 3};
        int[] a2 = a1.clone();

        a1[0] = 666;
        System.out.println(Arrays.toString(a1));   //[666, 3]
        System.out.println(Arrays.toString(a2));   //[1, 3]
    }

    /**
     * 通过System.arraycopy复制数组
     * （原数组， 原数组的开始位置， 目标数组， 目标数组的开始位置， 拷贝个数）
     */
    public void toArrayCopy() {

        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = new int[10];

        System.arraycopy(a1, 1, a2, 3, 3);
        System.out.println(Arrays.toString(a1)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(a2)); // [0, 0, 0, 2, 3, 4, 0, 0, 0, 0]
    }

    /**
     * 通过Arrays.copyOf拷贝数组
     * （原数组，拷贝的个数）
     * 其底层使用的还是System.arraycopy()
     */
    public void toCopyOf() {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = Arrays.copyOf(a1, 3);

        System.out.println(Arrays.toString(a1)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(a2)); // [1, 2, 3]
    }

    /**
     * 使用Arrays.copyOfRange复制数组
     * （原数组，开始位置，拷贝的个数）
     * 其底层使用的还是System.arraycopy()
     */
    public void toCopyOfRange() {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = Arrays.copyOfRange(a1, 0, 1);

        System.out.println(Arrays.toString(a1)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(a2)); // [1]
    }

}
