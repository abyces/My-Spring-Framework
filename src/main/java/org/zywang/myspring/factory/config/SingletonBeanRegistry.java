package org.zywang.myspring.factory.config;

public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
