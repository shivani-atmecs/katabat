package com.ozstrategy.credagility.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created with IntelliJ IDEA. User: liaodongming Date: 12-5-23 Time: AM10:20 To change this template use File |
 * Settings | File Templates.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo</a>
 * @version  10/18/2014 11:49
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface EscapeProperty { }
