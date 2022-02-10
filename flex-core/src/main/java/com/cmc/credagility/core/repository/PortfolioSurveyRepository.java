package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyAnswerUserSavedValue;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.portfolio.PortfolioSurvey;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 15:42
 */
public interface PortfolioSurveyRepository extends JpaRepository<PortfolioSurvey, Long> {

  @Query("select distinct ps from PortfolioSurveyAnswerUserSavedValue ps where ps.survey.id=?1 and ps.question.id=?2 and ps.responsible.responsibleId=?3 order by ps.createDate DESC")
  List<PortfolioSurveyAnswerUserSavedValue> getBySurveyQuestion(Long surveyId, Long questionId, Long responsibleId);
}
