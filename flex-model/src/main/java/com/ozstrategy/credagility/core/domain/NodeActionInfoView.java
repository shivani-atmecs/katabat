package com.ozstrategy.credagility.core.domain;

import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 13:38
 */
public class NodeActionInfoView implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -8029223941930351141L;

  /** TODO: DOCUMENT ME! */
  public static final String CHANNEL_ACTION = "CHANNEL";


  /** TODO: DOCUMENT ME! */
  public static final String PROGRAM_ACTION = "PROGRAM";


  /** TODO: DOCUMENT ME! */
  public static final String VARIABLE_ACTION = "VARIABLE";


  /** TODO: DOCUMENT ME! */
  public static final String UPDATE_VARIABLE_ACTION = "UPDATEVARIABLE";


  /** TODO: DOCUMENT ME! */
  public static final String STATUS_ACTION = "STATUS";


  /** TODO: DOCUMENT ME! */
  public static final String FLOW_ACTION = "FLOW";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Long id;


  /** TODO: DOCUMENT ME! */
  protected String name;


  /** TODO: DOCUMENT ME! */
  protected Long nid;


  /** TODO: DOCUMENT ME! */
  protected String sid;


  /** TODO: DOCUMENT ME! */
  protected String triggerType;


  /** TODO: DOCUMENT ME! */
  protected String type;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new NodeActionInfoView object.
   */
  public NodeActionInfoView() { }

  /**
   * Creates a new NodeActionInfoView object.
   *
   * @param  obj  Object[]
   */
  public NodeActionInfoView(Object[] obj) {
    this.nid         = new Long(obj[0].toString());
    this.triggerType = obj[1].toString();
    this.sid         = obj[2].toString();
    this.name        = obj[3].toString();
    this.type        = obj[4].toString();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for nid.
   *
   * @return  Long
   */
  public Long getNid() {
    return nid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sid.
   *
   * @return  String
   */
  public String getSid() {
    return sid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger type.
   *
   * @return  String
   */
  public String getTriggerType() {
    return triggerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for nid.
   *
   * @param  nid  Long
   */
  public void setNid(Long nid) {
    this.nid = nid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sid.
   *
   * @param  sid  String
   */
  public void setSid(String sid) {
    this.sid = sid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger type.
   *
   * @param  triggerType  String
   */
  public void setTriggerType(String triggerType) {
    this.triggerType = triggerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }
} // end class NodeActionInfoView
