/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day11.exercises;

public class LogManagerTest {
    public static void main(String[] args) {
        LogManager logManager = LogManager.getInstance();
        logManager.log("调用LogManagerTest的main方法");
        logManager.log("5 + 6 = " + add(5, 6));
    }

    public static int add(int a, int b) {
        int result;
        result = a + b;

        LogManager logManager = LogManager.getInstance();
        logManager.log("The result is: " + result);

        return result;
    }
}
