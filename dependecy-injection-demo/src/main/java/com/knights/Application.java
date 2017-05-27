package com.knights;

import com.knights.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AppConfig.class);
        context.refresh();

        Knight knight = context.getBean(Knight.class);
        knight.embarkQuest();

        context.close();
    }
}
