package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component //marks the class as spring bean
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!";
    }
}
