package com.ozstrategy.credagility.core.domain.document.agent;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agent.AgentWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * This class is used to store AgentDocumentInstance information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:48
 */
@Entity
@Table(name = "AgentDocumentInstance")
public class AgentDocumentInstance extends BasicDocumentInstance implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -898424241536980282L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "documentInstance",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<AgentDocumentMetaDataValue> metaDataValues = new HashSet<AgentDocumentMetaDataValue>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "agentId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User owner;

  /** ResponsibleDocumentInstance. */
  @JoinColumn(
    name      = "previousInstanceId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgentDocumentInstance previousInstance;

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
   * @param   metaDataValue  AgentDocumentMetaDataValue
   *
   * @return  boolean
   */
  public boolean addMetaDataValue(AgentDocumentMetaDataValue metaDataValue) {
    metaDataValue.setDocumentInstance(this);

    return this.metaDataValues.add(metaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#addMetaDataValue(com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue)
   */
  @Override public boolean addMetaDataValue(DocumentMetaDataValue metaDataValue) {
    AgentDocumentMetaDataValue agentMetaDataValue = (AgentDocumentMetaDataValue) metaDataValue;

    return addMetaDataValue(agentMetaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#clearAllMetaDataValue()
   */
  @Override public void clearAllMetaDataValue() {
    for (AgentDocumentMetaDataValue metaDataValue : metaDataValues) {
      metaDataValue.clearValue();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getMetaDataValues()
   */
  @Override public Set<AgentDocumentMetaDataValue> getMetaDataValues() {
    return metaDataValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getOwner()
   */
  @Override public User getOwner() {
    return owner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getPreviousInstance()
   */
  @Override public AgentDocumentInstance getPreviousInstance() {
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
    if (businessObject instanceof AgentWorkflowBusinessObject) {
      setOwner((User) businessObject.getObject());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data values.
   *
   * @param  metaDataValues  Set
   */
  public void setMetaDataValues(Set<AgentDocumentMetaDataValue> metaDataValues) {
    this.metaDataValues = metaDataValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for owner.
   *
   * @param  owner  User
   */
  public void setOwner(User owner) {
    this.owner = owner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous instance.
   *
   * @param  previousInstance  AgentDocumentInstance
   */
  public void setPreviousInstance(AgentDocumentInstance previousInstance) {
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
    setPreviousInstance((AgentDocumentInstance) currentInstance);
  }
} // end class AgentDocumentInstance
