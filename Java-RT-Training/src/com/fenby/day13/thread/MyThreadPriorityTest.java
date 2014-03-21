package com.fenby.day13.thread;

public class MyThreadPriorityTest {
	public static void main(String[] args) {

		Thread t = Thread.currentThread();
		t.setName("主线程");
		// 设置当前进程优先级为最高
		t.setPriority(Thread.MAX_PRIORITY);

		// 打印当前进程
		System.out.println("Thread: " + t);

		System.out.println("当前进程优先级为: " + t.getPriority());
	}
}
