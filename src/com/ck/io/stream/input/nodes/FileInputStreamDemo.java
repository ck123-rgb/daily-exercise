package com.ck.io.stream.input.nodes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {

    public static void main(String[] args) {

        try {
            FileInputStreamDemo demo = new FileInputStreamDemo();
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\pc\\Desktop\\12.txt");
            demo.readOne(fileInputStream,"all");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取一个字符
     * @param fileInputStream
     * @throws IOException
     */
    public void readOne(FileInputStream fileInputStream) throws IOException {
        int read = fileInputStream.read();
        fileInputStream.close();
        System.out.println((char)read);
    }

    /**
     *
     * @param fileInputStream
     * @param condition
     */
    public void readOne(FileInputStream fileInputStream,String condition) throws IOException {
        if ("all".equals(condition)) {
            int read = 0;
            String s = "";
            while ((read = fileInputStream.read()) != -1) {
                s += (char)read;
                //System.out.println((char)read);
            }
            fileInputStream.close();
            System.out.println(s);
        } else {
            readOne(fileInputStream);
        }
    }

    /**
     * 读取所有字符,按照字节数组读取
     * @param fileInputStream
     */
    public void readAll(FileInputStream fileInputStream) throws IOException {
        byte[] b = new byte[1024];
        int len = -1;
        while((len = fileInputStream.read(b)) != -1) {
            String s = new String(b);
            System.out.println(s);
        }
        fileInputStream.close();
    }
}
