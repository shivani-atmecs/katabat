package com.cmc.credagility.core.repository.jdbc;


import java.util.List;
import java.util.Map;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  04/08/2015 15:57 PM
 */
public interface ResponsibleRepositoryJdbc {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * listCustomerBorrowers.
   *
   * @param   currentCustomerId   Long
   * @param   loggedInCustomerId  Long
   *
   * @return  Map
   */
  Map<Long, String> listCustomerBorrowers(Long currentCustomerId, Long loggedInCustomerId);

  /**
   * listCustomerBorrowers.
   *
   * @param   currentCustomerId   Long
   * @param   loggedInCustomerId  Long
   * @param   portfolioIds  List
   *
   * @return  Map
   */
  Map<Long, String> listCustomerBorrowers(Long currentCustomerId, Long loggedInCustomerId, List<Long> portfolioIds);
}
