package com.gestaospring.gestationalspring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
@Before("execution(* com.gestaospring.gestationalspring..*(..))")
public void logBefore(JoinPoint joinPoint) {
    System.out.println("logBefore() is running!");
    System.out.println("hijacked : " + joinPoint.getSignature().toShortString());
    System.out.println("******");
}
}