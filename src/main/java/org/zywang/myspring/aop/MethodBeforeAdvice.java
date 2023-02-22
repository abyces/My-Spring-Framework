package org.zywang.myspring.aop;

import java.lang.reflect.Method;

public interface MethodBeforeAdvice extends BeforeAdvice {

    /**
     * call back before a method is invoked
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    void before(Method method, Object[] args, Object target) throws Throwable;

}
