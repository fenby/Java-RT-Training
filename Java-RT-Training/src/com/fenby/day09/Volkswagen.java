/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day09;

// 引擎类
class Engine {
    public void start() {
        System.out.println("启动引擎");
    }

    public void stop() {
        System.out.println("关闭引擎");
    }
}

// 汽车类
class Car {
    // 外观颜色
    private String color;
    // 最高时速
    private int maxSpeed;

    public void carInfo() {
        System.out.println("汽车颜色 = " + color + ", 最高时速 = " + maxSpeed);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

// 大众汽车
public class Volkswagen extends Car {
    private Engine engine;

    public Volkswagen() {
        engine = new Engine();
    }

    public void drive() {
        engine.start();
        System.out.println("启动汽车");
    }

    public static void main(String[] args) {
        Volkswagen myCar = new Volkswagen();
        myCar.setColor("Black");
        myCar.setMaxSpeed(180);
        myCar.carInfo();

        myCar.drive();
    }
}
