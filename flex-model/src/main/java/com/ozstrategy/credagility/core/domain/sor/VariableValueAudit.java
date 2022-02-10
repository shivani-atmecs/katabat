package com.ozstrategy.credagility.core.domain.sor;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created by coin on 6/24/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  06/24/2016 14:21
 */
@Entity @Table public class VariableValueAudit extends BaseVariableValueAudit {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8626212887627262982L;

  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * @see  BaseVariableValueAudit#toString()
   */
  @Override public String toString() {
    final String  TAB      = "    ";
    StringBuilder retValue = new StringBuilder();
    retValue.append("VariableValueAudit ( ").append(super.toString()).append(TAB).append(
      " )");

    return retValue.toString();
  } // end method toString
}
