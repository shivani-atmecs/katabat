package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


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
   * getter method for creator.
   *
   * @return  User
   */
  public User getCreator() {
    return creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator name.
   *
   * @return  String
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
   * getter method for last updater.
   *
   * @return  User
   */
  public User getLastUpdater() {
    return lastUpdater;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last updater name.
   *
   * @return  String
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
   * setter method for creator.
   *
   * @param  creator  User
   */
  public void setCreator(User creator) {
    this.creator = creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for creator name.
   *
   * @param  name  String
   */
  public void setCreatorName(String name) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last updater.
   *
   * @param  lastUpdater  User
   */
  public void setLastUpdater(User lastUpdater) {
    this.lastUpdater = lastUpdater;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last updater name.
   *
   * @param  name  String
   */
  public void setLastUpdaterName(String name) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
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
