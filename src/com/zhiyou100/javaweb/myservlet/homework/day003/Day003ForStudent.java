package com.zhiyou100.javaweb.myservlet.homework.day003;

import java.io.Serializable;

/**
 * @packageName: javase_26
 * @className: Day003ForStudent
 * @Description: TODO 学生表的实现类
 * @author: yang
 * @date: 2020/5/22
 */
public class Day003ForStudent implements Serializable {
    private Integer studentId;
    private String studentName;
    private String studentGender;
    private Double studentScore;

    @Override
    public String toString() {
        return "Day003ForStudent{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentGender='" + studentGender + '\'' +
                ", studentScore=" + studentScore +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public Double getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(Double studentScore) {
        this.studentScore = studentScore;
    }

    public Day003ForStudent() {
    }

    public Day003ForStudent(Integer studentId, String studentName, String studentGender, Double studentScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentScore = studentScore;
    }
}
