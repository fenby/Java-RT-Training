package com.fenby.day14.collection;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();

		myList.add("苹果");
		myList.add("芒果");
		myList.add("句子");
		myList.add("葡萄");

		// 在指定位置添加对象
		myList.add(1, "香蕉");
		myList.add(2, "西瓜");

		System.out.println("打印所有对象:");
		for (String s : myList) {
			System.out.println(s);
		}
		System.out.println("索引为3的元素为: " + myList.get(3));
		System.out.println("list中是否包含橙子: " + myList.contains("橙子"));
		System.out.println("ArrayList的大小: " + myList.size());
		myList.remove("西瓜");
		System.out.println("ArrayList的大小: " + myList.size());

		myList.add("樱桃");
		myList.add("草莓");
		myList.add("火龙果");

		System.out.println("ArrayList的大小: " + myList.size());

		for (int i = 0; i < myList.size(); i++) {
			System.out.println("[" + i + "]: " + myList.get(i));
		}
	}
}
