package com.ozstrategy.credagility.core.domain.workflow;

import com.ozstrategy.credagility.core.domain.audit.FindingType;

import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:40
 */
public class AuditAnswerItem implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2190420953651255247L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String comments;

  /** TODO: DOCUMENT ME! */
  protected Long elementId;

  /** TODO: DOCUMENT ME! */
  protected FindingType finding;

  /** TODO: DOCUMENT ME! */
  protected String severity;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AuditAnswerItem object.
   */
  public AuditAnswerItem() { }

  /**
   * Creates a new AuditAnswerItem object.
   *
   * @param  finding    DOCUMENT ME!
   * @param  severity   DOCUMENT ME!
   * @param  comments   DOCUMENT ME!
   * @param  elementId  DOCUMENT ME!
   */
  public AuditAnswerItem(FindingType finding, String severity, String comments, Long elementId) {
    this.finding   = finding;
    this.severity  = severity;
    this.comments  = comments;
    this.elementId = elementId;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for comments.
   *
   * @return  String
   */
  public String getComments() {
    return comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for element id.
   *
   * @return  Long
   */
  public Long getElementId() {
    return elementId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for finding.
   *
   * @return  FindingType
   */
  public FindingType getFinding() {
// if (finding == null) {
// return Boolean.FALSE;
// }

    return finding;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for severity.
   *
   * @return  String
   */
  public String getSeverity() {
    return severity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for comments.
   *
   * @param  comments  String
   */
  public void setComments(String comments) {
    this.comments = comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for element id.
   *
   * @param  elementId  Long
   */
  public void setElementId(Long elementId) {
    this.elementId = elementId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for finding.
   *
   * @param  finding  FindingType
   */
  public void setFinding(FindingType finding) {
    this.finding = finding;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for severity.
   *
   * @param  severity  String
   */
  public void setSeverity(String severity) {
    this.severity = severity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("AuditAnswerItem");
    sb.append("{comments='").append(comments).append('\'');
    sb.append(", elementId=").append(elementId);
    sb.append(", finding=").append(finding);
    sb.append(", severity='").append(severity).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class AuditAnswerItem
