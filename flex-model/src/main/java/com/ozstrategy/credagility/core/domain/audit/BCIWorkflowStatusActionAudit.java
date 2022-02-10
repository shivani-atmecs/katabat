package com.ozstrategy.credagility.core.domain.audit;

import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.workflow.BCIWorkflowStatusAction;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 17:04
 */
@Entity public class BCIWorkflowStatusActionAudit extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Long actionId;


  /** TODO: DOCUMENT ME! */
  @Column(length = 5)
  /**
   *  'C' 'U' 'D'
   */
  protected String auditType;


  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String criteria;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  protected String triggerType;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new SurveyFlowStatusActionAudit object.
   */
  public BCIWorkflowStatusActionAudit() { }

  /**
   * Creates a new SurveyFlowStatusActionAudit object.
   *
   * @param  action  $param.type$
   * @param  type    $param.type$
   */
  public BCIWorkflowStatusActionAudit(BCIWorkflowStatusAction action, AuditType type) {
    this.criteria       = action.getCriteria();
    this.actionId       = action.getId();
    this.auditType      = type.name();
    this.triggerType    = action.getTriggerType().name();
    this.creator        = action.getCreator();
    this.lastUpdater    = action.getLastUpdater();
    this.createDate     = action.getCreateDate();
    this.lastUpdateDate = action.getLastUpdateDate();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getActionId() {
    return actionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getAuditType() {
    return auditType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getTriggerType() {
    return triggerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setActionId.
   *
   * @param  actionId  $param.type$
   */
  public void setActionId(Long actionId) {
    this.actionId = actionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAuditType.
   *
   * @param  auditType  $param.type$
   */
  public void setAuditType(String auditType) {
    this.auditType = auditType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCriteria.
   *
   * @param  criteria  $param.type$
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTriggerType.
   *
   * @param  triggerType  $param.type$
   */
  public void setTriggerType(String triggerType) {
    this.triggerType = triggerType;
  }

} // end class BCIWorkflowStatusActionAudit
