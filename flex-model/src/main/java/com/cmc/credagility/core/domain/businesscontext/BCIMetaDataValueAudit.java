package com.cmc.credagility.core.domain.businesscontext;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.type.MetaDataValueType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:03
 */
@Entity
@Table(
  indexes = {
    @Index(
      columnList = "fieldName",
      name = "fieldNameIndex"
    )
  }
)
public class BCIMetaDataValueAudit extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1934533425179677194L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "businessContextInstanceId",
    nullable = false
  )
  @ManyToOne protected BusinessContextInstance businessContextInstance;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fieldName;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "metaDataFieldId")
  @ManyToOne protected BCMetaDataField metaDataField;

  /** TODO: DOCUMENT ME! */
  @Lob protected String newTextValue;

  /** TODO: DOCUMENT ME! */
  @Column
  @Lob
  protected String newValue;

  /** TODO: DOCUMENT ME! */
  @Lob protected String oldTextValue;

  /** TODO: DOCUMENT ME! */
  @Lob
  protected String oldValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BCIMetaDataValueAudit object.
   */
  public BCIMetaDataValueAudit() { }

  /**
   * Creates a new BCIMetaDataValueAudit object.
   *
   * @param  metaDataValue  BCIMetaDataValue
   */
  public BCIMetaDataValueAudit(BCIMetaDataValue metaDataValue) {
    this.copy(metaDataValue);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @param  metaDataValue  BCIMetaDataValue
   */
  public void copy(BCIMetaDataValue metaDataValue) {
    this.fieldName               = metaDataValue.getFieldName();
    this.metaDataField           = metaDataValue.getMetaDataField();
    this.businessContextInstance = metaDataValue.getBusinessContextInstance();
    this.newValue                = metaDataValue.getSafeNullValueByType();


    if (MetaDataValueType.TEXT.equals(metaDataField.getType())) {
      this.newValue     = null;
      this.newTextValue = metaDataValue.getTextValue();
    }

    if (metaDataValue.isValueChanged()) {
      this.oldValue = metaDataValue.getOldValue();

      if (MetaDataValueType.TEXT.equals(metaDataField.getType())) {
        this.oldValue     = null;
        this.oldTextValue = metaDataValue.getOldValue();
      }
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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BCIMetaDataValueAudit that = (BCIMetaDataValueAudit) o;

    if ((businessContextInstance != null) ? (!businessContextInstance.equals(that.businessContextInstance))
                                          : (that.businessContextInstance != null)) {
      return false;
    }

    if ((fieldName != null) ? (!fieldName.equals(that.fieldName)) : (that.fieldName != null)) {
      return false;
    }

    if ((metaDataField != null) ? (!metaDataField.equals(that.metaDataField)) : (that.metaDataField != null)) {
      return false;
    }

    if ((newTextValue != null) ? (!newTextValue.equals(that.newTextValue)) : (that.newTextValue != null)) {
      return false;
    }

    if ((newValue != null) ? (!newValue.equals(that.newValue)) : (that.newValue != null)) {
      return false;
    }

    if ((oldTextValue != null) ? (!oldTextValue.equals(that.oldTextValue)) : (that.oldTextValue != null)) {
      return false;
    }

    if ((oldValue != null) ? (!oldValue.equals(that.oldValue)) : (that.oldValue != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context instance.
   *
   * @return  BusinessContextInstance
   */
  public BusinessContextInstance getBusinessContextInstance() {
    return businessContextInstance;
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
   * getter method for meta data field.
   *
   * @return  BCMetaDataField
   */
  public BCMetaDataField getMetaDataField() {
    return metaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for new text value.
   *
   * @return  String
   */
  public String getNewTextValue() {
    return newTextValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for new value.
   *
   * @return  String
   */
  public String getNewValue() {
    return newValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for old text value.
   *
   * @return  String
   */
  public String getOldTextValue() {
    return oldTextValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for old value.
   *
   * @return  String
   */
  public String getOldValue() {
    return oldValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((businessContextInstance != null) ? businessContextInstance.hashCode() : 0);
    result = (31 * result) + ((fieldName != null) ? fieldName.hashCode() : 0);
    result = (31 * result) + ((metaDataField != null) ? metaDataField.hashCode() : 0);
    result = (31 * result) + ((newTextValue != null) ? newTextValue.hashCode() : 0);
    result = (31 * result) + ((newValue != null) ? newValue.hashCode() : 0);
    result = (31 * result) + ((oldTextValue != null) ? oldTextValue.hashCode() : 0);
    result = (31 * result) + ((oldValue != null) ? oldValue.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context instance.
   *
   * @param  businessContextInstance  BusinessContextInstance
   */
  public void setBusinessContextInstance(BusinessContextInstance businessContextInstance) {
    this.businessContextInstance = businessContextInstance;
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
   * setter method for meta data field.
   *
   * @param  metaDataField  BCMetaDataField
   */
  public void setMetaDataField(BCMetaDataField metaDataField) {
    this.metaDataField = metaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new text value.
   *
   * @param  newTextValue  String
   */
  public void setNewTextValue(String newTextValue) {
    this.newTextValue = newTextValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new value.
   *
   * @param  newValue  String
   */
  public void setNewValue(String newValue) {
    this.newValue = newValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for old text value.
   *
   * @param  oldTextValue  String
   */
  public void setOldTextValue(String oldTextValue) {
    this.oldTextValue = oldTextValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for old value.
   *
   * @param  oldValue  String
   */
  public void setOldValue(String oldValue) {
    this.oldValue = oldValue;
  }
} // end class BCIMetaDataValueAudit
