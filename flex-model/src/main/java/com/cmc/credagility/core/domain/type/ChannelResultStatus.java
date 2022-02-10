package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for channel result status types.
 *
 * <p><a href="ChannelResultStatus.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
public enum ChannelResultStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  INIT, EXPORTED, EXECUTED, REJECTED, SENT, CONFIRMED, BUFFERED, ACKED, FAILED, SKIPPED, UNKNOWN, SEND_FAILED, CLOSED,STOPPED,
  TEMP;
}
