package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountExportFile;
import com.cmc.credagility.core.domain.account.AccountMetaDataField;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.*;


/**
 * This class is used to store program action information.
 *
 * <p><a href="QueueAction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 14:25
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
public class QueueAction extends PortfolioBaseNodeAction {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7809025161788122324L;


  /** TODO: DOCUMENT ME! */
  public static final String PATH_PARSE_TAG = "!";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         accountLabeledDate;


  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "QueueAssignAgent",
    indexes            = {
      @Index(
        name           = "queueActionId",
        columnList     = "queueActionId"
      )
    },
    joinColumns        = {
      @JoinColumn(
        name           = "queueActionId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "agentId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Set<User> assignAgents = new HashSet<User>();


  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         assignDate;


  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "QueueAssignRole",
    indexes            = {
      @Index(
        name           = "queueActionId",
        columnList     = "queueActionId"
      )
    },
    joinColumns        = {
      @JoinColumn(
        name           = "queueActionId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "roleId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Set<Role> assignRoles = new HashSet<Role>();


  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Integer duplicateCount = 0;


  /** TODO: DOCUMENT ME! */
  @Column(length = 1024)
  // used for active schedule and fixed path.
  protected String fixedPath;


  /** TODO: DOCUMENT ME! */
  @Column(length = 1024)
  protected String path;


  /** TODO: DOCUMENT ME! */
  @ManyToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "nodeQueueActions"
  )
  protected Set<Node> queueNodes = new LinkedHashSet<Node>();


  /** TODO: DOCUMENT ME! */
  @Transient protected String tempPath;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean visible;


  /** TODO: DOCUMENT ME! */
  @ManyToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "queueActions",
    cascade  = { CascadeType.ALL }
  )
  Set<AccountExportFile>         exportFiles = new LinkedHashSet<AccountExportFile>();
  private final transient Logger logger      = LoggerFactory.getLogger(getClass());

  @Transient private Set<Long> processedAccounts = new HashSet<Long>();

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "queueAction",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  private Set<QueueFeatureRestriction> restrictions = new LinkedHashSet<QueueFeatureRestriction>();

  @Transient private Long scheduleId;

  /** Node actions. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "queueAction",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  private Set<QueueSortCriteria> sortCriterias = new LinkedHashSet<QueueSortCriteria>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new QueueAction object.
   */
  public QueueAction() {
    actionType = BaseNodeAction.ActionType_Queue;
  }

  /**
   * Creates a new QueueAction object.
   *
   * @param  id  DOCUMENT ME!
   */
  public QueueAction(Long id) {
    this.id = id;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addAssignAgent.
   *
   * @param  user  User
   */
  public void addAssignAgent(User user) {
    this.assignAgents.add(user);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addAssignRole.
   *
   * @param  role  Role
   */
  public void addAssignRole(Role role) {
    this.assignRoles.add(role);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addFeatureRestriction.
   *
   * @param  restriction  QueueFeatureRestriction
   */
  public void addFeatureRestriction(QueueFeatureRestriction restriction) {
    restriction.setQueueAction(this);
    this.restrictions.add(restriction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addSortCriteria.
   *
   * @param  sortCriteria  QueueSortCriteria
   */
  public void addSortCriteria(QueueSortCriteria sortCriteria) {
    sortCriteria.setQueueAction(this);
    this.sortCriterias.add(sortCriteria);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * adjustPath.
   */
  public void adjustPath() {
    if (logger.isDebugEnabled()) {
      logger.debug("Always set queueAction path as name!id.");
    }

    this.setPath(this.getName() + PATH_PARSE_TAG + this.getId());
    this.setFixedPath(this.getPath());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * beforeExecute.
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculatePath.
   *
   * @param  splitTag  String
   * @param  nodes     Collection
   */
  public void calculatePath(String splitTag, Collection<Node> nodes) {
    // reset path value when calculate restart
    this.path = "";

    List<StringBuilder> tempPaths = new ArrayList<StringBuilder>();

    if ((nodes != null) && (nodes.size() > 0)) {
      for (Node qNode : this.queueNodes) {
        if (nodes.contains(qNode)) {
          StringBuilder sb = new StringBuilder(this.getName());
          sb.append(PATH_PARSE_TAG);
          sb.append(this.getId());

          Node parentNode = qNode.getParentNode();
          generateParentPath(parentNode, sb, splitTag);
          tempPaths.add(sb);
        }
      }
    }

    StringBuilder allPath   = new StringBuilder();
    int           loopIndex = 0;

    for (StringBuilder tempPath : tempPaths) {
      allPath.append(tempPath);
      loopIndex++;

      if (loopIndex < tempPaths.size()) {
        allPath.append(",");
      }
    }

    this.path = buildSegmentPath(queuePathTrim(allPath.toString(), splitTag), splitTag);

    if ("".equals(this.path.trim())) {
      if (logger.isDebugEnabled()) {
        logger.debug("not bind any node. set as root queue.");
      }

      this.path = this.getName() + PATH_PARSE_TAG + this.getId();
    }

    if (logger.isDebugEnabled()) {
      logger.debug("path : " + this.path);
    }
  } // end method calculatePath

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculateTempPath.
   *
   * @param  splitTag  String
   * @param  nodes     Collection
   */
  public void calculateTempPath(String splitTag, Collection<Node> nodes) {
    // reset path value when calculate restart
    this.tempPath = "";

    List<StringBuilder> tempPaths = new ArrayList<StringBuilder>();

    if ((nodes != null) && (nodes.size() > 0)) {
      for (Node qNode : this.queueNodes) {
        if (nodes.contains(qNode)) {
          StringBuilder sb = new StringBuilder(this.getName());
          sb.append(PATH_PARSE_TAG);
          sb.append(this.getId());

          Node parentNode = qNode.getParentNode();
          generateParentPath(parentNode, sb, splitTag);
          tempPaths.add(sb);
        }
      }
    }

    StringBuilder allPath   = new StringBuilder();
    int           loopIndex = 0;

    for (StringBuilder tempPath : tempPaths) {
      allPath.append(tempPath);
      loopIndex++;

      if (loopIndex < tempPaths.size()) {
        allPath.append(",");
      }
    }

    this.tempPath = buildSegmentPath(queuePathTrim(allPath.toString(), splitTag), splitTag);

    if (logger.isDebugEnabled()) {
      logger.debug("tempPath : " + this.tempPath);
    }
  } // end method calculateTempPath

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseNodeAction#duplicate()
   */
  @Override public BaseNodeAction duplicate() {
    // if (this.duplicateCount == null) {
    // this.duplicateCount = 0;
    // }
    //
    // this.duplicateCount++;

    QueueAction queueAction = new QueueAction();
    queueAction.updateNodeAction(this);
    queueAction.setPortfolio(queueAction.getPortfolio());
    queueAction.setName(queueAction.getName());
    queueAction.setVisible(Boolean.TRUE);

    for (QueueSortCriteria sortCriteria : this.sortCriterias) {
      queueAction.addSortCriteria(sortCriteria.duplicate());
    }

    for (Role role : this.assignRoles) {
      queueAction.addAssignRole(role);
    }

    for (User user : this.assignAgents) {
      queueAction.addAssignAgent(user);
    }

    return queueAction;
  } // end method duplicate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  PortfolioBaseNodeAction#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof QueueAction)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    QueueAction that = (QueueAction) o;

    if ((accountLabeledDate != null) ? (!accountLabeledDate.equals(that.accountLabeledDate))
                                     : (that.accountLabeledDate != null)) {
      return false;
    }

    if ((assignAgents != null) ? (!assignAgents.equals(
              that.assignAgents)) : (that.assignAgents != null)) {
      return false;
    }

    if ((assignDate != null) ? (!assignDate.equals(that.assignDate)) : (that.assignDate != null)) {
      return false;
    }

    if ((assignRoles != null) ? (!assignRoles.equals(that.assignRoles)) : (that.assignRoles != null)) {
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
      RunType runType = (RunType) params.get("runType");

      if (((runType.isBatch()) || (runType.isCID())) && (runType.isQueue())) {
        this.triggered = true;

        Account account    = (Account) params.get("account");
        boolean deltaBatch = (Boolean) params.get("deltaBatch");
        Long    batchId    = Long.parseLong((String) params.get("batchId"));

        if (deltaBatch) {
          if (logger.isDebugEnabled()) {
            logger.debug("create queue result from deltaBatch file.");
          }
        }

        Long accountNum = account.getAccountNum();

        // skip this account if it was processed before
        // since the responsible are sorted by primaryHolder so that we
        // are safe
        if (!processedAccounts.contains(accountNum)) {
          processedAccounts.add(accountNum);

          QueueAccount queueAccount = new QueueAccount();
          queueAccount.setAccount(account);
          queueAccount.setQueueAction(this);
          queueAccount.setDeltaBatch(deltaBatch);
          queueAccount.setMasterBatchId(batchId);

          executeHelper.addSingleObject("QueueAccount",queueAccount);
          executeHelper.addResult(queueAccount);

          if (accountLabeledDate == null) {
            accountLabeledDate = new Date();
            executeHelper.addSingleObject("QueueAction",this);
          }
        } // end if
      }   // end if
    }     // end if
  }       // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findFeatureRestriction.
   *
   * @param   restriction  QueueFeatureRestriction
   *
   * @return  QueueFeatureRestriction
   */
  public QueueFeatureRestriction findFeatureRestriction(QueueFeatureRestriction restriction) {
    if (restriction == null) {
      return null;
    }

    if (restriction.getRestrictionId() != null) {
      // lookup through id
      for (QueueFeatureRestriction curRestriction : this.restrictions) {
        if (curRestriction.getRestrictionId().equals(
                restriction.getRestrictionId())) {
          return curRestriction;
        }
      }

      return null;
    } else {
      // lookup through equal
      Iterator<QueueFeatureRestriction> it = this.restrictions.iterator();

      while (it.hasNext()) {
        QueueFeatureRestriction ret = it.next();

        if (ret.equals(restriction)) {
          return ret;
        }
      }

    } // end if-else

    return null;
  } // end method findFeatureRestriction

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findSortCriteria.
   *
   * @param   sortCriteria  QueueSortCriteria
   *
   * @return  QueueSortCriteria
   */
  public QueueSortCriteria findSortCriteria(QueueSortCriteria sortCriteria) {
    if (sortCriteria == null) {
      return null;
    }

    if (sortCriteria.getId() != null) {
      // lookup through id
      for (QueueSortCriteria curSortCriteria : this.sortCriterias) {
        if (curSortCriteria.getId().equals(sortCriteria.getId())) {
          return curSortCriteria;
        }
      }

      return null;
    } else {
      // lookup through equal
      Iterator<QueueSortCriteria> it = this.sortCriterias.iterator();

      while (it.hasNext()) {
        QueueSortCriteria ret = it.next();

        if (ret.equals(sortCriteria)) {
          return ret;
        }
      }

    } // end if-else

    return null;
  } // end method findSortCriteria

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get Account labeled date.
   *
   * @return  Account labeled date
   */
  public Date getAccountLabeledDate() {
    return accountLabeledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all queue assigned agents.
   *
   * @return  queue assign agents
   */
  public Set<User> getAssignAgents() {
    return assignAgents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get assignment date.
   *
   * @return  queue assign date
   */
  public Date getAssignDate() {
    return assignDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all queue assigned roles.
   *
   * @return  queue assigned roles
   */
  public Set<Role> getAssignRoles() {
    return assignRoles;
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
   * getter method for duplicate count.
   *
   * @return  Integer
   */
  public Integer getDuplicateCount() {
    return duplicateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for export files.
   *
   * @return  Set
   */
  public Set<AccountExportFile> getExportFiles() {
    return exportFiles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fixed path.
   *
   * @return  String
   */
  public String getFixedPath() {
    return fixedPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Stashed changes.
   *
   * @return  stashed changes.
   */
  public String getPath() {
    return path;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue nodes.
   *
   * @return  Set
   */
  public Set<Node> getQueueNodes() {
    return queueNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for restrictions.
   *
   * @return  Set
   */
  public Set<QueueFeatureRestriction> getRestrictions() {
    return restrictions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sort criterias.
   *
   * @return  Set
   */
  public Set<QueueSortCriteria> getSortCriterias() {
    return sortCriterias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temp path.
   *
   * @return  String
   */
  public String getTempPath() {
    return tempPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visible.
   *
   * @return  Boolean
   */
  public Boolean getVisible() {
    if (visible == null) {
      return Boolean.TRUE;
    }

    return visible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Com.ozstrategy.com.ozstrategy.credagility.core.domain.QueueAction#hashCode().
   *
   * @return  com.ozstrategy.com.ozstrategy.credagility.core.domain.QueueAction#hashCode().
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result)
      + ((accountLabeledDate != null) ? accountLabeledDate.hashCode() : 0);
    result = (31 * result)
      + ((assignAgents != null) ? assignAgents.hashCode() : 0);
    result = (31 * result)
      + ((assignDate != null) ? assignDate.hashCode() : 0);
    result = (31 * result)
      + ((assignRoles != null) ? assignRoles.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasRestrictionForFeature.
   *
   * @param   featureName  String
   *
   * @return  boolean
   */
  public boolean hasRestrictionForFeature(String featureName) {
    for (QueueFeatureRestriction restriction : this.restrictions) {
      if (restriction.getFeature().getFeatureName().equals(featureName)) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeAssignAgent.
   *
   * @param  user  User
   */
  public void removeAssignAgent(User user) {
    this.assignAgents.remove(user);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeAssignRole.
   *
   * @param  role  Role
   */
  public void removeAssignRole(Role role) {
    this.assignRoles.remove(role);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeFeatureRestriction.
   *
   * @param   restriction  QueueFeatureRestriction
   *
   * @return  QueueFeatureRestriction
   */
  public QueueFeatureRestriction removeFeatureRestriction(QueueFeatureRestriction restriction) {
    for (QueueFeatureRestriction curRestriction : this.restrictions) {
      if (curRestriction.getRestrictionId().equals(
              restriction.getRestrictionId())) {
        if (this.restrictions.remove(curRestriction)) {
          curRestriction.setQueueAction(null);

          return curRestriction;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeRole.
   *
   * @param  role  Role
   */
  public void removeRole(Role role) {
    if (role == null) {
      return;
    }

    for (Role curRole : this.assignRoles) {
      if (curRole.getId().equals(role.getId())) {
        this.assignRoles.remove(curRole);

        return;
      }
    }

    return;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeSortCriteria.
   *
   * @param   sortCriteria  QueueSortCriteria
   *
   * @return  QueueSortCriteria
   */
  public QueueSortCriteria removeSortCriteria(QueueSortCriteria sortCriteria) {
    for (QueueSortCriteria curSortCriteria : this.sortCriterias) {
      if (curSortCriteria.getId().equals(sortCriteria.getId())) {
        if (this.sortCriterias.remove(curSortCriteria)) {
          curSortCriteria.setQueueAction(null);

          return curSortCriteria;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeSortCriteriaByMetaData.
   *
   * @param  metaDataField  AccountMetaDataField
   * @param  sortCriteria   QueueSortCriteria
   */
  public void removeSortCriteriaByMetaData(AccountMetaDataField metaDataField, QueueSortCriteria sortCriteria) {
    // lookup through equal
    Iterator<QueueSortCriteria> it        = this.sortCriterias.iterator();
    Set<QueueSortCriteria>      toRemoved = new HashSet<QueueSortCriteria>();

    while (it.hasNext()) {
      QueueSortCriteria ret = it.next();

      if (metaDataField.equals(ret.getAccountMetaDataField()) && !ret.equals(sortCriteria)) {
        toRemoved.add(ret);
      }
    }

    this.sortCriterias.removeAll(toRemoved);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account labeled date.
   *
   * @param  accountLabeledDate  Date
   */
  public void setAccountLabeledDate(Date accountLabeledDate) {
    this.accountLabeledDate = accountLabeledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assign agents.
   *
   * @param  assignAgents  Set
   */
  public void setAssignAgents(Set<User> assignAgents) {
    this.assignAgents = assignAgents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set assign date.
   *
   * @param  assignDate  assign date to set
   */
  public void setAssignDate(Date assignDate) {
    this.assignDate = assignDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set assign roles.
   *
   * @param  assignRoles  roles to assign to queue
   */
  public void setAssignRoles(Set<Role> assignRoles) {
    this.assignRoles = assignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duplicate count.
   *
   * @param  duplicateCount  Integer
   */
  public void setDuplicateCount(Integer duplicateCount) {
    this.duplicateCount = duplicateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export files.
   *
   * @param  exportFiles  Set
   */
  public void setExportFiles(Set<AccountExportFile> exportFiles) {
    this.exportFiles = exportFiles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fixed path.
   *
   * @param  fixedPath  String
   */
  public void setFixedPath(String fixedPath) {
    this.fixedPath = fixedPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseNodeAction#setId(Long)
   */
  @Override public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for path.
   *
   * @param  path  String
   */
  public void setPath(String path) {
    this.path = path;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue nodes.
   *
   * @param  queueNodes  Set
   */
  public void setQueueNodes(Set<Node> queueNodes) {
    this.queueNodes = queueNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for restrictions.
   *
   * @param  restrictions  Set
   */
  public void setRestrictions(Set<QueueFeatureRestriction> restrictions) {
    this.restrictions = restrictions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sort criterias.
   *
   * @param  sortCriterias  Set
   */
  public void setSortCriterias(Set<QueueSortCriteria> sortCriterias) {
    this.sortCriterias = sortCriterias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for temp path.
   *
   * @param  tempPath  String
   */
  public void setTempPath(String tempPath) {
    this.tempPath = tempPath;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */

  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("QueueAction{");
    sb.append("accountLabeledDate=").append(accountLabeledDate);
    sb.append(", assignAgents=").append(assignAgents);
    sb.append(", assignDate=").append(assignDate);
    sb.append(", assignRoles=").append(assignRoles);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  queueAction  QueueAction
   * @param  agent        User
   */
  public void update(QueueAction queueAction, User agent) {
    this.name           = queueAction.getName();
    this.description    = queueAction.getDescription();
    this.permanenceCode = queueAction.getPermanenceCode();
    this.lastUpdater    = agent;
    this.lastUpdateDate = new Date();
    this.visible        = queueAction.getVisible();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateNodeAction.
   *
   * @param   queueAction  BaseNodeAction
   *
   * @return  boolean
   */
  @Override public boolean updateNodeAction(BaseNodeAction queueAction) {
    this.exportFiles.clear();
    this.exportFiles.addAll(((QueueAction) queueAction).getExportFiles());

    return super.updateNodeAction(queueAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private String buildSegmentPath(String trimPath, String splitTag) {
    StringBuilder sb        = new StringBuilder();
    String[]      trimPaths = trimPath.split(splitTag);
    int           length    = trimPaths.length;

    if (length > 1) {
      int i = 1;

      while (i < length) {
        String tPath = trimPaths[i];

        if (tPath.split(":").length > 1) { // more than one parent queue in the node.

          String[] tPaths = tPath.split(":");
          int      j      = 0;

          for (String s : tPaths) {
            sb.append(trimPaths[0]);
            sb.append(splitTag);
            sb.append(s);
            j++;

            if (j < tPaths.length) {
              sb.append(",");
            }
          }
        } else {
          sb.append(trimPaths[0]);
          sb.append(splitTag);
          sb.append(trimPaths[i]);
        }

        i++;

        if (i < length) {
          sb.append(",");
        }
      } // end while
    } else {
      sb.append(trimPath);
    }   // end if-else

    return sb.toString();
  } // end method buildSegmentPath

  //~ ------------------------------------------------------------------------------------------------------------------

  private void generateParentPath(Node parent, StringBuilder sb, String splitTag) {
    if (parent != null) {
      if (parent.getNodeQueueActions().size() > 0) {
        sb.append(splitTag);

        Set<QueueAction> queues    = parent.getNodeQueueActions();
        int              loopIndex = 0;

        for (QueueAction queue : queues) {
          sb.append(queue.getName());
          sb.append(PATH_PARSE_TAG);
          sb.append(queue.getId());
          loopIndex++;

          if (loopIndex < queues.size()) {
            sb.append(":");
          }
        }
      }

      generateParentPath(parent.getParentNode(), sb, splitTag);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private String queuePathTrim(String path, String splitTag) {
    String[]    ap        = path.split(",");
    int         length    = ap.length;
    Set<String> resultSet = new LinkedHashSet<String>();

    for (int i = 0; i < length; i++) {
      String   pps = ap[i];
      String[] ppa = pps.split(splitTag);

      for (String pp : ppa) {
        int     index = 0;
        boolean match = false;

        while (index < length) {
          if (!ap[index].contains(pp)) {
            match = false;

            break;
          }

          match = true;
          index++;
        }

        if (match == true) {
          resultSet.add(pp);
        }
      }
    }

    StringBuilder sb           = new StringBuilder();
    int           resultLength = resultSet.size();

    for (String s : resultSet) {
      sb.append(s);
      --resultLength;

      if (resultLength != 0) {
        sb.append(splitTag);
      }
    }

    return sb.toString();
  } // end method queuePathTrim


} // end class QueueAction
