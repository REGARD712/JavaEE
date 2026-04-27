package org.me.springiocdidemo.Controller;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    public void print() {
        System.out.println("Hello controller");
    }
}
