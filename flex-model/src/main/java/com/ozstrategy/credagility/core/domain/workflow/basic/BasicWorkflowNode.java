package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeType;

import javax.persistence.*;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * @author   $author$
 * @version  $Revision$, $Date$ : Wang Yang : 13-2-19 : PM5:22
 */
@MappedSuperclass public abstract class BasicWorkflowNode extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7706053165845179776L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> allow this node Single Point of Contact. */
  @Column(
    name             = "allowSPOC",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSPOC;

  /** <code>true</code> allow this node execute on flex site. */
  @Column(
    name             = "allowWeb",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowWeb;

  /** <code>true</code> after finished this node, can not update this node data any more. */
  @Column(
    name             = "noRegret",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean noRegret = false;

  /** <code>true</code> this node is root node. */
  @Column(
    name             = "root",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean root = false;

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeType
   */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowNodeType type = WorkflowNodeType.SURVEY_NODE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<User> getAssignAgents();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<Role> getAssignRoles();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<? extends BasicWorkflowLink> getInSet();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract String getName();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<? extends BasicWorkflowLink> getOutSet();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<? extends BasicWorkflowLink> getSystemOutputLinks();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BasicWorkflow getWorkflow();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  assignAgents  DOCUMENT ME!
   */
  public abstract void setAssignAgents(Set<User> assignAgents);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  assignRoles  DOCUMENT ME!
   */
  public abstract void setAssignRoles(Set<Role> assignRoles);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    BasicWorkflowNode that = (BasicWorkflowNode) o;

    if ((noRegret != null) ? (!noRegret.equals(that.noRegret)) : (that.noRegret != null)) {
      return false;
    }

    if ((root != null) ? (!root.equals(that.root)) : (that.root != null)) {
      return false;
    }

    if (type != that.type) {
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
  public Boolean getAllowSPOC() {
    if (allowSPOC == null) {
      return Boolean.FALSE;
    }

    return allowSPOC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowWeb() {
    if (allowWeb == null) {
      return Boolean.FALSE;
    }

    return allowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getNoRegret() {
    if (noRegret == null) {
      return Boolean.FALSE;
    }

    return noRegret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getRoot() {
    if (root == null) {
      return Boolean.FALSE;
    }

    return root;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowNodeType getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = (noRegret != null) ? noRegret.hashCode() : 0;
    result = (31 * result) + ((root != null) ? root.hashCode() : 0);
    result = (31 * result) + type.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  role  DOCUMENT ME!
   */
  public void removeAssignedRole(Role role) {
    if (null != role) {
      this.getAssignRoles().remove(role);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowSPOC  DOCUMENT ME!
   */
  public void setAllowSPOC(Boolean allowSPOC) {
    this.allowSPOC = allowSPOC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowWeb  DOCUMENT ME!
   */
  public void setAllowWeb(Boolean allowWeb) {
    this.allowWeb = allowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  noRegret  DOCUMENT ME!
   */
  public void setNoRegret(Boolean noRegret) {
    this.noRegret = noRegret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  root  DOCUMENT ME!
   */
  public void setRoot(Boolean root) {
    this.root = root;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  type  DOCUMENT ME!
   */
  public void setType(WorkflowNodeType type) {
    this.type = type;
  }
} // end class BasicWorkflowNode
