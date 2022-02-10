package com.ozstrategy.credagility.core.domain.document.agency;

import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * This class is used to store AgencyDocumentInstance information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:47
 */
@Entity
@Table(name = "AgencyDocumentInstance")
public class AgencyDocumentInstance extends BasicDocumentInstance implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -898424241536980282L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "documentInstance",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<AgencyDocumentMetaDataValue> metaDataValues = new HashSet<AgencyDocumentMetaDataValue>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "agencyId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role owner;

  /** ResponsibleDocumentInstance. */
  @JoinColumn(
    name      = "previousInstanceId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyDocumentInstance previousInstance;

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
   * @param   metaDataValue  AgencyDocumentMetaDataValue
   *
   * @return  boolean
   */
  public boolean addMetaDataValue(AgencyDocumentMetaDataValue metaDataValue) {
    metaDataValue.setDocumentInstance(this);

    return this.metaDataValues.add(metaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addMetaDataValue.
   *
   * @param   metaDataValue  DocumentMetaDataValue
   *
   * @return  boolean
   */
  @Override public boolean addMetaDataValue(DocumentMetaDataValue metaDataValue) {
    AgencyDocumentMetaDataValue agencyMetaDataValue = (AgencyDocumentMetaDataValue) metaDataValue;

    return addMetaDataValue(agencyMetaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * clearAllMetaDataValue.
   */
  @Override public void clearAllMetaDataValue() {
    for (AgencyDocumentMetaDataValue metaDataValue : metaDataValues) {
      metaDataValue.clearValue();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data values.
   *
   * @return  Set
   */
  @Override public Set<AgencyDocumentMetaDataValue> getMetaDataValues() {
    return metaDataValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for owner.
   *
   * @return  Role
   */
  @Override public Role getOwner() {
    return owner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous instance.
   *
   * @return  AgencyDocumentInstance
   */
  @Override public AgencyDocumentInstance getPreviousInstance() {
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
   * setter method for business object.
   *
   * @param  businessObject  WorkflowBusinessObject
   */
  @Override public void setBusinessObject(WorkflowBusinessObject businessObject) {
    if (businessObject instanceof AgencyWorkflowBusinessObject) {
      setOwner((Role) businessObject.getObject());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data values.
   *
   * @param  metaDataValues  Set
   */
  public void setMetaDataValues(Set<AgencyDocumentMetaDataValue> metaDataValues) {
    this.metaDataValues = metaDataValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for owner.
   *
   * @param  owner  Role
   */
  public void setOwner(Role owner) {
    this.owner = owner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous instance.
   *
   * @param  previousInstance  AgencyDocumentInstance
   */
  public void setPreviousInstance(AgencyDocumentInstance previousInstance) {
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
   * updatePreviousInstance.
   *
   * @param  currentInstance  BasicDocumentInstance
   */
  @Override public void updatePreviousInstance(BasicDocumentInstance currentInstance) {
    setPreviousInstance((AgencyDocumentInstance) currentInstance);
  }
} // end class AgencyDocumentInstance
