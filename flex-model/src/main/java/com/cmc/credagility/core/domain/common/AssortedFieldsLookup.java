package com.cmc.credagility.core.domain.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store AssortedFieldsLookup information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 15:37
 */
@Entity
@Table(
  name              = "AssortedFieldsLookup",
  uniqueConstraints = {
    @UniqueConstraint(
      name          = "fieldName",
      columnNames   = { "fieldName", "code" }
    )
  }
)
public class AssortedFieldsLookup extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 1865317744345015131L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** code. */
  @Column(length = 255)
  protected String code;


  /** description. */
  @Column(length = 255)
  protected String description;


  /** fieldName. */
  @Column(length = 255)
  protected String fieldName;

  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

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

    if (!(o instanceof AssortedFieldsLookup)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AssortedFieldsLookup that = (AssortedFieldsLookup) o;

    if ((code != null) ? (!code.equals(that.code)) : (that.code != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((fieldName != null) ? (!fieldName.equals(that.fieldName)) : (that.fieldName != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for code.
   *
   * @return  String
   */
  public String getCode() {
    return code;
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
   * getter method for field name.
   *
   * @return  String
   */
  public String getFieldName() {
    return fieldName;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((fieldName != null) ? fieldName.hashCode() : 0);
    result = (31 * result) + ((code != null) ? code.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for code.
   *
   * @param  code  String
   */
  public void setCode(String code) {
    this.code = code;
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
   * setter method for field name.
   *
   * @param  fieldName  String
   */
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
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
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("AssortedFieldsLookup ( ").append(super.toString()).append(TAB).append("id = ").append(this.id)
      .append(TAB).append("fieldName = ").append(this.fieldName).append(TAB).append("code = ").append(this.code).append(
      TAB).append("description = ").append(this.description).append(" )");

    return retValue.toString();
  }
} // end class AssortedFieldsLookup
