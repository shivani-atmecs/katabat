package com.cmc.credagility.core.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.businesscontext.BCVariable;
import com.cmc.credagility.core.domain.portfolio.PortfolioVariable;
import com.cmc.credagility.core.domain.survey.SurveyFlowVariable;
import com.cmc.credagility.core.domain.variable.Variable;
import com.cmc.credagility.core.domain.variable.VariableAudit;
import com.cmc.credagility.core.domain.variable.WorkflowVariable;


/**
 * Created by wangyang on 10/28/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/28/2014 17:03 PM
 */
@Repository public class VariableRepositoryImpl implements VariableRepository {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  VariableRepository#auditHistory(Long, String)
   */
  @Override public Set<Object> auditHistory(Long responsibleId, String variableName) {
    Set<Object> auditHistory = new HashSet<>();
    List        auditChanges = em.createQuery(
        "from VariableValueChangeAudit v where v.variableName=:variableName and v.responsible.responsibleId=:responsibleId order by v.createDate desc ")
      .setParameter("variableName", variableName).setParameter("responsibleId", responsibleId).getResultList();
    auditHistory.addAll(auditChanges);

    List auditAll = em.createQuery(
        "from VariableValueAudit v where v.variableName=:variableName and v.responsible.responsibleId=:responsibleId order by v.createDate desc ")
      .setParameter("variableName", variableName).setParameter("responsibleId", responsibleId).getResultList();

    auditHistory.addAll(auditChanges);
    auditHistory.addAll(auditAll);

    return auditHistory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveAudit.
   *
   * @param   variableAudit  VariableAudit
   *
   * @return  VariableAudit
   */
  @Override public VariableAudit saveAudit(VariableAudit variableAudit) {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveBCVariable.
   *
   * @param   variable  BCVariable
   *
   * @return  BCVariable
   */
  @Override public BCVariable saveBCVariable(BCVariable variable) {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * savePortfolioVariable.
   *
   * @param   variable  PortfolioVariable
   *
   * @return  PortfolioVariable
   */
  @Override public PortfolioVariable savePortfolioVariable(PortfolioVariable variable) {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveSurveyFlowVariable.
   *
   * @param   variable  SurveyFlowVariable
   *
   * @return  SurveyFlowVariable
   */
  @Override public SurveyFlowVariable saveSurveyFlowVariable(SurveyFlowVariable variable) {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveVariable.
   *
   * @param   variable  Variable
   *
   * @return  Variable
   */
  @Override public Variable saveVariable(Variable variable) {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveWorkflowVariable.
   *
   * @param   variable  WorkflowVariable
   *
   * @return  WorkflowVariable
   */
  @Override public WorkflowVariable saveWorkflowVariable(WorkflowVariable variable) {
    return null;
  }
} // end class VariableRepositoryImpl
