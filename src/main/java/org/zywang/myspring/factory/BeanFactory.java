package org.zywang.myspring.factory;

import org.zywang.myspring.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactory {

    Object getBean(String name);

}
