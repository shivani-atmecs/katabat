package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
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

import com.cmc.credagility.core.domain.AssignmentTrace;
import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.assignmentaction.AgencyAccount;
import com.cmc.credagility.core.domain.assignmentaction.AgentAccount;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.config.FlexSelectConfig;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.ozstrategy.credagility.core.domain.ChargeOffReason;


/**
 * This class is used to store AccountIndex information.
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/15/2014 11:11
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "accountUniqueIdIndex",
      columnList = "accountUniqueId"
    ),
    @Index(
      name = "accountUniqueIdHashIndex",
      columnList = "accountUniqueIdHash"
    ),
    @Index(
      name = "runComplianceIndex",
      columnList = "runCompliance"
    ),
    @Index(
      name = "runNonOperationalStrategiesIndex",
      columnList = "runNonOperationalStrategies"
    ),
    @Index(
      name = "runOperationalStrategiesIndex",
      columnList = "runOperationalStrategies"
    ),
    @Index(
      name = "eSignProvidedIndex",
      columnList = "eSignProvided"
    ),
    @Index(
      name = "hiddenFromQueueIndex",
      columnList = "hiddenFromQueue"
    ),
    @Index(
      name = "last4OriginalAccountNumberIndex",
      columnList = "last4OriginalAccountNumber"
    ),
    @Index(
      name = "leadAccountIndex",
      columnList = "leadAccount"
    ),
    @Index(
      name = "originalAccountNumberHashIndex",
      columnList = "originalAccountNumberHash"
    ),
    @Index(
      name = "priorityScoreIndex",
      columnList = "priorityScore"
    ),
    @Index(
      name = "allResponsibleDeletedDateIndex",
      columnList = "allResponsibleDeletedDate"
    ), @Index(
      name = "lastDisposedDateIndex",
      columnList = "lastDisposedDate"
    ), @Index(
      name = "lastLoadedDateIndex",
      columnList = "lastLoadedDate"
    )
  }
)
public class AccountIndex extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 7791657770137495310L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountAggregateId",
    updatable = false
  )
  @ManyToOne(cascade = CascadeType.ALL)
  protected AccountAggregate accountAggregate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "accountUniqueId",
    length = 255
  )
  protected String accountUniqueId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "accountUniqueIdHash",
    length = 255
  )
  protected String accountUniqueIdHash;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "agencyAccountId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyAccount agencyAccount;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "agentId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "agentAccountId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgentAccount agentAccount;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowCallBack = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "assignmentTraceId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AssignmentTrace assignmentTrace;

  /** TODO: DOCUMENT ME! */
  @Column(name = "chargeOffDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date chargeOffDate;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "chargeOffReasonId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ChargeOffReason chargeOffReason;

  /** TODO: DOCUMENT ME! */
  @Column(name = "exportKillDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date exportKillDate;

  /** Account Index id PK. */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long         id;

  /** TODO: DOCUMENT ME! */
  @Column(name = "importKillDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date importKillDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "initialAgentAssignmentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date initialAgentAssignmentDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "initialRoleAssignmentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date initialRoleAssignmentDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isChargeOff = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastClickToDialAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastClickToDialAttemptDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastDialerAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastDialerAttemptDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastEmailAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastEmailAttemptDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastLetterAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLetterAttemptDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastOutboundIvrAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastOutboundIvrAttemptDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastSmsAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastSmsAttemptDate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "previousAgentId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User previousAgent;

  /** TODO: DOCUMENT ME! */
  @Column(name = "previousInitialAgentAssignmentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date previousInitialAgentAssignmentDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "previousInitialRoleAssignmentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date previousInitialRoleAssignmentDate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "previousRoleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role previousRole;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "roleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role role;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean runCompliance = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean runNonOperationalStrategies = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean runOperationalStrategies = Boolean.TRUE;


  /** TODO: DOCUMENT ME! */
  @Column(name = "soldDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date soldDate;

  /** DOCUMENT ME! */
  @Column(name = "updateActionDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date updateActionDate;

  /** Account link accountNum. */
  @JoinColumn(
    name     = "accountNum",
    unique   = true,
    nullable = false
  )
  @ManyToOne private Account account;

  @Column(name = "allResponsibleDeletedDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date allResponsibleDeletedDate;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean eSignProvided = Boolean.FALSE;

  @JoinColumn(name = "flexSelectConfigId")
  @ManyToOne(fetch = FetchType.EAGER)
  private FlexSelectConfig flexSelectConfig;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean hiddenFromQueue = Boolean.FALSE;

  @Column(
    length   = 4,
    nullable = false
  )
  private String last4OriginalAccountNumber;

  @Column(name = "lastDisposedDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastDisposedDate;

  @Column(name = "lastLoadedDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastLoadedDate;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean leadAccount;

  @Column(
    length   = 48,
    nullable = false
  )
  private String originalAccountNumberHash;

  @JoinColumn(
    name     = "nextWorkDateDispositionId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AgentCallActivity previousDisposition;

  @Column(name = "priorityScore")
  private Long priorityScore = null;

  @Column(
    name             = "updateActionBoolean",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean updateActionBoolean = Boolean.FALSE;

  @Column(name = "updateActionDecimal")
  private BigDecimal updateActionDecimal;

  @Column(
    name   = "updateActionInteger",
    length = 9
  )
  private Integer updateActionInteger;

  @Column(
    name   = "updateActionString",
    length = 255
  )
  private String updateActionString;

  @Column(
    name   = "updateActionString2",
    length = 255
  )
  private String updateActionString2;

  @Column(
    name   = "updateActionString3",
    length = 255
  )
  private String updateActionString3;

  @Column(name = "updateActionDate2")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateActionDate2;

  @Column(name = "updateActionDate3")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateActionDate3;


  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    AccountIndex that = (AccountIndex) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((last4OriginalAccountNumber != null) ? (!last4OriginalAccountNumber.equals(that.last4OriginalAccountNumber))
                                             : (that.last4OriginalAccountNumber != null)) {
      return false;
    }

    if ((originalAccountNumberHash != null) ? (!originalAccountNumberHash.equals(that.originalAccountNumberHash))
                                            : (that.originalAccountNumberHash != null)) {
      return false;
    }

    if ((accountUniqueIdHash != null) ? (!accountUniqueIdHash.equals(that.accountUniqueIdHash))
                                      : (that.accountUniqueIdHash != null)) {
      return false;
    }

    if ((runNonOperationalStrategies != null) ? (!runNonOperationalStrategies.equals(
              that.runNonOperationalStrategies)) : (that.runNonOperationalStrategies != null)) {
      return false;
    }

    if ((runOperationalStrategies != null) ? (!runOperationalStrategies.equals(
              that.runOperationalStrategies)) : (that.runOperationalStrategies != null)) {
      return false;
    }

    if ((runCompliance != null) ? (!runCompliance.equals(
              that.runCompliance)) : (that.runCompliance != null)) {
      return false;
    }

    if ((flexSelectConfig != null) ? (!flexSelectConfig.equals(
              that.flexSelectConfig)) : (that.flexSelectConfig != null)) {
      return false;
    }

    if ((eSignProvided != null) ? (!eSignProvided.equals(that.eSignProvided)) : (that.eSignProvided != null)) {
      return false;
    }

    if ((role != null) ? (!role.equals(that.role)) : (that.role != null)) {
      return false;
    }

    if ((agent != null) ? (!agent.equals(that.agent)) : (that.agent != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account aggregate.
   *
   * @return  AccountAggregate
   */
  public AccountAggregate getAccountAggregate() {
    return accountAggregate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account unique id.
   *
   * @return  String
   */
  public String getAccountUniqueId() {
    return accountUniqueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account unique id hash.
   *
   * @return  String
   */
  public String getAccountUniqueIdHash() {
    return accountUniqueIdHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency account.
   *
   * @return  AgencyAccount
   */
  public AgencyAccount getAgencyAccount() {
    return agencyAccount;
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
   * getter method for agent account.
   *
   * @return  AgentAccount
   */
  public AgentAccount getAgentAccount() {
    return agentAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow call back.
   *
   * @return  Boolean
   */
  public Boolean getAllowCallBack() {
    if (allowCallBack == null) {
      return Boolean.FALSE;
    }

    return allowCallBack;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all responsible deleted date.
   *
   * @return  Date
   */
  public Date getAllResponsibleDeletedDate() {
    return allResponsibleDeletedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assignment trace.
   *
   * @return  AssignmentTrace
   */
  public AssignmentTrace getAssignmentTrace() {
    return assignmentTrace;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off date.
   *
   * @return  Date
   */
  public Date getChargeOffDate() {
    return chargeOffDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off reason.
   *
   * @return  ChargeOffReason
   */
  public ChargeOffReason getChargeOffReason() {
    return chargeOffReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * geteSignProvided.
   *
   * @return  Boolean
   */
  public Boolean geteSignProvided() {
    if (eSignProvided == null) {
      return Boolean.FALSE;
    }

    return eSignProvided;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for export kill date.
   *
   * @return  Date
   */
  public Date getExportKillDate() {
    return exportKillDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex select config.
   *
   * @return  FlexSelectConfig
   */
  public FlexSelectConfig getFlexSelectConfig() {
    return flexSelectConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hidden from queue.
   *
   * @return  Boolean
   */
  public Boolean getHiddenFromQueue() {
    if (hiddenFromQueue == null) {
      return Boolean.FALSE;
    }

    return hiddenFromQueue;
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
   * getter method for import kill date.
   *
   * @return  Date
   */
  public Date getImportKillDate() {
    return importKillDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for initial agent assignment date.
   *
   * @return  Date
   */
  public Date getInitialAgentAssignmentDate() {
    return initialAgentAssignmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for initial role assignment date.
   *
   * @return  Date
   */
  public Date getInitialRoleAssignmentDate() {
    return initialRoleAssignmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is charge off.
   *
   * @return  Boolean
   */
  public Boolean getIsChargeOff() {
    return isChargeOff;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last4 original account number.
   *
   * @return  String
   */
  public String getLast4OriginalAccountNumber() {
    return last4OriginalAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last click to dial attempt date.
   *
   * @return  Date
   */
  public Date getLastClickToDialAttemptDate() {
    return lastClickToDialAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last dialer attempt date.
   *
   * @return  Date
   */
  public Date getLastDialerAttemptDate() {
    return lastDialerAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last disposed date.
   *
   * @return  Date
   */
  public Date getLastDisposedDate() {
    return lastDisposedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last email attempt date.
   *
   * @return  Date
   */
  public Date getLastEmailAttemptDate() {
    return lastEmailAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last letter attempt date.
   *
   * @return  Date
   */
  public Date getLastLetterAttemptDate() {
    return lastLetterAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last loaded date.
   *
   * @return  Date
   */
  public Date getLastLoadedDate() {
    return lastLoadedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last outbound ivr attempt date.
   *
   * @return  Date
   */
  public Date getLastOutboundIvrAttemptDate() {
    return lastOutboundIvrAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last sms attempt date.
   *
   * @return  Date
   */
  public Date getLastSmsAttemptDate() {
    return lastSmsAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lead account.
   *
   * @return  Boolean
   */
  public Boolean getLeadAccount() {
    return leadAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original account number hash.
   *
   * @return  String
   */
  public String getOriginalAccountNumberHash() {
    return originalAccountNumberHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous agent.
   *
   * @return  User
   */
  public User getPreviousAgent() {
    return previousAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous disposition.
   *
   * @return  AgentCallActivity
   */
  public AgentCallActivity getPreviousDisposition() {
    return previousDisposition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous initial agent assignment date.
   *
   * @return  Date
   */
  public Date getPreviousInitialAgentAssignmentDate() {
    return previousInitialAgentAssignmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous initial role assignment date.
   *
   * @return  Date
   */
  public Date getPreviousInitialRoleAssignmentDate() {
    return previousInitialRoleAssignmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous role.
   *
   * @return  Role
   */
  public Role getPreviousRole() {
    return previousRole;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority score.
   *
   * @return  Long
   */
  public Long getPriorityScore() {
    return priorityScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role.
   *
   * @return  Role
   */
  public Role getRole() {
    return role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for run compliance.
   *
   * @return  Boolean
   */
  public Boolean getRunCompliance() {
    return runCompliance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for run non operational strategies.
   *
   * @return  Boolean
   */
  public Boolean getRunNonOperationalStrategies() {
    if (null == runNonOperationalStrategies) {
      return false;
    }

    return runNonOperationalStrategies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for run operational strategies.
   *
   * @return  Boolean
   */
  public Boolean getRunOperationalStrategies() {
    return runOperationalStrategies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sold date.
   *
   * @return  Date
   */
  public Date getSoldDate() {
    return soldDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update action boolean.
   *
   * @return  Boolean
   */
  public Boolean getUpdateActionBoolean() {
    return updateActionBoolean;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update action date.
   *
   * @return  Date
   */
  public Date getUpdateActionDate() {
    return updateActionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update action decimal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getUpdateActionDecimal() {
    return updateActionDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update action integer.
   *
   * @return  Integer
   */
  public Integer getUpdateActionInteger() {
    return updateActionInteger;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update action string.
   *
   * @return  String
   */
  public String getUpdateActionString() {
    return updateActionString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((last4OriginalAccountNumber != null) ? last4OriginalAccountNumber.hashCode() : 0);
    result = (31 * result) + ((runNonOperationalStrategies != null) ? runNonOperationalStrategies.hashCode() : 0);
    result = (31 * result) + ((runOperationalStrategies != null) ? runOperationalStrategies.hashCode() : 0);
    result = (31 * result) + ((runCompliance != null) ? runCompliance.hashCode() : 0);
    result = (31 * result) + ((flexSelectConfig != null) ? flexSelectConfig.hashCode() : 0);
    result = (31 * result) + ((originalAccountNumberHash != null) ? originalAccountNumberHash.hashCode() : 0);
    result = (31 * result) + ((accountUniqueIdHash != null) ? accountUniqueIdHash.hashCode() : 0);
    result = (31 * result) + ((eSignProvided != null) ? eSignProvided.hashCode() : 0);
    result = (31 * result) + ((agent != null) ? agent.hashCode() : 0);
    result = (31 * result) + ((role != null) ? role.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account aggregate.
   *
   * @param  accountAggregate  AccountAggregate
   */
  public void setAccountAggregate(AccountAggregate accountAggregate) {
    this.accountAggregate = accountAggregate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account unique id.
   *
   * @param  accountUniqueId  String
   */
  public void setAccountUniqueId(String accountUniqueId) {
    this.accountUniqueId = accountUniqueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account unique id hash.
   *
   * @param  accountUniqueIdHash  String
   */
  public void setAccountUniqueIdHash(String accountUniqueIdHash) {
    this.accountUniqueIdHash = accountUniqueIdHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency account.
   *
   * @param  agencyAccount  AgencyAccount
   */
  public void setAgencyAccount(AgencyAccount agencyAccount) {
    this.agencyAccount = agencyAccount;
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
   * setter method for agent account.
   *
   * @param  agentAccount  AgentAccount
   */
  public void setAgentAccount(AgentAccount agentAccount) {
    this.agentAccount = agentAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow call back.
   *
   * @param  allowCallBack  Boolean
   */
  public void setAllowCallBack(Boolean allowCallBack) {
    this.allowCallBack = allowCallBack;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for all responsible deleted date.
   *
   * @param  allResponsibleDeletedDate  Date
   */
  public void setAllResponsibleDeletedDate(Date allResponsibleDeletedDate) {
    this.allResponsibleDeletedDate = allResponsibleDeletedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assignment trace.
   *
   * @param  assignmentTrace  AssignmentTrace
   */
  public void setAssignmentTrace(AssignmentTrace assignmentTrace) {
    this.assignmentTrace = assignmentTrace;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off date.
   *
   * @param  chargeOffDate  Date
   */
  public void setChargeOffDate(Date chargeOffDate) {
    this.chargeOffDate = chargeOffDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off reason.
   *
   * @param  chargeOffReason  ChargeOffReason
   */
  public void setChargeOffReason(ChargeOffReason chargeOffReason) {
    this.chargeOffReason = chargeOffReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * seteSignProvided.
   *
   * @param  eSignProvided  Boolean
   */
  public void seteSignProvided(Boolean eSignProvided) {
    this.eSignProvided = eSignProvided;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export kill date.
   *
   * @param  exportKillDate  Date
   */
  public void setExportKillDate(Date exportKillDate) {
    this.exportKillDate = exportKillDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex select config.
   *
   * @param  flexSelectConfig  FlexSelectConfig
   */
  public void setFlexSelectConfig(FlexSelectConfig flexSelectConfig) {
    this.flexSelectConfig = flexSelectConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hidden from queue.
   *
   * @param  hiddenFromQueue  Boolean
   */
  public void setHiddenFromQueue(Boolean hiddenFromQueue) {
    this.hiddenFromQueue = hiddenFromQueue;
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
   * setter method for import kill date.
   *
   * @param  importKillDate  Date
   */
  public void setImportKillDate(Date importKillDate) {
    this.importKillDate = importKillDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for initial agent assignment date.
   *
   * @param  initialAgentAssignmentDate  Date
   */
  public void setInitialAgentAssignmentDate(Date initialAgentAssignmentDate) {
    this.initialAgentAssignmentDate = initialAgentAssignmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for initial role assignment date.
   *
   * @param  initialRoleAssignmentDate  Date
   */
  public void setInitialRoleAssignmentDate(Date initialRoleAssignmentDate) {
    this.initialRoleAssignmentDate = initialRoleAssignmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for is charge off.
   *
   * @param  isChargeOff  Boolean
   */
  public void setIsChargeOff(Boolean isChargeOff) {
    this.isChargeOff = isChargeOff;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last4 original account number.
   *
   * @param  last4OriginalAccountNumber  String
   */
  public void setLast4OriginalAccountNumber(String last4OriginalAccountNumber) {
    this.last4OriginalAccountNumber = last4OriginalAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last click to dial attempt date.
   *
   * @param  lastClickToDialAttemptDate  Date
   */
  public void setLastClickToDialAttemptDate(Date lastClickToDialAttemptDate) {
    this.lastClickToDialAttemptDate = lastClickToDialAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last dialer attempt date.
   *
   * @param  lastDialerAttemptDate  Date
   */
  public void setLastDialerAttemptDate(Date lastDialerAttemptDate) {
    this.lastDialerAttemptDate = lastDialerAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last disposed date.
   *
   * @param  lastDisposedDate  Date
   */
  public void setLastDisposedDate(Date lastDisposedDate) {
    this.lastDisposedDate = lastDisposedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last email attempt date.
   *
   * @param  lastEmailAttemptDate  Date
   */
  public void setLastEmailAttemptDate(Date lastEmailAttemptDate) {
    this.lastEmailAttemptDate = lastEmailAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last letter attempt date.
   *
   * @param  lastLetterAttemptDate  Date
   */
  public void setLastLetterAttemptDate(Date lastLetterAttemptDate) {
    this.lastLetterAttemptDate = lastLetterAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last loaded date.
   *
   * @param  lastLoadedDate  Date
   */
  public void setLastLoadedDate(Date lastLoadedDate) {
    this.lastLoadedDate = lastLoadedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last outbound ivr attempt date.
   *
   * @param  lastOutboundIvrAttemptDate  Date
   */
  public void setLastOutboundIvrAttemptDate(Date lastOutboundIvrAttemptDate) {
    this.lastOutboundIvrAttemptDate = lastOutboundIvrAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last sms attempt date.
   *
   * @param  lastSmsAttemptDate  Date
   */
  public void setLastSmsAttemptDate(Date lastSmsAttemptDate) {
    this.lastSmsAttemptDate = lastSmsAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for lead account.
   *
   * @param  leadAccount  Boolean
   */
  public void setLeadAccount(Boolean leadAccount) {
    this.leadAccount = leadAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original account number hash.
   *
   * @param  originalAccountNumberHash  String
   */
  public void setOriginalAccountNumberHash(String originalAccountNumberHash) {
    this.originalAccountNumberHash = originalAccountNumberHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous agent.
   *
   * @param  previousAgent  User
   */
  public void setPreviousAgent(User previousAgent) {
    this.previousAgent = previousAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous disposition.
   *
   * @param  previousDisposition  AgentCallActivity
   */
  public void setPreviousDisposition(AgentCallActivity previousDisposition) {
    this.previousDisposition = previousDisposition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous initial agent assignment date.
   *
   * @param  previousInitialAgentAssignmentDate  Date
   */
  public void setPreviousInitialAgentAssignmentDate(Date previousInitialAgentAssignmentDate) {
    this.previousInitialAgentAssignmentDate = previousInitialAgentAssignmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous initial role assignment date.
   *
   * @param  previousInitialRoleAssignmentDate  Date
   */
  public void setPreviousInitialRoleAssignmentDate(Date previousInitialRoleAssignmentDate) {
    this.previousInitialRoleAssignmentDate = previousInitialRoleAssignmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous role.
   *
   * @param  previousRole  Role
   */
  public void setPreviousRole(Role previousRole) {
    this.previousRole = previousRole;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority score.
   *
   * @param  priorityScore  Long
   */
  public void setPriorityScore(Long priorityScore) {
    this.priorityScore = priorityScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role.
   *
   * @param  role  Role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for run compliance.
   *
   * @param  runCompliance  Boolean
   */
  public void setRunCompliance(Boolean runCompliance) {
    this.runCompliance = runCompliance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for run non operational strategies.
   *
   * @param  runNonOperationalStrategies  Boolean
   */
  public void setRunNonOperationalStrategies(Boolean runNonOperationalStrategies) {
    this.runNonOperationalStrategies = runNonOperationalStrategies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for run operational strategies.
   *
   * @param  runOperationalStrategies  Boolean
   */
  public void setRunOperationalStrategies(Boolean runOperationalStrategies) {
    this.runOperationalStrategies = runOperationalStrategies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sold date.
   *
   * @param  soldDate  Date
   */
  public void setSoldDate(Date soldDate) {
    this.soldDate = soldDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update action boolean.
   *
   * @param  updateActionBoolean  Boolean
   */
  public void setUpdateActionBoolean(Boolean updateActionBoolean) {
    this.updateActionBoolean = updateActionBoolean;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update action date.
   *
   * @param  updateActionDate  Date
   */
  public void setUpdateActionDate(Date updateActionDate) {
    this.updateActionDate = updateActionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update action decimal.
   *
   * @param  updateActionDecimal  BigDecimal
   */
  public void setUpdateActionDecimal(BigDecimal updateActionDecimal) {
    this.updateActionDecimal = updateActionDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update action integer.
   *
   * @param  updateActionInteger  Integer
   */
  public void setUpdateActionInteger(Integer updateActionInteger) {
    this.updateActionInteger = updateActionInteger;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update action string.
   *
   * @param  updateActionString  String
   */
  public void setUpdateActionString(String updateActionString) {
    this.updateActionString = updateActionString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  public String getUpdateActionString2() {
    return updateActionString2;
  }

  public void setUpdateActionString2(String updateActionString2) {
    this.updateActionString2 = updateActionString2;
  }

  public String getUpdateActionString3() {
    return updateActionString3;
  }

  public void setUpdateActionString3(String updateActionString3) {
    this.updateActionString3 = updateActionString3;
  }

  public Date getUpdateActionDate2() {
    return updateActionDate2;
  }

  public void setUpdateActionDate2(Date updateActionDate2) {
    this.updateActionDate2 = updateActionDate2;
  }

  public Date getUpdateActionDate3() {
    return updateActionDate3;
  }

  public void setUpdateActionDate3(Date updateActionDate3) {
    this.updateActionDate3 = updateActionDate3;
  }

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("AccountIndex");
    sb.append("{id=").append(id);
    sb.append(", account=").append(account);
    sb.append(", last4OriginalAccountNumber='").append(last4OriginalAccountNumber).append('\'');
    sb.append(", originalAccountNumberHash='").append(originalAccountNumberHash).append('\'');
    sb.append(", accountUniqueIdHash='").append(accountUniqueIdHash).append('\'');
    sb.append(", runNonOperationalStrategies='").append(runNonOperationalStrategies).append('\'');
    sb.append(", runCompliance='").append(runCompliance).append('\'');
    sb.append(", user='").append(agent).append('\'');
    sb.append(", role='").append(role).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class AccountIndex
