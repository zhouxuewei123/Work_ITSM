/**
 * @Title: TreeNodeLabel.java
 * @Package com.sloop.treeview.utils.annotation
 * Copyright: Copyright (c) 2015
 * 
 * @author sloop
 * @date 2015年2月21日 上午4:26:46
 * @version V1.0
 */

package com.android.core.widget.treeview.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: TreeNodeLabel
 * @author sloop
 * @date 2015年2月21日 上午4:26:46
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TreeNodeLabel {

}
