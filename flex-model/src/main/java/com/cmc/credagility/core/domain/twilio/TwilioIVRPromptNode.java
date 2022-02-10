package com.cmc.credagility.core.domain.twilio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  01/26/2015 14:33
 */
@Entity
@Table(name = "TwilioIVRPromptNode")
public class TwilioIVRPromptNode extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -2816838750275329076L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean containHuntGroup = false;

  /** TODO: DOCUMENT ME! */
  protected String continueKey;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean gather = false;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String gatherAction;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  protected int ivrLoopTimeoutCount;

  /** DOCUMENT ME! */
  protected int ivrLoopWait;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "nextPromptNodeId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioIVRPromptNode nextPromptNode;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String otherKey;

  /** TODO: DOCUMENT ME! */
  @Column(length = 640)
  protected String otherText;

  /** TODO: DOCUMENT ME! */
  @Column(length = 640)
  protected String text;

  /** TODO: DOCUMENT ME! */

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "timeoutDecisionNodeId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioIVRDecisionNode timeoutDecisionNode;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "timeoutEndNodeId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioIVREndNode timeoutEndNode;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "timeoutPromptNodeId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioIVRPromptNode timeoutPromptNode;
  @Column(
    name             = "wavBlob",
    columnDefinition = "LONGBLOB"
  )
  private byte[]                wavBlob;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for continue key.
   *
   * @return  String
   */
  public String getContinueKey() {
    return continueKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gather action.
   *
   * @return  String
   */
  public String getGatherAction() {
    return gatherAction;
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
   * getter method for ivr loop timeout count.
   *
   * @return  int
   */
  public int getIvrLoopTimeoutCount() {
    return ivrLoopTimeoutCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ivr loop wait.
   *
   * @return  int
   */
  public int getIvrLoopWait() {
    return ivrLoopWait;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next prompt node.
   *
   * @return  TwilioIVRPromptNode
   */
  public TwilioIVRPromptNode getNextPromptNode() {
    return nextPromptNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other key.
   *
   * @return  String
   */
  public String getOtherKey() {
    return otherKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other text.
   *
   * @return  String
   */
  public String getOtherText() {
    return otherText;
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
   * getter method for timeout decision node.
   *
   * @return  TwilioIVRDecisionNode
   */
  public TwilioIVRDecisionNode getTimeoutDecisionNode() {
    return timeoutDecisionNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for timeout end node.
   *
   * @return  TwilioIVREndNode
   */
  public TwilioIVREndNode getTimeoutEndNode() {
    return timeoutEndNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for timeout prompt node.
   *
   * @return  TwilioIVRPromptNode
   */
  public TwilioIVRPromptNode getTimeoutPromptNode() {
    return timeoutPromptNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for wav blob.
   *
   * @return  byte[]
   */
  public byte[] getWavBlob() {
    return wavBlob;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contain hunt group.
   *
   * @return  boolean
   */
  public boolean isContainHuntGroup() {
    return containHuntGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gather.
   *
   * @return  boolean
   */
  public boolean isGather() {
    return gather;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contain hunt group.
   *
   * @param  containHuntGroup  boolean
   */
  public void setContainHuntGroup(boolean containHuntGroup) {
    this.containHuntGroup = containHuntGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for continue key.
   *
   * @param  continueKey  String
   */
  public void setContinueKey(String continueKey) {
    this.continueKey = continueKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for gather.
   *
   * @param  gather  boolean
   */
  public void setGather(boolean gather) {
    this.gather = gather;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for gather action.
   *
   * @param  gatherAction  String
   */
  public void setGatherAction(String gatherAction) {
    this.gatherAction = gatherAction;
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
   * setter method for ivr loop timeout count.
   *
   * @param  ivrLoopTimeoutCount  int
   */
  public void setIvrLoopTimeoutCount(int ivrLoopTimeoutCount) {
    this.ivrLoopTimeoutCount = ivrLoopTimeoutCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr loop wait.
   *
   * @param  ivrLoopWait  int
   */
  public void setIvrLoopWait(int ivrLoopWait) {
    this.ivrLoopWait = ivrLoopWait;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next prompt node.
   *
   * @param  nextPromptNode  TwilioIVRPromptNode
   */
  public void setNextPromptNode(TwilioIVRPromptNode nextPromptNode) {
    this.nextPromptNode = nextPromptNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other key.
   *
   * @param  otherKey  String
   */
  public void setOtherKey(String otherKey) {
    this.otherKey = otherKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other text.
   *
   * @param  otherText  String
   */
  public void setOtherText(String otherText) {
    this.otherText = otherText;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for timeout decision node.
   *
   * @param  timeoutDecisionNode  TwilioIVRDecisionNode
   */
  public void setTimeoutDecisionNode(TwilioIVRDecisionNode timeoutDecisionNode) {
    this.timeoutDecisionNode = timeoutDecisionNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for timeout end node.
   *
   * @param  timeoutEndNode  TwilioIVREndNode
   */
  public void setTimeoutEndNode(TwilioIVREndNode timeoutEndNode) {
    this.timeoutEndNode = timeoutEndNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for timeout prompt node.
   *
   * @param  timeoutPromptNode  TwilioIVRPromptNode
   */
  public void setTimeoutPromptNode(TwilioIVRPromptNode timeoutPromptNode) {
    this.timeoutPromptNode = timeoutPromptNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for wav blob.
   *
   * @param  wavBlob  byte[]
   */
  public void setWavBlob(byte[] wavBlob) {
    this.wavBlob = wavBlob;
  }
} // end class TwilioIVRPromptNode
