package com.ozstrategy.credagility.el.service;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;

import com.ozstrategy.credagility.core.el.ElObject;


/**
 * Created by coin on 6/28/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  06/28/2016 16:17
 */
public interface VariableValueAuditService {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * auditAll.
   *
   * @param  varName        String
   * @param  context        String
   * @param  dataType       String
   * @param  responsible    Responsible
   * @param  account        Account
   * @param  agent          User
   * @param  triggerSource  String
   * @param  elObject       ElObject
   */
  void auditAll(String varName, String context, String dataType, Responsible responsible, Account account,
    User agent, String triggerSource, ElObject elObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * auditChange.
   *
   * @param   varName        Long
   * @param   context        String
   * @param   dataType       String
   * @param   responsible    Long
   * @param   account        Long
   * @param   previousValue  String
   * @param   agent          changer User
   * @param   triggerSource  String
   * @param   elObject       ElObject
   *
   * @return  auditChange.
   */
  Boolean auditChange(String varName, String context, String dataType, Responsible responsible,
    Account account, Object previousValue, User agent, String triggerSource, ElObject elObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * auditChange.
   *
   * @param   varName        String
   * @param   context        String
   * @param   dataType       String
   * @param   responsible    Responsible
   * @param   account        Account
   * @param   previousValue  Object
   * @param   currentValue   Object
   * @param   agent          User
   * @param   triggerSource  String
   *
   * @return  Boolean
   */
  Boolean auditChange(String varName, String context, String dataType, Responsible responsible,
    Account account, Object previousValue, Object currentValue, User agent, String triggerSource);

} // end interface VariableValueAuditService
