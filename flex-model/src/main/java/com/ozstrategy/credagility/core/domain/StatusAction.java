package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountOverallStatus;
import com.cmc.credagility.core.domain.account.AccountOverallStatusDetail;
import com.cmc.credagility.core.domain.type.SourceType;
import com.cmc.credagility.core.domain.type.StatusSource;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
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
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 16:33
 */
@Entity @Table public class StatusAction extends PortfolioBaseNodeAction implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1288336137839146423L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "statusAction",
    cascade  = CascadeType.ALL
  )
  protected Set<Node> nodes = new LinkedHashSet<Node>();

  /** node . */
  @JoinColumn(
    name       = "overallStatusDetailId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected AccountOverallStatusDetail overallStatusDetail = new AccountOverallStatusDetail();


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean removeAction = false;

  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new NodeStatusAction object.
   */
  public StatusAction() {
    this.actionType = BaseNodeAction.ActionType_Status;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Executable#beforeExecute()
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  NodeStatusAction
   */
  public void deepCopy(StatusAction copyFrom) {
    setOverallStatusDetail(copyFrom.getOverallStatusDetail());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseNodeAction#duplicate()
   */
  @Override public BaseNodeAction duplicate() {
    StatusAction statusAction = new StatusAction();
    statusAction.updateNodeAction(this);
    statusAction.setPortfolio(statusAction.getPortfolio());
    statusAction.setName(statusAction.getName());
    statusAction.setOverallStatusDetail(this.getOverallStatusDetail());

    return statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    StatusAction that = (StatusAction) o;


    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if (!nodes.equals(that.nodes)) {
      return false;
    }


    if ((overallStatusDetail != null) ? (!overallStatusDetail.equals(that.overallStatusDetail))
                                      : (that.overallStatusDetail != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Executable#execute(com.ozstrategy.credagility.core.helper.EvaluateHelper,
   *       com.ozstrategy.credagility.core.helper.ExecuteHelper)
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    Map<String, Object> params = executeHelper.getParameters();

    if (evaluate(evaluateHelper)) {
      this.triggered = true;

      Account                    account      = (Account) params.get("account");
      RunType                    jobRunType   = (RunType) params.get("runType");
      boolean                    deltaBatch   = (Boolean) params.get("deltaBatch");
      Long                       batchId      = Long.parseLong((String) params.get("batchId"));
      AccountOverallStatusDetail statusDetail = this.getOverallStatusDetail();

      if (statusDetail != null) {
        String preStatusCode = null;

        if ((account.getAccountOverallStatus() != null)
            && (account.getAccountOverallStatus().getAccountOverallStatusDetail() != null)) {
          preStatusCode = account.getAccountOverallStatus().getAccountOverallStatusDetail().getStatusCode();
        }

        executeHelper.addSingleObject("AccountOverallStatus",account.getAccountOverallStatus());
        AccountOverallStatus accountOverallStatus = account.updateAccountOverallStatus(statusDetail.getStatusId(),
            statusDetail.getStatusCode(), new Date(),
            (((jobRunType != null) && (jobRunType.isEvent() || jobRunType.isCID())) ? StatusSource.CID
                                                                                    : StatusSource.BATCH));

        if (accountOverallStatus.getId() == null) {
          accountOverallStatus.setSourceType(SourceType.DTM);
          accountOverallStatus.setPreviousStatusCode(preStatusCode);
          executeHelper.addSingleObject("AccountOverallStatus", accountOverallStatus);
        }

        logger.info("Executed node status action[StatusAction#" + this.getId()
            + "] successfully. Updated account overall status to [" + statusDetail.toString() + "]");
        executeHelper.addResult(account);
      } else if (this.removeAction) {
        if ((account.getAccountOverallStatus() != null)
              && (account.getAccountOverallStatus().getAccountOverallStatusDetail() != null)) {
// String preStatusCode = null;
// preStatusCode = account.getAccountOverallStatus().getAccountOverallStatusDetail().getStatusCode();
// account.getAccountOverallStatus().setAccountOverallStatusDetail((AccountOverallStatusDetail) null);
//
// AccountOverallStatus accountOverallStatus = account.getAccountOverallStatus();
// accountOverallStatus.setSourceType(SourceType.DTM);
// accountOverallStatus.setPreviousStatusCode(preStatusCode);
          AccountOverallStatus accountOverallStatus = account.getAccountOverallStatus();
          account.removeAccountOverallStatus(); // remove accountOverallStatus
          executeHelper.addSingleObject("AccountOverallStatus", accountOverallStatus);
          executeHelper.addResult(account);
        }
      }                                         // end if-else

      // Save status result
      StatusResult result = new StatusResult();
      result.setStatusAction(this);
      result.setAccount(account);
      result.setMasterBatchId(batchId);
      result.setDeltaBatch(deltaBatch);
      executeHelper.addSingleObject("StatusResult", result);
      executeHelper.addResult(result);
    } // end if
  }   // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action name.
   *
   * @return  String
   */
  public String getActionName() {
    if (this.overallStatusDetail != null) {
      return this.overallStatusDetail.getStatusCode() + ":" + this.overallStatusDetail.getStatusDescription();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<Node> getNodes() {
    return nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * AccountOverallStatusDetail.
   *
   * @return  AccountOverallStatusDetail.
   */
  public AccountOverallStatusDetail getOverallStatusDetail() {
    return overallStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Boolean.
   *
   * @return  Boolean.
   */
  public Boolean getRemoveAction() {
    return removeAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + nodes.hashCode();
    result = (31 * result) + ((overallStatusDetail != null) ? overallStatusDetail.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setNodes.
   *
   * @param  nodes  $param.type$
   */
  public void setNodes(Set<Node> nodes) {
    this.nodes = nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setOverallStatusDetail.
   *
   * @param  overallStatusDetail  $param.type$
   */
  public void setOverallStatusDetail(AccountOverallStatusDetail overallStatusDetail) {
    this.overallStatusDetail = overallStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setRemoveAction.
   *
   * @param  removeAction  $param.type$
   */
  public void setRemoveAction(Boolean removeAction) {
    this.removeAction = removeAction;
  }
} // end class SurveyFlowNodeStatusAction
