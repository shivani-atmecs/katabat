package com.cmc.credagility.core.domain.agency;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.variable.Variable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:02
 */
@Entity public class AgencyGridConfig extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3255277592271691382L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyMetaDataFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyMetaDataField agencyMetaDataField;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "queueMappingFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyQueueMappingField agencyQueueMappingField;

  /** TODO: DOCUMENT ME! */
  protected Boolean defaultShow;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected String displayName;

  /** TODO: DOCUMENT ME! */
  protected String format;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  protected Integer priority;

  /** Queue sorting criteria. */
  @JoinColumn(
    name       = "variableId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Variable variable;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    AgencyGridConfig that = (AgencyGridConfig) o;

    if ((agencyMetaDataField != null) ? (!agencyMetaDataField.equals(that.agencyMetaDataField))
                                      : (that.agencyMetaDataField != null)) {
      return false;
    }

    if ((agencyQueueMappingField != null) ? (!agencyQueueMappingField.equals(that.agencyQueueMappingField))
                                          : (that.agencyQueueMappingField != null)) {
      return false;
    }

    if ((defaultShow != null) ? (!defaultShow.equals(that.defaultShow)) : (that.defaultShow != null)) {
      return false;
    }

    if ((variable != null) ? (!variable.equals(that.variable)) : (that.variable != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency meta data field.
   *
   * @return  AgencyMetaDataField
   */
  public AgencyMetaDataField getAgencyMetaDataField() {
    return agencyMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency queue mapping field.
   *
   * @return  AgencyQueueMappingField
   */
  public AgencyQueueMappingField getAgencyQueueMappingField() {
    return agencyQueueMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default show.
   *
   * @return  Boolean
   */
  public Boolean getDefaultShow() {
    return defaultShow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display name.
   *
   * @return  String
   */
  public String getDisplayName() {
    return displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for format.
   *
   * @return  String
   */
  public String getFormat() {
    return format;
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
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable.
   *
   * @return  Variable
   */
  public Variable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((agencyMetaDataField != null) ? agencyMetaDataField.hashCode() : 0);
    result = (31 * result) + ((agencyQueueMappingField != null) ? agencyQueueMappingField.hashCode() : 0);
    result = (31 * result) + ((defaultShow != null) ? defaultShow.hashCode() : 0);
    result = (31 * result) + ((variable != null) ? variable.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency meta data field.
   *
   * @param  agencyMetaDataField  AgencyMetaDataField
   */
  public void setAgencyMetaDataField(AgencyMetaDataField agencyMetaDataField) {
    this.agencyMetaDataField = agencyMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency queue mapping field.
   *
   * @param  agencyQueueMappingField  AgencyQueueMappingField
   */
  public void setAgencyQueueMappingField(AgencyQueueMappingField agencyQueueMappingField) {
    this.agencyQueueMappingField = agencyQueueMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default show.
   *
   * @param  defaultShow  Boolean
   */
  public void setDefaultShow(Boolean defaultShow) {
    this.defaultShow = defaultShow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display name.
   *
   * @param  displayName  String
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for format.
   *
   * @param  format  String
   */
  public void setFormat(String format) {
    this.format = format;
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
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable.
   *
   * @param  variable  Variable
   */
  public void setVariable(Variable variable) {
    this.variable = variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "AgencyGridConfig{"
      + "agencyMetaDataField=" + agencyMetaDataField
      + ", agencyQueueMappingField=" + agencyQueueMappingField
      + ", defaultShow=" + defaultShow
      + ", displayName='" + displayName + '\''
      + ", format='" + format + '\''
      + ", id=" + id
      + ", priority=" + priority
      + ", variable=" + variable
      + '}';
  }
} // end class AgencyGridConfig
