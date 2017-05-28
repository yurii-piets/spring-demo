package com.prototypes.impl;

import com.prototypes.def.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UsualUser implements User {

    public static int counter = 0;

    public UsualUser() {
        counter += 1;
    }

}
