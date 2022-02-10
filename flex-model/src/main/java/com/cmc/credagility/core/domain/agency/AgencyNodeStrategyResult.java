package com.cmc.credagility.core.domain.agency;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:10
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "strategyDate_idx",
      columnList = "strategyDate"
    ),
    @Index(
      name = "runType_idx",
      columnList = "runType"
    )
  }
)
public class AgencyNodeStrategyResult extends AbstractAgencyNodeStrategyResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 577757581971974293L;
}
