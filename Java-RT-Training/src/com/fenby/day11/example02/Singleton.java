/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day11.example02;

public class Singleton {
    /** 静态类实例变量 */
    private volatile static Singleton instance = null;

    /**
     * 私有构造函数
     */
    private Singleton() {
    }

    /**
     * 返回单例的实例引用
     *
     * @return 唯一的实例
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}