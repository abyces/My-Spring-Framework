package org.zywang.myspring.test.bean;

import org.zywang.myspring.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("USbeforeAdvice: " + method.getName());
    }
}
