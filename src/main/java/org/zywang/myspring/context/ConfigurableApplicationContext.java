package org.zywang.myspring.context;

import org.zywang.myspring.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;

}
