package org.example.demo_spring_book.adapter;

public class Log4jSl4jAdapter implements Sl4jApi{
    private Log4j log4j;

    public Log4jSl4jAdapter(Log4j log4j) {
        this.log4j = log4j;
    }

    @Override
    public void log(String log) {
        log4j.log("Log4jSl4jAdapter log : " + log);
    }
}
