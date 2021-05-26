package com.ck.xml;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 读取文件
 */
public class ReaderFile {

    public static String getFilePath(String filepath) {
        String path = ReaderFile.class.getResource("/").getPath();
        try {
            path = URLDecoder.decode(path,"UTF-8") + filepath;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return path;
    }


}
