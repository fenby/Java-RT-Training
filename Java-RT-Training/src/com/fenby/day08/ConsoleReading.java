package com.fenby.day08;
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
 * 从console中读取字符串
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReading {
    public static void main(String[] args) {
        System.out.println("从console中读取字符串");

        // 通过System.in可以获取用户在console中输入的字符串
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            System.out.println("请输入字符串...");
            System.out.println("输入'quit'退出");
            do {
                // 在你输入回车前BufferedReader方法处于等待状态
                userInput = (String) br.readLine();
                // 在这里填写你的代码
                userInput = toLowerCase(userInput);
                System.out.println("你输入了: " + userInput);
            } while (!userInput.equals("quit"));
        } catch (Exception e) {
        }
    }

    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }
}
