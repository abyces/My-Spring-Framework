package org.zywang.myspring.beans.factory;

import org.zywang.myspring.beans.BeansException;
import org.zywang.myspring.beans.factory.config.BeanDefinition;
import org.zywang.myspring.beans.factory.config.AutowireCapableBeanFactory;
import org.zywang.myspring.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}