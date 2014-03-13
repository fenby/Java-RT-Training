/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day10.example01;

public class Salary extends Employee {
    // 年工资
    private double salary;

    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }

    public void mailCheck() {
        System.out.println("调用Salary的mailCheck()方法");
        System.out.println("邮寄支票给 " + getName() + " 年薪资为 " + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        if (newSalary >= 0.0) {
            salary = newSalary;
        }
    }

    public double computePay() {
        System.out.println("为用户 " + getName() + " 计算月薪资");
        return salary / 12;
    }
}
