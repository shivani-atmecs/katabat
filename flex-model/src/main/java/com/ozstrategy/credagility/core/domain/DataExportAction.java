package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountExportLayout;
import com.cmc.credagility.core.domain.account.AccountExportLayoutColumn;
import com.cmc.credagility.core.domain.dataexport.DataExportResult;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.ChannelResultStatus;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowTriggerSource;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;


/**
 * Created by yongliu on 2/17/17.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  02/17/2017 12:53
 */
@Entity
@Table(name = "DataExportAction")
public class DataExportAction extends PortfolioBaseNodeAction {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long   serialVersionUID = -547814518339891377L;
  private static final String STRING           = "String";
  private static final String INTEGER          = "Integer";
  private static final String BOOLEAN          = "Boolean";
  private static final String BIGDECIMAL       = "BigDecimal";
  private static final String LONG             = "Long";
  private static final String DATE             = "Date";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Data Export Action Template (used Configuration Manager--> File Layout). */
  @JoinColumn(
    name     = "accountExportLayoutId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountExportLayout accountExportLayout;

  /** DOCUMENT ME! */
  @ManyToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "nodeDataExportActions"
  )
  protected Set<Node> dataExportNodes = new LinkedHashSet<Node>();

  /** TODO: DOCUMENT ME! */
  protected Boolean visible;

  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  @Transient private Set<Long> processedAccounts = new HashSet<Long>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for serial version UID.
   *
   * @return  long
   */
  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Executable#beforeExecute()
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculate.
   *
   * @param   helper  EvaluateHelper
   *
   * @return  Object
   */
  public Object calculate(EvaluateHelper helper) {
    return helper.calculate(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseNodeAction#duplicate()
   */
  @Override public BaseNodeAction duplicate() {
    DataExportAction dataExportAction = new DataExportAction();
    dataExportAction.updateNodeAction(this);
    dataExportAction.setActionType(BaseNodeAction.ActionType_DATAEXPORT);
    dataExportAction.setPortfolio(this.getPortfolio());
    dataExportAction.setAccountExportLayout(this.getAccountExportLayout());

    return dataExportAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Executable#execute(com.ozstrategy.credagility.core.helper.EvaluateHelper,
   *       com.ozstrategy.credagility.core.helper.ExecuteHelper)
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    if (evaluate(evaluateHelper)) {
      Map<String, Object>           params      = executeHelper.getParameters();
      Date                          today       = DateUtil.toDateOnly(new Date());
      String                        source      = null;
      RunType                       runType     = (RunType) params.get("runType");
      Account                       account     = (Account) params.get("account");
      Node                          node        = (Node) params.get("currentNode");
      Long                          batchId     = (params.get("batchId") != null)
        ? Long.parseLong((String) params.get("batchId")) : new Date().getTime();
      SurveyFlowStep                flowStep    = (SurveyFlowStep) params.get("flowStep");
      WorkflowNodeActionTriggerType triggerType = (WorkflowNodeActionTriggerType) params.get(
          "triggerType");
      User                          executor    = (User) params.get("executor");
      Responsible                   responsible = (Responsible) params.get("responsible");
      boolean                       deltaBatch  = (Boolean) params.get("deltaBatch");

      if (runType.isBatch()) {
        source = "BATCH";
      } else if (runType.isCID()) {
        source = "CID";
      } else if (runType.isEvent()) {
        source = "CID";
      } else if ((flowStep != null) || (triggerType != null)) {
        source = WorkflowTriggerSource.AGENCY.toString();
      }

      if ((source != null) && runType.isDataExport()) {
        this.triggered = true;

        if (deltaBatch) {
          if (logger.isDebugEnabled()) {
            logger.debug("create data export result from deltaBatch file.");
          }
        }

        Long accountNum = account.getAccountNum();

        // skip this account if it was processed before
        if (!processedAccounts.contains(accountNum)) {
          processedAccounts.add(accountNum);

          if ((this.getAccountExportLayout().getColumns() != null)
                && (this.getAccountExportLayout().getColumns().size() > 0)) {
            Set<AccountExportLayoutColumn> columns = this.getAccountExportLayout().getColumns();

            List<AccountExportLayoutColumn> columnList = new ArrayList<>();
            columnList.addAll(columns);

            List<Object> values = (List<Object>) calculate(evaluateHelper);

            for (int i = 0; i < columnList.size(); i++) {
              DataExportResult dataExportResult = new DataExportResult();
              dataExportResult.setAccount(account);
              dataExportResult.setAction(this);
              dataExportResult.setNode(node);
              dataExportResult.setExecuteDate(new Date());
              dataExportResult.setStrategyDate(today);
              dataExportResult.setRuleBatchId(batchId);
              dataExportResult.setResponsible(responsible);
              dataExportResult.setStatus(ChannelResultStatus.INIT);
              dataExportResult.setCreator(executor);
              dataExportResult.setSurveyFlowMode(triggerType);
              dataExportResult.setSurveyFlowStep(flowStep);
              dataExportResult.setSource(source);

              BaseVariable variable = columnList.get(i).getVariable();
              String       dataType = variable.getDataType();
              dataExportResult.setVariable(variable);
              dataExportResult.setDataType(dataType);


              if (values.get(i) != null) {
                Object value = values.get(i);
                dataExportResult.setValue(value.toString());

                switch (dataType) {
                  case STRING: {
                    dataExportResult.setStringValue(value.toString());

                    break;
                  }

                  case INTEGER: {
                    dataExportResult.setIntegerValue((Integer) value);

                    break;
                  }

                  case BOOLEAN: {
                    dataExportResult.setBooleanValue((Boolean) value);

                    break;
                  }

                  case BIGDECIMAL: {
                    dataExportResult.setDecimalValue((BigDecimal) value);

                    break;
                  }

                  case LONG: {
                    dataExportResult.setLongValue(Long.parseLong(value.toString()));

                    break;
                  }

                  case DATE: {
                    dataExportResult.setDateValue((Date) value);

                    break;
                  }
                } // end switch
              }   // end if

              executeHelper.addResult(dataExportResult);
            } // end for
          }   // end if

        } // end if
      }   // end if
    }     // end if
  }       // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account export layout.
   *
   * @return  AccountExportLayout
   */
  public AccountExportLayout getAccountExportLayout() {
    return accountExportLayout;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data export nodes.
   *
   * @return  Set
   */
  public Set<Node> getDataExportNodes() {
    return dataExportNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visible.
   *
   * @return  Boolean
   */
  public Boolean getVisible() {
    return visible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account export layout.
   *
   * @param  accountExportLayout  AccountExportLayout
   */
  public void setAccountExportLayout(AccountExportLayout accountExportLayout) {
    this.accountExportLayout = accountExportLayout;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data export nodes.
   *
   * @param  dataExportNodes  Set
   */
  public void setDataExportNodes(Set<Node> dataExportNodes) {
    this.dataExportNodes = dataExportNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visible.
   *
   * @param  visible  Boolean
   */
  public void setVisible(Boolean visible) {
    this.visible = visible;
  }
} // end class DataExportAction
