package com.ozstrategy.credagility.core.repository.jdbc;


import com.ozstrategy.credagility.core.domain.SurveyFlowAuditQuestion;
import com.ozstrategy.credagility.core.info.DocumentInfo;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 16:02
 */
public interface WorkflowRepositoryJdbc {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * countWorkflowDocument.
   *
   * @param   responsibleId  Long
   * @param   queryText      String
   *
   * @return  Integer
   */
  Integer countWorkflowDocument(final Long responsibleId, final String queryText);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer options by provider.
   *
   * @param   questionId  Long
   *
   * @return  List
   */
  List<Object[]> getAnswerOptionsByProvider(Long questionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for audit question.
   *
   * @param   responsibleId    Long
   * @param   flowStepId       Long
   * @param   auditInstanceId  Long
   * @param   questionId       Long
   *
   * @return  SurveyFlowAuditQuestion
   */
  SurveyFlowAuditQuestion getAuditQuestion(final Long responsibleId, final Long flowStepId, final Long auditInstanceId,
    final Long questionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * readWorkflowDocument.
   *
   * @param   responsibleId  Long
   * @param   queryText      String
   * @param   start          int
   * @param   size           int
   *
   * @return  List
   */
  List<DocumentInfo> readWorkflowDocument(final Long responsibleId, final String queryText, final int start,
    final int size);

} // end interface WorkflowRepositoryJdbc
