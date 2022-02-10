package com.ozstrategy.credagility.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * Created with IntelliJ IDEA. User: liaodongming Date: 12-4-6 Time: PM5:04 To change this template use File | Settings
 * | File Templates.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo</a>
 * @version  10/18/2014 11:49
 */
public class RandomUtil {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * nextLong.
   *
   * @param   rng  Random
   * @param   n    long
   *
   * @return  long
   */
  public static long nextLong(Random rng, long n) {
    // error checking and 2^x checking removed for simplicity.
    long bits;
    long val;

    do {
      bits = (rng.nextLong() << 1) >>> 1;
      val  = bits % n;
    } while ((bits - val + (n - 1)) < 0L);

    return val;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   min  DOCUMENT ME!
   * @param   max  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static int random(int min, int max) {
    Random random = new Random();

    return (random.nextInt(max) % (max - min + 1)) + min;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * random.
   *
   * @param   min  long
   * @param   max  long
   *
   * @return  long
   */
  public static long random(long min, long max) {
    Random random = new Random();

    return (nextLong(random, max) % (max - min + 1)) + min;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   beginDate  DOCUMENT ME!
   * @param   endDate    end DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
// public static long random(long begin, long end, String coefficient) {
// // try to fix veracode test.
// long rtn = 0l;
// if(coefficient != null){
// rtn = begin + (long) (Math.random() * (end - begin) * (Double.valueOf(coefficient)));
// if ((rtn == begin) || (rtn == end)) {
// return random(begin, end, coefficient);
// }
// }
// return rtn;
// }

  /**
   * DOCUMENT ME!
   *
   * @param   beginDate  DOCUMENT ME!
   * @param   endDate    DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Date randomDate(Date beginDate, Date endDate) {
    if (beginDate.getTime() >= endDate.getTime()) {
      return null;
    }

    long date = random(beginDate.getTime(), endDate.getTime());

    return new Date(date);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   formatStr  DOCUMENT ME!
   * @param   beginDate  DOCUMENT ME!
   * @param   endDate    DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Date randomDate(String formatStr, String beginDate, String endDate) {
    try {
      SimpleDateFormat format = new SimpleDateFormat(formatStr);
      Date             start  = format.parse(beginDate);
      Date             end    = format.parse(endDate);

      if (start.getTime() >= end.getTime()) {
        return null;
      }

      long date = random(start.getTime(), end.getTime());

      return new Date(date);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  // public static void main(String[] args) {
  // double   f   =   3d/2d;
  // NumberFormat ddf1= NumberFormat.getNumberInstance() ;
  // ddf1.setMaximumFractionDigits(1);
  // String s= ddf1.format(f) ;
  // System.out.println("" + s);
  // System.out.println("Random Long : "+ random(2500,3000,s));
  // }

} // end class RandomUtil
