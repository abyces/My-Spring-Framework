package org.zywang.myspring.factory.support;

import org.zywang.myspring.BeansException;
import org.zywang.myspring.factory.BeanFactory;
import org.zywang.myspring.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return doGetBean(name, null);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);

        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
