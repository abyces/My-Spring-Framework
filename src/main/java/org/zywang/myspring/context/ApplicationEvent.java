package org.zywang.myspring.context;

import java.util.EventObject;

/**
 * a prototypical Event
 */
public abstract class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }

}
