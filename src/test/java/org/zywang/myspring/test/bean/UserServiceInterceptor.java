package org.zywang.myspring.test.bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.zywang.myspring.aop.Pointcut;

public class UserServiceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            System.out.println("----------------------- AOP start -----------------------");
            System.out.println("Method Name: " + invocation.getMethod());
            System.out.println("Time cost: " + (System.currentTimeMillis() - start) + " ms");
            System.out.println("------------------------ AOP end ------------------------");
        }
    }
}
