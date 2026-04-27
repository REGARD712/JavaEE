package org.me.springiocdidemo.Configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    public void print() {
        System.out.println("Hello Configuration");
    }
}
