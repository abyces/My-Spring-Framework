package org.zywang.myspring.context.event;

import org.zywang.myspring.context.ApplicationContext;
import org.zywang.myspring.context.ApplicationEvent;

public class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}
