package com.ozstrategy.credagility.core.domain;

/**
 * Created with IntelliJ IDEA.
 *
 * <pre>
     Order:
         RETIRE
         PUBLISH
         DISABLE
         ENABLE
         DELETE
         UPDATE
         CREATE
 * </pre>
 *
 * <p>: Wang Yang : 13-2-22 : PM3:41</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public enum AuditOperation {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CREATE,


  UPDATE,


  DELETE,


  DISABLE,


  ENABLE,


  PUBLISH,


  RETIRE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   operationType  String
   *
   * @return  AuditOperation
   */
  public static AuditOperation convert(String operationType) {
    if ((operationType == null) || operationType.trim().isEmpty()) {
      return null;
    }

    return valueOf(operationType);
  }
}
