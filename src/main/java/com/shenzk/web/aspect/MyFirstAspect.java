package com.shenzk.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyFirstAspect {
	
	@Pointcut("@annotation(com.shenzk.web.annotation.MyFirstAnnotation)")
	public void annotationPointcut(){}
	
	@Before("annotationPointcut()")
	public void before(JoinPoint jPoint){
		System.out.println("before");
	}
	
	@After("annotationPointcut()")
	public void after(JoinPoint jPoint){
		System.out.println("after");
	}
	
	@Around("annotationPointcut()")
	public void doAround(ProceedingJoinPoint point) throws Throwable{
		System.out.println("around before");
		point.proceed();
		System.out.println("around after");
	}

}

