/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day10;

public class VirtualDemo {
    public static void main(String[] args) {
        Salary s = new Salary("Kevin Lee", "北京市西城区西直门外大街金贸中心", 3, 90000.00);
        Employee e = new Salary("Macy Zhao", "北京市西城区西直门外大街金贸中心", 2, 60000.00);
        System.out.println("使用Salary的引用调用mailCheck()方法");
        s.mailCheck();
        System.out.println("使用Employee的引用调用mailCheck()方法");
        e.mailCheck();
    }
}
