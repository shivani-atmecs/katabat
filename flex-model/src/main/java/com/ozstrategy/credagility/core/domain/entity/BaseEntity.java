package com.ozstrategy.credagility.core.domain.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 12:14
 */
@MappedSuperclass public abstract class BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5137348947151932448L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Create date. */
  @Column(
    name      = "createDate",
    nullable  = false,
    updatable = false
  )
  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  protected Date              createDate;

  /** Update date. */
  @Column(name = "lastUpdateDate")
  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastUpdateDate;

  // protected Integer version = 0;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Set createDate when new an object.
   */
  public BaseEntity() {
    this.createDate     = new Date();
    this.lastUpdateDate = createDate;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final BaseEntity other = (BaseEntity) obj;

    if (this.createDate == null) {
      if (other.getCreateDate() != null) {
        return false;
      }
    } else if (!this.createDate.equals(other.getCreateDate())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the createDate
   *
   *          <p>not-null = "true" update = "false"</p>
   */
  public Date getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the lastUpdateDate
   *
   *          <p>not-null = "false"</p>
   */
  public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = 31;
    result = (PRIME * result)
      + ((this.createDate == null) ? 0 : this.createDate.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for create date.
   *
   * @param  createDate  Date
   */
  public void setCreateDate(Date createDate) {
    if (createDate == null) {
      this.createDate = new Date();
    } else {
      this.createDate = createDate;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last update date.
   *
   * @param  lastUpdateDate  Date
   */
  public void setLastUpdateDate(Date lastUpdateDate) {
    this.lastUpdateDate = new Date();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("BaseObject ( ").append("createDate = ").append(
      this.createDate).append(TAB).append("updateDate = ").append(
      this.lastUpdateDate).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class BaseEntity
