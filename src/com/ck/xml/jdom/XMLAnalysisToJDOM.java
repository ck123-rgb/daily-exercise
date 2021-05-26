package com.ck.xml.jdom;

import com.ck.xml.ReaderFile;
import com.ck.xml.sax.Book;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析xml文件
 *
 * JDOM方式解析
 *
 * 特征：
 * 1、仅使用具体类，而不使用接口。
 * 2、API大量使用了Collections类。
 */
public class XMLAnalysisToJDOM {

    public static void main(String[] args) {
        String filePath = ReaderFile.getFilePath("com/ck/xml/book.xml");

        // 创建一个SAXBuilder对象
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream in;

        List<Book> booksList = new ArrayList<>();

        try {
            // 读取xml文件
            in = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(in,"UTF-8");
            // 将输入流加载到saxBuilder中
            Document document = saxBuilder.build(isr);
            // 获取xml文件的跟节点
            Element rootElement = document.getRootElement();
            // 获取跟节点下面的子节点的集合
            List<Element> children = rootElement.getChildren();

            for (Element child : children) {
                Book book = new Book();
                System.out.println("======开始解析第" + (children.indexOf(book) + 1)
                        + "书======");
                List<Attribute> attributes = child.getAttributes();
                // 知道节点下属性名称时，直接通过属性名称获取值
                // book.getAttributeValue("id");

                for (Attribute attribute : attributes) {
                    // 获取属性名
                    String attrName = attribute.getName();
                    // 获取属性值
                    String attrValue = attribute.getValue();
                    System.out.println("属性名：" + attrName + "----属性值："
                            + attrValue);
                    if (attrName.equals("id")) {
                        book.setId(attrValue);
                    }
                }

                // 对当前节点下的子节点的节点名以及节点值进行遍历
                List<Element> bookChildren = child.getChildren();
                for (Element bookChild : bookChildren) {
                    System.out.println("节点名：" + bookChild.getName() + "----节点值："
                            + bookChild.getValue());
                    if (bookChild.getName().equals("name")) {
                        book.setName(bookChild.getValue());
                    } else if (bookChild.getName().equals("author")) {
                        book.setAuthor(bookChild.getValue());
                    } else if (bookChild.getName().equals("year")) {
                        book.setYear(bookChild.getValue());
                    } else if (bookChild.getName().equals("price")) {
                        book.setPrice(bookChild.getValue());
                    } else if (bookChild.getName().equals("language")) {
                        book.setLanguage(bookChild.getValue());
                    }
                }

                System.out.println("======结束解析第" + (children.indexOf(book) + 1)
                        + "书======");
                booksList.add(book);
                book = null;
                System.out.println(booksList.size());
                System.out.println(booksList.get(0).getId());
                System.out.println(booksList.get(0).getName());


            }


        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
