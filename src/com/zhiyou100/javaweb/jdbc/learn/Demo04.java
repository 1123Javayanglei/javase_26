package com.zhiyou100.javaweb.jdbc.learn;

import java.util.Date;

/**
 * @author yanglei
 */
public class Demo04 {
    public static void main(String[] args) {

    }

    /**
     * @name: addOne
     * @param:
     * @date: 2020/5/14 4:47 下午
     * @return:
     * @description: TODO
     */
    public static void addOne() {
    }
}

class MyDate {
    private final int id;
    private final Date day;
    private final Date time;
    private final Date dayTime;

    @Override
    public String toString() {
        return "MyDate{" +
                "id=" + id +
                ", day=" + day +
                ", time=" + time +
                ", dayTime=" + dayTime +
                '}';
    }

    public MyDate(int id, Date day, Date time, Date dayTime) {
        this.id = id;
        this.day = day;
        this.time = time;
        this.dayTime = dayTime;
    }
}