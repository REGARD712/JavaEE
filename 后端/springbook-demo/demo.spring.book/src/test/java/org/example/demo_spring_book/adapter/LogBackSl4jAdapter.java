package org.example.demo_spring_book.adapter;

public class LogBackSl4jAdapter implements Sl4jApi{
    private LogBack logBack;

    public LogBackSl4jAdapter(LogBack logBack) {
        this.logBack = logBack;
    }

    @Override
    public void log(String log) {
        logBack.print("LogBackSl4jAdapter log : " + log);
    }
}
