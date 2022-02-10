package com.cmc.credagility.core.domain.portfolio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.program.BaseProgramType;
import com.cmc.credagility.core.domain.program.InstallmentDueDateTolerance;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;


/**
 * This class is used to store Portfolio Program Type information.
 *
 * <p><a href="PortfolioProgramType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "PortfolioProgramType"</p>
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "PortfolioProgramType",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "portfolioId", "programTypeId" }) },
  indexes           = {
    @Index(
      name          = "FK8E_portfolioId",
      columnList    = "portfolioId"
    )
  }
)
public class PortfolioProgramType extends BaseProgramType {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6715006881051303235L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Program type description. */
  @Column(name = "description")
  protected String description;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "flexSiteMultipleDescriptionTextDocumentId",
    updatable  = false,
    insertable = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument flexSiteMultipleDescriptionTextDocument;

  /** DOCUMENT ME! */
  @Column(
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  protected Long flexSiteMultipleDescriptionTextDocumentId;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "flexSiteMultipleTeaserTextDocumentId",
    updatable  = false,
    insertable = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument flexSiteMultipleTeaserTextDocument;

  /** DOCUMENT ME! */
  @Column(
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  protected Long flexSiteMultipleTeaserTextDocumentId;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "flexSiteSingleDescriptionTextDocumentId",
    updatable  = false,
    insertable = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument flexSiteSingleDescriptionTextDocument;

  /** DOCUMENT ME! */
  @Column(
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  protected Long flexSiteSingleDescriptionTextDocumentId;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "flexSiteSingleTeaserTextDocumentId",
    updatable  = false,
    insertable = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument flexSiteSingleTeaserTextDocument;

  /** DOCUMENT ME! */
  @Column(
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  protected Long flexSiteSingleTeaserTextDocumentId;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "flexStationMultipleDescriptionTextDocumentId",
    updatable  = false,
    insertable = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument flexStationMultipleDescriptionTextDocument;

  /** DOCUMENT ME! */
  @Column(
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  protected Long flexStationMultipleDescriptionTextDocumentId;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "flexStationMultipleTeaserTextDocumentId",
    updatable  = false,
    insertable = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument flexStationMultipleTeaserTextDocument;

  /** DOCUMENT ME! */
  @Column(
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  protected Long flexStationMultipleTeaserTextDocumentId;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "flexStationSingleDescriptionTextDocumentId",
    updatable  = false,
    insertable = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument flexStationSingleDescriptionTextDocument;

  /** DOCUMENT ME! */
  @Column(
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  protected Long flexStationSingleDescriptionTextDocumentId;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "flexStationSingleTeaserTextDocumentId",
    updatable  = false,
    insertable = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument flexStationSingleTeaserTextDocument;

  /** DOCUMENT ME! */
  @Column(
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  protected Long flexStationSingleTeaserTextDocumentId;

  /** <code>true</code> allow include payment out side of installment period. */
  @Column(
    name             = "includePaymentsOutSideOfInstallmentPeriod",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean includePaymentsOutSideOfInstallmentPeriod;

  /** Program type maximum number of consecutive missed payment allowed. */
  @Column protected Long maxNumberOfConsecutiveMissedPaymentAllowed;


  /** Program type maximum number of consecutive reject payment allowed. */
  @Column protected Long maxNumberOfConsecutiveRejectPaymentAllowed;

  /** Program type maximum number of missed payment allowed. */
  @Column protected Long maxNumberOfMissedPaymentAllowed;

  /** Program type maximum number of reject payment allowed. */
  @Column protected Long maxNumberOfRejectPaymentAllowed;

  /** Program type name. */
  @Column(name = "name")
  protected String name;

  /** Portfolio PK portfolioId. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** PortfolioAgentDispositionCode PK portfolioAgentDispositionCodeId. */
  @JoinColumn(
    name      = "portfolioAgentDispositionCodeId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioAgentDispositionCode portfolioAgentDispositionCode;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Portfolio program type Id, PK. */
  @Column(
    name     = "typeId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long typeId;

  /**
   * @see  com.cmc.credagility.core.domain.program.InstallmentDueDateTolerance
   */
  @OneToMany(
    mappedBy = "programType",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  List<InstallmentDueDateTolerance> installmentDueDateToleranceList = new ArrayList<InstallmentDueDateTolerance>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    PortfolioProgramType other = (PortfolioProgramType) obj;

    if (portfolio == null) {
      if (other.portfolio != null) {
        return false;
      }
    } else if (!portfolio.equals(other.portfolio)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site multiple description text document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getFlexSiteMultipleDescriptionTextDocument() {
    return flexSiteMultipleDescriptionTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site multiple description text document id.
   *
   * @return  Long
   */
  public Long getFlexSiteMultipleDescriptionTextDocumentId() {
    return flexSiteMultipleDescriptionTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site multiple teaser text document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getFlexSiteMultipleTeaserTextDocument() {
    return flexSiteMultipleTeaserTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site multiple teaser text document id.
   *
   * @return  Long
   */
  public Long getFlexSiteMultipleTeaserTextDocumentId() {
    return flexSiteMultipleTeaserTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site single description text document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getFlexSiteSingleDescriptionTextDocument() {
    return flexSiteSingleDescriptionTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site single description text document id.
   *
   * @return  Long
   */
  public Long getFlexSiteSingleDescriptionTextDocumentId() {
    return flexSiteSingleDescriptionTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site single teaser text document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getFlexSiteSingleTeaserTextDocument() {
    return flexSiteSingleTeaserTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site single teaser text document id.
   *
   * @return  Long
   */
  public Long getFlexSiteSingleTeaserTextDocumentId() {
    return flexSiteSingleTeaserTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex station multiple description text document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getFlexStationMultipleDescriptionTextDocument() {
    return flexStationMultipleDescriptionTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex station multiple description text document id.
   *
   * @return  Long
   */
  public Long getFlexStationMultipleDescriptionTextDocumentId() {
    return flexStationMultipleDescriptionTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex station multiple teaser text document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getFlexStationMultipleTeaserTextDocument() {
    return flexStationMultipleTeaserTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex station multiple teaser text document id.
   *
   * @return  Long
   */
  public Long getFlexStationMultipleTeaserTextDocumentId() {
    return flexStationMultipleTeaserTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex station single description text document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getFlexStationSingleDescriptionTextDocument() {
    return flexStationSingleDescriptionTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex station single description text document id.
   *
   * @return  Long
   */
  public Long getFlexStationSingleDescriptionTextDocumentId() {
    return flexStationSingleDescriptionTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex station single teaser text document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getFlexStationSingleTeaserTextDocument() {
    return flexStationSingleTeaserTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex station single teaser text document id.
   *
   * @return  Long
   */
  public Long getFlexStationSingleTeaserTextDocumentId() {
    return flexStationSingleTeaserTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getIncludePaymentsOutSideOfInstallmentPeriod() {
    return includePaymentsOutSideOfInstallmentPeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<InstallmentDueDateTolerance> getInstallmentDueDateToleranceList() {
    return installmentDueDateToleranceList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getMaxNumberOfConsecutiveMissedPaymentAllowed() {
    return maxNumberOfConsecutiveMissedPaymentAllowed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getMaxNumberOfConsecutiveRejectPaymentAllowed() {
    return maxNumberOfConsecutiveRejectPaymentAllowed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getMaxNumberOfMissedPaymentAllowed() {
    return maxNumberOfMissedPaymentAllowed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getMaxNumberOfRejectPaymentAllowed() {
    return maxNumberOfRejectPaymentAllowed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The portfolio.
   *
   * @return  the portfolio
   *
   *          <p>lazy = "proxy" column = "portfolioId" not-null = "true" class = "com.cmc.credagility.Portfolio" insert
   *          = "true" update = "false"</p>
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioAgentDispositionCode getPortfolioAgentDispositionCode() {
    return portfolioAgentDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The typeId.
   *
   * @return  the typeId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getTypeId() {
    return this.typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((portfolio == null) ? 0 : portfolio.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  description  DOCUMENT ME!
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site multiple description text document.
   *
   * @param  flexSiteMultipleDescriptionTextDocument  EnterpriseDocument
   */
  public void setFlexSiteMultipleDescriptionTextDocument(EnterpriseDocument flexSiteMultipleDescriptionTextDocument) {
    this.flexSiteMultipleDescriptionTextDocument = flexSiteMultipleDescriptionTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site multiple description text document id.
   *
   * @param  flexSiteMultipleDescriptionTextDocumentId  Long
   */
  public void setFlexSiteMultipleDescriptionTextDocumentId(Long flexSiteMultipleDescriptionTextDocumentId) {
    this.flexSiteMultipleDescriptionTextDocumentId = flexSiteMultipleDescriptionTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site multiple teaser text document.
   *
   * @param  flexSiteMultipleTeaserTextDocument  EnterpriseDocument
   */
  public void setFlexSiteMultipleTeaserTextDocument(EnterpriseDocument flexSiteMultipleTeaserTextDocument) {
    this.flexSiteMultipleTeaserTextDocument = flexSiteMultipleTeaserTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site multiple teaser text document id.
   *
   * @param  flexSiteMultipleTeaserTextDocumentId  Long
   */
  public void setFlexSiteMultipleTeaserTextDocumentId(Long flexSiteMultipleTeaserTextDocumentId) {
    this.flexSiteMultipleTeaserTextDocumentId = flexSiteMultipleTeaserTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site single description text document.
   *
   * @param  flexSiteSingleDescriptionTextDocument  EnterpriseDocument
   */
  public void setFlexSiteSingleDescriptionTextDocument(EnterpriseDocument flexSiteSingleDescriptionTextDocument) {
    this.flexSiteSingleDescriptionTextDocument = flexSiteSingleDescriptionTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site single description text document id.
   *
   * @param  flexSiteSingleDescriptionTextDocumentId  Long
   */
  public void setFlexSiteSingleDescriptionTextDocumentId(Long flexSiteSingleDescriptionTextDocumentId) {
    this.flexSiteSingleDescriptionTextDocumentId = flexSiteSingleDescriptionTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site single teaser text document.
   *
   * @param  flexSiteSingleTeaserTextDocument  EnterpriseDocument
   */
  public void setFlexSiteSingleTeaserTextDocument(EnterpriseDocument flexSiteSingleTeaserTextDocument) {
    this.flexSiteSingleTeaserTextDocument = flexSiteSingleTeaserTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site single teaser text document id.
   *
   * @param  flexSiteSingleTeaserTextDocumentId  Long
   */
  public void setFlexSiteSingleTeaserTextDocumentId(Long flexSiteSingleTeaserTextDocumentId) {
    this.flexSiteSingleTeaserTextDocumentId = flexSiteSingleTeaserTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex station multiple description text document.
   *
   * @param  flexStationMultipleDescriptionTextDocument  EnterpriseDocument
   */
  public void setFlexStationMultipleDescriptionTextDocument(
    EnterpriseDocument flexStationMultipleDescriptionTextDocument) {
    this.flexStationMultipleDescriptionTextDocument = flexStationMultipleDescriptionTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex station multiple description text document id.
   *
   * @param  flexStationMultipleDescriptionTextDocumentId  Long
   */
  public void setFlexStationMultipleDescriptionTextDocumentId(Long flexStationMultipleDescriptionTextDocumentId) {
    this.flexStationMultipleDescriptionTextDocumentId = flexStationMultipleDescriptionTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex station multiple teaser text document.
   *
   * @param  flexStationMultipleTeaserTextDocument  EnterpriseDocument
   */
  public void setFlexStationMultipleTeaserTextDocument(EnterpriseDocument flexStationMultipleTeaserTextDocument) {
    this.flexStationMultipleTeaserTextDocument = flexStationMultipleTeaserTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex station multiple teaser text document id.
   *
   * @param  flexStationMultipleTeaserTextDocumentId  Long
   */
  public void setFlexStationMultipleTeaserTextDocumentId(Long flexStationMultipleTeaserTextDocumentId) {
    this.flexStationMultipleTeaserTextDocumentId = flexStationMultipleTeaserTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex station single description text document.
   *
   * @param  flexStationSingleDescriptionTextDocument  EnterpriseDocument
   */
  public void setFlexStationSingleDescriptionTextDocument(EnterpriseDocument flexStationSingleDescriptionTextDocument) {
    this.flexStationSingleDescriptionTextDocument = flexStationSingleDescriptionTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex station single description text document id.
   *
   * @param  flexStationSingleDescriptionTextDocumentId  Long
   */
  public void setFlexStationSingleDescriptionTextDocumentId(Long flexStationSingleDescriptionTextDocumentId) {
    this.flexStationSingleDescriptionTextDocumentId = flexStationSingleDescriptionTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex station single teaser text document.
   *
   * @param  flexStationSingleTeaserTextDocument  EnterpriseDocument
   */
  public void setFlexStationSingleTeaserTextDocument(EnterpriseDocument flexStationSingleTeaserTextDocument) {
    this.flexStationSingleTeaserTextDocument = flexStationSingleTeaserTextDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex station single teaser text document id.
   *
   * @param  flexStationSingleTeaserTextDocumentId  Long
   */
  public void setFlexStationSingleTeaserTextDocumentId(Long flexStationSingleTeaserTextDocumentId) {
    this.flexStationSingleTeaserTextDocumentId = flexStationSingleTeaserTextDocumentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  includePaymentsOutSideOfInstallmentPeriod  DOCUMENT ME!
   */
  public void setIncludePaymentsOutSideOfInstallmentPeriod(Boolean includePaymentsOutSideOfInstallmentPeriod) {
    this.includePaymentsOutSideOfInstallmentPeriod = includePaymentsOutSideOfInstallmentPeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  installmentDueDateToleranceList  DOCUMENT ME!
   */
  public void setInstallmentDueDateToleranceList(List<InstallmentDueDateTolerance> installmentDueDateToleranceList) {
    this.installmentDueDateToleranceList = installmentDueDateToleranceList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxNumberOfConsecutiveMissedPaymentAllowed  DOCUMENT ME!
   */
  public void setMaxNumberOfConsecutiveMissedPaymentAllowed(Long maxNumberOfConsecutiveMissedPaymentAllowed) {
    this.maxNumberOfConsecutiveMissedPaymentAllowed = maxNumberOfConsecutiveMissedPaymentAllowed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxNumberOfConsecutiveRejectPaymentAllowed  DOCUMENT ME!
   */
  public void setMaxNumberOfConsecutiveRejectPaymentAllowed(Long maxNumberOfConsecutiveRejectPaymentAllowed) {
    this.maxNumberOfConsecutiveRejectPaymentAllowed = maxNumberOfConsecutiveRejectPaymentAllowed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxNumberOfMissedPaymentAllowed  DOCUMENT ME!
   */
  public void setMaxNumberOfMissedPaymentAllowed(Long maxNumberOfMissedPaymentAllowed) {
    this.maxNumberOfMissedPaymentAllowed = maxNumberOfMissedPaymentAllowed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxNumberOfRejectPaymentAllowed  DOCUMENT ME!
   */
  public void setMaxNumberOfRejectPaymentAllowed(Long maxNumberOfRejectPaymentAllowed) {
    this.maxNumberOfRejectPaymentAllowed = maxNumberOfRejectPaymentAllowed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  the portfolio to set
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioAgentDispositionCode  DOCUMENT ME!
   */
  public void setPortfolioAgentDispositionCode(PortfolioAgentDispositionCode portfolioAgentDispositionCode) {
    this.portfolioAgentDispositionCode = portfolioAgentDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  typeId  the typeId to set
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("PortfolioProgramType ( ").append(super.toString()).append(
      TAB).append("portfolio = ").append(this.portfolio).append(TAB).append(
      "typeId = ").append(this.typeId).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class PortfolioProgramType
