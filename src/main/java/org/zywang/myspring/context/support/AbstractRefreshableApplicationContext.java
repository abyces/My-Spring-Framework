package org.zywang.myspring.context.support;

import org.zywang.myspring.beans.BeansException;
import org.zywang.myspring.beans.factory.ConfigurableListableBeanFactory;
import org.zywang.myspring.beans.factory.config.BeanDefinition;
import org.zywang.myspring.beans.factory.support.DefaultListableBeanFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

}
