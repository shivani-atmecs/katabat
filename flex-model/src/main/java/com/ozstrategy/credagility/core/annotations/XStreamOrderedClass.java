package com.ozstrategy.credagility.core.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Created by Yang Wang on 2/15/14. This annotation that If the class need sort
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface XStreamOrderedClass { }
