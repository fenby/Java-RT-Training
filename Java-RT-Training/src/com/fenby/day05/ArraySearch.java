package com.fenby.day05;
/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 *
 * SVN revision information:
 * @id      $Id: $
 * @version $Revision: $
 * @author  $Author: $
 * @date    $Date: $
 */

/*
 * 你可以通过Arrays的binarySearch（二进制查找）方法实现数组的查找
 * 但是在进行查找前，你需要先对数组进行排序处理。
 */
import java.util.Arrays;

public class ArraySearch {
    public static void main(String[] args) {
        System.out.println("Performing Binary Search on Arrays");
        System.out.println("----------------------------------");

        int[] numbers = new int[5];

        // 为数组赋值
        numbers[0] = 12;
        numbers[1] = 5;
        numbers[2] = 4;
        numbers[3] = 14;
        numbers[4] = 56;

        // 在执行二进制查找前我们需要先对数组进行排序
        Arrays.sort(numbers);

        // 通过Arrays的binarySearch方法我们就可以实现数据的查找了
        // 该方法返回查找数据在当前数组中的索引位置
        // 如果数据没有找到则返回-1
        System.out.println("14 is found at index : " + Arrays.binarySearch(numbers, 56));

        System.out.println("14 is found at index : " + Arrays.binarySearch(numbers, 1));
    }
}
