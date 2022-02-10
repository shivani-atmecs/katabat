package com.cmc.credagility.core.domain.report;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Daily Performance Report.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/20/2014 17:58 PM
 */
@Entity @Table public class DailyPerformanceReport extends BaseReport {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountsStrategizedForDialer = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountsStrategizedForEmailSms = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountsStrategizedForIvr = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountsStrategizedForLetters = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountsStrategizedForOutboundAgentCalling = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long activeAccounts = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal agencyChannelPaymentsReceived = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal agentNoFundingAccountScheduledFuturePaymentsToday = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal agentScheduledFuturePaymentsToday = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal averagePlacementBalance = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal balanceOfUniqueAccountsPaid = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal clientDirectPaymentsReceived = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal cmcLockboxPaymentsReceived = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected Long cumulativeAccountsPlaced = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal cumulativeAgencyChannelPaymentsReceived = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal cumulativeBalancePlaced = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal cumulativeClientDirectPaymentsReceived = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal cumulativeCmcLockboxPaymentsReceived = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal cumulativeIvrPaymentReceived = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal cumulativeWebsitePaymentReceived = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected Long deletedTodayPayments = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long inactiveAccounts = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal ivrPaymentReceived = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal ivrScheduledFuturePaymentsToday = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected Long newAccountsPlaced = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal newBalancePlaced = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected Long numberOfFutureScheduledPayments = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long numberOfPayments = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long rejectedTodayPayments = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal scheduledFuturePaymentsToday = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected Long totalAccountsStrategizedForTreatment = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueAccountsPaid = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueAccountsPTDMakingAPayment = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueAccountsScheduledAPayment = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueAccountsScheduledFuturePaymentToday = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueAccountsWithDialerRpcResultCode = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueAccountsWithIvrRpcResultCode = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueAccountsWithOutboundDialerCallResult = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueAccountsWithOutboundIvrCallResult = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueAccountWebVisits = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueDirectInboundIvrCallsOfAccountSpokenToAgent = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueOutboundCallsOfAccountSpokenToAgent = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueOutboundDialerCallsOfAccountSpokenToAgent = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueOutboundIvrCallsOfAccountSpokenToAgent = 0L;

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal webScheduledFuturePaymentsToday = new BigDecimal(
      "0.00");

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal websitePaymentReceived = new BigDecimal(
      "0.00");

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getAccountsStrategizedForDialer() {
    return accountsStrategizedForDialer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getAccountsStrategizedForEmailSms() {
    return accountsStrategizedForEmailSms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getAccountsStrategizedForIvr() {
    return accountsStrategizedForIvr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getAccountsStrategizedForLetters() {
    return accountsStrategizedForLetters;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getAccountsStrategizedForOutboundAgentCalling() {
    return accountsStrategizedForOutboundAgentCalling;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getActiveAccounts() {
    return activeAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getAgencyChannelPaymentsReceived() {
    return agencyChannelPaymentsReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getAgentNoFundingAccountScheduledFuturePaymentsToday() {
    return agentNoFundingAccountScheduledFuturePaymentsToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getAgentScheduledFuturePaymentsToday() {
    return agentScheduledFuturePaymentsToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getAveragePlacementBalance() {
    return averagePlacementBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getBalanceOfUniqueAccountsPaid() {
    return balanceOfUniqueAccountsPaid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getClientDirectPaymentsReceived() {
    return clientDirectPaymentsReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getCmcLockboxPaymentsReceived() {
    return cmcLockboxPaymentsReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getCumulativeAccountsPlaced() {
    return cumulativeAccountsPlaced;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getCumulativeAgencyChannelPaymentsReceived() {
    return cumulativeAgencyChannelPaymentsReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getCumulativeBalancePlaced() {
    return cumulativeBalancePlaced;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getCumulativeClientDirectPaymentsReceived() {
    return cumulativeClientDirectPaymentsReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getCumulativeCmcLockboxPaymentsReceived() {
    return cumulativeCmcLockboxPaymentsReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getCumulativeIvrPaymentReceived() {
    return cumulativeIvrPaymentReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getCumulativeWebsitePaymentReceived() {
    return cumulativeWebsitePaymentReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getDeletedTodayPayments() {
    return deletedTodayPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getInactiveAccounts() {
    return inactiveAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getIvrPaymentReceived() {
    return ivrPaymentReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getIvrScheduledFuturePaymentsToday() {
    return ivrScheduledFuturePaymentsToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getNewAccountsPlaced() {
    return newAccountsPlaced;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getNewBalancePlaced() {
    return newBalancePlaced;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getNumberOfFutureScheduledPayments() {
    return numberOfFutureScheduledPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getNumberOfPayments() {
    return numberOfPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getRejectedTodayPayments() {
    return rejectedTodayPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getScheduledFuturePaymentsToday() {
    return scheduledFuturePaymentsToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getTotalAccountsStrategizedForTreatment() {
    return totalAccountsStrategizedForTreatment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueAccountsPaid() {
    return uniqueAccountsPaid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueAccountsPTDMakingAPayment() {
    return uniqueAccountsPTDMakingAPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueAccountsScheduledAPayment() {
    return uniqueAccountsScheduledAPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueAccountsScheduledFuturePaymentToday() {
    return uniqueAccountsScheduledFuturePaymentToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueAccountsWithDialerRpcResultCode() {
    return uniqueAccountsWithDialerRpcResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueAccountsWithIvrRpcResultCode() {
    return uniqueAccountsWithIvrRpcResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueAccountsWithOutboundDialerCallResult() {
    return uniqueAccountsWithOutboundDialerCallResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueAccountsWithOutboundIvrCallResult() {
    return uniqueAccountsWithOutboundIvrCallResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueAccountWebVisits() {
    return uniqueAccountWebVisits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueDirectInboundIvrCallsOfAccountSpokenToAgent() {
    return uniqueDirectInboundIvrCallsOfAccountSpokenToAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueOutboundCallsOfAccountSpokenToAgent() {
    return uniqueOutboundCallsOfAccountSpokenToAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueOutboundDialerCallsOfAccountSpokenToAgent() {
    return uniqueOutboundDialerCallsOfAccountSpokenToAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>not-null = "false"</p>
   */
  public Long getUniqueOutboundIvrCallsOfAccountSpokenToAgent() {
    return uniqueOutboundIvrCallsOfAccountSpokenToAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getWebScheduledFuturePaymentsToday() {
    return webScheduledFuturePaymentsToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getWebsitePaymentReceived() {
    return websitePaymentReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAccountsStrategizedForDialer.
   *
   * @param  accountsStrategizedForDialer  $param.type$
   */
  public void setAccountsStrategizedForDialer(Long accountsStrategizedForDialer) {
    this.accountsStrategizedForDialer = accountsStrategizedForDialer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAccountsStrategizedForEmailSms.
   *
   * @param  accountsStrategizedForEmailSms  $param.type$
   */
  public void setAccountsStrategizedForEmailSms(
    Long accountsStrategizedForEmailSms) {
    this.accountsStrategizedForEmailSms = accountsStrategizedForEmailSms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAccountsStrategizedForIvr.
   *
   * @param  accountsStrategizedForIvr  $param.type$
   */
  public void setAccountsStrategizedForIvr(Long accountsStrategizedForIvr) {
    this.accountsStrategizedForIvr = accountsStrategizedForIvr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAccountsStrategizedForLetters.
   *
   * @param  accountsStrategizedForLetters  $param.type$
   */
  public void setAccountsStrategizedForLetters(
    Long accountsStrategizedForLetters) {
    this.accountsStrategizedForLetters = accountsStrategizedForLetters;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAccountsStrategizedForOutboundAgentCalling.
   *
   * @param  accountsStrategizedForOutboundAgentCalling  $param.type$
   */
  public void setAccountsStrategizedForOutboundAgentCalling(
    Long accountsStrategizedForOutboundAgentCalling) {
    this.accountsStrategizedForOutboundAgentCalling = accountsStrategizedForOutboundAgentCalling;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setActiveAccounts.
   *
   * @param  activeAccounts  $param.type$
   */
  public void setActiveAccounts(Long activeAccounts) {
    this.activeAccounts = activeAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAgencyChannelPaymentsReceived.
   *
   * @param  agencyChannelPaymentsReceived  $param.type$
   */
  public void setAgencyChannelPaymentsReceived(
    BigDecimal agencyChannelPaymentsReceived) {
    this.agencyChannelPaymentsReceived = agencyChannelPaymentsReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAgentNoFundingAccountScheduledFuturePaymentsToday.
   *
   * @param  agentNoFundingAccountScheduledFuturePaymentsToday  $param.type$
   */
  public void setAgentNoFundingAccountScheduledFuturePaymentsToday(
    BigDecimal agentNoFundingAccountScheduledFuturePaymentsToday) {
    this.agentNoFundingAccountScheduledFuturePaymentsToday = agentNoFundingAccountScheduledFuturePaymentsToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAgentScheduledFuturePaymentsToday.
   *
   * @param  agentScheduledFuturePaymentsToday  $param.type$
   */
  public void setAgentScheduledFuturePaymentsToday(
    BigDecimal agentScheduledFuturePaymentsToday) {
    this.agentScheduledFuturePaymentsToday = agentScheduledFuturePaymentsToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAveragePlacementBalance.
   *
   * @param  averagePlacementBalance  $param.type$
   */
  public void setAveragePlacementBalance(BigDecimal averagePlacementBalance) {
    this.averagePlacementBalance = averagePlacementBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setBalanceOfUniqueAccountsPaid.
   *
   * @param  balanceOfUniqueAccountsPaid  $param.type$
   */
  public void setBalanceOfUniqueAccountsPaid(
    BigDecimal balanceOfUniqueAccountsPaid) {
    this.balanceOfUniqueAccountsPaid = balanceOfUniqueAccountsPaid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDirectPaymentsReceived.
   *
   * @param  clientDirectPaymentsReceived  $param.type$
   */
  public void setClientDirectPaymentsReceived(
    BigDecimal clientDirectPaymentsReceived) {
    this.clientDirectPaymentsReceived = clientDirectPaymentsReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCmcLockboxPaymentsReceived.
   *
   * @param  cmcLockboxPaymentsReceived  $param.type$
   */
  public void setCmcLockboxPaymentsReceived(
    BigDecimal cmcLockboxPaymentsReceived) {
    this.cmcLockboxPaymentsReceived = cmcLockboxPaymentsReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCumulativeAccountsPlaced.
   *
   * @param  cumulativeAccountsPlaced  $param.type$
   */
  public void setCumulativeAccountsPlaced(Long cumulativeAccountsPlaced) {
    this.cumulativeAccountsPlaced = cumulativeAccountsPlaced;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCumulativeAgencyChannelPaymentsReceived.
   *
   * @param  cumulativeAgencyChannelPaymentsReceived  $param.type$
   */
  public void setCumulativeAgencyChannelPaymentsReceived(
    BigDecimal cumulativeAgencyChannelPaymentsReceived) {
    this.cumulativeAgencyChannelPaymentsReceived = cumulativeAgencyChannelPaymentsReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCumulativeBalancePlaced.
   *
   * @param  cumulativeBalancePlaced  $param.type$
   */
  public void setCumulativeBalancePlaced(BigDecimal cumulativeBalancePlaced) {
    this.cumulativeBalancePlaced = cumulativeBalancePlaced;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCumulativeClientDirectPaymentsReceived.
   *
   * @param  cumulativeClientDirectPaymentsReceived  $param.type$
   */
  public void setCumulativeClientDirectPaymentsReceived(
    BigDecimal cumulativeClientDirectPaymentsReceived) {
    this.cumulativeClientDirectPaymentsReceived = cumulativeClientDirectPaymentsReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCumulativeCmcLockboxPaymentsReceived.
   *
   * @param  cumulativeCmcLockboxPaymentsReceived  $param.type$
   */
  public void setCumulativeCmcLockboxPaymentsReceived(
    BigDecimal cumulativeCmcLockboxPaymentsReceived) {
    this.cumulativeCmcLockboxPaymentsReceived = cumulativeCmcLockboxPaymentsReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCumulativeIvrPaymentReceived.
   *
   * @param  cumulativeIvrPaymentReceived  $param.type$
   */
  public void setCumulativeIvrPaymentReceived(
    BigDecimal cumulativeIvrPaymentReceived) {
    this.cumulativeIvrPaymentReceived = cumulativeIvrPaymentReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCumulativeWebsitePaymentReceived.
   *
   * @param  cumulativeWebsitePaymentReceived  $param.type$
   */
  public void setCumulativeWebsitePaymentReceived(
    BigDecimal cumulativeWebsitePaymentReceived) {
    this.cumulativeWebsitePaymentReceived = cumulativeWebsitePaymentReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setDeletedTodayPayments.
   *
   * @param  deletedTodayPayments  $param.type$
   */
  public void setDeletedTodayPayments(Long deletedTodayPayments) {
    this.deletedTodayPayments = deletedTodayPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setInactiveAccounts.
   *
   * @param  inactiveAccounts  $param.type$
   */
  public void setInactiveAccounts(Long inactiveAccounts) {
    this.inactiveAccounts = inactiveAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setIvrPaymentReceived.
   *
   * @param  ivrPaymentReceived  $param.type$
   */
  public void setIvrPaymentReceived(BigDecimal ivrPaymentReceived) {
    this.ivrPaymentReceived = ivrPaymentReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setIvrScheduledFuturePaymentsToday.
   *
   * @param  ivrScheduledFuturePaymentsToday  $param.type$
   */
  public void setIvrScheduledFuturePaymentsToday(
    BigDecimal ivrScheduledFuturePaymentsToday) {
    this.ivrScheduledFuturePaymentsToday = ivrScheduledFuturePaymentsToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setNewAccountsPlaced.
   *
   * @param  newAccountsPlaced  $param.type$
   */
  public void setNewAccountsPlaced(Long newAccountsPlaced) {
    this.newAccountsPlaced = newAccountsPlaced;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setNewBalancePlaced.
   *
   * @param  newBalancePlaced  $param.type$
   */
  public void setNewBalancePlaced(BigDecimal newBalancePlaced) {
    this.newBalancePlaced = newBalancePlaced;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for number of future scheduled payments.
   *
   * @param  numberOfFutureScheduledPayments  Long
   */
  public void setNumberOfFutureScheduledPayments(
    Long numberOfFutureScheduledPayments) {
    this.numberOfFutureScheduledPayments = numberOfFutureScheduledPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for number of payments.
   *
   * @param  numberOfPayments  Long
   */
  public void setNumberOfPayments(Long numberOfPayments) {
    this.numberOfPayments = numberOfPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setRejectedTodayPayments.
   *
   * @param  rejectedTodayPayments  $param.type$
   */
  public void setRejectedTodayPayments(Long rejectedTodayPayments) {
    this.rejectedTodayPayments = rejectedTodayPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setScheduledFuturePaymentsToday.
   *
   * @param  scheduledFuturePaymentsToday  $param.type$
   */
  public void setScheduledFuturePaymentsToday(
    BigDecimal scheduledFuturePaymentsToday) {
    this.scheduledFuturePaymentsToday = scheduledFuturePaymentsToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTotalAccountsStrategizedForTreatment.
   *
   * @param  totalAccountsStrategizedForTreatment  $param.type$
   */
  public void setTotalAccountsStrategizedForTreatment(
    Long totalAccountsStrategizedForTreatment) {
    this.totalAccountsStrategizedForTreatment = totalAccountsStrategizedForTreatment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueAccountsPaid.
   *
   * @param  uniqueAccountsPaid  $param.type$
   */
  public void setUniqueAccountsPaid(Long uniqueAccountsPaid) {
    this.uniqueAccountsPaid = uniqueAccountsPaid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueAccountsPTDMakingAPayment.
   *
   * @param  uniqueAccountsPTDMakingAPayment  $param.type$
   */
  public void setUniqueAccountsPTDMakingAPayment(
    Long uniqueAccountsPTDMakingAPayment) {
    this.uniqueAccountsPTDMakingAPayment = uniqueAccountsPTDMakingAPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueAccountsScheduledAPayment.
   *
   * @param  uniqueAccountsScheduledAPayment  $param.type$
   */
  public void setUniqueAccountsScheduledAPayment(
    Long uniqueAccountsScheduledAPayment) {
    this.uniqueAccountsScheduledAPayment = uniqueAccountsScheduledAPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueAccountsScheduledFuturePaymentToday.
   *
   * @param  uniqueAccountsScheduledFuturePaymentToday  $param.type$
   */
  public void setUniqueAccountsScheduledFuturePaymentToday(
    Long uniqueAccountsScheduledFuturePaymentToday) {
    this.uniqueAccountsScheduledFuturePaymentToday = uniqueAccountsScheduledFuturePaymentToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueAccountsWithDialerRpcResultCode.
   *
   * @param  uniqueAccountsWithDialerRpcResultCode  $param.type$
   */
  public void setUniqueAccountsWithDialerRpcResultCode(
    Long uniqueAccountsWithDialerRpcResultCode) {
    this.uniqueAccountsWithDialerRpcResultCode = uniqueAccountsWithDialerRpcResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueAccountsWithIvrRpcResultCode.
   *
   * @param  uniqueAccountsWithIvrRpcResultCode  $param.type$
   */
  public void setUniqueAccountsWithIvrRpcResultCode(
    Long uniqueAccountsWithIvrRpcResultCode) {
    this.uniqueAccountsWithIvrRpcResultCode = uniqueAccountsWithIvrRpcResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueAccountsWithOutboundDialerCallResult.
   *
   * @param  uniqueAccountsWithOutboundDialerCallResult  $param.type$
   */
  public void setUniqueAccountsWithOutboundDialerCallResult(
    Long uniqueAccountsWithOutboundDialerCallResult) {
    this.uniqueAccountsWithOutboundDialerCallResult = uniqueAccountsWithOutboundDialerCallResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueAccountsWithOutboundIvrCallResult.
   *
   * @param  uniqueAccountsWithOutboundIvrCallResult  $param.type$
   */
  public void setUniqueAccountsWithOutboundIvrCallResult(
    Long uniqueAccountsWithOutboundIvrCallResult) {
    this.uniqueAccountsWithOutboundIvrCallResult = uniqueAccountsWithOutboundIvrCallResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueAccountWebVisits.
   *
   * @param  uniqueAccountWebVisits  $param.type$
   */
  public void setUniqueAccountWebVisits(Long uniqueAccountWebVisits) {
    this.uniqueAccountWebVisits = uniqueAccountWebVisits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueDirectInboundIvrCallsOfAccountSpokenToAgent.
   *
   * @param  uniqueDirectInboundIvrCallsOfAccountSpokenToAgent  $param.type$
   */
  public void setUniqueDirectInboundIvrCallsOfAccountSpokenToAgent(
    Long uniqueDirectInboundIvrCallsOfAccountSpokenToAgent) {
    this.uniqueDirectInboundIvrCallsOfAccountSpokenToAgent = uniqueDirectInboundIvrCallsOfAccountSpokenToAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueOutboundCallsOfAccountSpokenToAgent.
   *
   * @param  uniqueOutboundCallsOfAccountSpokenToAgent  $param.type$
   */
  public void setUniqueOutboundCallsOfAccountSpokenToAgent(
    Long uniqueOutboundCallsOfAccountSpokenToAgent) {
    this.uniqueOutboundCallsOfAccountSpokenToAgent = uniqueOutboundCallsOfAccountSpokenToAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueOutboundDialerCallsOfAccountSpokenToAgent.
   *
   * @param  uniqueOutboundDialerCallsOfAccountSpokenToAgent  $param.type$
   */
  public void setUniqueOutboundDialerCallsOfAccountSpokenToAgent(
    Long uniqueOutboundDialerCallsOfAccountSpokenToAgent) {
    this.uniqueOutboundDialerCallsOfAccountSpokenToAgent = uniqueOutboundDialerCallsOfAccountSpokenToAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUniqueOutboundIvrCallsOfAccountSpokenToAgent.
   *
   * @param  uniqueOutboundIvrCallsOfAccountSpokenToAgent  $param.type$
   */
  public void setUniqueOutboundIvrCallsOfAccountSpokenToAgent(
    Long uniqueOutboundIvrCallsOfAccountSpokenToAgent) {
    this.uniqueOutboundIvrCallsOfAccountSpokenToAgent = uniqueOutboundIvrCallsOfAccountSpokenToAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setWebScheduledFuturePaymentsToday.
   *
   * @param  webScheduledFuturePaymentsToday  $param.type$
   */
  public void setWebScheduledFuturePaymentsToday(
    BigDecimal webScheduledFuturePaymentsToday) {
    this.webScheduledFuturePaymentsToday = webScheduledFuturePaymentsToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setWebsitePaymentReceived.
   *
   * @param  websitePaymentReceived  $param.type$
   */
  public void setWebsitePaymentReceived(BigDecimal websitePaymentReceived) {
    this.websitePaymentReceived = websitePaymentReceived;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "PerformanceReport{" + "reportId=" + reportId + ", reportDate="
      + reportDate + ", portfolio=" + portfolio + ", newAccountsPlaced="
      + newAccountsPlaced + ", cumulativeAccountsPlaced="
      + cumulativeAccountsPlaced + ", newBlancePlaced=" + newBalancePlaced
      + ", averagePlacementBalance=" + averagePlacementBalance
      + ", cumulativeBalancePlaced=" + cumulativeBalancePlaced
      + ", inactiveAccounts=" + inactiveAccounts + ", activeAccounts="
      + activeAccounts + ", accountsStrategizedForLetters="
      + accountsStrategizedForLetters + ", accountsStrategizedForIvr="
      + accountsStrategizedForIvr + ", accountsStrategizedForDialer="
      + accountsStrategizedForDialer
      + ", accountsStrategizedForOutboundAgentCalling="
      + accountsStrategizedForOutboundAgentCalling
      + ", accountsStrategizedForEmailSms=" + accountsStrategizedForEmailSms
      + ", totalAccountsStrategizedForTreatment="
      + totalAccountsStrategizedForTreatment + ", uniqueAccountWebVisits="
      + uniqueAccountWebVisits
      + ", uniqueDirectInboundIvrCallsOfAccountSpokenToAgent="
      + uniqueDirectInboundIvrCallsOfAccountSpokenToAgent
      + ", uniqueOutboundCallsOfAccountSpokenToAgent="
      + uniqueOutboundCallsOfAccountSpokenToAgent
      + ", uniqueOutboundDialerCallsOfAccountSpokenToAgent="
      + uniqueOutboundDialerCallsOfAccountSpokenToAgent
      + ", uniqueOutboundIvrCallsOfAccountSpokenToAgent="
      + uniqueOutboundIvrCallsOfAccountSpokenToAgent
      + ", uniqueAccountsWithOutboundIvrCallResult="
      + uniqueAccountsWithOutboundIvrCallResult
      + ", uniqueAccountsWithIvrRpcResultCode="
      + uniqueAccountsWithIvrRpcResultCode
      + ", uniqueAccountsWithOutboundDialerCallResult="
      + uniqueAccountsWithOutboundDialerCallResult
      + ", uniqueAccountsWithDialerRpcResultCode="
      + uniqueAccountsWithDialerRpcResultCode + ", uniqueAccountsPaid="
      + uniqueAccountsPaid + ", rejectedTodayPayments="
      + rejectedTodayPayments + ", deletedTodayPayments="
      + deletedTodayPayments + ", balanceOfUniqueAccountsPaid="
      + balanceOfUniqueAccountsPaid + ", uniqueAccountsScheduledAPayment="
      + uniqueAccountsScheduledAPayment
      + ", uniqueAccountsPTDMakingAPayment="
      + uniqueAccountsPTDMakingAPayment + ", agencyChannelPaymentsReceived="
      + agencyChannelPaymentsReceived
      + ", cumulativeAgencyChannelPaymentsReceived="
      + cumulativeAgencyChannelPaymentsReceived
      + ", clientDirectPaymentsReceived=" + clientDirectPaymentsReceived
      + ", cumulativeClientDirectPaymentsReceived="
      + cumulativeClientDirectPaymentsReceived
      + ", cmcLockboxPaymentsReceived=" + cmcLockboxPaymentsReceived
      + ", cumulativeCmcLockboxPaymentsReceived="
      + cumulativeCmcLockboxPaymentsReceived + ", websitePaymentReceived="
      + websitePaymentReceived + ", cumulativeWebsitePaymentReceived="
      + cumulativeWebsitePaymentReceived + ", ivrPaymentReceived="
      + ivrPaymentReceived + ", cumulativeIvrPaymentReceived="
      + cumulativeIvrPaymentReceived
      + ", uniqueAccountsScheduledFuturePaymentToday="
      + uniqueAccountsScheduledFuturePaymentToday
      + ", scheduledFuturePaymentsToday=" + scheduledFuturePaymentsToday
      + ", agentScheduledFuturePaymentsToday="
      + agentScheduledFuturePaymentsToday
      + ", webScheduledFuturePaymentsToday="
      + webScheduledFuturePaymentsToday
      + ", ivrScheduledFuturePaymentsToday="
      + ivrScheduledFuturePaymentsToday
      + ", agentNoFundingAccountScheduledFuturePaymentsToday="
      + agentNoFundingAccountScheduledFuturePaymentsToday + '}';
  } // end method toString
} // end class DailyPerformanceReport
