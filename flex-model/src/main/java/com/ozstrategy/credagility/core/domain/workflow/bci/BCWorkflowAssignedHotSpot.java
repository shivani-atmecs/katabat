package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.EnterpriseHotSpot;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/18/13 : 10:39 AM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "BCWorkflowAssignedHotSpot",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "hotSpotId", "workflowId" }) }
)
public class BCWorkflowAssignedHotSpot extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3735014162532019687L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean openInCurrentTab;

  /** Alias name. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob private String aliasName;

  /** EnterpriseHotSpot PK hotSpotId. */
  @JoinColumn(
    name       = "hotSpotId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private EnterpriseHotSpot hotSpot;

  /** Primary key. */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  /** BCWorkflow PK workflowId. */
  @JoinColumn(
    name       = "workflowId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private BCWorkflow workflow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
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

    BCWorkflowAssignedHotSpot that = (BCWorkflowAssignedHotSpot) o;

    if ((hotSpot != null) ? (!hotSpot.equals(that.hotSpot)) : (that.hotSpot != null)) {
      return false;
    }

    if ((workflow != null) ? (!workflow.equals(that.workflow)) : (that.workflow != null)) {
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
  public String getAliasName() {
    return aliasName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public EnterpriseHotSpot getHotSpot() {
    return hotSpot;
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

  public void setOpenInCurrentTab(Boolean openInCurrentTab) {
    this.openInCurrentTab = openInCurrentTab;
  }
//~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((hotSpot != null) ? hotSpot.hashCode() : 0);
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aliasName  DOCUMENT ME!
   */
  public void setAliasName(String aliasName) {
    this.aliasName = aliasName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hotSpot  DOCUMENT ME!
   */
  public void setHotSpot(EnterpriseHotSpot hotSpot) {
    this.hotSpot = hotSpot;
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
   * @param  workflow  DOCUMENT ME!
   */
  public void setWorkflow(BCWorkflow workflow) {
    this.workflow = workflow;
  }
} // end class BCWorkflowAssignedHotSpot
