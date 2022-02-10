package com.ozstrategy.credagility.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created by Yang Wang on 2/15/14. target filed will at last, the complexity filed will be at end (XStreamOrdered)
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface XStreamOrderedField {
  int order() default -1;
}
