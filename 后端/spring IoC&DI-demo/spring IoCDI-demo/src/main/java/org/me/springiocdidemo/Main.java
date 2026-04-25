package org.me.springiocdidemo;

public class Main {
    public static void main(String[] args) {
        Tire tire = new Tire(17);
        Buttom buttom = new Buttom(tire);
        Framework framework = new Framework(buttom);
        Car car = new Car(framework);
        car.run();
    }
}
