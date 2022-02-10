package com.cmc.credagility.core.domain.document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @version  10/15/2014 11:56
 */
@Entity @Table public class DocumentTypeStatusType extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8823387708339324370L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Document status type. */
  @JoinColumn(
    name      = "statusId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DocumentStatus documentStatus;

  /** Document type. */
  @JoinColumn(
    name      = "typeId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DocumentType documentType;

  /** Document Flow status position, 'INIT'/'MID'/'END'. */
  @Column(nullable = false)
  protected String flowPosition;

  /** Document type status type Id, PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof DocumentTypeStatusType)) {
      return false;
    }

    DocumentTypeStatusType that = (DocumentTypeStatusType) o;

    if ((documentStatus != null) ? (!documentStatus.equals(that.documentStatus)) : (that.documentStatus != null)) {
      return false;
    }

    if ((documentType != null) ? (!documentType.equals(that.documentType)) : (that.documentType != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document status type.
   *
   * @return  get document status type.
   */
  public DocumentStatus getDocumentStatus() {
    return documentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document type.
   *
   * @return  get document type.
   */
  public DocumentType getDocumentType() {
    return documentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get end status flag.
   *
   * @return  get end status flag.
   */
  public Boolean getEndStatus() {
    return flowPosition.equalsIgnoreCase("END");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get flow position.
   *
   * @return  get flow position.
   */
  public String getFlowPosition() {
    return flowPosition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The id.
   *
   * @return  the id
   */
  public Long getId() {
    return this.id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get start status flag.
   *
   * @return  get start status flag.
   */
  public Boolean getStartStatus() {
    return flowPosition.equalsIgnoreCase("INIT");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 17;
    result = (31 * result) + ((documentType != null) ? documentType.hashCode() : 0);
    result = (31 * result) + ((documentStatus != null) ? documentStatus.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document status type.
   *
   * @param  documentStatus  $param.type$
   */
  public void setDocumentStatus(DocumentStatus documentStatus) {
    this.documentStatus = documentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document type.
   *
   * @param  documentType  $param.type$
   */
  public void setDocumentType(DocumentType documentType) {
    this.documentType = documentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set flow position.
   *
   * @param  flowPosition  $param.type$
   */
  public void setFlowPosition(String flowPosition) {
    this.flowPosition = flowPosition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  the typeId to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("DocumentTypeStatusType");
    sb.append("{id=").append(id);
    sb.append(", documentType=").append(documentType);
    sb.append(", documentStatus=").append(documentStatus);
    sb.append(", flowPosition='").append(flowPosition).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class DocumentTypeStatusType
