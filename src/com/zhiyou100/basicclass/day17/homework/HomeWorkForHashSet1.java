package com.zhiyou100.basicclass.day17.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @packageName: javase_26
 * @className: HomeWorkForHashSet1
 * @Description: TODO 获取键盘输入的一行字符串 提供arrarlist 和 hashset 打印出字符串中各个字符出现的次数 用list装所有的字符，用set装不重复的字符
 * @author: YangLei
 * @date: 2020/3/14 4:36 下午
 */
public class HomeWorkForHashSet1 {
    public static void main(String[] args) {
        String into=getKeyboardInput();
//        String into = "aabbbccccdddddeeee";
        // 获取键盘输入
        System.out.println("字符串："+into+"中");
        ArrayList<Character> arrayList = stringToArrayList(into);
        // into 放在arrayList中
        HashSet<Character> hashSet = removeDuplicates(arrayList);
        // 去调用arrayList中重复的元素，放在hashSet
        for (Character character :
                hashSet) {
            // 遍历hashSet
            int flag = 0;
            // 记录次数
            for (Character ch :
                    arrayList) {
                // 遍历arrayList
                if (character.equals(ch)) {
                    // 如果重复了，次数+1
                    flag++;
                }
            }
            System.out.println(character + " 出现了 " + flag + "次");
        }
    }

    public static HashSet<Character> removeDuplicates(ArrayList<Character> arrayList) {
        /**
         * @name: removeDuplicates
         * @param: ArrayList<Character> arrayList
         * @date: 2020/3/14 5:33 下午
         * @return: HashSet<Character>
         * @description: TODO 去重
         */
        HashSet<Character> characters = new HashSet<>();
        for (Object object :
                arrayList) {
            characters.add(objectToCharacter(object));
        }
        return characters;
    }

    public static Character objectToCharacter(Object object) {
        /**
         * @name: ObjectToCharacter
         * @param: Object object
         * @date: 2020/3/14 4:55 下午
         * @return: Character
         * @description: TODO Objec向下转型为Character
         */
        if (object instanceof Character) {
            return (Character) object;
        }
        return null;
    }

    public static ArrayList<Character> stringToArrayList(String string) {
        /**
         * @name: stringToArrayList
         * @param: String string
         * @date: 2020/3/14 4:46 下午
         * @return: ArrayList<Character>
         * @description: TODO 把String的每个字符，放在ArrayList 中
         */
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            characters.add(string.charAt(i));
        }
        return characters;
    }

    public static String getKeyboardInput() {
        /**
         * @name: getKeyboardInput
         * @param: void
         * @date: 2020/3/14 4:39 下午
         * @return: String
         * @description: TODO 获取键盘输入的字符串
         */
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
