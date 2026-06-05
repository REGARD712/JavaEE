package org.example.demo_spring_book.model;

import lombok.Data;
import org.example.demo_spring_book.enums.ResultCodeEnum;

@Data
public class Result<T> {
    private ResultCodeEnum code;
    private String errMsg;
    private T data;

    public static <T> Result success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public static <T> Result fail(String errMsg) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(errMsg);
        result.setData(null);
        return result;
    }

    public static <T> Result fail(String errMsg, T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(errMsg);
        result.setData(data);
        return result;
    }

    public static <T> Result unlogin() {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.UNLOGIN);
        result.setErrMsg("用户未登录");
        result.setData(null);
        return result;
    }
}
