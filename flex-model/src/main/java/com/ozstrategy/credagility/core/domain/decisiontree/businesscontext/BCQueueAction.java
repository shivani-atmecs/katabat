package com.ozstrategy.credagility.core.domain.decisiontree.businesscontext;

import com.cmc.credagility.core.domain.businesscontext.*;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.BaseNodeAction;
import com.ozstrategy.credagility.core.domain.RunType;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.*;


/**
 * This class is used to store BCQueueAction information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:01
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
public class BCQueueAction extends BCBaseNodeAction {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7556887599612128142L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "BCQueueAssignAgent",
    indexes            = { @Index(columnList = "queueActionId") },
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
    cascade = CascadeType.ALL
  )
  protected Set<User> assignAgents = new HashSet<User>();


  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         assignDate;


  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "BCQueueAssignRole",
    indexes            = { @Index(columnList = "queueActionId") },
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
    cascade = CascadeType.ALL
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
  protected Set<BCNode> queueNodes = new LinkedHashSet<BCNode>();


  /** TODO: DOCUMENT ME! */
  @Transient protected String tempPath;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean visible;

  private String exportFileName;

  @JoinColumn(name = "exportLayoutId")
  @ManyToOne(fetch = FetchType.LAZY)
  private BCExportLayout exportLayout;
  // ------------------------

  @JoinColumn(
    name       = "exportLocationId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private BCExportConfiguration  exportLocation;
  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  @Transient private Set<Long> processedAccounts = new HashSet<Long>();

  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "queueAction"
  )
  private Set<BCQueueFeatureRestriction> restrictions = new LinkedHashSet<BCQueueFeatureRestriction>();

  /** Node actions. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "queueAction",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  private Set<BCDefaultQueueSortCriteria> sortCriterias = new LinkedHashSet<BCDefaultQueueSortCriteria>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new QueueAction object.
   */
  public BCQueueAction() {
    actionType = BaseNodeAction.ActionType_Queue;
  }

  /**
   * Creates a new BCQueueAction object.
   *
   * @param  id  Long
   */
  public BCQueueAction(Long id) {
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
   * @param  restriction  BCQueueFeatureRestriction
   */
  public void addFeatureRestriction(BCQueueFeatureRestriction restriction) {
    restriction.setQueueAction(this);
    this.restrictions.add(restriction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addSortCriteria.
   *
   * @param  sortCriteria  BCDefaultQueueSortCriteria
   */
  public void addSortCriteria(BCDefaultQueueSortCriteria sortCriteria) {
    sortCriteria.setQueueAction(this);
    this.sortCriterias.add(sortCriteria);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.Executable#beforeExecute()
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculatePath.
   *
   * @param  splitTag  String
   * @param  nodes     Collection
   */
  public void calculatePath(String splitTag, Collection<BCNode> nodes) {
    // reset path value when calculate restart
    this.path = "";

    List<StringBuilder> tempPaths = new ArrayList<StringBuilder>();

    for (BCNode qNode : nodes) {
      StringBuilder sb = new StringBuilder(this.getName());
      sb.append("!");
      sb.append(this.getId());

      BCNode parentNode = qNode.getParentNode();
      generateParentPath(parentNode, sb, splitTag);
      tempPaths.add(sb);
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
  public void calculateTempPath(String splitTag, Collection<BCNode> nodes) {
    // reset path value when calculate restart
    this.tempPath = "";

    List<StringBuilder> tempPaths = new ArrayList<StringBuilder>();

    for (BCNode qNode : nodes) {
      StringBuilder sb = new StringBuilder(this.getName());
      sb.append("!");
      sb.append(this.getId());

      BCNode parentNode = qNode.getParentNode();
      generateParentPath(parentNode, sb, splitTag);
      tempPaths.add(sb);
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
   * @see  com.ozstrategy.credagility.core.domain.BaseNodeAction#duplicate()
   */
  @Override public BaseNodeAction duplicate() {
    BCQueueAction queueAction = new BCQueueAction();
    queueAction.updateNodeAction(this);
    queueAction.setBusinessContext(queueAction.getBusinessContext());
    queueAction.setName(queueAction.getName());
    queueAction.setVisible(Boolean.TRUE);

    for (BCDefaultQueueSortCriteria sortCriteria : this.sortCriterias) {
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
   * @see  BCBaseNodeAction#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BCQueueAction)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BCQueueAction that = (BCQueueAction) o;

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
   * @see  com.ozstrategy.credagility.core.domain.Executable#execute(com.ozstrategy.credagility.core.helper.EvaluateHelper, com.ozstrategy.credagility.core.helper.ExecuteHelper)
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    Map<String, Object> params = executeHelper.getParameters();

    if (evaluate(evaluateHelper)) {
      RunType runType = (RunType) params.get("runType");

      if (((runType.isBatch()) || (runType.isCID())) && (runType.isQueue())) {
        this.triggered = true;

        BusinessContextInstance bci        = (BusinessContextInstance) params.get("businessContextInstance");
        boolean                 deltaBatch = (Boolean) params.get("deltaBatch");
        Long                    batchId    = (params.get("batchId") != null)
          ? Long.parseLong((String) params.get("batchId")) : null;

        if (deltaBatch) {
          if (logger.isDebugEnabled()) {
            logger.debug("create queue result from deltaBatch file.");
          }
        }

        BCIQueue bciQueue = new BCIQueue();
        bciQueue.setBusinessContextInstance(bci);
        bciQueue.setQueueAction(this);
        bciQueue.setDeltaBatch(deltaBatch);
        bciQueue.setMasterBatchId(batchId);
        
        // For fixed the dead lock
        // drop run the 'usp_PopulateQueueOrderResultInBusinessContext' store procedure
        // during generate the BCIQueue
        // Create BCIQueueOrderResult the same time.
        BCIQueueOrderResult bciQueueOrderResult = new BCIQueueOrderResult();
        bciQueueOrderResult.setBusinessContextInstanceId(bci.getId());
        bciQueueOrderResult.setQueueActionId(this.getId());

        executeHelper.addResult(bciQueue);
        executeHelper.addResult(bciQueueOrderResult);
      } // end if
    }   // end if
  }     // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findFeatureRestriction.
   *
   * @param   restriction  BCQueueFeatureRestriction
   *
   * @return  BCQueueFeatureRestriction
   */
  public BCQueueFeatureRestriction findFeatureRestriction(
    BCQueueFeatureRestriction restriction) {
    if (restriction == null) {
      return null;
    }

    if (restriction.getRestrictionId() != null) {
      // lookup through id
      for (BCQueueFeatureRestriction curRestriction : this.restrictions) {
        if (curRestriction.getRestrictionId().equals(
                restriction.getRestrictionId())) {
          return curRestriction;
        }
      }

      return null;
    } else {
      // lookup through equal
      Iterator<BCQueueFeatureRestriction> it = this.restrictions.iterator();

      while (it.hasNext()) {
        BCQueueFeatureRestriction ret = it.next();

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
   * @param   sortCriteria  BCDefaultQueueSortCriteria
   *
   * @return  BCDefaultQueueSortCriteria
   */
  public BCDefaultQueueSortCriteria findSortCriteria(BCDefaultQueueSortCriteria sortCriteria) {
    if (sortCriteria == null) {
      return null;
    }

    if (sortCriteria.getId() != null) {
      // lookup through id
      for (BCDefaultQueueSortCriteria curSortCriteria : this.sortCriterias) {
        if (curSortCriteria.getId().equals(sortCriteria.getId())) {
          return curSortCriteria;
        }
      }

      return null;
    } else {
      // lookup through equal
      Iterator<BCDefaultQueueSortCriteria> it = this.sortCriterias.iterator();

      while (it.hasNext()) {
        BCDefaultQueueSortCriteria ret = it.next();

        if (ret.equals(sortCriteria)) {
          return ret;
        }
      }

    } // end if-else

    return null;
  } // end method findSortCriteria

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
   * getter method for export file name.
   *
   * @return  String
   */
  public String getExportFileName() {
    return exportFileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for export layout id.
   *
   * @return  Long
   */
  public Long getExportLayoutId() {
    if (exportLayout != null) {
      return exportLayout.getId();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for export location.
   *
   * @return  BCExportConfiguration
   */
  public BCExportConfiguration getExportLocation() {
    return exportLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for export location id.
   *
   * @return  Long
   */
  public Long getExportLocationId() {
    if (exportLocation != null) {
      return exportLocation.getId();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for export location string.
   *
   * @return  String
   */
  public String getExportLocationString() {
    if (exportLocation != null) {
      return exportLocation.getQueueExportLocation();
    }

    return null;
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
   * getter method for path.
   *
   * @return  String
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
  public Set<BCNode> getQueueNodes() {
    return queueNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for restrictions.
   *
   * @return  Set
   */
  public Set<BCQueueFeatureRestriction> getRestrictions() {
    return restrictions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sort criterias.
   *
   * @return  Set
   */
  public Set<BCDefaultQueueSortCriteria> getSortCriterias() {
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
   * @see  com.ozstrategy.credagility.core.domain.BaseNodeAction#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
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
    for (BCQueueFeatureRestriction restriction : this.restrictions) {
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
   * @param   restriction  BCQueueFeatureRestriction
   *
   * @return  BCQueueFeatureRestriction
   */
  public BCQueueFeatureRestriction removeFeatureRestriction(
    BCQueueFeatureRestriction restriction) {
    for (BCQueueFeatureRestriction curRestriction : this.restrictions) {
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
   * @param   sortCriteria  BCDefaultQueueSortCriteria
   *
   * @return  BCDefaultQueueSortCriteria
   */
  public BCDefaultQueueSortCriteria removeSortCriteria(BCDefaultQueueSortCriteria sortCriteria) {
    for (BCDefaultQueueSortCriteria curSortCriteria : this.sortCriterias) {
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
   * @param  metaDataField  BCVariableMetaDataField
   * @param  sortCriteria   BCDefaultQueueSortCriteria
   */
  public void removeSortCriteriaByMetaData(BCVariableMetaDataField metaDataField,
    BCDefaultQueueSortCriteria sortCriteria) {
    // lookup through equal
    Iterator<BCDefaultQueueSortCriteria> it        = this.sortCriterias.iterator();
    Set<BCDefaultQueueSortCriteria>      toRemoved = new HashSet<BCDefaultQueueSortCriteria>();

    while (it.hasNext()) {
      BCDefaultQueueSortCriteria ret = it.next();

      if (metaDataField.equals(ret.getVariableMetaDataField()) && !ret.equals(sortCriteria)) {
        toRemoved.add(ret);
      }
    }

    this.sortCriterias.removeAll(toRemoved);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set assigned agents.
   *
   * @param  assignAgents  agents to assign to queue
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
   * setter method for export file name.
   *
   * @param  exportFileName  String
   */
  public void setExportFileName(String exportFileName) {
    this.exportFileName = exportFileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export layout id.
   *
   * @param  id  Long
   */
  public void setExportLayoutId(Long id) {
    if ((id != null) && (id != 0L)) {
      this.exportLayout = new BCExportLayout();
      this.exportLayout.setId(id);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export location.
   *
   * @param  exportLocation  BCExportConfiguration
   */
  public void setExportLocation(BCExportConfiguration exportLocation) {
    this.exportLocation = exportLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export location id.
   *
   * @param  id  Long
   */
  public void setExportLocationId(Long id) {
    if ((id != null) && (id != 0L)) {
      this.exportLocation = new BCExportConfiguration();
      this.exportLocation.setId(id);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export location string.
   *
   * @param  locationString  String
   */
  public void setExportLocationString(String locationString) { }

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
   * @see  com.ozstrategy.credagility.core.domain.BaseNodeAction#setId(Long)
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
  public void setQueueNodes(Set<BCNode> queueNodes) {
    this.queueNodes = queueNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for restrictions.
   *
   * @param  restrictions  Set
   */
  public void setRestrictions(Set<BCQueueFeatureRestriction> restrictions) {
    this.restrictions = restrictions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sort criterias.
   *
   * @param  sortCriterias  Set
   */
  public void setSortCriterias(Set<BCDefaultQueueSortCriteria> sortCriterias) {
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

  /**
   * @see  com.ozstrategy.credagility.core.domain.BaseNodeAction#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("QueueAction{");
    sb.append(", assignAgents=").append(assignAgents);
    sb.append(", assignDate=").append(assignDate);
    sb.append(", assignRoles=").append(assignRoles);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.BaseNodeAction#updateNodeAction(com.ozstrategy.credagility.core.domain.BaseNodeAction)
   */
  @Override public boolean updateNodeAction(BaseNodeAction queueAction) {
    this.exportLocation = ((BCQueueAction) queueAction).getExportLocation();

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

  private void generateParentPath(BCNode parent, StringBuilder sb, String splitTag) {
    if (parent != null) {
      if (parent.getNodeQueueActions().size() > 0) {
        sb.append(splitTag);

        Set<BCQueueAction> queues    = parent.getNodeQueueActions();
        int                loopIndex = 0;

        for (BCQueueAction queue : queues) {
          sb.append(queue.getName());
          sb.append("!");
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

} // end class BCQueueAction
