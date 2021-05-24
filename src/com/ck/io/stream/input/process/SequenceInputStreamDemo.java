package com.ck.io.stream.input.process;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;

/**
 * Sequence 序列化
 * SequenceInputStream 序列化流，
 * 用于从多个流中读取数据 。它是按顺序读取数据的（也就是逐一读取）。
 * 一次只能放入两个流
 */
public class SequenceInputStreamDemo {

    public static void main(String[] args) {
        try {
            SequenceInputStreamDemo demo = new SequenceInputStreamDemo();
            FileInputStream f1 = new FileInputStream("C:\\Users\\pc\\Desktop\\12.txt");
            FileInputStream f2 = new FileInputStream("C:\\Users\\pc\\Desktop\\word.txt");
            SequenceInputStream sequenceInputStream = new SequenceInputStream(f1,f2);
            demo.readOne(sequenceInputStream,"byte");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 一次性  读取一个字节
     * @param sequenceInputStream
     * @throws IOException
     */
    public void readOne(SequenceInputStream sequenceInputStream) throws IOException {
        int len = 0;
        String s = "";
        while ((len = sequenceInputStream.read()) != -1) {
            s += (char)len;
        }
        sequenceInputStream.close();
        System.out.println(s);
    }

    /**
     * 根据类型，一次性读取
     * @param sequenceInputStream
     * @param type
     */
    public void readOne(SequenceInputStream sequenceInputStream,String type) throws IOException {
        int available = sequenceInputStream.available();
        System.out.println(available);
        byte[] b = new byte[available];
        String s = "";
        if ("byte".equals(type)) {
            while ((available = sequenceInputStream.read(b)) != -1) {
                s += new String(b);
            }
            sequenceInputStream.close();
            System.out.println(s);
        } else if ("int".equals(type)) {
            readOne(sequenceInputStream);
        }
    }


}
