package com.cmc.credagility.core.domain.disclosure;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.channel.AbstractChannelResult;
import com.cmc.credagility.core.domain.channel.BasePortfolioChannelTemplateContent;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.webactivity.WebActivity;

import com.ozstrategy.credagility.core.domain.document.EnterpriseDocumentVersionTemplate;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:02
 */
@Entity
@Table(
  name    = "DisclosureAudit",
  indexes = {
    @Index(
      name = "createDateIndex",
      columnList = "createDate"
    ), @Index(
      name = "ruleBatchIdIndex",
      columnList = "ruleBatchId"
    ),
    @Index(
      name = "sourceIndex",
      columnList = "source"
    ),
    @Index(
      name = "statusIndex",
      columnList = "status"
    ),
    @Index(
      name = "strategyDateIndex",
      columnList = "strategyDate"
    ),
    @Index(
      name = "uniqueSessionIdIndex",
      columnList = "uniqueSessionId"
    )
  }
)
public class DisclosureAudit extends AbstractChannelResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "disclosureAuditId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long disclosureAuditId;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "disclosureAudit"
  )
  protected Set<DisclosureAuditDocument> documents = new LinkedHashSet<DisclosureAuditDocument>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "documentVersionTemplateId",
    nullable = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected EnterpriseDocumentVersionTemplate documentVersionTemplate;

  /** Payment. */
  @JoinColumn(
    name      = "paymentId",
    updatable = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  protected Payment payment;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "templateContentId",
    nullable = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected BasePortfolioChannelTemplateContent templateContent;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "disclosureAudit"
  )
  protected Set<DisclosureAuditVariableValue> variableValues = new LinkedHashSet<DisclosureAuditVariableValue>();

  /** WebActivity. */
  @JoinColumn(
    name      = "webActivityId",
    updatable = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  protected WebActivity webActivity;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addDocument.
   *
   * @param  document  DisclosureAuditDocument
   */
  public void addDocument(DisclosureAuditDocument document) {
    if (document != null) {
      this.documents.add(document);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disclosure audit id.
   *
   * @return  Long
   */
  public Long getDisclosureAuditId() {
    return disclosureAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for documents.
   *
   * @return  Set
   */
  public Set<DisclosureAuditDocument> getDocuments() {
    return documents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document version template.
   *
   * @return  EnterpriseDocumentVersionTemplate
   */
  public EnterpriseDocumentVersionTemplate getDocumentVersionTemplate() {
    return documentVersionTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment.
   *
   * @return  Payment
   */
  public Payment getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BaseChannelResult#getResultId()
   */
  @Override public Long getResultId() {
    return disclosureAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template content.
   *
   * @return  BasePortfolioChannelTemplateContent
   */
  public BasePortfolioChannelTemplateContent getTemplateContent() {
    return templateContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable values.
   *
   * @return  Set
   */
  public Set<DisclosureAuditVariableValue> getVariableValues() {
    return variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web activity.
   *
   * @return  WebActivity
   */
  public WebActivity getWebActivity() {
    return webActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disclosure audit id.
   *
   * @param  disclosureAuditId  Long
   */
  public void setDisclosureAuditId(Long disclosureAuditId) {
    this.disclosureAuditId = disclosureAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for documents.
   *
   * @param  documents  Set
   */
  public void setDocuments(Set<DisclosureAuditDocument> documents) {
    this.documents = documents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document version template.
   *
   * @param  documentVersionTemplate  EnterpriseDocumentVersionTemplate
   */
  public void setDocumentVersionTemplate(EnterpriseDocumentVersionTemplate documentVersionTemplate) {
    this.documentVersionTemplate = documentVersionTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment.
   *
   * @param  payment  Payment
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BaseChannelResult#setResultId(Long)
   */
  @Override public void setResultId(Long resultId) {
    this.disclosureAuditId = resultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template content.
   *
   * @param  templateContent  BasePortfolioChannelTemplateContent
   */
  public void setTemplateContent(BasePortfolioChannelTemplateContent templateContent) {
    this.templateContent = templateContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable values.
   *
   * @param  variableValues  Set
   */
  public void setVariableValues(Set<DisclosureAuditVariableValue> variableValues) {
    this.variableValues = variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web activity.
   *
   * @param  webActivity  WebActivity
   */
  public void setWebActivity(WebActivity webActivity) {
    this.webActivity = webActivity;
  }
} // end class DisclosureAudit
