package org.zywang.myspring.context.support;

import org.zywang.myspring.beans.BeansException;
import org.zywang.myspring.beans.factory.config.BeanPostProcessor;
import org.zywang.myspring.context.ApplicationContext;
import org.zywang.myspring.context.ApplicationContextAware;


/**
 * ApplicationContext的获取不能直接在创建Bean时直接拿到
 * 所以需要在refresh时把ApplicationContext写入一个包装
 * 的BeanPostProcessor中去
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
