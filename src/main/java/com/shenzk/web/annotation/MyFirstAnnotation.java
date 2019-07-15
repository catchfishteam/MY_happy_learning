package com.shenzk.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.Mapping;

// 修饰对象
@Target({ElementType.METHOD, ElementType.TYPE})
// 生命周期
@Retention(RetentionPolicy.RUNTIME)
// 这是一个Web Mapping annotation
@Mapping
public @interface MyFirstAnnotation {
	String value() default "";
}
