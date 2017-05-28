package com;

import com.config.AppConfig;
import com.prototypes.def.User;
import com.prototypes.impl.UsualUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AppConfig.class);
        context.refresh();

        User user1 = context.getBean(UsualUser.class);
        User user2 = context.getBean(UsualUser.class);
        User user3 = context.getBean(UsualUser.class);

        System.out.println(UsualUser.counter);

        context.close();
    }
}
