package com.cmc.credagility.core.domain.account;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.mra.QueueAccountMappingField;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.Calculatable;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/14/2014 15:40
 */
@Entity public class AccountGridConfig extends CreatorEntity implements Serializable, Calculatable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8004162073750981741L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "availableMappingFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected QueueAccountMappingField availableMappingField;

  /** Queue sorting criteria. */
  @JoinColumn(
    name       = "variableId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BaseVariable criteriaVariable;

  /** DOCUMENT ME! */
  @Column(
    name             = "defaultShow",
    columnDefinition = "char",
    length           = 1,
    nullable         = true
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean defaultShow;

  /** DOCUMENT ME! */
  @Column(nullable = false)
  protected String displayName;

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal flex;

  /** DOCUMENT ME! */
  protected String format;

  /** DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** DOCUMENT ME! */
  protected Integer priority;

  /** TODO: DOCUMENT ME! */
  @Column protected String renderer;

  /** DOCUMENT ME! */
  @Column(
    name     = "staticField",
    nullable = true
  )
  protected String staticField;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "variableMetaDataFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected AccountMetaDataField variableMetaDataField;

  /** DOCUMENT ME! */
  @Column(
    name     = "width",
    nullable = true
  )
  protected Integer width;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.Calculatable#calculate(com.ozstrategy.credagility.core.helper.EvaluateHelper)
   */
  @Override public Object calculate(EvaluateHelper helper) {
    return helper.calculate(this);
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

    AccountGridConfig that = (AccountGridConfig) o;

    if ((availableMappingField != null) ? (!availableMappingField.equals(that.availableMappingField))
                                        : (that.availableMappingField != null)) {
      return false;
    }

    if ((criteriaVariable != null) ? (!criteriaVariable.equals(that.criteriaVariable))
                                   : (that.criteriaVariable != null)) {
      return false;
    }

    if ((displayName != null) ? (!displayName.equals(that.displayName)) : (that.displayName != null)) {
      return false;
    }

    if ((format != null) ? (!format.equals(that.format)) : (that.format != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if ((renderer != null) ? (!renderer.equals(that.renderer)) : (that.renderer != null)) {
      return false;
    }

    if ((staticField != null) ? (!staticField.equals(that.staticField)) : (that.staticField != null)) {
      return false;
    }

    return !((variableMetaDataField != null) ? (!variableMetaDataField.equals(that.variableMetaDataField))
                                             : (that.variableMetaDataField != null));
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public QueueAccountMappingField getAvailableMappingField() {
    return availableMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BaseVariable getCriteriaVariable() {
    return criteriaVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getDefaultShow() {
    if ((null == defaultShow) || (defaultShow == false)) {
      return false;
    }

    return defaultShow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDisplayName() {
    return displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFlex() {
    return flex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFormat() {
    return format;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for renderer.
   *
   * @return  String
   */
  public String getRenderer() {
    return renderer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStaticField() {
    return staticField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountMetaDataField getVariableMetaDataField() {
    return variableMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getWidth() {
    return width;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((availableMappingField != null) ? availableMappingField.hashCode() : 0);
    result = (31 * result) + ((criteriaVariable != null) ? criteriaVariable.hashCode() : 0);
    result = (31 * result) + ((defaultShow != null) ? defaultShow.hashCode() : 0);
    result = (31 * result) + ((displayName != null) ? displayName.hashCode() : 0);
    result = (31 * result) + ((format != null) ? format.hashCode() : 0);
    result = (31 * result) + ((renderer != null) ? renderer.hashCode() : 0);
    result = (31 * result) + ((staticField != null) ? staticField.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((variableMetaDataField != null) ? variableMetaDataField.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  availableMappingField  DOCUMENT ME!
   */
  public void setAvailableMappingField(QueueAccountMappingField availableMappingField) {
    this.availableMappingField = availableMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  criteriaVariable  DOCUMENT ME!
   */
  public void setCriteriaVariable(BaseVariable criteriaVariable) {
    this.criteriaVariable = criteriaVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  defaultShow  DOCUMENT ME!
   */
  public void setDefaultShow(Boolean defaultShow) {
    this.defaultShow = defaultShow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  displayName  DOCUMENT ME!
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex.
   *
   * @param  flex  BigDecimal
   */
  public void setFlex(BigDecimal flex) {
    this.flex = flex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  format  DOCUMENT ME!
   */
  public void setFormat(String format) {
    this.format = format;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  priority  DOCUMENT ME!
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for renderer.
   *
   * @param  renderer  String
   */
  public void setRenderer(String renderer) {
    this.renderer = renderer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  staticField  DOCUMENT ME!
   */
  public void setStaticField(String staticField) {
    this.staticField = staticField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variableMetaDataField  DOCUMENT ME!
   */
  public void setVariableMetaDataField(AccountMetaDataField variableMetaDataField) {
    this.variableMetaDataField = variableMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  width  DOCUMENT ME!
   */
  public void setWidth(Integer width) {
    this.width = width;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    return "BCIGridConfig{"
      + "id=" + id
      + ", portfolio=" + portfolio
      + ", availableMappingField=" + availableMappingField
      + ", defaultShow=" + defaultShow
      + ", criteriaVariable=" + criteriaVariable
      + ", variableMetaDataField=" + variableMetaDataField
      + ", priority=" + priority
      + ", displayName=" + displayName
      + ", renderer=" + renderer
      + ", format=" + format
      + '}';
  }
} // end class AccountGridConfig
