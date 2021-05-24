package com.ck.string.encryption;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.UUID;

/**
 * 字符串加密
 */
public class StringEncrypte {

    /**
     * MD5和SHA1加密
     * @param input 要加密的字符串
     * @param type MD5或者SHA1类型
     * @return
     */
    public static String stringEncrypt(String input, String type) {
        try {
            // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
            MessageDigest messageDigest =MessageDigest.getInstance(type);
            // 输入的字符串转换成字节数组
            byte[] inputByteArray = input.getBytes();
            // inputByteArray是输入字符串转换得到的字节数组
            messageDigest.update(inputByteArray);
            // 转换并返回结果，也是字节数组，包含16个元素
            byte[] resultByteArray = messageDigest.digest();
            // 字符数组转换成字符串返回
            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    //下面这个函数用于将字节数组换成16进制的字符串
    public static String byteArrayToHex(byte[] byteArray) {
        // 首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };
        // new一个字符数组，这个就是用来组成结果字符串的
        // （解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））

        char[] resultCharArray =new char[byteArray.length * 2];

        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b& 0xf];
        }
        // 字符数组组合成字符串返回

        return new String(resultCharArray);
    }

    /**
     * 将字符串加入盐值后进行加密
     * @param password 原密码
     * @param salt 盐值
     * @return 返回加密后的字符串
     */
    public static String  getEncryptStr(String password, String salt) {

        //加密之后的密码
        String encryptPwd = null;

        //加密的次数
        int encryptCount = 256;
        String type = "MD5";
        //加密后的字符串，原密码加上盐值
        encryptPwd = password + salt;
        for (int i = 0; i < encryptCount; i++) {
            encryptPwd = StringEncrypte.stringEncrypt(encryptPwd, type);
        }

        return encryptPwd;
    }

    /**
     * 获取一段随机的字符串
     * 盐值
     */
    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("\\-", "").toUpperCase();

    }

}