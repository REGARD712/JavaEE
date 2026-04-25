package org.me.springiocdidemo;

public class Car {
    Framework framework;
    public Car(Framework framework) {
        this.framework = framework;
        System.out.println("car init");
    }

    public void run() {
        System.out.println("car run");
    }
}
