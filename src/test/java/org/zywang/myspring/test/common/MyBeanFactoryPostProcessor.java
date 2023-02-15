package org.zywang.myspring.test.common;

import org.zywang.myspring.BeansException;
import org.zywang.myspring.PropertyValue;
import org.zywang.myspring.PropertyValues;
import org.zywang.myspring.beans.factory.ConfigurableListableBeanFactory;
import org.zywang.myspring.beans.factory.config.BeanDefinition;
import org.zywang.myspring.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "apple"));
    }
}
