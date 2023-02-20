package org.zywang.myspring.test.event;

import org.zywang.myspring.context.ApplicationListener;
import org.zywang.myspring.context.event.ContextClosedEvent;

public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("Close event：" + this.getClass().getName());
    }

}
