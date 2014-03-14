/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day10.example03;

public class AbstractDemo {
    public static void main(String[] args) {

        Employee e1 = new Sales(10, "Macy Zhao");
        Sales s1 = new Sales(11, "Jack Lee");

        /* 以下是不允许的，会引发错误 */
        // Employee e2 = new Employee(12, "Tina Zhang");

        e1.setSalary(120000);
        s1.setSalary(180000);
        // e2.setSalary(90000);

        System.out.println(e1.toString() + ", 月薪为: " + e1.computePay());
        System.out.println(s1.toString() + ", 月薪为: " + s1.computePay());
        // System.out.println(e2.toString() + ", 月薪为: " + e2.computePay());
    }
}