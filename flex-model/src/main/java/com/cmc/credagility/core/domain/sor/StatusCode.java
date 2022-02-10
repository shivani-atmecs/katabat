package com.cmc.credagility.core.domain.sor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO:
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  11/20/2015 10:26
 */
@Entity
@Table(name = "StatusCode")
public class StatusCode extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5388427462257334000L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean bal;

  /** TODO: */
  @Column(length = 10)
  protected String CBCode;


  /** TODO: */
  @Column(length = 255)
  protected String description;


  /** TODO: */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: */
  @Column(
    length   = 16,
    nullable = false
  )
  protected String statusCode;

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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    StatusCode that = (StatusCode) o;

    if ((bal != null) ? (!bal.equals(that.bal)) : (that.bal != null)) {
      return false;
    }

    if ((CBCode != null) ? (!CBCode.equals(that.CBCode)) : (that.CBCode != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return !((statusCode != null) ? (!statusCode.equals(that.statusCode)) : (that.statusCode != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bal.
   *
   * @return  Boolean
   */
  public Boolean getBal() {
    return bal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for CBCode.
   *
   * @return  String
   */
  public String getCBCode() {
    return CBCode;
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
   * getter method for status code.
   *
   * @return  String
   */
  public String getStatusCode() {
    return statusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((bal != null) ? bal.hashCode() : 0);
    result = (31 * result) + ((CBCode != null) ? CBCode.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((statusCode != null) ? statusCode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bal.
   *
   * @param  bal  Boolean
   */
  public void setBal(Boolean bal) {
    this.bal = bal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for CBCode.
   *
   * @param  CBCode  String
   */
  public void setCBCode(String CBCode) {
    this.CBCode = CBCode;
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
   * setter method for status code.
   *
   * @param  statusCode  String
   */
  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "StatusCode{"
      + "bal=" + bal
      + ", CBCode='" + CBCode + '\''
      + ", statusCode='" + statusCode + '\''
      + ", id=" + id
      + '}';
  }
} // end class StatusCode
