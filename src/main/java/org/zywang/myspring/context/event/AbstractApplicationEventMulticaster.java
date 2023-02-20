package org.zywang.myspring.context.event;

import org.zywang.myspring.BeansException;
import org.zywang.myspring.beans.factory.BeanFactory;
import org.zywang.myspring.beans.factory.BeanFactoryAware;
import org.zywang.myspring.context.ApplicationEvent;
import org.zywang.myspring.context.ApplicationListener;
import org.zywang.myspring.utils.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();
    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event) {
        ArrayList<ApplicationListener> allListeners = new ArrayList<>();
        for (ApplicationListener<ApplicationEvent> listener: applicationListeners) {
            if (supportsEvent(listener, event)) allListeners.add(listener);
        }

        return allListeners;
    }

    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
        Class<? extends ApplicationListener> listenerClass = applicationListener.getClass();

        // 判断目标是由 CglibSubclassingInstantiationStrategy 还是 SimpleInstantiationStrategy 实例化的？
        // 两种方案获得目标class的方式不同
        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        Type genericInterface = targetClass.getGenericInterfaces()[0];

        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }

        // 判断此eventClassName对象所表示的类或接口与指定的event.getClass参数所表示的类或接口是否相同
        // isAssignableFrom 可以判断子类和父类的关系，如果A.isAF(B) == true，说明B可以转换成A
        return eventClassName.isAssignableFrom(event.getClass());
    }
}
