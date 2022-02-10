package com.cmc.credagility.core.domain.sor;


import java.io.Serializable;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.responsible.Responsible;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  11/20/2015 11:16
 */
@Entity
@Table(
  name    = "Transaction",
  indexes = {
    @Index(
      name = "transStatusIndex",
      columnList = "transStatus"
    )
  }
)
public class Transaction extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long   serialVersionUID    = 1169372742670188056L;
  private static final String GLExportDatePattern = "MM/dd/YYYY";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "accountNum",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2,
    nullable  = true
  )
  protected BigDecimal actualAmount;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long agencyId;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 4,
    nullable = true
  )
  protected String assessFeeTransCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal balance;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean balanceChanged = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = true
  )
  protected String batchId;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long clientId;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 16
  )
  protected String creatorType;

  /** TODO: DOCUMENT ME! */
  @Column(name = "deletedDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deletedDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "effectiveDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date effectiveDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal fee1;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal fee1Credit;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal fee2;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal fee2Credit;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal fee3;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal fee3Credit;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal fee4;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal fee4Credit;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "GLExportDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date GLExportDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "grouping",
    nullable = true
  )
  protected Long group;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char default 'N'",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean hasGlTrans = Boolean.FALSE;


  /**
   * this field indicate that the transaction is reversed /reinstated or not<br/>
   * it will be used when import negative amount fee / payment and need reversed.
   */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean hasManualAction = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal interest;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal interestCredit;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char default 'N'",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isAccruedInterest = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char default 'N'",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isGlTrans = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char default 'N'",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isJudgement = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "lastInterestDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastInterestDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastPayAmount")
  protected BigDecimal lastPayAmount;

  /** last pay date. */
  @Column(name = "lastPayDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastPayDate;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long lastUpdateUserId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "manualActionDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date manualActionDate;

  /** this field indicate that this transaction is generate by reverse/reinstate which transaction. */
  @Column(nullable = true)
  protected Long manualActionPreTransId;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 30,
    nullable = true
  )
  protected String manualActionType;

  /** the original unique sign when payment or fee import. */
  @Column(
    name     = "originalGroup",
    nullable = true
  )
  protected Long originalGroup;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = true
  )
  protected String parentBatchId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "paymentId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Payment payment;

  /** TODO: DOCUMENT ME! */
  @Column(name = "postedDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date postedDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal preBalance;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal preFee1;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal preFee2;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal preFee3;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal preFee4;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal preInterest;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "preInterestDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date preInterestDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "preLastPayAmount")
  protected BigDecimal preLastPayAmount;

  /** last pay date. */
  @Column(name = "preLastPayDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date preLastPayDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal prePrincipal;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long preTransId;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 10,
    nullable = true
  )
  protected String preTransStatus;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal principal;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2
  )
  protected BigDecimal principalCredit;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "responsibleId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsibleId;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char default 'N'",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean reversedGlTrans = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(length = 40)
  protected String source;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "transCodeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TransactionCode transactionCode;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long transactionId;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2,
    nullable  = false
  )
  protected BigDecimal transAmount;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 16,
    nullable = true
  )
  protected String transSourceType;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 10,
    nullable = true
  )
  protected String transStatus;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long userId;


  /** TODO: DOCUMENT ME! */

  /** TODO: DOCUMENT ME! */
  @Transient String externalReferenceNumber;

  /** TODO: DOCUMENT ME! */
  @Transient String fundingAccount;

  /** TODO: DOCUMENT ME! */
  @Transient String fundingSource;

  /** TODO: DOCUMENT ME! */
  @Transient Map<Long, BaseTransInfo> reversedManualActionTransMap;

  /** TODO: DOCUMENT ME! */
  @Transient boolean savePrimaryTrans = false;

  /** TODO: DOCUMENT ME! */
  @Transient boolean updateAccountInfo = false;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new Transaction object.
   */
  public Transaction() {
    super.lastUpdateDate = null;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * calculateFeeCredit.
   */
  public void calculateCOFFeeCredit() {
    this.fee1Credit = this.getFee1().subtract(getPreFee1());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculateCredit.
   */
  public void calculateCredit() {
    calculatePrincipalCredit();
    calculateInterestCredit();
    calculateCOFFeeCredit();
    calculateFee2Credit();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculateFee1Credit.
   */
  public void calculateFee1Credit() {
    this.fee1Credit = this.getFee1().subtract(getPreFee1());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculateFee2Credit.
   */
  public void calculateFee2Credit() {
    this.fee2Credit = this.getFee2().subtract(getPreFee2());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculateInterestCredit.
   */
  public void calculateInterestCredit() {
    this.interestCredit = this.getInterest().subtract(getPreInterest());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculateCredit.
   */
  public void calculatePrincipalCredit() {
    this.principalCredit = this.getPrincipal().subtract(getPrePrincipal());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * cancelTrans.
   */
  public void cancelTrans() {
    setPreTransStatus(getTransStatus());
    setTransStatus(TransStatusEnum.CANCELLED.name());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyPaymentValues.
   *
   * @param  preTrans  Transaction
   */
  public void copyPaymentValues(Transaction preTrans) {
    this.setPreLastPayDate(preTrans.getPreLastPayDate());
    this.setPreLastPayAmount(preTrans.getPreLastPayAmount());
    this.setLastPayDate(preTrans.getLastPayDate());
    this.setLastPayAmount(preTrans.getLastPayAmount());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  from  Transaction
   */
  public void deepCopy(Transaction from) {
    if (null != from) {
      setAccount(from.getAccount());
      setBalance(from.getBalance());
      setLastInterestDate(from.getLastInterestDate());
      setPreInterestDate(from.getPreInterestDate());
      setTransAmount(from.getTransAmount());

      setPreBalance(from.getPreBalance());
      setPrePrincipal(from.getPrePrincipal());
      setPreFee1(from.getPreFee1());
      setPreFee2(from.getPreFee2());
      setPreFee3(from.getPreFee3());
      setPreFee4(from.getPreFee4());
      setPreInterest(from.getPreInterest());

      setBalance(from.getBalance());
      setPrincipal(from.getPrincipal());
      setFee1(from.getFee1());
      setFee2(from.getFee2());
      setFee3(from.getFee3());
      setFee4(from.getFee4());
      setInterest(from.getInterest());

      setPrincipalCredit(from.getPrincipalCredit());
      setFee1Credit(from.getFee1Credit());
      setFee2Credit(from.getFee2Credit());
      setFee3Credit(from.getFee3Credit());
      setFee4Credit(from.getFee4Credit());
      setInterestCredit(from.getInterestCredit());

      setBatchId(from.getBatchId());
      setParentBatchId(from.getParentBatchId());
      setPayment(from.getPayment());
      setSource(from.getSource());
      setTransStatus(from.getTransStatus());
      setPreTransStatus(from.getPreTransStatus());
      setEffectiveDate(from.getEffectiveDate());
      setActualAmount(from.getActualAmount());

      // copy payment info
      setPreLastPayDate(from.getPreLastPayDate());
      setPreLastPayAmount(from.getPreLastPayAmount());
      setLastPayDate(from.getLastPayDate());
      setLastPayAmount(from.getLastPayAmount());

      setCreatorType(from.getCreatorType());
      setUserId(from.getUserId());
      setTransSourceType(from.getTransSourceType());
      setPostedDate(from.getPostedDate());

      setClientId(from.getClientId());
      setAgencyId(from.getAgencyId());

    } // end if
  }   // end method deepCopy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(java.lang.Object)
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

    Transaction that = (Transaction) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((actualAmount != null) ? (!actualAmount.equals(that.actualAmount)) : (that.actualAmount != null)) {
      return false;
    }

    if ((agencyId != null) ? (!agencyId.equals(that.agencyId)) : (that.agencyId != null)) {
      return false;
    }

    if ((assessFeeTransCode != null) ? (!assessFeeTransCode.equals(that.assessFeeTransCode))
                                     : (that.assessFeeTransCode != null)) {
      return false;
    }

    if ((balance != null) ? (!balance.equals(that.balance)) : (that.balance != null)) {
      return false;
    }

    if ((balanceChanged != null) ? (!balanceChanged.equals(that.balanceChanged)) : (that.balanceChanged != null)) {
      return false;
    }

    if ((batchId != null) ? (!batchId.equals(that.batchId)) : (that.batchId != null)) {
      return false;
    }

    if ((clientId != null) ? (!clientId.equals(that.clientId)) : (that.clientId != null)) {
      return false;
    }

    if ((creatorType != null) ? (!creatorType.equals(that.creatorType)) : (that.creatorType != null)) {
      return false;
    }

    if ((deletedDate != null) ? (!deletedDate.equals(that.deletedDate)) : (that.deletedDate != null)) {
      return false;
    }

    if ((effectiveDate != null) ? (!effectiveDate.equals(that.effectiveDate)) : (that.effectiveDate != null)) {
      return false;
    }

    if ((fee1 != null) ? (!fee1.equals(that.fee1)) : (that.fee1 != null)) {
      return false;
    }

    if ((fee1Credit != null) ? (!fee1Credit.equals(that.fee1Credit)) : (that.fee1Credit != null)) {
      return false;
    }

    if ((fee2 != null) ? (!fee2.equals(that.fee2)) : (that.fee2 != null)) {
      return false;
    }

    if ((fee2Credit != null) ? (!fee2Credit.equals(that.fee2Credit)) : (that.fee2Credit != null)) {
      return false;
    }

    if ((fee3 != null) ? (!fee3.equals(that.fee3)) : (that.fee3 != null)) {
      return false;
    }

    if ((fee3Credit != null) ? (!fee3Credit.equals(that.fee3Credit)) : (that.fee3Credit != null)) {
      return false;
    }

    if ((fee4 != null) ? (!fee4.equals(that.fee4)) : (that.fee4 != null)) {
      return false;
    }

    if ((fee4Credit != null) ? (!fee4Credit.equals(that.fee4Credit)) : (that.fee4Credit != null)) {
      return false;
    }

    if ((GLExportDate != null) ? (!GLExportDate.equals(that.GLExportDate)) : (that.GLExportDate != null)) {
      return false;
    }

    if ((group != null) ? (!group.equals(that.group)) : (that.group != null)) {
      return false;
    }

    if ((hasGlTrans != null) ? (!hasGlTrans.equals(that.hasGlTrans)) : (that.hasGlTrans != null)) {
      return false;
    }

    if ((hasManualAction != null) ? (!hasManualAction.equals(that.hasManualAction)) : (that.hasManualAction != null)) {
      return false;
    }

    if ((interest != null) ? (!interest.equals(that.interest)) : (that.interest != null)) {
      return false;
    }

    if ((interestCredit != null) ? (!interestCredit.equals(that.interestCredit)) : (that.interestCredit != null)) {
      return false;
    }

    if ((isAccruedInterest != null) ? (!isAccruedInterest.equals(that.isAccruedInterest))
                                    : (that.isAccruedInterest != null)) {
      return false;
    }

    if ((isGlTrans != null) ? (!isGlTrans.equals(that.isGlTrans)) : (that.isGlTrans != null)) {
      return false;
    }

    if ((isJudgement != null) ? (!isJudgement.equals(that.isJudgement)) : (that.isJudgement != null)) {
      return false;
    }

    if ((lastInterestDate != null) ? (!lastInterestDate.equals(that.lastInterestDate))
                                   : (that.lastInterestDate != null)) {
      return false;
    }

    if ((lastPayAmount != null) ? (!lastPayAmount.equals(that.lastPayAmount)) : (that.lastPayAmount != null)) {
      return false;
    }

    if ((lastPayDate != null) ? (!lastPayDate.equals(that.lastPayDate)) : (that.lastPayDate != null)) {
      return false;
    }

    if ((lastUpdateUserId != null) ? (!lastUpdateUserId.equals(that.lastUpdateUserId))
                                   : (that.lastUpdateUserId != null)) {
      return false;
    }

    if ((manualActionDate != null) ? (!manualActionDate.equals(that.manualActionDate))
                                   : (that.manualActionDate != null)) {
      return false;
    }

    if ((manualActionPreTransId != null) ? (!manualActionPreTransId.equals(that.manualActionPreTransId))
                                         : (that.manualActionPreTransId != null)) {
      return false;
    }

    if ((manualActionType != null) ? (!manualActionType.equals(that.manualActionType))
                                   : (that.manualActionType != null)) {
      return false;
    }

    if ((originalGroup != null) ? (!originalGroup.equals(that.originalGroup)) : (that.originalGroup != null)) {
      return false;
    }

    if ((parentBatchId != null) ? (!parentBatchId.equals(that.parentBatchId)) : (that.parentBatchId != null)) {
      return false;
    }

    if ((payment != null) ? (!payment.equals(that.payment)) : (that.payment != null)) {
      return false;
    }

    if ((postedDate != null) ? (!postedDate.equals(that.postedDate)) : (that.postedDate != null)) {
      return false;
    }

    if ((preBalance != null) ? (!preBalance.equals(that.preBalance)) : (that.preBalance != null)) {
      return false;
    }

    if ((preFee1 != null) ? (!preFee1.equals(that.preFee1)) : (that.preFee1 != null)) {
      return false;
    }

    if ((preFee2 != null) ? (!preFee2.equals(that.preFee2)) : (that.preFee2 != null)) {
      return false;
    }

    if ((preFee3 != null) ? (!preFee3.equals(that.preFee3)) : (that.preFee3 != null)) {
      return false;
    }

    if ((preFee4 != null) ? (!preFee4.equals(that.preFee4)) : (that.preFee4 != null)) {
      return false;
    }

    if ((preInterest != null) ? (!preInterest.equals(that.preInterest)) : (that.preInterest != null)) {
      return false;
    }

    if ((preInterestDate != null) ? (!preInterestDate.equals(that.preInterestDate)) : (that.preInterestDate != null)) {
      return false;
    }

    if ((preLastPayAmount != null) ? (!preLastPayAmount.equals(that.preLastPayAmount))
                                   : (that.preLastPayAmount != null)) {
      return false;
    }

    if ((preLastPayDate != null) ? (!preLastPayDate.equals(that.preLastPayDate)) : (that.preLastPayDate != null)) {
      return false;
    }

    if ((prePrincipal != null) ? (!prePrincipal.equals(that.prePrincipal)) : (that.prePrincipal != null)) {
      return false;
    }

    if ((preTransId != null) ? (!preTransId.equals(that.preTransId)) : (that.preTransId != null)) {
      return false;
    }

    if ((preTransStatus != null) ? (!preTransStatus.equals(that.preTransStatus)) : (that.preTransStatus != null)) {
      return false;
    }

    if ((principal != null) ? (!principal.equals(that.principal)) : (that.principal != null)) {
      return false;
    }

    if ((principalCredit != null) ? (!principalCredit.equals(that.principalCredit)) : (that.principalCredit != null)) {
      return false;
    }

    if ((responsibleId != null) ? (!responsibleId.equals(that.responsibleId)) : (that.responsibleId != null)) {
      return false;
    }

    if ((reversedGlTrans != null) ? (!reversedGlTrans.equals(that.reversedGlTrans)) : (that.reversedGlTrans != null)) {
      return false;
    }

    if ((source != null) ? (!source.equals(that.source)) : (that.source != null)) {
      return false;
    }

    if ((transactionCode != null) ? (!transactionCode.equals(that.transactionCode)) : (that.transactionCode != null)) {
      return false;
    }

    if ((transactionId != null) ? (!transactionId.equals(that.transactionId)) : (that.transactionId != null)) {
      return false;
    }

    if ((transAmount != null) ? (!transAmount.equals(that.transAmount)) : (that.transAmount != null)) {
      return false;
    }

    if ((transSourceType != null) ? (!transSourceType.equals(that.transSourceType)) : (that.transSourceType != null)) {
      return false;
    }

    if ((transStatus != null) ? (!transStatus.equals(that.transStatus)) : (that.transStatus != null)) {
      return false;
    }

    return (userId != null) ? userId.equals(that.userId) : (that.userId == null);

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * evalIs.
   *
   * @return  evalIs
   */
  public boolean evalIsGlTrans() {
    return (null != this.getTransactionCode()) && "GL".equals(this.getTransactionCode().getGroup());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * needHandleManualAction.
   *
   * @return  boolean
   */
  public boolean feeNeedHandleManualAction() {
    return (getTransAmount().compareTo(BigDecimal.ZERO) >= 0) && (getActualAmount().compareTo(BigDecimal.ZERO) > 0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * generate.
   *
   * @return  Transaction
   */
  public Transaction generateGlTrans() {
    Transaction glTrans = null;

    if ((null != transactionCode) && StringUtils.hasText(transactionCode.getGLCode())) {
      glTrans = new Transaction();
      glTrans.deepCopy(this);
      glTrans.setHasManualAction(Boolean.FALSE);
      glTrans.setGlTrans(true);
      glTrans.setOriginalGroup(this.getOriginalGroup());

    } // end if

    return glTrans;
  } // end method generateGlTrans

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account num.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accrued interest.
   *
   * @return  Boolean
   */
  public Boolean getAccruedInterest() {
    return isAccruedInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for actual amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getActualAmount() {
    return actualAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency id.
   *
   * @return  Long
   */
  public Long getAgencyId() {
    return agencyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assess fee trans code.
   *
   * @return  String
   */
  public String getAssessFeeTransCode() {
    return assessFeeTransCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalance() {
    return (null == balance) ? BigDecimal.ZERO : balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance changed.
   *
   * @return  Boolean
   */
  public Boolean getBalanceChanged() {
    if (null == balanceChanged) {
      return Boolean.FALSE;
    }

    return balanceChanged;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch id.
   *
   * @return  String
   */
  public String getBatchId() {
    return batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client id.
   *
   * @return  Long
   */
  public Long getClientId() {
    return clientId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator type.
   *
   * @return  String
   */
  public String getCreatorType() {
    return creatorType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deleted date.
   *
   * @return  Date
   */
  public Date getDeletedDate() {
    return deletedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction date.
   *
   * @return  Date
   */
  public Date getEffectiveDate() {
    return effectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external reference number.
   *
   * @return  String
   */
  public String getExternalReferenceNumber() {
    return externalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee1() {
    return (null == fee1) ? BigDecimal.ZERO : fee1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee1 credit.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee1Credit() {
    return fee1Credit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee2() {
    return (null == fee2) ? BigDecimal.ZERO : fee2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee2 credit.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee2Credit() {
    return fee2Credit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee3() {
    return fee3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee3 credit.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee3Credit() {
    return fee3Credit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee4.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee4() {
    return fee4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee4 credit.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee4Credit() {
    return fee4Credit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account.
   *
   * @return  String
   */
  public String getFundingAccount() {
    return fundingAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding source.
   *
   * @return  String
   */
  public String getFundingSource() {
    return fundingSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for GLExport date.
   *
   * @return  Date
   */
  public Date getGLExportDate() {
    return GLExportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for GLExport date key pair.
   *
   * @return  String
   */
  public String getGLExportDateKeyPair() {
    String           datepattern = this.account.getPortfolio().getJavaDateFormat();
    SimpleDateFormat sdf         = new SimpleDateFormat((datepattern == null) ? GLExportDatePattern : datepattern);

    return (null == this.GLExportDate) ? "" : (", Exported Date: " + sdf.format(this.GLExportDate));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gl trans.
   *
   * @return  Boolean
   */
  public Boolean getGlTrans() {
    return isGlTrans;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for group.
   *
   * @return  Long
   */
  public Long getGroup() {
    return group;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has gl trans.
   *
   * @return  Boolean
   */
  public Boolean getHasGlTrans() {
    return hasGlTrans;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInterest() {
    return (null == interest) ? BigDecimal.ZERO : interest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for interest credit.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInterestCredit() {
    return interestCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for judgement.
   *
   * @return  Boolean
   */
  public Boolean getJudgement() {
    return (null == isJudgement) ? Boolean.FALSE : isJudgement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last interest date.
   *
   * @return  Date
   */
  public Date getLastInterestDate() {
    return lastInterestDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last pay amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLastPayAmount() {
    return lastPayAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last pay date.
   *
   * @return  Date
   */
  public Date getLastPayDate() {
    return lastPayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last update user id.
   *
   * @return  Long
   */
  public Long getLastUpdateUserId() {
    return lastUpdateUserId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for manual action date.
   *
   * @return  String
   */
  public Date getManualActionDate() {
    return manualActionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for manual action pre trans id.
   *
   * @return  Long
   */
  public Long getManualActionPreTransId() {
    return manualActionPreTransId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for manual action type.
   *
   * @return  String
   */
  public String getManualActionType() {
    return manualActionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original group.
   *
   * @return  Long
   */
  public Long getOriginalGroup() {
    return originalGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for parent batch id.
   *
   * @return  String
   */
  public String getParentBatchId() {
    return parentBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment.
   *
   * @return  Payment
   */
  public Payment getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for posting date.
   *
   * @return  Date
   */
  public Date getPostedDate() {
    return postedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreBalance() {
    return preBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre fee1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreFee1() {
    return preFee1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre fee2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreFee2() {
    return preFee2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre fee3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreFee3() {
    return preFee3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre fee4.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreFee4() {
    return preFee4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreInterest() {
    return preInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre interest date.
   *
   * @return  Date
   */
  public Date getPreInterestDate() {
    return preInterestDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre last pay amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreLastPayAmount() {
    return preLastPayAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre last pay date.
   *
   * @return  Date
   */
  public Date getPreLastPayDate() {
    return preLastPayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPrePrincipal() {
    return prePrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre trans id.
   *
   * @return  Long
   */
  public Long getPreTransId() {
    return preTransId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre trans status.
   *
   * @return  String
   */
  public String getPreTransStatus() {
    return preTransStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPrincipal() {
    return (null == principal) ? BigDecimal.ZERO : principal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for principal credit.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPrincipalCredit() {
    return principalCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible id.
   *
   * @return  Responsible
   */
  public Responsible getResponsibleId() {
    return responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reversed gl trans.
   *
   * @return  Boolean
   */
  public Boolean getReversedGlTrans() {
    return reversedGlTrans;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reversed manual action trans map.
   *
   * @return  Map
   */
  public Map<Long, BaseTransInfo> getReversedManualActionTransMap() {
    return reversedManualActionTransMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source.
   *
   * @return  String
   */
  public String getSource() {
    return source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction code.
   *
   * @return  com.cmc.credagility.core.domain.sor.TransactionCode
   */
  public TransactionCode getTransactionCode() {
    return transactionCode;
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
   * getter method for trans source type.
   *
   * @return  String
   */
  public String getTransSourceType() {
    return transSourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans status.
   *
   * @return  String
   */
  public String getTransStatus() {
    return transStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans type.
   *
   * @return  String
   */
  public String getTransType() {
    if ((null != transactionCode) && (null != transactionCode.getTransType())) {
      return transactionCode.getTransType().getTransType();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user id.
   *
   * @return  Long
   */
  public Long getUserId() {
    return userId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for OCATrans source type.
   *
   * @return  boolean
   */
  public boolean hasAccessFeeTrans() {
    return StringUtils.hasText(this.transSourceType)
      && (TransSourceTypeEnum.JOBIMPORT.toString().equalsIgnoreCase(this.transSourceType)
        || TransSourceTypeEnum.ONLINEBATCH.toString().equalsIgnoreCase((this.transSourceType)));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((actualAmount != null) ? actualAmount.hashCode() : 0);
    result = (31 * result) + ((agencyId != null) ? agencyId.hashCode() : 0);
    result = (31 * result) + ((assessFeeTransCode != null) ? assessFeeTransCode.hashCode() : 0);
    result = (31 * result) + ((balance != null) ? balance.hashCode() : 0);
    result = (31 * result) + ((balanceChanged != null) ? balanceChanged.hashCode() : 0);
    result = (31 * result) + ((batchId != null) ? batchId.hashCode() : 0);
    result = (31 * result) + ((clientId != null) ? clientId.hashCode() : 0);
    result = (31 * result) + ((creatorType != null) ? creatorType.hashCode() : 0);
    result = (31 * result) + ((deletedDate != null) ? deletedDate.hashCode() : 0);
    result = (31 * result) + ((effectiveDate != null) ? effectiveDate.hashCode() : 0);
    result = (31 * result) + ((fee1 != null) ? fee1.hashCode() : 0);
    result = (31 * result) + ((fee1Credit != null) ? fee1Credit.hashCode() : 0);
    result = (31 * result) + ((fee2 != null) ? fee2.hashCode() : 0);
    result = (31 * result) + ((fee2Credit != null) ? fee2Credit.hashCode() : 0);
    result = (31 * result) + ((fee3 != null) ? fee3.hashCode() : 0);
    result = (31 * result) + ((fee3Credit != null) ? fee3Credit.hashCode() : 0);
    result = (31 * result) + ((fee4 != null) ? fee4.hashCode() : 0);
    result = (31 * result) + ((fee4Credit != null) ? fee4Credit.hashCode() : 0);
    result = (31 * result) + ((GLExportDate != null) ? GLExportDate.hashCode() : 0);
    result = (31 * result) + ((group != null) ? group.hashCode() : 0);
    result = (31 * result) + ((hasGlTrans != null) ? hasGlTrans.hashCode() : 0);
    result = (31 * result) + ((hasManualAction != null) ? hasManualAction.hashCode() : 0);
    result = (31 * result) + ((interest != null) ? interest.hashCode() : 0);
    result = (31 * result) + ((interestCredit != null) ? interestCredit.hashCode() : 0);
    result = (31 * result) + ((isAccruedInterest != null) ? isAccruedInterest.hashCode() : 0);
    result = (31 * result) + ((isGlTrans != null) ? isGlTrans.hashCode() : 0);
    result = (31 * result) + ((isJudgement != null) ? isJudgement.hashCode() : 0);
    result = (31 * result) + ((lastInterestDate != null) ? lastInterestDate.hashCode() : 0);
    result = (31 * result) + ((lastPayAmount != null) ? lastPayAmount.hashCode() : 0);
    result = (31 * result) + ((lastPayDate != null) ? lastPayDate.hashCode() : 0);
    result = (31 * result) + ((lastUpdateUserId != null) ? lastUpdateUserId.hashCode() : 0);
    result = (31 * result) + ((manualActionDate != null) ? manualActionDate.hashCode() : 0);
    result = (31 * result) + ((manualActionPreTransId != null) ? manualActionPreTransId.hashCode() : 0);
    result = (31 * result) + ((manualActionType != null) ? manualActionType.hashCode() : 0);
    result = (31 * result) + ((originalGroup != null) ? originalGroup.hashCode() : 0);
    result = (31 * result) + ((parentBatchId != null) ? parentBatchId.hashCode() : 0);
    result = (31 * result) + ((payment != null) ? payment.hashCode() : 0);
    result = (31 * result) + ((postedDate != null) ? postedDate.hashCode() : 0);
    result = (31 * result) + ((preBalance != null) ? preBalance.hashCode() : 0);
    result = (31 * result) + ((preFee1 != null) ? preFee1.hashCode() : 0);
    result = (31 * result) + ((preFee2 != null) ? preFee2.hashCode() : 0);
    result = (31 * result) + ((preFee3 != null) ? preFee3.hashCode() : 0);
    result = (31 * result) + ((preFee4 != null) ? preFee4.hashCode() : 0);
    result = (31 * result) + ((preInterest != null) ? preInterest.hashCode() : 0);
    result = (31 * result) + ((preInterestDate != null) ? preInterestDate.hashCode() : 0);
    result = (31 * result) + ((preLastPayAmount != null) ? preLastPayAmount.hashCode() : 0);
    result = (31 * result) + ((preLastPayDate != null) ? preLastPayDate.hashCode() : 0);
    result = (31 * result) + ((prePrincipal != null) ? prePrincipal.hashCode() : 0);
    result = (31 * result) + ((preTransId != null) ? preTransId.hashCode() : 0);
    result = (31 * result) + ((preTransStatus != null) ? preTransStatus.hashCode() : 0);
    result = (31 * result) + ((principal != null) ? principal.hashCode() : 0);
    result = (31 * result) + ((principalCredit != null) ? principalCredit.hashCode() : 0);
    result = (31 * result) + ((responsibleId != null) ? responsibleId.hashCode() : 0);
    result = (31 * result) + ((reversedGlTrans != null) ? reversedGlTrans.hashCode() : 0);
    result = (31 * result) + ((source != null) ? source.hashCode() : 0);
    result = (31 * result) + ((transactionCode != null) ? transactionCode.hashCode() : 0);
    result = (31 * result) + ((transactionId != null) ? transactionId.hashCode() : 0);
    result = (31 * result) + ((transAmount != null) ? transAmount.hashCode() : 0);
    result = (31 * result) + ((transSourceType != null) ? transSourceType.hashCode() : 0);
    result = (31 * result) + ((transStatus != null) ? transStatus.hashCode() : 0);
    result = (31 * result) + ((userId != null) ? userId.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * initCreditValues.
   */
  public void initCreditValues() {
    setPrincipalCredit(BigDecimal.ZERO);
    setFee1Credit(BigDecimal.ZERO);
    setFee2Credit(BigDecimal.ZERO);
    setFee3Credit(BigDecimal.ZERO);
    setFee4Credit(BigDecimal.ZERO);
    setInterestCredit(BigDecimal.ZERO);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * initPreValues.
   */
  public void initPreValues() {
    setPreBalance(BigDecimal.ZERO);
    setPrePrincipal(BigDecimal.ZERO);
    setPreFee1(BigDecimal.ZERO);
    setPreFee2(BigDecimal.ZERO);
    setPreFee3(BigDecimal.ZERO);
    setPreFee4(BigDecimal.ZERO);
    setPreInterest(BigDecimal.ZERO);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for maunal action trans.
   *
   * @return  boolean
   */
  public boolean isManualActionTrans() {
    return StringUtils.hasText(this.manualActionType)
      && (TransManualActionTypeEnum.REVERSAL.toString().equalsIgnoreCase(this.manualActionType)
        || TransManualActionTypeEnum.REINSTATEMENT.toString().equals(this.manualActionType));

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for OCATrans.
   *
   * @return  boolean
   */
  public boolean isOCATrans() {
    return StringUtils.hasText(this.transSourceType)
      && this.transSourceType.equalsIgnoreCase(TransSourceTypeEnum.OCAJOBIMPORT.toString());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for primary trans.
   *
   * @return  boolean
   */
  public boolean isPrimaryTrans() {
    return (null != group) && group.equals(transactionId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for save primary trans.
   *
   * @return  boolean
   */
  public boolean isSavePrimaryTrans() {
    return savePrimaryTrans;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update account info.
   *
   * @return  boolean
   */
  public boolean isUpdateAccountInfo() {
    return updateAccountInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * paymentNeedHandleManualAction.
   *
   * @return  boolean
   */
  public boolean paymentNeedHandleManualAction() {
    return !((getTransAmount().compareTo(BigDecimal.ZERO) > 0) && (getActualAmount().compareTo(BigDecimal.ZERO) == 0));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account num.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accrued interest.
   *
   * @param  accruedInterest  Boolean
   */
  public void setAccruedInterest(Boolean accruedInterest) {
    isAccruedInterest = accruedInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for actual amount.
   *
   * @param  actualAmount  BigDecimal
   */
  public void setActualAmount(BigDecimal actualAmount) {
    this.actualAmount = actualAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency id.
   *
   * @param  agencyId  Long
   */
  public void setAgencyId(Long agencyId) {
    this.agencyId = agencyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assess fee trans code.
   *
   * @param  assessFeeTransCode  String
   */
  public void setAssessFeeTransCode(String assessFeeTransCode) {
    this.assessFeeTransCode = assessFeeTransCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance.
   *
   * @param  balance  BigDecimal
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance changed.
   *
   * @param  balanceChanged  Boolean
   */
  public void setBalanceChanged(Boolean balanceChanged) {
    this.balanceChanged = balanceChanged;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch id.
   *
   * @param  batchId  String
   */
  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client id.
   *
   * @param  clientId  Long
   */
  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for creator type.
   *
   * @param  creatorType  String
   */
  public void setCreatorType(String creatorType) {
    this.creatorType = creatorType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deleted date.
   *
   * @param  deletedDate  Date
   */
  public void setDeletedDate(Date deletedDate) {
    this.deletedDate = deletedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction date.
   *
   * @param  effectiveDate  Date
   */
  public void setEffectiveDate(Date effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external reference number.
   *
   * @param  externalReferenceNumber  String
   */
  public void setExternalReferenceNumber(String externalReferenceNumber) {
    this.externalReferenceNumber = externalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee1.
   *
   * @param  fee1  BigDecimal
   */
  public void setFee1(BigDecimal fee1) {
    this.fee1 = fee1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee1 credit.
   *
   * @param  fee1Credit  BigDecimal
   */
  public void setFee1Credit(BigDecimal fee1Credit) {
    this.fee1Credit = fee1Credit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee2.
   *
   * @param  fee2  BigDecimal
   */
  public void setFee2(BigDecimal fee2) {
    this.fee2 = fee2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee2 credit.
   *
   * @param  fee2Credit  BigDecimal
   */
  public void setFee2Credit(BigDecimal fee2Credit) {
    this.fee2Credit = fee2Credit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee3.
   *
   * @param  fee3  BigDecimal
   */
  public void setFee3(BigDecimal fee3) {
    this.fee3 = fee3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee3 credit.
   *
   * @param  fee3Credit  BigDecimal
   */
  public void setFee3Credit(BigDecimal fee3Credit) {
    this.fee3Credit = fee3Credit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee4.
   *
   * @param  fee4  BigDecimal
   */
  public void setFee4(BigDecimal fee4) {
    this.fee4 = fee4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee4 credit.
   *
   * @param  fee4Credit  BigDecimal
   */
  public void setFee4Credit(BigDecimal fee4Credit) {
    this.fee4Credit = fee4Credit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for funding account.
   *
   * @param  fundingAccount  String
   */
  public void setFundingAccount(String fundingAccount) {
    this.fundingAccount = fundingAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for funding source.
   *
   * @param  fundingSource  String
   */
  public void setFundingSource(String fundingSource) {
    this.fundingSource = fundingSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for GLExport date.
   *
   * @param  GLExportDate  Date
   */
  public void setGLExportDate(Date GLExportDate) {
    this.GLExportDate = GLExportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for gl trans.
   *
   * @param  glTrans  Boolean
   */
  public void setGlTrans(Boolean glTrans) {
    isGlTrans = glTrans;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for group.
   *
   * @param  group  Long
   */
  public void setGroup(Long group) {
    this.group = group;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for has gl trans.
   *
   * @param  hasGlTrans  Boolean
   */
  public void setHasGlTrans(Boolean hasGlTrans) {
    this.hasGlTrans = hasGlTrans;
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
   * setter method for interest.
   *
   * @param  interest  BigDecimal
   */
  public void setInterest(BigDecimal interest) {
    this.interest = interest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for interest credit.
   *
   * @param  interestCredit  BigDecimal
   */
  public void setInterestCredit(BigDecimal interestCredit) {
    this.interestCredit = interestCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for judgement.
   *
   * @param  judgement  Boolean
   */
  public void setJudgement(Boolean judgement) {
    isJudgement = judgement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last interest date.
   *
   * @param  lastInterestDate  Date
   */
  public void setLastInterestDate(Date lastInterestDate) {
    this.lastInterestDate = lastInterestDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last pay amount.
   *
   * @param  lastPayAmount  BigDecimal
   */
  public void setLastPayAmount(BigDecimal lastPayAmount) {
    this.lastPayAmount = lastPayAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last pay date.
   *
   * @param  lastPayDate  Date
   */
  public void setLastPayDate(Date lastPayDate) {
    this.lastPayDate = lastPayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last update user id.
   *
   * @param  lastUpdateUserId  Long
   */
  public void setLastUpdateUserId(Long lastUpdateUserId) {
    this.lastUpdateUserId = lastUpdateUserId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for manual action date.
   *
   * @param  manualActionDate  String
   */
  public void setManualActionDate(Date manualActionDate) {
    this.manualActionDate = manualActionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for manual action pre trans id.
   *
   * @param  manualActionPreTransId  Long
   */
  public void setManualActionPreTransId(Long manualActionPreTransId) {
    this.manualActionPreTransId = manualActionPreTransId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for manual action type.
   *
   * @param  manualActionType  String
   */
  public void setManualActionType(String manualActionType) {
    this.manualActionType = manualActionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original group.
   *
   * @param  originalGroup  Long
   */
  public void setOriginalGroup(Long originalGroup) {
    this.originalGroup = originalGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for parent batch id.
   *
   * @param  parentBatchId  String
   */
  public void setParentBatchId(String parentBatchId) {
    this.parentBatchId = parentBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for parent trans id.
   *
   * @param  payment  parentTransId Long
   */

  /**
   * setter method for payment.
   *
   * @param  payment  Payment
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for posting date.
   *
   * @param  postedDate  Date
   */
  public void setPostedDate(Date postedDate) {
    this.postedDate = postedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre balance.
   *
   * @param  preBalance  BigDecimal
   */
  public void setPreBalance(BigDecimal preBalance) {
    this.preBalance = preBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre fee1.
   *
   * @param  preFee1  BigDecimal
   */
  public void setPreFee1(BigDecimal preFee1) {
    this.preFee1 = preFee1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre fee2.
   *
   * @param  preFee2  BigDecimal
   */
  public void setPreFee2(BigDecimal preFee2) {
    this.preFee2 = preFee2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre fee3.
   *
   * @param  preFee3  BigDecimal
   */
  public void setPreFee3(BigDecimal preFee3) {
    this.preFee3 = preFee3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre fee4.
   *
   * @param  preFee4  BigDecimal
   */
  public void setPreFee4(BigDecimal preFee4) {
    this.preFee4 = preFee4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre interest.
   *
   * @param  preInterest  BigDecimal
   */
  public void setPreInterest(BigDecimal preInterest) {
    this.preInterest = preInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre interest date.
   *
   * @param  preInterestDate  Date
   */
  public void setPreInterestDate(Date preInterestDate) {
    this.preInterestDate = preInterestDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre last pay amount.
   *
   * @param  preLastPayAmount  BigDecimal
   */
  public void setPreLastPayAmount(BigDecimal preLastPayAmount) {
    this.preLastPayAmount = preLastPayAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre last pay date.
   *
   * @param  preLastPayDate  Date
   */
  public void setPreLastPayDate(Date preLastPayDate) {
    this.preLastPayDate = preLastPayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre principal.
   *
   * @param  prePrincipal  BigDecimal
   */
  public void setPrePrincipal(BigDecimal prePrincipal) {
    this.prePrincipal = prePrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre trans id.
   *
   * @param  preTransId  Long
   */
  public void setPreTransId(Long preTransId) {
    this.preTransId = preTransId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre trans status.
   *
   * @param  preTransStatus  String
   */
  public void setPreTransStatus(String preTransStatus) {
    this.preTransStatus = preTransStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre values.
   *
   * @param  preTrans  Transaction
   */
  public void setPreValuesByValues(Transaction preTrans) {
    setPreBalance(preTrans.getBalance());
    setPrePrincipal(preTrans.getPrincipal());
    setPreFee1(preTrans.getFee1());
    setPreFee2(preTrans.getFee2());
    setPreInterest(preTrans.getInterest());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for principal.
   *
   * @param  principal  BigDecimal
   */
  public void setPrincipal(BigDecimal principal) {
    this.principal = principal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for principal credit.
   *
   * @param  principalCredit  BigDecimal
   */
  public void setPrincipalCredit(BigDecimal principalCredit) {
    this.principalCredit = principalCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible id.
   *
   * @param  responsibleId  Responsible
   */
  public void setResponsibleId(Responsible responsibleId) {
    this.responsibleId = responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reversed gl trans.
   *
   * @param  reversedGlTrans  Boolean
   */
  public void setReversedGlTrans(Boolean reversedGlTrans) {
    this.reversedGlTrans = reversedGlTrans;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reversed manual action trans map.
   *
   * @param  reversedManualActionTransMap  Map
   */
  public void setReversedManualActionTransMap(Map<Long, BaseTransInfo> reversedManualActionTransMap) {
    this.reversedManualActionTransMap = reversedManualActionTransMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for save primary trans.
   *
   * @param  savePrimaryTrans  boolean
   */
  public void setSavePrimaryTrans(boolean savePrimaryTrans) {
    this.savePrimaryTrans = savePrimaryTrans;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source.
   *
   * @param  source  String
   */
  public void setSource(String source) {
    this.source = source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction code.
   *
   * @param  transactionCode  com.cmc.credagility.core.domain.sor.TransactionCode
   */
  public void setTransactionCode(TransactionCode transactionCode) {
    this.transactionCode = transactionCode;
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
   * setter method for trans source type.
   *
   * @param  transSourceType  String
   */
  public void setTransSourceType(String transSourceType) {
    this.transSourceType = transSourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans status.
   *
   * @param  transStatus  String
   */
  public void setTransStatus(String transStatus) {
    this.transStatus = transStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update account info.
   *
   * @param  updateAccountInfo  boolean
   */
  public void setUpdateAccountInfo(boolean updateAccountInfo) {
    this.updateAccountInfo = updateAccountInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user id.
   *
   * @param  userId  Long
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for values by pre values.
   */
  public void setValuesByPreValues() {
    setBalance(getPreBalance());
    setPrincipal(getPrePrincipal());
    setFee1(getPreFee1());
    setFee2(getPreFee2());
    setInterest(getPreInterest());
    setLastPayDate(getPreLastPayDate());
    setLastPayAmount(getPreLastPayAmount());
    setLastInterestDate(getPreInterestDate());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "Transaction{"
      + "batchId='" + batchId + '\''
      + ", parentBatchId='" + parentBatchId + '\''
      + ", transactionCode=" + transactionCode
      + ", actualAmount=" + actualAmount
      + ", transStatus='" + transStatus + '\''
      + ", effectiveDate=" + effectiveDate
      + ", balance=" + balance
      + ", transAmount=" + transAmount
      + ", transactionId=" + transactionId
      + ", userId=" + userId
      + '}';
  }
} // end class Transaction
