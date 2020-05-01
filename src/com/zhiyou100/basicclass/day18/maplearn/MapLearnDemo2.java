package com.zhiyou100.basicclass.day18.maplearn;

import com.zhiyou100.basicclass.day17.homework.HomeWorkForHash;
import com.zhiyou100.basicclass.day17.homework.HomeWorkForHashSet1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @packageName: javase_26
 * @className: MapLearnDemo2
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/16 11:43 上午
 */
public class MapLearnDemo2 {
    public static void main(String[] args) {
        HashMap<Character, Integer> characterIntegerHashMap =getNumber();
        Set<Entry<Character, Integer>> entries = characterIntegerHashMap.entrySet();
        for (Entry<Character, Integer> entry :
                entries) {
            System.out.println(" "+entry.getKey()+" 出现了"+entry.getValue()+"次数");
        }
    }
    static HashMap<Character,Integer> getNumber(){
        /**
         * @name: getNumber
         * @param: void
         * @date: 2020/3/16 4:03 下午
         * @return: HashMap<Character,Integer>
         * @description: TODO 获取键盘输入的一行字符串，记录每个字符出现的次数
         */
        String in=HomeWorkForHashSet1.getKeyboardInput();
        // 从键盘获取一个输入
        // 根据in 创建一个set
        HashSet<Character> hashSet=HomeWorkForHashSet1.removeDuplicates(HomeWorkForHashSet1.stringToArrayList(in));
        // 创建map
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (Character c :
                hashSet) {
            int number = 0;
            // 记录次数
            for (int i = 0; i < in.length(); i++) {
               number+=c.equals(in.charAt(i))?1:0;
               // 是否相等
            }
            characterIntegerHashMap.put(c,number);
            // c是键，次数是值
        }
        return characterIntegerHashMap;
    }
}
