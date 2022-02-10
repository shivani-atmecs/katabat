package com.cmc.credagility.core.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.client.CustomerPortalLoginConfiguration;
import com.cmc.credagility.core.domain.client.CustomerPortalLoginToken;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.util.constant.Constants;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Repository("customerPortalLoginConfigurationRepository")
public class CustomerPortalLoginConfigurationRepositoryImpl implements CustomerPortalLoginConfigurationRepository {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  public static final String DEFAULT_LANGUAGE = "en_US";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  CustomerPortalLoginConfigurationRepository#findCustomerPortalLoginConfigurationByName(String)
   */
  @Override public CustomerPortalLoginConfiguration findCustomerPortalLoginConfigurationByName(String packageName) {
    return findCustomerPortalLoginConfigurationByName(packageName, DEFAULT_LANGUAGE);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  CustomerPortalLoginConfigurationRepository#findCustomerPortalLoginConfigurationByName(String,
   *       String)
   */
  @Override public CustomerPortalLoginConfiguration findCustomerPortalLoginConfigurationByName(String packageName,
    String language) {
    packageName = packageName.trim();
    language    = StringUtils.hasText(language) ? language.trim() : Constants.DEFAULT_LANGUAGE;

    if (!StringUtils.hasText(packageName)
          || packageName.equalsIgnoreCase("none")
          || packageName.equalsIgnoreCase("null")) {
      return null;
    }

    Query query = em.createQuery("select c from CustomerPortalLoginConfiguration c where c.packageName=?1");
    query.setMaxResults(1).setParameter(1, packageName);

    List<CustomerPortalLoginConfiguration> cfgList = query.getResultList();

    CustomerPortalLoginConfiguration loginConfiguration = null;

    if ((cfgList != null) && (cfgList.size() > 0)) {
      loginConfiguration = cfgList.get(0);
    }

    if (loginConfiguration != null) {
      query = em.createQuery("select t from CustomerPortalLoginToken t left join t.labels l where t.id in ?1");
      query.setParameter(1, loginConfiguration.getTokenIds());
      // query.setParameter(2, language.trim());

      List<CustomerPortalLoginToken> tokens = query.getResultList();
      loginConfiguration.setLoginTokens(tokens, loginConfiguration.getTokenIds(), language);
    }

    return loginConfiguration;
  } // end method findCustomerPortalLoginConfigurationByName

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  CustomerPortalLoginConfigurationRepository#findLoginTokensByPackageName(String)
   */
  @Override public Set<CustomerPortalLoginToken> findLoginTokensByPackageName(String packageName) {
    return this.findLoginTokensByPackageName(packageName, DEFAULT_LANGUAGE);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  CustomerPortalLoginConfigurationRepository#findLoginTokensByPackageName(String,
   *       String)
   */
  @Override public Set<CustomerPortalLoginToken> findLoginTokensByPackageName(String packageName, String language) {
    CustomerPortalLoginConfiguration cfg = this.findCustomerPortalLoginConfigurationByName(packageName, language);

    if (cfg != null) {
      return cfg.getLoginTokens();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  CustomerPortalLoginConfigurationRepository#findResponsibleByExecuteLoginSQL(String,
   *       java.util.List)
   */
  @Override public List<Responsible> findResponsibleByExecuteLoginSQL(String loginSQL, List<Object> params) {
    Query query = em.createQuery(loginSQL);
    int   idx   = 1;

    for (Object param : params) {
      query.setParameter(idx, param);
      idx++;
    }

    List<Responsible> responsibles = query.getResultList();

    return responsibles;
  }

  @Override
  public List<Object> findByExecuteLoginSQL(String loginSQL, List<Object> params) {
    Query query = em.createQuery(loginSQL);
    int   idx   = 1;

    for (Object param : params) {
      query.setParameter(idx, param);
      idx++;
    }

    return query.getResultList();
  }
} // end class CustomerPortalLoginConfigurationRepositoryImpl
