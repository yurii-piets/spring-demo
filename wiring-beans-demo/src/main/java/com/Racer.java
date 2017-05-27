package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Racer {

    private Car car;

    @Autowired
    public Racer(Car car) {
        this.car = car;
    }

    public void drive() {
        car.drive();
    }
}
