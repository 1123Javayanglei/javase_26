package com.zhiyou100.basicclass.day14;

/**
 * @packageName: javase_26
 * @className: Pdf11
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/10 5:58 下午
 */
// class TestThrow{
//    public static void main(String[] args){
//        throwException(10);
//    }
//    public static void throwException(int n){
//        if (n == 0){
////抛出一个 NullPointerException
//            throw new NullPointerException();
//        }else{
////抛出一个 ClassCastException
////并设定详细信息为"类型转换出错"
//            throw new ClassCastException("类型转换出错");
//        }
//    }
//}

//import java.io.*;
//import java.sql.*;
//class TestException{
//    public static void main(String[] args){
//        System.out.println("main 1");
//        int n=5;
////读入 n
//        ma(n);
//        System.out.println("main2");
//    }
//    public static void ma(int n){
//        try{
//           System.out.println("ma1");
//            mb(n);
//            System.out.println("ma2");
//        }catch(EOFException e){
//            System.out.println("Catch EOFException");
//        }catch(IOException e){
//            System.out.println("Catch IOException");
//        }catch(SQLException e){
//            System.out.println("Catch SQLException");
//        }catch(Exception e){
//            System.out.println("Catch Exception");
//        }finally{
//            System.out.println("I n finally");
//        }
//    }
//    public static void mb(int n) throws Exception{
//        System.out.println("mb1");
//        if (n == 1) {
//            throw new EOFException();
//        }
//        if (n == 2) {
//            throw new FileNotFoundException();
//        }
//        if (n == 3) {
//            throw new SQLException();
//        }
//        if (n == 4) {
//            throw new NullPointerException();
//        }
//        System.out.println("mb2");
//        // 前面已经抛出了，不需要执行
//    }
//}
//class MyException1 extends Exception {
//    // 已检查异常
//
//    public MyException1() {
//    }
//
//    public MyException1(String message) {
//        super(message);
//    }
//}
//
//class MyException2 extends RuntimeException {
//    // 未检查异常
//
//    public MyException2() {
//    }
//
//    public MyException2(String message) {
//        super(message);
//    }
//}

//class TestMyException {
//    public static void main(String[] args) {
//        int n=1;
////读入 n
//        try {
//            m(n);
//        } catch (MyException1 ex1) {
////输出 ex1 详细的方法调用栈信息
//            ex1.printStackTrace();
//        } catch (MyException2 ex2) {
////输出 ex2 的详细信息
//            ex2.printStackTrace();
////并把 ex2 重新抛出
//            throw ex2;
//        }
//    }
//
//    public static void m(int n) throws MyException1 { //声明抛出 MyException1
//        if (n == 1) {
////抛出 MyException1
////并设定其详细信息为"n == 1"
//            throw new MyException1("n == 1");
//        } else {
////抛出 MyException2
////并设定其详细信息为"n == 2"
//            throw new MyException2("n == 2");
//        }
//    }
//}

//class MyException extends Throwable {
//}
//
//class TestException {
//    public static void main(String args[]) {
//        ma();
//    }
//
//    public static int ma() {
//        try {
//            m();
//            return 100;
//        } catch (ArithmeticException e) {
//            System.out.println("ArithmeticException");
//        } catch (Exception e) {
//            System.out.println("Exception");
//        } catch (MyException e) {
//            System.out.println("MyException");
//        }
//        return 0;
//    }
//
//    public static void m() throws MyException {
//        throw new MyException();
//    }
//}
//    }
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//class Super{
//    public void ma() throws IOException{}
//}
//interface IA{
//    void mb();
//}
//class MySub extends Super implements IA{
//    @Override
//    public void ma() throws IOException {
//        super.ma();

//    @Override
//    public void mb(){
//}
//}
// }

//import java.io.*;
//import java.sql.*;
// class TestTryCatch{
//    public static void main(String args[]){
//        try{
//            ma(10);
//            System.out.println("No Exception");
//        }
//        catch(EOFException ex1){
//            System.out.println("ex1");
//        }
//        catch(IOException ex2) {
//            System.out.println("ex2");
//        }
//        catch(SQLException ex3) {
//            System.out.println("ex3");
//        }
//    }
//    public static void ma(int n) throws Exception{
//        if (n == 1){
//            throw new IOException();
//        }else if (n == 2){
//            throw new EOFException();
//        }else if (n == 3) {
//            throw new SQLException();
//        }
//    }
//}


//class TestTryCatch {
//    public static void main(String args[]) {
//        System.out.println(ma());
//    }
//
//    public static int ma() {
//        int n=0;
//        try {
//            n = 10 / 0;
//        } catch (Exception e) {
//        }
//        return n;
//    }
//}

// class TestFinally {
//    public static void main(String args[]) {
//        System.out.println(ma());
//    }
//
//    public static int ma() {
//        int b=0;
////读入 b
//        try {
//            int n = 100;
//            return n / b;
//        } catch (Exception e) {
//            return 10;
//        } finally {
//            return 100;
//        }
//    }
//}

// class TestTryFinally{
//    public static void main(String[] args){
//        try{
//            ma();
//        }catch(Exception ex1){
//        }
//    }
//    public static void ma() throws Exception {
//        int n = 10;
//        int b=0;
////读入一个整数 b
//        try{
//            System.out.println("ma1");
//            int result = n / b;
//            System.out.println("ma2 " + result);
//        }finally{
//            System.out.println("In Finally");
//        }
//    }
//}

//import java.io.*;
//class MySuper{
//    public void m() throws IOException{}
//}
//class MySub extends MySuper{
//    @Override
//    public void m() throws EOFException, FileNotFoundException {}
//}
//class MySub2 extends MySub {
//    @Override
//    public void m() throws FileNotFoundException{}
//}