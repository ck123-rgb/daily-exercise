package com.ck.io.stream.input.process;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * BufferedInputStream 缓存流（处理流）
 *
 * 当跳过或读取流中的字节时，内部缓冲区自动从包含的输入流中重新填充，一次填充多个字节
 *
 * 创建BufferedInputStream时，将创建一个内部缓冲区数组
 *
 */
public class BufferedInputStreamDemo {

    public static void main(String[] args) {

        try {
            BufferedInputStreamDemo demo = new BufferedInputStreamDemo();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\pc\\Desktop\\12.txt"));
            demo.readOne(bufferedInputStream,"all");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 一次读取一个字节
     * @param bufferedInputStream
     * @throws IOException
     */
    public void readOne(BufferedInputStream bufferedInputStream) throws IOException {
        int read = 0;
        String s = "";
        while ((read=bufferedInputStream.read()) != -1) {
            s += (char)read;
        }
        System.out.println(s);
    }

    /**
     * 一次性读取固定长度的btye数组，数据
     * @param bufferedInputStream
     * @param condition
     * @throws IOException
     */
    public void readOne(BufferedInputStream bufferedInputStream, String condition) throws IOException {
        if ("all".equals(condition)) {
            // 读取资源1中有多少个字节
            int available = bufferedInputStream.available();
            System.out.println(available);
            byte[] bytes = new byte[available];
            String s = "";
            while ((available = bufferedInputStream.read(bytes)) != -1) {
                s += new String(bytes);
            }
            System.out.println(s);
        } else {
            readOne(bufferedInputStream);
        }

    }

}
