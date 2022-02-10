package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.sso.FlexSiteSSOIntegrateConfig;


/**
 * Created by wenchaoyong on 2/17/17.
 *
 * @author   <a href="mailto:wenchao.yong@ozstrategy.com">Wenchao Yong</a>
 * @version  02/17/2017 14:19
 */
public interface FlexSiteSSOIntegrateConfigRepository extends JpaRepository<FlexSiteSSOIntegrateConfig, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site SSOIntegrate config.
   *
   * @param   tag  String
   *
   * @return  FlexSiteSSOIntegrateConfig
   */
  @Query("from FlexSiteSSOIntegrateConfig f where f.tag=?1")
  FlexSiteSSOIntegrateConfig getFlexSiteSSOIntegrateConfig(String tag);
}
