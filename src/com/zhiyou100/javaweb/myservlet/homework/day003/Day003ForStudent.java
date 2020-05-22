package com.zhiyou100.javaweb.myservlet.homework.day003;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;

import java.io.Serializable;

/**
 * @packageName: javase_26
 * @className: Day003ForStudent
 * @Description: TODO 学生表的实现类
 * @author: yang
 * @date: 2020/5/22
 */
public class Day003ForStudent implements Serializable {
    private Integer StudentId;
    private String StudentName;
    private String StudentGender;
    private Double StudentScore;

    @Override
    public String toString() {
        return "Day003ForStudent{" +
                "StudentId=" + StudentId +
                ", StudentName='" + StudentName + '\'' +
                ", StudentGender='" + StudentGender + '\'' +
                ", StudentScore=" + StudentScore +
                '}';
    }

    public Integer getStudentId() {
        return StudentId;
    }

    public void setStudentId(Integer studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentGender() {
        return StudentGender;
    }

    public void setStudentGender(String studentGender) {
        StudentGender = studentGender;
    }

    public Double getStudentScore() {
        return StudentScore;
    }

    public void setStudentScore(Double studentScore) {
        StudentScore = studentScore;
    }

    public Day003ForStudent(Integer studentId, String studentName, String studentGender, Double studentScore) {
        StudentId = studentId;
        StudentName = studentName;
        StudentGender = studentGender;
        StudentScore = studentScore;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 23; i++) {
            int hours= HomeWorkOfMath.randomOfMinToMax(8,10);
            // 小时8-10
            int minutes=HomeWorkOfMath.randomOfMinToMax(0,59);
            // 分钟 0-59

            int degree=36;
            int point=HomeWorkOfMath.randomOfMinToMax(5,9);
            // 度数，小数点后

            String message=hours+":"+minutes+"\t"+degree+"."+point+"\t";
            System.out.print(message);
        }



    }
}
