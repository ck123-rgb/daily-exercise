package com.function_code.file;

import java.io.*;

/**
 * 批量修改文件名
 *
 * @AUTHOR Chen
 */
public class ChangeFileName {

    public static void main(String[] args) {

        String srcPath = "C:\\Users\\pc\\Desktop\\img";
        String targetPath = "C:\\Users\\pc\\Desktop\\img2";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        File srcFile = new File(srcPath);
        // 获取文件夹下面的所有的文件名数组
        String[] list = srcFile.list();

        for (int i = 0; i < list.length; i++) {
            try {
                // 拼接图片路径，并获取图片对应的文件流
                String filePath = srcPath + "\\" + list[i];
                String tarPath = targetPath + "\\" + (i+1) +".jpg";
                fis =  new FileInputStream(new File(filePath));
                // 在我们将文件写入的时候，如果文件不存在会自动根据文件名创建文件
                fos = new FileOutputStream(new File(tarPath));

                byte[] b = new byte[fis.available()];
                int j = -1;
                while ((j = fis.read(b)) != -1) {
                    fos.write(b);
                }
                fos.flush();
                System.out.println("赋值文件" + i+1 + "成功");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


}
