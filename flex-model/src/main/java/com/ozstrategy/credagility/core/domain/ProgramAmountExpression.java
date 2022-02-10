package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 14:16
 */
@Entity public class ProgramAmountExpression extends BaseEntity implements Evaluable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String amountExpression;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long amountExpressionId;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer position;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "programActionId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected ProgramAction programAction;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  ProgramAmountExpression
   */
  public ProgramAmountExpression duplicate() {
    ProgramAmountExpression newCopy = new ProgramAmountExpression();
    newCopy.setAmountExpression(amountExpression);
    newCopy.setPosition(position);
    newCopy.setProgramAction(programAction);

    return newCopy;
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

    ProgramAmountExpression that = (ProgramAmountExpression) o;

    if ((amountExpression != null) ? (!amountExpression.equals(that.amountExpression))
                                   : (that.amountExpression != null)) {
      return false;
    }

    if ((position != null) ? (!position.equals(that.position)) : (that.position != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * evaluate.
   *
   * @param   helper  EvaluateHelper
   *
   * @return  boolean
   */
  @Override public boolean evaluate(EvaluateHelper helper) {
    return false; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount expression.
   *
   * @return  String
   */
  public String getAmountExpression() {
    return amountExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount expression id.
   *
   * @return  Long
   */
  public Long getAmountExpressionId() {
    return amountExpressionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for position.
   *
   * @return  Integer
   */
  public Integer getPosition() {
    return position;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program action.
   *
   * @return  ProgramAction
   */
  public ProgramAction getProgramAction() {
    return programAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((amountExpression != null) ? amountExpression.hashCode() : 0);
    result = (31 * result) + ((position != null) ? position.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount expression.
   *
   * @param  amountExpression  String
   */
  public void setAmountExpression(String amountExpression) {
    this.amountExpression = amountExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount expression id.
   *
   * @param  amountExpressionId  Long
   */
  public void setAmountExpressionId(Long amountExpressionId) {
    this.amountExpressionId = amountExpressionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for position.
   *
   * @param  position  Integer
   */
  public void setPosition(Integer position) {
    this.position = position;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program action.
   *
   * @param  programAction  ProgramAction
   */
  public void setProgramAction(ProgramAction programAction) {
    this.programAction = programAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ProgramAmountExpression");
    sb.append("{amountExpression='").append(amountExpression).append('\'');
    sb.append(", amountExpressionId=").append(amountExpressionId);
    sb.append(", position=").append(position);
    sb.append(", programAction=").append(programAction);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * verify.
   *
   * @param  helper  EvaluateHelper
   */
  @Override public void verify(EvaluateHelper helper) {
    // To change body of implemented methods use File | Settings | File Templates.
  }
} // end class ProgramAmountExpression
