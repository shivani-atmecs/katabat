package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:14
 */
public enum BankruptcyStatus {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  PENDING,

  // Debt Discharged - Debtor is not liable any more
  DISCHARGED,

  // case dismissed, debtor is still liable
  DISMISSED
}
