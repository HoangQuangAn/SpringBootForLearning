package com.example.primary.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrackCoach implements Coach {
    public TrackCoach(){
        System.out.println("In contructor "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}
