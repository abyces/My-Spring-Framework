package org.zywang.myspring.aop;

public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();

}
