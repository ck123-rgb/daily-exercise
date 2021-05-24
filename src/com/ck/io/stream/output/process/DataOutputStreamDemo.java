package com.ck.io.stream.output.process;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DataOutputStream 类允许应用程序以与机器无关的方式将原始Java数据类型写入输出流。
 * Java应用程序通常使用数据输出流来写入数据，这些数据以后可以由数据输入流读取。
 */
public class DataOutputStreamDemo {

    public static void main(String[] args) throws FileNotFoundException {

        // writeByte会写入一个字节，writeShort也会将数据转换为字符，但是对于的部分会以空格替代
        // writeInt也会将数据转换为字符，但是对于的部分会以空格替代，这个空格会大于writeShort也会将数据转换为字符
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("C:\\Users\\pc\\Desktop\\12.txt"));
            dataOutputStream.writeInt(66);
            dataOutputStream.flush();
            dataOutputStream.close();
            System.out.println("Succcess...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
