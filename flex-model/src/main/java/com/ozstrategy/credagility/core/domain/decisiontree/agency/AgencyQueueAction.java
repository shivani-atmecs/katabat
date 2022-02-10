package com.ozstrategy.credagility.core.domain.decisiontree.agency;

import com.cmc.credagility.core.domain.agency.AgencyExportConfiguration;
import com.cmc.credagility.core.domain.agency.AgencyExportLayout;
import com.cmc.credagility.core.domain.agency.AgencyMetaDataField;
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
import java.io.Serializable;
import java.util.*;


/**
 * This class is used to store AgencyQueueAction information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 16:59
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
public class AgencyQueueAction extends AgencyBaseNodeAction implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5771026919380839587L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "AgencyQueueAssignAgent",
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
    name               = "AgencyQueueAssignRole",
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
  protected Set<AgencyNode> queueNodes = new LinkedHashSet<AgencyNode>();


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
  private AgencyExportLayout exportLayout;
  // ------------------------

  @JoinColumn(
    name       = "exportLocationId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AgencyExportConfiguration exportLocation;
  private final transient Logger    logger = LoggerFactory.getLogger(getClass());

  @Transient private Set<Long> processedAccounts = new HashSet<Long>();

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "queueAction",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  private Set<AgencyQueueFeatureRestriction> restrictions = new LinkedHashSet<AgencyQueueFeatureRestriction>();

  /** Node actions. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "queueAction",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  private Set<AgencyQueueSortCriteria> sortCriterias = new LinkedHashSet<AgencyQueueSortCriteria>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AgencyQueueAction object.
   */
  public AgencyQueueAction() {
    actionType = BaseNodeAction.ActionType_Queue;
  }

  /**
   * Creates a new AgencyQueueAction object.
   *
   * @param  id  Long
   */
  public AgencyQueueAction(Long id) {
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
   * @param  restriction  AgencyQueueFeatureRestriction
   */
  public void addFeatureRestriction(AgencyQueueFeatureRestriction restriction) {
    restriction.setQueueAction(this);
    this.restrictions.add(restriction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addSortCriteria.
   *
   * @param  sortCriteria  AgencyQueueSortCriteria
   */
  public void addSortCriteria(AgencyQueueSortCriteria sortCriteria) {
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
   * @param  splitTag           String
   * @param  publishedSchedule  AgencySchedule
   */
  public void calculatePath(String splitTag, AgencySchedule publishedSchedule) {
    // reset path value when calculate restart
    this.path = "";

    List<StringBuilder> tempPaths = new ArrayList<StringBuilder>();

    for (AgencyNode qNode : queueNodes) {
      if (qNode.getStrategy().getSchedule().getId().equals(publishedSchedule.getId())) { // do not calculate other schedule's queue path.

        StringBuilder sb = new StringBuilder(this.getName());
        sb.append("!");
        sb.append(this.getId());

        AgencyNode parentNode = qNode.getParentNode();
        generateParentPath(parentNode, sb, splitTag);
        tempPaths.add(sb);
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

    if (logger.isDebugEnabled()) {
      logger.debug("path : " + this.path);
    }
  } // end method calculatePath

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculateTempPath.
   *
   * @param  splitTag           String
   * @param  publishedSchedule  AgencySchedule
   */
  public void calculateTempPath(String splitTag, AgencySchedule publishedSchedule) {
    // reset path value when calculate restart
    this.tempPath = "";

    List<StringBuilder> tempPaths = new ArrayList<StringBuilder>();

    for (AgencyNode qNode : queueNodes) {
      if (qNode.getStrategy().getSchedule().getId().equals(publishedSchedule.getId())) { // do not calculate other schedule's queue path.

        StringBuilder sb = new StringBuilder(this.getName());
        sb.append("!");
        sb.append(this.getId());

        AgencyNode parentNode = qNode.getParentNode();
        generateParentPath(parentNode, sb, splitTag);
        tempPaths.add(sb);
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
   * @see  com.ozstrategy.credagility.core.domain.BaseNodeAction#duplicate()
   */
  @Override public BaseNodeAction duplicate() {
    AgencyQueueAction queueAction = new AgencyQueueAction();
    queueAction.updateNodeAction(this);
    queueAction.setName(queueAction.getName());
    queueAction.setVisible(Boolean.TRUE);

    for (AgencyQueueSortCriteria sortCriteria : this.sortCriterias) {
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
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof AgencyQueueAction)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AgencyQueueAction that = (AgencyQueueAction) o;

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

        Role    role       = (Role) params.get("agency");
        boolean deltaBatch = (Boolean) params.get("deltaBatch");
        Long    batchId    = Long.parseLong((String) params.get("batchId"));

        if (deltaBatch) {
          if (logger.isDebugEnabled()) {
            logger.debug("create queue result from deltaBatch file.");
          }
        }

        TriggeredAgencyQueue agencyQueue = new TriggeredAgencyQueue();
        agencyQueue.setAgency(role);
        agencyQueue.setQueueAction(this);
        agencyQueue.setDeltaBatch(deltaBatch);
        agencyQueue.setMasterBatchId(batchId);

        executeHelper.addResult(agencyQueue);
      } // end if
    }   // end if
  }     // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findFeatureRestriction.
   *
   * @param   restriction  AgencyQueueFeatureRestriction
   *
   * @return  AgencyQueueFeatureRestriction
   */
  public AgencyQueueFeatureRestriction findFeatureRestriction(
    AgencyQueueFeatureRestriction restriction) {
    if (restriction == null) {
      return null;
    }

    if (restriction.getRestrictionId() != null) {
      // lookup through id
      for (AgencyQueueFeatureRestriction curRestriction : this.restrictions) {
        if (curRestriction.getRestrictionId().equals(
                restriction.getRestrictionId())) {
          return curRestriction;
        }
      }

      return null;
    } else {
      // lookup through equal
      Iterator<AgencyQueueFeatureRestriction> it = this.restrictions.iterator();

      while (it.hasNext()) {
        AgencyQueueFeatureRestriction ret = it.next();

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
   * @param   sortCriteria  AgencyQueueSortCriteria
   *
   * @return  AgencyQueueSortCriteria
   */
  public AgencyQueueSortCriteria findSortCriteria(AgencyQueueSortCriteria sortCriteria) {
    if (sortCriteria == null) {
      return null;
    }

    if (sortCriteria.getId() != null) {
      // lookup through id
      for (AgencyQueueSortCriteria curSortCriteria : this.sortCriterias) {
        if (curSortCriteria.getId().equals(sortCriteria.getId())) {
          return curSortCriteria;
        }
      }

      return null;
    } else {
      // lookup through equal
      Iterator<AgencyQueueSortCriteria> it = this.sortCriterias.iterator();

      while (it.hasNext()) {
        AgencyQueueSortCriteria ret = it.next();

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
   * getter method for export layout.
   *
   * @return  AgencyExportLayout
   */
  public AgencyExportLayout getExportLayout() {
    return exportLayout;
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
   * @return  AgencyExportConfiguration
   */
  public AgencyExportConfiguration getExportLocation() {
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
   * getter method for processed accounts.
   *
   * @return  Set
   */
  public Set<Long> getProcessedAccounts() {
    return processedAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue nodes.
   *
   * @return  Set
   */
  public Set<AgencyNode> getQueueNodes() {
    return queueNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for restrictions.
   *
   * @return  Set
   */
  public Set<AgencyQueueFeatureRestriction> getRestrictions() {
    return restrictions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sort criterias.
   *
   * @return  Set
   */
  public Set<AgencyQueueSortCriteria> getSortCriterias() {
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
    for (AgencyQueueFeatureRestriction restriction : this.restrictions) {
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
   * @param   restriction  AgencyQueueFeatureRestriction
   *
   * @return  AgencyQueueFeatureRestriction
   */
  public AgencyQueueFeatureRestriction removeFeatureRestriction(
    AgencyQueueFeatureRestriction restriction) {
    for (AgencyQueueFeatureRestriction curRestriction : this.restrictions) {
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
   * @param   sortCriteria  AgencyQueueSortCriteria
   *
   * @return  AgencyQueueSortCriteria
   */
  public AgencyQueueSortCriteria removeSortCriteria(AgencyQueueSortCriteria sortCriteria) {
    for (AgencyQueueSortCriteria curSortCriteria : this.sortCriterias) {
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
   * @param  agencyMetaDataField  AgencyMetaDataField
   * @param  sortCriteria         AgencyQueueSortCriteria
   */
  public void removeSortCriteriaByMetaData(AgencyMetaDataField agencyMetaDataField,
    AgencyQueueSortCriteria sortCriteria) {
    // lookup through equal
    Iterator<AgencyQueueSortCriteria> it        = this.sortCriterias.iterator();
    Set<AgencyQueueSortCriteria>      toRemoved = new HashSet<AgencyQueueSortCriteria>();

    while (it.hasNext()) {
      AgencyQueueSortCriteria ret = it.next();

      if (agencyMetaDataField.equals(ret.getAgencyMetaDataField()) && !ret.equals(sortCriteria)) {
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
   * setter method for export layout.
   *
   * @param  exportLayout  AgencyExportLayout
   */
  public void setExportLayout(AgencyExportLayout exportLayout) {
    this.exportLayout = exportLayout;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export layout id.
   *
   * @param  id  Long
   */
  public void setExportLayoutId(Long id) {
    if ((id != null) && (id != 0L)) {
      this.exportLayout = new AgencyExportLayout();
      this.exportLayout.setId(id);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export location.
   *
   * @param  exportLocation  AgencyExportConfiguration
   */
  public void setExportLocation(AgencyExportConfiguration exportLocation) {
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
      this.exportLocation = new AgencyExportConfiguration();
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
   * setter method for processed accounts.
   *
   * @param  processedAccounts  Set
   */
  public void setProcessedAccounts(Set<Long> processedAccounts) {
    this.processedAccounts = processedAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue nodes.
   *
   * @param  queueNodes  Set
   */
  public void setQueueNodes(Set<AgencyNode> queueNodes) {
    this.queueNodes = queueNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for restrictions.
   *
   * @param  restrictions  Set
   */
  public void setRestrictions(Set<AgencyQueueFeatureRestriction> restrictions) {
    this.restrictions = restrictions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sort criterias.
   *
   * @param  sortCriterias  Set
   */
  public void setSortCriterias(Set<AgencyQueueSortCriteria> sortCriterias) {
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
   * @see  Object#toString()
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
    this.exportLocation = ((AgencyQueueAction) queueAction).getExportLocation();

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

  private void generateParentPath(AgencyNode parent, StringBuilder sb, String splitTag) {
    if (parent != null) {
      if (parent.getNodeQueueActions().size() > 0) {
        sb.append(splitTag);

        Set<AgencyQueueAction> queues    = parent.getNodeQueueActions();
        int                    loopIndex = 0;

        for (AgencyQueueAction queue : queues) {
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

} // end class AgencyQueueAction
