package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.PortfolioSurvey;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyVersion;
import com.ozstrategy.credagility.core.annotations.EvaluateMessageProperty;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * the Snapshot of SurveyflowStepTask info.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 16:20
 */
@Entity @Table public class SurveyflowStepTaskSnapshot implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7318284363830599637L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** inactive. */
  @Transient public boolean inactive;


  /** agent Introduction. */
  @Column(columnDefinition = "LONGTEXT")
  @EvaluateMessageProperty @Lob protected String agentIntroduction;


  /** agent PostText. */
  @Column(columnDefinition = "LONGTEXT")
  @EvaluateMessageProperty @Lob protected String agentPostText;


  /** customer Introduction. */
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

  /** flexStation no access Text. */
  @Column(columnDefinition = "LONGTEXT")
  @EvaluateMessageProperty @Lob protected String flexStationNAText;


  /** flexStation no access title. */
  @Column(columnDefinition = "LONGTEXT")
  @EvaluateMessageProperty @Lob protected String flexStationNATitle;


  /** PK. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** PortfolioSurvey. */
  @JoinColumn(
    name       = "taskId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioSurvey portfolioSurvey;


  /** PortfolioSurveyVersion. */
  @JoinColumn(
    name       = "taskVersionId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioSurveyVersion portfolioSurveyVersion;


  /** SurveyFlowStep. */
  @JoinColumn(
    name       = "stepId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  protected SurveyFlowStep surveyFlowStep;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new SurveyflowStepTaskSnapshot object.
   */
  public SurveyflowStepTaskSnapshot() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @return  SurveyflowStepTaskSnapshot
   */
  public SurveyflowStepTaskSnapshot copy() {
    SurveyflowStepTaskSnapshot taskSnapshot = new SurveyflowStepTaskSnapshot();
    taskSnapshot.setAgentIntroduction(this.getAgentIntroduction());
    taskSnapshot.setAgentPostText(this.getAgentPostText());
    taskSnapshot.setFlexStationNAText(this.getFlexStationNAText());
    taskSnapshot.setFlexStationNATitle(this.getFlexStationNATitle());
    taskSnapshot.setCustomerIntroduction(this.getCustomerIntroduction());
    taskSnapshot.setCustomerPostText(this.getCustomerPostText());
    taskSnapshot.setFlexSiteNAText(this.getFlexSiteNAText());
    taskSnapshot.setFlexSiteNATitle(this.getFlexSiteNATitle());
    taskSnapshot.setPortfolioSurvey(this.getPortfolioSurvey());
    taskSnapshot.setPortfolioSurveyVersion(this.getPortfolioSurveyVersion());

    return taskSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent introduction.
   *
   * @return  String
   */
  public String getAgentIntroduction() {
    return agentIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent post text.
   *
   * @return  String
   */
  public String getAgentPostText() {
    return agentPostText;
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
   * getter method for flex station NAText.
   *
   * @return  String
   */
  public String getFlexStationNAText() {
    return flexStationNAText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex station NATitle.
   *
   * @return  String
   */
  public String getFlexStationNATitle() {
    return flexStationNATitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio survey.
   *
   * @return  PortfolioSurvey
   */
  public PortfolioSurvey getPortfolioSurvey() {
    return portfolioSurvey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio survey version.
   *
   * @return  PortfolioSurveyVersion
   */
  public PortfolioSurveyVersion getPortfolioSurveyVersion() {
    return portfolioSurveyVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow step.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep getSurveyFlowStep() {
    return surveyFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for inactive.
   *
   * @return  boolean
   */
  public boolean isInactive() {
    return inactive;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent introduction.
   *
   * @param  agentIntroduction  String
   */
  public void setAgentIntroduction(String agentIntroduction) {
    this.agentIntroduction = agentIntroduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent post text.
   *
   * @param  agentPostText  String
   */
  public void setAgentPostText(String agentPostText) {
    this.agentPostText = agentPostText;
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
   * setter method for flex station NAText.
   *
   * @param  flexStationNAText  String
   */
  public void setFlexStationNAText(String flexStationNAText) {
    this.flexStationNAText = flexStationNAText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex station NATitle.
   *
   * @param  flexStationNATitle  String
   */
  public void setFlexStationNATitle(String flexStationNATitle) {
    this.flexStationNATitle = flexStationNATitle;
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
   * setter method for inactive.
   *
   * @param  inactive  boolean
   */
  public void setInactive(boolean inactive) {
    this.inactive = inactive;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio survey.
   *
   * @param  portfolioSurvey  PortfolioSurvey
   */
  public void setPortfolioSurvey(PortfolioSurvey portfolioSurvey) {
    this.portfolioSurvey = portfolioSurvey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio survey version.
   *
   * @param  portfolioSurveyVersion  PortfolioSurveyVersion
   */
  public void setPortfolioSurveyVersion(PortfolioSurveyVersion portfolioSurveyVersion) {
    this.portfolioSurveyVersion = portfolioSurveyVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey flow step.
   *
   * @param  surveyFlowStep  SurveyFlowStep
   */
  public void setSurveyFlowStep(SurveyFlowStep surveyFlowStep) {
    this.surveyFlowStep = surveyFlowStep;
  }
} // end class SurveyflowStepTaskSnapshot
