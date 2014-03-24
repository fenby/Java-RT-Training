package com.fenby.day14.collection;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet<String> playerSet = new TreeSet<String>();

		playerSet.add("Sachin");
		playerSet.add("Zahir");
		playerSet.add("Mahi");
		playerSet.add("Bhajji");
		playerSet.add("Viru");
		playerSet.add("Gautam");
		playerSet.add("Ishant");
		playerSet.add("Umesh");
		playerSet.add("Pathan");
		playerSet.add("Virat");
		playerSet.add("Sachin"); // 数据重复，该数据不会再添加至set中

		// 显示set中的内容
		System.out.println("原始Set内容为:" + playerSet);
		System.out.println("第一个元素为: " + playerSet.first());
		System.out.println("最后一个元素为: " + playerSet.last());

		TreeSet<String> newPlySet = (TreeSet<String>) playerSet.subSet("Mahi",
				"Virat");
		System.out.println("Set的子集为: " + newPlySet);
	}
}
