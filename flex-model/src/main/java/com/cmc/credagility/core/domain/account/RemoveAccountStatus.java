package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.PortfolioAgentDispositionConfiguration;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/17/2014 10:02
 */
@Entity
@Table(
  name              = "RemoveAccountStatus",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "portfolioAgentDispositionConfigurationId", "statusId" }) }
)
public class RemoveAccountStatus extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 3321155919143393342L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "statusId",
    updatable = true,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountStatusDetail accountStatusDetail = null;


  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String expression;

  /** PortfolioAgentDispositionCode. */
  @JoinColumn(
    name      = "portfolioAgentDispositionConfigurationId",
    updatable = true,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioAgentDispositionConfiguration portfolioAgentDispositionConfiguration = null;

  /** AddAccountStatus identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long removeAccountStatusId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account status detail.
   *
   * @return  AccountStatusDetail
   */
  public AccountStatusDetail getAccountStatusDetail() {
    return accountStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for expression.
   *
   * @return  String
   */
  public String getExpression() {
    return expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio agent disposition configuration.
   *
   * @return  PortfolioAgentDispositionConfiguration
   */
  public PortfolioAgentDispositionConfiguration getPortfolioAgentDispositionConfiguration() {
    return portfolioAgentDispositionConfiguration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for remove account status id.
   *
   * @return  Long
   */
  public Long getRemoveAccountStatusId() {
    return removeAccountStatusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account status detail.
   *
   * @param  accountStatusDetail  AccountStatusDetail
   */
  public void setAccountStatusDetail(AccountStatusDetail accountStatusDetail) {
    this.accountStatusDetail = accountStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for expression.
   *
   * @param  expression  String
   */
  public void setExpression(String expression) {
    this.expression = expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio agent disposition configuration.
   *
   * @param  portfolioAgentDispositionConfiguration  PortfolioAgentDispositionConfiguration
   */
  public void setPortfolioAgentDispositionConfiguration(
    PortfolioAgentDispositionConfiguration portfolioAgentDispositionConfiguration) {
    this.portfolioAgentDispositionConfiguration = portfolioAgentDispositionConfiguration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for remove account status id.
   *
   * @param  removeAccountStatusId  Long
   */
  public void setRemoveAccountStatusId(Long removeAccountStatusId) {
    this.removeAccountStatusId = removeAccountStatusId;
  }
} // end class RemoveAccountStatus
