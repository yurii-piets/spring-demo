package com;

import com.config.CarConfig;
import com.driver.def.Driver;
import com.driver.impl.FamilyDriver;
import com.driver.impl.SportDriver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(CarConfig.class);
        context.refresh();

        Driver familyDriver = context.getBean(FamilyDriver.class);
        familyDriver.drive();

        Driver sportDriver = context.getBean(SportDriver.class);
        sportDriver.drive();

        context.close();
    }
}
