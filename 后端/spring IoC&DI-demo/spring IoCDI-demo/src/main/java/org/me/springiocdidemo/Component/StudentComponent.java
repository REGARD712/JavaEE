package org.me.springiocdidemo.Component;

import org.me.springiocdidemo.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StudentComponent {
//    @Bean
    @Bean({"stu", "student"})
    public Student s() {
        return new Student("zhangsan", 20);
    }
}
