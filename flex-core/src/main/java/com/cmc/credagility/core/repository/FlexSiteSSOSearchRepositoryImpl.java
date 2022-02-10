package com.cmc.credagility.core.repository;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import javax.persistence.Query;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.sso.FlexSiteSSOIntegrateConfig;
import com.cmc.credagility.core.domain.type.CustomerType;
import com.cmc.credagility.core.security.LoginCustomer;
import com.cmc.credagility.core.security.LoginUser;
import com.cmc.credagility.util.DateUtil;

import com.ozstrategy.credagility.core.repository.OzHibernateDaoSupport;


/**
 * Created by wenchaoyong on 2/21/17.
 *
 * @author   <a href="mailto:wenchao.yong@ozstrategy.com">Wenchao Yong</a>
 * @version  02/21/2017 11:23
 */
@Repository("flexSiteSsoSearchRepository")
public class FlexSiteSSOSearchRepositoryImpl extends OzHibernateDaoSupport implements FlexSiteSSOSearchRepository {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired protected ConfigurablePasswordEncryptor hashEncryptor;

  private Logger                          log                   = LoggerFactory.getLogger(this.getClass());
  @Resource private ResponsibleRepository responsibleRepository;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createLoginUser.
   *
   * @param   responsible             Responsible
   * @param   siteSSOIntegrateConfig  FlexSiteSSOIntegrateConfig
   *
   * @return  LoginUser
   */
  public LoginUser createLoginUser(Responsible responsible, FlexSiteSSOIntegrateConfig siteSSOIntegrateConfig) {
    Set<GrantedAuthority> dbAuthSet = new HashSet<GrantedAuthority>();
    dbAuthSet.add(loadUserAuthorities(responsible.getUserLogon()));

    Boolean active = Boolean.TRUE;
    log.info("default active flag is.." + active + " tag: " + siteSSOIntegrateConfig.getTag() + " allowWeb:"
      + responsible.getAccount().getAllowWeb());

    List<GrantedAuthority> dbAuthList = new ArrayList<GrantedAuthority>(dbAuthSet);

    if ("default".equalsIgnoreCase(siteSSOIntegrateConfig.getTag())
          || "smw".equalsIgnoreCase(siteSSOIntegrateConfig.getTag())) {
      // Base on the https://jira.cmcassist.com/browse/SMW-314 Point 2.
      if (Boolean.TRUE.equals(responsible.getCustomer().getActive())
            && Boolean.FALSE.equals(responsible.getResponsibleIndex().getDeleted())
            && ((responsible.getCustomerType() == null) || CustomerType.P.equals(responsible.getCustomerType())
              || CustomerType.G.equals(responsible.getCustomerType()))) {
        active = Boolean.TRUE;
      } else {
        active = Boolean.FALSE;
      }

      log.info("Allow web status: " + active);

    } else {
      if ((responsible.getAccount().getAllowWeb() != null)
            && !Boolean.TRUE.equals(responsible.getAccount().getAllowWeb())) {
        active = responsible.getAccount().getAllowWeb();
      }
    } // end if-else

    log.info("Allow web status: " + active);

    LoginUser user = new LoginUser(responsible.getUserLogon(), responsible.getFullName(), responsible.getZipCode(),
        responsible.getMotherMaidenName(), responsible.getSsnLast4(), active, true, true, true, dbAuthList,
        responsible.getUserLogon());

    if (log.isDebugEnabled()) {
      log.debug("Returning user..");
    }

    return user;
  } // end method createLoginUser

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  FlexSiteSSOSearchRepository#searchUserByQuerySql(com.cmc.credagility.core.domain.sso.FlexSiteSSOIntegrateConfig,
   *       java.util.Map)
   */
  @Override public UserDetails searchUserByQuerySql(FlexSiteSSOIntegrateConfig siteSSOIntegrateConfig,
    Map<String, String> tokenFieldMap) throws UsernameNotFoundException, DataAccessException {
    List<Responsible> responsibleList = null;

    if (siteSSOIntegrateConfig == null) {
      log.error("FlexSiteSSOIntegrateConfig is null. Throwing UsernameNotFoundException.");
      throw new UsernameNotFoundException("siteSSOIntegrateConfig is null.", new Throwable("NOTFOUND"));
    } else {
      log.info("Get Query");

      Query query = em.createQuery(siteSSOIntegrateConfig.getQuerySql());

      if ((tokenFieldMap != null)) {
        if (log.isDebugEnabled()) {
          log.debug("Loop through tokens..");
        }

        for (Object key : tokenFieldMap.keySet()) {
          log.info("Token Name:" + key.toString());

          if (log.isDebugEnabled()) {
            log.debug("Token Value:" + tokenFieldMap.get(key.toString()));
          }

          if ("dob".equalsIgnoreCase(key.toString()) || "dateOfBirth".equalsIgnoreCase(key.toString())) {
            try {
              if (log.isDebugEnabled()) {
                log.debug("Formatting tokens dob|dateOfBirth");
              }

              query.setParameter(key.toString(),
                DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tokenFieldMap.get(key.toString()) + " 00:00:00"));
            } catch (ParseException e) {
              log.error("Parsing Exception for token dob|dateOfBirth, expected format: yyyy-MM-dd HH:mm:ss");
              throw new UsernameNotFoundException("Login for '" + key.toString() + "' not found...",
                new Throwable("NOTFOUND"));
            }
          } else if ("originalAccountNumber".equalsIgnoreCase(key.toString())
                || "oan".equalsIgnoreCase(key.toString())) {
            if (log.isDebugEnabled()) {
              log.debug("Generating hash value");
            }

            String encryptedValue = hashEncryptor.encryptPassword(tokenFieldMap.get(key.toString()).toString());

            if (log.isDebugEnabled()) {
              log.debug("encryptedValue: " + encryptedValue);
            }

            query.setParameter(key.toString(), encryptedValue);
          } else {
            query.setParameter(key.toString(), tokenFieldMap.get(key.toString()));
          } // end if-else
        }   // end for
      }     // end if

      if (query.getResultList().size() > 0) {
        if (log.isDebugEnabled()) {
          log.debug("Query Result Successful");
        }

        responsibleList = query.getResultList();
      }

      if ((responsibleList != null) && !responsibleList.isEmpty()) {
        if (log.isDebugEnabled()) {
          log.debug("Get Customer/Responsible");
        }

        Customer    customer    = responsibleList.get(0).getCustomer();
        Responsible responsible = responsibleList.get(0);

        if (log.isDebugEnabled()) {
          log.debug("Context: " + siteSSOIntegrateConfig.getContext());
        }

        // create UserDetails
        if ("Customer".equalsIgnoreCase(siteSSOIntegrateConfig.getContext())) {
          if (log.isDebugEnabled()) {
            log.debug("Calling createLoginCustomer");
          }

          return createLoginCustomer(customer, responsible);
        } else if ("User".equalsIgnoreCase(siteSSOIntegrateConfig.getContext())) {
          if (log.isDebugEnabled()) {
            log.debug("Calling createLoginUser");
          }

          return createLoginUser(responsible, siteSSOIntegrateConfig);
        }
      } // end if
    }   // end if-else

    return null;
  } // end method searchUserByQuerySql

  //~ ------------------------------------------------------------------------------------------------------------------

  private LoginCustomer createLoginCustomer(Customer customer, Responsible responsible) {
    Set<GrantedAuthority> dbAuthSet = new HashSet<GrantedAuthority>();
    dbAuthSet.add(loadUserAuthorities(customer.getUcid()));
    log.info("UCID Number: " + customer.getUcid());

    List<GrantedAuthority> dbAuthList = new ArrayList<GrantedAuthority>(dbAuthSet);

    Long         allowWebAccounts = responsibleRepository.countCustomerAllowWebAccounts(
        customer.getCustomerId());
    List<String> userLogonList    = responsibleRepository.getUserLogonByResponsibleIndexCustomerCustomerId(
        customer.getCustomerId());
    boolean      active           = allowWebAccounts.longValue() > 0;

    if (log.isDebugEnabled()) {
      log.debug("Allow web status: " + active + " with userLogonList size: "
        + ((userLogonList != null) ? userLogonList.size() : 0));
    }

    LoginCustomer user = new LoginCustomer(customer.getCustomerId(), customer.getFullName(), active, true, true, true,
        dbAuthList, userLogonList, responsible.getUserLogon());

    if (log.isDebugEnabled()) {
      log.debug("Returning user..");
    }

    return user;
  } // end method createLoginCustomer

  //~ ------------------------------------------------------------------------------------------------------------------

  private GrantedAuthority loadUserAuthorities(String username) {
    String                 roleName  = "ROLE_USER";
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleName);

    return authority;
  }
} // end class FlexSiteSSOSearchRepositoryImpl
