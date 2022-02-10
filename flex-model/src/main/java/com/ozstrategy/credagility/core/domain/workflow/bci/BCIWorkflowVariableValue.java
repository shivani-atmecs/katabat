package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowVariableValue;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/19/13 : 3:34 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCIWorkflowVariableValue")
public class BCIWorkflowVariableValue extends BasicWorkflowVariableValue implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8282648638040142012L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BusinessContextInstance PK bciId. */
  @JoinColumn(
    name       = "bciId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance bci;


  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Ref WorkflowStep. */
  @JoinColumn(
    name       = "workflowStepId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowStep workflowStep;

  /** WorkflowVariable link variableId. */
  @JoinColumn(
    name     = "variableId",
    nullable = false
  )
  @ManyToOne private BaseVariable variable;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowVariableValue#createBusinessObject()
   */
  @Override public WorkflowBusinessObject createBusinessObject() {
    BCIWorkflowBusinessObject obj = new BCIWorkflowBusinessObject();
    obj.setBci(bci);

    return obj;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowVariableValue#equals(Object)
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

    BCIWorkflowVariableValue that = (BCIWorkflowVariableValue) o;

    if ((bci != null) ? (!bci.equals(that.bci)) : (that.bci != null)) {
      return false;
    }

    if ((variable != null) ? (!variable.equals(that.variable)) : (that.variable != null)) {
      return false;
    }

    if ((workflowStep != null) ? (!workflowStep.equals(that.workflowStep)) : (that.workflowStep != null)) {
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
  public BusinessContextInstance getBci() {
    return bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BaseVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((bci != null) ? bci.hashCode() : 0);
    result = (31 * result) + ((workflowStep != null) ? workflowStep.hashCode() : 0);
    result = (31 * result) + ((variable != null) ? variable.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bci  DOCUMENT ME!
   */
  public void setBci(BusinessContextInstance bci) {
    this.bci = bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowVariableValue#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) {
    setBci((BusinessContextInstance) businessObject);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variable  DOCUMENT ME!
   */
  public void setVariable(BaseVariable variable) {
    this.variable = variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowStep  DOCUMENT ME!
   */
  public void setWorkflowStep(BCIWorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }
} // end class BCIWorkflowVariableValue
