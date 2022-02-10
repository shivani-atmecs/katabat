package com.cmc.credagility.core.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.common.GenericLock;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  04/01/2015 17:05
 */
@Repository public interface GenericLockCustom {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   queryType  DOCUMENT ME!
   * @param   params     DOCUMENT ME!
   * @param   queryStr   DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Boolean executeQuery(String queryType, final Map<String, Object> params, final String queryStr);


} // end interface GenericLockCustom
