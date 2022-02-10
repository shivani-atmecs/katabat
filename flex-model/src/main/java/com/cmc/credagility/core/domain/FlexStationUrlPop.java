package com.cmc.credagility.core.domain;

import com.cmc.credagility.core.domain.base.CreatorEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * FlexStation Popup Url.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/20/2014 17:13 PM
 */
@Entity public class FlexStationUrlPop extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -819563578818941712L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    name   = "acct",
    length = 50
  )
  protected String acct;

  /** DOCUMENT ME! */
  @Column(
    name   = "ani",
    length = 50
  )
  protected String ani;


  /** DOCUMENT ME! */
  @Column(
    name   = "customerId",
    length = 50
  )
  protected String customerId;

  /** DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "portfolioId",
    length = 50
  )
  protected String portfolioId;

  /** DOCUMENT ME! */
  @Column(
    name   = "sourceType",
    length = 50
  )
  protected String sourceType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAcct() {
    return acct;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAni() {
    return ani;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustomerId() {
    return customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio id.
   *
   * @return  String
   */
  public String getPortfolioId() {
    return portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSourceType() {
    return sourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  acct  DOCUMENT ME!
   */
  public void setAcct(String acct) {
    this.acct = acct;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ani  DOCUMENT ME!
   */
  public void setAni(String ani) {
    this.ani = ani;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerId  clientId DOCUMENT ME!
   */

  /**
   * DOCUMENT ME!
   *
   * @param  customerId  DOCUMENT ME!
   */
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio id.
   *
   * @param  portfolioId  String
   */
  public void setPortfolioId(String portfolioId) {
    this.portfolioId = portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sourceType  DOCUMENT ME!
   */
  public void setSourceType(String sourceType) {
    this.sourceType = sourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "FlexStationUrlPop{"
      + "acct='" + acct + '\''
      + ", ani='" + ani + '\''
      + ", portfolioId='" + portfolioId + '\''

      + ", customerId='" + customerId + '\''
      + ", id=" + id
      + ", sourceType='" + sourceType + '\''
      + '}';
  }
} // end class FlexStationUrlPop
