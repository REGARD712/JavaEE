package org.me.springaopdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAspectDemo {
    @Around("@annotation(org.me.springaopdemo.aspect.MyAspect)")
    public Object timeRecord(ProceedingJoinPoint pjp) throws Throwable {
        log.info("目标方法执行前...");

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            log.info("do afterThrowing...");
        }

        log.info("目标方法执行后...");

        return object;
    }
}
