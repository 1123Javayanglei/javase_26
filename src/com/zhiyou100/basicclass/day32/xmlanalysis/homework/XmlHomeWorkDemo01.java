package com.zhiyou100.basicclass.day32.xmlanalysis.homework;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @packageName: javase_26
 * @className: XmlHomeWorkDemo01
 * @Description: TODO  xml作业
 * @author: YangLei
 * @date: 2020/4/15 7:16 下午
 */
public class XmlHomeWorkDemo01 {
    public static final String FILEPATH = "/Users/yanglei/Documents/javase_26/src/com/zhiyou100/basicclass/day32/xmlanalysis/homework/homeWork.xml";

    public static void main(String[] args) {
//        new XmlHomeWorkDemo01().setTeacher();
        new XmlHomeWorkDemo01().getTheAverageSalaryOfAllTeachers();
    }


    public void getTheAverageSalaryOfAllTeachers() {
        // TODO  获取所有老师的平均工资
        try {
            SAXReader saxReader = new SAXReader();
            Document read = saxReader.read(FILEPATH);
            // 读取xml文件获取Document

            Element rootElement = read.getRootElement();
            // 获取根标签

            List<Element> elements = rootElement.elements();
            // 获取所有的子标签

            double theTotalWagesAnd = 0;
            int cnt=0;
            for (Element e :
                    elements) {
                Element salary=e.element("salary");
                // 获取工资子标签
                double salaryTemp=Double.parseDouble(salary.getText());
                // 获取工资
                theTotalWagesAnd+=salaryTemp;
                cnt++;
            }
            System.out.println("所有老师平均工资是 "+theTotalWagesAnd/cnt);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    public void giveWomenTeachersRaise() {
        // TODO  给所有的女老师 工资+100
        try {
            SAXReader saxReader = new SAXReader();
            Document read = saxReader.read(FILEPATH);
            // 读取xml文件获取Document

            Element rootElement = read.getRootElement();
            // 获取根标签

            List<Element> elements = rootElement.elements();
            // 获取所有的子标签

            for (Element e :
                    elements) {
                Element gender = e.element("gender");
                // 获取性别子标签
                Element salary=e.element("salary");
                // 获取工资子标签
                if ("女".equals(gender.getText())){
                    // 如果性别为女
                    double salaryTemp=Double.parseDouble(salary.getText())+100;
                    // 工资加100
                    salary.setText(String.valueOf(salaryTemp));
                    // 设置工资增加100
                }
            }
            refreshXml(FILEPATH,"UTF-8",read);
            // 刷新到文件

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void delLowSalary() {
        // TODO 2 写一个方法 删除工资少于2000的Teacher标签

        try {
            SAXReader saxReader = new SAXReader();
            Document read = saxReader.read(FILEPATH);
            // 读取xml文件获取document

            Element rootElement = read.getRootElement();
            // 获取根标签
            List<Element> teacher = rootElement.elements();
            // 获取所有的Teacher标签
            for (Element e :
                    teacher) {
                Element salary = e.element("salary");
                // 获取工资标签
                double salaryTemp = Double.parseDouble(salary.getText());
                // 使用salaryTemp记录
                if (salaryTemp <= 2000) {
                    // 如果工资小于2000，则删除Teacher标签
                    rootElement.remove(e);
                    // 删除Teacher标签
                }

            }
            refreshXml(FILEPATH, "UTF-8", read);
        } catch (DocumentException e) {
            System.out.println("删除出错");
        }

    }

    public void setTeacher() {
        // TODO 写一个方法 把参数list中的所有Teacher写入一个xml文件中  根标签File  Teacher属性  name tid salary sex
//    public void setTeacher(ArrayList<XmlHomeWorkForTeacher> arrayList,String filePath){
        XmlHomeWorkForTeacher xmlHomeWorkForTeacher = new XmlHomeWorkForTeacher();
        ArrayList<XmlHomeWorkForTeacher> arrayList = xmlHomeWorkForTeacher.getArrayList();
        // 获取老师的集合

        Document document = DocumentHelper.createDocument();
        // 创建一个 document 对象
        Element file = document.addElement("File");
        // 添加一个夫标签
        for (XmlHomeWorkForTeacher x :
                arrayList) {
            // 循环遍历把老师的属性放到xml文件中
            String idTemp = x.getId();
            String nameTemp = x.getName();
            String genderTemp = x.getGender();
            String salaryTemp = String.valueOf(x.getSalary());
            // 记录属性
            Element student = file.addElement("Teacher");
            // 创建子标签Student
            student.addElement("id").setText(idTemp);
            student.addElement("name").setText(nameTemp);
            student.addElement("gender").setText(genderTemp);
            student.addElement("salary").setText(salaryTemp);
        }


        refreshXml(FILEPATH, "UTF-8", document);
        // 把更改刷新到文件中
    }

    private static void refreshXml(String fileName, String encoding, Document doc) {
        // TODO 写一个方法：把document对象刷新到xml文件中
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            //创建一个字节流关联xml文件
            OutputStreamWriter osw = new OutputStreamWriter(fos, encoding);
            //创建一个转换流关联字节流 指定编码集
            OutputFormat opf = new OutputFormat();
            opf.setEncoding(encoding);
            //创建一个OutputFormat指定xml声明区的编码集
            XMLWriter writer = new XMLWriter(osw, opf);
            //创建一个xmlwrietr方法关联字符流
            writer.write(doc);
            //使用xmlwrietr的writer方法把doc对象中的信息刷新到xml文件中
            writer.close();
        } catch (Exception e) {
            System.out.println("刷新文件出错");
        }
    }

}
