package com.ozstrategy.credagility.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Workflow Task Performance Report.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 17:12
 */
@Entity
@Table(name = "WorkflowTaskPerformanceReportItem")
public class WorkflowTaskPerformanceReportItem implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6368251149521344633L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column protected Long agentId;

  /** TODO: DOCUMENT ME! */
  @Column protected Double avgToday;

  /** TODO: DOCUMENT ME! */
  @Column protected Double avgTotal;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer cptToday;

  /** TODO: DOCUMENT ME! */
  @Column protected Date createDate;

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String depthNamePath;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String depthPath;

  /** TODO: DOCUMENT ME! */
  @Column protected Long flowId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 256)
  protected String flowName;

  /** PK. */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long         id;

  /** TODO: DOCUMENT ME! */
  @Column protected Long nodeId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 20)
  protected String nodeType;

  /** TODO: DOCUMENT ME! */
  @Column protected Long portfolioId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 80)
  protected String portfolioName;

  /** TODO: DOCUMENT ME! */
  @Column protected Long scheduleId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String scheduleName;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck100d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck10d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck15d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck1d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck200d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck20d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck2d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck30d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck3d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck40d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck4d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck50d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck5d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck60d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck6d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck70d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck7d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck80d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck8d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck90d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuck9d;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer stuckCount;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer totalCount;

  /** TODO: DOCUMENT ME! */
  @Column(length = 20)
  protected String type;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent id.
   *
   * @return  Long
   */
  public Long getAgentId() {
    return agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for avg today.
   *
   * @return  Double
   */
  public Double getAvgToday() {
    return avgToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for avg total.
   *
   * @return  Double
   */
  public Double getAvgTotal() {
    return avgTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cpt today.
   *
   * @return  Integer
   */
  public Integer getCptToday() {
    return cptToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for create date.
   *
   * @return  Date
   */
  public Date getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for depth name path.
   *
   * @return  String
   */
  public String getDepthNamePath() {
    return depthNamePath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for depth path.
   *
   * @return  String
   */
  public String getDepthPath() {
    return depthPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow id.
   *
   * @return  Long
   */
  public Long getFlowId() {
    return flowId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow name.
   *
   * @return  String
   */
  public String getFlowName() {
    return flowName;
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
   * getter method for node id.
   *
   * @return  Long
   */
  public Long getNodeId() {
    return nodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node type.
   *
   * @return  String
   */
  public String getNodeType() {
    return nodeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio id.
   *
   * @return  Long
   */
  public Long getPortfolioId() {
    return portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio name.
   *
   * @return  String
   */
  public String getPortfolioName() {
    return portfolioName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule id.
   *
   * @return  Long
   */
  public Long getScheduleId() {
    return scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule name.
   *
   * @return  String
   */
  public String getScheduleName() {
    return scheduleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck100d.
   *
   * @return  Integer
   */
  public Integer getStuck100d() {
    return stuck100d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck10d.
   *
   * @return  Integer
   */
  public Integer getStuck10d() {
    return stuck10d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck15d.
   *
   * @return  Integer
   */
  public Integer getStuck15d() {
    return stuck15d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck1d.
   *
   * @return  Integer
   */
  public Integer getStuck1d() {
    return stuck1d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck200d.
   *
   * @return  Integer
   */
  public Integer getStuck200d() {
    return stuck200d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck20d.
   *
   * @return  Integer
   */
  public Integer getStuck20d() {
    return stuck20d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck2d.
   *
   * @return  Integer
   */
  public Integer getStuck2d() {
    return stuck2d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck30d.
   *
   * @return  Integer
   */
  public Integer getStuck30d() {
    return stuck30d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck3d.
   *
   * @return  Integer
   */
  public Integer getStuck3d() {
    return stuck3d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck40d.
   *
   * @return  Integer
   */
  public Integer getStuck40d() {
    return stuck40d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck4d.
   *
   * @return  Integer
   */
  public Integer getStuck4d() {
    return stuck4d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck50d.
   *
   * @return  Integer
   */
  public Integer getStuck50d() {
    return stuck50d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck5d.
   *
   * @return  Integer
   */
  public Integer getStuck5d() {
    return stuck5d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck60d.
   *
   * @return  Integer
   */
  public Integer getStuck60d() {
    return stuck60d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck6d.
   *
   * @return  Integer
   */
  public Integer getStuck6d() {
    return stuck6d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck70d.
   *
   * @return  Integer
   */
  public Integer getStuck70d() {
    return stuck70d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck7d.
   *
   * @return  Integer
   */
  public Integer getStuck7d() {
    return stuck7d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck80d.
   *
   * @return  Integer
   */
  public Integer getStuck80d() {
    return stuck80d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck8d.
   *
   * @return  Integer
   */
  public Integer getStuck8d() {
    return stuck8d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck90d.
   *
   * @return  Integer
   */
  public Integer getStuck90d() {
    return stuck90d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck9d.
   *
   * @return  Integer
   */
  public Integer getStuck9d() {
    return stuck9d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck count.
   *
   * @return  Integer
   */
  public Integer getStuckCount() {
    return stuckCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stuck count by day.
   *
   * @param   day  Integer
   *
   * @return  Integer
   */
  public Integer getStuckCountByDay(Integer day) {
    Integer stuckCount = null;

    switch (day) {
      case 1: {
        stuckCount = stuck1d;

        break;
      }

      case 2: {
        stuckCount = stuck2d;

        break;
      }

      case 3: {
        stuckCount = stuck3d;

        break;
      }

      case 4: {
        stuckCount = stuck4d;

        break;
      }

      case 5: {
        stuckCount = stuck5d;

        break;
      }

      case 6: {
        stuckCount = stuck6d;

        break;
      }

      case 7: {
        stuckCount = stuck7d;

        break;
      }

      case 8: {
        stuckCount = stuck8d;

        break;
      }

      case 9: {
        stuckCount = stuck9d;

        break;
      }

      case 10: {
        stuckCount = stuck10d;

        break;
      }

      case 15: {
        stuckCount = stuck15d;

        break;
      }

      case 20: {
        stuckCount = stuck20d;

        break;
      }

      case 30: {
        stuckCount = stuck30d;

        break;
      }

      case 40: {
        stuckCount = stuck40d;

        break;
      }

      case 50: {
        stuckCount = stuck50d;

        break;
      }

      case 60: {
        stuckCount = stuck60d;

        break;
      }

      case 70: {
        stuckCount = stuck70d;

        break;
      }

      case 80: {
        stuckCount = stuck80d;

        break;
      }

      case 90: {
        stuckCount = stuck90d;

        break;
      }

      case 100: {
        stuckCount = stuck100d;

        break;
      }

      case 200: {
        stuckCount = stuck200d;

        break;
      }

      default: { }
    } // end switch

    return stuckCount;
  } // end method getStuckCountByDay

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total count.
   *
   * @return  Integer
   */
  public Integer getTotalCount() {
    return totalCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent id.
   *
   * @param  agentId  Long
   */
  public void setAgentId(Long agentId) {
    this.agentId = agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for avg today.
   *
   * @param  avgToday  Double
   */
  public void setAvgToday(Double avgToday) {
    this.avgToday = avgToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for avg total.
   *
   * @param  avgTotal  Double
   */
  public void setAvgTotal(Double avgTotal) {
    this.avgTotal = avgTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cpt today.
   *
   * @param  cptToday  Integer
   */
  public void setCptToday(Integer cptToday) {
    this.cptToday = cptToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for create date.
   *
   * @param  createDate  Date
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for depth name path.
   *
   * @param  depthNamePath  String
   */
  public void setDepthNamePath(String depthNamePath) {
    this.depthNamePath = depthNamePath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for depth path.
   *
   * @param  depthPath  String
   */
  public void setDepthPath(String depthPath) {
    this.depthPath = depthPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow id.
   *
   * @param  flowId  Long
   */
  public void setFlowId(Long flowId) {
    this.flowId = flowId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow name.
   *
   * @param  flowName  String
   */
  public void setFlowName(String flowName) {
    this.flowName = flowName;
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
   * setter method for node id.
   *
   * @param  nodeId  Long
   */
  public void setNodeId(Long nodeId) {
    this.nodeId = nodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node type.
   *
   * @param  nodeType  String
   */
  public void setNodeType(String nodeType) {
    this.nodeType = nodeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio id.
   *
   * @param  portfolioId  Long
   */
  public void setPortfolioId(Long portfolioId) {
    this.portfolioId = portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio name.
   *
   * @param  portfolioName  String
   */
  public void setPortfolioName(String portfolioName) {
    this.portfolioName = portfolioName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule id.
   *
   * @param  scheduleId  Long
   */
  public void setScheduleId(Long scheduleId) {
    this.scheduleId = scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule name.
   *
   * @param  scheduleName  String
   */
  public void setScheduleName(String scheduleName) {
    this.scheduleName = scheduleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck100d.
   *
   * @param  stuck100d  Integer
   */
  public void setStuck100d(Integer stuck100d) {
    this.stuck100d = stuck100d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck10d.
   *
   * @param  stuck10d  Integer
   */
  public void setStuck10d(Integer stuck10d) {
    this.stuck10d = stuck10d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck15d.
   *
   * @param  stuck15d  Integer
   */
  public void setStuck15d(Integer stuck15d) {
    this.stuck15d = stuck15d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck1d.
   *
   * @param  stuck1d  Integer
   */
  public void setStuck1d(Integer stuck1d) {
    this.stuck1d = stuck1d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck200d.
   *
   * @param  stuck200d  Integer
   */
  public void setStuck200d(Integer stuck200d) {
    this.stuck200d = stuck200d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck20d.
   *
   * @param  stuck20d  Integer
   */
  public void setStuck20d(Integer stuck20d) {
    this.stuck20d = stuck20d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck2d.
   *
   * @param  stuck2d  Integer
   */
  public void setStuck2d(Integer stuck2d) {
    this.stuck2d = stuck2d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck30d.
   *
   * @param  stuck30d  Integer
   */
  public void setStuck30d(Integer stuck30d) {
    this.stuck30d = stuck30d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck3d.
   *
   * @param  stuck3d  Integer
   */
  public void setStuck3d(Integer stuck3d) {
    this.stuck3d = stuck3d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck40d.
   *
   * @param  stuck40d  Integer
   */
  public void setStuck40d(Integer stuck40d) {
    this.stuck40d = stuck40d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck4d.
   *
   * @param  stuck4d  Integer
   */
  public void setStuck4d(Integer stuck4d) {
    this.stuck4d = stuck4d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck50d.
   *
   * @param  stuck50d  Integer
   */
  public void setStuck50d(Integer stuck50d) {
    this.stuck50d = stuck50d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck5d.
   *
   * @param  stuck5d  Integer
   */
  public void setStuck5d(Integer stuck5d) {
    this.stuck5d = stuck5d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck60d.
   *
   * @param  stuck60d  Integer
   */
  public void setStuck60d(Integer stuck60d) {
    this.stuck60d = stuck60d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck6d.
   *
   * @param  stuck6d  Integer
   */
  public void setStuck6d(Integer stuck6d) {
    this.stuck6d = stuck6d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck70d.
   *
   * @param  stuck70d  Integer
   */
  public void setStuck70d(Integer stuck70d) {
    this.stuck70d = stuck70d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck7d.
   *
   * @param  stuck7d  Integer
   */
  public void setStuck7d(Integer stuck7d) {
    this.stuck7d = stuck7d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck80d.
   *
   * @param  stuck80d  Integer
   */
  public void setStuck80d(Integer stuck80d) {
    this.stuck80d = stuck80d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck8d.
   *
   * @param  stuck8d  Integer
   */
  public void setStuck8d(Integer stuck8d) {
    this.stuck8d = stuck8d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck90d.
   *
   * @param  stuck90d  Integer
   */
  public void setStuck90d(Integer stuck90d) {
    this.stuck90d = stuck90d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck9d.
   *
   * @param  stuck9d  Integer
   */
  public void setStuck9d(Integer stuck9d) {
    this.stuck9d = stuck9d;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stuck count.
   *
   * @param  stuckCount  Integer
   */
  public void setStuckCount(Integer stuckCount) {
    this.stuckCount = stuckCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total count.
   *
   * @param  totalCount  Integer
   */
  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }
} // end class WorkflowTaskPerformanceReportItem
