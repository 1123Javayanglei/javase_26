package com.zhiyou100.basicclass.day32.xmlanalysis;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @packageName: javase_26
 * @className: HomeWorksForXml
 * @Description: TODO 作业：写一个xml 存储所有的学生：学生属性name sex score  id 读取xml获取分数最高的学生的id
 * @author: YangLei
 * @date: 2020/4/14 10:32 下午
 */
public class HomeWorksForXml {
    private static final String FILE_PATH = "/Users/yanglei/Documents/javase_26/src/com/zhiyou100/basicclass/day32/xmlanalysis/student.xml";
    // 文件的位置

    public static void main(String[] args) {
        Element elements = getDocument(FILE_PATH).getRootElement();
        // 获取根节点

        HashMap<String, String> stringHashMap = new HashMap<>();
        //  创建一个hashMap记录id和成绩
        List<Element> elements1 = elements.elements();
        // 获取所有节点
        for (Element e :
                elements1) {
            Element id = e.element("id");
            Element score = e.element("score");
            // 获取id和score字段的文本
            stringHashMap.put(id.getText(), score.getText());
            // 存储数据
        }

        String maxId ="";
        int maxScore=0;
        // 记录最大成绩和id
        Set<Map.Entry<String, String>> entries = stringHashMap.entrySet();
        for (Map.Entry<String, String> entry :
                entries) {
            String id= (entry.getKey());
            int score=Integer.parseInt(entry.getValue());
            if (score>=maxScore){
                // 找到成绩最高的人
                maxScore=score;
                maxId=id;
            }
        }

        System.out.println("分数最高的学生的id是:"+maxId+" 分数是"+maxScore);


    }

    public static Element getElement(String s) {
        // TODO 取得某节点的单个子节点
        Element elements = getElements();
        return elements.element(s);
    }

    public static Element getElements() {
        // TODO 获取文档的根节点
        Document document = getDocument(FILE_PATH);
        assert document != null;
        return document.getRootElement();
    }

    public static Document getDocument(String fileName) {
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
}
