package com.ozstrategy.credagility.core.domain.document.enterprise;

import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * This class is used to store EnterpriseDocumentInstance information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:57
 */
@Entity
@Table(name = "EnterpriseDocumentInstance")
public class EnterpriseDocumentInstance extends BasicDocumentInstance implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -342351061795688685L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "documentInstance",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<EnterpriseDocumentMetaDataValue> metaDataValues = new HashSet<EnterpriseDocumentMetaDataValue>();


  /** ResponsibleDocumentInstance. */
  @JoinColumn(
    name      = "previousInstanceId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentInstance previousInstance;

  /** Ref WorkflowStep. */
  @JoinColumn(
    name       = "workflowStepId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addMetaDataValue.
   *
   * @param   metaDataValue  EnterpriseDocumentMetaDataValue
   *
   * @return  boolean
   */
  public boolean addMetaDataValue(EnterpriseDocumentMetaDataValue metaDataValue) {
    metaDataValue.setDocumentInstance(this);

    return this.metaDataValues.add(metaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#addMetaDataValue(com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue)
   */
  @Override public boolean addMetaDataValue(DocumentMetaDataValue metaDataValue) {
    EnterpriseDocumentMetaDataValue enterMetaDataValue = (EnterpriseDocumentMetaDataValue) metaDataValue;

    return addMetaDataValue(enterMetaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#clearAllMetaDataValue()
   */
  @Override public void clearAllMetaDataValue() {
    for (EnterpriseDocumentMetaDataValue metaDataValue : metaDataValues) {
      metaDataValue.clearValue();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getMetaDataValues()
   */
  @Override public Set<EnterpriseDocumentMetaDataValue> getMetaDataValues() {
    return metaDataValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getOwner()
   */
  @Override public Object getOwner() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getPreviousInstance()
   */
  @Override public EnterpriseDocumentInstance getPreviousInstance() {
    return previousInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow step.
   *
   * @return  WorkflowStep
   */
  public WorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#setBusinessObject(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject)
   */
  @Override public void setBusinessObject(WorkflowBusinessObject businessObject) {
    // nothing to do, as its enterprise level.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data values.
   *
   * @param  metaDataValues  Set
   */
  public void setMetaDataValues(Set<EnterpriseDocumentMetaDataValue> metaDataValues) {
    this.metaDataValues = metaDataValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous instance.
   *
   * @param  previousInstance  EnterpriseDocumentInstance
   */
  public void setPreviousInstance(EnterpriseDocumentInstance previousInstance) {
    this.previousInstance = previousInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow step.
   *
   * @param  workflowStep  WorkflowStep
   */
  public void setWorkflowStep(WorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#updatePreviousInstance(com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance)
   */
  @Override public void updatePreviousInstance(BasicDocumentInstance currentInstance) {
    setPreviousInstance((EnterpriseDocumentInstance) currentInstance);
  }
} // end class EnterpriseDocumentInstance
