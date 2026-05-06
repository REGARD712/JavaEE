package org.me.springiocdidemo.Controller;

import jakarta.annotation.Resource;
import org.me.springiocdidemo.Component.StudentComponent;
import org.me.springiocdidemo.Configuration.UserConfiguration;
import org.me.springiocdidemo.Service.UserService;
import org.me.springiocdidemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
//    public void print() {
//        System.out.println("Hello controller");
//    }

    // Spring DI:
    // 1. 使用Autowired注解自动注入
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private UserConfiguration userConfiguration;

    // 2. 使用构造方法自动注入
//    private UserService userService;
//    private UserConfiguration userConfiguration;

    // 如果只有一个构造方法，默认就是调用这个来注入
//    public HelloController(UserService userService, UserConfiguration userConfiguration) {
//        this.userService = userService;
//        this.userConfiguration = userConfiguration;
//    }

    // 如果有多个构造方法，默认是无参构造方法，需要在有参构造方法上添加@Autowired注解，否则无法实现注入
//    public HelloController() {
//
//    }
//    @Autowired
//    public HelloController(UserService userService, UserConfiguration userConfiguration) {
//        this.userService = userService;
//        this.userConfiguration = userConfiguration;
//    }

    // 3. 使用setter方法自动注入，需要在每一个setter方法上添加Autowired注解，否则无法实现注入
//    private UserService userService;
//    private UserConfiguration userConfiguration;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//    @Autowired
//    public void setUserConfiguration(UserConfiguration userConfiguration) {
//        this.userConfiguration = userConfiguration;
//    }

//    public void print() {
//        System.out.println("Hello controller");
//        System.out.println(userService);
//        System.out.println(userConfiguration);
//        userService.print(); // 调用UserService的print方法
//        userConfiguration.print();
//    }

    // 4. @Autowired的问题：当有多个Bean时，也无法完成注入（-> StudentComponent）
//    @Autowired
//    private Student student; // 注入Student

    // 解决方法2：优先使用s2这个Bean
//    @Qualifier("s2")
//    @Autowired
//    private Student student; // 注入Student

    // 解决方法3：通过name字段指定使用s2这个Bean
//    @Resource(name = "s2") // @Resource注解默认按照名称进行注入，name属性指定要注入的Bean的名称
//    @Autowired
//    private Student student; // 注入Student

    // @Qualifier也可以在参数中指定Bean进行注入
    @Qualifier("s2")
    @Autowired
    private Student student; // 注入Student

    public void print() {
        System.out.println("Hello controller");
        System.out.println(student);
    }
}
