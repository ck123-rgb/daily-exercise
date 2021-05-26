package com.ck.xml.dom;

import com.ck.xml.ReaderFile;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * 解析xml格式的文件
 *
 * DOM解析
 *
 * 一次性把整个xml文件读取，组装成一颗DOM数，通过节点与节点之间的关系进行解析。
 *        优点：
 * 　　　　　　1、形成了树结构，有助于更好的理解、掌握，且代码容易编写。
 * 　　　　　　2、解析过程中，树结构保存在内存中，方便修改。
 *
 * 　　　　缺点：
 * 　　　　　　1、由于文件是一次性读取，所以对内存的耗费比较大。
 * 　　　　　　2、如果XML文件比较大，容易影响解析性能且可能会造成内存溢出。
 */
public class XMLAnalysisToDOM {

    public static void main(String[] args) {
        String filePath = "com/ck/xml/book.xml";
        // 获取文件路径
        String xmlFilePath = ReaderFile.getFilePath(filePath);
        // 创建一个DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // 创建一个DocumentBuilder对象
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 读取xml文件
            Document document = builder.parse(xmlFilePath);
            // 获取所有的book节点
            NodeList bookList = document.getElementsByTagName("book");
            System.out.println("一共有" + bookList.getLength() + "本书");

            // 遍历每一个节点
            for (int i = 0; i < bookList.getLength(); i++) {
                System.out.println("=================下面开始遍历第" + (i + 1) + "本书的内容=================");
                // 获取一个book节点
                Node book = bookList.item(i);
                // 获取一个book节点的所有的属性
                NamedNodeMap attrs = book.getAttributes();
                System.out.println("第" + (i+1) + "本书共有" + attrs.getLength() + "个属性");

                for (int j = 0; j < attrs.getLength(); j++) {
                    // 获取这个节点的某一个属性
                    Node attr = attrs.item(j);

                    System.out.println("属性名：" + attr.getNodeName());
                    System.out.println("属性值：" + attr.getNodeValue());
                }

                // 获取当前节点下的所有的子节点
                NodeList childNodes = book.getChildNodes();

                System.out.println("第" + (i+1) + "本书共有" + childNodes.getLength() + "个字节点");

                for (int k = 0; k < childNodes.getLength(); k++) {
                    // 区分出text类型的node以及element类型的node
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        //获取了element类型节点的节点名
                        System.out.print("第" + (k + 1) + "个节点的节点名：" + childNodes.item(k).getNodeName());
                        //获取了element类型节点的节点值
                        System.out.println("--节点值是：" + childNodes.item(k).getFirstChild().getNodeValue());
                        //System.out.println("--节点值是：" + childNodes.item(k).getTextContent());
                    }
                }

                System.out.println("======================结束遍历第" + (i + 1) + "本书的内容=================");
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
