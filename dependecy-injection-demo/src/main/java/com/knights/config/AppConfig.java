package com.knights.config;

import com.knights.BraveKnight;
import com.knights.DragonQuest;
import com.knights.Knight;
import com.knights.Quest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public Knight knight(){
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest(){
        return new DragonQuest();
    }
}
