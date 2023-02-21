package org.zywang.myspring.aop;

import java.lang.reflect.Method;

public interface MethodMatcher {

    /**
     * check whether the given method matches
     * @param method
     * @param targetClass
     * @return
     */
    boolean matches(Method method, Class<?> targetClass);

}
