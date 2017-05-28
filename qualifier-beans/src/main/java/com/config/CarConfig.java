package com.config;

import com.cars.impl.FamilyCar;
import com.driver.def.Driver;
import com.driver.impl.FamilyDriver;
import com.driver.impl.SportDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/com/driver/driver.properties")
@ComponentScan(basePackageClasses = {FamilyDriver.class, FamilyCar.class})
public class CarConfig {

    @Autowired
    private Environment env;

    @Bean
    public Driver familyDriver(){
        FamilyDriver driver = new FamilyDriver();
        driver.setName(env.getProperty("driver.family.name"));
        return driver;
    }

    @Bean
    public Driver sportDriver(){
        SportDriver driver = new SportDriver();
        driver.setName(env.getProperty("driver.sport.name"));
        return driver;
    }
}
