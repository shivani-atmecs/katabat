package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 14:35
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "actionNameIndex",
      columnList = "name"
    )
  }
)
public class ReQueueAction extends BaseNodeAction {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7809025161788122563L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "InsertReQueueQueueAction",
    indexes            = { @Index(columnList = "insertReQueueActionId") },
    joinColumns        = {
      @JoinColumn(
        name           = "insertReQueueActionId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "insertQueueActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Set<QueueAction> insertQueueActions = new LinkedHashSet<QueueAction>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;


  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "RemoveReQueueQueueAction",
    indexes            = {
      @Index(
        name           = "removeReQueueActionId",
        columnList     = "removeReQueueActionId"
      )
    },
    joinColumns        = {
      @JoinColumn(
        name           = "removeReQueueActionId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "removeQueueActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Set<QueueAction> removeQueueActions = new LinkedHashSet<QueueAction>();


  @ManyToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "nodeReQueueActions"
  )
  private Set<Node> reQueueNodes = new LinkedHashSet<Node>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * beforeExecute.
   */
  @Override public void beforeExecute() {
    // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  BaseNodeAction
   */
  @Override public BaseNodeAction duplicate() {
    ReQueueAction reQueueAction = new ReQueueAction();
    reQueueAction.setName(this.getName());

    for (QueueAction queueAction : this.insertQueueActions) {
      reQueueAction.getInsertQueueActions().add(queueAction);
    }

    for (QueueAction queueAction : this.removeQueueActions) {
      reQueueAction.getRemoveQueueActions().add(queueAction);
    }

    return reQueueAction; // end method duplicate
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * execute.
   *
   * @param  evaluateHelper  EvaluateHelper
   * @param  executeHelper   ExecuteHelper
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for complete criteria.
   *
   * @return  String
   */
  public String getCompleteCriteria() {
    return this.criteria;
  } // end method getCompleteCriteria

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for insert queue actions.
   *
   * @return  Set
   */
  public Set<QueueAction> getInsertQueueActions() {
    return insertQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for remove queue actions.
   *
   * @return  Set
   */
  public Set<QueueAction> getRemoveQueueActions() {
    return removeQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for re queue nodes.
   *
   * @return  Set
   */
  public Set<Node> getReQueueNodes() {
    return reQueueNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for insert queue actions.
   *
   * @param  insertQueueActions  Set
   */
  public void setInsertQueueActions(Set<QueueAction> insertQueueActions) {
    this.insertQueueActions = insertQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for remove queue actions.
   *
   * @param  removeQueueActions  Set
   */
  public void setRemoveQueueActions(Set<QueueAction> removeQueueActions) {
    this.removeQueueActions = removeQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for re queue nodes.
   *
   * @param  reQueueNodes  Set
   */
  public void setReQueueNodes(Set<Node> reQueueNodes) {
    this.reQueueNodes = reQueueNodes;
  }
} // end class ReQueueAction
