package com;

import org.springframework.stereotype.Component;

@Component
public class SportCar implements Car {
    private String mark = "BMW";
    private String model = "7";

    @Override
    public void drive() {
        System.out.print("Driving " + mark + " " + model);
    }
}