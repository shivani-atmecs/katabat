package com.ozstrategy.credagility.core.domain.audit;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:09
 */
public enum AuditType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  C, U, D;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   auditType  String
   *
   * @return  AuditType
   */
  public static AuditType convert(String auditType) {
    if ((auditType == null) || auditType.trim().isEmpty()) {
      return null;
    }

    return valueOf(auditType);
  }

}
