package com.cmc.credagility.core.domain.mra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.account.AccountMetaDataField;
import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioVariable;
import com.cmc.credagility.core.domain.variable.BaseVariable;

import com.ozstrategy.credagility.core.domain.Calculatable;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 13:08
 */
@Entity public class PortfolioFilterSorterVariable extends CreatorEntity implements Calculatable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountMetaDataFieldId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountMetaDataField accountMetaDataField;

  /** Queue sorting criteria. */
  @JoinColumn(
    name       = "variableId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BaseVariable criteriaVariable = new PortfolioVariable();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** Description for the sorting criteria. */
  @Column(length = 255)
  private String description;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * calculate.
   *
   * @param   helper  EvaluateHelper
   *
   * @return  Object
   */
  @Override public Object calculate(EvaluateHelper helper) {
    return helper.calculate(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  PortfolioFilterSorterVariable
   */
  public PortfolioFilterSorterVariable duplicate() {
    PortfolioFilterSorterVariable newCopy = new PortfolioFilterSorterVariable();
    newCopy.setCriteriaVariable(criteriaVariable);
    newCopy.setDescription(description);
    newCopy.setPortfolio(portfolio);
    newCopy.setAccountMetaDataField(accountMetaDataField);

    return newCopy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    PortfolioFilterSorterVariable that = (PortfolioFilterSorterVariable) o;


    if ((criteriaVariable != null) ? (!criteriaVariable.getId().equals(
              that.criteriaVariable.getId())) : (that.criteriaVariable != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account meta data field.
   *
   * @return  AccountMetaDataField
   */
  public AccountMetaDataField getAccountMetaDataField() {
    return accountMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria variable.
   *
   * @return  BaseVariable
   */
  public BaseVariable getCriteriaVariable() {
    return criteriaVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria variable id.
   *
   * @return  Long
   */
  public Long getCriteriaVariableId() {
    if (criteriaVariable != null) {
      return criteriaVariable.getId();
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria variable name.
   *
   * @return  String
   */
  public String getCriteriaVariableName() {
    if (criteriaVariable != null) {
      return criteriaVariable.getName();
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
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
   * Update schedule based on passed in template Only update schedule it self but not the related rules.
   *
   * @return  update schedule based on passed in template Only update schedule it self but not the related rules
   */
// public boolean updateSortCriteria(QueueSortCriteria sortCriteria) {
// this.criteriaVariable = sortCriteria.getCriteriaVariable();
// this.description = sortCriteria.getDescription();
// this.direction = sortCriteria.getDirection();
// this.priority = sortCriteria.getPriority();
// this.lastUpdateDate = new Date();
// setLastUpdater(sortCriteria.getCreator());
//
// return true;
// }


  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result)
      + ((criteriaVariable != null) ? criteriaVariable.getId().hashCode() : 0);
    result = (31 * result)
      + ((description != null) ? description.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account meta data field.
   *
   * @param  accountMetaDataField  AccountMetaDataField
   */
  public void setAccountMetaDataField(AccountMetaDataField accountMetaDataField) {
    this.accountMetaDataField = accountMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria variable.
   *
   * @param  criteriaVariable  BaseVariable
   */
  public void setCriteriaVariable(BaseVariable criteriaVariable) {
    this.criteriaVariable = criteriaVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria variable id.
   *
   * @param  variableId  Long
   */
  public void setCriteriaVariableId(Long variableId) {
    criteriaVariable.setId(variableId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria variable name.
   *
   * @param  name  String
   */
  public void setCriteriaVariableName(String name) {
    criteriaVariable.setName(name);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
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
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioFilterSorterVariable");
    sb.append("{criteriaVariable='").append(criteriaVariable).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", id=").append(id);
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioFilterSorterVariable
