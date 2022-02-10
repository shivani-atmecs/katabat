package com.cmc.credagility.core.domain.preview;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.user.User;


/**
 * Preview request capture all request of preview.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 09:37
 */
@Entity public class PreviewRequest extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8848641072066213545L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Total accounts to be run. */
  @Column protected Long accountCount;

  /** TODO: DOCUMENT ME! */
  @Column protected Long accountNum;

  /** Account selection option, byAccountNum/byRandomDigit. */
  @Column(
    length   = 32,
    nullable = false
  )
  protected String byOption;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long copyFromScheduleId;

  /** preview cost. */

  @Column protected BigDecimal cost;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  protected Date executeDate;

  /** Total percentage to be run. */
  @Column protected BigDecimal percentage;

  /** Schedule portfolio. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long previewRequestId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String previewRequestName;

  /** TODO: DOCUMENT ME! */
  @Column protected Long processorId;

  /** Account random digits to select account. */
  @Column(length = 512)
  protected String randomDigits;

  /** TODO: DOCUMENT ME! */
  @Column protected Long responsibleId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String responsibleName;

  /** List of rules of schedule to be run. */
  @Transient protected String ruleIds;

  /** DOCUMENT ME! */
  @Transient protected String ruleNames;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  protected Date scheduleDate;

  /** Strategy schedule ID to be run. */
  @Column(nullable = false)
  protected Long scheduleId;

  /** Preview status: INIT/SPLIT/STARTED/FAIL/SUCCESS/CANCEL */
  @Column(length = 16)
  protected String status = "INIT";

  /** Strategy type name: program/channel/negotiateException/queue */
  @Column(
    length   = 64,
    nullable = false
  )
  protected String strategy = "universal";

  /** DOCUMENT ME! */
  @Column protected Long totalAccountRun;

  /** DOCUMENT ME! */
  @Column(length = 255)
  protected String type = "FREE";

  /** List of rules of schedule to be run. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "previewRequest",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  private Set<PreviewRequestItem> items = new LinkedHashSet<PreviewRequestItem>();

  /** List of sub-request fro the account splits. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "previewRequest",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  private Set<PreviewRequestSplit> splits = new LinkedHashSet<PreviewRequestSplit>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addRequestItem.
   *
   * @param  item  PreviewRequestItem
   */
  public void addRequestItem(PreviewRequestItem item) {
    item.setPreviewRequest(this);
    this.items.add(item);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addRequestSplit.
   *
   * @param  split  PreviewRequestSplit
   */
  public void addRequestSplit(PreviewRequestSplit split) {
    split.setPreviewRequest(this);
    this.splits.add(split);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculateCost.
   */
  public void calculateCost() {
    BigDecimal price = this.portfolio.getPreviewPricePerAccount();

    if ((price != null) && (price.compareTo(new BigDecimal("0.0")) > 0)) {
      this.cost = price.multiply(new BigDecimal(this.totalAccountRun));
    } else {
      this.cost = new BigDecimal("0.0");
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * cancelPreview.
   */
  public void cancelPreview() {
    this.status = "CANCEL";
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

    PreviewRequest that = (PreviewRequest) o;

    if ((accountCount != null) ? (!accountCount.equals(that.accountCount)) : (that.accountCount != null)) {
      return false;
    }

    if ((percentage != null) ? (!percentage.equals(that.percentage)) : (that.percentage != null)) {
      return false;
    }

    if ((byOption != null) ? (!byOption.equals(that.byOption)) : (that.byOption != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if ((randomDigits != null) ? (!randomDigits.equals(that.randomDigits)) : (that.randomDigits != null)) {
      return false;
    }

    if ((ruleIds != null) ? (!ruleIds.equals(that.ruleIds)) : (that.ruleIds != null)) {
      return false;
    }

    if ((scheduleId != null) ? (!scheduleId.equals(that.scheduleId)) : (that.scheduleId != null)) {
      return false;
    }

    if ((strategy != null) ? (!strategy.equals(that.strategy)) : (that.strategy != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account count.
   *
   * @return  Long
   */
  public Long getAccountCount() {
    return accountCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account num.
   *
   * @return  Long
   */
  public Long getAccountNum() {
    return accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by option.
   *
   * @return  String
   */
  public String getByOption() {
    return byOption;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for copy from schedule id.
   *
   * @return  Long
   */
  public Long getCopyFromScheduleId() {
    return copyFromScheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cost.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCost() {
    return cost;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for execute date.
   *
   * @return  Date
   */
  public Date getExecuteDate() {
    return executeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for items.
   *
   * @return  Set
   */
  public Set<PreviewRequestItem> getItems() {
    return items;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for percentage.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPercentage() {
    return percentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview request id.
   *
   * @return  Long
   */
  public Long getPreviewRequestId() {
    return previewRequestId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview request name.
   *
   * @return  String
   */
  public String getPreviewRequestName() {
    return previewRequestName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for processor id.
   *
   * @return  Long
   */
  public Long getProcessorId() {
    return processorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for random digits.
   *
   * @return  String
   */
  public String getRandomDigits() {
    return randomDigits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible id.
   *
   * @return  Long
   */
  public Long getResponsibleId() {
    return responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible name.
   *
   * @return  String
   */
  public String getResponsibleName() {
    return responsibleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule ids.
   *
   * @return  String
   */
  public String getRuleIds() {
    return ruleIds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule names.
   *
   * @return  String
   */
  public String getRuleNames() {
    return ruleNames;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule date.
   *
   * @return  Date
   */
  public Date getScheduleDate() {
    return scheduleDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule id.
   *
   * @return  Long
   */
  public Long getScheduleId() {
    return scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for splits.
   *
   * @return  Set
   */
  public Set<PreviewRequestSplit> getSplits() {
    return splits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy.
   *
   * @return  String
   */
  public String getStrategy() {
    return strategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total account run.
   *
   * @return  Long
   */
  public Long getTotalAccountRun() {
    return totalAccountRun;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((accountCount != null) ? accountCount.hashCode() : 0);
    result = (31 * result) + ((percentage != null) ? percentage.hashCode() : 0);
    result = (31 * result) + ((byOption != null) ? byOption.hashCode() : 0);
    result = (31 * result) + ((randomDigits != null) ? randomDigits.hashCode() : 0);
    result = (31 * result) + ((ruleIds != null) ? ruleIds.hashCode() : 0);
    result = (31 * result) + ((scheduleId != null) ? scheduleId.hashCode() : 0);
    result = (31 * result) + ((strategy != null) ? strategy.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for canceled.
   *
   * @return  boolean
   */
  public boolean isCanceled() {
    return ("CANCEL".equalsIgnoreCase(this.status));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for free.
   *
   * @return  boolean
   */
  public boolean isFree() {
    return this.type.equalsIgnoreCase("FREE");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for paid.
   *
   * @return  boolean
   */
  public boolean isPaid() {
    return this.type.equalsIgnoreCase("PAID");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * makePaid.
   *
   * @param  agent  User
   */
  public void makePaid(User agent) {
    Date now = new Date();
    this.type           = "PAID";
    this.lastUpdater    = agent;
    this.lastUpdateDate = now;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account count.
   *
   * @param  accountCount  Long
   */
  public void setAccountCount(Long accountCount) {
    this.accountCount = accountCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account num.
   *
   * @param  accountNum  Long
   */
  public void setAccountNum(Long accountNum) {
    this.accountNum = accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for by option.
   *
   * @param  byOption  String
   */
  public void setByOption(String byOption) {
    this.byOption = byOption;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for copy from schedule id.
   *
   * @param  copyFromScheduleId  Long
   */
  public void setCopyFromScheduleId(Long copyFromScheduleId) {
    this.copyFromScheduleId = copyFromScheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cost  DOCUMENT ME!
   */
  public void setCost(BigDecimal cost) {
    this.cost = cost;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for execute date.
   *
   * @param  executeDate  Date
   */
  public void setExecuteDate(Date executeDate) {
    this.executeDate = executeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for items.
   *
   * @param  items  Set
   */
  public void setItems(Set<PreviewRequestItem> items) {
    this.items = items;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  percentage  DOCUMENT ME!
   */
  public void setPercentage(BigDecimal percentage) {
    this.percentage = percentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview request id.
   *
   * @param  previewRequestId  Long
   */
  public void setPreviewRequestId(Long previewRequestId) {
    this.previewRequestId = previewRequestId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview request name.
   *
   * @param  previewRequestName  String
   */
  public void setPreviewRequestName(String previewRequestName) {
    this.previewRequestName = previewRequestName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for processor id.
   *
   * @param  processorId  Long
   */
  public void setProcessorId(Long processorId) {
    this.processorId = processorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for random digits.
   *
   * @param  randomDigits  String
   */
  public void setRandomDigits(String randomDigits) {
    this.randomDigits = randomDigits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible id.
   *
   * @param  responsibleId  Long
   */
  public void setResponsibleId(Long responsibleId) {
    this.responsibleId = responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible name.
   *
   * @param  responsibleName  String
   */
  public void setResponsibleName(String responsibleName) {
    this.responsibleName = responsibleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule ids.
   *
   * @param  ruleIds  String
   */
  public void setRuleIds(String ruleIds) {
    this.ruleIds = ruleIds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule names.
   *
   * @param  ruleNames  String
   */
  public void setRuleNames(String ruleNames) {
    this.ruleNames = ruleNames;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule date.
   *
   * @param  scheduleDate  Date
   */
  public void setScheduleDate(Date scheduleDate) {
    this.scheduleDate = scheduleDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule id.
   *
   * @param  scheduleId  Long
   */
  public void setScheduleId(Long scheduleId) {
    this.scheduleId = scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for splits.
   *
   * @param  splits  Set
   */
  public void setSplits(Set<PreviewRequestSplit> splits) {
    this.splits = splits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy.
   *
   * @param  strategy  String
   */
  public void setStrategy(String strategy) {
    this.strategy = strategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total account run.
   *
   * @param  totalAccountRun  Long
   */
  public void setTotalAccountRun(Long totalAccountRun) {
    this.totalAccountRun = totalAccountRun;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PreviewRequest");
    sb.append("{previewRequestId=").append(previewRequestId);
    sb.append(", portfolio=").append(portfolio);
    sb.append(", accountCount=").append(accountCount);
    sb.append(", percentage=").append(percentage);
    sb.append(", byOption='").append(byOption).append('\'');
    sb.append(", randomDigits='").append(randomDigits).append('\'');
    sb.append(", ruleIds='").append(ruleIds).append('\'');
    sb.append(", scheduleId=").append(scheduleId);
    sb.append(", strategy='").append(strategy).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class PreviewRequest
