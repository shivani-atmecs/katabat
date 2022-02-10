package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.ozstrategy.credagility.core.annotations.EvaluateMessageProperty;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStepTaskSnapshot;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskVersion;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 12/5/13 Time: 11:42 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCIWorkflowStepTaskSnapshot")
public class BCIWorkflowStepTaskSnapshot extends BasicWorkflowStepTaskSnapshot implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8495410998232116569L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @EvaluateMessageProperty @Lob protected String customerIntroduction;


  /** customer PostText. */
  @Column(columnDefinition = "LONGTEXT")
  @EvaluateMessageProperty @Lob protected String customerPostText;


  /** flexSite no access Text. */
  @Column(columnDefinition = "LONGTEXT")
  @EvaluateMessageProperty @Lob protected String flexSiteNAText;


  /** flexSite no access Title. */
  @Column(columnDefinition = "LONGTEXT")
  @EvaluateMessageProperty @Lob protected String flexSiteNATitle;

  /** BCIWorkflowStep PK stepId. */
  @JoinColumn(
    name       = "stepId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowStep workflowStep;


  /** BCWorkflowTask PK taskId. */
  @JoinColumn(
    name       = "taskId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTask workflowTask;

  /** BCWorkflowTaskVersion PK taskVersionId. */
  @JoinColumn(
    name       = "taskVersionId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskVersion workflowTaskVersion;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowStepTaskSnapshot copy() {
    BCIWorkflowStepTaskSnapshot taskSnapshot = new BCIWorkflowStepTaskSnapshot();
    taskSnapshot.setAgentIntroduction(this.getAgentIntroduction());
    taskSnapshot.setAgentPostText(this.getAgentPostText());
    taskSnapshot.setFlexStationNAText(this.getFlexStationNAText());
    taskSnapshot.setFlexStationNATitle(this.getFlexStationNATitle());
    taskSnapshot.setWorkflowTask(this.getWorkflowTask());
    taskSnapshot.setWorkflowTaskVersion(this.getWorkflowTaskVersion());
    taskSnapshot.setCustomerIntroduction(this.getCustomerIntroduction());
    taskSnapshot.setCustomerPostText(this.getCustomerPostText());
    taskSnapshot.setFlexSiteNAText(this.getFlexSiteNAText());
    taskSnapshot.setFlexSiteNATitle(this.getFlexSiteNATitle());

    return taskSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer introduction.
   *
   * @return  String
   */
  public String getCustomerIntroduction() {
    return customerIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer post text.
   *
   * @return  String
   */
  public String getCustomerPostText() {
    return customerPostText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site NAText.
   *
   * @return  String
   */
  public String getFlexSiteNAText() {
    return flexSiteNAText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site NATitle.
   *
   * @return  String
   */
  public String getFlexSiteNATitle() {
    return flexSiteNATitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTask getWorkflowTask() {
    return workflowTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskVersion getWorkflowTaskVersion() {
    return workflowTaskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer introduction.
   *
   * @param  customerIntroduction  String
   */
  public void setCustomerIntroduction(String customerIntroduction) {
    this.customerIntroduction = customerIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer post text.
   *
   * @param  customerPostText  String
   */
  public void setCustomerPostText(String customerPostText) {
    this.customerPostText = customerPostText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site NAText.
   *
   * @param  flexSiteNAText  String
   */
  public void setFlexSiteNAText(String flexSiteNAText) {
    this.flexSiteNAText = flexSiteNAText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site NATitle.
   *
   * @param  flexSiteNATitle  String
   */
  public void setFlexSiteNATitle(String flexSiteNATitle) {
    this.flexSiteNATitle = flexSiteNATitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowStep  DOCUMENT ME!
   */
  public void setWorkflowStep(BCIWorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowTask  DOCUMENT ME!
   */
  public void setWorkflowTask(BCWorkflowTask workflowTask) {
    this.workflowTask = workflowTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowTaskVersion  DOCUMENT ME!
   */
  public void setWorkflowTaskVersion(BCWorkflowTaskVersion workflowTaskVersion) {
    this.workflowTaskVersion = workflowTaskVersion;
  }
} // end class BCIWorkflowStepTaskSnapshot
