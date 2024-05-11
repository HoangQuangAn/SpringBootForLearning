package com.example.primary.common;

import org.springframework.context.annotation.Bean;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In Contructor : "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "swim 100 meter as a warming up";
    }
}
