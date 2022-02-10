package com.ozstrategy.credagility.core.domain.document.program;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by zhubq on 12/11/15.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  12/11/2015 22:16
 */
@Entity public class ProgramDocumentInstance extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 1899805501827051975L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "MEDIUMBLOB")
  @Lob protected byte[] fileContent;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long instanceId;

  @JoinColumn(
    name     = "documentId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private EnterpriseDocument document;


  @Column(columnDefinition = "LONGTEXT")
  @Convert(converter = StringEncryptionConverter.class)
  private String htmlContent;

  @Column(
    length   = 16,
    nullable = false
  )
  private String instanceStatus;


  @JoinColumn(
    name      = "paymentProgramId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PaymentProgram paymentProgram;


  @JoinColumn(
    name     = "responsibleId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(Object)
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

    ProgramDocumentInstance that = (ProgramDocumentInstance) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((instanceId != null) ? (!instanceId.equals(that.instanceId)) : (that.instanceId != null)) {
      return false;
    }

    if ((document != null) ? (!document.equals(that.document)) : (that.document != null)) {
      return false;
    }

    if ((htmlContent != null) ? (!htmlContent.equals(that.htmlContent)) : (that.htmlContent != null)) {
      return false;
    }

    if ((instanceStatus != null) ? (!instanceStatus.equals(that.instanceStatus)) : (that.instanceStatus != null)) {
      return false;
    }

    if ((paymentProgram != null) ? (!paymentProgram.equals(that.paymentProgram)) : (that.paymentProgram != null)) {
      return false;
    }


    return !((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
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
   * getter method for file content.
   *
   * @return  byte[]
   */
  public byte[] getFileContent() {
    return fileContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for html content.
   *
   * @return  String
   */
  public String getHtmlContent() {
    return htmlContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for instance id.
   *
   * @return  Long
   */
  public Long getInstanceId() {
    return instanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for instance status.
   *
   * @return  String
   */
  public String getInstanceStatus() {
    return instanceStatus;
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
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((instanceId != null) ? instanceId.hashCode() : 0);
    result = (31 * result) + ((document != null) ? document.hashCode() : 0);
    result = (31 * result) + ((htmlContent != null) ? htmlContent.hashCode() : 0);
    result = (31 * result) + ((instanceStatus != null) ? instanceStatus.hashCode() : 0);
    result = (31 * result) + ((paymentProgram != null) ? paymentProgram.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
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
   * setter method for file content.
   *
   * @param  fileContent  byte[]
   */
  public void setFileContent(byte[] fileContent) {
    this.fileContent = fileContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for html content.
   *
   * @param  htmlContent  String
   */
  public void setHtmlContent(String htmlContent) {
    this.htmlContent = htmlContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for instance id.
   *
   * @param  instanceId  Long
   */
  public void setInstanceId(Long instanceId) {
    this.instanceId = instanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for instance status.
   *
   * @param  instanceStatus  String
   */
  public void setInstanceStatus(String instanceStatus) {
    this.instanceStatus = instanceStatus;
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
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for text content.
   *
   * @return  setter method for text content.
   */

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "ProgramDocumentInstance{"
      + "account=" + account
      + ", instanceId=" + instanceId
      + ", document=" + document
      + ", instanceStatus='" + instanceStatus + '\''
      + ", paymentProgram=" + paymentProgram
      + ", responsible=" + responsible
      + '}';
  }


} // end class ProgramDocumentInstance
