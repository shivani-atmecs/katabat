package com.ozstrategy.credagility.core.domain;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;


/**
 * TODO: DOCUMENT ME!
 *
 * @version  10/16/2014 09:59
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
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
public class NodeStrategyResultHistory extends AbstractNodeStrategyResult { }
