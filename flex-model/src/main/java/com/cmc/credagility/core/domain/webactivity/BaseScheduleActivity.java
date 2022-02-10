package com.cmc.credagility.core.domain.webactivity;

import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:41
 */
public abstract class BaseScheduleActivity extends BCCActivity implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Long   scheduleId;
  private String scheduleType;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseScheduleActivity object.
   */
  public BaseScheduleActivity() { }

  /**
   * Creates a new BaseScheduleActivity object.
   *
   * @param  webActivity  WebActivity
   */
  protected BaseScheduleActivity(WebActivity webActivity) {
    super(webActivity);
    this.scheduleId   = new Long(webActivity.getData3());
    this.scheduleType = webActivity.getData2();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule id.
   *
   * @return  Long
   */
  public Long getScheduleId() {
    return scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule type.
   *
   * @return  String
   */
  public String getScheduleType() {
    return scheduleType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule id.
   *
   * @param  scheduleId  Long
   */
  public void setScheduleId(Long scheduleId) {
    this.scheduleId = scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule type.
   *
   * @param  scheduleType  String
   */
  public void setScheduleType(String scheduleType) {
    this.scheduleType = scheduleType;
  }
} // end class BaseScheduleActivity
