package com.spring.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.example.model.UserInfo;
import org.junit.jupiter.api.Test;

public class JsonTest {
//    public static void main(String[] args) {
//        System.out.println(123456);
//    }
//    @Test
//    void testJson() {
//        System.out.println("test json");
//    }

    // Java 对象转 json
    @Test
    void testObject2Json() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 定义一个 Java 对象
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhangsan");
        userInfo.setAge(20);
        userInfo.setGender(1);
        // 对象转json
        String s = objectMapper.writeValueAsString(userInfo);
        System.out.println(s);
    }

    // json 转 Java 对象
    @Test
    void testJson2Object() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 定义一个json字符串
        String s = "{\"username\":\"zhangsan\",\"gender\":1,\"age\":20}";
        // json转对象
        UserInfo userInfo = objectMapper.readValue(s, UserInfo.class);
        System.out.println(userInfo);
    }
}
