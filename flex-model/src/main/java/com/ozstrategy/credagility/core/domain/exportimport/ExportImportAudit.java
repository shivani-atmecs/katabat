package com.ozstrategy.credagility.core.domain.exportimport;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:24
 */
@Entity public class ExportImportAudit implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -2520414101987249008L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enabled = true;

  @Column private Long costSecond;

  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date         finishTime;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @Column(length = 32)
  private String          imCat;
  @Column private Integer imIndex;
  @Column(length = 32)
  private String          imModule;
  @Column private Integer imPercent;
  @Column(length = 32)
  private String          imStatus;
  @Column private Integer imTotal;
  @Column private String  imType;
  @Column(length = 3200)
  private String          metaData;
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date            startTime;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ExportImportAudit object.
   */
  public ExportImportAudit() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for cost second.
   *
   * @return  Long
   */
  public Long getCostSecond() {
    return costSecond;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enabled.
   *
   * @return  Boolean
   */
  public Boolean getEnabled() {
    return enabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for finish time.
   *
   * @return  Date
   */
  public Date getFinishTime() {
    return finishTime;
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
   * getter method for im cat.
   *
   * @return  String
   */
  public String getImCat() {
    return imCat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for im index.
   *
   * @return  Integer
   */
  public Integer getImIndex() {
    return imIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for im module.
   *
   * @return  String
   */
  public String getImModule() {
    return imModule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for im percent.
   *
   * @return  Integer
   */
  public Integer getImPercent() {
    return imPercent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for im status.
   *
   * @return  String
   */
  public String getImStatus() {
    return imStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for im total.
   *
   * @return  Integer
   */
  public Integer getImTotal() {
    return imTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for im type.
   *
   * @return  String
   */
  public String getImType() {
    return imType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data.
   *
   * @return  String
   */
  public String getMetaData() {
    return metaData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start time.
   *
   * @return  Date
   */
  public Date getStartTime() {
    return startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cost second.
   *
   * @param  costSecond  Long
   */
  public void setCostSecond(Long costSecond) {
    this.costSecond = costSecond;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enabled.
   *
   * @param  enabled  Boolean
   */
  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for finish time.
   *
   * @param  finishTime  Date
   */
  public void setFinishTime(Date finishTime) {
    this.finishTime = finishTime;
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
   * setter method for im cat.
   *
   * @param  imCat  String
   */
  public void setImCat(String imCat) {
    this.imCat = imCat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for im index.
   *
   * @param  imIndex  Integer
   */
  public void setImIndex(Integer imIndex) {
    this.imIndex = imIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for im module.
   *
   * @param  imModule  String
   */
  public void setImModule(String imModule) {
    this.imModule = imModule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for im percent.
   *
   * @param  imPercent  Integer
   */
  public void setImPercent(Integer imPercent) {
    this.imPercent = imPercent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for im status.
   *
   * @param  imStatus  String
   */
  public void setImStatus(String imStatus) {
    this.imStatus = imStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for im total.
   *
   * @param  imTotal  Integer
   */
  public void setImTotal(Integer imTotal) {
    this.imTotal = imTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for im type.
   *
   * @param  imType  String
   */
  public void setImType(String imType) {
    this.imType = imType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data.
   *
   * @param  metaData  String
   */
  public void setMetaData(String metaData) {
    this.metaData = metaData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start time.
   *
   * @param  startTime  Date
   */
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }
} // end class ExportImportAudit
