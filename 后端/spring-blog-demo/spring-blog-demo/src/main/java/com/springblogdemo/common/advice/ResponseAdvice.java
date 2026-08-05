package com.springblogdemo.common.advice;

import com.springblogdemo.pojo.response.Result;
import lombok.SneakyThrows;
import org.jspecify.annotations.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import tools.jackson.databind.ObjectMapper;

public class ResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @SneakyThrows
    @Override
    public @Nullable Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        if (body instanceof String) {
            return objectMapper.writeValueAsString(Result.success(body));
        }
        if (body instanceof Result) {
            return body;
        }
        return Result.success(body);
    }
}