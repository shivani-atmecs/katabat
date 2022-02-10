package com.cmc.credagility.core.domain.webactivity;

import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:40
 */
public abstract class BaseRuleActivity extends BCCActivity implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Long   ruleId;
  private String ruleType;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseRuleActivity object.
   */
  public BaseRuleActivity() { }

  /**
   * Creates a new BaseRuleActivity object.
   *
   * @param  webActivity  WebActivity
   */
  protected BaseRuleActivity(WebActivity webActivity) {
    super(webActivity);
    this.ruleId   = new Long(webActivity.getData3());
    this.ruleType = webActivity.getData2();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule id.
   *
   * @return  Long
   */
  public Long getRuleId() {
    return ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule type.
   *
   * @return  String
   */
  public String getRuleType() {
    return ruleType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule id.
   *
   * @param  ruleId  Long
   */
  public void setRuleId(Long ruleId) {
    this.ruleId = ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule type.
   *
   * @param  ruleType  String
   */
  public void setRuleType(String ruleType) {
    this.ruleType = ruleType;
  }
} // end class BaseRuleActivity
