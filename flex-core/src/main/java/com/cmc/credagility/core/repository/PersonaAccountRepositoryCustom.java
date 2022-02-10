package com.cmc.credagility.core.repository;

import java.util.Date;
import java.util.List;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface PersonaAccountRepositoryCustom {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsibleIds  DOCUMENT ME!
   * @param  lastUpdateDate  DOCUMENT ME!
   */
  void updatePersonaAccountsHistorical(List<Long> responsibleIds, Date lastUpdateDate);
}
