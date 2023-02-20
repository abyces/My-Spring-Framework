package org.zywang.myspring.test.event;

import org.zywang.myspring.context.ApplicationListener;
import org.zywang.myspring.context.event.ContextRefreshedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Refresh event：" + this.getClass().getName());
    }

}
