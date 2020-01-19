package com.zhiyou100.day09;

public class ZuoYe1 {
	public static void main(String[] args) {
	
		
	}
}	
//	1. （重载，实例变量）有以下代码：  实例变量：对象可以调用的成员变量
//	class ClassA{
	//	public void method(int value){
		//	System.out.println(value);//此处的value是局部变量
	//	}
	//	public void method(){
		//	System.out.println(value);//此处的value是成员变量
	//	}
	//	int value;
//	}
//	class TestClassA{   //测试类：有主方法的类称之为测试类
	//	public static void main(String args[]){
		//	ClassA classA = new ClassA();//创建一个对象 并起个名字 叫classa
		//	classA.value = 10;  //给对象的属性赋值
		//	classA.method();    //通过对象调用方法：无参数的method方法
		//	classA.method(20);  //通过对象调用方法：有参数的method方法
	//	}
 //	}
//	请选择正确结果：
//	A. 编译不通过
//	B. 输出10 10
//	C. 输出 10 20
//	D. 输出0 20
	
//	2. （方法重载，函数返回值）有以下代码
//	class ClassA{
//		void method(){
//			System.out.println("method()");
//		}
//		int method(int i){//编译器报错  返回值是int类型  但没有return
//			System.out.println("method(int)");
//		}
//		public static void main(String args[]){
//			ClassA a = new ClassA();
//			a.method();
//			a.method(10);
//		}
//	}
//	该程序是否能编译通过？如果可以，写出该程序运行结果。如果不能，请说明理
//	3. （构造方法）关于构造方法，下列说法正确的是：
//	A. 每个类中都有至少一个构造方法：     //如果一个类没有定义构造方法 默认有一个无参数的构造方法
//	B. 一个类中可以有多个构造方法            //构造方法可以重载：
//	C. 构造方法可以有返回值                       //构造方法的特点：1不能有返回值 不用void标示   2 方法名必须类名相同  3new 调用构造方法创建对象 4 如果一个类没有定义构造方法 默认有一个无参数的构造方法 5对象不能调用构造方法
//	D. 构造方法可以有多个参数          
//	4. （引用）有以下代码
//	class MyClass{
		//	int value;
//	}
//	public class TestRef{
		//	public static void main(String args[]){
				//	int a = 10;
				//	int b = a;
				//	b ++ ;
				//	System.out.println(a);//10
	
				//	MyClass mc1 = new MyClass();//创建一个对象并起个名字mc1
				//	mc1.value = 10;
				//	MyClass mc2 = mc1;//让引用mc2指向mc1指向的对象
				//	mc2.value ++;
				//	System.out.println(mc1.value);
		//	}
//	}
	
//	请写出编译运行后的结果。11
//	5. （引用）有以下代码
//	class ClassA{
		//	int value = 10;
//	}
//	public class TestReturnRef{
	//	public static void main(String args[]){
		//	ClassA ca = new ClassA();
		//	ca = getObject();//让ca指向getObject方法返回的对象
		//	ca = getObject();
		//	ca = getObject();
		//	System.out.println(ca.value);
	//	}
	//如果方法定义时  没加static  方法必须被对象来调用
	//如果方法定义时  加了static   可以在main方法中直接调用
	//	public static ClassA getObject(){//返回值类型是ClassA 此方法应该返回一个ClassA类型的对象
		//	ClassA newObject = new ClassA();
		//	newObject.value += 10;
		//	return newObject;
	//	}
//	}
//	编译运行TestReturnRef 程序，结果为：
//	A. 编译出错
//	B. 输出10
//	C. 输出20
//	D. 输出40
//	6. （构造函数）有以下代码
//	class MyClass{
		//	int value;
//	}
//	public class TestMyClass{
	//	public static void main(String args[]){
		//	MyClass mc1 = new MyClass();
		//	MyClass mc2 = new MyClass(10);//没有参数是int的构造方法  只有一个无参数的构造方法
		//	System.out.println(mc1.value);
		//	System.out.println(mc2.value);
	//	}
//	}
//	问：这个程序能否编译通过？如果可以，输出结果是什么？如果不可以，则应该
//	如何修改？
	
//	7. （面向对象基础）根据注释，把下面代码补充完整
//	//定义一个Dog 类
//	class Dog{
		//	//定义一个name 属性，该属性为String 类型
		//	String name;
		//	//定义一个age 属性，该属性为int 类型
		//	int age;
		//	//定义一个sexual 属性，该属性为boolean 类型
		//	//true 表示为公，false 表示为母
		//	booleab sexual;
		//	public Dog(){}
		//	public Dog(String name, int age, boolean sexual){
		//	     //分别根据参数，设置Dog 类的属性:::拿参数列表给成员变量赋值
	              //this.name=name;this.age=age;this.sexual=sexual;
	
		//	}
		//	public void play(){
				//	System.out.println(this.name + “ play”);
		//	}
		//	public void play(int n){
				//	System.out.println(name + “ play ” + n + “ minutes”);
		//	}
//	}
//	public class TestDog{
		//	public static void main(String args[]){
				//	Dog d;//定义一个引用名d
				//	//创建一个Dog 对象，利用带参数的构造函数
				//	//名字为joy，年龄为2 岁，性别为母
				//	d=new Dog("joy",2,false);
				//	//调用Dog 对象无参的play 方法。
				//	d.play();
				//	//调用Dog 对象有参的play 方法，参数为30
				//	d.play(30);
		//	}
//	}
//	8. *（对象创建过程）有以下代码
//	class ClassA{
	//	public ClassA(){
		//	System.out.println("ClassA()");
	//	}
//	}
//	class ClassB{
	//	public ClassB(){
		//	System.out.println("ClassB()");
	//	}
//	}
//	class ClassC{
	//	ClassA a = new ClassA();//定义一个成员变量a
	//	ClassB b ;//所有的成员变量都有默认初始值  基本数据类型默认初始值是对应类型的0 boolean是false  引用数据类型是null
	//	public ClassC(){
		//	System.out.println("ClassC()");
		//	b = new ClassB();
	//	}
//	}
//	public class TestConstructor{
	//	public static void main(String args[]){
		//	ClassC cc = new ClassC();
	    //  创建一个ClassC类型的对象c：
	    //    对象c有属性a 给a属性赋值 要创建一个ClassA类型的对象  要调用ClassA的构造方法   
	    //    在执行ClassC构造方法时  有打印输出语句：System.out.println("ClassC()");
	    //    在执行ClassC构造方法时  b = new ClassB();  
	//	}
//	}
//	请选择正确答案：
//	A. 编译不通过
//	B. 输出ClassA() ClassB() ClassC()
//	C. 输出 ClassA() ClassC() ClassB()
//	D. 输出 ClassC() ClassB() ClassA()
	
//	9. *（引用，方法参数传递）有以下代码
//	class ClassA{
		//	int value;
//	}
//	public class TestClassA{
	//	public static void main(String args[]){
			//	int value = 10;
			//	changeInt(value);//把value的值复制一份 给了changeInt方法中的局部变量val
			//	System.out.println(value);
	
			//	ClassA ca = new ClassA();
			//	ca.value = 10;
	
			//	changeObject(ca);               //给ca指向的对象又起个名字ca2
			//	System.out.println(ca.value);   //
	//	}
	//	public static void changeInt(int val){
			//	val++;
	//	}
	//	public static void changeObject(ClassA ca2){
			//	ca2.value++;
	//	}
//	}
//	编译运行TestClassA 时，结果是
//	A. 编译出错
//	B. 输出 10 11
//	C. 输出 10 10
//	D. 输出 11 11
//	10. *（构造函数，this 关键字）程序改错
//	public class Student{
	//	int age;
	//	String name;
	//	public void Student(){}//普通方法
	//	void init(){
		//	age = 10;
		//	name = "limy";
	//	}
	//	public Student(String name){
		//	this.init();
		//	this.name = name;
	//	}
	//	public Student(String name, int age){
        //  this(name);//调用构造方法：：：：
		//	this.init();
		//	this.age = age;
	//	}
//	}
	//Student s1=new Student("韩梅梅");
	//Student s2=new Student("韩梅梅",11);
