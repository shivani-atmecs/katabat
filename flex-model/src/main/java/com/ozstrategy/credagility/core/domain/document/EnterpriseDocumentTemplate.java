package com.ozstrategy.credagility.core.domain.document;

import javax.persistence.*;
import java.io.Serializable;


/**
 * This class is used to store EnterpriseDocumentTemplate information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:34
 */
@DiscriminatorColumn(
  name              = "contentType",
  discriminatorType = DiscriminatorType.STRING
)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "EnterpriseDocumentTemplate")
public abstract class EnterpriseDocumentTemplate extends BasicEnterpriseDocumentTemplate implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3717450885238841179L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * generateVersionInfo.
   *
   * @return  EnterpriseDocumentVersionTemplate
   */
  public abstract EnterpriseDocumentVersionTemplate generateVersionInfo();
}
