package com.cmc.credagility.core.domain.businesscontext;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:34
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
public class BCNodeStrategyResultHistory extends AbstractBCNodeStrategyResult { }
