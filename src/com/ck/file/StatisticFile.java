package com.ck.file;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Statistic 统计
 * 读取文件，按一定规则分割出单词，统计各个单词出现次数
 * 不区分单词的大小写
 */
public class StatisticFile {

    public static void main(String[] args) {

        String path = "C:\\Users\\pc\\Desktop\\word.txt";


        try {

            Map<String, Integer> map = new StatisticFile().statistic(path);
            StringBuilder str = new StringBuilder();
            for (String s1 : map.keySet()) {
                str.append(s1).append(":").append(map.get(s1)).append(" ");
                System.out.println(s1+":"+map.get(s1));
            }

            //System.out.println(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 统计字符串，默认按照空格分割
     * @param path
     * @return
     * @throws IOException
     */
    private Map<String, Integer> statistic(String path) throws IOException {
        return statistic(path," ");
    }

    /**
     * 按输入的规则分割并统计字符串
     * @param path
     * @param rules
     * @throws IOException
     */
    public Map<String,Integer> statistic(String path, String rules) throws IOException {

        // 根据文件地址读取文件并返回字符串
        String str = readerFile(path);
        // 分割字符串
        String[] strArr = str.split(rules);
        // 返回技术结果
        return count(strArr);
    }

    /**
     * 读取文件并返回一个字符串
     * @param path
     * @return
     */
    public String readerFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        // 读取文件
        StringBuilder sb = new StringBuilder();
        String s;
        while((s = br.readLine()) != null) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * 统计数组中的单词
     * @param strArr
     * @return
     */
    public Map<String, Integer> count(String[] strArr) {
        // 统计集合
        Map<String, Integer> map = new HashMap<String, Integer>();

        // 遍历所有单词
        for (String s1 : strArr) {
            // 将单词转为小写
            String key = s1.toLowerCase();
            // 不为空
            if(!"".equals(key)){
                // 当前单词出现的次数
                Integer count = map.get(key);
                // 次数等于空或0，当前单词为新单词
                if(count == null || count == 0){
                    map.put(key, 1);
                }else if(count > 0){
                    // 次数加一
                    map.put(key, count+1);
                }
            }
        }
        return map;
    }


}
