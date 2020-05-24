package com.zhiyou100.javaweb.myservlet.day002;

import java.io.Serializable;

/**
 * @packageName: javase_26
 * @className: Teacher
 * @Description: TODO teacher实体类
 * @author: yang
 * @date: 2020/5/24
 */
public class Teacher implements Serializable {
    private Integer teacherId;
    private String teacherName;
    private String teacherPwd;

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPwd='" + teacherPwd + '\'' +
                '}';
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd;
    }

    public Teacher(Integer teacherId, String teacherName, String teacherPwd) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherPwd = teacherPwd;
    }
}
