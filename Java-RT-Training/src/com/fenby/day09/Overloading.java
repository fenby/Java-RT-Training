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
package com.fenby.day09;

public class Overloading {

    public int test() {
        System.out.println("test1");
        return 1;
    }

    public void test(int a) {
        System.out.println("test2");
    }

    // 以下两个参数类型顺序不同
    public String test(int a, String s) {
        System.out.println("test3");
        return "return test3";
    }

    public String test(String s, int a) {
        System.out.println("test4");
        return "return test4";
    }

    public static void main(String[] args) {
        Overloading o = new Overloading();
        System.out.println(o.test());
        o.test(1);
        System.out.println(o.test(1, "Overloading"));
        System.out.println(o.test("Overloading", 1));
    }
}
