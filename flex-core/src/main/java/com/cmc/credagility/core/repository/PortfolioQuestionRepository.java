package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.portfolio.PortfolioSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.portfolio.PortfolioQuestion;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 15:51
 */
public interface PortfolioQuestionRepository extends JpaRepository<PortfolioQuestion, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for one by variable id.
   *
   * @param   variableId  Long
   *
   * @return  PortfolioQuestion
   */
  @Query("select distinct q from PortfolioQuestion q where q.surveyVariable.id=?1")
  List<PortfolioQuestion> listPortfolioQuestionByVariableId(Long variableId);

  @Query("select ps from PortfolioSurvey ps WHERE ps.portfolio.id = ?1")
  List<PortfolioSurvey> listPortfolioSurveyByPortfolioId(Long portfolioId);
}
