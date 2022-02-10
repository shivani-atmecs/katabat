package com.ozstrategy.credagility.core.domain.workflow.basic;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 12/5/13 Time: 11:39 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflowStepTaskSnapshot implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8333259762901171396L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> is inactive. */
  @Transient public boolean inactive;

  /** Introduction workflow in flex station. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String agentIntroduction;

  /** workflow post text iin flex station. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String agentPostText;

  /** If the user no access to execute workflow text. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String flexStationNAText;

  /** If the user no access to execute workflow title. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String flexStationNATitle;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAgentIntroduction() {
    return agentIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAgentPostText() {
    return agentPostText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFlexStationNAText() {
    return flexStationNAText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFlexStationNATitle() {
    return flexStationNATitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isInactive() {
    return inactive;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentIntroduction  DOCUMENT ME!
   */
  public void setAgentIntroduction(String agentIntroduction) {
    this.agentIntroduction = agentIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentPostText  DOCUMENT ME!
   */
  public void setAgentPostText(String agentPostText) {
    this.agentPostText = agentPostText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexStationNAText  DOCUMENT ME!
   */
  public void setFlexStationNAText(String flexStationNAText) {
    this.flexStationNAText = flexStationNAText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexStationNATitle  DOCUMENT ME!
   */
  public void setFlexStationNATitle(String flexStationNATitle) {
    this.flexStationNATitle = flexStationNATitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  inactive  DOCUMENT ME!
   */
  public void setInactive(boolean inactive) {
    this.inactive = inactive;
  }
} // end class BasicWorkflowStepTaskSnapshot
