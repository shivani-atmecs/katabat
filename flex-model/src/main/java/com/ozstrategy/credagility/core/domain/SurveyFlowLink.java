package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowLinkDrivenType;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * SurveyFlow Link !
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 11:44
 */
@Entity
@Table(
  name              = "SurveyFlowLink",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "fromId", "toId", "drivenType" }) }
)
public class SurveyFlowLink extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2493622132370910478L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Criteria for SurveyFlow Link. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String criteria;


  /** WorkflowLink Driven run Type. */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowLinkDrivenType drivenType = WorkflowLinkDrivenType.MANUALLY;

  /** The start of this link. */
  @JoinColumn(
    name       = "fromId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowNode from;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** priority the order. */
  @Column(nullable = false)
  protected Integer priority = 1;

  /** The SurveyFlow which this link belong to. */
  @JoinColumn(
    name       = "surveyFlowId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlow surveyFlow;

  /** The end of this link. */
  @JoinColumn(
    name       = "toId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowNode to;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  newLink  SurveyFlowLink
   */
  public void deepCopy(SurveyFlowLink newLink) {
    setCriteria(newLink.getCriteria());
    setPriority(newLink.getPriority());
    setDrivenType(newLink.getDrivenType());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
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

    SurveyFlowLink that = (SurveyFlowLink) o;

    if ((from != null) ? (!from.equals(that.from)) : (that.from != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((to != null) ? (!to.equals(that.to)) : (that.to != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  String
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for driven type.
   *
   * @return  WorkflowLinkDrivenType
   */
  public WorkflowLinkDrivenType getDrivenType() {
    if (drivenType == null) {
      return WorkflowLinkDrivenType.MANUALLY;
    }

    return drivenType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from.
   *
   * @return  SurveyFlowNode
   */
  public SurveyFlowNode getFrom() {
    return from;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getSurveyFlow() {
    return surveyFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for to.
   *
   * @return  SurveyFlowNode
   */
  public SurveyFlowNode getTo() {
    return to;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((from != null) ? from.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((to != null) ? to.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria.
   *
   * @param  criteria  String
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for driven type.
   *
   * @param  drivenType  WorkflowLinkDrivenType
   */
  public void setDrivenType(WorkflowLinkDrivenType drivenType) {
    this.drivenType = drivenType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from.
   *
   * @param  from  SurveyFlowNode
   */
  public void setFrom(SurveyFlowNode from) {
    this.from = from;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey flow.
   *
   * @param  surveyFlow  SurveyFlow
   */
  public void setSurveyFlow(SurveyFlow surveyFlow) {
    this.surveyFlow = surveyFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for to.
   *
   * @param  to  SurveyFlowNode
   */
  public void setTo(SurveyFlowNode to) {
    this.to = to;
  }
} // end class SurveyFlowLink
