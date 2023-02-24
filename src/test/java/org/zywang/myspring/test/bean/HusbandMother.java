package org.zywang.myspring.test.bean;

import org.zywang.myspring.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class HusbandMother implements FactoryBean<IMother> {

    @Override
    public IMother getObject() throws Exception {
        return (IMother) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[] {IMother.class},
                ((proxy, method, args) -> "婚后媳妇的妈妈被代理咯" + method.getName()));
    }

    @Override
    public Class<?> getObjectType() {
        return IMother.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
