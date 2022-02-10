package com.cmc.credagility.core.domain.base;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import com.cmc.credagility.core.domain.user.User;


/**
 * This class is used to store object creator and last updater information.
 *
 * @author   Yang Wang
 * @version  $Revision$, 09/29/2014 214:53 PM
 */
@MappedSuperclass public abstract class CreatorEntity extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 579757832122255158L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Create date. */
  @CreatedBy
  @JoinColumn(
    name       = "creatorId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User            creator;

  /** Last Updater. */
  @JoinColumn(
    name       = "lastUpdaterId",
    insertable = true,
    updatable  = true
  )
  @LastModifiedBy
  @ManyToOne(fetch = FetchType.LAZY)
  protected User lastUpdater;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getCreator() {
    return creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCreatorName() {
    if (getCreator() != null) {
      return getCreator().getFullName();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getLastUpdater() {
    return lastUpdater;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLastUpdaterName() {
    if (getLastUpdater() != null) {
      return getLastUpdater().getFullName();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  creator  DOCUMENT ME!
   */
  public void setCreator(User creator) {
    this.creator = creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setCreatorName(String name) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastUpdater  DOCUMENT ME!
   */
  public void setLastUpdater(User lastUpdater) {
    this.lastUpdater = lastUpdater;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setLastUpdaterName(String name) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("CreatorObject");
    sb.append("{creator=").append(creator);
    sb.append(", lastUpdater=").append(lastUpdater);
    sb.append('}');

    return sb.toString();
  }
} // end class CreatorEntity
