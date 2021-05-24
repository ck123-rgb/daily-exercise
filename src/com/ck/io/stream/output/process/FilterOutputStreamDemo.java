package com.ck.io.stream.output.process;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

public class FilterOutputStreamDemo {
    public static void main(String[] args) {
        try {
            FilterOutputStream filterOutputStream = new FilterOutputStream(new FileOutputStream("C:\\Users\\pc\\Desktop\\12.txt"));
            String s = "Welcome to China";
            byte[] b = s.getBytes();
            filterOutputStream.write(b);
            filterOutputStream.flush();
            filterOutputStream.close();
            System.out.println("Success...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
