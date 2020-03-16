package com.zhiyou100.basicclass.day18.pdf10collection;

/**
 * @packageName: javase_26
 * @className: Pdf10Collection
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/16 4:15 下午
 */

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;
import com.zhiyou100.basicclass.day15.collectionDemo.CollectionDemo01;
import edu.princeton.cs.algs4.In;
import jdk.swing.interop.LightweightContentWrapper;

import java.net.CookieHandler;
import java.sql.Blob;
import java.util.*;

//class TestList {
//    public static void main(String args[]) {
//        List list = new Vector();
//        list.add("Hello");
//        list.add("World");
//        list.add(1, "Learn");
//        list.add(1, "Java");
//        printList(list);
//    }
//
//    public static void printList(List list) {
//        for (Object l :
//                list) {
//            System.out.println(l);
//        }
//    }
//}

// class TestList{
//    public static void main(String args[]){
//        List list = new ArrayList();
//        list.add("Hello");
//        list.add("World");
//        list.add("Hello");
//        list.add("Learn");
//        list.remove("Hello");
//        list.remove(0);
//        for(int i = 0; i<list.size(); i++){
//            System.out.println(list.get(i));
//        }
//    }
//}


//

//class Worker {
//    private int age;
//    private String name;
//    private double salary;
//
//    public Worker() {
//    }
//
//    public Worker(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public void work() {
//        System.out.println(name + "work");
//    }
//
//    @Override
//    public String toString() {
//        return name+" "+age+" "+salary;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//}
//class Text5{
//    public static void main(String[] args) {
//        List<Worker> list = new ArrayList<Worker>();
//        list.add(new Worker("zhang3",18,3000));
//        list.add(new Worker("1i4",25,3500));
//        list.add(new Worker("wang5",22,3200));
//        list.add(1,new Worker("zhao6",24,3300));
//        list.remove(3);
//        for (Worker worker :
//                list) {
//            System.out.println(worker);
//        }
//        System.out.println("================");
//        Iterator<Worker> integer=list.iterator();
//        while (integer.hasNext()){
//            System.out.println(integer.next());
//        }
//    }
//}


//class Worker{
//    String name;
//    int age;
//    double salary;
//    public Worker(){}
//    public Worker(String name, int age, double salary){
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
//    }
//    // 重写方法，范围修饰符只能变大，不能变小，从 public 变为 default，范围变小了
//    @Override
//    public int hashCode(){
//        return (int) (name.hashCode() + age + salary);
//        // double 转为int可能会精度丢失
//    }
//    public boolean equals(Worker w){
//        if (w.name == name && w.salary == salary && w.age == age){
//            return true;
//        }else {
//            return false;
//        }
//    }
//}
// class TestWorker{
//    public static void main(String args[]){
//        Set set = new HashSet();
//        set.add(new Worker("tom", 18, 2000));
//        set.add(new Worker("tom", 18, 2000));
//        set.add(new Worker("jerry", 18, 2000));
//        // hashSet没有下标，是无序的
//        System.out.println(set.size());
//    }
//}

//class Worker{
//    private String name;
//    private int age;
//    private double salary;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public Worker(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
//    }
//
//    @Override
//    public int hashCode() {
//        return 1;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        try {
//            Worker worker=(Worker)obj;
//            return worker.name.equals(this.name) || (worker.age == this.age) || (worker.salary == this.salary);
//            // 若名字，年龄，工资有一项相同，则不放进HashSet
//        }catch (Exception e){
//            return false;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return name+" "+age+" "+salary;
//    }
//}
//class Text8{
//    public static void main(String[] args) {
//        HashSet<Worker> workers = new HashSet<>();
//        for (int i = 0; i < 10; i++) {
//            Worker worker=new Worker("杨磊"+i%3,19,50);
//            System.out.println(worker);
//            workers.add(worker);
//        }
//        System.out.println("===============");
//        for (Worker wo :
//                workers) {
//            System.out.println(wo);
//        }
//    }
//}


//class Worker implements Comparator<Worker> {
//    private String name;
//    private int age;
//    private double salary;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public Worker() {
//    }
//
//    public Worker(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
//    }
//
//    @Override
//    public int hashCode() {
//        return 1;
//    }
//
//    @Override
//    public int compare(Worker o1, Worker o2) {
//
//        if ((o1.getAge() != o2.getAge())) {
//            // 如果年龄不相同
//            return (o1.getAge() > o2.getAge()) ? 1 : -1;
//        } else {
//            if (o1.getSalary() != o2.getSalary()) {
//                // 如果收入不相同
//                return (o1.getSalary() > o2.getSalary()) ? 1 : -1;
//            } else {
//                // 收入和年龄都相同
//                // 如果此字符串按字典顺序小于字符串参数，则返回一个小于 0 的值；如果此字符串按字典顺序大于字符串参数，则返回一个大于 0 的值。
//                return o1.getName().compareTo(o2.getName());
//            }
//
//        }
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        try {
//            Worker worker = (Worker) obj;
//            return worker.name.equals(this.name) || (worker.age == this.age) || (worker.salary == this.salary);
//            // 若名字，年龄，工资有一项相同，则不放进HashSet
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return name + " " + age + " " + salary;
//    }
//}
//
//class Text9 {
//    public static void main(String[] args) {
//        TreeSet<Worker> workers = new TreeSet<>(new Worker());
//        workers.add(new Worker("zhang3", 18, 1500));
//        workers.add(new Worker("li4", 18, 1500));
//        workers.add(new Worker("wang5", 18, 1600));
//        workers.add(new Worker("zhao6", 17, 2000));
//
//        for (Worker wo :
//                workers) {
//            System.out.println(wo);
//        }
//    }
//}

//class TheWorldCupChampions {
//    public static void main(String[] args) {
//        intoBallTeamOutWinYearList();
//    }
//
//    static void intoBallTeamOutWinYearList() {
//        String in = new Scanner(System.in).next();
//        // 读入一个字符串
//        HashMap<Integer, WorldCupDate> integerWorldCupDateHashMap = centuryCupChampionshipDatabase();
//        // 创建一个hashMap，内容是世界杯数据库
//        Set<Map.Entry<Integer, WorldCupDate>> entries = integerWorldCupDateHashMap.entrySet();
//        // 创建一个个entrySet
//        boolean wineFlag = false;
//        // 记录是否获得过世界杯子
//        for (Map.Entry<Integer, WorldCupDate> en :
//                entries) {
//            String value = en.getValue().champion;
//            // 获得世界杯国家名字
//            if (value.equals(in)) {
//                // 判断是否获得，若获得则跳出
//                wineFlag = true;
//                break;
//            }
//        }
//        if (wineFlag) {
//            // 如果获得，遍历输出
//            for (Map.Entry<Integer, WorldCupDate> entry :
//                    entries) {
//                if (entry.getValue().champion.equals(in)) {
//                    System.out.print(entry.getKey() + " ");
//                }
//            }
//        } else {
//            // 如果没有获得，安慰一下
//            System.out.println(in + " 没有获得过世界杯");
//        }
//
//    }
//
//    static void exportTheWorldCupWinnersInTheNextYear() {
//        int in = new Scanner(System.in).nextInt();
//        // 输入一行字符串
//        HashMap<Integer, WorldCupDate> integerWorldCupDateHashMap = centuryCupChampionshipDatabase();
//        // 获取数据库
//        if (integerWorldCupDateHashMap.containsKey(in)) {
//            System.out.println(in + " 这一年的世界杯冠军是" + integerWorldCupDateHashMap.get(in).champion);
//        } else {
//            System.out.println("没有举办世界杯");
//        }
//    }
//
//    static HashMap<Integer, WorldCupDate> centuryCupChampionshipDatabase() {
//        /**
//         * @name: centuryCupChampionshipDatabase
//         * @param: void
//         * @date: 2020/3/16 9:24 下午
//         * @return:
//         * @description: TODO 1930-2006 年的世界杯举办年份，次数和冠军
//         */
//        HashMap<Integer, WorldCupDate> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put(1930, new WorldCupDate("1", "1930", "乌拉圭"));
//        stringStringHashMap.put(1934, new WorldCupDate("2", "1934", "意大利"));
//        stringStringHashMap.put(1938, new WorldCupDate("3", "1938", "意大利"));
//        stringStringHashMap.put(1950, new WorldCupDate("4", "1950", "乌拉圭"));
//        stringStringHashMap.put(1954, new WorldCupDate("5", "1954", "德国"));
//        stringStringHashMap.put(1958, new WorldCupDate("6", "1958", "巴西"));
//        stringStringHashMap.put(1962, new WorldCupDate("7", "1962", "巴西"));
//        stringStringHashMap.put(1966, new WorldCupDate("8", "1966", "苏格兰"));
//        stringStringHashMap.put(1970, new WorldCupDate("9", "1970", "巴西"));
//        stringStringHashMap.put(1974, new WorldCupDate("10", "1974", "德国"));
//        stringStringHashMap.put(1978, new WorldCupDate("11", "1978", "阿根廷"));
//        stringStringHashMap.put(1982, new WorldCupDate("12", "1982", "意大利"));
//        stringStringHashMap.put(1986, new WorldCupDate("13", "1986", "阿根廷"));
//        stringStringHashMap.put(1990, new WorldCupDate("14", "1990", "德国"));
//        stringStringHashMap.put(1994, new WorldCupDate("15", "1994", "巴西"));
//        stringStringHashMap.put(1998, new WorldCupDate("16", "1998", "法国"));
//        stringStringHashMap.put(2002, new WorldCupDate("17", "2002", "巴西"));
//        stringStringHashMap.put(2006, new WorldCupDate("18", "2006", "意大利"));
//        return stringStringHashMap;
//    }
//}
//
//class WorldCupDate {
//    String theNumberOf;
//    String year;
//    String champion;
//
//    @Override
//    public String toString() {
//        return theNumberOf + " " + year + " " + champion;
//    }
//
//    public WorldCupDate(String theNumberOf, String year, String champion) {
//        this.theNumberOf = theNumberOf;
//        this.year = year;
//        this.champion = champion;
//    }
//}


//class Map12{
//    public static void main(String[] args) {
//        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        // 1 录入
//        stringStringHashMap.put("Tom","CoreJava");
//        stringStringHashMap.put("John","Oracle");
//        stringStringHashMap.put("Susan","Oracle");
//        stringStringHashMap.put("Jerry","JDBC");
//        stringStringHashMap.put("Jim","Unix");
//        stringStringHashMap.put("Kevin","JSP");
//        stringStringHashMap.put("Lucy","JSP");
//        // 2 添加
//        stringStringHashMap.put("Allen","JDBC");
//        // 3 改,覆盖
//        stringStringHashMap.put("Lucy","CoreJava");
//        // 4 遍历 输出所有的老师及老师教授的课程
//        Set<Map.Entry<String, String>> entries = stringStringHashMap.entrySet();
//        for (Map.Entry<String,String> entry :
//                entries) {
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }
//        System.out.println("=============");
//        // 5 输出所有觉JSP的老师
//        for (Map.Entry<String, String> entry:
//        entries){
//            if ("JSP".equals(entry.getValue())){
//                System.out.println("教JSP的老师是 "+entry.getKey());
//            }
//        }
//    }
//}

//class MyClass{
//    int value;
//    public MyClass(){}
//    public MyClass(int value){ this.value = value; }
//    @Override
//    public String toString(){
//        return " "+value;
//    }
//}
// class TestList{
//    public static void main(String args[]){
//        MyClass mc1 = new MyClass(10);
//        MyClass mc2 = new MyClass(20);
//        MyClass mc3 = new MyClass(30);
//        List list = new ArrayList();
//        list.add(mc1);
//        list.add(mc2);
//        list.add(mc3);
//        MyClass mc4 = (MyClass) list.get(1);
//        mc4.value = 50;
//        for(int i = 0; i<list.size(); i++){
//            System.out.println(list.get(i));
//        }
//    }
//}


//class Student {
//    int age;
//    String name;
//    public Student(){}
//    public Student(String name, int age){
//        this.name = name;this.age = age;
//    }
//    @Override
//    public int hashCode(){
//        try {
//            return name.hashCode() + age;
//            // null没有hashCode方法
//        }catch (Exception e){
//            return 0;
//        }
//    }
//    @Override
//    public boolean equals(Object o){
//        if (o == null) {
//            return false;
//        }
//        if (o == this) {
//            return true;
//        }
//        if (o.getClass() != this.getClass()) {
//            return false;
//        }
//        Student stu = (Student) o;
//        if (stu.name.equals(name) && stu.age == age) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//}
// class TestHashSet{
//    public static void main(String args[]){
//        Set set = new HashSet();
//        Student stu1 = new Student();
//        Student stu2 = new Student("Tom", 18);
//        Student stu3 = new Student("Tom", 18);
//        set.add(stu1);
//        set.add(stu2);
//        set.add(stu3);
//        System.out.println(set.size());
//    }
//}

//class Address{
//    private String addressName;
//
//    public String getAddressName() {
//        return addressName;
//    }
//
//    public void setAddressName(String addressName) {
//        this.addressName = addressName;
//    }
//
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public Address(String addressName, String zipCode) {
//        this.addressName = addressName;
//        this.zipCode = zipCode;
//    }
//
//    private String zipCode;
//}
//class Worker{
//    @Override
//    public String toString() {
//        return name+" "+age+" "+salary+" "+address.getAddressName()+" "+address.getZipCode();
//    }
//
//    private String name;
//    private int age;
//
//    public Worker(String name, int age, double salary, Address address) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
//        this.address = address;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    private double salary;
//    private Address address;
//
//    @Override
//    public boolean equals(Object obj) {
//        try {
//            Worker worker=(Worker)obj;
//            boolean nameFlag= worker.getName().equals(this.getName());
//            boolean ageFlag=worker.getAge()==this.getAge();
//            boolean salaryFlag=worker.getSalary()==this.getSalary();
//            boolean addressNameFlag=worker.address.getAddressName().equals(this.address.getAddressName());
//            boolean zipCodeFlag=worker.address.getZipCode().equals(this.address.getZipCode());
//            return nameFlag && ageFlag && salaryFlag && addressNameFlag && zipCodeFlag;
//        }catch (Exception e){
//            return false;
//        }
//    }
//
//    @Override
//    public int hashCode() {
//        return 1;
//    }
//}
//class Text17{
//    public static void main(String[] args) {
//        HashSet<Worker> workers = new HashSet<>();
//        workers.add(new Worker("杨磊",18,50,new Address("中国","1234")));
//        workers.add(new Worker("杨磊",18,50,new Address("中国","1234")));
//        workers.add(new Worker("杨磊",18,50,new Address("中国","1234")));
//        workers.add(new Worker("杨磊",18,50,new Address("中国","1234")));
//        workers.add(new Worker("杨磊",18,50,new Address("中国","1234")));
//        workers.add(new Worker("杨磊",18,50,new Address("中国","1234")));
//        workers.add(new Worker("杨磊",12,50,new Address("中国","1234")));
//
//        for (Worker worker :
//                workers) {
//            System.out.println(worker);
//        }
//
//    }
//}

//class Account {
//    private static long tempId=1;
//    private long id;
//
//    public static long getTempId() {
//        return tempId;
//    }
//
//    public static void setTempId(long tempId) {
//        Account.tempId = tempId;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    private double balance;
//    private String password;
//
//    public Account(double balance, String password) {
//        this.balance = balance;
//        this.password = password;
//        id = tempId++;
//    }
//
//    public Account() {
//        id++;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "Account{" + "id=" + id+
//        ",balance=" + balance +
//                ", password='" + password + '\'' +
//                '}';
//    }
//}
//
//class Text19 {
//    public static void main(String[] args) {
//        ArrayList<Account> arrayList = new ArrayList<Account>();
//        Account account = new Account(10.00, "1234");
//        Account account1 = new Account(15.00, "5678");
//        Account account2 = new Account(0, "1010");
//
//        arrayList.add(account);
//        arrayList.add(account1);
//        arrayList.add(account2);
//
//        HashMap<Integer, Account> objectObjectMap = new HashMap<>();
//        for (int i = 0; i < arrayList.size(); i++) {
//            objectObjectMap.put((int) arrayList.get(i).getId(),arrayList.get(i));
//        }
//        Set<Map.Entry<Integer, Account>> entries = objectObjectMap.entrySet();
//        for (Map.Entry<Integer, Account> entry:
//        entries){
//            System.out.println("Id="+entry.getKey()+" ,balance"+entry.getValue().getBalance());
//        }
//    }
//}

//class Text20{
//    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("Hello");
//        strings.add("World");
//        strings.add("Learn");
//        System.out.println("倒叙前");
//        for (String st :
//                strings) {
//            System.out.println(st);
//        }
//        System.out.println("倒叙后");
//        reverseList(strings);
//    }
//    static void reverseList(ArrayList<String> arrayList){
//        for (int i = arrayList.size()-1; i>=0 ; i--) {
//            // 倒着遍历
//            System.out.println(arrayList.get(i));
//        }
//    }
//}

//class MyKey{
//    int keyValue;
//    public MyKey(){}
//    public MyKey(int value){this.keyValue = value;}
//}
//class MyValue{
//    String value;
//    public MyValue(){}
//    public MyValue(String value){this.value = value;}
//    @Override
//    public String toString(){return value;}
//}
// class TestMap{
//    public static void main(String args[]){
//        Map map = new HashMap();
//        MyKey key1 = new MyKey(10);
//        map.put(key1, new MyValue("abc"));
//        map.put(new MyKey(10), new MyValue("cde"));
//        System.out.println(map.get(key1));
//        System.out.println(map.size());
//    }
//}

//class Worker{
//    private static long tempId=1;
//    private final long id;
//    public long getId() {
//        return id;
//    }
//
//    private String name;
//    private int age;
//    private double salary;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public Worker(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
//        id=tempId++;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//       try {
//           Worker worker=(Worker)o;
//           if (worker.id!=this.id){
//               // 如果id不相等
//               return false;
//           }else {
//               return true;
//           }
//       }catch (Exception e){
//           return false;
//       }
//    }
//
//    @Override
//    public int hashCode() {
//        return (int) (name.hashCode()+age+salary+id);
//    }
//
//    @Override
//    public String toString() {
//        return name+" "+age+" "+salary;
//    }
//}

//class Student{
//    private String name;
//    private int age;
//    private double score;
//    private String classNum;
//
//    public Student(String name, int age, double score, String classNum) {
//        this.name = name;
//        this.age = age;
//        this.score = score;
//        this.classNum = classNum;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public double getScore() {
//        return score;
//    }
//
//    public void setScore(double score) {
//        this.score = score;
//    }
//
//    public String getClassNum() {
//        return classNum;
//    }
//
//    public void setClassNum(String classNum) {
//        this.classNum = classNum;
//    }
//}
//class Text23{
//    public static void main(String[] args) {
//        ArrayList<Student> list = new ArrayList<>();
//        list.add(new Student("Tom", 18, 100, "class05"));
//        list.add(new Student("Jerry", 22, 70, "class04"));
//        list.add(new Student("Owen", 25, 90, "class05"));
//        list.add(new Student("Jim", 30,80 , "class05"));
//        list.add(new Student("Steve", 28, 66, "class06"));
//        list.add(new Student("Kevin", 24, 100, "class04"));
//        System.out.println("所有学生的平均年龄是 "+allYearCnt(list));
//        allClassCnt(list);
//    }
//    static int allYearCnt(ArrayList<Student> list){
//        /**
//         * @name: allYearCnt
//         * @param:
//         * @date: 2020/3/17 2:24 上午
//         * @return:
//         * @description: TODO 计算平均年龄
//         */
//        int cnt=0;
//        for (int i = 0; i < list.size(); i++) {
//            cnt+=list.get(i).getAge();
//        }
//        return cnt/list.size();
//    }
//    static void allClassCnt(ArrayList<Student> list){
//        int class04=0;
//        int class04Num=0;
//        int class05=0;
//        int class05Num=0;
//        int class06=0;
//        int class06Num=0;
//        for (int i = 0; i < list.size(); i++) {
//            if ("class04".equals(list.get(i).getClassNum())){
//                class04++;
//                class04Num+=list.get(i).getScore();
//            }else if ("class05".equals(list.get(i).getClassNum())){
//                class05++;
//                class05Num+=list.get(i).getScore();
//            }else {
//                class06++;
//                class06Num+=list.get(i).getScore();
//            }
//        }
//        System.out.println("class4 的平均成绩是"+class04Num/class04);
//        System.out.println("class5 的平均成绩是"+class05Num/class05);
//        System.out.println("class6 的平均成绩是"+class06Num/class06);
//    }
//}


class Text24 {
    public static void main(String[] args) {
        // 科特迪瓦，阿根廷，澳大利亚，塞尔维亚，荷兰，尼日利亚、日本，美国，中国， 新西兰，巴西，比利时，韩国，喀麦隆，洪都拉斯，意大利
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "意大利");
        map.put(1, "科特迪瓦");
        map.put(2, "阿根廷");
        map.put(3, "澳大利亚");
        map.put(4, "塞尔维亚");
        map.put(5, "荷兰");
        map.put(6, "尼日利亚");
        map.put(7, "日本");
        map.put(8, "美国");
        map.put(9, "中国");
        map.put(10, "新西兰");
        map.put(11, "巴西");
        map.put(12, "比利时");
        map.put(13, "韩国");
        map.put(14, "喀麦隆");
        map.put(15, "洪都拉斯");
        int arr[] = Cai(16);
        System.out.println("第一组：");
        for (int i = 0; i <= 3; i++) {
            System.out.print(map.get(arr[i]) + " ");
        }
        System.out.println();
        System.out.println("第二组:");
        for (int i = 4; i <= 7; i++) {
            System.out.print(map.get(arr[i]) + " ");
        }
        System.out.println();

        System.out.println("第三组:");
        for (int i = 8; i <= 11; i++) {
            System.out.print(map.get(arr[i]) + " ");
        }
        System.out.println();

        System.out.println("第四组:");
        for (int i = 12; i <= 15; i++) {
            System.out.print(map.get(arr[i]) + " ");
        }

    }

    static int[] Cai(int num) {
        // 生成 [0,num-1]的不重复的数组
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = HomeWorkOfMath.randomOfMinToMax(0, num-1);
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }
        return arr;
    }
}