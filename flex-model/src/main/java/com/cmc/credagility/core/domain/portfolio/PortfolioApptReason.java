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
 * Created with IntelliJ IDEA. User: knandyala Date: 10/31/12 Time: 4:30 PM To change this template use File | Settings
 * | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "PortfolioApptReason")
public class PortfolioApptReason extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Which portfolio referenced. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** Portfolio application reason id. */
  @Column(
    name     = "portfolioApptReasonId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioApptReasonId;


  /** Application reason code. */
  @Column(
    name   = "apptReasonCode",
    length = 50
  )
  private String apptReasonCode;

  /** Application reason description. */
  @Column(
    name   = "apptReasonDescription",
    length = 255
  )
  private String apptReasonDescription;


  /** <code>true</code> disabled. */
  @Column(
    name             = "disable",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean disable;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioApptReason)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioApptReason that = (PortfolioApptReason) o;

    if ((apptReasonDescription != null) ? (!apptReasonDescription.equals(that.apptReasonDescription))
                                        : (that.apptReasonDescription != null)) {
      return false;
    }

    if ((apptReasonCode != null) ? (!apptReasonCode.equals(that.apptReasonCode)) : (that.apptReasonCode != null)) {
      return false;
    }

    if ((disable != null) ? (!disable.equals(that.disable)) : (that.disable != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if ((portfolioApptReasonId != null) ? (!portfolioApptReasonId.equals(that.portfolioApptReasonId))
                                        : (that.portfolioApptReasonId != null)) {
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
  public String getApptReasonCode() {
    return apptReasonCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptReasonDescription() {
    return apptReasonDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getdisable() {
    return disable;
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
  public Long getPortfolioApptReasonId() {
    return portfolioApptReasonId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((portfolioApptReasonId != null) ? portfolioApptReasonId.hashCode() : 0);
    result = (31 * result) + ((apptReasonDescription != null) ? apptReasonDescription.hashCode() : 0);
    result = (31 * result) + ((apptReasonCode != null) ? apptReasonCode.hashCode() : 0);
    result = (31 * result) + ((disable != null) ? disable.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptReasonCode  DOCUMENT ME!
   */
  public void setApptReasonCode(String apptReasonCode) {
    this.apptReasonCode = apptReasonCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptReasonDescription  DOCUMENT ME!
   */
  public void setApptReasonDescription(String apptReasonDescription) {
    this.apptReasonDescription = apptReasonDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  disable  DOCUMENT ME!
   */
  public void setdisable(Boolean disable) {
    this.disable = disable;
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
   * @param  portfolioApptReasonId  DOCUMENT ME!
   */
  public void setPortfolioApptReasonId(Long portfolioApptReasonId) {
    this.portfolioApptReasonId = portfolioApptReasonId;
  }

} // end class PortfolioApptReason
