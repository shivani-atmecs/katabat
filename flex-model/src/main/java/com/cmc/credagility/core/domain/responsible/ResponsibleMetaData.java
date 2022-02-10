package com.cmc.credagility.core.domain.responsible;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store ResponsibleMetaData information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 14:40
 */
@Entity
@Table(
  name              = "ResponsibleMetaData",
  uniqueConstraints = {
    @UniqueConstraint(
      name          = "responsibleId",
      columnNames   = { "responsibleId", "responsibleMetaDataFieldId" }
    )
  }
)
public class ResponsibleMetaData extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -974471639435651271L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "responsibleId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "responsibleMetaDataFieldId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected ResponsibleMetaDataField responsibleMetaDataField;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "responsibleMetaDataId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long responsibleMetaDataId;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "responsibleMetaData",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected ResponsibleMetaDataValueString responsibleMetaDataValueBoolean = null;


  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "responsibleMetaData",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected ResponsibleMetaDataValueDate responsibleMetaDataValueDate = null;


  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "responsibleMetaData",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected ResponsibleMetaDataValueDecimal responsibleMetaDataValueDecimal = null;


  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "responsibleMetaData",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected ResponsibleMetaDataValueInteger responsibleMetaDataValueInteger = null;


  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "responsibleMetaData",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected ResponsibleMetaDataValueLong responsibleMetaDataValueLong = null;


  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "responsibleMetaData",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected ResponsibleMetaDataValueString responsibleMetaDataValueString = null;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    final ResponsibleMetaData other = (ResponsibleMetaData) obj;

    if (this.responsible == null) {
      if (other.getResponsible() != null) {
        return false;
      }
    } else if (!this.responsible.equals(other.getResponsible())) {
      return false;
    }

    if (this.responsibleMetaDataField == null) {
      if (other.getResponsibleMetaDataField() != null) {
        return false;
      }
    } else if (!this.responsibleMetaDataField.equals(other.getResponsibleMetaDataField())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible meta data field.
   *
   * @return  ResponsibleMetaDataField
   */
  public ResponsibleMetaDataField getResponsibleMetaDataField() {
    return responsibleMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible meta data id.
   *
   * @return  Long
   */
  public Long getResponsibleMetaDataId() {
    return responsibleMetaDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible meta data value boolean.
   *
   * @return  ResponsibleMetaDataValueString
   */
  public ResponsibleMetaDataValueString getResponsibleMetaDataValueBoolean() {
    return responsibleMetaDataValueBoolean;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible meta data value date.
   *
   * @return  ResponsibleMetaDataValueDate
   */
  public ResponsibleMetaDataValueDate getResponsibleMetaDataValueDate() {
    return responsibleMetaDataValueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible meta data value decimal.
   *
   * @return  ResponsibleMetaDataValueDecimal
   */
  public ResponsibleMetaDataValueDecimal getResponsibleMetaDataValueDecimal() {
    return responsibleMetaDataValueDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible meta data value integer.
   *
   * @return  ResponsibleMetaDataValueInteger
   */
  public ResponsibleMetaDataValueInteger getResponsibleMetaDataValueInteger() {
    return responsibleMetaDataValueInteger;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible meta data value long.
   *
   * @return  ResponsibleMetaDataValueLong
   */
  public ResponsibleMetaDataValueLong getResponsibleMetaDataValueLong() {
    return responsibleMetaDataValueLong;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible meta data value string.
   *
   * @return  ResponsibleMetaDataValueString
   */
  public ResponsibleMetaDataValueString getResponsibleMetaDataValueString() {
    return responsibleMetaDataValueString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = 1;
    result = (PRIME * result)
      + ((this.responsible == null) ? 0 : this.responsible.hashCode());
    result = (PRIME * result)
      + ((this.responsibleMetaDataField == null) ? 0 : this.responsibleMetaDataField.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible meta data field.
   *
   * @param  responsibleMetaDataField  ResponsibleMetaDataField
   */
  public void setResponsibleMetaDataField(ResponsibleMetaDataField responsibleMetaDataField) {
    this.responsibleMetaDataField = responsibleMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible meta data id.
   *
   * @param  responsibleMetaDataId  Long
   */
  public void setResponsibleMetaDataId(Long responsibleMetaDataId) {
    this.responsibleMetaDataId = responsibleMetaDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible meta data value boolean.
   *
   * @param  responsibleMetaDataValueBoolean  ResponsibleMetaDataValueString
   */
  public void setResponsibleMetaDataValueBoolean(ResponsibleMetaDataValueString responsibleMetaDataValueBoolean) {
    this.responsibleMetaDataValueBoolean = responsibleMetaDataValueBoolean;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible meta data value date.
   *
   * @param  responsibleMetaDataValueDate  ResponsibleMetaDataValueDate
   */
  public void setResponsibleMetaDataValueDate(ResponsibleMetaDataValueDate responsibleMetaDataValueDate) {
    this.responsibleMetaDataValueDate = responsibleMetaDataValueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible meta data value decimal.
   *
   * @param  responsibleMetaDataValueDecimal  ResponsibleMetaDataValueDecimal
   */
  public void setResponsibleMetaDataValueDecimal(ResponsibleMetaDataValueDecimal responsibleMetaDataValueDecimal) {
    this.responsibleMetaDataValueDecimal = responsibleMetaDataValueDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible meta data value integer.
   *
   * @param  responsibleMetaDataValueInteger  ResponsibleMetaDataValueInteger
   */
  public void setResponsibleMetaDataValueInteger(ResponsibleMetaDataValueInteger responsibleMetaDataValueInteger) {
    this.responsibleMetaDataValueInteger = responsibleMetaDataValueInteger;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible meta data value long.
   *
   * @param  responsibleMetaDataValueLong  ResponsibleMetaDataValueLong
   */
  public void setResponsibleMetaDataValueLong(ResponsibleMetaDataValueLong responsibleMetaDataValueLong) {
    this.responsibleMetaDataValueLong = responsibleMetaDataValueLong;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible meta data value string.
   *
   * @param  responsibleMetaDataValueString  ResponsibleMetaDataValueString
   */
  public void setResponsibleMetaDataValueString(ResponsibleMetaDataValueString responsibleMetaDataValueString) {
    this.responsibleMetaDataValueString = responsibleMetaDataValueString;
  }
} // end class ResponsibleMetaData
