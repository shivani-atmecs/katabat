package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyAnswerOptionVersion;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/23/2014 14:30
 */
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

// @EntityGraph(value = "Portfolio.events", type = EntityGraph.EntityGraphType.FETCH)
  /**
   * findFirstByPortfolioId.
   *
   * @param   portfolioId  Long
   *
   * @return  Portfolio
   */
  @Query(
    "SELECT p FROM Portfolio p LEFT JOIN FETCH p.events ev left join fetch ev.eventActivities activities left join fetch activities.activityChannels channels WHERE p.portfolioId = ?1 "
  )
  Portfolio findFirstByPortfolioId(Long portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findFirstByPortfolioByTheme.
   *
   * @param   theme  String
   *
   * @return  Portfolio
   */
  Portfolio findFirstByTheme(String theme);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findFirstByThemeIsNull.
   *
   * @return  Portfolio
   */
  Portfolio findFirstByThemeIsNull();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio survey answer option versions.
   *
   * @param   questionVersionId  Long
   *
   * @return  List
   */
  @Query("from PortfolioSurveyAnswerOptionVersion p where p.questionVersion.id = ?1")
  List<PortfolioSurveyAnswerOptionVersion> getPortfolioSurveyAnswerOptionVersions(final Long questionVersionId);
} // end interface PortfolioRepository
