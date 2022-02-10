package com.cmc.credagility.core.domain.mra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

import com.cmc.credagility.core.domain.base.CreatorEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 14:14
 */
@Entity public class QueueExportFileName extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "campaignType",
    nullable = true,
    length   = 20
  )
  protected String campaignType;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fileDescription;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fileName;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for campaign type.
   *
   * @return  String
   */
  public String getCampaignType() {
    return campaignType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file description.
   *
   * @return  String
   */
  public String getFileDescription() {
    return fileDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file name.
   *
   * @return  String
   */
  public String getFileName() {
    return fileName;
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
   * setter method for campaign type.
   *
   * @param  campaignType  String
   */
  public void setCampaignType(String campaignType) {
    this.campaignType = campaignType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file description.
   *
   * @param  fileDescription  String
   */
  public void setFileDescription(String fileDescription) {
    this.fileDescription = fileDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file name.
   *
   * @param  fileName  String
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
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
} // end class QueueExportFileName
