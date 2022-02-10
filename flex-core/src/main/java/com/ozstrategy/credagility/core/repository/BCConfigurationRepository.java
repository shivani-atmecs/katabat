package com.ozstrategy.credagility.core.repository;

import com.cmc.credagility.core.domain.businesscontext.BCFilterSorterVariable;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:52
 */
public interface BCConfigurationRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for filter variables by business context.
   *
   * @param   businessContextId  Long
   *
   * @return  List
   */
  List<BCFilterSorterVariable> getFilterVariablesByBusinessContext(Long businessContextId);
}
