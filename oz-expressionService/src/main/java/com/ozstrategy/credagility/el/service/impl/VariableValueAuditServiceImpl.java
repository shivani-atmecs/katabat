package com.ozstrategy.credagility.el.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;

import com.ozstrategy.credagility.core.domain.sor.VariableValueAudit;
import com.ozstrategy.credagility.core.domain.sor.VariableValueChangeAudit;
import com.ozstrategy.credagility.core.el.ElObject;
import com.ozstrategy.credagility.core.el.repository.VariableValueAuditRepository;
import com.ozstrategy.credagility.core.util.DataFormatter;
import com.ozstrategy.credagility.el.service.ExpressionService;
import com.ozstrategy.credagility.el.service.VariableValueAuditService;


/**
 * Created by coin on 6/28/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  06/28/2016 16:18
 */
@Service("variableValueAuditService")
@Transactional public class VariableValueAuditServiceImpl implements VariableValueAuditService {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired protected VariableValueAuditRepository variableValueAuditRepository;

  @Autowired private ExpressionService expressionService;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.VariableValueAuditService#auditAll(String, String,
   *       String, com.cmc.credagility.core.domain.responsible.Responsible,
   *       com.cmc.credagility.core.domain.account.Account, com.cmc.credagility.core.domain.user.User, String,
   *       com.ozstrategy.credagility.core.el.ElObject)
   */
  @Override public void auditAll(String varName, String context, String dataType, Responsible responsible,
    Account account, User agent, String triggerSource, ElObject elObject) {
    VariableValueAudit auditAll  = new VariableValueAudit();
    DataFormatter      formatter = new DataFormatter();

    auditAll.setVariableName(varName);
    auditAll.setContext(context);
    auditAll.setDataType(dataType);
    auditAll.setExecutor(agent);
    auditAll.setResponsible(responsible);
    auditAll.setAccount(account);
    auditAll.setTriggerSource(triggerSource);

    Object currentValue = evaluateCurrentValue(varName, elObject);

    auditAll.setCurrentValue((currentValue != null) ? formatter.format(currentValue) : "");
    variableValueAuditRepository.save(auditAll);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.VariableValueAuditService#auditChange(String, String,
   *       String, com.cmc.credagility.core.domain.responsible.Responsible,
   *       com.cmc.credagility.core.domain.account.Account, Object,com.cmc.credagility.core.domain.user.User,
   *       String, com.ozstrategy.credagility.core.el.ElObject)
   */
  @Override public Boolean auditChange(String varName, String context, String dataType,
    Responsible responsible, Account account, Object previousValue, User agent, String triggerSource,
    ElObject elObject) {
    DataFormatter formatter    = new DataFormatter();
    Object        currentValue = evaluateCurrentValue(varName, elObject);

    if ((previousValue != null) && (previousValue instanceof BigDecimal)) {
      previousValue = ((BigDecimal) previousValue).setScale(8, RoundingMode.HALF_UP);
    }

    String  previousValueStr = (previousValue != null) ? formatter.format(previousValue) : "";
    String  currentValueStr  = (currentValue != null) ? formatter.format(currentValue) : "";
    Boolean changed          = !previousValueStr.equals(currentValueStr);

    if (changed) {
      saveVariableValueAuditChange(varName, context, dataType, responsible, account, previousValueStr, currentValueStr,
        agent, triggerSource);
    }

    return changed;
  } // end method auditChange

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.el.service.VariableValueAuditService#auditChange(String, String, String, Responsible, Account, Object, Object, User,
   *       String)
   */
  @Override public Boolean auditChange(String varName, String context, String dataType,
    Responsible responsible, Account account, Object previousValue, Object currentValue, User agent,
    String triggerSource) {
    DataFormatter formatter = new DataFormatter();

    if ((previousValue != null) && (previousValue instanceof BigDecimal)) {
      previousValue = ((BigDecimal) previousValue).setScale(8, RoundingMode.HALF_UP);
    }

    if ((currentValue != null) && (currentValue instanceof BigDecimal)) {
      currentValue = ((BigDecimal) currentValue).setScale(8, RoundingMode.HALF_UP);
    }


    String  previousValueStr = (previousValue != null) ? formatter.format(previousValue) : "";
    String  currentValueStr  = (currentValue != null) ? formatter.format(currentValue) : "";
    Boolean changed          = !previousValueStr.equals(currentValueStr);

    if (changed) {
      saveVariableValueAuditChange(varName, context, dataType, responsible, account, previousValueStr, currentValueStr,
        agent, triggerSource);
    }

    return changed;
  } // end method auditChange

  //~ ------------------------------------------------------------------------------------------------------------------

  private Object evaluateCurrentValue(String varName, ElObject elObject) {
    Object currentValue = null;

    if (elObject != null) {
      currentValue = expressionService.evaluate(varName, elObject);

      if ((currentValue != null) && (currentValue instanceof BigDecimal)) {
        currentValue = ((BigDecimal) currentValue).setScale(8, RoundingMode.HALF_UP);
      }

    }

    return currentValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private void saveVariableValueAuditChange(String varName, String context, String dataType,
    Responsible responsible, Account account, String previousValueStr, String currentValueStr, User agent,
    String triggerSource) {
    VariableValueChangeAudit auditChange = new VariableValueChangeAudit();
    auditChange.setExecutor(agent);
    auditChange.setPreviousValue(previousValueStr);

    auditChange.setVariableName(varName);
    auditChange.setContext(context);
    auditChange.setDataType(dataType);
    auditChange.setResponsible(responsible);
    auditChange.setAccount(account);
    auditChange.setTriggerSource(triggerSource);
    auditChange.setCurrentValue(currentValueStr);
    variableValueAuditRepository.save(auditChange);
  }
} // end class VariableValueAuditServiceImpl
