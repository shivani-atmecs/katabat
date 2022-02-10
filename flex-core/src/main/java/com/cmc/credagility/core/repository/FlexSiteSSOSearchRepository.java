package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.sso.FlexSiteSSOIntegrateConfig;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Map;


/**
 * Created by wenchaoyong on 2/22/17.
 *
 * @author   <a href="mailto:wenchao.yong@ozstrategy.com">Wenchao Yong</a>
 * @version  02/22/2017 10:16
 */
public interface FlexSiteSSOSearchRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * searchUserByQuerySql.
   *
   * @param   siteSSOIntegrateConfig  FlexSiteSSOIntegrateConfig
   * @param   tokenFieldMap           Map
   *
   * @return  UserDetails
   *
   * @throws  UsernameNotFoundException  exception
   * @throws  DataAccessException        exception
   */
  UserDetails searchUserByQuerySql(FlexSiteSSOIntegrateConfig siteSSOIntegrateConfig, Map<String, String> tokenFieldMap)
    throws UsernameNotFoundException, DataAccessException;
}
