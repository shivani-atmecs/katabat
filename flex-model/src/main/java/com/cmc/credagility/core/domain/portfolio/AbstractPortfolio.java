package com.cmc.credagility.core.domain.portfolio;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Created by IntelliJ IDEA. User: ye Date: Apr 30, 2010 Time: 11:17:34 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public class AbstractPortfolio extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6866258315855349159L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "cutOffTime",
    length = 10
  )
  protected String cutOffTime;

  /** DOCUMENT ME! */
  @Column(
    name      = "overBalanceToleranceAmount",
    precision = 19,
    scale     = 2
  )
  protected BigDecimal overBalanceToleranceAmount;

  /** DOCUMENT ME! */
  @Column(
    name   = "overBalanceTolerancePercentage",
    length = 3
  )
  protected Integer overBalanceTolerancePercentage;

  /** Count of accounts that Preview need to pay. */
  @Column protected Long previewPaidCount;

  /** Percentage of accounts that Preview need to pay. */
  @Column(
    name      = "previewPaidPercentage",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal previewPaidPercentage;

  /** Price for each account need to pay. */
  @Column(
    name      = "previewPricePerAccount",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal previewPricePerAccount;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for cut off time.
   *
   * @return  String
   */
  public String getCutOffTime() {
    return cutOffTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for over balance tolerance amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOverBalanceToleranceAmount() {
    return overBalanceToleranceAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for over balance tolerance percentage.
   *
   * @return  Integer
   */
  public Integer getOverBalanceTolerancePercentage() {
    return overBalanceTolerancePercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPreviewPaidCount() {
    return previewPaidCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPreviewPaidPercentage() {
    return previewPaidPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPreviewPricePerAccount() {
    return previewPricePerAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cut off time.
   *
   * @param  cutOffTime  String
   */
  public void setCutOffTime(String cutOffTime) {
    this.cutOffTime = cutOffTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for over balance tolerance amount.
   *
   * @param  overBalanceToleranceAmount  BigDecimal
   */
  public void setOverBalanceToleranceAmount(BigDecimal overBalanceToleranceAmount) {
    this.overBalanceToleranceAmount = overBalanceToleranceAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for over balance tolerance percentage.
   *
   * @param  overBalanceTolerancePercentage  Integer
   */
  public void setOverBalanceTolerancePercentage(Integer overBalanceTolerancePercentage) {
    this.overBalanceTolerancePercentage = overBalanceTolerancePercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  previewPaidCount  DOCUMENT ME!
   */
  public void setPreviewPaidCount(Long previewPaidCount) {
    this.previewPaidCount = previewPaidCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  previewPaidPercentage  DOCUMENT ME!
   */
  public void setPreviewPaidPercentage(BigDecimal previewPaidPercentage) {
    this.previewPaidPercentage = previewPaidPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  previewPricePerAccount  DOCUMENT ME!
   */
  public void setPreviewPricePerAccount(BigDecimal previewPricePerAccount) {
    this.previewPricePerAccount = previewPricePerAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void updatePortfolio(Portfolio other) {
    this.previewPaidCount       = other.getPreviewPaidCount();
    this.previewPaidPercentage  = other.getPreviewPaidPercentage();
    this.previewPricePerAccount = other.getPreviewPricePerAccount();
    
    this.overBalanceToleranceAmount = other.getOverBalanceToleranceAmount();
    this.overBalanceTolerancePercentage = other.getOverBalanceTolerancePercentage();
  }
} // end class AbstractPortfolio
