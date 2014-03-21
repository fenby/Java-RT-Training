/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day13.thread;

class Counter {
    public void printCount(String threadName) {
        for (int i = 5; i > 0; i--) {
            System.out.println(threadName + ", 计数器 --- " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("中断异常");
            }
        }
    }
}

class MyThreadUnSync extends Thread {
    private Counter counter;

    public MyThreadUnSync(String name, Counter pd) {
        this.setName(name);
        counter = pd;
    }

    public void run() {
        System.out.println("启动线程: " + this.getName());
        synchronized (counter) {
        	counter.printCount(this.getName());
        }
        System.out.println("结束线程: " + this.getName());
    }

}

public class MyThreadUnSyncTest {
    public static void main(String args[]) {

        Counter counter = new Counter();

        MyThreadUnSync thread1 = new MyThreadUnSync("线程1", counter);
        MyThreadUnSync thread2 = new MyThreadUnSync("线程2", counter);

        thread1.start();
        thread2.start();

        // 等待子线程结束
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("子线程中断异常");
        }

        System.out.println("主线程结束");
    }
}