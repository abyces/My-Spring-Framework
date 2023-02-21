package org.zywang.myspring.aop;

public interface Pointcut {

    // return the ClassFilter of THIS pointcut
    ClassFilter getClassFilter();

    // return the MethodMatcher of THIS pointcut
    MethodMatcher getMethodMatcher();

}
