package com.zhiyou100.basicclass.day32.xmlanalysis;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @packageName: javase_26
 * @className: XmlAnalysisDemo01
 * @Description: TODO Demo4j 读取xml常用方法
 * @author: YangLei
 * @date: 2020/4/14 7:26 下午
 */
public class XmlAnalysisDemo01 {
    private static final String FILE_NAME = "/Users/yanglei/Documents/javase_26/src/com/zhiyou100/basicclass/day32/xmlanalysis/text.xml";

    public static void main(String[] args) {
        showXml(FILE_NAME);
    }

    private static void readXml() {
        /*
         * @date: 2020/4/14 10:04 下午
         * @description: TODO read
         */
        Document document = xml2Doc(FILE_NAME);
        // 根据xml文件获取document对象
        Element rootElement = document.getRootElement();
        // 获取根标签
        List<Element> elements = rootElement.elements();
        // 不加参数，获取所有的子标签
        elements=rootElement.elements("Student");
        // 获取根标签下载的所有Student子标签
        for (Element e :
                elements) {
            List<Attribute> attributes = e.attributes();
            // 获取所有的属性
            for (Attribute att :
                    attributes) {
//                System.out.println(att);
            }
            Attribute name = e.attribute("name");
            // 获取指定的属性
            System.out.println(name.getName()+"::"+name.getValue());
            // 获取属性名和属性的值
            System.out.println(e.attributeValue("name"));
            // 获取指定的属性的值
            System.out.println("文本内容="+e.getText());
        }

    }

    public static Document xml2Doc(String fileName) {
        /*
         * @date: 2020/4/14 10:05 下午
         * @description: TODO 读取xml文件获取document对象
         */

        SAXReader saxReader = new SAXReader();
        // 创建一个SaxReader对象
        try {
            return saxReader.read(fileName);
        } catch (DocumentException e) {
            System.out.println("读取xml文件失败");
            return null;
        }
    }
    public static void showXml(String fileName){
        /*
         * @date: 2020/4/14 10:13 下午
         * @description: TODO 遍历指定的xml文件
         */
        Document document = xml2Doc(fileName);
        // 根据xml文件获取document对象
        Element rootElement = document.getRootElement();
        // 获取根标签
        showElement(rootElement);
    }

    private static void showElement(Element rootElement) {
        /*
         * TODO 对参数element对象进行递归操作
         */
        System.out.println("遍历标签 "+rootElement.getName());

        List<Attribute> attributes = rootElement.attributes();
        // 获取标签的属性
        if (attributes!=null&&attributes.size()!=0){
            // 如果attributes不为空或者size不等于0
            for (Attribute attribute:
                 attributes) {
                System.out.println(rootElement.getName()+" 标签的属性："+attribute.getName()+" = "+attribute.getValue() );
            }
        }


        List<Element> elements = rootElement.elements();
        // 获取子标签
        if (elements==null&&elements.size()==0){
            System.out.println("标签 "+rootElement.getName()+" 文本的内容: "+rootElement.getText());
            // 获取标签的文本内容
            return;

        }
        for (Element e :
                elements) {
            showElement(e);
            // 遍历子标签
        }
        System.out.println();
        // 换行

    }

}
