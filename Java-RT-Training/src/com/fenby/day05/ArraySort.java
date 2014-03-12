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
 * 使用sort方法实现数组的排序功能
 */
import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        String newLine = System.getProperty("line.separator");
        System.out.println("Performing Sort on Arrays Demo");
        System.out.println("---------------------------");

        int[] numbers = new int[5];

        // 为数组赋初值
        numbers[0] = 12;
        numbers[1] = 5;
        numbers[2] = 4;
        numbers[3] = 14;
        numbers[4] = 56;

        // 使用foreach循环显示数组的内容
        System.out.println("Numbers before sort : ");
        for (int num : numbers) {
            System.out.print(num + ",");
        }
        System.out.println(newLine + "---------------------------");

        // 通过Arrays的sort方法实现数组的排序
        Arrays.sort(numbers);

        // 使用foreach循环显示数组的内容
        System.out.println("Numbers after sort : ");
        for (int num : numbers) {
            System.out.print(num + ",");
        }
    }
}
