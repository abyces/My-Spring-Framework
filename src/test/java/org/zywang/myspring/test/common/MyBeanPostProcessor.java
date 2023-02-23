package org.zywang.myspring.test.common;

import org.zywang.myspring.beans.BeansException;
import org.zywang.myspring.beans.factory.config.BeanPostProcessor;
import org.zywang.myspring.test.bean.UserService;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if ("userService".equals(beanName)) {
//            UserService userService = (UserService) bean;
//            userService.setLocation("(*) New York");
//        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
