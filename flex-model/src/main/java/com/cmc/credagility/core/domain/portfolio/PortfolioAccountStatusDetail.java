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

import com.cmc.credagility.core.domain.account.AccountStatusDetail;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Created with IntelliJ IDEA. User: weitang Date: 12-12-24 Time: PM11:54 To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "PortfolioAccountStatusDetail",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "portfolioId", "accountStatusDetailId" }) },
  indexes           = {
    @Index(
      name          = "FKDC_portfolioId",
      columnList    = "portfolioId"
    )
  }
)
public class PortfolioAccountStatusDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2230303470942970918L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** AccountStatusDetail PK accountStatusDetailId.* */
  @JoinColumn(
    name       = "accountStatusDetailId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AccountStatusDetail accountStatusDetail;

  /** Portfolio PK portfolioId.* */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;

  /** Primary key.* */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long portfolioAccountStatusDetailId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountStatusDetail getAccountStatusDetail() {
    return accountStatusDetail;
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
  public Long getPortfolioAccountStatusDetailId() {
    return portfolioAccountStatusDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountStatusDetail  DOCUMENT ME!
   */
  public void setAccountStatusDetail(AccountStatusDetail accountStatusDetail) {
    this.accountStatusDetail = accountStatusDetail;
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
   * @param  portfolioAccountStatusDetailId  DOCUMENT ME!
   */
  public void setPortfolioAccountStatusDetailId(Long portfolioAccountStatusDetailId) {
    this.portfolioAccountStatusDetailId = portfolioAccountStatusDetailId;
  }
} // end class PortfolioAccountStatusDetail
