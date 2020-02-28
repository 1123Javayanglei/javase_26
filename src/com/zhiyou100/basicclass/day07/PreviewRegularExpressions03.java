package com.zhiyou100.basicclass.day07;

/**
 * @packageName: javase_26
 * @className: PreviewRegularExpressions03
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/28 6:33 下午
 */
public class PreviewRegularExpressions03 {
    public static void main(String[] args) {
        /**
         * 复杂匹配规则
         *      匹配开头和结尾
         *          ^开头 $结尾 e.g. ^A\d{3}$ ---> A001,A380
         *
         *      匹配指定范围
         *          [....] 匹配范围内的字符
         *              1、 e.g. [123456789] -> 匹配1~9
         *              2、[1-9] :字符0~9
         *                 [a-f] :字符a~f
         *                 [A-F]:字符A~f
         *              3、[^1-9]{3} 排除法：不包含指定字符
         *      或匹配规则
         *          用 ｜ 连接的的两个正则规则是或规则 a.g. AB|BC 可以匹配 AB或BC
         *
         *      使用括号
         *          若想要匹配learn java,learn php,learn go
         *              1、learn\sjava|learn\sphp|learn\sgo
         *              2. learn\s(java|php|go) 把公共部分提出来，然后用()把子规则扩起来
         *
         */
        String re="learn\\s([jJ]ava|[Pp]hp|[Gg]o)";
        System.out.println("learn java".matches(re));
        System.out.println("learn php".matches(re));
        System.out.println("learn go".matches(re));
        System.out.println("learn Java".matches(re));
        System.out.println("learn Php".matches(re));
        System.out.println("learn Go".matches(re));
    }
}
