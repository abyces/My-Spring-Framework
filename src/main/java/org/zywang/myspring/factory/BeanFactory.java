package org.zywang.myspring.factory;

import org.zywang.myspring.BeansException;
import org.zywang.myspring.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

}
