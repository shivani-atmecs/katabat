package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.metadata.MetaDataField;
import com.cmc.credagility.core.domain.portfolio.PortfolioVariable;
import com.cmc.credagility.core.domain.variable.BaseVariable;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 14:00
 */
@Entity
@Table(name = "PreviewMetaDataField")
public class PreviewMetaDataField extends MetaDataField {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "variableId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BaseVariable metaDataVariable = new PortfolioVariable();

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "previewMetaDataFieldId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long previewMetaDataFieldId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "previewRequestId",
    nullable = false
  )
  protected Long previewRequestId;

  /** TODO: DOCUMENT ME! */
  @Transient protected Long variableId;

  /** Description for the sorting criteria. */
  @Column(length = 255)
  private String description;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for meta data variable.
   *
   * @return  BaseVariable
   */
  public BaseVariable getMetaDataVariable() {
    return metaDataVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview meta data field id.
   *
   * @return  Long
   */
  public Long getPreviewMetaDataFieldId() {
    return previewMetaDataFieldId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview request id.
   *
   * @return  Long
   */
  public Long getPreviewRequestId() {
    return previewRequestId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable id.
   *
   * @return  Long
   */
  public Long getVariableId() {
    return variableId;
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
   * setter method for meta data variable.
   *
   * @param  metaDataVariable  BaseVariable
   */
  public void setMetaDataVariable(BaseVariable metaDataVariable) {
    this.metaDataVariable = metaDataVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview meta data field id.
   *
   * @param  previewMetaDataFieldId  Long
   */
  public void setPreviewMetaDataFieldId(Long previewMetaDataFieldId) {
    this.previewMetaDataFieldId = previewMetaDataFieldId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview request id.
   *
   * @param  previewRequestId  Long
   */
  public void setPreviewRequestId(Long previewRequestId) {
    this.previewRequestId = previewRequestId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable id.
   *
   * @param  variableId  Long
   */
  public void setVariableId(Long variableId) {
    this.variableId = variableId;
  }
} // end class PreviewMetaDataField
