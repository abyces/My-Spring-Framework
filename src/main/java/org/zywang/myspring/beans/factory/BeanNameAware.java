package org.zywang.myspring.beans.factory;

/**
 * Interface to be implemented by beans that want to be aware of their
 * bean name in a bean factory.
 */
public interface BeanNameAware extends Aware{

    void setBeanName(String name);

}
