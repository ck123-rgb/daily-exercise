package com.ck.xml.sax;

import com.ck.xml.ReaderFile;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * 通过 SAX 方式解析xml文件
 * Simple APIs for XML  XML简单应用程序接口
 *
 *        优点：
 * 　　　　　　1、采用事件驱动模式，对内存耗费比较小。
 * 　　　　　　2、适用于只处理XML文件中的数据时。
 * 　　　　缺点：
 * 　　　　　　1、编码比较麻烦。
 * 　　　　　　2、很难同时访问XML文件中的多处不同数据。
 */
public class XMLAnalysisToSAX {



    public static void main(String[] args) {
        // 获取SAXFactory对象
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            // 获取文件路径
            String filePath = ReaderFile.getFilePath("com/ck/xml/book.xml");
            SAXParserHandler handler = new SAXParserHandler();
            saxParser.parse(filePath,handler);
            System.out.println("~！~！~！共有" + handler.getBookList().size()
                    + "本书");

            for (Book book : handler.getBookList()) {
                System.out.println(book.getId());
                System.out.println(book.getName());
                System.out.println(book.getAuthor());
                System.out.println(book.getYear());
                System.out.println(book.getPrice());
                System.out.println(book.getLanguage());
                System.out.println("----finish----");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
