package com.cmc.credagility.core.domain.sor;

import javax.persistence.*;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:yao.wang@ozstrategy.com">Yao Wang</a>
 * @version  04/01/2016 10:09
 */
@Entity
@Table(name = "GeneralLedger")
public class GeneralLedger extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4330186306975131323L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 100
  )
  protected String costCenter;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String description;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 80
  )
  protected String GLAccountNumber;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 4
  )
  protected String GLTranCode;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "portfolioId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 12
  )
  protected String productType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for serial version UID.
   *
   * @return  long
   */
  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    GeneralLedger that = (GeneralLedger) o;

    if ((costCenter != null) ? (!costCenter.equals(that.costCenter)) : (that.costCenter != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((GLAccountNumber != null) ? (!GLAccountNumber.equals(that.GLAccountNumber)) : (that.GLAccountNumber != null)) {
      return false;
    }

    if ((GLTranCode != null) ? (!GLTranCode.equals(that.GLTranCode)) : (that.GLTranCode != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return !((productType != null) ? (!productType.equals(that.productType)) : (that.productType != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cost center.
   *
   * @return  String
   */
  public String getCostCenter() {
    return costCenter;
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
   * getter method for GLAccount number.
   *
   * @return  String
   */
  public String getGLAccountNumber() {
    return GLAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for GLTran code.
   *
   * @return  String
   */
  public String getGLTranCode() {
    return GLTranCode;
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
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for product type.
   *
   * @return  String
   */
  public String getProductType() {
    return productType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((costCenter != null) ? costCenter.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((GLAccountNumber != null) ? GLAccountNumber.hashCode() : 0);
    result = (31 * result) + ((GLTranCode != null) ? GLTranCode.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((productType != null) ? productType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cost center.
   *
   * @param  costCenter  String
   */
  public void setCostCenter(String costCenter) {
    this.costCenter = costCenter;
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
   * setter method for GLAccount number.
   *
   * @param  GLAccountNumber  String
   */
  public void setGLAccountNumber(String GLAccountNumber) {
    this.GLAccountNumber = GLAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for GLTran code.
   *
   * @param  GLTranCode  String
   */
  public void setGLTranCode(String GLTranCode) {
    this.GLTranCode = GLTranCode;
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
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for product type.
   *
   * @param  productType  String
   */
  public void setProductType(String productType) {
    this.productType = productType;
  }

} // end class GeneralLedger
