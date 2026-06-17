package org.me.springaopdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectDemo2 {
    @Before("org.me.springaopdemo.aspect.AspectDemo1.pt()")
    public void doBefore() {
        log.info("do before...");
    }

    @After("org.me.springaopdemo.aspect.AspectDemo1.pt()")
    public void doAfter() {
        log.info("do after...");
    }
}
