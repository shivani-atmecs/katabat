package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * SurveyFlow HotSpots Assignment.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 11:16
 */
@Entity
@Table(
  name              = "SurveyFlowHotSpotsAssignment",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "hotSpotId", "surveyFlowId" }) }
)
public class SurveyFlowHotSpotsAssignment extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2255728516327210449L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean openInCurrentTab;

  @Transient private SurveyFlow executedWorkflow;

  @JoinColumn(
    name       = "hotSpotId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private HotSpot hotSpot;

  @Column(columnDefinition = "LONGTEXT")
  @Lob private String hotSpotAliasName;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @JoinColumn(
    name       = "surveyFlowId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private SurveyFlow surveyFlow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    SurveyFlowHotSpotsAssignment that = (SurveyFlowHotSpotsAssignment) o;

    if ((hotSpot != null) ? (!hotSpot.equals(that.hotSpot)) : (that.hotSpot != null)) {
      return false;
    }

    if ((surveyFlow != null) ? (!surveyFlow.equals(that.surveyFlow)) : (that.surveyFlow != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for executed workflow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getExecutedWorkflow() {
    return executedWorkflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hot spot.
   *
   * @return  HotSpot
   */
  public HotSpot getHotSpot() {
    return hotSpot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hot spot alias name.
   *
   * @return  String
   */
  public String getHotSpotAliasName() {
    return hotSpotAliasName;
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
   * getter method for open in current tab.
   *
   * @return  Boolean
   */
  public Boolean getOpenInCurrentTab() {
    if (openInCurrentTab == null) {
      return Boolean.FALSE;
    }

    return openInCurrentTab;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getSurveyFlow() {
    return surveyFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((hotSpot != null) ? hotSpot.hashCode() : 0);
    result = (31 * result) + ((surveyFlow != null) ? surveyFlow.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for executed workflow.
   *
   * @param  executedWorkflow  SurveyFlow
   */
  public void setExecutedWorkflow(SurveyFlow executedWorkflow) {
    this.executedWorkflow = executedWorkflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hot spot.
   *
   * @param  hotSpot  HotSpot
   */
  public void setHotSpot(HotSpot hotSpot) {
    this.hotSpot = hotSpot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hot spot alias name.
   *
   * @param  hotSpotAliasName  String
   */
  public void setHotSpotAliasName(String hotSpotAliasName) {
    this.hotSpotAliasName = hotSpotAliasName;
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
   * setter method for open in current tab.
   *
   * @param  openInCurrentTab  Boolean
   */
  public void setOpenInCurrentTab(Boolean openInCurrentTab) {
    this.openInCurrentTab = openInCurrentTab;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey flow.
   *
   * @param  surveyFlow  SurveyFlow
   */
  public void setSurveyFlow(SurveyFlow surveyFlow) {
    this.surveyFlow = surveyFlow;
  }
} // end class SurveyFlowHotSpotsAssignment
