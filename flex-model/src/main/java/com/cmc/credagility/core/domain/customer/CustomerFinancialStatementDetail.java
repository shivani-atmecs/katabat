package com.cmc.credagility.core.domain.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.CreatorEntity;


/**
 * Created by tangwei on 1/9/17.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  01/09/2017 16:20
 */
@Entity
@Table(name = "CustomerFinancialStatementDetail")
public class CustomerFinancialStatementDetail extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "answer",
    length = 1024
  )
  protected String answer;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "customerId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "questionId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerFinancialStatementQuestion question;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "statementId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerFinancialStatement statement;

  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof CustomerFinancialStatementDetail)) {
      return false;
    }

    CustomerFinancialStatementDetail that = (CustomerFinancialStatementDetail) obj;

    if (!super.equals(obj)) {
      return false;
    }

    if ((question != null) ? (!question.equals(that.getQuestion())) : (that.getQuestion() != null)) {
      return false;
    }

    if ((answer != null) ? (!answer.equals(that.getAnswer())) : (that.getAnswer() != null)) {
      return false;
    }

    if ((customer != null) ? (!customer.equals(that.getCustomer())) : (that.getCustomer() != null)) {
      return false;
    }

    if ((statement != null) ? (!statement.equals(that.getStatement())) : (that.getStatement() != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer.
   *
   * @return  String
   */
  public String getAnswer() {
    return answer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Customer getCustomer() {
    return customer;
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
   * getter method for question.
   *
   * @return  CustomerFinancialStatementQuestion
   */
  public CustomerFinancialStatementQuestion getQuestion() {
    return question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for statement.
   *
   * @return  CustomerFinancialStatement
   */
  public CustomerFinancialStatement getStatement() {
    return statement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((answer != null) ? answer.hashCode() : 0);
    result = (31 * result) + ((question != null) ? question.hashCode() : 0);
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);
    result = (31 * result) + ((statement != null) ? statement.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer.
   *
   * @param  answer  String
   */
  public void setAnswer(String answer) {
    this.answer = answer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  customer  Responsible
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
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
   * setter method for question.
   *
   * @param  question  CustomerFinancialStatementQuestion
   */
  public void setQuestion(CustomerFinancialStatementQuestion question) {
    this.question = question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for statement.
   *
   * @param  statement  CustomerFinancialStatement
   */
  public void setStatement(CustomerFinancialStatement statement) {
    this.statement = statement;
  }
} // end class CustomerFinancialStatementDetail
