package com.cmc.credagility.core.domain.businesscontext;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.type.MetaDataValueType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:31
 */
@Entity
@Table(
  name              = "BCMetaDataField",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "fieldName", "businessContextId" }) }
)
public class BCMetaDataField extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -9075525728594333172L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean audit;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bcAvailableMappingFieldId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @OneToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected BCAvailableMappingField bcAvailableMappingField;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bcVariableId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @OneToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected BCVariable bcVariable;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "businessContextId",
    nullable = false
  )
  @ManyToOne protected BusinessContext businessContext;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String businessDataType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "description",
    length = 255
  )
  protected String description;


  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 255,
    name     = "displayName",
    nullable = true
  )
  protected String displayName;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 255,
    name     = "fieldName",
    nullable = false
  )
  protected String fieldName;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "type",
    nullable = false,
    length   = 255
  )
  @Enumerated(value = EnumType.STRING)
  protected MetaDataValueType type;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * detectDataType.
   */
  public void detectDataType() {
    if ("String".equalsIgnoreCase(businessDataType)) {
      type = MetaDataValueType.STRING;
    } else if ("Currency".equalsIgnoreCase(businessDataType)) {
      type = MetaDataValueType.BIGDECIMAL;
    } else if ("Percentage".equalsIgnoreCase(businessDataType)) {
      type = MetaDataValueType.BIGDECIMAL;
    } else if ("Decimal".equalsIgnoreCase(businessDataType)) {
      type = MetaDataValueType.BIGDECIMAL;
    } else if ("Integer".equalsIgnoreCase(businessDataType)) {
      type = MetaDataValueType.LONG;
    } else if ("Boolean".equalsIgnoreCase(businessDataType)) {
      type = MetaDataValueType.BOOLEAN;
    } else if ("Date".equalsIgnoreCase(businessDataType)) {
      type = MetaDataValueType.DATE;
    } else if ("Text".equalsIgnoreCase(businessDataType)) {
      type = MetaDataValueType.TEXT;
    } else if ("Float".equalsIgnoreCase(businessDataType) || "Double".equalsIgnoreCase(businessDataType)) {
      type = MetaDataValueType.BIGDECIMAL;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BCMetaDataField)) {
      return false;
    }

    BCMetaDataField that = (BCMetaDataField) o;

    if ((active != null) ? (!active.equals(that.active)) : (that.active != null)) {
      return false;
    }

    if ((audit != null) ? (!audit.equals(that.audit)) : (that.audit != null)) {
      return false;
    }

    if ((businessContext != null) ? (!businessContext.equals(that.businessContext)) : (that.businessContext != null)) {
      return false;
    }

    if ((fieldName != null) ? (!fieldName.equals(that.fieldName)) : (that.fieldName != null)) {
      return false;
    }

    if ((displayName != null) ? (!displayName.equals(that.displayName)) : (that.displayName != null)) {
      return false;
    }

    if ((businessDataType != null) ? (!businessDataType.equals(that.businessDataType))
                                   : (that.businessDataType != null)) {
      return false;
    }

    if (type != that.type) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for audit.
   *
   * @return  Boolean
   */
  public Boolean getAudit() {
    if (audit == null) {
      return Boolean.FALSE;
    }

    return audit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bc available mapping field.
   *
   * @return  BCAvailableMappingField
   */
  public BCAvailableMappingField getBcAvailableMappingField() {
    return bcAvailableMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bc variable.
   *
   * @return  BCVariable
   */
  public BCVariable getBcVariable() {
    return bcVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @return  BusinessContext
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business data type.
   *
   * @return  String
   */
  public String getBusinessDataType() {
    return businessDataType;
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
   * getter method for display name.
   *
   * @return  String
   */
  public String getDisplayName() {
    return displayName;
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
   * getter method for type.
   *
   * @return  MetaDataValueType
   */
  public MetaDataValueType getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((active != null) ? active.hashCode() : 0);
    result = (31 * result) + ((audit != null) ? audit.hashCode() : 0);
    result = (31 * result) + ((businessContext != null) ? businessContext.hashCode() : 0);
    result = (31 * result) + ((fieldName != null) ? fieldName.hashCode() : 0);
    result = (31 * result) + ((displayName != null) ? displayName.hashCode() : 0);
    result = (31 * result) + ((businessDataType != null) ? businessDataType.hashCode() : 0);
    result = (31 * result) + ((type != null) ? type.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active.
   *
   * @param  active  Boolean
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for audit.
   *
   * @param  audit  Boolean
   */
  public void setAudit(Boolean audit) {
    this.audit = audit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bc available mapping field.
   *
   * @param  bcAvailableMappingField  BCAvailableMappingField
   */
  public void setBcAvailableMappingField(BCAvailableMappingField bcAvailableMappingField) {
    this.bcAvailableMappingField = bcAvailableMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bc variable.
   *
   * @param  bcVariable  BCVariable
   */
  public void setBcVariable(BCVariable bcVariable) {
    this.bcVariable = bcVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context.
   *
   * @param  businessContext  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business data type.
   *
   * @param  businessDataType  String
   */
  public void setBusinessDataType(String businessDataType) {
    this.businessDataType = businessDataType;
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
   * setter method for display name.
   *
   * @param  displayName  String
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
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
   * setter method for type.
   *
   * @param  type  MetaDataValueType
   */
  public void setType(MetaDataValueType type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "BCMetaDataField{"
      + "id=" + id
      + ", fieldName='" + fieldName
      + ", type=" + type
      + ", businessDataType=" + businessDataType
      + ", audit=" + audit
      + ", active=" + active
      + ", businessContext=" + businessContext
      + '}';
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateAvailableFields.
   *
   * @param  metaDataField  BCMetaDataField
   */
  public void updateAvailableFields(BCMetaDataField metaDataField) {
    // update field self...
    this.setAudit(metaDataField.getAudit());
    this.setDisplayName(metaDataField.getDisplayName());
    this.setDescription(metaDataField.getDescription());
    this.setLastUpdater(metaDataField.getLastUpdater());
    this.setLastUpdateDate(metaDataField.getLastUpdateDate());

    // if bc variable not available, there will related.
    if (this.getBcVariable() == null) {
      BCVariable variable = new BCVariable();
      variable.update(this);
      this.setBcVariable(variable);
    }

    // sync BCAvailableMappingField
    if (this.getBcAvailableMappingField() == null) {
      BCAvailableMappingField bcAvailableMappingField = new BCAvailableMappingField();
      bcAvailableMappingField.update(this);
      this.setBcAvailableMappingField(bcAvailableMappingField);
    } else {
      this.getBcAvailableMappingField().setDisplayName(metaDataField.getDisplayName());
      this.getBcAvailableMappingField().setLastUpdateDate(metaDataField.getLastUpdateDate());
      this.getBcAvailableMappingField().setLastUpdater(metaDataField.getLastUpdater());
    }

    // update variable displayName/Description
    this.getBcVariable().setDisplayName(metaDataField.getDisplayName());
    this.getBcVariable().setDescription(metaDataField.getDescription());
    this.getBcVariable().setLastUpdateDate(metaDataField.getLastUpdateDate());
    this.getBcVariable().setLastUpdater(metaDataField.getLastUpdater());

  } // end method updateAvailableFields
} // end class BCMetaDataField
