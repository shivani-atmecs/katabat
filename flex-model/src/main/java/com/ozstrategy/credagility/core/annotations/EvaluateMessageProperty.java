package com.ozstrategy.credagility.core.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Document for new class.
 *
 * <p>: Wang Yang : 12-10-30 : PM2:45</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Retention(RUNTIME)
@Target({ FIELD })
public @interface EvaluateMessageProperty {
  boolean unescapeHtml() default true;
}
