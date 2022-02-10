package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.ozstrategy.credagility.core.domain.CreatorEntity;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-2-25 : AM9:31</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflowTaskGroup extends CreatorEntity implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Group display order. */
  @Column protected Integer displayOrder;

  /** Group display header. */
  @Column(
    columnDefinition = "LONGTEXT",
    nullable         = false
  )
  @Lob protected String groupHeader = "";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<? extends BasicWorkflowTaskElement> getActiveElements();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<? extends BasicWorkflowTaskElement> getElements();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<? extends BasicWorkflowTaskGroupElement> getGroupElements();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BasicWorkflowTask getTask();

  //~ ------------------------------------------------------------------------------------------------------------------

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

    BasicWorkflowTaskGroup that = (BasicWorkflowTaskGroup) o;

    if ((groupHeader != null) ? (!groupHeader.equals(that.groupHeader)) : (that.groupHeader != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDisplayOrder() {
    return displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGroupHeader() {
    if ((groupHeader == null) || !StringUtils.hasText(groupHeader)) {
      return "Default";
    }

    return groupHeader;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((groupHeader != null) ? groupHeader.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  displayOrder  DOCUMENT ME!
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupHeader  DOCUMENT ME!
   */
  public void setGroupHeader(String groupHeader) {
    this.groupHeader = groupHeader;
  }

  //~ ------------------------------------------------------------------------------------------------------------------
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDisplayGroupHeaderWithColon() {
    if (StringUtils.hasText(groupHeader)) {
      if (groupHeader.endsWith(":")) {
        return groupHeader;
      }

      return groupHeader + ":";
    }

    return "";
  }
} // end class BasicWorkflowTaskGroup
