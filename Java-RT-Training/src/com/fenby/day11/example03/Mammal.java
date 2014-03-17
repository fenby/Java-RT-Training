/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day11.example03;

public class Mammal implements Animal {

    public void eat() {
        System.out.println("Mammal's eat");
    }

    public void move() {
        System.out.println("Mammal's move");
    }

    public static void main(String[] args) {
        Mammal mammal = new Mammal();
        mammal.eat();
        mammal.move();
    }
}
