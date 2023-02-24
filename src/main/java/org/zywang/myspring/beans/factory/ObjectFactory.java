package org.zywang.myspring.beans.factory;

import org.zywang.myspring.beans.BeansException;

public interface ObjectFactory<T> {

    T getObject() throws BeansException;

}
