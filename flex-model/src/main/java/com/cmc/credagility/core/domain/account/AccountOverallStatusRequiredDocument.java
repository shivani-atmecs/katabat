package com.cmc.credagility.core.domain.account;

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
import com.cmc.credagility.core.domain.document.DocumentType;


/**
 * This class is used to store required Document for different account status information.
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 10:58
 */
@Entity @Table public class AccountOverallStatusRequiredDocument extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8204401569499621717L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Document type. */
  @JoinColumn(
    name     = "documentTypeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected DocumentType documentType;

  /** Document Type PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Document type. */
  @JoinColumn(
    name     = "statusDetailId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected AccountOverallStatusDetail statusDetail;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    AccountOverallStatusRequiredDocument that = (AccountOverallStatusRequiredDocument) o;

    if ((documentType != null) ? (!documentType.equals(that.documentType)) : (that.documentType != null)) {
      return false;
    }

    if ((statusDetail != null) ? (!statusDetail.equals(that.statusDetail)) : (that.statusDetail != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document type.
   *
   * @return  DocumentType
   */
  public DocumentType getDocumentType() {
    return documentType;
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
   * getter method for status detail.
   *
   * @return  AccountOverallStatusDetail
   */
  public AccountOverallStatusDetail getStatusDetail() {
    return statusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((statusDetail != null) ? statusDetail.hashCode() : 0);
    result = (31 * result) + ((documentType != null) ? documentType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document type.
   *
   * @param  documentType  DocumentType
   */
  public void setDocumentType(DocumentType documentType) {
    this.documentType = documentType;
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
   * setter method for status detail.
   *
   * @param  statusDetail  AccountOverallStatusDetail
   */
  public void setStatusDetail(AccountOverallStatusDetail statusDetail) {
    this.statusDetail = statusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("AccountOverallStatusRequiredDocument");
    sb.append("{id=").append(id);
    sb.append(", statusDetail=").append(statusDetail);
    sb.append(", documentType=").append(documentType);
    sb.append('}');

    return sb.toString();
  }
} // end class AccountOverallStatusRequiredDocument
