package com.fenby.day14.collection;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {

		LinkedList<String> myList = new LinkedList<String>();

		myList.add("苹果");
		myList.add("芒果");
		myList.add("橘子");
		myList.add("葡萄");

		// 在指定位置添加对象
		myList.addFirst("香蕉");
		myList.addLast("西瓜");

		System.out.println("删除前的list内容为: ");
		System.out.println(myList);

		myList.removeFirst();
		myList.removeLast();

		System.out.println("删除第一个和最后一个元素后的list内容为: ");
		System.out.println(myList);
		System.out.println("删除后list中的第一个元素为: "+ myList.getFirst());
		System.out.println("删除后list中的最后一个元素为: "+ myList.getLast());

		myList.push("火龙果");
		myList.push("草莓");

		System.out.println("当前list大小为: " + myList.size());
		System.out.println(myList.pop());
		System.out.println(myList.pop());
	}
}

