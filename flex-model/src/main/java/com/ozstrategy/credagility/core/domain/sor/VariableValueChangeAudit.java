package com.ozstrategy.credagility.core.domain.sor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created by coin on 6/24/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  06/24/2016 14:22
 */
@Entity @Table public class VariableValueChangeAudit extends BaseVariableValueAudit {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6100908709940478102L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column protected String previousValue;

  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * @see  BaseVariableValueAudit#equals(Object)
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

    VariableValueChangeAudit that = (VariableValueChangeAudit) o;

    return ((previousValue != null) ? (!previousValue.equals(that.previousValue)) : (that.previousValue != null));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous value.
   *
   * @return  String
   */
  public String getPreviousValue() {
    return previousValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  BaseVariableValueAudit#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((context != null) ? context.hashCode() : 0);
    result = (31 * result) + ((currentValue != null) ? currentValue.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((executor != null) ? executor.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((previousValue != null) ? previousValue.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((triggerSource != null) ? triggerSource.hashCode() : 0);
    result = (31 * result) + ((variableName != null) ? variableName.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous value.
   *
   * @param  previousValue  String
   */
  public void setPreviousValue(String previousValue) {
    this.previousValue = previousValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  BaseVariableValueAudit#toString()
   */
  @Override public String toString() {
    final String  TAB      = "    ";
    StringBuilder retValue = new StringBuilder();
    retValue.append("VariableValueChangeAudit ( ").append(super.toString()).append(TAB).append(
      "previousValue== ").append((this.previousValue != null) ? this.previousValue : "").append(TAB).append(TAB).append(
      " )");

    return retValue.toString();
  } // end method toString
} // end class VariableValueChangeAudit
