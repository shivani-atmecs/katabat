package com.cmc.credagility.core.domain.invoice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * The additional data for tobacco tax info if the portfolio is tobacco tax customer.
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 10:49
 */
@Entity
@Table(name = "InvoiceTobaccoTaxData")
public class InvoiceTobaccoTaxData extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2182213562468635575L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(name = "numberOfCarton")
  private Integer numberOfCarton;

  @Column(name = "purchasePrice")
  private BigDecimal purchasePrice;

  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "ttDataId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long ttDataId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final InvoiceTobaccoTaxData other = (InvoiceTobaccoTaxData) obj;

    if (numberOfCarton == null) {
      if (other.numberOfCarton != null) {
        return false;
      }
    } else if (!numberOfCarton.equals(other.numberOfCarton)) {
      return false;
    }

    if (purchasePrice == null) {
      if (other.purchasePrice != null) {
        return false;
      }
    } else if (!purchasePrice.equals(other.purchasePrice)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for number of carton.
   *
   * @return  Integer
   */
  public Integer getNumberOfCarton() {
    return numberOfCarton;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for purchase price.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPurchasePrice() {
    return purchasePrice;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tt data id.
   *
   * @return  Long
   */
  public Long getTtDataId() {
    return ttDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((numberOfCarton == null) ? 0 : numberOfCarton.hashCode());
    result = (prime * result)
      + ((purchasePrice == null) ? 0 : purchasePrice.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for number of carton.
   *
   * @param  numberOfCarton  Integer
   */
  public void setNumberOfCarton(Integer numberOfCarton) {
    this.numberOfCarton = numberOfCarton;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for purchase price.
   *
   * @param  purchasePrice  BigDecimal
   */
  public void setPurchasePrice(BigDecimal purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tt data id.
   *
   * @param  ttDataId  Long
   */
  public void setTtDataId(Long ttDataId) {
    this.ttDataId = ttDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "InvoiceTobaccoTaxData ( " + TAB + "numberOfCarton = "
      + this.numberOfCarton + TAB + "purchasePrice = " + this.purchasePrice
      + TAB + " )";

    return retValue;
  }

} // end class InvoiceTobaccoTaxData
