package com.ozstrategy.credagility.core.domain.document.responsible;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.ozstrategy.credagility.core.domain.SurveyFlowStep;
import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * This class is used to store ResponsibleDocumentInstance information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 15:02
 */
@Entity
@Table(name = "ResponsibleDocumentInstance")
public class ResponsibleDocumentInstance extends BasicDocumentInstance implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -898424241536980282L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "documentInstance",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<ResponsibleDocumentMetaDataValue> metaDataValues = new HashSet<ResponsibleDocumentMetaDataValue>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "responsibleId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible owner;

  /** ResponsibleDocumentInstance. */
  @JoinColumn(
    name      = "previousInstanceId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ResponsibleDocumentInstance previousInstance;

  /** Ref WorkflowStep. */
  @JoinColumn(
    name       = "workflowStepId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addMetaDataValue.
   *
   * @param   metaDataValue  ResponsibleDocumentMetaDataValue
   *
   * @return  boolean
   */
  public boolean addMetaDataValue(ResponsibleDocumentMetaDataValue metaDataValue) {
    metaDataValue.setDocumentInstance(this);

    return this.metaDataValues.add(metaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#addMetaDataValue(com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue)
   */
  @Override public boolean addMetaDataValue(DocumentMetaDataValue metaDataValue) {
    ResponsibleDocumentMetaDataValue respDocMetaDataValue = (ResponsibleDocumentMetaDataValue) metaDataValue;

    return addMetaDataValue(respDocMetaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#clearAllMetaDataValue()
   */
  @Override public void clearAllMetaDataValue() {
    for (ResponsibleDocumentMetaDataValue metaDataValue : metaDataValues) {
      metaDataValue.clearValue();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getMetaDataValues()
   */
  @Override public Set<ResponsibleDocumentMetaDataValue> getMetaDataValues() {
    return metaDataValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getOwner()
   */
  @Override public Responsible getOwner() {
    return owner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getPreviousInstance()
   */
  @Override public ResponsibleDocumentInstance getPreviousInstance() {
    return previousInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow step.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#setBusinessObject(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject)
   */
  @Override public void setBusinessObject(WorkflowBusinessObject businessObject) {
    // nothing
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data values.
   *
   * @param  metaDataValues  Set
   */
  public void setMetaDataValues(Set<ResponsibleDocumentMetaDataValue> metaDataValues) {
    this.metaDataValues = metaDataValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for owner.
   *
   * @param  owner  Responsible
   */
  public void setOwner(Responsible owner) {
    this.owner = owner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous instance.
   *
   * @param  previousInstance  ResponsibleDocumentInstance
   */
  public void setPreviousInstance(ResponsibleDocumentInstance previousInstance) {
    this.previousInstance = previousInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow step.
   *
   * @param  workflowStep  SurveyFlowStep
   */
  public void setWorkflowStep(SurveyFlowStep workflowStep) {
    this.workflowStep = workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#updatePreviousInstance(com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance)
   */
  @Override public void updatePreviousInstance(BasicDocumentInstance currentInstance) {
    setPreviousInstance((ResponsibleDocumentInstance) currentInstance);
  }
} // end class ResponsibleDocumentInstance
