package com.ozstrategy.credagility.core.domain.sor;

import com.cmc.credagility.core.domain.sor.TransactionCode;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.domain.BaseNodeAction;
import com.ozstrategy.credagility.core.domain.Node;
import com.ozstrategy.credagility.core.domain.PortfolioBaseNodeAction;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Created by zhubq on 4/5/16.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  04/05/2016 14:41
 */
@Entity @Table public class TransactionAction extends PortfolioBaseNodeAction implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4001932900994128837L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "amountVariableId",
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
  @JoinColumn(
    name     = "transCodeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TransactionCode transCode;

  /** TODO: DOCUMENT ME! */
  @ManyToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "nodeTransactionActions"
  )
  protected Set<Node> transNodes = new LinkedHashSet<Node>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.Executable#beforeExecute()
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.BaseNodeAction#duplicate()
   */
  @Override public BaseNodeAction duplicate() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.PortfolioBaseNodeAction#equals(Object)
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

    TransactionAction that = (TransactionAction) o;

    if ((amountVariable != null) ? (!amountVariable.equals(that.amountVariable)) : (that.amountVariable != null)) {
      return false;
    }

    if ((effectiveDateVariable != null) ? (!effectiveDateVariable.equals(that.effectiveDateVariable))
                                        : (that.effectiveDateVariable != null)) {
      return false;
    }

    return !((transCode != null) ? (!transCode.equals(that.transCode)) : (that.transCode != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.Executable#execute(com.ozstrategy.credagility.core.helper.EvaluateHelper,
   *       com.ozstrategy.credagility.core.helper.ExecuteHelper)
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    if (evaluate(evaluateHelper)) {
      this.triggered = true;
    } // end if-else
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount variable.
   *
   * @return  BaseVariable
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
   * getter method for trans code.
   *
   * @return  TransactionCode
   */
  public TransactionCode getTransCode() {
    return transCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans nodes.
   *
   * @return  Set
   */
  public Set<Node> getTransNodes() {
    return transNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.PortfolioBaseNodeAction#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((amountVariable != null) ? amountVariable.hashCode() : 0);
    result = (31 * result) + ((effectiveDateVariable != null) ? effectiveDateVariable.hashCode() : 0);
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
   * setter method for trans code.
   *
   * @param  transCode  TransactionCode
   */
  public void setTransCode(TransactionCode transCode) {
    this.transCode = transCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans nodes.
   *
   * @param  transNodes  Set
   */
  public void setTransNodes(Set<Node> transNodes) {
    this.transNodes = transNodes;
  }
} // end class TransactionAction
