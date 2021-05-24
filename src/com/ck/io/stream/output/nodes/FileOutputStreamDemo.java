package com.ck.io.stream.output.nodes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream为节点流，直接与数据源连接，读入或读出
 */
public class FileOutputStreamDemo {

    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\pc\\Desktop\\12.txt"));
            String s = "Welcome to China";
            //fileOutputStream.write(65);
            fileOutputStream.write(s.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            System.out.println("SUCCESS......");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
