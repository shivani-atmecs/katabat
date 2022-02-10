package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.payment.RoutingNumber;


/**
 * Created with IntelliJ IDEA. User: sujy Date: 15/3/31 To change this template use File | Settings | File Templates.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  03/31/2015 14:20
 */
public interface RoutingNumberRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findByRoutingNumber.
   *
   * @param   routingNumber  String
   *
   * @return  RoutingNumber
   */
  RoutingNumber findByRoutingNumber(String routingNumber);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for routing number count.
   *
   * @return  Long
   */
  Long getRoutingNumberCount();
}
