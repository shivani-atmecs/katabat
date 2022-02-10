package com.cmc.credagility.core.domain.payment;

import javax.persistence.*;

import com.cmc.credagility.core.domain.document.BaseValidationRule;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:31
 */
@Entity
@Table(
  name    = "PromiseToPayValidationRule",
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
public class PromiseToPayValidationRule extends BaseValidationRule {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */

  @Column(
    name             = "allowFlexSite",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowFlexSite = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowFlexStation",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowFlexStation = Boolean.FALSE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow flex site.
   *
   * @return  Boolean
   */
// CA-5615 AC.5 By default FlexStation and FlexSite will be enabled in this window.
  public Boolean getAllowFlexSite() {
    if (allowFlexSite == null) {
      return Boolean.TRUE;
    }

    return allowFlexSite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow flex station.
   *
   * @return  Boolean
   */
// CA-5615 AC.5 By default FlexStation and FlexSite will be enabled in this window.
  public Boolean getAllowFlexStation() {
    if (allowFlexStation == null) {
      return Boolean.TRUE;
    }

    return allowFlexStation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow flex site.
   *
   * @param  allowFlexSite  Boolean
   */
  public void setAllowFlexSite(Boolean allowFlexSite) {
    this.allowFlexSite = allowFlexSite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow flex station.
   *
   * @param  allowFlexStation  Boolean
   */
  public void setAllowFlexStation(Boolean allowFlexStation) {
    this.allowFlexStation = allowFlexStation;
  }
} // end class PromiseToPayValidationRule
