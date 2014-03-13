/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day10.example02;

public class AbstractDemo {
    public static void main(String[] args) {
        /* 以下是不允许的，会引发错误 */
        // Employee e = new Employee("Kevin Lee", "北京市西城区西直门外大街金贸中心", 43);
        Employee e = new Salary("Kevin Lee", "北京市西城区西直门外大街金贸中心", 3, 90000.00);

        System.out.println("使用Employee的引用调用mailCheck()方法");
        e.mailCheck();
    }
}