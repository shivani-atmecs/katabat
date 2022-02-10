package com.ozstrategy.credagility.core.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Created with IntelliJ IDEA. User: wangy Date: 12-5-18 Time: AM10:12 To change this template use File | Settings |
 * File Templates.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo</a>
 * @version  10/18/2014 11:49
 */
@Retention(RUNTIME)
@Target({ METHOD })
public @interface ParamFeature {
  int index() default 0;
  String key() default "feature";
  String methodName() default "getFeature";
}
