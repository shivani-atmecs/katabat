package com.cmc.credagility.core.domain.portfolio;

import com.cmc.credagility.core.domain.account.AccountOverallStatusDetail;
import com.cmc.credagility.core.domain.base.BaseEntity;

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
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA. User: weitang Date: 12-12-24 Time: PM4:10 To change this template use File | Settings |
 * File Templates.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  10/15/2014 17:31
 */
@Entity
@Table(
  name              = "PortfolioAccountOverallStatusDetail",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "portfolioId", "accountOverallStatusDetailId" }) },
  indexes           = {
    @Index(
      name          = "FKDC_portfolioId",
      columnList    = "portfolioId"
    )
  }
)
public class PortfolioAccountOverallStatusDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7397448191841128671L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** AccountOverallStatusDetail PK accountOverallStatusDetailId.* */
  @JoinColumn(
    name       = "accountOverallStatusDetailId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AccountOverallStatusDetail accountOverallStatusDetail;

  /** Portfolio PK portfolioId.* */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;

  /** Primary key.* */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long portfolioAccountOverallStatusDetailId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account overall status detail.
   *
   * @return  AccountOverallStatusDetail
   */
  public AccountOverallStatusDetail getAccountOverallStatusDetail() {
    return accountOverallStatusDetail;
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
   * getter method for portfolio account overall status detail id.
   *
   * @return  Long
   */
  public Long getPortfolioAccountOverallStatusDetailId() {
    return portfolioAccountOverallStatusDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account overall status detail.
   *
   * @param  accountOverallStatusDetail  AccountOverallStatusDetail
   */
  public void setAccountOverallStatusDetail(AccountOverallStatusDetail accountOverallStatusDetail) {
    this.accountOverallStatusDetail = accountOverallStatusDetail;
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
   * setter method for portfolio account overall status detail id.
   *
   * @param  portfolioAccountOverallStatusDetailId  Long
   */
  public void setPortfolioAccountOverallStatusDetailId(Long portfolioAccountOverallStatusDetailId) {
    this.portfolioAccountOverallStatusDetailId = portfolioAccountOverallStatusDetailId;
  }
} // end class PortfolioAccountOverallStatusDetail
