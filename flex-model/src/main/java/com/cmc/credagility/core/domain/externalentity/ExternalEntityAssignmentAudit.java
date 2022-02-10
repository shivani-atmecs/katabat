package com.cmc.credagility.core.domain.externalentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.businesscontext.BCMetaDataField;
import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowTriggerSource;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowInstance;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowStep;


/**
 * Created by yongliu on 8/31/15.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  08/31/2015 17:22
 */
@Entity
@Table(name = "ExternalEntityAssignmentAudit")
public class ExternalEntityAssignmentAudit extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6021413665559792306L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "bciId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance bci;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "bcMetaDataFieldId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCMetaDataField bcMetaDataField;

  /** TODO: DOCUMENT ME! */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowTriggerSource entryChannel;

  /** TODO: DOCUMENT ME! */
  @Column(name = "fromEE")
  protected Long fromEEId;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(name = "toEE")
  protected Long toEEId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowInstanceId",
    nullable   = false,
    insertable = false,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowInstance workflowInstance;

  /** TODO: DOCUMENT ME! */
  protected Long workflowInstanceId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "stepId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci.
   *
   * @return  BusinessContextInstance
   */
  public BusinessContextInstance getBci() {
    return bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bc meta data field.
   *
   * @return  BCMetaDataField
   */
  public BCMetaDataField getBcMetaDataField() {
    return bcMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entry channel.
   *
   * @return  WorkflowTriggerSource
   */
  public WorkflowTriggerSource getEntryChannel() {
    return entryChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from EEId.
   *
   * @return  Long
   */
  public Long getFromEEId() {
    return fromEEId;
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
   * getter method for to EEId.
   *
   * @return  Long
   */
  public Long getToEEId() {
    return toEEId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow instance.
   *
   * @return  BCIWorkflowInstance
   */
  public BCIWorkflowInstance getWorkflowInstance() {
    return workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow instance id.
   *
   * @return  Long
   */
  public Long getWorkflowInstanceId() {
    return workflowInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow step.
   *
   * @return  BCIWorkflowStep
   */
  public BCIWorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci.
   *
   * @param  bci  BusinessContextInstance
   */
  public void setBci(BusinessContextInstance bci) {
    this.bci = bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bc meta data field.
   *
   * @param  bcMetaDataField  BCMetaDataField
   */
  public void setBcMetaDataField(BCMetaDataField bcMetaDataField) {
    this.bcMetaDataField = bcMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for entry channel.
   *
   * @param  entryChannel  WorkflowTriggerSource
   */
  public void setEntryChannel(WorkflowTriggerSource entryChannel) {
    this.entryChannel = entryChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from EEId.
   *
   * @param  fromEEId  Long
   */
  public void setFromEEId(Long fromEEId) {
    this.fromEEId = fromEEId;
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
   * setter method for to EEId.
   *
   * @param  toEEId  Long
   */
  public void setToEEId(Long toEEId) {
    this.toEEId = toEEId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow instance.
   *
   * @param  workflowInstance  BCIWorkflowInstance
   */
  public void setWorkflowInstance(BCIWorkflowInstance workflowInstance) {
    this.workflowInstance = workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow instance id.
   *
   * @param  workflowInstanceId  Long
   */
  public void setWorkflowInstanceId(Long workflowInstanceId) {
    this.workflowInstanceId = workflowInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow step.
   *
   * @param  workflowStep  BCIWorkflowStep
   */
  public void setWorkflowStep(BCIWorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }
} // end class ExternalEntityAssignmentAudit
