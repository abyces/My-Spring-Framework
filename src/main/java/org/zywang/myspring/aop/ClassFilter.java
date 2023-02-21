package org.zywang.myspring.aop;

public interface ClassFilter {

    /**
     * should the pointcut apply to given interface or class
     * @param clazz
     * @return
     */
    boolean matches(Class<?> clazz);

}
