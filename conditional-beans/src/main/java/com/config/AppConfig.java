package com.config;

import com.beans.MyBean;
import com.condition.MyCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

public class AppConfig {

    @Bean
    @Conditional(MyCondition.class)
    public MyBean myBean(){
        return new MyBean();
    }
}
