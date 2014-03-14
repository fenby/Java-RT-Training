/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day10.example02;

public abstract class Employee {
    // 员工编号
    protected int number;
    // 员工姓名
    protected String name;
    // 员工薪资（年）
    protected double salary;

    public Employee(int number, String name) {
        System.out.println("创建一个Employee对象, 编号：" + number + ", 姓名: " + name);
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    // 设置年薪资
    public void setSalary(double newSalary) {
        if (newSalary >= 0.0) {
            this.salary = newSalary;
        }
    }

    // 计算月薪资
    public double computePay() {
        return salary / 12;
    }

    public String toString() {
        return "编号: " + number + ", 姓名: " + name;
    }
}
