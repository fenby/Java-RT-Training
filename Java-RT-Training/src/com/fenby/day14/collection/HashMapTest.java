package com.fenby.day14.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {

		Map<String, Integer> empSal = new HashMap<String, Integer>();
		// 将员工的姓名和工资添加至map中
		empSal.put("Ramesh", 10000);
		empSal.put("Suresh", 20000);
		empSal.put("Mahesh", 30000);
		empSal.put("Naresh", 1000);
		empSal.put("Nainesh", 15000);
		empSal.put("Rakesh", 10000);

		// 此处的值是允许重复的，但是键是不能重复的。
		empSal.put("Nilesh", null); // 值也可以是空

		// 打印完整的map内容
		System.out.println("原始map内容为: " + empSal);

		// 此处我们再添加一名新的员工
		empSal.put("Rohit", 23000);
		// 此处我们删除一个键值对
		empSal.remove("Nilesh");
		System.out.println("更新后的map内容为: " + empSal);

		// 打印所有键内容
		System.out.println("键内容为: " + empSal.keySet());
		// 打印所有值内容
		System.out.println("值内容为: " + empSal.values());

		empSal.put("Kevin", 5000);
		System.out.println("更新后的map内容为: " + empSal);
		empSal.clear();
		System.out.println(empSal);
	}
}