package org.me.springiocdidemo.Component;

import org.me.springiocdidemo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StudentComponent {
    @Bean
    public Student s() {
        return new Student("zhangsan", 20);
    }
}
