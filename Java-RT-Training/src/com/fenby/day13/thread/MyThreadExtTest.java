/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day13.thread;

class MyThreadExt extends Thread {
    private String threadName;

    MyThreadExt(String name) {
        threadName = name;
        System.out.println("创建子线程: " + threadName);
    }

    public void run() {
        System.out.println("执行子线程: " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("子线程: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("子线程 " + threadName + " 中断");
        }
        System.out.println("子线程 " + threadName + " 结束");
    }

}

public class MyThreadExtTest {
    public static void main(String args[]) {
        MyThreadExt t1 = new MyThreadExt("线程1");
        t1.start();

        MyThreadExt t2 = new MyThreadExt("线程2");
        t2.start();
    }
}
