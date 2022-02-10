package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.channel.IvrResultCodeType;


/**
 * Created by IntelliJ IDEA. User: pkanduri Date: Mar 20, 2010 Time: 10:44:40 PM To change this template use File |
 * Settings | File Templates.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  10/16/2014 10:11
 */
@Entity
@Table(name = "PortfolioIvrDialerResultCode")
public class PortfolioIvrDialerResultCode extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  private static final long serialVersionUID = 1L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Portfolio PK portfolioId. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne protected Portfolio portfolio;

  /** Primary key. */
  @Column(
    name     = "portfolioIvrDialerCode",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioIvrDialerCode;

  /** Action code. */
  @Column(name = "actionCode")
  private String actionCode;

  /** IvrResultCodeType PK ivrResultCodeId. */
  @JoinColumn(
    name     = "ivrResultCodeId",
    nullable = false
  )
  @ManyToOne(cascade = { CascadeType.ALL, CascadeType.REMOVE })
  private IvrResultCodeType ivrResultCodeType;

  /** Result code. */
  @Column(name = "resultCode")
  private String resultCode;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for action code.
   *
   * @return  String
   */
  public String getActionCode() {
    return actionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ivr result code type.
   *
   * @return  IvrResultCodeType
   */
  public IvrResultCodeType getIvrResultCodeType() {
    return ivrResultCodeType;
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
   * getter method for portfolio ivr dialer code.
   *
   * @return  Long
   */
  public Long getPortfolioIvrDialerCode() {
    return portfolioIvrDialerCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for result code.
   *
   * @return  String
   */
  public String getResultCode() {
    return resultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action code.
   *
   * @param  actionCode  String
   */
  public void setActionCode(String actionCode) {
    this.actionCode = actionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr result code type.
   *
   * @param  ivrResultCodeType  IvrResultCodeType
   */
  public void setIvrResultCodeType(IvrResultCodeType ivrResultCodeType) {
    this.ivrResultCodeType = ivrResultCodeType;
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
   * setter method for portfolio ivr dialer code.
   *
   * @param  portfolioIvrDialerCode  Long
   */
  public void setPortfolioIvrDialerCode(Long portfolioIvrDialerCode) {
    this.portfolioIvrDialerCode = portfolioIvrDialerCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for result code.
   *
   * @param  resultCode  String
   */
  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }
} // end class PortfolioIvrDialerResultCode
