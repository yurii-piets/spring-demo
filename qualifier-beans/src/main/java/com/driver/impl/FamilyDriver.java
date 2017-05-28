package com.driver.impl;

import com.cars.def.Car;
import com.driver.def.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FamilyDriver implements Driver {

    private Car car;
    private String name;

    @Autowired
    @Qualifier("family")
    public void setCar(Car car) {
        this.car = car;
    }


    @Override
    public void drive()  {
        System.out.print(name + ": ");
        car.drive();
    }

    public void setName(String name) {
        this.name = name;
    }
}
