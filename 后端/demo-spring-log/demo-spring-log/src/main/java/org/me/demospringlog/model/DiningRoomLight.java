package org.me.demospringlog.model;

public class DiningRoomLight implements Light {
    @Override
    public void on() {
        System.out.println("打开餐厅灯");
    }

    @Override
    public void off() {
        System.out.println("关闭餐厅灯");
    }
}
