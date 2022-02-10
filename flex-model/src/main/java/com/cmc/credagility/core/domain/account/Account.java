package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.lang.reflect.InvocationTargetException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
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
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.collections.CollectionUtils;

import org.hibernate.annotations.Where;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.MethodInvoker;
import org.springframework.util.StringUtils;

import com.cmc.credagility.core.constant.COFSConstants;
import com.cmc.credagility.core.domain.ContractAssets;
import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.activity.BaseActivity;
import com.cmc.credagility.core.domain.activity.CommentActivity;
import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.agency.AgencyQueue;
import com.cmc.credagility.core.domain.agency.AgencyTeamQueue;
import com.cmc.credagility.core.domain.assignmentaction.AgencyAccount;
import com.cmc.credagility.core.domain.authorizedcontact.AuthorizedContactAddress;
import com.cmc.credagility.core.domain.authorizedcontact.AuthorizedContactPhone;
import com.cmc.credagility.core.domain.authorizeduser.AuthorizedUserAddress;
import com.cmc.credagility.core.domain.authorizeduser.AuthorizedUserPhone;
import com.cmc.credagility.core.domain.barclay.BarclayAccount;
import com.cmc.credagility.core.domain.channel.DialerActivity;
import com.cmc.credagility.core.domain.channel.DialerChannelResult;
import com.cmc.credagility.core.domain.channel.EmailActivity;
import com.cmc.credagility.core.domain.channel.EmailChannelResult;
import com.cmc.credagility.core.domain.channel.IvrActivity;
import com.cmc.credagility.core.domain.channel.IvrChannelResult;
import com.cmc.credagility.core.domain.channel.IvrOutboundAudit;
import com.cmc.credagility.core.domain.channel.LetterActivity;
import com.cmc.credagility.core.domain.channel.LetterChannelResult;
import com.cmc.credagility.core.domain.channel.SmsActivity;
import com.cmc.credagility.core.domain.channel.SmsChannelResult;
import com.cmc.credagility.core.domain.channel.VoiceMailActivity;
import com.cmc.credagility.core.domain.citi.CitiAccount;
import com.cmc.credagility.core.domain.client.AdvisorAppointment;
import com.cmc.credagility.core.domain.config.FlexSelectConfig;
import com.cmc.credagility.core.domain.contact.ContactAddress;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.domain.contact.ContactableBaseObject;
import com.cmc.credagility.core.domain.contact.GeneralContactPhone;
import com.cmc.credagility.core.domain.document.Document;
import com.cmc.credagility.core.domain.document.DocumentHistory;
import com.cmc.credagility.core.domain.document.DocumentType;
import com.cmc.credagility.core.domain.homeequity.HomeEquityPrequalifiedRefi;
import com.cmc.credagility.core.domain.income.Income;
import com.cmc.credagility.core.domain.income.IncomeAudit;
import com.cmc.credagility.core.domain.invoice.Invoice;
import com.cmc.credagility.core.domain.memo.Memo;
import com.cmc.credagility.core.domain.memo.MemoryMessage;
import com.cmc.credagility.core.domain.negotiate.NegotiateExceptionResult;
import com.cmc.credagility.core.domain.negotiate.NegotiateProgramType;
import com.cmc.credagility.core.domain.payment.AutoDebitDetail;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.domain.payment.PaymentProgramInstallment;
import com.cmc.credagility.core.domain.payment.PaymentProgramType;
import com.cmc.credagility.core.domain.payment.PromiseToPay;
import com.cmc.credagility.core.domain.portfolio.BucketDelinquentData;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioAgentDispositionCode;
import com.cmc.credagility.core.domain.portfolio.PortfolioPhoneTypeDependency;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyAnswer;
import com.cmc.credagility.core.domain.program.ProgramTemplate;
import com.cmc.credagility.core.domain.queue.AgentQueue;
import com.cmc.credagility.core.domain.responsible.Loan;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.responsible.ResponsibleDetail;
import com.cmc.credagility.core.domain.responsible.ResponsibleIndex;
import com.cmc.credagility.core.domain.responsible.ResponsibleScore;
import com.cmc.credagility.core.domain.score.ScoreType;
import com.cmc.credagility.core.domain.slm.SlmSchoolStatus;
import com.cmc.credagility.core.domain.survey.SurveyFlowVariable;
import com.cmc.credagility.core.domain.transaction.Expense;
import com.cmc.credagility.core.domain.transaction.ExpenseAudit;
import com.cmc.credagility.core.domain.treatment.TreatmentCandidate;
import com.cmc.credagility.core.domain.tsys.TsysAccount;
import com.cmc.credagility.core.domain.tsys.TsysAccountCustomData;
import com.cmc.credagility.core.domain.tsys.TsysAccountStatusCode;
import com.cmc.credagility.core.domain.tsys.TsysMemo;
import com.cmc.credagility.core.domain.tsys.TsysPaymentHistory;
import com.cmc.credagility.core.domain.type.AccountStatusCode;
import com.cmc.credagility.core.domain.type.AmountType;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.CustomerType;
import com.cmc.credagility.core.domain.type.DoNotContactReason;
import com.cmc.credagility.core.domain.type.InstallmentStatus;
import com.cmc.credagility.core.domain.type.MetaDataValueType;
import com.cmc.credagility.core.domain.type.PaymentChannel;
import com.cmc.credagility.core.domain.type.PaymentProgramTypeCode;
import com.cmc.credagility.core.domain.type.PaymentStatus;
import com.cmc.credagility.core.domain.type.ProgramSource;
import com.cmc.credagility.core.domain.type.ProgramStatus;
import com.cmc.credagility.core.domain.type.PromiseToPayStatus;
import com.cmc.credagility.core.domain.type.RoundType;
import com.cmc.credagility.core.domain.type.ScoreSource;
import com.cmc.credagility.core.domain.type.ScoreTypeEnum;
import com.cmc.credagility.core.domain.type.StatusSource;
import com.cmc.credagility.core.domain.usb.USBAccount;
import com.cmc.credagility.core.domain.user.Division;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.user.UserLoadedAccount;
import com.cmc.credagility.core.domain.util.CompareUtil;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.cmc.credagility.core.domain.util.InterestUtils;
import com.cmc.credagility.core.domain.util.NegotiateExceptionResultComparator;
import com.cmc.credagility.core.domain.util.PersonaActionComparator;
import com.cmc.credagility.core.domain.webactivity.WebActivity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;
import com.cmc.credagility.util.CollectionUtil;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.ozstrategy.credagility.core.domain.PersonaAccount;
import com.ozstrategy.credagility.core.domain.PersonaAction;
import com.ozstrategy.credagility.core.domain.ProgramAction;
import com.ozstrategy.credagility.core.domain.QueueAccount;
import com.ozstrategy.credagility.core.domain.QueueAction;
import com.ozstrategy.credagility.core.domain.RecallResult;


/**
 * This class is used to store User Account information.
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/17/2014 10:30
 */
@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property  = "accountNum",
  scope     = Account.class
)
@Table(
  name              = "Account",
  uniqueConstraints = {
    /* @UniqueConstraint(columnNames = "hePreRefiId"), */ @UniqueConstraint(columnNames = "acceptedProgramId"),
    @UniqueConstraint(columnNames = "mortgageId"), // npelleti added Unique

    // constraint mortgageID
    @UniqueConstraint(columnNames = "autoId"),
    @UniqueConstraint(columnNames = "citiAccountId"), // npelleti added

    // Unique constraint
    @UniqueConstraint(columnNames = "accountDetailId"), // npelleti added

    // Unique constraint
    @UniqueConstraint(columnNames = "helocId"), // npelleti added unique

    // constraint helocID
    @UniqueConstraint(columnNames = { "originalAccountNumber", "portfolioId" })
  },
  indexes           = {
    @Index(
      name          = "idx_batchId",
      columnList    = "batchId"
    ),
    @Index(
      name          = "uclLastFourAccount",
      columnList    = "clientDefined4CharCode1"
    ),
    @Index(
      name          = "cmcRandomDigitsIndex",
      columnList    = "cmcRandomDigits"
    ),
    @Index(
      name          = "randomDigitsIndex",
      columnList    = "randomDigits"
    ),
    @Index(
      name          = "ruleBatchIdIndex",
      columnList    = "ruleBatchId"
    )
  }
)
public class Account extends ContactableBaseObject implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1259058493177127831L;

  /** TODO: DOCUMENT ME! */
  protected static final transient Logger log = LoggerFactory.getLogger(Account.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** accepted payment program id. */
  @JoinColumn(
    name       = "acceptedProgramId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected PaymentProgram acceptedProgram;

  /** TODO: DOCUMENT ME! */
  @Column(name = "acceptProgramDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date acceptProgramDate;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountAdditionalDetail accountAdditionalDetail = null;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<AccountAssignedExternalEntity> accountAssignedExternalEntities =
    new LinkedHashSet<AccountAssignedExternalEntity>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<AccountAuthorizedContact> accountAuthorizedContacts = new LinkedHashSet<AccountAuthorizedContact>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<AccountAuthorizedUser> accountAuthorizedUsers = new LinkedHashSet<AccountAuthorizedUser>();

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountBalanceBreakDown accountBalanceBreakDown = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountConfig accountConfig = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountDelinquent accountDelinquent = null;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "accountDetailId")
  @OneToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected AccountDetail accountDetail = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountExtension accountExtension = null;


  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountExtensionBoolean accountExtensionBoolean = null;


  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountExtensionChar accountExtensionChar = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountExtensionDate accountExtensionDate = null;


  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountExtensionDecimal accountExtensionDecimal = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountExtensionInteger accountExtensionInteger = null;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<AccountFlexSelectConfigAudit> accountFlexSelectConfigAuditSet =
    new LinkedHashSet<AccountFlexSelectConfigAudit>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<AccountFlowVariableValue> accountFlowVariableValues = new LinkedHashSet<AccountFlowVariableValue>();

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountIndex accountIndex = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountInformation accountInformation = null;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<AccountMetaData> accountMetaData = new LinkedHashSet<AccountMetaData>();

  /** account number PK. */
  @Column(
    name     = "accountNum",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountNum;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<AccountNumberAudit> accountNumberAudits = new LinkedHashSet<AccountNumberAudit>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = { CascadeType.ALL }
  )
  @OrderBy("createDate desc")
  protected Set<AccountOverallStatus> accountOverallStatusSet = new LinkedHashSet<AccountOverallStatus>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<AccountPolicy> accountPolicies = new LinkedHashSet<AccountPolicy>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<AccountSaleInfo> accountSaleInfoSet = new LinkedHashSet<AccountSaleInfo>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("scoreDate asc")
  protected Set<AccountScore> accountScores = new LinkedHashSet<AccountScore>();

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected AccountSOR accountSOR = null;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("statusDate desc")
  @Where(clause = "historical is null or historical='N'")
  protected Set<AccountStatus> accountStatuses = new LinkedHashSet<AccountStatus>();

  /** Active. If not active, user can log in but can not see anything. */
  @Column(
    name             = "active",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active = Boolean.TRUE;

  /** actual exit date. */
  @Column(name = "actualExitDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date actualExitDate;

  /** agency account number. */
  @Column(
    name   = "agencyAccountNumber",
    length = 20
  )
  protected String agencyAccountNumber;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<AgencyAccount> agencyAccountSet = new LinkedHashSet<AgencyAccount>();

  /** Relation Account Queue : */
  @JoinColumn(name = "agencyQueueId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyQueue agencyQueue;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "teamQueueId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyTeamQueue agencyTeamQueue;

  /** Agent id. */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent = null;

  /** Relations Account AgentCallActivity. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<AgentCallActivity> agentCallActivities = new LinkedHashSet<AgentCallActivity>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agentQueueId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgentQueue agentQueue;

  /** TODO: DOCUMENT ME! */
  @Column(name = "agentViewedCounter")
  protected Integer agentViewedCounter = 0;

  /** TODO: DOCUMENT ME! */
  @Column(name = "agentWorkedCounter")
  protected Integer agentWorkedCounter = 0;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowWeb",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowWeb;

  /** Relation Account AdvisorAppointment: */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("appointmentDateTime asc")
  protected Set<AdvisorAppointment> appointments = new LinkedHashSet<AdvisorAppointment>();

  /** annual Percentage Rate. */
  @Column(
    name      = "apr",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal apr;
  // npelleti 08/10 made balance not null

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("amountFinanced desc, assetId")
  protected Set<ContractAssets> assets = new LinkedHashSet<ContractAssets>();

  /** Relation Account Auto Debit: */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("enrolledDate asc")
  protected Set<AutoDebitDetail> autoDebitDetails = new LinkedHashSet<AutoDebitDetail>();

  /** DOCUMENT ME! */
  @Column(name = "availableCredit")
  protected BigDecimal availableCredit;

  /** DOCUMENT ME! */
  @Column(name = "availableCreditForCash")
  protected BigDecimal availableCreditForCash;

  /** account balance. */
  @Column(
    name      = "balance",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal balance;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected BarclayAccount barclayAccount = null;

  /** Batch Import Date. */
  @Column(name = "batchFileDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date batchFileDate;

  /** batch Job Id. */
  @Column(name = "batchId")
  protected Long batchId;

  /** Behavior Score. */
  @Column(name = "behaviorScore")
  protected Integer behaviorScore;

  /** Billing cycle. */
  @Column(name = "billingCycle")
  protected Integer billingCycle;

  /** Billing Date. */
  @Column(name = "billingDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date billingDate;

  /** broken promise. */
  @Column(
    name             = "brokenPromise",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean brokenPromise;

  /** broken promise date. */
  @Column(name = "brokenPromiseDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date brokenPromiseDate;

  /** bucket amount 1. */
  @Column(name = "bucketAmount1")
  protected BigDecimal bucketAmount1;

  /** bucket amount 2. */
  @Column(name = "bucketAmount2")
  protected BigDecimal bucketAmount2;

  /** bucket amount 3. */
  @Column(name = "bucketAmount3")
  protected BigDecimal bucketAmount3;

  /** bucket amount 4. */
  @Column(name = "bucketAmount4")
  protected BigDecimal bucketAmount4;

  /** bucket amount 5. */
  @Column(name = "bucketAmount5")
  protected BigDecimal bucketAmount5;

  /** bucket amount 6. */
  @Column(name = "bucketAmount6")
  protected BigDecimal bucketAmount6;

  /** bucket amount 7. */
  @Column(name = "bucketAmount7")
  protected BigDecimal bucketAmount7;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "chargeOff",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean chargeOff = Boolean.FALSE;

  /** charge off amount. */
  @Column(name = "chargeOffAmount")
  protected BigDecimal chargeOffAmount;

  /** charge off date. */
  @Column(name = "chargeOffDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date chargeOffDate;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<ChargeOffDelayExclusion> chargeOffDelayExclusion = new LinkedHashSet<ChargeOffDelayExclusion>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "citiAccountId")
  @OneToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected CitiAccount citiAccount = null;

  /** Claimed agent id. */
  @JoinColumn(
    name       = "claimAgentId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User claimAgent = null;

  /** TODO: DOCUMENT ME! */
  @Column(name = "claimTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date claimTime = null;

  /** client code. */
  @Column(name = "clientCode")
  protected Integer clientCode;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientContactDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientContactDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined1CharCode1",
    length = 1
  )
  protected String clientDefined1CharCode1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined1CharCode2",
    length = 1
  )
  protected String clientDefined1CharCode2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined1CharCode3",
    length = 1
  )
  protected String clientDefined1CharCode3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined1CharCode4",
    length = 1
  )
  protected String clientDefined1CharCode4;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined1CharCode5",
    length = 1
  )
  protected String clientDefined1CharCode5;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined1CharCode6",
    length = 1
  )
  protected String clientDefined1CharCode6;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined1CharCode7",
    length = 1
  )
  protected String clientDefined1CharCode7;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined1CharCode8",
    length = 1
  )
  protected String clientDefined1CharCode8;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined20CharCode1",
    length = 20
  )
  protected String clientDefined20CharCode1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined20CharCode2",
    length = 20
  )
  protected String clientDefined20CharCode2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined20CharCode3",
    length = 20
  )
  protected String clientDefined20CharCode3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined2CharCode1",
    length = 2
  )
  protected String clientDefined2CharCode1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined2CharCode2",
    length = 2
  )
  protected String clientDefined2CharCode2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined2CharCode3",
    length = 2
  )
  protected String clientDefined2CharCode3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined3CharCode1",
    length = 3
  )
  protected String clientDefined3CharCode1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined3CharCode2",
    length = 3
  )
  protected String clientDefined3CharCode2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined4CharCode1",
    length = 4
  )
  protected String clientDefined4CharCode1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined4CharCode2",
    length = 4
  )
  protected String clientDefined4CharCode2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined4CharCode3",
    length = 4
  )
  protected String clientDefined4CharCode3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined6CharCode1",
    length = 6
  )
  protected String clientDefined6CharCode1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined6CharCode2",
    length = 6
  )
  protected String clientDefined6CharCode2;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedAmount1")
  protected BigDecimal clientDefinedAmount1;
  // Client Defined Fields - added 07/24

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate1;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate2")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate2;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate3")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate3;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate4")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate4;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate5")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate5;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate6")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate6;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal1",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal2",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal3",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "clientDefinedFlag1",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean clientDefinedFlag1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "clientDefinedFlag2",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean clientDefinedFlag2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "clientDefinedFlag3",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean clientDefinedFlag3;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger1")
  protected Integer clientDefinedInteger1;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger2")
  protected Integer clientDefinedInteger2;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger3")
  protected Integer clientDefinedInteger3;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger4")
  protected Integer clientDefinedInteger4;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger5")
  protected Integer clientDefinedInteger5;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger6")
  protected Integer clientDefinedInteger6;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger7")
  protected Integer clientDefinedInteger7;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger8")
  protected Integer clientDefinedInteger8;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientReceiptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientReceiptDate;

  /** CMC random digits. */
  @Column(name = "cmcRandomDigits")
  protected Integer cmcRandomDigits;

  /** Collection costs. */
  @Column(name = "collectionCosts")
  protected BigDecimal collectionCosts;

  /** collection re-age counter. */
  @Column(name = "colReageCounter")
  protected Integer colReageCounter;

  /** Relations Account CommentActivity. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<CommentActivity> commentActivities = new LinkedHashSet<CommentActivity>();

  /** TODO: DOCUMENT ME! */
  @Column(name = "commission")
  protected BigDecimal commission;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "commissionRate",
    precision = 19,
    scale     = 4
  )
  protected BigDecimal commissionRate;

  /** compensation code. */
  @Column(name = "compensationCode")
  protected Integer compensationCode;

  /** TODO: DOCUMENT ME! */
  @Column(name = "contractDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date contractDate;

  /** credit Limit. */
  @Column(name = "creditLimit")
  protected BigDecimal creditLimit;

  /** credit line. */
  @Column(name = "creditLine")
  protected BigDecimal creditLine;

  /** DOCUMENT ME! */
  @Column(name = "creditLineIncreaseDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date creditLineIncreaseDate;

  /** Current Due. */
  @Column(name = "currentDue")
  protected BigDecimal currentDue;

  /** Cycle code. */
  @Column(
    name   = "cycleCode",
    length = 4
  )
  protected String cycleCode;

  /** days since last collection. */
  @Column(name = "daysSinceLastCollection")
  protected Integer daysSinceLastCollection;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "deactivatedReason",
    length = 8
  )
  protected String deactivatedReason = null;

  /** ScoreNet ADS specific. Platform code. */
  @Column(
    name   = "dealerCode",
    length = 4
  )
  protected String dealerCode;

  /** debt type. */
  @Column(
    name   = "debtType",
    length = 10
  )
  protected String debtType;

  /** Default responsible. */
  @JoinColumn(
    name       = "defaultResponsibleId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible defaultResponsible = null;

  /** Delinquency Date. */
  @Column(name = "delinquencyDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date delinquencyDate;

  /** Days past due, delinquency days. */
  @Column(name = "delinquencyDays")
  protected Integer delinquencyDays;

  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "bucketOrder")
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Map<Integer, DelinquencyHistory> delinquencyHistory = new LinkedHashMap<Integer, DelinquencyHistory>();

  /**
   * delinquencyStage is different than delinquencyDays: delinquencyStage is related to cycle. For two account with the
   * same delinquencyDays (e.g., 30), they could have different delinquencyStage (one could b 2 cycles, the other could
   * be 1 cycle)
   */
  @Column(name = "delinquencyStage")
  protected Integer delinquencyStage;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "disallowWebReason",
    length = 8
  )
  protected String disallowWebReason = null;

  /** Relations Account DocumentHistory : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate DESC")
  protected Set<DocumentHistory> documentHistories = new LinkedHashSet<DocumentHistory>();

  /** Relations Account Document : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate DESC")
  @Where(clause = "active='Y'")
  protected Set<Document> documents = new LinkedHashSet<Document>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<AccountEligibleProgram> eligiblePrograms = new LinkedHashSet<AccountEligibleProgram>();
  // npelleti 08/10 Made column not null

  /** account entry balance. */
  @Column(
    name      = "entryBalance",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal entryBalance;

  /** entry charge off amount: when entering CMC */
  @Column(name = "entryChargeOffAmount")
  protected BigDecimal entryChargeOffAmount;

  /** entry date. */
  // npelleti, 07/29, USB, Added Annotation for column NotNull
  @Column(
    name     = "entryDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date entryDate;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("executeDate asc")
  @Where(clause = "status = 'EXECUTED'")
  protected Set<DialerChannelResult> executedDialerResults = new LinkedHashSet<DialerChannelResult>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("executeDate asc")
  @Where(clause = "status = 'EXECUTED'")
  protected Set<EmailChannelResult> executedEmailResults = new LinkedHashSet<EmailChannelResult>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("executeDate asc")
  @Where(clause = "status = 'EXECUTED'")
  protected Set<IvrChannelResult> executedIvrResults = new LinkedHashSet<IvrChannelResult>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("executeDate asc")
  @Where(clause = "status = 'EXECUTED'")
  protected Set<SmsChannelResult> executedSmsResults = new LinkedHashSet<SmsChannelResult>();

  /** TODO: DOCUMENT ME! */
  @OneToOne(mappedBy = "account")
  protected ExpenseAudit expenseAudit = null;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate asc")
  protected Set<Expense> expenses = new LinkedHashSet<Expense>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("exportDate asc")
  @Where(clause = "status = 'EXPORTED'")
  protected Set<DialerChannelResult> exportedDialerResults = new LinkedHashSet<DialerChannelResult>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.MERGE
  )
  @OrderBy("exportDate asc")
  @Where(clause = "status = 'EXPORTED'")
  protected Set<EmailChannelResult> exportedEmailResults = new LinkedHashSet<EmailChannelResult>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("exportDate asc")
  @Where(clause = "status = 'EXPORTED'")
  protected Set<IvrChannelResult> exportedIvrResults = new LinkedHashSet<IvrChannelResult>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("exportDate asc")
  @Where(clause = "status = 'EXPORTED'")
  protected Set<LetterChannelResult> exportedLetterResults = new LinkedHashSet<LetterChannelResult>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("exportDate asc")
  @Where(clause = "status = 'EXPORTED'")
  protected Set<SmsChannelResult> exportedSmsResults = new LinkedHashSet<SmsChannelResult>();

  /** DOCUMENT ME! */
  @Column(name = "feeOutstanding")
  protected BigDecimal feeOutstanding;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("adjustDate asc")
  protected Set<FinancialAdjustment> financialAdjustments = new LinkedHashSet<FinancialAdjustment>();

  /** 1st agency placement date. */
  @Column(name = "firstAgencyPlacementDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date firstAgencyPlacementDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "firstDialerDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date firstDialerDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "firstEmailDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date firstEmailDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "firstIvrDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date firstIvrDate;
  // Added for Citi

  /** TODO: DOCUMENT ME! */
  @Column(name = "firstLetterDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date firstLetterDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "firstSmsDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date firstSmsDate;

  /** Fixed payment amount. */
  @Column(name = "fixedPaymentAmount")
  protected BigDecimal fixedPaymentAmount;

  /** 4th agency placement date. */
  @Column(name = "fourthAgencyPlacementDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date fourthAgencyPlacementDate;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("statusDate desc")
  @Where(clause = "historical='Y'")
  protected Set<AccountStatus> historicalAccountStatuses = new LinkedHashSet<AccountStatus>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "hePreRefiId",
    insertable = true,
    updatable  = false,
    unique     = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  protected HomeEquityPrequalifiedRefi homeEquityPrequalifiedRefi;

  /** ScoreNet ADS specific. Host/Region code. */
  @Column(
    name   = "hostIndicator",
    length = 4
  )
  protected String hostIndicator;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account"
  )
  @OrderBy("createDate desc")
  protected Set<IncomeAudit> incomeAudits = new LinkedHashSet<IncomeAudit>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate asc")
  protected Set<Income> incomes = new LinkedHashSet<Income>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate asc")
  @Where(clause = "status = 'INIT'")
  protected Set<DialerChannelResult> initDialerResults = new LinkedHashSet<DialerChannelResult>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate asc")
  @Where(clause = "status = 'INIT'")
  protected Set<EmailChannelResult> initEmailResults = new LinkedHashSet<EmailChannelResult>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate asc")
  @Where(clause = "status = 'INIT'")
  protected Set<IvrChannelResult> initIvrResults = new LinkedHashSet<IvrChannelResult>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate asc")
  @Where(clause = "status = 'INIT'")
  protected Set<LetterChannelResult> initLetterResults = new LinkedHashSet<LetterChannelResult>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate asc")
  @Where(clause = "status = 'INIT'")
  protected Set<SmsChannelResult> initSmsResults = new LinkedHashSet<SmsChannelResult>();

  /** Interest due. */
  @Column(name = "interestDue")
  protected BigDecimal interestDue;

  /** DOCUMENT ME! */
  @Column(name = "interestOutstanding")
  protected BigDecimal interestOutstanding;

  /** Relations Account Invoice : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("invoiceDate asc")
  protected Set<Invoice> invoices = new LinkedHashSet<Invoice>();

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastContactDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastContactDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastInterestDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastInterestDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastLetterDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLetterDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastLetterId")
  protected Long lastLetterId;

  /** last web login date for this account. */
  @Column(name = "lastLoginDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLoginDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastLoginFailureDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLoginFailureDate;
  // Added for Discover

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastNSFDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastNSFDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastNSFReportDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastNSFReportDate;

  /** last pay amount. */
  @Column(name = "lastPayAmount")
  protected BigDecimal lastPayAmount;

  /** last pay date. */
  @Column(name = "lastPayDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastPayDate;

  /** last re-age date. */
  @Column(name = "lastReageDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastReageDate;

  /** last re-age type. */
  @Column(
    name   = "lastReageType",
    length = 10
  )
  protected String lastReageType;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastWorkDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastWorkDate;

  /** loan term. */
  @Column(name = "loanTerm")
  protected Integer loanTerm;

  /** TODO: DOCUMENT ME! */
  @Column(name = "loanToValue")
  protected BigDecimal loanToValue;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lockExpirationTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lockExpirationTime = null;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lockTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lockTime = null;

  /** DOCUMENT ME! */
  @Column(name = "maturityDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date maturityDate;

  /** max delinquency. */
  @Column(name = "maxDelinquencyDays")
  protected Integer maxDelinquencyDays;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("dataOrder asc")
  protected Set<MemoryMessage> memoryMessages = new LinkedHashSet<MemoryMessage>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<Memo> memos = new LinkedHashSet<Memo>();

  /** minimum pay due. */
  @Column(name = "minimumPayDue")
  protected BigDecimal minimumPayDue;

  /** Relations Account PaymentPrograms : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("strategyDate asc")
  protected Set<NegotiateExceptionResult> negotiateExceptionResults = new LinkedHashSet<NegotiateExceptionResult>();

  /** Relations Account NegotiateProgramType : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<NegotiateProgramType> negotiateProgramTypes = new LinkedHashSet<NegotiateProgramType>();

  /** TODO: DOCUMENT ME! */
  @Column(name = "nextPaymentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date nextPaymentDate;

  /** next re-age date. */
  @Column(name = "nextReageDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date nextReageDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "nextWorkDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date nextWorkDate;

  /** number of cycles delinquent. */
  @Column(name = "numberOfCyclesDelinquent")
  protected Integer numberOfCyclesDelinquent;

  /** ScoreNet ADS specific. Portfolio or Division code. This code is not unique for Logos. */
  @Column(
    name   = "officerCode",
    length = 7
  )
  protected String officerCode;

  /** TODO: DOCUMENT ME! */
  @Transient protected Date omniNextPaymentDate;


  /** TODO: DOCUMENT ME! */
  @Transient protected BigDecimal omniPastDue;

  /** open date. */
  @Column(name = "openDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date openDate;

  /** original account number. */
  @Column(
    name     = "originalAccountNumber",
    length   = 80,
    nullable = false
  )
  @Convert(converter = StringEncryptionConverter.class)
  protected String originalAccountNumber;

  /** the original charge off amount for this account. */
  @Column(name = "originalChargeOffAmount")
  protected BigDecimal originalChargeOffAmount;

  /** original creditor. */
  @Column(
    name   = "originalCreditor",
    length = 50
  )
  protected String originalCreditor;

  /** original date time-stamp. */
  @Column(name = "originalDateTimestamp")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date originalDateTimestamp;

  /** DOCUMENT ME! */
  @Column(name = "originalPrincipalAmount")
  protected BigDecimal originalPrincipalAmount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "overLimit")
  protected BigDecimal overLimit;

  /** Past Due. */
  @Column(name = "pastDue")
  protected BigDecimal pastDue;

  /** Payment due date. */
  @Column(name = "paymentDueDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paymentDueDate;

  /** Relations Account PaymentPrograms : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("programOrder asc")
  protected Set<PaymentProgram> paymentPrograms = new LinkedHashSet<PaymentProgram>();

  /** Relation Account Payment: */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("paymentDate asc")
  protected Set<Payment> payments = new LinkedHashSet<Payment>();

  /** Payment Score. */
  @Column(name = "paymentScore")
  protected Integer paymentScore;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "placementSent",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean placementSent;

  /** planned exit date. */
  @Column(name = "plannedExitDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date plannedExitDate;

  /** account portfolio. */
  // npelleti, 07/29, USB, Added Annotation for column NotNull
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Portfolio portfolio;
  // npelleti 08/10 made priorityScore not null

  /** DOCUMENT ME! */
  @Column(name = "principalOutstanding")
  protected BigDecimal principalOutstanding;

  /** Account Priority score, the high score the hinger. */
  @Column(
    name     = "priorityScore",
    nullable = false,
    length   = 11
  )
  protected Integer priorityScore = 0;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "productType",
    length = 12
  )
  protected String productType;

  /**
   * Normally we show X payment programs per day. There may be Y payment programs for this account. So we need to
   * specify the start index for the payment programs to get X out of Y payment programs. Adds a invoice for the account
   */
  @Transient protected Integer programStartIndex = new Integer(0);

  /** promise amount. */
  @Column(name = "promiseAmount")
  protected BigDecimal promiseAmount;

  /** Relation Account PTP: */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("arrivalDate asc")
  protected Set<PromiseToPay> promises = new LinkedHashSet<PromiseToPay>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<QueueAccount> queueAccounts = new LinkedHashSet<QueueAccount>();

  /** Random Digits from client import. */
  @Column(name = "randomDigits")
  protected Integer randomDigits;

  /** re-age counter. */
  @Column(name = "reageCounter")
  protected Integer reageCounter;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("createDate DESC")
  protected Set<RecallResult> recallResults = new LinkedHashSet<RecallResult>();

  /** ScoreNet ADS specific. The Code to identify agency. */
  @Transient protected String recovererCode;

  /** Relations Account Responsible : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("primaryHolder desc, responsibleId asc")
  protected Set<Responsible> responsibles = new LinkedHashSet<Responsible>();

  /** revised data time-stamp. */
  @Column(name = "revisedDateTimestamp")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date revisedDateTimestamp;

  /** rightOfOffsetLastUpdateDate. */
  @Column(name = "rightOfOffsetLastUpdateDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date rightOfOffsetLastUpdateDate;

  /** rightOfOffsetResult. */
  @Column(
    name   = "rightOfOffsetResult",
    length = 10
  )
  protected String rightOfOffsetResult;

  /** Risk Score. */
  @Column(name = "riskScore")
  protected Integer riskScore;

  /** TODO: DOCUMENT ME! */
  @Column(name = "roundCounter")
  protected Integer roundCounter = null;

  /** 2nd agency placement date. */
  @Column(name = "secondAgencyPlacementDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date secondAgencyPlacementDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "secondToLastLoginDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date secondToLastLoginDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "secondToLastLoginFailureDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date secondToLastLoginFailureDate;

  /** previous re-age date. */
  @Column(name = "secondToLastReageDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date secondToLastReageDate;
  // Added by Etisbew on 11/09/2009 for Account Active History-Start

  /** DOCUMENT ME! */
  @Column(
    name   = "shadowMode",
    length = 1
  )
  protected String shadowMode;

  /** Relations Account SPReportHistory : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SPReportHistory> spReportHistory = new LinkedHashSet<SPReportHistory>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "testAccount",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean testAccount;

  /** test digit. */
  @Column(
    name   = "testDigit",
    length = 2
  )
  protected String testDigit;

  /** 3rd agency placement date. */
  @Column(name = "thirdAgencyPlacementDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date thirdAgencyPlacementDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "totalNumberOfPayments")
  protected Integer totalNumberOfPayments;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<TreatmentCandidate> treatments = new LinkedHashSet<TreatmentCandidate>();

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected TsysAccount tsysAccount = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected TsysAccountCustomData tsysAccountCustomData = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected TsysAccountStatusCode tsysAccountStatusCode = null;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<TsysMemo> tsysMemos = new LinkedHashSet<TsysMemo>();

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected USBAccount usbAccount = null;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<UserLoadedAccount> userLoadedAccounts = new LinkedHashSet<UserLoadedAccount>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("vmDate asc")
  protected Set<VoiceMailActivity> voiceMailActivities = new LinkedHashSet<VoiceMailActivity>();

  /** Relations Account WebActivity. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "account",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate asc")
  protected Set<WebActivity> webActivities       = new LinkedHashSet<WebActivity>();
  @Column(name = "accruedInterest")
  private BigDecimal         accruedInterest;
  @JoinColumn(
    name      = "autoId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AccountAuto        auto;
  @Column(name = "cancelProgramDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date               cancelProgramDate   = null;
  @Column(
    name                                         = "chargeOffReasonCode",
    length                                       = 5
  )
  private String             chargeOffReasonCode;
  // The following properties are inspired by ScoreNet

  /** Type of the account customer. E.g., Individual or Corporate. */
  @Column(
    name   = "customerType",
    length = 2
  )
  @Enumerated(EnumType.STRING)
  private CustomerType customerType;
  @Column(
    name   = "delinquencyReasonCode",
    length = 5
  )
  private String       delinquencyReasonCode;

  /**
   * This is used to further divide an existing portfolio. For example, Alliance Data may have one portfolio but with a
   * lot of brands. Each division represent a brand (009 represents Victoria's Secret for ADS). Portfolio is the
   * smallest unit for strategy etc. -
   *
   * <p>TODO: we should consider division for branding.</p>
   */
  @JoinColumn(name = "divisionId")
  @ManyToOne(fetch = FetchType.EAGER)
  private Division              division;
  @JoinColumn(
    name      = "helocId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AccountHeloc          heloc;
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("insuranceOrder asc")
  private Set<AccountInsurance> insurances;

  /** Reserve for Rule use. */
  @Column(name = "labelledScheduleId")
  private Long            labelledScheduleId = null;
  @JoinColumn(
    name                                     = "mortgageId",
    updatable                                = false
  )
  @OneToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  private AccountMortgage mortgage;

  /** netCosts may be useful for ScoreNet. Collection costs is sort of like "total cost" */
  @Column(name = "netCosts")
  private BigDecimal netCosts;

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "account",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @Where(clause = "historical is null or historical='N'")
  private Set<PersonaAccount> personaAccounts = new LinkedHashSet<PersonaAccount>();

  @Transient private Set<String> personaSet;
  @Column(name = "principal")
  private BigDecimal             principal;
  @Column(name = "ruleBatchId")
  private Long                   ruleBatchId;

  /** If active and viewOnlyWebAccess is true, then the debtor can only see the accountSummary page. */
  @Column(
    name             = "viewOnlyWebAccess",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean viewOnlyWebAccess = Boolean.FALSE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountAdditionalDetail  programAction DOCUMENT ME!
   */
  // todo:just fix build
// public static PaymentProgram generatePaymentProgramByProgramAction(ProgramAction programAction,
// Responsible responsible, Long processId, String runType, boolean ignoreActionCriteria,
// ExpressionService expressionService) {
// String              optionalCriteria = programAction.getCriteria();
// Account             account          = responsible.getAccount();
// ResponsibleElObject obj              = new ResponsibleElObject(responsible);
//
// if (ignoreActionCriteria || (!StringUtils.hasText(optionalCriteria))
// || Boolean.TRUE.equals(expressionService.evaluate(optionalCriteria,
// obj, Boolean.class))) {
// Integer    allowedPaymentDateRange = expressionService.evaluate(programAction.getAllowedPaymentDateRange(),
// obj, null, Integer.class);
// Integer    duration                = expressionService.evaluate(programAction.getDuration(), obj, null,
// Integer.class);
// BigDecimal fixedFee                = BigDecimal.ZERO;
//
// try {
// fixedFee = expressionService.evaluate(programAction.getFixedFeeAmount(), obj, BigDecimal.class);
// } catch (Exception e) { }
//
// Integer    frequency                  = expressionService.evaluate(programAction.getFrequency(), obj,
// Integer.class);
// Integer    installmentDateTolerence   = expressionService.evaluate(programAction.getInstallmentDateTolerence(),
// obj, Integer.class);
// BigDecimal installmentDollarTolerence = expressionService.evaluate(
// programAction.getInstallmentDollarTolerence(), obj, BigDecimal.class);
// Integer    programValidDays           = expressionService.evaluate(programAction.getProgramValidDays(),
// obj, Integer.class);
// Integer    requiredPayments           = expressionService.evaluate(programAction.getRequiredPayments(),
// obj, Integer.class);
// Integer    requiredPTPs               = 0;
//
// try {
// requiredPTPs = expressionService.evaluate(programAction.getRequiredPTPs(), obj, Integer.class);
// } catch (Exception e) { }
//
// // programAction.setRequiredPTPsValue(variableService.eval(programAction.getRequiredPTPs(), responsible, Integer.class));
// // programAction.setStartDateValue(variableService.eval(programAction.getStartDateExpression(), responsible, Date.class));
// // programAction.setTotalAmountValue(variableService.eval(programAction.getTotalAmountExpression(), responsible, BigDecimal.class));
//
// String[]            exprs      = programAction.getInstallmentExpressions(duration);
// Map<String, Object> extraValue = new HashMap<String, Object>();
//
// if (programAction.getForceMappingVariable() != null) {
// extraValue.putAll(programAction.getForceMappingVariable());
// }
//
// BigDecimal[] amounts = EvaluateUtils.calculateExprAmounts(exprs, programAction.getRoundType(),
// responsible, extraValue, expressionService);
//
// if ("totalAmount".equals(programAction.getInstallmentTermSelect())) {
// amounts = EvaluateUtils.calculateExprAmounts(programAction.getTotalAmountExpression(),
// duration, programAction.getRoundType(), responsible, extraValue, expressionService);
// }
//
// if ((amounts != null) && (amounts.length > 0)) {
// for (int i = 0; i < amounts.length; i++) {
// log.info("each installment amount is " + amounts[i]);
// }
// }
//
// BigDecimal percentage = programAction.getPercentage();
//
// if (percentage == null) {
// percentage = BigDecimal.ZERO;
// }
//
// // TODO: AmountType.TOTAL_AMOUNT or MONTHLY_AMOUNT should be refactored.
// return account.addPaymentProgram(processId, null, programAction,
// programAction.getType(), null, AmountType.INDIVIDUAL_AMOUNT, programAction.getRoundType(),
// programValidDays, allowedPaymentDateRange, installmentDateTolerence,
// installmentDollarTolerence, percentage,
// duration, fixedFee,
// programAction.getPriority(),
// amounts, requiredPayments, frequency, runType, requiredPTPs,
// programAction.getAllowEagerPayment());
//
// } // end if
//
// return null;
// } // end method generatePaymentProgramByProgramAction
  /**
   * Adds a AccountDetail for the account.
   *
   * @param  accountAdditionalDetail  DOCUMENT ME!
   */
  public void addAccountAdditionalDetail(AccountAdditionalDetail accountAdditionalDetail) {
    accountAdditionalDetail.setAccount(this);
    setAccountAdditionalDetail(accountAdditionalDetail);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountAssignedExternalEntity  accountFlexSelectConfigAudit DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   */
  public boolean addAccountAssignedExternalEntity(AccountAssignedExternalEntity accountAssignedExternalEntity) {
    if (accountAssignedExternalEntity != null) {
      accountAssignedExternalEntity.setAccount(this);

      return accountAssignedExternalEntities.add(accountAssignedExternalEntity);
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountConfig  DOCUMENT ME!
   */
  public void addAccountConfig(AccountConfig accountConfig) {
    accountConfig.setAccount(this);
    setAccountConfig(accountConfig);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a AccountDetail for the account.
   *
   * @param  accountDetail  DOCUMENT ME!
   */
  public void addAccountDetail(AccountDetail accountDetail) {
    accountDetail.setAccount(this);
    setAccountDetail(accountDetail);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a AccountExtensionBoolean for the account.
   *
   * @param  accountExtensionBoolean  DOCUMENT ME!
   */
  public void addAccountExtensionBoolean(AccountExtensionBoolean accountExtensionBoolean) {
    accountExtensionBoolean.setAccount(this);
    setAccountExtensionBoolean(accountExtensionBoolean);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a AccountExtensionChar for the account.
   *
   * @param  accountExtensionChar  DOCUMENT ME!
   */
  public void addAccountExtensionChar(AccountExtensionChar accountExtensionChar) {
    accountExtensionChar.setAccount(this);
    setAccountExtensionChar(accountExtensionChar);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a AccountExtensionDate for the account.
   *
   * @param  accountExtensionDate  DOCUMENT ME!
   */
  public void addAccountExtensionDate(AccountExtensionDate accountExtensionDate) {
    accountExtensionDate.setAccount(this);
    setAccountExtensionDate(accountExtensionDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a AccountExtensionDecimal for the account.
   *
   * @param  accountExtensionDecimal  DOCUMENT ME!
   */
  public void addAccountExtensionDecimal(AccountExtensionDecimal accountExtensionDecimal) {
    accountExtensionDecimal.setAccount(this);
    setAccountExtensionDecimal(accountExtensionDecimal);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a AccountExtensionInteger for the account.
   *
   * @param  accountExtensionInteger  accountDetail DOCUMENT ME!
   */
  public void addAccountExtensionInteger(AccountExtensionInteger accountExtensionInteger) {
    accountExtensionInteger.setAccount(this);
    setAccountExtensionInteger(accountExtensionInteger);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountFlexSelectConfigAudit  DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   */
  public boolean addAccountFlexSelectConfigAudit(AccountFlexSelectConfigAudit accountFlexSelectConfigAudit) {
    if (accountFlexSelectConfigAudit != null) {
      accountFlexSelectConfigAudit.setAccount(this);

      return accountFlexSelectConfigAuditSet.add(accountFlexSelectConfigAudit);
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a AccountIndex for the account.
   *
   * @param  accountIndex  DOCUMENT ME!
   */
  public void addAccountIndex(AccountIndex accountIndex) {
    accountIndex.setAccount(this);
    setAccountIndex(accountIndex);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountNumberAudit  DOCUMENT ME!
   */
  public void addAccountNumberAudit(AccountNumberAudit accountNumberAudit) {
    getAccountNumberAudits().add(accountNumberAudit);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountPolicy  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addAccountPolicy(AccountPolicy accountPolicy) {
    accountPolicy.setAccount(this);

    return getAccountPolicies().add(accountPolicy);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   acctScore  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addAccountScore(AccountScore acctScore) {
    if ((acctScore.getScoreValue() == null)
          || (acctScore.getScoreType() == null)) {
      return false;
    }

    return this.accountScores.add(acctScore);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   scoreValue   DOCUMENT ME!
   * @param   scoreDate    DOCUMENT ME!
   * @param   scoreType    DOCUMENT ME!
   * @param   scoreSource  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addAccountScore(Integer scoreValue, Date scoreDate, ScoreTypeEnum scoreType, ScoreSource scoreSource) {
    if ((scoreValue == null) || (scoreType == null)) {
      return false;
    }

    AccountScore acctScore = new AccountScore();
    acctScore.setAccount(this);
    acctScore.setScoreDate(scoreDate);
    acctScore.setScoreValue(scoreValue);
    acctScore.setScoreSource(scoreSource);

    ScoreType type = new ScoreType();
    type.setScoreTypeId(scoreType.getScoreTypeId());
    type.setScoreName(scoreType.toString());
    acctScore.setScoreType(type);

    return this.accountScores.add(acctScore);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addAccountSOR.
   *
   * @param  sor  AccountSOR
   */
  public void addAccountSOR(AccountSOR sor) {
    sor.setAccount(this);
    setAccountSOR(sor);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountStatus  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addAccountStatus(AccountStatus accountStatus) {
    accountStatus.setAccount(this);

    return accountStatuses.add(accountStatus);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountStatusDetail  DOCUMENT ME!
   * @param   statusSource         DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addAccountStatus(AccountStatusDetail accountStatusDetail, StatusSource statusSource) {
    return addAccountStatus(accountStatusDetail, new Date(), statusSource);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   statusCode    DOCUMENT ME!
   * @param   statusSource  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addAccountStatus(AccountStatusCode statusCode, StatusSource statusSource) {
    return addAccountStatus(statusCode, new Date(), statusSource);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   threeLetterCode  DOCUMENT ME!
   * @param   statusSource     DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addAccountStatus(String threeLetterCode, StatusSource statusSource) {
    return addAccountStatus(AccountStatusCode.toAccountStatusCode(
          threeLetterCode), statusSource);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   statusDetailId  DOCUMENT ME!
   * @param   statusSource    DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addAccountStatus(Long statusDetailId, StatusSource statusSource) {
    return addAccountStatus(AccountStatusCode.toAccountStatusCode(
          statusDetailId), statusSource);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountStatusDetail  DOCUMENT ME!
   * @param   statusDate           DOCUMENT ME!
   * @param   statusSource         DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addAccountStatus(AccountStatusDetail accountStatusDetail, Date statusDate, StatusSource statusSource) {
    if ((accountStatusDetail != null)
          && (accountStatusDetail.getStatusId() != null)) {
      AccountStatus status = new AccountStatus();
      status.setAccountStatusDetail(accountStatusDetail);
      status.setAccount(this);
      status.setHistorical(Boolean.FALSE);
      status.setStatusDate(statusDate);
      status.setStatusSource(statusSource);

      return addAccountStatus(status);
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add account status based on a statusCode enum, a statusDate and a statusSource.
   *
   * @param   statusCode    DOCUMENT ME!
   * @param   statusDate    DOCUMENT ME!
   * @param   statusSource  DOCUMENT ME!
   *
   * @return  add account status based on a statusCode enum, a statusDate and a statusSource.
   */
  public boolean addAccountStatus(AccountStatusCode statusCode, Date statusDate, StatusSource statusSource) {
    if (statusCode != null) {
      Long statusId = statusCode.getStatusId();

      if (statusId != null) {
        AccountStatusDetail accountStatusDetail = new AccountStatusDetail();
        accountStatusDetail.setStatusId(statusId);
        accountStatusDetail.setStatusCode(statusCode.toString());

        AccountStatus status = new AccountStatus();
        status.setAccountStatusDetail(accountStatusDetail);
        status.setStatusDate(statusDate); // no status date, use

        // batchDate
        status.setStatusSource(statusSource);

        return addAccountStatus(status);
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   threeLetterCode  DOCUMENT ME!
   * @param   statusDate       DOCUMENT ME!
   * @param   statusSource     DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addAccountStatus(String threeLetterCode, Date statusDate, StatusSource statusSource) {
    return addAccountStatus(AccountStatusCode.toAccountStatusCode(
          threeLetterCode), statusDate, statusSource);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   statusDetailId  DOCUMENT ME!
   * @param   statusDate      DOCUMENT ME!
   * @param   statusSource    DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addAccountStatus(Long statusDetailId, Date statusDate, StatusSource statusSource) {
    return addAccountStatus(AccountStatusCode.toAccountStatusCode(
          statusDetailId), statusDate, statusSource);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a agent call activity for the account.
   *
   * @param   activity  DOCUMENT ME!
   *
   * @return  adds a agent call activity for the account
   */
  public boolean addAgentCallActivity(AgentCallActivity activity) {
    activity.setAccount(this);

    return getAgentCallActivities().add(activity);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  barclayAccount  DOCUMENT ME!
   */
  public void addBarclayAccount(BarclayAccount barclayAccount) {
    barclayAccount.setAccount(this);
    setBarclayAccount(barclayAccount);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a citiaccount for the account.
   *
   * @param  citiAccount  DOCUMENT ME!
   */
  public void addCitiAccount(CitiAccount citiAccount) {
    citiAccount.setAccount(this);
    setCitiAccount(citiAccount);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a comment activity for the account.
   *
   * @param   activity  DOCUMENT ME!
   *
   * @return  adds a comment activity for the account
   */
  public boolean addCommentActivity(CommentActivity activity) {
    activity.setAccount(this);

    return getCommentActivities().add(activity);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add Document.
   *
   * @param  agent     DOCUMENT ME!
   * @param  document  DOCUMENT ME!
   */
  public void addDocument(User agent, Document document) {
    document.setAccount(this);

    boolean addNew = true;

    for (Document myDocument : documents) {
      if (myDocument.getDocumentType().getId().equals(
              document.getDocumentType().getId())) {
        // found same document type, do an update
        // update existing record, add to historical also
        DocumentHistory documentHistory = new DocumentHistory(
            myDocument);
        documentHistories.add(documentHistory);

        // update document
        myDocument.copy(document);
        myDocument.setLastUpdateAgent(agent);
        myDocument.setLastUpdateDate(new Date());
        addNew = false;

        break;
      }
    }

    if (addNew) {
      document.setCreateAgent(agent);
      document.setLastUpdateDate(null);
      documents.add(document);
    }
  } // end method addDocument

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add a financial adjustment.
   *
   * @param   fa  DOCUMENT ME!
   *
   * @return  add a financial adjustment.
   */
  public boolean addFinancialAdjustment(FinancialAdjustment fa) {
    fa.setAccount(this);

    return getFinancialAdjustments().add(fa);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addFlexPaymentProgram.
   *
   * @param   batchId             Long
   * @param   ruleId              Long
   * @param   programAction       ProgramAction
   * @param   paymentProgramType  PaymentProgramType
   * @param   programValidDays    Integer
   * @param   totalAmount         BigDecimal
   * @param   fixedFee            BigDecimal
   * @param   order               Integer
   * @param   frequency           Integer
   * @param   source              String
   *
   * @return  PaymentProgram
   */
  public PaymentProgram addFlexPaymentProgram(Long batchId, Long ruleId, ProgramAction programAction,
    PaymentProgramType paymentProgramType, Integer programValidDays, BigDecimal totalAmount, BigDecimal fixedFee,
    Integer order, Integer frequency,
    String source) {
    PaymentProgram paymentProgram = createFlexPaymentProgram(paymentProgramType, programValidDays, totalAmount,
        fixedFee, order,
        frequency);

    // If payment program can not be created, return
    if (paymentProgram == null) {
      log.info("Account " + getAccountNum()
        + ": no new Payment program created.");

      return null;
    }

    paymentProgram.setRuleBatchId(batchId);
    paymentProgram.setRuleId(ruleId);
    paymentProgram.setProgramAction(programAction);
    paymentProgram.setMonitoringType(programAction.getMonitoringType());
    paymentProgram.setStatusChangeDate(new Date());
    paymentProgram.setSource(ProgramSource.toProgramSource(source));
    paymentProgram.setAccount(this);

    if (paymentProgram != null) {
      int programHashCode    = paymentProgram.flexBusinessHashCode();
      int installmentHasCode = 0;

      paymentProgram.setProgramHashCode(programHashCode);
      log.info("programHashCode=" + programHashCode);
    }
    // ----------------end fixed PROD-2374-----------------------------------------------------------------------------

    log.info("Account " + getAccountNum() + ": add Payment program - " + paymentProgram);


    boolean createNew = true;
    boolean hasCreate = false;

    for (PaymentProgram curPaymentProgram : paymentPrograms) {
      if ((curPaymentProgram.getProgramHashCode() != null)
            && curPaymentProgram.getProgramHashCode().equals(paymentProgram.getProgramHashCode())) {
        log.info("Account " + getAccountNum() + ": Found identical program...");

        ProgramStatus curPaymentProgramStatus = curPaymentProgram.getProgramStatus();
        Date          now                     = new Date();

        if (ProgramStatus.INIT.equals(curPaymentProgramStatus)) {
          log.info("Update current PaymentProgram: " + curPaymentProgram.getProgramId() + " for Account: "
            + getAccountNum());
          curPaymentProgram.updateFlexPaymentProgram(paymentProgram, programAction);
          createNew = false;
          hasCreate = true; // Already contain the same init paymentProgram, do not repeat create new one.

          log.info("PaymentProgram: " + curPaymentProgram.getProgramId() + " Account: " + getAccountNum()
            + "ProgramStatus: INIT => Do not create a new PaymentProgram");

        } else if (ProgramStatus.ACCEPTED.equals(curPaymentProgramStatus)) {
          createNew = false;
          hasCreate = true; // Already contain the same ACCEPTED paymentProgram, do not repeat create new one.

          log.info("PaymentProgram: " + curPaymentProgram.getProgramId() + " Account: " + getAccountNum()
            + "ProgramStatus: ACCEPTED => Do not create a new PaymentProgram");

        } else if (ProgramStatus.CANCELLEDBYCLIENT.equals(curPaymentProgramStatus)
              || ProgramStatus.CANCELLEDBYDEBTOR.equals(curPaymentProgramStatus)
              || ProgramStatus.CANCELLEDBYCUSTOMER.equals(curPaymentProgramStatus)
              || ProgramStatus.CANCELLEDBYAGENT.equals(curPaymentProgramStatus)
              || ProgramStatus.CANCELLEDBYBROKENPROMISE.equals(curPaymentProgramStatus)
              || ProgramStatus.ENDED.equals(curPaymentProgramStatus)) {
          createNew = true;

          log.info("PaymentProgram: " + curPaymentProgram.getProgramId() + " Account: " + getAccountNum()
            + "ProgramStatus: " + curPaymentProgramStatus + " => Create a new PaymentProgram");

        } else {
          log.info("Deactivate current PaymentProgram: " + curPaymentProgram.getProgramId()
            + ". will insert a new PaymentProgram for Account: " + getAccountNum());
          curPaymentProgram.setActive(Boolean.FALSE);
          curPaymentProgram.setLastUpdateDate(now);
          createNew = true;

          log.info("PaymentProgram: " + curPaymentProgram.getProgramId() + " Account: " + getAccountNum()
            + "ProgramStatus: " + curPaymentProgramStatus + " => Create a new PaymentProgram");

        } // end if-else

        // break;
      } // end if
      else {
        log.info("curPaymentProgram not equals new paymentProgram.");
        log.info("curPaymentProgram : " + curPaymentProgram);
        log.info("new paymentProgram : " + paymentProgram);
      } // end if-else
    }   // end for

    boolean added = false;

    if (createNew && !hasCreate) {
      log.info("Account " + getAccountNum()
        + ": Need to create new program in DB. Add to programs set.");

      int num = 0;

      if (paymentPrograms != null) {
        num = paymentPrograms.size();
      }

      log.info("Account " + getAccountNum() + ": before program count: "
        + num);

      added = paymentPrograms.add(paymentProgram);

      if (paymentPrograms != null) {
        num = paymentPrograms.size();
      }

      log.info("Account " + getAccountNum() + ": after program count: "
        + num);

    } else {
      log.info("Account " + getAccountNum()
        + ": No need to create new program in DB. Only update one of the existing programs.");
    } // end if-else

    return added ? paymentProgram : null;

  } // end method addFlexPaymentProgram

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a invoice for the account.
   *
   * @param   invoice  DOCUMENT ME!
   *
   * @return  adds a invoice for the account
   */
  public boolean addInvoice(Invoice invoice) {
    invoice.setAccount(this);

    return getInvoices().add(invoice);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a agent call activity for the account.
   *
   * @param   memo  memoryMessage activity DOCUMENT ME!
   *
   * @return  adds a memory message for the account
   */
  public boolean addMemo(Memo memo) {
    memo.setAccount(this);

    return getMemos().add(memo);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a agent call activity for the account.
   *
   * @param   memoryMessage  activity DOCUMENT ME!
   *
   * @return  adds a memory message for the account
   */
  public boolean addMemoryMessage(MemoryMessage memoryMessage) {
    memoryMessage.setAccount(this);

    return getMemoryMessages().add(memoryMessage);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  mortgage  DOCUMENT ME!
   */
  public void addMortgage(AccountMortgage mortgage) {
    mortgage.setAccount(this);
    setMortgage(mortgage);
  }
  // /**
  // * Adds a letter activity for the account
  // *
  // * @param invoice
  // */
  // public boolean addLetterActivity(LetterActivity activity) {
  // activity.setAccount(this);
  // return getLetterActivities().add(activity);
  // }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   negotiateExceptionResult  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addNegotiateExceptionResult(NegotiateExceptionResult negotiateExceptionResult) {
    negotiateExceptionResult.setAccount(this);

    return negotiateExceptionResults.add(negotiateExceptionResult);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add a new negotiation program type.
   *
   * @param  batchId             DOCUMENT ME!
   * @param  ruleId              DOCUMENT ME!
   * @param  paymentProgramType  DOCUMENT ME!
   * @param  principalType       DOCUMENT ME!
   * @param  programValidDays    DOCUMENT ME!
   * @param  floorPercentage     DOCUMENT ME!
   * @param  longestDuration     DOCUMENT ME!
   * @param  mixFixedFee         DOCUMENT ME!
   */
  public void addNegotiateProgramType(Long batchId, Long ruleId, PaymentProgramType paymentProgramType,
    String principalType, Integer programValidDays, BigDecimal floorPercentage, Integer longestDuration,
    BigDecimal mixFixedFee) {
    NegotiateProgramType negotiateProgramType = new NegotiateProgramType();
    negotiateProgramType.setRuleBatchId(batchId);
    negotiateProgramType.setRuleId(ruleId);
    negotiateProgramType.setFloorPercentage(floorPercentage);
    negotiateProgramType.setPrincipalType(principalType);
    negotiateProgramType.setProgramValidDays(programValidDays.intValue());
    negotiateProgramType.setLongestDuration(longestDuration.intValue());
    negotiateProgramType.setMinFixedFee(mixFixedFee);
    negotiateProgramType.setPaymentProgramType(paymentProgramType);
    negotiateProgramType.setAccount(this);

    boolean                           createNew = true;
    Map<String, NegotiateProgramType> allTypes  = new LinkedHashMap<String, NegotiateProgramType>();

    for (NegotiateProgramType curNegotiateProgramType : negotiateProgramTypes) {
      // only allow one negotiate program type for each program type
      PaymentProgramType programType = curNegotiateProgramType.getPaymentProgramType();
      String             typeName    = programType.getName();

      if (!allTypes.containsKey(typeName)) {
        allTypes.put(typeName, curNegotiateProgramType);
      }

      if (curNegotiateProgramType.businessEquals(negotiateProgramType)) {
        // the channel result is existed, update the time stamp
        curNegotiateProgramType.setRuleId(ruleId);
        curNegotiateProgramType.setRuleBatchId(batchId);
        curNegotiateProgramType.setLastUpdateDate(new Date());
        createNew = false;

        break;
      } else if (programType.equals(negotiateProgramType)) {
        // update negotiate program type for the same type
        curNegotiateProgramType.update(negotiateProgramType);
        createNew = false;

        break;
      }
    } // end for

    if (createNew) {
      // create a new type if there is no such type program
      allTypes.put(negotiateProgramType.getPaymentProgramType().getName(),
        negotiateProgramType);
    }

    // add all program type
    negotiateProgramTypes.clear();
    negotiateProgramTypes.addAll(allTypes.values());
  } // end method addNegotiateProgramType

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   field          DOCUMENT ME!
   * @param   metaDataValue  DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   */
  public Object addOrUpdateAccountMetaData(AccountMetaDataField field, Object metaDataValue) {
    Object targetValue = null;

    if (metaDataValue == null) {
      log.info("Meta data value is null.");
    } else {
      targetValue = MetaDataValueType.convertToMetaType(field.getType(), metaDataValue);

      if (targetValue == null) {
        log.error("Meta data value type is not correct type.");
      }
    }

    AccountMetaData curMetaData = null;
    Date            now         = new Date();

    for (AccountMetaData metaData : getAccountMetaData()) {
      AccountMetaDataField curField = metaData.getAccountMetaDataField();

      if ((curField == field) || (curField.getAccountMetaDataFieldId().equals(field.getAccountMetaDataFieldId()))
            || (curField.equals(field))) {
        curMetaData = metaData;

        break;
      }
    }

    if (curMetaData == null) {
      curMetaData = new AccountMetaData();
      curMetaData.setAccount(this);
      curMetaData.setAccountMetaDataField(field);
      accountMetaData.add(curMetaData);
    }

    curMetaData.setValue(null);
    curMetaData.setMetaDataDecimalValue(null);
    curMetaData.setMetaDataIntegerValue(null);
    curMetaData.setMetaDataBooleanValue(null);
    curMetaData.setMetaDataDateValue(null);
    curMetaData.setMetaDataLongValue(null);
    curMetaData.setMetaDataStringValue(null);

    switch (field.getType()) {
      case INTEGER: {
        if (targetValue != null) {
          Integer intVal = (Integer) targetValue;
          curMetaData.setMetaDataIntegerValue(intVal);
          curMetaData.setValue(intVal.toString());
        }

        curMetaData.setLastUpdateDate(now);

        break;
      }

      case LONG: {
        if (targetValue != null) {
          Long longVal = (Long) targetValue;
          curMetaData.setMetaDataLongValue(longVal);
          curMetaData.setValue(longVal.toString());
        }

        curMetaData.setLastUpdateDate(now);

        break;
      }

      case BIGDECIMAL: {
        if (targetValue != null) {
          BigDecimal decimalVal = (BigDecimal) targetValue;
          curMetaData.setMetaDataDecimalValue(decimalVal);
          curMetaData.setValue(decimalVal.toString());
        }

        curMetaData.setLastUpdateDate(now);

        break;
      }

      case DATE: {
        if (targetValue != null) {
          Date dateVal = (Date) targetValue;
          curMetaData.setMetaDataDateValue(dateVal);

          SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
          curMetaData.setValue(sdf.format(dateVal));
        }

        curMetaData.setLastUpdateDate(now);

        break;
      }

      case STRING: {
        if (targetValue != null) {
          curMetaData.setMetaDataStringValue(targetValue.toString());
          curMetaData.setValue(targetValue.toString());
        }

        curMetaData.setLastUpdateDate(now);

        break;
      }

      case BOOLEAN: {
        if (targetValue != null) {
          Boolean booleanVal = (Boolean) targetValue;
          curMetaData.setMetaDataBooleanValue(booleanVal);
          curMetaData.setValue(booleanVal.toString());
        }

        curMetaData.setLastUpdateDate(now);

        break;
      }

      case TEXT: {
        break;
      }
    } // end switch

    return curMetaData;
  } // end method addOrUpdateAccountMetaData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  metaDataName   DOCUMENT ME!
   * @param  type           DOCUMENT ME!
   * @param  metaDataValue  DOCUMENT ME!
   */
  public void addOrUpdateAccountMetaData(String metaDataName, MetaDataValueType type, Object metaDataValue) {
    addOrUpdateAccountMetaData(metaDataName, type, metaDataValue, null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  metaDataName        DOCUMENT ME!
   * @param  type                DOCUMENT ME!
   * @param  metaDataExpression  DOCUMENT ME!
   */
  public void addOrUpdateAccountMetaData(String metaDataName, MetaDataValueType type, String metaDataExpression) {
    addOrUpdateAccountMetaData(metaDataName, type, null,
      metaDataExpression);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  metaDataName        DOCUMENT ME!
   * @param  type                DOCUMENT ME!
   * @param  metaDataValue       DOCUMENT ME!
   * @param  metaDataExpression  DOCUMENT ME!
   */
  public void addOrUpdateAccountMetaData(String metaDataName, MetaDataValueType type, Object metaDataValue,
    String metaDataExpression) {
    if ((metaDataValue == null)
          && ((metaDataExpression == null)
            || (metaDataExpression.length() == 0))) {
      log.info("can not update meta data name or type");

      return;
    }

    Date now = new Date();

    if ((getAccountMetaData() != null)
          && (getAccountMetaData().size() > 0)) {
      for (AccountMetaData metaData : getAccountMetaData()) {
        AccountMetaDataField field = metaData.getAccountMetaDataField();

        if (metaDataName.equalsIgnoreCase(field.getName())) {
          if (metaDataValue == null) {
            field.setExpression(metaDataExpression);
            field.setLastUpdateDate(now);
          } else {
            switch (type) {
              case INTEGER: {
                if (metaDataValue instanceof Integer) {
                  if ((metaDataExpression != null)
                        && (metaDataExpression.length() > 0)) {
                    field.setExpression(metaDataExpression);
                    field.setLastUpdateDate(now);
                  }

                  Integer intVal = (Integer) metaDataValue;
                  metaData.setValue(intVal.toString());
                  metaData.setMetaDataIntegerValue(intVal);

                  return;
                }

                log.info("meta data value type is not Integer.");

                return;
              }

              case BIGDECIMAL: {
                if (metaDataValue instanceof BigDecimal) {
                  if ((metaDataExpression != null)
                        && (metaDataExpression.length() > 0)) {
                    field.setExpression(metaDataExpression);
                    field.setLastUpdateDate(now);
                  }

                  BigDecimal decimalVal = (BigDecimal) metaDataValue;
                  metaData.setMetaDataDecimalValue(decimalVal);
                  metaData.setValue(decimalVal.toString());

                  return;
                }

                log.info("meta data value type is not BigDecimal.");

                return;
              }

              case LONG: {
                if (metaDataValue instanceof Long) {
                  if ((metaDataExpression != null)
                        && (metaDataExpression.length() > 0)) {
                    field.setExpression(metaDataExpression);
                    field.setLastUpdateDate(now);
                  }

                  Long longVal = (Long) metaDataValue;
                  metaData.setMetaDataLongValue(longVal);
                  metaData.setValue(longVal.toString());

                  return;
                }

                log.info("meta data value type is not Long.");

                return;
              }

              case DATE: {
                if (metaDataValue instanceof Date) {
                  if ((metaDataExpression != null)
                        && (metaDataExpression.length() > 0)) {
                    field.setExpression(metaDataExpression);
                    field.setLastUpdateDate(now);
                  }

                  Date dateVal = (Date) metaDataValue;
                  metaData.setMetaDataDateValue(dateVal);
                  metaData.setValue(dateVal.toString());

                  return;
                }

                log.info("meta data value type is not Date.");

                return;
              }

              case STRING: {
                if (metaDataValue instanceof String) {
                  if ((metaDataExpression != null)
                        && (metaDataExpression.length() > 0)) {
                    field.setExpression(metaDataExpression);
                    field.setLastUpdateDate(now);
                  }

                  metaData.setMetaDataStringValue(metaDataValue.toString());
                  metaData.setValue(metaDataValue.toString());

                  return;
                }

                log.info("meta data value type is not String.");

                return;
              }

              case BOOLEAN: {
                if (metaDataValue instanceof Boolean) {
                  if ((metaDataExpression != null)
                        && (metaDataExpression.length() > 0)) {
                    field.setExpression(metaDataExpression);
                    field.setLastUpdateDate(now);
                  }

                  Boolean boolVal = (Boolean) metaDataValue;
                  metaData.setValue(boolVal.toString());
                  metaData.setMetaDataBooleanValue(boolVal);

                  return;
                }

                log.info("meta data value type is not String.");

                return;
              }

            } // end switch
          }   // end if-else

          log.info("account " + accountNum + " meta data type "
            + type + " not found!");

          return;
        } // end if
      }   // end for
    }     // end if

    AccountMetaData metaData = createAccountMetaData(metaDataName, type,
        metaDataValue, metaDataExpression);

    if (metaData == null) {
      return;
    }

    accountMetaData.add(metaData);
  } // end method addOrUpdateAccountMetaData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a payment program for the account.
   *
   * @param   paymentProgram  DOCUMENT ME!
   *
   * @return  adds a payment program for the account
   */
  public boolean addPaymentProgram(PaymentProgram paymentProgram) {
    paymentProgram.setAccount(this);

    return getPaymentPrograms().add(paymentProgram);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add a payment program.
   *
   * @param   batchId                     DOCUMENT ME!
   * @param   ruleId                      DOCUMENT ME!
   * @param   programAction               actionId DOCUMENT ME!
   * @param   paymentProgramType          DOCUMENT ME!
   * @param   principalType               DOCUMENT ME!
   * @param   amountType                  DOCUMENT ME!
   * @param   roundType                   DOCUMENT ME!
   * @param   programValidDays            DOCUMENT ME!
   * @param   allowedPaymentDateRange     DOCUMENT ME!
   * @param   installmentDateTolerence    DOCUMENT ME!
   * @param   installmentDollarTolerence  DOCUMENT ME!
   * @param   percentage                  DOCUMENT ME!
   * @param   duration                    DOCUMENT ME!
   * @param   fixedFee                    DOCUMENT ME!
   * @param   order                       DOCUMENT ME!
   * @param   amounts                     DOCUMENT ME!
   * @param   requiredPayments            DOCUMENT ME!
   * @param   frequency                   DOCUMENT ME!
   * @param   source                      DOCUMENT ME!
   * @param   requiredPTPs                DOCUMENT ME!
   * @param   allowEagerPayment           DOCUMENT ME!
   *
   * @return  add a payment program.
   */
  public PaymentProgram addPaymentProgram(Long batchId, Long ruleId, ProgramAction programAction,
    PaymentProgramType paymentProgramType, String principalType, AmountType amountType, RoundType roundType,
    Integer programValidDays, Integer allowedPaymentDateRange, Integer installmentDateTolerence,
    BigDecimal installmentDollarTolerence, BigDecimal percentage, Integer duration, BigDecimal fixedFee, Integer order,
    BigDecimal[] amounts, Integer requiredPayments, Integer frequency, String source, Integer requiredPTPs,
    Boolean allowEagerPayment) {
    // if (this.getAcceptedProgram() != null) {
    // // if this account has accepted any offer before, skip generate new
    // // program
    // return;
    // }

    PaymentProgram paymentProgram = createPaymentProgram(paymentProgramType,
        principalType, amountType, roundType, programValidDays,
        allowedPaymentDateRange, installmentDateTolerence,
        installmentDollarTolerence, percentage, duration, fixedFee,
        order, amounts, requiredPayments, frequency, requiredPTPs, allowEagerPayment);

    paymentProgram.setRuleBatchId(batchId);
    paymentProgram.setRuleId(ruleId);
    paymentProgram.setProgramAction(programAction);
    paymentProgram.setMonitoringType(programAction.getMonitoringType());
    paymentProgram.setStatusChangeDate(new Date());
    paymentProgram.setSource(ProgramSource.toProgramSource(source));
    paymentProgram.setAccount(this);

    // ----------------for fixed PROD-2374-----------------------------------------------------------------------------
    if (paymentProgram != null) {
      int programHashCode    = paymentProgram.businessHashCode();
      int installmentHasCode = 0;

      for (PaymentProgramInstallment installment : paymentProgram.getInstallments()) {
        installmentHasCode += installment.businessHashCode();
      }

      paymentProgram.setProgramHashCode(programHashCode + installmentHasCode);
      log.info("programHashCode=" + programHashCode + "installmentHasCode:" + installmentHasCode);
    }

    // ----------------end fixed PROD-2374-----------------------------------------------------------------------------
    // If payment program can not be created, return
    if (paymentProgram == null) {
      log.info("Account " + getAccountNum()
        + ": no new Payment program created.");

      return null;
    }

    log.info("Account " + getAccountNum() + ": add Payment program - " + paymentProgram);

    boolean createNew = true;
    boolean hasCreate = false;

    Set<PaymentProgram> syncPaymentPrograms = Collections.synchronizedSet(paymentPrograms);

    synchronized (syncPaymentPrograms) {
      for (PaymentProgram curPaymentProgram : paymentPrograms) {
        if ((curPaymentProgram.getProgramHashCode() != null)
              && curPaymentProgram.getProgramHashCode().equals(paymentProgram.getProgramHashCode())) {
// if (curPaymentProgram.businessEquals(paymentProgram)) {
          log.info("Account " + getAccountNum()
            + ": Found identical program...");

          ProgramStatus curPaymentProgramStatus = curPaymentProgram.getProgramStatus();
          Date          now                     = new Date();

          if (ProgramStatus.INIT.equals(curPaymentProgramStatus)) {
            log.info("Update current PaymentProgram: " + curPaymentProgram.getProgramId() + " for Account: "
              + getAccountNum());
            curPaymentProgram.updatePaymentProgram(paymentProgram, programAction);
            createNew = false;
            hasCreate = true; // Already contain the same init paymentProgram, do not repeat create new one.

            if (log.isDebugEnabled()) {
              log.debug("PaymentProgram: " + curPaymentProgram.getProgramId() + " Account: " + getAccountNum()
                + "ProgramStatus: INIT => Do not create a new PaymentProgram");
            }
          } else if (ProgramStatus.ACCEPTED.equals(curPaymentProgramStatus)) {
            createNew = false;
            hasCreate = true; // Already contain the same ACCEPTED paymentProgram, do not repeat create new one.

            if (log.isDebugEnabled()) {
              log.debug("PaymentProgram: " + curPaymentProgram.getProgramId() + " Account: " + getAccountNum()
                + "ProgramStatus: ACCEPTED => Do not create a new PaymentProgram");
            }
          } else if (ProgramStatus.CANCELLEDBYCLIENT.equals(curPaymentProgramStatus)
                || ProgramStatus.CANCELLEDBYDEBTOR.equals(curPaymentProgramStatus)
                || ProgramStatus.CANCELLEDBYCUSTOMER.equals(curPaymentProgramStatus)
                || ProgramStatus.CANCELLEDBYAGENT.equals(curPaymentProgramStatus)
                || ProgramStatus.CANCELLEDBYBROKENPROMISE.equals(curPaymentProgramStatus)
                || ProgramStatus.ENDED.equals(curPaymentProgramStatus)) {
            createNew = true;

            if (log.isDebugEnabled()) {
              log.debug("PaymentProgram: " + curPaymentProgram.getProgramId() + " Account: " + getAccountNum()
                + "ProgramStatus: " + curPaymentProgramStatus + " => Create a new PaymentProgram");
            }
          } else {
            log.info("Deactivate current PaymentProgram: " + curPaymentProgram.getProgramId()
              + ". will insert a new PaymentProgram for Account: " + getAccountNum());
            curPaymentProgram.setActive(Boolean.FALSE);
            curPaymentProgram.setLastUpdateDate(now);
            createNew = true;

            if (log.isDebugEnabled()) {
              log.debug("PaymentProgram: " + curPaymentProgram.getProgramId() + " Account: " + getAccountNum()
                + "ProgramStatus: " + curPaymentProgramStatus + " => Create a new PaymentProgram");
            }
          } // end if-else
          // break;
        }   // end if
        else {
          if (log.isDebugEnabled()) {
            log.debug("curPaymentProgram not equals new paymentProgram.");
            log.debug("curPaymentProgram : " + curPaymentProgram);
            log.debug("new paymentProgram : " + paymentProgram);
          }
        }   // end if-else
      }     // end for
    }       // end synchronized

    boolean added = false;

    if (createNew && !hasCreate) {
      log.info("Account " + getAccountNum()
        + ": Need to create new program in DB. Add to programs set.");

      int num = 0;

      if (paymentPrograms != null) {
        num = paymentPrograms.size();
      }

      log.info("Account " + getAccountNum() + ": before program count: "
        + num);

      synchronized (syncPaymentPrograms) {
        added = paymentPrograms.add(paymentProgram);
      }

      if (paymentPrograms != null) {
        num = paymentPrograms.size();
      }

      log.info("Account " + getAccountNum() + ": after program count: "
        + num);
    } else {
      log.info("Account " + getAccountNum()
        + ": No need to create new program in DB. Only update one of the existing programs.");
    } // end if-else

    return added ? paymentProgram : null;
  } // end method addPaymentProgram

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNum    DOCUMENT ME!
   * @param  dependency  DOCUMENT ME!
   */
  public void addPhoneTypeDependencyStatusByPhoneNumber(String phoneNum, PortfolioPhoneTypeDependency dependency) {
    for (Responsible responsible : responsibles) {
      addPhoneTypeDependencyStatusByPhoneNum(responsible.getPhones(), phoneNum, dependency);
      addPhoneTypeDependencyStatusByPhoneNum(responsible.getTemporaryPhones(), phoneNum, dependency);
      addPhoneTypeDependencyStatusByPhoneNum(responsible.getFuturePermanentPhones(), phoneNum, dependency);
    } // end for

    for (AccountAuthorizedUser authorizedUser : this.getAccountAuthorizedUsers()) {
      addPhoneTypeDependencyStatusByPhoneNum(authorizedUser.getPhones(), phoneNum, dependency);
      addPhoneTypeDependencyStatusByPhoneNum(authorizedUser.getTemporaryPhones(), phoneNum, dependency);
      addPhoneTypeDependencyStatusByPhoneNum(authorizedUser.getFuturePermanentPhones(), phoneNum, dependency);
    } // end for

    for (AccountAuthorizedContact authorizedContact : this.getAccountAuthorizedContacts()) {
      addPhoneTypeDependencyStatusByPhoneNum(authorizedContact.getPhones(), phoneNum, dependency);
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   promise  DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   */
  public boolean addPromise(PromiseToPay promise) {
    promise.setAccount(this);

    if (promise.getResponsible() == null) {
      if (getPrimaryResponsible() != null) {
        promise.setResponsible(getPrimaryResponsible());
      } else if ((getResponsibles() != null)
            && (getResponsibles().size() > 0)) {
        Responsible[] resp = (getResponsibles().toArray(
              new Responsible[] {}));
        promise.setResponsible(resp[0]);
      }
    }

    return getPromises().add(promise);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a responsible for the account.
   *
   * @param   responsible  DOCUMENT ME!
   *
   * @return  adds a responsible for the account
   */
  public boolean addResponsible(Responsible responsible) {
    responsible.setAccount(this);

    return getResponsibles().add(responsible);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a Active History for the account.
   *
   * @param   spReportHistory  DOCUMENT ME!
   *
   * @return  adds a spReportHistory for the account
   */
  public boolean addSPReportHistory(SPReportHistory spReportHistory) {
    spReportHistory.setAccount(this);

    return getSPReportHistory().add(spReportHistory);
  }
  // Added by Etisbew on 11/09/2009 for Account Active History-End

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  treatment  DOCUMENT ME!
   */
  public void addTreatment(TreatmentCandidate treatment) {
    treatment.setAccount(this);
    this.treatments.add(treatment);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  usbAccount  DOCUMENT ME!
   */
  public void addUSBAccount(USBAccount usbAccount) {
    usbAccount.setAccount(this);
    setUsbAccount(usbAccount);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * blockFinancialTransactions.
   *
   * @return  Boolean
   */
  public Boolean blockFinancialTransactions() {
    Optional<AccountOverallStatus> blockFinancialOverallStatuOptional = this.accountOverallStatusSet.stream().filter(
        accountOverallStatus ->
          (!accountOverallStatus.getHistorical()) && (accountOverallStatus.getAccountOverallStatusDetail() != null)
          && accountOverallStatus.getAccountOverallStatusDetail().getBlockFinancialTransactions()).findFirst();

    return blockFinancialOverallStatuOptional.isPresent();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean canAddPTP() {
    if ((promises == null) || (promises.size() < 1) || (getPortfolio().getPortfolioId() == 220001L)) {
      return true;
    }

    for (PromiseToPay promise : promises) {
      if (PromiseToPayStatus.FUTURE.equals(promise.getPtpStatus())
            || PromiseToPayStatus.OUTSTANDING.equals(
              promise.getPtpStatus())
            || PromiseToPayStatus.INIT.equals(promise.getPtpStatus())) {
        return false;
      }
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   agent  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean checkUserTransactionLoad(User agent) {
    // check the user have access right to load the account
    // check from FlexSelectConfig table.
    AccountIndex accountIndex = getAccountIndex();

    if ((accountIndex != null) && (accountIndex.getFlexSelectConfig() != null)) {
      FlexSelectConfig config = accountIndex.getFlexSelectConfig();
      log.info("Only check have flexSelect config account.");
      log.info("Flex Select config Id is: " + config.getId() + " config name : " + config.getName());

      // we need check it, if flexSelectConfigId not null.
      log.info("Check user: " + agent.getUsername() + " have access right to load the account?");

      if (config.getAllRoles()) {
        log.info("FlexStation Transaction Enabled All Roles.");

        return Boolean.TRUE;
      } else {
        if ((config.getEnabledRoles() == null) || (config.getEnabledRoles().size() == 0)) {
          log.info("No transactional role selected. So the account will be load as readyOnly mode by all user.");

          return Boolean.FALSE;
        } else {
          Set<Role> transactionRoles = config.getEnabledRoles();

          for (Role transactionRole : transactionRoles) {
            if (agent.getRoles().contains(transactionRole)) {
              log.info("The user contain transaction role : " + transactionRole.getId() + ", break check now.");

              return Boolean.TRUE;
            }
          }

          log.info("The user not contain any transaction role, load the account as read Only mode.");

          return Boolean.FALSE;
        } // end if-else
      }   // end if-else
    }     // end if

    return Boolean.TRUE;
  } // end method checkUserTransactionLoad

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Claim account for the agent.
   *
   * @param   agent  DOCUMENT ME!
   *
   * @return  claim account for the agent
   */
  public boolean claim(User agent) {
    if (this.claimAgent == null) {
      if (!isActiveLocked() || isLockedBy(agent)) {
        Date now = new Date();
        this.claimAgent     = agent;
        this.claimTime      = now;
        this.lastUpdateDate = now;

        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void clearRoundCounter() {
    roundCounter = null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void clearViewedCounter() {
    agentViewedCounter = 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void clearWorkCounter() {
    agentWorkedCounter = 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   type   DOCUMENT ME!
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Object convertToMetaType(MetaDataValueType type, Object value) { // todo removable

    if (value == null) {
      return null;
    }

    switch (type) {
      case INTEGER: {
        if (value instanceof Integer) {
          return (Integer) value;
        }

        log.error("meta data value type is not Integer: " + value);

        break;
      }

      case LONG: {
        if (value instanceof Integer) {
          return new Long((Integer) value);
        } else if (value instanceof Long) {
          return (Long) value;
        }

        log.error("meta data value type is not Long: " + value);

        break;
      }

      case BIGDECIMAL: {
        if (value instanceof Integer) {
          return new BigDecimal((Integer) value);
        } else if (value instanceof Long) {
          return new BigDecimal((Long) value);
        } else if (value instanceof BigDecimal) {
          return (BigDecimal) value;
        }

        log.error("meta data value type is not BigDecimal: " + value);

        break;
      }

      case DATE: {
        if (value instanceof Date) {
          return (Date) value;
        }

        log.error("meta data value type is not Date: " + value);

        break;
      }

      case STRING: {
        if (value instanceof String) {
          return (String) value;
        }

        log.error("meta data value type is not String: " + value);

        break;
      }

      case BOOLEAN: {
        if (value instanceof Boolean) {
          return (Boolean) value;
        }

        log.error("meta data value type is not Boolean: " + value);

        break;
      }
    } // end switch

    return null;
  } // end method convertToMetaType

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   field          DOCUMENT ME!
   * @param   metaDataValue  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountMetaData createAccountMetaData(AccountMetaDataField field, Object metaDataValue) {
    Object targetValue = null;

    if (metaDataValue == null) {
      log.info("Meta data value is null.");
    } else {
      targetValue = MetaDataValueType.convertToMetaType(field.getType(), metaDataValue);

      if (targetValue == null) {
        log.error("Meta data value type is not correct type.");
      }
    }

    Date            now         = new Date();
    AccountMetaData curMetaData = new AccountMetaData();
    curMetaData.setAccount(this);
    curMetaData.setAccountMetaDataField(field);
    curMetaData.setCreateDate(now);
    curMetaData.setLastUpdateDate(now);

    switch (field.getType()) {
      case INTEGER: {
        if (targetValue != null) {
          Integer intVal = (Integer) targetValue;
          curMetaData.setMetaDataIntegerValue(intVal);
          curMetaData.setValue(intVal.toString());
        }

        break;
      }

      case LONG: {
        if (targetValue != null) {
          Long longVal = (Long) targetValue;
          curMetaData.setMetaDataLongValue(longVal);
          curMetaData.setValue(longVal.toString());
        }

        break;
      }

      case BIGDECIMAL: {
        if (targetValue != null) {
          BigDecimal decimalVal = (BigDecimal) targetValue;
          curMetaData.setMetaDataDecimalValue(decimalVal);
          curMetaData.setValue(decimalVal.toString());
        }

        curMetaData.setLastUpdateDate(now);

        break;
      }

      case DATE: {
        if (targetValue != null) {
          Date dateVal = (Date) targetValue;
          curMetaData.setMetaDataDateValue(dateVal);

          SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
          curMetaData.setValue(sdf.format(dateVal));
        }

        break;
      }

      case STRING: {
        if (targetValue != null) {
          curMetaData.setMetaDataStringValue(targetValue.toString());
          curMetaData.setValue(targetValue.toString());
        }

        break;
      }

      case BOOLEAN: {
        if (targetValue != null) {
          Boolean booleanVal = (Boolean) targetValue;
          curMetaData.setMetaDataBooleanValue(booleanVal);
          curMetaData.setValue(booleanVal.toString());
        }

        break;
      }
    } // end switch

    return curMetaData;
  } // end method createAccountMetaData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   metaDataName        DOCUMENT ME!
   * @param   type                DOCUMENT ME!
   * @param   metaDataValue       DOCUMENT ME!
   * @param   metaDataExpression  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountMetaData createAccountMetaData(String metaDataName, MetaDataValueType type, Object metaDataValue,
    String metaDataExpression) {
    AccountMetaData metaData = new AccountMetaData();
    metaData.setAccount(this);

    AccountMetaDataField accountMetaDataField = new AccountMetaDataField();
    accountMetaDataField.setType(type);
    accountMetaDataField.setName(metaDataName);
    accountMetaDataField.setExpression(metaDataExpression);
    metaData.setAccountMetaDataField(accountMetaDataField);

    if ((type.equals(MetaDataValueType.INTEGER))
          && (metaDataValue instanceof Integer)) {
      Integer intVal = (Integer) metaDataValue;
      metaData.setMetaDataIntegerValue(intVal);
      metaData.setValue(intVal.toString());

      return metaData;
    } else if ((type.equals(MetaDataValueType.BIGDECIMAL))
          && (metaDataValue instanceof BigDecimal)) {
      BigDecimal decimalVal = (BigDecimal) metaDataValue;
      metaData.setMetaDataDecimalValue(decimalVal);
      metaData.setValue(decimalVal.toString());

      return metaData;
    } else if ((type.equals(MetaDataValueType.LONG))
          && (metaDataValue instanceof Long)) {
      Long longVal = (Long) metaDataValue;
      metaData.setMetaDataLongValue(longVal);
      metaData.setValue(longVal.toString());

      return metaData;
    } else if ((type.equals(MetaDataValueType.DATE)
            && (metaDataValue instanceof Date))) {
      Date dateVal = (Date) metaDataValue;
      metaData.setMetaDataDateValue(dateVal);
      metaData.setValue(dateVal.toString());

      return metaData;
    } else if ((type.equals(MetaDataValueType.STRING)
            && (metaDataValue instanceof String))) {
      String stringVal = (String) metaDataValue;
      metaData.setMetaDataStringValue(stringVal);
      metaData.setValue(stringVal);

      return metaData;
    } else if ((type.equals(MetaDataValueType.BOOLEAN)
            && (metaDataValue instanceof Boolean))) {
      Boolean boolVal = (Boolean) metaDataValue;
      metaData.setMetaDataBooleanValue(boolVal);
      metaData.setValue(boolVal.toString());

      return metaData;
    } else {
      log.info("account " + accountNum + " meta data type " + type
        + " and meta data value " + metaDataValue + " not match!");

      return null;
    } // end if-else
  }   // end method createAccountMetaData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createFlexPaymentProgram.
   *
   * @param   paymentProgramType  PaymentProgramType
   * @param   programValidDays    Integer
   * @param   totalAmount         BigDecimal
   * @param   fixedFee            BigDecimal
   * @param   startOrder          Integer
   * @param   frequency           Integer
   *
   * @return  PaymentProgram
   */
  public PaymentProgram createFlexPaymentProgram(PaymentProgramType paymentProgramType, Integer programValidDays,
    BigDecimal totalAmount, BigDecimal fixedFee, Integer startOrder, Integer frequency) {
    PaymentProgram paymentProgram = new PaymentProgram();

    paymentProgram.setActive(true);
    paymentProgram.setProgramOrder(startOrder);
    paymentProgram.setType(paymentProgramType);
    paymentProgram.setPrincipalType(null);
    paymentProgram.setPercentage(new BigDecimal(0));
    paymentProgram.setDuration(0);
    paymentProgram.setFrequency(frequency);
    paymentProgram.setFixedFeeAmount(fixedFee);
    paymentProgram.setProgramStatus(ProgramStatus.INIT);

    paymentProgram.setAllowedInstallmentDateRange(0);

    paymentProgram.setInstallmentDateTolerence(0);
    paymentProgram.setInstallmentDollarTolerence(new BigDecimal(0));

    // calculate the expiration date
    GregorianCalendar calbase = new GregorianCalendar();
    GregorianCalendar cal     = new GregorianCalendar(calbase.get(
          Calendar.YEAR), calbase.get(Calendar.MONTH),
        calbase.get(Calendar.DAY_OF_MONTH));
    cal.add(Calendar.DAY_OF_YEAR, programValidDays);
    paymentProgram.setExpirationDate(cal.getTime());
    paymentProgram.setRequiredPayments(0);
    paymentProgram.setRequiredPTPs(0);
    paymentProgram.setAllowEagerPayment(Boolean.FALSE);

    paymentProgram.setProgramAmount(totalAmount);
    paymentProgram.setTotalAmount(totalAmount);

    return paymentProgram;
  } // end method createFlexPaymentProgram

  //~ ------------------------------------------------------------------------------------------------------------------

  /* Create a payment program for the account and return the created program. The Payment program is not add the account
   * payment program collection. Need to call addPaymentProgram in order to add to account program collection.
   *
   * @param   paymentProgramType  DOCUMENT ME!
   * @param   principalType       DOCUMENT ME!
   * @param   programValidDays    DOCUMENT ME!
   * @param   percentage          DOCUMENT ME!
   * @param   duration            DOCUMENT ME!
   * @param   fixedFee            DOCUMENT ME!
   *
   * @return  create a payment program for the account and return the created program.
   */
  // end method createAccountMetaData
  /**
   * DOCUMENT ME!
   *
   * @param   paymentProgramType  DOCUMENT ME!
   * @param   principalType       DOCUMENT ME!
   * @param   programValidDays    DOCUMENT ME!
   * @param   percentage          DOCUMENT ME!
   * @param   duration            DOCUMENT ME!
   * @param   fixedFee            DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentProgram createPaymentProgram(PaymentProgramType paymentProgramType, String principalType,
    Integer programValidDays, BigDecimal percentage, Integer duration, BigDecimal fixedFee) {
    if (duration == 0) {
      return null;
    }

    BigDecimal[] amounts   = new BigDecimal[duration];
    BigDecimal   principal = getPrincipalAmount(principalType);

    // Check principal value: not null and not 0.0
    if ((principal == null)
          || (principal.compareTo(BigDecimal.ZERO) <= 0)) {
      return null;
    }

    BigDecimal programAmount     = principal.multiply(percentage);
    BigDecimal installmentAmount = programAmount.divide(new BigDecimal(duration), 2, BigDecimal.ROUND_UP);

    for (int i = 0; i < duration; i++) {
      amounts[i] = installmentAmount;
    }

    return this.createPaymentProgram(paymentProgramType, principalType, null, null,
        programValidDays, null, null, null, percentage, duration,
        fixedFee, paymentPrograms.size() + 1, amounts, duration, -1, null, null);
  } // end method createPaymentProgram

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Create a payment program with program order.
   *
   * @param   paymentProgramType          DOCUMENT ME!
   * @param   principalType               DOCUMENT ME!
   * @param   amountType                  DOCUMENT ME!
   * @param   roundType                   DOCUMENT ME!
   * @param   programValidDays            DOCUMENT ME!
   * @param   allowedPaymentDateRange     DOCUMENT ME!
   * @param   installmentDateTolerence    DOCUMENT ME!
   * @param   installmentDollarTolerence  DOCUMENT ME!
   * @param   percentage                  DOCUMENT ME!
   * @param   duration                    DOCUMENT ME!
   * @param   fixedFee                    DOCUMENT ME!
   * @param   startOrder                  DOCUMENT ME!
   * @param   amounts                     DOCUMENT ME!
   * @param   requiredPayments            DOCUMENT ME!
   * @param   frequency                   DOCUMENT ME!
   * @param   requiredPTPs                DOCUMENT ME!
   * @param   allowEagerPayment           DOCUMENT ME!
   *
   * @return  create a payment program with program order
   */
  public PaymentProgram createPaymentProgram(PaymentProgramType paymentProgramType, String principalType,
    AmountType amountType, RoundType roundType, Integer programValidDays, Integer allowedPaymentDateRange,
    Integer installmentDateTolerence, BigDecimal installmentDollarTolerence, BigDecimal percentage, Integer duration,
    BigDecimal fixedFee, Integer startOrder, BigDecimal[] amounts, Integer requiredPayments, Integer frequency,
    Integer requiredPTPs, Boolean allowEagerPayment) {
    if (amountType == null) {
      amountType = AmountType.TOTAL_AMOUNT;
    }

    if (roundType == null) {
      roundType = RoundType.CENTS_UP;
    }

    if ((requiredPayments == null) && (duration > 0)) {
      requiredPayments = duration;
    }

    PaymentProgram paymentProgram = new PaymentProgram();
    paymentProgram.setActive(true);
    paymentProgram.setProgramOrder(startOrder);
    paymentProgram.setType(paymentProgramType);
    paymentProgram.setPrincipalType(principalType);
    paymentProgram.setPercentage(percentage);
    paymentProgram.setDuration(duration);
    paymentProgram.setFrequency(frequency);
    paymentProgram.setFixedFeeAmount(fixedFee);
    paymentProgram.setProgramStatus(ProgramStatus.INIT);

    if (allowedPaymentDateRange != null) {
      paymentProgram.setAllowedInstallmentDateRange(
        allowedPaymentDateRange);
    }

    if (installmentDateTolerence != null) {
      paymentProgram.setInstallmentDateTolerence(
        installmentDateTolerence);
    }

    if (installmentDollarTolerence != null) {
      paymentProgram.setInstallmentDollarTolerence(
        installmentDollarTolerence);
    }

    // calculate the expiration date
    GregorianCalendar calbase = new GregorianCalendar();
    GregorianCalendar cal     = new GregorianCalendar(calbase.get(
          Calendar.YEAR), calbase.get(Calendar.MONTH),
        calbase.get(Calendar.DAY_OF_MONTH));
    cal.add(Calendar.DAY_OF_YEAR, programValidDays);
    paymentProgram.setExpirationDate(cal.getTime());
    paymentProgram.setRequiredPayments(requiredPayments);
    paymentProgram.setRequiredPTPs(requiredPTPs);
    paymentProgram.setAllowEagerPayment(allowEagerPayment);

    // get the principalWhenCreated amount, and create installments
    try {
      BigDecimal programAmount    = BigDecimal.ZERO;
      BigDecimal totalAmount      = null;
      BigDecimal principal        = BigDecimal.ZERO;
      int        installmentCount = duration;

      if (installmentCount < 0) {
        installmentCount = requiredPayments;
      }

      if (installmentCount > 0) {
        BigDecimal[] installmentAmounts = new BigDecimal[installmentCount];

        // get program amount from individual installment
        for (int i = 0; i < installmentCount; i++) {
          installmentAmounts[i] = roundAmount(amounts[i], roundType); // 2
          programAmount         = programAmount.add((installmentAmounts[i] == null) ? BigDecimal.ZERO
                                                                                    : installmentAmounts[i]);
        }

        // Now round the principal - sometimes it is needed if principal
        // uses
        // complex calculation.
        switch (amountType) {
          case TOTAL_AMOUNT: {
            principal = getPrincipalAmount(principalType);

            BigDecimal targetProgramAmount     = principal.multiply(
                percentage);                 // 104.18
            BigDecimal targetInstallmentAmount = targetProgramAmount.divide(new BigDecimal(duration), 2,
                BigDecimal.ROUND_HALF_DOWN); // duration

            // 5:
            // 20.836-&gt;20.84
            targetInstallmentAmount = roundAmount(
                targetInstallmentAmount, roundType); // REMAINDER_FIRST:

            // 20.84
            if (roundType.equals(RoundType.CENTS_UP)
                  || roundType.equals(RoundType.DOLLARS_UP)) {
              principal           = roundAmount(principal, roundType);
              targetProgramAmount = roundAmount(targetProgramAmount,
                  roundType);
            } else {
              principal           = roundAmount(principal,
                  RoundType.CENTS_HALF_UP); // 104.18
              targetProgramAmount = roundAmount(targetProgramAmount,
                  RoundType.CENTS_HALF_UP); // 104.18
            }

            BigDecimal remainderAmount; // -0.02

            // Adjust installment if needed
            if (roundType.equals(RoundType.REMAINDER_FIRST)
                  || roundType.equals(RoundType.SPREAD_REMAINDER)) {
              targetInstallmentAmount = targetProgramAmount.divide(
                  new BigDecimal(duration), 2,
                  BigDecimal.ROUND_DOWN);
              programAmount           = BigDecimal.ZERO;

              for (int i = 0; i < installmentCount; i++) {
                installmentAmounts[i] = targetInstallmentAmount;
                programAmount         = programAmount.add(
                    installmentAmounts[i]);
              }

              // add remainder to the first installment
              remainderAmount = targetProgramAmount.subtract(
                  programAmount);

              switch (roundType) {
                case REMAINDER_FIRST: {
                  installmentAmounts[0] = installmentAmounts[0].add(
                      remainderAmount); // 20.84-0.02=20.82

                  // adjust program amount
                  programAmount = targetProgramAmount;

                  break;
                }

                case SPREAD_REMAINDER: {
                  BigDecimal oneCent = new BigDecimal("0.01");
                  programAmount = BigDecimal.ZERO;

                  for (int i = 0; i < installmentCount; i++) {
                    // installmentAmounts[i] =
                    // targetInstallmentAmount;
                    if (remainderAmount.compareTo(BigDecimal.ZERO)
                          > 0) {
                      // add remainder
                      installmentAmounts[i] = installmentAmounts[i].add(oneCent);
                      remainderAmount       = remainderAmount.subtract(
                          oneCent);
                    }

                    programAmount = programAmount.add(
                        installmentAmounts[i]);
                  }

                  break;
                }
              } // end switch
            }   // end if

            break;
          }

          case MONTHLY_AMOUNT: {
            principal = getPrincipalAmount(principalType);

            if (roundType.equals(RoundType.CENTS_UP)
                  || roundType.equals(RoundType.DOLLARS_UP)) {
              principal = roundAmount(principal, roundType);
            } else {
              principal = roundAmount(principal,
                  RoundType.CENTS_HALF_UP);
            }

            break;
          }

          case INDIVIDUAL_AMOUNT: {
            principal = programAmount;

            break;
          }
        } // end switch

        paymentProgram.setPrincipalWhenCreated(principal);

        // Check principal value: not null and not 0.0 and not less than 0.0
        if ((principal == null)
              || (principal.compareTo(BigDecimal.ZERO) <= 0)) {
          return null;
        }

        // validate program amount and installment amount
        if ((programAmount == null)
              || (programAmount.compareTo(BigDecimal.ZERO) <= 0)) {
          return null;
        }

        if (installmentCount > 1) {
          for (int i = 0; i < installmentCount; i++) {
            if ((installmentAmounts[i] == null)
                  || (installmentAmounts[i].compareTo(
                      BigDecimal.ZERO) <= 0)) {
              return null;
            }
          }
        }

        totalAmount = programAmount;
        paymentProgram.setProgramAmount(programAmount);

        int order = 1;

        /*if (fixedFee.compareTo(BigDecimal.ZERO) > 0) {
         *
         * PaymentProgramInstallment installment = new PaymentProgramInstallment();
         * installment.setFixedFee(true);
         * installment.setOrder(order++);
         * installment.setPaymentAmount(fixedFee);
         *
         * paymentProgram.addFixedFeeInstallment(installment);
         * totalAmount = programAmount.add(fixedFee);
         *} */
        if (installmentCount == 1) {
          // one payment
          PaymentProgramInstallment installment = new PaymentProgramInstallment();
          installment.setFixedFee(false);
          installment.setOrder(order++);
          installment.setPaymentAmount(programAmount);

          // there is fixed fee, add fixed fee to installment
          if ((fixedFee != null) && (BigDecimal.ZERO.compareTo(fixedFee) < 0)) {
            installment.setFixedFee(true);
            installment.setPaymentAmount(programAmount.add(fixedFee));
          }

          if (requiredPayments > 0) {
            installment.setRequired(true);
          } else {
            installment.setRequired(false);
          }

          paymentProgram.addInstallment(installment);
        } else {
          for (int i = 0; i < installmentCount; i++) {
            PaymentProgramInstallment installment = new PaymentProgramInstallment();

            // frequency is null then go monthly
            if ((frequency == null) || (frequency <= 0)) {
              int f = 1;

              if (frequency != null) {
                if (frequency < 0) {
                  f = frequency * (-1);
                }
              }

              // weekly payment
              installment.setPaymentMonthOffset(i * f);
              installment.setPaymentDateOffset(0);
            } else {
              installment.setPaymentMonthOffset(0);
              installment.setPaymentDateOffset(frequency * i);
            }

            installment.setOrder(order++);
            installment.setFixedFee(false);
            installment.setPaymentAmount(installmentAmounts[i]);

            // there is fixed fee, add fixed fee to first installment
            if ((fixedFee != null) && (BigDecimal.ZERO.compareTo(fixedFee) < 0) && (i == 0)) {
              installment.setFixedFee(true);
              installment.setPaymentAmount(installmentAmounts[i].add(fixedFee));
            }

            if (i < requiredPayments) {
              installment.setRequired(true);
            } else {
              installment.setRequired(false);
            }

            paymentProgram.addInstallment(installment);
          } // end for
        }   // end if-else

        // set total amount
        paymentProgram.setTotalAmount(totalAmount);

      } // end if
    } catch (Exception e) {
      paymentProgram = null;
      e.printStackTrace();
    }   // end try-catch

    return paymentProgram;
  } // end method createPaymentProgram

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   metaDataName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean deleteAccountMetaData(String metaDataName) {
    if ((getAccountMetaData() == null)
          || (getAccountMetaData().size() == 0)) {
      return false;
    }

    for (AccountMetaData metaData : getAccountMetaData()) {
      AccountMetaDataField field = metaData.getAccountMetaDataField();

      if (metaDataName.equalsIgnoreCase(field.getName())) {
        return accountMetaData.remove(metaData);
      } // end if
    }   // end for

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void disableAllPaymentPrograms() {
    for (PaymentProgram paymentProgram : getPaymentPrograms()) {
      paymentProgram.setActive(false);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final Account other = (Account) obj;

    if (agencyAccountNumber == null) {
      if (other.getAgencyAccountNumber() != null) {
        return false;
      }
    } else if (!agencyAccountNumber.equals(
            other.getAgencyAccountNumber())) {
      return false;
    }

    if (createDate == null) {
      if (other.getCreateDate() != null) {
        return false;
      }
    } else if (!createDate.equals(other.getCreateDate())) {
      return false;
    }

    if (originalAccountNumber == null) {
      if (other.getOriginalAccountNumber() != null) {
        return false;
      }
    } else if (!originalAccountNumber.equals(other.getOriginalAccountNumber())) {
      return false;
    }

    if (originalCreditor == null) {
      if (other.getOriginalCreditor() != null) {
        return false;
      }
    } else if (!originalCreditor.equals(other.getOriginalCreditor())) {
      return false;
    }

    if (originalDateTimestamp == null) {
      if (other.getOriginalDateTimestamp() != null) {
        return false;
      }
    } else if (!originalDateTimestamp.equals(other.getOriginalDateTimestamp())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   docType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Document findDocuemntByType(DocumentType docType) {
    for (Document document : documents) {
      if (document.getDocumentType().equals(docType)) {
        return document;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Find Document by Id.
   *
   * @param   documentId  DOCUMENT ME!
   *
   * @return  find Document by Id
   */
  public Document findDocument(Long documentId) {
    for (Document document : documents) {
      if (document.getId().equals(documentId)) {
        return document;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   amount          DOCUMENT ME!
   * @param   receivedDate    DOCUMENT ME!
   * @param   leftDateRange   DOCUMENT ME!
   * @param   rightDateRange  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long findMatchingInProcessPaymentId(BigDecimal amount, Date receivedDate, int leftDateRange,
    int rightDateRange) {
    if ((amount == null) || (receivedDate == null)) {
      return null;
    }

    Date paidDate  = DateUtil.toDateOnly(receivedDate);
    Date startDate = DateUtil.addDays(paidDate, -1 * leftDateRange);
    Date endDate   = DateUtil.addDays(paidDate, rightDateRange);

    for (Payment payment : this.payments) {
      // ascending by payment date
      if (PaymentStatus.INPROCESS.equals(payment.getPaymentStatus())) {
        Date paymentDate = DateUtil.toDateOnly(
            payment.getPaymentDate());

        if (DateUtil.isInDateTimeRange(paymentDate, startDate,
                endDate)) {
          if (payment.getAmount() != null) {
            if (amount.compareTo(payment.getAmount()) == 0) {
              return payment.getPaymentId();
            }
          }
        }
      }
    }

    return null;
  } // end method findMatchingInProcessPaymentId

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accepted program.
   *
   * @return  PaymentProgram
   */
  public PaymentProgram getAcceptedProgram() {
    return acceptedProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getAcceptedProgramFulfillDate() {
    if ((acceptedProgram != null)
          && ProgramStatus.FULFILLED.equals(
            acceptedProgram.getProgramStatus())) {
      PaymentProgramInstallment installment = acceptedProgram.getLastInstallment();

      if (installment != null) {
        return installment.getPaymentDate();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAcceptedProgramId() {
    if (acceptedProgram != null) {
      return acceptedProgram.getProgramId();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAcceptedProgramInstallmentNumber() {
    if (acceptedProgram != null) {
      return acceptedProgram.getDuration();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAcceptedProgramStatus() {
    if (acceptedProgram != null) {
      if (acceptedProgram.getProgramStatus() != null) {
        return acceptedProgram.getProgramStatus().toString();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return program accepted type.
   *
   * @return  DOCUMENT ME!
   */
  public String getAcceptedProgramType() {
    if (acceptedProgram != null) {
      return acceptedProgram.getType().getName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getAcceptedSettlmentPercent() {
    if (acceptedProgram != null) {
      if ("Settlement".equalsIgnoreCase(
              acceptedProgram.getType().getName())) {
        if (acceptedProgram.getPercentage() != null) {
          return acceptedProgram.getPercentage();
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accept program date.
   *
   * @return  Date
   */
  public Date getAcceptProgramDate() {
    return acceptProgramDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accept terms.
   *
   * @return  String
   */
  public String getAcceptTerms() {
    return clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account additional detail.
   *
   * @return  AccountAdditionalDetail
   */
  public AccountAdditionalDetail getAccountAdditionalDetail() {
    return accountAdditionalDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account assigned external entities.
   *
   * @return  Set
   */
  public Set<AccountAssignedExternalEntity> getAccountAssignedExternalEntities() {
    return accountAssignedExternalEntities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AccountAuthorizedContact> getAccountAuthorizedContacts() {
    return accountAuthorizedContacts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   ucid  - Tsys Unique Customer Id
   *
   * @return  DOCUMENT ME!
   */
  public AccountAuthorizedUser getAccountAuthorizedUser(String ucid) {
    if ((StringUtils.hasText(ucid)) && (getAccountAuthorizedUsers() != null)
          && (getAccountAuthorizedUsers().size() > 0)) {
      for (AccountAuthorizedUser acctAuthUser : getAccountAuthorizedUsers()) {
        if (ucid.equalsIgnoreCase(acctAuthUser.getAccountAuthorizedUserDetail().getClientDefined20CharCode2())) {
          return acctAuthUser;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AccountAuthorizedUser> getAccountAuthorizedUsers() {
    return accountAuthorizedUsers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountBalanceBreakDown getAccountBalanceBreakDown() {
    return accountBalanceBreakDown;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountConfig getAccountConfig() {
    return accountConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the account existing days.
   *
   * @return  get the account existing days
   */
  public Integer getAccountDays() {
    if (this.entryDate != null) {
      return DateUtil.getDayDifference(new Date(), this.entryDate, false)
        + 1;
    } else {
      return DateUtil.getDayDifference(new Date(), this.createDate,
          false) + 1;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountDelinquent getAccountDelinquent() {
    return accountDelinquent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentConsDaysPastDue() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getConsDaysPastDue();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentTimesPastDue1() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getTimesPastDue1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentTimesPastDue10() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getTimesPastDue10();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentTimesPastDue11() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getTimesPastDue11();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentTimesPastDue12() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getTimesPastDue12();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentTimesPastDue2() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getTimesPastDue2();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentTimesPastDue3() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getTimesPastDue3();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentTimesPastDue4() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getTimesPastDue4();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentTimesPastDue5() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getTimesPastDue5();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentTimesPastDue6() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getTimesPastDue6();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentTimesPastDue7() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getTimesPastDue7();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentTimesPastDue8() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getTimesPastDue8();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountDelinquentTimesPastDue9() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getTimesPastDue9();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account detail.
   *
   * @return  AccountDetail
   */
  public AccountDetail getAccountDetail() {
    return accountDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountExtension getAccountExtension() {
    return accountExtension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account extension boolean.
   *
   * @return  AccountExtensionBoolean
   */
  public AccountExtensionBoolean getAccountExtensionBoolean() {
    return accountExtensionBoolean;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account extension char.
   *
   * @return  AccountExtensionChar
   */
  public AccountExtensionChar getAccountExtensionChar() {
    return accountExtensionChar;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account extension date.
   *
   * @return  AccountExtensionDate
   */
  public AccountExtensionDate getAccountExtensionDate() {
    return accountExtensionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account extension decimal.
   *
   * @return  AccountExtensionDecimal
   */
  public AccountExtensionDecimal getAccountExtensionDecimal() {
    return accountExtensionDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account extension integer.
   *
   * @return  AccountExtensionInteger
   */
  public AccountExtensionInteger getAccountExtensionInteger() {
    return accountExtensionInteger;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AccountFlexSelectConfigAudit> getAccountFlexSelectConfigAuditSet() {
    return accountFlexSelectConfigAuditSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   variable  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountFlowVariableValue getAccountFlowVariableValue(SurveyFlowVariable variable) {
    if (accountFlowVariableValues != null) {
      for (AccountFlowVariableValue variableValue : accountFlowVariableValues) {
        if (variable.equals(variableValue.getVariable())) {
          return variableValue;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AccountFlowVariableValue> getAccountFlowVariableValues() {
    return accountFlowVariableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountIndex getAccountIndex() {
    return accountIndex;
  }
  // accountIndicator

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAccountIndicator() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountInformation getAccountInformation() {
    return accountInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAccountMarker() {
    return clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AccountMetaData> getAccountMetaData() {
    return accountMetaData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   metaDataName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountMetaDataField getAccountMetaDataField(String metaDataName) {
    if ((metaDataName == null) || (metaDataName.length() == 0)) {
      return null;
    }

    if ((getAccountMetaData() != null)
          && (getAccountMetaData().size() > 0)) {
      for (AccountMetaData metaData : getAccountMetaData()) {
        AccountMetaDataField field = metaData.getAccountMetaDataField();

        if (metaDataName.equalsIgnoreCase(field.getName())) {
          return field;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   metaDataName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Object getAccountMetaDataValue(String metaDataName) {
    if ((getAccountMetaData() == null)
          || (getAccountMetaData().size() == 0)) {
      return null;
    }

    for (AccountMetaData metaData : getAccountMetaData()) {
      AccountMetaDataField field = metaData.getAccountMetaDataField();

      if (metaDataName.equalsIgnoreCase(field.getName())) {
        MetaDataValueType type = field.getType();

        switch (type) {
          case INTEGER: {
            return metaData.getMetaDataIntegerValue();
          }

          case BIGDECIMAL: {
            if (StringUtils.hasText(metaData.getValue())) {
              try {
                return new BigDecimal(metaData.getValue());
              } catch (Exception e) { }
            }

            return metaData.getMetaDataDecimalValue();
          }

          case LONG: {
            return metaData.getMetaDataLongValue();
          }

          case DATE: {
            return metaData.getMetaDataDateValue();
          }

          case STRING: {
            return metaData.getMetaDataStringValue();
          }

          case BOOLEAN: {
            return metaData.getMetaDataBooleanValue();
          }
        } // end switch

        return null;
      } // end if
    }   // end for

    return null;
  } // end method getAccountMetaDataValue

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account num.
   *
   * @return  Long
   */
  public Long getAccountNum() {
    return accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AccountNumberAudit> getAccountNumberAudits() {
    return accountNumberAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountOverallStatus getAccountOverallStatus() {
    for (AccountOverallStatus overallStatus : this.accountOverallStatusSet) {
      if (!overallStatus.getHistorical()) {
        return overallStatus;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account overall status set.
   *
   * @return  Set
   */
  public Set<AccountOverallStatus> getAccountOverallStatusSet() {
    return accountOverallStatusSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get account payment based on paymentId.
   *
   * @param   paymentId  DOCUMENT ME!
   *
   * @return  get account payment based on paymentId
   */
  public Payment getAccountPayment(Long paymentId) {
    if (paymentId == null) {
      return null;
    }

    for (Payment payment : payments) {
      if (paymentId.equals(payment.getPaymentId())) {
        return payment;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get Account payment program by program id.
   *
   * @param   programId  DOCUMENT ME!
   *
   * @return  get Account payment program by program id
   */
  public PaymentProgram getAccountPaymentProgram(Long programId) {
    if (programId == null) {
      return null;
    }

    for (PaymentProgram paymentProgram : paymentPrograms) {
      if (programId.equals(paymentProgram.getProgramId())) {
        return paymentProgram;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AccountPolicy> getAccountPolicies() {
    return accountPolicies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAccountProfileCode() {
    return clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AccountSaleInfo> getAccountSaleInfoSet() {
    return accountSaleInfoSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Score retrieval.
   *
   * @param   scoreName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAccountScore(String scoreName) {
    try {
      scoreName = StringUtils.trimAllWhitespace(scoreName);

      Set<AccountScore> acctScores = getAccountScores();

      if ((acctScores != null) && (acctScores.size() > 0)) {
        for (AccountScore score : acctScores) {
          String sName = StringUtils.trimAllWhitespace(score.getScoreType().getScoreName());

          if (scoreName.equalsIgnoreCase(sName)) {
            log.warn("getAccountScore(" + scoreName + "): " + score.getScoreValue());

            return score.getScoreValue();
          }
        }
      }
    } catch (Exception e) {
      log.error("Exception getting : " + scoreName + " score.");
      log.error(e.getMessage(), e);
    } // end try-catch

    log.warn("Account.getAccountScore(" + scoreName + "): returning null.");

    return null;
  } // end method getAccountScore

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   scoreName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getAccountScoreDate(String scoreName) {
    AccountScore accountScore = getAccountScoreObj(scoreName);

    if (accountScore != null) {
      return accountScore.getScoreDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   scoreName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountScore getAccountScoreObj(String scoreName) {
    try {
      scoreName = StringUtils.trimAllWhitespace(scoreName);

      Set<AccountScore> acctScores = getAccountScores();

      if ((acctScores != null) && (acctScores.size() > 0)) {
        for (AccountScore score : acctScores) {
          String sName = StringUtils.trimAllWhitespace(score.getScoreType().getScoreName());

          if (scoreName.equalsIgnoreCase(sName)) {
            log.warn("getAccountScore(" + scoreName + "): " + score.getScoreValue());

            return score;
          }
        }
      }
    } catch (Exception e) {
      log.error("Exception getting : " + scoreName + " score.");
      log.error(e.getMessage(), e);
    } // end try-catch

    log.warn("Account.getAccountScore(" + scoreName + "): returning null.");

    return null;
  } // end method getAccountScoreObj

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account scores.
   *
   * @return  Set
   */
  public Set<AccountScore> getAccountScores() {
    return accountScores;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get specific type of scores based on score type. Returns null if no such score exists.
   *
   * @param   scoreType  DOCUMENT ME!
   *
   * @return  get specific type of scores based on score type.
   */
  public Set<AccountScore> getAccountScores(ScoreTypeEnum scoreType) {
    Set<AccountScore> scores = new LinkedHashSet<AccountScore>();

    for (AccountScore score : this.accountScores) {
      if (score.getScoreType().getScoreTypeId().equals(
              scoreType.getScoreTypeId())) {
        scores.add(score);
      }
    }

    if (scores.size() == 0) {
      return null;
    }

    return scores;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account SOR.
   *
   * @return  AccountSOR
   */
  public AccountSOR getAccountSOR() {
    return accountSOR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return a String status code array. If no status, returns an empty String array.
   *
   * @return  return a String status code array.
   */
  public String[] getAccountStatusCodes() {
    if ((accountStatuses == null) || (accountStatuses.size() == 0)) {
      return new String[0];
    }

    String[] codes = new String[accountStatuses.size()];
    int      i     = 0;

    for (AccountStatus accountStatus : accountStatuses) {
      codes[i] = accountStatus.getAccountStatusDetail().getStatusCode();
      i++;
    }

    return codes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account statuses.
   *
   * @return  Set
   */
  public Set<AccountStatus> getAccountStatuses() {
    return accountStatuses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   code  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getAccountStatusMostRecentDate(final String code) {
    return getAccountStatusMostRecentDate(code, true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAccountType() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the account existing days.
   *
   * @return  get the account existing days
   */
  public Integer getAccountWeeks() {
    if (this.entryDate != null) {
      return DateUtil.getWeekDifference(new Date(), this.entryDate) + 1;
    } else {
      return DateUtil.getWeekDifference(new Date(), this.createDate) + 1;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accrued interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAccruedInterest() {
    return accruedInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    if (active == null) {
      // NULL means active - maximize performance
      return Boolean.TRUE;
    }

    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   code  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getActiveAccountStatusMostRecentDate(final String code) {
    return getAccountStatusMostRecentDate(code, false);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getActiveDays() {
    if (Boolean.FALSE.equals(this.active)) {
      return 0;
    }

    if (this.revisedDateTimestamp == null) {
      return null;
    } else {
      return DateUtil.getDayDifference(new Date(),
          this.revisedDateTimestamp, false);
    }
  }
  // COFS ActiveMortgageTrades

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getActiveMortgageTrades() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for actual exit date.
   *
   * @return  Date
   */
  public Date getActualExitDate() {
    return actualExitDate;
  }
  // adjustedPaidToDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getAdjustedPaidToDate() {
    return clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency account number.
   *
   * @return  String
   */
  public String getAgencyAccountNumber() {
    return agencyAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency account set.
   *
   * @return  Set
   */
  public Set<AgencyAccount> getAgencyAccountSet() {
    return agencyAccountSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency code.
   *
   * @return  String
   */
  public String getAgencyCode() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getAgencyCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency queue.
   *
   * @return  AgencyQueue
   */
  public AgencyQueue getAgencyQueue() {
    return agencyQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency team queue.
   *
   * @return  AgencyTeamQueue
   */
  public AgencyTeamQueue getAgencyTeamQueue() {
    return agencyTeamQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency transaction code.
   *
   * @return  String
   */
  public String getAgencyTransactionCode() {
    return clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return this.agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent call activities.
   *
   * @return  Set
   */
  public Set<AgentCallActivity> getAgentCallActivities() {
    return this.agentCallActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent last work date.
   *
   * @return  Date
   */
  public Date getAgentLastWorkDate() {
    if (getUserLoadedAccounts().size() > 0) {
      return getUserLoadedAccounts().iterator().next().getCreateDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent queue.
   *
   * @return  AgentQueue
   */
  public AgentQueue getAgentQueue() {
    return agentQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent viewed counter.
   *
   * @return  Integer
   */
  public Integer getAgentViewedCounter() {
    if (agentViewedCounter == null) {
      agentViewedCounter = 0;
    }

    return agentViewedCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent worked counter.
   *
   * @return  Integer
   */
  public Integer getAgentWorkedCounter() {
    if (agentWorkedCounter == null) {
      agentWorkedCounter = 0;
    }

    return agentWorkedCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all account activities.
   *
   * @return  get all account activities
   */
  public List<BaseActivity> getAllActivities() {
    List<BaseActivity> list = new ArrayList<BaseActivity>();
    list.addAll(agentCallActivities);
    list.addAll(getLetterActivitiesFromLetterChannelResults());
    list.addAll(getEmailActivitiesFromEmailChannelResults());
    list.addAll(getIvrActivitiesFromIvrChannelResults());
    list.addAll(getSmsActivitiesFromSmsChannelResults());
    list.addAll(getDialerActivitiesFromDialerChannelResults());
    list.addAll(webActivities);

    return list;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow channel strategy.
   *
   * @return  Boolean
   */
  public Boolean getAllowChannelStrategy() {
    AccountConfig c = this.getAccountConfig();

    if (c != null) {
      return (c.getAllowChannelStrategy() == null) ? Boolean.TRUE : c.getAllowChannelStrategy();
    }

    return Boolean.TRUE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowNegotiationStrategy() {
    AccountConfig c = this.getAccountConfig();

    if (c != null) {
      return (c.getAllowNegotiationStrategy() == null) ? Boolean.TRUE : c.getAllowNegotiationStrategy();
    }

    return Boolean.TRUE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowProgram() {
    if (this.getAccountDetail() != null) {
      if (this.getAccountDetail().getAllowProgram() == null) {
        return Boolean.TRUE;
      } else {
        return this.getAccountDetail().getAllowProgram();
      }
    }

    return Boolean.TRUE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowProgramStrategy() {
    AccountConfig c = this.getAccountConfig();

    if (c != null) {
      return (c.getAllowProgramStrategy() == null) ? Boolean.TRUE : c.getAllowProgramStrategy();
    }

    return Boolean.TRUE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowQueueStrategy() {
    AccountConfig c = this.getAccountConfig();

    if (c != null) {
      return (c.getAllowQueueStrategy() == null) ? Boolean.TRUE : c.getAllowQueueStrategy();
    }

    return Boolean.TRUE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow web.
   *
   * @return  Boolean
   */
  public Boolean getAllowWeb() {
    if (allowWeb == null) {
      return Boolean.FALSE;
    }

    return allowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   typeId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<String> getAllPhoneNum(String typeId) {
    if (typeId == null) {
      return null;
    }

    Set<String> allPhones = new LinkedHashSet<String>();

    for (Responsible r : responsibles) {
      allPhones.addAll(r.getAllPhoneNum(typeId));
    }

    for (AccountAuthorizedContact c : accountAuthorizedContacts) {
      allPhones.addAll(c.getAllPhoneNum(typeId));
    }

    for (AccountAuthorizedUser u : accountAuthorizedUsers) {
      allPhones.addAll(u.getAllPhoneNum(typeId));
    }

    return allPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * ClientDefinedAmount1.
   *
   * @return  clientDefinedAmount1
   */
  public BigDecimal getAmendedAmount() {
    return clientDefinedAmount1;
  }
  // Added by Etisbew on 07/29/09 for Scottsh Power Specific Fields-Satrt

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * return clientDefinedFlag3.
   *
   * @return  return clientDefinedFlag3
   */
  public boolean getAmendedBill() {
    return Boolean.TRUE.equals(clientDefinedFlag3);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApplication() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApplicationId() {
    return clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for appointments.
   *
   * @return  Set
   */
  public Set<AdvisorAppointment> getAppointments() {
    return appointments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for apr.
   *
   * @return  BigDecimal
   */
  public BigDecimal getApr() {
    return apr;
  }
  // DFS arrangement status code

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getArrangementStatusCode() {
    return clientDefined1CharCode3;
  }
  // DFS Arrangement Type

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getArrangementType() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for asset equip type.
   *
   * @return  String
   */
  public String getAssetEquipType() {
    log.info("InSide getAssetEquipType..");

    ContractAssets asset          = null;
    String         assetEquipType = null;

    if (!this.getAssets().isEmpty()) {
      log.info("Assests exist");
      asset = this.getAssets().iterator().hasNext() ? this.getAssets().iterator().next() : null;
    }

    if (asset != null) {
      log.info("Asset is not null..");
      assetEquipType = asset.getEquipType();
      log.info("assetEquipType:" + assetEquipType);

      return assetEquipType;
    }

    return null;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assets.
   *
   * @return  Set
   */
  public Set<ContractAssets> getAssets() {
    return assets;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for auto.
   *
   * @return  AccountAuto
   */
  public AccountAuto getAuto() {
    return auto;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for auto debit details.
   *
   * @return  Set
   */
  public Set<AutoDebitDetail> getAutoDebitDetails() {
    return autoDebitDetails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAutoPayFlag() {
    return clientDefinedFlag1;
  }
  // auxStatusCodes

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAuxStatusCodes() {
    return clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getAvailableCredit() {
    return availableCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getAvailableCreditForCash() {
    return availableCreditForCash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalance() {
    return balance;
  }
  // bkptcyFlag

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBankruptcyFlag() {
    return clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BarclayAccount getBarclayAccount() {
    return barclayAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch file date.
   *
   * @return  Date
   */
  public Date getBatchFileDate() {
    return this.batchFileDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch id.
   *
   * @return  Long
   */
  public Long getBatchId() {
    return batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BBLAccount score.
   *
   * @param   scoreName  String
   *
   * @return  BigDecimal
   */
  public BigDecimal getBBLAccountScore(String scoreName) {
    try {
      scoreName = StringUtils.trimAllWhitespace(scoreName);

      Set<AccountScore> acctScores = getAccountScores();

      if ((acctScores != null) && (acctScores.size() > 0)) {
        for (AccountScore score : acctScores) {
          String sName = StringUtils.trimAllWhitespace(score.getScoreType().getScoreName());

          if (scoreName.equalsIgnoreCase(sName)) {
            BigDecimal scoreValue = (score.getScoreValue() != null)
              ? new BigDecimal(score.getScoreValue()).divide(new BigDecimal(100)) : null;
            log.warn("getBBLAccountScore() for :: " + scoreName + " returning :: " + scoreValue);

            return scoreValue;
          }
        }
      }

    } catch (Exception e) {
      log.error("Exception getting : " + scoreName + " score from EvalManager.getScore(..)");
      log.error(e.getMessage(), e);
    } // end try-catch

    log.warn("Account.getBBLAccountScore() for :: " + scoreName + " returning null.");

    return null;
  } // end method getBBLAccountScore

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBBLProgramCode() {
    String cardStatus     = this.getClientDefined3CharCode1();
    String bblProgramCode = null;

    if ("ZZ".equalsIgnoreCase(cardStatus)) {
      bblProgramCode = "PE4";
    } else {
      bblProgramCode = "PE3";
    }

    return bblProgramCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   scoreName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBBLScoreDate(String scoreName) {
    try {
      scoreName = StringUtils.trimAllWhitespace(scoreName);

      Set<AccountScore> acctScores = getAccountScores();

      if ((acctScores != null) && (acctScores.size() > 0)) {
        for (AccountScore score : acctScores) {
          String sName = StringUtils.trimAllWhitespace(score.getScoreType().getScoreName());

          if (scoreName.equalsIgnoreCase(sName)) {
            Date scoreDate = score.getScoreDate();
            log.warn("Account.getBBLScoreDate() for :: " + scoreName + " returning :: " + scoreDate);

            return scoreDate;
          }
        }
      }
    } catch (Exception e) {
      log.error("Exception getting : " + scoreName + " scoreDate from Account.getBBLScoreDate(..)");
      log.error(e.getMessage(), e);
    }

    log.warn("Account.getBBLScoreDate() for :: " + scoreName + " returning NULL.");

    return null;
  } // end method getBBLScoreDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for behavior score.
   *
   * @return  Integer
   */
  public Integer getBehaviorScore() {
    return this.behaviorScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the best creditor name.
   *
   * @return  get the best creditor name.
   */
  public String getBestCreditorName() {
    String ret = getOriginalCreditor();

    if (!StringUtils.hasText(ret)) {
      ret = getPortfolio().getOriginalCreditor();
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBillFromDate() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for billing cycle.
   *
   * @return  Integer
   */
  public Integer getBillingCycle() {
    return billingCycle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for billing date.
   *
   * @return  Date
   */
  public Date getBillingDate() {
    return billingDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBillIssueDate() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBillToDate() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBrandIndicator() {
    if (this.division != null) {
      return division.getClientDivisionCode();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for broken promise.
   *
   * @return  Boolean
   */
  public Boolean getBrokenPromise() {
    return brokenPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for broken promise date.
   *
   * @return  Date
   */
  public Date getBrokenPromiseDate() {
    return brokenPromiseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getBrokenPromisesLTD() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getBrokenPromisesLTD();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getBrokenPromisesYTD() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getBrokenPromisesYTD();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount1() {
    return bucketAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBucketAmount10() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getBucketAmount10();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBucketAmount11() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getBucketAmount11();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBucketAmount12() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getBucketAmount12();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount2() {
    return bucketAmount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount3() {
    return bucketAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount4.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount4() {
    return bucketAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount5.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount5() {
    return bucketAmount5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount6.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount6() {
    return bucketAmount6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount7.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount7() {
    return bucketAmount7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBucketAmount8() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getBucketAmount8();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBucketAmount9() {
    if (this.getAccountDelinquent() != null) {
      return this.getAccountDelinquent().getBucketAmount9();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBusinessNextCustomerDueDate() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getBusinessNextCustomerDueDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBusinessNextInstallmentDueDate() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getBusinessNextInstallmentDueDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business next installment due date for RAM.
   *
   * @return  Date
   */
  public Date getBusinessNextInstallmentDueDateForRAM() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getBusinessNextInstallmentDueDateForRAM();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBusinessPreviousCustomerDueDate() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getBusinessPreviousCustomerDueDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBusinessPreviousInstallmentDueDate() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getBusinessPreviousInstallmentDueDate();
    }

    return null;
  }
  // NCC cacs state code

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCacsStateCode() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cancel program date.
   *
   * @return  Date
   */
  public Date getCancelProgramDate() {
    return cancelProgramDate;
  }
  // CBNACustomerFlag

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getCBNACustomerFlag() {
    return (clientDefinedFlag3 != null) ? clientDefinedFlag3 : false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return the last Originated Channel.
   *
   * @return  channel origination
   */
  public String getChannelOrigination() {
    if (accountInformation != null) {
      return accountInformation.getChannelOrigination();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off.
   *
   * @return  Boolean
   */
  public Boolean getChargeOff() {
    return chargeOff;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getChargeOffAmount() {
    return chargeOffAmount;
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
   * getter method for charge off delay exclusion.
   *
   * @return  Set
   */
  public Set<ChargeOffDelayExclusion> getChargeOffDelayExclusion() {
    return chargeOffDelayExclusion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off reason code.
   *
   * @return  String
   */
  public String getChargeOffReasonCode() {
    return chargeOffReasonCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getChargePaymentAmount() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for citi account.
   *
   * @return  CitiAccount
   */
  public CitiAccount getCitiAccount() {
    return citiAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for claim agent.
   *
   * @return  User
   */
  public User getClaimAgent() {
    return this.claimAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for claim time.
   *
   * @return  Date
   */
  public Date getClaimTime() {
    return this.claimTime;
  }
  // NCC Card Client Accepted Program ID

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientAcceptedProgramId() {
    return clientDefined6CharCode2;
  }
  // NCC Card Client Accepted Program Status

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientAcceptedProgramStatus() {
    return clientDefined1CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client code.
   *
   * @return  Integer
   */
  public Integer getClientCode() {
    return clientCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method returns True or False based on the whether the customer has accepted ExpressConsent at Account Level
   * With Client or CMC receives in PlacementFile from Client.
   *
   * @return  Boolean
   */
  public Boolean getClientConsent() {
    AccountConfig c = this.getAccountConfig();

    if (c != null) {
      return (c.getClientConsentDate() != null) ? Boolean.TRUE : Boolean.FALSE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method returns Date when the customer has accepted ExpressConsent at Account Level CMC receives in
   * PlacementFile from Client.
   *
   * @return  Date
   */
  public Date getClientConsentDate() {
    AccountConfig c = this.getAccountConfig();

    if (c != null) {
      return c.getClientConsentDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client contact date.
   *
   * @return  Date
   */
  public Date getClientContactDate() {
    return clientContactDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code1.
   *
   * @return  String
   */
  public String getClientDefined1CharCode1() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code2.
   *
   * @return  String
   */
  public String getClientDefined1CharCode2() {
    return clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code3.
   *
   * @return  String
   */
  public String getClientDefined1CharCode3() {
    return clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code4.
   *
   * @return  String
   */
  public String getClientDefined1CharCode4() {
    return clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code5.
   *
   * @return  String
   */
  public String getClientDefined1CharCode5() {
    return clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code6.
   *
   * @return  String
   */
  public String getClientDefined1CharCode6() {
    return clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code7.
   *
   * @return  String
   */
  public String getClientDefined1CharCode7() {
    return clientDefined1CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code8.
   *
   * @return  String
   */
  public String getClientDefined1CharCode8() {
    return clientDefined1CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code1.
   *
   * @return  String
   */
  public String getClientDefined20CharCode1() {
    return clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code2.
   *
   * @return  String
   */
  public String getClientDefined20CharCode2() {
    return clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code3.
   *
   * @return  String
   */
  public String getClientDefined20CharCode3() {
    return clientDefined20CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code1.
   *
   * @return  String
   */
  public String getClientDefined2CharCode1() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code2.
   *
   * @return  String
   */
  public String getClientDefined2CharCode2() {
    return clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code3.
   *
   * @return  String
   */
  public String getClientDefined2CharCode3() {
    return clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code1.
   *
   * @return  String
   */
  public String getClientDefined3CharCode1() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code2.
   *
   * @return  String
   */
  public String getClientDefined3CharCode2() {
    return clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code1.
   *
   * @return  String
   */
  public String getClientDefined4CharCode1() {
    return clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code2.
   *
   * @return  String
   */
  public String getClientDefined4CharCode2() {
    return clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code3.
   *
   * @return  String
   */
  public String getClientDefined4CharCode3() {
    return clientDefined4CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined6 char code1.
   *
   * @return  String
   */
  public String getClientDefined6CharCode1() {
    return clientDefined6CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined6 char code2.
   *
   * @return  String
   */
  public String getClientDefined6CharCode2() {
    return clientDefined6CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined amount1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedAmount1() {
    return clientDefinedAmount1;
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
   * getter method for client defined date3.
   *
   * @return  Date
   */
  public Date getClientDefinedDate3() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date4.
   *
   * @return  Date
   */
  public Date getClientDefinedDate4() {
    return clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date5.
   *
   * @return  Date
   */
  public Date getClientDefinedDate5() {
    return clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date6.
   *
   * @return  Date
   */
  public Date getClientDefinedDate6() {
    return clientDefinedDate6;
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
   * getter method for client defined decimal3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal3() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag1.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag1() {
    if (clientDefinedFlag1 == null) {
      return Boolean.FALSE;
    }

    return clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag2.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag2() {
    return clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag3.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag3() {
    return clientDefinedFlag3;
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
   * getter method for client defined integer3.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger3() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer4.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger4() {
    return clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer5.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger5() {
    return clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer6.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger6() {
    return clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer7.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger7() {
    return clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer8.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger8() {
    return clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientPortfolio() {
    if ((this.getAccountDetail().getUserDefined1() != null)
          && (this.getAccountDetail().getUserDefined1().length() > 0)) {
      return this.getAccountDetail().getUserDefined1();
    }

    return null;
  }
  // NCC client portfolio Id

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientPortfolioId() {
    return this.getAccountDetail().getUserDefined1();
  }
  // NCC Card Client Program Eligibility Indicator- Not in Layout for Gen2

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientProgramEligibilityIndicator() {
    return clientDefined1CharCode7;
  }
  // NCC Card Client Program End Date

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientProgramEndDate() {
    return clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client receipt date.
   *
   * @return  Date
   */
  public Date getClientReceiptDate() {
    return clientReceiptDate;
  }
  // CMCActivationDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getCMCActivationDate() {
    return clientDefinedDate3;
  }
  // CMCActivationFlag

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getCMCActivationFlag() {
    return Boolean.TRUE.equals(clientDefinedFlag1);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method returns True or False based on the whether the customer has accepted ExpressConsent at Account Level in
   * CMC Website.
   *
   * @return  Boolean
   */
  public Boolean getCmcConsent() {
    AccountConfig c = this.getAccountConfig();

    if (c != null) {
      return (c.getCmcConsentDate() != null) ? Boolean.TRUE : Boolean.FALSE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method returns Date when the customer has accepted ExpressConsent at Account Level in CMC Debtor Site.
   *
   * @return  Date
   */
  public Date getCmcConsentDate() {
    AccountConfig c = this.getAccountConfig();

    if (c != null) {
      return c.getCmcConsentDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Payment getCMCPreviousPaymentDeclined() {
    long    today   = (new Date()).getTime();
    long    dateVal = 0;
    Payment ret     = null;

    for (Payment payment : this.payments) {
      if ((payment != null)
            && PaymentStatus.REJECTED.equals(payment.getPaymentStatus())
            && !PaymentChannel.CLIENT.equals(
              payment.getPaymentChannel())) {
        long v = -1;

        if (payment.getRejectedStatusDate() != null) {
          v = (payment.getRejectedStatusDate()).getTime();
        }

        if ((dateVal < v) && (v <= today)) {
          dateVal = v;
          ret     = payment;
        }
      }
    }

    return ret;
  } // end method getCMCPreviousPaymentDeclined

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getCMCPreviousPaymentDeclinedAmount() {
    Payment ret = getCMCPreviousPaymentDeclined();

    if (ret != null) {
      return ret.getAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getCMCPreviousPaymentDeclinedDate() {
    Payment ret = getCMCPreviousPaymentDeclined();

    if (ret != null) {
      return ret.getRejectedStatusDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cmc random digits.
   *
   * @return  Integer
   */
  public Integer getCmcRandomDigits() {
    return cmcRandomDigits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for collection costs.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCollectionCosts() {
    return collectionCosts;
  }
  // collectorExtension

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCollectorExtension() {
    return getAccountDetail().getClientDefined8CharCode1();
  }
  // collectorId

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCollectorId() {
    return getAccountDetail().getClientDefined4CharCode1();
  }
  // collectorName

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCollectorName() {
    return getAccountDetail().getClientDefined32CharCode1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for col reage counter.
   *
   * @return  Integer
   */
  public Integer getColReageCounter() {
    return colReageCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for comment activities.
   *
   * @return  Set
   */
  public Set<CommentActivity> getCommentActivities() {
    return commentActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCommercialDelinquencyHistoryString() {
    StringBuffer sb = new StringBuffer();

    if ((getTsysAccount() != null) && (getTsysAccount().getTsysPaymentHistory() != null)
          && (getTsysAccount().getTsysPaymentHistory().size() > 0)) {
      if (log.isDebugEnabled()) {
        log.debug("TsysPaymentHistory.size=" + getTsysAccount().getTsysPaymentHistory().size());
      }

      Set<TsysPaymentHistory>  tsysPaymentHistorySet  = getTsysAccount().getTsysPaymentHistory();
      List<TsysPaymentHistory> tsysPaymentHistoryList = new ArrayList<TsysPaymentHistory>();
      tsysPaymentHistoryList.addAll(tsysPaymentHistorySet);
      Collections.sort(tsysPaymentHistoryList, new Comparator<TsysPaymentHistory>() {
          @Override public int compare(TsysPaymentHistory o1, TsysPaymentHistory o2) {
            Integer seq1 = formatInteger(o1.getSequenceNumber());
            Integer seq2 = formatInteger(o2.getSequenceNumber());

            return seq1.compareTo(seq2);
          }
        });

      for (TsysPaymentHistory tsysPaymentHistory : tsysPaymentHistoryList) {
        if (!StringUtils.hasText(tsysPaymentHistory.getPastDueCategory())) {
          sb.append("0");

          continue;
        }

        sb.append(tsysPaymentHistory.getPastDueCategory());
      }
    } // end if

    if (log.isDebugEnabled()) {
      log.debug("Commercial Delinquency History: " + sb.toString());
    }

    return sb.toString();
  } // end method getCommercialDelinquencyHistoryString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for commission.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCommission() {
    return commission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for commission rate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCommissionRate() {
    return commissionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for compensation code.
   *
   * @return  Integer
   */
  public Integer getCompensationCode() {
    return compensationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getContactPhoneNumber() {
    if ((this.getDivision() != null)
          && StringUtils.hasText(
            this.getDivision().getContactPhoneNumber())) {
      return this.getDivision().getContactPhoneNumber();
    } else if (StringUtils.hasText(this.getPortfolio().getIvrPhoneNum())) {
      return this.getPortfolio().getIvrPhoneNum();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getContactSupplyAddress() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contract date.
   *
   * @return  Date
   */
  public Date getContractDate() {
    return contractDate;
  }
  // Added by Gopal on 08/09/09 for RBS Specific Fields-End
  // Added by EtisBew on 08/10/09 for RBS Specific Fields - Start

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getControl() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getControlFour() {
    return clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getControlOne() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getControlTwo() {
    return clientDefined3CharCode1;
  }
  // Cost

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cosigner responsible.
   *
   * @return  Responsible
   */
  public Responsible getCosignerResponsible() {
    for (Responsible responsible : responsibles) {
      if (CustomerType.G.equals(responsible.getCustomerType())) {
        return responsible;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getCost() {
    return clientDefinedAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getCreatedPaymentYesterday() {
    long yesterday = DateUtil.addDays(DateUtil.toDateOnly(new Date()), -1).getTime();

    for (Payment payment : this.payments) {
      if (DateUtil.toDateOnly(payment.getCreateDate()).getTime()
            == yesterday) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }
  // Added by Etisbew on 05/01/09 to get Payments for JIRA # NC-249-END
  // Added for US Bank - 90L//
  // Karthik//////////////////////////////////////////////////
  // CreditBalance

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getCreditBalance() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for credit limit.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCreditLimit() {
    return this.creditLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for credit line.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCreditLine() {
    return creditLine;
  }
  // Added by Etisbew on 09/23/2009 for JIRA # Citiau-109-Start

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getCreditLineIncreaseDate() {
    return creditLineIncreaseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * To get Minimum Due amount for CTA portfolio.
   *
   * @return  to get Minimum Due amount for CTA portfolio
   */
  public BigDecimal getCtaMinimumDue() {
    BigDecimal bucketAmount1           = getBucketAmount1();
    BigDecimal bucketAmount2           = getBucketAmount2();
    BigDecimal bucketAmount3           = getBucketAmount3();
    BigDecimal bucketAmount4           = getBucketAmount4();
    BigDecimal delinquentArrearsAmount = BigDecimal.ZERO;
    BigDecimal suggestedPaymentAmount  = BigDecimal.ZERO;

    if (getPastDue() != null) {
      delinquentArrearsAmount = getPastDue();
    }

    if (minimumPayDue != null) {
      delinquentArrearsAmount = delinquentArrearsAmount.subtract(
          minimumPayDue);
    }

    if (bucketAmount1 != null) {
      delinquentArrearsAmount = delinquentArrearsAmount.subtract(
          bucketAmount1);
    }

    if (bucketAmount2 != null) {
      delinquentArrearsAmount = delinquentArrearsAmount.subtract(
          bucketAmount2);
    }

    if (bucketAmount3 != null) {
      delinquentArrearsAmount = delinquentArrearsAmount.subtract(
          bucketAmount3);
    }

    if (bucketAmount4 != null) {
      delinquentArrearsAmount = delinquentArrearsAmount.subtract(
          bucketAmount4);
    }

    if ((delinquentArrearsAmount != null)
          && (delinquentArrearsAmount.compareTo(BigDecimal.ZERO) != 0)) {
      suggestedPaymentAmount = delinquentArrearsAmount;
    } else {
      if ((bucketAmount4 != null)
            && (bucketAmount4.compareTo(BigDecimal.ZERO) != 0)) {
        suggestedPaymentAmount = bucketAmount4;
      } else if ((bucketAmount3 != null)
            && (bucketAmount3.compareTo(BigDecimal.ZERO) != 0)) {
        suggestedPaymentAmount = bucketAmount3;
      } else if ((bucketAmount2 != null)
            && (bucketAmount2.compareTo(BigDecimal.ZERO) != 0)) {
        suggestedPaymentAmount = bucketAmount2;
      } else if ((bucketAmount1 != null)
            && (bucketAmount1.compareTo(BigDecimal.ZERO) != 0)) {
        suggestedPaymentAmount = bucketAmount1;
      } else if (minimumPayDue != null) {
        suggestedPaymentAmount = minimumPayDue;
      }
    } // end if-else

    /*
     * BigDecimal overLimit = BigDecimal.ZERO; if (getOverLimit() != null) {
     * overLimit = getOverLimit(); }
     */
    /*
     * BigDecimal oldestDelinquentAmount = BigDecimal.ZERO; if
     * (bucketAmount4 != null) { oldestDelinquentAmount = bucketAmount4; }
     * else if (bucketAmount3 != null) { oldestDelinquentAmount =
     * bucketAmount3; } else if (bucketAmount2 != null) {
     * oldestDelinquentAmount = bucketAmount2; } else if (bucketAmount1 !=
     * null) { oldestDelinquentAmount = bucketAmount1; }
     */
    // BigDecimal minDue = BigDecimal.ZERO;
    /*
     * if ((delinquentArrearsAmount.compareTo(overLimit) >= 0) &&
     * (delinquentArrearsAmount.compareTo(oldestDelinquentAmount) >= 0)) {
     * minDue = delinquentArrearsAmount; } else if
     * (overLimit.compareTo(oldestDelinquentAmount) >= 0) { minDue =
     * overLimit; } else { minDue = oldestDelinquentAmount; }
     */
    return suggestedPaymentAmount;
  } // end method getCtaMinimumDue

  //~ ------------------------------------------------------------------------------------------------------------------

  // Citi status
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCtmStatus() {
    return clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCurrencySymbol() {
    if ((this.getDivision() != null)
          && StringUtils.hasText(this.getDivision().getCurrencySymbol())) {
      return this.getDivision().getCurrencySymbol();
    } else if (StringUtils.hasText(
            this.getPortfolio().getCurrencySymbol())) {
      return this.getPortfolio().getCurrencySymbol();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCurrentDue() {
    return currentDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current pay off amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCurrentPayOffAmount() {
    BigDecimal currentPayOffAmount = (balance.compareTo(BigDecimal.ZERO) > 0)
      ? getInterestAccruedFromLastInterestDateToNow().add(accountSOR.getChargeOffPrincipal()).add(
          accountSOR.getChargeOffInterest()).add(accountSOR.getChargeOffFees1()).add(accountSOR.getChargeOffFees2())
      : BigDecimal.ZERO;

    return currentPayOffAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCurrentQueueNumber() {
    return clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getCurrentTrancheDate() {
    return accountAdditionalDetail.getClientDefinedDate13();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCurrentTrancheName() {
    return accountAdditionalDetail.getClientDefined35CharCode4();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustomData10() {
    if (this.getTsysAccountCustomData() != null) {
      return this.getTsysAccountCustomData().getCustomData10();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustomData23() {
    if (this.getTsysAccountCustomData() != null) {
      return this.getTsysAccountCustomData().getCustomData10();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustomData81() {
    if (this.getTsysAccountCustomData() != null) {
      return this.getTsysAccountCustomData().getCustomData81();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer type.
   *
   * @return  CustomerType
   */
  public CustomerType getCustomerType() {
    return customerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cycle code.
   *
   * @return  String
   */
  public String getCycleCode() {
    return this.cycleCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for daily interest amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDailyInterestAmount() {
    BigDecimal dailyInterest = ((apr != null)
        && (accountSOR.getChargeOffPrincipal().compareTo(BigDecimal.ZERO) > 0))
      ? (accountSOR.getChargeOffPrincipal().multiply(apr)).divide(BigDecimal.valueOf(365), 8,
        RoundingMode.HALF_UP) : BigDecimal.ZERO;

    return dailyInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDairyRequired() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get days from broken promise date of this account.
   *
   * @return  get days from broken promise date of this account
   */
  public Integer getDaysFromBrokenPromiseDate() {
    Date d = getMostRecentBrokenPromiseDate();

    if (d != null) {
      return DateUtil.getDayDifference(new Date(), d);
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get days from charge off date of this account.
   *
   * @return  get days from charge off date of this account
   */
  public Integer getDaysFromChargeOffDate() {
    if (chargeOffDate != null) {
      return DateUtil.getDayDifference(new Date(), chargeOffDate);
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get days from last contact of this account.
   *
   * @return  get days from last contact of this account
   */
  public int getDaysFromLastContact() {
    if (lastContactDate != null) {
      return DateUtil.getDayDifference(new Date(), lastContactDate);
    } else {
      return DateUtil.getDayDifference(new Date(), createDate);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get days from last payment date of this account.
   *
   * @return  get days from last payment date of this account
   */
  public Integer getDaysFromLastPayDate() {
    if (lastPayDate != null) {
      return DateUtil.getDayDifference(new Date(), lastPayDate);
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get days from next work date of this account.
   *
   * @return  get days from next work date of this account
   */
  public Integer getDaysFromNextWorkDate() {
    if (nextWorkDate != null) {
      return DateUtil.getDayDifference(new Date(), nextWorkDate);
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDaysSinceChargeOff() {
    if (chargeOffDate != null) {
      return DateUtil.getDayDifference(new Date(), chargeOffDate, false);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for days since last collection.
   *
   * @return  Integer
   */
  public Integer getDaysSinceLastCollection() {
    return daysSinceLastCollection;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * ClientDefinedDate5.
   *
   * @return  clientDefinedDate5
   */
  public Date getDeActivateDate() {
    return clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deactivated reason.
   *
   * @return  String
   */
  public String getDeactivatedReason() {
    return deactivatedReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dealer code.
   *
   * @return  String
   */
  public String getDealerCode() {
    return dealerCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for debt type.
   *
   * @return  String
   */
  public String getDebtType() {
    return debtType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default responsible.
   *
   * @return  Responsible
   */
  public Responsible getDefaultResponsible() {
    if (this.defaultResponsible == null) {
      if (responsibles == null) {
        return null;
      }

      Responsible first          = null;
      Responsible firstBySeqNum  = null;
      Responsible firstByPrimary = null;

      for (Responsible responsible : responsibles) {
        if (first == null) {
          // default set to the first responsible
          first = responsible;
        }

        // try to find the first primary responsible
        if (firstByPrimary == null) {
          if ((responsible.getPrimaryHolder() != null)
                && Boolean.TRUE.equals(
                  responsible.getPrimaryHolder())) {
            firstByPrimary = responsible;
          }
        }

        if (firstBySeqNum == null) {
          if ((responsible.getSequenceNum() != null)
                && (responsible.getSequenceNum() == 0)) {
            firstBySeqNum = responsible;
          }
        }
      } // end for

      if (firstBySeqNum != null) {
        this.defaultResponsible = firstBySeqNum;
      } else if (firstByPrimary != null) {
        this.defaultResponsible = firstByPrimary;
      } else {
        this.defaultResponsible = first;
      }
    } // end if

    return this.defaultResponsible;
  } // end method getDefaultResponsible

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency date.
   *
   * @return  Date
   */
  public Date getDelinquencyDate() {
    return delinquencyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency days.
   *
   * @return  Integer
   */
  public Integer getDelinquencyDays() {
    return delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<Integer, DelinquencyHistory> getDelinquencyHistory() {
    return delinquencyHistory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDelinquencyHistoryString() {
    StringBuffer sb = new StringBuffer();

    for (int i = 1; i < 13; i++) {
      DelinquencyHistory history = delinquencyHistory.get(i);

      if ((history != null) && (history.getLevelAltPastDue() != null) && (history.getLevelAltPastDue() > 0)) {
        if (history.getLevelAltPastDue() == 10) {
          sb.append("A");
        } else if (history.getLevelAltPastDue() == 11) {
          sb.append("B");
        } else if (history.getLevelAltPastDue() == 12) {
          sb.append("C");
        } else {
          sb.append(history.getLevelAltPastDue());
        }
      } else {
        sb.append("0");
      }
    }

    return sb.toString();
  } // end method getDelinquencyHistoryString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency reason code.
   *
   * @return  String
   */
  public String getDelinquencyReasonCode() {
    return delinquencyReasonCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency stage.
   *
   * @return  Integer
   */
  public Integer getDelinquencyStage() {
    BigDecimal z0 = new BigDecimal("0");

    if (delinquencyStage == null) {
      if ((bucketAmount7 != null) && (bucketAmount7.compareTo(z0) > 0)) {
        return 7;
      }

      if ((bucketAmount6 != null) && (bucketAmount6.compareTo(z0) > 0)) {
        return 6;
      }

      if ((bucketAmount5 != null) && (bucketAmount5.compareTo(z0) > 0)) {
        return 5;
      }

      if ((bucketAmount4 != null) && (bucketAmount4.compareTo(z0) > 0)) {
        return 4;
      }

      if ((bucketAmount3 != null) && (bucketAmount3.compareTo(z0) > 0)) {
        return 3;
      }

      if ((bucketAmount2 != null) && (bucketAmount2.compareTo(z0) > 0)) {
        return 2;
      }

      if ((bucketAmount1 != null) && (bucketAmount1.compareTo(z0) > 0)) {
        return 1;
      }

      return null;
    } // end if

    return delinquencyStage;
  } // end method getDelinquencyStage

  //~ ------------------------------------------------------------------------------------------------------------------

  // DFS Active Month Count
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDFSActiveMonthCount() {
    return clientDefinedInteger1;
  }
  // DFS Agent Number

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDFSAgentNumber() {
    return clientDefinedInteger5;
  }
  // DFS Chargeoff Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDFSChargeOffScore() {
    return clientDefinedInteger2;
  }
  // DFS Charge roll score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDFSChargeRollScore() {
    return clientDefinedInteger3;
  }
  // DFS EXTERNAL STATUS CODE

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDFSExternalStatusCode() {
    return clientDefined1CharCode1;
  }
  // DFS internal status code

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDFSInternalStatusCode() {
    return clientDefined1CharCode2;
  }
  // DFS LTPR Score1

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDFSLTPRScore1() {
    return clientDefinedInteger7;
  }
  // DFS LTPR Score1

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDFSLTPRScore2() {
    return clientDefinedInteger8;
  }
  // DFS Overlimit Amount

  //~ ------------------------------------------------------------------------------------------------------------------

  // DFS Non Tran Score
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDFSNonTranScore() {
    return clientDefinedInteger4;
  }
  // DFS OLPM Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDFSOLPMScore() {
    return clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DFS overlimit monthly amount.
   *
   * @return  dFS overlimit monthly amount
   */
  public BigDecimal getDfsOverlimitMonthlyAmount() {
    return roundAmount(
        ((balance.subtract(this.creditLimit)).divide(
            new BigDecimal("11.0"), 3, BigDecimal.ROUND_HALF_UP)).add(
          (balance.multiply(new BigDecimal("0.1299"))).divide(
            new BigDecimal("12.0"), 3,
            BigDecimal.ROUND_HALF_UP)), RoundType.CENTS_UP);
  }
  // End of Citi
  // Field used in DFS - Discover

  //~ ------------------------------------------------------------------------------------------------------------------

  // DFS Process Code
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDFSProcessCode() {
    return clientDefined6CharCode1;
  }
  // DFS Program Status

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDFSProgramStatus() {
    return clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<DialerActivity> getDialerActivitiesFromDialerChannelResults() {
    List<DialerActivity> ret = new ArrayList<DialerActivity>();

    for (DialerChannelResult channelResult : exportedDialerResults) {
      DialerActivity dialerActivity = new DialerActivity();
      dialerActivity.setAccount(this);
      dialerActivity.setResponsible(channelResult.getResponsible());
      dialerActivity.setBalance(channelResult.getBalance());
      dialerActivity.setDelinquencyDays(getDelinquencyDays());
      dialerActivity.setStatus(channelResult.getStatus().toString());
      dialerActivity.setCreateDate(channelResult.getCreateDate());
      dialerActivity.setExecuteDate(channelResult.getExportDate());
      ret.add(dialerActivity);
    }

    for (DialerChannelResult channelResult : executedDialerResults) {
      DialerActivity dialerActivity = new DialerActivity();
      dialerActivity.setAccount(this);
      dialerActivity.setResponsible(channelResult.getResponsible());
      dialerActivity.setBalance(channelResult.getBalance());
      dialerActivity.setDelinquencyDays(getDelinquencyDays());
      dialerActivity.setPhoneNumber(channelResult.getPhoneNumber());
      dialerActivity.setResult(channelResult.getExecuteResult());
      dialerActivity.setStatus(channelResult.getStatus().toString());
      dialerActivity.setCreateDate(channelResult.getCreateDate());
      dialerActivity.setExecuteDate(channelResult.getExecuteDate());
      ret.add(dialerActivity);
    }

    return ret;
  } // end method getDialerActivitiesFromDialerChannelResults

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disallow web reason.
   *
   * @return  String
   */
  public String getDisallowWebReason() {
    return disallowWebReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDisplayAccountOverallStatusCodes() {
    AccountOverallStatus accountOverallStatus = getAccountOverallStatus();

    if (portfolio.getClient().getClientId().equals(42L)) {
      // Map COFS Account Status to FDR codes
      if (accountOverallStatus == null) {
        return "";
      }

      String code = COFSConstants.cofsStatusMap.get(
          accountOverallStatus.getAccountOverallStatusCode());

      if (StringUtils.hasText(code)) {
        return code;
      }

      return "";
    } // end if

    if (accountOverallStatus == null) {
      return "";
    }

    if (accountOverallStatus.getAccountOverallStatusDetail() == null) {
      return "N/A";
    }

    return accountOverallStatus.getAccountOverallStatusDetail().getStatusCode();
  } // end method getDisplayAccountOverallStatusCodes

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Account status codes for display only.
   *
   * @return  Account status codes for display only.
   */
  public String getDisplayAccountStatusCodes() {
    if (portfolio.getClient().getClientId().equals(42L)) {
      // Map COFS Account Status to FDR codes
      if ((accountStatuses == null) || (accountStatuses.size() == 0)) {
        return "";
      }

      AccountStatus accountStatus = getMostRecentActiveAccountStatus();

      if (accountStatus == null) {
        return "";
      }

      String code = COFSConstants.cofsStatusMap.get(
          accountStatus.getAccountStatusCode());

      if (StringUtils.hasText(code)) {
        return code;
      }

      return "";
        /*
         * for (AccountStatus accountStatus : accountStatuses) { String code
         * = COFSConstants.cofsStatusMap.get(accountStatus
         * .getAccountStatusCode()); if (StringUtils.hasText(code)) { if
         * (StringUtils.hasText(retVal)) retVal = retVal + "," + code; else
         * retVal = code; } }
         */
    } // end if

    return StringUtils.arrayToCommaDelimitedString(getAccountStatusCodes());
  } // end method getDisplayAccountStatusCodes

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for division.
   *
   * @return  Division
   */
  public Division getDivision() {
    return division;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<DocumentHistory> getDocumentHistories() {
    return documentHistories;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<Document> getDocuments() {
    return documents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * NCC ASAP Project.
   *
   * @return  nCC ASAP Project
   */
  public BigDecimal getDTI() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getElan25() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 16235L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getElan25Jan() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 17195L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getElan35() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 16233L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getElan35Jan() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 17193L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getElan45() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 16231L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getElan45Jan() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 17191L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getElan55() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 16259L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getElan65gt30Days() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 16229L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getElan65lt30Days() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 16239L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getElectricityValue() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getElectricMeterNumber() {
    return clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getElectricMeterReadingRegOne() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getElectricMeterReadingRegTwo() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getElectricReadingType() {
    return clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getElectricReferenceNumber() {
    return clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get eligible programs in INIT status, ProgramAction.WebOffer is not considered. See getWebEligiblePaymentPrograms()
   * for eligible programs only for web
   *
   * @return  DOCUMENT ME!
   */
  public List<PaymentProgram> getEligiblePaymentPrograms() {
    List<PaymentProgram> programs = new ArrayList<PaymentProgram>();

    // Find all payment programs after start order index, inclusive. Sort is
    // needed because new programs may just be added
    // and not persisted yet.
    Iterator it = paymentPrograms.iterator();

    while (it.hasNext()) {
      PaymentProgram program       = (PaymentProgram) it.next();
      Integer        order         = program.getProgramOrder();
      ProgramAction  programAction = program.getProgramAction();

      if ((order >= this.programStartIndex)
            && program.isInEffect()
            && ProgramStatus.INIT.equals(program.getProgramStatus())) {
        programs.add(program);
      }
    }

    Collections.sort(programs);

    // Remove redundant programs
    if (programs.size() > this.portfolio.getTotalProgramShown()) {
      programs.subList(this.portfolio.getTotalProgramShown(),
        programs.size()).clear();
    }

    return programs;
  } // end method getEligiblePaymentPrograms

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AccountEligibleProgram> getEligiblePrograms() {
    return eligiblePrograms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<EmailActivity> getEmailActivitiesFromEmailChannelResults() {
    List<EmailActivity> ret = new ArrayList<EmailActivity>();

    for (EmailChannelResult channelResult : executedEmailResults) {
      EmailActivity emailActivity = new EmailActivity();
      emailActivity.setAccount(this);
      emailActivity.setResponsible(channelResult.getResponsible());
      emailActivity.setBalance(channelResult.getBalance());
      emailActivity.setDelinquencyDays(getDelinquencyDays());
      emailActivity.setEmailAddress(channelResult.getEmailAddress());
      emailActivity.setTemplate(channelResult.getTemplate());
      emailActivity.setStatus(channelResult.getStatus().toString());
      emailActivity.setCreateDate(channelResult.getCreateDate());
      emailActivity.setExecuteDate(channelResult.getExecuteDate());
      ret.add(emailActivity);
    }

    return ret;
  }
  // employeeFlag

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getEmployeeFlag() {
    return (clientDefinedFlag2 != null) ? clientDefinedFlag2 : false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entry balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getEntryBalance() {
    return this.entryBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entry charge off amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getEntryChargeOffAmount() {
    return this.entryChargeOffAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entry date.
   *
   * @return  Date
   */
  public Date getEntryDate() {
    return entryDate;
  }
  // DFS Exception Status 1

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExceptionStatus1() {
    return clientDefined4CharCode1;
  }
  // DFS Exception Status 2

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExceptionStatus2() {
    return clientDefined4CharCode2;
  }
  // DFS Exception Status 3

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExceptionStatus3() {
    return clientDefined4CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for executed dialer results.
   *
   * @return  Set
   */
  public Set<DialerChannelResult> getExecutedDialerResults() {
    return executedDialerResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for executed email results.
   *
   * @return  Set
   */
  public Set<EmailChannelResult> getExecutedEmailResults() {
    return executedEmailResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for executed ivr results.
   *
   * @return  Set
   */
  public Set<IvrChannelResult> getExecutedIvrResults() {
    return executedIvrResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for executed sms results.
   *
   * @return  Set
   */
  public Set<SmsChannelResult> getExecutedSmsResults() {
    return executedSmsResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ExpenseAudit getExpenseAudit() {
    return expenseAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for expenses.
   *
   * @return  Set
   */
  public Set<Expense> getExpenses() {
    return expenses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exported dialer results.
   *
   * @return  Set
   */
  public Set<DialerChannelResult> getExportedDialerResults() {
    return exportedDialerResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exported email results.
   *
   * @return  Set
   */
  public Set<EmailChannelResult> getExportedEmailResults() {
    return exportedEmailResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exported ivr results.
   *
   * @return  Set
   */
  public Set<IvrChannelResult> getExportedIvrResults() {
    return exportedIvrResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exported letter results.
   *
   * @return  Set
   */
  public Set<LetterChannelResult> getExportedLetterResults() {
    return exportedLetterResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exported sms results.
   *
   * @return  Set
   */
  public Set<SmsChannelResult> getExportedSmsResults() {
    return exportedSmsResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for express consent code.
   *
   * @return  String
   */
  public String getExpressConsentCode() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getFeeOutstanding() {
    return feeOutstanding;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFinalInstallmentPaymentStatus() {
    if (this.acceptedProgram != null) {
      PaymentProgramInstallment installment = acceptedProgram.getFinalInstallment();

      if (installment != null) {
        return installment.getInstallmentPaymentStatus().toString();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFinalInstallmentStatus() {
    if (this.acceptedProgram != null) {
      PaymentProgramInstallment installment = acceptedProgram.getFinalInstallment();

      if (installment != null) {
        return installment.getInstallmentStatus().toString();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for financial adjustments.
   *
   * @return  Set
   */
  public Set<FinancialAdjustment> getFinancialAdjustments() {
    return financialAdjustments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first agency placement date.
   *
   * @return  Date
   */
  public Date getFirstAgencyPlacementDate() {
    return firstAgencyPlacementDate;
  }
  // firstCMCActivationDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getFirstCMCActivationDate() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Responsible getFirstCoMaker() {
    if (responsibles == null) {
      return null;
    }

    // Check if only one responsible
    if (responsibles.size() == 1) {
      return null;
    }

    // Find the first primary==false holder
    boolean hasPrimary = false;

    for (Responsible responsible : responsibles) {
      if (Boolean.FALSE.equals(responsible.getPrimaryHolder())) {
        return responsible;
      } else if (Boolean.TRUE.equals(responsible.getPrimaryHolder())) {
        hasPrimary = true;
      }
    }

    // If has primary, find the first non-primary holder
    if (hasPrimary) {
      for (Responsible responsible : responsibles) {
        if (!Boolean.TRUE.equals(responsible.getPrimaryHolder())) {
          return responsible;
        }
      }
    } else {
      // No primary, but has more than one holder. Get the second holder
      // by
      // natural holder
      Iterator<Responsible> it = responsibles.iterator();

      if (it.hasNext()) {
        it.next();
      }

      if (it.hasNext()) {
        return it.next();
      }
    }

    // no co maker
    return null;
  } // end method getFirstCoMaker

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first dialer date.
   *
   * @return  Date
   */
  public Date getFirstDialerDate() {
    return firstDialerDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first email date.
   *
   * @return  Date
   */
  public Date getFirstEmailDate() {
    return firstEmailDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first ivr date.
   *
   * @return  Date
   */
  public Date getFirstIvrDate() {
    return firstIvrDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first letter date.
   *
   * @return  Date
   */
  public Date getFirstLetterDate() {
    return firstLetterDate;
  }
  // Field used in Citi - Citi Mortgage

  //~ ------------------------------------------------------------------------------------------------------------------

  // Citi 1mtgPrincipalBalance - Not Used for Apr-24
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getFirstMortgagePrincipalBalance() {
    return clientDefinedAmount1;
  }
  // firstPaymentDueDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getFirstPaymentDueDate() {
    return clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Payment getFirstPaymentForDay() {
    Payment payment  = null;
    Date    fromDate = DateUtil.getYesterday();
    Date    toDate   = DateUtil.getToday();

    for (Payment p : this.getPayments()) {
      if (p.getCreateDate().after(fromDate)
            && p.getCreateDate().before(toDate)) {
        if (PaymentStatus.INPROCESS.equals(p.getPaymentStatus())
              || PaymentStatus.SCHEDULED.equals(p.getPaymentStatus())) {
          if (payment == null) {
            payment = p;

            continue;
          }

          if (payment.getCreateDate().before(p.getCreateDate())) {
            continue;
          } else {
            payment = p;
          }
        }
      }
    }

    return payment;
  } // end method getFirstPaymentForDay

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first sms date.
   *
   * @return  Date
   */
  public Date getFirstSmsDate() {
    return firstSmsDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fixed payment amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFixedPaymentAmount() {
    return fixedPaymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fourth agency placement date.
   *
   * @return  Date
   */
  public Date getFourthAgencyPlacementDate() {
    return fourthAgencyPlacementDate;
  }
  // NCC Card Frontend Risk Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFrontendRiskScore() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the furthest of all future appt. If no future appt, returns null.
   *
   * @return  get the furthest of all future appt.
   */
  public AdvisorAppointment getFurthestAppointment() {
    AdvisorAppointment ret      = null;
    Date               apptDate = null;

    for (AdvisorAppointment a : appointments) {
      if (a.getAppointmentDateTime().after(new Date())) {
        if ((apptDate == null)
              || a.getAppointmentDateTime().after(apptDate)) {
          apptDate = a.getAppointmentDateTime();
          ret      = a;
        }
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the furthest future payment that does not belong to a payment program.
   *
   * @return  get the furthest future payment that does not belong to a payment program.
   */
  public Payment getFurthestNonProgramPayment() {
    Payment ret         = null;
    Date    paymentDate = null;

    for (Payment payment : payments) {
      if (PaymentStatus.SCHEDULED.equals(payment.getPaymentStatus())
            && (payment.getPaymentProgram() == null)) {
        if ((paymentDate == null)
              || paymentDate.before(payment.getPaymentDate())) {
          paymentDate = payment.getPaymentDate();
          ret         = payment;
        }
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the furthest future payment. If no future (scheduled) payment, returns null.
   *
   * @return  get the furthest future payment.
   */
  public Payment getFurthestPayment() {
    Payment ret         = null;
    Date    paymentDate = null;

    for (Payment payment : payments) {
      if (PaymentStatus.SCHEDULED.equals(payment.getPaymentStatus())) {
        if ((paymentDate == null)
              || paymentDate.before(payment.getPaymentDate())) {
          paymentDate = payment.getPaymentDate();
          ret         = payment;
        }
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the furthest promise to pay.
   *
   * @return  get the furthest promise to pay
   */
  public PromiseToPay getFurthestPromiseToPay() {
    Set<PromiseToPay> promiseToPaySet = getPromises();

    if ((promiseToPaySet != null) && (promiseToPaySet.size() > 0)) {
      return promiseToPaySet.toArray(new PromiseToPay[] {})[promiseToPaySet.size() - 1];
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the furthest Promise To Pay payment amount - exposed as a variable in RUA.
   *
   * @return  get the furthest promise to pay
   */
  public BigDecimal getFurthestPromiseToPayAmount() {
    if (getFurthestPromiseToPay() != null) {
      return getFurthestPromiseToPay().getPaymentAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the furthest promise to pay arrival date - exposed as a variable in RUA.
   *
   * @return  get the furthest promise to pay
   */
  public Date getFurthestPromiseToPayArrivalDate() {
    if (getFurthestPromiseToPay() != null) {
      return getFurthestPromiseToPay().getArrivalDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the furthest promise to pay arrival date - exposed as a variable in RUA.
   *
   * @return  get the furthest promise to pay
   */
  public Date getFurthestPromiseToPaySendDate() {
    if (getFurthestPromiseToPay() != null) {
      return getFurthestPromiseToPay().getSendDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns a list of all PromiseToPays which are statused as FUTURE.
   *
   * @return  DOCUMENT ME!
   */
  public List<PromiseToPay> getFuturePromises() {
    Set<PromiseToPay>  promiseToPaySet  = getPromises();
    List<PromiseToPay> promiseToPayList = new ArrayList<PromiseToPay>();

    if ((promiseToPaySet != null) && (promiseToPaySet.size() > 0)) {
      for (PromiseToPay promise : promiseToPaySet) {
        if (log.isDebugEnabled()) {
          log.debug("getFuturePromises() :: promiseStatus: "
            + promise.getPtpStatus());
        }

        if (PromiseToPayStatus.FUTURE.equals(promise.getPtpStatus())) {
          promiseToPayList.add(promise);
        }
      }
    }

    return promiseToPayList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGasMeterNumber() {
    return clientDefined20CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getGasReading() {
    return clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGasReadingType() {
    return clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getGasReferenceNumber() {
    return clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getGasValue() {
    return clientDefinedDecimal2;
  }
  // NCC Card Hardcore Risk Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHardcoreRiskScore() {
    return clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasAcceptedBblProgram() {
    Boolean hasBarclayProgram = null;

    if (this.barclayAccount != null) {
      hasBarclayProgram = this.barclayAccount.getHasBarclayProgram();
    }

    return Boolean.TRUE.equals(hasBarclayProgram);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the flag which the account has accepted any program.
   *
   * @return  get the flag which the account has accepted any program
   */
  public boolean getHasAcceptedProgram() {
    return (acceptedProgram != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasBrokenProgramPromise() {
    if (this.acceptedProgram != null) {
      return this.acceptedProgram.getHasBrokenPromise();
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDateStr  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasBrokenPromiseToPayAfterArrivalDate(String fromDateStr) {
    Date fromDate = getDate(fromDateStr, "MM/dd/yyyy");

    if (fromDate != null) {
      List<PromiseToPay> brokenPTPList = getPromisesWithStatusFromArrivalDate(PromiseToPayStatus.BROKEN, fromDate);

      if ((brokenPTPList != null) && (brokenPTPList.size() > 0)) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDate  Start Date from which Broken PTPs are searched for
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasBrokenPromiseToPayByDate(Date fromDate) {
    List<PromiseToPay> brokenPTPList = getPromisesWithStatusFromArrivalDate(PromiseToPayStatus.BROKEN, fromDate);

    if ((brokenPTPList != null) && (brokenPTPList.size() > 0)) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasClientScheduledPayment() {
    long today = (DateUtil.toDateOnly(new Date())).getTime();

    for (Payment payment : this.payments) {
      if ((payment != null) && PaymentChannel.CLIENT.equals(payment.getPaymentChannel())
            && PaymentStatus.SCHEDULED.equals(
              payment.getPaymentStatus())) {
        long v = (payment.getPaymentDate()).getTime();

        if (v >= today) {
          return Boolean.TRUE;
        }
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasCMCScheduledPayment() {
    long today = (DateUtil.toDateOnly(new Date())).getTime();

    for (Payment payment : this.payments) {
      if ((payment != null) && payment.isCMCWebPayment()
            && PaymentStatus.SCHEDULED.equals(
              payment.getPaymentStatus())) {
        long v = (payment.getPaymentDate()).getTime();

        if (v >= today) {
          return Boolean.TRUE;
        }
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDateStr  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasDeletedPromiseToPay(String fromDateStr) {
    Date fromDate = getDate(fromDateStr, "MM/dd/yyyy");

    if (fromDate != null) {
      List<PromiseToPay> deletedPTPList = getPromisesWithStatusFromArrivalDate(PromiseToPayStatus.DELETED, fromDate);

      if ((deletedPTPList != null) && (deletedPTPList.size() > 0)) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDate  Start Date from which Deleted PTPs are searched for
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasDeletedPromiseToPayByDate(Date fromDate) {
    List<PromiseToPay> deletedPTPList = getPromisesWithStatusFromArrivalDate(PromiseToPayStatus.DELETED, fromDate);

    if ((deletedPTPList != null) && (deletedPTPList.size() > 0)) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasFutureScheduledAppointment() {
    if ((appointments != null) && (appointments.size() > 0)) {
      for (AdvisorAppointment a : appointments) {
        if (a.getAppointmentDateTime().after(new Date())) {
          return Boolean.TRUE;
        }
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasFutureWebPayment() {
    return getNextWebPayment() != null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDateStr  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasKeptPromiseToPay(String fromDateStr) {
    Date fromDate = getDate(fromDateStr, "MM/dd/yyyy");

    if (fromDate != null) {
      List<PromiseToPay> keptPTPList = getPromisesWithStatusFromArrivalDate(PromiseToPayStatus.KEPT, fromDate);

      if ((keptPTPList != null) && (keptPTPList.size() > 0)) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDate  Start Date from which Outstanding PTPs are searched for
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasKeptPromiseToPayAfterArrivalDate(Date fromDate) {
    List<PromiseToPay> keptPTPList = getPromisesWithStatusFromArrivalDate(PromiseToPayStatus.KEPT, fromDate);

    if ((keptPTPList != null) && (keptPTPList.size() > 0)) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   template  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasLetterBeenSent(String template) {
    if ((exportedLetterResults == null) || (exportedLetterResults.size() == 0)) {
      return Boolean.FALSE;
    }

    for (LetterChannelResult letterChannelResult : exportedLetterResults) {
      if (template.equalsIgnoreCase(letterChannelResult.getTemplate())) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns true if the customer made a web payment. Note that "scheduled" payment does not count. This method only
   * looks at payments with status "PAID" or "INPROCESS".
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasMadeWebPayment() {
    long    today = (new Date()).getTime();
    Payment ret   = null;

    for (Payment payment : this.payments) {
      if ((payment != null) && payment.isCMCWebPayment()
            && (PaymentStatus.PAID.equals(payment.getPaymentStatus())
              || PaymentStatus.INPROCESS.equals(
                payment.getPaymentStatus()))) {
        long v = (payment.getPaymentDate()).getTime();

        if (v <= today) {
          ret = payment;
        }
      }
    }

    return ret != null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDateStr  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasMultipleBrokenPromiseToPay(String fromDateStr) {
    Date fromDate = getDate(fromDateStr, "MM/dd/yyyy");

    if (fromDate != null) {
      List<PromiseToPay> brokenPTPList = getPromisesWithStatusFromArrivalDate(PromiseToPayStatus.BROKEN, fromDate);

      if ((brokenPTPList != null) && (brokenPTPList.size() > 1)) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDate  Start Date from which Broken PTPs are searched for
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasMultipleBrokenPromiseToPayByDate(Date fromDate) {
    List<PromiseToPay> brokenPTPList = getPromisesWithStatusFromArrivalDate(PromiseToPayStatus.BROKEN, fromDate);

    if ((brokenPTPList != null) && (brokenPTPList.size() > 1)) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDateStr  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasMultipleDeletedPromiseToPay(String fromDateStr) {
    Date fromDate = getDate(fromDateStr, "MM/dd/yyyy");

    if (fromDate != null) {
      List<PromiseToPay> deletedPTPList = getPromisesWithStatusFromArrivalDate(PromiseToPayStatus.DELETED, fromDate);

      if ((deletedPTPList != null) && (deletedPTPList.size() > 1)) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDate  Start Date from which Outstanding PTPs are searched for
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasMultipleDeletedPromiseToPayByDate(Date fromDate) {
    List<PromiseToPay> deletedPTPList = getPromisesWithStatusFromArrivalDate(PromiseToPayStatus.DELETED, fromDate);

    if ((deletedPTPList != null) && (deletedPTPList.size() > 1)) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDateStr  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasMultipleKeptPromiseToPay(String fromDateStr) {
    Date fromDate = getDate(fromDateStr, "MM/dd/yyyy");

    if (fromDate != null) {
      List<PromiseToPay> keptPTPList = getPromisesWithStatusFromArrivalDate(PromiseToPayStatus.KEPT, fromDate);

      if ((keptPTPList != null) && (keptPTPList.size() > 1)) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDate  Start Date from which Outstanding PTPs are searched for
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasMultipleKeptPromiseToPayByDate(Date fromDate) {
    List<PromiseToPay> keptPTPList = getPromisesWithStatusFromArrivalDate(PromiseToPayStatus.KEPT, fromDate);

    if ((keptPTPList != null) && (keptPTPList.size() > 1)) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDateStr  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasMultipleOutstandingPromiseToPay(String fromDateStr) {
    Date fromDate = getDate(fromDateStr, "MM/dd/yyyy");

    if (fromDate != null) {
      List<PromiseToPay> outstandingPTPList = getOutstandingOrFuturePromisesFromDate(fromDate);

      if ((outstandingPTPList != null) && (outstandingPTPList.size() > 1)) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDate  Start Date from which Outstanding PTPs are searched for
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasMultipleOutstandingPromiseToPayByDate(Date fromDate) {
    List<PromiseToPay> outstandingPTPList = getOutstandingOrFuturePromisesFromDate(fromDate);

    if ((outstandingPTPList != null) && (outstandingPTPList.size() > 1)) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the flag that there is no contact for this account.
   *
   * @return  get the flag that there is no contact for this account
   */
  public boolean getHasNoAccountContact() {
    return (this.lastContactDate == null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getHasOutstandingPayment() {
    for (Payment payment : this.payments) {
      if (PaymentStatus.INPROCESS.equals(payment.getPaymentStatus())
            || PaymentStatus.SCHEDULED.equals(
              payment.getPaymentStatus())) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasOutstandingPromiseToPay() {
    return hasOutstandingPromiseToPay();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDateStr  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasOutstandingPromiseToPay(String fromDateStr) {
    Date fromDate = getDate(fromDateStr, "MM/dd/yyyy");

    if (fromDate != null) {
      List<PromiseToPay> outstandingPTPList = getOutstandingOrFuturePromisesFromDate(fromDate);

      if ((outstandingPTPList != null) && (outstandingPTPList.size() > 0)) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fromDate  Start Date from which Outstanding PTPs are searched for
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasOutstandingPromiseToPayByDate(Date fromDate) {
    List<PromiseToPay> outstandingPTPList = getOutstandingOrFuturePromisesFromDate(fromDate);

    if ((outstandingPTPList != null) && (outstandingPTPList.size() > 0)) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the flag which the account has any payment program. Please note that this could include expired or inactive
   * payemnt program.
   *
   * @return  get the flag which the account has any payment program.
   */
  public Boolean getHasPaymentProgram() {
    if (paymentPrograms == null) {
      return Boolean.FALSE;
    }

    return new Boolean(this.paymentPrograms.size() > 0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   typeName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasPaymentProgramType(String typeName) {
    for (PaymentProgram program : this.paymentPrograms) {
      if ((program != null) && program.isInEffect()
            && (program.getType() != null)
            && program.getType().getName().equalsIgnoreCase(typeName)) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasScheduledPaymentAfterChargeOffDate() {
    return getHasScheduledPaymentAfter(chargeOffDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasScheduledPaymentAfterDueDate() {
    return getHasScheduledPaymentAfter(paymentDueDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getHasUPCAcceptedProgram() {
    String acceptedOffer = null;

    if (this.accountDetail != null) {
      acceptedOffer = this.accountDetail.getClientDefined5CharCode2();
    }

    return (StringUtils.hasText(acceptedOffer) && (this.acceptedProgram == null) && (this.acceptProgramDate == null));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return true if a valid payment program exists.
   *
   * @return  return true if a valid payment program exists.
   */
  public Boolean getHasValidPaymentProgram() {
    if (paymentPrograms == null) {
      return Boolean.FALSE;
    }

    for (PaymentProgram p : paymentPrograms) {
      if (!Boolean.FALSE.equals(p.getActive())) {
        if (p.getExpirationDate() == null) {
          return Boolean.TRUE;
        } else if (CompareUtil.compareDateOnly(new Date(),
                p.getExpirationDate()) <= 0) {
          return Boolean.TRUE;
        }
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if this account has a payment program with a type that matches the given name.
   *
   * @param   name  DOCUMENT ME!
   *
   * @return  check if this account has a payment program with a type that matches the given name
   */
  public Boolean getHasValidPaymentProgram(final String name) {
    if (!StringUtils.hasText(name)) {
      return this.getHasValidPaymentProgram();
    }

    for (PaymentProgram p : paymentPrograms) {
      if (name.equalsIgnoreCase(p.getType().toString())) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for heloc.
   *
   * @return  AccountHeloc
   */
  public AccountHeloc getHeloc() {
    return heloc;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical account statuses.
   *
   * @return  Set
   */
  public Set<AccountStatus> getHistoricalAccountStatuses() {
    return historicalAccountStatuses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Expense getHOAExpense() {
    // return the sum expense from expenses
    Expense            expense;
    ArrayList<Expense> expenses = new ArrayList<Expense>();
    expenses.addAll(this.getExpenses());
    expense = expenses.get(0);

    for (int i = 1; i < expenses.size(); i++) {
      if (expenses.get(i).getLastUpdateDate().compareTo(
              expense.getLastUpdateDate()) > 0) {
        expense = expenses.get(i);
      }
    }

    return expense;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Income getHOAIncome() {
    // return the sum income from incomes
    Income                 income             = new Income();
    BigDecimal             monthlyTakeHomePay = new BigDecimal(0.0);
    BigDecimal             bonusIncome        = new BigDecimal(0.0);
    BigDecimal             unemployment       = new BigDecimal(0.0);
    BigDecimal             disability         = new BigDecimal(0.0);
    BigDecimal             childSupport       = new BigDecimal(0.0);
    BigDecimal             alimony            = new BigDecimal(0.0);
    BigDecimal             netRentalIncome    = new BigDecimal(0.0);
    BigDecimal             plan401K           = new BigDecimal(0.0);
    BigDecimal             stocksBonds        = new BigDecimal(0.0);
    String                 other1;
    String                 other2;
    String                 other3;
    String                 other4;
    String                 other5;
    String                 other6;
    BigDecimal             other1Amount       = new BigDecimal(0.0);
    BigDecimal             other2Amount       = new BigDecimal(0.0);
    BigDecimal             other3Amount       = new BigDecimal(0.0);
    BigDecimal             other4Amount       = new BigDecimal(0.0);
    BigDecimal             other5Amount       = new BigDecimal(0.0);
    BigDecimal             other6Amount       = new BigDecimal(0.0);
    String                 borrowerPosition;
    ArrayList<Responsible> responsibles       = new ArrayList<Responsible>();
    responsibles.addAll(this.getResponsibles());

    for (int i = 0; i < responsibles.size(); i++) {
      monthlyTakeHomePay.add(responsibles.get(i).getHOAIncome().getMonthlyTakeHomePay());
      bonusIncome.add(responsibles.get(i).getHOAIncome().getBonusIncome());
      unemployment.add(responsibles.get(i).getHOAIncome().getUnemployment());
      disability.add(responsibles.get(i).getHOAIncome().getDisability());
      childSupport.add(responsibles.get(i).getHOAIncome().getChildSupport());
      alimony.add(responsibles.get(i).getHOAIncome().getAlimony());
      netRentalIncome.add(responsibles.get(i).getHOAIncome().getNetRentalIncome());
      plan401K.add(responsibles.get(i).getHOAIncome().getMonthlyTakeHomePay());
      stocksBonds.add(responsibles.get(i).getHOAIncome().getStocksBonds());
      other1Amount.add(responsibles.get(i).getHOAIncome().getOther1Amount());
      other2Amount.add(responsibles.get(i).getHOAIncome().getOther2Amount());
      other3Amount.add(responsibles.get(i).getHOAIncome().getOther3Amount());
      other4Amount.add(responsibles.get(i).getHOAIncome().getOther4Amount());
      other5Amount.add(responsibles.get(i).getHOAIncome().getOther5Amount());
      other6Amount.add(responsibles.get(i).getHOAIncome().getOther6Amount());
    }

    income.setMonthlyTakeHomePay(monthlyTakeHomePay);
    income.setBonusIncome(bonusIncome);
    income.setUnemployment(unemployment);
    income.setDisability(disability);
    income.setChildSupport(childSupport);
    income.setAlimony(alimony);
    income.setNetRentalIncome(netRentalIncome);
    income.setPlan401K(plan401K);
    income.setStocksBonds(stocksBonds);
    income.setOther1Amount(other1Amount);
    income.setOther2Amount(other2Amount);
    income.setOther3Amount(other3Amount);
    income.setOther4Amount(other4Amount);
    income.setOther5Amount(other5Amount);
    income.setOther6Amount(other6Amount);

    return income;
  } // end method getHOAIncome

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHOAProduct() {
    String hoaProduct = null;

    if ((this.getAccountDetail().getSecondaryStateCode1() != null)
          && (this.getAccountDetail().getSecondaryStateCode1().length()
            > 0)) {
      hoaProduct = this.getAccountDetail().getSecondaryStateCode1();
    } else if ((this.getAccountDetail().getSecondaryStateCode2() != null)
          && (this.getAccountDetail().getSecondaryStateCode2().length()
            > 0)) {
      hoaProduct = this.getAccountDetail().getSecondaryStateCode2();
    } else if ((this.getAccountDetail().getSecondaryStateCode3() != null)
          && (this.getAccountDetail().getSecondaryStateCode3().length()
            > 0)) {
      hoaProduct = this.getAccountDetail().getSecondaryStateCode3();
    } else if ((this.getAccountDetail().getSecondaryStateCode4() != null)
          && (this.getAccountDetail().getSecondaryStateCode4().length()
            > 0)) {
      hoaProduct = this.getAccountDetail().getSecondaryStateCode4();
    } else if ((this.getAccountDetail().getSecondaryStateCode5() != null)
          && (this.getAccountDetail().getSecondaryStateCode5().length()
            > 0)) {
      hoaProduct = this.getAccountDetail().getSecondaryStateCode5();
    }

    return hoaProduct;
  } // end method getHOAProduct

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHOAProduct1() {
    String hoaProduct = null;

    if ((this.getAccountDetail().getSecondaryStateCode1() != null)
          && (this.getAccountDetail().getSecondaryStateCode1().length()
            > 0)) {
      hoaProduct = this.getAccountDetail().getSecondaryStateCode1();
    }

    return hoaProduct;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHOAProduct2() {
    String hoaProduct = null;

    if ((this.getAccountDetail().getSecondaryStateCode2() != null)
          && (this.getAccountDetail().getSecondaryStateCode2().length()
            > 0)) {
      hoaProduct = this.getAccountDetail().getSecondaryStateCode2();
    }

    return hoaProduct;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHOAProduct3() {
    String hoaProduct = null;

    if ((this.getAccountDetail().getSecondaryStateCode3() != null)
          && (this.getAccountDetail().getSecondaryStateCode3().length()
            > 0)) {
      hoaProduct = this.getAccountDetail().getSecondaryStateCode3();
    }

    return hoaProduct;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHOAProduct4() {
    String hoaProduct = null;

    if ((this.getAccountDetail().getSecondaryStateCode4() != null)
          && (this.getAccountDetail().getSecondaryStateCode4().length()
            > 0)) {
      hoaProduct = this.getAccountDetail().getSecondaryStateCode4();
    }

    return hoaProduct;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHOAProduct5() {
    String hoaProduct = null;

    if ((this.getAccountDetail().getSecondaryStateCode5() != null)
          && (this.getAccountDetail().getSecondaryStateCode5().length()
            > 0)) {
      hoaProduct = this.getAccountDetail().getSecondaryStateCode5();
    }

    return hoaProduct;
  }
  // Added for GEN 2

  //~ ------------------------------------------------------------------------------------------------------------------

  // NCC HOA product
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHOAProductAcceptance() {
    List<String> l         = Arrays.asList(
        new String[] { "W30", "W31", "W32", "w30", "w31", "w32" });
    Set<String>  constants = new HashSet<String>(l);

    return constants.contains(this.getAccountDetail().getSecondaryStateCode1())
      || constants.contains(this.getAccountDetail().getSecondaryStateCode2())
      || constants.contains(this.getAccountDetail().getSecondaryStateCode3())
      || constants.contains(this.getAccountDetail().getSecondaryStateCode4())
      || constants.contains(this.getAccountDetail().getSecondaryStateCode5());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home equity prequalified refi.
   *
   * @return  HomeEquityPrequalifiedRefi
   */
  public HomeEquityPrequalifiedRefi getHomeEquityPrequalifiedRefi() {
    return homeEquityPrequalifiedRefi;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for host indicator.
   *
   * @return  String
   */
  public String getHostIndicator() {
    return hostIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHubGroupName() {
    return accountAdditionalDetail.getClientDefined35CharCode2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHubLetterChannelName() {
    return accountAdditionalDetail.getClientDefined35CharCode5();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHubQueueName() {
    return accountAdditionalDetail.getClientDefined35CharCode3();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<IncomeAudit> getIncomeAudits() {
    return incomeAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for incomes.
   *
   * @return  Set
   */
  public Set<Income> getIncomes() {
    return incomes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * NCC ASAP Project.
   *
   * @return  nCC ASAP Project
   */
  public boolean getIncomeTaxIndicator() {
    return Boolean.TRUE.equals(clientDefinedFlag2);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for init dialer results.
   *
   * @return  Set
   */
  public Set<DialerChannelResult> getInitDialerResults() {
    return this.initDialerResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for init email results.
   *
   * @return  Set
   */
  public Set<EmailChannelResult> getInitEmailResults() {
    return initEmailResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for init ivr results.
   *
   * @return  Set
   */
  public Set<IvrChannelResult> getInitIvrResults() {
    return initIvrResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for init letter results.
   *
   * @return  Set
   */
  public Set<LetterChannelResult> getInitLetterResults() {
    return initLetterResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for init sms results.
   *
   * @return  Set
   */
  public Set<SmsChannelResult> getInitSmsResults() {
    return initSmsResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @param   installmentNumber  $param.type$
   *
   * @return  Date.
   */
  public Date getInstallmentDate(Integer installmentNumber) {
    Date date = null;

    if (installmentNumber != null) {
      if (this.acceptedProgram != null) {
        date = acceptedProgram.getInstallmentDate(installmentNumber);
      }
    }

    return date;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for insurances.
   *
   * @return  Set
   */
  public Set<AccountInsurance> getInsurances() {
    return insurances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for interest accrued from last interest date to now.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInterestAccruedFromLastInterestDateToNow() {
    BigDecimal interestAccruedFromLastInterestDateToNow = new BigDecimal("0.00");

    if (lastInterestDate != null) {
      if (portfolio.getAccrueInterest() && (accountSOR.getChargeOffPrincipal().compareTo(BigDecimal.ZERO) > 0)
            && accountSOR.getAccrueInterest()) {
        interestAccruedFromLastInterestDateToNow = InterestUtils.calculateInterest(accountSOR.getChargeOffPrincipal(),
            apr,
            lastInterestDate, new Date());
      }
    }

    return interestAccruedFromLastInterestDateToNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for interest due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInterestDue() {
    return interestDue;
  }
  // COFS Internal Status

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getInterestOutstanding() {
    return interestOutstanding;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getInternalStatus() {
    return clientDefined3CharCode1;
  }
  // investorLoanNumber

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getInvestorLoanNumber() {
    return clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for invoices.
   *
   * @return  Set
   */
  public Set<Invoice> getInvoices() {
    return this.invoices;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<IvrActivity> getIvrActivitiesFromIvrChannelResults() {
    List<IvrActivity> ret = new ArrayList<IvrActivity>();

    for (IvrChannelResult channelResult : exportedIvrResults) {
      IvrActivity ivrActivity = new IvrActivity();
      ivrActivity.setAccount(this);
      ivrActivity.setResponsible(channelResult.getResponsible());
      ivrActivity.setBalance(channelResult.getBalance());
      ivrActivity.setDelinquencyDays(getDelinquencyDays());
      ivrActivity.setStatus(channelResult.getStatus().toString());

      Date exportDate = channelResult.getStrategyDate();

      if (channelResult.getExportDate() != null) {
        exportDate = DateUtil.toDateOnly(channelResult.getExportDate());
      }

      ivrActivity.setCreateDate(exportDate);
      ivrActivity.setExecuteDate(channelResult.getExportDate());
      ret.add(ivrActivity);
    }

    for (IvrChannelResult channelResult : executedIvrResults) {
      for (IvrOutboundAudit outboundAudit : channelResult.getOutboundAudits()) {
        IvrActivity ivrActivity = new IvrActivity();
        ivrActivity.setAccount(this);
        ivrActivity.setResponsible(channelResult.getResponsible());
        ivrActivity.setBalance(channelResult.getBalance());
        ivrActivity.setDelinquencyDays(getDelinquencyDays());
        ivrActivity.setPhoneNumber(outboundAudit.getPhoneNumber());
        ivrActivity.setIvrResult(outboundAudit.getCallResultCode().getDescription());
        ivrActivity.setStatus(channelResult.getStatus().toString());

        Date exportDate = channelResult.getStrategyDate();

        if (channelResult.getExportDate() != null) {
          exportDate = DateUtil.toDateOnly(
              channelResult.getExportDate());
        }

        ivrActivity.setCreateDate(exportDate);
        ivrActivity.setExecuteDate(outboundAudit.getAttemptStartTime());
        ret.add(ivrActivity);
      }
    } // end for

    return ret;
  } // end method getIvrActivitiesFromIvrChannelResults

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for labelled schedule id.
   *
   * @return  Long
   */
  public Long getLabelledScheduleId() {
    return labelledScheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getLargestBucketAmount() {
    return CompareUtil.max(getBucketAmount1(), getBucketAmount2(),
        getBucketAmount3(), getBucketAmount4(), getBucketAmount5(),
        getBucketAmount6(), getBucketAmount7());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLastCashDate() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getLastCashDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last contact date.
   *
   * @return  Date
   */
  public Date getLastContactDate() {
    return lastContactDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLastDispositionDate() {
    Date lastDispDate = null;

    for (AgentCallActivity ac : this.agentCallActivities) {
      // agentCallActivities are sorted in asc order so get the last one
      lastDispDate = ac.getCreateDate();
    }

    return lastDispDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLastFutureDatedPaymentRejectDate() {
    Payment retPayment = null;

    for (Payment payment : payments) {
      if (payment.isFutureDated()
            && PaymentStatus.REJECTED.equals(payment.getPaymentStatus())) {
        if ((retPayment == null)
              || ((DateUtil.toDateOnly(payment.getPaymentDate())).compareTo(
                  DateUtil.toDateOnly(
                    retPayment.getPaymentDate())) > 0)) {
          retPayment = payment;
        }
      }
    }

    if (retPayment != null) {
      return retPayment.getRejectedStatusDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last interest date.
   *
   * @return  Date
   */
  public Date getLastInterestDate() {
    return lastInterestDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last letter date.
   *
   * @return  Date
   */
  public Date getLastLetterDate() {
    return lastLetterDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getLastLetterDays() {
    if (this.lastLetterDate != null) {
      return DateUtil.getDayDifference(new Date(), this.lastLetterDate)
        + 1;
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last letter id.
   *
   * @return  Long
   */
  public Long getLastLetterId() {
    return lastLetterId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last login date.
   *
   * @return  Date
   */
  public Date getLastLoginDate() {
    return lastLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last login failure date.
   *
   * @return  Date
   */
  public Date getLastLoginFailureDate() {
    return lastLoginFailureDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last NSFDate.
   *
   * @return  Date
   */
  public Date getLastNSFDate() {
    return lastNSFDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last NSFReport date.
   *
   * @return  Date
   */
  public Date getLastNSFReportDate() {
    return lastNSFReportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last pay amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLastPayAmount() {
    return lastPayAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last pay date.
   *
   * @return  Date
   */
  public Date getLastPayDate() {
    return lastPayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLastPaymentRejectDateNotAtAuth() {
    Payment retPayment = null;

    for (Payment payment : payments) {
      if (PaymentStatus.REJECTED.equals(payment.getPaymentStatus())
            && (payment.getRejectedAtAuthorizationDate() == null)) {
        if ((retPayment == null)
              || ((DateUtil.toDateOnly(payment.getPaymentDate())).compareTo(
                  DateUtil.toDateOnly(
                    retPayment.getPaymentDate())) > 0)) {
          retPayment = payment;
        }
      }
    }

    if (retPayment != null) {
      return retPayment.getRejectedStatusDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLastPTPKept() {
    return clientDefined1CharCode2;
  }
  // Added by EtisBew on 08/10/09 for RBS Specific Fields - End

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getLastPurchaseAmount() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getLastPurchaseAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last reage date.
   *
   * @return  Date
   */
  public Date getLastReageDate() {
    return lastReageDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last reage type.
   *
   * @return  String
   */
  public String getLastReageType() {
    return lastReageType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLastScheduledAppointmentCreateDate() {
    AdvisorAppointment appt     = null;
    Date               apptDate = null;

    if ((appointments != null) && (appointments.size() > 0)) {
      for (AdvisorAppointment a : appointments) {
        if (a.getAppointmentDateTime().after(new Date())) {
          if ((apptDate == null)
                || a.getAppointmentDateTime().after(apptDate)) {
            apptDate = a.getAppointmentDateTime();
            appt     = a;
          }
        }
      }
    }

    if (appt != null) {
      return appt.getCreateDate();
    }

    return null;
  } // end method getLastScheduledAppointmentCreateDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last work date.
   *
   * @return  Date
   */
  public Date getLastWorkDate() {
    return lastWorkDate;
  }
  // lateFee

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getLateFee() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the most recent responsible score based on score type.
   *
   * @param   scoreType  DOCUMENT ME!
   *
   * @return  get the most recent responsible score based on score type.
   */
  public AccountScore getLatestScore(ScoreTypeEnum scoreType) {
    AccountScore ret = null;

    for (AccountScore score : this.accountScores) {
      if (score.getScoreType().getScoreTypeId().equals(
              scoreType.getScoreTypeId())) {
        if ((ret == null)
              || (ret.getScoreDate().compareTo(score.getScoreDate())
                < 0)) {
          ret = score;
        }
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the most recent responsible score based on the score type, value only.
   *
   * @param   scoreType  DOCUMENT ME!
   *
   * @return  get the most recent responsible score based on the score type, value only.
   */
  public Integer getLatestScoreValue(ScoreTypeEnum scoreType) {
    AccountScore score = getLatestScore(scoreType);

    if (score != null) {
      return score.getScoreValue();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLegalStatus() {
    return this.clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<LetterActivity> getLetterActivitiesFromLetterChannelResults() {
    List<LetterActivity> ret = new ArrayList<LetterActivity>();

    for (LetterChannelResult channelResult : exportedLetterResults) {
      LetterActivity letterActivity = new LetterActivity();
      letterActivity.setAccount(this);
      letterActivity.setResponsible(channelResult.getResponsible());
      letterActivity.setBalance(channelResult.getBalance());
      letterActivity.setDelinquencyDays(getDelinquencyDays());
      letterActivity.setProgram(channelResult.getProgram());
      letterActivity.setTemplateId(channelResult.getTemplate());
      letterActivity.setStatus(channelResult.getStatus().toString());
      letterActivity.setCreateDate(channelResult.getCreateDate());
      letterActivity.setExecuteDate(channelResult.getExportDate());
      ret.add(letterActivity);
    }

    return ret;
  }
  // lienPosition - Changed for APR-24 -clientDefined1CharCode2

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLienPosition() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * NCC ASAP Project.
   *
   * @return  nCC ASAP Project
   */
  public Date getLineMaturityDate() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan term.
   *
   * @return  Integer
   */
  public Integer getLoanTerm() {
    return loanTerm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan to value.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLoanToValue() {
    return loanToValue;
  }
  // END - Field used in DFS - Discover
  // Start - Field used in NCC Card
  // NCC CARD Location Code

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLocationCode() {
    return clientDefined6CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lock expiration time.
   *
   * @return  Date
   */
  public Date getLockExpirationTime() {
    return this.lockExpirationTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lock time.
   *
   * @return  Date
   */
  public Date getLockTime() {
    return this.lockTime;
  }
  // NCC Card Longman Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLongmanScore() {
    return clientDefined3CharCode2;
  }
  // NCC LPMI insurance

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getLPMIInsurance() {
    if (this.getAccountDetail().getLpmiIndicator() == null) {
      return Boolean.FALSE;
    }

    return "Y".equals(this.getAccountDetail().getLpmiIndicator().toUpperCase());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get Lump Sum payment program - one payment of Settlement type.
   *
   * @return  get Lump Sum payment program - one payment of Settlement type
   */
  public PaymentProgram getLumpSumPaymentProgram() {
    for (PaymentProgram program : paymentPrograms) {
      if ("SETTLEMENT".equalsIgnoreCase(program.getType().getName())
            && (program.getDuration() == 1)) {
        return program;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * NCC ASAP Project.
   *
   * @return  nCC ASAP Project
   */
  public BigDecimal getMargin() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMaturityDate() {
    return maturityDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max delinquency days.
   *
   * @return  Integer
   */
  public Integer getMaxDelinquencyDays() {
    return maxDelinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the concatenated MemoryMessage.data fields for the account.
   *
   * @return  the concatenated MemoryMessage.data fields for the account.
   */
  public String getMemoryMessage() {
    if (memoryMessages != null) {
      StringBuffer memMsgs = new StringBuffer();

      for (MemoryMessage memMsg : memoryMessages) {
        if (StringUtils.hasText(memMsg.getData())) {
          memMsgs.append(memMsg.getData());
        }
      }

      return memMsgs.toString();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<MemoryMessage> getMemoryMessages() {
    return memoryMessages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<Memo> getMemos() {
    return memos;
  }
  // NCC Card midrange Risk Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMidrangeRiskScore() {
    return clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getMinimumDue() {
    return this.minimumPayDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for minimum pay due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMinimumPayDue() {
    return this.minimumPayDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mortgage.
   *
   * @return  AccountMortgage
   */
  public AccountMortgage getMortgage() {
    return mortgage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the most distant PromiseToPay Arrival Date.
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostDistantPromiseToPayArrivalDate() {
    Date              now             = new Date();
    Set<PromiseToPay> promiseToPaySet = getPromises();

    if ((promiseToPaySet != null) && (promiseToPaySet.size() > 0)) {
      PromiseToPay[] ptpArr = promiseToPaySet.toArray(new PromiseToPay[] {});
      CollectionUtils.reverseArray(ptpArr);

      if (ptpArr[0] != null) {
        return ptpArr[0].getArrivalDate();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountStatus getMostRecentAccountStatus() {
    return getMostRecentAccountStatus(null, true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMostRecentAccountStatus2() {
    AccountStatus status = getMostRecentAccountStatus(null, true, null,
        new String[] { "800" });

    if (status != null) {
      return status.getStatusCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentAccountStatus2Date() {
    AccountStatus status = getMostRecentAccountStatus(null, true, null,
        new String[] { "800" });

    if (status != null) {
      return status.getStatusDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   statusCodes  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMostRecentAccountStatusAmong(String... statusCodes) {
    if ((accountStatuses == null) || (accountStatuses.size() == 0)) {
      return null;
    }

    AccountStatus status = getMostRecentAccountStatus(null, true,
        statusCodes, null);

    if (status != null) {
      return status.getStatusCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountStatus getMostRecentActiveAccountStatus() {
    return getMostRecentAccountStatus(null, false);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMostRecentActiveAccountStatus2() {
    AccountStatus status = getMostRecentAccountStatus(null, false);

    if (status != null) {
      return status.getStatusCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentBrokenPromiseArrivalDate() {
    return getMostRecentPromiseToPayArrivalDate(PromiseToPayStatus.BROKEN);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentBrokenPromiseDate() {
    // Calculate broken ptp Date
    for (PromiseToPay ptp : promises) {
      if (PromiseToPayStatus.BROKEN.equals(ptp.getPtpStatus())) {
        if (brokenPromiseDate == null) {
          brokenPromiseDate = ptp.getPaymentDate();
        } else if (brokenPromiseDate.before(ptp.getPaymentDate())) {
          brokenPromiseDate = ptp.getPaymentDate();
        }
      }
    }

    return brokenPromiseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentBrokenPromiseSendDate() {
    return getMostRecentPromiseToPaySendDate(PromiseToPayStatus.BROKEN);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentDeletedPromiseArrivalDate() {
    return getMostRecentPromiseToPayArrivalDate(PromiseToPayStatus.DELETED);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentDeletedPromiseSendDate() {
    return getMostRecentPromiseToPaySendDate(PromiseToPayStatus.DELETED);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the most recent FUTURE statused PromiseToPay.
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay getMostRecentFuturePromiseToPay() {
    List<PromiseToPay> futurePromises = getFuturePromises();

    if ((futurePromises != null) && (futurePromises.size() > 0)) {
      return futurePromises.toArray(new PromiseToPay[] {})[0];
    }

    return null;
  } // end method getMostRecentFuturePromiseToPay

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay getMostRecentKeptPromise() {
    Set<PromiseToPay>  promiseToPaySet = getPromises();
    List<PromiseToPay> keptPromiseList = new ArrayList<PromiseToPay>();

    for (PromiseToPay promise : promiseToPaySet) {
      if (PromiseToPayStatus.KEPT.equals(promise.getPtpStatus())) {
        keptPromiseList.add(promise);
      }
    }

    if (keptPromiseList.size() > 0) {
      return keptPromiseList.get(keptPromiseList.size() - 1);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentKeptPromiseArrivalDate() {
    return getMostRecentPromiseToPayArrivalDate(PromiseToPayStatus.KEPT);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentKeptPromiseSendDate() {
    return getMostRecentPromiseToPaySendDate(PromiseToPayStatus.KEPT);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the most recent lumpsum payment program. The returned settlement program needs to match two criterias:
   *
   * <p>Amount has to be less than the balance.</p>
   *
   * <p>Program has to be active.</p>
   *
   * @return  get the most recent lumpsum payment program.
   */
  public PaymentProgram getMostRecentLumpSumSettlementProgram() {
    PaymentProgram p = null;

    for (PaymentProgram program : this.paymentPrograms) {
      PaymentProgramTypeCode type = PaymentProgramTypeCode.toPaymentProgramTypeCode(program.getType()
          .getProgramTypeId());

      if (PaymentProgramTypeCode.SETTLEMENT.equals(type)
            && (program.getDuration() == 1) && !program.isExpired()
            && Boolean.TRUE.equals(program.getActive())) {
        if (p == null) {
          p = program;
        } else if (p.getCreateDate().before(program.getCreateDate())) {
          p = program;
        }
      }
    }

    return p;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the most recent multiple month program.
   *
   * @return  get the most recent multiple month program.
   */
  public PaymentProgram getMostRecentMultiMonthProgram() {
    PaymentProgram p = null;

    for (PaymentProgram program : this.paymentPrograms) {
      if ((program.getDuration() > 1) && !program.isExpired()
            && Boolean.TRUE.equals(program.getActive())) {
        if (p == null) {
          p = program;
        } else if (p.getCreateDate().before(program.getCreateDate())) {
          p = program;
        }
      }
    }

    return p;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentOutstandingPromiseArrivalDate() {
    return getMostRecentPromiseToPayArrivalDate(PromiseToPayStatus.OUTSTANDING);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentOutstandingPromiseSendDate() {
    return getMostRecentPromiseToPaySendDate(PromiseToPayStatus.OUTSTANDING);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the Most Recent payments for the Account.
   *
   * @return  Payment
   */
  public Payment getMostRecentPayment() {
    Payment returnPay = null;

    for (Payment payment : getPayments()) {
      if (returnPay == null) {
        returnPay = payment;

        continue;
      }

      if (returnPay.getCreateDate().after(payment.getCreateDate())) {
        continue;
      } else {
        returnPay = payment;
      }
    }

    return returnPay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentPaymentCreateDate() {
    Payment p = this.getMostRecentPayment();

    if (p != null) {
      return p.getCreateDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the most recent FUTURE statused PromiseToPay.
   *
   * @param   status  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentPromiseToPayArrivalDate(PromiseToPayStatus status) {
    if (status != null) {
      Date               now              = new Date();
      List<PromiseToPay> promiseToPayList = getPromisesWithStatusFromArrivalDate(status, now);

      if ((promiseToPayList != null) && (promiseToPayList.size() > 0)) {
        return promiseToPayList.get(0).getArrivalDate();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the most recent FUTURE statused PromiseToPay.
   *
   * @param   status  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMostRecentPromiseToPaySendDate(PromiseToPayStatus status) {
    if (status != null) {
      Date               now              = new Date();
      List<PromiseToPay> promiseToPayList = getPromisesWithStatusFromSendDate(status, now);

      if ((promiseToPayList != null) && (promiseToPayList.size() > 0)) {
        PromiseToPay ptp = promiseToPayList.toArray(new PromiseToPay[] {})[0];

        if (ptp != null) {
          return ptp.getSendDate();
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * NCC ASAP MtgHist.
   *
   * @return  nCC ASAP MtgHist
   */
  public boolean getMtgHist() {
    return Boolean.TRUE.equals(clientDefinedFlag1);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * NCC ASAP Project.
   *
   * @return  nCC ASAP Project
   */
  public Integer getMtgNum() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNCCAcsPortfolio() {
    return accountDetail.getClientDefinedDecimal8();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCBankNumber() {
    return accountDetail.getClientDefined4CharCode2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCBkScore() {
    return accountDetail.getClientDefinedInteger10();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCCardCycleCount1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCCardCycleCount2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCCardCycleCount3() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCCardCycleCount4() {
    return clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCCardCycleCount5() {
    return clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCCardCycleCount6() {
    return clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCCardCycleCount7() {
    return clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCChallengerMod3() {
    return accountDetail.getClientDefinedInteger14();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCCicKey() {
    return accountDetail.getClientDefined15CharCode2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCCimsBankNumber() {
    return accountDetail.getClientDefined2CharCode2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCCMO() {
    return accountDetail.getClientDefined8CharCode1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCCollateralType() {
    return accountDetail.getClientDefinedInteger2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCCollectionSeg() {
    return accountDetail.getClientDefinedInteger15();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNCCCreditCardDebt() {
    return accountDetail.getClientDefinedDecimal5();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCCreditCardProgram8() {
    return accountDetail.getClientDefined1CharCode3();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCCreditLifeFlag() {
    return accountDetail.getClientDefinedInteger9();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCCurrentFicoScore() {
    return accountDetail.getClientDefinedInteger7();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCCustomRiskScore() {
    return accountDetail.getClientDefined3CharCode3();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNCCExtensionFee() {
    return accountDetail.getClientDefinedDecimal7();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCExtensionLength() {
    AccountDetail accountDetail = getAccountDetail();

    if ((accountDetail != null)
          && "ILA".equalsIgnoreCase(
            accountDetail.getClientDefined5CharCode4())) {
      if ((getNumberOfCyclesDelinquent() != null)
            && (getNumberOfCyclesDelinquent() == 1)) {
        return new Integer(2);
      } else if ((getNumberOfCyclesDelinquent() != null)
            && (getNumberOfCyclesDelinquent() > 1)) {
        return new Integer(3);
      }
    } else if ((accountDetail != null)
          && "ACL".equalsIgnoreCase(
            accountDetail.getClientDefined5CharCode4())) {
      if ((getNumberOfCyclesDelinquent() != null)
            && (getNumberOfCyclesDelinquent() >= 1)) {
        return new Integer(2);
      }
    }

    return null;
  } // end method getNCCExtensionLength

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCHouseholdRiskModel() {
    return accountDetail.getClientDefinedInteger17();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCHouseholdType() {
    return accountDetail.getClientDefined8CharCode2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNCCLastPaymentReversalDate() {
    return accountDetail.getClientDefinedDate1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCLetterUserDefined3() {
    return accountDetail.getClientDefined32CharCode1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCLienPosition() {
    return accountDetail.getClientDefinedInteger12();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCClmAsapIndicator() {
    return accountDetail.getClientDefinedInteger16();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCLob() {
    return accountDetail.getClientDefined1CharCode4();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNCCLossMitigationRiskScore() {
    return accountDetail.getClientDefinedDecimal9();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCLpmiIndicator() {
    return accountDetail.getLpmiIndicator();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNCCMaturityDate() {
    return accountDetail.getClientDefinedDate8();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCMonthsLastCheckReturned() {
    return accountDetail.getClientDefinedInteger1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNCCMortgagebalance() {
    return accountDetail.getClientDefinedDecimal4();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getNCCMortgageDelinquencFlag() {
    return accountDetail.getClientDefinedFlag2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCMortgageOwnedInvestor() {
    return accountDetail.getClientDefined1CharCode1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCMortgageTrades() {
    return accountDetail.getClientDefinedInteger8();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCMspLoanNumber() {
    return accountDetail.getClientDefined25CharCode2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNCCOriginal1stMortgageAmount() {
    return accountDetail.getClientDefinedDecimal2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNCCOriginalDTI() {
    return accountDetail.getClientDefinedDecimal3();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCOriginalFicoScore() {
    return accountDetail.getClientDefinedInteger6();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNCCOriginalPropertyValue() {
    return accountDetail.getClientDefinedDecimal1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNCCOtherDebt() {
    return accountDetail.getClientDefinedDecimal6();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCPortfolioId() {
    return accountDetail.getClientDefined20CharCode1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCProduct() {
    return accountDetail.getClientDefined1CharCode2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNCCProgramLastUpdateDate() {
    return accountDetail.getClientDefinedDate9();
  }
  // UserDefined1

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNCCProgramPurgeDate() {
    return clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCProgramScore() {
    return accountDetail.getClientDefinedInteger11();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCReageExtensionFlag() {
    return accountDetail.getClientDefined2CharCode1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCRecoveryGrade() {
    return accountDetail.getClientDefined3CharCode1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCRightPartyContactScore() {
    return accountDetail.getClientDefinedInteger13();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNCCRollDate() {
    return accountDetail.getClientDefinedDate7();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCSecondaryStateCode1() {
    return accountDetail.getClientDefined3CharCode4();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCSecondaryStateCode2() {
    return accountDetail.getClientDefined3CharCode5();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCSecondaryStateCode3() {
    return accountDetail.getClientDefined5CharCode1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCSecondaryStateCode4() {
    return accountDetail.getClientDefined5CharCode2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCSecondaryStateCode5() {
    return accountDetail.getClientDefined5CharCode3();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCSettlementScore() {
    return accountDetail.getClientDefined3CharCode2();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCSpecialFlag7() {
    return accountDetail.getClientDefined2CharCode4();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getNCCStateIncomeFlag() {
    return accountDetail.getClientDefinedFlag1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCStatus() {
    return clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCSystemRecord() {
    return accountDetail.getClientDefined4CharCode1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNCCUnemploymentInsurance() {
    return accountDetail.getClientDefinedInteger3();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNCCUserDefined4() {
    return accountDetail.getClientDefined2CharCode5();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get Program total amount based on percentage.
   *
   * @param   principalType  DOCUMENT ME!
   * @param   percentage     DOCUMENT ME!
   *
   * @return  get Program total amount based on percentage
   */
  public BigDecimal getNegotiatedProgramAmount(String principalType, BigDecimal percentage) {
    BigDecimal principalAmount = getPrincipalAmount(principalType);
    BigDecimal totalAmount     = principalAmount.multiply(percentage);
    totalAmount = totalAmount.setScale(2, BigDecimal.ROUND_HALF_UP);

    return totalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<NegotiateExceptionResult> getNegotiateExceptionResults() {
    return negotiateExceptionResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the account program type by type id.
   *
   * @param   typeId  DOCUMENT ME!
   *
   * @return  get the account program type by type id
   */
  public NegotiateProgramType getNegotiateProgramType(Long typeId) {
    for (NegotiateProgramType type : negotiateProgramTypes) {
      if (type.getTypeId().equals(typeId)) {
        return type;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for negotiate program types.
   *
   * @return  Set
   */
  public Set<NegotiateProgramType> getNegotiateProgramTypes() {
    return this.negotiateProgramTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for net costs.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNetCosts() {
    return netCosts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNextExpectedPaymentDate() {
    PaymentProgramInstallment nInstallment = null;

    if (acceptedProgram != null) {
      nInstallment = acceptedProgram.getNextInstallmentByExpectedPaymentDate();
    }

    return (nInstallment == null) ? null : nInstallment.getExpectedPaymentDate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNextInstallmentAmount() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getNextInstallmentAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next installment amount for RAM.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNextInstallmentAmountForRAM() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getNextInstallmentAmountForRAM();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNextInstallmentDueDate() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getNextInstallmentDueDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNextInstallmentDueDateWithTolerance() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getNextInstallmentDueDateWithTolerance();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNextInstallmentPaymentStatus() {
    if (this.acceptedProgram != null) {
      PaymentProgramInstallment installment = acceptedProgram.getNextInstallment();

      if (installment != null) {
        return installment.getInstallmentPaymentStatus().toString();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getNextInstallmentScheduled() {
    if (this.acceptedProgram != null) {
      PaymentProgramInstallment installment = acceptedProgram.getNextInstallment();

      if (installment == null) {
        return null;
      }

      if (InstallmentStatus.FULFILLED.equals(
              installment.getInstallmentStatus())) {
        return Boolean.TRUE;
      }

      BigDecimal amt = getOutStandingPaymentTotalAmount(null,
          installment.getInstallmentDueDate());

      if (amt.compareTo(installment.getUnfulfilledPaymentAmount()) >= 0) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getNextInstallmentScheduledByExpectedPaymentDate() {
    if (this.acceptedProgram != null) {
      PaymentProgramInstallment installment = acceptedProgram.getNextInstallmentByExpectedPaymentDate();

      if (installment == null) {
        return null;
      }

      if (InstallmentStatus.FULFILLED.equals(
              installment.getInstallmentStatus())) {
        return Boolean.TRUE;
      }

      BigDecimal amt = getOutStandingPaymentTotalAmount(null,
          installment.getExpectedPaymentDate());

      if (amt.compareTo(installment.getUnfulfilledPaymentAmount()) >= 0) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNextInstallmentStatus() {
    if (this.acceptedProgram != null) {
      PaymentProgramInstallment installment = acceptedProgram.getNextInstallment();

      if (installment != null) {
        return installment.getInstallmentStatus().toString();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNextInstallmentStatusByExpectedPaymentDate() {
    if (this.acceptedProgram != null) {
      PaymentProgramInstallment installment = acceptedProgram.getNextInstallmentByExpectedPaymentDate();

      if (installment != null) {
        return installment.getInstallmentStatus().toString();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next payment date.
   *
   * @return  Date
   */
  public Date getNextPaymentDate() {
    return nextPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next reage date.
   *
   * @return  Date
   */
  public Date getNextReageDate() {
    return this.nextReageDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Payment getNextScheduledPayment() {
    for (Payment payment : this.payments) {
      if ((payment != null)
            && PaymentStatus.SCHEDULED.equals(
              payment.getPaymentStatus())) {
        return payment;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getNextScheduledPaymentAmount() {
    Payment payment = getNextScheduledPayment();

    if (payment != null) {
      return payment.getAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNextScheduledPaymentCreateDate() {
    for (Payment payment : this.payments) {
      if ((payment != null)
            && PaymentStatus.SCHEDULED.equals(
              payment.getPaymentStatus())) {
        return payment.getCreateDate();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNextScheduledPaymentDate() {
    Payment payment = getNextScheduledPayment();

    if (payment != null) {
      return payment.getPaymentDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNextUnpaidExpectedPaymentDate() {
    PaymentProgramInstallment nInstallment = null;

    if (acceptedProgram != null) {
      nInstallment = acceptedProgram.getNextUnpaidInstallmentByExpectedPaymentDate();
    }

    return (nInstallment == null) ? null : nInstallment.getExpectedPaymentDate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the next web payment (debtorsite or agent workstation). This method returns the very next payment (including
   * today) with "SCHEDULED" status.
   *
   * @return  DOCUMENT ME!
   */
  public Payment getNextWebPayment() {
    long today = (DateUtil.toDateOnly(new Date())).getTime();

    for (Payment payment : this.payments) {
      if ((payment != null) && payment.isCMCWebPayment()
            && PaymentStatus.SCHEDULED.equals(
              payment.getPaymentStatus())) {
        long v = (payment.getPaymentDate()).getTime();

        if (v >= today) {
          return payment;
        }
      }
    }

    return null;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getNextWorkDateFromDispositions() {
    int i = 0;

    if ((userLoadedAccounts != null) && (userLoadedAccounts.size() > i)) {
      UserLoadedAccount      mostRecentUserSession = userLoadedAccounts.toArray(new UserLoadedAccount[] {})[i];
      Set<AgentCallActivity> agentCallActivitySet  = mostRecentUserSession.getAgentCallActivities();

      while ((agentCallActivitySet == null) || (agentCallActivitySet.size() == 0)) {
        i++;

        if (userLoadedAccounts.size() <= i) {
          break;
        }

        mostRecentUserSession = userLoadedAccounts.toArray(new UserLoadedAccount[] {})[i];
        agentCallActivitySet  = mostRecentUserSession.getAgentCallActivities();
      }

      if ((agentCallActivitySet != null) && (agentCallActivitySet.size() > 0)) {
        List<AgentCallActivity> agentCallActivityList = new ArrayList<AgentCallActivity>();
        agentCallActivityList.addAll(agentCallActivitySet);
        Collections.sort(agentCallActivityList, new Comparator<AgentCallActivity>() {
            @Override public int compare(AgentCallActivity o1, AgentCallActivity o2) {
              Date nextWorkDate1 = o1.getNextWorkDate();
              Date nextWorkDate2 = o2.getNextWorkDate();

              if ((nextWorkDate1 == null) || (nextWorkDate2 == null)) {
                return 0;
              }

              return nextWorkDate1.compareTo(nextWorkDate2);
            }
          });

        for (AgentCallActivity callActivity : agentCallActivityList) {
          if (callActivity.getNextWorkDate() != null) {
            return callActivity.getNextWorkDate();
          }
        }
      }
    } // end if

    return null;
  } // end method getNextWorkDateFromDispositions

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date Helper Get current time.
   *
   * @return  date Helper Get current time
   */
  public Date getNow() {
    return new Date();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNumberNSFChecks() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getNumberNSFChecks();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNumberOfBrokenPromiseToPays() {
    int i = 0;

    for (PromiseToPay ptp : this.promises) {
      if (PromiseToPayStatus.BROKEN.equals(ptp.getPtpStatus())) {
        i++;
      }
    }

    return i;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for number of cycles delinquent.
   *
   * @return  Integer
   */
  public Integer getNumberOfCyclesDelinquent() {
    return this.numberOfCyclesDelinquent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNumberOfKeptPromiseToPays() {
    int i = 0;

    for (PromiseToPay ptp : this.promises) {
      if (PromiseToPayStatus.KEPT.equals(ptp.getPtpStatus())) {
        i++;
      }
    }

    return i;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for officer code.
   *
   * @return  String
   */
  public String getOfficerCode() {
    return officerCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for omni next payment date.
   *
   * @return  Date
   */
  public Date getOmniNextPaymentDate() {
    return omniNextPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for omni past due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOmniPastDue() {
    return omniPastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for open date.
   *
   * @return  Date
   */
  public Date getOpenDate() {
    return openDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * To get OptOut Value for SP Response Flow.
   *
   * @return  to get OptOut Value for SP Response Flow
   */
  public String getOptOut() {
    return clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original account number.
   *
   * @return  String
   */
  public String getOriginalAccountNumber() {
    return originalAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original account num last4.
   *
   * @return  String
   */
  public String getOriginalAccountNumLast4() {
    if (StringUtils.hasText(this.originalAccountNumber)) {
      return (this.originalAccountNumber.length() > 4)
        ? this.originalAccountNumber.substring(this.originalAccountNumber.length() - 4,
          this.originalAccountNumber.length()) : this.originalAccountNumber;
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original charge off amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOriginalChargeOffAmount() {
    return originalChargeOffAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original creditor.
   *
   * @return  String
   */
  public String getOriginalCreditor() {
    return originalCreditor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original date timestamp.
   *
   * @return  Date
   */
  public Date getOriginalDateTimestamp() {
    return originalDateTimestamp;
  }
  // Citi originalHousingRatio

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getOriginalHousingRatio() {
    return clientDefinedDecimal2;
  }
  // Citi originalLoanAmount - Not Used for Apr-24

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getOriginalLoanAmount() {
    return clientDefinedDecimal1;
  }
  // Citi originalTotalPayment

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getOriginalPrincipalAmount() {
    return originalPrincipalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getOriginalTotalPayment() {
    return clientDefinedDecimal3;
  }
  // otherFee

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getOtherFee() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns a list of all PromiseToPays which are either being evaluated and not yet been KEPT/INACTIVE and have the
   * evaluation period as today or in the future in the ASCENDING order of Arrival Date.
   *
   * @return  DOCUMENT ME!
   */
  public List<PromiseToPay> getOutstandingOrFuturePromises() {
    Set<PromiseToPay>  promiseToPaySet  = getPromises();
    List<PromiseToPay> promiseToPayList = new ArrayList<PromiseToPay>();

    if ((promiseToPaySet != null) && (promiseToPaySet.size() > 0)) {
      for (PromiseToPay promise : promiseToPaySet) {
        if (log.isDebugEnabled()) {
          log.debug("getOutstandingOrFuturePromises() :: promiseStatus: "
            + promise.getPtpStatus());
        }

        if (PromiseToPayStatus.OUTSTANDING.equals(
                promise.getPtpStatus()) || PromiseToPayStatus.FUTURE.equals(promise.getPtpStatus())) {
          promiseToPayList.add(promise);
        }
      }
    }

    return promiseToPayList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   arrivalDate  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay getOutstandingOrFuturePromises(Date arrivalDate) {
    if (arrivalDate != null) {
      arrivalDate = DateUtil.toDateOnly(arrivalDate);

      List<PromiseToPay> outstandingFuturePTPList = getOutstandingOrFuturePromises();

      if (outstandingFuturePTPList != null) {
        for (PromiseToPay ptp : outstandingFuturePTPList) {
          Date existingPTPArrivalDate = DateUtil.toDateOnly(ptp.getArrivalDate());

          if (existingPTPArrivalDate.compareTo(arrivalDate) == 0) {
            return ptp;
          }
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns a list of all PromiseToPays which are either being evaluated and not yet been KEPT/INACTIVE and have the
   * evaluation period as today or in the future in the ASCENDING order of Arrival Date.
   *
   * @param   fromDate  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<PromiseToPay> getOutstandingOrFuturePromisesFromDate(Date fromDate) {
    if (fromDate != null) {
      Set<PromiseToPay>  promiseToPaySet  = getPromises();
      List<PromiseToPay> promiseToPayList = new ArrayList<PromiseToPay>();

      if ((promiseToPaySet != null) && (promiseToPaySet.size() > 0)) {
        for (PromiseToPay promise : promiseToPaySet) {
          if (log.isDebugEnabled()) {
            log.debug("getOutstandingOrFuturePromises() :: promiseStatus: "
              + promise.getPtpStatus());
          }

          if (DateUtil.isAfterDate(promise.getArrivalDate(), fromDate)
                && (PromiseToPayStatus.OUTSTANDING.equals(
                    promise.getPtpStatus()) || PromiseToPayStatus.FUTURE.equals(promise.getPtpStatus()))) {
            promiseToPayList.add(promise);
          }
        }
      }

      return promiseToPayList;
    }

    return null;
  } // end method getOutstandingOrFuturePromisesFromDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getOutStandingPaymentTotalAmount() {
    BigDecimal amt = new BigDecimal("0.0");

    for (Payment payment : this.payments) {
      if (PaymentStatus.INPROCESS.equals(payment.getPaymentStatus())
            || PaymentStatus.SCHEDULED.equals(
              payment.getPaymentStatus())) {
        amt = amt.add(payment.getAmount());
      }
    }

    return amt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   paymentDate1  DOCUMENT ME!
   * @param   paymentDate2  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getOutStandingPaymentTotalAmount(Date paymentDate1, Date paymentDate2) {
    BigDecimal amt   = new BigDecimal("0.0");
    long       date1 = 0;
    long       date2 = Long.MAX_VALUE;

    if (paymentDate1 != null) {
      date1 = DateUtil.toDateOnly(paymentDate1).getTime();
    }

    if (paymentDate2 != null) {
      date2 = DateUtil.toDateOnly(paymentDate2).getTime();
    }

    for (Payment payment : this.payments) {
      long dateVal = (DateUtil.toDateOnly(payment.getPaymentDate())).getTime();

      if ((dateVal >= date1) && (dateVal <= date2)) {
        if (PaymentStatus.INPROCESS.equals(
                payment.getPaymentStatus())
              || PaymentStatus.SCHEDULED.equals(
                payment.getPaymentStatus())) {
          amt = amt.add(payment.getAmount());
        }
      }
    }

    return amt;
  } // end method getOutStandingPaymentTotalAmount

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the PromiseToPay that is currently in its evaluation period - If the promise is KEPT or INACTIVE donot
   * return it. This is time specific. This returns Promises for INACTIVE accounts as well.
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay getOutstandingPromise() {
    List<PromiseToPay> outstandingOrFuturePromiseToPays = getOutstandingOrFuturePromises();

    for (PromiseToPay ptp : outstandingOrFuturePromiseToPays) {
      if (PromiseToPayStatus.OUTSTANDING.equals(ptp.getPtpStatus())) {
        return ptp;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the PromiseToPay that is currently in its evaluation period - If the promise is KEPT or INACTIVE donot
   * return it. This is time specific. This returns Promises for INACTIVE accounts as well.
   *
   * @param   fromDate  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay getOutstandingPromise(Date fromDate) {
    List<PromiseToPay> outstandingOrFuturePromiseToPays = getOutstandingOrFuturePromisesFromDate(fromDate);

    for (PromiseToPay ptp : CollectionUtil.safeList(outstandingOrFuturePromiseToPays)) {
      if (PromiseToPayStatus.OUTSTANDING.equals(ptp.getPtpStatus())) {
        return ptp;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns a list of all PromiseToPays which are either being evaluated and not yet been KEPT/INACTIVE and have the
   * evaluation period as today or in the future in the ASCENDING order of Arrival Date.
   *
   * @return  DOCUMENT ME!
   */
  public List<PromiseToPay> getOutstandingPromises() {
    Set<PromiseToPay>  promiseToPaySet  = getPromises();
    List<PromiseToPay> promiseToPayList = new ArrayList<PromiseToPay>();

    if ((promiseToPaySet != null) && (promiseToPaySet.size() > 0)) {
      Date today               = new Date();
      Date finalEvaluationDate = null;

      for (PromiseToPay promise : promiseToPaySet) {
        finalEvaluationDate = promise.getEvaluationDate();

        if (log.isDebugEnabled()) {
          log.debug("getOutstandingPromises() :: finalEvaluationDate: "
            + finalEvaluationDate);
        }

        if (!finalEvaluationDate.before(today)
              && !PromiseToPayStatus.KEPT.equals(
                promise.getPtpStatus()) && !PromiseToPayStatus.INACTIVE.equals(promise.getPtpStatus())) {
          promiseToPayList.add(promise);
        }
      }
    }

    return promiseToPayList;
  } // end method getOutstandingPromises

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the PromiseToPay that is currently in its evaluation period - If the promise is KEPT or INACTIVE donot
   * return it. This is time specific. This returns Promises for INACTIVE accounts as well.
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay getOutstandingPromiseToPay() {
    Set<PromiseToPay> promiseToPaySet = getPromises();

    if ((promiseToPaySet != null) && (promiseToPaySet.size() > 0)) {
      Date               today               = new Date();
      Date               startEvaluationDate = null;
      Date               finalEvaluationDate = null;
      List<PromiseToPay> outstandingPTPList  = new ArrayList<PromiseToPay>();

      for (PromiseToPay promise : promiseToPaySet) {
        startEvaluationDate = promise.getStartEvaluationDate();
        finalEvaluationDate = promise.getEvaluationDate();

        if (log.isDebugEnabled()) {
          log.debug(
            "getOutstandingPromiseToPay() :: startEvaluationDate: "
            + startEvaluationDate + "\nfinalEvaluationDate: "
            + finalEvaluationDate);
        }

        if (!finalEvaluationDate.before(today)) {
          if ((PromiseToPayStatus.OUTSTANDING.equals(
                    promise.getPtpStatus()))
                || (PromiseToPayStatus.FUTURE.equals(
                    promise.getPtpStatus()))
                || (PromiseToPayStatus.INIT.equals(
                    promise.getPtpStatus()))) {
            outstandingPTPList.add(promise);
          }
        }
      }

      if (log.isDebugEnabled()) {
        log.debug(
          "getOutstandingPromiseToPay() :: outstandingPTPList: "
          + outstandingPTPList);
      }

      if ((outstandingPTPList != null)
            && (outstandingPTPList.size() > 0)) {
        return outstandingPTPList.get(0);
      }
    } // end if

    return null;
  } // end method getOutstandingPromiseToPay

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for over limit.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOverLimit() {
    return overLimit;
  }
  // NCC Card overthelimit Risk Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOverthelimitRiskScore() {
    return clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for past due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPastDue() {
    return pastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PromiseToPay> getPastNonEvaluatedPromises() {
    Set<PromiseToPay> pastNonEvaluatedPromiseSet = new LinkedHashSet<PromiseToPay>();
    Set<PromiseToPay> promiseToPaySet            = getPromises();

    if ((promiseToPaySet != null) && (promiseToPaySet.size() > 0)) {
      Date today               = new Date();
      Date startEvaluationDate = null;
      Date finalEvaluationDate = null;

      for (PromiseToPay promise : promiseToPaySet) {
        startEvaluationDate = promise.getStartEvaluationDate();
        finalEvaluationDate = promise.getEvaluationDate();

        if (log.isDebugEnabled()) {
          log.debug(
            "getPastNonEvaluatedPromises() :: startEvaluationDate: "
            + startEvaluationDate + "\nfinalEvaluationDate: "
            + finalEvaluationDate);
        }

        if ((finalEvaluationDate != null)
              && finalEvaluationDate.before(today)
              && (PromiseToPayStatus.OUTSTANDING.equals(
                  promise.getPtpStatus())
                || PromiseToPayStatus.FUTURE.equals(
                  promise.getPtpStatus()))) {
          pastNonEvaluatedPromiseSet.add(promise);
        }
      }
    } // end if

    return pastNonEvaluatedPromiseSet;
  } // end method getPastNonEvaluatedPromises

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Responsible getPaygResponsible() {
    if (responsibles == null) {
      return null;
    }

    if (responsibles.size() > 0) {
      for (Responsible responsible : responsibles) {
        ResponsibleDetail responsibleDetail = responsible.getResponsibleDetail();

        if ((responsibleDetail != null) && "payG".equalsIgnoreCase(responsibleDetail.getClientDefined50CharCode4())) {
          return responsible;
        }
      }
    }

    return null;
  } // end method getPaygResponsible

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment due date.
   *
   * @return  Date
   */
  public Date getPaymentDueDate() {
    return this.paymentDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getPaymentPostedYesterday() {
    if ((payments != null) && (payments.size() > 0)) {
      Date yesterday = DateUtil.getWayBackDate(-1, 12, 0, 0, 0);

      for (Payment payment : payments) {
        if ((payment.getPostDate() != null)
              && DateUtil.isSameDay(yesterday, payment.getPostDate())) {
          return Boolean.TRUE;
        }
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get payment program by index.
   *
   * @param   index  DOCUMENT ME!
   *
   * @return  get payment program by index
   */
  public PaymentProgram getPaymentProgram(int index) {
    PaymentProgram[] programs = paymentPrograms.toArray(
        new PaymentProgram[0]);

    if ((programs.length > index) && (programs[index] != null)) {
      return programs[index];
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get payment program's total amount.
   *
   * @param   index  DOCUMENT ME!
   *
   * @return  get payment program's total amount
   */
  public Integer getPaymentProgramDuration(int index) {
    PaymentProgram[] programs = paymentPrograms.toArray(
        new PaymentProgram[0]);

    if ((programs.length > index) && (programs[index] != null)) {
      return programs[index].getDuration();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The list of payment programs.
   *
   * @return  the list of payment programs
   */
  public List<PaymentProgram> getPaymentProgramList() {
    List<PaymentProgram> list = new ArrayList<PaymentProgram>();
    list.addAll(paymentPrograms);

    return list;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment programs.
   *
   * @return  Set
   */
  public Set<PaymentProgram> getPaymentPrograms() {
    return paymentPrograms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get payment program's total amount.
   *
   * @param   index  DOCUMENT ME!
   *
   * @return  get payment program's total amount
   */
  public BigDecimal getPaymentProgramTotalAmount(int index) {
    PaymentProgram[] programs = paymentPrograms.toArray(
        new PaymentProgram[0]);

    if ((programs.length > index) && (programs[index] != null)) {
      return programs[index].getTotalAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get payment program's total amount.
   *
   * @param   index   DOCUMENT ME!
   * @param   format  DOCUMENT ME!
   *
   * @return  get payment program's total amount
   */
  public String getPaymentProgramTotalAmountStr(int index, String format) {
    if (!StringUtils.hasText(format)) {
      format = "#####0.00";
    }

    DecimalFormat df     = new DecimalFormat(format);
    BigDecimal    amount = getPaymentProgramTotalAmount(index);

    if (amount != null) {
      return df.format(amount);
    }

    return "";
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
   * getter method for payment score.
   *
   * @return  Integer
   */
  public Integer getPaymentScore() {
    return this.paymentScore;
  }
  // Added by Etisbew on 05/01/09 to get Payments for JIRA # NC-249-START

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<Payment> getPaymentsList() {
    List<Payment> paymentsList = null;

    if ((getPayments() != null) && (getPayments().size() != 0)) {
      paymentsList = new ArrayList<Payment>();

      for (Payment payment : getPayments()) {
        paymentsList.add(payment);
      }
    }

    return paymentsList;
  }
  // percentMICoverage

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPercentMICoverage() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for persona accounts.
   *
   * @return  Set
   */
  public Set<PersonaAccount> getPersonaAccounts() {
    return personaAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for persona list.
   *
   * @return  List
   */
  public List<String> getPersonaList() {
    List<String> personaList = new ArrayList<String>();

    if (personaSet == null) {
      personaSet = new LinkedHashSet<String>();

      ArrayList<PersonaAction> personaActions = new ArrayList<PersonaAction>();

      for (PersonaAccount personaAccount : personaAccounts) {
        personaActions.add(personaAccount.getPersonaAction());
      }

      personaActions.sort(new PersonaActionComparator());

      for (PersonaAction personaAction : personaActions) {
        personaSet.add(personaAction.getName());
      }
    } // end if

    if ((null != personaSet) && (personaSet.size() > 0)) {
      personaList.addAll(personaSet);
    }

    return personaList;
  } // end method getPersonaList

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for placement sent.
   *
   * @return  Boolean
   */
  public Boolean getPlacementSent() {
    return placementSent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for planned exit date.
   *
   * @return  Date
   */
  public Date getPlannedExitDate() {
    return plannedExitDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * NCC ASAP Population ID.
   *
   * @return  nCC ASAP Population ID
   */
  public String getPopulationId() {
    return clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }
  // portfolioIndicator

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPortfolioIndicator() {
    return clientDefined20CharCode1;
  }
  // portfolioName

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPortfolioName() {
    return clientDefined20CharCode2;
  }
  // NCC Card PremId Risk Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreMidRiskScore() {
    return clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getPrePaymentAccount() {
    return Boolean.TRUE.equals(clientDefinedFlag1);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * NCC ASAP.
   *
   * @return  nCC ASAP
   */
  public Boolean getPrequalifiedRefi() {
    String pid = getPopulationId();

    if (StringUtils.hasText(pid)) {
      pid = pid.trim();
    }

    if ("R1".equalsIgnoreCase(pid)) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPreviousBalance() {
    return accountDetail.getPreviousBalance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPreviousExpectedPaymentDate() {
    PaymentProgramInstallment pInstallment = null;

    if (acceptedProgram != null) {
      pInstallment = acceptedProgram.getPreviousInstallmentByExpectedPaymentDate();
    }

    return (pInstallment == null) ? null : pInstallment.getExpectedPaymentDate();
  } // end method getPreviousExpectedPaymentDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPreviousInstallmentAmount() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getPreviousInstallmentAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPreviousInstallmentAmountByExpectedPaymentDate() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getPreviousInstallmentAmountByExpectedPaymentDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPreviousInstallmentDueDate() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getPreviousInstallmentDueDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPreviousInstallmentDueDateWithTolerance() {
    if (this.acceptedProgram != null) {
      return acceptedProgram.getPreviousInstallmentDueDateWithTolerance();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousInstallmentPaymentStatus() {
    if (this.acceptedProgram != null) {
      PaymentProgramInstallment installment = acceptedProgram.getPreviousInstallment();

      if (installment != null) {
        return installment.getInstallmentPaymentStatus().toString();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getPreviousInstallmentScheduled() {
    PaymentProgramInstallment installment = null;
    Boolean                   ret         = Boolean.FALSE;

    if (this.acceptedProgram != null) {
      installment = acceptedProgram.getPreviousInstallment();

      if (installment != null) {
        if (installment.getPayment() != null) {
          ret = Boolean.TRUE;
        }
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getPreviousInstallmentScheduledByExpectedPaymentDate() {
    PaymentProgramInstallment installment = null;
    Boolean                   ret         = Boolean.FALSE;

    if (this.acceptedProgram != null) {
      installment = acceptedProgram.getPreviousInstallmentByExpectedPaymentDate();

      if (installment != null) {
        if (installment.getPayment() != null) {
          ret = Boolean.TRUE;
        }
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousInstallmentStatus() {
    if (this.acceptedProgram != null) {
      PaymentProgramInstallment installment = acceptedProgram.getPreviousInstallment();

      if (installment != null) {
        return installment.getInstallmentStatus().toString();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousInstallmentStatusByExpectedPaymentDate() {
    if (this.acceptedProgram != null) {
      PaymentProgramInstallment installment = acceptedProgram.getPreviousInstallmentByExpectedPaymentDate();

      if (installment != null) {
        return installment.getInstallmentStatus().toString();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousOriginalAccountNumber() {
    if (accountNumberAudits.size() > 0) {
      AccountNumberAudit accountNumberAudit = accountNumberAudits.stream().sorted(Comparator.comparing(
            AccountNumberAudit::getCreateDate).reversed()).findFirst().orElse(null);

      return accountNumberAudit.getOldOriginalAccountNumber();
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Payment getPreviousPayment() {
    long    today   = (DateUtil.toDateOnly(new Date())).getTime();
    long    dateVal = 0;
    Payment ret     = null;

    for (Payment payment : this.payments) {
      if (payment != null) {
        long v = (payment.getPaymentDate()).getTime();

        if ((dateVal < v) && (v <= today)) {
          dateVal = v;
          ret     = payment;
        }
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPreviousPaymentAmount() {
    Payment payment = getPreviousPayment();

    if (payment != null) {
      return payment.getAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPreviousPaymentDate() {
    Payment payment = getPreviousPayment();

    if (payment != null) {
      return payment.getPaymentDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Payment getPreviousPaymentDeclined() {
    long    today   = (new Date()).getTime();
    long    dateVal = 0;
    Payment ret     = null;

    for (Payment payment : this.payments) {
      if ((payment != null)
            && PaymentStatus.REJECTED.equals(payment.getPaymentStatus())) {
        long v = -1;

        if (payment.getRejectedStatusDate() != null) {
          v = (payment.getRejectedStatusDate()).getTime();
        }

        if ((dateVal < v) && (v <= today)) {
          dateVal = v;
          ret     = payment;
        }
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPreviousPaymentDeclinedAmount() {
    Payment ret = getPreviousPaymentDeclined();

    if (ret != null) {
      return ret.getAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPreviousPaymentDeclinedDate() {
    Payment ret = getPreviousPaymentDeclined();

    if (ret != null) {
      return ret.getRejectedStatusDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentStatus getPreviousPaymentStatus() {
    Payment payment = getPreviousPayment();

    if (payment != null) {
      return payment.getPaymentStatus();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   promise  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay getPreviousPromise(PromiseToPay promise) {
    Set<PromiseToPay> allPromises = getPromises();

    /**
     * Return the previous promise only if there are more than one promise on
     * the account.
     */
    if ((promise != null) && (allPromises != null) && (allPromises.size() > 1)) {
      PromiseToPay[] promisesArr = allPromises.toArray(new PromiseToPay[] {});
      PromiseToPay   prevPromise = promisesArr[0];
      PromiseToPay   ptp         = null;

      for (int i = 1; i < promisesArr.length; i++) {
        ptp = promisesArr[i];

        if (ptp.getPromiseId().compareTo(promise.getPromiseId()) == 0) {
          return prevPromise;
        }

        prevPromise = ptp;
      }
    } // end if

    return null;
  } // end method getPreviousPromise

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPreviousWebPaymentAmount() {
    Payment payment = getPreviousWebPaymentPaid();

    if (payment != null) {
      return payment.getAmount();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Payment getPreviousWebPaymentCreated() {
    long    today   = (new Date()).getTime();
    long    dateVal = 0;
    Payment ret     = null;

    for (Payment payment : this.payments) {
      if ((payment != null) && payment.isCMCWebPayment()) {
        long v = (payment.getCreateDate()).getTime();

        if ((dateVal < v) && (v <= today)) {
          dateVal = v;
          ret     = payment;
        }
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPreviousWebPaymentCreateDate() {
    Payment payment = getPreviousWebPaymentCreated();

    if (payment != null) {
      return payment.getCreateDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPreviousWebPaymentDate() {
    Payment payment = getPreviousWebPaymentPaid();

    if (payment != null) {
      return payment.getPaymentDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Payment getPreviousWebPaymentPaid() {
    long    today   = (new Date()).getTime();
    long    dateVal = 0;
    Payment ret     = null;

    for (Payment payment : this.payments) {
      if ((payment != null) && payment.isCMCWebPayment()
            && PaymentStatus.PAID.equals(payment.getPaymentStatus())) {
        long v = (payment.getPaymentDate()).getTime();

        if ((dateVal < v) && (v <= today)) {
          dateVal = v;
          ret     = payment;
        }
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPrimaryLatestRiskScore3() {
    Responsible res = getPrimaryResponsible();

    if (res != null) {
      ResponsibleScore resScore = res.getLatestScore("RiskScore3");

      if (resScore != null) {
        return resScore.getScoreValue();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Responsible getPrimaryResponsible() {
    if (responsibles == null) {
      return null;
    }

    if (responsibles.size() == 1) {
      Iterator<Responsible> it = responsibles.iterator();

      if (it.hasNext()) {
        return it.next();
      }
    }

    for (Responsible responsible : responsibles) {
      if (Boolean.TRUE.equals(responsible.getPrimaryHolder())) {
        return responsible;
      }
    }

    // No primaryHolder==true and has more than one responsible
    // Get first in natural order
    Iterator<Responsible> it = responsibles.iterator();

    if (it.hasNext()) {
      return it.next();
    }

    return null;
  } // end method getPrimaryResponsible

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
  if(riskBand3 > 7 and riskSegment = 1){"H";}
  else
  if(riskBand3 > 7 and riskSegment = 2){"M";}
  else
  if(riskBand3 > 3 and riskBand3 < 7 and riskSegment >= 1){"M";}
  else {"L";}
   */
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPrimaryRiskIndicator() {
    Integer riskSegment = getPrimaryRiskSegment();
    Integer riskBand    = getPrimaryLatestRiskScore3();

    if (riskSegment != null) {
      if (riskBand > 7) {
        if (riskSegment.compareTo(Integer.valueOf(1)) == 0) {
          return "H";
        } else if (riskSegment.compareTo(Integer.valueOf(2)) == 0) {
          return "M";
        }
      } else if (riskBand > 3) {
        if (riskSegment.compareTo(Integer.valueOf(1)) >= 0) {
          return "M";
        }
      }
    }

    return "L";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPrimaryRiskSegment() {
    Responsible res = getPrimaryResponsible();

    if (res != null) {
      ResponsibleDetail resDet = res.getResponsibleDetail();

      if (resDet != null) {
        return resDet.getClientDefinedInteger1();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPrincipal() {
    return principal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get base amount based on amount type.
   *
   * @param   principalType  DOCUMENT ME!
   *
   * @return  get base amount based on amount type
   */
  public BigDecimal getPrincipalAmount(String principalType) {
    String[]   array = principalType.split("\\+");
    BigDecimal ret;

    if (array.length > 0) {
      ret = getPropertyAmount(array[0]);
    } else {
      return null;
    }

    for (int i = 1; i < array.length; i++) {
      if (StringUtils.hasText(array[i])) {
        ret = ret.add(doSubtractAmount(array[i]));
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPrincipalOutstanding() {
    return principalOutstanding;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority score.
   *
   * @return  Integer
   */
  public Integer getPriorityScore() {
    return this.priorityScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * NCC ASAP Project.
   *
   * @return  nCC ASAP Project
   */
  public boolean getPriorityStatus() {
    return Boolean.TRUE.equals(clientDefinedFlag3);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getPriorShortTermHardship() {
    return "Y".equalsIgnoreCase(accountDetail.getClientDefined1CharCode7()) ? Boolean.TRUE : Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * NCC ASAP Project.
   *
   * @return  nCC ASAP Project
   */
  public BigDecimal getProdD() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for product type.
   *
   * @return  String
   */
  public String getProductType() {
    return productType;
  }
  // NCC Program Accepted From client flag

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getProgramAcceptedFromClientFlag() {
    return Boolean.TRUE.equals(clientDefinedFlag1);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getProgramBroken() {
    if (this.acceptedProgram != null) {
      for (PaymentProgramInstallment installment : acceptedProgram.getInstallments()) {
        if (InstallmentStatus.BROKEN.equals(
                installment.getInstallmentStatus())) {
          return Boolean.TRUE;
        }
      }

      return Boolean.FALSE;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getProgramBrokenDate() {
    if (this.acceptedProgram != null) {
      for (PaymentProgramInstallment installment : acceptedProgram.getInstallments()) {
        if (InstallmentStatus.BROKEN.equals(
                installment.getInstallmentStatus())) {
          return installment.getBusinessInstallmentDueDate();
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getProgramFulfilled() {
    if (this.acceptedProgram != null) {
      for (PaymentProgramInstallment installment : acceptedProgram.getInstallments()) {
        if (!InstallmentStatus.FULFILLED.equals(
                installment.getInstallmentStatus())) {
          return Boolean.FALSE;
        }
      }

      return Boolean.TRUE;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getProgramOfferFlag() {
    if (Boolean.TRUE.equals(getClientDefinedFlag1())) {
      return Boolean.TRUE;
    } else if (Boolean.TRUE.equals(getClientDefinedFlag2())) {
      return Boolean.TRUE;
    } else if (Boolean.TRUE.equals(getClientDefinedFlag3())) {
      return Boolean.TRUE;
    }

    AccountDetail ad = this.getAccountDetail();

    if (ad != null) {
      if (Boolean.TRUE.equals(ad.getClientDefinedFlag1())) {
        return Boolean.TRUE;
      } else if (Boolean.TRUE.equals(ad.getClientDefinedFlag2())) {
        return Boolean.TRUE;
      } else if (Boolean.TRUE.equals(ad.getClientDefinedFlag3())) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  } // end method getProgramOfferFlag

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The programStartOrderId.
   *
   * @return  the programStartOrderId
   */
  public Integer getProgramStartIndex() {
    return programStartIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<ProgramTemplate> getProgramTemplates() {
    List<NegotiateExceptionResult> results = new ArrayList<NegotiateExceptionResult>();
    results.addAll(getNegotiateExceptionResults());
    Collections.sort(results, new NegotiateExceptionResultComparator());

    List<ProgramTemplate> templates = new ArrayList<ProgramTemplate>();

    for (NegotiateExceptionResult result : results) {
      templates.addAll(result.getExceptionRule().getProgramTemplates());
    }

    return templates;
  } // end method getProgramTemplates

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   ptpAmount          DOCUMENT ME!
   * @param   ptpArrivalDueDate  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay getPromise(BigDecimal ptpAmount, Date ptpArrivalDueDate) {
    if ((promises != null) && (ptpAmount != null) && (ptpArrivalDueDate != null)) {
      for (PromiseToPay ptp : promises) {
        if ((ptp.getPaymentAmount() != null) && (ptp.getArrivalDate() != null)) {
          if ((ptp.getPaymentAmount().doubleValue() == ptpAmount.doubleValue())
                && (DateUtil.getDayDifference(ptp.getArrivalDate(), ptpArrivalDueDate) == 0)) {
            return ptp;
          }
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   acceptAgentId      DOCUMENT ME!
   * @param   ptpAmount          DOCUMENT ME!
   * @param   ptpArrivalDueDate  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay getPromise(Long acceptAgentId, BigDecimal ptpAmount, Date ptpArrivalDueDate) {
    if ((promises != null) && (acceptAgentId != null)
          && (ptpAmount != null) && (ptpArrivalDueDate != null)) {
      for (PromiseToPay ptp : promises) {
        if ((ptp.getAcceptAgentId() != null)
              && (ptp.getPaymentAmount() != null)
              && (ptp.getArrivalDate() != null)) {
          if ((ptp.getAcceptAgentId().longValue()
                  == acceptAgentId.longValue())
                && (ptp.getPaymentAmount().doubleValue()
                  == ptpAmount.doubleValue())
                && (DateUtil.getDayDifference(ptp.getArrivalDate(),
                    ptpArrivalDueDate) == 0)) {
            return ptp;
          }
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promise amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPromiseAmount() {
    return promiseAmount;
  }
  // promiseDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPromiseClientDefinedDecimal() {
    return getClientDefinedDecimal1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPromiseDate() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promises.
   *
   * @return  Set
   */
  public Set<PromiseToPay> getPromises() {
    return promises;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   createDate  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay[] getPromises(Date createDate) {
    ArrayList<PromiseToPay> promisesWithSameCreateDateList = new ArrayList<PromiseToPay>();

    if (createDate != null) {
      int dayDiff = 0;

      for (PromiseToPay promise : promises) {
        dayDiff = DateUtil.getDayDifference(promise.getCreateDate(),
            createDate);

        if (dayDiff == 0) {
          promisesWithSameCreateDateList.add(promise);
        }
      }
    }

    return promisesWithSameCreateDateList.toArray(new PromiseToPay[] {});
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   ptpStatus  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<PromiseToPay> getPromisesWithStatus(PromiseToPayStatus ptpStatus) {
    if (ptpStatus != null) {
      Set<PromiseToPay>  promiseToPaySet  = getPromises();
      List<PromiseToPay> promiseToPayList = new ArrayList<PromiseToPay>();

      for (PromiseToPay promise : CollectionUtil.safeSet(promiseToPaySet)) {
        if (log.isDebugEnabled()) {
          log.debug("getPromisesWithStatus() :: " + promise.getPtpStatus() + "; " + promise.getArrivalDate());
        }

        if (ptpStatus.equals(promise.getPtpStatus())) {
          promiseToPayList.add(promise);
        }
      }

      return promiseToPayList;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns a list of all PromiseToPays in a certail status with arrival date after fromDate.
   *
   * @param   ptpStatus  DOCUMENT ME!
   * @param   fromDate   DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<PromiseToPay> getPromisesWithStatusFromArrivalDate(PromiseToPayStatus ptpStatus, Date fromDate) {
    if ((fromDate != null) && (ptpStatus != null)) {
      Set<PromiseToPay>  promiseToPaySet  = getPromises();
      List<PromiseToPay> promiseToPayList = new ArrayList<PromiseToPay>();

      for (PromiseToPay promise : CollectionUtil.safeSet(promiseToPaySet)) {
        if (log.isDebugEnabled()) {
          log.debug("getPromisesWithStatusFromArrivalDate() :: " + promise.getPtpStatus() + "; "
            + promise.getArrivalDate());
        }

        if (DateUtil.isAfterDate(promise.getArrivalDate(), fromDate) && ptpStatus.equals(promise.getPtpStatus())) {
          promiseToPayList.add(promise);
        }
      }

      return promiseToPayList;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   ptpStatus  DOCUMENT ME!
   * @param   fromDate   DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<PromiseToPay> getPromisesWithStatusFromSendDate(PromiseToPayStatus ptpStatus, Date fromDate) {
    if ((fromDate != null) && (ptpStatus != null)) {
      Set<PromiseToPay>  promiseToPaySet  = getPromises();
      List<PromiseToPay> promiseToPayList = new ArrayList<PromiseToPay>();

      for (PromiseToPay promise : CollectionUtil.safeSet(promiseToPaySet)) {
        if (log.isDebugEnabled()) {
          log.debug("getPromisesWithStatusFromSendDate() :: " + promise.getPtpStatus() + "; " + promise.getSendDate());
        }

        if (DateUtil.isAfterDate(promise.getSendDate(), fromDate) && ptpStatus.equals(promise.getPtpStatus())) {
          promiseToPayList.add(promise);
        }
      }

      return promiseToPayList;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the promise with date among startEvaluationDate finalEvaluationDate.
   *
   * @param   date  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay getPromiseUnderEvaluation(Date date) {
    List<PromiseToPay> outstandingPromises = getOutstandingOrFuturePromises();

    if ((date != null) && (outstandingPromises != null) && (outstandingPromises.size() > 0)) {
      for (PromiseToPay promise : outstandingPromises) {
        /**
         * startEvaluationDate <= date <= finalEvaluationDate
         */
        if (promise.isUnderEvaluationPeriod(date)) {
          return promise;
        }
      }
    } // end if

    return null;
  } // end method getPromiseUnderEvaluation

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get base amount based on amount type.
   *
   * @param   principalType  DOCUMENT ME!
   *
   * @return  get base amount based on amount type
   */
  public BigDecimal getPropertyAmount(String principalType) {
    BigDecimal principal = null;

    try {
      String        methodName = "get" + StringUtils.capitalize(principalType);
      MethodInvoker invoker    = new MethodInvoker();
      invoker.setTargetObject(this);
      invoker.setTargetMethod(methodName);
      invoker.prepare();
      principal = (BigDecimal) invoker.invoke();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

    return principal;
  } // end method getPropertyAmount

  //~ ------------------------------------------------------------------------------------------------------------------

  // propertyType
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPropertyType() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<QueueAccount> getQueueAccounts() {
    return queueAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for random digits.
   *
   * @return  Integer
   */
  public Integer getRandomDigits() {
    return this.randomDigits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReadingType() {
    return clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reage counter.
   *
   * @return  Integer
   */
  public Integer getReageCounter() {
    return reageCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recall results.
   *
   * @return  Set
   */
  public Set<RecallResult> getRecallResults() {
    return recallResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountPolicy getRecentOpenPolicy() {
    if ((accountPolicies != null) && (accountPolicies.size() > 0)) {
      for (AccountPolicy accountPolicyTemp : accountPolicies) {
        if ((accountPolicyTemp.getPolicyStatus() != null)
              && accountPolicyTemp.getPolicyStatus().equalsIgnoreCase("OPN")) {
          return accountPolicyTemp;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PolicyClaim getRecentOpenPolicyRecentClaim() {
    if (this.getRecentOpenPolicy() != null) {
      if ((this.getRecentOpenPolicy().getPolicyClaims() != null)
            && (this.getRecentOpenPolicy().getPolicyClaims().size() > 0)) {
        Iterator<PolicyClaim> policyClaimIterator = this.getRecentOpenPolicy().getPolicyClaims().iterator();

        while (policyClaimIterator.hasNext()) {
          return policyClaimIterator.next();
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRecentOpenPolicyTypeCode() {
    if (this.getRecentOpenPolicy() != null) {
      return this.getRecentOpenPolicy().getPolicyTypeCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountPolicy getRecentPolicy() {
    if ((accountPolicies != null) && (accountPolicies.size() > 0)) {
      Iterator<AccountPolicy> accountPolicyIterator = accountPolicies.iterator();

      while (accountPolicyIterator.hasNext()) {
        return accountPolicyIterator.next();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRecentPolicyClaimStatus() {
    if (this.getRecentPolicy() != null) {
      Set<PolicyClaim> policyClaims = this.getRecentPolicy().getPolicyClaims();

      if ((policyClaims != null) && (policyClaims.size() > 0)) {
        Iterator<PolicyClaim> policyClaimsIterator = policyClaims.iterator();

        while (policyClaimsIterator.hasNext()) {
          return policyClaimsIterator.next().getStatus();
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PolicyClaim getRecentPolicyRecentClaim() {
    if (this.getRecentPolicy() != null) {
      if ((this.getRecentPolicy().getPolicyClaims() != null) && (this.getRecentPolicy().getPolicyClaims().size() > 0)) {
        Iterator<PolicyClaim> policyClaimIterator = this.getRecentPolicy().getPolicyClaims().iterator();

        while (policyClaimIterator.hasNext()) {
          return policyClaimIterator.next();
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRecentPolicyStatus() {
    if (this.getRecentPolicy() != null) {
      this.getRecentPolicy().getPolicyStatus();
    }

    return null;
  }
  // COFS Recouncil Date

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getReconciledDate() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRecovererCode() {
    return recovererCode;
  }
  // reoValue

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys Placement File Record 100 userDefinedField3.
   *
   * @return  DOCUMENT ME!
   */
  public String getRegistrationNumber() {
    if (accountDetail != null) {
      return accountDetail.getClientDefined20CharCode1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getReoValue() {
    return principal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AccountOverallStatusRequiredDocument> getRequiredDocuments() {
    Set<AccountOverallStatusRequiredDocument> requiredDocumentOveralls =
      new LinkedHashSet<AccountOverallStatusRequiredDocument>();

    AccountOverallStatus accountOverallStatus = getAccountOverallStatus();

    if (accountOverallStatus != null) {
      AccountOverallStatusDetail detail = accountOverallStatus.getAccountOverallStatusDetail();

      for (AccountOverallStatusRequiredDocument requiredDocumentOverall : detail.getRequiredDocuments()) {
        requiredDocumentOveralls.add(requiredDocumentOverall);
      }
    }

    // return empty
    return requiredDocumentOveralls;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Find the first responsible that matches the SSN. NULL will match to NULL.
   *
   * @param   ssn  DOCUMENT ME!
   *
   * @return  find the first responsible that matches the SSN.
   */
  public Responsible getResponsible(String ssn) {
    if ((responsibles == null) || (responsibles.size() == 0)) {
      return null;
    }

    for (Responsible r : responsibles) {
      if ((ssn == null) && (r.getSsn() == null)) {
        return r;
      }

      if (ssn.equalsIgnoreCase(r.getSsn())) {
        return r; // ssn matches
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get responsible by sequence number.
   *
   * @param   sequenceNum  DOCUMENT ME!
   *
   * @return  get responsible by sequence number.
   */
  public Responsible getResponsible(Integer sequenceNum) {
    for (Responsible r : responsibles) {
      if (sequenceNum == null) {
        if (r.getSequenceNum() == null) {
          return r;
        }
      } else if (sequenceNum.equals(r.getSequenceNum())) {
        return r;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get responsible by firstname and lastname. NULL will match to NULL.
   *
   * @param   firstName  DOCUMENT ME!
   * @param   lastName   DOCUMENT ME!
   *
   * @return  get responsible by firstname and lastname.
   */
  public Responsible getResponsible(String firstName, String lastName) {
    if ((responsibles == null) || (responsibles.size() == 0)) {
      return null;
    }

    for (Responsible r : responsibles) {
      if (((firstName == null) && (r.getFirstName() != null))
            || ((firstName != null) && (r.getFirstName() == null))
            || ((firstName != null)
              && !firstName.equalsIgnoreCase(r.getFirstName()))) {
        continue; // firstName not match
      } else if (((lastName == null) && (r.getLastName() != null))
            || ((lastName != null) && (r.getLastName() == null))
            || ((lastName != null)
              && !lastName.equalsIgnoreCase(r.getLastName()))) {
        continue; // lastName not match
      }

      return r;
    }

    return null;
  } // end method getResponsible

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Find the first responsible (within this account) that matches given criteria. This method is used in account import
   * batch job. E.g., when ScoreNet dl file is imported repeatedly due to some errors, we do not want to generate
   * duplicate responsibles. This method is used to check whether the responsible already exists.
   *
   * <p>NULL will match to NULL.</p>
   *
   * @param   firstName  DOCUMENT ME!
   * @param   lastName   DOCUMENT ME!
   * @param   ssn        DOCUMENT ME!
   *
   * @return  find the first responsible (within this account) that matches given criteria.
   */
  public Responsible getResponsible(String firstName, String lastName, String ssn) {
    if ((responsibles == null) || (responsibles.size() == 0)) {
      return null;
    }

    for (Responsible r : responsibles) {
      if (((firstName == null) && (r.getFirstName() != null))
            || ((firstName != null) && (r.getFirstName() == null))
            || ((firstName != null)
              && !firstName.equalsIgnoreCase(r.getFirstName()))) {
        continue; // firstName not match
      } else if (((lastName == null) && (r.getLastName() != null))
            || ((lastName != null) && (r.getLastName() == null))
            || ((lastName != null)
              && !lastName.equalsIgnoreCase(r.getLastName()))) {
        continue; // lastName not match
      } else if (((ssn == null) && (r.getSsn() != null))
            || ((ssn != null) && (r.getSsn() == null))
            || ((ssn != null) && !ssn.equalsIgnoreCase(r.getSsn()))) {
        continue; // ssn not match
      }

      return r;
    }

    return null;
  } // end method getResponsible

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   customerType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Responsible getResponsibleByCustomerType2(String customerType) {
    if ((this.getResponsibles() != null) && (this.getResponsibles().size() > 0)) {
      for (Responsible r : this.getResponsibles()) {
        if ((r.getCustomerType() != null) && customerType.equalsIgnoreCase(r.getCustomerType().toString())) {
          return r;
        }
      }

      return null;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   ucid  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Responsible getResponsibleByUcid(String ucid) {
    if ((StringUtils.hasText(ucid)) && (getResponsibles() != null)
          && (getResponsibles().size() > 0)) {
      for (Responsible responsible : getResponsibles()) {
        ResponsibleIndex responsibleIndex = responsible.getResponsibleIndex();

        if ((responsibleIndex.getCustomer() != null)
              && (ucid.equalsIgnoreCase(responsibleIndex.getCustomer().getUcid()))) {
          return responsible;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getResponsibleCount() {
    if (responsibles == null) {
      return 0;
    }

    return responsibles.size();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getResponsibleName(String responsibleType) {
    StringBuffer sb = new StringBuffer();

    for (Responsible r : getResponsibles()) {
      if ((r.getResponsibleIndex() != null) && r.getResponsibleIndex().getResponsibleType().equals(responsibleType)) {
        sb.append(r.getFirstName() + " " + r.getMiddleName() + " " + r.getLastName() + ", ");
      }
    }

    if (sb.length() > 0) {
      sb.deleteCharAt(sb.lastIndexOf(","));
    }

    return sb.toString().trim();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsibles.
   *
   * @return  Set
   */
  public Set<Responsible> getResponsibles() {
    return responsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for revised date timestamp.
   *
   * @return  Date
   */
  public Date getRevisedDateTimestamp() {
    return revisedDateTimestamp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getRevolvingDebt() {
    return clientDefinedAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getRightOfOffsetLastUpdateDate() {
    return rightOfOffsetLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRightOfOffsetResult() {
    return rightOfOffsetResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for risk score.
   *
   * @return  Integer
   */
  public Integer getRiskScore() {
    return this.riskScore;
  }
  // rmsStatusCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRmsStatusCode() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for round counter.
   *
   * @return  Integer
   */
  public Integer getRoundCounter() {
    return roundCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getRUACurrentFicoScore() {
    Set<AccountScore> accountScores = getAccountScores();

    if ((accountScores != null) && (accountScores.size() > 0)) {
      for (AccountScore accScore : accountScores) {
        if ("FicoScore".equalsIgnoreCase(accScore.getScoreType().getScoreName())) {
          return accScore.getScoreValue();
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRUAWorkOutType() {
    if (accountStatuses != null) {
      for (AccountStatus status : accountStatuses) {
        if ("R08".equalsIgnoreCase(status.getStatusCode())) {
          return "Mod";
        }

        if ("R09".equalsIgnoreCase(status.getStatusCode())) {
          return "Short";
        }

        if ("R10".equalsIgnoreCase(status.getStatusCode())) {
          return "Deed";
        }

        if ("R11".equalsIgnoreCase(status.getStatusCode())) {
          return "Fore";
        }

        if ("R12".equalsIgnoreCase(status.getStatusCode())) {
          return "Pay";
        }

        if ("R13".equalsIgnoreCase(status.getStatusCode())) {
          return "HMP";
        }
      } // end for
    }   // end if

    return null;
  } // end method getRUAWorkOutType

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule batch id.
   *
   * @return  Long
   */
  public Long getRuleBatchId() {
    return ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getScheduledRecallDate() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school id.
   *
   * @return  String
   */
  public String getSchoolId() {
    if (accountDetail != null) {
      SlmSchoolStatus school = accountDetail.getSlmSchoolStatus();

      if (school != null) {
        return school.getSchoolId();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school name.
   *
   * @return  String
   */
  public String getSchoolName() {
    if (accountDetail != null) {
      SlmSchoolStatus school = accountDetail.getSlmSchoolStatus();

      if (school != null) {
        return school.getSchoolName();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal2.
   *
   * @return  the clientDefinedDecimal2
   */
  public BigDecimal getScoreNumber2() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal3.
   *
   * @return  the clientDefinedDecimal3
   */
  public BigDecimal getScoreNumber3() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal1.
   *
   * @return  the clientDefinedDecimal1
   */
  public BigDecimal getScoreNumbrw1() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for second agency placement date.
   *
   * @return  Date
   */
  public Date getSecondAgencyPlacementDate() {
    return secondAgencyPlacementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the most recent FUTURE statused PromiseToPay.
   *
   * @return  DOCUMENT ME!
   */
  public PromiseToPay getSecondMostRecentFuturePromiseToPay() {
    List<PromiseToPay> futurePromises = getFuturePromises();

    if ((futurePromises != null) && (futurePromises.size() > 1)) {
      return futurePromises.toArray(new PromiseToPay[] {})[1];
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for second to last login date.
   *
   * @return  Date
   */
  public Date getSecondToLastLoginDate() {
    return secondToLastLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for second to last login failure date.
   *
   * @return  Date
   */
  public Date getSecondToLastLoginFailureDate() {
    return secondToLastLoginFailureDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for second to last reage date.
   *
   * @return  Date
   */
  public Date getSecondToLastReageDate() {
    return this.secondToLastReageDate;
  }
  // COFS secondToLastWorkoutReageDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getSecondToLastWorkoutReageDate() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getSettlementExpirationDate() {
    return clientDefinedDate3;
  }
  // NCC Card Settlement Satisfy Date

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getSettlementSatisfyDate() {
    return clientDefinedDate2;
  } // NCC Settlement Expiration Date

  //~ ------------------------------------------------------------------------------------------------------------------

  // NCC Card Settlement Setup Date
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getSettlementSetupDate() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getShadowMode() {
    return shadowMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSlmMaxBucket() {
    SortedSet<Integer>        sortedBucketSet         = new TreeSet<Integer>();
    Set<BucketDelinquentData> bucketDelinquentDataSet = getPortfolio().getBucketDelinquentDataSet();

    if (bucketDelinquentDataSet == null) {
      return null;
    }

    Responsible responsible = getPrimaryResponsible();
    Date        now         = new Date();

    if (responsible == null) {
      Set<Responsible> responsibleSet = getResponsibles();

      if (responsibleSet != null) {
        Responsible[] responsibleArr = responsibleSet.toArray(
            new Responsible[] {});
        responsible = responsibleArr[0];
      }
    }

    Date    delinquencyDate        = null;
    int     numberOfDaysDelinquent = 0;
    Integer bucket                 = null;

    if ((responsible != null) && (bucketDelinquentDataSet != null)) {
      Set<Loan> loanSet = responsible.getNonChargedOffLoans();

      if (loanSet != null) {
        for (Loan loan : loanSet) {
          if ("P".equalsIgnoreCase(loan.getCategory())) {
            delinquencyDate = loan.getDelinquencyDate();

            if (delinquencyDate == null) {
              continue;
            }

            numberOfDaysDelinquent = DateUtil.getDayDifference(
                delinquencyDate, now);
            bucket                 = getDelinquencyBucket(bucketDelinquentDataSet,
                numberOfDaysDelinquent);

            if (bucket != null) {
              sortedBucketSet.add(bucket);
            }
          }
        }
      }
    } // end if

    if (sortedBucketSet.size() > 0) {
      return sortedBucketSet.last();
    } else {
      return null;
    }
  } // end method getSlmMaxBucket

  //~ ------------------------------------------------------------------------------------------------------------------

  // SmithBarneyCustomerFlag
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSmithBarneyCustomerFlag() {
    return clientDefined1CharCode5;
  }
  // SmithBarneyEmployeeFlag

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSmithBarneyEmployeeFlag() {
    return clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<SmsActivity> getSmsActivitiesFromSmsChannelResults() {
    List<SmsActivity> ret = new ArrayList<SmsActivity>();

    for (SmsChannelResult channelResult : exportedSmsResults) {
      SmsActivity smsActivity = new SmsActivity();
      smsActivity.setAccount(this);
      smsActivity.setResponsible(channelResult.getResponsible());
      smsActivity.setBalance(channelResult.getBalance());
      smsActivity.setDelinquencyDays(getDelinquencyDays());
      smsActivity.setCreateDate(channelResult.getCreateDate());
      smsActivity.setExecuteDate(channelResult.getExportDate());
      smsActivity.setTemplate(channelResult.getTemplate());
      smsActivity.setStatus(channelResult.getStatus().toString());
      ret.add(smsActivity);
    }

    for (SmsChannelResult channelResult : executedSmsResults) {
      SmsActivity smsActivity = new SmsActivity();
      smsActivity.setAccount(this);
      smsActivity.setResponsible(channelResult.getResponsible());
      smsActivity.setBalance(channelResult.getBalance());
      smsActivity.setDelinquencyDays(getDelinquencyDays());
      smsActivity.setPhoneNumber(channelResult.getPhoneNumber());
      smsActivity.setTemplate(channelResult.getTemplate());
      smsActivity.setResult(channelResult.getExecuteResult());
      smsActivity.setStatus(channelResult.getStatus().toString());
      smsActivity.setCreateDate(channelResult.getCreateDate());
      smsActivity.setExecuteDate(channelResult.getExecuteDate());
      ret.add(smsActivity);
    }

    return ret;
  } // end method getSmsActivitiesFromSmsChannelResults

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSPAccountProfileCode() {
    return clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSPAccountType() {
    String accountType = "";

    if ((this.clientDefinedDecimal1 != null)
          && (this.clientDefinedDecimal2 != null)
          && (this.clientDefinedDecimal1.compareTo(BigDecimal.ZERO) > 0)
          && (this.clientDefinedDecimal2.compareTo(BigDecimal.ZERO) > 0)) {
      accountType = "Dual";
    } else if ((this.clientDefinedDecimal1 != null)
          && (this.clientDefinedDecimal1.compareTo(BigDecimal.ZERO) > 0)) {
      accountType = "Electricity";
    } else if ((this.clientDefinedDecimal2 != null)
          && (this.clientDefinedDecimal2.compareTo(BigDecimal.ZERO) > 0)) {
      accountType = "Gas";
    }

    return accountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getSPHasPaymentProgramReminder() {
    return Boolean.TRUE;
  }
  // End of SP clientSpecifc Fields

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getSpocAgent() {
    if (accountInformation != null) {
      return accountInformation.getSpocAgent();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getSPPreviousInstallmentMissingReminderDate() {
    if (this.acceptedProgram != null) {
      PaymentProgramInstallment installment = acceptedProgram.getPreviousInstallmentByExpectedPaymentDate();

      if (installment != null) {
        return DateUtil.addBusinessDays(
            installment.getBusinessCustomerDueDate(), 3);
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for SPReport history.
   *
   * @return  Set
   */
  public Set<SPReportHistory> getSPReportHistory() {
    return spReportHistory;
  }
  // NCC Card State Entry Date

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sp report history.
   *
   * @return  Set
   */
  public Set<SPReportHistory> getSpReportHistory() {
    return spReportHistory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getStateEntryDate() {
    return clientDefinedDate5;
  }
  // NCC Card Statement Hold Code

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStatementHoldCode() {
    return clientDefined2CharCode1;
  }
  // COFS StatusReasonCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStatusReasonCode() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for student responsible.
   *
   * @return  Responsible
   */
  public Responsible getStudentResponsible() {
    for (Responsible responsible : responsibles) {
      if (CustomerType.S.equals(responsible.getCustomerType())) {
        return responsible;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getSuggestedAmount() {
    // if ("COFS".equalsIgnoreCase(portfolio.getClient().getName()))
    // return this.getTotalDue();
    if ("RBS".equalsIgnoreCase(portfolio.getName())
          || "NatWest".equalsIgnoreCase(portfolio.getName())) {
      if (pastDue == null) {
        return overLimit;
      }

      if (overLimit == null) {
        return pastDue;
      }

      return pastDue.add(overLimit);
    } else if (portfolio.getPortfolioId() == 900003L) {
      return currentDue;
    }

    return this.getTotalDue();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSwcLatestDispositionedAgencyCode() {
    List<AgentCallActivity> agencyAddChangeActivitiesList = getSwcDispositionAgencyAddChangeActivities();

    if ((agencyAddChangeActivitiesList != null) && (agencyAddChangeActivitiesList.size() > 0)) {
      AgentCallActivity          agencyAddChangeActivity = agencyAddChangeActivitiesList.get(
          agencyAddChangeActivitiesList.size() - 1);
      Set<PortfolioSurveyAnswer> surveyAnswers           = agencyAddChangeActivity.getPortfolioSurveyAnswers();

      if ((surveyAnswers != null) && (surveyAnswers.size() > 0)) {
        PortfolioSurveyAnswer[] surveyAnswerArr = surveyAnswers.toArray(new PortfolioSurveyAnswer[] {});

        if (surveyAnswerArr != null) {
          PortfolioSurveyAnswer surveyAnswer = surveyAnswerArr[0];

          if (surveyAnswer != null) {
            log.info("swcLatestDispositionedAgencyCode :: " + surveyAnswer.getData());

            return surveyAnswer.getData();
          }
        }
      } // end if
    }   // end if

    return null;
  } // end method getSwcLatestDispositionedAgencyCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSwcPreviouslyDispositionedAgencyCode() {
    List<AgentCallActivity> agencyAddChangeActivitiesList = getSwcDispositionAgencyAddChangeActivities();

    if ((agencyAddChangeActivitiesList != null) && (agencyAddChangeActivitiesList.size() > 1)) {
      AgentCallActivity          agencyAddChangeActivity = agencyAddChangeActivitiesList.get(
          agencyAddChangeActivitiesList.size() - 2);
      Set<PortfolioSurveyAnswer> surveyAnswers           = agencyAddChangeActivity.getPortfolioSurveyAnswers();

      if ((surveyAnswers != null) && (surveyAnswers.size() > 0)) {
        PortfolioSurveyAnswer[] surveyAnswerArr = surveyAnswers.toArray(new PortfolioSurveyAnswer[] {});

        if (surveyAnswerArr != null) {
          PortfolioSurveyAnswer surveyAnswer = surveyAnswerArr[0];

          if (surveyAnswer != null) {
            log.info("swcPreviouslyDispositionedAgencyCode :: " + surveyAnswer.getData());

            return surveyAnswer.getData();
          }
        }
      } // end if
    }   // end if

    return null;
  } // end method getSwcPreviouslyDispositionedAgencyCode

  //~ ------------------------------------------------------------------------------------------------------------------

  // NCC Card Terminal Risk Score
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTerminalRiskScore() {
    return clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for test account.
   *
   * @return  Boolean
   */
  public Boolean getTestAccount() {
    if (testAccount == null) {
      return Boolean.FALSE;
    }

    return testAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for test digit.
   *
   * @return  String
   */
  public String getTestDigit() {
    return testDigit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTestDigit1() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getTestDigit1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTestDigit2() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getTestDigit2();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTestDigit3() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getTestDigit3();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTestDigit4() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getTestDigit4();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTestDigit5() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getTestDigit5();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTestDigit6() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getTestDigit6();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTestDigit7() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getTestDigit7();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTestDigit8() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getTestDigit8();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTestDigit9() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getTestDigit9();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for third agency placement date.
   *
   * @return  Date
   */
  public Date getThirdAgencyPlacementDate() {
    return thirdAgencyPlacementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getThirdReageDate() {
    return accountDetail.getClientDefinedDate3();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the todays payments for the Account.
   *
   * @return  Payment
   */
  public List<Payment> getTodaysPayments() {
    List<Payment> returnPmts = new ArrayList<Payment>();
    Calendar      cal        = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);

    for (Payment payment : getPayments()) {
      if (payment.getCreateDate().after(cal.getTime())) {
        returnPmts.add(payment);
      }
    }

    return returnPmts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for top persona.
   *
   * @return  String
   */
  public String getTopPersona() {
    List<String> list = getPersonaList();

    if (list.size() > 0) {
      return list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getTotalAmountOfPromisesOutstanding() {
    List<PromiseToPay> outstandingPTPList        = getOutstandingOrFuturePromises();
    BigDecimal         totalOutstandingPTPAmount = BigDecimal.ZERO;

    for (PromiseToPay ptp : CollectionUtil.safeList(outstandingPTPList)) {
      totalOutstandingPTPAmount = totalOutstandingPTPAmount.add(ptp.getPaymentAmount());
    }

    return totalOutstandingPTPAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get total dur which is the total of current due and past due.
   *
   * @return  get total dur which is the total of current due and past due
   */
  public BigDecimal getTotalDue() {
    if (currentDue == null) {
      return pastDue;
    }

    if (pastDue == null) {
      return currentDue;
    }

    BigDecimal totalDue = currentDue.add(pastDue);

    return totalDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTotalElectricReading() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total number of payments.
   *
   * @return  Integer
   */
  public Integer getTotalNumberOfPayments() {
    return totalNumberOfPayments;
  }
  // Citi totalNumberOfPaymentsRemaining

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTotalNumberOfPaymentsRemaining() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   date  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getTotalOutstandingPaymentAmountBy(Date date) {
    if (date == null) {
      return null;
    }

    date = DateUtil.toDateOnly(date);

    BigDecimal amt = BigDecimal.ZERO;

    for (Payment payment : payments) {
      if (PaymentStatus.INPROCESS.equals(payment.getPaymentStatus())
            || PaymentStatus.SCHEDULED.equals(
              payment.getPaymentStatus())) {
        if ((DateUtil.toDateOnly(payment.getPaymentDate())).compareTo(
                date) <= 0) {
          amt = amt.add(payment.getAmount());
        }
      }
    }

    return amt;
  } // end method getTotalOutstandingPaymentAmountBy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getTotalOutstandingPaymentAmountByChargeOffDate() {
    return getTotalOutstandingPaymentAmountBy(chargeOffDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getTotalOutstandingPaymentAmountByDueDate() {
    return getTotalOutstandingPaymentAmountBy(paymentDueDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getTotalPaymentAmountAfterDecline() {
    return getOutStandingPaymentTotalAmount(
        getPreviousPaymentDeclinedDate(), null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTraceRequired() {
    return clientDefined1CharCode2;
  }
  // transactionCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTransactionCode() {
    return clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for treatments.
   *
   * @return  Set
   */
  public Set<TreatmentCandidate> getTreatments() {
    return treatments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * TRIAD SPID from Tsys.
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTriadSPID() {
    if (accountDetail != null) {
      return accountDetail.getTriadSPID();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public TsysAccount getTsysAccount() {
    return tsysAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountAccountType() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getAccountType();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getTsysAccountAvailableCredit() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getAvailableCredit();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountClientProductCode() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getClientProductCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public TsysAccountCustomData getTsysAccountCustomData() {
    return tsysAccountCustomData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getTsysAccountIdentifer() {
    if (getTsysAccount() != null) {
      return getTsysAccount().getTsysAccountIdentifier();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getTsysAccountLastAutoReageDate() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getLastAutoReageDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTsysAccountNumCardsIssued() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getNumCardsIssued();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode1() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode10() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode10();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode11() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode11();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode12() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode12();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode13() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode13();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode14() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode14();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode15() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode15();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode2() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode2();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode3() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode3();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode4() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode4();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode5() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode5();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode6() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode6();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode7() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode7();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode8() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode8();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedReasonCode9() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedReasonCode9();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode1() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode10() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode10();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode11() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode11();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode12() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode12();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode13() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode13();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode14() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode14();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode15() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode15();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode2() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode2();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode3() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode3();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode4() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode4();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode5() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode5();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode6() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode6();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode7() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode7();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode8() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode8();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountPrioritizedStatusCode9() {
    if (this.getTsysAccountStatusCode() != null) {
      return this.getTsysAccountStatusCode().getPrioritizedStatusCode9();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountProviderId1() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getProviderId1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountProviderId2() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getProviderId2();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysAccountRegionCode() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getRegionCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public TsysAccountStatusCode getTsysAccountStatusCode() {
    return tsysAccountStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTsysAccountTimesAutoReage() {
    if (this.getTsysAccount() != null) {
      return this.getTsysAccount().getTimesAutoReage();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getTsysAmountOfPaymentsCTD() {
    if (accountDetail != null) {
      BigDecimal amountOfPaymentsCTD = accountDetail.getClientDefinedDecimal5();

      if (amountOfPaymentsCTD != null) {
        BigDecimal roundedAmountOfPaymentsCTD = amountOfPaymentsCTD.round(new MathContext(3, RoundingMode.CEILING));

        return roundedAmountOfPaymentsCTD;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysKeptPromisesLTD() {
    if ((this.getTsysAccount() != null) && (this.getTsysAccount().getTsysAggregatedPromiseToPayHistory() != null)) {
      return this.getTsysAccount().getTsysAggregatedPromiseToPayHistory().getPromisesKeptLTD();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<TsysMemo> getTsysMemos() {
    return tsysMemos;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTsysOriginalBureauScore() {
    if (tsysAccount != null) {
      return tsysAccount.getOriginalBureauScore();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysPartialPromisesLTD() {
    if ((this.getTsysAccount() != null) && (this.getTsysAccount().getTsysAggregatedPromiseToPayHistory() != null)) {
      return this.getTsysAccount().getTsysAggregatedPromiseToPayHistory().getPartialPromisesLTD();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys Placement File Record 100 userDefinedField1.
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysUserDefinedField1() {
    if (accountDetail != null) {
      return accountDetail.getUserDefinedField1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys Placement File Record 100 userDefinedField2.
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysUserDefinedField2() {
    if (accountDetail != null) {
      return accountDetail.getUserDefinedField2();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys Placement File Record 100 userDefinedField3.
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysUserDefinedField3() {
    if (accountDetail != null) {
      return accountDetail.getUserDefinedField3();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys Placement File Record 100 userDefinedFieldS1.
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTsysUserDefinedFieldS1() {
    if (accountDetail != null) {
      return accountDetail.getUserDefinedFieldS1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   lastName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Responsible getUPCResponsible(String lastName) {
    if ((responsibles == null) || (responsibles.size() == 0)) {
      return null;
    }

    for (Responsible r : responsibles) {
      if ((lastName == null) && (r.getLastName() == null)) {
        log.info("lastName is null && res last name is null");

        return r;
      }

      if (lastName.equalsIgnoreCase(r.getLastName())) {
        log.info("lastName match return responsible");

        return r; // last name matches
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getUSB25() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 16277L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getUSB25Jan() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 17247L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getUSB35() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 16269L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getUSB35Jan() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 17245L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getUSB45() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 16267L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getUSB45Jan() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 17243L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getUSB55() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 16275L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getUSB65gt30Days() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 16279L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getUSB65lt30Days() {
    if ((paymentPrograms != null) && (paymentPrograms.size() > 0)) {
      for (PaymentProgram program : paymentPrograms) {
        if (program.getRuleId() == 16289L) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public USBAccount getUsbAccount() {
    return usbAccount;
  }
  // usbStatus

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getUSBStatus() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<UserLoadedAccount> getUserLoadedAccounts() {
    return userLoadedAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getValidPaymentProgramCount() {
    if (paymentPrograms == null) {
      return new Integer(0);
    }

    int i = 0;

    for (PaymentProgram p : paymentPrograms) {
      if (!Boolean.FALSE.equals(p.getActive())) {
        if (p.getExpirationDate() == null) {
          i++;
        } else if (CompareUtil.compareDateOnly(new Date(),
                p.getExpirationDate()) <= 0) {
          i++;
        }
      }
    }

    return new Integer(i);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * If viewOnlyWebAccess is true, then debtor is only able to see account summary.
   *
   * @return  if viewOnlyWebAccess is true, then debtor is only able to see account summary.
   */
  public Boolean getViewOnlyWebAccess() {
    if (viewOnlyWebAccess == null) {
      // NULL means full access, maximize
      // performance
      return Boolean.FALSE;
    }

    return viewOnlyWebAccess;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for voice mail activities.
   *
   * @return  Set
   */
  public Set<VoiceMailActivity> getVoiceMailActivities() {
    return voiceMailActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web activities.
   *
   * @return  Set
   */
  public Set<WebActivity> getWebActivities() {
    return this.webActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get eligible payment programs for the account. This method will not assume the payment programs are sorted and will
   * first sort the programs. If you are sure the programs have already been sorted (just out of DB and no new program
   * added), you should use <code>getWebEligiblePaymentPrograms()</code> to get better performance
   *
   * @return  the set of eligible payment programs
   */
  @SuppressWarnings("unchecked")
  public List<PaymentProgram> getWebEligiblePaymentPrograms() {
    List<PaymentProgram> programs      = new ArrayList<PaymentProgram>();
    List<PaymentProgram> batchPrograms = new ArrayList<PaymentProgram>();
    List<PaymentProgram> cidPrograms   = new ArrayList<PaymentProgram>();

    // Find all payment programs after start order index, inclusive. Sort is
    // needed because new programs may just be added
    // and not persisted yet.
    Iterator it = paymentPrograms.iterator();

    while (it.hasNext()) {
      PaymentProgram program       = (PaymentProgram) it.next();
      Integer        order         = program.getProgramOrder();
      ProgramAction  programAction = program.getProgramAction();

      log.info("Processing program with Id:" + program.getProgramId() + " with source:" + program.getSource());

      if ((order >= this.programStartIndex)
            && program.isInEffect()
            && ProgramStatus.INIT.equals(program.getProgramStatus())
            && ((programAction == null)
              || ((programAction != null) && Boolean.TRUE.equals(programAction.getWebOffer())))) {
        if (ProgramSource.BATCH.equals(program.getSource())) {
          log.info("BATCH Program:" + program.getLastUpdateDate());
          batchPrograms.add(program);
        } else {
          log.info("CID Program:" + program.getLastUpdateDate());
          cidPrograms.add(program);
        }
      }
    }

    log.info("BATCH Programs:" + batchPrograms.size() + " CID Programs:" + cidPrograms.size());

    // sort BATCH programs in descending lastUpdateDate without time followed by programOrder ascending
    if ((batchPrograms != null) && (batchPrograms.size() > 0)) {
      log.info("Sorting BATCH Programs");
      Collections.sort(batchPrograms,
        (a, b) -> {
          if (DateUtil.getDateStart(b.getLastUpdateDate()).compareTo(DateUtil.getDateStart(a.getLastUpdateDate()))
                != 0) {
            log.info("a:" + a.getLastUpdateDate());
            log.info("b:" + b.getLastUpdateDate());

            return DateUtil.getDateStart(b.getLastUpdateDate()).compareTo(DateUtil.getDateStart(a.getLastUpdateDate()));
          } else {
            log.info("Date is same order by programOrder:" + a.getProgramId());
            log.info(String.valueOf(a.getProgramOrder().compareTo(b.getProgramOrder())));

            return a.getProgramOrder().compareTo(b.getProgramOrder());
          }
        });
    }

    /*for(PaymentProgram pp: batchPrograms ){
      log.info(pp.getSource()+" Date:"+pp.getLastUpdateDate()+" Program Order:"+pp.getProgramOrder()+" Program Id:"+pp.getProgramId());
    }*/

    // sort CID programs in descending lastUpdateDate with time followed by ascending programOrder in case of same lastUpdateDate
    if ((cidPrograms != null) && (cidPrograms.size() > 0)) {
      log.info("Sorting CID Programs");
      Collections.sort(cidPrograms,
        (a, b) -> {
          if (b.getLastUpdateDate().compareTo(a.getLastUpdateDate()) != 0) {
            log.info("a:" + a.getLastUpdateDate());
            log.info("b:" + b.getLastUpdateDate());

            return b.getLastUpdateDate().compareTo(a.getLastUpdateDate());
          } else {
            log.info("Date is same order by programOrder:" + a.getProgramId());
            log.info(String.valueOf(a.getProgramOrder().compareTo(b.getProgramOrder())));

            return a.getProgramOrder().compareTo(b.getProgramOrder());
          }
        });
    }

    /*for(PaymentProgram pp: cidPrograms ){
      log.info(pp.getSource()+" Date:"+pp.getLastUpdateDate()+" Program Order:"+pp.getProgramOrder()+" Program Id:"+pp.getProgramId());
    }*/

    // Merge and sort the sorted CID and BATCH programs, CID programs on same day take precedence over BATCH programs
    // ProgramOder of BATCH programs take precendence over time on same day
    if ((cidPrograms.size() > 0) && (batchPrograms.size() > 0)) {
      log.info("Both CID and BATCH programs exist");

      Iterator<PaymentProgram> cpitr = cidPrograms.iterator();

      while (cpitr.hasNext()) {
        PaymentProgram cp = cpitr.next();
        log.info("CID Program:" + cp.getProgramId());

        Iterator<PaymentProgram> bpitr = batchPrograms.iterator();

        while (bpitr.hasNext()) {
          PaymentProgram bp = bpitr.next();
          log.info("BATCH Program:" + bp.getProgramId());

          if (DateUtil.getDateStart(cp.getLastUpdateDate()).compareTo(DateUtil.getDateStart(bp.getLastUpdateDate()))
                >= 0) {
            log.info("Adding CID Program to list:" + cp.getProgramId());
            programs.add(cp);
            cpitr.remove();

            break;
          }

          if (cp.getLastUpdateDate().compareTo(bp.getLastUpdateDate()) < 0) {
            log.info("Adding BATCH Program to list:" + bp.getProgramId());
            programs.add(bp);
            bpitr.remove();

          }
        }
      } // end while

    } // end if

    log.info("Check if BATCH or CID programs exist");

    if (batchPrograms.size() > 0) {
      log.info("Adding all BATCH programs");
      programs.addAll(batchPrograms);
    }

    if (cidPrograms.size() > 0) {
      log.info("Adding all CID programs");
      programs.addAll(cidPrograms);
    }

    log.info("Total programs to display:" + programs.size());

    // Remove redundant programs
    if (programs.size() > this.portfolio.getTotalProgramShown()) {
      programs.subList(this.portfolio.getTotalProgramShown(),
        programs.size()).clear();
    }

    return programs;
  } // end method getWebEligiblePaymentPrograms

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<ProgramTemplate> getWebOfferProgramTemplates() {
    List<ProgramTemplate> programTemplates = getProgramTemplates();
    List<ProgramTemplate> copy             = new ArrayList<ProgramTemplate>(
        programTemplates);

    for (ProgramTemplate programTemplate : copy) {
      if (Boolean.FALSE.equals(programTemplate.getWebOffer())) {
        programTemplates.remove(programTemplate);
      }
    }

    return programTemplates;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getWebSiteUrl() {
    if ((this.getDivision() != null)
          && StringUtils.hasText(this.getDivision().getWebSiteUrl())) {
      return this.getDivision().getWebSiteUrl();
    } else if (StringUtils.hasText(this.getPortfolio().getWebSiteUrl())) {
      return this.getPortfolio().getWebSiteUrl();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date Helper Get yesterday.
   *
   * @return  date Helper Get yesterday
   */
  public Date getYesterday() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);

    return DateUtil.toDateOnly(cal.getTime());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   code  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean hasAccountStatus(final String code) {
    return hasAccountStatus(code, true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   code  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean hasActiveAccountStatus(final String code) {
    return hasAccountStatus(code, false);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   programType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean hasActivePaymentProgram(final String programType) {
    if (paymentPrograms != null) {
      for (PaymentProgram program : paymentPrograms) {
        if ((program.getType() != null)
              && programType.equalsIgnoreCase(
                program.getType().getName())) {
          return Boolean.TRUE;
        }
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Does any account holder have the given address? Note this has nothing to do with address type.
   *
   * @param   address  DOCUMENT ME!
   *
   * @return  does any account holder have the given address?
   */
  public boolean hasAddress(Address address) {
    if (address == null) {
      return false;
    }

    for (Responsible r : responsibles) {
      for (ContactAddress a : r.getAddresses().values()) {
        if (a != null) {
          if (address.equals(a.getAddress())) {
            return true;
          }
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   address  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean hasAddress(ContactAddress address) {
    return hasAddress(address.getAddress());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean hasAgentCreatedPaymentsYesterday() {
    if (payments != null) {
      Iterator<Payment> paymentIterator = payments.iterator();
      Date              yesterDayDate   = getYesterday();

      while (paymentIterator.hasNext()) {
        Payment payment = paymentIterator.next();

        if (DateUtil.isSameDay(payment.getCreateDate(), yesterDayDate)
              && (payment.getPaymentChannel().equals(PaymentChannel.AGENCY))) {
          return Boolean.TRUE;
        }
      }
    }

    return Boolean.FALSE;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean hasAgentDeletedPaymentsYesterday() {
    if (payments != null) {
      Iterator<Payment> paymentIterator = payments.iterator();
      Date              yesterDayDate   = getYesterday();

      while (paymentIterator.hasNext()) {
        Payment payment = paymentIterator.next();

        if (DateUtil.isSameDay(payment.getDeletedStatusDate(), yesterDayDate)
              && (payment.getDeletedAgentId() != null)) {
          return Boolean.TRUE;
        }
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean hasAgentUpdatedPaymentsYesterday() {
    if (payments != null) {
      Iterator<Payment> paymentIterator = payments.iterator();
      Date              yesterDayDate   = getYesterday();

      while (paymentIterator.hasNext()) {
        Payment payment = paymentIterator.next();

        if (DateUtil.isSameDay(payment.getAgentUpdatedPaymentDate(), yesterDayDate)
              && !DateUtil.isSameDay(payment.getCreateDate(), yesterDayDate)) {
          return Boolean.TRUE;
        }
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean hasBrokenPromiseCancelledProgram() {
    if ((paymentPrograms == null) || (paymentPrograms.size() == 0)) {
      return null;
    }

    for (PaymentProgram program : paymentPrograms) {
      if (ProgramStatus.CANCELLEDBYBROKENPROMISE.equals(program.getProgramStatus())) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }
  // "Wilmington", "DE"

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   city   DOCUMENT ME!
   * @param   state  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean hasCityState(String city, String state) {
    return checkAccountAddressInfo("CityState", state, city);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean hasDebtorCancelledProgram() {
    if ((paymentPrograms == null) || (paymentPrograms.size() == 0)) {
      return null;
    }

    for (PaymentProgram program : paymentPrograms) {
      if (ProgramStatus.CANCELLEDBYDEBTOR.equals(program.getProgramStatus())
            || ProgramStatus.CANCELLEDBYCUSTOMER.equals(program.getProgramStatus())) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   channel                   DOCUMENT ME!
   * @param   destination               DOCUMENT ME!
   * @param   spokeTo                   DOCUMENT ME!
   * @param   coreDispositionCategory   DOCUMENT ME!
   * @param   portfolioDispositionCode  DOCUMENT ME!
   * @param   date                      DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean hasDisposition(String channel, String destination, String spokeTo, String coreDispositionCategory,
    String portfolioDispositionCode, Date date) {
    if (log.isDebugEnabled()) {
      log.debug("this.agentCallActivities: " + this.agentCallActivities);
    }

    for (AgentCallActivity ac : this.agentCallActivities) {
      if (log.isDebugEnabled()) {
        log.debug("this.agentCallActivities.size(): " + this.agentCallActivities.size());
      }

      if (log.isDebugEnabled()) {
        log.debug("date: " + date);
      }

      if (date != null) {
        if (log.isDebugEnabled()) {
          log.debug(
            "DateUtil.getDayDifference(DateUtil.toDateOnly(ac.getCreateDate()), DateUtil.toDateOnly(date)): "
            + DateUtil.getDayDifference(DateUtil.toDateOnly(ac.getCreateDate()), DateUtil.toDateOnly(date)));
        }

        if (DateUtil.getDayDifference(DateUtil.toDateOnly(ac.getCreateDate()), DateUtil.toDateOnly(date)) != 0) {
          continue;
        }
      }

      if (log.isDebugEnabled()) {
        log.debug("channel: " + channel);
      }

      if (StringUtils.hasText(channel)) {
        if (ac.getCoreAgentDispositionChannel() != null) {
          if (log.isDebugEnabled()) {
            log.debug("ac.getCoreAgentDispositionChannel().getShortCode(): "
              + ac.getCoreAgentDispositionChannel().getShortCode());
          }

          if (log.isDebugEnabled()) {
            log.debug("ac.getCoreAgentDispositionChannel().getChannel(): "
              + ac.getCoreAgentDispositionChannel().getChannel());
          }
        }

        if ((ac.getCoreAgentDispositionChannel() == null)
              || (!channel.equalsIgnoreCase(ac.getCoreAgentDispositionChannel().getShortCode())
                && !channel.equalsIgnoreCase(ac.getCoreAgentDispositionChannel().getChannel()))) {
          continue;
        }
      }

      if (log.isDebugEnabled()) {
        log.debug("destination: " + destination);
      }

      if (StringUtils.hasText(destination)) {
        if (ac.getCoreAgentDispositionDestination() != null) {
          if (log.isDebugEnabled()) {
            log.debug("ac.getCoreAgentDispositionDestination().getShortCode(): "
              + ac.getCoreAgentDispositionDestination().getShortCode());
          }

          if (log.isDebugEnabled()) {
            log.debug("ac.getCoreAgentDispositionDestination().getDestination(): "
              + ac.getCoreAgentDispositionDestination().getDestination());
          }
        }

        if ((ac.getCoreAgentDispositionDestination() == null)
              || (!destination.equalsIgnoreCase(ac.getCoreAgentDispositionDestination().getShortCode())
                && !destination.equalsIgnoreCase(ac.getCoreAgentDispositionDestination().getDestination()))) {
          continue;
        }
      }

      if (log.isDebugEnabled()) {
        log.debug("spokeTo: " + spokeTo);
      }

      if (StringUtils.hasText(spokeTo)) {
        if (ac.getCoreAgentDispositionSpokeTo() != null) {
          if (log.isDebugEnabled()) {
            log.debug("ac.getCoreAgentDispositionSpokeTo().getShortCode(): "
              + ac.getCoreAgentDispositionSpokeTo().getShortCode());
          }

          if (log.isDebugEnabled()) {
            log.debug("ac.getCoreAgentDispositionSpokeTo().getSpokeTo(): "
              + ac.getCoreAgentDispositionSpokeTo().getSpokeTo());
          }
        }

        if ((ac.getCoreAgentDispositionSpokeTo() == null)
              || (!spokeTo.equalsIgnoreCase(ac.getCoreAgentDispositionSpokeTo().getShortCode())
                && !spokeTo.equalsIgnoreCase(ac.getCoreAgentDispositionSpokeTo().getSpokeTo()))) {
          continue;
        }
      }

      if (log.isDebugEnabled()) {
        log.debug("portfolioDispositionCode: " + portfolioDispositionCode);
      }

      if (StringUtils.hasText(portfolioDispositionCode)) {
        if (ac.getPortfolioAgentDispositionCode() != null) {
          if (log.isDebugEnabled()) {
            log.debug("ac.getPortfolioAgentDispositionCode().getDispositionCode(): "
              + ac.getPortfolioAgentDispositionCode().getDispositionCode());
          }
        }

        if ((ac.getPortfolioAgentDispositionCode() == null)
              || !portfolioDispositionCode.equalsIgnoreCase(
                ac.getPortfolioAgentDispositionCode().getDispositionCode())) {
          continue;
        }
      }

      if (log.isDebugEnabled()) {
        log.debug("coreDispositionCategory: " + coreDispositionCategory);
      }

      if (StringUtils.hasText(coreDispositionCategory)) {
        if ((ac.getPortfolioAgentDispositionCode() != null)
              && (ac.getPortfolioAgentDispositionCode().getCoreDispositionCategory() != null)) {
          if (log.isDebugEnabled()) {
            log.debug(
              "ac.getPortfolioAgentDispositionCode().getCoreDispositionCategory().getDispositionCategory(): "
              + ac.getPortfolioAgentDispositionCode().getCoreDispositionCategory().getDispositionCategory());
          }
        }

        if ((ac.getPortfolioAgentDispositionCode() == null)
              || (ac.getPortfolioAgentDispositionCode().getCoreDispositionCategory() == null)
              || !coreDispositionCategory.equalsIgnoreCase(
                ac.getPortfolioAgentDispositionCode().getCoreDispositionCategory().getDispositionCategory())) {
          continue;
        }
      }

      return Boolean.TRUE;
    } // end for

    return Boolean.FALSE;
  } // end method hasDisposition

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean hasExtensionProgramOffer() {
    Iterator<PaymentProgram> programs = getPaymentPrograms().iterator();

    while (programs.hasNext()) {
      PaymentProgram paymentProgram = programs.next();

      if (paymentProgram.getType().getProgramTypeId().toString().equals(
              "100")) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((agencyAccountNumber == null) ? 0 : agencyAccountNumber.hashCode());
    result = (prime * result)
      + ((createDate == null) ? 0 : createDate.hashCode());
    result = (prime * result)
      + ((originalAccountNumber == null) ? 0 : originalAccountNumber.hashCode());
    result = (prime * result)
      + ((originalCreditor == null) ? 0 : originalCreditor.hashCode());
    result = (prime * result)
      + ((originalDateTimestamp == null) ? 0 : originalDateTimestamp.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean hasOutstandingPromiseToPay() {
    PromiseToPay promiseToPayUnderEvaluation = getOutstandingPromise();

    if (promiseToPayUnderEvaluation != null) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean hasPendingPayment() {
    for (Payment payment : getPayments()) {
      if (payment.getPaymentStatus().equals(PaymentStatus.INPROCESS)
            || payment.getPaymentStatus().equals(
              PaymentStatus.SCHEDULED)) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   type  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean hasPhone(String type) {
    if ((getAllPhoneNum(type) != null) && (getAllPhoneNum(type).size() > 0)) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * <p>public boolean hasPendingPayment() { for (Payment payment : getPayments()) { if
   * (payment.getPaymentStatus().equals(PaymentStatus.INPROCESS) || payment.getPaymentStatus().equals(
   * PaymentStatus.SCHEDULED)) { return true; } } return false; } //~
   * ------------------------------------------------------------------------------------------------------------------
   * /** DOCUMENT ME!</p>
   *
   * @return  DOCUMENT ME!
   */
  public boolean hasReageProgramOffer() {
    Iterator<PaymentProgram> programs = getPaymentPrograms().iterator();

    while (programs.hasNext()) {
      PaymentProgram paymentProgram = programs.next();

      if (paymentProgram.getType().getProgramTypeId().toString().equals(
              "101")) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether the two account got same account number.
   *
   * @param   other  DOCUMENT ME!
   *
   * @return  check whether the two account got same account number
   */
  public boolean hasSameAccountNum(Account other) {
    if ((this.accountNum == null) || (other.getAccountNum() == null)) {
      return false;
    }

    return accountNum.equals(other.getAccountNum());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean hasScheduledPayment() {
    if (getPayments() == null) {
      return false;
    }

    for (Payment payment : this.getPayments()) {
      if (payment.getPaymentStatus().equals(PaymentStatus.SCHEDULED)) {
        return true;
      }
    }

    return false;
  }
  // check the account has State(state)

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   state  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean hasState(String state) {
    return checkAccountAddressInfo("State", state, null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   zipCode  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean hasZipCode(String zipCode) {
    return checkAccountAddressInfo("ZipCode", zipCode, null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the PromiseToPay that is currently in its evaluation period - NOT necessarily the one that is tagged
   * OUTSTANDING! This is time specific. This returns Promises for INACTIVE accounts as well.
   */
  public void inactivateOutstandingOrFuturePromiseToPays() {
    List<PromiseToPay> nonEvaluatedPromiseToPays = getOutstandingPromises();

    if ((nonEvaluatedPromiseToPays != null) && (nonEvaluatedPromiseToPays.size() > 0)) {
      for (PromiseToPay promise : nonEvaluatedPromiseToPays) {
        promise.setPtpStatus(PromiseToPayStatus.INACTIVE);
      }
    }
  } // end method inactivateOutstandingOrFuturePromiseToPays

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * increase round counter.
   */
  public void increaseRoundCounter() {
    if ((roundCounter == null) || (roundCounter <= 0)) {
      roundCounter = 0;
    }

    roundCounter++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void increaseViewedCounter() {
    if ((agentViewedCounter == null) || (agentViewedCounter <= 0)) {
      agentViewedCounter = 0;
    }

    agentViewedCounter++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void increaseWorkedCounter() {
    if ((agentWorkedCounter == null) || (agentWorkedCounter <= 0)) {
      agentWorkedCounter = 0;
    }

    agentWorkedCounter++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   queue  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean inQueue(String queue) {
    for (QueueAccount queueAccount : this.queueAccounts) {
      QueueAction queueAction = queueAccount.getQueueAction();

      if (queueAction.getName().equals(queue)
            || queueAction.getId().toString().equals(queue)) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isActive() {
    return Boolean.TRUE.equals(getActive());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * S Get the locked actively.
   *
   * @return  s Get the locked actively
   */
  public boolean isActiveLocked() {
    return (isLocked() && (!isLockExpired()));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * If all responsibles are bankrupt, return true. Otherwise, return false.
   *
   * @return  if all responsibles are bankrupt, return true.
   */
  public boolean isBankrupt() {
    for (Responsible r : responsibles) {
      if (!r.isBankrupt()) {
        return false;
      }
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isBBLRecoveryAccount() {
    String cardStatus = this.getClientDefined3CharCode1();

    if ("ZZ".equalsIgnoreCase(cardStatus)) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isBillingCycleDay() {
    if (billingCycle != null) {
      return DateUtil.isSameDayOfMonth(billingCycle.intValue());
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the flag for the account claimed.
   *
   * @return  get the flag for the account claimed
   */
  public boolean isClaimed() {
    return (claimAgent != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the flag that account is claim by the agent.
   *
   * @param   agent  DOCUMENT ME!
   *
   * @return  get the flag that account is claim by the agent
   */
  public boolean isClaimedBy(User agent) {
    if (agent != null) {
      return agent.equals(this.claimAgent);
    }

    return false;
  }
  // Delinquency days > 29

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isDelinquent() {
    boolean returnValue = false;

    if ((getDelinquencyDays() != null) && (getDelinquencyDays() > 0)) {
      returnValue = getDelinquencyDays() > 29;
    }

    return returnValue;
  }
  // check the account has MobilePhone(phoneNumber)

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   phoneNumber  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isDestinationMobilePhone(String phoneNumber) {
    Set<Responsible> responsibleSet = this.getResponsibles();

    if ((responsibleSet != null) && (responsibleSet.size() > 0)) {
      for (Responsible responsible : responsibleSet) {
        if ((responsible.getPhones() != null) && (responsible.getPhones().size() > 0)) {
          Set<String> types = responsible.getPhones().keySet();

          for (String type : types) {
            ContactPhone contactPhone = responsible.getPhones().get(type);

            if ((contactPhone.getPhoneType() != null)
                  && contactPhone.getPhoneType().getTypeId().equals(ContactChannel.MOBILEPHONE.getTypeId())) {
              return true;
            }
          }
        }
      }
    }

    Set<AccountAuthorizedContact> authorizedContacts = this.getAccountAuthorizedContacts();

    if ((authorizedContacts != null) && (authorizedContacts.size() > 0)) {
      for (AccountAuthorizedContact authorizedContact : authorizedContacts) {
        if ((authorizedContact.getPhones() != null) && (authorizedContact.getPhones().size() > 0)) {
          Set<String> types = authorizedContact.getPhones().keySet();

          for (String type : types) {
            AuthorizedContactPhone contactPhone = authorizedContact.getPhones().get(type);

            if ((contactPhone.getPhoneType() != null)
                  && contactPhone.getPhoneType().getTypeId().equals(ContactChannel.MOBILEPHONE.getTypeId())) {
              return true;
            }
          }
        }
      }
    }

    Set<AccountAuthorizedUser> authorizedUsers = this.getAccountAuthorizedUsers();

    if ((authorizedUsers != null) && (authorizedUsers.size() > 0)) {
      for (AccountAuthorizedUser authorizedUser : authorizedUsers) {
        if ((authorizedUser.getPhones() != null) && (authorizedUser.getPhones().size() > 0)) {
          Set<String> types = authorizedUser.getPhones().keySet();

          for (String type : types) {
            AuthorizedUserPhone contactPhone = authorizedUser.getPhones().get(type);

            if ((contactPhone.getPhoneType() != null)
                  && contactPhone.getPhoneType().getTypeId().equals(ContactChannel.MOBILEPHONE.getTypeId())) {
              return true;
            }
          }
        }
      }
    }

    return false;
  } // end method isDestinationMobilePhone

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isEvenFriday() {
    return DateUtil.isEvenFriday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isEvenMonday() {
    return DateUtil.isEvenMonday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isEvenSaturday() {
    return DateUtil.isEvenSaturday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isEvenSunday() {
    return DateUtil.isEvenSunday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isEvenThursday() {
    return DateUtil.isEvenThursday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isEvenTuesday() {
    return DateUtil.isEvenTuesday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isEvenWednesday() {
    return DateUtil.isEvenWednesday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the lock flag for the account.
   *
   * @return  get the lock flag for the account
   */
  public boolean isLocked() {
    return (agent != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the flag account locked by agent.
   *
   * @param   agent  DOCUMENT ME!
   *
   * @return  get the flag account locked by agent
   */
  public boolean isLockedBy(User agent) {
    if (isActiveLocked() && agent.equals(this.agent)) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the lock flag expired.
   *
   * @return  get the lock flag expired
   */
  public boolean isLockExpired() {
    if (lockExpirationTime != null) {
      return (new Date().after(lockExpirationTime));
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isOddFriday() {
    return DateUtil.isOddFriday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Helper method for date access regarding the entry date.
   *
   * @return  helper method for date access regarding the entry date
   */
  public boolean isOddMonday() {
    return DateUtil.isOddMonday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isOddSaturday() {
    return DateUtil.isOddSaturday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isOddSunday() {
    return DateUtil.isOddSunday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isOddThursday() {
    return DateUtil.isOddThursday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isOddTuesday() {
    return DateUtil.isOddTuesday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isOddWednesday() {
    return DateUtil.isOddWednesday(entryDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   promiseToPay  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isOutstandingPromiseToPay(PromiseToPay promiseToPay) {
    PromiseToPay outstandingPromiseToPay = getOutstandingPromise();

    if ((promiseToPay != null) && (outstandingPromiseToPay != null)) {
      if (outstandingPromiseToPay.getPromiseId().compareTo(promiseToPay.getPromiseId()) == 0) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isProgramAcceptedFromClientFlag() {
    return Boolean.TRUE.equals(clientDefinedFlag1);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * return the flag that the account is an business account.
   *
   * @return  return the flag that the account is an business account
   */
  public boolean isSmallBusiness() {
    return (CustomerType.C.equals(this.customerType));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isTestAccount() {
    return Boolean.TRUE.equals(this.testAccount);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Lock the account for the agent.
   *
   * @param   agent  DOCUMENT ME!
   *
   * @return  lock the account for the agent
   */
  public boolean lock(User agent) {
    if (!isActiveLocked()) {
      if ((!isClaimed()) || isClaimedBy(agent)) {
        Date now = new Date();
        this.agent              = agent;
        this.lockTime           = now;
        this.lastUpdateDate     = now;
        this.lockExpirationTime = null;
        increaseWorkedCounter();
        this.setLastWorkDate(now);

        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set phone level do-not-contact. This method enumerates all responsibles and make sure all contact phones with the
   * provided phone number be set as do-not-contact.
   *
   * @param  phoneNum           DOCUMENT ME!
   * @param  doNotContactUntil  DOCUMENT ME!
   * @param  reason             DOCUMENT ME!
   * @param  reasonId           DOCUMENT ME!
   */
  public void markDoNotContactPhoneNum(String phoneNum, Date doNotContactUntil, DoNotContactReason reason,
    String reasonId) {
    for (Responsible r : responsibles) {
      r.markDoNotContactPhoneNum(phoneNum, doNotContactUntil, reason,
        reasonId);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Mark phone number as bad. This method enumerates all responsibles and make sure all contact phones with the
   * provided phone number be marked as bad phone number.
   *
   * @param  phoneNum  DOCUMENT ME!
   */
  public void markPhoneNumBad(String phoneNum) {
    for (Responsible r : responsibles) {
      r.markPhoneNumBad(phoneNum);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Mark phone number as wrong. This method enumerates all responsibles and make sure all contact phones with the
   * provided phone number be marked as bad phone number.
   *
   * @param  phoneNum  DOCUMENT ME!
   */
  public void markPhoneNumWrong(String phoneNum) {
    for (Responsible r : responsibles) {
      r.markPhoneNumWrong(phoneNum);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Release claim for account.
   *
   * @return  release claim for account
   */
  public boolean release() {
    if (this.claimAgent != null) {
      Date now = new Date();
      this.claimAgent     = null;
      this.claimTime      = null;
      this.lastUpdateDate = now;

      return true;
    }

    return false;
  }
  /*
   * public boolean removeAccountStatus(String statusCode) { if (statusCode ==
   * null) return false; boolean retValue = false; Iterator<AccountStatus>
   * iter = accountStatuses.iterator(); while (iter.hasNext()) { AccountStatus
   * accountStatus = iter.next(); if
   * (accountStatus.getAccountOverallStatusDetail().getStatusCode().equals(
   * statusCode)) { iter.remove(); retValue = true; } } return retValue; }
   */

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void removeAccountOverallStatus() {
    for (AccountOverallStatus overallStatus : accountOverallStatusSet) {
      if (!overallStatus.getHistorical()) {
        overallStatus.setLastUpdateDate(new Date());
        overallStatus.setHistorical(Boolean.TRUE);

        break;
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   statusCode  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean removeAccountStatus(AccountStatusCode statusCode) {
    if (statusCode == null) {
      return false;
    }

    boolean                 ret = false;
    Date                    now = new Date();
    Iterator<AccountStatus> it  = accountStatuses.iterator();

    while (it.hasNext()) {
      AccountStatus status = it.next();

      if (statusCode.equals(status.getAccountStatusCode())) {
        it.remove();
        status.setHistorical(Boolean.TRUE);
        status.setRemoveDate(now);
        status.setLastUpdateDate(now);
        historicalAccountStatuses.add(status);
        ret = true;
      }
    }

    return ret;
  } // end method removeAccountStatus

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   threeLetterCode  statusCode threeLetterCode DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean removeAccountStatus(String threeLetterCode) {
    return removeAccountStatus(AccountStatusCode.toAccountStatusCode(
          threeLetterCode));
  } // end method removeAccountStatus

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   statusDetailId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean removeAccountStatus(Long statusDetailId) {
    return removeAccountStatus(AccountStatusCode.toAccountStatusCode(
          statusDetailId));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   statusCode  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean removeAccountStatusByStatusCode(String statusCode) {
    if (statusCode == null) {
      return false;
    }

    boolean                 ret = false;
    Date                    now = new Date();
    Iterator<AccountStatus> it  = accountStatuses.iterator();

    while (it.hasNext()) {
      AccountStatus status = it.next();

      if (statusCode.equals(status.getStatusCode())) {
        status.setHistorical(Boolean.TRUE);
        status.setRemoveDate(now);
        status.setLastUpdateDate(now);
        historicalAccountStatuses.add(status);
        ret = true;
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void removeAllPhoneTypeDependencyStatus() {
    for (Responsible responsible : responsibles) {
      removePhoneTypeDependencyStatus(responsible.getPhones());
      removePhoneTypeDependencyStatus(responsible.getTemporaryPhones());
      removePhoneTypeDependencyStatus(responsible.getFuturePermanentPhones());
    } // end for

    for (AccountAuthorizedUser authorizedUser : this.getAccountAuthorizedUsers()) {
      removePhoneTypeDependencyStatus(authorizedUser.getPhones());
      removePhoneTypeDependencyStatus(authorizedUser.getTemporaryPhones());
      removePhoneTypeDependencyStatus(authorizedUser.getFuturePermanentPhones());
    } // end for

    for (AccountAuthorizedContact authorizedContact : this.getAccountAuthorizedContacts()) {
      removePhoneTypeDependencyStatus(authorizedContact.getPhones());
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove document, mark delete and push to history record.
   *
   * @param  agent       DOCUMENT ME!
   * @param  documentId  DOCUMENT ME!
   */
  public void removeDocument(User agent, Long documentId) {
    Document document = findDocument(documentId);

    // copy to historical
    DocumentHistory documentHistory = new DocumentHistory(document);
    documentHistories.add(documentHistory);

    // found the document and marked it as inactive
    document.setActive(false);
    document.setLastUpdateAgent(agent);
    document.setLastUpdateDate(new Date());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void removeTsysAccount() {
    if (tsysAccount != null) {
      this.tsysAccount = null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Rotates the OUTSTANDING status to the next future PromiseToPay if the outstanding PromiseToPay has already passed
   * its final evaluation date.
   *
   * @param   outstandingPromiseToPay  DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   */
  public PromiseToPay rotateOutstandingPromiseToPay(PromiseToPay outstandingPromiseToPay) {
    Date today = DateUtil.toDateOnly(new Date());

    /**
     * If the currently outstanding PromiseToPay is tagged INACTIVE status, then all of the FUTURE tagged PromiseToPay should be tagged inactive as well.
     */
    if (outstandingPromiseToPay != null) {
      if (!PromiseToPayStatus.INACTIVE.equals(
              outstandingPromiseToPay.getPtpStatus())) {
        /**
         * Outstanding PromiseToPay status is KEPT or BROKEN or
         * Outstanding PromiseToPay Final Evaluation Date is on or before today.
         */
        if ((PromiseToPayStatus.KEPT.equals(outstandingPromiseToPay.getPtpStatus()))
              || (PromiseToPayStatus.BROKEN.equals(outstandingPromiseToPay.getPtpStatus()))) {
          PromiseToPay nextFuturePromiseToPay = getMostRecentFuturePromiseToPay();

          if (log.isDebugEnabled()) {
            log.debug("Account.rotateOutstandingPromiseToPay("
              + outstandingPromiseToPay
              + "):: nextFuturePromiseToPay: "
              + nextFuturePromiseToPay);
          }

          if (nextFuturePromiseToPay != null) {
            nextFuturePromiseToPay.setPtpStatus(PromiseToPayStatus.OUTSTANDING);

            return nextFuturePromiseToPay;
          } // end if
        }   // end if
      }     // end if
    }       // end if

    return null;
  } // end method rotateOutstandingPromiseToPay

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  acceptedProgram  the acceptedProgramId to set
   */
  public void setAcceptedProgram(PaymentProgram acceptedProgram) {
    this.acceptedProgram = acceptedProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  acceptProgramDate  DOCUMENT ME!
   */
  public void setAcceptProgramDate(Date acceptProgramDate) {
    this.acceptProgramDate = acceptProgramDate;
  }
  // Terms and Conditions

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode2  DOCUMENT ME!
   */
  public void setAcceptTerms(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountAdditionalDetail  DOCUMENT ME!
   */
  public void setAccountAdditionalDetail(AccountAdditionalDetail accountAdditionalDetail) {
    this.accountAdditionalDetail = accountAdditionalDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountAssignedExternalEntities  DOCUMENT ME!
   */
  public void setAccountAssignedExternalEntities(Set<AccountAssignedExternalEntity> accountAssignedExternalEntities) {
    this.accountAssignedExternalEntities = accountAssignedExternalEntities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountAuthorizedContacts  DOCUMENT ME!
   */
  public void setAccountAuthorizedContacts(Set<AccountAuthorizedContact> accountAuthorizedContacts) {
    this.accountAuthorizedContacts = accountAuthorizedContacts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountAuthorizedUsers  DOCUMENT ME!
   */
  public void setAccountAuthorizedUsers(Set<AccountAuthorizedUser> accountAuthorizedUsers) {
    this.accountAuthorizedUsers = accountAuthorizedUsers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountBalanceBreakDown  DOCUMENT ME!
   */
  public void setAccountBalanceBreakDown(AccountBalanceBreakDown accountBalanceBreakDown) {
    this.accountBalanceBreakDown = accountBalanceBreakDown;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountConfig  DOCUMENT ME!
   */
  public void setAccountConfig(AccountConfig accountConfig) {
    this.accountConfig = accountConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountDelinquent  DOCUMENT ME!
   */
  public void setAccountDelinquent(AccountDelinquent accountDelinquent) {
    this.accountDelinquent = accountDelinquent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountDetail  DOCUMENT ME!
   */
  public void setAccountDetail(AccountDetail accountDetail) {
    this.accountDetail = accountDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountExtension  DOCUMENT ME!
   */
  public void setAccountExtension(AccountExtension accountExtension) {
    this.accountExtension = accountExtension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account extension boolean.
   *
   * @param  accountExtensionBoolean  AccountExtensionBoolean
   */
  public void setAccountExtensionBoolean(AccountExtensionBoolean accountExtensionBoolean) {
    this.accountExtensionBoolean = accountExtensionBoolean;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account extension char.
   *
   * @param  accountExtensionChar  AccountExtensionChar
   */
  public void setAccountExtensionChar(AccountExtensionChar accountExtensionChar) {
    this.accountExtensionChar = accountExtensionChar;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account extension date.
   *
   * @param  accountExtensionDate  AccountExtensionDate
   */
  public void setAccountExtensionDate(AccountExtensionDate accountExtensionDate) {
    this.accountExtensionDate = accountExtensionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account extension decimal.
   *
   * @param  accountExtensionDecimal  AccountExtensionDecimal
   */
  public void setAccountExtensionDecimal(AccountExtensionDecimal accountExtensionDecimal) {
    this.accountExtensionDecimal = accountExtensionDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account extension integer.
   *
   * @param  accountExtensionInteger  AccountExtensionInteger
   */
  public void setAccountExtensionInteger(AccountExtensionInteger accountExtensionInteger) {
    this.accountExtensionInteger = accountExtensionInteger;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountFlexSelectConfigAuditSet  DOCUMENT ME!
   */
  public void setAccountFlexSelectConfigAuditSet(Set<AccountFlexSelectConfigAudit> accountFlexSelectConfigAuditSet) {
    this.accountFlexSelectConfigAuditSet = accountFlexSelectConfigAuditSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountFlowVariableValues  DOCUMENT ME!
   */
  public void setAccountFlowVariableValues(Set<AccountFlowVariableValue> accountFlowVariableValues) {
    this.accountFlowVariableValues = accountFlowVariableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountIndex  DOCUMENT ME!
   */
  public void setAccountIndex(AccountIndex accountIndex) {
    this.accountIndex = accountIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountIndicator  DOCUMENT ME!
   */
  public void setAccountIndicator(String accountIndicator) {
    this.clientDefined1CharCode1 = accountIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountInformation  DOCUMENT ME!
   */
  public void setAccountInformation(AccountInformation accountInformation) {
    this.accountInformation = accountInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountMetaData  DOCUMENT ME!
   */
  public void setAccountMetaData(Set<AccountMetaData> accountMetaData) {
    this.accountMetaData = accountMetaData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the account num.
   *
   * @param  accountNum  the accountNum to set
   */
  public void setAccountNum(Long accountNum) {
    this.accountNum = accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account number audits.
   *
   * @param  accountNumberAudits  Set
   */
  public void setAccountNumberAudits(Set<AccountNumberAudit> accountNumberAudits) {
    this.accountNumberAudits = accountNumberAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountOverallStatus  DOCUMENT ME!
   */
  public void setAccountOverallStatus(AccountOverallStatus accountOverallStatus) {
    if (accountOverallStatus != null) {
      for (AccountOverallStatus overallStatus : accountOverallStatusSet) {
        if (!overallStatus.getHistorical()) {
          overallStatus.setHistorical(Boolean.TRUE);

          break;
        }
      }

      accountOverallStatusSet.add(accountOverallStatus);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account overall status set.
   *
   * @param  accountOverallStatusSet  Set
   */
  public void setAccountOverallStatusSet(Set<AccountOverallStatus> accountOverallStatusSet) {
    this.accountOverallStatusSet = accountOverallStatusSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountPolicies  DOCUMENT ME!
   */
  public void setAccountPolicies(Set<AccountPolicy> accountPolicies) {
    this.accountPolicies = accountPolicies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountSaleInfoSet  DOCUMENT ME!
   */
  public void setAccountSaleInfoSet(Set<AccountSaleInfo> accountSaleInfoSet) {
    this.accountSaleInfoSet = accountSaleInfoSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountScores  DOCUMENT ME!
   */
  public void setAccountScores(Set<AccountScore> accountScores) {
    this.accountScores = accountScores;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account SOR.
   *
   * @param  accountSOR  AccountSOR
   */
  public void setAccountSOR(AccountSOR accountSOR) {
    this.accountSOR = accountSOR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountStatuses  DOCUMENT ME!
   */
  public void setAccountStatuses(Set<AccountStatus> accountStatuses) {
    this.accountStatuses = accountStatuses;
  }
  // Gopal 07/22/09 Added for SP Client Specific fields
  // Account Type

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode1  DOCUMENT ME!
   */
  public void setAccountType(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accruedInterest  DOCUMENT ME!
   */
  public void setAccruedInterest(BigDecimal accruedInterest) {
    this.accruedInterest = accruedInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the active flag.
   *
   * @param  active  the active to set
   */
  public void setActive(Boolean active) {
    this.active = active;
  }
  // COFS ActiveMortgageTrades

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  activeMortgageTrades  DOCUMENT ME!
   */
  public void setActiveMortgageTrades(Integer activeMortgageTrades) {
    this.clientDefinedInteger1 = activeMortgageTrades;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the actual exit date.
   *
   * @param  actualExitDate  the actualExitDate to set
   */
  public void setActualExitDate(Date actualExitDate) {
    this.actualExitDate = actualExitDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  date  DOCUMENT ME!
   */
  public void setAdjustedPaidToDate(Date date) {
    this.clientDefinedDate4 = date;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set agency account number.
   *
   * @param  agencyAccountNumber  the agencyAccountNumber to set
   */
  public void setAgencyAccountNumber(String agencyAccountNumber) {
    this.agencyAccountNumber = agencyAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agencyAccountSet  DOCUMENT ME!
   */
  public void setAgencyAccountSet(Set<AgencyAccount> agencyAccountSet) {
    this.agencyAccountSet = agencyAccountSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the agencyQueue.
   *
   * @param  agencyQueue  the agencyQueue to set
   */
  public void setAgencyQueue(AgencyQueue agencyQueue) {
    this.agencyQueue = agencyQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agencyTeamQueue  DOCUMENT ME!
   */
  public void setAgencyTeamQueue(AgencyTeamQueue agencyTeamQueue) {
    this.agencyTeamQueue = agencyTeamQueue;
  }
  // Agency Transaction Code

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode2  DOCUMENT ME!
   */
  public void setAgencyTransactionCode(String clientDefined2CharCode2) {
    this.clientDefined2CharCode2 = clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agent  the agent to set
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentCallActivities  the agentCallActivities to set
   */
  public void setAgentCallActivities(Set<AgentCallActivity> agentCallActivities) {
    this.agentCallActivities = agentCallActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentQueue  DOCUMENT ME!
   */
  public void setAgentQueue(AgentQueue agentQueue) {
    this.agentQueue = agentQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentViewedCounter  DOCUMENT ME!
   */
  public void setAgentViewedCounter(Integer agentViewedCounter) {
    this.agentViewedCounter = agentViewedCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentWorkedCounter  DOCUMENT ME!
   */
  public void setAgentWorkedCounter(Integer agentWorkedCounter) {
    this.agentWorkedCounter = agentWorkedCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowProgram  DOCUMENT ME!
   */
  public void setAllowProgram(Boolean allowProgram) {
    if (this.getAccountDetail() != null) {
      this.getAccountDetail().setAllowProgram(allowProgram);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowWeb  the allowWeb to set
   */
  public void setAllowWeb(Boolean allowWeb) {
    this.allowWeb = allowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Called by SP Account Loader.
   *
   * @param  clientDefinedAmount1  DOCUMENT ME!
   */
  public void setAmendedAmount(BigDecimal clientDefinedAmount1) {
    this.clientDefinedAmount1 = clientDefinedAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Called by SP Account Loader.
   *
   * @param  clientDefinedFlag3  DOCUMENT ME!
   */
  public void setAmendedBill(boolean clientDefinedFlag3) {
    this.clientDefinedFlag3 = clientDefinedFlag3;
  }
  // Added by Etisbew on 07/29/09 for SP Specific Fields-End
  // Added by Gopal on 08/09/09 for RBS Specific Fields-Start

  //~ ------------------------------------------------------------------------------------------------------------------

  // Application
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode1  DOCUMENT ME!
   */
  public void setApplication(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  appointments  DOCUMENT ME!
   */
  public void setAppointments(Set<AdvisorAppointment> appointments) {
    this.appointments = appointments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the annual percentage rate.
   *
   * @param  apr  the apr to set
   */
  public void setApr(BigDecimal apr) {
    this.apr = apr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode3  DOCUMENT ME!
   */
  public void setArrangementStatusCode(String clientDefined1CharCode3) {
    this.clientDefined1CharCode3 = clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  DOCUMENT ME!
   */
  public void setArrangementType(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assets.
   *
   * @param  assets  Set
   */
  public void setAssets(Set<ContractAssets> assets) {
    this.assets = assets;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode5  DOCUMENT ME!
   */
  public void setAuthCode(String clientDefined1CharCode5) {
    this.clientDefined1CharCode5 = clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  auto  DOCUMENT ME!
   */
  public void setAuto(AccountAuto auto) {
    this.auto = auto;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for auto debit details.
   *
   * @param  autoDebitDetails  Set
   */
  public void setAutoDebitDetails(Set<AutoDebitDetail> autoDebitDetails) {
    this.autoDebitDetails = autoDebitDetails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  autoPayFlag  DOCUMENT ME!
   */
  public void setAutoPayFlag(Boolean autoPayFlag) {
    this.clientDefinedFlag1 = autoPayFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode1  DOCUMENT ME!
   */
  public void setAuxStatusCodes(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  availableCredit  DOCUMENT ME!
   */
  public void setAvailableCredit(BigDecimal availableCredit) {
    this.availableCredit = availableCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  availableCreditForCash  DOCUMENT ME!
   */
  public void setAvailableCreditForCash(BigDecimal availableCreditForCash) {
    this.availableCreditForCash = availableCreditForCash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the balance.
   *
   * @param  balance  the balance to set
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  position  DOCUMENT ME!
   */
  public void setBankruptcyFlag(String position) {
    this.clientDefined1CharCode3 = position;
  }
  // Balance at risk

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode1  DOCUMENT ME!
   */
  public void setBar(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  barclayAccount  DOCUMENT ME!
   */
  public void setBarclayAccount(BarclayAccount barclayAccount) {
    this.barclayAccount = barclayAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  batchFileDate  the batchFileDate to set
   */
  public void setBatchFileDate(Date batchFileDate) {
    this.batchFileDate = batchFileDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the batch id.
   *
   * @param  batchId  the batchId to set
   */
  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  behaviorScore  the behaviorScore to set
   */
  public void setBehaviorScore(Integer behaviorScore) {
    this.behaviorScore = behaviorScore;
  }
  // billFromDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate2  DOCUMENT ME!
   */
  public void setBillFromDate(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the billing cycle.
   *
   * @param  billingCycle  the billingCyle to set
   */
  public void setBillingCycle(Integer billingCycle) {
    this.billingCycle = billingCycle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the billing date.
   *
   * @param  billingDate  the billingDate to set
   */
  public void setBillingDate(Date billingDate) {
    this.billingDate = billingDate;
  }
  // BillIssueDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate1  DOCUMENT ME!
   */
  public void setBillIssueDate(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }
  // billToDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate3  DOCUMENT ME!
   */
  public void setBillToDate(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the broken promise flag.
   *
   * @param  brokenPromise  the brokenPromise to set
   */
  public void setBrokenPromise(Boolean brokenPromise) {
    this.brokenPromise = brokenPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the broken promise date.
   *
   * @param  brokenPromiseDate  the brokenPromiseDate to set
   */
  public void setBrokenPromiseDate(Date brokenPromiseDate) {
    this.brokenPromiseDate = brokenPromiseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the bucket amount1.
   *
   * @param  bucketAmount1  the bucketAmount1 to set
   */
  public void setBucketAmount1(BigDecimal bucketAmount1) {
    this.bucketAmount1 = bucketAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the bucket amount2.
   *
   * @param  bucketAmount2  the bucketAmount2 to set
   */
  public void setBucketAmount2(BigDecimal bucketAmount2) {
    this.bucketAmount2 = bucketAmount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the bucket amount3.
   *
   * @param  bucketAmount3  the bucketAmount3 to set
   */
  public void setBucketAmount3(BigDecimal bucketAmount3) {
    this.bucketAmount3 = bucketAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the bucket amount4.
   *
   * @param  bucketAmount4  the bucketAmount4 to set
   */
  public void setBucketAmount4(BigDecimal bucketAmount4) {
    this.bucketAmount4 = bucketAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the bucket amount5.
   *
   * @param  bucketAmount5  the bucketAmount5 to set
   */
  public void setBucketAmount5(BigDecimal bucketAmount5) {
    this.bucketAmount5 = bucketAmount5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the bucket amount6.
   *
   * @param  bucketAmount6  the bucketAmount6 to set
   */
  public void setBucketAmount6(BigDecimal bucketAmount6) {
    this.bucketAmount6 = bucketAmount6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the bucket amount7.
   *
   * @param  bucketAmount7  the bucketAmount7 to set
   */
  public void setBucketAmount7(BigDecimal bucketAmount7) {
    this.bucketAmount7 = bucketAmount7;
  }
  // NCC cacs state code

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode1  DOCUMENT ME!
   */
  public void setCacsStateCode(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cancelProgramDate  the cancelProgramDate to set
   */
  public void setCancelProgramDate(Date cancelProgramDate) {
    this.cancelProgramDate = cancelProgramDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag3  DOCUMENT ME!
   */
  public void setCBNACustomerFlag(Boolean clientDefinedFlag3) {
    this.clientDefinedFlag3 = clientDefinedFlag3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  chargeOff  DOCUMENT ME!
   */
  public void setChargeOff(Boolean chargeOff) {
    this.chargeOff = chargeOff;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the charge off amount.
   *
   * @param  chargeOffAmount  the chargeOffAmount to set
   */
  public void setChargeOffAmount(BigDecimal chargeOffAmount) {
    this.chargeOffAmount = chargeOffAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the charge off date.
   *
   * @param  chargeOffDate  the chargeOffDate to set
   */
  public void setChargeOffDate(Date chargeOffDate) {
    this.chargeOffDate = chargeOffDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  chargeOffDelayExclusion  DOCUMENT ME!
   */
  public void setChargeOffDelayExclusion(Set<ChargeOffDelayExclusion> chargeOffDelayExclusion) {
    this.chargeOffDelayExclusion = chargeOffDelayExclusion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  chargeOffReasonCode  DOCUMENT ME!
   */
  public void setChargeOffReasonCode(String chargeOffReasonCode) {
    this.chargeOffReasonCode = chargeOffReasonCode;
  }
  // Charge Payment Amount

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal3  DOCUMENT ME!
   */
  public void setChargePaymentAmount(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  citiAccount  DOCUMENT ME!
   */
  public void setCitiAccount(CitiAccount citiAccount) {
    this.citiAccount = citiAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  claimAgent  the claimAgent to set
   */
  public void setClaimAgent(User claimAgent) {
    this.claimAgent = claimAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  claimTime  the claimTime to set
   */
  public void setClaimTime(Date claimTime) {
    this.claimTime = claimTime;
  }
  // NCC Client Accepted Program ID

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined6CharCode2  DOCUMENT ME!
   */
  public void setClientAcceptedProgramId(String clientDefined6CharCode2) {
    this.clientDefined6CharCode2 = clientDefined6CharCode2;
  }
  // NCC Client Accepted Program Status

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode8  DOCUMENT ME!
   */
  public void setClientAcceptedProgramStatus(String clientDefined1CharCode8) {
    this.clientDefined1CharCode8 = clientDefined1CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the client code.
   *
   * @param  clientCode  the clientCode to set
   */
  public void setClientCode(Integer clientCode) {
    this.clientCode = clientCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientContactDate  DOCUMENT ME!
   */
  public void setClientContactDate(Date clientContactDate) {
    this.clientContactDate = clientContactDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode1  DOCUMENT ME!
   */
  public void setClientDefined1CharCode1(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode2  DOCUMENT ME!
   */
  public void setClientDefined1CharCode2(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode3  DOCUMENT ME!
   */
  public void setClientDefined1CharCode3(String clientDefined1CharCode3) {
    this.clientDefined1CharCode3 = clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode4  DOCUMENT ME!
   */
  public void setClientDefined1CharCode4(String clientDefined1CharCode4) {
    this.clientDefined1CharCode4 = clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode5  DOCUMENT ME!
   */
  public void setClientDefined1CharCode5(String clientDefined1CharCode5) {
    this.clientDefined1CharCode5 = clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode6  DOCUMENT ME!
   */
  public void setClientDefined1CharCode6(String clientDefined1CharCode6) {
    this.clientDefined1CharCode6 = clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode7  DOCUMENT ME!
   */
  public void setClientDefined1CharCode7(String clientDefined1CharCode7) {
    this.clientDefined1CharCode7 = clientDefined1CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode8  DOCUMENT ME!
   */
  public void setClientDefined1CharCode8(String clientDefined1CharCode8) {
    this.clientDefined1CharCode8 = clientDefined1CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode1  DOCUMENT ME!
   */
  public void setClientDefined20CharCode1(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode2  DOCUMENT ME!
   */
  public void setClientDefined20CharCode2(String clientDefined20CharCode2) {
    this.clientDefined20CharCode2 = clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode3  DOCUMENT ME!
   */
  public void setClientDefined20CharCode3(String clientDefined20CharCode3) {
    this.clientDefined20CharCode3 = clientDefined20CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  DOCUMENT ME!
   */
  public void setClientDefined2CharCode1(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode2  DOCUMENT ME!
   */
  public void setClientDefined2CharCode2(String clientDefined2CharCode2) {
    this.clientDefined2CharCode2 = clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode3  DOCUMENT ME!
   */
  public void setClientDefined2CharCode3(String clientDefined2CharCode3) {
    this.clientDefined2CharCode3 = clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode1  DOCUMENT ME!
   */
  public void setClientDefined3CharCode1(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode2  DOCUMENT ME!
   */
  public void setClientDefined3CharCode2(String clientDefined3CharCode2) {
    this.clientDefined3CharCode2 = clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode1  DOCUMENT ME!
   */
  public void setClientDefined4CharCode1(String clientDefined4CharCode1) {
    this.clientDefined4CharCode1 = clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode2  DOCUMENT ME!
   */
  public void setClientDefined4CharCode2(String clientDefined4CharCode2) {
    this.clientDefined4CharCode2 = clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode3  DOCUMENT ME!
   */
  public void setClientDefined4CharCode3(String clientDefined4CharCode3) {
    this.clientDefined4CharCode3 = clientDefined4CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined6CharCode1  DOCUMENT ME!
   */
  public void setClientDefined6CharCode1(String clientDefined6CharCode1) {
    this.clientDefined6CharCode1 = clientDefined6CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined6CharCode2  DOCUMENT ME!
   */
  public void setClientDefined6CharCode2(String clientDefined6CharCode2) {
    this.clientDefined6CharCode2 = clientDefined6CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedAmount1  DOCUMENT ME!
   */
  public void setClientDefinedAmount1(BigDecimal clientDefinedAmount1) {
    this.clientDefinedAmount1 = clientDefinedAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate1  DOCUMENT ME!
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate2  DOCUMENT ME!
   */
  public void setClientDefinedDate2(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate3  DOCUMENT ME!
   */
  public void setClientDefinedDate3(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate4  DOCUMENT ME!
   */
  public void setClientDefinedDate4(Date clientDefinedDate4) {
    this.clientDefinedDate4 = clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate5  DOCUMENT ME!
   */
  public void setClientDefinedDate5(Date clientDefinedDate5) {
    this.clientDefinedDate5 = clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate6  DOCUMENT ME!
   */
  public void setClientDefinedDate6(Date clientDefinedDate6) {
    this.clientDefinedDate6 = clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal1  DOCUMENT ME!
   */
  public void setClientDefinedDecimal1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal2  DOCUMENT ME!
   */
  public void setClientDefinedDecimal2(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal3  DOCUMENT ME!
   */
  public void setClientDefinedDecimal3(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag1  DOCUMENT ME!
   */
  public void setClientDefinedFlag1(Boolean clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag2  DOCUMENT ME!
   */
  public void setClientDefinedFlag2(Boolean clientDefinedFlag2) {
    this.clientDefinedFlag2 = clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag3  DOCUMENT ME!
   */
  public void setClientDefinedFlag3(Boolean clientDefinedFlag3) {
    this.clientDefinedFlag3 = clientDefinedFlag3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger1  DOCUMENT ME!
   */
  public void setClientDefinedInteger1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger2  DOCUMENT ME!
   */
  public void setClientDefinedInteger2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger3  DOCUMENT ME!
   */
  public void setClientDefinedInteger3(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger4  DOCUMENT ME!
   */
  public void setClientDefinedInteger4(Integer clientDefinedInteger4) {
    this.clientDefinedInteger4 = clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger5  DOCUMENT ME!
   */
  public void setClientDefinedInteger5(Integer clientDefinedInteger5) {
    this.clientDefinedInteger5 = clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger6  DOCUMENT ME!
   */
  public void setClientDefinedInteger6(Integer clientDefinedInteger6) {
    this.clientDefinedInteger6 = clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger7  DOCUMENT ME!
   */
  public void setClientDefinedInteger7(Integer clientDefinedInteger7) {
    this.clientDefinedInteger7 = clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger8  DOCUMENT ME!
   */
  public void setClientDefinedInteger8(Integer clientDefinedInteger8) {
    this.clientDefinedInteger8 = clientDefinedInteger8;
  }
  // NCC client portfolio ID

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientPortfolioId  DOCUMENT ME!
   */
  public void setClientPortfolioId(String clientPortfolioId) {
    this.getAccountDetail().setUserDefined1(clientPortfolioId);
  }
  // Ended for GEN2

  //~ ------------------------------------------------------------------------------------------------------------------

  // NCC Client Program Eligibility Indicator
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode7  DOCUMENT ME!
   */
  public void setClientProgramEligibilityIndicator(String clientDefined1CharCode7) {
    this.clientDefined1CharCode7 = clientDefined1CharCode7;
  }
  // NCC Client Program End Date

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate4  DOCUMENT ME!
   */
  public void setClientProgramEndDate(Date clientDefinedDate4) {
    this.clientDefinedDate4 = clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientReceiptDate  DOCUMENT ME!
   */
  public void setClientReceiptDate(Date clientReceiptDate) {
    this.clientReceiptDate = clientReceiptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  date  DOCUMENT ME!
   */
  public void setCMCActivationDate(Date date) {
    this.clientDefinedDate3 = date;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flag  DOCUMENT ME!
   */
  public void setCMCActivationFlag(Boolean flag) {
    this.clientDefinedFlag1 = flag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cmcRandomDigits  DOCUMENT ME!
   */
  public void setCmcRandomDigits(Integer cmcRandomDigits) {
    this.cmcRandomDigits = cmcRandomDigits;
  }
  // Collate code

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode3  DOCUMENT ME!
   */
  public void setCollatCode(String clientDefined4CharCode3) {
    this.clientDefined4CharCode3 = clientDefined4CharCode3;
  }
  // Collateral Description

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode1  DOCUMENT ME!
   */
  public void setCollatDesc(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the collection costs.
   *
   * @param  collectionCosts  the collectionCosts to set
   */
  public void setCollectionCosts(BigDecimal collectionCosts) {
    this.collectionCosts = collectionCosts;
  }
  // CollectionStatus

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode3  DOCUMENT ME!
   */
  public void setCollectionStatus(String clientDefined1CharCode3) {
    this.clientDefined1CharCode3 = clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode1  DOCUMENT ME!
   */
  public void setCollectorExtension(String clientDefined8CharCode1) {
    this.getAccountDetail().setClientDefined8CharCode1(
      clientDefined8CharCode1);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode1  DOCUMENT ME!
   */
  public void setCollectorId(String clientDefined4CharCode1) {
    this.getAccountDetail().setClientDefined4CharCode1(
      clientDefined4CharCode1);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined32CharCode1  DOCUMENT ME!
   */
  public void setCollectorName(String clientDefined32CharCode1) {
    this.getAccountDetail().setClientDefined32CharCode1(
      clientDefined32CharCode1);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the collection re-age counter.
   *
   * @param  colReageCounter  the colReageCounter to set
   */
  public void setColReageCounter(Integer colReageCounter) {
    this.colReageCounter = colReageCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  commentActivities  DOCUMENT ME!
   */
  public void setCommentActivities(Set<CommentActivity> commentActivities) {
    this.commentActivities = commentActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  commission  DOCUMENT ME!
   */
  public void setCommission(BigDecimal commission) {
    this.commission = commission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  commissionRate  DOCUMENT ME!
   */
  public void setCommissionRate(BigDecimal commissionRate) {
    this.commissionRate = commissionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the compensation code.
   *
   * @param  compensationCode  the compensationCode to set
   */
  public void setCompensationCode(Integer compensationCode) {
    this.compensationCode = compensationCode;
  }
  // Contact at Supply Address

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode1  DOCUMENT ME!
   */
  public void setContactSupplyAddress(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  contractDate  DOCUMENT ME!
   */
  public void setContractDate(Date contractDate) {
    this.contractDate = contractDate;
  }
  // Control4

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode1  DOCUMENT ME!
   */
  public void setControlFour(String clientDefined4CharCode1) {
    this.clientDefined4CharCode1 = clientDefined4CharCode1;
  }
  // Control1

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  DOCUMENT ME!
   */
  public void setControlOne(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }
  // Control2

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode1  DOCUMENT ME!
   */
  public void setControlTwo(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedAmount1  DOCUMENT ME!
   */
  public void setCost(BigDecimal clientDefinedAmount1) {
    this.clientDefinedAmount1 = clientDefinedAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal1  DOCUMENT ME!
   */
  public void setCreditBalance(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }
  // Credit History Five

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger5  DOCUMENT ME!
   */
  public void setCreditHistoryFive(Integer clientDefinedInteger5) {
    this.clientDefinedInteger5 = clientDefinedInteger5;
  }
  // Credit History Four

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger4  DOCUMENT ME!
   */
  public void setCreditHistoryFour(Integer clientDefinedInteger4) {
    this.clientDefinedInteger4 = clientDefinedInteger4;
  }
  // Credit History One

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger1  DOCUMENT ME!
   */
  public void setCreditHistoryOne(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }
  // Credit History Six

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger6  DOCUMENT ME!
   */
  public void setCreditHistorySix(Integer clientDefinedInteger6) {
    this.clientDefinedInteger6 = clientDefinedInteger6;
  }
  // Credit History Three

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger3  DOCUMENT ME!
   */
  public void setCreditHistoryThree(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }
  // Credit History two

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger2  DOCUMENT ME!
   */
  public void setCreditHistoryTwo(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  creditLimit  the creditLimit to set
   */
  public void setCreditLimit(BigDecimal creditLimit) {
    this.creditLimit = creditLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the credit line.
   *
   * @param  creditLine  the creditLine to set
   */
  public void setCreditLine(BigDecimal creditLine) {
    this.creditLine = creditLine;
  }
  // CollectorId

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  creditLineIncreaseDate  DOCUMENT ME!
   */
  public void setCreditLineIncreaseDate(Date creditLineIncreaseDate) {
    this.creditLineIncreaseDate = creditLineIncreaseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode2  DOCUMENT ME!
   */
  public void setCtaCollectorId(String clientDefined4CharCode2) {
    this.clientDefined4CharCode2 = clientDefined4CharCode2;
  }
  // affinity brand

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ctaLocationCode  DOCUMENT ME!
   */
  public void setCtaLocationCode(Integer ctaLocationCode) {
    this.clientDefinedInteger2 = ctaLocationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode1  DOCUMENT ME!
   */
  public void setCtmStatus(String clientDefined4CharCode1) {
    this.clientDefined4CharCode1 = clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the current due.
   *
   * @param  currentDue  the currentDue to set
   */
  public void setCurrentDue(BigDecimal currentDue) {
    this.currentDue = currentDue;
  }
  // Current Queue Number

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode2  DOCUMENT ME!
   */
  public void setCurrentQueueNumber(String clientDefined4CharCode2) {
    this.clientDefined4CharCode2 = clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerType  DOCUMENT ME!
   */
  public void setCustomerType(CustomerType customerType) {
    this.customerType = customerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cycleCode  the cycleCode to set
   */
  public void setCycleCode(String cycleCode) {
    this.cycleCode = cycleCode;
  }
  // Diary Comment

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  DOCUMENT ME!
   */
  public void setDairyRequired(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the days since last collection.
   *
   * @param  daysSinceLastCollection  the daysSinceLastCollection to set
   */
  public void setDaysSinceLastCollection(Integer daysSinceLastCollection) {
    this.daysSinceLastCollection = daysSinceLastCollection;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode6  DOCUMENT ME!
   */
  public void setDbcInd(String clientDefined1CharCode6) {
    this.clientDefined1CharCode6 = clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Called by SP Account Loader.
   *
   * @param  clientDefinedDate5  DOCUMENT ME!
   */
  public void setDeactivatedDate(Date clientDefinedDate5) {
    this.clientDefinedDate5 = clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  deactivatedReason  DOCUMENT ME!
   */
  public void setDeactivatedReason(String deactivatedReason) {
    this.deactivatedReason = deactivatedReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dealerCode  DOCUMENT ME!
   */
  public void setDealerCode(String dealerCode) {
    this.dealerCode = dealerCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the debt type.
   *
   * @param  debtType  the debtType to set
   */
  public void setDebtType(String debtType) {
    this.debtType = debtType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  defaultResponsible  the defaultResponsible to set
   */
  public void setDefaultResponsible(Responsible defaultResponsible) {
    this.defaultResponsible = defaultResponsible;
  }
  // Delinquency String

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode3  DOCUMENT ME!
   */
  public void setDelinqString(String clientDefined20CharCode3) {
    this.clientDefined20CharCode3 = clientDefined20CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the delinquency date.
   *
   * @param  delinquencyDate  the delinquencyDate to set
   */
  public void setDelinquencyDate(Date delinquencyDate) {
    this.delinquencyDate = delinquencyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the days past due.
   *
   * @param  delinquencyDays  the delinquencyDays to set
   */
  public void setDelinquencyDays(Integer delinquencyDays) {
    this.delinquencyDays = delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  delinquencyHistory  DOCUMENT ME!
   */
  public void setDelinquencyHistory(Map<Integer, DelinquencyHistory> delinquencyHistory) {
    this.delinquencyHistory = delinquencyHistory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  delinquencyReasonCode  DOCUMENT ME!
   */
  public void setDelinquencyReasonCode(String delinquencyReasonCode) {
    this.delinquencyReasonCode = delinquencyReasonCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  delinquencyStage  DOCUMENT ME!
   */
  public void setDelinquencyStage(Integer delinquencyStage) {
    this.delinquencyStage = delinquencyStage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger1  DOCUMENT ME!
   */
  public void setDFSActiveMonthCount(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger5  DOCUMENT ME!
   */
  public void setDFSAgentNumber(Integer clientDefinedInteger5) {
    this.clientDefinedInteger5 = clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger2  DOCUMENT ME!
   */
  public void setDFSChargeOffScore(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger3  DOCUMENT ME!
   */
  public void setDFSChargeRollScore(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Getters and Setters for DFS Account Import Job Added by Etisbew on 08/19/09-Start.
   *
   * @param  clientDefined1CharCode1  DOCUMENT ME!
   */
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode1  DOCUMENT ME!
   */
  public void setDfsExternalStatusCode(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode2  DOCUMENT ME!
   */
  public void setDfsInternalStatusCode(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger4  DOCUMENT ME!
   */
  public void setDFSNonTranScore(Integer clientDefinedInteger4) {
    this.clientDefinedInteger4 = clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined6CharCode1  DOCUMENT ME!
   */
  public void setDfsProcessCode(String clientDefined6CharCode1) {
    this.clientDefined6CharCode1 = clientDefined6CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode4  DOCUMENT ME!
   */
  public void setDfsProgramStatus(String clientDefined1CharCode4) {
    this.clientDefined1CharCode4 = clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  disallowWebReason  DOCUMENT ME!
   */
  public void setDisallowWebReason(String disallowWebReason) {
    this.disallowWebReason = disallowWebReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  division  DOCUMENT ME!
   */
  public void setDivision(Division division) {
    this.division = division;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  documentHistories  DOCUMENT ME!
   */
  public void setDocumentHistories(Set<DocumentHistory> documentHistories) {
    this.documentHistories = documentHistories;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  documents  DOCUMENT ME!
   */
  public void setDocuments(Set<Document> documents) {
    this.documents = documents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dti  DOCUMENT ME!
   */
  public void setDTI(BigDecimal dti) {
    clientDefinedDecimal2 = dti;
  }
  // ealertDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate1  DOCUMENT ME!
   */
  public void setEalertDate(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }
  // ealert type

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  DOCUMENT ME!
   */
  public void setEalertType(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }
  // Electric Value

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal1  DOCUMENT ME!
   */
  public void setElectricityValue(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }
  // Electric Meter Number

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode2  DOCUMENT ME!
   */
  public void setElectricMeterNumber(String clientDefined20CharCode2) {
    this.clientDefined20CharCode2 = clientDefined20CharCode2;
  }
  // Electric Meter Reading (Register 1)

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger1  DOCUMENT ME!
   */
  public void setElectricMeterReadingRegOne(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }
  // Electric Meter Reading (Register 2)

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger2  DOCUMENT ME!
   */
  public void setElectricMeterReadingRegTwo(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }
  // Electric Reading Type

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode3  DOCUMENT ME!
   */
  public void setElectricReadingType(String clientDefined1CharCode3) {
    this.clientDefined1CharCode3 = clientDefined1CharCode3;
  }
  // Electric Reference Number

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode1  DOCUMENT ME!
   */
  public void setElectricReferenceNumber(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  eligiblePrograms  DOCUMENT ME!
   */
  public void setEligiblePrograms(Set<AccountEligibleProgram> eligiblePrograms) {
    this.eligiblePrograms = eligiblePrograms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flag  DOCUMENT ME!
   */
  public void setEmployeeFlag(Boolean flag) {
    this.clientDefinedFlag2 = flag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  entryBalance  the entryBalance to set
   */
  public void setEntryBalance(BigDecimal entryBalance) {
    this.entryBalance = entryBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  entryChargeOffAmount  the entryChargeOffAmount to set
   */
  public void setEntryChargeOffAmount(BigDecimal entryChargeOffAmount) {
    this.entryChargeOffAmount = entryChargeOffAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the entry date.
   *
   * @param  entryDate  the entryDate to set
   */
  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }
  // epp balance

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal1  DOCUMENT ME!
   */
  public void setEppBalance(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode1  DOCUMENT ME!
   */
  public void setExceptionStatus1(String clientDefined4CharCode1) {
    this.clientDefined4CharCode1 = clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode2  DOCUMENT ME!
   */
  public void setExceptionStatus2(String clientDefined4CharCode2) {
    this.clientDefined4CharCode2 = clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode3  DOCUMENT ME!
   */
  public void setExceptionStatus3(String clientDefined4CharCode3) {
    this.clientDefined4CharCode3 = clientDefined4CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  executedDialerResults  the executedDialerResults to set
   */
  public void setExecutedDialerResults(Set<DialerChannelResult> executedDialerResults) {
    this.executedDialerResults = executedDialerResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  executedEmailResults  the executedEmailResults to set
   */
  public void setExecutedEmailResults(Set<EmailChannelResult> executedEmailResults) {
    this.executedEmailResults = executedEmailResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  executedIvrResults  the executedIvrResults to set
   */
  public void setExecutedIvrResults(Set<IvrChannelResult> executedIvrResults) {
    this.executedIvrResults = executedIvrResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  executedSmsResults  the executedSmsResults to set
   */
  public void setExecutedSmsResults(Set<SmsChannelResult> executedSmsResults) {
    this.executedSmsResults = executedSmsResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expenseAudit  DOCUMENT ME!
   */
  public void setExpenseAudit(ExpenseAudit expenseAudit) {
    this.expenseAudit = expenseAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expenses  the expenses to set
   */
  public void setExpenses(Set<Expense> expenses) {
    this.expenses = expenses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exportedDialerResults  the exportedDialerResults to set
   */
  public void setExportedDialerResults(Set<DialerChannelResult> exportedDialerResults) {
    this.exportedDialerResults = exportedDialerResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exportedEmailResults  the exportedEmailResults to set
   */
  public void setExportedEmailResults(Set<EmailChannelResult> exportedEmailResults) {
    this.exportedEmailResults = exportedEmailResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exportedIvrResults  the exportedIvrResults to set
   */
  public void setExportedIvrResults(Set<IvrChannelResult> exportedIvrResults) {
    this.exportedIvrResults = exportedIvrResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exportedLetterResults  the exportedLetterResults to set
   */
  public void setExportedLetterResults(Set<LetterChannelResult> exportedLetterResults) {
    this.exportedLetterResults = exportedLetterResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exportedSmsResults  the exportedSmsResults to set
   */
  public void setExportedSmsResults(Set<SmsChannelResult> exportedSmsResults) {
    this.exportedSmsResults = exportedSmsResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  DOCUMENT ME!
   */
  public void setExpressConsentCode(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }
  // Fee due

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal2  DOCUMENT ME!
   */
  public void setFeeDue(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }
  // Field Agent

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  feeOutstanding  DOCUMENT ME!
   */
  public void setFeeOutstanding(BigDecimal feeOutstanding) {
    this.feeOutstanding = feeOutstanding;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode2  DOCUMENT ME!
   */
  public void setFieldAgent(String clientDefined3CharCode2) {
    this.clientDefined3CharCode2 = clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  financialAdjustments  DOCUMENT ME!
   */
  public void setFinancialAdjustments(Set<FinancialAdjustment> financialAdjustments) {
    this.financialAdjustments = financialAdjustments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the first agency placement date.
   *
   * @param  firstAgencyPlacementDate  the firstAgencyPlacementDate to set
   */
  public void setFirstAgencyPlacementDate(Date firstAgencyPlacementDate) {
    this.firstAgencyPlacementDate = firstAgencyPlacementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  date  DOCUMENT ME!
   */
  public void setFirstCMCActivationDate(Date date) {
    this.clientDefinedDate2 = date;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  firstDialerDate  the firstDialerDate to set
   */
  public void setFirstDialerDate(Date firstDialerDate) {
    this.firstDialerDate = firstDialerDate;
  }
  // Added by Etisbew For DFS Job on 04 Feb 2009

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  firstEmailDate  the firstEmailDate to set
   */
  public void setFirstEmailDate(Date firstEmailDate) {
    this.firstEmailDate = firstEmailDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  firstIvrDate  the firstIvrDate to set
   */
  public void setFirstIvrDate(Date firstIvrDate) {
    this.firstIvrDate = firstIvrDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  firstLetterDate  the firstLetterDate to set
   */
  public void setFirstLetterDate(Date firstLetterDate) {
    this.firstLetterDate = firstLetterDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedAmount1  DOCUMENT ME!
   */
  public void setFirstMortgagePrincipalBalance(BigDecimal clientDefinedAmount1) {
    this.clientDefinedAmount1 = clientDefinedAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate5  DOCUMENT ME!
   */
  public void setFirstPaymentDueDate(Date clientDefinedDate5) {
    this.clientDefinedDate5 = clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  firstSmsDate  the firstSmsDate to set
   */
  public void setFirstSmsDate(Date firstSmsDate) {
    this.firstSmsDate = firstSmsDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the fixed payment amount.
   *
   * @param  fixedPaymentAmount  the fixedPaymentAmount to set
   */
  public void setFixedPaymentAmount(BigDecimal fixedPaymentAmount) {
    this.fixedPaymentAmount = fixedPaymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the fourth agency placement date.
   *
   * @param  fourthAgencyPlacementDate  the fourthAgencyPlacementDate to set
   */
  public void setFourthAgencyPlacementDate(Date fourthAgencyPlacementDate) {
    this.fourthAgencyPlacementDate = fourthAgencyPlacementDate;
  }
  // NCC Frontend Risk Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode1  DOCUMENT ME!
   */
  public void setFrontendRiskScore(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }
  // Gas Reference Number

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger4  DOCUMENT ME!
   */
  public void setGasMeterNumber(Integer clientDefinedInteger4) {
    this.clientDefinedInteger4 = clientDefinedInteger4;
  }
  // Gas Reading

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger5  DOCUMENT ME!
   */
  public void setGasReading(Integer clientDefinedInteger5) {
    this.clientDefinedInteger5 = clientDefinedInteger5;
  }
  // Gas Reading Type

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode4  DOCUMENT ME!
   */
  public void setGasReadingType(String clientDefined1CharCode4) {
    this.clientDefined1CharCode4 = clientDefined1CharCode4;
  }
  // Gas Meter Number

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode3  DOCUMENT ME!
   */
  public void setGasReferenceNumber(String clientDefined20CharCode3) {
    this.clientDefined20CharCode3 = clientDefined20CharCode3;
  }
  // Gas Value

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ClientDefinedDecimal2  DOCUMENT ME!
   */
  public void setGasValue(BigDecimal ClientDefinedDecimal2) {
    this.clientDefinedDecimal2 = ClientDefinedDecimal2;
  }
  // GovernMent Insured

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode4  DOCUMENT ME!
   */
  public void setGovtInsured(String clientDefined1CharCode4) {
    this.clientDefined1CharCode4 = clientDefined1CharCode4;
  }
  // NCC Hardcore Risk Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode2  DOCUMENT ME!
   */
  public void setHardcoreRiskScore(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  heloc  DOCUMENT ME!
   */
  public void setHeloc(AccountHeloc heloc) {
    this.heloc = heloc;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  historicalAccountStatuses  DOCUMENT ME!
   */
  public void setHistoricalAccountStatuses(Set<AccountStatus> historicalAccountStatuses) {
    this.historicalAccountStatuses = historicalAccountStatuses;
  }
  // holdDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate2  DOCUMENT ME!
   */
  public void setHoldDate(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  homeEquityPrequalifiedRefi  DOCUMENT ME!
   */
  public void setHomeEquityPrequalifiedRefi(HomeEquityPrequalifiedRefi homeEquityPrequalifiedRefi) {
    this.homeEquityPrequalifiedRefi = homeEquityPrequalifiedRefi;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * ScoreNet hostIndicator for ADS.
   *
   * @param  hostIndicator  DOCUMENT ME!
   */
  public void setHostIndicator(String hostIndicator) {
    this.hostIndicator = hostIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  incomeAudits  DOCUMENT ME!
   */
  public void setIncomeAudits(Set<IncomeAudit> incomeAudits) {
    this.incomeAudits = incomeAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  incomes  the incomes to set
   */
  public void setIncomes(Set<Income> incomes) {
    this.incomes = incomes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  incomeTaxIndicator  DOCUMENT ME!
   */
  public void setIncomeTaxIndicator(Boolean incomeTaxIndicator) {
    this.clientDefinedFlag2 = incomeTaxIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  initDialerResults  the initDialerResults to set
   */
  public void setInitDialerResults(Set<DialerChannelResult> initDialerResults) {
    this.initDialerResults = initDialerResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  initEmailResults  the initEmailResults to set
   */
  public void setInitEmailResults(Set<EmailChannelResult> initEmailResults) {
    this.initEmailResults = initEmailResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  initIvrResults  the initIvrResults to set
   */
  public void setInitIvrResults(Set<IvrChannelResult> initIvrResults) {
    this.initIvrResults = initIvrResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  initLetterResults  the initLetterResults to set
   */
  public void setInitLetterResults(Set<LetterChannelResult> initLetterResults) {
    this.initLetterResults = initLetterResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  initSmsResults  the initSmsResults to set
   */
  public void setInitSmsResults(Set<SmsChannelResult> initSmsResults) {
    this.initSmsResults = initSmsResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Insurance info if this is a medical, dental... account
   *
   * @param  insurances  DOCUMENT ME!
   */
  public void setInsurances(Set<AccountInsurance> insurances) {
    this.insurances = insurances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the interest due.
   *
   * @param  interestDue  the interestDue to set
   */
  public void setInterestDue(BigDecimal interestDue) {
    this.interestDue = interestDue;
  }
  // COFS Internal Status

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  interestOutstanding  DOCUMENT ME!
   */
  public void setInterestOutstanding(BigDecimal interestOutstanding) {
    this.interestOutstanding = interestOutstanding;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  internalStatus  DOCUMENT ME!
   */
  public void setInternalStatus(String internalStatus) {
    this.clientDefined3CharCode1 = internalStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode2  DOCUMENT ME!
   */
  public void setInvestorLoanNumber(String clientDefined20CharCode2) {
    this.clientDefined20CharCode2 = clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  invoices  the invoices to set
   */
  public void setInvoices(Set<Invoice> invoices) {
    this.invoices = invoices;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  labelledScheduleId  the labelledScheduleId to set
   */
  public void setLabelledScheduleId(Long labelledScheduleId) {
    this.labelledScheduleId = labelledScheduleId;
  }
  // /**
  // * @param ivrActivities
  // * the ivrActivities to set
  // */
  // public void setIvrActivities(Set<IvrActivity> ivrActivities) {
  // this.ivrActivities = ivrActivities;
  // }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastContactDate  DOCUMENT ME!
   */
  public void setLastContactDate(Date lastContactDate) {
    this.lastContactDate = lastContactDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastInterestDate  DOCUMENT ME!
   */
  public void setLastInterestDate(Date lastInterestDate) {
    this.lastInterestDate = lastInterestDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastLetterDate  the lastLetterDate to set
   */
  public void setLastLetterDate(Date lastLetterDate) {
    this.lastLetterDate = lastLetterDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastLetterId  the lastLetterId to set
   */
  public void setLastLetterId(Long lastLetterId) {
    this.lastLetterId = lastLetterId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastLoginDate  DOCUMENT ME!
   */
  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastLoginFailureDate  DOCUMENT ME!
   */
  public void setLastLoginFailureDate(Date lastLoginFailureDate) {
    this.lastLoginFailureDate = lastLoginFailureDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastNSFDate  DOCUMENT ME!
   */
  public void setLastNSFDate(Date lastNSFDate) {
    this.lastNSFDate = lastNSFDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastNSFReportDate  DOCUMENT ME!
   */
  public void setLastNSFReportDate(Date lastNSFReportDate) {
    this.lastNSFReportDate = lastNSFReportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastPayAmount  the lastPayAmount to set
   */
  public void setLastPayAmount(BigDecimal lastPayAmount) {
    this.lastPayAmount = lastPayAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the last pay due.
   *
   * @param  lastPayDate  the lastPayDate to set
   */
  public void setLastPayDate(Date lastPayDate) {
    this.lastPayDate = lastPayDate;
  }
  // LastPayment Date

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate2  DOCUMENT ME!
   */
  public void setLastPaymentDate(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }
  // Last Ptp Kept

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode2  DOCUMENT ME!
   */
  public void setLastPtpKept(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the last re-age date.
   *
   * @param  lastReageDate  the lastReageDate to set
   */
  public void setLastReageDate(Date lastReageDate) {
    this.lastReageDate = lastReageDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the last re-age type.
   *
   * @param  lastReageType  the lastReageType to set
   */
  public void setLastReageType(String lastReageType) {
    this.lastReageType = lastReageType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastWorkDate  DOCUMENT ME!
   */
  public void setLastWorkDate(Date lastWorkDate) {
    this.lastWorkDate = lastWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal2  DOCUMENT ME!
   */
  public void setLateFee(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }
  // LegalStatus

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode3  DOCUMENT ME!
   */
  public void setLegalStatus(String clientDefined2CharCode3) {
    this.clientDefined2CharCode3 = clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  position  DOCUMENT ME!
   */
  public void setLienPosition(String position) {
    this.clientDefined3CharCode1 = position;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate1  DOCUMENT ME!
   */
  public void setLineMaturityDate(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }
  // /**
  // * @param letterActivities
  // * the letterActivities to set
  // */
  // public void setLetterActivities(Set<LetterActivity> letterActivities) {
  // this.letterActivities = letterActivities;
  // }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the loan term.
   *
   * @param  loanTerm  the loanTerm to set
   */
  public void setLoanTerm(Integer loanTerm) {
    this.loanTerm = loanTerm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  loanToValue  DOCUMENT ME!
   */
  public void setLoanToValue(BigDecimal loanToValue) {
    this.loanToValue = loanToValue;
  }
  // NCC Location Code

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined6CharCode1  DOCUMENT ME!
   */
  public void setLocationCode(String clientDefined6CharCode1) {
    this.clientDefined6CharCode1 = clientDefined6CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lockExpirationTime  the lockExpirationTime to set
   */
  public void setLockExpirationTime(Date lockExpirationTime) {
    this.lockExpirationTime = lockExpirationTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lockTime  the lockTime to set
   */
  public void setLockTime(Date lockTime) {
    this.lockTime = lockTime;
  }
  // Added by Kattasrinivas on 08/11/09 for Citi Aus Specific Fields-Start
  // Visa or Mastercard

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  logo  DOCUMENT ME!
   */
  public void setLogo(Integer logo) {
    this.clientDefinedInteger1 = logo;
  }
  // NCC Longman Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode2  DOCUMENT ME!
   */
  public void setLongmanScore(String clientDefined3CharCode2) {
    this.clientDefined3CharCode2 = clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  margin  DOCUMENT ME!
   */
  public void setMargin(BigDecimal margin) {
    this.clientDefinedDecimal3 = margin;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maturityDate  DOCUMENT ME!
   */
  public void setMaturityDate(Date maturityDate) {
    this.maturityDate = maturityDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the max delinquency.
   *
   * @param  maxDelinquencyDays  the maxDelinquencyDays to set
   */
  public void setMaxDelinquencyDays(Integer maxDelinquencyDays) {
    this.maxDelinquencyDays = maxDelinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  memoryMessages  DOCUMENT ME!
   */
  public void setMemoryMessages(Set<MemoryMessage> memoryMessages) {
    this.memoryMessages = memoryMessages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  memos  DOCUMENT ME!
   */
  public void setMemos(Set<Memo> memos) {
    this.memos = memos;
  }
  // NCC midrange Risk Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode3  DOCUMENT ME!
   */
  public void setMidrangeRiskScore(String clientDefined1CharCode3) {
    this.clientDefined1CharCode3 = clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  minimumPayDue  the minimumPayDue to set
   */
  public void setMinimumPayDue(BigDecimal minimumPayDue) {
    this.minimumPayDue = minimumPayDue;
  }
  // Months Extended

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger8  DOCUMENT ME!
   */
  public void setMonthsExtended(Integer clientDefinedInteger8) {
    this.clientDefinedInteger8 = clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  mortgage  DOCUMENT ME!
   */
  public void setMortgage(AccountMortgage mortgage) {
    this.mortgage = mortgage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined6CharCode2  DOCUMENT ME!
   */
  public void setMortgageType(String clientDefined6CharCode2) {
    this.clientDefined6CharCode2 = clientDefined6CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  mtgHist  DOCUMENT ME!
   */
  public void setMtgHist(Boolean mtgHist) {
    this.clientDefinedFlag1 = mtgHist;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * NCC ASAP Project.
   *
   * @param  mtgNum  DOCUMENT ME!
   */
  public void setMtgNum(Integer mtgNum) {
    this.clientDefinedInteger1 = mtgNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger1  DOCUMENT ME!
   */
  public void setNCCCardCycleCount1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger2  DOCUMENT ME!
   */
  public void setNCCCardCycleCount2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger3  DOCUMENT ME!
   */
  public void setNCCCardCycleCount3(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger4  DOCUMENT ME!
   */
  public void setNCCCardCycleCount4(Integer clientDefinedInteger4) {
    this.clientDefinedInteger4 = clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger5  DOCUMENT ME!
   */
  public void setNCCCardCycleCount5(Integer clientDefinedInteger5) {
    this.clientDefinedInteger5 = clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger6  DOCUMENT ME!
   */
  public void setNCCCardCycleCount6(Integer clientDefinedInteger6) {
    this.clientDefinedInteger6 = clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger7  DOCUMENT ME!
   */
  public void setNCCCardCycleCount7(Integer clientDefinedInteger7) {
    this.clientDefinedInteger7 = clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate6  DOCUMENT ME!
   */
  public void setNCCProgramPurgeDate(Date clientDefinedDate6) {
    this.clientDefinedDate6 = clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nccStatus  DOCUMENT ME!
   */
  public void setNCCStatus(String nccStatus) {
    this.clientDefined2CharCode3 = nccStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  negotiateExceptionResults  DOCUMENT ME!
   */
  public void setNegotiateExceptionResults(Set<NegotiateExceptionResult> negotiateExceptionResults) {
    this.negotiateExceptionResults = negotiateExceptionResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  negotiateProgramTypes  DOCUMENT ME!
   */
  public void setNegotiateProgramType(Set<NegotiateProgramType> negotiateProgramTypes) {
    this.negotiateProgramTypes = negotiateProgramTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  negotiateProgramTypes  the negotiateProgramTypes to set
   */
  public void setNegotiateProgramTypes(Set<NegotiateProgramType> negotiateProgramTypes) {
    this.negotiateProgramTypes = negotiateProgramTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  netCosts  DOCUMENT ME!
   */
  public void setNetCosts(BigDecimal netCosts) {
    this.netCosts = netCosts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nextPaymentDate  the matchedResponsibles to set
   */
  public void setNextPaymentDate(Date nextPaymentDate) {
    this.nextPaymentDate = nextPaymentDate;
  }
  // next Payment Due Amount

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal1  DOCUMENT ME!
   */
  public void setNextPaymentDueAmount(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nextReageDate  the nextReageDate to set
   */
  public void setNextReageDate(Date nextReageDate) {
    this.nextReageDate = nextReageDate;
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
   * @param  numberOfCyclesDelinquent  the numberOfCyclesDelinquent to set
   */
  public void setNumberOfCyclesDelinquent(Integer numberOfCyclesDelinquent) {
    this.numberOfCyclesDelinquent = numberOfCyclesDelinquent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  officerCode  DOCUMENT ME!
   */
  public void setOfficerCode(String officerCode) {
    this.officerCode = officerCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for omni next payment date.
   *
   * @param  omniNextPaymentDate  Date
   */
  public void setOmniNextPaymentDate(Date omniNextPaymentDate) {
    this.omniNextPaymentDate = omniNextPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for omni past due.
   *
   * @param  omniPastDue  BigDecimal
   */
  public void setOmniPastDue(BigDecimal omniPastDue) {
    this.omniPastDue = omniPastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the open date.
   *
   * @param  openDate  the openDate to set
   */
  public void setOpenDate(Date openDate) {
    this.openDate = openDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set OptOut Value for SP response Flow.
   *
   * @param  clientDefined1CharCode5  DOCUMENT ME!
   */
  public void setOptOut(String clientDefined1CharCode5) {
    this.clientDefined1CharCode5 = clientDefined1CharCode5;
  }
  // card type (e.g. Silver, Platinum)

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode2  DOCUMENT ME!
   */
  public void setOrgNumber(String clientDefined3CharCode2) {
    this.clientDefined3CharCode2 = clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the original account number.
   *
   * @param  originalAccountNumber  the originalAccountNumber to set
   */
  public void setOriginalAccountNumber(String originalAccountNumber) {
    this.originalAccountNumber = originalAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  originalChargeOffAmount  DOCUMENT ME!
   */
  public void setOriginalChargeOffAmount(BigDecimal originalChargeOffAmount) {
    this.originalChargeOffAmount = originalChargeOffAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the original creditor.
   *
   * @param  originalCreditor  the originalCreditor to set
   */
  public void setOriginalCreditor(String originalCreditor) {
    this.originalCreditor = originalCreditor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the original date time-stamp.
   *
   * @param  originalDateTimestamp  the originalDateTimestamp to set
   */
  public void setOriginalDateTimestamp(Date originalDateTimestamp) {
    this.originalDateTimestamp = originalDateTimestamp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal2  DOCUMENT ME!
   */
  public void setOriginalHousingRatio(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal1  DOCUMENT ME!
   */
  public void setOriginalLoanAmount(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  originalPrincipalAmount  DOCUMENT ME!
   */
  public void setOriginalPrincipalAmount(BigDecimal originalPrincipalAmount) {
    this.originalPrincipalAmount = originalPrincipalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal3  DOCUMENT ME!
   */
  public void setOriginalTotalPayment(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined6CharCode1  DOCUMENT ME!
   */
  public void setOriginationLoanPurpose(String clientDefined6CharCode1) {
    this.clientDefined6CharCode1 = clientDefined6CharCode1;
  }
  // Other Account number

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode2  DOCUMENT ME!
   */
  public void setOtherAcctNum(String clientDefined20CharCode2) {
    this.clientDefined20CharCode2 = clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal3  DOCUMENT ME!
   */
  public void setOtherFee(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  overLimit  DOCUMENT ME!
   */
  public void setOverLimit(BigDecimal overLimit) {
    this.overLimit = overLimit;
  }
  // NCC overthelimit Risk Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode4  DOCUMENT ME!
   */
  public void setOverthelimitRiskScore(String clientDefined1CharCode4) {
    this.clientDefined1CharCode4 = clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the past due.
   *
   * @param  pastDue  the pastDue to set
   */
  public void setPastDue(BigDecimal pastDue) {
    this.pastDue = pastDue;
  }
  // Past Due Date

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate1  DOCUMENT ME!
   */
  public void setPastDueDate(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentDueDate  the paymentDueDate to set
   */
  public void setPaymentDueDate(Date paymentDueDate) {
    this.paymentDueDate = paymentDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentPrograms  DOCUMENT ME!
   */
  public void setPaymentPrograms(Set<PaymentProgram> paymentPrograms) {
    this.paymentPrograms = paymentPrograms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  payments  the payments to set
   */
  public void setPayments(Set<Payment> payments) {
    this.payments = payments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentScore  the paymentScore to set
   */
  public void setPaymentScore(Integer paymentScore) {
    this.paymentScore = paymentScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clienDefinedInteger3  DOCUMENT ME!
   */
  public void setPercentMICoverage(Integer clienDefinedInteger3) {
    this.clientDefinedInteger3 = clienDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for persona accounts.
   *
   * @param  personaAccounts  Set
   */
  public void setPersonaAccounts(Set<PersonaAccount> personaAccounts) {
    this.personaAccounts = personaAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  placementSent  the placementSent to set
   */
  public void setPlacementSent(Boolean placementSent) {
    this.placementSent = placementSent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the planned exit date.
   *
   * @param  plannedExitDate  the plannedExitDate to set
   */
  public void setPlannedExitDate(Date plannedExitDate) {
    this.plannedExitDate = plannedExitDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  populationId  DOCUMENT ME!
   */
  public void setPopulationId(String populationId) {
    this.clientDefined2CharCode2 = populationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set portfolio for the account.
   *
   * @param  portfolio  the portfolio to set
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioIndicator  DOCUMENT ME!
   */
  public void setPortfolioIndicator(String portfolioIndicator) {
    this.clientDefined20CharCode1 = portfolioIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode2  DOCUMENT ME!
   */
  public void setPortfolioName(String clientDefined20CharCode2) {
    this.clientDefined20CharCode2 = clientDefined20CharCode2;
  }
  // End for US Bank - Karthik//

  //~ ------------------------------------------------------------------------------------------------------------------

  // NCC PremId Risk Score
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode5  DOCUMENT ME!
   */
  public void setPreMidRiskScore(String clientDefined1CharCode5) {
    this.clientDefined1CharCode5 = clientDefined1CharCode5;
  }
  // Prepayment account

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag1  DOCUMENT ME!
   */
  public void setPrePaymentAccount(Boolean clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  principal  DOCUMENT ME!
   */
  public void setPrincipal(BigDecimal principal) {
    this.principal = principal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  principalOutstanding  DOCUMENT ME!
   */
  public void setPrincipalOutstanding(BigDecimal principalOutstanding) {
    this.principalOutstanding = principalOutstanding;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  priorityScore  the priorityScore to set
   */
  public void setPriorityScore(Integer priorityScore) {
    this.priorityScore = priorityScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  priorityStatus  DOCUMENT ME!
   */
  public void setPriorityStatus(Boolean priorityStatus) {
    this.clientDefinedFlag3 = priorityStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  prodD  DOCUMENT ME!
   */
  public void setProdD(BigDecimal prodD) {
    this.clientDefinedDecimal1 = prodD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  productType  DOCUMENT ME!
   */
  public void setProductType(String productType) {
    this.productType = productType;
  }
  // NCC Program Accepted From client flag

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag1  DOCUMENT ME!
   */
  public void setProgramAcceptedFromClientFlag(Boolean clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programStartIndex  the programStartIndex to set
   */
  public void setProgramStartIndex(Integer programStartIndex) {
    this.programStartIndex = programStartIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the promise amount.
   *
   * @param  promiseAmount  the promiseAmount to set
   */
  public void setPromiseAmount(BigDecimal promiseAmount) {
    this.promiseAmount = promiseAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  promiseDate  DOCUMENT ME!
   */
  public void setPromiseDate(Date promiseDate) {
    this.clientDefinedDate1 = promiseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  promises  DOCUMENT ME!
   */
  public void setPromises(Set<PromiseToPay> promises) {
    this.promises = promises;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clienDefinedInteger2  DOCUMENT ME!
   */
  public void setPropertyType(Integer clienDefinedInteger2) {
    this.clientDefinedInteger2 = clienDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  queueAccounts  DOCUMENT ME!
   */
  public void setQueueAccounts(Set<QueueAccount> queueAccounts) {
    this.queueAccounts = queueAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  randomDigits  the randomDigits to set
   */
  public void setRandomDigits(Integer randomDigits) {
    this.randomDigits = randomDigits;
  }
  // Account Type

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode2  DOCUMENT ME!
   */
  public void setRbsAccountType(String clientDefined2CharCode2) {
    this.clientDefined2CharCode2 = clientDefined2CharCode2;
  }
  // NextPayment Date

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate3  DOCUMENT ME!
   */
  public void setRbsNextPaymentDate(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }
  // Original Loan Amount

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal3  DOCUMENT ME!
   */
  public void setRbsOriginalLoanAmount(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }
  // Gas Reading Type

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode4  DOCUMENT ME!
   */
  public void setReadingType(String clientDefined1CharCode4) {
    this.clientDefined1CharCode4 = clientDefined1CharCode4;
  }
  // reage amount

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedAmount1  DOCUMENT ME!
   */
  public void setReageAmount(BigDecimal clientDefinedAmount1) {
    this.clientDefinedAmount1 = clientDefinedAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the re-age counter.
   *
   * @param  reageCounter  the reageCounter to set
   */
  public void setReageCounter(Integer reageCounter) {
    this.reageCounter = reageCounter;
  }
  // reage flag

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode1  DOCUMENT ME!
   */
  public void setReageFlag(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }
  // COFS Recouncil Date

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recall results.
   *
   * @param  recallResults  Set
   */
  public void setRecallResults(Set<RecallResult> recallResults) {
    this.recallResults = recallResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reconciledDate  DOCUMENT ME!
   */
  public void setReconciledDate(Date reconciledDate) {
    this.clientDefinedDate1 = reconciledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  recovererCode  DOCUMENT ME!
   */
  public void setRecovererCode(String recovererCode) {
    this.recovererCode = recovererCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the responsible.
   *
   * @param  responsibles  the responsibles to set
   */
  public void setResponsibles(Set<Responsible> responsibles) {
    this.responsibles = responsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the revised date time-stamp.
   *
   * @param  revisedDateTimestamp  the revisedDateTimestamp to set
   */
  public void setRevisedDateTimestamp(Date revisedDateTimestamp) {
    this.revisedDateTimestamp = revisedDateTimestamp;
  }
  // COFS RevolvingDebt

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  revolvingDebt  DOCUMENT ME!
   */
  public void setRevolvingDebt(BigDecimal revolvingDebt) {
    this.clientDefinedAmount1 = revolvingDebt;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rightOfOffsetLastUpdateDate  DOCUMENT ME!
   */
  public void setRightOfOffsetLastUpdateDate(Date rightOfOffsetLastUpdateDate) {
    this.rightOfOffsetLastUpdateDate = rightOfOffsetLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rightOfOffsetResult  DOCUMENT ME!
   */
  public void setRightOfOffsetResult(String rightOfOffsetResult) {
    this.rightOfOffsetResult = rightOfOffsetResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  riskScore  the riskScore to set
   */
  public void setRiskScore(Integer riskScore) {
    this.riskScore = riskScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode1  DOCUMENT ME!
   */
  public void setRmsStatusCode(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  roundCounter  DOCUMENT ME!
   */
  public void setRoundCounter(Integer roundCounter) {
    this.roundCounter = roundCounter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ruleBatchId  the ruleBatchId to set
   */
  public void setRuleBatchId(Long ruleBatchId) {
    this.ruleBatchId = ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal1  DOCUMENT ME!
   */
  public void setScoreNumber1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal2  DOCUMENT ME!
   */
  public void setScoreNumber2(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal3  DOCUMENT ME!
   */
  public void setScoreNumber3(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the second agency placement date.
   *
   * @param  secondAgencyPlacementDate  the secondAgencyPlacementDate to set
   */
  public void setSecondAgencyPlacementDate(Date secondAgencyPlacementDate) {
    this.secondAgencyPlacementDate = secondAgencyPlacementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  secondToLastLoginDate  DOCUMENT ME!
   */
  public void setSecondToLastLoginDate(Date secondToLastLoginDate) {
    this.secondToLastLoginDate = secondToLastLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  secondToLastLoginFailureDate  DOCUMENT ME!
   */
  public void setSecondToLastLoginFailureDate(Date secondToLastLoginFailureDate) {
    this.secondToLastLoginFailureDate = secondToLastLoginFailureDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  secondToLastReageDate  the secondToLastReageDate to set
   */
  public void setSecondToLastReageDate(Date secondToLastReageDate) {
    this.secondToLastReageDate = secondToLastReageDate;
  }
  // COFS secondToLastWorkoutReageDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  secondToLastWorkoutReageDate  DOCUMENT ME!
   */
  public void setSecondToLastWorkoutReageDate(Date secondToLastWorkoutReageDate) {
    this.clientDefinedDate2 = secondToLastWorkoutReageDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate3  DOCUMENT ME!
   */
  public void setSettlementExpirationDate(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }
  // NCC Settlement Satisfy Date

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate2  DOCUMENT ME!
   */
  public void setSettlementSatisfyDate(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  } // NCC Settlement Expiration Date

  //~ ------------------------------------------------------------------------------------------------------------------

  // NCC Settlement Setup Date
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate1  DOCUMENT ME!
   */
  public void setSettlementSetupDate(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  shadowMode  DOCUMENT ME!
   */
  public void setShadowMode(String shadowMode) {
    this.shadowMode = shadowMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode5  DOCUMENT ME!
   */
  public void setSmithBarneyCustomerFlag(String clientDefined1CharCode5) {
    this.clientDefined1CharCode5 = clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode6  DOCUMENT ME!
   */
  public void setSmithBarneyEmployeeFlag(String clientDefined1CharCode6) {
    this.clientDefined1CharCode6 = clientDefined1CharCode6;
  }
  // Account Profile Code

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode3  DOCUMENT ME!
   */
  public void setSPAccountProfileCode(String clientDefined2CharCode3) {
    this.clientDefined2CharCode3 = clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  spocAgent  DOCUMENT ME!
   */
  public void setSpocAgent(User spocAgent) {
    if (accountInformation == null) {
      accountInformation = new AccountInformation();
      accountInformation.setAccount(this);
    }

    accountInformation.setSpocAgent(spocAgent);
  }
  // NCC State Entry Date

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sp report history.
   *
   * @param  spReportHistory  Set
   */
  public void setSpReportHistory(Set<SPReportHistory> spReportHistory) {
    this.spReportHistory = spReportHistory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate5  DOCUMENT ME!
   */
  public void setStateEntryDate(Date clientDefinedDate5) {
    this.clientDefinedDate5 = clientDefinedDate5;
  }
  // NCC Statement Hold Code

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  DOCUMENT ME!
   */
  public void setStatementHoldCode(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }
  // COFS

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  StatusReasonCode  DOCUMENT ME!
   */
  public void setStatusReasonCode(String StatusReasonCode) {
    this.clientDefined2CharCode1 = StatusReasonCode;
  }
  // NCC Terminal Risk Score

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode6  DOCUMENT ME!
   */
  public void setTerminalRiskScore(String clientDefined1CharCode6) {
    this.clientDefined1CharCode6 = clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  testAccount  DOCUMENT ME!
   */
  public void setTestAccount(Boolean testAccount) {
    this.testAccount = testAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the test digit.
   *
   * @param  testDigit  the testDigit to set
   */
  public void setTestDigit(String testDigit) {
    this.testDigit = testDigit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the third agency placement date.
   *
   * @param  thirdAgencyPlacementDate  the thirdAgencyPlacementDate to set
   */
  public void setThirdAgencyPlacementDate(Date thirdAgencyPlacementDate) {
    this.thirdAgencyPlacementDate = thirdAgencyPlacementDate;
  }
  // Times collections

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger7  DOCUMENT ME!
   */
  public void setTimesCollections(Integer clientDefinedInteger7) {
    this.clientDefinedInteger7 = clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger3  DOCUMENT ME!
   */
  public void setTotalElectricReading(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  totalNumberOfPayments  DOCUMENT ME!
   */
  public void setTotalNumberOfPayments(Integer totalNumberOfPayments) {
    this.totalNumberOfPayments = totalNumberOfPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  totalNumberOfPaymentsRemaining  DOCUMENT ME!
   */
  public void setTotalNumberOfPaymentsRemaining(Integer totalNumberOfPaymentsRemaining) {
    this.clientDefinedInteger1 = totalNumberOfPaymentsRemaining;
  }
  // Trace Required

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode2  DOCUMENT ME!
   */
  public void setTraceRequired(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode4  DOCUMENT ME!
   */
  public void setTransactionCode(String clientDefined1CharCode4) {
    this.clientDefined1CharCode4 = clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  treatments  DOCUMENT ME!
   */
  public void setTreatments(Set<TreatmentCandidate> treatments) {
    this.treatments = treatments;
  }
  // triadScenarioID

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode1  DOCUMENT ME!
   */
  public void setTriadScenarioID(String clientDefined4CharCode1) {
    this.clientDefined4CharCode1 = clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  tsysAccount  DOCUMENT ME!
   */
  public void setTsysAccount(TsysAccount tsysAccount) {
    this.tsysAccount = tsysAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  tsysAccountCustomData  DOCUMENT ME!
   */
  public void setTsysAccountCustomData(TsysAccountCustomData tsysAccountCustomData) {
    this.tsysAccountCustomData = tsysAccountCustomData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  tsysAccountStatusCode  DOCUMENT ME!
   */
  public void setTsysAccountStatusCode(TsysAccountStatusCode tsysAccountStatusCode) {
    this.tsysAccountStatusCode = tsysAccountStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  tsysMemos  DOCUMENT ME!
   */
  public void setTsysMemos(Set<TsysMemo> tsysMemos) {
    this.tsysMemos = tsysMemos;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  usbAccount  DOCUMENT ME!
   */
  public void setUsbAccount(USBAccount usbAccount) {
    this.usbAccount = usbAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode1  DOCUMENT ME!
   */
  public void setUSBStatus(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  userLoadedAccounts  DOCUMENT ME!
   */
  public void setUserLoadedAccounts(Set<UserLoadedAccount> userLoadedAccounts) {
    this.userLoadedAccounts = userLoadedAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  viewOnlyWebAccess  DOCUMENT ME!
   */
  public void setViewOnlyWebAccess(Boolean viewOnlyWebAccess) {
    this.viewOnlyWebAccess = viewOnlyWebAccess;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  voiceMailActivities  DOCUMENT ME!
   */
  public void setVoiceMailActivities(Set<VoiceMailActivity> voiceMailActivities) {
    this.voiceMailActivities = voiceMailActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  webActivities  the webActivities to set
   */
  public void setWebActivities(Set<WebActivity> webActivities) {
    this.webActivities = webActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Getters and Setters for DFS Account Import Job Added by Etisbew on 08/19/09-End.
   *
   * @return  getters and Setters for DFS Account Import Job Added by Etisbew on 08/19/09-End
   */
  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String  TAB      = "    ";
    StringBuilder retValue = new StringBuilder();
    retValue.append("Account ( ").append("accountNum = ").append(
      this.accountNum).append(TAB).append("active = ").append(this.active).append(TAB).append("actualExitDate = ")
      .append(this.actualExitDate).append(TAB).append("agencyAccountNumber = ").append(
      this.agencyAccountNumber).append(TAB).append("apr = ").append(
      this.apr).append(TAB).append("balance = ").append(this.balance).append(TAB).append("batchId = ").append(
      this.batchId).append(TAB).append("chargeOffAmount = ").append(this.chargeOffAmount).append(
      TAB).append("chargeOffDate = ").append(this.chargeOffDate).append(
      TAB).append("clientCode = ").append(this.clientCode).append(TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * unlock current locking account.
   *
   * @param   agent  DOCUMENT ME!
   *
   * @return  unlock current locking account
   */
  public boolean unlock(User agent) {
    if ((agent != null) && (this.agent != null)
          && (agent.equals(this.agent))) {
      Date now = new Date();
      this.agent              = null;
      this.lockTime           = null;
      this.lockExpirationTime = null;
      this.lastUpdateDate     = now;

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountDelinquent  DOCUMENT ME!
   */
  public void updateAccountDelinquent(AccountDelinquent accountDelinquent) {
    accountDelinquent.setAccount(this);
    this.accountDelinquent = accountDelinquent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  overallStatus  DOCUMENT ME!
   */
  public void updateAccountOverallStatus(AccountOverallStatus overallStatus) {
    overallStatus.setAccount(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   statusId      Long
   * @param   statusCode    DOCUMENT ME!
   * @param   statusDate    DOCUMENT ME!
   * @param   statusSource  DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   */
  public AccountOverallStatus updateAccountOverallStatus(Long statusId, String statusCode, Date statusDate,
    StatusSource statusSource) {
    AccountOverallStatus currentAccountOverallStatus = getAccountOverallStatus();

    // fixed CA-2848
    if ((currentAccountOverallStatus != null) && (currentAccountOverallStatus.getAccountOverallStatusDetail() != null)
          && currentAccountOverallStatus.getAccountOverallStatusDetail().getStatusId().equals(statusId)) {
      currentAccountOverallStatus.setLastUpdateDate(new Date());

      return currentAccountOverallStatus;
    }

    if (statusId != null) {
      AccountOverallStatusDetail overallStatusDetail = new AccountOverallStatusDetail();
      overallStatusDetail.setStatusId(statusId);
      overallStatusDetail.setStatusCode(statusCode);

      AccountOverallStatus accountOverallStatus = new AccountOverallStatus();
      accountOverallStatus.setAccountOverallStatusDetail(overallStatusDetail);
      accountOverallStatus.setStatusDate(statusDate);

      // batchDate
      accountOverallStatus.setStatusSource(statusSource);
      accountOverallStatus.setAccount(this);
      accountOverallStatus.setHistorical(Boolean.FALSE);

      if (currentAccountOverallStatus != null) {
        currentAccountOverallStatus.setLastUpdateDate(new Date());
        currentAccountOverallStatus.setHistorical(Boolean.TRUE);
      }

      accountOverallStatusSet.add(accountOverallStatus);

      return accountOverallStatus;
    } // end if

    return currentAccountOverallStatus;
  } // end method updateAccountOverallStatus

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update locking expiration time.
   *
   * @param   expiration  DOCUMENT ME!
   *
   * @return  update locking expiration time
   */
  public boolean updateExpirationTime(Date expiration) {
    Date now = new Date();

    if (now.before(expiration)) {
      this.lockExpirationTime = expiration;
      this.lastUpdateDate     = now;

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  tsysAccount  DOCUMENT ME!
   */
  public void updateTsysAccount(TsysAccount tsysAccount) {
    tsysAccount.setAccount(this);
    this.tsysAccount = tsysAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adds a agent call activity for the account.
   *
   * @param   tsysMemo  memo memoryMessage activity DOCUMENT ME!
   *
   * @return  adds a memory message for the account
   */
  public boolean updateTsysMemo(TsysMemo tsysMemo) {
    tsysMemo.setAccount(this);

    return getTsysMemos().add(tsysMemo);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   amount     DOCUMENT ME!
   * @param   roundType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  protected BigDecimal roundAmount(BigDecimal amount, RoundType roundType) {
    if ((amount != null) && (roundType != null)) {
      // round the total amount
      switch (roundType) {
        case CENTS_HALF_UP: {
          return amount.setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        case CENTS_DOWN:
        case REMAINDER_FIRST:
        case SPREAD_REMAINDER: {
          return amount.setScale(2, BigDecimal.ROUND_DOWN);
        }

        case CENTS_UP: {
          return amount.setScale(2, BigDecimal.ROUND_UP);
        }

        // case DOLLARS_HALF_UP :
        // return amount.setScale(0, BigDecimal.ROUND_HALF_UP);
        //
        // case DOLLARS_DOWN :
        // return amount.setScale(0, BigDecimal.ROUND_DOWN);
        case DOLLARS_UP: {
          return amount.setScale(0, BigDecimal.ROUND_UP);
        }
      } // end switch
    }   // end if

    // no round if not support
    return amount;
  } // end method roundAmount

  //~ ------------------------------------------------------------------------------------------------------------------

  private void addPhoneTypeDependencyStatusByPhoneNum(Map<String, ? extends GeneralContactPhone> phones,
    String phoneNum,
    PortfolioPhoneTypeDependency dependency) {
    if (phones != null) {
      for (String key : phones.keySet()) {
        GeneralContactPhone phone = phones.get(key);

        if (phone != null) {
          if ((phoneNum == null) || phoneNum.equals(phone.getPhoneNum())) {
            phone.setDoNotCall(Boolean.TRUE);
          }

          phone.setPhoneTypeDependency(dependency);
        }
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Boolean checkAccountAddressInfo(String name, String value, String city) {
    Set<Responsible> responsibleSet = this.getResponsibles();

    if ((responsibleSet != null) && (responsibleSet.size() > 0)) {
      for (Responsible responsible : responsibleSet) {
        if (responsible.getAddresses() != null) {
          Set<String> types = responsible.getAddresses().keySet();

          for (String type : types) {
            ContactAddress address = responsible.getAddresses().get(type);

            if ("State".equalsIgnoreCase(name)) {
              if ((address.getAddress().getProvince() != null)
                    && address.getAddress().getProvince().equalsIgnoreCase(value)) {
                return true;
              }
            } else if ("ZipCode".equalsIgnoreCase(name)) {
              if ((address.getAddress().getPostalCode() != null)
                    && address.getAddress().getPostalCode().equalsIgnoreCase(value)) {
                return true;
              }
            } else if ("CityState".equalsIgnoreCase(name)) {
              if ((address.getAddress().getProvince() != null) && (address.getAddress().getCity() != null)
                    && address.getAddress().getProvince().equalsIgnoreCase(value)
                    && address.getAddress().getCity().equalsIgnoreCase(city)) {
                return true;
              }
            }
          }
        } // end if
      }   // end for
    }     // end if

    Set<AccountAuthorizedContact> authorizedContactSet = this.getAccountAuthorizedContacts();

    if ((authorizedContactSet != null) && (authorizedContactSet.size() > 0)) {
      for (AccountAuthorizedContact authorizedContact : authorizedContactSet) {
        if (authorizedContact.getAddresses() != null) {
          Set<String> types = authorizedContact.getAddresses().keySet();

          for (String type : types) {
            AuthorizedContactAddress address = authorizedContact.getAddresses().get(type);

            if ("State".equalsIgnoreCase(name)) {
              if ((address.getAddress().getProvince() != null)
                    && address.getAddress().getProvince().equalsIgnoreCase(value)) {
                return true;
              }
            } else if ("ZipCode".equalsIgnoreCase(name)) {
              if ((address.getAddress().getPostalCode() != null)
                    && address.getAddress().getPostalCode().equalsIgnoreCase(value)) {
                return true;
              }
            } else if ("CityState".equalsIgnoreCase(name)) {
              if ((address.getAddress().getProvince() != null) && (address.getAddress().getCity() != null)
                    && address.getAddress().getProvince().equalsIgnoreCase(value)
                    && address.getAddress().getCity().equalsIgnoreCase(city)) {
                return true;
              }
            }
          }
        } // end if
      }   // end for
    }     // end if

    Set<AccountAuthorizedUser> accountAuthorizedUserSet = this.getAccountAuthorizedUsers();

    if ((accountAuthorizedUserSet != null) && (accountAuthorizedUserSet.size() > 0)) {
      for (AccountAuthorizedUser authorizedUser : accountAuthorizedUserSet) {
        if (authorizedUser.getAddresses() != null) {
          Set<String> types = authorizedUser.getAddresses().keySet();

          for (String type : types) {
            AuthorizedUserAddress address = authorizedUser.getAddresses().get(type);

            if ("State".equalsIgnoreCase(name)) {
              if ((address.getAddress().getProvince() != null)
                    && address.getAddress().getProvince().equalsIgnoreCase(value)) {
                return true;
              }
            } else if ("ZipCode".equalsIgnoreCase(name)) {
              if ((address.getAddress().getPostalCode() != null)
                    && address.getAddress().getPostalCode().equalsIgnoreCase(value)) {
                return true;
              }
            } else if ("CityState".equalsIgnoreCase(name)) {
              if ((address.getAddress().getProvince() != null) && (address.getAddress().getCity() != null)
                    && address.getAddress().getProvince().equalsIgnoreCase(value)
                    && address.getAddress().getCity().equalsIgnoreCase(city)) {
                return true;
              }
            }
          }
        } // end if
      }   // end for
    }     // end if

    return false;
  } // end method checkAccountAddressInfo

  //~ ------------------------------------------------------------------------------------------------------------------

  private BigDecimal doSubtractAmount(String principalType) {
    String[]   array = principalType.split("\\-");
    BigDecimal ret;

    if (array.length > 0) {
      ret = getPropertyAmount(array[0]);
    } else {
      return null;
    }

    for (int i = 1; i < array.length; i++) {
      if (StringUtils.hasText(array[i])) {
        ret = ret.subtract(getPropertyAmount(array[i]));
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Integer formatInteger(String value) {
    if (value == null) {
      return null;
    }

    try {
      return new Integer(value);
    } catch (NumberFormatException e) {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Date getAccountStatusMostRecentDate(final String code, final boolean countHistorical) {
    if ((accountStatuses == null) || (accountStatuses.size() == 0)
          || !StringUtils.hasText(code)) {
      return null;
    }

    AccountStatus status = getMostRecentAccountStatus(code,
        countHistorical);

    if (status == null) {
      return null;
    }

    return status.getStatusDate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Date getDate(String dateStr, String pattern) {
    Date fromDate = null;

    if (StringUtils.hasText(dateStr) && StringUtils.hasText(pattern)) {
      try {
        fromDate = (new SimpleDateFormat(pattern)).parse(dateStr);
      } catch (Exception e) {
        log.error(e.getMessage(), e);
      }
    }

    return fromDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Integer getDelinquencyBucket(Set<BucketDelinquentData> bucketDelinquentDataSet,
    Integer numberOfDaysDelinquent) {
    if (bucketDelinquentDataSet != null) {
      for (BucketDelinquentData bucketDelinquentData : bucketDelinquentDataSet) {
        if ((bucketDelinquentData.getMinNumberOfDays()
                < numberOfDaysDelinquent)
              && (numberOfDaysDelinquent
                < bucketDelinquentData.getMaxNumberOfDays())) {
          return bucketDelinquentData.getBucketNumber();
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Boolean getHasScheduledPaymentAfter(Date date) {
    if (date == null) {
      return null;
    }

    for (Payment payment : payments) {
      if (PaymentStatus.SCHEDULED.equals(payment.getPaymentStatus())) {
        if ((DateUtil.toDateOnly(payment.getPaymentDate())).compareTo(
                DateUtil.toDateOnly(date)) > 0) {
          return Boolean.TRUE;
        }
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private AccountStatus getMostRecentAccountStatus(final String code, final boolean countHistorical) {
    return getMostRecentAccountStatus(code, countHistorical, null, null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the most recent account status object that matches the given string-based status code. The match could be
   * either code or description.
   *
   * @param   code                The status code to match. If null, matches any account status. If empty string,
   *                              matches nothing.
   * @param   countHistorical     whether search historical statuses or not.
   * @param   validStatusCodes    DOCUMENT ME!
   * @param   inValidStatusCodes  DOCUMENT ME!
   *
   * @return  get the most recent account status object that matches the given string-based status code.
   */
  private AccountStatus getMostRecentAccountStatus(final String code, final boolean countHistorical,
    String[] validStatusCodes, String[] inValidStatusCodes) {
    if ((code != null)
          && ((accountStatuses == null) || (accountStatuses.size() == 0)
            || !StringUtils.hasText(code))) {
      return null;
    }

    for (AccountStatus accountStatus : accountStatuses) {
      if (countHistorical
            || !Boolean.TRUE.equals(accountStatus.getHistorical())) {
        AccountStatusDetail detail = accountStatus.getAccountStatusDetail();

        if (detail != null) {
          if (code == null) { // no need to match

            if (isValidCode(detail.getStatusCode(),
                    validStatusCodes, inValidStatusCodes)) {
              return accountStatus;
            } else {
              continue;
            }
          }

          // match either code or description
          if (code.equalsIgnoreCase(detail.getStatusCode())
                || code.equalsIgnoreCase(
                  detail.getStatusDescription())) {
            if (isValidCode(detail.getStatusCode(),
                    validStatusCodes, inValidStatusCodes)) {
              return accountStatus;
            } else {
              continue;
            }
          }
        } // end if
      }   // end if
    }     // end for

    return null;
  } // end method getMostRecentAccountStatus

  //~ ------------------------------------------------------------------------------------------------------------------

  private List<AgentCallActivity> getSwcDispositionAgencyAddChangeActivities() {
    List<AgentCallActivity> agencyAddChangeActivitiesList = new ArrayList<AgentCallActivity>();

    if ((agentCallActivities != null) && (agentCallActivities.size() > 0)) {
      for (AgentCallActivity agentCallActivity : agentCallActivities) {
        PortfolioAgentDispositionCode dispCode = agentCallActivity.getPortfolioAgentDispositionCode();

        if ((dispCode != null) && ("ACA".equalsIgnoreCase(dispCode.getDispositionCode()))) {
          agencyAddChangeActivitiesList.add(agentCallActivity);
        }
      }
    }

    return agencyAddChangeActivitiesList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private boolean hasAccountStatus(final String code, final boolean countHistorical) {
    if ((accountStatuses == null) || (accountStatuses.size() == 0)
          || !StringUtils.hasText(code)) {
      return false;
    }

    AccountStatus status = getMostRecentAccountStatus(code,
        countHistorical);

    if (status == null) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if a status code is valid. 1. If valid status code list is empty, ignore it - there is no restriction on it,
   * any text status will be fine. 2. If invalid status code list is empty, ignore it - there is no restriction on it.
   *
   * <p>This means, if both valid codes and invalid codes are empty.</p>
   *
   * @param   code                DOCUMENT ME!
   * @param   validStatusCodes    DOCUMENT ME!
   * @param   invalidStatusCodes  DOCUMENT ME!
   *
   * @return  check if a status code is valid.
   */
  private boolean isValidCode(String code, String[] validStatusCodes, String[] invalidStatusCodes) {
    if (code == null) {
      return false;
    }

    HashSet<String> invalidCodeSet = new HashSet<String>();

    if ((invalidStatusCodes != null) && (invalidStatusCodes.length != 0)) {
      invalidCodeSet.addAll(Arrays.asList(invalidStatusCodes));
    }

    if ((validStatusCodes == null) || (validStatusCodes.length == 0)) {
      return !invalidCodeSet.contains(code);
    }

    for (String statusCode : validStatusCodes) {
      if (code.equalsIgnoreCase(statusCode)
            && !invalidCodeSet.contains(statusCode)) {
        return true;
      }
    }

    return false;
  } // end method isValidCode

  //~ ------------------------------------------------------------------------------------------------------------------

  private void removePhoneTypeDependencyStatus(Map<String, ? extends GeneralContactPhone> phones) {
    if (phones != null) {
      for (String key : phones.keySet()) {
        GeneralContactPhone phone = phones.get(key);

        if (phone != null) {
          phone.setDoNotCall(Boolean.FALSE);
          phone.setPhoneTypeDependency(null);
        }
      }
    }
  }
} // end class Account
