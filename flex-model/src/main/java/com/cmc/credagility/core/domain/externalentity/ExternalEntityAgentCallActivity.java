package com.cmc.credagility.core.domain.externalentity;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.activity.BaseActivity;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionChannel;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionDestination;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionSpokeTo;
import com.cmc.credagility.core.domain.portfolio.PortfolioAgentDispositionCode;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/09/2015 16:35
 */
@Entity
@Table(
  name    = "ExternalEntityAgentCallActivity",
  indexes = {
    @Index(
      name = "idx_TwilioCustomerDispositionCode_dispositionCode",
      columnList = "dispositionCode"
    ), @Index(
      name = "idx_channel",
      columnList = "channel"
    )
  }
)
public class ExternalEntityAgentCallActivity extends BaseActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1340446154631668278L;


  /** activity name. */
  private static String NAME = "AgentCallActivity";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Agent call Activity PK activityId. */
  @Column(
    name     = "activityId",
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long activityId;

  /** working agent. */
  @Column(length = 255)
  @JoinColumn(
    name       = "agentName",
    insertable = true,
    nullable   = false
  )
  protected String agentName;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "callEndDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date callEndDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "callStartDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date callStartDate;

  /** debtor phone number. */
  @Column(
    name   = "channel",
    length = 50
  )
  protected String channel;

  /** comments. */
  @Column(
    name   = "comments",
    length = 512
  )
  protected String comments;


  /** contact phone. */
  @JoinColumn(
    name       = "phoneId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactPhone contactPhone;


  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "coreAgentDispositionChannelId",
    insertable = true,
    nullable   = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionChannel coreAgentDispositionChannel;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "coreAgentDispositionDestinationId",
    insertable = true,
    nullable   = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionDestination coreAgentDispositionDestination;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "coreAgentDispositionSpokeToId",
    insertable = true,
    nullable   = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionSpokeTo coreAgentDispositionSpokeTo;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "customerId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;


  /** debtor phone type. */
  @Column(
    name   = "destination",
    length = 100
  )
  protected String destination;

  /** DOCUMENT ME! */

  @Column(
    name   = "dispositionCode",
    length = 50
  )
  protected String dispositionCode;

  /** duration in second. */
  @Column(name = "duration")
  protected Long duration;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "externalEntityId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ExternalEntity externalEntity;

  /** DOCUMENT ME! */
  @Column(name = "nextWorkDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date nextWorkDate;

  /** debtor phone number. */
  @Column(
    name   = "phoneNumber",
    length = 20
  )
  protected String phoneNumber;

  /** Phone type. */
  @JoinColumn(name = "phoneTypeId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected PhoneType phoneType;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioAgentDispositionCodeId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioAgentDispositionCode portfolioAgentDispositionCode = null;

  /** DOCUMENT ME! */
  @Column(
    name   = "source",
    length = 20
  )
  protected String source;

  /** To whom the agent spoke to: primary, secondary, legal, none, spouse */
  @Column(
    name   = "spokeTo",
    length = 100
  )
  protected String spokeTo;
  @Column(
    name   = "clientDefined80CharCode1",
    length = 80
  )
  private String   clientDefined80CharCode1;

  @Column(
    name   = "clientDefined80CharCode2",
    length = 80
  )
  private String clientDefined80CharCode2;

  @Column(name = "clientDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate1;

  @Column(name = "clientDefinedDate2")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate2;

  @Column(
    name      = "clientDefinedDecimal1",
    precision = 19,
    scale     = 2
  )
  private BigDecimal clientDefinedDecimal1;

  @Column(
    name      = "clientDefinedDecimal2",
    precision = 19,
    scale     = 2
  )
  private BigDecimal clientDefinedDecimal2;

  @Column(
    name   = "clientDefinedFlag1",
    length = 1
  )
  private String clientDefinedFlag1;

  @Column(
    name   = "clientDefinedFlag2",
    length = 1
  )
  private String clientDefinedFlag2;

  @Column(
    name   = "clientDefinedInteger1",
    length = 11
  )
  private Integer clientDefinedInteger1;

  @Column(
    name   = "clientDefinedInteger2",
    length = 11
  )
  private Integer clientDefinedInteger2;

  @Column(name = "clientDefinedLong1")
  private Long clientDefinedLong1;

  @Column(name = "clientDefinedLong2")
  private Long clientDefinedLong2;

  @Column(
    name   = "clientDefinedString1",
    length = 256
  )
  private String clientDefinedString1;

  @Column(
    name   = "clientDefinedString2",
    length = 256
  )
  private String clientDefinedString2;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    ExternalEntityAgentCallActivity that = (ExternalEntityAgentCallActivity) o;

    if ((agentName != null) ? (!agentName.equals(that.agentName)) : (that.agentName != null)) {
      return false;
    }

    if ((callEndDate != null) ? (!callEndDate.equals(that.callEndDate)) : (that.callEndDate != null)) {
      return false;
    }

    if ((callStartDate != null) ? (!callStartDate.equals(that.callStartDate)) : (that.callStartDate != null)) {
      return false;
    }

    if ((channel != null) ? (!channel.equals(that.channel)) : (that.channel != null)) {
      return false;
    }

    if ((comments != null) ? (!comments.equals(that.comments)) : (that.comments != null)) {
      return false;
    }

    if ((contactPhone != null) ? (!contactPhone.equals(that.contactPhone)) : (that.contactPhone != null)) {
      return false;
    }

    if ((coreAgentDispositionChannel != null) ? (!coreAgentDispositionChannel.equals(
              that.coreAgentDispositionChannel)) : (that.coreAgentDispositionChannel != null)) {
      return false;
    }

    if ((coreAgentDispositionDestination != null)
          ? (!coreAgentDispositionDestination.equals(that.coreAgentDispositionDestination))
          : (that.coreAgentDispositionDestination != null)) {
      return false;
    }

    if ((coreAgentDispositionSpokeTo != null) ? (!coreAgentDispositionSpokeTo.equals(
              that.coreAgentDispositionSpokeTo)) : (that.coreAgentDispositionSpokeTo != null)) {
      return false;
    }

    if ((externalEntity != null) ? (!externalEntity.equals(that.externalEntity)) : (that.externalEntity != null)) {
      return false;
    }

    if ((customer != null) ? (!customer.equals(that.customer)) : (that.customer != null)) {
      return false;
    }

    if ((destination != null) ? (!destination.equals(that.destination)) : (that.destination != null)) {
      return false;
    }

    if ((dispositionCode != null) ? (!dispositionCode.equals(that.dispositionCode)) : (that.dispositionCode != null)) {
      return false;
    }

    if ((duration != null) ? (!duration.equals(that.duration)) : (that.duration != null)) {
      return false;
    }

    if ((nextWorkDate != null) ? (!nextWorkDate.equals(that.nextWorkDate)) : (that.nextWorkDate != null)) {
      return false;
    }

    if ((phoneNumber != null) ? (!phoneNumber.equals(that.phoneNumber)) : (that.phoneNumber != null)) {
      return false;
    }

    if ((phoneType != null) ? (!phoneType.equals(that.phoneType)) : (that.phoneType != null)) {
      return false;
    }

    if ((portfolioAgentDispositionCode != null)
          ? (!portfolioAgentDispositionCode.equals(that.portfolioAgentDispositionCode))
          : (that.portfolioAgentDispositionCode != null)) {
      return false;
    }

    if ((source != null) ? (!source.equals(that.source)) : (that.source != null)) {
      return false;
    }

    if ((spokeTo != null) ? (!spokeTo.equals(that.spokeTo)) : (that.spokeTo != null)) {
      return false;
    }

    if ((clientDefined80CharCode1 != null) ? (!clientDefined80CharCode1.equals(that.clientDefined80CharCode1))
                                           : (that.clientDefined80CharCode1 != null)) {
      return false;
    }

    if ((clientDefined80CharCode2 != null) ? (!clientDefined80CharCode2.equals(that.clientDefined80CharCode2))
                                           : (that.clientDefined80CharCode2 != null)) {
      return false;
    }

    if ((clientDefinedString1 != null) ? (!clientDefinedString1.equals(that.clientDefinedString1))
                                       : (that.clientDefinedString1 != null)) {
      return false;
    }

    if ((clientDefinedString2 != null) ? (!clientDefinedString2.equals(that.clientDefinedString2))
                                       : (that.clientDefinedString2 != null)) {
      return false;
    }

    if ((clientDefinedDate1 != null) ? (!clientDefinedDate1.equals(that.clientDefinedDate1))
                                     : (that.clientDefinedDate1 != null)) {
      return false;
    }

    if ((clientDefinedDate2 != null) ? (!clientDefinedDate2.equals(that.clientDefinedDate2))
                                     : (that.clientDefinedDate2 != null)) {
      return false;
    }

    if ((clientDefinedDecimal1 != null) ? (!clientDefinedDecimal1.equals(that.clientDefinedDecimal1))
                                        : (that.clientDefinedDecimal1 != null)) {
      return false;
    }

    if ((clientDefinedDecimal2 != null) ? (!clientDefinedDecimal2.equals(that.clientDefinedDecimal2))
                                        : (that.clientDefinedDecimal2 != null)) {
      return false;
    }

    if ((clientDefinedFlag1 != null) ? (!clientDefinedFlag1.equals(that.clientDefinedFlag1))
                                     : (that.clientDefinedFlag1 != null)) {
      return false;
    }

    if ((clientDefinedFlag2 != null) ? (!clientDefinedFlag2.equals(that.clientDefinedFlag2))
                                     : (that.clientDefinedFlag2 != null)) {
      return false;
    }

    if ((clientDefinedInteger1 != null) ? (!clientDefinedInteger1.equals(that.clientDefinedInteger1))
                                        : (that.clientDefinedInteger1 != null)) {
      return false;
    }

    if ((clientDefinedInteger2 != null) ? (!clientDefinedInteger2.equals(that.clientDefinedInteger2))
                                        : (that.clientDefinedInteger2 != null)) {
      return false;
    }

    if ((clientDefinedLong1 != null) ? (!clientDefinedLong1.equals(that.clientDefinedLong1))
                                     : (that.clientDefinedLong1 != null)) {
      return false;
    }

    return (clientDefinedLong2 != null) ? clientDefinedLong2.equals(that.clientDefinedLong2)
                                        : (that.clientDefinedLong2 == null);

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The activityId.
   *
   * @return  the activityId
   *
   * @hibernate.id
   *   generator-class = "native"
   *   unsaved-value   = "null"
   */
  public Long getActivityId() {
    return this.activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @hibernate.many-to-one
   *   lazy     = "proxy"
   *   column   = "agentId"
   *   not-null = "true"
   *   class    = "com.cmc.model.User"
   *   insert   = "true"
   *   update   = "false"
   *   cascade  = "none"
   */
  public String getAgentName() {
    return agentName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call end date.
   *
   * @return  Date
   */
  public Date getCallEndDate() {
    return callEndDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call start date.
   *
   * @return  Date
   */
  public Date getCallStartDate() {
    return callStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseActivity#getChannel()
   */
  @Override public String getChannel() {
    return channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined80 char code1.
   *
   * @return  String
   */
  public String getClientDefined80CharCode1() {
    return clientDefined80CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined80 char code2.
   *
   * @return  String
   */
  public String getClientDefined80CharCode2() {
    return clientDefined80CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date1.
   *
   * @return  Date
   */
  public Date getClientDefinedDate1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date2.
   *
   * @return  Date
   */
  public Date getClientDefinedDate2() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal1() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal2() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag1.
   *
   * @return  String
   */
  public String getClientDefinedFlag1() {
    return clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag2.
   *
   * @return  String
   */
  public String getClientDefinedFlag2() {
    return clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer1.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer2.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long1.
   *
   * @return  Long
   */
  public Long getClientDefinedLong1() {
    return clientDefinedLong1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long2.
   *
   * @return  Long
   */
  public Long getClientDefinedLong2() {
    return clientDefinedLong2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string1.
   *
   * @return  String
   */
  public String getClientDefinedString1() {
    return clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string2.
   *
   * @return  String
   */
  public String getClientDefinedString2() {
    return clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The comments.
   *
   * @return  the comments
   *
   * @hibernate.property
   *   not-null = "false"
   *   length   = "512"
   */
  public String getComments() {
    return this.comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @hibernate.many-to-one
   *   lazy     = "proxy"
   *   not-null = "false"
   *   column   = "phoneId"
   *   class    = "com.cmc.model.ContactPhone"
   *   insert   = "true"
   *   update   = "false"
   *   cascade  = "none"
   */
  public ContactPhone getContactPhone() {
    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for core agent disposition channel.
   *
   * @return  CoreAgentDispositionChannel
   */
  public CoreAgentDispositionChannel getCoreAgentDispositionChannel() {
    return coreAgentDispositionChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for core agent disposition destination.
   *
   * @return  CoreAgentDispositionDestination
   */
  public CoreAgentDispositionDestination getCoreAgentDispositionDestination() {
    return coreAgentDispositionDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for core agent disposition spoke to.
   *
   * @return  CoreAgentDispositionSpokeTo
   */
  public CoreAgentDispositionSpokeTo getCoreAgentDispositionSpokeTo() {
    return coreAgentDispositionSpokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDestination() {
    return destination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDispositionCode() {
    return dispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The duration.
   *
   * @return  the duration
   *
   * @hibernate.property
   *   not-null = "false"
   */
  public Long getDuration() {
    return this.duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external entity.
   *
   * @return  ExternalEntity
   */
  public ExternalEntity getExternalEntity() {
    return externalEntity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseActivity#getName()
   */
  @Override public String getName() {
    return NAME;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @hibernate.property
   *   not-null = "false"
   */
  public Date getNextWorkDate() {
    return nextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The phoneNumber.
   *
   * @return  the phoneNumber
   *
   * @hibernate.property
   *   not-null = "false"
   *   length   = "20"
   */
  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PhoneType getPhoneType() {
    return phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio agent disposition code.
   *
   * @return  PortfolioAgentDispositionCode
   */
  public PortfolioAgentDispositionCode getPortfolioAgentDispositionCode() {
    return portfolioAgentDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source.
   *
   * @return  String
   */
  public String getSource() {
    return source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSpokeTo() {
    return spokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((agentName != null) ? agentName.hashCode() : 0);
    result = (31 * result) + ((callEndDate != null) ? callEndDate.hashCode() : 0);
    result = (31 * result) + ((callStartDate != null) ? callStartDate.hashCode() : 0);
    result = (31 * result) + ((channel != null) ? channel.hashCode() : 0);
    result = (31 * result) + ((comments != null) ? comments.hashCode() : 0);
    result = (31 * result) + ((contactPhone != null) ? contactPhone.hashCode() : 0);
    result = (31 * result) + ((coreAgentDispositionChannel != null) ? coreAgentDispositionChannel.hashCode() : 0);
    result = (31 * result)
      + ((coreAgentDispositionDestination != null) ? coreAgentDispositionDestination.hashCode() : 0);
    result = (31 * result) + ((coreAgentDispositionSpokeTo != null) ? coreAgentDispositionSpokeTo.hashCode() : 0);
    result = (31 * result) + ((externalEntity != null) ? externalEntity.hashCode() : 0);
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);
    result = (31 * result) + ((destination != null) ? destination.hashCode() : 0);
    result = (31 * result) + ((dispositionCode != null) ? dispositionCode.hashCode() : 0);
    result = (31 * result) + ((duration != null) ? duration.hashCode() : 0);
    result = (31 * result) + ((nextWorkDate != null) ? nextWorkDate.hashCode() : 0);
    result = (31 * result) + ((phoneNumber != null) ? phoneNumber.hashCode() : 0);
    result = (31 * result) + ((phoneType != null) ? phoneType.hashCode() : 0);
    result = (31 * result) + ((portfolioAgentDispositionCode != null) ? portfolioAgentDispositionCode.hashCode() : 0);
    result = (31 * result) + ((source != null) ? source.hashCode() : 0);
    result = (31 * result) + ((spokeTo != null) ? spokeTo.hashCode() : 0);
    result = (31 * result) + ((clientDefined80CharCode1 != null) ? clientDefined80CharCode1.hashCode() : 0);
    result = (31 * result) + ((clientDefined80CharCode2 != null) ? clientDefined80CharCode2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString1 != null) ? clientDefinedString1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString2 != null) ? clientDefinedString2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate1 != null) ? clientDefinedDate1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate2 != null) ? clientDefinedDate2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal1 != null) ? clientDefinedDecimal1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal2 != null) ? clientDefinedDecimal2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedFlag1 != null) ? clientDefinedFlag1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedFlag2 != null) ? clientDefinedFlag2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger1 != null) ? clientDefinedInteger1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger2 != null) ? clientDefinedInteger2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedLong1 != null) ? clientDefinedLong1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedLong2 != null) ? clientDefinedLong2.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  activityId  the activityId to set
   */
  public void setActivityId(Long activityId) {
    this.activityId = activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentName  DOCUMENT ME!
   */
  public void setAgentName(String agentName) {
    this.agentName = agentName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call end date.
   *
   * @param  callEndDate  Date
   */
  public void setCallEndDate(Date callEndDate) {
    this.callEndDate = callEndDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call start date.
   *
   * @param  callStartDate  Date
   */
  public void setCallStartDate(Date callStartDate) {
    this.callStartDate = callStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channel  DOCUMENT ME!
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined80 char code1.
   *
   * @param  clientDefined80CharCode1  String
   */
  public void setClientDefined80CharCode1(String clientDefined80CharCode1) {
    this.clientDefined80CharCode1 = clientDefined80CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined80 char code2.
   *
   * @param  clientDefined80CharCode2  String
   */
  public void setClientDefined80CharCode2(String clientDefined80CharCode2) {
    this.clientDefined80CharCode2 = clientDefined80CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date1.
   *
   * @param  clientDefinedDate1  Date
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date2.
   *
   * @param  clientDefinedDate2  Date
   */
  public void setClientDefinedDate2(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal1.
   *
   * @param  clientDefinedDecimal1  BigDecimal
   */
  public void setClientDefinedDecimal1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal2.
   *
   * @param  clientDefinedDecimal2  BigDecimal
   */
  public void setClientDefinedDecimal2(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag1.
   *
   * @param  clientDefinedFlag1  String
   */
  public void setClientDefinedFlag1(String clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag2.
   *
   * @param  clientDefinedFlag2  String
   */
  public void setClientDefinedFlag2(String clientDefinedFlag2) {
    this.clientDefinedFlag2 = clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer1.
   *
   * @param  clientDefinedInteger1  Integer
   */
  public void setClientDefinedInteger1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer2.
   *
   * @param  clientDefinedInteger2  Integer
   */
  public void setClientDefinedInteger2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long1.
   *
   * @param  clientDefinedLong1  Long
   */
  public void setClientDefinedLong1(Long clientDefinedLong1) {
    this.clientDefinedLong1 = clientDefinedLong1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long2.
   *
   * @param  clientDefinedLong2  Long
   */
  public void setClientDefinedLong2(Long clientDefinedLong2) {
    this.clientDefinedLong2 = clientDefinedLong2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string1.
   *
   * @param  clientDefinedString1  String
   */
  public void setClientDefinedString1(String clientDefinedString1) {
    this.clientDefinedString1 = clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string2.
   *
   * @param  clientDefinedString2  String
   */
  public void setClientDefinedString2(String clientDefinedString2) {
    this.clientDefinedString2 = clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  comments  the comments to set
   */
  public void setComments(String comments) {
    this.comments = (comments != null) ? comments.trim() : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  contactPhone  DOCUMENT ME!
   */
  public void setContactPhone(ContactPhone contactPhone) {
    this.contactPhone = contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for core agent disposition channel.
   *
   * @param  coreAgentDispositionChannel  CoreAgentDispositionChannel
   */
  public void setCoreAgentDispositionChannel(CoreAgentDispositionChannel coreAgentDispositionChannel) {
    this.coreAgentDispositionChannel = coreAgentDispositionChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for core agent disposition destination.
   *
   * @param  coreAgentDispositionDestination  CoreAgentDispositionDestination
   */
  public void setCoreAgentDispositionDestination(CoreAgentDispositionDestination coreAgentDispositionDestination) {
    this.coreAgentDispositionDestination = coreAgentDispositionDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for core agent disposition spoke to.
   *
   * @param  coreAgentDispositionSpokeTo  CoreAgentDispositionSpokeTo
   */
  public void setCoreAgentDispositionSpokeTo(CoreAgentDispositionSpokeTo coreAgentDispositionSpokeTo) {
    this.coreAgentDispositionSpokeTo = coreAgentDispositionSpokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  destination  DOCUMENT ME!
   */
  public void setDestination(String destination) {
    this.destination = destination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dispositionCode  DOCUMENT ME!
   */
  public void setDispositionCode(String dispositionCode) {
    this.dispositionCode = dispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  duration  the duration to set
   */
  public void setDuration(Long duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external entity.
   *
   * @param  externalEntity  ExternalEntity
   */
  public void setExternalEntity(ExternalEntity externalEntity) {
    this.externalEntity = externalEntity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nextWorkDate  DOCUMENT ME!
   */
  public void setNextWorkDate(Date nextWorkDate) {
    this.nextWorkDate = nextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNumber  the phoneNumber to set
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneType  DOCUMENT ME!
   */
  public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio agent disposition code.
   *
   * @param  portfolioAgentDispositionCode  PortfolioAgentDispositionCode
   */
  public void setPortfolioAgentDispositionCode(PortfolioAgentDispositionCode portfolioAgentDispositionCode) {
    this.portfolioAgentDispositionCode = portfolioAgentDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source.
   *
   * @param  source  String
   */
  public void setSource(String source) {
    this.source = source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  spokeTo  DOCUMENT ME!
   */
  public void setSpokeTo(String spokeTo) {
    this.spokeTo = spokeTo;
  }
} // end class ExternalEntityAgentCallActivity
