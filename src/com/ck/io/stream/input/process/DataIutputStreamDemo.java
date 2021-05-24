package com.ck.io.stream.input.process;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataIutputStreamDemo {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\pc\\Desktop\\12.txt");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            int count = dataInputStream.available();
            System.out.println(count);
            byte[] b = new byte[count];
            String s = "";
            while((count = dataInputStream.read(b)) != -1) {
                s += new String(b);
            }
            System.out.println(s);
            dataInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
