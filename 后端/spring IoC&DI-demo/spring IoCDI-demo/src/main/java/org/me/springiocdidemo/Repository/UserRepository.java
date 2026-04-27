package org.me.springiocdidemo.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void print() {
        System.out.println("Hello Repository");
    }
}
