package org.zywang.myspring.beans.factory.config;

import org.zywang.myspring.beans.BeansException;

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * call this method before bean instantiation
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

}
