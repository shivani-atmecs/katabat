package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.document.DocumentStatus;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * EnterpriseDocumentStatus Abstract Class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:42
 */
@MappedSuperclass public abstract class BasicEnterpriseDocumentStatus extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4745612282440661291L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean asDefault;

  /** PortfolioDocument. */
  @JoinColumn(
    name      = "documentId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument document;

  /** Document Type Name. */
  @JoinColumn(
    name      = "statusId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DocumentStatus documentStatus;

  /** Flow Positions: INIT/MID/END */
  @Column(
    length   = 5,
    nullable = false
  )
  protected String flowPosition;


  /** TODO: DOCUMENT ME! */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BasicEnterpriseDocumentStatus object.
   */
  public BasicEnterpriseDocumentStatus() { }

  /**
   * Creates a new BasicEnterpriseDocumentStatus object.
   *
   * @param  documentStatus  DocumentStatus
   */
  public BasicEnterpriseDocumentStatus(DocumentStatus documentStatus) {
    this.documentStatus = documentStatus;
  }

  /**
   * Creates a new BasicEnterpriseDocumentStatus object.
   *
   * @param  documentStatus  DocumentStatus
   * @param  flowPosition    String
   */
  public BasicEnterpriseDocumentStatus(DocumentStatus documentStatus, String flowPosition) {
    this.documentStatus = documentStatus;
    this.flowPosition   = flowPosition;
  }

  /**
   * Creates a new BasicEnterpriseDocumentStatus object.
   *
   * @param  documentStatus  DocumentStatus
   * @param  flowPosition    String
   * @param  asDefault       Boolean
   */
  public BasicEnterpriseDocumentStatus(DocumentStatus documentStatus, String flowPosition, Boolean asDefault) {
    this.documentStatus = documentStatus;
    this.flowPosition   = flowPosition;
    this.asDefault      = asDefault;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @return  BasicEnterpriseDocumentStatus
   */
  public abstract BasicEnterpriseDocumentStatus copy();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BasicEnterpriseDocumentStatus that = (BasicEnterpriseDocumentStatus) o;

    if ((asDefault != null) ? (!asDefault.equals(that.asDefault)) : (that.asDefault != null)) {
      return false;
    }

    if (!document.equals(that.document)) {
      return false;
    }

    if (!documentStatus.equals(that.documentStatus)) {
      return false;
    }

    if (!flowPosition.equals(that.flowPosition)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for as default.
   *
   * @return  Boolean
   */
  public Boolean getAsDefault() {
    if (asDefault == null) {
      return Boolean.FALSE;
    }

    return asDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getDocument() {
    return document;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document status.
   *
   * @return  DocumentStatus
   */
  public DocumentStatus getDocumentStatus() {
    return documentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow position.
   *
   * @return  String
   */
  public String getFlowPosition() {
    return flowPosition;
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
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + document.hashCode();
    result = (31 * result) + flowPosition.hashCode();
    result = (31 * result) + documentStatus.hashCode();
    result = (31 * result) + ((asDefault != null) ? asDefault.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for as default.
   *
   * @param  asDefault  Boolean
   */
  public void setAsDefault(Boolean asDefault) {
    this.asDefault = asDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document.
   *
   * @param  document  EnterpriseDocument
   */
  public void setDocument(EnterpriseDocument document) {
    this.document = document;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document status.
   *
   * @param  documentStatus  DocumentStatus
   */
  public void setDocumentStatus(DocumentStatus documentStatus) {
    this.documentStatus = documentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow position.
   *
   * @param  flowPosition  String
   */
  public void setFlowPosition(String flowPosition) {
    this.flowPosition = flowPosition;
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
   * paste.
   *
   * @param  status  BasicEnterpriseDocumentStatus
   */
  protected void paste(BasicEnterpriseDocumentStatus status) {
    status.setDocument(document);
    status.setFlowPosition(flowPosition);
    status.setDocumentStatus(documentStatus);
    status.setAsDefault(asDefault);
  }
} // end class BasicEnterpriseDocumentStatus
