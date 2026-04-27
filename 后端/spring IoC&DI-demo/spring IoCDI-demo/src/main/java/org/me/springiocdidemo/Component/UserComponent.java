package org.me.springiocdidemo.Component;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    public void print() {
        System.out.println("Hello Component");
    }
}
