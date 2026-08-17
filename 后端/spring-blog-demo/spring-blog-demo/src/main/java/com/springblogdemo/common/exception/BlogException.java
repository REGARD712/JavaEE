package com.springblogdemo.common.exception;

import lombok.Data;

@Data
public class BlogException extends RuntimeException {
    private Integer code;
    private String errmsg;

    public BlogException(Integer code, String errmsg) {
        this.code = code;
        this.errmsg = errmsg;
    }

    public BlogException(String errmsg) {
        this.errmsg = errmsg;
    }
}
