package com.cars.impl;

import com.cars.def.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("family")
public class FamilyCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving family car");
    }
}
