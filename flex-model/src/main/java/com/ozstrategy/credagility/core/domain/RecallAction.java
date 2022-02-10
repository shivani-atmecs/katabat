package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  09/23/2015 17:01
 */
@Entity @Table public class RecallAction extends PortfolioBaseNodeAction implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6241821363209054406L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "recallAction",
    cascade  = { CascadeType.ALL }
  )
  protected Set<Node> nodes = new LinkedHashSet<Node>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "recallReasonId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected RecallReason reason;

  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new RecallAction object.
   */
  public RecallAction() { }

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
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    RecallAction that = (RecallAction) o;

    if ((nodes != null) ? (!nodes.equals(that.nodes)) : (that.nodes != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((reason != null) ? (!reason.equals(that.reason)) : (that.reason != null)) {
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
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) { }

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
   * RecallReason.
   *
   * @return  RecallReason.
   */
  public RecallReason getReason() {
    return reason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((nodes != null) ? nodes.hashCode() : 0);
    result = (31 * result) + ((reason != null) ? reason.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);

    return result;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reason.
   *
   * @param  reason  RecallReason
   */
  public void setReason(RecallReason reason) {
    this.reason = reason;
  }
} // end class RecallAction
