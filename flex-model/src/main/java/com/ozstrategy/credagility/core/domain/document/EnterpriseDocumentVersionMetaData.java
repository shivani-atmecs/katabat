package com.ozstrategy.credagility.core.domain.document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * This class is used to store EnterpriseDocumentVersionMetaData information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:40
 */
@Entity
@Table(name = "EnterpriseDocumentVersionMetaData")
public class EnterpriseDocumentVersionMetaData extends BasicEnterpriseDocumentMetaData implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2014072142740584315L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "documentVersionId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersion documentVersion;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "documentVersionMetaData",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("displayOrder asc")
  protected Set<EnterpriseDocumentVersionMetaDataAnswerOption> metaDataAnswerOptions =
    new LinkedHashSet<EnterpriseDocumentVersionMetaDataAnswerOption>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copyAnswerOption.
   *
   * @param  metaDataAnswerOptions  Set
   */
  public void copyAnswerOption(Set<EnterpriseDocumentMetaDataAnswerOption> metaDataAnswerOptions) {
    if ((metaDataAnswerOptions != null) && !metaDataAnswerOptions.isEmpty()) {
      this.metaDataAnswerOptions.clear();

      for (EnterpriseDocumentMetaDataAnswerOption metaDataAnswerOption : metaDataAnswerOptions) {
        EnterpriseDocumentVersionMetaDataAnswerOption versionMetaDataAOpt =
          new EnterpriseDocumentVersionMetaDataAnswerOption();
        versionMetaDataAOpt.setDefault(metaDataAnswerOption.getDefault());
        versionMetaDataAOpt.setDisplayName(metaDataAnswerOption.getDisplayName());
        versionMetaDataAOpt.setValue(metaDataAnswerOption.getValue());
        versionMetaDataAOpt.setDisplayOrder(metaDataAnswerOption.getDisplayOrder());
        versionMetaDataAOpt.setDocumentVersionMetaData(this);

        versionMetaDataAOpt.setCreateDate(new Date());
        versionMetaDataAOpt.setLastUpdateDate(new Date());

        this.metaDataAnswerOptions.add(versionMetaDataAOpt);
      }

    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyFrom.
   *
   * @param  metaData  EnterpriseDocumentMetaData
   */
  public void copyFrom(EnterpriseDocumentMetaData metaData) {
    this.setName(metaData.getName());
    this.setDescription(metaData.getDescription());
    this.setQuestionText(metaData.getQuestionText());
    this.setDataType(metaData.getDataType());
    this.setRequired(metaData.getRequired());
    this.setDisplayOrder(metaData.getDisplayOrder());
    this.setAnswerType(metaData.getAnswerType());

    if (!metaData.getMetaDataAnswerOptions().isEmpty()) {
      this.copyAnswerOption(metaData.getMetaDataAnswerOptions());
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document version.
   *
   * @return  EnterpriseDocumentVersion
   */
  public EnterpriseDocumentVersion getDocumentVersion() {
    return documentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data answer options.
   *
   * @return  Set
   */
  public Set<EnterpriseDocumentVersionMetaDataAnswerOption> getMetaDataAnswerOptions() {
    return metaDataAnswerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document version.
   *
   * @param  documentVersion  EnterpriseDocumentVersion
   */
  public void setDocumentVersion(EnterpriseDocumentVersion documentVersion) {
    this.documentVersion = documentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data answer options.
   *
   * @param  metaDataAnswerOptions  Set
   */
  public void setMetaDataAnswerOptions(Set<EnterpriseDocumentVersionMetaDataAnswerOption> metaDataAnswerOptions) {
    this.metaDataAnswerOptions = metaDataAnswerOptions;
  }
} // end class EnterpriseDocumentVersionMetaData
