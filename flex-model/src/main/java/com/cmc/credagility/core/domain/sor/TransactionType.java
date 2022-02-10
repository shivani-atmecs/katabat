package com.cmc.credagility.core.domain.sor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.ozstrategy.credagility.core.domain.CreatorEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:shuang.wu@ozstrategy.com">Shuang Wu</a>
 * @version  11/22/2015 23:45
 */
@Entity
@Table(
  name    = "TransactionType",
  indexes = {
    @Index(
      name = "transTypeIndex",
      columnList = "transType"
    )
  }
)
public class TransactionType extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6192797271540750933L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String description;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 4,
    nullable = false,
    unique   = true
  )
  protected String transType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof TransactionType)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    TransactionType that = (TransactionType) o;

    if ((getDescription() != null) ? (!getDescription().equals(that.getDescription()))
                                   : (that.getDescription() != null)) {
      return false;
    }

    return !((getTransType() != null) ? (!getTransType().equals(that.getTransType())) : (that.getTransType() != null));

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans type.
   *
   * @return  String
   */
  public String getTransType() {
    return transType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((getDescription() != null) ? getDescription().hashCode() : 0);
    result = (31 * result) + ((getTransType() != null) ? getTransType().hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans type.
   *
   * @param  transType  String
   */
  public void setTransType(String transType) {
    this.transType = transType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "TransactionType{"
      + "description='" + description + '\''
      + ", id=" + id
      + ", transType='" + transType + '\''
      + '}';
  }

} // end class TransactionType
