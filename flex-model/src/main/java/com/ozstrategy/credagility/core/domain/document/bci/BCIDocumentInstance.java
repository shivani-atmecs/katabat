package com.ozstrategy.credagility.core.domain.document.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowStep;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * This class is used to store BCIDocumentInstance information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:52
 */
@Entity
@Table(name = "BCIDocumentInstance")
public class BCIDocumentInstance extends BasicDocumentInstance implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -898424241536980282L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BusinessContextInstance PK bciId. */
  @JoinColumn(
    name       = "bciId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance bci;


  /** BCIDocumentMetaDataValue. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "documentInstance",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<BCIDocumentMetaDataValue> metaDataValues = new HashSet<BCIDocumentMetaDataValue>();

  /** ResponsibleDocumentInstance. */
  @JoinColumn(
    name      = "previousInstanceId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIDocumentInstance previousInstance;

  /** Ref WorkflowStep. */
  @JoinColumn(
    name       = "workflowStepId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addMetaDataValue.
   *
   * @param   metaDataValue  BCIDocumentMetaDataValue
   *
   * @return  boolean
   */
  public boolean addMetaDataValue(BCIDocumentMetaDataValue metaDataValue) {
    metaDataValue.setDocumentInstance(this);

    return this.metaDataValues.add(metaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#addMetaDataValue(com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue)
   */
  @Override public boolean addMetaDataValue(DocumentMetaDataValue metaDataValue) {
    BCIDocumentMetaDataValue agencyMetaDataValue = (BCIDocumentMetaDataValue) metaDataValue;

    return addMetaDataValue(agencyMetaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#clearAllMetaDataValue()
   */
  @Override public void clearAllMetaDataValue() {
    for (BCIDocumentMetaDataValue metaDataValue : metaDataValues) {
      metaDataValue.clearValue();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getDocumentMetaDataValues()
   */
  @Override public Map<Long, DocumentMetaDataValue> getDocumentMetaDataValues() {
    Map<Long, DocumentMetaDataValue> metaDataValueMap = new HashMap<Long, DocumentMetaDataValue>();

    for (BCIDocumentMetaDataValue metaDataValue : metaDataValues) {
      metaDataValueMap.put(metaDataValue.getMetaData().getId(), metaDataValue);
    }

    return metaDataValueMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getMetaDataValues()
   */
  @Override public Set<BCIDocumentMetaDataValue> getMetaDataValues() {
    return metaDataValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getOwner()
   */
  @Override public BusinessContextInstance getOwner() {
    return bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getPreviousInstance()
   */
  @Override public BCIDocumentInstance getPreviousInstance() {
    return previousInstance;
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
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#setBusinessObject(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject)
   */
  @Override public void setBusinessObject(WorkflowBusinessObject businessObject) {
    if (businessObject instanceof BCIWorkflowBusinessObject) {
      setBci(((BCIWorkflowBusinessObject) businessObject).getBci());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data values.
   *
   * @param  metaDataValues  Set
   */
  public void setMetaDataValues(Set<BCIDocumentMetaDataValue> metaDataValues) {
    this.metaDataValues = metaDataValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous instance.
   *
   * @param  previousInstance  BCIDocumentInstance
   */
  public void setPreviousInstance(BCIDocumentInstance previousInstance) {
    this.previousInstance = previousInstance;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#updatePreviousInstance(com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance)
   */
  @Override public void updatePreviousInstance(BasicDocumentInstance currentInstance) {
    setPreviousInstance((BCIDocumentInstance) currentInstance);
  }
} // end class BCIDocumentInstance
