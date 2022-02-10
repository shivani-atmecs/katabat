package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:41
 */
@Entity public class ComplianceVariable extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date complianceDate;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "complianceVariable",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("displayOrder asc")
  protected List<CommunicationCompliance> complianceList = new ArrayList<CommunicationCompliance>();

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String complianceRule;


  /** TODO: DOCUMENT ME! */
  protected Integer disableAccountsCount;


  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String treatmentLevel;


  /** WHEN part. */
  @Column(length = 255)
  protected String variableExpression;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String variableName;

  /** General || Communication. */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String variableType = "General";


  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String variableWhen;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createCommunicationVariables.
   *
   * @param  complianceVariable  ComplianceVariable
   */
  public void createCommunicationVariables(ComplianceVariable complianceVariable) {
    if (complianceVariable == null) {
      complianceVariable = new ComplianceVariable();
    }

    complianceVariable.setVariableType("Communication");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createGeneralVariables.
   *
   * @param  complianceVariable  ComplianceVariable
   */
  public void createGeneralVariables(ComplianceVariable complianceVariable) {
    if (complianceVariable == null) {
      complianceVariable = new ComplianceVariable();
    }

    complianceVariable.setVariableType("General");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    ComplianceVariable that = (ComplianceVariable) o;

    if ((complianceDate != null) ? (!complianceDate.equals(that.complianceDate)) : (that.complianceDate != null)) {
      return false;
    }

    if ((complianceRule != null) ? (!complianceRule.equals(that.complianceRule)) : (that.complianceRule != null)) {
      return false;
    }

    if ((disableAccountsCount != null) ? (!disableAccountsCount.equals(that.disableAccountsCount))
                                       : (that.disableAccountsCount != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((treatmentLevel != null) ? (!treatmentLevel.equals(that.treatmentLevel)) : (that.treatmentLevel != null)) {
      return false;
    }

    if ((variableExpression != null) ? (!variableExpression.equals(that.variableExpression))
                                     : (that.variableExpression != null)) {
      return false;
    }

    if ((variableName != null) ? (!variableName.equals(that.variableName)) : (that.variableName != null)) {
      return false;
    }

    if ((variableType != null) ? (!variableType.equals(that.variableType)) : (that.variableType != null)) {
      return false;
    }

    if ((variableWhen != null) ? (!variableWhen.equals(that.variableWhen)) : (that.variableWhen != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for compliance date.
   *
   * @return  Date
   */
  public Date getComplianceDate() {
    return complianceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for compliance list.
   *
   * @return  List
   */
  public List<CommunicationCompliance> getComplianceList() {
    return complianceList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for compliance rule.
   *
   * @return  String
   */
  public String getComplianceRule() {
    return complianceRule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for create date.
   *
   * @return  Date
   */
  @Override public Date getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disable accounts count.
   *
   * @return  Integer
   */
  public Integer getDisableAccountsCount() {
    return disableAccountsCount;
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
   * getter method for last update date.
   *
   * @return  Date
   */
  @Override public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for treatment level.
   *
   * @return  String
   */
  public String getTreatmentLevel() {
    return treatmentLevel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable expression.
   *
   * @return  String
   */
  public String getVariableExpression() {
    return variableExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable name.
   *
   * @return  String
   */
  public String getVariableName() {
    return variableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable type.
   *
   * @return  String
   */
  public String getVariableType() {
    return variableType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable when.
   *
   * @return  String
   */
  public String getVariableWhen() {
    return variableWhen;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((variableName != null) ? variableName.hashCode() : 0);
    result = (31 * result) + ((treatmentLevel != null) ? treatmentLevel.hashCode() : 0);
    result = (31 * result) + ((variableExpression != null) ? variableExpression.hashCode() : 0);
    result = (31 * result) + ((variableWhen != null) ? variableWhen.hashCode() : 0);
    result = (31 * result) + ((complianceRule != null) ? complianceRule.hashCode() : 0);
    result = (31 * result) + ((disableAccountsCount != null) ? disableAccountsCount.hashCode() : 0);
    result = (31 * result) + ((complianceDate != null) ? complianceDate.hashCode() : 0);
    result = (31 * result) + ((variableType != null) ? variableType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for compliance date.
   *
   * @param  complianceDate  Date
   */
  public void setComplianceDate(Date complianceDate) {
    this.complianceDate = complianceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for compliance list.
   *
   * @param  complianceList  List
   */
  public void setComplianceList(List<CommunicationCompliance> complianceList) {
    this.complianceList = complianceList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for compliance rule.
   *
   * @param  complianceRule  String
   */
  public void setComplianceRule(String complianceRule) {
    this.complianceRule = complianceRule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disable accounts count.
   *
   * @param  disableAccountsCount  Integer
   */
  public void setDisableAccountsCount(Integer disableAccountsCount) {
    this.disableAccountsCount = disableAccountsCount;
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
   * setter method for treatment level.
   *
   * @param  treatmentLevel  String
   */
  public void setTreatmentLevel(String treatmentLevel) {
    this.treatmentLevel = treatmentLevel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable expression.
   *
   * @param  variableExpression  String
   */
  public void setVariableExpression(String variableExpression) {
    this.variableExpression = variableExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable name.
   *
   * @param  variableName  String
   */
  public void setVariableName(String variableName) {
    this.variableName = variableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable type.
   *
   * @param  variableType  String
   */
  public void setVariableType(String variableType) {
    this.variableType = variableType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable when.
   *
   * @param  variableWhen  String
   */
  public void setVariableWhen(String variableWhen) {
    this.variableWhen = variableWhen;
  }
} // end class ComplianceVariable
