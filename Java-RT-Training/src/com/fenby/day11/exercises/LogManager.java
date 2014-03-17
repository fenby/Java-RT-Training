/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day11.exercises;

import java.io.PrintStream;

public class LogManager {
    /** 静态类实例变量 */
    private volatile static LogManager instance = null;
    private PrintStream out;

    /**
     * 私有构造函数
     */
    private LogManager(PrintStream out) {
        System.out.println("执行私有LogManager构造函数");
        this.out = out;
    }

    /**
     * 返回单例的实例引用
     *
     * @return 唯一的实例
     */
    public static LogManager getInstance() {
        if (instance == null) {
            synchronized (LogManager.class) {
                if (instance == null) {
                    instance = new LogManager(System.out);
                }
            }
        }

        return instance;
    }

    public void log(String msg) {
        out.println(this.toString() + " : " + msg);
    }
}