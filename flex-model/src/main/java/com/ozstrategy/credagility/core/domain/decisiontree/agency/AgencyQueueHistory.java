package com.ozstrategy.credagility.core.domain.decisiontree.agency;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * This class is used to store AgencyQueueHistory information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 16:20
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "ix_agencyId",
      columnList = "agencyId"
    ),
    @Index(
      name = "ix_queueActionId",
      columnList = "queueActionId"
    )
  }
)
public class AgencyQueueHistory extends AgencyAbstractQueue implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4352557214465440733L;
}
