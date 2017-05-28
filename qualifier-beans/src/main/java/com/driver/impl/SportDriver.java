package com.driver.impl;

import com.cars.annotations.qualifiers.Fast;
import com.cars.annotations.qualifiers.Sport;
import com.cars.def.Car;
import com.driver.def.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SportDriver implements Driver {

    private Car car;
    private String name;

    @Override
    public void drive() {
        System.out.print(name + ": ");
        car.drive();
    }

    @Autowired
    @Fast
    @Sport
    public void setCar(Car car) {
        this.car = car;
    }

    public void setName(String name) {
        this.name = name;
    }
}
