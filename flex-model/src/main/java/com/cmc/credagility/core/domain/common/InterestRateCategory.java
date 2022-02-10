package com.cmc.credagility.core.domain.common;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store InterestRateCategory information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 15:36
 */
@Entity
@Table(name = "InterestRateCategory")
public class InterestRateCategory extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Category name. */
  @Column(
    name     = "categoryName",
    nullable = false,
    length   = 255
  )
  protected String categoryName;

  /** Description. */
  @Column(
    name     = "description",
    nullable = true,
    length   = 255
  )
  protected String description;

  /** Rate. */
  @Column(
    name     = "rate",
    nullable = false
  )
  protected BigDecimal rate = new BigDecimal(0.0);

  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new InterestRateCategory object.
   */
  public InterestRateCategory() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    InterestRateCategory that = (InterestRateCategory) o;

    if ((categoryName != null) ? (!categoryName.equals(that.categoryName)) : (that.categoryName != null)) {
      return false;
    }

    if ((rate != null) ? (!rate.equals(that.rate)) : (that.rate != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getCategoryName.
   *
   * @return  String
   */
  public String getCategoryName() {
    return categoryName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getDescription.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getId.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getRate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRate() {
    return rate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = 0;
    result = (31 * result) + ((categoryName != null) ? categoryName.hashCode() : 0);
    result = (31 * result) + ((rate != null) ? rate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCategoryName.
   *
   * @param  categoryName  String
   */
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setDescription.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setRate.
   *
   * @param  rate  BigDecimal
   */
  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }


} // end class InterestRateCategory
