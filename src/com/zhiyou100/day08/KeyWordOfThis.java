package com.zhiyou100.day08;

/**
 * @author yanglei
 */
public class KeyWordOfThis {
    public static void main(String[] args) {
        WorkerTwo two = new WorkerTwo();
        two.test(1);
        System.out.println(two);
        // 打印对象的地址 com.zhiyou100.day08.WorkerTwo@1218025c

        WorkerTwo two2 = new WorkerTwo();
        System.out.println(two2);
        // 打印 com.zhiyou100.day08.WorkerTwo@816f27d
        two2.test(1);
        // 打印 com.zhiyou100.day08.WorkerTwo@816f27d
        /*
         *  out 1 当局部变量和成员变量重名时，变量名默认指向的是局部变量
         *  计算机语言的原则：就近原则
         */
    }
}
class WorkerTwo{
    int a=10;
    int b;

    public WorkerTwo() {

    }

    public void test(int a){
        System.out.println("a="+a);
        System.out.println("this.a="+this.a);
        System.out.println(this);
        // this地址 ：com.zhiyou100.day08.WorkerTwo@1218025c
        //通过this. 来指向成员变量
        //this 就是当前对象，谁调用this就是谁
    }
    public WorkerTwo(int a){
        this.a=a;
        // 把局部变量a赋值给成员变量a
    }
    public WorkerTwo(int a,int b){
        this(a);
        //构造方法互相调用 用 this(参数列表）
         this.b=b;
    }
}
