package com.ck.xml.dom4j;

import com.ck.xml.ReaderFile;
import com.ck.xml.sax.Book;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 解析xml
 *
 * 使用 DOM4J方式 解析
 *
 * 特征：
 * 1、JDOM的一种智能分支，它合并了许多超出基本XML文档表示的功能。
 * 2、它使用接口和抽象基本类方法。
 * 3、具有性能优异、灵活性好、功能强大和极端易用的特点。
 * 4、是一个开放源码的文件
 */
public class XMLAnalysisToDom4j {

    private static ArrayList<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {

        String filePath = ReaderFile.getFilePath("com/ck/xml/book.xml");

        // 创建SAXReader对象
        SAXReader reader = new SAXReader();

        try {
            // 读取xml文件，并获取document对象
            Document document = reader.read(new File(filePath));
            // 获取跟节点 bookstore
            Element bookStore = document.getRootElement();
            // 获取跟节点的迭代器
            Iterator it = bookStore.elementIterator();

            // 遍历迭代器，获取跟节点中的信息
            while (it.hasNext()) {
                System.out.println("=====开始遍历某一本书=====");
                Element book = (Element) it.next(); // 获取下一个子节点独对象

                // 获取当前子节点中的所有的属性
                List<Attribute> bookAttrs = book.attributes();
                for (Attribute attr : bookAttrs) {
                    System.out.println("属性名：" + attr.getName() + "--属性值："
                            + attr.getValue());
                }

                // 获取当前子节点下面的所以的所有子节点
                Iterator<Element> itt = book.elementIterator();

                while (itt.hasNext()) {
                    Element bookChild = itt.next();
                    System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
                }
                System.out.println("=====结束遍历某一本书=====");
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
