package com.ck.io.stream.output.nodes;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {

    public static void main(String[] args) {

        try {
            ByteArrayOutputStreamDemo demo = new ByteArrayOutputStreamDemo();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileOutputStream f1 = new FileOutputStream("C:\\Users\\pc\\Desktop\\12.txt");
            FileOutputStream f2 = new FileOutputStream("C:\\Users\\pc\\Desktop\\新建流程请求参数.txt");
            demo.write(byteArrayOutputStream,f1,f2);
            System.out.println("SUCCESS......");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将数据写入文件中，可以写入多个文件中
     * @param byteArrayOutputStream
     * @param fileOutputStreams
     * @throws IOException
     */
    public void write(ByteArrayOutputStream byteArrayOutputStream, FileOutputStream... fileOutputStreams) throws IOException {
        String str = "测试ByteArrayOutputStream流";
        byteArrayOutputStream.write(str.getBytes()); // 将数据写入ByteArrayOutputStream流

        // 通过ByteArrayOutputStream将数据写入具体的文件字节流
        for (FileOutputStream fileOutputStream : fileOutputStreams) {
            byteArrayOutputStream.writeTo(fileOutputStream);
        }
        byteArrayOutputStream.close();

    }
}
