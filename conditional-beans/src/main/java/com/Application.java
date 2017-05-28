package com;

import com.beans.MyBean;
import com.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AppConfig.class);
        context.refresh();



        MyBean my = context.getBean(MyBean.class);
        my.myWork();

        context.close();
    }
}
