package com.ozstrategy.credagility.core.el;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * This class is to register function object into expression engine.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/28/2014 11:27 AM
 */
public class ELFunctionRegister {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final HashMap<String, Object> registeredFunctions = new LinkedHashMap<>();
  private static final Set<Class>              registeredClasses   = new LinkedHashSet<Class>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for all exposed classes.
   *
   * @return  Set
   */
  public static final Set<Class> getAllExposedClasses() {
    return registeredClasses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all functions.
   *
   * @return  HashMap
   */
  public static final HashMap<String, Object> getAllFunctions() {
    return registeredFunctions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * <p>Register a class into expression engine. For example, you can register a class like:</p>
   *
   * <pre>
   ELFunctionRegister.register(EvalManager.class);
   * </pre>
   *
   * <p>Then you can evaluate a expression by expression engine, and the expression can use any static methods defined
   * in EvalManager:</p>
   *
   * <pre>
       expressionService.evaluate("getFormattedDate(.....
   * </pre>
   *
   * @param   clazz  name String
   *
   * @return  When return false, it means the class is registered failed; else registered successfully.
   */
  public static boolean registerExposedClass(Class clazz) {
    boolean flag = registeredClasses.contains(clazz);

    if (flag) {
      return false;
    }

    return registeredClasses.add(clazz);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * <p>Register an object instance into expression engine. For example, you can register a object like:</p>
   *
   * <pre>
   ELFunctionRegister.registerFunction("evalManager", new EvalManager());
   * </pre>
   *
   * <p>Then you can evaluate a expression by expression engine, and the expression can be:</p>
   *
   * <pre>
       expressionService.evaluate("evalManager.getFormattedDate(.....
   * </pre>
   *
   * @param   name                    String
   * @param   functionObjectInstance  Object
   *
   * @return  When return false, it means the object is registered failed; else registered successfully.
   */
  public static boolean registerFunction(String name, Object functionObjectInstance) {
    boolean flag = registeredFunctions.containsKey(name);

    if (flag) {
      return false;
    }

    return registeredFunctions.put(name, functionObjectInstance) == null;
  }
} // end class ELFunctionRegister
