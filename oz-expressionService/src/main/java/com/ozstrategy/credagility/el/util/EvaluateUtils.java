package com.ozstrategy.credagility.el.util;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountAuthorizedContact;
import com.cmc.credagility.core.domain.account.AccountAuthorizedUser;
import com.cmc.credagility.core.domain.program.ProgramRule;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.RoundType;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agent.AgentWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowStep;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep;
import com.ozstrategy.credagility.core.domain.workflow.responsible.ResponsibleWorkflowBusinessObject;
import com.ozstrategy.credagility.core.el.ElObject;
import com.ozstrategy.credagility.el.context.accountauthorizedcontact.AccountAuthContactElObject;
import com.ozstrategy.credagility.el.context.accountauthorizeduser.AccountAuthUserElObject;
import com.ozstrategy.credagility.el.context.agency.AgencyElObject;
import com.ozstrategy.credagility.el.context.agent.AgentElObject;
import com.ozstrategy.credagility.el.context.businesscontextinstance.BCIElObject;
import com.ozstrategy.credagility.el.context.global.GlobalElObject;
import com.ozstrategy.credagility.el.context.responsible.ResponsibleElObject;
import com.ozstrategy.credagility.el.service.ExpressionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 * @User:    Wang Yang
 * @Date:    13-5-6
 * @Time:    PM6:11
 */
public class EvaluateUtils {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final transient Logger logger = LoggerFactory.getLogger(EvaluateUtils.class);

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expression         DOCUMENT ME!
   * @param   roundType          DOCUMENT ME!
   * @param   responsible        DOCUMENT ME!
   * @param   expressionService  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static BigDecimal[] calculateExprAmounts(String expression,
    RoundType roundType, Responsible responsible, ExpressionService expressionService) {
    return calculateExprAmounts(expression, roundType, responsible, null,
        expressionService);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expressions        DOCUMENT ME!
   * @param   roundType          DOCUMENT ME!
   * @param   responsible        DOCUMENT ME!
   * @param   expressionService  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static BigDecimal[] calculateExprAmounts(String[] expressions,
    RoundType roundType, Responsible responsible,
    ExpressionService expressionService) {
    return calculateExprAmounts(expressions, roundType, responsible, null,
        expressionService);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expression         DOCUMENT ME!
   * @param   roundType          DOCUMENT ME!
   * @param   responsible        DOCUMENT ME!
   * @param   extraValues        DOCUMENT ME!
   * @param   expressionService  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static BigDecimal[] calculateExprAmounts(String expression,
    RoundType roundType, Responsible responsible, Map<String, Object> extraValues,
    ExpressionService expressionService) {
    if ((expression == null) || (expression.trim().length() == 0)) {
      return null;
    }

    String[] parts = StringUtils.delimitedListToStringArray(expression,
        ProgramRule.expressionDelimiter);
    int      size  = parts.length;

    if (size == 0) {
      return null;
    }

    Map<String, BigDecimal> c               = new HashMap<String, BigDecimal>();
    BigDecimal[]            values          = new BigDecimal[size];
    String                  totalExpression = "(" + parts[0] + ")";
    BigDecimal              total;
    ResponsibleElObject     obj             = new ResponsibleElObject(
        responsible);

    for (int i = 0; i < size; i++) {
      if ((i + 1) < size) {
        totalExpression = totalExpression + " + (" + parts[i + 1] + ")";
      }

      try {
        if (c.containsKey(parts[i])) {
          values[i] = c.get(parts[i]);
        } else {
          values[i] = expressionService.evaluate(parts[i], obj,
              extraValues, BigDecimal.class);
          c.put(parts[i], values[i]);
        }
      } catch (Exception e) {
        values[i] = BigDecimal.ZERO;

        String msg = "Expression:'" + parts[i] + "' for Account("
          + responsible.getAccount().getAccountNum() + ")";
        logger.error(msg, e);
      }
    } // end for

    try {
      total = expressionService.evaluate((totalExpression), obj,
          extraValues, BigDecimal.class);
    } catch (Exception e) {
      total = null;

      String msg = "Total Expression:'" + totalExpression
        + "' for Account(" + responsible.getAccount().getAccountNum()
        + ")";
      logger.error(msg, e);
    }

    if (total == null) {
      return null;
    }

    // Adjust amount based on the rounding methods
    BigDecimal temp = BigDecimal.ZERO;

    switch (roundType) {
      case CENTS_UP: {
        for (int i = 0; i < size; i++) {
          values[i] = values[i].setScale(2, BigDecimal.ROUND_UP);
        }

        break;
      }

      case DOLLARS_UP: {
        for (int i = 0; i < size; i++) {
          values[i] = values[i].setScale(0, BigDecimal.ROUND_UP);
        }

        break;
      }

      case REMAINDER_FIRST: {
        for (int i = 0; i < size; i++) {
          values[i] = values[i].setScale(2, BigDecimal.ROUND_HALF_DOWN);
          temp      = temp.add(values[i]);
        }

        if (total != null) {
          total     = total.setScale(2, BigDecimal.ROUND_HALF_UP);
          values[0] = values[0].add(total.subtract(temp));
        }

        break;
      }

      case SPREAD_REMAINDER:
      default: {
        for (int i = 0; i < size; i++) {
          values[i] = values[i].setScale(2, BigDecimal.ROUND_HALF_DOWN);
          temp      = temp.add(values[i]);
        }

        if (total != null) {
          total = total.setScale(2, BigDecimal.ROUND_HALF_UP);

          BigDecimal oneCent   = new BigDecimal("0.01");
          BigDecimal remainder = total.subtract(temp);

          for (int i = 0; i < size; i++) {
            if (remainder.compareTo(BigDecimal.ZERO) > 0) {
              values[i] = values[i].add(oneCent);
              remainder = remainder.subtract(oneCent);
            }
          }
        }

        break;
      }
    } // end switch

    return values;
  } // end method calculateExprAmounts

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expressions        DOCUMENT ME!
   * @param   roundType          DOCUMENT ME!
   * @param   responsible        DOCUMENT ME!
   * @param   extraValues        DOCUMENT ME!
   * @param   expressionService  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static BigDecimal[] calculateExprAmounts(String[] expressions,
    RoundType roundType, Responsible responsible, Map<String, Object> extraValues,
    ExpressionService expressionService) {
    if ((expressions == null) || (expressions.length == 0)) {
      return null;
    }

    int size = expressions.length;

    Map<String, BigDecimal> c               = new HashMap<String, BigDecimal>();
    BigDecimal[]            values          = new BigDecimal[size];
    String                  totalExpression = "(" + expressions[0] + ")";
    BigDecimal              total;
    ResponsibleElObject     obj             = new ResponsibleElObject(
        responsible);

    for (int i = 0; i < size; i++) {
      if ((i + 1) < size) {
        totalExpression = totalExpression + " + ("
          + expressions[i + 1] + ")";
      }

      try {
        if (c.containsKey(expressions[i])) {
          values[i] = c.get(expressions[i]);
        } else {
          values[i] = expressionService.evaluate(expressions[i], obj,
              extraValues, BigDecimal.class);
          c.put(expressions[i], values[i]);
        }
      } catch (Exception e) {
        values[i] = BigDecimal.ZERO;

        String msg = "Expression:'" + expressions[i]
          + "' for Account("
          + responsible.getAccount().getAccountNum() + ")";
        logger.error(msg, e);
      }
    } // end for

    try {
      total = expressionService.evaluate((totalExpression), obj,
          extraValues, BigDecimal.class);
    } catch (Exception e) {
      total = null;

      String msg = "Total Expression:'" + totalExpression
        + "' for Account(" + responsible.getAccount().getAccountNum()
        + ")";
      logger.error(msg, e);
    }

    if (total == null) {
      return null;
    }

    // Adjust amount based on the rounding methods
    BigDecimal temp = BigDecimal.ZERO;

    switch (roundType) {
      case CENTS_UP: {
        for (int i = 0; i < size; i++) {
          values[i] = values[i].setScale(2, BigDecimal.ROUND_UP);
        }

        break;
      }

      case DOLLARS_UP: {
        for (int i = 0; i < size; i++) {
          values[i] = values[i].setScale(0, BigDecimal.ROUND_UP);
        }

        break;
      }

      case REMAINDER_FIRST: {
        for (int i = 0; i < size; i++) {
          values[i] = values[i].setScale(2, BigDecimal.ROUND_DOWN);
          temp      = temp.add(values[i]);
        }

        if (total != null) {
          total     = total.setScale(2, BigDecimal.ROUND_HALF_UP);
          values[0] = values[0].add(total.subtract(temp));
        }

        break;
      }

      case SPREAD_REMAINDER:
      default: {
        for (int i = 0; i < size; i++) {
          values[i] = values[i].setScale(2, BigDecimal.ROUND_DOWN);
          temp      = temp.add(values[i]);
        }

        if (total != null) {
          total = total.setScale(2, BigDecimal.ROUND_HALF_UP);

          BigDecimal oneCent   = new BigDecimal("0.01");
          BigDecimal remainder = total.subtract(temp);

          for (int i = 0; i < size; i++) {
            if (remainder.compareTo(BigDecimal.ZERO) > 0) {
              values[i] = values[i].add(oneCent);
              remainder = remainder.subtract(oneCent);
            }
          }
        }

        break;
      }
    } // end switch

    return values;
  } // end method calculateExprAmounts

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   totalAmountExpression  DOCUMENT ME!
   * @param   installments           DOCUMENT ME!
   * @param   roundType              DOCUMENT ME!
   * @param   responsible            DOCUMENT ME!
   * @param   extraValues            DOCUMENT ME!
   * @param   expressionService      DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static BigDecimal[] calculateExprAmounts(
    String totalAmountExpression, int installments, RoundType roundType,
    Responsible responsible, Map<String, Object> extraValues,
    ExpressionService expressionService) {
    if (!StringUtils.hasText(totalAmountExpression)) {
      return null;
    }

    BigDecimal[]            values = new BigDecimal[installments];
    BigDecimal              total;
    ResponsibleElObject     obj    = new ResponsibleElObject(
        responsible);

    try {
      total = expressionService.evaluate((totalAmountExpression), obj,
          extraValues, BigDecimal.class);
    } catch (Exception e) {
      total = null;

      String msg = "Total Expression:'" + totalAmountExpression
        + "' for Account(" + responsible.getAccount().getAccountNum()
        + ")";
      logger.error(msg, e);
    }

    if (total == null) {
      return null;
    }

    // Adjust amount based on the rounding methods
    BigDecimal temp = BigDecimal.ZERO;

    switch (roundType) {
      case CENTS_UP: {
        BigDecimal r = total.setScale(2, BigDecimal.ROUND_UP);

        for (int i = 0; i < installments; i++) {
          values[i] = r.divide(new BigDecimal(installments - i), 2,
              BigDecimal.ROUND_UP);
          r         = r.subtract(values[i]);
        }

        break;
      }

      case DOLLARS_UP: {
        BigDecimal r = total.setScale(0, BigDecimal.ROUND_UP);

        for (int i = 0; i < installments; i++) {
          values[i] = r.divide(new BigDecimal(installments - i), 0,
              BigDecimal.ROUND_UP);
          r         = r.subtract(values[i]);
        }

        break;
      }

      case REMAINDER_FIRST: {
        total = total.setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal ins = total.divide(new BigDecimal(installments), 2,
            BigDecimal.ROUND_DOWN);

        for (int i = 0; i < installments; i++) {
          values[i] = ins;
          temp      = temp.add(values[i]);
        }

        values[0] = values[0].add(total.subtract(temp));

        break;
      }

      case SPREAD_REMAINDER:
      default: {
        total = total.setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal ins = total.divide(new BigDecimal(installments), 2,
            BigDecimal.ROUND_DOWN);

        for (int i = 0; i < installments; i++) {
          values[i] = ins;
          temp      = temp.add(values[i]);
        }

        BigDecimal oneCent   = new BigDecimal("0.01");
        BigDecimal remainder = total.subtract(temp);

        for (int i = 0; i < installments; i++) {
          if (remainder.compareTo(BigDecimal.ZERO) > 0) {
            values[i] = values[i].add(oneCent);
            remainder = remainder.subtract(oneCent);
          }
        }

        break;
      }
    } // end switch

    return values;
  } // end method calculateExprAmounts

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   businessObject  DOCUMENT ME!
   * @param   workflowStep    DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static ElObject createEvaluateObject(
    WorkflowBusinessObject businessObject, BasicWorkflowStep workflowStep) {
    if (businessObject instanceof AgentWorkflowBusinessObject) {
      AgentElObject obj = new AgentElObject(
          ((AgentWorkflowBusinessObject) businessObject).getAgent());
      obj.setWorkflowStep((WorkflowStep) workflowStep);
      obj.setBusinessObject(businessObject);

      return obj;
    } else if (businessObject instanceof AgencyWorkflowBusinessObject) {
      AgencyElObject obj = new AgencyElObject(
          ((AgencyWorkflowBusinessObject) businessObject).getAgency());
      obj.setWorkflowStep((WorkflowStep) workflowStep);
      obj.setBusinessObject(businessObject);

      return obj;
    } else if (businessObject instanceof BCIWorkflowBusinessObject) {
      BCIElObject obj = new BCIElObject(((BCIWorkflowBusinessObject) businessObject).getContext(), ((BCIWorkflowBusinessObject) businessObject).getBci(),
          (BCIWorkflowStep) workflowStep);
      obj.setBusinessObject(businessObject);

      return obj;
    } else if (businessObject instanceof ResponsibleWorkflowBusinessObject) {
      ResponsibleElObject obj = new ResponsibleElObject(((ResponsibleWorkflowBusinessObject) businessObject)
          .getResponsible());
      obj.setBusinessObject(businessObject);

      return obj;
    } // end if-else

    return new GlobalElObject();
  } // end method createEvaluateObject

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   expressionService       DOCUMENT ME!
   * @param   jurisdictionExpression  DOCUMENT ME!
   * @param   context                 DOCUMENT ME!
   * @param   T                       DOCUMENT ME!
   * @param   phoneNumber             DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Boolean evaluateJurisdictionExpression(
    ExpressionService expressionService, String jurisdictionExpression,
    Object context, Class T, String phoneNumber) {
    Map<String, Object> extraMap = new HashMap<String, Object>();

    if (phoneNumber != null) {
      extraMap.put("phoneNumber", phoneNumber);
    }

    Object result = null;

    if (T == Account.class) {
      // eval AccountLevel expression
      if ((context != null) && (context instanceof Account)) {
        Account             account        = (Account) context;
        ResponsibleElObject evaluateObject = new ResponsibleElObject(account);
        result = expressionService.evaluate((jurisdictionExpression),
            evaluateObject, (extraMap.size() > 0) ? extraMap : null,
            Boolean.class);

      }
    } else if (T == Responsible.class) {
      if ((context != null) && (context instanceof Responsible)) {
        Responsible         responsible    = (Responsible) context;
        ResponsibleElObject evaluateObject = new ResponsibleElObject(responsible);
        result = expressionService.evaluate((jurisdictionExpression),
            evaluateObject, (extraMap.size() > 0) ? extraMap : null,
            Boolean.class);
      }
    } else if (T == AccountAuthorizedContact.class) {
      if ((context != null)
            && (context instanceof AccountAuthorizedContact)) {
        AccountAuthorizedContact   contact        = (AccountAuthorizedContact) context;
        AccountAuthContactElObject evaluateObject = new AccountAuthContactElObject(contact);
        result = expressionService.evaluate((jurisdictionExpression),
            evaluateObject, (extraMap.size() > 0) ? extraMap : null,
            Boolean.class);

      }
    } else if (T == AccountAuthorizedUser.class) {
      if ((context != null)
            && (context instanceof AccountAuthorizedUser)) {
        AccountAuthorizedUser   authorizedUser = (AccountAuthorizedUser) context;
        AccountAuthUserElObject evaluateObject = new AccountAuthUserElObject(authorizedUser);
        result = expressionService.evaluate((jurisdictionExpression),
            evaluateObject, (extraMap.size() > 0) ? extraMap : null,
            Boolean.class);
      }
    } // end if-else

    if (result != null) {
      return (Boolean) result;
    }

    return Boolean.FALSE;
  } // end method evaluateJurisdictionExpression
} // end class EvaluateUtils
