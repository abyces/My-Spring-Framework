package org.zywang.myspring.factory.support;

import org.zywang.myspring.BeansException;
import org.zywang.myspring.core.io.Resource;
import org.zywang.myspring.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();
    ResourceLoader getResourceLoader();
    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(Resource... resources) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;

}
