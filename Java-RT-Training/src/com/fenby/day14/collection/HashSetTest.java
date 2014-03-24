package com.fenby.day14.collection;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> mySet = new HashSet<String>();
		// 向HashSet中添加元素
		mySet.add("苹果");
		mySet.add("芒果");
		mySet.add("橘子");
		mySet.add("葡萄");
		mySet.add("香蕉");
		mySet.add("西瓜");

		System.out.println("HashSet的大小为: " + mySet.size());
		System.out.println("更新前的HashSet内容为: " + mySet);

		System.out.println("从HashSet中删除'苹果'元素: " + mySet.remove("苹果"));
		System.out.println("从HashSet中删除'草莓'元素（未包含）: " + mySet.remove("草莓"));
		System.out.println("检查HashSet中是否包含'西瓜'元素: " + mySet.contains("西瓜"));
		System.out.println("更新后的HashSet内容为: " + mySet);

		ArrayList<String> myList = new ArrayList<String>();
		for (String fruit : mySet) {
			myList.add(fruit);
		}

		mySet.add("芒果");
		myList.add("芒果");

		System.out.println("HashSet的内容为: " + mySet);
		System.out.println("ArrayList的内容为: " + myList);
	}
}
