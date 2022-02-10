package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.channel.EmailType;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 12/20/12 Time: 10:01 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  10/16/2014 10:08
 */
@Entity
@Table(
  name              = "PortfolioEmailType",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "portfolioId", "emailTypeId" }) },
  indexes           = {
    @Index(
      name          = "FK2D_portfolioId",
      columnList    = "portfolioId"
    )
  }
)
public class PortfolioEmailType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7860685568067869565L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** EmailType PK emailTypeId. */
  @JoinColumn(
    name       = "emailTypeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private EmailType emailType;

  /** Portfolio PK portfolioId. */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long portfolioEmailTypeId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for email type.
   *
   * @return  EmailType
   */
  public EmailType getEmailType() {
    return emailType;
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
   * getter method for portfolio email type id.
   *
   * @return  Long
   */
  public Long getPortfolioEmailTypeId() {
    return portfolioEmailTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email type.
   *
   * @param  emailType  EmailType
   */
  public void setEmailType(EmailType emailType) {
    this.emailType = emailType;
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
   * setter method for portfolio email type id.
   *
   * @param  portfolioEmailTypeId  Long
   */
  public void setPortfolioEmailTypeId(Long portfolioEmailTypeId) {
    this.portfolioEmailTypeId = portfolioEmailTypeId;
  }
} // end class PortfolioEmailType
