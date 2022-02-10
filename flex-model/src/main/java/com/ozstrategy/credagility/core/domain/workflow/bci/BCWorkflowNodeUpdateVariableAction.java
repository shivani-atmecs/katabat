package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.ozstrategy.credagility.core.util.DataFormatter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/20/13 : 3:46 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCWorkflowNodeUpdateVariableAction")
public class BCWorkflowNodeUpdateVariableAction extends BCWorkflowNodeAction {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1782700208983921074L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String uniqueIdOnNode;

  /** node . */
  @Column(length = 512)
  protected String value;

  /** node . */
  @JoinColumn(
    name       = "variableId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowUpdateVariable variable;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BCWorkflowNodeAction#equals(Object)
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

    BCWorkflowNodeUpdateVariableAction that = (BCWorkflowNodeUpdateVariableAction) o;

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }

    if ((variable != null) ? (!variable.equals(that.variable)) : (that.variable != null)) {
      return false;
    }

    if ((uniqueIdOnNode != null) ? (!uniqueIdOnNode.equals(that.uniqueIdOnNode)) : (that.uniqueIdOnNode != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    if (this.getVariable() != null) {
      return this.getVariable().getName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Object getDataValue() {
    String type = this.getVariable().getDataType();

    if ("Integer".equalsIgnoreCase(type)
          || "java.lang.Integer".equalsIgnoreCase(type)) {
      return new Integer(value);
    } else if ("Long".equalsIgnoreCase(type)
          || "java.lang.Long".equalsIgnoreCase(type)) {
      return new Long(value);
    } else if ("BigDecimal".equalsIgnoreCase(type)
          || "java.math.BigDecimal".equalsIgnoreCase(type)) {
      return new BigDecimal(value);
    } else if ("Boolean".equalsIgnoreCase(type)
          || "java.lang.Boolean".equalsIgnoreCase(type)) {
      return Boolean.valueOf(value);
    } else if ("Date".equalsIgnoreCase(type)
          || "java.util.Date".equalsIgnoreCase(type)) {
      try {
        return new SimpleDateFormat(DataFormatter.getDefaultDatePattern()).parse(value);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    } else if ("String".equalsIgnoreCase(type)
          || "java.lang.String".equalsIgnoreCase(type)) {
      return value;
    }

    return null;
  } // end method getDataValue

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique id on node.
   *
   * @return  String
   */
  public String getUniqueIdOnNode() {
    return uniqueIdOnNode;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowUpdateVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BCWorkflowNodeAction#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);
    result = (31 * result) + ((variable != null) ? variable.hashCode() : 0);
    result = (31 * result) + ((uniqueIdOnNode != null) ? uniqueIdOnNode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique id on node.
   *
   * @param  uniqueIdOnNode  String
   */
  public void setUniqueIdOnNode(String uniqueIdOnNode) {
    this.uniqueIdOnNode = uniqueIdOnNode;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variable  DOCUMENT ME!
   */
  public void setVariable(BCWorkflowUpdateVariable variable) {
    this.variable = variable;
  }
} // end class BCWorkflowNodeUpdateVariableAction
