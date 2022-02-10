package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountIndex;
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
 * Created by david on 8/6/15.
 *
 * @author   <a href="mailto:wei.dai@ozstrategy.com">Wei Dai</a>
 * @version  08/06/2015 09:59
 */
@Entity @Table public class ChargeOffAction extends PortfolioBaseNodeAction implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 7901504464030535931L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** node . */
  @JoinColumn(
    name       = "chargeOffReasonId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected ChargeOffReason chargeOffReason;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "chargeOffAction",
    cascade  = { CascadeType.ALL }
  )
  protected Set<Node>            nodes  = new LinkedHashSet<Node>();
  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * beforeExecute.
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  BaseNodeAction
   */
  @Override public BaseNodeAction duplicate() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * execute.
   *
   * @param  evaluateHelper  EvaluateHelper
   * @param  executeHelper   ExecuteHelper
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    Map<String, Object> params = executeHelper.getParameters();

    if (evaluate(evaluateHelper)) {
      this.triggered = true;

      try {
        Account         account    = (Account) params.get("account");
        RunType         jobRunType = (RunType) params.get("runType");
        boolean         deltaBatch = (Boolean) params.get("deltaBatch");
        Long            batchId    = Long.parseLong((String) params.get("batchId"));
        ChargeOffResult result     = new ChargeOffResult();
        result.setAccount(account);
        result.setMasterBatchId(batchId);
        result.setDeltaBatch(deltaBatch);
        result.setChargeOffAction(this);
        result.setChargeOffDate(new Date());
        result.setReasonCode((this.getChargeOffReason() != null) ? this.getChargeOffReason().getReasonCode() : null);
        executeHelper.addSingleObject("ChargeOffResult", result);
        executeHelper.addResult(result);

        AccountIndex index = account.getAccountIndex();
        index.setChargeOffDate(new Date());
        index.setChargeOffReason(this.getChargeOffReason());
        index.setIsChargeOff(true);
        executeHelper.addSingleObject("AccountIndex", index);
        executeHelper.addResult(index);
      } catch (Exception e) {
        if (logger.isDebugEnabled()) {
          logger.debug("execute error : " + e.getMessage());
        }
      }

    } // end if
  }   // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off reason.
   *
   * @return  ChargeOffReason
   */
  public ChargeOffReason getChargeOffReason() {
    return chargeOffReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for nodes.
   *
   * @return  Set
   */
  public Set<Node> getNodes() {
    return nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off reason.
   *
   * @param  chargeOffReason  ChargeOffReason
   */
  public void setChargeOffReason(ChargeOffReason chargeOffReason) {
    this.chargeOffReason = chargeOffReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for nodes.
   *
   * @param  nodes  Set
   */
  public void setNodes(Set<Node> nodes) {
    this.nodes = nodes;
  }
} // end class ChargeOffAction
