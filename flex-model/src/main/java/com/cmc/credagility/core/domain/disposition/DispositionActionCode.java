package com.cmc.credagility.core.domain.disposition;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:16
 */
@Entity
@Table(name = "DispositionActionCode")
public class DispositionActionCode extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -85715003026940915L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------

  /** DispositionActionCode identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long actionId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "actionName",
    length = 50
  )
  protected String actionName;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "dispositionActionCode"
  )
  protected Set<CoreAgentDispositionCategory> coreAgentDispositionCategory =
    new HashSet<CoreAgentDispositionCategory>();

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
   * getter method for action name.
   *
   * @return  String
   */
  public String getActionName() {
    return actionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for core agent disposition category.
   *
   * @return  Set
   */
  public Set<CoreAgentDispositionCategory> getCoreAgentDispositionCategory() {
    return coreAgentDispositionCategory;
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
   * setter method for action name.
   *
   * @param  actionName  String
   */
  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for core agent disposition category.
   *
   * @param  coreAgentDispositionCategory  Set
   */
  public void setCoreAgentDispositionCategory(Set<CoreAgentDispositionCategory> coreAgentDispositionCategory) {
    this.coreAgentDispositionCategory = coreAgentDispositionCategory;
  }
} // end class DispositionActionCode
