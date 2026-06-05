package org.example.demo_spring_book.enums;

public enum ResultCodeEnum {
    SUCCESS(200),
    FAIL(-2),
    UNLOGIN(-1);

    private Integer code;

    ResultCodeEnum(Integer code) {
        this.code = code;
    }
}
