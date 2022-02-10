package com.cmc.credagility.core.domain.disposition;

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
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:09
 */
@Entity
@Table(name = "CallType")
public class CallType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 122087105792848570L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "callType",
    unique = true,
    length = 10
  )
  protected String callType;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String description;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String displayColor;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enableDial;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new CallType object.
   */
  public CallType() { }

  /**
   * Creates a new CallType object.
   *
   * @param  callType      DOCUMENT ME!
   * @param  description   DOCUMENT ME!
   * @param  displayColor  DOCUMENT ME!
   * @param  enableDial    DOCUMENT ME!
   */
  public CallType(String callType, String description, String displayColor, Boolean enableDial) {
    this.callType     = callType;
    this.description  = description;
    this.displayColor = displayColor;
    this.enableDial   = enableDial;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof CallType)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    CallType callType1 = (CallType) o;

    if ((callType != null) ? (!callType.equals(callType1.callType)) : (callType1.callType != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(callType1.description)) : (callType1.description != null)) {
      return false;
    }

    if ((displayColor != null) ? (!displayColor.equals(callType1.displayColor)) : (callType1.displayColor != null)) {
      return false;
    }

    if ((enableDial != null) ? (!enableDial.equals(callType1.enableDial)) : (callType1.enableDial != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(callType1.id)) : (callType1.id != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call type.
   *
   * @return  String
   */
  public String getCallType() {
    return callType;
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
   * getter method for display color.
   *
   * @return  String
   */
  public String getDisplayColor() {
    return displayColor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enable dial.
   *
   * @return  Boolean
   */
  public Boolean getEnableDial() {
    return enableDial;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((callType != null) ? callType.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((displayColor != null) ? displayColor.hashCode() : 0);
    result = (31 * result) + ((enableDial != null) ? enableDial.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call type.
   *
   * @param  callType  String
   */
  public void setCallType(String callType) {
    this.callType = callType;
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
   * setter method for display color.
   *
   * @param  displayColor  String
   */
  public void setDisplayColor(String displayColor) {
    this.displayColor = displayColor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enable dial.
   *
   * @param  enableDial  Boolean
   */
  public void setEnableDial(Boolean enableDial) {
    this.enableDial = enableDial;
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
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("CallType ( ").append(super.toString()).append(TAB).append("typeId = ").append(this.id).append(TAB)
      .append("callType = ").append(this.callType).append(TAB).append("description = ").append(this.description).append(
      TAB).append("enableDial = ").append(this.enableDial).append(TAB).append("displayColor = ").append(
      this.displayColor).append(" )");

    return retValue.toString();
  }
} // end class CallType
