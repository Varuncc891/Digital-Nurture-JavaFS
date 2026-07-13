package com.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.Country.getName(..))")
    public void logBefore() {
        System.out.println("[Aspect LOG]: getName about to execute");
    }

    @After("execution(* com.example.Country.getName(..))")
    public void logAfter() {
        System.out.println("[Aspect LOG]: getName executed");
    }
}