package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created with IntelliJ IDEA. User: liaodongming Date: 12-4-6 Time: PM2:49 To change this template use File | Settings
 * | File Templates.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:37
 */
@Entity public class CommunicationCompliance extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Integer attemptsRejectedCounts = 0;

  /** TODO: DOCUMENT ME! */
  protected Integer attemptsTimePeriod = 0;

  /** Dialer/IVR Calls || Manual Calls Out || Letter ... */
  @Column(length = 255)
  protected String channelLabel;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "complianceVariableId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ComplianceVariable complianceVariable;


  /** TODO: DOCUMENT ME! */
  protected Integer contactsRejectedCounts = 0;

  /** TODO: DOCUMENT ME! */
  protected Integer contactsTimePeriod = 0;


  /** TODO: DOCUMENT ME! */
  protected Integer displayOrder = 0;

  /** CALL LETTER. */
  @Column(length = 20)
  protected String generalType;


  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  protected Integer maxAttempts = 0;


  /** TODO: DOCUMENT ME! */
  protected Integer maxContacts = 0;


  /** TODO: DOCUMENT ME! */
  protected Integer maxMessages = 0;


  /** TODO: DOCUMENT ME! */
  protected Integer maxSent = 0;


  /** TODO: DOCUMENT ME! */
  protected Integer messagesRejectedCounts = 0;

  /** TODO: DOCUMENT ME! */
  protected Integer messagesTimePeriod = 0;


  /** TODO: DOCUMENT ME! */
  protected Integer rejectedCounts = 0;


  /** TODO: DOCUMENT ME! */
  protected Integer sentRejectedCounts = 0;

  /** TODO: DOCUMENT ME! */
  protected Integer sentTimePeriod = 0;

  /** Total Home Work ... */
  @Column(length = 255)
  protected String typeLabel;

  /** DICTotal || DICHome MCOTotal || MCOHome ... */
  @Column(
    nullable = false,
    length   = 50
  )
  protected String uniqueChannelType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof CommunicationCompliance)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    CommunicationCompliance that = (CommunicationCompliance) o;

    if ((attemptsTimePeriod != null) ? (!attemptsTimePeriod.equals(that.attemptsTimePeriod))
                                     : (that.attemptsTimePeriod != null)) {
      return false;
    }

    if ((channelLabel != null) ? (!channelLabel.equals(that.channelLabel)) : (that.channelLabel != null)) {
      return false;
    }

    if ((complianceVariable != null) ? (!complianceVariable.equals(that.complianceVariable))
                                     : (that.complianceVariable != null)) {
      return false;
    }

    if ((contactsTimePeriod != null) ? (!contactsTimePeriod.equals(that.contactsTimePeriod))
                                     : (that.contactsTimePeriod != null)) {
      return false;
    }

    if ((displayOrder != null) ? (!displayOrder.equals(that.displayOrder)) : (that.displayOrder != null)) {
      return false;
    }

    if ((generalType != null) ? (!generalType.equals(that.generalType)) : (that.generalType != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((maxAttempts != null) ? (!maxAttempts.equals(that.maxAttempts)) : (that.maxAttempts != null)) {
      return false;
    }

    if ((maxContacts != null) ? (!maxContacts.equals(that.maxContacts)) : (that.maxContacts != null)) {
      return false;
    }

    if ((maxMessages != null) ? (!maxMessages.equals(that.maxMessages)) : (that.maxMessages != null)) {
      return false;
    }

    if ((maxSent != null) ? (!maxSent.equals(that.maxSent)) : (that.maxSent != null)) {
      return false;
    }

    if ((messagesTimePeriod != null) ? (!messagesTimePeriod.equals(that.messagesTimePeriod))
                                     : (that.messagesTimePeriod != null)) {
      return false;
    }

    if ((sentTimePeriod != null) ? (!sentTimePeriod.equals(that.sentTimePeriod)) : (that.sentTimePeriod != null)) {
      return false;
    }

    if ((typeLabel != null) ? (!typeLabel.equals(that.typeLabel)) : (that.typeLabel != null)) {
      return false;
    }

    if ((uniqueChannelType != null) ? (!uniqueChannelType.equals(that.uniqueChannelType))
                                    : (that.uniqueChannelType != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for attempts rejected counts.
   *
   * @return  Integer
   */
  public Integer getAttemptsRejectedCounts() {
    return attemptsRejectedCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for attempts time period.
   *
   * @return  Integer
   */
  public Integer getAttemptsTimePeriod() {
    return attemptsTimePeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel label.
   *
   * @return  String
   */
  public String getChannelLabel() {
    return channelLabel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for compliance variable.
   *
   * @return  ComplianceVariable
   */
  public ComplianceVariable getComplianceVariable() {
    return complianceVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contacts rejected counts.
   *
   * @return  Integer
   */
  public Integer getContactsRejectedCounts() {
    return contactsRejectedCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contacts time period.
   *
   * @return  Integer
   */
  public Integer getContactsTimePeriod() {
    return contactsTimePeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display order.
   *
   * @return  Integer
   */
  public Integer getDisplayOrder() {
    return displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for general type.
   *
   * @return  String
   */
  public String getGeneralType() {
    return generalType;
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
   * getter method for max attempts.
   *
   * @return  Integer
   */
  public Integer getMaxAttempts() {
    return maxAttempts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max contacts.
   *
   * @return  Integer
   */
  public Integer getMaxContacts() {
    return maxContacts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max messages.
   *
   * @return  Integer
   */
  public Integer getMaxMessages() {
    return maxMessages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max sent.
   *
   * @return  Integer
   */
  public Integer getMaxSent() {
    return maxSent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for messages rejected counts.
   *
   * @return  Integer
   */
  public Integer getMessagesRejectedCounts() {
    return messagesRejectedCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for messages time period.
   *
   * @return  Integer
   */
  public Integer getMessagesTimePeriod() {
    return messagesTimePeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rejected counts.
   *
   * @return  Integer
   */
  public Integer getRejectedCounts() {
    return rejectedCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sent rejected counts.
   *
   * @return  Integer
   */
  public Integer getSentRejectedCounts() {
    return sentRejectedCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sent time period.
   *
   * @return  Integer
   */
  public Integer getSentTimePeriod() {
    return sentTimePeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type label.
   *
   * @return  String
   */
  public String getTypeLabel() {
    return typeLabel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique channel type.
   *
   * @return  String
   */
  public String getUniqueChannelType() {
    return uniqueChannelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((complianceVariable != null) ? complianceVariable.hashCode() : 0);
    result = (31 * result) + ((displayOrder != null) ? displayOrder.hashCode() : 0);
    result = (31 * result) + ((generalType != null) ? generalType.hashCode() : 0);
    result = (31 * result) + ((channelLabel != null) ? channelLabel.hashCode() : 0);
    result = (31 * result) + ((typeLabel != null) ? typeLabel.hashCode() : 0);
    result = (31 * result) + ((uniqueChannelType != null) ? uniqueChannelType.hashCode() : 0);
    result = (31 * result) + ((maxAttempts != null) ? maxAttempts.hashCode() : 0);
    result = (31 * result) + ((attemptsTimePeriod != null) ? attemptsTimePeriod.hashCode() : 0);
    result = (31 * result) + ((maxMessages != null) ? maxMessages.hashCode() : 0);
    result = (31 * result) + ((messagesTimePeriod != null) ? messagesTimePeriod.hashCode() : 0);
    result = (31 * result) + ((maxContacts != null) ? maxContacts.hashCode() : 0);
    result = (31 * result) + ((contactsTimePeriod != null) ? contactsTimePeriod.hashCode() : 0);
    result = (31 * result) + ((maxSent != null) ? maxSent.hashCode() : 0);
    result = (31 * result) + ((sentTimePeriod != null) ? sentTimePeriod.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for attempts rejected counts.
   *
   * @param  attemptsRejectedCounts  Integer
   */
  public void setAttemptsRejectedCounts(Integer attemptsRejectedCounts) {
    this.attemptsRejectedCounts = attemptsRejectedCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for attempts time period.
   *
   * @param  attemptsTimePeriod  Integer
   */
  public void setAttemptsTimePeriod(Integer attemptsTimePeriod) {
    this.attemptsTimePeriod = attemptsTimePeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel label.
   *
   * @param  channelLabel  String
   */
  public void setChannelLabel(String channelLabel) {
    this.channelLabel = channelLabel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for compliance variable.
   *
   * @param  complianceVariable  ComplianceVariable
   */
  public void setComplianceVariable(ComplianceVariable complianceVariable) {
    this.complianceVariable = complianceVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contacts rejected counts.
   *
   * @param  contactsRejectedCounts  Integer
   */
  public void setContactsRejectedCounts(Integer contactsRejectedCounts) {
    this.contactsRejectedCounts = contactsRejectedCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contacts time period.
   *
   * @param  contactsTimePeriod  Integer
   */
  public void setContactsTimePeriod(Integer contactsTimePeriod) {
    this.contactsTimePeriod = contactsTimePeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display order.
   *
   * @param  displayOrder  Integer
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for general type.
   *
   * @param  generalType  String
   */
  public void setGeneralType(String generalType) {
    this.generalType = generalType;
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
   * setter method for max attempts.
   *
   * @param  maxAttempts  Integer
   */
  public void setMaxAttempts(Integer maxAttempts) {
    this.maxAttempts = maxAttempts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max contacts.
   *
   * @param  maxContacts  Integer
   */
  public void setMaxContacts(Integer maxContacts) {
    this.maxContacts = maxContacts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max messages.
   *
   * @param  maxMessages  Integer
   */
  public void setMaxMessages(Integer maxMessages) {
    this.maxMessages = maxMessages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max sent.
   *
   * @param  maxSent  Integer
   */
  public void setMaxSent(Integer maxSent) {
    this.maxSent = maxSent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for messages rejected counts.
   *
   * @param  messagesRejectedCounts  Integer
   */
  public void setMessagesRejectedCounts(Integer messagesRejectedCounts) {
    this.messagesRejectedCounts = messagesRejectedCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for messages time period.
   *
   * @param  messagesTimePeriod  Integer
   */
  public void setMessagesTimePeriod(Integer messagesTimePeriod) {
    this.messagesTimePeriod = messagesTimePeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rejected counts.
   *
   * @param  rejectedCounts  Integer
   */
  public void setRejectedCounts(Integer rejectedCounts) {
    this.rejectedCounts = rejectedCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sent rejected counts.
   *
   * @param  sentRejectedCounts  Integer
   */
  public void setSentRejectedCounts(Integer sentRejectedCounts) {
    this.sentRejectedCounts = sentRejectedCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sent time period.
   *
   * @param  sentTimePeriod  Integer
   */
  public void setSentTimePeriod(Integer sentTimePeriod) {
    this.sentTimePeriod = sentTimePeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type label.
   *
   * @param  typeLabel  String
   */
  public void setTypeLabel(String typeLabel) {
    this.typeLabel = typeLabel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique channel type.
   *
   * @param  uniqueChannelType  String
   */
  public void setUniqueChannelType(String uniqueChannelType) {
    this.uniqueChannelType = uniqueChannelType;
  }
} // end class CommunicationCompliance
