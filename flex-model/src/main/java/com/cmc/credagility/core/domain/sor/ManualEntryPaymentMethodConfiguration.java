package com.cmc.credagility.core.domain.sor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.portfolio.Portfolio;

import com.ozstrategy.credagility.core.domain.CreatorEntity;


/**
 * Created by coin on 3/23/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  03/23/2016 13:58
 */
@Entity
@Table(
  name              = "ManualEntryPaymentMethodConfiguration",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "paymentMethodId", "portfolioId" }) }
)
public class ManualEntryPaymentMethodConfiguration extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6091333309980723659L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "paymentMethodId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentMethod paymentMethod;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "portfolioId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** TODO: DOCUMENT ME! */
  @Column(name = "priority")
  protected Integer priority;

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

    ManualEntryPaymentMethodConfiguration that = (ManualEntryPaymentMethodConfiguration) o;

    if (!id.equals(that.id)) {
      return false;
    }

    if (!paymentMethod.equals(that.paymentMethod)) {
      return false;
    }

    if (!portfolio.equals(that.portfolio)) {
      return false;
    }

    return priority.equals(that.priority);

  } // end method equals

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
   * getter method for payment method.
   *
   * @return  PaymentMethod
   */
  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
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
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + id.hashCode();
    result = (31 * result) + paymentMethod.hashCode();
    result = (31 * result) + portfolio.hashCode();
    result = (31 * result) + priority.hashCode();

    return result;
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
   * setter method for payment method.
   *
   * @param  paymentMethod  PaymentMethod
   */
  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
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
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }
} // end class ManualEntryPaymentMethodConfiguration
