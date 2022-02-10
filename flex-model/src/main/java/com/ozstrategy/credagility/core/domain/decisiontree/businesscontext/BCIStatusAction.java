package com.ozstrategy.credagility.core.domain.decisiontree.businesscontext;

import com.cmc.credagility.core.domain.businesscontext.BCIStatusDetail;
import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.BaseNodeAction;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/25/2015 17:44
 */
@Entity @Table public class BCIStatusAction extends BCBaseNodeAction implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5791321894364900501L;

  //~ Instance fields --------------------------------------------------------------------------------------------------


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "statusAction",
    cascade  = { CascadeType.ALL }
  )
  protected Set<BCNode> nodes = new HashSet<BCNode>();


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean removeAction = false;

  /** node . */
  @JoinColumn(
    name       = "statusDetailId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected BCIStatusDetail statusDetail = new BCIStatusDetail();

  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BCIStatusAction object.
   */
  public BCIStatusAction() {
    this.actionType = BaseNodeAction.ActionType_Status;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * beforeExecute.
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  BCIStatusAction
   */
  public void deepCopy(BCIStatusAction copyFrom) {
    setStatusDetail(copyFrom.getStatusDetail());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  BaseNodeAction
   */
  @Override public BaseNodeAction duplicate() {
    BCIStatusAction statusAction = new BCIStatusAction();
    statusAction.updateNodeAction(this);
    statusAction.setBusinessContext(statusAction.getBusinessContext());
    statusAction.setName(statusAction.getName());
    statusAction.setStatusDetail(this.getStatusDetail());

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

    BCIStatusAction that = (BCIStatusAction) o;


    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if (!nodes.equals(that.nodes)) {
      return false;
    }

    if ((statusDetail != null) ? (!statusDetail.equals(that.statusDetail)) : (that.statusDetail != null)) {
      return false;
    }

    return true;
  } // end method equals

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

      BusinessContextInstance bci = (BusinessContextInstance) params.get("businessContextInstance");

      BCIStatusDetail statusDetail = this.getStatusDetail();

      if ((statusDetail != null) && (bci != null)) {
        Set<Long> processedBCSet = (Set<Long>) params.get("processedBCSet");

        if (!processedBCSet.contains(bci.getId())) {
          processedBCSet.add(bci.getId());

          bci.setStatus(statusDetail.getStatusCode());
          logger.info("Executed node status action[BCIStatusAction#" + this.getId()
            + "] successfully. Updated bci overall status to [" + statusDetail.getStatusCode() + "]");

          executeHelper.addResult(bci);
        }
      } else if (this.removeAction) {
        bci.setStatus(null);
        executeHelper.addResult(bci);
      }
    } // end if
  }   // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<BCNode> getNodes() {
    return nodes;
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
   * getter method for status detail.
   *
   * @return  BCIStatusDetail
   */
  public BCIStatusDetail getStatusDetail() {
    return statusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + nodes.hashCode();

    result = (31 * result) + ((statusDetail != null) ? statusDetail.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setNodes.
   *
   * @param  nodes  $param.type$
   */
  public void setNodes(Set<BCNode> nodes) {
    this.nodes = nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setRemoveAction.
   *
   * @param  removeAction  $param.type$
   */
  public void setRemoveAction(Boolean removeAction) {
    this.removeAction = removeAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status detail.
   *
   * @param  statusDetail  BCIStatusDetail
   */
  public void setStatusDetail(BCIStatusDetail statusDetail) {
    this.statusDetail = statusDetail;
  }
} // end class BCIStatusAction
