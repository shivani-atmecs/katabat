package com.ozstrategy.credagility.core.domain.sor;


import com.cmc.credagility.core.domain.sor.TransactionCode;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.domain.AbstractActionAudit;
import com.ozstrategy.credagility.core.domain.audit.AuditType;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by zhubq on 4/5/16.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  04/05/2016 15:23
 */
@Entity public class TransactionActionAudit extends AbstractActionAudit implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5378279016867260200L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "variableId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BaseVariable amountVariable;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "effectiveDateVariableId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BaseVariable effectiveDateVariable;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "transCodeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TransactionCode transCode;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TransactionActionAudit object.
   *
   * @param  action     TransactionAction
   * @param  auditType  AuditType
   */
  public TransactionActionAudit(TransactionAction action, AuditType auditType) {
    super(action, auditType);
    this.amountVariable        = action.getAmountVariable();
    this.transCode             = action.getTransCode();
    this.effectiveDateVariable = action.getEffectiveDateVariable();
  }

  public TransactionActionAudit() {
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    TransactionActionAudit that = (TransactionActionAudit) o;

    if ((amountVariable != null) ? (!amountVariable.equals(that.amountVariable)) : (that.amountVariable != null)) {
      return false;
    }

    if ((effectiveDateVariable != null) ? (!effectiveDateVariable.equals(that.effectiveDateVariable))
                                        : (that.effectiveDateVariable != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return !((transCode != null) ? (!transCode.equals(that.transCode)) : (that.transCode != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
   */
  public BaseVariable getAmountVariable() {
    return amountVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for effective date variable.
   *
   * @return  BaseVariable
   */
  public BaseVariable getEffectiveDateVariable() {
    return effectiveDateVariable;
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
   * getter method for trans code.
   *
   * @return  TransactionCode
   */
  public TransactionCode getTransCode() {
    return transCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((amountVariable != null) ? amountVariable.hashCode() : 0);
    result = (31 * result) + ((effectiveDateVariable != null) ? effectiveDateVariable.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((transCode != null) ? transCode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount variable.
   *
   * @param  amountVariable  BaseVariable
   */
  public void setAmountVariable(BaseVariable amountVariable) {
    this.amountVariable = amountVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for effective date variable.
   *
   * @param  effectiveDateVariable  BaseVariable
   */
  public void setEffectiveDateVariable(BaseVariable effectiveDateVariable) {
    this.effectiveDateVariable = effectiveDateVariable;
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
   * setter method for trans code.
   *
   * @param  transCode  TransactionCode
   */
  public void setTransCode(TransactionCode transCode) {
    this.transCode = transCode;
  }
} // end class TransactionActionAudit
