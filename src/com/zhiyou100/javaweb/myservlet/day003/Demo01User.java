package com.zhiyou100.javaweb.myservlet.day003;

/**
 * @packageName: javase_26
 * @className: Demo01User
 * @Description: TODO  tab_user表的实现类
 * @author: yang
 * @date: 2020/5/21
 */
public class Demo01User {
    private Integer userId;
    private String userName;
    private String userPwd;
    private String userGender;
    public Integer userScore;

    public Demo01User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "Demo01User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userScore='" + userScore + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Demo01User(Integer userId, String userName, String userPwd, String userGender, Integer userScore) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userGender = userGender;
        this.userScore = userScore;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }
}
