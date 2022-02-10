package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.audit.AuditType;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 09:52
 */
@MappedSuperclass public abstract class AbstractActionAudit extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Long actionId;

  /** node action type. */
  @Column(length = 32)
  protected String actionType;


  /** TODO: DOCUMENT ME! */
  @Column(length = 5)
  /**
   *  'C' 'U' 'D'
   */
  protected String auditType;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long copyFromId;


  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String criteria;

  /** Description for the node aChannelRulection. */
  @Column(length = 255)
  protected String description;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean locked = false;

  /** Name for the node action. */
  @Column(length = 255)
  protected String name;

  /** node . */
  @JoinColumn(
    name       = "nodeId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Node node;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Integer permanenceCode;

  /** node . */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;


  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority = 1;

  /** action run type: CID/Strategy/All. */
  @Column(length = 32)
  protected String runType;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AbstractActionAudit object.
   */
  protected AbstractActionAudit() { }

  /**
   * Creates a new AbstractActionAudit object.
   *
   * @param  action  BaseNodeAction
   * @param  type    AuditType
   */
  protected AbstractActionAudit(BaseNodeAction action, AuditType type) {
    this.actionType  = action.getActionType();
    this.copyFromId  = action.getCopyFromId();
    this.criteria    = action.getCriteria();
    this.description = action.getDescription();
    this.name        = action.getName();
// this.node           = action.getNode();
    this.locked         = action.getLocked();
    this.permanenceCode = action.getPermanenceCode();
// this.portfolio      = action.getPortfolio();
    this.priority       = action.getPriority();
    this.runType        = action.getRunType();
    this.actionId       = action.getId();
    this.auditType      = type.name();
    this.creator        = action.getCreator();
    this.lastUpdater    = action.getLastUpdater();
    this.createDate     = action.getCreateDate();
    this.lastUpdateDate = action.getLastUpdateDate();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for action id.
   *
   * @return  Long
   */
  public Long getActionId() {
    return actionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action type.
   *
   * @return  String
   */
  public String getActionType() {
    return actionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for audit type.
   *
   * @return  String
   */
  public String getAuditType() {
    return auditType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for copy from id.
   *
   * @return  Long
   */
  public Long getCopyFromId() {
    return copyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  String
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for locked.
   *
   * @return  Boolean
   */
  public Boolean getLocked() {
    if (locked == null) {
      return Boolean.FALSE;
    }

    return locked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node.
   *
   * @return  Node
   */
  public Node getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for permanence code.
   *
   * @return  Integer
   */
  public Integer getPermanenceCode() {
    return permanenceCode;
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
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for run type.
   *
   * @return  String
   */
  public String getRunType() {
    return runType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action id.
   *
   * @param  actionId  Long
   */
  public void setActionId(Long actionId) {
    this.actionId = actionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action type.
   *
   * @param  actionType  String
   */
  public void setActionType(String actionType) {
    this.actionType = actionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for audit type.
   *
   * @param  auditType  String
   */
  public void setAuditType(String auditType) {
    this.auditType = auditType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for copy from id.
   *
   * @param  copyFromId  Long
   */
  public void setCopyFromId(Long copyFromId) {
    this.copyFromId = copyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria.
   *
   * @param  criteria  String
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for locked.
   *
   * @param  locked  Boolean
   */
  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node.
   *
   * @param  node  Node
   */
  public void setNode(Node node) {
    this.node = node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for permanence code.
   *
   * @param  permanenceCode  Integer
   */
  public void setPermanenceCode(Integer permanenceCode) {
    this.permanenceCode = permanenceCode;
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
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for run type.
   *
   * @param  runType  String
   */
  public void setRunType(String runType) {
    this.runType = runType;
  }
} // end class AbstractActionAudit
