package com.ozstrategy.credagility.core.domain.document;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:54
 */
public enum DocumentDeliveryType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  /** Email Channel. */
  EMAIL,

  /** Letter Channel. */
  Letter,

  /** SMS Channel. */
  SMS,

  /** IVR Channel. */
  IVR,

  /** Dialer Channel. */
  DIALER,

  /** PDF Channel. */
  PDF,

  /** Disclosure Channel. */
  DISCLOSURE,

  /** Workflow Channel. */
  WORKFLOW;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   documentType  String
   *
   * @return  DocumentDeliveryType
   */
  public static DocumentDeliveryType convert(String documentType) {
    if ((documentType == null) || documentType.trim().isEmpty()) {
      return null;
    }

    return valueOf(documentType);
  }

}
