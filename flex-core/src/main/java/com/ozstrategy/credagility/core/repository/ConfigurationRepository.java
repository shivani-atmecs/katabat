package com.ozstrategy.credagility.core.repository;

import com.cmc.credagility.core.domain.businesscontext.BCIGridConfig;
import com.cmc.credagility.core.domain.businesscontext.BCIStatusColorConfig;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:52
 */
public interface ConfigurationRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCIGrid config.
   *
   * @param   businessContextId  long
   *
   * @return  List
   */
  List<BCIGridConfig> getBCIGridConfig(long businessContextId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCIStatus color config.
   *
   * @param   businessContextId  long
   * @param   start              int
   * @param   limit              int
   *
   * @return  List
   */
  List<BCIStatusColorConfig> getBCIStatusColorConfig(long businessContextId, int start, int limit);
} // end interface ConfigurationRepository
