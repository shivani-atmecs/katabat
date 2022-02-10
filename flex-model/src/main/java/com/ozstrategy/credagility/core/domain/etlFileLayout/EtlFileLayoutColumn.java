package com.ozstrategy.credagility.core.domain.etlFileLayout;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:13
 */
@Entity public class EtlFileLayoutColumn extends BaseEtlFileLayoutColumn {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 64
  )
  protected String defaultValue;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "etlFileLayoutId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected EtlFileLayout etlFileLayout;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  protected String staticFieldDataType;

  /** TODO: DOCUMENT ME! */
  protected String staticFieldName;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "variableId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected EtlAccountLoaderVariable variable;
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean                               allowNull = Boolean.TRUE;

  @Column(
    nullable = false,
    length   = 64
  )
  private String positions;

  @Column(length = 16)
  private String scale;

  @Column(nullable = false)
  private Integer valueLength;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EtlFileLayoutColumn object.
   */
  public EtlFileLayoutColumn() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseEtlFileLayoutColumn#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EtlFileLayoutColumn)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EtlFileLayoutColumn that = (EtlFileLayoutColumn) o;

    if ((allowNull != null) ? (!allowNull.equals(that.allowNull)) : (that.allowNull != null)) {
      return false;
    }

    if ((defaultValue != null) ? (!defaultValue.equals(that.defaultValue)) : (that.defaultValue != null)) {
      return false;
    }

    if ((etlFileLayout != null) ? (!etlFileLayout.equals(that.etlFileLayout)) : (that.etlFileLayout != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((positions != null) ? (!positions.equals(that.positions)) : (that.positions != null)) {
      return false;
    }

    if ((scale != null) ? (!scale.equals(that.scale)) : (that.scale != null)) {
      return false;
    }

    if ((staticFieldDataType != null) ? (!staticFieldDataType.equals(that.staticFieldDataType))
                                      : (that.staticFieldDataType != null)) {
      return false;
    }

    if ((staticFieldName != null) ? (!staticFieldName.equals(that.staticFieldName)) : (that.staticFieldName != null)) {
      return false;
    }

    if ((valueLength != null) ? (!valueLength.equals(that.valueLength)) : (that.valueLength != null)) {
      return false;
    }

    if ((variable != null) ? (!variable.equals(that.variable)) : (that.variable != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow null.
   *
   * @return  Boolean
   */
  public Boolean getAllowNull() {
    return allowNull;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default value.
   *
   * @return  String
   */
  public String getDefaultValue() {
    return defaultValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for etl file layout.
   *
   * @return  EtlFileLayout
   */
  public EtlFileLayout getEtlFileLayout() {
    return etlFileLayout;
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
   * getter method for positions.
   *
   * @return  String
   */
  public String getPositions() {
    return positions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for scale.
   *
   * @return  String
   */
  public String getScale() {
    return scale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for static field data type.
   *
   * @return  String
   */
  public String getStaticFieldDataType() {
    return staticFieldDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for static field name.
   *
   * @return  String
   */
  public String getStaticFieldName() {
    return staticFieldName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value length.
   *
   * @return  Integer
   */
  public Integer getValueLength() {
    return valueLength;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable.
   *
   * @return  EtlAccountLoaderVariable
   */
  public EtlAccountLoaderVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseEtlFileLayoutColumn#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((defaultValue != null) ? defaultValue.hashCode() : 0);
    result = (31 * result) + ((etlFileLayout != null) ? etlFileLayout.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((staticFieldDataType != null) ? staticFieldDataType.hashCode() : 0);
    result = (31 * result) + ((staticFieldName != null) ? staticFieldName.hashCode() : 0);
    result = (31 * result) + ((variable != null) ? variable.hashCode() : 0);
    result = (31 * result) + ((allowNull != null) ? allowNull.hashCode() : 0);
    result = (31 * result) + ((positions != null) ? positions.hashCode() : 0);
    result = (31 * result) + ((scale != null) ? scale.hashCode() : 0);
    result = (31 * result) + ((valueLength != null) ? valueLength.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow null.
   *
   * @param  allowNull  Boolean
   */
  public void setAllowNull(Boolean allowNull) {
    this.allowNull = allowNull;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default value.
   *
   * @param  defaultValue  String
   */
  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for etl file layout.
   *
   * @param  etlFileLayout  EtlFileLayout
   */
  public void setEtlFileLayout(EtlFileLayout etlFileLayout) {
    this.etlFileLayout = etlFileLayout;
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
   * setter method for positions.
   *
   * @param  positions  String
   */
  public void setPositions(String positions) {
    this.positions = positions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for scale.
   *
   * @param  scale  String
   */
  public void setScale(String scale) {
    this.scale = scale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for static field data type.
   *
   * @param  staticFieldDataType  String
   */
  public void setStaticFieldDataType(String staticFieldDataType) {
    this.staticFieldDataType = staticFieldDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for static field name.
   *
   * @param  staticFieldName  String
   */
  public void setStaticFieldName(String staticFieldName) {
    this.staticFieldName = staticFieldName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value length.
   *
   * @param  valueLength  Integer
   */
  public void setValueLength(Integer valueLength) {
    this.valueLength = valueLength;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable.
   *
   * @param  variable  EtlAccountLoaderVariable
   */
  public void setVariable(EtlAccountLoaderVariable variable) {
    this.variable = variable;
  }
} // end class EtlFileLayoutColumn
