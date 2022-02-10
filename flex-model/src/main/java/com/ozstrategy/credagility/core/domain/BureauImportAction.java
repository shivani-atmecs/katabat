package com.ozstrategy.credagility.core.domain;


import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.bureau.BureauDataRequest;
import com.cmc.credagility.core.domain.event.EventInstance;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.ChannelResultStatus;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.cmc.credagility.core.domain.webactivity.Session;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowTriggerSource;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


/**
 * Created by yongliu on 11/4/16.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  11/04/2016 15:52
 */
@Entity
@Table(name = "BureauImportAction")
public class BureauImportAction extends PortfolioBaseNodeAction implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long   serialVersionUID = 4994859581882808146L;
  private static final Logger logger           = LoggerFactory.getLogger(BureauImportAction.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @ManyToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "nodeBureauImportActions"
  )
  protected Set<Node> bureauNodes = new LinkedHashSet<Node>();

  /** TODO: DOCUMENT ME! */
  @Transient protected Node triggeredNode;

  @JoinColumn(
    name     = "bureauDataProviderId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private BureauDataProvider bureauDataProvider;

  @JoinColumn(
    name     = "bureauRequestTypeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private BureauRequestType bureauRequestType;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BureauImportAction object.
   */
  public BureauImportAction() {
    actionType = BaseNodeAction.ActionType_BUREAUIMPORT;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Executable#beforeExecute()
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseNodeAction#duplicate()
   */
  @Override public BaseNodeAction duplicate() {
    BureauImportAction bureauImportAction = new BureauImportAction();
    bureauImportAction.updateNodeAction(this);
    bureauImportAction.setActionType(BaseNodeAction.ActionType_BUREAUIMPORT);
    bureauImportAction.setPortfolio(this.getPortfolio());
    bureauImportAction.setBureauDataProvider(this.getBureauDataProvider());
    bureauImportAction.setBureauRequestType(this.getBureauRequestType());

    return bureauImportAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Executable#execute(com.ozstrategy.credagility.core.helper.EvaluateHelper,
   *       com.ozstrategy.credagility.core.helper.ExecuteHelper)
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    Map<String, Object> params = executeHelper.getParameters();

    if (evaluate(evaluateHelper)) {
      this.triggered = true;

      RunType                       runType                    = (RunType) params.get("runType");
      Account                       account                    = (Account) params.get("account");
      Responsible                   responsible                = (Responsible) params.get("responsible");
      boolean                       deltaBatch                 = (Boolean) params.get("deltaBatch");
      Long                          batchId                    = (params.get("batchId") != null)
        ? Long.parseLong((String) params.get("batchId")) : new Date().getTime();
      Session                       session                    = (Session) params.get("session");
      EventInstance                 eventInstance              = (EventInstance) params.get("eventInstance");
      SurveyFlowStep                flowStep                   = (SurveyFlowStep) params.get("flowStep");
      WorkflowNodeActionTriggerType triggerType                = (WorkflowNodeActionTriggerType) params.get(
          "triggerType");
      Set<Long>                     processedATPResponsibleIds = (Set) params.get("processedATPResponsibleIds");

      Date today         = DateUtil.toDateOnly(new Date());
      Long responsibleId = responsible.getResponsibleId();

      String source = null;

      if (runType.isBatch()) {
        source = "BATCH";
      } else if (runType.isCID()) {
        source = "CID";
      } else if (runType.isEvent()) {
        source = "CID";
      } else if ((flowStep != null) || (triggerType != null)) {
        source = WorkflowTriggerSource.DEBTOR_SITE.toString();
      }

      String  bureauRequestTypeName  = bureauRequestType.getName();
      boolean createBureauResultFlag = Boolean.FALSE;

      /**
       * ATP: if responsible never trigger a ATP before, then trigger it
       *       else never trigger it again
       * FRP & SCR: if responsible has trigger @ATP, then can trigger FRP & SCR request type BIA(Bureau Import Action)
       *            else never trigger FRP & SCR BIA
       * SCO: if responsible never triggered @ATP request Action, then can generate SCO BIA
       *       else never trigger SCP BIA
       */
      logDebug("Process bureau request: " + bureauRequestTypeName + " and channel source is: " + source);

      if (BureauRequestType.REQUEST_TYPE_ATP.equalsIgnoreCase(bureauRequestTypeName)) {
        createBureauResultFlag = (processedATPResponsibleIds != null)
          && !processedATPResponsibleIds.contains(responsibleId);

        if (createBureauResultFlag) {
          processedATPResponsibleIds.add(responsibleId);
          logDebug("Will process bureau request: " + bureauRequestTypeName + " for responsibleId#" + responsibleId);
        } else {
          logDebug("Will skip bureau request: " + bureauRequestTypeName + " for responsibleId#" + responsibleId
            + ", because this responsible has triggered '" + bureauRequestTypeName + "'");
        }

      } else if (BureauRequestType.REQUEST_TYPE_FRP.equalsIgnoreCase(bureauRequestTypeName)
            || BureauRequestType.REQUEST_TYPE_SCR.equalsIgnoreCase(bureauRequestTypeName)) {
        createBureauResultFlag = (processedATPResponsibleIds != null)
          && processedATPResponsibleIds.contains(responsibleId);

        if (createBureauResultFlag) {
          logDebug("Will process bureau request: " + bureauRequestTypeName + " for responsibleId#" + responsibleId);
        } else {
          logDebug("Will skip bureau request: " + bureauRequestTypeName + " for responsibleId#" + responsibleId
            + ", because this responsible never trigger 'ATP' bureau request type. ");
        }

      } else if (BureauRequestType.REQUEST_TYPE_SCO.equalsIgnoreCase(bureauRequestTypeName)) {
        createBureauResultFlag = (processedATPResponsibleIds != null)
          && !processedATPResponsibleIds.contains(responsibleId);

        if (createBureauResultFlag) {
          logDebug("Will process bureau request: " + bureauRequestTypeName + " for responsibleId#" + responsibleId);
        } else {
          logDebug("Will skip bureau request: " + bureauRequestTypeName + " for responsibleId#" + responsibleId
            + ", because this responsible has triggered 'ATP' bureau request type. ");
        }

      } else {
        createBureauResultFlag = Boolean.TRUE;
        logDebug("Will process bureau request: " + bureauRequestTypeName + " for responsibleId#" + responsibleId);
      } // end if-else

      if (createBureauResultFlag) {
        BureauDataRequest bureauDataRequest = new BureauDataRequest();
        bureauDataRequest.setBureauRequestType(this.getBureauRequestType());
        bureauDataRequest.setBureauDataProvider(this.getBureauDataProvider());
        bureauDataRequest.setBureauImportAction(this);
        bureauDataRequest.setAccount(account);
        bureauDataRequest.setResponsible(responsible);
        bureauDataRequest.setNode(this.getTriggeredNode());
        bureauDataRequest.setDeltaBatch(deltaBatch);
        bureauDataRequest.setRuleBatchId(batchId);
        bureauDataRequest.setExecuteDate(new Date());
        bureauDataRequest.setSession(session);
        bureauDataRequest.setExecutionInstance(eventInstance);
        bureauDataRequest.setStrategyDate(today);
        bureauDataRequest.setSource(source);
        bureauDataRequest.setStatus(ChannelResultStatus.INIT);
        bureauDataRequest.setSurveyFlowMode(triggerType);
        bureauDataRequest.setSurveyFlowStep(flowStep);

        logDebug("Process bureau request: " + bureauRequestTypeName + " for responsibleId#" + responsibleId
          + " successfully.");

        executeHelper.addResult(bureauDataRequest);
      } // end if
    }   // end if
  }     // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau data provider.
   *
   * @return  BureauDataProvider
   */
  public BureauDataProvider getBureauDataProvider() {
    return bureauDataProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau nodes.
   *
   * @return  Set
   */
  public Set<Node> getBureauNodes() {
    return bureauNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau request type.
   *
   * @return  BureauRequestType
   */
  public BureauRequestType getBureauRequestType() {
    return bureauRequestType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for triggered node.
   *
   * @return  Node
   */
  public Node getTriggeredNode() {
    return triggeredNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau data provider.
   *
   * @param  bureauDataProvider  BureauDataProvider
   */
  public void setBureauDataProvider(BureauDataProvider bureauDataProvider) {
    this.bureauDataProvider = bureauDataProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau nodes.
   *
   * @param  bureauNodes  Set
   */
  public void setBureauNodes(Set<Node> bureauNodes) {
    this.bureauNodes = bureauNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau request type.
   *
   * @param  bureauRequestType  BureauRequestType
   */
  public void setBureauRequestType(BureauRequestType bureauRequestType) {
    this.bureauRequestType = bureauRequestType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for triggered node.
   *
   * @param  triggeredNode  Node
   */
  public void setTriggeredNode(Node triggeredNode) {
    this.triggeredNode = triggeredNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private void logDebug(String log) {
    if (logger.isDebugEnabled()) {
      logger.debug(log);
    }
  }
} // end class BureauImportAction
