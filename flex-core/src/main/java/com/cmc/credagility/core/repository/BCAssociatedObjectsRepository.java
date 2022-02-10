package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.businesscontext.BCAssociatedField;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:51
 */
public interface BCAssociatedObjectsRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------
  Long countCaseId(String caseId);
  /**
   * findObject.
   *
   * @param   <T>     List
   * @param   clazz   Class
   * @param   fields  List
   *
   * @return  T
   */
  <T> T findObject(Class<T> clazz, List<BCAssociatedField> fields);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account by original num.
   *
   * @param   originalAccountNum  String
   *
   * @return  Account
   */
  Account getAccountByOriginalNum(String originalAccountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max case id.
   *
   * @return  String
   */
  String getMaxCaseId();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max case id.
   *
   * @return  String
   */
  String getMaxUserLogon();
} // end interface BCAssociatedObjectsRepository
