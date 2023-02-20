package org.zywang.myspring.context.event;

public class ContextRefreshedEvent extends ContextClosedEvent {

    public ContextRefreshedEvent(Object source) {
        super(source);
    }

}
