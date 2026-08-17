package com.blog.pojo.response;

import com.blog.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Result {
    private ResultCodeEnum code; // 业务信息码，非Http信息码
    private String errmsg;
    private Object data;

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result fail(String errmsg) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrmsg(errmsg);
        return result;
    }

    public static Result fail(String errmsg, Object data) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrmsg(errmsg);
        result.setData(data);
        return result;
    }
}
