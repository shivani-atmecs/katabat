package com.ozstrategy.credagility.core.domain.workflow.responsible;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessProcessAssignment;

import javax.persistence.*;


/**
 * Responsible Workflow Business Process Assignment.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:26
 */
@DiscriminatorValue("Responsible")
@Entity public class ResponsibleWorkflowBusinessProcessAssignment extends WorkflowBusinessProcessAssignment {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8862871153729818411L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Portfolio. */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }
} // end class ResponsibleWorkflowBusinessProcessAssignment
