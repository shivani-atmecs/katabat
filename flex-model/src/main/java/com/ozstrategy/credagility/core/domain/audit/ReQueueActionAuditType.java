package com.ozstrategy.credagility.core.domain.audit;


/**
 * ReQueueAction AuditType.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:28
 */
public enum ReQueueActionAuditType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  R, I;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   auditType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static ReQueueActionAuditType convert(String auditType) {
    if ((auditType == null) || auditType.trim().isEmpty()) {
      return null;
    }

    return valueOf(auditType);
  }

}
