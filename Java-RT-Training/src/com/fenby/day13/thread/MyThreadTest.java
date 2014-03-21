/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day13.thread;

class MyThread implements Runnable {

    public void run() {
        try {
           for(int i = 4; i > 0; i--) {
              System.out.println("子线程: " + i);
              // 暂停线程
              Thread.sleep(50);
           }
       } catch (InterruptedException e) {
           System.out.println("子线程中断");
       }
       System.out.println("子线程结束");
     }
}

public class MyThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyThread());
            thread.start();
        }
        System.out.println("主线程结束");
    }
}
