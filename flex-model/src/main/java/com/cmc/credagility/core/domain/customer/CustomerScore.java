package com.cmc.credagility.core.domain.customer;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  02/27/2015 11:17
 */
@Entity
@Table(name = "CustomerScore")
public class CustomerScore extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7496045274746160890L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "customerId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "customerScoreTypeId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected CustomerScoreType customerScoreType;


  /** TODO: DOCUMENT ME! */
  @Column(name = "entryDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date entryDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "scoreFactor1",
    length = 3
  )
  protected Integer scoreFactor1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "scoreFactor2",
    length = 3
  )
  protected Integer scoreFactor2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "scoreOrder",
    length = 3
  )
  protected Integer scoreOrder;


  /** TODO: DOCUMENT ME! */
  @Column(name = "scoreRefreshDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date scoreRefreshDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "scoreValue",
    length = 3
  )
  protected Integer scoreValue;


  @Column(
    name     = "customerScoreId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long customerScoreId;

  @Column(
    name   = "customerScoreSource",
    length = 15
  )
  @Enumerated(value = EnumType.STRING)
  private CustomerScoreSource customerScoreSource;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final CustomerScore other = (CustomerScore) obj;

    if (scoreOrder == null) {
      if (other.getScoreOrder() != null) {
        return false;
      }
    } else if (!scoreOrder.equals(other.getScoreOrder())) {
      return false;
    }

    if (scoreValue == null) {
      if (other.getScoreValue() != null) {
        return false;
      }
    } else if (!scoreValue.equals(other.getScoreValue())) {
      return false;
    }

    if (scoreRefreshDate == null) {
      if (other.getScoreRefreshDate() != null) {
        return false;
      }
    } else if (!scoreRefreshDate.equals(other.getScoreRefreshDate())) {
      return false;
    }

    if (customerScoreType == null) {
      if (other.getCustomerScoreType() != null) {
        return false;
      }
    } else if (!customerScoreType.equals(other.getCustomerScoreType())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerScoreSource getCustomerScoreSource() {
    return customerScoreSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerScoreType getCustomerScoreType() {
    return customerScoreType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getEntryDate() {
    return entryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getScoreFactor1() {
    return scoreFactor1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getScoreFactor2() {
    return scoreFactor2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getScoreOrder() {
    return scoreOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getScoreRefreshDate() {
    return scoreRefreshDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getScoreValue() {
    return scoreValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((scoreValue == null) ? 0 : scoreValue.hashCode());
    result = (prime * result) + ((scoreOrder == null) ? 0 : scoreOrder.hashCode());
    result = (prime * result) + ((scoreRefreshDate == null) ? 0 : scoreRefreshDate.hashCode());
    result = (prime * result) + ((customerScoreType == null) ? 0 : customerScoreType.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customer  DOCUMENT ME!
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerScoreSource  DOCUMENT ME!
   */
  public void setCustomerScoreSource(CustomerScoreSource customerScoreSource) {
    this.customerScoreSource = customerScoreSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerScoreType  DOCUMENT ME!
   */
  public void setCustomerScoreType(CustomerScoreType customerScoreType) {
    this.customerScoreType = customerScoreType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  entryDate  DOCUMENT ME!
   */
  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  scoreFactor1  DOCUMENT ME!
   */
  public void setScoreFactor1(Integer scoreFactor1) {
    this.scoreFactor1 = scoreFactor1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  scoreFactor2  DOCUMENT ME!
   */
  public void setScoreFactor2(Integer scoreFactor2) {
    this.scoreFactor2 = scoreFactor2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  scoreOrder  DOCUMENT ME!
   */
  public void setScoreOrder(Integer scoreOrder) {
    this.scoreOrder = scoreOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  scoreRefreshDate  DOCUMENT ME!
   */
  public void setScoreRefreshDate(Date scoreRefreshDate) {
    this.scoreRefreshDate = scoreRefreshDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  scoreValue  DOCUMENT ME!
   */
  public void setScoreValue(Integer scoreValue) {
    this.scoreValue = scoreValue;
  }
} // end class CustomerScore
