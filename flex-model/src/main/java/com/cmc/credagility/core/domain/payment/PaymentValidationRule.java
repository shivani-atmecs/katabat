package com.cmc.credagility.core.domain.payment;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.document.BaseValidationRule;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:31
 */
@Entity
@Table(
  name    = "PaymentValidationRule",
  indexes = {
    @Index(
      name = "priorityIndex",
      columnList = "priority"
    ), @Index(
      name = "ruleNameIndex",
      columnList = "ruleName"
    )
  }
)
public class PaymentValidationRule extends BaseValidationRule { } // end class PaymentValidationRule
