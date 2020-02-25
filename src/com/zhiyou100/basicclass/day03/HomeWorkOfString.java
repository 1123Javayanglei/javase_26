package com.zhiyou100.basicclass.day03;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Character.getNumericValue;

/**
 * @packageName: javase_26
 * @className: HomeWorkOfString
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/24 11:15 上午
 */
public class HomeWorkOfString {
    public static void main(String[] args) {
        String s="色情在爆炸";
        System.out.println(MyString.filterSensitiveWords(s));
    }
}

class MyString {
    public static String change(String s) {
        /**
         * @name: change
         * @param: String s
         * @description: TODO 去掉s中的所有重复元素，去掉叠词
         * @date: 2020/2/24 7:00 下午
         * @return: String
         */
        String newString = "";
        // 一个新的字符串，放s字符串中重复的值
        for (int i = 0; i < s.length(); i++) {
            // 遍历字符串
            String cnt = s.substring(i, i + 1);
            // 把每个字符串提出放在cnt中
            if (countOfParentInChild(s, cnt) >= 1) {
                // 如果在s字符串中 字串cnt出现的次数>=1,就把cnt放在newString中
                newString += cnt;
                s = s.replaceAll(cnt, ",");
                // 把s字符串中重复的值用 " ，" 替换
            }
        }
        String[] array = (newString).split(",");
        // 把newString 用"," 切片，分割成String数组
        String newFinalString = "";
        // 新建一个数组，放没有 ，号的字符串
        for (int i = 0; i < array.length; i++) {
            // 把数组中的每一个值赋给 newFinalString字符串
            newFinalString += array[i];
        }
        return newFinalString;
    }

    public static int countOfParentInChild(String father, String son) {
        /**
         * @name: countOfParentInChild
         * @param:
         * @description: TODO  判断父字符串中子字符串出现的次数
         * @date: 2020/2/24 8:19 下午
         * @return: int
         */
        int tag = 0;
        String[] array = ("," + father + ",").split(son);
        // 切片
        if (array.length - 1 != 0) {
            tag = array.length - 1;
        }
        return tag;

    }

    public static int myCompareTo(String s1, String s2) {
        /**
         * @name: myCompareTo
         * @param: String s1,String s2
         * @description: TODO 比较两个字符串,s1大 -1，s2大 1，相等 0
         * @date: 2020/2/24 6:46 下午
         * @return: int
         */
        int tag = 0;
        if (s1.length() > s2.length()) {
            // 若 1比2长
            tag = 1;
        } else if (s1.length() < s2.length()) {
            // 若 2比1长
            tag = -1;
        } else {
            // 长度一样，按编码表比较
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) > s2.charAt(i)) {
                    tag = 1;
                    break;
                } else if (s2.charAt(i) > s1.charAt(i)) {
                    tag = -1;
                    break;
                } else {
                    tag = 0;
                    continue;
                }
            }
        }
        return tag;
    }

    public static int getInt(String s) {
        /**
         * @name: getInt
         * @param: String s
         * @description: TODO 获取s中所有的数字，组成一个最大整数
         * @date: 2020/2/24 5:14 下午
         * @return: int
         */
        int[] charsArray = new int[s.length()];
        // 创建一个数组用来放提取出来的数字
        int charTag = 0;
        // 数组下标，每次加一
        for (int i = 0; i < s.length(); i++) {
            // 提取字符串中的数字到数组
            char charInString = s.charAt(i);
            if (charInString >= '0' && charInString <= '9') {
                // 找到了数字 ，放入数组，下标+1

                int a = getNumericValue((int) charInString);
                charsArray[charTag++] = a;
            }
        }

        int charNot32 = 0;
        // charNot32 是 放数字数组的大小
        for (int i = charsArray.length - 1; i >= 0; i--) {
            // 倒着找第一个非空的下标
            if (charsArray[i] != '\0') {
                charNot32 = i;
                break;
            }
        }
        Integer[] charsArrayNew = new Integer[charNot32];
        // 新建一个数组 最大下标是 charsArray的第一个空下标
        for (int i = 0; i < charNot32; i++) {
            charsArrayNew[i] = charsArray[i];
            // 把 charsArray 赋给 charsArrayNew
        }
        Arrays.sort(charsArrayNew, Comparator.reverseOrder());
        // 倒着排序
        String original = "";
        // 把数组放在字符串中
        for (int i = 0; i < charsArrayNew.length; i++) {
            original += charsArrayNew[i];
            // 拼接
        }
        if (original.length() > 10) {
            //  int max 2147483647, int min -2147483648
            System.out.println("弟弟,int 放不下 ——> int max 2147483647, int min -2147483648");
            System.exit(1);
        }
        int i = Integer.parseInt(original.trim());
        return i;
        // 转换为int
    }

    public static String delStringInOfChar(String s, char c) {
        /**
         * @name: delStringInOfChar
         * @param: String s,char c
         * @description: TODO 删除字符串S中的所有字符c
         * @date: 2020/2/24 5:09 下午
         * @return: String
         */
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                newString += s.charAt(i);
            }
        }
        return newString;
    }

    public static String flipString(String s) {
        /**
         * @name: flipString
         * @param: String s
         * @description: TODO 翻转字符串
         * @date: 2020/2/24 5:04 下午
         * @return: String
         */
        String newString = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            newString += s.charAt(i);
        }
        return newString;
    }

    public static String myTrim(String s) {
        /**
         * @name: myTrim
         * @param: String s
         * @description: TODO 返回字符串的副本，忽略前导空白和尾部空白
         * @date: 2020/2/24 4:49 下午
         * @return: String
         */
        // " " = 32
        int starterTag = 0;
        // 正数第一个非空格的下标
        int endTag = 0;
        // 倒数第一个非空格的下标
        for (int i = 0; i < s.length(); i++) {
            // 寻找 starterTag 找到就跳出
            if (s.charAt(i) != ' ') {
                starterTag = i;
                break;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            // 寻找 endTag 找到跳出
            if (s.charAt(i) != ' ') {
                endTag = i;
                break;
            }
        }
        return s.substring(starterTag, endTag + 1);
        // substring 范围是 [str,end)
    }

    public static boolean determineIfTheRegistrationWasSuccessful(String name, String pwd) {
        /**
         * @name: determineIfTheRegistrationWasSuccessful
         * @param: String name,String pwd
         * @description: TODO 判断注册是否成功，条件 -> name.length()>=6 && ((pwd.length()>=8)&&(pwd包含英文字母和数字))
         * @date: 2020/2/24 3:25 下午
         * @return: boolean
         */
        boolean nameLengthFlag = name.length() >= 6;
        // name长度
        boolean pwdLengthFlag = pwd.length() >= 8;
        // pwd长度
        boolean capitalFlag = false;
        // 大写字母
        boolean lowercaseFlag = false;
        // 小写字母
        boolean numberFlag = false;
        // 数字
        boolean finalFlag = false;
        // 是否包含 大小写字母和数字
        for (int i = 0; i < pwd.length(); i++) {
            char tempChar = pwd.charAt(i);
            boolean lowercaseFlagIn = tempChar >= 'a' && tempChar <= 'z';
            // 判断是否包含小写字母
            boolean capitalFlagIn = tempChar >= 'A' && tempChar <= 'Z';
            // 判断是否包含大写字母
            boolean numberFlagIn = tempChar >= '0' && tempChar <= '9';
            // 判断是否包含数字
            if (lowercaseFlagIn) {
                lowercaseFlag = true;
                continue;
            }
            if (capitalFlagIn) {
                capitalFlag = true;
                continue;
            }
            if (numberFlagIn) {
                numberFlag = true;
                continue;
            }
        }
        if (capitalFlag && lowercaseFlag && numberFlag) {
            finalFlag = true;
            // 若 同时包含 大、小写字母和数字，返回true
        }
        return finalFlag && nameLengthFlag && pwdLengthFlag;
    }

    public static String changeString(String s) {
        String ss = "";
        /**
         * 写一个方法，把参数字符串中大写字母转换为小写，小写转换为大写，删除字符数组
         *  遍历每个字符
         *      1.charAt
         *      2.toCharArray
         *
         *  改变
         */
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                // 如果是小写，转换为大写
                c = ((char) (s.charAt(i) - 32));
            } else if (c >= 'A' && c <= 'Z') {
                // 如果是大写，转换为大写
                c = ((char) (s.charAt(i) + 32));

            } else if (c >= '0' && c <= '9') {
                continue;
            }
            ss += c;
        }
        return ss;
    }

    public static String filterSensitiveWords(String into) {
        /**
         * @name: filterSensitiveWords
         * @param: String into
         * @description: TODO 敏感词过滤
         * @date: 2020/2/24 3:01 下午
         * @return: String
         */
        String[] stringArr = new String[5];
        stringArr[0] = "性";
        stringArr[1] = "色情";
        stringArr[2] = "爆炸";
        stringArr[3] = "恐怖";
        stringArr[4] = "枪";
        // 把敏感词放一个字符串数组
        for (String s : stringArr) {
            into = into.replace(s, getStarts(s));
        }
        // 遍历敏感词数组，替换
        return into;
    }
    public static String getStarts(String s){
        String newString="";
        for (int i = 0; i < s.length(); i++) {
            newString+="*";
        }
        return newString;
    }
}
