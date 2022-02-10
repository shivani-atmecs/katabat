package com.cmc.credagility.core.domain.sor;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.*;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.portfolio.Portfolio;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  11/20/2015 10:30
 */
@Entity
@Table(
  name              = "TransactionCode",
  indexes           = {
    @Index(
      name          = "transCodeIndex",
      unique        = true,
      columnList    = "transCode"
    )
  },
  uniqueConstraints = {
    @UniqueConstraint(columnNames = { "transCode", "portfolioId" }),
    @UniqueConstraint(columnNames = { "defaultScenarioId", "portfolioId" })
  }
)
public class TransactionCode extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4556674685208898681L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean affectBalance;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowAgentEntry;

  /** TODO: DOCUMENT ME! */
  @Column(
    precision = 19,
    scale     = 2,
    nullable  = true
  )
  protected BigDecimal defaultAmount;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "defaultScenarioId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TransactionCodeScenario defaultScenario;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String description;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enableAsOnlineBatchReversalFee = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enableAsOnlineBatchTransaction = Boolean.TRUE;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enableTransAction = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 4,
    nullable = true
  )
  protected String GLCode;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String GLDescription;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "grouping",
    length = 255
  )
  protected String group;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  protected Integer paymentAllocationSeq;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "portfolioId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean system;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 4,
    nullable = false
  )
  protected String transCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 255,
    nullable = false
  )
  protected String transName;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "transTypeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TransactionType transType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    TransactionCode that = (TransactionCode) o;

    if ((affectBalance != null) ? (!affectBalance.equals(that.affectBalance)) : (that.affectBalance != null)) {
      return false;
    }

    if ((allowAgentEntry != null) ? (!allowAgentEntry.equals(that.allowAgentEntry)) : (that.allowAgentEntry != null)) {
      return false;
    }

    if ((defaultAmount != null) ? (!defaultAmount.equals(that.defaultAmount)) : (that.defaultAmount != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((enableAsOnlineBatchReversalFee != null)
          ? (!enableAsOnlineBatchReversalFee.equals(that.enableAsOnlineBatchReversalFee))
          : (that.enableAsOnlineBatchReversalFee != null)) {
      return false;
    }

    if ((enableAsOnlineBatchTransaction != null)
          ? (!enableAsOnlineBatchTransaction.equals(that.enableAsOnlineBatchTransaction))
          : (that.enableAsOnlineBatchTransaction != null)) {
      return false;
    }

    if ((defaultScenario != null) ? (!defaultScenario.equals(that.defaultScenario)) : (that.defaultScenario != null)) {
      return false;
    }

    if ((enableTransAction != null) ? (!enableTransAction.equals(that.enableTransAction))
                                    : (that.enableTransAction != null)) {
      return false;
    }

    if ((GLCode != null) ? (!GLCode.equals(that.GLCode)) : (that.GLCode != null)) {
      return false;
    }

    if ((GLDescription != null) ? (!GLDescription.equals(that.GLDescription)) : (that.GLDescription != null)) {
      return false;
    }

    if ((group != null) ? (!group.equals(that.group)) : (that.group != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((paymentAllocationSeq != null) ? (!paymentAllocationSeq.equals(that.paymentAllocationSeq))
                                       : (that.paymentAllocationSeq != null)) {
      return false;
    }

    if ((system != null) ? (!system.equals(that.system)) : (that.system != null)) {
      return false;
    }

    if ((transCode != null) ? (!transCode.equals(that.transCode)) : (that.transCode != null)) {
      return false;
    }

    return (transName != null) ? transName.equals(that.transName) : (that.transName == null);

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for affect balance.
   *
   * @return  Boolean
   */
  public Boolean getAffectBalance() {
    return affectBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow agent entry.
   *
   * @return  Boolean
   */
  public Boolean getAllowAgentEntry() {
    return allowAgentEntry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDefaultAmount() {
    return defaultAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default scenario.
   *
   * @return  String
   */
  public TransactionCodeScenario getDefaultScenario() {
    return defaultScenario;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enable as online batch reversal fee.
   *
   * @return  Boolean
   */
  public Boolean getEnableAsOnlineBatchReversalFee() {
    return enableAsOnlineBatchReversalFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enable as online batch transaction.
   *
   * @return  Boolean
   */
  public Boolean getEnableAsOnlineBatchTransaction() {
    return enableAsOnlineBatchTransaction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enable trans action.
   *
   * @return  Boolean
   */
  public Boolean getEnableTransAction() {
    return enableTransAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for GLCode.
   *
   * @return  String
   */
  public String getGLCode() {
    return GLCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for GLDescription.
   *
   * @return  String
   */
  public String getGLDescription() {
    return GLDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for group.
   *
   * @return  String
   */
  public String getGroup() {
    return group;
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
   * getter method for payment allocation seq.
   *
   * @return  Integer
   */
  public Integer getPaymentAllocationSeq() {
    return paymentAllocationSeq;
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
   * getter method for system.
   *
   * @return  Boolean
   */
  public Boolean getSystem() {
    return system;
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
   * getter method for trans code scenario.
   *
   * @return  String
   */
  public String getTransCodeScenario() {
    return this.defaultScenario.getName();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans name.
   *
   * @return  String
   */
  public String getTransName() {
    return transName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans type.
   *
   * @return  TransactionType
   */
  public TransactionType getTransType() {
    return transType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((affectBalance != null) ? affectBalance.hashCode() : 0);
    result = (31 * result) + ((allowAgentEntry != null) ? allowAgentEntry.hashCode() : 0);
    result = (31 * result) + ((defaultAmount != null) ? defaultAmount.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((enableAsOnlineBatchReversalFee != null) ? enableAsOnlineBatchReversalFee.hashCode() : 0);
    result = (31 * result) + ((enableAsOnlineBatchTransaction != null) ? enableAsOnlineBatchTransaction.hashCode() : 0);
    result = (31 * result) + ((defaultScenario != null) ? defaultScenario.hashCode() : 0);
    result = (31 * result) + ((enableTransAction != null) ? enableTransAction.hashCode() : 0);
    result = (31 * result) + ((GLCode != null) ? GLCode.hashCode() : 0);
    result = (31 * result) + ((GLDescription != null) ? GLDescription.hashCode() : 0);
    result = (31 * result) + ((group != null) ? group.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((paymentAllocationSeq != null) ? paymentAllocationSeq.hashCode() : 0);
    result = (31 * result) + ((system != null) ? system.hashCode() : 0);
    result = (31 * result) + ((transCode != null) ? transCode.hashCode() : 0);
    result = (31 * result) + ((transName != null) ? transName.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasPositiveDefaultAmount.
   *
   * @return  boolean
   */
  public boolean hasPositiveDefaultAmount() {
    return (null != this.defaultAmount) && (this.defaultAmount.compareTo(BigDecimal.ZERO) > 0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee trans.
   *
   * @return  boolean
   */
  public boolean isFeeTrans() {
    return (null != transType) && "FEE".equalsIgnoreCase(transType.getTransType());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gl trans.
   *
   * @return  boolean
   */
  public boolean isGlCode() {
    return StringUtils.hasText(this.group) && "GL".equalsIgnoreCase(this.group);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment trans.
   *
   * @return  boolean
   */
  public boolean isPaymentTrans() {
    return (null != transType) && "PMT".equalsIgnoreCase(transType.getTransType());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for affect balance.
   *
   * @param  affectBalance  Boolean
   */
  public void setAffectBalance(Boolean affectBalance) {
    this.affectBalance = affectBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow agent entry.
   *
   * @param  allowAgentEntry  Boolean
   */
  public void setAllowAgentEntry(Boolean allowAgentEntry) {
    this.allowAgentEntry = allowAgentEntry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default amount.
   *
   * @param  defaultAmount  BigDecimal
   */
  public void setDefaultAmount(BigDecimal defaultAmount) {
    this.defaultAmount = defaultAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default scenario.
   *
   * @param  defaultScenario  String
   */
  public void setDefaultScenario(TransactionCodeScenario defaultScenario) {
    this.defaultScenario = defaultScenario;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * --------------------------------------------------------------------------------------------------------------- /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enable as online batch reversal fee.
   *
   * @param  enableAsOnlineBatchReversalFee  Boolean
   */
  public void setEnableAsOnlineBatchReversalFee(Boolean enableAsOnlineBatchReversalFee) {
    this.enableAsOnlineBatchReversalFee = enableAsOnlineBatchReversalFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enable as online batch transaction.
   *
   * @param  enableAsOnlineBatchTransaction  Boolean
   */
  public void setEnableAsOnlineBatchTransaction(Boolean enableAsOnlineBatchTransaction) {
    this.enableAsOnlineBatchTransaction = enableAsOnlineBatchTransaction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enable trans action.
   *
   * @param  enableTransAction  Boolean
   */
  public void setEnableTransAction(Boolean enableTransAction) {
    this.enableTransAction = enableTransAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * //~
   * ------------------------------------------------------------------------------------------------------------------
   * /** setter method for GLCode.
   *
   * @param  GLCode  String
   */
  public void setGLCode(String GLCode) {
    this.GLCode = GLCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for GLDescription.
   *
   * @param  GLDescription  String
   */
  public void setGLDescription(String GLDescription) {
    this.GLDescription = GLDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for group.
   *
   * @param  group  String
   */
  public void setGroup(String group) {
    this.group = group;
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
   * setter method for payment allocation seq.
   *
   * @param  paymentAllocationSeq  Integer
   */
  public void setPaymentAllocationSeq(Integer paymentAllocationSeq) {
    this.paymentAllocationSeq = paymentAllocationSeq;
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
   * setter method for system.
   *
   * @param  system  Boolean
   */
  public void setSystem(Boolean system) {
    this.system = system;
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
   * setter method for trans name.
   *
   * @param  transName  String
   */
  public void setTransName(String transName) {
    this.transName = transName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans type.
   *
   * @param  transType  TransactionType
   */
  public void setTransType(TransactionType transType) {
    this.transType = transType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "TransactionCode{"
      + "affectBalance=" + affectBalance
      + ", allowAgentEntry=" + allowAgentEntry
      + ", defaultAmount=" + defaultAmount
      + ", description='" + description + '\''
      + ", enableAsOnlineBatchReversalFee=" + enableAsOnlineBatchReversalFee
      + ", enableAsOnlineBatchTransaction="
      + enableAsOnlineBatchTransaction
// + ", defaultScenario='" + defaultScenario + '\''
      + ", enableTransAction=" + enableTransAction
      + ", GLCode='" + GLCode + '\''
      + ", GLDescription='" + GLDescription + '\''
      + ", group='" + group + '\''
      + ", id=" + id
      + ", paymentAllocationSeq=" + paymentAllocationSeq
      + ", system=" + system
      + ", transCode='" + transCode + '\''
      + ", transName='" + transName + '\''
      + '}';
  }
} // end class TransactionCode
