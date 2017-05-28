package com.cars.impl;

import com.cars.annotations.qualifiers.Fast;
import com.cars.annotations.qualifiers.Sport;
import com.cars.def.Car;
import org.springframework.stereotype.Component;

@Component
@Sport
@Fast
public class SportCar implements Car {

    @Override
    public void drive() {
        System.out.println("Driving sport car");
    }
}
