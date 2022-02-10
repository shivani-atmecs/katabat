package com.cmc.credagility.core.domain.disposition;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 12:04
 */
@Entity
@Table(name = "CoreAgentDispositionCategory")
public class CoreAgentDispositionCategory extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5461789546068587433L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------

  /** CoreAgentDispositionCategory identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long coreAgentDispositionCategoryId;

  /** TODO: DOCUMENT ME! */
  @Column(name = "defaultNextWorkDate")
  protected Long defaultNextWorkDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "description",
    length = 100
  )
  protected String description;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "actionId",
    unique   = false,
    nullable = true
  )
  @ManyToOne protected DispositionActionCode dispositionActionCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "dispositionCategory",
    length = 20
  )
  protected String dispositionCategory;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "dispositionType",
    length = 20
  )
  protected String dispositionType;

  /** TODO: DOCUMENT ME! */
  @Column(name = "maxNextWorkDate")
  protected Long maxNextWorkDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "minNextWorkDate")
  protected Long minNextWorkDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for core agent disposition category id.
   *
   * @return  Long
   */
  public Long getCoreAgentDispositionCategoryId() {
    return coreAgentDispositionCategoryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default next work date.
   *
   * @return  Long
   */
  public Long getDefaultNextWorkDate() {
    return defaultNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disposition action code.
   *
   * @return  DispositionActionCode
   */
  public DispositionActionCode getDispositionActionCode() {
    return dispositionActionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disposition category.
   *
   * @return  String
   */
  public String getDispositionCategory() {
    return dispositionCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disposition type.
   *
   * @return  String
   */
  public String getDispositionType() {
    return dispositionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max next work date.
   *
   * @return  Long
   */
  public Long getMaxNextWorkDate() {
    return maxNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for min next work date.
   *
   * @return  Long
   */
  public Long getMinNextWorkDate() {
    return minNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for core agent disposition category id.
   *
   * @param  coreAgentDispositionCategoryId  Long
   */
  public void setCoreAgentDispositionCategoryId(Long coreAgentDispositionCategoryId) {
    this.coreAgentDispositionCategoryId = coreAgentDispositionCategoryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default next work date.
   *
   * @param  defaultNextWorkDate  Long
   */
  public void setDefaultNextWorkDate(Long defaultNextWorkDate) {
    this.defaultNextWorkDate = defaultNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disposition action code.
   *
   * @param  dispositionActionCode  DispositionActionCode
   */
  public void setDispositionActionCode(DispositionActionCode dispositionActionCode) {
    this.dispositionActionCode = dispositionActionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disposition category.
   *
   * @param  dispositionCategory  String
   */
  public void setDispositionCategory(String dispositionCategory) {
    this.dispositionCategory = dispositionCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disposition type.
   *
   * @param  dispositionType  String
   */
  public void setDispositionType(String dispositionType) {
    this.dispositionType = dispositionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max next work date.
   *
   * @param  maxNextWorkDate  Long
   */
  public void setMaxNextWorkDate(Long maxNextWorkDate) {
    this.maxNextWorkDate = maxNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for min next work date.
   *
   * @param  minNextWorkDate  Long
   */
  public void setMinNextWorkDate(Long minNextWorkDate) {
    this.minNextWorkDate = minNextWorkDate;
  }
} // end class CoreAgentDispositionCategory
