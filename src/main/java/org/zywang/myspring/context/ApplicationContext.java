package org.zywang.myspring.context;

import org.zywang.myspring.beans.factory.HierarchicalBeanFactory;
import org.zywang.myspring.beans.factory.ListableBeanFactory;
import org.zywang.myspring.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
