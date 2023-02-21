package org.zywang.myspring.beans.factory;

import org.zywang.myspring.beans.BeansException;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory{

    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
    String[] getBeanDefinitionNames();

}