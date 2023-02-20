package org.zywang.myspring.context;

public interface ApplicationEventPublisher {

    // Notify all listeners registered with this application of an application event
    void publishEvent(ApplicationEvent event);

}
