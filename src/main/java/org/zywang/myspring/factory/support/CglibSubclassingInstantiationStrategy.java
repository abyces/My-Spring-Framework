package org.zywang.myspring.factory.support;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;
import org.zywang.myspring.BeansException;
import org.zywang.myspring.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        if (ctor == null) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
