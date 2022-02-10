package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCChannelAction;

import javax.persistence.*;


/**
 * Created with IntelliJ IDEA. User: weitang Date: 14-8-5 Time: PM4:30 To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCWorkflowChannelAction")
public class BCWorkflowChannelAction extends BCWorkflowAction {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5252866526463277609L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** node . */
  @JoinColumn(
    name       = "actionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCChannelAction action;

  /** node . */
  @Column(length = 512)
  protected String value;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  BCWorkflowChannelAction
   */
  public void deepCopy(BCWorkflowChannelAction copyFrom) {
    super.deepCopy(copyFrom);
    setAction(copyFrom.getAction());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BCWorkflowAction#equals(Object)
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

    BCWorkflowChannelAction that = (BCWorkflowChannelAction) o;

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }

    if ((action != null) ? (!action.equals(that.action)) : (that.action != null)) {
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
  public BCChannelAction getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    if (this.getAction() != null) {
      return this.getAction().getName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BCWorkflowAction#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  action  DOCUMENT ME!
   */
  public void setAction(BCChannelAction action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  value  DOCUMENT ME!
   */
  public void setValue(String value) {
    this.value = value;
  }

} // end class BCWorkflowChannelAction
