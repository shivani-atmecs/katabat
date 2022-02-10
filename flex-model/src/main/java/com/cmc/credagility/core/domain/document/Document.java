package com.cmc.credagility.core.domain.document;

import java.io.Serializable;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 12:09
 */
@Entity public class Document extends BaseDocument implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4783897932387622075L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active = true;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "fileId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DocumentFile documentFile;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "templateId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DocumentTemplate downloadTemplate;


  /** Relations Document Document History: */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "document",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate DESC")
  protected Set<DocumentHistory> histories = new LinkedHashSet<DocumentHistory>();

  /** Document PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "programId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgram paymentProgram;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean received = false;


  /** Require flag for display only, not persistent into database. */
  @Transient protected Boolean required;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Add document history.
   */
  public void addHistory() {
    DocumentHistory history = new DocumentHistory(this);
    histories.add(history);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Copy document properties from other.
   *
   * @param  other  $param.type$
   */
  @Override public void copy(Document other) {
    super.copy(other);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.document.BaseDocument#equals(java.lang.Object)
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

    Document document = (Document) o;

    if ((active != null) ? (!active.equals(document.active)) : (document.active != null)) {
      return false;
    }


    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document active flag.
   *
   * @return  get document active flag.
   */
  public Boolean getActive() {
    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document file.
   *
   * @return  DocumentFile
   */
  public DocumentFile getDocumentFile() {
    return documentFile;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for download template.
   *
   * @return  DocumentTemplate
   */
  public DocumentTemplate getDownloadTemplate() {
    return downloadTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Is document at End status.
   *
   * @return  is document at End status.
   */
  public Boolean getEndStatus() {
    return Boolean.TRUE.equals(typeStatusType.getEndStatus());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get Document histories.
   *
   * @return  get Document histories.
   */
  public Set<DocumentHistory> getHistories() {
    return histories;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document id.
   *
   * @return  get document id.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment program.
   *
   * @return  PaymentProgram
   */
  public PaymentProgram getPaymentProgram() {
    return paymentProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for received.
   *
   * @return  Boolean
   */
  public Boolean getReceived() {
    return received;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Is Document required.
   *
   * @return  is Document required.
   */
  public Boolean getRequired() {
    return required;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Is Document at Start status.
   *
   * @return  is Document at Start status.
   */
  public Boolean getStartStatus() {
    return Boolean.TRUE.equals(typeStatusType.getStartStatus());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((active != null) ? active.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document active flag, when the document is marked delete, the flag is set to fals.
   *
   * @param  active  $param.type$
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document file.
   *
   * @param  documentFile  DocumentFile
   */
  public void setDocumentFile(DocumentFile documentFile) {
    this.documentFile = documentFile;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for download template.
   *
   * @param  downloadTemplate  DocumentTemplate
   */
  public void setDownloadTemplate(DocumentTemplate downloadTemplate) {
    this.downloadTemplate = downloadTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set Document History.
   *
   * @param  histories  $param.type$
   */
  public void setHistories(Set<DocumentHistory> histories) {
    this.histories = histories;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document id.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment program.
   *
   * @param  paymentProgram  PaymentProgram
   */
  public void setPaymentProgram(PaymentProgram paymentProgram) {
    this.paymentProgram = paymentProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for received.
   *
   * @param  received  Boolean
   */
  public void setReceived(Boolean received) {
    this.received = received;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document require flag.
   *
   * @param  required  $param.type$
   */
  public void setRequired(Boolean required) {
    this.required = required;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Document");
    sb.append("{id=").append(id);
    sb.append(", histories=").append(histories);
    sb.append(", active=").append(active);
    sb.append(", required=").append(required);
    sb.append('}');

    return sb.toString();
  }
} // end class Document
