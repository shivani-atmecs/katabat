package com.cmc.credagility.core.domain.config;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;


/**
 * This class is used to store Quick Dispose Configuration information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 14:45
 */
@Entity
@Table(name = "QDTConfiguration")
public class QDTConfiguration extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -8113759786590947304L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name   = "channelCode",
    length = 4
  )
  private String channelCode;

  @Column(
    name   = "destinationCode",
    length = 4
  )
  private String destinationCode;

  @Column(
    name   = "dispositionCode",
    length = 10
  )
  private String dispositionCode;

  @Column(
    name     = "label",
    nullable = false,
    length   = 255
  )
  private String label;

  @JoinColumn(
    name     = "portfolioId",
    unique   = false,
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;

  @Column(
    name     = "qdtCode",
    nullable = false,
    length   = 22
  )
  private String qdtCode;

  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long         qdtId;

  @Column(
    name   = "spokenTo",
    length = 4
  )
  private String spokenTo;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new QDTConfiguration object.
   */
  public QDTConfiguration() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel code.
   *
   * @return  String
   */
  public String getChannelCode() {
    return channelCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for destination code.
   *
   * @return  String
   */
  public String getDestinationCode() {
    return destinationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disposition code.
   *
   * @return  String
   */
  public String getDispositionCode() {
    return dispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for label.
   *
   * @return  String
   */
  public String getLabel() {
    return label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for qdt code.
   *
   * @return  String
   */
  public String getQdtCode() {
    return qdtCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for qdt id.
   *
   * @return  Long
   */
  public Long getQdtId() {
    return qdtId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spoken to.
   *
   * @return  String
   */
  public String getSpokenTo() {
    return spokenTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel code.
   *
   * @param  channelCode  String
   */
  public void setChannelCode(String channelCode) {
    this.channelCode = channelCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for destination code.
   *
   * @param  destinationCode  String
   */
  public void setDestinationCode(String destinationCode) {
    this.destinationCode = destinationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disposition code.
   *
   * @param  dispositionCode  String
   */
  public void setDispositionCode(String dispositionCode) {
    this.dispositionCode = dispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for label.
   *
   * @param  label  String
   */
  public void setLabel(String label) {
    this.label = label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for qdt code.
   *
   * @param  qdtCode  String
   */
  public void setQdtCode(String qdtCode) {
    this.qdtCode = qdtCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for qdt id.
   *
   * @param  qdtId  Long
   */
  public void setQdtId(Long qdtId) {
    this.qdtId = qdtId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spoken to.
   *
   * @param  spokenTo  String
   */
  public void setSpokenTo(String spokenTo) {
    this.spokenTo = spokenTo;
  }
} // end class QDTConfiguration
