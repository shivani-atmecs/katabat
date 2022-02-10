package com.cmc.credagility.core.domain.util;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:15
 */
public class MRAAccountUtil implements InitializingBean, Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 4687067031607290333L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Map<String, Account> mraAccountMap;

  private List<Account> mraAccounts;

  private List<Account> mraActiveAccounts;

  private List<Responsible> mraActiveResponsibles;

  private Map<String, Responsible> mraResponsibleMap;

  private List<Responsible> mraResponsibles;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
   */
  @Override public void afterPropertiesSet() throws Exception { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mra account map.
   *
   * @return  Map
   */
  public Map<String, Account> getMraAccountMap() {
    return mraAccountMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mra accounts.
   *
   * @return  List
   */
  public List<Account> getMraAccounts() {
    return mraAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mra active accounts.
   *
   * @return  List
   */
  public List<Account> getMraActiveAccounts() {
    return mraActiveAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mra active responsibles.
   *
   * @return  List
   */
  public List<Responsible> getMraActiveResponsibles() {
    return mraActiveResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mra responsible map.
   *
   * @return  Map
   */
  public Map<String, Responsible> getMraResponsibleMap() {
    return mraResponsibleMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mra responsibles.
   *
   * @return  List
   */
  public List<Responsible> getMraResponsibles() {
    return mraResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mra account map.
   *
   * @param  mraAccountMap  Map
   */
  public void setMraAccountMap(Map<String, Account> mraAccountMap) {
    this.mraAccountMap = mraAccountMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mra accounts.
   *
   * @param  mraAccounts  List
   */
  public void setMraAccounts(List<Account> mraAccounts) {
    this.mraAccounts = mraAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mra active accounts.
   *
   * @param  mraActiveAccounts  List
   */
  public void setMraActiveAccounts(List<Account> mraActiveAccounts) {
    this.mraActiveAccounts = mraActiveAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mra active responsibles.
   *
   * @param  mraActiveResponsibles  List
   */
  public void setMraActiveResponsibles(List<Responsible> mraActiveResponsibles) {
    this.mraActiveResponsibles = mraActiveResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mra responsible map.
   *
   * @param  mraResponsibleMap  Map
   */
  public void setMraResponsibleMap(Map<String, Responsible> mraResponsibleMap) {
    this.mraResponsibleMap = mraResponsibleMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mra responsibles.
   *
   * @param  mraResponsibles  List
   */
  public void setMraResponsibles(List<Responsible> mraResponsibles) {
    this.mraResponsibles = mraResponsibles;
  }
} // end class MRAAccountUtil
