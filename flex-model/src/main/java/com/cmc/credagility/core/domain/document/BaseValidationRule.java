package com.cmc.credagility.core.domain.document;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:23
 */
@MappedSuperclass public abstract class BaseValidationRule extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = true,
    length           = 2147483647,
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String criteria;


  /** error message. */
  @JoinColumn(
    name     = "documentId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument errorMessageDoc;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "historical",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(
    fetch   = FetchType.EAGER,
    cascade = CascadeType.ALL
  )
  protected Portfolio portfolio;


  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority = 1;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String ruleName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    BaseValidationRule that = (BaseValidationRule) o;

    if ((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null)) {
      return false;
    }

    if ((historical != null) ? (!historical.equals(that.historical)) : (that.historical != null)) {
      return false;
    }

    if ((ruleName != null) ? (!ruleName.equals(that.ruleName)) : (that.ruleName != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  String
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for error message doc.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getErrorMessageDoc() {
    return errorMessageDoc;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    return historical;
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
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule name.
   *
   * @return  String
   */
  public String getRuleName() {
    return ruleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (criteria != null) ? criteria.hashCode() : 0;
    result = (31 * result) + ((historical != null) ? historical.hashCode() : 0);
    result = (31 * result) + ((ruleName != null) ? ruleName.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria.
   *
   * @param  criteria  String
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for error message doc.
   *
   * @param  errorMessageDoc  EnterpriseDocument
   */
  public void setErrorMessageDoc(EnterpriseDocument errorMessageDoc) {
    this.errorMessageDoc = errorMessageDoc;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for historical.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
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
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule name.
   *
   * @param  ruleName  String
   */
  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }

} // end class BaseValidationRule
