package com.cmc.credagility.core.utility;

import com.cmc.credagility.core.domain.payment.RoutingNumber;
import com.cmc.credagility.core.repository.RoutingNumberRepository;


/**
 * Created with IntelliJ IDEA. User: sujy Date: 15/3/31 To change this template use File | Settings | File Templates.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  03/31/2015 14:13
 */
public class RoutingNumberHelper {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static RoutingNumberHelper instance = new RoutingNumberHelper();

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private RoutingNumberRepository routingNumberRepository;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private RoutingNumberHelper() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * bankName.
   *
   * @param   routingNumber  String
   *
   * @return  String
   */
  public static String bankName(String routingNumber) {
    return bankNameWithoutCategory(routingNumber);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * bankNameWithoutCategory.
   *
   * @param   routingNumber  String
   *
   * @return  String
   */
  public static String bankNameWithoutCategory(String routingNumber) {
    RoutingNumber routingNum = getInstance().routingNumberRepository.findByRoutingNumber(routingNumber);

    if (routingNum != null) {
      return routingNum.getBankName();
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for instance.
   *
   * @return  RoutingNumberValueHelper
   */
  public static RoutingNumberHelper getInstance() {
    return instance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for routing number count.
   *
   * @return  Long
   */
  public static Long getRoutingNumberCount() {
    return getInstance().routingNumberRepository.getRoutingNumberCount();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for routing number repository.
   *
   * @param  routingNumberRepository  RoutingNumberRepository
   */
  public static void setRoutingNumberRepository(RoutingNumberRepository routingNumberRepository) {
    getInstance().routingNumberRepository = routingNumberRepository;
  }
} // end class RoutingNumberHelper
