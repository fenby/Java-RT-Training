/**
 * --------------------------------------------------------------------
 * Copyright (c) 2014 by VIPHold Technology.
 * This software is the proprietary information of VIPHold Technology
 * All Right Reserved.
 * --------------------------------------------------------------------
 */
package com.fenby.day11.example05;

public interface Football extends Sports, Event {
    public void homeTeamScored(int points);
    public void visitingTeamScored(int points);
}
