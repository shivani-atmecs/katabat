package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 14:17
 */
@Entity public class ProgramIndividualInstallment extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String amountDateExpression;

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String amountExpression;

  /** TODO: DOCUMENT ME! */
  @Transient protected BigDecimal amountValue;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "defaulted",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean defaulted;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long individualInstallmentId;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer position;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "programActionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ProgramAction programAction;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  ProgramIndividualInstallment
   */
  public ProgramIndividualInstallment duplicate() {
    ProgramIndividualInstallment installment = new ProgramIndividualInstallment();
    installment.setAmountExpression(this.amountExpression);
    installment.setPosition(this.position);
    installment.setDefaulted(this.defaulted);

    return installment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    ProgramIndividualInstallment that = (ProgramIndividualInstallment) o;

    if ((amountExpression != null) ? (!amountExpression.equals(that.amountExpression))
                                   : (that.amountExpression != null)) {
      return false;
    }

    if ((amountDateExpression != null) ? (!amountDateExpression.equals(that.amountDateExpression))
                                       : (that.amountDateExpression != null)) {
      return false;
    }

    if ((defaulted != null) ? (!defaulted.equals(that.defaulted)) : (that.defaulted != null)) {
      return false;
    }

    if ((individualInstallmentId != null) ? (!individualInstallmentId.equals(that.individualInstallmentId))
                                          : (that.individualInstallmentId != null)) {
      return false;
    }

    if ((position != null) ? (!position.equals(that.position)) : (that.position != null)) {
      return false;
    }

    if ((programAction != null) ? (!programAction.equals(that.programAction)) : (that.programAction != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount date expression.
   *
   * @return  String
   */
  public String getAmountDateExpression() {
    return amountDateExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount expression.
   *
   * @return  String
   */
  public String getAmountExpression() {
    return amountExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount value.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAmountValue() {
    return amountValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for defaulted.
   *
   * @return  Boolean
   */
  public Boolean getDefaulted() {
    if (defaulted == null) {
      return Boolean.FALSE;
    }

    return defaulted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for individual installment id.
   *
   * @return  Long
   */
  public Long getIndividualInstallmentId() {
    return individualInstallmentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for position.
   *
   * @return  Integer
   */
  public Integer getPosition() {
    return position;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program action.
   *
   * @return  ProgramAction
   */
  public ProgramAction getProgramAction() {
    return programAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((amountExpression != null) ? amountExpression.hashCode() : 0);
    result = (31 * result) + ((amountDateExpression != null) ? amountDateExpression.hashCode() : 0);
    result = (31 * result) + ((defaulted != null) ? defaulted.hashCode() : 0);
    result = (31 * result) + ((individualInstallmentId != null) ? individualInstallmentId.hashCode() : 0);
    result = (31 * result) + ((position != null) ? position.hashCode() : 0);
    result = (31 * result) + ((programAction != null) ? programAction.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount date expression.
   *
   * @param  amountDateExpression  String
   */
  public void setAmountDateExpression(String amountDateExpression) {
    this.amountDateExpression = amountDateExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount expression.
   *
   * @param  amountExpression  String
   */
  public void setAmountExpression(String amountExpression) {
    this.amountExpression = amountExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount value.
   *
   * @param  amountValue  BigDecimal
   */
  public void setAmountValue(BigDecimal amountValue) {
    this.amountValue = amountValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for defaulted.
   *
   * @param  defaulted  Boolean
   */
  public void setDefaulted(Boolean defaulted) {
    this.defaulted = defaulted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for individual installment id.
   *
   * @param  individualInstallmentId  Long
   */
  public void setIndividualInstallmentId(Long individualInstallmentId) {
    this.individualInstallmentId = individualInstallmentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for position.
   *
   * @param  position  Integer
   */
  public void setPosition(Integer position) {
    this.position = position;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program action.
   *
   * @param  programAction  ProgramAction
   */
  public void setProgramAction(ProgramAction programAction) {
    this.programAction = programAction;
  }
} // end class ProgramIndividualInstallment
