package com.cmc.credagility.core.domain.transaction;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.common.InterestRateCategory;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.webactivity.Session;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store Current Transaction Data.
 *
 * <p><a href="Portfolio.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 15:46
 */
@Entity
@Table(
  name    = "TransactionData",
  indexes = {
    @Index(
      name = "transDataTransViewKeyIndex",
      columnList = "transViewKey"
    )
  }
)
public class TransactionData extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -8295399662776380629L;

  /** TODO: DOCUMENT ME! */
  public static final String TransCategory_Interest = "interest";

  /** TODO: DOCUMENT ME! */
  public static final String TransCategory_Normal = "normal";

  /** TODO: DOCUMENT ME! */
  public static final String TransCategory_Fee = "fee";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne protected Account account;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "agentId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "amount",
    nullable = false
  )
  protected BigDecimal amount = new BigDecimal(0.0);

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "cardType",
    length = 50
  )
  protected String cardType;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate1;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "sessionId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Session dataSession;

  /** DOCUMENT ME! */
  @Column(name = "dateEffect")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date dateEffect;

  /** TODO: DOCUMENT ME! */
  @Column(name = "datePost")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date datePost;

  /** TODO: DOCUMENT ME! */
  @Column(name = "dateTrans")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date dateTrans;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "interestEligible",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean interestEligible = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(name = "interestStartDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date interestStartDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastPaidDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastPaidDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "merchantAccountNum",
    length = 32
  )
  protected String merchantAccountNum;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "paidAmount",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal paidAmount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "paymentType",
    length = 255
  )
  protected String     paymentType;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "rateCategoryId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne protected InterestRateCategory rateCategory;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "refNbr",
    length = 100
  )
  protected String refNbr;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "transactionCategoryId",
    updatable  = true,
    insertable = true
  )
  @ManyToOne protected TransactionCategory transactionCategory;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "transactionId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long transactionId;

  /** Transaction Category. */
  @Column(
    name   = "transCategory",
    length = 100
  )
  protected String transCategory;

  /** Transaction Code/Type Id. */
  @Column(
    name   = "transCode",
    length = 100
  )
  protected String transCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "transDesc",
    length = 255
  )
  protected String transDesc;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "transGroupId",
    length = 50
  )
  protected String transGroupId;

  /** Transaction key. */
  @Column(
    name     = "transViewKey",
    nullable = false,
    length   = 255
  )
  protected String   transViewKey;
  @Column(name = "accruedInterestAmount")
  private BigDecimal accruedInterestAmount;
  @Column(
    name   = "clientDefined1CharCode1",
    length = 1
  )
  private String     clientDefined1CharCode1;

  @Column(
    name   = "clientDefined1CharCode2",
    length = 1
  )
  private String clientDefined1CharCode2;

  @Column(
    name   = "clientDefined2CharCode1",
    length = 2
  )
  private String clientDefined2CharCode1;

  @Column(
    name   = "clientDefined3CharCode1",
    length = 3
  )
  private String clientDefined3CharCode1;

  @Column(name = "clientDefinedDecimal1")
  private BigDecimal clientDefinedDecimal1;

  @Column(name = "clientDefinedDecimal2")
  private BigDecimal clientDefinedDecimal2;

  @Column(name = "clientDefinedDecimal3")
  private BigDecimal clientDefinedDecimal3;

  @Column(name = "clientDefinedDecimal4")
  private BigDecimal clientDefinedDecimal4;

  @Column(name = "clientDefinedDecimal5")
  private BigDecimal clientDefinedDecimal5;

  @Column(name = "clientDefinedDecimal6")
  private BigDecimal clientDefinedDecimal6;

  @Column(name = "interestAmount")
  private BigDecimal interestAmount;

  @Column(name = "principalAmount")
  private BigDecimal principalAmount;
  @Column(name = "transFee")
  private BigDecimal transFee;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TransactionData object.
   */
  public TransactionData() { }

  /**
   * Creates a new TransactionData object.
   *
   * @param  account        Account
   * @param  amount         BigDecimal
   * @param  dateTrans      Date
   * @param  transCategory  String
   */
  public TransactionData(Account account, BigDecimal amount, Date dateTrans, String transCategory) {
    this.account       = account;
    this.amount        = amount;
    this.dateTrans     = dateTrans;
    this.transCategory = transCategory;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * applyAmount.
   *
   * @param  payment  Payment
   */
  public void applyAmount(Payment payment) {
    payment.setApplied(Boolean.TRUE);
    setLastPaidDate(new Date());

    if (payment.getAmount().compareTo(getAmount()) >= 0) {
      setPaidAmount(getAmount());
      payment.setAppliedAmount(getAmount());
    } else {
      setPaidAmount(payment.getAmount());
      payment.setAppliedAmount(payment.getAmount());
    }
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

    TransactionData that = (TransactionData) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((accruedInterestAmount != null) ? (!accruedInterestAmount.equals(that.accruedInterestAmount))
                                        : (that.accruedInterestAmount != null)) {
      return false;
    }

    if ((agent != null) ? (!agent.equals(that.agent)) : (that.agent != null)) {
      return false;
    }

    if ((amount != null) ? (!amount.equals(that.amount)) : (that.amount != null)) {
      return false;
    }

    if ((cardType != null) ? (!cardType.equals(that.cardType)) : (that.cardType != null)) {
      return false;
    }

    if ((clientDefined1CharCode1 != null) ? (!clientDefined1CharCode1.equals(that.clientDefined1CharCode1))
                                          : (that.clientDefined1CharCode1 != null)) {
      return false;
    }

    if ((clientDefined1CharCode2 != null) ? (!clientDefined1CharCode2.equals(that.clientDefined1CharCode2))
                                          : (that.clientDefined1CharCode2 != null)) {
      return false;
    }

    if ((clientDefined2CharCode1 != null) ? (!clientDefined2CharCode1.equals(that.clientDefined2CharCode1))
                                          : (that.clientDefined2CharCode1 != null)) {
      return false;
    }

    if ((clientDefined3CharCode1 != null) ? (!clientDefined3CharCode1.equals(that.clientDefined3CharCode1))
                                          : (that.clientDefined3CharCode1 != null)) {
      return false;
    }

    if ((clientDefinedDate1 != null) ? (!clientDefinedDate1.equals(that.clientDefinedDate1))
                                     : (that.clientDefinedDate1 != null)) {
      return false;
    }

    if ((clientDefinedDecimal1 != null) ? (!clientDefinedDecimal1.equals(that.clientDefinedDecimal1))
                                        : (that.clientDefinedDecimal1 != null)) {
      return false;
    }

    if ((clientDefinedDecimal2 != null) ? (!clientDefinedDecimal2.equals(that.clientDefinedDecimal2))
                                        : (that.clientDefinedDecimal2 != null)) {
      return false;
    }

    if ((clientDefinedDecimal3 != null) ? (!clientDefinedDecimal3.equals(that.clientDefinedDecimal3))
                                        : (that.clientDefinedDecimal3 != null)) {
      return false;
    }

    if ((clientDefinedDecimal4 != null) ? (!clientDefinedDecimal4.equals(that.clientDefinedDecimal4))
                                        : (that.clientDefinedDecimal4 != null)) {
      return false;
    }

    if ((clientDefinedDecimal5 != null) ? (!clientDefinedDecimal5.equals(that.clientDefinedDecimal5))
                                        : (that.clientDefinedDecimal5 != null)) {
      return false;
    }

    if ((clientDefinedDecimal6 != null) ? (!clientDefinedDecimal6.equals(that.clientDefinedDecimal6))
                                        : (that.clientDefinedDecimal6 != null)) {
      return false;
    }

    if ((dataSession != null) ? (!dataSession.equals(that.dataSession)) : (that.dataSession != null)) {
      return false;
    }

    if ((dateEffect != null) ? (!dateEffect.equals(that.dateEffect)) : (that.dateEffect != null)) {
      return false;
    }

    if ((datePost != null) ? (!datePost.equals(that.datePost)) : (that.datePost != null)) {
      return false;
    }

    if ((dateTrans != null) ? (!dateTrans.equals(that.dateTrans)) : (that.dateTrans != null)) {
      return false;
    }

    if ((interestAmount != null) ? (!interestAmount.equals(that.interestAmount)) : (that.interestAmount != null)) {
      return false;
    }

    if ((interestEligible != null) ? (!interestEligible.equals(that.interestEligible))
                                   : (that.interestEligible != null)) {
      return false;
    }

    if ((interestStartDate != null) ? (!interestStartDate.equals(that.interestStartDate))
                                    : (that.interestStartDate != null)) {
      return false;
    }

    if ((lastPaidDate != null) ? (!lastPaidDate.equals(that.lastPaidDate)) : (that.lastPaidDate != null)) {
      return false;
    }

    if ((merchantAccountNum != null) ? (!merchantAccountNum.equals(that.merchantAccountNum))
                                     : (that.merchantAccountNum != null)) {
      return false;
    }

    if ((paidAmount != null) ? (!paidAmount.equals(that.paidAmount)) : (that.paidAmount != null)) {
      return false;
    }

    if ((principalAmount != null) ? (!principalAmount.equals(that.principalAmount)) : (that.principalAmount != null)) {
      return false;
    }

    if ((rateCategory != null) ? (!rateCategory.equals(that.rateCategory)) : (that.rateCategory != null)) {
      return false;
    }

    if ((refNbr != null) ? (!refNbr.equals(that.refNbr)) : (that.refNbr != null)) {
      return false;
    }

    if ((transCategory != null) ? (!transCategory.equals(that.transCategory)) : (that.transCategory != null)) {
      return false;
    }

    if ((transCode != null) ? (!transCode.equals(that.transCode)) : (that.transCode != null)) {
      return false;
    }

    if ((transDesc != null) ? (!transDesc.equals(that.transDesc)) : (that.transDesc != null)) {
      return false;
    }

    if ((transFee != null) ? (!transFee.equals(that.transFee)) : (that.transFee != null)) {
      return false;
    }

    if ((transGroupId != null) ? (!transGroupId.equals(that.transGroupId)) : (that.transGroupId != null)) {
      return false;
    }

    if ((transViewKey != null) ? (!transViewKey.equals(that.transViewKey)) : (that.transViewKey != null)) {
      return false;
    }

    if ((transactionCategory != null) ? (!transactionCategory.equals(that.transactionCategory))
                                      : (that.transactionCategory != null)) {
      return false;
    }

    if ((transactionId != null) ? (!transactionId.equals(that.transactionId)) : (that.transactionId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accrued interest amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAccruedInterestAmount() {
    return accruedInterestAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAmount() {
    return amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for card type.
   *
   * @return  String
   */
  public String getCardType() {
    return cardType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code1.
   *
   * @return  String
   */
  public String getClientDefined1CharCode1() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code2.
   *
   * @return  String
   */
  public String getClientDefined1CharCode2() {
    return clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code1.
   *
   * @return  String
   */
  public String getClientDefined2CharCode1() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code1.
   *
   * @return  String
   */
  public String getClientDefined3CharCode1() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date1.
   *
   * @return  Date
   */
  public Date getClientDefinedDate1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal1() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal2() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal3() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal4.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal4() {
    return clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal5.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal5() {
    return clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal6.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal6() {
    return clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data session.
   *
   * @return  Session
   */
  public Session getDataSession() {
    return dataSession;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date effect.
   *
   * @return  Date
   */
  public Date getDateEffect() {
    return dateEffect;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date post.
   *
   * @return  Date
   */
  public Date getDatePost() {
    return datePost;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date trans.
   *
   * @return  Date
   */
  public Date getDateTrans() {
    return dateTrans;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for interest amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInterestAmount() {
    return interestAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for interest eligible.
   *
   * @return  Boolean
   */
  public Boolean getInterestEligible() {
    return interestEligible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for interest start date.
   *
   * @return  Date
   */
  public Date getInterestStartDate() {
    return interestStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last paid date.
   *
   * @return  Date
   */
  public Date getLastPaidDate() {
    return lastPaidDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for merchant account num.
   *
   * @return  String
   */
  public String getMerchantAccountNum() {
    return merchantAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for paid amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPaidAmount() {
    return paidAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment type.
   *
   * @return  String
   */
  public String getPaymentType() {
    return paymentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for principal amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPrincipalAmount() {
    return principalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rate category.
   *
   * @return  InterestRateCategory
   */
  public InterestRateCategory getRateCategory() {
    return rateCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ref nbr.
   *
   * @return  String
   */
  public String getRefNbr() {
    return refNbr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction category.
   *
   * @return  TransactionCategory
   */
  public TransactionCategory getTransactionCategory() {
    return transactionCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction date.
   *
   * @return  Date
   */
  @Transient public Date getTransactionDate() {
    return this.getDateTrans();
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
   * getter method for trans category.
   *
   * @return  String
   */
  public String getTransCategory() {
    return transCategory;
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
   * getter method for trans desc.
   *
   * @return  String
   */
  public String getTransDesc() {
    return transDesc;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTransFee() {
    return transFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans group id.
   *
   * @return  String
   */
  public String getTransGroupId() {
    return transGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans view key.
   *
   * @return  String
   */
  public String getTransViewKey() {
    return transViewKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((agent != null) ? agent.hashCode() : 0);
    result = (31 * result) + ((amount != null) ? amount.hashCode() : 0);
    result = (31 * result) + ((cardType != null) ? cardType.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate1 != null) ? clientDefinedDate1.hashCode() : 0);
    result = (31 * result) + ((dataSession != null) ? dataSession.hashCode() : 0);
    result = (31 * result) + ((dateEffect != null) ? dateEffect.hashCode() : 0);
    result = (31 * result) + ((datePost != null) ? datePost.hashCode() : 0);
    result = (31 * result) + ((dateTrans != null) ? dateTrans.hashCode() : 0);
    result = (31 * result) + ((interestEligible != null) ? interestEligible.hashCode() : 0);
    result = (31 * result) + ((interestStartDate != null) ? interestStartDate.hashCode() : 0);
    result = (31 * result) + ((lastPaidDate != null) ? lastPaidDate.hashCode() : 0);
    result = (31 * result) + ((merchantAccountNum != null) ? merchantAccountNum.hashCode() : 0);
    result = (31 * result) + ((paidAmount != null) ? paidAmount.hashCode() : 0);
    result = (31 * result) + ((rateCategory != null) ? rateCategory.hashCode() : 0);
    result = (31 * result) + ((refNbr != null) ? refNbr.hashCode() : 0);
    result = (31 * result) + ((transactionCategory != null) ? transactionCategory.hashCode() : 0);
    result = (31 * result) + ((transactionId != null) ? transactionId.hashCode() : 0);
    result = (31 * result) + ((transCategory != null) ? transCategory.hashCode() : 0);
    result = (31 * result) + ((transCode != null) ? transCode.hashCode() : 0);
    result = (31 * result) + ((transDesc != null) ? transDesc.hashCode() : 0);
    result = (31 * result) + ((transGroupId != null) ? transGroupId.hashCode() : 0);
    result = (31 * result) + ((transViewKey != null) ? transViewKey.hashCode() : 0);
    result = (31 * result) + ((accruedInterestAmount != null) ? accruedInterestAmount.hashCode() : 0);
    result = (31 * result) + ((clientDefined1CharCode1 != null) ? clientDefined1CharCode1.hashCode() : 0);
    result = (31 * result) + ((clientDefined1CharCode2 != null) ? clientDefined1CharCode2.hashCode() : 0);
    result = (31 * result) + ((clientDefined2CharCode1 != null) ? clientDefined2CharCode1.hashCode() : 0);
    result = (31 * result) + ((clientDefined3CharCode1 != null) ? clientDefined3CharCode1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal1 != null) ? clientDefinedDecimal1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal2 != null) ? clientDefinedDecimal2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal3 != null) ? clientDefinedDecimal3.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal4 != null) ? clientDefinedDecimal4.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal5 != null) ? clientDefinedDecimal5.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal6 != null) ? clientDefinedDecimal6.hashCode() : 0);
    result = (31 * result) + ((interestAmount != null) ? interestAmount.hashCode() : 0);
    result = (31 * result) + ((principalAmount != null) ? principalAmount.hashCode() : 0);
    result = (31 * result) + ((transFee != null) ? transFee.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accrued interest amount.
   *
   * @param  accruedInterestAmount  BigDecimal
   */
  public void setAccruedInterestAmount(BigDecimal accruedInterestAmount) {
    this.accruedInterestAmount = accruedInterestAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount.
   *
   * @param  amount  BigDecimal
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for card type.
   *
   * @param  cardType  String
   */
  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code1.
   *
   * @param  clientDefined1CharCode1  String
   */
  public void setClientDefined1CharCode1(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code2.
   *
   * @param  clientDefined1CharCode2  String
   */
  public void setClientDefined1CharCode2(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined2 char code1.
   *
   * @param  clientDefined2CharCode1  String
   */
  public void setClientDefined2CharCode1(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code1.
   *
   * @param  clientDefined3CharCode1  String
   */
  public void setClientDefined3CharCode1(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date1.
   *
   * @param  clientDefinedDate1  Date
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal1.
   *
   * @param  clientDefinedDecimal1  BigDecimal
   */
  public void setClientDefinedDecimal1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal2.
   *
   * @param  clientDefinedDecimal2  BigDecimal
   */
  public void setClientDefinedDecimal2(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal3.
   *
   * @param  clientDefinedDecimal3  BigDecimal
   */
  public void setClientDefinedDecimal3(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal4.
   *
   * @param  clientDefinedDecimal4  BigDecimal
   */
  public void setClientDefinedDecimal4(BigDecimal clientDefinedDecimal4) {
    this.clientDefinedDecimal4 = clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal5.
   *
   * @param  clientDefinedDecimal5  BigDecimal
   */
  public void setClientDefinedDecimal5(BigDecimal clientDefinedDecimal5) {
    this.clientDefinedDecimal5 = clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal6.
   *
   * @param  clientDefinedDecimal6  BigDecimal
   */
  public void setClientDefinedDecimal6(BigDecimal clientDefinedDecimal6) {
    this.clientDefinedDecimal6 = clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data session.
   *
   * @param  dataSession  Session
   */
  public void setDataSession(Session dataSession) {
    this.dataSession = dataSession;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date effect.
   *
   * @param  dateEffect  Date
   */
  public void setDateEffect(Date dateEffect) {
    this.dateEffect = dateEffect;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date post.
   *
   * @param  datePost  Date
   */
  public void setDatePost(Date datePost) {
    this.datePost = datePost;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date trans.
   *
   * @param  dateTrans  Date
   */
  public void setDateTrans(Date dateTrans) {
    this.dateTrans = dateTrans;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for interest amount.
   *
   * @param  interestAmount  BigDecimal
   */
  public void setInterestAmount(BigDecimal interestAmount) {
    this.interestAmount = interestAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for interest eligible.
   *
   * @param  interestEligible  Boolean
   */
  public void setInterestEligible(Boolean interestEligible) {
    this.interestEligible = interestEligible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for interest start date.
   *
   * @param  interestStartDate  Date
   */
  public void setInterestStartDate(Date interestStartDate) {
    this.interestStartDate = interestStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last paid date.
   *
   * @param  lastPaidDate  Date
   */
  public void setLastPaidDate(Date lastPaidDate) {
    this.lastPaidDate = lastPaidDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for merchant account num.
   *
   * @param  merchantAccountNum  String
   */
  public void setMerchantAccountNum(String merchantAccountNum) {
    this.merchantAccountNum = merchantAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for paid amount.
   *
   * @param  paidAmount  BigDecimal
   */
  public void setPaidAmount(BigDecimal paidAmount) {
    this.paidAmount = paidAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment type.
   *
   * @param  paymentType  String
   */
  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for principal amount.
   *
   * @param  principalAmount  BigDecimal
   */
  public void setPrincipalAmount(BigDecimal principalAmount) {
    this.principalAmount = principalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rate category.
   *
   * @param  rateCategory  InterestRateCategory
   */
  public void setRateCategory(InterestRateCategory rateCategory) {
    this.rateCategory = rateCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ref nbr.
   *
   * @param  refNbr  String
   */
  public void setRefNbr(String refNbr) {
    this.refNbr = refNbr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction category.
   *
   * @param  transactionCategory  TransactionCategory
   */
  public void setTransactionCategory(TransactionCategory transactionCategory) {
    this.transactionCategory = transactionCategory;
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
   * setter method for trans category.
   *
   * @param  transCategory  String
   */
  public void setTransCategory(String transCategory) {
    this.transCategory = transCategory;
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
   * setter method for trans desc.
   *
   * @param  transDesc  String
   */
  public void setTransDesc(String transDesc) {
    this.transDesc = transDesc;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans fee.
   *
   * @param  transFee  BigDecimal
   */
  public void setTransFee(BigDecimal transFee) {
    this.transFee = transFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans group id.
   *
   * @param  transGroupId  String
   */
  public void setTransGroupId(String transGroupId) {
    this.transGroupId = transGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans view key.
   *
   * @param  transViewKey  String
   */
  public void setTransViewKey(String transViewKey) {
    this.transViewKey = transViewKey;
  }
} // end class TransactionData
