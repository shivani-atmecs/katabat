package com.cmc.credagility.core.domain.twilio;

import com.cmc.credagility.core.domain.base.BaseEntity;

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
 * @version  01/26/2015 14:32
 */
@Entity
@Table(name = "TwilioIVRDecisionNode")
public class TwilioIVRDecisionNode extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7355095126259675393L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "failPromptNodeId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioIVRPromptNode failPromptNode;


  /** DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "nextDecisionNodeId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioIVRDecisionNode nextDecisionNode;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "successPromptNodeId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioIVRPromptNode successPromptNode;

  /** TODO: DOCUMENT ME! */
  @Column(length = 64)
  @Enumerated(value = EnumType.STRING)
  protected TwilioDecisionType twilioDecisionType = TwilioDecisionType.Has_Agent_Login;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for fail prompt node.
   *
   * @return  TwilioIVRPromptNode
   */
  public TwilioIVRPromptNode getFailPromptNode() {
    return failPromptNode;
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
   * getter method for next decision node.
   *
   * @return  TwilioIVRDecisionNode
   */
  public TwilioIVRDecisionNode getNextDecisionNode() {
    return nextDecisionNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for success prompt node.
   *
   * @return  TwilioIVRPromptNode
   */
  public TwilioIVRPromptNode getSuccessPromptNode() {
    return successPromptNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio decision type.
   *
   * @return  TwilioDecisionType
   */
  public TwilioDecisionType getTwilioDecisionType() {
    return twilioDecisionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fail prompt node.
   *
   * @param  failPromptNode  TwilioIVRPromptNode
   */
  public void setFailPromptNode(TwilioIVRPromptNode failPromptNode) {
    this.failPromptNode = failPromptNode;
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
   * setter method for next decision node.
   *
   * @param  nextDecisionNode  TwilioIVRDecisionNode
   */
  public void setNextDecisionNode(TwilioIVRDecisionNode nextDecisionNode) {
    this.nextDecisionNode = nextDecisionNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for success prompt node.
   *
   * @param  successPromptNode  TwilioIVRPromptNode
   */
  public void setSuccessPromptNode(TwilioIVRPromptNode successPromptNode) {
    this.successPromptNode = successPromptNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio decision type.
   *
   * @param  twilioDecisionType  TwilioDecisionType
   */
  public void setTwilioDecisionType(TwilioDecisionType twilioDecisionType) {
    this.twilioDecisionType = twilioDecisionType;
  }
} // end class TwilioIVRDecisionNode
