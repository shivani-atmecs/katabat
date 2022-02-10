package com.cmc.credagility.core.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store GenericLock information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 15:36
 */
@Entity
@Table(
  uniqueConstraints = {
    @UniqueConstraint(
      name = "lockName",
      columnNames = { "lockName", "lockKey" }
    )
  }
)
public class GenericLock extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Lock key. */
  @Column(
    insertable = true,
    updatable  = false,
    nullable   = false,
    length     = 150
  )
  protected String lockKey = "";


  /** Lock name. */
  @Column(
    insertable = true,
    nullable   = false,
    length     = 100
  )
  protected String lockName = "";

  @Column @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long lockId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new GenericLock object.
   */
  public GenericLock() { }

  /**
   * Creates a new GenericLock object.
   *
   * @param  name  String
   * @param  key   String
   */
  public GenericLock(String name, String key) {
    this.lockName = name;
    this.lockKey  = key;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    if (!(o instanceof GenericLock)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    GenericLock that = (GenericLock) o;

    if ((lockKey != null) ? (!lockKey.equals(that.lockKey)) : (that.lockKey != null)) {
      return false;
    }

    if ((lockName != null) ? (!lockName.equals(that.lockName)) : (that.lockName != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lock id.
   *
   * @return  Long
   */
  public Long getLockId() {
    return lockId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lock key.
   *
   * @return  String
   */
  public String getLockKey() {
    return lockKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lock name.
   *
   * @return  String
   */
  public String getLockName() {
    return lockName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((lockName != null) ? lockName.hashCode() : 0);
    result = (31 * result) + ((lockKey != null) ? lockKey.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for lock id.
   *
   * @param  lockId  Long
   */
  public void setLockId(Long lockId) {
    this.lockId = lockId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for lock key.
   *
   * @param  lockKey  String
   */
  public void setLockKey(String lockKey) {
    this.lockKey = lockKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for lock name.
   *
   * @param  lockName  String
   */
  public void setLockName(String lockName) {
    this.lockName = lockName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("GenericLock");
    sb.append("{lockName='").append(lockName).append('\'');
    sb.append(", lockKey='").append(lockKey).append('\'');
    sb.append(", lockId=").append(lockId);
    sb.append('}');

    return sb.toString();
  }

} // end class GenericLock
