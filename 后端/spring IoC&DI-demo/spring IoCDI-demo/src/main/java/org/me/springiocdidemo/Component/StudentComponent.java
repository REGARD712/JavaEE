package org.me.springiocdidemo.Component;

import org.me.springiocdidemo.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class StudentComponent {
//    @Bean
//    @Bean({"stu", "student"}) // 指定Bean的名称，默认是方法名
    // @Bean(name = {"stu", "student"})
    // @Bean(value = {"stu", "student"})
//    public Student s() {
//        return new Student("zhangsan", 20);
//    }

    // 测试@Autowired的问题：多个Bean无法注入
//    @Bean()
//    public Student s1() {
//        return new Student("zhangsan", 20);
//    }
//    @Bean
//    public Student s2() {
//        return new Student("lisi", 22);
//    }
    // 解决方法1：在需要使用的Bean上方添加@Primary注解，表示优先使用这个Bean进行注入
//    @Primary
//    @Bean()
//    public Student s1() {
//        return new Student("zhangsan", 20);
//    }
//    @Bean
//    public Student s2() {
//        return new Student("lisi", 22);
//    }
    // 解决方法2：在上层的字段的上方添加@Qualifier并指定Bean，表示优先使用这个Bean进行注入
//    @Bean()
//    public Student s1() {
//        return new Student("zhangsan", 20);
//    }
//    @Bean
//    public Student s2() {
//        return new Student("lisi", 22);
//    }
    // 解决方法3：在上层的字段的上方添加@Resource并通过name字段指定Bean，表示优先使用这个Bean进行注入
//    @Bean()
//    public Student s1() {
//        return new Student("zhangsan", 20);
//    }
//    @Bean
//    public Student s2() {
//        return new Student("lisi", 22);
//    }

    // @Qualifier也可以在参数中指定Bean进行注入
    @Bean()
    public Student s1() {
        return new Student("zhangsan", 20);
    }
    @Bean
    public String name() {
        return "lisi";
    }
    @Bean
    public String name2() {
        return "wangwu";
    }
    @Bean // 使用@Qualifier指定参数，表示优先使用这个Bean进行注入
    public Student s2(@Qualifier("name") String n) {
        return new Student(n, 22);
    }
}
