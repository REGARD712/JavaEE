package org.me.springiocdidemo;

public class Tire {
    Integer size;

    public Tire(Integer size) {
        this.size = size;
        System.out.println("tire init, size:" + this.size);
    }
}
