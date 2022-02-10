package com.ozstrategy.credagility.core.el.repository;

import com.cmc.credagility.core.domain.businesscontext.BCVariable;
import com.cmc.credagility.core.domain.portfolio.PortfolioVariable;
import com.cmc.credagility.core.domain.survey.SurveyFlowVariable;
import com.cmc.credagility.core.domain.variable.Variable;
import com.cmc.credagility.core.domain.variable.VariableAudit;
import com.cmc.credagility.core.domain.variable.WorkflowVariable;


/**
 * Created by Yang Wang on 10/28/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/28/2014 16:30 PM
 */
public interface ElVariableRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * saveAudit.
   *
   * @param   variableAudit  VariableAudit
   *
   * @return  VariableAudit
   */
  VariableAudit saveAudit(VariableAudit variableAudit);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveBCVariable.
   *
   * @param   variable  BCVariable
   *
   * @return  BCVariable
   */
  BCVariable saveBCVariable(BCVariable variable);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * savePortfolioVariable.
   *
   * @param   variable  PortfolioVariable
   *
   * @return  PortfolioVariable
   */
  PortfolioVariable savePortfolioVariable(PortfolioVariable variable);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveSurveyFlowVariable.
   *
   * @param   variable  SurveyFlowVariable
   *
   * @return  SurveyFlowVariable
   */
  SurveyFlowVariable saveSurveyFlowVariable(SurveyFlowVariable variable);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveVariable.
   *
   * @param   variable  Variable
   *
   * @return  Variable
   */
  Variable saveVariable(Variable variable);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveWorkflowVariable.
   *
   * @param   variable  WorkflowVariable
   *
   * @return  WorkflowVariable
   */
  WorkflowVariable saveWorkflowVariable(WorkflowVariable variable);
} // end interface VariableRepository
