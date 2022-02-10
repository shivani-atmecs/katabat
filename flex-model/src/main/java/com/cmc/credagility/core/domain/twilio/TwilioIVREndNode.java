package com.cmc.credagility.core.domain.twilio;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.ozstrategy.credagility.core.domain.HuntGroup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  01/26/2015 14:34
 */
@Entity
@Table(name = "TwilioIVREndNode")
public class TwilioIVREndNode extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6900579481588468143L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 64)
  @Enumerated(value = EnumType.STRING)
  protected TwilioIVREndNodeMode endNodeMode = TwilioIVREndNodeMode.Hunt_Group;


  /** TODO: DOCUMENT ME! */
  @Column(length = 640)
  protected String holdText;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "huntGroupdId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected HuntGroup huntGroup;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String keyValue;


  /** TODO: DOCUMENT ME! */
  protected int priority = 1;


  /** TODO: DOCUMENT ME! */
  @Column(length = 640)
  protected String text;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for end node mode.
   *
   * @return  TwilioIVREndNodeMode
   */
  public TwilioIVREndNodeMode getEndNodeMode() {
    return endNodeMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hold text.
   *
   * @return  String
   */
  public String getHoldText() {
    return holdText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hunt group.
   *
   * @return  HuntGroup
   */
  public HuntGroup getHuntGroup() {
    return huntGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for key value.
   *
   * @return  String
   */
  public String getKeyValue() {
    return keyValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  int
   */
  public int getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for text.
   *
   * @return  String
   */
  public String getText() {
    return text;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end node mode.
   *
   * @param  endNodeMode  TwilioIVREndNodeMode
   */
  public void setEndNodeMode(TwilioIVREndNodeMode endNodeMode) {
    this.endNodeMode = endNodeMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hold text.
   *
   * @param  holdText  String
   */
  public void setHoldText(String holdText) {
    this.holdText = holdText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hunt group.
   *
   * @param  huntGroup  HuntGroup
   */
  public void setHuntGroup(HuntGroup huntGroup) {
    this.huntGroup = huntGroup;
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
   * setter method for key value.
   *
   * @param  keyValue  String
   */
  public void setKeyValue(String keyValue) {
    this.keyValue = keyValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  int
   */
  public void setPriority(int priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for text.
   *
   * @param  text  String
   */
  public void setText(String text) {
    this.text = text;
  }
} // end class TwilioIVREndNode
