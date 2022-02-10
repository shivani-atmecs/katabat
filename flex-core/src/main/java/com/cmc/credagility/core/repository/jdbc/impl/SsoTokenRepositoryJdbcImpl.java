package com.cmc.credagility.core.repository.jdbc.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Profile;

import org.springframework.stereotype.Component;

import com.cmc.credagility.core.repository.jdbc.SsoTokenRepositoryJdbc;


/**
 * Created by lihao1 on 1/15/16.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  05/20/2016 16:02
 */
@Component("ssoTokenRepositoryJdbc")
@Profile("jdbc")
public class SsoTokenRepositoryJdbcImpl extends BaseJdbcRepositoryImpl implements SsoTokenRepositoryJdbc {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired(required = false)
  ConfigurablePasswordEncryptor hashEncryptor;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseJdbcRepositoryImpl object.
   *
   * @param  dataSource  DataSource
   */
  @Autowired public SsoTokenRepositoryJdbcImpl(DataSource dataSource) {
    super(dataSource);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.repository.jdbc.SsoTokenRepositoryJdbc#getLoginInformation(String)
   */
  @Override public Map<String, Object> getLoginInformation(String ucid) {
    String sql = "SELECT "
      + "r.responsibleId,"
      + "r.firstName,r.lastName,r.dateOfBirth,"
      + "ai.last4OriginalAccountNumber "
      + "FROM "
      + "Responsible r "
      + "INNER JOIN ResponsibleIndex ri ON ri.responsibleId = r.responsibleId "
      + "INNER JOIN Account a ON a.accountNum = r.accountNum "
      + "INNER JOIN AccountIndex ai ON a.accountNum = ai.accountNum "
      + "INNER JOIN Customer c on ri.customerInfoId=c.customerId "
      + "WHERE "
      + "a.active = 'Y' and c.ucid=?  order by r.primaryHolder desc limit 1";

    if (logger.isDebugEnabled()) {
      logger.debug("getLoginInformation sql is-->" + sql + ">>>params[ucid=" + ucid + "]");
    }

    List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql, ucid);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  } // end method getLoginInformation

  /**
   * @see  com.cmc.credagility.core.repository.jdbc.SsoTokenRepositoryJdbc#getLoginInformationByUCID(String)
   */
  @Override public Map<String, Object> getLoginInformationByUCID(String ucid) {
    String sql = "SELECT "
            + "r.responsibleId,"
            + "r.firstName,r.lastName,r.dateOfBirth,"
            + "ai.last4OriginalAccountNumber "
            + "FROM "
            + "Responsible r "
            + "INNER JOIN ResponsibleIndex ri ON ri.responsibleId = r.responsibleId "
            + "INNER JOIN Account a ON a.accountNum = r.accountNum "
            + "INNER JOIN AccountIndex ai ON a.accountNum = ai.accountNum "
            + "INNER JOIN Customer c on ri.customerInfoId=c.customerId "
            + "WHERE "
            + "ri.responsibleDeleteDate is NULL and a.active='Y' and a.allowWeb='Y' "
            + "and c.ucid=?  order by r.primaryHolder desc limit 1";

    if (logger.isDebugEnabled()) {
      logger.debug("getLoginInformationByUCID sql is-->" + sql + ">>>params[ucid=" + ucid + "]");
    }

    List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql, ucid);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  } // end method getLoginInformationByUCID

  @Override
  public Map<String, Object> getLoginInformationByOANHash(String oanHash) {
    String sql = "SELECT "
            + "r.responsibleId,"
            + "r.firstName,r.lastName,r.dateOfBirth,"
            + "ai.last4OriginalAccountNumber "
            + "FROM "
            + "Responsible r "
            + "INNER JOIN ResponsibleIndex ri ON ri.responsibleId = r.responsibleId "
            + "INNER JOIN Account a ON a.accountNum = r.accountNum "
            + "INNER JOIN AccountIndex ai ON a.accountNum = ai.accountNum "
            + "WHERE "
            + "ri.responsibleDeleteDate is NULL and a.active='Y' and a.allowWeb='Y' "
            + "and ai.originalAccountNumberHash=?  and r.primaryHolder='Y' "
            + "order by r.primaryHolder desc limit 1";

    if (logger.isDebugEnabled()) {
      logger.debug("getLoginInformation sql is-->" + sql + ">>>params[originalAccountNumberHash=" + oanHash + "]");
    }

    List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql, oanHash);

    if (!list.isEmpty()) {
      return list.get(0);
    }
    return null;
  }

  @Override
  public Map<String, Object> getLoginInformationBySsnHash(String ssnHash) {
    String sql = "SELECT "
            + "r.responsibleId,"
            + "r.firstName,r.lastName,r.dateOfBirth,"
            + "ai.last4OriginalAccountNumber "
            + "FROM "
            + "Responsible r "
            + "INNER JOIN ResponsibleIndex ri ON ri.responsibleId = r.responsibleId "
            + "INNER JOIN Account a ON a.accountNum = r.accountNum "
            + "INNER JOIN AccountIndex ai ON a.accountNum = ai.accountNum "
            + "WHERE "
            + "ri.responsibleDeleteDate is NULL and a.active='Y' and a.allowWeb='Y' "
            + "and ri.ssnHash=?  order by r.primaryHolder desc limit 1";

    if (logger.isDebugEnabled()) {
      logger.debug("getLoginInformationBySsnHash sql is-->" + sql + ">>>params[ssnHash=" + ssnHash + "]");
    }

    List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql, ssnHash);

    if (!list.isEmpty()) {
      return list.get(0);
    }
    return null;
  }
  @Override
  public Map<String, Object> getLoginInformationByUCIDAndOANHash(String ucid, String oanHash){
    String sql = "SELECT "
            + "r.responsibleId,"
            + "r.firstName,r.lastName,r.dateOfBirth,"
            + "ai.last4OriginalAccountNumber "
            + "FROM "
            + "Responsible r "
            + "INNER JOIN ResponsibleIndex ri ON ri.responsibleId = r.responsibleId "
            + "INNER JOIN Account a ON a.accountNum = r.accountNum "
            + "INNER JOIN AccountIndex ai ON a.accountNum = ai.accountNum "
            + "INNER JOIN Customer c on ri.customerInfoId=c.customerId "
            + "WHERE "
            + "ri.responsibleDeleteDate is NULL and a.active='Y' and a.allowWeb='Y' "
            + "and c.ucid=?  and ai.originalAccountNumberHash=? "
            + "order by r.primaryHolder desc limit 1";

    if (logger.isDebugEnabled()) {
      logger.debug("getLoginInformationByUCIDAndOANHash sql is-->" + sql
              + ">>>params[ucid=" + ucid + ", oanHash=" + oanHash + "]");
    }

    List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql, ucid, oanHash);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  }
  @Override
  public Map<String, Object> getLoginInformationByUCIDAndSsnHash(String ucid, String ssnHash){
    String sql = "SELECT "
            + "r.responsibleId,"
            + "r.firstName,r.lastName,r.dateOfBirth,"
            + "ai.last4OriginalAccountNumber "
            + "FROM "
            + "Responsible r "
            + "INNER JOIN ResponsibleIndex ri ON ri.responsibleId = r.responsibleId "
            + "INNER JOIN Account a ON a.accountNum = r.accountNum "
            + "INNER JOIN AccountIndex ai ON a.accountNum = ai.accountNum "
            + "INNER JOIN Customer c on ri.customerInfoId=c.customerId "
            + "WHERE "
            + "ri.responsibleDeleteDate is NULL and a.active='Y' and a.allowWeb='Y' "
            + "and c.ucid=? and ri.ssnHash=? "
            + "order by r.primaryHolder desc limit 1";

    if (logger.isDebugEnabled()) {
      logger.debug("getLoginInformationByUCIDAndSsnHash sql is-->" + sql
              + ">>>params[ucid=" + ucid + ", ssnHash="+ ssnHash + "]");
    }

    List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql, ucid, ssnHash);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  }
  @Override
  public Map<String, Object> getLoginInformationByOANHashAndSsnHash(String oanHash, String ssnHash){
    String sql = "SELECT "
            + "r.responsibleId,"
            + "r.firstName,r.lastName,r.dateOfBirth,"
            + "ai.last4OriginalAccountNumber "
            + "FROM "
            + "Responsible r "
            + "INNER JOIN ResponsibleIndex ri ON ri.responsibleId = r.responsibleId "
            + "INNER JOIN Account a ON a.accountNum = r.accountNum "
            + "INNER JOIN AccountIndex ai ON a.accountNum = ai.accountNum "
            + "WHERE "
            + "ri.responsibleDeleteDate is NULL and a.active='Y' and a.allowWeb='Y' "
            + "and ai.originalAccountNumberHash=?  and ri.ssnHash=? "
            + "order by r.primaryHolder desc limit 1";

    if (logger.isDebugEnabled()) {
      logger.debug("getLoginInformationByOANHashAndSsnHash sql is-->" + sql
              + ">>>params[oanHash=" + oanHash + ", ssnHash="+ ssnHash + "]");
    }

    List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql, oanHash, ssnHash);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  }
  @Override
  public Map<String, Object> getLoginInformationByUCIDAndOANHashAndSsnHash(String ucid, String oanHash, String ssnHash){
    String sql = "SELECT "
            + "r.responsibleId,"
            + "r.firstName,r.lastName,r.dateOfBirth,"
            + "ai.last4OriginalAccountNumber "
            + "FROM "
            + "Responsible r "
            + "INNER JOIN ResponsibleIndex ri ON ri.responsibleId = r.responsibleId "
            + "INNER JOIN Account a ON a.accountNum = r.accountNum "
            + "INNER JOIN AccountIndex ai ON a.accountNum = ai.accountNum "
            + "INNER JOIN Customer c on ri.customerInfoId=c.customerId "
            + "WHERE "
            + "ri.responsibleDeleteDate is NULL and a.active='Y' and a.allowWeb='Y' "
            + "and c.ucid=?  and ai.originalAccountNumberHash=? and ri.ssnHash=? "
            + "order by r.primaryHolder desc limit 1";

    if (logger.isDebugEnabled()) {
      logger.debug("getLoginInformationByUCIDAndOANHashAndSsnHash sql is-->" + sql
              + ">>>params[ucid=" + ucid + ", oanHash=" + oanHash + ", ssnHash="+ ssnHash + "]");
    }

    List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql, ucid, oanHash, ssnHash);

    if (!list.isEmpty()) {
      return list.get(0);
    }

    return null;
  }
} // end class SsoTokenRepositoryJdbcImpl
