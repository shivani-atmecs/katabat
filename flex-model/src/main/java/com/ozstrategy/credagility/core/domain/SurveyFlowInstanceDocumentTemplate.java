package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioQuestion;
import com.cmc.credagility.core.domain.type.LocaleType;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocumentVersionTemplate;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


/**
 * Template of SurveyFlowInstance Document.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 11:28
 */
@Entity
@Table(
  name              = "SurveyFlowInstanceDocumentTemplate",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "documentId", "instanceId" }) }
)
public class SurveyFlowInstanceDocumentTemplate extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5002074085122683703L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** EnterpriseDocument. */
  @JoinColumn(
    name      = "documentId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument document;

  /** doc extension. */
  @Column(
    name   = "extension",
    length = 10
  )
  protected String extension;

  /** fileContent. */
  @Column(columnDefinition = "MEDIUMBLOB")
  @Lob protected byte[] fileContent;

  /** SurveyFlow Instance. */
  @JoinColumn(
    name      = "instanceId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowInstance instance;

  /** LocaleType. */
  @Column(
    name   = "locale",
    length = 5
  )
  @Enumerated(EnumType.STRING)
  protected LocaleType locale = LocaleType.ENGLISH;

  /** doc originalName. */
  @Column(
    name   = "originalName",
    length = 255
  )
  protected String originalName;

  /** Portfolio. */
  @JoinColumn(
    name      = "portfolioId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** PortfolioQuestion. */
  @JoinColumn(
    name      = "portfolioQuestionId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioQuestion question;

  /** template Variables. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "template",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SurveyFlowInstanceDocumentTemplateVariable> templateVariables =
    new HashSet<SurveyFlowInstanceDocumentTemplateVariable>();

  /** EnterpriseDocument Version Template. */
  @JoinColumn(
    name      = "enterpriseDocumentVersionTemplateId",
    nullable  = false,
    updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersionTemplate versionTemplate;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addTemplateVariable.
   *
   * @param  variable  String
   * @param  value     String
   */
  public void addTemplateVariable(String variable, String value) {
    if ((variable != null) && !"".equals(variable)) {
      SurveyFlowInstanceDocumentTemplateVariable templateVariable = null;

      if ((templateVariables != null) && (templateVariables.size() > 0)) {
        for (SurveyFlowInstanceDocumentTemplateVariable var : templateVariables) {
          if (variable.equals(var.getVariable())) {
            templateVariable = var;

            break;
          }
        }
      }

      if (templateVariable == null) {
        templateVariable = new SurveyFlowInstanceDocumentTemplateVariable();
        templateVariable.setVariable(variable);
      }

      templateVariable.setValue(value);
      templateVariable.setTemplate(this);
      templateVariable.setDocument(this.getDocument());
      templateVariable.setInstance(this.getInstance());

      getTemplateVariables().add(templateVariable);
    } // end if
  }   // end method addTemplateVariable

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
   * getter method for extension.
   *
   * @return  String
   */
  public String getExtension() {
    return extension;
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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for instance.
   *
   * @return  SurveyFlowInstance
   */
  public SurveyFlowInstance getInstance() {
    return instance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for locale.
   *
   * @return  LocaleType
   */
  public LocaleType getLocale() {
    return locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original name.
   *
   * @return  String
   */
  public String getOriginalName() {
    if ((originalName == null) || "".equals(originalName.trim())) {
      return UUID.randomUUID().toString();
    }

    return originalName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for question.
   *
   * @return  PortfolioQuestion
   */
  public PortfolioQuestion getQuestion() {
    return question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template variables.
   *
   * @return  Set
   */
  public Set<SurveyFlowInstanceDocumentTemplateVariable> getTemplateVariables() {
    return templateVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for version template.
   *
   * @return  EnterpriseDocumentVersionTemplate
   */
  public EnterpriseDocumentVersionTemplate getVersionTemplate() {
    return versionTemplate;
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
   * setter method for extension.
   *
   * @param  extension  String
   */
  public void setExtension(String extension) {
    this.extension = extension;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for instance.
   *
   * @param  instance  SurveyFlowInstance
   */
  public void setInstance(SurveyFlowInstance instance) {
    this.instance = instance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for locale.
   *
   * @param  locale  LocaleType
   */
  public void setLocale(LocaleType locale) {
    this.locale = locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original name.
   *
   * @param  originalName  String
   */
  public void setOriginalName(String originalName) {
    this.originalName = originalName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for question.
   *
   * @param  question  PortfolioQuestion
   */
  public void setQuestion(PortfolioQuestion question) {
    this.question = question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template variables.
   *
   * @param  templateVariables  Set
   */
  public void setTemplateVariables(Set<SurveyFlowInstanceDocumentTemplateVariable> templateVariables) {
    this.templateVariables = templateVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for version template.
   *
   * @param  versionTemplate  EnterpriseDocumentVersionTemplate
   */
  public void setVersionTemplate(EnterpriseDocumentVersionTemplate versionTemplate) {
    this.versionTemplate = versionTemplate;
  }
} // end class SurveyFlowInstanceDocumentTemplate
