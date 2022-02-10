package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * This class is used to store node action information.
 *
 * <p><a href="BaseNodeAction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 11:02
 */
@MappedSuperclass public abstract class BaseNodeAction extends CreatorEntity implements Executable, Evaluable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final String ActionType_Program = "Program";


  /** TODO: DOCUMENT ME! */
  public static final String ActionType_Channel = "Channel";


  /** TODO: DOCUMENT ME! */
  public static final String ActionType_Queue = "Queue";

  /** TODO: DOCUMENT ME! */
  public static final String ActionType_Persona = "Persona";


  /** TODO: DOCUMENT ME! */
  public static final String ActionType_Score = "Score";


  /** TODO: DOCUMENT ME! */
  public static final String ActionType_Flow = "Flow";


  /** TODO: DOCUMENT ME! */
  public static final String ActionType_AGENCYASSIGN = "agencyAssign";


  /** TODO: DOCUMENT ME! */
  public static final String ActionType_AGENTASSIGN = "agentAssign";

  /** TODO: DOCUMENT ME! */
  public static final String ActionType_Status = "statusAction";

  /** TODO: DOCUMENT ME! */
  public static final String ActionType_Update = "updateAction";

  public static final String ActionType_BUREAUIMPORT = "bureauImport";

  public static final String ActionType_DATAEXPORT = "dataExport";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** node action type. */
  @Column(length = 32)
  protected String actionType;


  /** TODO: DOCUMENT ME! */
  @Transient protected List<Long> affectScheduleIds = new ArrayList<Long>();


  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long copyFromId;


  /** TODO: DOCUMENT ME! */
  @Lob protected String criteria;

  /** Description for the node action. */
  @Column(length = 255)
  protected String description;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(generator = "assigned")
  @GenericGenerator(
    name     = "assigned",
    strategy = "assigned"
  )
  @Id protected Long id;

  /** Name for the node action. */
  @Column(length = 255)
  protected String name;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Integer permanenceCode;


  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority = 1;

  /** action run type: CID/Strategy/All. */
  @Column(length = 32)
  protected String runType;

  /** Action trigger flag. */
  @Transient protected Boolean triggered = false;


  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean locked = false;


  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  BaseNodeAction
   */
  public abstract BaseNodeAction duplicate();

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

    BaseNodeAction that = (BaseNodeAction) o;

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Evaluate.
   *
   * @param   helper  for evaluate
   *
   * @return  evaluate result
   */
  @Override public boolean evaluate(EvaluateHelper helper) {
    return helper.evaluate(this);
  }
  /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Action type.
   *
   * @return  action type
   */
  public String getActionType() {
    return actionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for affect schedule ids.
   *
   * @return  List
   */
  public List<Long> getAffectScheduleIds() {
    return affectScheduleIds;
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
   * Action optional Condition.
   *
   * @return  action optional Condition.
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The description.
   *
   * @return  the description
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for force mapping variable.
   *
   * @return  Map
   */
  public Map<String, BaseVariable> getForceMappingVariable() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Node action id .
   *
   * @return  action id
   */
  public Long getId() {
    return id;
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
   * Node name .
   *
   * @return  node name
   */
  public String getName() {
    return name;
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
   * Flag for this node was triggered.
   *
   * @return  triggered flag
   */
  public Boolean getTriggered() {
    if (triggered == null) {
      return Boolean.FALSE;
    }

    return triggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = 47;
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lockSelf.
   *
   * @param  agent  User
   */
  public void lockSelf(User agent) {
    this.setLocked(true);
    this.setLastUpdater(agent);
    this.setLastUpdateDate(new Date());
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
   * setter method for affect schedule ids.
   *
   * @param  affectScheduleIds  List
   */
  public void setAffectScheduleIds(List<Long> affectScheduleIds) {
    this.affectScheduleIds = affectScheduleIds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for complete criteria.
   *
   * @param  criteria  String
   */
  public void setCompleteCriteria(String criteria) { }

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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
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

    if (this.name != null) {
      this.name = this.name.trim();
    }
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy name.
   *
   * @param  name  String
   */
  public void setStrategyName(String name) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for triggered.
   *
   * @param  triggered  Boolean
   */
  public void setTriggered(Boolean triggered) {
    this.triggered = triggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("BaseNodeAction");
    sb.append("{actionType='").append(actionType).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update node Action based on passed in template .
   *
   * <p>.@param baseNodeAction to use for update</p>
   *
   * @param   baseNodeAction  BaseNodeAction
   *
   * @return  true if changes detected, false nothing updated
   */
  public boolean updateNodeAction(BaseNodeAction baseNodeAction) {
    this.copyFromId     = baseNodeAction.getId();
    this.name           = baseNodeAction.getName();
    this.criteria       = baseNodeAction.getCriteria();
    this.runType        = baseNodeAction.getRunType();
    this.description    = baseNodeAction.getDescription();
    this.permanenceCode = baseNodeAction.getPermanenceCode();
    this.priority       = baseNodeAction.getPriority();
    this.lastUpdateDate = new Date();
    setCreator(baseNodeAction.getCreator());
    setLastUpdater(baseNodeAction.getCreator());

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Verify.
   *
   * @param  helper  for verify
   */
  @Override public void verify(EvaluateHelper helper) {
    helper.verify(this);
  }
} // end class BaseNodeAction
