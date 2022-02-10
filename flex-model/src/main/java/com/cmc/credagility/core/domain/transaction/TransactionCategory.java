package com.cmc.credagility.core.domain.transaction;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.common.InterestRateCategory;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 15:40
 */
@Entity
@Table(name = "TransactionCategory")
public class TransactionCategory extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -6318175874581836413L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowManualEntry",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowManualEntry = Boolean.FALSE;

  /** Transaction Category. */
  @Column(
    name   = "category",
    length = 100
  )
  protected String category;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "credit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean credit = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "defaultInterestRateCategoryId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne protected InterestRateCategory defaultInterestRateCategory;

  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new TransactionCategory object.
   */
  public TransactionCategory() { }

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

    TransactionCategory that = (TransactionCategory) o;

    if ((allowManualEntry != null) ? (!allowManualEntry.equals(that.allowManualEntry))
                                   : (that.allowManualEntry != null)) {
      return false;
    }

    if ((category != null) ? (!category.equals(that.category)) : (that.category != null)) {
      return false;
    }

    if ((credit != null) ? (!credit.equals(that.credit)) : (that.credit != null)) {
      return false;
    }

    if ((defaultInterestRateCategory != null) ? (!defaultInterestRateCategory.equals(
              that.defaultInterestRateCategory)) : (that.defaultInterestRateCategory != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow manual entry.
   *
   * @return  Boolean
   */
  public Boolean getAllowManualEntry() {
    if (null == allowManualEntry) {
      return false;
    }

    return allowManualEntry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  String
   */
  public String getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for credit.
   *
   * @return  Boolean
   */
  public Boolean getCredit() {
    if (null == credit) {
      return false;
    }

    return credit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default interest rate category.
   *
   * @return  InterestRateCategory
   */
  public InterestRateCategory getDefaultInterestRateCategory() {
    return defaultInterestRateCategory;
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
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((allowManualEntry != null) ? allowManualEntry.hashCode() : 0);
    result = (31 * result) + ((category != null) ? category.hashCode() : 0);
    result = (31 * result) + ((credit != null) ? credit.hashCode() : 0);
    result = (31 * result) + ((defaultInterestRateCategory != null) ? defaultInterestRateCategory.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow manual entry.
   *
   * @param  allowManualEntry  Boolean
   */
  public void setAllowManualEntry(Boolean allowManualEntry) {
    this.allowManualEntry = allowManualEntry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  String
   */
  public void setCategory(String category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for credit.
   *
   * @param  credit  Boolean
   */
  public void setCredit(Boolean credit) {
    this.credit = credit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default interest rate category.
   *
   * @param  defaultInterestRateCategory  InterestRateCategory
   */
  public void setDefaultInterestRateCategory(InterestRateCategory defaultInterestRateCategory) {
    this.defaultInterestRateCategory = defaultInterestRateCategory;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "TransactionCategory{"
      + "allowManualEntry=" + allowManualEntry
      + ", category='" + category + '\''
      + ", credit=" + credit
      + ", defaultInterestRateCategory=" + defaultInterestRateCategory
      + ", id=" + id
      + '}';
  }
} // end class TransactionCategory
