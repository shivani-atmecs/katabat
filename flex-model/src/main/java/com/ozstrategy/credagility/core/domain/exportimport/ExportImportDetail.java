package com.ozstrategy.credagility.core.domain.exportimport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by lihao on 8/22/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity public class ExportImportDetail implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 4182372506840666636L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column private Integer addTotal = 0;

  @Column private String  context;
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date            createDate;
  @Column private String  entry;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long        id;
  @Column private Long    jobConfigId;
  @Column private String  manager;
  @Column private String  module;
  @Column(columnDefinition = "TEXT")
  private String          skipNames;
  @Column private Integer skipTotal   = 0;
  @Column private Integer total       = 0;
  @Column(columnDefinition = "TEXT")
  private String          updateNames;
  @Column private Integer updateTotal = 0;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAddTotal() {
    return addTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getContext() {
    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEntry() {
    return entry;
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
  public Long getJobConfigId() {
    return jobConfigId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getManager() {
    return manager;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getModule() {
    return module;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSkipNames() {
    return skipNames;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSkipTotal() {
    return skipTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTotal() {
    return total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getUpdateNames() {
    return updateNames;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getUpdateTotal() {
    return updateTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  addTotal  DOCUMENT ME!
   */
  public void setAddTotal(Integer addTotal) {
    this.addTotal = addTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  context  DOCUMENT ME!
   */
  public void setContext(String context) {
    this.context = context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  createDate  DOCUMENT ME!
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  entry  DOCUMENT ME!
   */
  public void setEntry(String entry) {
    this.entry = entry;
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
   * @param  jobConfigId  DOCUMENT ME!
   */
  public void setJobConfigId(Long jobConfigId) {
    this.jobConfigId = jobConfigId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  manager  DOCUMENT ME!
   */
  public void setManager(String manager) {
    this.manager = manager;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  module  DOCUMENT ME!
   */
  public void setModule(String module) {
    this.module = module;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  skipNames  DOCUMENT ME!
   */
  public void setSkipNames(String skipNames) {
    this.skipNames = skipNames;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  skipTotal  DOCUMENT ME!
   */
  public void setSkipTotal(Integer skipTotal) {
    this.skipTotal = skipTotal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  total  DOCUMENT ME!
   */
  public void setTotal(Integer total) {
    this.total = total;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateNames  DOCUMENT ME!
   */
  public void setUpdateNames(String updateNames) {
    this.updateNames = updateNames;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateTotal  DOCUMENT ME!
   */
  public void setUpdateTotal(Integer updateTotal) {
    this.updateTotal = updateTotal;
  }
} // end class ExportImportDetail
