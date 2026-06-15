package org.example.demo_spring_book.adapter;

public class Client {
    public static void main(String[] args) {
        Sl4jApi sl4jApi = new Log4jSl4jAdapter(new Log4j());
        sl4jApi.log("Hello Adapter Pattern");
    }
}
