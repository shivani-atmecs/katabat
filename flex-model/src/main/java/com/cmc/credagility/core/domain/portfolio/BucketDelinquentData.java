package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Created by IntelliJ IDEA. User: adevan Date: Jun 24, 2010 Time: 11:57:59 AM To change this template use File |
 * Settings | File Templates.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  10/15/2014 16:15
 */
@Entity
@Table(name = "BucketDelinquentData")
public class BucketDelinquentData extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 3557014219221910737L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long bucketDelinquentDataId;

  /** Description of the bucket. */
  @Column(
    name   = "bucketDescription",
    length = 50
  )
  protected String bucketDescription;

  /** The number of the bucket. */
  @Column(name = "bucketNumber")
  protected Integer bucketNumber;

  /** collection group type. */
  @Column(
    name   = "collectionGroupType",
    length = 30
  )
  protected String collectionGroupType;

  /** The date of effective. */
  @Column(name = "effectiveDate")
  @Temporal(TemporalType.DATE)
  protected Date effectiveDate;

  /** Maximum number of days. */
  @Column(name = "maxNumberOfDays")
  protected Integer maxNumberOfDays;

  /** Minimum number of days. */
  @Column(name = "minNumberOfDays")
  protected Integer minNumberOfDays;

  /** Which portfolio in use. */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    BucketDelinquentData that = (BucketDelinquentData) o;

    if ((bucketDelinquentDataId != null) ? (!bucketDelinquentDataId.equals(that.bucketDelinquentDataId))
                                         : (that.bucketDelinquentDataId != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if ((minNumberOfDays != null) ? (!minNumberOfDays.equals(that.minNumberOfDays)) : (that.minNumberOfDays != null)) {
      return false;
    }

    if ((maxNumberOfDays != null) ? (!maxNumberOfDays.equals(that.maxNumberOfDays)) : (that.maxNumberOfDays != null)) {
      return false;
    }

    if ((bucketNumber != null) ? (!bucketNumber.equals(that.bucketNumber)) : (that.bucketNumber != null)) {
      return false;
    }

    if ((bucketDescription != null) ? (!bucketDescription.equals(that.bucketDescription))
                                    : (that.bucketDescription != null)) {
      return false;
    }

    if ((effectiveDate != null) ? (!effectiveDate.equals(that.effectiveDate)) : (that.effectiveDate != null)) {
      return false;
    }

    if ((collectionGroupType != null) ? (!collectionGroupType.equals(that.collectionGroupType))
                                      : (that.collectionGroupType != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket delinquent data id.
   *
   * @return  Long
   */
  public Long getBucketDelinquentDataId() {
    return bucketDelinquentDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket description.
   *
   * @return  String
   */
  public String getBucketDescription() {
    return bucketDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket number.
   *
   * @return  Integer
   */
  public Integer getBucketNumber() {
    return bucketNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for collection group type.
   *
   * @return  String
   */
  public String getCollectionGroupType() {
    return collectionGroupType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for effective date.
   *
   * @return  Date
   */
  public Date getEffectiveDate() {
    return effectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max number of days.
   *
   * @return  Integer
   */
  public Integer getMaxNumberOfDays() {
    return maxNumberOfDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for min number of days.
   *
   * @return  Integer
   */
  public Integer getMinNumberOfDays() {
    return minNumberOfDays;
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
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((bucketDelinquentDataId != null) ? bucketDelinquentDataId.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((collectionGroupType != null) ? collectionGroupType.hashCode() : 0);
    result = (31 * result) + ((bucketNumber != null) ? bucketNumber.hashCode() : 0);
    result = (31 * result) + ((bucketDescription != null) ? bucketDescription.hashCode() : 0);
    result = (31 * result) + ((effectiveDate != null) ? effectiveDate.hashCode() : 0);
    result = (31 * result) + ((minNumberOfDays != null) ? minNumberOfDays.hashCode() : 0);
    result = (31 * result) + ((maxNumberOfDays != null) ? maxNumberOfDays.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket delinquent data id.
   *
   * @param  bucketDelinquentDataId  Long
   */
  public void setBucketDelinquentDataId(Long bucketDelinquentDataId) {
    this.bucketDelinquentDataId = bucketDelinquentDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket description.
   *
   * @param  bucketDescription  String
   */
  public void setBucketDescription(String bucketDescription) {
    this.bucketDescription = bucketDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket number.
   *
   * @param  bucketNumber  Integer
   */
  public void setBucketNumber(Integer bucketNumber) {
    this.bucketNumber = bucketNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for collection group type.
   *
   * @param  collectionGroupType  String
   */
  public void setCollectionGroupType(String collectionGroupType) {
    this.collectionGroupType = collectionGroupType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for effective date.
   *
   * @param  effectiveDate  Date
   */
  public void setEffectiveDate(Date effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max number of days.
   *
   * @param  maxNumberOfDays  Integer
   */
  public void setMaxNumberOfDays(Integer maxNumberOfDays) {
    this.maxNumberOfDays = maxNumberOfDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for min number of days.
   *
   * @param  minNumberOfDays  Integer
   */
  public void setMinNumberOfDays(Integer minNumberOfDays) {
    this.minNumberOfDays = minNumberOfDays;
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
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("BucketDelinquentData");
    sb.append("{portfolio=").append(portfolio);
    sb.append(super.toString());
    sb.append('}');

    return sb.toString();
  }
} // end class BucketDelinquentData
