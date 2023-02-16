package org.zywang.myspring.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import org.zywang.myspring.BeansException;
import org.zywang.myspring.beans.factory.DisposableBean;
import org.zywang.myspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 避免二次销毁
        if (StrUtil.isNotEmpty(destroyMethodName)
                && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {

            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);

            if (destroyMethod == null) {
                throw new BeansException("Could not find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }

            destroyMethod.invoke(bean);
        }
    }
}
