package com.cmc.credagility.core.domain.sor;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;

import com.cmc.credagility.core.domain.portfolio.Portfolio;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;


/**
 * Created by zhubq on 3/4/16.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  03/04/2016 14:03
 */
@Entity
@Table(name = "TransactionBatchHeader")
public class TransactionBatchHeader extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2834610136091043633L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "batchHeaderStatus",
    nullable = false,
    length   = 10
  )
  protected String batchHeaderStatus;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long batchId;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 10
  )
  protected String batchType;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "paymentMethodId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentMethod defaultPaymentMethod;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "transCode",
    nullable = false,
    length   = 4
  )
  protected String defaultTransCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "effectiveDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date defaultTransEffectiveDate;


  /** TODO: DOCUMENT ME! */
  @Column(length = 256)
  protected String description;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer numberOfTrans;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "portfolioId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Portfolio portfolio;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "postedDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date postedDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "submittedDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date submittedDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean system = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected BigDecimal totalAmount;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "batchHeader",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @Where(clause = "batchStatus<>'DELETED'")
  protected Set<IndividualTransaction> transSet = new HashSet<IndividualTransaction>();

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

    TransactionBatchHeader that = (TransactionBatchHeader) o;

    if ((batchHeaderStatus != null) ? (!batchHeaderStatus.equals(that.batchHeaderStatus))
                                    : (that.batchHeaderStatus != null)) {
      return false;
    }

    if ((batchId != null) ? (!batchId.equals(that.batchId)) : (that.batchId != null)) {
      return false;
    }

    if ((batchType != null) ? (!batchType.equals(that.batchType)) : (that.batchType != null)) {
      return false;
    }

    if ((defaultPaymentMethod != null) ? (!defaultPaymentMethod.equals(that.defaultPaymentMethod))
                                       : (that.defaultPaymentMethod != null)) {
      return false;
    }

    if ((defaultTransCode != null) ? (!defaultTransCode.equals(that.defaultTransCode))
                                   : (that.defaultTransCode != null)) {
      return false;
    }

    if ((defaultTransEffectiveDate != null) ? (!defaultTransEffectiveDate.equals(that.defaultTransEffectiveDate))
                                            : (that.defaultTransEffectiveDate != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((numberOfTrans != null) ? (!numberOfTrans.equals(that.numberOfTrans)) : (that.numberOfTrans != null)) {
      return false;
    }

    if ((postedDate != null) ? (!postedDate.equals(that.postedDate)) : (that.postedDate != null)) {
      return false;
    }

    if ((submittedDate != null) ? (!submittedDate.equals(that.submittedDate)) : (that.submittedDate != null)) {
      return false;
    }

    if ((system != null) ? (!system.equals(that.system)) : (that.system != null)) {
      return false;
    }

    return (totalAmount != null) ? totalAmount.equals(that.totalAmount) : (that.totalAmount == null);
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch header status.
   *
   * @return  String
   */
  public String getBatchHeaderStatus() {
    return batchHeaderStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch id.
   *
   * @return  Long
   */
  public Long getBatchId() {
    return batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch type.
   *
   * @return  String
   */
  public String getBatchType() {
    return batchType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default payment method.
   *
   * @return  String
   */
  public PaymentMethod getDefaultPaymentMethod() {
    return defaultPaymentMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default trans code.
   *
   * @return  String
   */
  public String getDefaultTransCode() {
    return defaultTransCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default trans effective date.
   *
   * @return  Date
   */
  public Date getDefaultTransEffectiveDate() {
    return defaultTransEffectiveDate;
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
   * getter method for number of trans.
   *
   * @return  Integer
   */
  public Integer getNumberOfTrans() {
    return numberOfTrans;
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
   * getter method for posted date.
   *
   * @return  Date
   */
  public Date getPostedDate() {
    return postedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for product type.
   *
   * @return  String
   */

  /**
   * getter method for submitted date.
   *
   * @return  Date
   */
  public Date getSubmittedDate() {
    return submittedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for system.
   *
   * @return  Boolean
   */
  public Boolean getSystem() {
    return Objects.isNull(system) ? Boolean.FALSE : system;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans code.
   *
   * @return  String
   */

  /**
   * getter method for trans batch set.
   *
   * @return  Set
   */
  public Set<IndividualTransaction> getTransSet() {
    return transSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((batchHeaderStatus != null) ? batchHeaderStatus.hashCode() : 0);
    result = (31 * result) + ((batchId != null) ? batchId.hashCode() : 0);
    result = (31 * result) + ((batchType != null) ? batchType.hashCode() : 0);
    result = (31 * result) + ((defaultPaymentMethod != null) ? defaultPaymentMethod.hashCode() : 0);
    result = (31 * result) + ((defaultTransCode != null) ? defaultTransCode.hashCode() : 0);
    result = (31 * result) + ((defaultTransEffectiveDate != null) ? defaultTransEffectiveDate.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((numberOfTrans != null) ? numberOfTrans.hashCode() : 0);
    result = (31 * result) + ((postedDate != null) ? postedDate.hashCode() : 0);
    result = (31 * result) + ((submittedDate != null) ? submittedDate.hashCode() : 0);
    result = (31 * result) + ((system != null) ? system.hashCode() : 0);
    result = (31 * result) + ((totalAmount != null) ? totalAmount.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch header status.
   *
   * @param  batchHeaderStatus  String
   */
  public void setBatchHeaderStatus(String batchHeaderStatus) {
    this.batchHeaderStatus = batchHeaderStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch id.
   *
   * @param  batchId  Long
   */
  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch type.
   *
   * @param  batchType  String
   */
  public void setBatchType(String batchType) {
    this.batchType = batchType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default payment method.
   *
   * @param  defaultPaymentMethod  String
   */
  public void setDefaultPaymentMethod(PaymentMethod defaultPaymentMethod) {
    this.defaultPaymentMethod = defaultPaymentMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default trans code.
   *
   * @param  defaultTransCode  String
   */
  public void setDefaultTransCode(String defaultTransCode) {
    this.defaultTransCode = defaultTransCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default trans effective date.
   *
   * @param  defaultTransEffectiveDate  Date
   */
  public void setDefaultTransEffectiveDate(Date defaultTransEffectiveDate) {
    this.defaultTransEffectiveDate = defaultTransEffectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for number of trans.
   *
   * @param  numberOfTrans  Integer
   */
  public void setNumberOfTrans(Integer numberOfTrans) {
    this.numberOfTrans = numberOfTrans;
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
   * setter method for payment method.
   *
   * @param  postedDate  paymentMethod String
   */

  /**
   * setter method for posted date.
   *
   * @param  postedDate  Date
   */
  public void setPostedDate(Date postedDate) {
    this.postedDate = postedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for product type.
   *
   * @param  submittedDate  productType String
   */

  /**
   * setter method for submitted date.
   *
   * @param  submittedDate  Date
   */
  public void setSubmittedDate(Date submittedDate) {
    this.submittedDate = submittedDate;
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
   * setter method for total amount.
   *
   * @param  totalAmount  BigDecimal
   */
  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans batch set.
   *
   * @param  transSet  Set
   */
  public void setTransSet(Set<IndividualTransaction> transSet) {
    this.transSet = transSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "TransactionBatchHeader{"
      + "batchHeaderStatus=" + batchHeaderStatus
      + ", batchType='" + batchType + '\''
      + ", defaultPaymentMethod=" + defaultPaymentMethod
      + ", defaultTransCode='" + defaultTransCode + '\''
      + ", defaultTransEffectiveDate=" + defaultTransEffectiveDate
      + ", description='" + description + '\''
      + ", batchId=" + batchId
      + ", numberOfTrans=" + numberOfTrans
      + ", postedDate=" + postedDate
      + ", submittedDate=" + submittedDate
      + ", totalAmount=" + totalAmount
      + '}';
  }
} // end class TransactionBatchHeader
