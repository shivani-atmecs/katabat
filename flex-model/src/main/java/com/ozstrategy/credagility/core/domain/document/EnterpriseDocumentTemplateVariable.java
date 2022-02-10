package com.ozstrategy.credagility.core.domain.document;

import javax.persistence.Entity;
import java.io.Serializable;


/**
 * This class is used to store EnterpriseDocumentTemplateVariable information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:34
 */
@Entity public class EnterpriseDocumentTemplateVariable extends BasicEnterpriseDocumentTemplateVariable
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 439285181603971167L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocumentTemplateVariable#copy()
   */
  @Override public EnterpriseDocumentTemplateVariable copy() {
    EnterpriseDocumentTemplateVariable variable = new EnterpriseDocumentTemplateVariable();
    paste(variable);

    return variable;
  }
}
