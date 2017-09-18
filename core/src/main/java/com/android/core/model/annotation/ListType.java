package com.android.core.model.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.LinkedList;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/11/1 14:37
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListType {
    Class list() default LinkedList.class;
    Class value();
}
