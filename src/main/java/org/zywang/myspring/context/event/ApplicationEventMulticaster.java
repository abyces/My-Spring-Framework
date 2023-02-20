package org.zywang.myspring.context.event;

import org.zywang.myspring.context.ApplicationEvent;
import org.zywang.myspring.context.ApplicationListener;

public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    // Multicast the given application event to appropriate listeners.
    void multicastEvent(ApplicationEvent event);

}
