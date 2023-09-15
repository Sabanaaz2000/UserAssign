//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanBag {
    public BeanBag() {
    }

    @Bean
    public List<org.saba.UserManagementSystem.User> allUsers() {
        return new ArrayList();
    }
}
