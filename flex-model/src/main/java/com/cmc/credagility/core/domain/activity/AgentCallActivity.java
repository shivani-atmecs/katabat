package com.cmc.credagility.core.domain.activity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.ININCustomerAuthentication;
import com.cmc.credagility.core.domain.account.AccountAuthorizedContact;
import com.cmc.credagility.core.domain.account.AccountAuthorizedUser;
import com.cmc.credagility.core.domain.channel.OutboundCallVerification;
import com.cmc.credagility.core.domain.channel.TelephonyActivity;
import com.cmc.credagility.core.domain.channel.VoiceMailActivity;
import com.cmc.credagility.core.domain.client.AdvisorAppointment;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionChannel;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionDestination;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionSpokeTo;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionSpokeToRef;
import com.cmc.credagility.core.domain.memo.Memo;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.domain.payment.PromiseToPay;
import com.cmc.credagility.core.domain.portfolio.OutcomeType;
import com.cmc.credagility.core.domain.portfolio.PortfolioAgentDispositionCode;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyAnswer;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.CallType;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.user.UserLoadedAccount;
import com.cmc.credagility.core.domain.user.UserLoadedCustomer;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * This class is used to log all agent call activity.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/16/2014 18:11 PM
 */
@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property  = "activityId",
  scope     = AgentCallActivity.class
)
@Table(
  name              = "AgentCallActivity",
  uniqueConstraints = { @UniqueConstraint(columnNames = "vmId") },
  indexes           = {
    @Index(
      name          = "vmId_2",
      columnList    = "vmId",
      unique        = true
    ),
    @Index(
      name          = "idx_channel",
      columnList    = "channel"
    ),
    @Index(
      name          = "idx_TwilioCustomerDispositionCode_customerCallSid",
      columnList    = "customerCallSid"
    ),
    @Index(
      name          = "idx_TwilioCustomerDispositionCode_dispositionCode",
      columnList    = "dispositionCode"
    )
  }
)
public class AgentCallActivity extends BaseActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7030446154631668278L;

  /** activity type. */
  private static String CHANNEL = "AgentCall";

  /** activity name. */
  private static String NAME = "AgentCallActivity";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Agent call Activity PK activityId. */
  @Column(
    name     = "activityId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long activityId;

  /** The advisor appointment this activity created for. */
  @JoinColumn(
    name       = "appointmentId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AdvisorAppointment advisorAppointment;

  /** working agent. */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

  /** call Type. */
  @Column(
    name     = "callType",
    nullable = false,
    length   = 15
  )
  @Enumerated(value = EnumType.STRING)
  protected CallType callType;

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

  /** the call activity referred to contact phone. */
  @JoinColumn(
    name       = "phoneId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactPhone contactPhone;

  /** disposition channel. */
  @JoinColumn(
    name       = "coreAgentDispositionChannelId",
    insertable = true,
    nullable   = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionChannel coreAgentDispositionChannel;

  /** destination of the disposition. */
  @JoinColumn(
    name       = "coreAgentDispositionDestinationId",
    insertable = true,
    nullable   = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionDestination coreAgentDispositionDestination;

  /** spoke to of the disposition. */
  @JoinColumn(
    name       = "coreAgentDispositionSpokeToId",
    insertable = true,
    nullable   = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionSpokeTo coreAgentDispositionSpokeTo;

  /** the reference of spoke to. */
  @JoinColumn(
    name       = "coreAgentDispositionSpokeToRefId",
    insertable = true,
    nullable   = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionSpokeToRef coreAgentDispositionSpokeToRef;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "customerId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** TODO: DOCUMENT ME! */
  protected String customerCallSid;

  /** debtor phone type. */
  @Column(
    name   = "destination",
    length = 100
  )
  protected String destination;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "dispositionCode",
    length = 10
  )
  protected String dispositionCode;


  /** duration in second. */
  @Column(name = "duration")
  protected Long duration;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "externalReferenceNumber",
    nullable = true,
    length   = 255
  )
  protected String externalReferenceNumber;

  /** inbound call id. */
  @Column protected Long inboundId;

  /** the memo message for disposition. */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "agentCallActivity",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Memo memo;

  /** the next workf date set at disposition. */
  @Column(name = "nextWorkDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date nextWorkDate;

  /** referred to {@link com.cmc.credagility.core.domain.channel.OutboundCallVerification}. */
  @JoinColumn(
    name       = "outboundCallVerificationId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected OutboundCallVerification outboundCallVerification;

  /** outbound call id. */
  @Column protected Long outboundId;

  /** Relations AgentCallActivity. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "agentCallActivity",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<Payment> payments = new LinkedHashSet<Payment>();

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

  /** phone types. */
  @Column(name = "phoneTypes")
  protected String phoneTypes;

  /** PortfolioAgentDispositionCode. */
  @JoinColumn(
    name      = "portfolioAgentDispositionCodeId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioAgentDispositionCode portfolioAgentDispositionCode = null;

  /** Relations AgentCallActivity. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "agentCallActivity",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<PortfolioSurveyAnswer> portfolioSurveyAnswers = new LinkedHashSet<PortfolioSurveyAnswer>();

  /** Relations AgentCallActivity. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "agentCallActivity",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<PromiseToPay> promiseToPays = new LinkedHashSet<PromiseToPay>();

  /** result. */
  @JoinColumn(
    name       = "resultId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected OutcomeType result;

  /** working role. */
  @Column protected Long roleId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "sourceCategory",
    length = 20
  )
  protected String sourceCategory;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "sourceId",
    length = 20
  )
  protected Long sourceId;

  /** To whom the agent spoke to: primary, secondary, legal, none, spouse */
  @Column(
    name   = "spokeTo",
    length = 100
  )
  protected String spokeTo;

  /** Referred to com.cmc.credagility.core.domain.account.AccountAuthorizedContact. */
  @JoinColumn(name = "spokeToAccountAuthorizedContactId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountAuthorizedContact spokeToAccountAuthorizedContact;

  /** Referred to com.cmc.credagility.core.domain.account.AccountAuthorizedUser. */
  @JoinColumn(name = "spokeToAccountAuthorizedUserId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountAuthorizedUser spokeToAccountAuthorizedUser;

  /** the responsible of the agent spoke to. */
  @JoinColumn(name = "spokeToResponsibleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible spokeToResponsible;

  // USB-1534
  /** account. */
  @JoinColumn(
    name     = "telephonyActivityId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TelephonyActivity telephonyActivity;
  // USB-1534

  /** Referred to com.cmc.credagility.core.domain.user.UserLoadedAccount. */
  @JoinColumn(
    name       = "userLoadedAccountId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected UserLoadedAccount userLoadedAccount;

  /** Referred to com.cmc.credagility.core.domain.user.UserLoadedCustomer. */
  @JoinColumn(
    name       = "userLoadedCustomerId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected UserLoadedCustomer userLoadedCustomer;

  /** Referred to com.cmc.credagility.core.domain.channel.VoiceMailActivity. */
  @JoinColumn(
    name       = "vmId",
    unique     = true,
    insertable = true,
    updatable  = false
  )
  @OneToOne(
    fetch         = FetchType.LAZY,
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected VoiceMailActivity        voiceMail;
  @JoinColumn(
    name       = "ininCustomerAuthenticationId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private ININCustomerAuthentication ininCustomerAuthentication;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final AgentCallActivity other = (AgentCallActivity) obj;

    if (this.createDate == null) {
      if (other.getCreateDate() != null) {
        return false;
      }
    } else if (!this.createDate.equals(other.getCreateDate())) {
      return false;
    }

    if (this.activityId == null) {
      if (other.getActivityId() != null) {
        return false;
      }
    } else if (!this.activityId.equals(other.getActivityId())) {
      return false;
    }

    if (this.agent == null) {
      if (other.getAgent() != null) {
        return false;
      }
    } else if (!this.agent.equals(other.getAgent())) {
      return false;
    }

    if (this.coreAgentDispositionChannel == null) {
      if (other.getCoreAgentDispositionChannel() != null) {
        return false;
      }
    } else if (!this.coreAgentDispositionChannel.equals(other.getCoreAgentDispositionChannel())) {
      return false;
    }

    if (this.coreAgentDispositionDestination == null) {
      if (other.getCoreAgentDispositionDestination() != null) {
        return false;
      }
    } else if (!this.coreAgentDispositionDestination.equals(other.getCoreAgentDispositionDestination())) {
      return false;
    }

    if (this.coreAgentDispositionSpokeTo == null) {
      if (other.getCoreAgentDispositionSpokeTo() != null) {
        return false;
      }
    } else if (!this.coreAgentDispositionSpokeTo.equals(other.getCoreAgentDispositionSpokeTo())) {
      return false;
    }

    if (this.portfolioAgentDispositionCode == null) {
      if (other.getPortfolioAgentDispositionCode() != null) {
        return false;
      }
    } else if (!this.portfolioAgentDispositionCode.equals(other.getPortfolioAgentDispositionCode())) {
      return false;
    }

    if (this.nextWorkDate == null) {
      if (other.getNextWorkDate() != null) {
        return false;
      }
    } else if (!this.nextWorkDate.equals(other.getNextWorkDate())) {
      return false;
    }

    if (this.customer == null) {
      if (other.getCustomer() != null) {
        return false;
      }
    } else if (!this.customer.equals(other.getCustomer())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for activity id.
   *
   * @return  Long
   */
  public Long getActivityId() {
    return this.activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for advisor appointment.
   *
   * @return  AdvisorAppointment
   */
  public AdvisorAppointment getAdvisorAppointment() {
    return advisorAppointment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call type.
   *
   * @return  CallType
   */
  public CallType getCallType() {
    return this.callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#getChannel()
   */
  @Override public String getChannel() {
    return channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for comments.
   *
   * @return  String
   */
  public String getComments() {
    return this.comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact phone.
   *
   * @return  ContactPhone
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
   * getter method for core agent disposition spoke to ref.
   *
   * @return  CoreAgentDispositionSpokeToRef
   */
  public CoreAgentDispositionSpokeToRef getCoreAgentDispositionSpokeToRef() {
    return coreAgentDispositionSpokeToRef;
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
   * getter method for customer call sid.
   *
   * @return  String
   */
  public String getCustomerCallSid() {
    return customerCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for destination.
   *
   * @return  String
   */
  public String getDestination() {
    return destination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disposition code.
   *
   * @return  String
   */
  public String getDispositionCode() {
    return dispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for duration.
   *
   * @return  Long
   */
  public Long getDuration() {
    return this.duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external reference number.
   *
   * @return  String
   */
  public String getExternalReferenceNumber() {
    return externalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for inbound id.
   *
   * @return  Long
   */
  public Long getInboundId() {
    return inboundId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for inin customer authentication.
   *
   * @return  ININCustomerAuthentication
   */
  public ININCustomerAuthentication getIninCustomerAuthentication() {
    return ininCustomerAuthentication;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for memo.
   *
   * @return  Memo
   */
  public Memo getMemo() {
    return memo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#getName()
   */
  @Override public String getName() {
    return NAME;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next work date.
   *
   * @return  Date
   */
  public Date getNextWorkDate() {
    return nextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for outbound call verification.
   *
   * @return  OutboundCallVerification
   */
  public OutboundCallVerification getOutboundCallVerification() {
    return outboundCallVerification;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for outbound id.
   *
   * @return  Long
   */
  public Long getOutboundId() {
    return outboundId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment program.
   *
   * @return  PaymentProgram
   */
  public PaymentProgram getPaymentProgram() {
    if ((promiseToPays != null) && (promiseToPays.size() > 0)) {
      for (PromiseToPay promise : promiseToPays) {
        if (promise.getPaymentProgramInstallment() != null) {
          return promise.getPaymentProgramInstallment().getPaymentProgram();
        }
      }
    }

    if ((payments != null) && (payments.size() > 0)) {
      for (Payment payment : payments) {
        if (payment.getPaymentProgramInstallment() != null) {
          return payment.getPaymentProgramInstallment().getPaymentProgram();
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payments.
   *
   * @return  Set
   */
  public Set<Payment> getPayments() {
    return payments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone number.
   *
   * @return  String
   */
  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type.
   *
   * @return  PhoneType
   */
  public PhoneType getPhoneType() {
    return phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone types.
   *
   * @return  String
   */
  public String getPhoneTypes() {
    return phoneTypes;
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
   * getter method for portfolio survey answers.
   *
   * @return  Set
   */
  public Set<PortfolioSurveyAnswer> getPortfolioSurveyAnswers() {
    return portfolioSurveyAnswers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promise to pays.
   *
   * @return  Set
   */
  public Set<PromiseToPay> getPromiseToPays() {
    return promiseToPays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for result.
   *
   * @return  OutcomeType
   */
  public OutcomeType getResult() {
    return this.result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role id.
   *
   * @return  Long
   */
  public Long getRoleId() {
    return roleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source category.
   *
   * @return  String
   */
  public String getSourceCategory() {
    return sourceCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source id.
   *
   * @return  Long
   */
  public Long getSourceId() {
    return sourceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spoke to.
   *
   * @return  String
   */
  public String getSpokeTo() {
    return spokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spoke to account authorized contact.
   *
   * @return  AccountAuthorizedContact
   */
  public AccountAuthorizedContact getSpokeToAccountAuthorizedContact() {
    return spokeToAccountAuthorizedContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spoke to account authorized user.
   *
   * @return  AccountAuthorizedUser
   */
  public AccountAuthorizedUser getSpokeToAccountAuthorizedUser() {
    return spokeToAccountAuthorizedUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spoke to responsible.
   *
   * @return  Responsible
   */
  public Responsible getSpokeToResponsible() {
    return spokeToResponsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for telephony activity.
   *
   * @return  TelephonyActivity
   */
  public TelephonyActivity getTelephonyActivity() {
    return telephonyActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user loaded account.
   *
   * @return  UserLoadedAccount
   */
  public UserLoadedAccount getUserLoadedAccount() {
    return userLoadedAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user loaded customer.
   *
   * @return  UserLoadedCustomer
   */
  public UserLoadedCustomer getUserLoadedCustomer() {
    return userLoadedCustomer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for voice mail.
   *
   * @return  VoiceMailActivity
   */
  public VoiceMailActivity getVoiceMail() {
    return voiceMail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result)
      + ((this.activityId == null) ? 0 : this.activityId.hashCode());
    result = (PRIME * result)
      + ((this.agent == null) ? 0 : this.agent.hashCode());
    result = (PRIME * result)
      + ((this.coreAgentDispositionChannel == null) ? 0 : this.coreAgentDispositionChannel.hashCode());
    result = (PRIME * result)
      + ((this.coreAgentDispositionDestination == null) ? 0 : this.coreAgentDispositionDestination.hashCode());
    result = (PRIME * result)
      + ((this.coreAgentDispositionSpokeTo == null) ? 0 : this.coreAgentDispositionSpokeTo.hashCode());
    result = (PRIME * result)
      + ((this.portfolioAgentDispositionCode == null) ? 0 : this.portfolioAgentDispositionCode.hashCode());
    result = (PRIME * result)
      + ((this.nextWorkDate == null) ? 0 : this.nextWorkDate.hashCode());
    result = (PRIME * result)
      + ((this.customer == null) ? 0 : this.customer.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for activity id.
   *
   * @param  activityId  Long
   */
  public void setActivityId(Long activityId) {
    this.activityId = activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for advisor appointment.
   *
   * @param  advisorAppointment  AdvisorAppointment
   */
  public void setAdvisorAppointment(AdvisorAppointment advisorAppointment) {
    this.advisorAppointment = advisorAppointment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call type.
   *
   * @param  callType  CallType
   */
  public void setCallType(CallType callType) {
    this.callType = callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel.
   *
   * @param  channel  String
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for comments.
   *
   * @param  comments  String
   */
  public void setComments(String comments) {
    this.comments = (comments != null) ? comments.trim() : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact phone.
   *
   * @param  contactPhone  ContactPhone
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
   * setter method for core agent disposition spoke to ref.
   *
   * @param  coreAgentDispositionSpokeToRef  CoreAgentDispositionSpokeToRef
   */
  public void setCoreAgentDispositionSpokeToRef(CoreAgentDispositionSpokeToRef coreAgentDispositionSpokeToRef) {
    this.coreAgentDispositionSpokeToRef = coreAgentDispositionSpokeToRef;
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
   * setter method for customer call sid.
   *
   * @param  customerCallSid  String
   */
  public void setCustomerCallSid(String customerCallSid) {
    this.customerCallSid = customerCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for destination.
   *
   * @param  destination  String
   */
  public void setDestination(String destination) {
    this.destination = destination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disposition code.
   *
   * @param  dispositionCode  String
   */
  public void setDispositionCode(String dispositionCode) {
    this.dispositionCode = dispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duration.
   *
   * @param  duration  Long
   */
  public void setDuration(Long duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external reference number.
   *
   * @param  externalReferenceNumber  String
   */
  public void setExternalReferenceNumber(String externalReferenceNumber) {
    this.externalReferenceNumber = externalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for inbound id.
   *
   * @param  inboundId  Long
   */
  public void setInboundId(Long inboundId) {
    this.inboundId = inboundId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for inin customer authentication.
   *
   * @param  ininCustomerAuthentication  ININCustomerAuthentication
   */
  public void setIninCustomerAuthentication(ININCustomerAuthentication ininCustomerAuthentication) {
    this.ininCustomerAuthentication = ininCustomerAuthentication;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for memo.
   *
   * @param  memo  Memo
   */
  public void setMemo(Memo memo) {
    this.memo = memo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next work date.
   *
   * @param  nextWorkDate  Date
   */
  public void setNextWorkDate(Date nextWorkDate) {
    this.nextWorkDate = nextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for outbound call verification.
   *
   * @param  outboundCallVerification  OutboundCallVerification
   */
  public void setOutboundCallVerification(OutboundCallVerification outboundCallVerification) {
    this.outboundCallVerification = outboundCallVerification;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for outbound id.
   *
   * @param  outboundId  Long
   */
  public void setOutboundId(Long outboundId) {
    this.outboundId = outboundId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payments.
   *
   * @param  payments  Set
   */
  public void setPayments(Set<Payment> payments) {
    this.payments = payments;
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
   * setter method for phone type.
   *
   * @param  phoneType  PhoneType
   */
  public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone types.
   *
   * @param  phoneTypes  String
   */
  public void setPhoneTypes(String phoneTypes) {
    this.phoneTypes = phoneTypes;
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
   * setter method for portfolio survey answers.
   *
   * @param  portfolioSurveyAnswers  Set
   */
  public void setPortfolioSurveyAnswers(Set<PortfolioSurveyAnswer> portfolioSurveyAnswers) {
    this.portfolioSurveyAnswers = portfolioSurveyAnswers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for promise to pays.
   *
   * @param  promiseToPays  Set
   */
  public void setPromiseToPays(Set<PromiseToPay> promiseToPays) {
    this.promiseToPays = promiseToPays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for result.
   *
   * @param  result  OutcomeType
   */
  public void setResult(OutcomeType result) {
    this.result = result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role id.
   *
   * @param  roleId  Long
   */
  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source category.
   *
   * @param  sourceCategory  String
   */
  public void setSourceCategory(String sourceCategory) {
    this.sourceCategory = sourceCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source id.
   *
   * @param  sourceId  Long
   */
  public void setSourceId(Long sourceId) {
    this.sourceId = sourceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spoke to.
   *
   * @param  spokeTo  String
   */
  public void setSpokeTo(String spokeTo) {
    this.spokeTo = spokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spoke to account authorized contact.
   *
   * @param  spokeToAccountAuthorizedContact  AccountAuthorizedContact
   */
  public void setSpokeToAccountAuthorizedContact(AccountAuthorizedContact spokeToAccountAuthorizedContact) {
    this.spokeToAccountAuthorizedContact = spokeToAccountAuthorizedContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spoke to account authorized user.
   *
   * @param  spokeToAccountAuthorizedUser  AccountAuthorizedUser
   */
  public void setSpokeToAccountAuthorizedUser(AccountAuthorizedUser spokeToAccountAuthorizedUser) {
    this.spokeToAccountAuthorizedUser = spokeToAccountAuthorizedUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spoke to responsible.
   *
   * @param  spokeToResponsible  Responsible
   */
  public void setSpokeToResponsible(Responsible spokeToResponsible) {
    this.spokeToResponsible = spokeToResponsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for telephony activity.
   *
   * @param  telephonyActivity  TelephonyActivity
   */
  public void setTelephonyActivity(TelephonyActivity telephonyActivity) {
    this.telephonyActivity = telephonyActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user loaded account.
   *
   * @param  userLoadedAccount  UserLoadedAccount
   */
  public void setUserLoadedAccount(UserLoadedAccount userLoadedAccount) {
    this.userLoadedAccount = userLoadedAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user loaded customer.
   *
   * @param  userLoadedCustomer  UserLoadedCustomer
   */
  public void setUserLoadedCustomer(UserLoadedCustomer userLoadedCustomer) {
    this.userLoadedCustomer = userLoadedCustomer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for voice mail.
   *
   * @param  voiceMail  VoiceMailActivity
   */
  public void setVoiceMail(VoiceMailActivity voiceMail) {
    this.voiceMail = voiceMail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("AgentCallActivity ( ").append(super.toString()).append(TAB).append("activityId = ").append(
      this.activityId).append(TAB).append("comments = ").append(this.comments).append(TAB).append("duration = ").append(
      this.duration).append(TAB).append(
      "calltype = ").append(this.callType).append(TAB).append(
      "phoneNumber = ").append(this.phoneNumber).append(TAB).append(
      "result = ").append(this.result).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class AgentCallActivity
