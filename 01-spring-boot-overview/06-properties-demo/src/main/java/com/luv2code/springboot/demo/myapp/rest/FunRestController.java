package com.luv2code.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //inject properties for coach name and team name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expose a new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
        public String getTeamInfo(){
        return "coach name: " + coachName + ", team name: " + teamName;
    }

    //expose "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    //expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "my package is 12LPA";
    }
}
