package org.zywang.myspring.test.event;

import org.zywang.myspring.context.ApplicationListener;

import java.util.Date;

public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("Received from " + event.getSource() + "; Time: " + new Date());
        System.out.println("Message: " + event.getId() + ": " + event.getMessage());
    }
}
