package com.ck.io.stream.input.process;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * ObjectInputStreamDemo处理流  一般用作处理反序列化
 * 将序列化到本地的文件反序列化成一个类
 *
 * 一般一次性只能反序列化一个对象
 * 想反序列化多个对象，可以反序列化一个集合，再遍历这个集合中的所有对象
 *
 */
public class ObjectInputStreamDemo {

    public static void main(String[] args) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(""));
            ArrayList<String> object = (ArrayList<String>) objectInputStream.readObject();
            objectInputStream.close();
            for (String s : object) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
