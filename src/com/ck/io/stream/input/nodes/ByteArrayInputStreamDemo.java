package com.ck.io.stream.input.nodes;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamDemo {

    public static void main(String[] args) {

        ByteArrayInputStreamDemo demo = new ByteArrayInputStreamDemo();
        byte[] b = {35, 36, 37, 38};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
        int k = 0;
        while ((k = byteArrayInputStream.read()) != -1) {
            // 将字节转换为字符
            char ch = (char)k;
            System.out.println("ASCII value of Character is:" + k + "; Special character is: " + ch);
        }
    }
}
