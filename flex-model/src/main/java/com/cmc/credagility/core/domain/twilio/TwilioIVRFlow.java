package com.cmc.credagility.core.domain.twilio;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @version  01/26/2015 14:31
 */
@Entity
@Table(name = "TwilioIVRFlow")
public class TwilioIVRFlow extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -877994552401924806L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String phoneNumber;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "startDecisionNodeId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioIVRDecisionNode startDecisionNode;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "startPromptNodeId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioIVRPromptNode startPromptNode;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "twilioSubAccountId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioSubAccount twilioSubAccount;

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
   * getter method for phone number.
   *
   * @return  String
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start decision node.
   *
   * @return  TwilioIVRDecisionNode
   */
  public TwilioIVRDecisionNode getStartDecisionNode() {
    return startDecisionNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start prompt node.
   *
   * @return  TwilioIVRPromptNode
   */
  public TwilioIVRPromptNode getStartPromptNode() {
    return startPromptNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio sub account.
   *
   * @return  TwilioSubAccount
   */
  public TwilioSubAccount getTwilioSubAccount() {
    return twilioSubAccount;
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
   * setter method for phone number.
   *
   * @param  phoneNumber  String
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start decision node.
   *
   * @param  startDecisionNode  TwilioIVRDecisionNode
   */
  public void setStartDecisionNode(TwilioIVRDecisionNode startDecisionNode) {
    this.startDecisionNode = startDecisionNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start prompt node.
   *
   * @param  startPromptNode  TwilioIVRPromptNode
   */
  public void setStartPromptNode(TwilioIVRPromptNode startPromptNode) {
    this.startPromptNode = startPromptNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio sub account.
   *
   * @param  twilioSubAccount  TwilioSubAccount
   */
  public void setTwilioSubAccount(TwilioSubAccount twilioSubAccount) {
    this.twilioSubAccount = twilioSubAccount;
  }
} // end class TwilioIVRFlow
