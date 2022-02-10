package com.cmc.credagility.core.domain.sor;


import java.math.BigDecimal;


/**
 * Created by zhubq on 5/6/16.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  05/06/2016 13:43
 */
public class BaseTransInfo {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Boolean    hasManualAction;
  private Long       transactionId;
  private BigDecimal transAmount;

  private String transCode;
  private String tranStatus;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseTransInfo object.
   */
  public BaseTransInfo() { }

  /**
   * Creates a new BaseTransInfo object.<br/>
   * </>t.transactionCode.transCode,t.transStatus,t.transactionId,t.hasManualAction
   *
   * @param  objArray  Object[]
   */
  public BaseTransInfo(Object[] objArray) {
    if ((null != objArray) && (objArray.length == 4)) {
      this.transCode       = (String) objArray[0];
      this.tranStatus      = (String) objArray[1];
      this.transactionId   = (Long) objArray[2];
      this.hasManualAction = (Boolean) objArray[3];
    }
  }

  /**
   * Creates a new BaseTransInfo object.
   *
   * @param  transactionId  Long
   * @param  transAmount    BigDecimal
   */
  public BaseTransInfo(Long transactionId, BigDecimal transAmount) {
    this.transactionId = transactionId;
    this.transAmount   = transAmount;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for has manual action.
   *
   * @return  Boolean
   */
  public Boolean getHasManualAction() {
    return hasManualAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction id.
   *
   * @return  Long
   */
  public Long getTransactionId() {
    return transactionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTransAmount() {
    return transAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans code.
   *
   * @return  String
   */
  public String getTransCode() {
    return transCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tran status.
   *
   * @return  String
   */
  public String getTranStatus() {
    return tranStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for has manual action.
   *
   * @param  hasManualAction  Boolean
   */
  public void setHasManualAction(Boolean hasManualAction) {
    this.hasManualAction = hasManualAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction id.
   *
   * @param  transactionId  Long
   */
  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans amount.
   *
   * @param  transAmount  BigDecimal
   */
  public void setTransAmount(BigDecimal transAmount) {
    this.transAmount = transAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans code.
   *
   * @param  transCode  String
   */
  public void setTransCode(String transCode) {
    this.transCode = transCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tran status.
   *
   * @param  tranStatus  String
   */
  public void setTranStatus(String tranStatus) {
    this.tranStatus = tranStatus;
  }
} // end class BaseTransInfo
