package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.EnterpriseHotSpot;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 11:31
 */
@Entity
@Table(
  name = "EnterpriseWorkflowAssignedHotSpot"

// ,uniqueConstraints = {
// @UniqueConstraint(
// name          = "hotSpotId",
// columnNames   = { "hotSpotId" }
// ),
// @UniqueConstraint(
// name          = "workflowId",
// columnNames   = { "workflowId" }
// )
// }
)
public class EnterpriseWorkflowAssignedHotSpot extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3059488600885439423L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean openInCurrentTab;

  /** TODO: DOCUMENT ME! */
  @Column(length = 50)
  protected String uniqueIdOnNode;

  @Column(columnDefinition = "LONGTEXT")
  @Lob private String aliasName;

  @JoinColumn(
    name       = "hotSpotId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private EnterpriseHotSpot hotSpot;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @JoinColumn(
    name       = "workflowId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private EnterpriseWorkflow workflow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    EnterpriseWorkflowAssignedHotSpot that = (EnterpriseWorkflowAssignedHotSpot) o;

    if ((aliasName != null) ? (!aliasName.equals(that.aliasName)) : (that.aliasName != null)) {
      return false;
    }

    if (!hotSpot.equals(that.hotSpot)) {
      return false;
    }

    if (!workflow.equals(that.workflow)) {
      return false;
    }

    if ((uniqueIdOnNode != null) ? (!uniqueIdOnNode.equals(that.uniqueIdOnNode)) : (that.uniqueIdOnNode != null)) {
      return false;
    }


    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getAliasName() {
    return aliasName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseHotSpot.
   *
   * @return  EnterpriseHotSpot.
   */
  public EnterpriseHotSpot getHotSpot() {
    return hotSpot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for open new tab.
   *
   * @return  Boolean
   */
  public Boolean getOpenInCurrentTab() {
    if (openInCurrentTab == null) {
      return Boolean.FALSE;
    }

    return openInCurrentTab;
  }

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
   * EnterpriseWorkflow.
   *
   * @return  EnterpriseWorkflow.
   */
  public EnterpriseWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + hotSpot.hashCode();
    result = (31 * result) + workflow.hashCode();
    result = (31 * result) + ((aliasName != null) ? aliasName.hashCode() : 0);
    result = (31 * result) + ((uniqueIdOnNode != null) ? uniqueIdOnNode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAliasName.
   *
   * @param  aliasName  $param.type$
   */
  public void setAliasName(String aliasName) {
    this.aliasName = aliasName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setHotSpot.
   *
   * @param  hotSpot  $param.type$
   */
  public void setHotSpot(EnterpriseHotSpot hotSpot) {
    this.hotSpot = hotSpot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for open new tab.
   *
   * @param  openInCurrentTab  openNewTab Boolean
   */
  public void setOpenInCurrentTab(Boolean openInCurrentTab) {
    this.openInCurrentTab = openInCurrentTab;
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
   * setWorkflow.
   *
   * @param  workflow  $param.type$
   */
  public void setWorkflow(EnterpriseWorkflow workflow) {
    this.workflow = workflow;
  }
} // end class EnterpriseWorkflowAssignedHotSpot
