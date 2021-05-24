package com.ck.io.stream.output.process;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedOutputStream 为缓存流（处理流），
 * 它在内部使用缓冲区存储数据。与将数据直接写入流相比，
 * 它提高了效率。因此，它可以提高性能。
 *
 * 因为BufferedOutputStream为处理流不直接与数据源进行连接，
 * 所有它还需要一个节点流来让它处理
 */
public class BufferedOutputStreamDemo {

    public static void main(String[] args) {
        try {
            BufferedOutputStreamDemo demo = new BufferedOutputStreamDemo();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\pc\\Desktop\\12.txt"));
            demo.writeString(bufferedOutputStream,"这是新写入的字符串");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将字符串写入本地
     * @param bufferedOutputStream
     * @param str
     * @throws IOException
     */
    public void writeString(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        byte[] bytes = str.getBytes();
        //System.out.println("str字节==》" + Arrays.toString(bytes));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    /**
     * 将字节写入
     * @param bufferedOutputStream
     * @param b
     * @throws IOException
     */
    public void writeByte(BufferedOutputStream bufferedOutputStream, byte b) throws IOException {
        bufferedOutputStream.write(b);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    /**
     * 将int类型数据写入本地
     * @param bufferedOutputStream
     * @param b
     * @throws IOException
     */
    public void writeInt(BufferedOutputStream bufferedOutputStream, int b) throws IOException {
        bufferedOutputStream.write(b);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }
}


