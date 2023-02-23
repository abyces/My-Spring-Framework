package org.zywang.myspring.beans.factory.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    /**
     * the actual value expression: e.g. "#{systemProperties.myProp}"
     * @return
     */
    String value();

}
