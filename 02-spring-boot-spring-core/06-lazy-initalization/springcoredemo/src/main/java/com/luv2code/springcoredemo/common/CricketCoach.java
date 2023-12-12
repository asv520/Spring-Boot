package com.luv2code.springcoredemo.common;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;

@Component //marks the class as spring bean
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!";
    }
}
