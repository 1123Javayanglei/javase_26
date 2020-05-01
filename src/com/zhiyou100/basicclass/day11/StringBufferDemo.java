package com.zhiyou100.basicclass.day11;

/**
 * @packageName: javase_26
 * @className: StringBufferDemo
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/6 10:46 上午
 */
/**
 * StringBuffer : 普通方法
 *  1.添加：StringBuffer append(Object obj) 把参数对象的字符串形式添加到当前字符串缓冲区序列后面
 *  2.删除 StringBuffer delete(int start,int end) 删除从start开始到end-1处的字符
 *  3.删除 StringBuffer deleteCharAt(int index) 删除参数下标处的字符
 *  4.替换 StringBuffer replace(int start,int end,String str) 使用str替换从start开始到end-1处的字符
 *  5.翻转 StringBuffer	reverse() 翻转字符串
 *  6.修改 void setCharAt(int index,char ch) 修改index下标处的字符为ch
 *
 * 和String相同的普通方法：
 *  char charAt(int index) 获取参数下标对应的字符
 *  int indexOf(String str) 获取参数字符串第一次出现的位置，找不到返回-1
 *  int indexOf(String str,int fromIndex) 从formIndex下标处开始找，找不到返回-1
 *  int length() 获取字符个数
 *  String	substring(int start) 截取：从start下标到最后一个下标
 *  String	substring(int start,int end) 截取：从start下标到end-1处的下标
 *
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        // 构造方法
        StringBuffer stringBuffer1 = new StringBuffer("abcdefg123456");
        // 带参参数的构造方法
        System.out.println(stringBuffer1);
        // out abcdefg123456
        StringBuffer stringBuffer2 = new StringBuffer();
        // 无参数的构造方法
        System.out.println(stringBuffer2);
        // out

        System.out.println("===========");

        // 特有的普通方法
        stringBuffer1.append("XYZ");
        // 添加
        System.out.println(stringBuffer1);
        // out abcdefg123456XYZ

        stringBuffer1.delete(stringBuffer1.length()-2,stringBuffer1.length()+1);
        // 删除 (start,end-1) 下标的字符
        System.out.println(stringBuffer1);
        // out abcdefg123456X

        stringBuffer1.deleteCharAt(stringBuffer1.length()-1);
        // 删除下标对应的字符
        System.out.println(stringBuffer1);
        // out abcdefg123456

        stringBuffer1.replace(stringBuffer1.length()-6,stringBuffer1.length()+1,"这是一些数字");
        // 用str 替换 （start,end]
        System.out.println(stringBuffer1);
        // out abcdefg这是一些数字

        stringBuffer1.reverse();
        // 翻转
        System.out.println(stringBuffer1);
        // out 字数些一是这gfedcba

        stringBuffer1.setCharAt(0,'我');
        // 修改
        System.out.println(stringBuffer1);
        // out 我数些一是这gfedcba


        System.out.println((int)('A'));
        System.out.println((int)('a'));
        System.out.println((char) ('A'+32));

        String string="1234ABC,,abc";
        System.out.println(changeString(string));


    }
    static String changeString(String string){
        /**
         * @name: changeString
         * @param: String string
         * @date: 2020/3/6 5:04 下午
         * @return: String
         * @description: TODO 字符串大写转小写，小写转大写，数字删除
         */
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < stringBuilder.length(); i++) {
            char temp=stringBuilder.charAt(i);
            if (Character.isUpperCase(temp)){
                // 判断是不大写
                stringBuilder.setCharAt(i,(char) (temp+32));
            }else if (Character.isLowerCase(temp)){
                // 判断是不是小写
                stringBuilder.setCharAt(i,(char) (temp-32));
            }else if (Character.isDigit(temp)){
                // 判断是不是数字
                stringBuilder.deleteCharAt(i);
                i--;
                // 下标要-1
            }
        }
        string= String.valueOf(stringBuilder);
        return string;
    }
}
