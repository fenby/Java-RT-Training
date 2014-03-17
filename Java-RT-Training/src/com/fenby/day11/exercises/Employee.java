/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day11.exercises;

public class Employee {
    private String name;
    private String idNum;
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdNum() {
        return idNum;
    }
    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age <= 18) {
            throw new IllegalArgumentException("员工年龄小于18岁");
        }
        this.age = age;
    }
    public String toString() {
        return "Name:[" + name + "], IdName:[" + idNum + "], Age:[" + age + "]";
    }
}
