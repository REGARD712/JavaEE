package org.example.demo_blog.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.demo_blog.pojo.Person;

/**
 * @ClassName: JSONUtils
 * @Author: JacksonLee
 * @Date: 2026/8/30
 * @Description: 使用jackson-databind工具实现JSON和Java对象的相互转换
 */
public class JSONUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        Person object = new Person();
        object.setId(5);
        object.setName("zhangsan");
        object.setPassword("123456");
        // 对象转为JSON字符串
        String jsonStr = objectMapper.writeValueAsString(object);
        System.out.println("JSON字符串为：" + jsonStr);
        // JSON字符串转为对象
        Person person = objectMapper.readValue(jsonStr, Person.class);
        System.out.println("转换的对象id：" + person.getId() +
                "，name：" + person.getName() + "，password：" + person.getPassword());
    }
}
