/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day10.example01;

public class Sales extends Employee {

    public Sales(int number, String name) {
        super(number, name);
    }

    // 销售人员月工资仅发60%
    public double computePay() {
        return super.computePay() * 0.6;
    }
}
