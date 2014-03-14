/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day10.example01;

public class Technical extends Employee {

    public Technical(int number, String name) {
        super(number, name);
    }

    public double computePay() {
        return super.computePay() * 0.8;
    }
}
