package com.cmc.credagility.core.domain.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.Date;


/**
 * Created by coin on 7/8/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  07/08/2016 11:00
 */
public class InterestUtils {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * calculateInterest.
   *
   * @param   principalAmount  BigDecimal
   * @param   apr              BigDecimal
   * @param   days             int
   *
   * @return  BigDecimal
   */
  public static BigDecimal calculateInterest(BigDecimal principalAmount, BigDecimal apr, int days) {
    if ((null != principalAmount) && (null != apr)) {
      return ((principalAmount.multiply(apr)).divide(BigDecimal.valueOf(365), 19, RoundingMode.HALF_UP)).multiply(
          BigDecimal.valueOf(days)).setScale(2,
          RoundingMode.HALF_UP);
    } else {
      return BigDecimal.ZERO;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculateInterest.
   *
   * @param   principalAmount  BigDecimal
   * @param   apr              BigDecimal
   * @param   start            Date
   * @param   end              Date
   *
   * @return  BigDecimal
   */
  public static BigDecimal calculateInterest(BigDecimal principalAmount, BigDecimal apr, Date start, Date end) {
    if ((null != principalAmount) && (null != apr)) {
      int days = DateUtil.getDayDifference(start, end, true);

      return ((principalAmount.multiply(apr)).divide(BigDecimal.valueOf(365), 19, RoundingMode.HALF_UP)).multiply(
          BigDecimal.valueOf(days)).setScale(2,
          RoundingMode.HALF_UP);
    } else {
      return BigDecimal.ZERO;
    }
  }

} // end class InterestUtils
