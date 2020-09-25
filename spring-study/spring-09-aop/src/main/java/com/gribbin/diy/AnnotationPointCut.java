package com.gribbin.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointCut {
    @Before("execution(* com.gribbin.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("==========方法执行前==========");
    }

    @After("execution(* com.gribbin.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("==========方法执行后==========");
    }

    @Around("execution(* com.gribbin.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("==========环绕前==========");
        Signature signature = pjp.getSignature();
        System.out.println("signature:" + signature);

        Object proceed = pjp.proceed();
        System.out.println("proceed:" + proceed);
        System.out.println("==========环绕后==========");
    }
}
