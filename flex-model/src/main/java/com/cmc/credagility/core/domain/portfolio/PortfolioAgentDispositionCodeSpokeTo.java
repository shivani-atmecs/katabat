package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/31/2014 09:32
 */
@Entity
@Table(name = "PortfolioAgentDispositionCodeSpokeTo")
public class PortfolioAgentDispositionCodeSpokeTo {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name     = "dispositionCodeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PortfolioAgentDispositionCode dispositionCode;


  @Column(
    name     = "id", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @Column(
    name   = "spokeToRefId",
    length = 20
  )
  private Long spokeToRefId;


  @Column(
    name     = "spokeToSource",
    nullable = false
  )
  private String spokeToSource;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new PortfolioAgentDispositionCodeSpokeTo object.
   */
  public PortfolioAgentDispositionCodeSpokeTo() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * PortfolioAgentDispositionCode.
   *
   * @return  PortfolioAgentDispositionCode.
   */
  public PortfolioAgentDispositionCode getDispositionCode() {
    return dispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getSpokeToRefId() {
    return spokeToRefId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spoke to source.
   *
   * @return  String
   */
  public String getSpokeToSource() {
    return spokeToSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spoke to ref type.
   *
   * @param  dispositionCode  PortfolioAgentDispositionCode
   */

  /**
   * setDispositionCode.
   *
   * @param  dispositionCode  $param.type$
   */
  public void setDispositionCode(PortfolioAgentDispositionCode dispositionCode) {
    this.dispositionCode = dispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setSpokeToRefId.
   *
   * @param  spokeToRefId  $param.type$
   */
  public void setSpokeToRefId(Long spokeToRefId) {
    this.spokeToRefId = spokeToRefId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spoke to source.
   *
   * @param  spokeToSource  String
   */
  public void setSpokeToSource(String spokeToSource) {
    this.spokeToSource = spokeToSource;
  }

  /**
   * setter method for spoke to ref type.
   *
   * @param  spokeToRefType  String
   */
} // end class PortfolioAgentDispositionCodeSpokeTo
