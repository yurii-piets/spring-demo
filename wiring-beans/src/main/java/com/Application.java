package com;

import com.config.CarsSpringConfig;
import com.racer.Racer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(CarsSpringConfig.class);
        context.refresh();

        Racer racer = context.getBean(Racer.class);

        racer.drive();

        context.close();

    }
}
