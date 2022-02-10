package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.config.FlexSiteSSOConfig;


/**
 * Created by wenchaoyong on 10/19/16.
 *
 * @author   <a href="mailto:wenchao.yong@ozstrategy.com">Wenchao Yong</a>
 * @version  10/19/2016 16:27
 */
public interface FlexSiteSSOConfigRepository extends JpaRepository<FlexSiteSSOConfig, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site SSOConfig.
   *
   * @param   portfolioId  Long
   *
   * @return  FlexSiteSSOConfig
   */
  @Query("select f from FlexSiteSSOConfig f where f.portfolio.portfolioId=?1")
  FlexSiteSSOConfig getFlexSiteSSOConfig(Long portfolioId);
}
