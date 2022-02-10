package com.cmc.credagility.core.domain.negotiate;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * This class is used to store negotiate exception result history information.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/14/2014 17:38
 */
@Entity @Table public class NegotiateExceptionResultHistory extends NegotiateExceptionBaseResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3226135855696171753L;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new NegotiateExceptionResultHistory object.
   */
  public NegotiateExceptionResultHistory() { }

  /**
   * Creates a new NegotiateExceptionResultHistory object.
   *
   * @param  result  NegotiateExceptionBaseResult
   */
  public NegotiateExceptionResultHistory(NegotiateExceptionBaseResult result) {
    super(result);
  }
}
