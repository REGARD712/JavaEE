package org.me.springiocdidemo.Service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void print() {
        System.out.println("Hello service");
    }
}
