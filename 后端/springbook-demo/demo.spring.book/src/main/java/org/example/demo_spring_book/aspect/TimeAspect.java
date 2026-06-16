package org.example.demo_spring_book.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeAspect {
    @Around("execution(* org.example.demo_spring_book.controller.*.*(..))") // 表示对所有controller生效
    public Object timeRecord(ProceedingJoinPoint pjp) throws Throwable {
        // 1.记录开始时间
        long start = System.currentTimeMillis();
        // 2.执行目标方法
        Object object = pjp.proceed();
        // 3.记录结束时间
        long end = System.currentTimeMillis();
        // 4.打印日志
        log.info(pjp.getSignature().toString() + "方法执行耗时：" + (end-start) + "ms");
        // 5.返回结果
        return object;
    }
}
