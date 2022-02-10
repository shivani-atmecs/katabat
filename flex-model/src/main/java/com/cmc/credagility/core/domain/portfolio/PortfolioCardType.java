package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created by IntelliJ IDEA. User: anigam Date: 3/14/12 Time: 9:34 AM To change this template use File | Settings | File
 * Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "PortfolioCardType")
public class PortfolioCardType extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> allow credit, default is <code>false.</code> */
  @Column(
    name             = "allowCredit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowCredit = false;

  /** <code>true</code> allow debit, default is <code>false.</code> */
  @Column(
    name             = "allowDebit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowDebit = false;

  /** Portfolio PK portfolioId. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** Portfolio card typeId. */
  @Column(
    name     = "portfolioCardTypeId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioCardTypeId;

  /** Card type description. */
  @Column(
    name   = "cardTypeDescription",
    length = 255
  )
  private String cardTypeDescription;

  /** Card typeName. */
  @Column(
    name   = "cardTypeName",
    length = 255
  )
  private String cardTypeName;

  /** <code>true</code> disabled. */
  @Column(
    name             = "disabledFlag",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean disabledFlag;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioCardType)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioCardType that = (PortfolioCardType) o;

    if ((cardTypeDescription != null) ? (!cardTypeDescription.equals(that.cardTypeDescription))
                                      : (that.cardTypeDescription != null)) {
      return false;
    }

    if ((cardTypeName != null) ? (!cardTypeName.equals(that.cardTypeName)) : (that.cardTypeName != null)) {
      return false;
    }

    if ((disabledFlag != null) ? (!disabledFlag.equals(that.disabledFlag)) : (that.disabledFlag != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if ((portfolioCardTypeId != null) ? (!portfolioCardTypeId.equals(that.portfolioCardTypeId))
                                      : (that.portfolioCardTypeId != null)) {
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
  public Boolean getAllowCredit() {
    if (allowCredit == null) {
      return Boolean.FALSE;
    }

    return allowCredit;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowDebit() {
    if (allowDebit == null) {
      return Boolean.FALSE;
    }

    return allowDebit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCardTypeDescription() {
    return cardTypeDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCardTypeName() {
    return cardTypeName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getDisabledFlag() {
    return disabledFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPortfolioCardTypeId() {
    return portfolioCardTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((portfolioCardTypeId != null) ? portfolioCardTypeId.hashCode() : 0);
    result = (31 * result) + ((cardTypeDescription != null) ? cardTypeDescription.hashCode() : 0);
    result = (31 * result) + ((cardTypeName != null) ? cardTypeName.hashCode() : 0);
    result = (31 * result) + ((disabledFlag != null) ? disabledFlag.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cardTypeDescription  DOCUMENT ME!
   */
  public void setCardTypeDescription(String cardTypeDescription) {
    this.cardTypeDescription = cardTypeDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cardTypeName  DOCUMENT ME!
   */
  public void setCardTypeName(String cardTypeName) {
    this.cardTypeName = cardTypeName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  disabledFlag  DOCUMENT ME!
   */
  public void setDisabledFlag(Boolean disabledFlag) {
    this.disabledFlag = disabledFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioCardTypeId  DOCUMENT ME!
   */
  public void setPortfolioCardTypeId(Long portfolioCardTypeId) {
    this.portfolioCardTypeId = portfolioCardTypeId;
  }
} // end class PortfolioCardType
