package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarsJavaConfig {

    @Bean
    public Car sportCar(){
        return new SportCar();
    }

    @Bean
    public Racer racer(){
        return new Racer(sportCar());
    }
}
