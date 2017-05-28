package com.config;

import com.prototypes.impl.UsualUser;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = UsualUser.class)
public class AppConfig {
}
