package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.audit.FindingType;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditingSeverity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/18/13 : 2:49 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public class BasicWorkflowAuditTaskElement extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7045011842022943186L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Primary key. */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String comments;

  /**
   * @see  com.ozstrategy.credagility.core.domain.audit.FindingType
   */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected FindingType finding;

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditingSeverity
   */
  @Column(
    length   = 32,
    nullable = true
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowAuditingSeverity severity = WorkflowAuditingSeverity.LOW;

  // get from answer
  @Column private Integer answerHashCode;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  auditTaskElement  DOCUMENT ME!
   */
  public void copy(BasicWorkflowAuditTaskElement auditTaskElement) {
    this.setCreateDate(auditTaskElement.getCreateDate());
    this.setCreator(auditTaskElement.getCreator());
    this.setLastUpdateDate(new Date());
    this.setAnswerHashCode(auditTaskElement.getAnswerHashCode());
    this.setComments(auditTaskElement.getComments());
    this.setFinding(auditTaskElement.getFinding());
    this.setSeverity(auditTaskElement.getSeverity());
    this.setAnswerHashCode(auditTaskElement.getAnswerHashCode());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BasicWorkflowAuditTaskElement that = (BasicWorkflowAuditTaskElement) o;

    if ((answerHashCode != null) ? (!answerHashCode.equals(that.answerHashCode)) : (that.answerHashCode != null)) {
      return false;
    }

    if ((comments != null) ? (!comments.equals(that.comments)) : (that.comments != null)) {
      return false;
    }

    if (finding != that.finding) {
      return false;
    }

    if (severity != that.severity) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAnswerHashCode() {
    return answerHashCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getComments() {
    return comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public FindingType getFinding() {
    return finding;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowAuditingSeverity getSeverity() {
    return severity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((comments != null) ? comments.hashCode() : 0);
    result = (31 * result) + ((finding != null) ? finding.hashCode() : 0);
    result = (31 * result) + ((severity != null) ? severity.hashCode() : 0);
    result = (31 * result) + ((answerHashCode != null) ? answerHashCode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerHashCode  DOCUMENT ME!
   */
  public void setAnswerHashCode(Integer answerHashCode) {
    this.answerHashCode = answerHashCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  comments  DOCUMENT ME!
   */
  public void setComments(String comments) {
    this.comments = comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  finding  DOCUMENT ME!
   */
  public void setFinding(FindingType finding) {
    this.finding = finding;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  severity  DOCUMENT ME!
   */
  public void setSeverity(WorkflowAuditingSeverity severity) {
    this.severity = severity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("BasicWorkflowAuditTaskElement{");
    sb.append("comments='").append(comments).append('\'');
    sb.append(", finding=").append(finding);
    sb.append(", severity=").append(severity);
    sb.append(", answerHashCode=").append(answerHashCode);
    sb.append('}');

    return sb.toString();
  }
} // end class BasicWorkflowAuditTaskElement
