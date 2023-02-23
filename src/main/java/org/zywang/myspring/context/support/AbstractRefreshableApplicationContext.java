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

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        List<String> beanNames = new ArrayList<>();
        for (Map.Entry<String, BeanDefinition> entry: beanFactory.getBeanDefinitionMap().entrySet()) {
            Class beanClass = entry.getValue().getBeanClass();
            if (requiredType.isAssignableFrom(beanClass)) {
                beanNames.add(entry.getKey());
            }
        }

        if (beanNames.size() == 1) {
            return getBean(beanNames.get(0), requiredType);
        }

        throw new BeansException(requiredType + " expected single bean but found " + beanNames.size() + ": " + beanNames);
    }
}
