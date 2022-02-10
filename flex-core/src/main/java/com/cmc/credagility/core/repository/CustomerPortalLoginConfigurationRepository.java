package com.cmc.credagility.core.repository;

import java.util.List;
import java.util.Set;

import org.springframework.cache.annotation.Cacheable;

import com.cmc.credagility.core.domain.client.CustomerPortalLoginConfiguration;
import com.cmc.credagility.core.domain.client.CustomerPortalLoginToken;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface CustomerPortalLoginConfigurationRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Find the CustomerPortalLoginConfiguration by packageName and find the associated tokens with English language.
   *
   * @param   packageName  DOCUMENT ME!
   *
   * @return  find the CustomerPortalLoginConfiguration by packageName and find the associated tokens by language.
   */
  @Cacheable CustomerPortalLoginConfiguration findCustomerPortalLoginConfigurationByName(String packageName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Find the CustomerPortalLoginConfiguration by packageName and find the associated tokens by language.
   *
   * @param   packageName  DOCUMENT ME!
   * @param   language     The language code reference CustomerPortalPreferredLanguages table ( English --> en_US French
   *                       --> fr_FR)
   *
   * @return  find the CustomerPortalLoginConfiguration by packageName and find the associated tokens by language.
   */
  @Cacheable CustomerPortalLoginConfiguration findCustomerPortalLoginConfigurationByName(String packageName,
    String language);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   packageName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<CustomerPortalLoginToken> findLoginTokensByPackageName(String packageName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   packageName  DOCUMENT ME!
   * @param   language     DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Set<CustomerPortalLoginToken> findLoginTokensByPackageName(String packageName, String language);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Find the responsible by execute the loginSQL which in CustomerPortalLoginConfiguration table configured.
   *
   * @param   loginSQL  The loginSQL which configured in CustomerPortalLoginConfiguration table.
   * @param   params    The SQL parameters.
   *
   * @return  The <code>Responsible</code>
   */
  List<Responsible> findResponsibleByExecuteLoginSQL(String loginSQL, List<Object> params);

  /**
   *
   * @param loginSQL
   * @param params
   * @return
   */
  List<Object> findByExecuteLoginSQL(String loginSQL, List<Object> params);

} // end interface CustomerPortalLoginConfigurationRepository
