package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-2-19 : PM4:03</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflow<W extends BasicWorkflow> extends CreatorEntity
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1153706906237647976L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> this workflow as sub-flow, default is <code>false.</code> */
  @Column(
    name             = "asSubFlow",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean asSubFlow = false;

  /** Workflow Audit instance pass criteria. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String auditPassCriteria;

  /** Criteria for enter this workflow. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String criteria;

  /** Workflow name. */
  @Column(
    length   = 256,
    nullable = false
  )
  protected String name;

  /** Workflow priority. */
  @Column protected Integer priority;

  /** <code>true</code> allow how step info in flex site, default is <code>false.</code> */
  @Column(
    name             = "showStepInSite",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showStepInSite = false;

  /** Workflow tag. */
  @Column(
    length   = 50,
    nullable = true
  )
  protected String tag;

  /** Workflow copy from PK Workflow id. */
  @Column(nullable = true)
  private Long copyFromId;

  /** workflow title in flex site. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob private String customerTitle;

  @Column private Integer flowFrequency;

  @Column private Long frequencyMinutes;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  copyFrom  DOCUMENT ME!
   * @param  user      DOCUMENT ME!
   */
  public abstract void deepCopy(W copyFrom, User user);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<User> getAssignAgents();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<Role> getAssignRoles();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<Role> getAuditAssignRoles();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Long getId();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<? extends BasicWorkflowLink> getLinks();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<? extends BasicWorkflowNode> getNodes();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<BaseVariable> getResetVariables();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BasicWorkflowSchedule getSchedule();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public abstract void setId(Long id);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  user  DOCUMENT ME!
   */
  public void addAssignAgent(User user) {
    if (null != user) {
      this.getAssignAgents().add(user);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  role  DOCUMENT ME!
   */
  public void addAssignRole(Role role) {
    if (null != role) {
      this.getAssignRoles().add(role);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  role  DOCUMENT ME!
   */
  public void addAuditAssignRole(Role role) {
    if (null != role) {
      this.getAuditAssignRoles().add(role);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  copyFrom  DOCUMENT ME!
   * @param  user      DOCUMENT ME!
   */
  @SuppressWarnings("unchecked")
  public void copy(BasicWorkflow copyFrom, User user) {
    setName(copyFrom.getName());
    setCopyFromId(copyFrom.getId());
    setPriority(copyFrom.getPriority());
    setCriteria(copyFrom.getCriteria());
    setAsSubFlow(copyFrom.getAsSubFlow());
    setShowStepInSite(copyFrom.getShowStepInSite());
    setFlowFrequency(copyFrom.getFlowFrequency());
    setFrequencyMinutes(copyFrom.getFrequencyMinutes());
    setCustomerTitle(copyFrom.getCustomerTitle());
    setTag(copyFrom.getTag());
    setAuditPassCriteria(copyFrom.getAuditPassCriteria());

    Set<BaseVariable> vars             = copyFrom.getResetVariables();
    Set<User>         assignAgents     = copyFrom.getAssignAgents();
    Set<Role>         assignRoles      = copyFrom.getAssignRoles();
    Set<Role>         auditAssignRoles = copyFrom.getAuditAssignRoles();

    for (BaseVariable variable : vars) {
      this.getResetVariables().add(variable);
    }

    // ----- add assigned agents & roles -------------
    for (User agent : assignAgents) {
      addAssignAgent(agent);
    }

    for (Role role : assignRoles) {
      addAssignRole(role);
    }

    // ----- copy audit role --------------------------
    for (Role auditRole : auditAssignRoles) {
      addAuditAssignRole(auditRole);
    }
  } // end method copy

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

    BasicWorkflow that = (BasicWorkflow) o;

    if ((asSubFlow != null) ? (!asSubFlow.equals(that.asSubFlow)) : (that.asSubFlow != null)) {
      return false;
    }

    if ((copyFromId != null) ? (!copyFromId.equals(that.copyFromId)) : (that.copyFromId != null)) {
      return false;
    }

    if ((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null)) {
      return false;
    }

    if ((flowFrequency != null) ? (!flowFrequency.equals(that.flowFrequency)) : (that.flowFrequency != null)) {
      return false;
    }

    if ((frequencyMinutes != null) ? (!frequencyMinutes.equals(that.frequencyMinutes))
                                   : (that.frequencyMinutes != null)) {
      return false;
    }

    if (!name.equals(that.name)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    if ((showStepInSite != null) ? (!showStepInSite.equals(that.showStepInSite)) : (that.showStepInSite != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAccessType() {
    boolean hasUserAccess = false;
    boolean hasRoleAccess = false;

    if (this.getAssignAgents().size() > 0) {
      hasUserAccess = true;
    }

    if (this.getAssignRoles().size() > 0) {
      hasRoleAccess = true;
    }

    if (hasUserAccess && hasRoleAccess) {
      return "UR";
    } else if (hasUserAccess) {
      return "U";
    } else if (hasRoleAccess) {
      return "R";
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAsSubFlow() {
    if (asSubFlow == null) {
      return Boolean.FALSE;
    }

    return asSubFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAuditPassCriteria() {
    return auditPassCriteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getCopyFromId() {
    return copyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustomerTitle() {
    return customerTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getFlowFrequency() {
    return flowFrequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getFrequencyMinutes() {
    return frequencyMinutes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getShowStepInSite() {
    if (showStepInSite == null) {
      return Boolean.FALSE;
    }

    return showStepInSite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTag() {
    return tag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public int getTotalNode() {
    return getNodes().size();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + name.hashCode();
    result = (31 * result) + ((asSubFlow != null) ? asSubFlow.hashCode() : 0);
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((showStepInSite != null) ? showStepInSite.hashCode() : 0);
    result = (31 * result) + ((copyFromId != null) ? copyFromId.hashCode() : 0);
    result = (31 * result) + ((flowFrequency != null) ? flowFrequency.hashCode() : 0);
    result = (31 * result) + ((frequencyMinutes != null) ? frequencyMinutes.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  asSubFlow  DOCUMENT ME!
   */
  public void setAsSubFlow(Boolean asSubFlow) {
    this.asSubFlow = asSubFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  auditPassCriteria  DOCUMENT ME!
   */
  public void setAuditPassCriteria(String auditPassCriteria) {
    this.auditPassCriteria = auditPassCriteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  copyFromId  DOCUMENT ME!
   */
  public void setCopyFromId(Long copyFromId) {
    this.copyFromId = copyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  criteria  DOCUMENT ME!
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerTitle  DOCUMENT ME!
   */
  public void setCustomerTitle(String customerTitle) {
    this.customerTitle = customerTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flowFrequency  DOCUMENT ME!
   */
  public void setFlowFrequency(Integer flowFrequency) {
    this.flowFrequency = flowFrequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  frequencyMinutes  DOCUMENT ME!
   */
  public void setFrequencyMinutes(Long frequencyMinutes) {
    this.frequencyMinutes = frequencyMinutes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  priority  DOCUMENT ME!
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  showStepInSite  DOCUMENT ME!
   */
  public void setShowStepInSite(Boolean showStepInSite) {
    this.showStepInSite = showStepInSite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  tag  DOCUMENT ME!
   */
  public void setTag(String tag) {
    this.tag = tag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Workflow");
    sb.append("{name='").append(name).append('\'');
    sb.append(", asSubFlow=").append(asSubFlow);
    sb.append(", criteria='").append(criteria).append('\'');
    sb.append(", priority=").append(priority);
    sb.append(", schedule=").append(getSchedule().getName());
    sb.append(", showStepInSite=").append(showStepInSite);
    sb.append(", flowFrequency=").append(flowFrequency);
    sb.append(", frequencyMinutes=").append(frequencyMinutes);
    sb.append('}');

    return sb.toString();
  }
} // end class BasicWorkflow
