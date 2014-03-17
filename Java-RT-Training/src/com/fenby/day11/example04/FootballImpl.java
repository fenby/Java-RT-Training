/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day11.example04;

public class FootballImpl implements Football {

    public void setHomeTeam(String name) {
        System.out.println("设置主场队: " + name);
    }

    public void setVisitingTeam(String name) {
        System.out.println("设置客场队: " + name);
    }

    public void homeTeamScored(int points) {
        System.out.println("主场得分: " + points);
    }

    public void visitingTeamScored(int points) {
        System.out.println("客场得分: " + points);
    }

    public static void main(String[] args) {
        FootballImpl footbal = new FootballImpl();
        footbal.setHomeTeam("中国队");
        footbal.setVisitingTeam("巴西队");
        footbal.homeTeamScored(0);
        footbal.visitingTeamScored(0);
    }
}
