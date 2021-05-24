package com.ck.io.stream.output.process;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * ObjectOutputStream处理流  一般用作Java对象需要序列化时的时候使用
 * 当我们需要序列化一个类到本地的时候，使用ObjectOutputStream
 *
 * 一次性只能序列化一个对象，如果要将多个对象序列化到本地，
 * 可以将对象存入list或者map集合，之后再将集合序列化到本地
 *
 */
public class ObjectOutputStreamDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        String s1 = new String();
        String s2 = new String();
        list.add(s1);
        list.add(s2);

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(""));
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
