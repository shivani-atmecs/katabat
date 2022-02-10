package com.cmc.credagility.core.domain.channel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store Channel Type information.
 *
 * <p><a href="ChannelType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 14:59
 */
@Entity
@Table(
  name              = "ChannelType",
  uniqueConstraints = { @UniqueConstraint(columnNames = "name") }
)
public class ChannelType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7960815178828719596L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Action Code of a channel type. */
  @Column(
    name     = "actionCode",
    length   = 64,
    nullable = false
  )
  protected String actionCode;


  /** Channel Type PK. */
  @Column(
    name     = "channelTypeId", /*unique = true,*/
    nullable = false
  )

  // npelleti, 07/30, USBank, Drop Unique Constraint
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long channelTypeId;

  /** Channel type description. */
  @Column(
    name   = "description",
    length = 255
  )
  protected String description;


  /** enable Event. */
  @Column(
    name             = "enableEvent",
    nullable         = true,
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enableEvent;

  /** Channel type name. */
  @Column(
    name     = "name",
    length   = 50,
    nullable = false,
    unique   = true
  )
  protected String name;


  /** Transient typeCode. */
  @Transient protected String typeCode = "";

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

    if (!(obj instanceof ChannelType)) {
      return false;
    }

    final ChannelType other = (ChannelType) obj;

    if (name == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!name.equals(other.getName())) {
      return false;
    }

    if (actionCode == null) {
      if (other.getActionCode() != null) {
        return false;
      }
    } else if (!actionCode.equals(other.getActionCode())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The action code for this channel.
   *
   * @return  the action code for this channel
   *
   *          <p>not-null = "true" length = "64"</p>
   */
  public String getActionCode() {
    return actionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The channelTypeId.
   *
   * @return  the channelTypeId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getChannelTypeId() {
    return channelTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The description.
   *
   * @return  the description
   *
   *          <p>not-null = "false" length = "255"</p>
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Channel Type PK.
   *
   * @return  channel Type PK.
   */
  public Boolean getEnableEvent() {
    return enableEvent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The name.
   *
   * @return  the name
   *
   *          <p>not-null = "true" length = "50" unique = "true"</p>
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the type code to locate the localized string for display purpose.
   *
   * @return  the type code to locate the localized string for display purpose.
   */
  public String getTypeCode() {
    return "channelType" + channelTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((name == null) ? 0 : name.hashCode());
    result = (prime * result)
      + ((actionCode == null) ? 0 : actionCode.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action code.
   *
   * @param  actionCode  String
   */
  public void setActionCode(String actionCode) {
    this.actionCode = actionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel type id.
   *
   * @param  channelTypeId  Long
   */
  public void setChannelTypeId(Long channelTypeId) {
    this.channelTypeId = channelTypeId;
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
   * setter method for enable event.
   *
   * @param  enableEvent  Boolean
   */
  public void setEnableEvent(Boolean enableEvent) {
    this.enableEvent = enableEvent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
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

    retValue.append("ChannelType ( ").append(super.toString()).append(TAB).append("actionCode = ").append(
      this.actionCode).append(TAB).append(
      "channelTypeId = ").append(this.channelTypeId).append(TAB).append(
      "description = ").append(this.description).append(TAB).append(
      "name = ").append(this.name).append(TAB).append("typeCode = ").append(this.typeCode).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class ChannelType
