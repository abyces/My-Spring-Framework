package org.zywang.myspring.beans.factory;

public interface InitializingBean {

    /**
     * Bean 处理属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;

}
