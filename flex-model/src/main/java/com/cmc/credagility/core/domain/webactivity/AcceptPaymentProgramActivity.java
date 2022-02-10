package com.cmc.credagility.core.domain.webactivity;

import java.math.BigDecimal;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:38
 */
public class AcceptPaymentProgramActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 939015989420082877L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String     acceptDate;
  private Integer    duration;
  private BigDecimal fixedFee;
  private BigDecimal programAmount;
  private String     programId;
  private Integer    programOrder;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for accept date.
   *
   * @return  String
   */
  public String getAcceptDate() {
    return acceptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for duration.
   *
   * @return  Integer
   */
  public Integer getDuration() {
    return duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fixed fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFixedFee() {
    return fixedFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getProgramAmount() {
    return programAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program id.
   *
   * @return  String
   */
  public String getProgramId() {
    return programId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program order.
   *
   * @return  Integer
   */
  public Integer getProgramOrder() {
    return programOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accept date.
   *
   * @param  acceptDate  String
   */
  public void setAcceptDate(String acceptDate) {
    this.acceptDate = acceptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duration.
   *
   * @param  duration  Integer
   */
  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fixed fee.
   *
   * @param  fixedFee  BigDecimal
   */
  public void setFixedFee(BigDecimal fixedFee) {
    this.fixedFee = fixedFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program amount.
   *
   * @param  programAmount  BigDecimal
   */
  public void setProgramAmount(BigDecimal programAmount) {
    this.programAmount = programAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program id.
   *
   * @param  programId  String
   */
  public void setProgramId(String programId) {
    this.programId = programId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program order.
   *
   * @param  programOrder  Integer
   */
  public void setProgramOrder(Integer programOrder) {
    this.programOrder = programOrder;
  }


} // end class AcceptPaymentProgramActivity
