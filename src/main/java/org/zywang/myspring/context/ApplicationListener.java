package org.zywang.myspring.context;

import java.util.EventListener;

public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    // handle an event
    void onApplicationEvent(E event);

}
