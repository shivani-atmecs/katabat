package com.cmc.credagility.core.domain.responsible;

import java.io.Serializable;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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

import org.apache.commons.lang3.time.DateUtils;

import org.hibernate.annotations.Where;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountPolicy;
import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.address.AddressType;
import com.cmc.credagility.core.domain.channel.ChannelType;
import com.cmc.credagility.core.domain.channel.ChannelVendor;
import com.cmc.credagility.core.domain.channel.DialerAudit;
import com.cmc.credagility.core.domain.channel.DialerChannelResult;
import com.cmc.credagility.core.domain.channel.DialerServiceVendor;
import com.cmc.credagility.core.domain.channel.EmailChannelResult;
import com.cmc.credagility.core.domain.channel.EmailServiceVendor;
import com.cmc.credagility.core.domain.channel.EmailType;
import com.cmc.credagility.core.domain.channel.IvrChannelResult;
import com.cmc.credagility.core.domain.channel.IvrServiceVendor;
import com.cmc.credagility.core.domain.channel.LetterChannelActualResult;
import com.cmc.credagility.core.domain.channel.LetterChannelResult;
import com.cmc.credagility.core.domain.channel.LetterServiceVendor;
import com.cmc.credagility.core.domain.channel.SmsChannelResult;
import com.cmc.credagility.core.domain.channel.SmsServiceVendor;
import com.cmc.credagility.core.domain.channel.VoiceMailActivity;
import com.cmc.credagility.core.domain.client.AdvisorAppointment;
import com.cmc.credagility.core.domain.client.Attorney;
import com.cmc.credagility.core.domain.client.Bankruptcy;
import com.cmc.credagility.core.domain.contact.ContactAddress;
import com.cmc.credagility.core.domain.contact.ContactEmail;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.domain.contact.ContactableBaseObject;
import com.cmc.credagility.core.domain.contact.FuturePermanentContactAddress;
import com.cmc.credagility.core.domain.contact.FuturePermanentContactPhone;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.domain.contact.TemporaryContactAddress;
import com.cmc.credagility.core.domain.contact.TemporaryContactPhone;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.customer.CustomerContactEmail;
import com.cmc.credagility.core.domain.document.Document;
import com.cmc.credagility.core.domain.document.DocumentHistory;
import com.cmc.credagility.core.domain.document.DocumentTypeStatusType;
import com.cmc.credagility.core.domain.homeequity.HomeEquityCTMSurvey;
import com.cmc.credagility.core.domain.homeequity.HomeEquityRefiSurvey;
import com.cmc.credagility.core.domain.homeequity.HomeEquitySurvey;
import com.cmc.credagility.core.domain.income.Income;
import com.cmc.credagility.core.domain.livechat.LiveChatSession;
import com.cmc.credagility.core.domain.negotiate.NegotiateConfirmationLetter;
import com.cmc.credagility.core.domain.payment.FundingAccount;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.domain.payment.PaymentProgramInstallment;
import com.cmc.credagility.core.domain.payment.PaymentReminder;
import com.cmc.credagility.core.domain.payment.PromiseToPay;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioChannelTemplate;
import com.cmc.credagility.core.domain.portfolio.PortfolioChannelType;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyAnswer;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyAnswerUserSavedValue;
import com.cmc.credagility.core.domain.score.ScoreType;
import com.cmc.credagility.core.domain.slm.SlmSchoolStatus;
import com.cmc.credagility.core.domain.survey.SurveyAnswer;
import com.cmc.credagility.core.domain.transaction.Expense;
import com.cmc.credagility.core.domain.tsys.TsysAttorney;
import com.cmc.credagility.core.domain.tsys.TsysBankruptcy;
import com.cmc.credagility.core.domain.tsys.TsysDeceased;
import com.cmc.credagility.core.domain.tsys.TsysJudgement;
import com.cmc.credagility.core.domain.type.AppointmentStatus;
import com.cmc.credagility.core.domain.type.ChannelResultStatus;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;
import com.cmc.credagility.core.domain.type.ContactSource;
import com.cmc.credagility.core.domain.type.ContactStatus;
import com.cmc.credagility.core.domain.type.CustomerType;
import com.cmc.credagility.core.domain.type.DoNotContactReason;
import com.cmc.credagility.core.domain.type.ExpressConsentType;
import com.cmc.credagility.core.domain.type.FundingAccountType;
import com.cmc.credagility.core.domain.type.HardShip;
import com.cmc.credagility.core.domain.type.LocaleType;
import com.cmc.credagility.core.domain.type.PaymentChannel;
import com.cmc.credagility.core.domain.type.PaymentStatus;
import com.cmc.credagility.core.domain.type.PromiseToPayStatus;
import com.cmc.credagility.core.domain.type.ReminderStatus;
import com.cmc.credagility.core.domain.type.ReminderType;
import com.cmc.credagility.core.domain.type.ScoreSource;
import com.cmc.credagility.core.domain.type.ScoreTypeEnum;
import com.cmc.credagility.core.domain.type.WebActivityChannel;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.cmc.credagility.core.domain.util.FormatUtil;
import com.cmc.credagility.core.domain.util.PersonaActionComparator;
import com.cmc.credagility.core.domain.webactivity.BaseWebActivity;
import com.cmc.credagility.core.domain.webactivity.UpdateEmailActivity;
import com.cmc.credagility.core.domain.webactivity.WebActivity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;
import com.cmc.credagility.util.CollectionUtil;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.ozstrategy.credagility.core.domain.PersonaAccount;
import com.ozstrategy.credagility.core.domain.PersonaAction;
import com.ozstrategy.credagility.core.domain.ResponsiblePortfolioScore;


/**
 * This class is used to store Responsible information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 11:49
 */
@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property  = "responsibleId",
  scope     = Responsible.class
)
@Table(
  uniqueConstraints = {
    @UniqueConstraint(
      name          = "attorneyId",
      columnNames   = "attorneyId"
    ),
    @UniqueConstraint(
      name          = "bankruptcyId",
      columnNames   = "bankruptcyId"
    ),
    @UniqueConstraint(
      name          = "userLogon",
      columnNames   = "userLogon"
    )
  },
  indexes           = {
    @Index(
      name          = "last4SsnIndex",
      columnList    = "last4Ssn"
    ), @Index(
      name          = "lastNameIndex",
      columnList    = "lastName"
    ), @Index(
      name          = "responsibleIdIndex",
      columnList    = "responsibleId"
    ), @Index(
      name          = "ssnIndex",
      columnList    = "ssn"
    ), @Index(
      name          = "responsibleIdentificationNumberIndex",
      columnList    = "responsibleIdentificationNumber"
    )
  }
)
public class Responsible extends ContactableBaseObject implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected static final transient Logger log = LoggerFactory.getLogger(
      Responsible.class);


  private static final long serialVersionUID = -5957785896897854889L;

  /** DOCUMENT ME! */
  public static final String ACTION_LOG_PREFIX = "a_";

  /** DOCUMENT ME! */
  public static final String UPDATE_EMAIL = "UpdateEmail";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @OrderBy("acceptDate desc")
  @Where(clause = "programStatus='ACCEPTED'")
  protected Set<PaymentProgram> acceptedPaymentPrograms = new LinkedHashSet<PaymentProgram>();

  /** Relations Responsible Account : */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(cascade = CascadeType.ALL)
  protected Account account;

  /** Relations Responsible Contact : */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, ContactAddress> addresses = new HashMap<String, ContactAddress>();

  /** Relations Account AgentCallActivity. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<AgentCallActivity> agentCallActivities = new LinkedHashSet<AgentCallActivity>();

  /** Relation Responsible AdvisorAppointment : 1 M */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<AdvisorAppointment> appointments = new HashSet<AdvisorAppointment>();

  /** assets. */
  @Column(name = "assets")
  protected BigDecimal assets;

  /** DOCUMENT ME! */
  @Column(
    name   = "bankruptInd",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean bankruptInd;

  /** bureau score. */
  @Column(name = "bureauScore")
  protected Integer bureauScore;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<NegotiateConfirmationLetter> confirmLetters = new LinkedHashSet<NegotiateConfirmationLetter>();

  /** custodial account. */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean custodialAccount;

  /** Date of birth. */
  @Column(name = "dateOfBirth")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date dateOfBirth;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<DialerChannelResult> dialerChannelResults = new LinkedHashSet<DialerChannelResult>();

  /** Relations Account Document : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate DESC")
  protected Set<DocumentHistory> documentHistories = new LinkedHashSet<DocumentHistory>();

  /** Relations Account Document : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate DESC")
  @Where(clause = "active='Y'")
  protected Set<Document> documents = new LinkedHashSet<Document>();

  /** Relations Account ChannelResult : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<EmailChannelResult> emailChannelResults = new LinkedHashSet<EmailChannelResult>();


  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, ContactEmail> emails = new HashMap<String, ContactEmail>();


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerAddress",
    length = 255
  )
  protected String employerAddress;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerName",
    length = 50
  )
  protected String employerName;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<Expense> expenses = new LinkedHashSet<Expense>();

  /** first name. */
  @Column(
    name   = "firstName",
    length = 45
  )
  protected String firstName;

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @OrderBy("acceptDate desc")
  @Where(clause = "programStatus='ACCEPTED' and acceptAgentId is null")
  protected Set<PaymentProgram> flexSitePaymentPrograms = new LinkedHashSet<PaymentProgram>();


  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @OrderBy("lastUpdateDate desc")
  @Where(clause = "paymentChannel='DEBTORSITE' and paymentStatus not in ('DELETED','REMOVED','REJECTED')")
  protected Set<Payment> flexSitePayments = new LinkedHashSet<Payment>();


  /** Relations Responsible FundingAccount : */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "responsible",
    cascade  =
      CascadeType.ALL
      // orphanRemoval = true
  )
  protected Set<FundingAccount> fundingAccounts = new LinkedHashSet<FundingAccount>();


  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, FuturePermanentContactAddress> futurePermanentAddresses =
    new HashMap<String, FuturePermanentContactAddress>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical='Y'")
  protected Set<FuturePermanentContactAddress> futurePermanentHistoricalAddresses =
    new LinkedHashSet<FuturePermanentContactAddress>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical='Y'")
  protected Set<FuturePermanentContactPhone> futurePermanentHistoricalPhones =
    new LinkedHashSet<FuturePermanentContactPhone>();


  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, FuturePermanentContactPhone> futurePermanentPhones =
    new HashMap<String, FuturePermanentContactPhone>();

  /** gender. */
  @Column(
    name   = "gender",
    length = 1
  )
  protected String gender;

  /** guaranteer account. */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean guarantor;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical='Y'")
  protected Set<ContactAddress> historicalAddresses = new LinkedHashSet<ContactAddress>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical='Y'")
  protected Set<ContactEmail> historicalEmails = new LinkedHashSet<ContactEmail>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical='Y'")
  protected Set<ContactPhone> historicalPhones = new LinkedHashSet<ContactPhone>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<HomeEquityCTMSurvey> homeEquityCTMSurveys = new LinkedHashSet<HomeEquityCTMSurvey>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<HomeEquityRefiSurvey> homeEquityRefiSurveys = new LinkedHashSet<HomeEquityRefiSurvey>();

  /*
   * Below code is commented to achieve One to Many relationship between
   * Responsible and HomeEquitySurvey. By Kpalanivelu
   */
  // /** Home Equity Survey */
  // protected HomeEquitySurvey homeEquitySurvey;
  // protected HomeEquityAcceptedTreatment homeEquityAcceptedTreatment;
  /** Home Equity Accepted Treatment. */
  /** Relations Responsible HomeEquitySurvey : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<HomeEquitySurvey> homeEquitySurveys = new LinkedHashSet<HomeEquitySurvey>();

  /** home owner. */

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean homeowner;

  /** annual income. */
  @Column(name = "income")
  protected BigDecimal income;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<Income> incomes = new LinkedHashSet<Income>();


  /** TODO: DOCUMENT ME! */
  @Transient protected boolean isZipRequiredFull = false;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<IvrChannelResult> ivrChannelResults = new LinkedHashSet<IvrChannelResult>();

  /** last 4 of SSN: since these will be encrypted eventually, we need this to be in a column */
  @Column(
    name   = "last4Ssn",
    length = 4
  )
  protected String last4Ssn;

  /** Last contact date. */
  @Column(name = "lastContactDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastContactDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastLetterDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLetterDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastLetterId")
  protected Long lastLetterId;

  /** last web login date for this accoun. */
  @Column(name = "lastLoginDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLoginDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastLoginFailureDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLoginFailureDate;

  // npelleti, 08/02, USBank, Added Index


  /** last name. */
  @Column(
    name   = "lastName",
    length = 55
  )
  protected String lastName;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<LetterChannelActualResult> letterChannelActualResults = new LinkedHashSet<LetterChannelActualResult>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<LetterChannelResult> letterChannelResults = new LinkedHashSet<LetterChannelResult>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy = "responsible",
    fetch    = FetchType.LAZY,
    cascade  = CascadeType.ALL
  )
  protected Set<LiveChatSession> liveChatSessions = new LinkedHashSet<LiveChatSession>();

  /** Relation Responsible Loan: */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("loanIdentifier asc")
  protected Set<Loan> loans = new LinkedHashSet<Loan>();


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "localeString",
    length = 12
  )
  protected String localeString;


  /** TODO: DOCUMENT ME! */
  @Column(name = "loginFailureCount")
  protected Integer loginFailureCount = 0;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "matchConfidence",
    length = 250
  )
  protected String matchConfidence;

  /** middle name. */
  @Column(
    name   = "middleName",
    length = 45
  )
  protected String middleName;


  /** TODO: DOCUMENT ME! */
  @Column(name = "monthlyIncome")
  protected BigDecimal monthlyIncome;


  /** TODO: DOCUMENT ME! */
  @Column(name = "monthlyPayment")
  protected BigDecimal monthlyPayment;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "motherMaidenName",
    length = 55
  )
  protected String motherMaidenName;

  /** name suffix. */
  @Column(
    name   = "nameSuffix",
    length = 4
  )
  protected String nameSuffix;

  /** Relation Responsible Loan: */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("loanIdentifier asc")
  @Where(clause = "artivaState not in ('CHOF')")
  protected Set<Loan> nonChargedOffLoans = new LinkedHashSet<Loan>();

  /** original date time-stamp. */
  @Column(name = "originalDateTimestamp")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date originalDateTimestamp;


  /** TODO: DOCUMENT ME! */
  @Column(name = "otherMonthlyIncome")
  protected BigDecimal otherMonthlyIncome;


  /** TODO: DOCUMENT ME! */
  @Column(name = "otherMonthlyPayment")
  protected BigDecimal otherMonthlyPayment;

  /** Payment program accepted by Responsible. Could be null. Need to cascade. */
  @JoinColumn(name = "programId")
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected PaymentProgram paymentProgram;

  /** Relations Responsible Payment : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("paymentDate asc")
  protected Set<Payment> payments = new LinkedHashSet<Payment>();


  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, ContactPhone> phones = new HashMap<String, ContactPhone>();

  /** Portfolio Survey Answer. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("surveyDate desc")
  protected Set<PortfolioSurveyAnswer> portfolioSurveyAnswers = new LinkedHashSet<PortfolioSurveyAnswer>();


  /** Portfolio Survey Answer User Saved Value. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("surveyDate desc")
  protected Set<PortfolioSurveyAnswerUserSavedValue> portfolioSurveyAnswerUserSavedValues =
    new LinkedHashSet<PortfolioSurveyAnswerUserSavedValue>();

  /** communication preference: Home Address */
  @Column(name = "preferHomeAddress")
  protected Integer preferHomeAddress;

  /** communication preference: Home Email. Integer means the order of communication - not used for now */
  @Column(name = "preferHomeEmail")
  protected Integer preferHomeEmail;

  /** communication preference: Home Phone */
  @Column(name = "preferHomePhone")
  protected Integer preferHomePhone;

  /** communication preference: Mobile Phone */
  @Column(name = "preferMobilePhone")
  protected Integer preferMobilePhone;

  /** communication preference: Text Message */
  @Column(name = "preferTextMessage")
  protected Integer preferTextMessage;

  /** communication preference: Work Phone */
  @Column(name = "preferWorkPhone")
  protected Integer preferWorkPhone;

  /** primaryHolder Responsible. */

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean primaryHolder;

  /** Responsible Promise to pay : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("paymentDate asc")
  protected Set<PromiseToPay> promises = new LinkedHashSet<PromiseToPay>();

  /** reason for delinquency. */
  @Column(
    name   = "reasonForDelinquency",
    length = 15
  )
  protected String reasonForDelinquency;


  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected ResponsibleConfig responsibleConfig = null;

  // Added by Etisbew on 04/27/09 for NCC2 E-sign Agreement Disclosure-START

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected ResponsibleDetail responsibleDetail = null;

  /** DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected ResponsibleExtensionBoolean responsibleExtensionBoolean = null;

  /** DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected ResponsibleExtensionChar responsibleExtensionChar = null;

  /** DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected ResponsibleExtensionDate responsibleExtensionDate = null;

  /** DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected ResponsibleExtensionDecimal responsibleExtensionDecimal = null;

  /** DOCUMENT ME! */
  @OneToOne(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected ResponsibleExtensionInteger responsibleExtensionInteger = null;

  /** Card holder id PK. */
  @Column(
    name     = "responsibleId",

    // unique = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long responsibleId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "responsibleIdentificationNumber",
    length = 255
  )
  @Convert(converter = StringEncryptionConverter.class)
  protected String responsibleIdentificationNumber;


  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected ResponsibleIndex responsibleIndex = null;


  /*    @Cascade(
   *      {
   *          org.hibernate.annotations.CascadeType.DELETE_ORPHAN,
   *          org.hibernate.annotations.CascadeType.ALL
   *      }
   *  )*/
  /** TODO: DOCUMENT ME! */
  @OneToOne(mappedBy = "responsible")
  protected ResponsiblePageVisit responsiblePageVisit = null;
  // npelleti, 08/02, USBank, Added Index, dropped Unique constraint

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<ResponsiblePolicy> responsiblePolicies = new LinkedHashSet<ResponsiblePolicy>();

  /** Portfolio Score. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("portfolioScoreType desc")
  protected Set<ResponsiblePortfolioScore> responsiblePortfolioScores = new LinkedHashSet<ResponsiblePortfolioScore>();

  /** A set of scores. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("scoreDate asc")
  protected Set<ResponsibleScore> responsibleScores = new HashSet<ResponsibleScore>();

  /** revised date time-stamp. */
  @Column(name = "revisedDateTimestamp")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date revisedDateTimestamp;

  /** second first name. */
  @Column(
    name   = "secondFirstName",
    length = 45
  )
  protected String secondFirstName;

  /** second last name. */
  @Column(
    name   = "secondLastName",
    length = 55
  )
  protected String secondLastName;

  /** second to last web login date for this account. */
  @Column(name = "secondToLastLoginDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date secondToLastLoginDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "secondToLastLoginFailureDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date secondToLastLoginFailureDate;

  /** the date this user accept prefer SMS. */
  @Column(name = "smsAcceptanceDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date smsAcceptanceDate;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<SmsChannelResult> smsChannelResults = new LinkedHashSet<SmsChannelResult>();

  // npelleti, 08/02, USBank, Added Index


  /** S.S.N. */
  @Column(
    name   = "ssn",
    length = 50
  )
  @Convert(converter = StringEncryptionConverter.class)
  protected String ssn;

  /** Survey Answer. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<SurveyAnswer> surveyAnswers = new LinkedHashSet<SurveyAnswer>();

  /** Survey taking round. */
  @Column(
    name     = "surveyRound",
    nullable = false
  )
  protected Integer surveyRound = 0;


  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, TemporaryContactAddress> temporaryAddresses = new HashMap<String, TemporaryContactAddress>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical='Y'")
  protected Set<TemporaryContactAddress> temporaryHistoricalAddresses = new LinkedHashSet<TemporaryContactAddress>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical='Y'")
  protected Set<TemporaryContactPhone> temporaryHistoricalPhones = new LinkedHashSet<TemporaryContactPhone>();


  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "typeId")
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @Where(clause = "historical is null or historical='N'")
  protected Map<String, TemporaryContactPhone> temporaryPhones = new HashMap<String, TemporaryContactPhone>();

  /** the date this user accept terms and condition. */
  @Column(name = "termAcceptanceDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date termAcceptanceDate;

  /** time zone. */
  @Column(
    name   = "timezone",
    length = 45
  )
  protected String timezone;

  /** total household annual income. */
  @Column(name = "totalHouseholdIncome")
  protected BigDecimal totalHouseholdIncome;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @OrderBy("createDate DESC")
  protected Set<TsysAttorney> tsysAttorneys = new LinkedHashSet<TsysAttorney>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<TsysBankruptcy> tsysBankruptcies = new LinkedHashSet<TsysBankruptcy>();


  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  protected TsysDeceased tsysDeceased = null;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<TsysJudgement> tsysJudgements = new LinkedHashSet<TsysJudgement>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("vmDate asc")
  protected Set<VoiceMailActivity> voiceMailActivities = new LinkedHashSet<VoiceMailActivity>();

  /** Responsible Web Activity : */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<WebActivity> webActivities = new LinkedHashSet<WebActivity>();


  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @OrderBy("lastUpdateDate desc")
  @Where(clause = "insertBy='Web' and paymentStatus not in ('DELETED','REMOVED','REJECTED')")
  protected Set<Payment> webPayments = new LinkedHashSet<Payment>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @OrderBy("lastUpdateDate desc")
  @Where(clause = "source='AGENT' or source='DEBTOR'")
  protected Set<ContactAddress> webUpdateAddress = new LinkedHashSet<ContactAddress>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @OrderBy("lastUpdateDate desc")
  @Where(clause = "source='AGENT' or source='DEBTOR'")
  protected Set<ContactEmail> webUpdateEmails = new LinkedHashSet<ContactEmail>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "responsible"
  )
  @OrderBy("lastUpdateDate desc")
  @Where(clause = "source='AGENT' or source='DEBTOR'")
  protected Set<ContactPhone> webUpdatePhones = new LinkedHashSet<ContactPhone>();

  /** zip code, for user login. */
  @Column(
    name   = "zipCode",
    length = 10
  )
  protected String zipCode;

  /** zip code changed, user need to use the new zip code to login. */
  @Transient protected boolean zipCodeChanged = false;

  @JoinColumn(
    name   = "attorneyId",
    unique = true
  )
  @OneToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  private Attorney attorney;

  @JoinColumn(
    name   = "bankruptcyId",
    unique = true
  )
  @OneToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  private Bankruptcy bankruptcy;

  @Column(
    name   = "customerType",
    length = 2
  )
  @Enumerated(EnumType.STRING)
  private CustomerType customerType;

  /** date of death, if applicable. */
  @Column(name = "deceasedDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date deceasedDate;

  @Column(name = "directCallCount")
  private Integer directCallCount;

  @Column(name = "ivrInboundCount")
  private Integer ivrInboundCount;
  @Column(
    name   = "password",
    length = 15
  )
  private String  password;

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsible",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @Where(clause = "historical is null or historical='N'")
  private Set<PersonaAccount> personaAccounts = new LinkedHashSet<PersonaAccount>();

  @Transient private Set<String> personaSet;

  @Column(
    name   = "preferredContactMethod",
    length = 50
  )
  private String preferredContactMethod;

  @Column(name = "rpcCount")
  private Integer rpcCount;

  /**
   * This is added for ScoreNet. But it could be used for us too. This is basically the order of responsibles. 00 --
   * means Debtor 01-99 means guarantors.
   */
  @Column(name = "sequenceNum")
  private Integer sequenceNum;

  @Transient private Map<String, PortfolioSurveyAnswer> tempAnswers = new HashMap<String, PortfolioSurveyAnswer>();

  @Column(
    name   = "title",
    length = 30
  )
  private String title;

  @Column(
    name     = "userLogon",
    length   = 20,
    unique   = true,
    nullable = false
  )
  private String userLogon;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addAccountScore.
   *
   * @param   responsibleScore  ResponsibleScore
   *
   * @return  boolean
   */
  public boolean addAccountScore(ResponsibleScore responsibleScore) {
    if ((responsibleScore.getScoreValue() == null)
          || (responsibleScore.getScoreType() == null)) {
      return false;
    }

    return this.responsibleScores.add(responsibleScore);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addAddress.
   *
   * @param  address  ContactAddress
   */
  public void addAddress(ContactAddress address) {
    getAddresses().put(address.getAddressType().getTypeId().toString(),
      address);
    address.setResponsible(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addAgentCallActivity.
   *
   * @param   agentCallActivity  AgentCallActivity
   *
   * @return  boolean
   */
  public boolean addAgentCallActivity(AgentCallActivity agentCallActivity) {
    if (agentCallActivity == null) {
      return false;
    }

    agentCallActivity.setResponsible(this);

    return this.agentCallActivities.add(agentCallActivity);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addAppointment.
   *
   * @param   appointment  AdvisorAppointment
   *
   * @return  boolean
   */
  public boolean addAppointment(AdvisorAppointment appointment) {
    boolean b = getAppointments().add(appointment);

    if (b) {
      appointment.setResponsible(this);
      appointment.setAccount(this.account);
    }

    return b;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addDialerChannelResult.
   *
   * @param  batchId   Long
   * @param  ruleId    Long
   * @param  template  String
   * @param  vendor    DialerServiceVendor
   * @param  source    String
   */
  public void addDialerChannelResult(Long batchId, Long ruleId, String template, DialerServiceVendor vendor,
    String source) {
    if (log.isDebugEnabled()) {
      log.debug("Add dialer channel result (1): batchId: " + batchId + " template: " + template + " ruleId: " + ruleId);
    }

    if (getIsContactableByPhone()) {
      Account account = this.getAccount();

      // allow this channel result, generate
      DialerChannelResult channelResult = new DialerChannelResult();
      channelResult.setRuleBatchId(batchId);
      channelResult.setRuleId(ruleId);
      channelResult.setAccount(account);
      channelResult.setStrategyDate(DateUtil.toDateOnly(new Date()));
      channelResult.setExportDate(null);
      channelResult.setExecuteDate(null);
      channelResult.setResponsible(this);
      channelResult.setTemplate(template);
      channelResult.setBalance(account.getBalance());
      channelResult.setCurrentDue(account.getCurrentDue());
      channelResult.setPastDue(account.getPastDue());
      channelResult.setStatus(ChannelResultStatus.INIT);
      channelResult.setVendor(vendor);
      channelResult.setSource(source);

      dialerChannelResults.add(channelResult);
    } else {
      log.info("FAILED to add dialer channel result (1): batchId: " + batchId + " template: " + template + " ruleId: "
        + ruleId);
    } // end if-else
    // end if
  }   // end method addDialerChannelResult

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addDialerChannelResult.
   *
   * @param  batchId   Long
   * @param  ruleId    Long
   * @param  template  PortfolioChannelTemplate
   * @param  vendor    ChannelVendor
   * @param  source    String
   */
  public void addDialerChannelResult(Long batchId, Long ruleId, PortfolioChannelTemplate template, ChannelVendor vendor,
    String source) {
    if (log.isDebugEnabled()) {
      log.debug("Add dialer channel result: batchId: " + batchId + " template: " + template + " ruleId: " + ruleId);
    }

    if (getIsContactableByPhone()) {
      if (log.isDebugEnabled()) {
        log.debug("Add dialer channel result: batchId: " + batchId + " template: " + template + " ruleId: " + ruleId);
      }

      Account account = this.getAccount();

      // allow this channel result, generate
      DialerChannelResult channelResult = new DialerChannelResult();
      channelResult.setRuleBatchId(batchId);
      channelResult.setRuleId(ruleId);
      channelResult.setAccount(account);
      channelResult.setStrategyDate(DateUtil.toDateOnly(new Date()));
      channelResult.setExportDate(null);
      channelResult.setExecuteDate(null);
      channelResult.setResponsible(this);
      channelResult.setTemplate(template.getName());
      channelResult.setTemplateId(template.getId());
      channelResult.setBalance(account.getBalance());
      channelResult.setCurrentDue(account.getCurrentDue());
      channelResult.setPastDue(account.getPastDue());
      channelResult.setStatus(ChannelResultStatus.INIT);
      channelResult.setChannelVendor(vendor);
      channelResult.setSource(source);

      if (log.isDebugEnabled()) {
        log.debug("dialer channel result: size before: " + dialerChannelResults.size());
      }

      dialerChannelResults.add(channelResult);

      if (log.isDebugEnabled()) {
        log.debug("dialer channel result: size after: " + dialerChannelResults.size());
      }


    } else {
      log.info("FAILED to add dialer channel result : batchId: " + batchId + " template: " + template + " ruleId: "
        + ruleId);
    } // end if-else

  } // end method addDialerChannelResult

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addDocument.
   *
   * @param  agent     User
   * @param  document  Document
   */
  public void addDocument(User agent, Document document) {
    document.setResponsible(this);
    this.getAccount().addDocument(agent, document);
  } // end method addDocument

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addEmail.
   *
   * @param  email  ContactEmail
   */
  public void addEmail(ContactEmail email) {
    getEmails().put(email.getEmailType().getTypeId().toString(), email);
    email.setResponsible(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addEmailChannelResult.
   *
   * @param  batchId   Long
   * @param  ruleId    Long
   * @param  template  String
   * @param  vendor    EmailServiceVendor
   * @param  source    String
   */
  public void addEmailChannelResult(Long batchId, Long ruleId, String template, EmailServiceVendor vendor,
    String source) {
    // check whether this responsible has contactable emails
    if (getIsContactableByEmail()) {
      Account account = this.getAccount();

      // allow this channel result, generate
      EmailChannelResult channelResult = new EmailChannelResult();
      channelResult.setRuleBatchId(batchId);
      channelResult.setRuleId(ruleId);
      channelResult.setAccount(account);
      channelResult.setStrategyDate(DateUtil.toDateOnly(new Date()));
      channelResult.setExportDate(null);
      channelResult.setExecuteDate(null);
      channelResult.setResponsible(this);
      channelResult.setTemplate(template);
      channelResult.setBalance(account.getBalance());
      channelResult.setCurrentDue(account.getCurrentDue());
      channelResult.setPastDue(account.getPastDue());
      channelResult.setStatus(ChannelResultStatus.INIT);
      channelResult.setVendor(vendor);
      channelResult.setSource(source);

      emailChannelResults.add(channelResult);
    }
  } // end method addEmailChannelResult

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addEmailChannelResult.
   *
   * @param  batchId   Long
   * @param  ruleId    Long
   * @param  template  PortfolioChannelTemplate
   * @param  vendor    ChannelVendor
   * @param  source    String
   */
  public void addEmailChannelResult(Long batchId, Long ruleId, PortfolioChannelTemplate template, ChannelVendor vendor,
    String source) {
    // check whether this responsible has contactable emails
    if (getIsContactableByEmail()) {
      Account account = this.getAccount();

      // allow this channel result, generate
      EmailChannelResult channelResult = new EmailChannelResult();
      channelResult.setRuleBatchId(batchId);
      channelResult.setRuleId(ruleId);
      channelResult.setAccount(account);
      channelResult.setStrategyDate(DateUtil.toDateOnly(new Date()));
      channelResult.setExportDate(null);
      channelResult.setExecuteDate(null);
      channelResult.setResponsible(this);
      channelResult.setTemplate(template.getName());
      channelResult.setTemplateId(template.getId());
      channelResult.setBalance(account.getBalance());
      channelResult.setCurrentDue(account.getCurrentDue());
      channelResult.setPastDue(account.getPastDue());
      channelResult.setStatus(ChannelResultStatus.INIT);
      channelResult.setChannelVendor(vendor);
      channelResult.setSource(source);
      channelResult.setEmailAddress(this.getDefaultEmailStr());

      emailChannelResults.add(channelResult);

    } // end if
  }   // end method addEmailChannelResult

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addFundingAccount.
   *
   * @param   fundingAccount  FundingAccount
   *
   * @return  boolean
   */
  public boolean addFundingAccount(FundingAccount fundingAccount) {
    /*
     * First Check to make sure this funding account has Nick Name. The
     * contract is to generate a Nick Name for this funding account if there
     * is none.
     */
    if (fundingAccount == null) {
      return false;
    }

    // Added by RamaKrishna on 9/12/2009 to fix SM-76 --START
    for (FundingAccount f : getFundingAccounts()) {
      // Found existing account
      if (f.equals(fundingAccount)) {
        return false;
      }
    }

    fundingAccount.setResponsible(this);

    // Added by RamaKrishna on 9/12/2009 to fix SM-76 --END
    Long portfolioId = null;

    if ((fundingAccount.getResponsible() != null) && (fundingAccount.getResponsible().getAccount() != null)
          && (fundingAccount.getResponsible().getAccount().getPortfolio() != null)) {
      portfolioId = fundingAccount.getResponsible().getAccount().getPortfolio().getPortfolioId();
    }

    if (!fundingAccount.ensureNickName(portfolioId)) {
      return false; // no funding account number so no nickname
    }

    return getFundingAccounts().add(fundingAccount);
  } // end method addFundingAccount

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addHistoricalAddress.
   *
   * @param  historicalAddress  ContactAddress
   */
  public void addHistoricalAddress(ContactAddress historicalAddress) {
    historicalAddress.setResponsible(this);
    historicalAddress.setHistorical(Boolean.TRUE);
    this.historicalAddresses.add(historicalAddress);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addIvrChannelResult.
   *
   * @param  batchId    Long
   * @param  ruleId     Long
   * @param  template   String
   * @param  vendor     IvrServiceVendor
   * @param  startTime  String
   * @param  endTime    String
   * @param  source     String
   */
  public void addIvrChannelResult(Long batchId, Long ruleId, String template, IvrServiceVendor vendor, String startTime,
    String endTime, String source) {
    // check whether this responsible has contactable phone
    if (getIsContactableByPhone()) {
      Account account = this.getAccount();

      // allow this channel result, generate
      IvrChannelResult channelResult = new IvrChannelResult();
      channelResult.setRuleBatchId(batchId);
      channelResult.setRuleId(ruleId);
      channelResult.setAccount(account);
      channelResult.setStrategyDate(DateUtil.toDateOnly(new Date()));
      channelResult.setExportDate(null);
      channelResult.setExecuteDate(null);
      channelResult.setResponsible(this);
      channelResult.setTemplate(template);
      channelResult.setBalance(account.getBalance());
      channelResult.setCurrentDue(account.getCurrentDue());
      channelResult.setPastDue(account.getPastDue());
      channelResult.setStatus(ChannelResultStatus.INIT);
      channelResult.setVendor(vendor);
      channelResult.setStartTime(startTime);
      channelResult.setEndTime(endTime);
      channelResult.setSource(source);

      ivrChannelResults.add(channelResult);
    } else {
      log.warn("Responsible# " + this.responsibleId + " is not contactable by phone.");
    } // end if-else
  }   // end method addIvrChannelResult

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addIvrChannelResult.
   *
   * @param  batchId    Long
   * @param  ruleId     Long
   * @param  template   PortfolioChannelTemplate
   * @param  vendor     ChannelVendor
   * @param  startTime  String
   * @param  endTime    String
   * @param  source     String
   */
  public void addIvrChannelResult(Long batchId, Long ruleId, PortfolioChannelTemplate template, ChannelVendor vendor,
    String startTime, String endTime, String source) {
    // check whether this responsible has contactable phone
    if (getIsContactableByPhone()) {
      Account account = this.getAccount();

      // allow this channel result, generate
      IvrChannelResult channelResult = new IvrChannelResult();
      channelResult.setRuleBatchId(batchId);
      channelResult.setRuleId(ruleId);
      channelResult.setAccount(account);
      channelResult.setStrategyDate(DateUtil.toDateOnly(new Date()));
      channelResult.setExportDate(null);
      channelResult.setExecuteDate(null);
      channelResult.setResponsible(this);
      channelResult.setTemplate(template.getName());
      channelResult.setTemplateId(template.getId());
      channelResult.setBalance(account.getBalance());
      channelResult.setCurrentDue(account.getCurrentDue());
      channelResult.setPastDue(account.getPastDue());
      channelResult.setStatus(ChannelResultStatus.INIT);
      channelResult.setChannelVendor(vendor);
      channelResult.setStartTime(startTime);
      channelResult.setEndTime(endTime);
      channelResult.setSource(source);

      ivrChannelResults.add(channelResult);
    } else {
      log.warn("Responsible# " + this.responsibleId + " is not contactable by phone.");
    } // end if

  } // end method addIvrChannelResult

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addLetterChannelResult.
   *
   * @param  batchId   Long
   * @param  ruleId    Long
   * @param  template  String
   * @param  vendor    LetterServiceVendor
   * @param  source    String
   */
  public void addLetterChannelResult(Long batchId, Long ruleId, String template, LetterServiceVendor vendor,
    String source) {
    // check whether this responsible has contactable address
    if (getIsContactableByAddress()) {
      Account account = this.getAccount();

      LetterChannelResult channelResult = new LetterChannelResult();
      channelResult.setRuleBatchId(batchId);
      channelResult.setRuleId(ruleId);
      channelResult.setAccount(account);
      channelResult.setStrategyDate(DateUtil.toDateOnly(new Date()));
      channelResult.setExportDate(null);
      channelResult.setExecuteDate(null);
      channelResult.setResponsible(this);
      channelResult.setTemplate(template);
      channelResult.setBalance(account.getBalance());
      channelResult.setCurrentDue(account.getCurrentDue());
      channelResult.setPastDue(account.getPastDue());
      channelResult.setStatus(ChannelResultStatus.INIT);
      channelResult.setVendor(vendor);
      channelResult.setSource(source);

      letterChannelResults.add(channelResult);
    } // end if
  }   // end method addLetterChannelResult

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addLetterChannelResult.
   *
   * @param  batchId   Long
   * @param  ruleId    Long
   * @param  template  PortfolioChannelTemplate
   * @param  vendor    ChannelVendor
   * @param  source    String
   */
  public void addLetterChannelResult(Long batchId, Long ruleId, PortfolioChannelTemplate template, ChannelVendor vendor,
    String source) {
    // check whether this responsible has contactable address
    if (getIsContactableByAddress()) {
      Account account = this.getAccount();

      LetterChannelResult channelResult = new LetterChannelResult();
      channelResult.setRuleBatchId(batchId);
      channelResult.setRuleId(ruleId);
      channelResult.setAccount(account);
      channelResult.setStrategyDate(DateUtil.toDateOnly(new Date()));
      channelResult.setExportDate(null);
      channelResult.setExecuteDate(null);
      channelResult.setResponsible(this);
      channelResult.setTemplate(template.getName());
      channelResult.setTemplateId(template.getId());
      channelResult.setBalance(account.getBalance());
      channelResult.setCurrentDue(account.getCurrentDue());
      channelResult.setPastDue(account.getPastDue());
      channelResult.setStatus(ChannelResultStatus.INIT);
      channelResult.setChannelVendor(vendor);
      channelResult.setSource(source);


      letterChannelResults.add(channelResult);
    } // end if
  }   // end method addLetterChannelResult

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addLoan.
   *
   * @param   loan  Loan
   *
   * @return  boolean
   */
  public boolean addLoan(Loan loan) {
    loan.setResponsible(this);

    return getLoans().add(loan);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addLoginFailureCount.
   */
  public void addLoginFailureCount() {
    if (this.loginFailureCount == null) {
      this.loginFailureCount = 1;
    } else {
      this.loginFailureCount++;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNegotiateConfirmationLetter.
   *
   * @param  letter  NegotiateConfirmationLetter
   */
  public void addNegotiateConfirmationLetter(NegotiateConfirmationLetter letter) {
    letter.setAccount(this.getAccount());
    letter.setResponsible(this);

    confirmLetters.add(letter);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNewPortfolioSurveyAnswers.
   *
   * @param  portfolioSurveyAnswers  Set
   */
  public void addNewPortfolioSurveyAnswers(Set<PortfolioSurveyAnswer> portfolioSurveyAnswers) {
    surveyRound++;

    for (PortfolioSurveyAnswer answer : portfolioSurveyAnswers) {
      answer.setSurveyRound(surveyRound);
      this.portfolioSurveyAnswers.add(answer);
      this.addTempAnswer(answer.getQuestion().getQuestionCode(), answer);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNewPortfolioSurveyAnswerUserSavedValues.
   *
   * @param  portfolioSurveyAnswerUserSavedValues  Set
   */
  public void addNewPortfolioSurveyAnswerUserSavedValues(
    Set<PortfolioSurveyAnswerUserSavedValue> portfolioSurveyAnswerUserSavedValues) {
    surveyRound++;

    for (PortfolioSurveyAnswerUserSavedValue savedValue : portfolioSurveyAnswerUserSavedValues) {
      savedValue.setSurveyRound(surveyRound);
      this.portfolioSurveyAnswerUserSavedValues.add(savedValue);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addOrUpdateFundingAccount.
   *
   * @param   fundingAccount  FundingAccount
   *
   * @return  boolean
   */
  public boolean addOrUpdateFundingAccount(FundingAccount fundingAccount) {
    if (fundingAccount == null) {
      return false;
    }

    if (!fundingAccount.ensureNickName(this.getAccount().getPortfolio().getPortfolioId())) {
      return false; // no funding account number so no nickname
    }

    fundingAccount.setResponsible(this);

    if (fundingAccount.getFundingAccountId() == null) {
      // must be new
      return getFundingAccounts().add(fundingAccount);
    } else {
      for (FundingAccount f : getFundingAccounts()) {
        if (fundingAccount.getFundingAccountId().equals(
                f.getFundingAccountId())) {
          // Found existing account
          if (!f.equals(fundingAccount)) {
            f.deepCopy(fundingAccount);
            f.setLastUpdateDate(new Date());
          }

          return false;
        }
      }

      // Can not find it in funing account collection - add new funding
      // account
      getFundingAccounts().add(fundingAccount);

      return true;
    } // end if-else
  }   // end method addOrUpdateFundingAccount

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addPayment.
   *
   * @param  payment  Payment
   */
  public void addPayment(Payment payment) {
    payment.setResponsible(this);

    Account account = getAccount();
    payment.setAccount(account);
    payment.setAccountBalance(account.getBalance());
    payment.setAccountChargeOffAmount(account.getChargeOffAmount());

    if (Boolean.TRUE.equals(account.getTestAccount())) {
      payment.setTestPayment(Boolean.TRUE);
    } else {
      payment.setTestPayment(Boolean.FALSE);
    }

    getPayments().add(payment);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addPhone.
   *
   * @param  phone  ContactPhone
   */
  public void addPhone(ContactPhone phone) {
    getPhones().put(phone.getPhoneType().getTypeId().toString(), phone);
    phone.setResponsible(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addPromise.
   *
   * @param   promise  PromiseToPay
   *
   * @return  boolean
   */
  public boolean addPromise(PromiseToPay promise) {
    if (promise == null) {
      return false;
    }

    promise.setResponsible(this);
    promise.setAccount(account);

    return promises.add(promise);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addResponsibleConfig.
   *
   * @param  responsibleConfig  ResponsibleConfig
   */
  public void addResponsibleConfig(ResponsibleConfig responsibleConfig) {
    responsibleConfig.setResponsible(this);
    setResponsibleConfig(responsibleConfig);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addResponsibleDetail.
   *
   * @param  responsibleDetail  ResponsibleDetail
   */
  public void addResponsibleDetail(ResponsibleDetail responsibleDetail) {
    responsibleDetail.setResponsible(this);
    setResponsibleDetail(responsibleDetail);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addResponsibleIndex.
   *
   * @param  responsibleIndex  ResponsibleIndex
   */
  public void addResponsibleIndex(ResponsibleIndex responsibleIndex) {
    responsibleIndex.setResponsible(this);
    setResponsibleIndex(responsibleIndex);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addResponsiblePageVisit.
   *
   * @param  responsiblePageVisit  ResponsiblePageVisit
   */
  public void addResponsiblePageVisit(ResponsiblePageVisit responsiblePageVisit) {
    responsiblePageVisit.setResponsible(this);
    setResponsiblePageVisit(responsiblePageVisit);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addResponsibleScore.
   *
   * @param   responsibleScore  ResponsibleScore
   *
   * @return  boolean
   */
  public boolean addResponsibleScore(ResponsibleScore responsibleScore) {
    return this.responsibleScores.add(responsibleScore);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addResponsibleScore.
   *
   * @param   scoreValue   Integer
   * @param   scoreDate    Date
   * @param   scoreType    ScoreTypeEnum
   * @param   scoreSource  ScoreSource
   *
   * @return  boolean
   */
  public boolean addResponsibleScore(Integer scoreValue, Date scoreDate, ScoreTypeEnum scoreType,
    ScoreSource scoreSource) {
    if ((scoreValue == null) || (scoreType == null)) {
      return false;
    }

    ResponsibleScore rScore = new ResponsibleScore();
    rScore.setResponsible(this);
    rScore.setScoreDate(scoreDate);
    rScore.setScoreValue(scoreValue);
    rScore.setScoreSource(scoreSource);

    ScoreType type = new ScoreType();
    type.setScoreTypeId(scoreType.getScoreTypeId());
    type.setScoreName(scoreType.toString());
    rScore.setScoreType(type);

    return this.responsibleScores.add(rScore);
  } // end method addResponsibleScore

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addSmsChannelResult.
   *
   * @param  batchId    Long
   * @param  ruleId     Long
   * @param  template   String
   * @param  vendor     SmsServiceVendor
   * @param  startTime  String
   * @param  endTime    String
   * @param  source     String
   */
  public void addSmsChannelResult(Long batchId, Long ruleId, String template, SmsServiceVendor vendor, String startTime,
    String endTime, String source) {
    // check whether this responsible has contactable address
    if (getIsContactableByPhone()) {
      Account account = this.getAccount();

      // allow this channel result, generate
      SmsChannelResult channelResult = new SmsChannelResult();
      channelResult.setRuleBatchId(batchId);
      channelResult.setRuleId(ruleId);
      channelResult.setAccount(account);
      channelResult.setStrategyDate(DateUtil.toDateOnly(new Date()));
      channelResult.setExportDate(null);
      channelResult.setExecuteDate(null);
      channelResult.setResponsible(this);
      channelResult.setTemplate(template);
      channelResult.setBalance(account.getBalance());
      channelResult.setCurrentDue(account.getCurrentDue());
      channelResult.setPastDue(account.getPastDue());
      channelResult.setStatus(ChannelResultStatus.INIT);
      channelResult.setVendor(vendor);
      channelResult.setStartTime(startTime);
      channelResult.setEndTime(endTime);
      channelResult.setSource(source);

      smsChannelResults.add(channelResult);
    }
  } // end method addSmsChannelResult

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addSmsChannelResult.
   *
   * @param  batchId    Long
   * @param  ruleId     Long
   * @param  template   PortfolioChannelTemplate
   * @param  vendor     ChannelVendor
   * @param  startTime  String
   * @param  endTime    String
   * @param  source     String
   */
  public void addSmsChannelResult(Long batchId, Long ruleId, PortfolioChannelTemplate template, ChannelVendor vendor,
    String startTime, String endTime, String source) {
    if (getIsContactableByPhone()) {
      // check whether this responsible has contactable address
      Account account = this.getAccount();

      // allow this channel result, generate
      SmsChannelResult channelResult = new SmsChannelResult();
      channelResult.setRuleBatchId(batchId);
      channelResult.setRuleId(ruleId);
      channelResult.setAccount(account);
      channelResult.setStrategyDate(DateUtil.toDateOnly(new Date()));
      channelResult.setExportDate(null);
      channelResult.setExecuteDate(null);
      channelResult.setResponsible(this);
      channelResult.setTemplateId(template.getId());
      channelResult.setTemplate(template.getName());
      channelResult.setBalance(account.getBalance());
      channelResult.setCurrentDue(account.getCurrentDue());
      channelResult.setPastDue(account.getPastDue());
      channelResult.setStatus(ChannelResultStatus.INIT);
      channelResult.setChannelVendor(vendor);
      channelResult.setStartTime(startTime);
      channelResult.setEndTime(endTime);
      channelResult.setSource(source);

      smsChannelResults.add(channelResult);
    } // end if
  }   // end method addSmsChannelResult

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addTempAnswer.
   *
   * @param  questionCode  String
   * @param  answer        PortfolioSurveyAnswer
   */
  public void addTempAnswer(String questionCode, PortfolioSurveyAnswer answer) {
    this.tempAnswers.put(questionCode, answer);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addTsysAttorney.
   *
   * @param  tsysAttorney  TsysAttorney
   */
  public void addTsysAttorney(TsysAttorney tsysAttorney) {
    tsysAttorney.setResponsible(this);
    this.tsysAttorneys.add(tsysAttorney);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addTsysBankruptcy.
   *
   * @param   tsysBankruptcy  TsysBankruptcy
   *
   * @return  boolean
   */
  public boolean addTsysBankruptcy(TsysBankruptcy tsysBankruptcy) {
    if (tsysBankruptcies == null) {
      return false;
    }

    tsysBankruptcy.setResponsible(this);

    return this.tsysBankruptcies.add(tsysBankruptcy);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addTsysJudgement.
   *
   * @param   tsysJudgement  TsysJudgement
   *
   * @return  boolean
   */
  public boolean addTsysJudgement(TsysJudgement tsysJudgement) {
    if (tsysJudgements == null) {
      return false;
    }

    tsysJudgement.setResponsible(this);

    return this.tsysJudgements.add(tsysJudgement);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addWebActivity.
   *
   * @param   webActivity  WebActivity
   *
   * @return  boolean
   */
  public boolean addWebActivity(WebActivity webActivity) {
    if (webActivity == null) {
      return false;
    }

    if (!this.webActivities.contains(webActivity)) {
      webActivity.setResponsible(this);
      this.webActivities.add(webActivity);

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * allowChannel.
   *
   * @param   name  String
   *
   * @return  boolean
   */
  public boolean allowChannel(String name) {
    for (PortfolioChannelType portfolioChannelType : account.getPortfolio().getAllowedChannelTypes()) {
      ChannelType channelType = portfolioChannelType.getChannelType();

      if ((channelType.getName().equalsIgnoreCase(name))) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * checkClassAndFdrLoans.
   *
   * @return  boolean
   */
  public boolean checkClassAndFdrLoans() {
    boolean    classLoan = false;
    boolean    fdrLoan   = false;
    List<Loan> aLoans    = this.getActiveLoans();

    for (Loan l : aLoans) {
      if (StringUtils.hasText(l.getServicingSystemIndicator())
            && l.getServicingSystemIndicator().equalsIgnoreCase("C")) {
        classLoan = true;
      } else if (StringUtils.hasText(l.getServicingSystemIndicator())
            && l.getServicingSystemIndicator().equalsIgnoreCase("F")) {
        fdrLoan = true;
      }
    }

    if ((classLoan && fdrLoan)) {
      return true;
    } else {
      return false;
    }
  } // end method checkClassAndFdrLoans

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * convertToContactPhone.
   *
   * @param   phoneNum       String
   * @param   channel        ContactChannel
   * @param   contactSource  ContactSource
   * @param   contactStatus  ContactStatus
   *
   * @return  ContactPhone
   */
  public ContactPhone convertToContactPhone(String phoneNum, ContactChannel channel, ContactSource contactSource,
    ContactStatus contactStatus) {
    phoneNum = phoneNum.replaceAll("[^0-9]", "");

    if (StringUtils.hasText(phoneNum)) {
      ContactPhone phone = new ContactPhone();
      phone.setPhoneType(new PhoneType(channel.getTypeId(),
          channel.toString()));
      phone.setPhoneNum(phoneNum);
      phone.setSource(contactSource);
      phone.setStatus(contactStatus);

      return phone;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createResponsibleIndex.
   *
   * @return  ResponsibleIndex
   */
  public ResponsibleIndex createResponsibleIndex() {
    ResponsibleIndex responsibleIndex = new ResponsibleIndex();
    responsibleIndex.setResponsible(this);
    responsibleIndex.setResponsibleUniqueId(this.getResponsibleId().toString());
    responsibleIndex.setSsnHash((this.getSsn() != null) ? this.getSsn() : this.getResponsibleId().toString());
    this.setResponsibleIndex(responsibleIndex);

    return responsibleIndex;
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

    final Responsible other = (Responsible) obj;

    if (dateOfBirth == null) {
      if (other.getDateOfBirth() != null) {
        return false;
      }
    } else if (!dateOfBirth.equals(other.getDateOfBirth())) {
      return false;
    }

    if (firstName == null) {
      if (other.getFirstName() != null) {
        return false;
      }
    } else if (!firstName.equals(other.getFirstName())) {
      return false;
    }

    if (gender == null) {
      if (other.getGender() != null) {
        return false;
      }
    } else if (!gender.equals(other.getGender())) {
      return false;
    }

    if (lastName == null) {
      if (other.getLastName() != null) {
        return false;
      }
    } else if (!lastName.equals(other.getLastName())) {
      return false;
    }

    if (ssn == null) {
      if (other.getSsn() != null) {
        return false;
      }
    } else if (!ssn.equals(other.getSsn())) {
      return false;
    }

    if (userLogon == null) {
      if (other.getUserLogon() != null) {
        return false;
      }
    } else if (!userLogon.equals(other.getUserLogon())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Have done any survey before?
   *
   * @return  have done any survey before?
   */
  public boolean fillPortfolioSurvey() {
    if (portfolioSurveyAnswers.size() > 0) {
      return true;
    } else {
      return false;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the last portfolio survey answer date.
   *
   * @return  get the last portfolio survey answer date
   */
  public Date fillPortfolioSurveyDate() {
    if (portfolioSurveyAnswers.size() > 0) {
      PortfolioSurveyAnswer portfolioSurveyAnswer = (PortfolioSurveyAnswer) portfolioSurveyAnswers.toArray()[0];

      return portfolioSurveyAnswer.getCreateDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Have done any survey before?
   *
   * @return  have done any survey before?
   */
  public boolean fillSurvey() {
    if (surveyAnswers.size() > 0) {
      return true;
    } else {
      return false;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the last survey answer date.
   *
   * @return  get the last survey answer date
   */
  public Date fillSurveyDate() {
    if (surveyAnswers.size() > 0) {
      SurveyAnswer surveyAnswer = (SurveyAnswer) surveyAnswers.toArray()[0];

      return surveyAnswer.getCreateDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accepted payment programs.
   *
   * @return  Set
   */
  public Set<PaymentProgram> getAcceptedPaymentPrograms() {
    return acceptedPaymentPrograms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accepted payment programs status.
   *
   * @param   searchDate  Date
   *
   * @return  Boolean
   */
  public Boolean getAcceptedPaymentProgramsStatus(Date searchDate) {
    if (null != acceptedPaymentPrograms) {
      for (PaymentProgram paymentProgram : acceptedPaymentPrograms) {
        if (DateUtil.toDateOnly(paymentProgram.getLastUpdateDate()).compareTo(searchDate) == 0) {
          Set<PaymentProgramInstallment> installments = paymentProgram.getInstallments();

          if ((installments != null) & (installments.size() > 0)) {
            for (PaymentProgramInstallment installment : installments) {
              if ("BankAccount".equalsIgnoreCase(installment.getPayment().getFundingInformation().getType())
                    && !PaymentStatus.REJECTED.equals(installment.getPayment().getPaymentStatus())
                    && !PaymentStatus.DELETED.equals(installment.getPayment().getPaymentStatus())) {
                return Boolean.TRUE;
              }
            }
          }
        }
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   tableStyle      String
   * @param   tableDataStyle  String
   * @param   searchDate      Date
   *
   * @return  DOCUMENT ME!
   */
  public String getAcceptedPaymentProgramTable(String tableStyle, String tableDataStyle, Date searchDate) {
    StringBuffer settlementStr = new StringBuffer("");

    if (acceptedPaymentPrograms != null) {
      PaymentProgram latestAcceptedPaymentProgram = acceptedPaymentPrograms.iterator().next();

      Set<PaymentProgramInstallment> installments = latestAcceptedPaymentProgram.getInstallments();

      if ((installments != null) & (installments.size() > 0)) {
        settlementStr.append(getPaymentHeading(tableStyle, tableDataStyle));

        for (PaymentProgramInstallment installment : installments) {
          if ("BankAccount".equalsIgnoreCase(installment.getPayment().getFundingInformation().getType())
                && (DateUtil.toDateOnly(installment.getCreateDate()).compareTo(searchDate) == 0)
                && !PaymentStatus.REJECTED.equals(installment.getPayment().getPaymentStatus())
                && !PaymentStatus.DELETED.equals(installment.getPayment().getPaymentStatus())) {
            settlementStr.append("<tr>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(installment.getPayment().getFundingInformation().getNickName());
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(installment.getPayment().getFundingInformation().getHolderFullName());
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(installment.getPayment().getFundingInformation().getRoutingNumber());
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(FormatUtil.maskAccountNumber(
                installment.getPayment().getFundingInformation().getFundingAccountNum(), 3));
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(FormatUtil.currencyFormat(installment.getPayment().getAmount()));
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(new SimpleDateFormat("dd/MM/yyyy").format(installment.getPayment().getPaymentDate()));
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("</tr>");
          } // end if
        }   // end for

        settlementStr.append("</tbody>");
        settlementStr.append("</table>");
      } else {
        return null;
      } // end if-else
    } else {
      return null;
    }   // end if-else

    return settlementStr.toString();
  } // end method getAcceptedPaymentProgramTable

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the account relate to this card holder.
   *
   * @return  the account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active loans.
   *
   * @return  List
   */
  public List<Loan> getActiveLoans() {
    List<Loan> activeLoans = new ArrayList<Loan>();

    for (Loan loan : getLoans()) {
      if (loan.getActive()) {
        activeLoans.add(loan);
      }
    }

    return activeLoans;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active payments between today and plus days.
   *
   * @param   plusDays  int
   *
   * @return  Set
   */
  public Set<Payment> getActivePaymentsBetweenTodayAndPlusDays(int plusDays) {
    Set<Payment> activePayments = new LinkedHashSet<Payment>();

    for (Payment payment : payments) {
      if ((PaymentStatus.SCHEDULED.equals(payment.getPaymentStatus())
              || PaymentStatus.INPROCESS.equals(payment.getPaymentStatus()))
            && DateUtil.isBetweenTodayAndPlusDays(plusDays, payment.getPaymentDate())) {
        activePayments.add(payment);
      }
    }

    return activePayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return address by type. The type is StringTypeId:
   *
   * <p>getAddress(ContactChannel.HOMEADDRESS.getStringTypeId())</p>
   *
   * @param   type  DOCUMENT ME!
   *
   * @return  return address by type.
   */
  public ContactAddress getAddress(String type) {
    return addresses.get(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address.
   *
   * @param   channel  ContactChannel
   *
   * @return  ContactAddress
   */
  public ContactAddress getAddress(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.ADDRESS.equals(channel.getChannelType())) {
      return addresses.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address by type.
   *
   * @param   addressType  AddressType
   *
   * @return  ContactAddress
   */
  public ContactAddress getAddressByType(AddressType addressType) {
    return getAddresses().get(addressType.getTypeId().toString());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for addresses.
   *
   * @return  Map
   */
  public Map<String, ContactAddress> getAddresses() {
    return addresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get age for the responsible.
   *
   * @return  get age for the responsible
   */
  public Integer getAge() {
    Calendar calendar = Calendar.getInstance();
    int      year     = calendar.get(Calendar.YEAR);
    int      month    = calendar.get(Calendar.MONTH);
    int      date     = calendar.get(Calendar.DATE);

    if (dateOfBirth != null) {
      calendar.setTime(dateOfBirth);

      Integer age = year - calendar.get(Calendar.YEAR);

      // adjust based on month and date
      if (month == calendar.get(Calendar.MONTH)) {
        // need to compare the date
        if (date < calendar.get(Calendar.DATE)) {
          age--;
        }
      } else if (month < calendar.get(Calendar.MONTH)) {
        age--;
      }

      return age;
    } else {
      return null;
    }
  } // end method getAge

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
   * Get all bank accounts of the responsible.
   *
   * @return  get all bank accounts of the responsible
   */
  public List<FundingAccount> getAllBankAccounts() {
    ArrayList<FundingAccount> bankList = new ArrayList<FundingAccount>();

    for (FundingAccount fundingAccount : fundingAccounts) {
      String type = fundingAccount.getFundingInformation().getType();

      if (FundingAccountType.BANKACCOUNT.toString().equalsIgnoreCase(
              type)) {
        bankList.add(fundingAccount);
      }
    }

    return bankList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all credit/debit card accounts of the responsible.
   *
   * @return  get all credit/debit card accounts of the responsible
   */
  public List<FundingAccount> getAllCardAccounts() {
    ArrayList<FundingAccount> cardList = new ArrayList<FundingAccount>();

    for (FundingAccount fundingAccount : fundingAccounts) {
      String type = fundingAccount.getFundingInformation().getType();

      if (FundingAccountType.CREDITCARD.toString().equalsIgnoreCase(
              type)
            || FundingAccountType.DEBITCARD.toString().equalsIgnoreCase(
              type)) {
        cardList.add(fundingAccount);
      }
    }

    return cardList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all city.
   *
   * @return  Set
   */
  public Set<String> getAllCity() {
    Set<String> cities = new LinkedHashSet<String>();
    cities.addAll(getCity());
    cities.addAll(getTemporaryCity());
    cities.addAll(getFuturePermanentCity());

    return cities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all credit cards belong to this responsible.
   *
   * @return  get all credit cards belong to this responsible
   */
  public List<FundingAccount> getAllCreditCards() {
    ArrayList<FundingAccount> cardList = new ArrayList<FundingAccount>();

    for (FundingAccount fundingAccount : fundingAccounts) {
      String type = fundingAccount.getFundingInformation().getType();

      if (FundingAccountType.CREDITCARD.toString().equalsIgnoreCase(
              type)) {
        cardList.add(fundingAccount);
      }
    }

    return cardList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all current address zip code.
   *
   * @return  Set
   */
  public Set<String> getAllCurrentAddressZipCode() {
    Set<String> zipCodes = new LinkedHashSet<String>();

    if ((addresses != null) && (addresses.size() > 0)) {
      for (Map.Entry<String, ContactAddress> address : addresses.entrySet()) {
        if ((address.getValue() != null) && (address.getValue().getAddress() != null)
              && StringUtils.hasText(address.getValue().getAddress().getPostalCode())) {
          zipCodes.add(address.getValue().getAddress().getPostalCode());
        }
      }
    }

    if ((temporaryAddresses != null) && (temporaryAddresses.size() > 0)) {
      for (Map.Entry<String, TemporaryContactAddress> address : temporaryAddresses.entrySet()) {
        if ((address.getValue() != null) && (address.getValue().getAddress() != null)
              && StringUtils.hasText(address.getValue().getAddress().getPostalCode())) {
          zipCodes.add(address.getValue().getAddress().getPostalCode());
        }
      }
    }

    if ((futurePermanentAddresses != null) && (futurePermanentAddresses.size() > 0)) {
      for (Map.Entry<String, FuturePermanentContactAddress> address : futurePermanentAddresses.entrySet()) {
        if ((address.getValue() != null) && (address.getValue().getAddress() != null)
              && StringUtils.hasText(address.getValue().getAddress().getPostalCode())) {
          zipCodes.add(address.getValue().getAddress().getPostalCode());
        }
      }
    }

    return zipCodes;
  } // end method getAllCurrentAddressZipCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all current contact phone area code.
   *
   * @param   startIndex  int
   * @param   endIndex    int
   *
   * @return  Set
   */
  public Set<String> getAllCurrentContactPhoneAreaCode(int startIndex, int endIndex) {
    Set<String> areaCodes = new LinkedHashSet<String>();

    if ((phones != null) && (phones.size() > 0)) {
      for (Map.Entry<String, ContactPhone> phone : phones.entrySet()) {
        if ((phone.getValue() != null)
              && StringUtils.hasText(phone.getValue().getAreaCode(startIndex, endIndex))) {
          areaCodes.add(phone.getValue().getAreaCode(startIndex, endIndex));
        }
      }
    }

    if ((temporaryPhones != null) && (temporaryPhones.size() > 0)) {
      for (Map.Entry<String, TemporaryContactPhone> phone : temporaryPhones.entrySet()) {
        if ((phone.getValue() != null)
              && StringUtils.hasText(phone.getValue().getAreaCode(startIndex, endIndex))) {
          areaCodes.add(phone.getValue().getAreaCode(startIndex, endIndex));
        }
      }
    }

    if ((futurePermanentPhones != null) && (futurePermanentPhones.size() > 0)) {
      for (Map.Entry<String, FuturePermanentContactPhone> phone : futurePermanentPhones.entrySet()) {
        if ((phone.getValue() != null)
              && StringUtils.hasText(phone.getValue().getAreaCode(startIndex, endIndex))) {
          areaCodes.add(phone.getValue().getAreaCode(startIndex, endIndex));
        }
      }
    }

    return areaCodes;
  } // end method getAllCurrentContactPhoneAreaCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all debit cards belong to this responsible.
   *
   * @return  get all debit cards belong to this responsible
   */
  public List<FundingAccount> getAllDebitCards() {
    ArrayList<FundingAccount> cardList = new ArrayList<FundingAccount>();

    for (FundingAccount fundingAccount : fundingAccounts) {
      String type = fundingAccount.getFundingInformation().getType();

      if (FundingAccountType.DEBITCARD.toString().equalsIgnoreCase(
              type)) {
        cardList.add(fundingAccount);
      }
    }

    return cardList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all latest portfolio survey answers.
   *
   * @return  Set
   */
  public Set<PortfolioSurveyAnswer> getAllLatestPortfolioSurveyAnswers() {
    Set<PortfolioSurveyAnswer> lastAnswers = new LinkedHashSet<PortfolioSurveyAnswer>();

    int r = -1;

    for (PortfolioSurveyAnswer answer : portfolioSurveyAnswers) {
      if (answer.getSurveyRound() < r) {
        break;
      } else if (answer.getSurveyRound() > r) {
        r = answer.getSurveyRound();
      }

      lastAnswers.add(answer);
    }

    return lastAnswers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all phone num.
   *
   * @return  Set
   */
  public Set<String> getAllPhoneNum() {
    Set<String> allPhoneNums = new LinkedHashSet<String>();

    for (ContactPhone p : phones.values()) {
      if (StringUtils.hasText(p.getPhoneNum())) {
        allPhoneNums.add(p.getPhoneNum());
      }
    }

    for (TemporaryContactPhone p : temporaryPhones.values()) {
      if (StringUtils.hasText(p.getPhoneNum())) {
        allPhoneNums.add(p.getPhoneNum());
      }
    }

    for (FuturePermanentContactPhone p : futurePermanentPhones.values()) {
      if (StringUtils.hasText(p.getPhoneNum())) {
        allPhoneNums.add(p.getPhoneNum());
      }
    }

    return allPhoneNums;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all phone num.
   *
   * @param   typeId  String
   *
   * @return  Set
   */
  public Set<String> getAllPhoneNum(String typeId) {
    Set<String> allPhoneNums = new LinkedHashSet<String>();

    if (getPhoneNum(typeId) != null) {
      allPhoneNums.add(getPhoneNum(typeId));
    }

    if (getTemporaryPhoneNum(typeId) != null) {
      allPhoneNums.add(getTemporaryPhoneNum(typeId));
    }

    if (getFuturePermanentPhoneNum(typeId) != null) {
      allPhoneNums.add(getFuturePermanentPhoneNum(typeId));
    }

    return allPhoneNums;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get responsible all phone numbers.
   *
   * @return  get responsible all phone numbers
   */
  public String getAllPhoneNumbers() {
    String phoneString = "";

    // get all zip codes and kill the duplications
    Set<String> phoneNumbers = new LinkedHashSet<String>();

    for (ContactPhone phone : phones.values()) {
      phoneNumbers.add(phone.getPhoneNum());
    }

    // compile the list to one string
    for (String string : phoneNumbers) {
      if (!phoneString.isEmpty()) {
        // skip the first one
        phoneString += ", ";
      }

      phoneString += string;
    }

    return phoneString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all province.
   *
   * @return  Set
   */
  public Set<String> getAllProvince() {
    Set<String> provinces = new LinkedHashSet<String>();
    provinces.addAll(getProvince());
    provinces.addAll(getTemporaryProvince());
    provinces.addAll(getFuturePermanentProvince());

    return provinces;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get responsible all address zip codes.
   *
   * @return  get responsible all address zip codes
   */
  public String getAllZipCodes() {
    String zipString = "";

    // get all zip codes and kill the duplications
    Set<String> zips = new LinkedHashSet<String>();

    for (ContactAddress address : addresses.values()) {
      zips.add(address.getAddress().getPostalCode());
    }

    // compile the list to one string
    for (String string : zips) {
      if (!zipString.isEmpty()) {
        // skip the first one
        zipString += ", ";
      }

      zipString += string;
    }

    return zipString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for appointment.
   *
   * @param   appointmentId  Long
   *
   * @return  AdvisorAppointment
   */
  public AdvisorAppointment getAppointment(Long appointmentId) {
    for (AdvisorAppointment advisorAppointment : appointments) {
      if (advisorAppointment.getAppointmentId().equals(appointmentId)) {
        return advisorAppointment;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for appointment phone.
   *
   * @return  ContactPhone
   */
  public ContactPhone getAppointmentPhone() {
    return getPhone(ContactChannel.APPOINTMENTPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all advisor appointment relate to responsible.
   *
   * @return  the advisorAppointments
   */
  public Set<AdvisorAppointment> getAppointments() {
    return this.appointments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the assets for the card holder.
   *
   * @return  the assets
   */
  public BigDecimal getAssets() {
    return assets;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for attorney.
   *
   * @return  Attorney
   */
  public Attorney getAttorney() {
    return attorney;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for attorney.
   *
   * @param   attorneyType  String
   *
   * @return  TsysAttorney
   */
  public TsysAttorney getAttorney(String attorneyType) {
    if (tsysAttorneys.size() > 0) {
      log.info("get attorney.." + attorneyType);

      for (TsysAttorney tsysAttorney : tsysAttorneys) {
        if (attorneyType.equalsIgnoreCase(tsysAttorney.getType())) {
          log.info("found matching attorney type...");

          return tsysAttorney;
        }
      }
    } else {
      log.info("attorney size is zero...");
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bankruptcy.
   *
   * @return  Bankruptcy
   */
  public Bankruptcy getBankruptcy() {
    return bankruptcy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getBankruptInd() {
    return bankruptInd;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BBLReminder type.
   *
   * @return  ReminderType
   */
  public ReminderType getBBLReminderType() {
    String optInValue = this.getResponsibleDetail().getClientDefined5CharCode1();

    if ("Email".equalsIgnoreCase(optInValue)) {
      return ReminderType.EMAIL;
    } else if ("SMS".equalsIgnoreCase(optInValue)) {
      return ReminderType.SMS;
    } else {
      return ReminderType.NONE;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BBLResponsible reminder days.
   *
   * @return  Integer
   */
  public Integer getBBLResponsibleReminderDays() {
    return this.getResponsibleDetail().getClientDefinedInteger1();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BBLTriumph cardholder id.
   *
   * @return  String
   */
  public String getBBLTriumphCardholderId() {
    return this.getResponsibleDetail().getClientDefined25CharCode1();

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau score.
   *
   * @return  Integer
   */
  public Integer getBureauScore() {
    return this.bureauScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business phone.
   *
   * @return  ContactPhone
   */
  public ContactPhone getBusinessPhone() {
    return getPhone(ContactChannel.BUSINESSPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by email.
   *
   * @return  Boolean
   */
  public Boolean getByEmail() {
    return this.preferHomeEmail != null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by home phone.
   *
   * @return  Boolean
   */
  public Boolean getByHomePhone() {
    return this.preferHomePhone != null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by letter.
   *
   * @return  Boolean
   */
  public Boolean getByLetter() {
    return this.preferHomeAddress != null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by mobile phone.
   *
   * @return  Boolean
   */
  public Boolean getByMobilePhone() {
    return this.preferMobilePhone != null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by SMS.
   *
   * @return  Boolean
   */
  public Boolean getBySMS() {
    return this.preferTextMessage != null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by work phone.
   *
   * @return  Boolean
   */
  public Boolean getByWorkPhone() {
    return this.preferWorkPhone != null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for called in count.
   *
   * @return  Integer
   */
  public Integer getCalledInCount() {
    initCount();

    return ivrInboundCount + directCallCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel type id.
   *
   * @param   name  String
   *
   * @return  Long
   */
  public Long getChannelTypeId(String name) {
    for (PortfolioChannelType portfolioChannelType : account.getPortfolio().getAllowedChannelTypes()) {
      ChannelType channelType = portfolioChannelType.getChannelType();

      if ((channelType.getName().equalsIgnoreCase(name))) {
        return channelType.getChannelTypeId();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for citi hard ship in months.
   *
   * @return  Integer
   */
  public Integer getCitiHardShipInMonths() {
    HomeEquitySurvey survey = getCitiSurvey();

    if (survey != null) {
      return survey.getHardShip();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for citi HTI.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCitiHTI() {
    if ((homeEquityRefiSurveys == null)
          || (homeEquityRefiSurveys.size() == 0)) {
      return null;
    }

    if (account.getCurrentDue() == null) {
      return null;
    }

    Iterator<HomeEquityRefiSurvey> it     = homeEquityRefiSurveys.iterator();
    HomeEquityRefiSurvey           survey = it.next();

    if ((survey == null) || (survey.getTotalAnnualIncome() == null)
          || (survey.getTotalAnnualIncome().compareTo(BigDecimal.ZERO)
            <= 0)) {
      return null;
    }

    return account.getCurrentDue().divide((survey.getTotalAnnualIncome().divide(new BigDecimal("12.0"))));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for citi LTHard ship.
   *
   * @return  Boolean
   */
  public Boolean getCitiLTHardShip() {
    return getCitiHardShipType().equals(HardShip.LT);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for citi refi survey date.
   *
   * @return  Date
   */
  public Date getCitiRefiSurveyDate() {
    HomeEquityRefiSurvey survey = getCitiRefiSurvey();

    if (survey != null) {
      return DateUtil.toDateOnly(survey.getCreateDate());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for citi STHard ship.
   *
   * @return  Boolean
   */
  public Boolean getCitiSTHardShip() {
    return getCitiHardShipType().equals(HardShip.ST);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for citi survey date.
   *
   * @return  Date
   */
  public Date getCitiSurveyDate() {
    HomeEquitySurvey survey = getCitiSurvey();

    if (survey != null) {
      return DateUtil.toDateOnly(survey.getCreateDate());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for city.
   *
   * @return  Set
   */
  public Set<String> getCity() {
    Set<String> cities = new LinkedHashSet<String>();
    Address     addr   = null;

    for (ContactAddress a : addresses.values()) {
      addr = a.getAddress();

      if ((addr != null) && StringUtils.hasText(addr.getCity())) {
        cities.add(addr.getCity());
      }
    }

    return cities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method returns True or False based on the whether the customer has accepted ExpressConsent at Client end and
   * cmc receives in Placement File.
   *
   * @return  Boolean
   */
  public Boolean getClientConsent() {
    ResponsibleConfig c = this.getResponsibleConfig();

    if (((c != null) && (c.getClientConsentDate() != null))
          || ((account != null) && (account.getAccountConfig() != null)
            && (account.getAccountConfig().getClientConsentDate()
              != null))) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method returns Date when the customer has accepted ExpressConsent at Responsible Level CMC receives in
   * PlacementFile from Client.
   *
   * @return  Date
   */
  public Date getClientConsentDate() {
    ResponsibleConfig c = this.getResponsibleConfig();

    if ((c != null) && (c.getClientConsentDate() != null)) {
      return c.getClientConsentDate();
    } else if ((account != null) && (account.getAccountConfig() != null)
          && (account.getAccountConfig().getClientConsentDate() != null)) {
      return account.getAccountConfig().getClientConsentDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method returns True or False based on the whether the customer has accepted ExpressConsent at Responsible
   * Level in CMC Website.
   *
   * @return  Boolean
   */
  public Boolean getCmcConsent() {
    ResponsibleConfig c = this.getResponsibleConfig();

    if (((c != null) && (c.getCmcConsentDate() != null))
          || ((account != null) && (account.getAccountConfig() != null)
            && (account.getAccountConfig().getCmcConsentDate() != null))) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method returns Date when the customer has accepted ExpressConsent at Responsible Level in CMC Debtor Site.
   *
   * @return  Date
   */
  public Date getCmcConsentDate() {
    ResponsibleConfig c = this.getResponsibleConfig();

    if ((c != null) && (c.getCmcConsentDate() != null)) {
      return c.getCmcConsentDate();
    } else if ((account != null) && (account.getAccountConfig() != null)
          && (account.getAccountConfig().getCmcConsentDate() != null)) {
      return account.getAccountConfig().getCmcConsentDate();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for confirm letters.
   *
   * @return  Set
   */
  public Set<NegotiateConfirmationLetter> getConfirmLetters() {
    return this.confirmLetters;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for consent.
   *
   * @return  Boolean
   */
  public Boolean getConsent() {
    return getClientConsent() || getCmcConsent();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method returns Date when the customer has accepted ExpressConsent at Responsible Level in CMC Debtor Site.
   *
   * @return  Date
   */
  public Date getConsentDate() {
    Date d1 = getCmcConsentDate();
    Date d2 = getClientConsentDate();

    if ((d1 != null) && (d2 != null)) {
      return (d1.getTime() < d2.getTime()) ? d1 : d2;
    }

    if (d1 == null) {
      return d2;
    }

    if (d2 == null) {
      return d1;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable home phone number, return empty string if there is no such number or the phone is not contactable.
   *
   * @return  get contactable home phone number, return empty string if there is no such number or the phone is not
   *          contactable
   */
  public String getContactableHomePhoneStr() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    ContactPhone contactPhone = getHomePhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    } else {
      return contactPhone.getPhoneNum();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable mobile phone.
   *
   * @return  get contactable mobile phone
   */
  public ContactPhone getContactableMobilePhone() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    ContactPhone contactPhone = getMobilePhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return null;
    }

    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable mobile phone number, return empty string if there is no such number or the phone is not
   * contactable.
   *
   * @return  get contactable mobile phone number, return empty string if there is no such number or the phone is not
   *          contactable
   */
  public String getContactableMobilePhoneStr() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    ContactPhone contactPhone = getMobilePhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    } else {
      return contactPhone.getPhoneNum();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable other phone number, return empty string if there is no such number or the phone is not contactable.
   *
   * @return  get contactable other phone number, return empty string if there is no such number or the phone is not
   *          contactable
   */
  public String getContactableOtherPhoneStr() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    ContactPhone contactPhone = getOtherPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    } else {
      return contactPhone.getPhoneNum();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contactable reminder phone.
   *
   * @return  ContactPhone
   */
  public ContactPhone getContactableReminderPhone() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    ContactPhone contactPhone = getReminderPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return null;
    }

    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contactable reminder phone str.
   *
   * @return  String
   */
  public String getContactableReminderPhoneStr() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    ContactPhone contactPhone = getReminderPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    } else {
      return contactPhone.getPhoneNum();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable sms phone.
   *
   * @return  get contactable sms phone
   */
  public ContactPhone getContactableSmsPhone() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    ContactPhone contactPhone = getSMSPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return null;
    }

    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable sms phone number, return empty string if there is no such number or the phone is not contactable.
   *
   * @return  get contactable sms phone number, return empty string if there is no such number or the phone is not
   *          contactable
   */
  public String getContactableSmsPhoneStr() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    ContactPhone contactPhone = getSMSPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    }

    return contactPhone.getPhoneNum();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contactable text phone.
   *
   * @return  ContactPhone
   */
  public ContactPhone getContactableTextPhone() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    ContactPhone contactPhone = getSMSPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      contactPhone = getMobilePhone();
    }

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return null;
    }

    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contactable text phone str.
   *
   * @return  String
   */
  public String getContactableTextPhoneStr() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    ContactPhone contactPhone = getSMSPhone();

    if (contactPhone == null) {
      contactPhone = getMobilePhone();
    }

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    }

    return contactPhone.getPhoneNum();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get contactable work phone number, return empty string if there is no such number or the phone is not contactable.
   *
   * @return  get contactable work phone number, return empty string if there is no such number or the phone is not
   *          contactable
   */
  public String getContactableWorkPhoneStr() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return "";
    }

    ContactPhone contactPhone = getWorkPhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      return "";
    } else {
      return contactPhone.getPhoneNum();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get a set of Contact Phones based on phone num. This method returns all match for different phone types. The order
   * in the Set is guaranteed in the following order:
   *
   * <p>ContactChannel.HOMEPHONE, ContactChannel.HOMEPHONE2, ContactChannel.WORKPHONE, ContactChannel.MOBILEPHONE,
   * ContactChannel.SMSPHONE, ContactChannel.OTHERPHONE, ContactChannel.OTHERPHONE2, ContactChannel.OTHERPHONE3,
   * ContactChannel.OTHERPHONE4</p>
   *
   * @param   phoneNum  DOCUMENT ME!
   *
   * @return  get a set of Contact Phones based on phone num.
   */
  public Set<ContactPhone> getContactPhonesbyPhoneNum(String phoneNum) {
    if (!StringUtils.hasText(phoneNum)) {
      return null;
    }

    Set<ContactPhone> ps = new LinkedHashSet<ContactPhone>();

    for (int i = 0; i < ContactChannel.PHONE_CHANNELS.length; i++) {
      ContactPhone phone = getPhone(ContactChannel.PHONE_CHANNELS[i]);

      if ((phone != null)
            && phoneNum.equalsIgnoreCase(phone.getPhoneNum())) {
        ps.add(phone);
      }
    }

    if (ps.size() > 0) {
      return ps;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get custodial Account.
   *
   * @return  the custodialAccount
   */
  public Boolean getCustodialAccount() {
    return custodialAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    if (responsibleIndex != null) {
      return responsibleIndex.getCustomer();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The debtor type. Whether it is "I": Individual or "C": Corporate
   *
   * @return  the debtor type.
   */
  public CustomerType getCustomerType() {
    return customerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer type string.
   *
   * @return  String
   */
  public String getCustomerTypeString() {
    return (customerType != null) ? customerType.toString() : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the date of birth.
   *
   * @return  the dateOfBirth
   */
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the day of the month.
   *
   * @return  get the day of the month
   */
  public int getDateOfMonth() {
    Calendar cal = Calendar.getInstance();

    return cal.get(Calendar.DAY_OF_MONTH);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for debtor street.
   *
   * @return  String
   */
  public String getDebtorAddress() {
    ContactAddress contactAddress = getHomeAddress();

    if (null != contactAddress) {
      Address address = contactAddress.getAddress();

      if (null != address) {
        StringBuffer street = new StringBuffer();

        if (StringUtils.hasText(address.getAddress1())) {
          street.append(address.getAddress1()).append(",");
        }

        if (StringUtils.hasText(address.getAddress2())) {
          street.append(address.getAddress2()).append(",");
        }

        if (StringUtils.hasText(address.getAddress3())) {
          street.append(address.getAddress3()).append(",");
        }

        if (StringUtils.hasText(address.getAddress4())) {
          street.append(address.getAddress4()).append(",");
        }

        if (street.length() > 0) {
          street = street.deleteCharAt(street.length() - 1);
        }

        return street.toString();
      } // end if
    }   // end if

    return null;
  } // end method getDebtorAddress

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for debtor info.
   *
   * @return  String
   */
  public String getDebtorInfo() {
    ContactAddress contactAddress = getHomeAddress();

    if (null != contactAddress) {
      Address address = contactAddress.getAddress();

      if (null != address) {
        StringBuffer creditorInfo = new StringBuffer();

        if (StringUtils.hasText(address.getCity())) {
          creditorInfo.append(address.getCity()).append(",");
        }

        if (StringUtils.hasText(address.getProvince())) {
          creditorInfo.append(address.getProvince()).append(",");
        }

        if (StringUtils.hasText(address.getCountry())) {
          creditorInfo.append(address.getCountry()).append(",");
        }

        if (StringUtils.hasText(address.getPostalCode())) {
          creditorInfo.append(address.getPostalCode()).append(",");
        }

        if (creditorInfo.length() > 0) {
          creditorInfo = creditorInfo.deleteCharAt(creditorInfo.length() - 1);
        }

        return creditorInfo.toString();
      } // end if
    }   // end if

    return null;
  } // end method getDebtorInfo

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deceased date.
   *
   * @return  Date
   */
  public Date getDeceasedDate() {
    return deceasedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get default address.
   *
   * @return  get default address
   */
  public ContactAddress getDefaultAddress() {
    ContactAddress contactAddress = getHomeAddress();

    if (contactAddress == null) {
      // no home address, try work address
      contactAddress = getWorkAddress();

      if (contactAddress == null) {
        contactAddress = getOtherAddress();
      }
    }

    return contactAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default address address1.
   *
   * @return  String
   */
  public String getDefaultAddressAddress1() {
    ContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default address address2.
   *
   * @return  String
   */
  public String getDefaultAddressAddress2() {
    ContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress2();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default address city.
   *
   * @return  String
   */
  public String getDefaultAddressCity() {
    ContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getCity();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default address country.
   *
   * @return  String
   */
  public String getDefaultAddressCountry() {
    ContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getCountry();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default address postal code.
   *
   * @return  String
   */
  public String getDefaultAddressPostalCode() {
    ContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getPostalCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default address province.
   *
   * @return  String
   */
  public String getDefaultAddressProvince() {
    ContactAddress contactAddress = getDefaultAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getProvince();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get default contactable address.
   *
   * @return  get default contactable address
   */
  public ContactAddress getDefaultContactableAddress() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    ContactAddress contactAddress = getHomeAddress();

    if ((contactAddress == null) || (!contactAddress.isValidAddress())
          || Boolean.TRUE.equals(contactAddress.getDoNotContact())
          || Boolean.TRUE.equals(contactAddress.getWrongInfo())) {
      // no home address, try work address
      contactAddress = getWorkAddress();

      if ((contactAddress == null)
            || (!contactAddress.isValidAddress())
            || Boolean.TRUE.equals(contactAddress.getDoNotContact())
            || Boolean.TRUE.equals(contactAddress.getWrongInfo())) {
        contactAddress = getOtherAddress();

        if ((contactAddress == null)
              || (!contactAddress.isValidAddress())
              || Boolean.TRUE.equals(contactAddress.getDoNotContact())
              || Boolean.TRUE.equals(contactAddress.getWrongInfo())) {
          return null;
        }
      }
    }

    return contactAddress;
  } // end method getDefaultContactableAddress

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable address address1.
   *
   * @return  String
   */
  public String getDefaultContactableAddressAddress1() {
    ContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable address address2.
   *
   * @return  String
   */
  public String getDefaultContactableAddressAddress2() {
    ContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getAddress2();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable address city.
   *
   * @return  String
   */
  public String getDefaultContactableAddressCity() {
    ContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getCity();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable address country.
   *
   * @return  String
   */
  public String getDefaultContactableAddressCountry() {
    ContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getCountry();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable address postal code.
   *
   * @return  String
   */
  public String getDefaultContactableAddressPostalCode() {
    ContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getPostalCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable address province.
   *
   * @return  String
   */
  public String getDefaultContactableAddressProvince() {
    ContactAddress contactAddress = getDefaultContactableAddress();

    if (contactAddress != null) {
      return contactAddress.getAddress().getProvince();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable email.
   *
   * @return  ContactEmail
   */
  public ContactEmail getDefaultContactableEmail() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    ContactEmail contactEmail = getHomeEmail();

    if ((contactEmail == null)
          || Boolean.TRUE.equals(contactEmail.getDoNotContact())
          || Boolean.TRUE.equals(contactEmail.getWrongInfo())) {
      // no home address, try work address
      contactEmail = getWorkEmail();

      if ((contactEmail == null)
            || Boolean.TRUE.equals(contactEmail.getDoNotContact())
            || Boolean.TRUE.equals(contactEmail.getWrongInfo())) {
        contactEmail = getOtherEmail();

        if ((contactEmail == null)
              || Boolean.TRUE.equals(contactEmail.getDoNotContact())
              || Boolean.TRUE.equals(contactEmail.getWrongInfo())) {
          return null;
        }
      }
    }

    return contactEmail;
  } // end method getDefaultContactableEmail

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default contactable email str.
   *
   * @return  String
   */
  public String getDefaultContactableEmailStr() {
    ContactEmail contactEmail = getDefaultContactableEmail();

    if (contactEmail != null) {
      return contactEmail.getEmailAddress();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get default phone.
   *
   * @return  get default phone
   */
  public ContactPhone getDefaultContactablePhone() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return null;
    }

    ContactPhone contactPhone = getHomePhone();

    if ((contactPhone == null) || (!contactPhone.isValidNumber())
          || Boolean.TRUE.equals(contactPhone.getDoNotContact())
          || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
      // no home phone, try work phone
      contactPhone = getWorkPhone();

      if ((contactPhone == null) || (!contactPhone.isValidNumber())
            || Boolean.TRUE.equals(contactPhone.getDoNotContact())
            || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
        contactPhone = getMobilePhone();

        if ((contactPhone == null) || (!contactPhone.isValidNumber())
              || Boolean.TRUE.equals(contactPhone.getDoNotContact())
              || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
          contactPhone = getOtherPhone();

          if ((contactPhone == null)
                || (!contactPhone.isValidNumber())
                || Boolean.TRUE.equals(
                  contactPhone.getDoNotContact())
                || Boolean.TRUE.equals(contactPhone.getWrongInfo())) {
            return null;
          }
        }
      }
    } // end if

    return contactPhone;
  } // end method getDefaultContactablePhone

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get default email.
   *
   * @return  get default email
   */
  public ContactEmail getDefaultEmail() {
    ContactEmail contactEmail = getHomeEmail();

    if (contactEmail == null) {
      // no home address, try work address
      contactEmail = getWorkEmail();

      if (contactEmail == null) {
        contactEmail = getOtherEmail();
      }
    }

    return contactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default email str.
   *
   * @return  String
   */
  public String getDefaultEmailStr() {
    ContactEmail contactEmail = getDefaultEmail();

    if (contactEmail != null) {
      return contactEmail.getEmailAddress();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the default account, first account found.
   *
   * @return  get the default account, first account found
   */
  public FundingAccount getDefaultFundingAccount() {
    for (FundingAccount account : fundingAccounts) {
      if (account != null) {
        return account;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get default phone.
   *
   * @return  get default phone
   */
  public ContactPhone getDefaultPhone() {
    ContactPhone contactPhone = getHomePhone();

    if (contactPhone == null) {
      // no home address, try work address
      contactPhone = getWorkPhone();

      if (contactPhone == null) {
        contactPhone = getMobilePhone();

        if (contactPhone == null) {
          contactPhone = getOtherPhone();
        }
      }
    }

    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialer channel results.
   *
   * @return  Set
   */
  public Set<DialerChannelResult> getDialerChannelResults() {
    return dialerChannelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * How many times somebody has called in using direct-agent number to discuss this responsible. Could be someboday
   * other than debtor called in and complain that we have the wrong contact info.
   *
   * @return  how many times somebody has called in using direct-agent number to discuss this responsible.
   */
  public Integer getDirectCallCount() {
    return directCallCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document histories.
   *
   * @return  Set
   */
  public Set<DocumentHistory> getDocumentHistories() {
    return documentHistories;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for documents.
   *
   * @return  Set
   */
  public Set<Document> getDocuments() {
    return documents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document status.
   *
   * @param   documentType  String
   *
   * @return  String
   */
  public String getDocumentStatus(String documentType) {
    for (Document document : documents) {
      if (document.getDocumentType().getName().equalsIgnoreCase(documentType)) {
        return document.getDocumentStatus().getName();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document status date.
   *
   * @param   documentType  String
   *
   * @return  Date
   */
  public Date getDocumentStatusDate(String documentType) {
    for (Document document : documents) {
      if (document.getDocumentType().getName().equalsIgnoreCase(documentType)) {
        return document.getStatusDate();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email.
   *
   * @param   type  String
   *
   * @return  ContactEmail
   */
  public ContactEmail getEmail(String type) {
    return emails.get(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email.
   *
   * @param   channel  ContactChannel
   *
   * @return  ContactEmail
   */
  public ContactEmail getEmail(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.EMAIL.equals(channel.getChannelType())) {
      return emails.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   typeId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEmailAddress(String typeId) {
    ContactEmail email = getEmail(typeId);

    if ((email != null) && StringUtils.hasText(email.getEmailAddress())) {
      return email.getEmailAddress();
    }

    return null;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email by type.
   *
   * @param   type  EmailType
   *
   * @return  ContactEmail
   */
  public ContactEmail getEmailByType(EmailType type) {
    return getEmails().get(type.getTypeId().toString());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email channel results.
   *
   * @return  Set
   */
  public Set<EmailChannelResult> getEmailChannelResults() {
    return emailChannelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email opt out by type.
   *
   * @param   type  String
   *
   * @return  Boolean
   */
  public Boolean getEmailOptOutByType(String type) {
    ContactEmail contactEmail = emails.get(type);

    if (contactEmail != null) {
      return contactEmail.getOptOut();
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for emails.
   *
   * @return  Map
   */
  public Map<String, ContactEmail> getEmails() {
    return emails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer address.
   *
   * @return  String
   */
  public String getEmployerAddress() {
    return employerAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer name.
   *
   * @return  String
   */
  public String getEmployerName() {
    return employerName;
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
   * Get the first phone matching given phone number. The matching order is ContactChannel.HOMEPHONE,
   * ContactChannel.HOMEPHONE2, ContactChannel.WORKPHONE, ContactChannel.MOBILEPHONE, ContactChannel.SMSPHONE,
   * ContactChannel.OTHERPHONE, ContactChannel.OTHERPHONE2, ContactChannel.OTHERPHONE3, ContactChannel.OTHERPHONE4
   *
   * @param   phoneNum  DOCUMENT ME!
   *
   * @return  get the first phone matching given phone number.
   */
  public ContactPhone getFirstContactPhoneByPhoneNum(String phoneNum) {
    if (!StringUtils.hasText(phoneNum)) {
      return null;
    }

    ContactPhone phone = null;

    for (int i = 0; i < ContactChannel.PHONE_CHANNELS.length; i++) {
      phone = getPhone(ContactChannel.PHONE_CHANNELS[i]);

      if ((phone != null)
            && phoneNum.equalsIgnoreCase(phone.getPhoneNum())) {
        return phone;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first name.
   *
   * @return  String
   */
  public String getFirstName() {
    return firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PaymentProgram> getFlexSitePaymentPrograms() {
    return flexSitePaymentPrograms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   tableStyle      String
   * @param   tableDataStyle  String
   *
   * @return  DOCUMENT ME!
   */
  public String getFlexSitePaymentProgramTable(String tableStyle, String tableDataStyle) {
    StringBuffer settlementStr = new StringBuffer("");

    if (flexSitePaymentPrograms != null) {
      PaymentProgram latestAcceptedPaymentProgram = flexSitePaymentPrograms.iterator().next();

      Set<PaymentProgramInstallment> installments = latestAcceptedPaymentProgram.getInstallments();

      if ((installments != null) & (installments.size() > 0)) {
        settlementStr.append(
          "<table border=\"1\"  style=" + tableStyle + ">");
        settlementStr.append("<tbody>");
        settlementStr.append("<tr>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">Name of financial institution</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">Account name</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">BSB</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">Account number</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">Amount</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">Date</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("</tr>");


        for (PaymentProgramInstallment installment : installments) {
          if ("BankAccount".equalsIgnoreCase(installment.getPayment().getFundingInformation().getType())) {
            settlementStr.append("<tr>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(installment.getPayment().getFundingInformation().getNickName());
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(installment.getPayment().getFundingInformation().getHolderFullName());
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(installment.getPayment().getFundingInformation().getRoutingNumber());
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(FormatUtil.maskAccountNumber(
                installment.getPayment().getFundingInformation().getFundingAccountNum(), 3));
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(FormatUtil.currencyFormat(installment.getPayment().getAmount()));
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(new SimpleDateFormat("dd/MM/yyyy").format(installment.getPayment().getPaymentDate()));
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("</tr>");
          } else {
            continue;
          } // end if-else
        }   // end for

        settlementStr.append("</tbody>");
        settlementStr.append("</table>");
      } else {
        return null;
      } // end if-else
    } else {
      return null;
    }   // end if-else

    return settlementStr.toString();
  } // end method getFlexSitePaymentProgramTable

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<Payment> getFlexSitePayments() {
    return flexSitePayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   tableStyle      String
   * @param   tableDataStyle  String
   *
   * @return  DOCUMENT ME!
   */
  public String getFlexSitePaymentTable(String tableStyle, String tableDataStyle) {
    StringBuffer settlementStr = new StringBuffer("");

    Payment latestPayment = null;

    if (flexSitePayments != null) {
      for (Payment payment : flexSitePayments) {
        if ("BankAccount".equalsIgnoreCase(payment.getFundingInformation().getType())) {
          latestPayment = payment;

          break;
        }
      }

      if (latestPayment != null) {
        settlementStr.append(
          "<table border=\"1\"  style=" + tableStyle + ">");
        settlementStr.append("<tbody>");
        settlementStr.append("<tr>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">Name of financial institution</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">Account name</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">BSB</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">Account number</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">Amount</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">Date</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("</tr>");
        settlementStr.append("<tr>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">");

        settlementStr.append(latestPayment.getFundingInformation().getNickName());
        settlementStr.append("</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">");

        settlementStr.append(latestPayment.getFundingInformation().getHolderFullName());
        settlementStr.append("</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">");

        settlementStr.append(latestPayment.getFundingInformation().getRoutingNumber());
        settlementStr.append("</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">");

        settlementStr.append(FormatUtil.maskAccountNumber(latestPayment.getFundingInformation().getFundingAccountNum(),
            3));
        settlementStr.append("</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">");

        settlementStr.append(FormatUtil.currencyFormat(latestPayment.getAmount()));
        settlementStr.append("</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("<td>");
        settlementStr.append(
          "<div><span style=" + tableDataStyle + ">");

        settlementStr.append(new SimpleDateFormat("dd/MM/yyyy").format(latestPayment.getPaymentDate()));
        settlementStr.append("</span></div>");
        settlementStr.append("</td>");
        settlementStr.append("</tr>");
        settlementStr.append("</tbody>");
        settlementStr.append("</table>");
      } else {
        return null;
      } // end if-else
    } else {
      return null;
    }   // end if-else

    return settlementStr.toString();
  } // end method getFlexSitePaymentTable

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get full name, first name + last name.
   *
   * @return  get full name, first name + last name
   */
  public String getFullName() {
    if ((null == firstName) && (null == lastName)) {
      return "";
    } else if ((null != firstName) && (null == lastName)) {
      return firstName;
    } else if ((null == firstName) && (null != lastName)) {
      return lastName;
    } else {
      return firstName + " " + lastName;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account.
   *
   * @param   fundingAccountId  Long
   *
   * @return  FundingAccount
   */
  public FundingAccount getFundingAccount(Long fundingAccountId) {
    for (FundingAccount account : fundingAccounts) {
      if (account.getFundingAccountId().equals(fundingAccountId)) {
        return account;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account by account number.
   *
   * @param   fromAccount  String
   *
   * @return  FundingAccount
   */
  public FundingAccount getFundingAccountByAccountNumber(String fromAccount) {
    for (FundingAccount account : fundingAccounts) {
      if (account.getFundingInformation().getFundingAccountNum().equals(
              fromAccount)) {
        return account;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account by nick name.
   *
   * @param   nickName  String
   *
   * @return  FundingAccount
   */
  public FundingAccount getFundingAccountByNickName(String nickName) {
    for (FundingAccount account : fundingAccounts) {
      if (account.getFundingInformation().getNickName().equals(
              nickName)) {
        return account;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding accounts.
   *
   * @return  Set
   */
  public Set<FundingAccount> getFundingAccounts() {
    return this.fundingAccounts;
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
  public PromiseToPay getFurthestPTP() {
    PromiseToPay ret         = null;
    Date         paymentDate = null;

    for (PromiseToPay ptp : this.promises) {
      if (PromiseToPayStatus.INIT.equals(ptp.getPtpStatus())) {
        if ((paymentDate == null)
              || paymentDate.before(ptp.getPaymentDate())) {
          paymentDate = ptp.getPaymentDate();
          ret         = ptp;
        }
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent address.
   *
   * @param   type  String
   *
   * @return  FuturePermanentContactAddress
   */
  public FuturePermanentContactAddress getFuturePermanentAddress(String type) {
    return futurePermanentAddresses.get(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent address.
   *
   * @param   channel  ContactChannel
   *
   * @return  FuturePermanentContactAddress
   */
  public FuturePermanentContactAddress getFuturePermanentAddress(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.ADDRESS.equals(channel.getChannelType())) {
      return futurePermanentAddresses.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent addresses.
   *
   * @return  Map
   */
  public Map<String, FuturePermanentContactAddress> getFuturePermanentAddresses() {
    return futurePermanentAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent city.
   *
   * @return  Set
   */
  public Set<String> getFuturePermanentCity() {
    Set<String> cities = new LinkedHashSet<String>();
    Address     addr   = null;

    for (FuturePermanentContactAddress a : futurePermanentAddresses.values()) {
      addr = a.getAddress();

      if ((addr != null) && StringUtils.hasText(addr.getCity())) {
        cities.add(addr.getCity());
      }

      return cities;
    }

    return cities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent historical addresses.
   *
   * @return  Set
   */
  public Set<FuturePermanentContactAddress> getFuturePermanentHistoricalAddresses() {
    return futurePermanentHistoricalAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent historical phones.
   *
   * @return  Set
   */
  public Set<FuturePermanentContactPhone> getFuturePermanentHistoricalPhones() {
    return futurePermanentHistoricalPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent phone.
   *
   * @param   typeId  String
   *
   * @return  FuturePermanentContactPhone
   */
  public FuturePermanentContactPhone getFuturePermanentPhone(String typeId) {
    return futurePermanentPhones.get(typeId);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent phone.
   *
   * @param   channel  ContactChannel
   *
   * @return  FuturePermanentContactPhone
   */
  public FuturePermanentContactPhone getFuturePermanentPhone(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.PHONE.equals(channel.getChannelType())) {
      return futurePermanentPhones.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent phone num.
   *
   * @param   typeId  String
   *
   * @return  String
   */
  public String getFuturePermanentPhoneNum(String typeId) {
    FuturePermanentContactPhone phone = getFuturePermanentPhone(typeId);

    if ((phone != null) && StringUtils.hasText(phone.getPhoneNum())) {
      return phone.getPhoneNum();
    }

    return null;


  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent phones.
   *
   * @return  Map
   */
  public Map<String, FuturePermanentContactPhone> getFuturePermanentPhones() {
    return futurePermanentPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future permanent province.
   *
   * @return  Set
   */
  public Set<String> getFuturePermanentProvince() {
    Set<String> provinces = new LinkedHashSet<String>();
    Address     addr      = null;

    for (FuturePermanentContactAddress a : futurePermanentAddresses.values()) {
      addr = a.getAddress();

      if ((addr != null) && StringUtils.hasText(addr.getProvince())) {
        provinces.add(addr.getProvince());
      }
    }

    return provinces;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gender.
   *
   * @return  String
   */
  public String getGender() {
    return gender;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for guarantor.
   *
   * @return  Boolean
   */
  public Boolean getGuarantor() {
    return guarantor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has current phone.
   *
   * @return  boolean
   */
  public boolean getHasCurrentPhone() {
    for (ContactPhone contactPhone : getPhones().values()) {
      if ((contactPhone != null)
            && (!Boolean.TRUE.equals(contactPhone.getHistorical()))) {
        if (log.isDebugEnabled()) {
          log.debug("Found a current phone number for contact phone id: " + contactPhone.getPhoneId()
            + " responsibleId: "
            + getResponsibleId());
        }

        return true;
      }
    }

    if (log.isDebugEnabled()) {
      log.debug("No current phone number(s) for responsibleId: " + getResponsibleId());
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get a flag that there is email for responsible.
   *
   * @return  get a flag that there is email for responsible
   */
  public boolean getHasEmail() {
    return (this.emails.size() > 0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get a flag that there is a email update today.
   *
   * @return  get a flag that there is a email update today
   */
  public boolean getHasEmailUpdateToday() {
    for (WebActivity webActivity : this.webActivities) {
      // TODO
      UpdateEmailActivity updateEmailActivity = getUpdateEmailActivity(webActivity);

      if (updateEmailActivity != null) {
        // update email activity
        // check the update time is less than one day
        Date updateDate = updateEmailActivity.getCreateDate();
        Date today      = new Date();
        long dif        = Math.abs(today.getTime() - updateDate.getTime());

        if (dif <= (1000L * 60 * 60 * 24)) {
          // updated less than 1 day
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the flag that there is no contact for this account holder.
   *
   * @return  get the flag that there is no contact for this account holder
   */
  public boolean getHasNoAccountHolderContact() {
    return (this.lastContactDate == null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the flag that there is web activity for this account holder.
   *
   * @return  get the flag that there is web activity for this account holder
   */
  public boolean getHasWebActivities() {
    return (this.webActivities.size() > 0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical addresses.
   *
   * @return  Set
   */
  public Set<ContactAddress> getHistoricalAddresses() {
    return historicalAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical emails.
   *
   * @return  Set
   */
  public Set<ContactEmail> getHistoricalEmails() {
    return historicalEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical phones.
   *
   * @return  Set
   */
  public Set<ContactPhone> getHistoricalPhones() {
    return historicalPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for HOAExpense.
   *
   * @return  Expense
   */
  public Expense getHOAExpense() {
    // return the most recent expense from expenses
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
   * getter method for HOAIncome.
   *
   * @return  Income
   */
  public Income getHOAIncome() {
    // return the most recent income from incomes
    Income            income;
    ArrayList<Income> incomes = new ArrayList<Income>();
    incomes.addAll(this.getIncomes());
    income = incomes.get(0);

    for (int i = 1; i < incomes.size(); i++) {
      if (incomes.get(i).getLastUpdateDate().compareTo(
              income.getLastUpdateDate()) > 0) {
        income = incomes.get(i);
      }
    }

    return income;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home address.
   *
   * @return  ContactAddress
   */
  public ContactAddress getHomeAddress() {
    return getAddress(ContactChannel.HOMEADDRESS.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home address1.
   *
   * @return  String
   */
  public String getHomeAddress1() {
    ContactAddress a = getHomeAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getAddress1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home address2.
   *
   * @return  String
   */
  public String getHomeAddress2() {
    ContactAddress a = getHomeAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getAddress2();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home address3.
   *
   * @return  String
   */
  public String getHomeAddress3() {
    ContactAddress a = getHomeAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getAddress3();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home city.
   *
   * @return  String
   */
  public String getHomeCity() {
    ContactAddress contactAddress = getHomeAddress();

    if (contactAddress != null) {
      if (contactAddress.getAddress() != null) {
        return contactAddress.getAddress().getCity();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  HomeEmail
   */
  public ContactEmail getHomeEmail() {
    return getEmail(ContactChannel.HOMEEMAIL.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get home email string, return empty string if there is no such email.
   *
   * @return  get home email string, return empty string if there is no such email
   */
  public String getHomeEmailStr() {
    ContactEmail contactEmail = getHomeEmail();

    if (contactEmail != null) {
      return contactEmail.getEmailAddress();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all Home equity CTM surveys related to responsible.
   *
   * @return  the homeEquityCTMSurveys
   */
  public Set<HomeEquityCTMSurvey> getHomeEquityCTMSurveys() {
    return homeEquityCTMSurveys;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all Home equity Refi surveys related to responsible.
   *
   * @return  the homeEquityRefiSurveys
   */
  public Set<HomeEquityRefiSurvey> getHomeEquityRefiSurveys() {
    return homeEquityRefiSurveys;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all Home equity surveys related to responsible.
   *
   * @return  the homeEquitySurveys
   */
  public Set<HomeEquitySurvey> getHomeEquitySurveys() {
    return homeEquitySurveys;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get home owner flag.
   *
   * @return  the homeowner
   */
  public Boolean getHomeowner() {
    return homeowner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  HomePhone
   */
  public ContactPhone getHomePhone() {
    return getPhone(ContactChannel.HOMEPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get home phone number string, return empty string if there is no such number.
   *
   * @return  get home phone number string, return empty string if there is no such number
   */
  public String getHomePhoneStr() {
    ContactPhone contactPhone = getHomePhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  HomeProvince
   */
  public String getHomeProvince() {
    ContactAddress contactAddress = getHomeAddress();

    if (contactAddress != null) {
      if (contactAddress.getAddress() != null) {
        return contactAddress.getAddress().getProvince();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home zip code.
   *
   * @return  String
   */
  public String getHomeZipCode() {
    ContactAddress a = getHomeAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getPostalCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the annual income.
   *
   * @return  the income
   */
  public BigDecimal getIncome() {
    return income;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all income relate to responsible.
   *
   * @return  the incomes
   */

  public Set<Income> getIncomes() {
    return incomes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Is responsible contactable?
   *
   * @return  is responsible contactable?
   */
  public boolean getIsContactable() {
    return (getIsContactableByAddress() || getIsContactableByEmail()
        || getIsContactableByPhone());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Could this responsible be contacted by address.
   *
   * @return  could this responsible be contacted by address
   */
  public boolean getIsContactableByAddress() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return false;
    }

    for (ContactAddress contactAddress : getAddresses().values()) {
      if ((contactAddress != null) && contactAddress.isValidAddress()
            && (!Boolean.TRUE.equals(contactAddress.getDoNotContact()))) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * this responsible could be contacted by email.
   *
   * @return  this responsible could be contacted by email
   */
  public boolean getIsContactableByEmail() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return false;
    }

    for (ContactEmail contactEmail : getEmails().values()) {
      if ((contactEmail != null)
            && (!Boolean.TRUE.equals(contactEmail.getDoNotContact()))
            && StringUtils.hasText(contactEmail.getEmailAddress())) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is contactable by mobile phone.
   *
   * @return  boolean
   */
  public boolean getIsContactableByMobilePhone() {
    return (getContactableMobilePhone() != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This responsible could be contacted by phone.
   *
   * @return  this responsible could be contacted by phone
   */
  public boolean getIsContactableByPhone() {
    if (Boolean.TRUE.equals(account.getDoNotContact())
          || Boolean.TRUE.equals(this.getDoNotContact())) {
      return false;
    }

    for (ContactPhone contactPhone : getPhones().values()) {
      if ((contactPhone != null)
            && (contactPhone.isValidNumber()
              && (!Boolean.TRUE.equals(
                  contactPhone.getDoNotContact())))) {
        if (log.isDebugEnabled()) {
          log.debug("Found a valid phone number for contact phone id: " + contactPhone.getPhoneId() + " responsibleId: "
            + getResponsibleId());
        }

        return true;
      }
    }

    if (log.isDebugEnabled()) {
      log.debug("No valid phone number for responsibleId: " + getResponsibleId());
    }

    return false;
  } // end method getIsContactableByPhone

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This responsible could be contacted by sms phone.
   *
   * @return  this responsible could be contacted by sms phone
   */
  public boolean getIsContactableBySmsPhone() {
    return (getContactableSmsPhone() != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This responsible could be contacted by sms phone.
   *
   * @return  this responsible could be contacted by sms phone
   */
  public boolean getIsContactableByTextPhone() {
    return (getContactableTextPhone() != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsHomeEmailUnsubscribed() {
    ContactEmail contactEmail = getHomeEmail();

    if ((contactEmail != null)
          && (Boolean.TRUE.equals(contactEmail.getOptOut()))) {
      return true;
    }


    if (this.getCustomer() != null) {
      CustomerContactEmail customerContactEmail = this.getCustomer().getHomeEmail();

      if ((customerContactEmail != null)
            && (Boolean.TRUE.equals(customerContactEmail.getOptOut()))) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Is responsible not contactable?
   *
   * @return  is responsible not contactable?
   */
  public boolean getIsNotContactable() {
    return !getIsContactable();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This responsible could not be contacted by address.
   *
   * @return  this responsible could not be contacted by address
   */
  public boolean getIsNotContactableByAddress() {
    return !getIsContactableByAddress();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This responsible could not be contacted by email.
   *
   * @return  this responsible could not be contacted by email
   */
  public boolean getIsNotContactableByEmail() {
    return !getIsContactableByEmail();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This responsible could not be contacted by phone.
   *
   * @return  this responsible could not be contacted by phone
   */
  public boolean getIsNotContactableByPhone() {
    return !getIsContactableByPhone();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This responsible could not be contacted by sms phone.
   *
   * @return  this responsible could not be contacted by sms phone
   */
  public boolean getIsNotContactableBySmsPhone() {
    return (getContactableSmsPhone() == null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This responsible could not be contacted by sms phone.
   *
   * @return  this responsible could not be contacted by sms phone
   */
  public boolean getIsNotContactableByTextPhone() {
    return (getContactableTextPhone() == null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getIsOtherEmailUnsubscribed() {
    ContactEmail contactEmail = getOtherEmail();

    if ((contactEmail != null)
          && (Boolean.TRUE.equals(contactEmail.getOptOut()))) {
      return true;
    }

    if (this.getCustomer() != null) {
      CustomerContactEmail customerContactEmail = this.getCustomer().getOtherEmail();

      if ((customerContactEmail != null)
            && (Boolean.TRUE.equals(customerContactEmail.getOptOut()))) {
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
  public boolean getIsWorkEmailUnsubscribed() {
    ContactEmail contactEmail = getWorkEmail();

    if ((contactEmail != null)
          && (Boolean.TRUE.equals(contactEmail.getOptOut()))) {
      return true;
    }

    if (this.getCustomer() != null) {
      CustomerContactEmail customerContactEmail = this.getCustomer().getWorkEmail();

      if ((customerContactEmail != null)
            && (Boolean.TRUE.equals(customerContactEmail.getOptOut()))) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The ivrChannelResults.
   *
   * @return  the ivrChannelResults
   */
  public Set<IvrChannelResult> getIvrChannelResults() {
    return ivrChannelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * How many times somebody has called in using ivr-inbound number to discuss this responsible. Could be someboday
   * other than debtor called in and complain that we have the wrong contact info.
   *
   * @return  how many times somebody has called in using ivr-inbound number to discuss this responsible.
   */
  public Integer getIvrInboundCount() {
    return ivrInboundCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last4 ssn.
   *
   * @return  String
   */
  public String getLast4Ssn() {
    if (StringUtils.hasText(last4Ssn)) {
      return last4Ssn;
    }

    if (StringUtils.hasText(ssn) && (ssn.length() >= 4)) {
      return ssn.substring(ssn.length() - 4);
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last4 ssn2.
   *
   * @return  String
   */
  public String getLast4Ssn2() {
    return last4Ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last chat accept date.
   *
   * @return  Date
   */
  public Date getLastChatAcceptDate() {
    Date lastChatAcceptDate = null;

    if ((liveChatSessions != null) && (liveChatSessions.size() > 0)) {
      for (LiveChatSession lc : liveChatSessions) {
        if ((lastChatAcceptDate == null) || lc.getChatLocalStartTime().after(lastChatAcceptDate)) {
          lastChatAcceptDate = lc.getChatLocalStartTime();
        }
      }
    }

    return lastChatAcceptDate;
  }
  /*SM-441*/

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last chat session start date.
   *
   * @return  Date
   */
  public Date getLastChatSessionStartDate() {
    Date lastChatSessionStartDate = null;

    if ((liveChatSessions != null) && (liveChatSessions.size() > 0)) {
      for (LiveChatSession lc : liveChatSessions) {
        if ((lastChatSessionStartDate == null) || lc.getChatStartTime().after(lastChatSessionStartDate)) {
          lastChatSessionStartDate = lc.getChatStartTime();
        }
      }
    }

    return lastChatSessionStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last CMCEmail reminder payment created date.
   *
   * @return  Date
   */
  public Date getLastCMCEmailReminderPaymentCreatedDate() {
    Date createDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (payment.isCMCWebPayment()
              && (payment.getPaymentReminder() != null)
              && ReminderType.EMAIL.equals(
                payment.getPaymentReminder().getReminderType())
              && ((createDate == null)
                || createDate.before(payment.getCreateDate()))) {
          createDate = payment.getCreateDate();
        }

      }
    }

    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last CMCEmail reminder payment deleted date.
   *
   * @return  Date
   */
  public Date getLastCMCEmailReminderPaymentDeletedDate() {
    Date deleteDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (payment.isCMCWebDeletedPayment()
              && (payment.getPaymentReminder() != null)
              && ReminderType.EMAIL.equals(
                payment.getPaymentReminder().getReminderType())
              && PaymentStatus.DELETED.equals(
                payment.getPaymentStatus())
              && ((deleteDate == null)
                || ((payment.getDeletedStatusDate() != null)
                  && deleteDate.before(
                    payment.getDeletedStatusDate())))) {
          deleteDate = payment.getDeletedStatusDate();
        }
      }
    }

    return deleteDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last CMCEmail reminder payment updated date.
   *
   * @return  Date
   */
  public Date getLastCMCEmailReminderPaymentUpdatedDate() {
    Date updateDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (payment.isCMCWebUpdatedPayment()
              && PaymentStatus.SCHEDULED.equals(
                payment.getPaymentStatus())
              && (payment.getPaymentReminder() != null)
              && ReminderType.EMAIL.equals(
                payment.getPaymentReminder().getReminderType())
              && (payment.getUpdatePaymentDate() != null)
              && ((updateDate == null)
                || ((payment.getUpdatePaymentDate() != null)
                  && updateDate.before(
                    payment.getUpdatePaymentDate())))) {
          updateDate = payment.getUpdatePaymentDate();
        }
      }
    }

    return updateDate;
  } // end method getLastCMCEmailReminderPaymentUpdatedDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last CMCPayment created date.
   *
   * @return  Date
   */
  public Date getLastCMCPaymentCreatedDate() {
    Date createDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (payment.isCMCWebPayment()
              && ((createDate == null)
                || createDate.before(payment.getCreateDate()))) {
          createDate = payment.getCreateDate();
        }

      }
    }

    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last CMCPayment deleted date.
   *
   * @return  Date
   */
  public Date getLastCMCPaymentDeletedDate() {
    Date deleteDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (payment.isCMCWebDeletedPayment()
              && PaymentStatus.DELETED.equals(
                payment.getPaymentStatus())
              && ((deleteDate == null)
                || ((payment.getDeletedStatusDate() != null)
                  && deleteDate.before(
                    payment.getDeletedStatusDate())))) {
          deleteDate = payment.getDeletedStatusDate();
        }
      }
    }

    return deleteDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last CMCPayment updated date.
   *
   * @return  Date
   */
  public Date getLastCMCPaymentUpdatedDate() {
    Date updateDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (payment.isCMCWebUpdatedPayment()
              && (payment.getUpdatePaymentDate() != null)
              && ((updateDate == null)
                || ((payment.getUpdatePaymentDate() != null)
                  && updateDate.before(
                    payment.getUpdatePaymentDate())))) {
          updateDate = payment.getUpdatePaymentDate();
        }
      }
    }

    return updateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last CMCSms reminder payment created date.
   *
   * @return  Date
   */
  public Date getLastCMCSmsReminderPaymentCreatedDate() {
    Date createDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (payment.isCMCWebPayment()
              && (payment.getPaymentReminder() != null)
              && ReminderType.SMS.equals(
                payment.getPaymentReminder().getReminderType())
              && ((createDate == null)
                || createDate.before(payment.getCreateDate()))) {
          createDate = payment.getCreateDate();
        }

      }
    }

    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last CMCSms reminder payment deleted date.
   *
   * @return  Date
   */
  public Date getLastCMCSmsReminderPaymentDeletedDate() {
    Date deleteDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (payment.isCMCWebDeletedPayment()
              && (payment.getPaymentReminder() != null)
              && ReminderType.SMS.equals(
                payment.getPaymentReminder().getReminderType())
              && PaymentStatus.DELETED.equals(
                payment.getPaymentStatus())
              && ((deleteDate == null)
                || ((payment.getDeletedStatusDate() != null)
                  && deleteDate.before(
                    payment.getDeletedStatusDate())))) {
          deleteDate = payment.getDeletedStatusDate();
        }
      }
    }

    return deleteDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last CMCSms reminder payment updated date.
   *
   * @return  Date
   */
  public Date getLastCMCSmsReminderPaymentUpdatedDate() {
    Date updateDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (payment.isCMCWebUpdatedPayment()
              && PaymentStatus.SCHEDULED.equals(
                payment.getPaymentStatus())
              && (payment.getPaymentReminder() != null)
              && ReminderType.SMS.equals(
                payment.getPaymentReminder().getReminderType())
              && (payment.getUpdatePaymentDate() != null)
              && ((updateDate == null)
                || ((payment.getUpdatePaymentDate() != null)
                  && updateDate.before(
                    payment.getUpdatePaymentDate())))) {
          updateDate = payment.getUpdatePaymentDate();
        }
      }
    }

    return updateDate;
  } // end method getLastCMCSmsReminderPaymentUpdatedDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The lastContactDate.
   *
   * @return  the lastContactDate
   */
  public Date getLastContactDate() {
    return this.lastContactDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The lastLetterDate.
   *
   * @return  the lastLetterDate
   */
  public Date getLastLetterDate() {
    return lastLetterDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last letter days.
   *
   * @return  Integer
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
   * getter method for last name.
   *
   * @return  String
   */
  public String getLastName() {
    return lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last payment created date.
   *
   * @return  Date
   */
  public Date getLastPaymentCreatedDate() {
    Date createDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if ((createDate == null)
              || createDate.before(payment.getCreateDate())) {
          createDate = payment.getCreateDate();
        }

      }
    }

    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last payment deleted date.
   *
   * @return  Date
   */
  public Date getLastPaymentDeletedDate() {
    Date deleteDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (PaymentStatus.DELETED.equals(payment.getPaymentStatus())
              && ((deleteDate == null)
                || ((payment.getDeletedStatusDate() != null)
                  && (deleteDate.before(
                      payment.getDeletedStatusDate()))))) {
          deleteDate = payment.getDeletedStatusDate();
        }
      }
    }

    return deleteDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last payment paid date.
   *
   * @return  Date
   */
  public Date getLastPaymentPaidDate() {
    Date paidDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (PaymentStatus.PAID.equals(payment.getPaymentStatus())
              && ((paidDate == null)
                || ((payment.getPaidStatusDate() != null)
                  && paidDate.before(
                    payment.getPaidStatusDate())))) {
          paidDate = payment.getPaidStatusDate();
        }
      }
    }

    return paidDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last payment processed date.
   *
   * @return  Date
   */
  public Date getLastPaymentProcessedDate() {
    Date processedDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if ((PaymentStatus.INPROCESS.equals(
                  payment.getPaymentStatus()) || PaymentStatus.PAID.equals(
                  payment.getPaymentStatus()))
              && ((processedDate == null)
                || ((payment.getProcessDate() != null)
                  && processedDate.before(
                    payment.getProcessDate())))) {
          processedDate = payment.getProcessDate();
        }
      }
    }

    return processedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last payment rejected at auth date.
   *
   * @return  Date
   */
  public Date getLastPaymentRejectedAtAuthDate() {
    Date rejectedAtAuthDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (PaymentStatus.REJECTED.equals(payment.getPaymentStatus())
              && ((rejectedAtAuthDate == null)
                || ((payment.getRejectedAtAuthorizationDate() != null)
                  && rejectedAtAuthDate.before(
                    payment.getRejectedAtAuthorizationDate())))) {
          rejectedAtAuthDate = payment.getRejectedAtAuthorizationDate();
        }
      }
    }

    return rejectedAtAuthDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last payment rejected date.
   *
   * @return  Date
   */
  public Date getLastPaymentRejectedDate() {
    Date rejectedDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if (PaymentStatus.REJECTED.equals(payment.getPaymentStatus())
              && ((rejectedDate == null)
                || ((payment.getRejectedStatusDate() != null)
                  && rejectedDate.before(
                    payment.getRejectedStatusDate())))) {
          rejectedDate = payment.getRejectedStatusDate();
        }
      }
    }

    return rejectedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last payment updated date.
   *
   * @return  Date
   */
  public Date getLastPaymentUpdatedDate() {
    Date updateDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        if ((payment.getUpdatePaymentDate() != null)
              && ((updateDate == null)
                || ((payment.getUpdatePaymentDate() != null)
                  && updateDate.before(
                    payment.getUpdatePaymentDate())))) {
          updateDate = payment.getUpdatePaymentDate();
        }
      }
    }

    return updateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the last portfolio survey answer by survey question id.
   *
   * @param   questionId  DOCUMENT ME!
   *
   * @return  get the last portfolio survey answer by survey question id
   */
  public PortfolioSurveyAnswer getLastPortfolioSurveyAnswer(Long questionId) {
    PortfolioSurveyAnswer retAnswer = null;

    if ((portfolioSurveyAnswers != null) && (portfolioSurveyAnswers.size() > 0)) {
      for (PortfolioSurveyAnswer answer : portfolioSurveyAnswers) {
        if ((answer.getQuestion().getId().equals(questionId))) {
          if (retAnswer == null) {
            retAnswer = answer;
          } else if (retAnswer.getSurveyRound() < answer.getSurveyRound()) {
            retAnswer = answer;
          }
        }
      }
    }

    return retAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last portfolio survey answer.
   *
   * @param   questionCode  String
   *
   * @return  PortfolioSurveyAnswer
   */
  public PortfolioSurveyAnswer getLastPortfolioSurveyAnswer(String questionCode) {
    PortfolioSurveyAnswer retAnswer = null;

    if ((portfolioSurveyAnswers != null) && (portfolioSurveyAnswers.size() > 0)) {
      for (PortfolioSurveyAnswer answer : portfolioSurveyAnswers) {
        if ((answer.getQuestion().getQuestionCode().equals(questionCode))) {
          if (retAnswer == null) {
            retAnswer = answer;
          } else if (retAnswer.getSurveyRound() < answer.getSurveyRound()) {
            retAnswer = answer;
          }
        }
      }
    }

    return retAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last portfolio survey answer data.
   *
   * @param   questionId  Long
   *
   * @return  Object
   */
  public Object getLastPortfolioSurveyAnswerData(Long questionId) {
    PortfolioSurveyAnswer answer = this.getLastPortfolioSurveyAnswer(questionId);

    if (answer == null) {
      return null;
    } else {
      return answer.getTypedData();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last portfolio survey answer data by code.
   *
   * @param   questionCode  String
   *
   * @return  Object
   */
  public Object getLastPortfolioSurveyAnswerDataByCode(String questionCode) {
    PortfolioSurveyAnswer answer = this.getLastPortfolioSurveyAnswer(questionCode);

    if (answer == null) {
      return null;
    } else {
      return answer.getTypedData();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the last portfolio survey answer relate to responsible.
   *
   * @return  the last portfolioSurveyAnswers
   */
  public Set<PortfolioSurveyAnswer> getLastPortfolioSurveyAnswers() {
    Set<PortfolioSurveyAnswer> lastAnswers = new LinkedHashSet<PortfolioSurveyAnswer>();

// for (PortfolioSurveyAnswer answer : portfolioSurveyAnswers) {
// if (answer.getSurveyRound().equals(surveyRound)) {
// lastAnswers.add(answer);
// }
// }

    int r = -1;

    for (PortfolioSurveyAnswer answer : portfolioSurveyAnswers) {
      if (answer.getSurveyRound() < r) {
        break;
      } else if (answer.getSurveyRound() > r) {
        r = answer.getSurveyRound();
        lastAnswers.add(answer);
      }
    }

    return lastAnswers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last portfolio survey date.
   *
   * @return  Date
   */
  public Date getLastPortfolioSurveyDate() {
    if (portfolioSurveyAnswers.size() > 0) {
      return ((PortfolioSurveyAnswer) portfolioSurveyAnswers.toArray()[0]).getSurveyDate();
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last survey date.
   *
   * @param   surveyCode  String
   *
   * @return  Date
   */
  public Date getLastSurveyDate(final String surveyCode) {
    Date surveyDate = null;

    if ((portfolioSurveyAnswers != null) && (portfolioSurveyAnswers.size() > 0)) {
      for (PortfolioSurveyAnswer answer : portfolioSurveyAnswers) {
        if (surveyCode.equalsIgnoreCase(answer.getSurveyCode())
              && ((surveyDate == null)
                || ((answer.getSurveyDate() != null)
                  && surveyDate.before(answer.getSurveyDate())))) {
          surveyDate = answer.getSurveyDate();
        }
      }
    }

    return surveyDate;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last web update address date.
   *
   * @return  Date
   */
  public Date getLastWebUpdateAddressDate() {
    if ((this.webUpdateAddress != null) && (this.webUpdateAddress.size() > 0)) {
      Iterator<ContactAddress> it = webUpdateAddress.iterator();

      return it.next().getLastUpdateDate();
    } else {
      return null;
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last web update email date.
   *
   * @return  Date
   */
  public Date getLastWebUpdateEmailDate() {
    if ((this.webUpdateEmails != null) && (this.webUpdateEmails.size() > 0)) {
      Iterator<ContactEmail> it = webUpdateEmails.iterator();

      return it.next().getLastUpdateDate();
    } else {
      return null;
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last web update phone date.
   *
   * @return  Date
   */
  public Date getLastWebUpdatePhoneDate() {
    if ((this.webUpdatePhones != null) && (this.webUpdatePhones.size() > 0)) {
      Iterator<ContactPhone> it = webUpdatePhones.iterator();

      return it.next().getLastUpdateDate();
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the latest CMC Channel Result code for Dialer Channel on the Responsible Phone Number matching the phone
   * type.
   *
   * @param   typeId  Phone Type Id
   *
   * @return  Latest CMC Channel Result Code for Dialer Channel
   */
  public String getLatestDialerChannelResultCode(String typeId) {
    if (StringUtils.hasText(typeId)) {
      ContactPhone phone = getPhone(typeId);

      if ((phone != null) && (phone.getDialerAudits() != null) && (phone.getDialerAudits().size() > 0)) {
        for (DialerAudit dialerAudit : phone.getDialerAudits()) {
          if ((dialerAudit.getVendorChannelResultCode() != null)
                && (dialerAudit.getVendorChannelResultCode().getCmcChannelResultCode() != null)) {
            return dialerAudit.getVendorChannelResultCode().getCmcChannelResultCode().getCode();
          }
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the latest Vendor Result code for Dialer Channel on the Responsible Phone Number matching the phone type.
   *
   * @param   typeId  Phone Type Id
   *
   * @return  Latest Vendor Result code for Dialer Channel
   */
  public String getLatestDialerVendorResultCode(String typeId) {
    if (StringUtils.hasText(typeId)) {
      ContactPhone phone = getPhone(typeId);

      if ((phone != null) && (phone.getDialerAudits() != null) && (phone.getDialerAudits().size() > 0)) {
        for (DialerAudit dialerAudit : phone.getDialerAudits()) {
          if (StringUtils.hasText(dialerAudit.getVendorResultCode())) {
            return dialerAudit.getVendorResultCode();
          }
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the most recent responsible score based on score type.
   *
   * @param   scoreType  DOCUMENT ME!
   *
   * @return  get the most recent responsible score based on score type.
   */
  public ResponsibleScore getLatestScore(String scoreType) {
    ResponsibleScore ret = null;

    for (ResponsibleScore score : this.responsibleScores) {
      if (score.getScoreType().getScoreName().equals(scoreType)) {
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
   * Get the most recent responsible score based on score type.
   *
   * @param   scoreType  DOCUMENT ME!
   *
   * @return  get the most recent responsible score based on score type.
   */
  public ResponsibleScore getLatestScore(ScoreTypeEnum scoreType) {
    ResponsibleScore ret = null;

    for (ResponsibleScore score : this.responsibleScores) {
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
    ResponsibleScore score = getLatestScore(scoreType);

    if (score != null) {
      return score.getScoreValue();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter channel actual results.
   *
   * @return  Set
   */
  public Set<LetterChannelActualResult> getLetterChannelActualResults() {
    return letterChannelActualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter channel results.
   *
   * @return  Set
   */
  public Set<LetterChannelResult> getLetterChannelResults() {
    return letterChannelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for live chat sessions.
   *
   * @return  Set
   */
  public Set<LiveChatSession> getLiveChatSessions() {
    return liveChatSessions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan.
   *
   * @param   loanId  String
   *
   * @return  Loan
   */
  public Loan getLoan(String loanId) {
    if (getLoans() != null) {
      for (Loan loan : getLoans()) {
        if (loan.getLoanId().equals(loanId)) {
          return loan;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loans.
   *
   * @return  Set
   */
  public Set<Loan> getLoans() {
    return loans;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get default locale for this responsible.
   *
   * @return  get default locale for this responsible.
   */
  public Locale getLocale() {
    if (this.localeString == null) {
      return null;
    }

    return StringUtils.parseLocaleString(this.localeString);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for locale country.
   *
   * @return  String
   */
  public String getLocaleCountry() {
    LocaleType locale = LocaleType.ENGLISH;

    if (this.localeString != null) {
      locale = LocaleType.convert(localeString);

      if (locale == null) {
        locale = LocaleType.ENGLISH;
      }
    }

    return locale.getCountry();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for locale string.
   *
   * @return  String
   */
  public String getLocaleString() {
    return localeString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for login failure count.
   *
   * @return  Integer
   */
  public Integer getLoginFailureCount() {
    return loginFailureCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for match confidence.
   *
   * @return  String
   */
  public String getMatchConfidence() {
    return matchConfidence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for middle name.
   *
   * @return  String
   */
  public String getMiddleName() {
    return middleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  MobilePhone
   */
  public ContactPhone getMobilePhone() {
    return getPhone(ContactChannel.MOBILEPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get mobile phone number string, return empty string if there is no such number.
   *
   * @return  get mobile phone number string, return empty string if there is no such number
   */
  public String getMobilePhoneStr() {
    ContactPhone contactPhone = getMobilePhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for monthly income.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMonthlyIncome() {
    return monthlyIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for monthly payment.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMonthlyPayment() {
    return monthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for most recent appointment.
   *
   * @return  AdvisorAppointment
   */
  public AdvisorAppointment getMostRecentAppointment() {
    if (appointments == null) {
      return null;
    }

    AdvisorAppointment returnAppt = null;

    for (AdvisorAppointment appt : appointments) {
      if ((appt != null)
            && !AppointmentStatus.CANCELLED.equals(appt.getStatus())
            && !AppointmentStatus.POSTPONED.equals(appt.getStatus())) {
        Date date = appt.getAppointmentDateTime();

        // Check if it is future appt
        if ((date != null)
              && (date.getTime() > (new Date()).getTime())) {
          if (returnAppt == null) {
            returnAppt = appt;
          } else if (date.getTime()
                < returnAppt.getAppointmentDateTime().getTime()) {
            returnAppt = appt;
          }
        }
      }
    }

    return returnAppt;
  } // end method getMostRecentAppointment

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for most recent appointment date.
   *
   * @return  Date
   */
  public Date getMostRecentAppointmentDate() {
    AdvisorAppointment appt = this.getMostRecentAppointment();

    if (appt != null) {
      return DateUtil.toDateOnly(appt.getAppointmentDateTime());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for most recent appointment hour.
   *
   * @return  Integer
   */
  public Integer getMostRecentAppointmentHour() {
    AdvisorAppointment appt = this.getMostRecentAppointment();

    if (appt != null) {
      Calendar c = GregorianCalendar.getInstance();
      c.setTime(appt.getAppointmentDateTime());

      return c.get(Calendar.HOUR_OF_DAY);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for most recent appointment minute.
   *
   * @return  Integer
   */
  public Integer getMostRecentAppointmentMinute() {
    AdvisorAppointment appt = this.getMostRecentAppointment();

    if (appt != null) {
      Calendar c = GregorianCalendar.getInstance();
      c.setTime(appt.getAppointmentDateTime());

      return c.get(Calendar.MINUTE);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for most recent survey answer.
   *
   * @return  PortfolioSurveyAnswer
   */
  public PortfolioSurveyAnswer getMostRecentSurveyAnswer() {
    if ((portfolioSurveyAnswers != null)
          && (portfolioSurveyAnswers.size() > 0)) {
      for (PortfolioSurveyAnswer answer : portfolioSurveyAnswers) {
        if (answer != null) {
          return answer;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for most recent survey answer by survey code.
   *
   * @param   surveyCode  String
   *
   * @return  PortfolioSurveyAnswer
   */
  public PortfolioSurveyAnswer getMostRecentSurveyAnswerBySurveyCode(String surveyCode) {
    if (!StringUtils.hasText(surveyCode)) {
      return null;
    }

    if ((portfolioSurveyAnswers != null)
          && (portfolioSurveyAnswers.size() > 0)) {
      for (PortfolioSurveyAnswer answer : portfolioSurveyAnswers) {
        if ((answer != null)
              && surveyCode.equalsIgnoreCase(answer.getSurveyCode())) {
          return answer;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for most recent survey answers by survey code.
   *
   * @param   surveyCode  String
   *
   * @return  Set
   */
  public Set<PortfolioSurveyAnswer> getMostRecentSurveyAnswersBySurveyCode(String surveyCode) {
    if (!StringUtils.hasText(surveyCode)) {
      return null;
    }

    Set<PortfolioSurveyAnswer> lastAnswers = new LinkedHashSet<PortfolioSurveyAnswer>();
    int                        initCode    = -1;

    if ((portfolioSurveyAnswers != null)
          && (portfolioSurveyAnswers.size() > 0)) {
      for (PortfolioSurveyAnswer answer : portfolioSurveyAnswers) {
        if ((answer != null)
              && surveyCode.equalsIgnoreCase(answer.getSurveyCode())
              && ((initCode == -1) || (answer.getSurveyRound() == initCode))) {
          lastAnswers.add(answer);
          initCode = answer.getSurveyRound();
        }
      }
    }

    return lastAnswers;


  } // end method getMostRecentSurveyAnswersBySurveyCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for most recent survey code.
   *
   * @return  String
   */
  public String getMostRecentSurveyCode() {
    PortfolioSurveyAnswer answer = this.getMostRecentSurveyAnswer();

    if (answer == null) {
      return null;
    }

    return answer.getSurveyCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for most recent survey date.
   *
   * @return  Date
   */
  public Date getMostRecentSurveyDate() {
    PortfolioSurveyAnswer answer = this.getMostRecentSurveyAnswer();

    if (answer == null) {
      return null;
    }

    return answer.getSurveyDate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for most recent survey date by survey code.
   *
   * @param   surveyCode  String
   *
   * @return  Date
   */
  public Date getMostRecentSurveyDateBySurveyCode(String surveyCode) {
    PortfolioSurveyAnswer answer = this.getMostRecentSurveyAnswerBySurveyCode(surveyCode);

    if (answer == null) {
      return null;
    }

    return answer.getSurveyDate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * When is the last time we left voice mail for this debtor.
   *
   * @return  when is the last time we left voice mail for this debtor.
   */
  public Date getMostRecentVoiceMailDate() {
    Date ret = null;

    for (VoiceMailActivity vm : this.voiceMailActivities) {
      if ((ret == null) || ret.before(vm.getVmDate())) {
        ret = vm.getVmDate();
      }
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mother maiden name.
   *
   * @return  String
   */
  public String getMotherMaidenName() {
    return motherMaidenName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name suffix.
   *
   * @return  String
   */
  public String getNameSuffix() {
    return nameSuffix;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for non charged off loans.
   *
   * @return  Set
   */
  public Set<Loan> getNonChargedOffLoans() {
    return nonChargedOffLoans;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  OtherAddress
   */
  public ContactAddress getOtherAddress() {
    return getAddress(ContactChannel.OTHERADDRESS.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  OtherEmail
   */
  public ContactEmail getOtherEmail() {
    return getEmail(ContactChannel.OTHEREMAIL.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get other email string, return empty string if there is no such email.
   *
   * @return  get other email string, return empty string if there is no such email
   */
  public String getOtherEmailStr() {
    ContactEmail contactEmail = getOtherEmail();

    if (contactEmail != null) {
      return contactEmail.getEmailAddress();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other monthly income.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOtherMonthlyIncome() {
    return otherMonthlyIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other monthly payment.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOtherMonthlyPayment() {
    return otherMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  OtherPhone
   */
  public ContactPhone getOtherPhone() {
    return getPhone(ContactChannel.OTHERPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get other phone number string, return empty string if there is no such number.
   *
   * @return  get other phone number string, return empty string if there is no such number
   */
  public String getOtherPhoneStr() {
    ContactPhone contactPhone = getOtherPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other zip code.
   *
   * @return  String
   */
  public String getOtherZipCode() {
    ContactAddress contactAddress = getOtherAddress();

    if ((contactAddress == null) || (contactAddress.getAddress() == null)) {
      return null;
    }

    String otherZipCode = contactAddress.getAddress().getPostalCode();

    if (otherZipCode == null) {
      return null;
    }

    return otherZipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for password.
   *
   * @return  String
   */
  public String getPassword() {
    return password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payg address.
   *
   * @return  ContactAddress
   */
  public ContactAddress getPaygAddress() {
    return getAddress(ContactChannel.PAYGADDRESS.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payg address1.
   *
   * @return  String
   */
  public String getPaygAddress1() {
    ContactAddress a = getPaygAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getAddress1();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payg address2.
   *
   * @return  String
   */
  public String getPaygAddress2() {
    ContactAddress a = getPaygAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getAddress2();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payg city.
   *
   * @return  String
   */
  public String getPaygCity() {
    ContactAddress a = getPaygAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getCity();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payg post code.
   *
   * @return  String
   */
  public String getPaygPostCode() {
    ContactAddress a = getPaygAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getPostalCode();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payg state.
   *
   * @return  String
   */
  public String getPaygState() {
    ContactAddress a = getPaygAddress();

    if ((a != null) && (a.getAddress() != null)) {
      return a.getAddress().getProvince();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment.
   *
   * @param   paymentId  Long
   *
   * @return  Payment
   */
  public Payment getPayment(Long paymentId) {
    for (Payment payment : payments) {
      if (payment.getPaymentId().equals(paymentId)) {
        return payment;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment by external reference.
   *
   * @param   pmtRef  String
   *
   * @return  Payment
   */
  public Payment getPaymentByExternalReference(String pmtRef) {
    if (pmtRef == null) {
      return null;
    }

    for (Payment payment : payments) {
      if (pmtRef.equals(payment.getExternalReferenceNumber())) {
        return payment;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment email reminder due date.
   *
   * @return  Date
   */
  public Date getPaymentEmailReminderDueDate() {
    Date reminderDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        PaymentReminder paymentReminder = payment.getPaymentReminder();

        if (paymentReminder != null) {
          if (ReminderType.EMAIL.equals(
                  paymentReminder.getReminderType())
                && (!ReminderStatus.SENT.equals(paymentReminder.getReminderStatus()))
                && ((reminderDate == null)
                  || ((paymentReminder.getReminderDate() != null)
                    && reminderDate.after(
                      paymentReminder.getReminderDate())))) {
            reminderDate = paymentReminder.getReminderDate();
          }
        }
      }
    }

    return reminderDate;
  } // end method getPaymentEmailReminderDueDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment email reminder due today.
   *
   * @return  Boolean
   */
  public Boolean getPaymentEmailReminderDueToday() {
    Date     now = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(now);

    int yearOfNow       = cal.get(Calendar.YEAR);
    int monthOfNow      = cal.get(Calendar.MONTH);
    int dayOfMonthOfNow = cal.get(Calendar.DAY_OF_MONTH);

    if (payments != null) {
      for (Payment payment : payments) {
        PaymentReminder paymentReminder = payment.getPaymentReminder();

        if (paymentReminder != null) {
          if (ReminderType.EMAIL.equals(
                  paymentReminder.getReminderType()) && (paymentReminder.getReminderDate() != null)) {
            cal.setTime(paymentReminder.getReminderDate());

            int yearOfReminderDate       = cal.get(Calendar.YEAR);
            int monthOfReminderDate      = cal.get(Calendar.MONTH);
            int dayOfMonthOfReminderDate = cal.get(Calendar.DAY_OF_MONTH);

            if ((yearOfNow == yearOfReminderDate) && (monthOfNow == monthOfReminderDate)
                  && (dayOfMonthOfNow == dayOfMonthOfReminderDate)) {
              return Boolean.TRUE;
            }
          }
        }
      }
    }

    return Boolean.FALSE;
  } // end method getPaymentEmailReminderDueToday

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment heading.
   *
   * @param   tableStyle      String
   * @param   tableDataStyle  String
   *
   * @return  String
   */
  public String getPaymentHeading(String tableStyle, String tableDataStyle) {
    StringBuffer settlementStr = new StringBuffer("");
    settlementStr.append(
      "<table border=\"1\"  style=" + tableStyle + ">");
    settlementStr.append("<tbody>");
    settlementStr.append("<tr>");
    settlementStr.append("<td>");
    settlementStr.append(
      "<div><span style=" + tableDataStyle + ">Name of financial institution</span></div>");
    settlementStr.append("</td>");
    settlementStr.append("<td>");
    settlementStr.append(
      "<div><span style=" + tableDataStyle + ">Account name</span></div>");
    settlementStr.append("</td>");
    settlementStr.append("<td>");
    settlementStr.append(
      "<div><span style=" + tableDataStyle + ">BSB</span></div>");
    settlementStr.append("</td>");
    settlementStr.append("<td>");
    settlementStr.append(
      "<div><span style=" + tableDataStyle + ">Account number</span></div>");
    settlementStr.append("</td>");
    settlementStr.append("<td>");
    settlementStr.append(
      "<div><span style=" + tableDataStyle + ">Amount</span></div>");
    settlementStr.append("</td>");
    settlementStr.append("<td>");
    settlementStr.append(
      "<div><span style=" + tableDataStyle + ">Date</span></div>");
    settlementStr.append("</td>");
    settlementStr.append("</tr>");

    return settlementStr.toString();
  } // end method getPaymentHeading

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment program.
   *
   * @return  PaymentProgram
   */
  public PaymentProgram getPaymentProgram() {
    return paymentProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payments.
   *
   * @return  Set
   */
  public Set<Payment> getPayments() {
    return this.payments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payments has no letter notification.
   *
   * @param   paymentsWithInDates  Set
   * @param   templateName         String
   *
   * @return  Set
   */
  public Set<Payment> getPaymentsHasNoLetterNotification(Set<Payment> paymentsWithInDates, String templateName) {
    Set<Payment> paymentsNoNotification = new LinkedHashSet<Payment>();

    for (Payment payment : paymentsWithInDates) {
      if (!hasPaymentLetterNotificationSent(templateName, payment)) {
        paymentsNoNotification.add(payment);
      }
    }

    return paymentsNoNotification;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment SMSReminder due date.
   *
   * @return  Date
   */
  public Date getPaymentSMSReminderDueDate() {
    Date reminderDate = null;

    if (payments != null) {
      for (Payment payment : payments) {
        PaymentReminder paymentReminder = payment.getPaymentReminder();

        if (paymentReminder != null) {
          if (ReminderType.SMS.equals(
                  paymentReminder.getReminderType())
                && (!ReminderStatus.SENT.equals(paymentReminder.getReminderStatus()))
                && ((reminderDate == null)
                  || ((paymentReminder.getReminderDate() != null)
                    && reminderDate.after(
                      paymentReminder.getReminderDate())))) {
            reminderDate = paymentReminder.getReminderDate();
          }
        }
      }
    }

    return reminderDate;
  } // end method getPaymentSMSReminderDueDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment sms reminder due today.
   *
   * @return  Boolean
   */
  public Boolean getPaymentSmsReminderDueToday() {
    Date     now = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(now);

    int yearOfNow       = cal.get(Calendar.YEAR);
    int monthOfNow      = cal.get(Calendar.MONTH);
    int dayOfMonthOfNow = cal.get(Calendar.DAY_OF_MONTH);

    if (payments != null) {
      for (Payment payment : payments) {
        PaymentReminder paymentReminder = payment.getPaymentReminder();

        if (paymentReminder != null) {
          if (ReminderType.SMS.equals(
                  paymentReminder.getReminderType()) && (paymentReminder.getReminderDate() != null)) {
            cal.setTime(paymentReminder.getReminderDate());

            int yearOfReminderDate       = cal.get(Calendar.YEAR);
            int monthOfReminderDate      = cal.get(Calendar.MONTH);
            int dayOfMonthOfReminderDate = cal.get(Calendar.DAY_OF_MONTH);

            if ((yearOfNow == yearOfReminderDate) && (monthOfNow == monthOfReminderDate)
                  && (dayOfMonthOfNow == dayOfMonthOfReminderDate)) {
              return Boolean.TRUE;
            }
          }
        }
      }
    }

    return Boolean.FALSE;
  } // end method getPaymentSmsReminderDueToday

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
   * getter method for phone.
   *
   * @param   typeId  String
   *
   * @return  ContactPhone
   */
  public ContactPhone getPhone(String typeId) {
    return phones.get(typeId);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone.
   *
   * @param   channel  ContactChannel
   *
   * @return  ContactPhone
   */
  public ContactPhone getPhone(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.PHONE.equals(channel.getChannelType())) {
      return phones.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone by type.
   *
   * @param   type  PhoneType
   *
   * @return  ContactPhone
   */
  public ContactPhone getPhoneByType(PhoneType type) {
    return getPhones().get(type.getTypeId().toString());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  /**
   * getter method for phone num.
   *
   * @param   typeId  String
   *
   * @return  String
   */
  public String getPhoneNum(String typeId) {
    ContactPhone phone = getPhone(typeId);

    if ((phone != null) && StringUtils.hasText(phone.getPhoneNum())) {
      return phone.getPhoneNum();
    }

    return null;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the area code from the phone number for the specified phone type.
   *
   * @param   typeId  String
   *
   * @return  The area code from the phone number for the specified phone type
   */
  public String getPhoneNumberAreaCode(String typeId) {
    if (StringUtils.hasText(typeId)) {
      String phoneNumber = getPhoneNum(typeId);

      if (StringUtils.hasText(phoneNumber)) {
        if (phoneNumber.length() == 10) {
          return phoneNumber.substring(0, 3);
        } else if (phoneNumber.length() == 11) {
          return phoneNumber.substring(1, 4);
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the Call Type for the phone number of the specified phone type.
   *
   * @param   typeId  String
   *
   * @return  The Call Type for the phone number of the specified phone type
   */
  public String getPhoneNumberCallType(String typeId) {
    if (StringUtils.hasText(typeId)) {
      ContactPhone phone = getPhone(typeId);

      if ((phone != null) && (phone.getCallType() != null)) {
        return phone.getCallType().getDescription();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone opt out by type.
   *
   * @param   type  String
   *
   * @return  Boolean
   */
  public Boolean getPhoneOptOutByType(String type) {
    ContactPhone contactPhone = phones.get(type);

    if (contactPhone != null) {
      return contactPhone.getOptOut();
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all card holders related to this account.
   *
   * @return  the phones
   */
  public Map<String, ContactPhone> getPhones() {
    return phones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the portfolio description for the responsible account.
   *
   * @return  get the portfolio description for the responsible account
   */
  public String getPortfolioDescription() {
    return account.getPortfolio().getDescription();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all portfolio survey answer relate to responsible.
   *
   * @return  the portfolioSurveyAnswers
   */
  public Set<PortfolioSurveyAnswer> getPortfolioSurveyAnswers() {
    return portfolioSurveyAnswers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio survey answer user saved values.
   *
   * @return  Set
   */
  public Set<PortfolioSurveyAnswerUserSavedValue> getPortfolioSurveyAnswerUserSavedValues() {
    return portfolioSurveyAnswerUserSavedValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get communication preference 6: Home Address
   *
   * @return  the order of the preference
   */
  public Integer getPreferHomeAddress() {
    return this.preferHomeAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get communication preference 1: Home Email
   *
   * @return  the order of the preference
   */
  public Integer getPreferHomeEmail() {
    return this.preferHomeEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get communication preference 4: Home Phone
   *
   * @return  the order of the preference
   */
  public Integer getPreferHomePhone() {
    return this.preferHomePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get communication preference 2: Mobile Phone
   *
   * @return  the order of the preference
   */
  public Integer getPreferMobilePhone() {
    return this.preferMobilePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreferredContactMethod() {
    return preferredContactMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get communication preference 3: Text Message
   *
   * @return  the order of the preference
   */
  public Integer getPreferTextMessage() {
    return this.preferTextMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get communication preference 5: Work Phone
   *
   * @return  the order of the preference
   */
  public Integer getPreferWorkPhone() {
    return this.preferWorkPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * the following methods added by Yan for SLM return file --- START
   */
  /**
   * getter method for previous home address.
   *
   * @return  ContactAddress
   */
  public ContactAddress getPreviousHomeAddress() {
    ContactAddress previousAddress = null;

    if ((historicalAddresses != null) && (historicalAddresses.size() > 0)) {
      for (ContactAddress ca : historicalAddresses) {
        if ((previousAddress == null)
              && ca.getAddressType().getTypeId().toString().equals(
                ContactChannel.HOMEADDRESS.getTypeId().toString())) {
          previousAddress = ca;
        }

        // modified to extidate as we need to pull  the data based on the exit date.
        if ((previousAddress != null)
              && ca.getAddressType().getTypeId().toString().equals(
                ContactChannel.HOMEADDRESS.getTypeId().toString())
              && ca.getExitDate().after(previousAddress.getExitDate())) {
          previousAddress = ca;
        }
      }

      if (previousAddress != null) {
        return previousAddress;
      }
    }

    return null;
  } // end method getPreviousHomeAddress

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous home email str.
   *
   * @return  String
   */
  public String getPreviousHomeEmailStr() {
    ContactEmail previousEmail = null;

    if ((historicalEmails != null) && (historicalEmails.size() > 0)) {
      for (ContactEmail ce : historicalEmails) {
        if ((previousEmail == null)
              && ce.getEmailType().getTypeId().toString().equals(
                ContactChannel.HOMEEMAIL.getTypeId().toString())) {
          previousEmail = ce;
        }

        if ((previousEmail != null)
              && ce.getEmailType().getTypeId().toString().equals(
                ContactChannel.HOMEEMAIL.getTypeId().toString())
              && ce.getExitDate().after(previousEmail.getExitDate())) {
          previousEmail = ce;
        }
      }

      if (previousEmail != null) {
        return previousEmail.getEmailAddress();
      }
    }

    return null;
  } // end method getPreviousHomeEmailStr

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous home phone str.
   *
   * @return  String
   */
  public String getPreviousHomePhoneStr() {
    ContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (ContactPhone ch : historicalPhones) {
        if ((previousPhone == null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.HOMEPHONE.getTypeId().toString())) {
          previousPhone = ch;
        }

        if ((previousPhone != null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.HOMEPHONE.getTypeId().toString())
              && ch.getExitDate().after(previousPhone.getExitDate())) {
          previousPhone = ch;
        }
      }

      if (previousPhone != null) {
        return previousPhone.getPhoneNum();
      }
    }

    return null;
  } // end method getPreviousHomePhoneStr

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous mobile phone str.
   *
   * @return  String
   */
  public String getPreviousMobilePhoneStr() {
    ContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (ContactPhone ch : historicalPhones) {
        if ((previousPhone == null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.MOBILEPHONE.getTypeId().toString())) {
          previousPhone = ch;
        }

        if ((previousPhone != null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.MOBILEPHONE.getTypeId().toString())
              && ch.getExitDate().after(previousPhone.getExitDate())) {
          previousPhone = ch;
        }
      }

      if (previousPhone != null) {
        return previousPhone.getPhoneNum();
      }
    }

    return null;
  } // end method getPreviousMobilePhoneStr

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous other phone str.
   *
   * @return  String
   */
  public String getPreviousOtherPhoneStr() {
    ContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (ContactPhone ch : historicalPhones) {
        if ((previousPhone == null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.OTHERPHONE.getTypeId().toString())) {
          previousPhone = ch;
        }

        if ((previousPhone != null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.OTHERPHONE.getTypeId().toString())
              && ch.getExitDate().after(previousPhone.getExitDate())) {
          previousPhone = ch;
        }
      }

      if (previousPhone != null) {
        return previousPhone.getPhoneNum();
      }
    }

    return null;
  } // end method getPreviousOtherPhoneStr

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous school phone str.
   *
   * @return  String
   */
  public String getPreviousSchoolPhoneStr() {
    ContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (ContactPhone ch : historicalPhones) {
        if ((previousPhone == null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.SCHOOLPHONE.getTypeId().toString())) {
          previousPhone = ch;
        }

        if ((previousPhone != null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.SCHOOLPHONE.getTypeId().toString())
              && ch.getExitDate().after(previousPhone.getExitDate())) {
          previousPhone = ch;
        }
      }

      if (previousPhone != null) {
        return previousPhone.getPhoneNum();
      }
    }

    return null;
  } // the following methods added by Yan for SLM return file --- END

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous sms phone str.
   *
   * @return  String
   */
  public String getPreviousSmsPhoneStr() {
    ContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (ContactPhone ch : historicalPhones) {
        if ((previousPhone == null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.SMSPHONE.getTypeId().toString())) {
          previousPhone = ch;
        }

        if ((previousPhone != null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.SMSPHONE.getTypeId().toString())
              && ch.getExitDate().after(previousPhone.getExitDate())) {
          previousPhone = ch;
        }
      }

      if (previousPhone != null) {
        return previousPhone.getPhoneNum();
      }
    }

    return null;
  } // end method getPreviousSmsPhoneStr

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous work phone str.
   *
   * @return  String
   */
  public String getPreviousWorkPhoneStr() {
    ContactPhone previousPhone = null;

    if ((historicalPhones != null) && (historicalPhones.size() > 0)) {
      for (ContactPhone ch : historicalPhones) {
        if ((previousPhone == null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.WORKPHONE.getTypeId().toString())) {
          previousPhone = ch;
        }

        if ((previousPhone != null)
              && ch.getPhoneType().getTypeId().toString().equals(
                ContactChannel.WORKPHONE.getTypeId().toString())
              && ch.getExitDate().after(previousPhone.getExitDate())) {
          previousPhone = ch;
        }
      }

      if (previousPhone != null) {
        return previousPhone.getPhoneNum();
      }
    }

    return null;
  } // end method getPreviousWorkPhoneStr

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get primaryHolder flag.
   *
   * @return  the primaryHolder
   */
  public Boolean getPrimaryHolder() {
    if (this.primaryHolder == null) {
      return Boolean.FALSE;
    }

    return primaryHolder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get promise by promise id.
   *
   * @param   promiseId  Long
   *
   * @return  get promise by promise id
   */
  public PromiseToPay getPromise(Long promiseId) {
    for (PromiseToPay promise : promises) {
      if (promise.getPromiseId().equals(promiseId)) {
        return promise;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promise.
   *
   * @param   ptpAmount          BigDecimal
   * @param   ptpArrivalDueDate  Date
   *
   * @return  PromiseToPay
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
   * Get all promises relate to responsible.
   *
   * @return  the payments
   */
  public Set<PromiseToPay> getPromises() {
    return promises;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for province.
   *
   * @return  Set
   */
  public Set<String> getProvince() {
    Set<String> provinces = new LinkedHashSet<String>();
    Address     addr      = null;

    for (ContactAddress a : addresses.values()) {
      addr = a.getAddress();

      if ((addr != null) && StringUtils.hasText(addr.getProvince())) {
        provinces.add(addr.getProvince());
      }
    }

    return provinces;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the reason for delinquency.
   *
   * @return  the reasonForDelinquency
   */
  public String getReasonForDelinquency() {
    return reasonForDelinquency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recent open policy.
   *
   * @return  AccountPolicy
   */
  public AccountPolicy getRecentOpenPolicy() {
    if ((responsiblePolicies != null) && (responsiblePolicies.size() > 0)) {
      for (ResponsiblePolicy responsiblePolicyTemp : responsiblePolicies) {
        if (((responsiblePolicyTemp.getAccountPolicy() != null)
                && (responsiblePolicyTemp.getAccountPolicy().getPolicyStatus() != null))
              && responsiblePolicyTemp.getAccountPolicy().getPolicyStatus().equalsIgnoreCase("OPN")) {
          return responsiblePolicyTemp.getAccountPolicy();
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
  public AccountPolicy getRecentPolicy() {
    if ((responsiblePolicies != null) && (responsiblePolicies.size() > 0)) {
      Iterator<ResponsiblePolicy> responsiblePolicyIterator = responsiblePolicies.iterator();

      while (responsiblePolicyIterator.hasNext()) {
        return responsiblePolicyIterator.next().getAccountPolicy();
      }

    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reminder email.
   *
   * @return  ContactEmail
   */
  public ContactEmail getReminderEmail() {
    return getEmail(ContactChannel.REMINDEREMAIL.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  /**
   * getter method for reminder phone.
   *
   * @return  ContactPhone
   */
  public ContactPhone getReminderPhone() {
    return getPhone(ContactChannel.REMINDERPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reminder phone str.
   *
   * @return  String
   */
  public String getReminderPhoneStr() {
    ContactPhone contactPhone = getReminderPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The responsibleConfig.
   *
   * @return  the responsibleConfig
   */
  public ResponsibleConfig getResponsibleConfig() {
    return responsibleConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Relations Responsible HomeEquitySurvey :
   *
   * @return  relations Responsible HomeEquitySurvey :
   */
  public ResponsibleDetail getResponsibleDetail() {
    return responsibleDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ResponsibleExtensionBoolean getResponsibleExtensionBoolean() {
    return responsibleExtensionBoolean;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ResponsibleExtensionChar getResponsibleExtensionChar() {
    return responsibleExtensionChar;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ResponsibleExtensionDate getResponsibleExtensionDate() {
    return responsibleExtensionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ResponsibleExtensionDecimal getResponsibleExtensionDecimal() {
    return responsibleExtensionDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ResponsibleExtensionInteger getResponsibleExtensionInteger() {
    return responsibleExtensionInteger;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get card holder PK.
   *
   * @return  the ResponsibleId
   */
  public Long getResponsibleId() {
    return responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible identification number.
   *
   * @return  String
   */
  public String getResponsibleIdentificationNumber() {
    return responsibleIdentificationNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible index.
   *
   * @return  ResponsibleIndex
   */
  public ResponsibleIndex getResponsibleIndex() {
    return responsibleIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible page visit.
   *
   * @return  ResponsiblePageVisit
   */
  public ResponsiblePageVisit getResponsiblePageVisit() {
    return responsiblePageVisit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible policies.
   *
   * @return  Set
   */
  public Set<ResponsiblePolicy> getResponsiblePolicies() {
    return responsiblePolicies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible portfolio score.
   *
   * @param   portfolioScoreTypeId  Long
   *
   * @return  Integer
   */
  public Integer getResponsiblePortfolioScore(Long portfolioScoreTypeId) {
    for (ResponsiblePortfolioScore score : responsiblePortfolioScores) {
      if (score.getPortfolioScoreType().getPortfolioScoreTypeId().equals(portfolioScoreTypeId)) {
        return score.getScore();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible portfolio scores.
   *
   * @return  Set
   */
  public Set<ResponsiblePortfolioScore> getResponsiblePortfolioScores() {
    return responsiblePortfolioScores;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible scores.
   *
   * @return  Set
   */
  public Set<ResponsibleScore> getResponsibleScores() {
    return responsibleScores;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get specific type of scores based on score type.
   *
   * @param   scoreType  ScoreTypeEnum
   *
   * @return  get specific type of scores based on score type.
   */
  public Set<ResponsibleScore> getResponsibleScores(ScoreTypeEnum scoreType) {
    Set<ResponsibleScore> scores = new LinkedHashSet<ResponsibleScore>();

    for (ResponsibleScore score : this.responsibleScores) {
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
   * Get the revise Date time stamp.
   *
   * @return  the revisedDateTimestamp
   */
  public Date getRevisedDateTimestamp() {
    return revisedDateTimestamp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Right-Party-Contact count.
   *
   * @return  right-Party-Contact count.
   */
  public Integer getRpcCount() {
    return rpcCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for scheduled payments by payment date.
   *
   * @param   schPmtDate  Date
   *
   * @return  Set
   */
  public Set<Payment> getScheduledPaymentsByPaymentDate(Date schPmtDate) {
    Set<Payment> scheduledPayments = new LinkedHashSet<Payment>();

    if (schPmtDate == null) {
      return null;
    }

    for (Payment payment : payments) {
      if (PaymentStatus.SCHEDULED.equals(payment.getPaymentStatus())
            && DateUtils.isSameDay(payment.getPaymentDate(), schPmtDate)) {
        scheduledPayments.add(payment);
      }
    }

    return scheduledPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school phone.
   *
   * @return  ContactPhone
   */
  public ContactPhone getSchoolPhone() {
    return getPhone(ContactChannel.SCHOOLPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for school phone str.
   *
   * @return  String
   */
  public String getSchoolPhoneStr() {
    ContactPhone contactPhone = getSchoolPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for second first name.
   *
   * @return  String
   */
  public String getSecondFirstName() {
    return secondFirstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for second last name.
   *
   * @return  String
   */
  public String getSecondLastName() {
    return secondLastName;
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
   * getter method for sequence num.
   *
   * @return  Integer
   */
  public Integer getSequenceNum() {
    return sequenceNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for service email address.
   *
   * @return  String
   */
  public String getServiceEmailAddress() {
    String       result       = null;
    ContactEmail contactEmail = getEmail(ContactChannel.SERVICEEMAIL.getTypeId().toString());

    if (contactEmail != null) {
      result = contactEmail.getEmailAddress();
    }

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slc loan account num.
   *
   * @param   loanProgramName  String
   *
   * @return  String
   */
  public String getSlcLoanAccountNum(String loanProgramName) {
    for (Loan loan : getLoans()) {
      if (loanProgramName.equalsIgnoreCase(loan.getLoanProgramName())) {
        return loan.getLoanAccountNumber();
      }
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slc loan amount.
   *
   * @param   loanProgramName  String
   *
   * @return  String
   */
  public String getSlcLoanAmount(String loanProgramName) {
    for (Loan loan : getLoans()) {
      if (loanProgramName.equalsIgnoreCase(loan.getLoanProgramName())) {
        return String.valueOf(loan.getCurrentBalance());
      }
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slc servicer address.
   *
   * @param   loanProgramName  String
   *
   * @return  String
   */
  public String getSlcServicerAddress(String loanProgramName) {
    for (Loan loan : getLoans()) {
      if (loanProgramName.equalsIgnoreCase(loan.getLoanProgramName())) {
        return loan.getServicerAddress();
      }
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slc servicer name.
   *
   * @param   loanProgramName  String
   *
   * @return  String
   */
  public String getSlcServicerName(String loanProgramName) {
    for (Loan loan : getLoans()) {
      if (loanProgramName.equalsIgnoreCase(loan.getLoanProgramName())) {
        return loan.getServicerName();
      }
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slc servicer phone num.
   *
   * @param   loanProgramName  String
   *
   * @return  String
   */
  public String getSlcServicerPhoneNum(String loanProgramName) {
    for (Loan loan : getLoans()) {
      if (loanProgramName.equalsIgnoreCase(loan.getLoanProgramName())) {
        return loan.getServicerPhoneNum();
      }
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm check loan protected state.
   *
   * @param   in  boolean
   *
   * @return  Boolean
   */
  public Boolean getSlmCheckLoanProtectedState(boolean in) {
    String[] protectedStates = {
      "APPL",
      "ATTY",
      "BNKR",
      "CHOF",
      "DECSD",
      "DEFER",
      "FCLM",
      "FORB",
      "FRD",
      "GRACE",
      "INCAR",
      "INTR",
      "JCLM",
      "LITC",
      "LITD",
      "LITP",
      "LITU",
      "OMBUD",
      "PAID",
      "PAIDAR",
      "PNDDECSD",
      "RCLM",
      "SCHOOL",
      "SCLM",
      "SNB",
      "PTPPFORB",
      "PDPMT",
      "PMT",
      "PTPPFORB",
      "PTPAUTOD",
      "PTPDEFER",
      "PTPFORB",
      "PTPSSTEP",
      "PTPXRPMT",
      "PNDFRD",
      "PNDBNKR",
      "SUPREV",
      "WRKPGM",
      "PTPWRKT",
      "PTPSETL",
      "PTP3PAY",
      "LITO",
      "PTP"
    };

    List<String> states = Arrays.asList(protectedStates);

    if (loans != null) {
      for (Loan loan : loans) {
        if (in) {
          if (states.contains(loan.getArtivaState())) {
            return Boolean.TRUE;
          }
        } else {
          if (!states.contains(loan.getArtivaState())) {
            return Boolean.TRUE;
          }
        }
      }
    }

    return Boolean.FALSE;
  } // end method getSlmCheckLoanProtectedState

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm ffelp loans current montly due amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSlmFfelpLoansCurrentMontlyDueAmount() {
    BigDecimal dueAmount = new BigDecimal(0.0);

    if (loans != null) {
      for (Loan loan : loans) {
        String     category      = loan.getCategory();
        BigDecimal curMonthlyDue = loan.getCurrentMonthlyDueAmount();

        if ("F".equalsIgnoreCase(category) && (curMonthlyDue != null)) {
          dueAmount = dueAmount.add(curMonthlyDue);
        }
      }
    }

    return dueAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has all forbearance months gt60.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasAllForbearanceMonthsGt60() {
    if (CollectionUtils.isEmpty(loans)) {
      return Boolean.FALSE;
    }

    for (Loan loan : loans) {
      Long monthsUsed = loan.getForbearanceMonthsUsed();

      if ((monthsUsed == null) || (monthsUsed <= 60L)) {
        return Boolean.FALSE;
      }
    }

    return Boolean.TRUE;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has clearing house indicator.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasClearingHouseIndicator() {
    if (account != null) {
      SlmSchoolStatus schoolStatus = account.getAccountDetail().getSlmSchoolStatus();

      if (schoolStatus != null) {
        return schoolStatus.getSchoolClearinghouseIndicator();
      }
    }

    return Boolean.FALSE;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has delq private.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasDelqPrivate() {
    if (nonChargedOffLoans != null) {
      for (Loan loan : nonChargedOffLoans) {
        if ("PRIVATE".equalsIgnoreCase(loan.getLoanProgramName())
              && (loan.getDelinquencyDate() != null)) {
          return Boolean.TRUE;
        }

      }
    }

    return Boolean.FALSE;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has delq smart option.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasDelqSmartOption() {
    if (nonChargedOffLoans != null) {
      for (Loan loan : nonChargedOffLoans) {
        if ("SMART OPTION".equalsIgnoreCase(
                loan.getLoanProgramName())
              && (loan.getDelinquencyDate() != null)) {
          return Boolean.TRUE;
        }

      }
    }

    return Boolean.FALSE;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has has delq due16 31.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasHasDelqDue16_31() {
    if (nonChargedOffLoans != null) {
      for (Loan loan : nonChargedOffLoans) {
        Date dueDate = loan.getNextPayDueDate();

        if (dueDate != null) {
          Calendar cal = new GregorianCalendar();
          cal.setTime(dueDate);

          int monthDay = cal.get(Calendar.DAY_OF_MONTH);

          if ((monthDay >= 16) && (monthDay <= 31)) {
            return Boolean.TRUE;
          }
        }

      }
    }

    return Boolean.FALSE;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has has delq due1 15.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasHasDelqDue1_15() {
    if (nonChargedOffLoans != null) {
      for (Loan loan : nonChargedOffLoans) {
        Date dueDate = loan.getNextPayDueDate();

        if (dueDate != null) {
          Calendar cal = new GregorianCalendar();
          cal.setTime(dueDate);

          int monthDay = cal.get(Calendar.DAY_OF_MONTH);

          if ((monthDay >= 1) && (monthDay <= 15)) {
            return Boolean.TRUE;
          }
        }

      }
    }

    return Boolean.FALSE;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has loan in protected state.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasLoanInProtectedState() {
    return getSlmCheckLoanProtectedState(true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has loan name.
   *
   * @param   programName  String
   *
   * @return  Boolean
   */
  public Boolean getSlmHasLoanName(String programName) {
    if (loans != null) {
      for (Loan loan : loans) {
        if (programName == null) {
          if (loan.getLoanProgramName() == null) {
            return Boolean.TRUE;
          }
        } else {
          if (programName.equalsIgnoreCase(
                  loan.getLoanProgramName())) {
            return Boolean.TRUE;
          }
        }
      }
    }

    return Boolean.FALSE;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has loan not in protected state.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasLoanNotInProtectedState() {
    return getSlmCheckLoanProtectedState(false);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has no plus loans.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasNoPlusLoans() {
    if (CollectionUtils.isEmpty(loans)) {
      return Boolean.TRUE;
    }

    for (Loan loan : loans) {
      String programeName = loan.getLoanProgramName();

      if ("PARENT PLUS".equalsIgnoreCase(programeName)
            || "GRADUATE PLUS".equalsIgnoreCase(programeName)) {
        return Boolean.FALSE;
      }
    }

    return Boolean.TRUE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has only plus loans.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasOnlyPlusLoans() {
    if (CollectionUtils.isEmpty(loans)) {
      return Boolean.FALSE;
    }

    for (Loan loan : loans) {
      String programeName = loan.getLoanProgramName();

      if (!"PARENT PLUS".equalsIgnoreCase(programeName)
            && !"GRADUATE PLUS".equalsIgnoreCase(programeName)) {
        return Boolean.FALSE;
      }
    }

    return Boolean.TRUE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has private.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasPrivate() {
    return getSlmHasLoanName("PRIVATE");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has smart option.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasSmartOption() {
    return getSlmHasLoanName("SMART OPTION");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm has some forbearance months gt60.
   *
   * @return  Boolean
   */
  public Boolean getSlmHasSomeForbearanceMonthsGt60() {
    if (loans != null) {
      for (Loan loan : loans) {
        Long monthsUsed = loan.getForbearanceMonthsUsed();

        if ((monthsUsed != null) && (monthsUsed > 60L)) {
          return Boolean.TRUE;
        }
      }
    }

    return Boolean.FALSE;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm sum of private.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSlmSumOfPrivate() {
    BigDecimal sum = BigDecimal.ZERO;

    if (loans != null) {
      for (Loan loan : loans) {
        if ("PRIVATE".equalsIgnoreCase(loan.getLoanProgramName())) {
          sum = sum.add(loan.getCurrentBalance());
        }
      }

    }

    return sum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm sum of smart option.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSlmSumOfSmartOption() {
    BigDecimal sum = BigDecimal.ZERO;

    if (loans != null) {
      for (Loan loan : loans) {
        if ("SMART OPTION".equalsIgnoreCase(
                loan.getLoanProgramName())) {
          sum = sum.add(loan.getCurrentBalance());
        }
      }
    }

    return sum;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms acceptance date.
   *
   * @return  Date
   */
  public Date getSmsAcceptanceDate() {
    return smsAcceptanceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The smsChannelResults.
   *
   * @return  the smsChannelResults
   */
  public Set<SmsChannelResult> getSmsChannelResults() {
    return smsChannelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  SMSPhone
   */
  public ContactPhone getSMSPhone() {
    return getPhone(ContactChannel.SMSPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get sms phone number string, return empty string if there is no such number.
   *
   * @return  get sms phone number string, return empty string if there is no such number
   */
  public String getSMSPhoneStr() {
    ContactPhone contactPhone = getSMSPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ssn.
   *
   * @return  String
   */
  public String getSsn() {
    return ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the last 4 of SSN.
   *
   * @return  get the last 4 of SSN
   */
  public String getSsnLast4() {
    return getLast4Ssn();

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all survey answer relate to responsible.
   *
   * @return  the surveyAnswers
   */
  public Set<SurveyAnswer> getSurveyAnswers() {
    return surveyAnswers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey round.
   *
   * @return  Integer
   */
  public Integer getSurveyRound() {
    return surveyRound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temp answer.
   *
   * @param   questionCode  String
   *
   * @return  PortfolioSurveyAnswer
   */
  public PortfolioSurveyAnswer getTempAnswer(String questionCode) {
    return this.tempAnswers.get(questionCode);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary address.
   *
   * @param   channel  ContactChannel
   *
   * @return  TemporaryContactAddress
   */
  public TemporaryContactAddress getTemporaryAddress(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.ADDRESS.equals(channel.getChannelType())) {
      return temporaryAddresses.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary address.
   *
   * @param   type  String
   *
   * @return  TemporaryContactAddress
   */
  public TemporaryContactAddress getTemporaryAddress(String type) {
    return temporaryAddresses.get(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary addresses.
   *
   * @return  Map
   */
  public Map<String, TemporaryContactAddress> getTemporaryAddresses() {
    return temporaryAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary city.
   *
   * @return  Set
   */
  public Set<String> getTemporaryCity() {
    Set<String> cities = new LinkedHashSet<String>();
    Address     addr   = null;

    for (TemporaryContactAddress a : temporaryAddresses.values()) {
      addr = a.getAddress();

      if ((addr != null) && StringUtils.hasText(addr.getCity())) {
        cities.add(addr.getCity());
      }
    }

    return cities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary historical addresses.
   *
   * @return  Set
   */
  public Set<TemporaryContactAddress> getTemporaryHistoricalAddresses() {
    return temporaryHistoricalAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary historical phones.
   *
   * @return  Set
   */
  public Set<TemporaryContactPhone> getTemporaryHistoricalPhones() {
    return temporaryHistoricalPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary phone.
   *
   * @param   channel  ContactChannel
   *
   * @return  TemporaryContactPhone
   */
  public TemporaryContactPhone getTemporaryPhone(ContactChannel channel) {
    if (channel == null) {
      return null;
    }

    if (ContactChannelType.PHONE.equals(channel.getChannelType())) {
      return temporaryPhones.get(channel.getStringTypeId());
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary phone.
   *
   * @param   typeId  String
   *
   * @return  TemporaryContactPhone
   */
  public TemporaryContactPhone getTemporaryPhone(String typeId) {
    return temporaryPhones.get(typeId);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary phone num.
   *
   * @param   typeId  String
   *
   * @return  String
   */
  public String getTemporaryPhoneNum(String typeId) {
    TemporaryContactPhone phone = getTemporaryPhone(typeId);

    if ((phone != null) && StringUtils.hasText(phone.getPhoneNum())) {
      return phone.getPhoneNum();
    }

    return null;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary phones.
   *
   * @return  Map
   */
  public Map<String, TemporaryContactPhone> getTemporaryPhones() {
    return temporaryPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temporary province.
   *
   * @return  Set
   */
  public Set<String> getTemporaryProvince() {
    Set<String> provinces = new LinkedHashSet<String>();
    Address     addr      = null;

    for (TemporaryContactAddress a : temporaryAddresses.values()) {
      addr = a.getAddress();

      if ((addr != null) && StringUtils.hasText(addr.getProvince())) {
        provinces.add(addr.getProvince());
      }
    }

    return provinces;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term acceptance date.
   *
   * @return  Date
   */
  public Date getTermAcceptanceDate() {
    return termAcceptanceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get time zone.
   *
   * @return  the timezone
   */
  public String getTimezone() {
    return timezone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Title of this person.
   *
   * @return  title of this person
   */
  public String getTitle() {
    return title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total home phone dialer vendor results.
   *
   * @param   startDate  Date
   * @param   pastDays   int
   *
   * @return  Integer
   */
  public Integer getTotalHomePhoneDialerVendorResults(Date startDate, int pastDays) {
    ContactPhone phone       = getHomePhone();
    Integer      returnValue = 0;

    if (phone != null) {
      Set<DialerAudit> dialerAudits = phone.getDialerAudits();

      if ((dialerAudits != null) && (dialerAudits.size() > 0)) {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -pastDays);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date endDate = calendar.getTime();
        log.info("startDate.." + startDate);
        log.info("endDate.." + endDate);
        log.info("pastDay: " + pastDays);

        for (DialerAudit dialerAudit : dialerAudits) {
          Date createDate = dialerAudit.getCreateDate();
          log.info("createDate.." + createDate);

          if (createDate.after(endDate) && createDate.before(startDate)) {
            log.info("found adding..");
            returnValue++;
          } else if (createDate.before(endDate)) {
            log.info("records are past end date break..");

            break;
          }
        }
      } else {
        log.info("dialer audits are null..");
      } // end if-else
    } else {
      log.info("phone is null..");
    }   // end if-else

    return returnValue;
  } // end method getTotalHomePhoneDialerVendorResults

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get total annual house hold income.
   *
   * @return  the totalHouseholdIncome
   */
  public BigDecimal getTotalHouseholdIncome() {
    return totalHouseholdIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total subsidized loan.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalSubsidizedLoan() {
    double totalSubsidizedLoan = 0.0;

    String  loanBranchId    = null;
    Integer loanBranchIdInt = null;

    if (getLoans() != null) {
      for (Loan loan : getLoans()) {
        loanBranchId = loan.getLenderBranchID();

        if (StringUtils.hasText(loanBranchId)) {
          loanBranchIdInt = Integer.valueOf(loanBranchId);

          if ((loan.getCurrentBalance() != null)
                && ((loanBranchIdInt < 4999)
                  || ((loanBranchIdInt > 6000)
                    && (loanBranchIdInt < 9999)))) {
            totalSubsidizedLoan += loan.getCurrentBalance().doubleValue();
          }
        }
      }
    }

    return new BigDecimal(totalSubsidizedLoan);
  } // end method getTotalSubsidizedLoan

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total un subsidized loan.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalUnSubsidizedLoan() {
    double totalUnSubsidizedLoan = 0.0;

    String  loanBranchId    = null;
    Integer loanBranchIdInt = null;

    if (getLoans() != null) {
      for (Loan loan : getLoans()) {
        loanBranchId = loan.getLenderBranchID();

        if (StringUtils.hasText(loanBranchId)) {
          loanBranchIdInt = Integer.valueOf(loanBranchId);

          if ((loan.getCurrentBalance() != null)
                && ((loanBranchIdInt >= 4999)
                  && (loanBranchIdInt <= 6000))) {
            totalUnSubsidizedLoan += loan.getCurrentBalance().doubleValue();
          }
        }
      }
    }

    return new BigDecimal(totalUnSubsidizedLoan);
  } // end method getTotalUnSubsidizedLoan

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys attorneys.
   *
   * @return  Set
   */
  public Set<TsysAttorney> getTsysAttorneys() {
    return tsysAttorneys;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys bankruptcies.
   *
   * @return  Set
   */
  public Set<TsysBankruptcy> getTsysBankruptcies() {
    return this.tsysBankruptcies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys customer id.
   *
   * @return  String
   */
  public String getTsysCustomerId() {
    if (getResponsibleDetail() != null) {
      return getResponsibleDetail().getClientReferenceId();
    }

    return org.apache.commons.lang3.StringUtils.EMPTY;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys deceased.
   *
   * @return  TsysDeceased
   */
  public TsysDeceased getTsysDeceased() {
    return tsysDeceased;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys judgements.
   *
   * @return  Set
   */
  public Set<TsysJudgement> getTsysJudgements() {
    return this.tsysJudgements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user logon.
   *
   * @return  String
   */
  public String getUserLogon() {
    return userLogon;
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
   * How many times we have left voice message.
   *
   * @return  how many times we have left voice message
   */
  public Integer getVoiceMailCount() {
    return voiceMailActivities.size();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all web activities relate to responsible.
   *
   * @return  the webactivities
   */
  public Set<WebActivity> getWebActivities() {
    return webActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web payments.
   *
   * @return  Set
   */
  public Set<Payment> getWebPayments() {
    return webPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web payments status.
   *
   * @param   searchDate  Date
   *
   * @return  Boolean
   */
  public Boolean getWebPaymentsStatus(Date searchDate) {
    if (null != webPayments) {
      for (Payment payment : webPayments) {
        if ("BankAccount".equalsIgnoreCase(payment.getFundingInformation().getType())
              && (DateUtil.toDateOnly(payment.getLastUpdateDate()).compareTo(searchDate) == 0)) {
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
   * @param   tableStyle      String
   * @param   tableDataStyle  String
   * @param   searchDate      Date
   *
   * @return  DOCUMENT ME!
   */
  public String getWebPaymentsTable(String tableStyle, String tableDataStyle, Date searchDate) {
    StringBuffer settlementStr = new StringBuffer("");

    Payment latestPayment = null;

    if (webPayments != null) {
      settlementStr.append(getPaymentHeading(tableStyle, tableDataStyle));

      for (Payment payment : webPayments) {
        if ("BankAccount".equalsIgnoreCase(payment.getFundingInformation().getType())
              && (DateUtil.toDateOnly(payment.getLastUpdateDate()).compareTo(searchDate) == 0)) {
          latestPayment = payment;

          if (latestPayment != null) {
            settlementStr.append("<tr>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(latestPayment.getFundingInformation().getNickName());
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(latestPayment.getFundingInformation().getHolderFullName());
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(latestPayment.getFundingInformation().getRoutingNumber());
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(FormatUtil.maskAccountNumber(
                latestPayment.getFundingInformation().getFundingAccountNum(), 3));
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(FormatUtil.currencyFormat(latestPayment.getAmount()));
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("<td>");
            settlementStr.append(
              "<div><span style=" + tableDataStyle + ">");

            settlementStr.append(new SimpleDateFormat("dd/MM/yyyy").format(latestPayment.getPaymentDate()));
            settlementStr.append("</span></div>");
            settlementStr.append("</td>");
            settlementStr.append("</tr>");
          } // end if
        }   // end if

      } // end for

      settlementStr.append("</tbody>");
      settlementStr.append("</table>");
    } // end if

    return settlementStr.toString();
  } // end method getWebPaymentsTable

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web update address.
   *
   * @return  Set
   */
  public Set<ContactAddress> getWebUpdateAddress() {
    return webUpdateAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web update emails.
   *
   * @return  Set
   */
  public Set<ContactEmail> getWebUpdateEmails() {
    return webUpdateEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web update phones.
   *
   * @return  Set
   */
  public Set<ContactPhone> getWebUpdatePhones() {
    return webUpdatePhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  WorkAddress
   */
  public ContactAddress getWorkAddress() {
    return getAddress(ContactChannel.WORKADDRESS.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  WorkEmail
   */
  public ContactEmail getWorkEmail() {
    return getEmail(ContactChannel.WORKEMAIL.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get work email string, return empty string if there is no such email.
   *
   * @return  get work email string, return empty string if there is no such email
   */
  public String getWorkEmailStr() {
    ContactEmail contactEmail = getWorkEmail();

    if (contactEmail != null) {
      return contactEmail.getEmailAddress();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Convenient method.
   *
   * @return  WorkPhone
   */
  public ContactPhone getWorkPhone() {
    return getPhone(ContactChannel.WORKPHONE.getStringTypeId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get work phone number string, return empty string if there is no such number.
   *
   * @return  get work phone number string, return empty string if there is no such number
   */
  public String getWorkPhoneStr() {
    ContactPhone contactPhone = getWorkPhone();

    if (contactPhone != null) {
      return contactPhone.getPhoneNum();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The zipCode.
   *
   * @return  the zipCode
   */
  public String getZipCode() {
    return zipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasBBLReminder.
   *
   * @return  Boolean
   */
  public Boolean hasBBLReminder() {
    String optInValue = this.getResponsibleDetail().getClientDefined5CharCode1();

    if ("Email".equalsIgnoreCase(optInValue) || "SMS".equalsIgnoreCase(optInValue)) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasCalledIn.
   *
   * @return  boolean
   */
  public boolean hasCalledIn() {
    initCount();

    return (ivrInboundCount > 0) || (directCallCount > 0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasClientRejectedPayments.
   *
   * @return  Boolean
   */
  public Boolean hasClientRejectedPayments() {
    for (Payment payment : CollectionUtil.safeSet(payments)) {
      if (PaymentStatus.REJECTED.equals(payment.getPaymentStatus())
            && PaymentChannel.CLIENT.equals(payment.getPaymentChannel())) {
        return Boolean.TRUE;
      }
    }


    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  /**
   * hasCMCRejectedPayments.
   *
   * @return  Boolean
   */
  public Boolean hasCMCRejectedPayments() {
    for (Payment payment : CollectionUtil.safeSet(payments)) {
      if (PaymentStatus.REJECTED.equals(payment.getPaymentStatus())
            && !PaymentChannel.CLIENT.equals(payment.getPaymentChannel())) {
        return Boolean.TRUE;
      }
    }


    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns True if there exist a contact phone for the responsible.
   *
   * @param   typeId  String
   *
   * @return  Returns True if there exist a contact phone for the responsible
   */
  public Boolean hasContactPhone(String typeId) {
    if (StringUtils.hasText(typeId)) {
      ContactPhone phone = getPhone(typeId);

      if (phone != null) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns True if there exist a Future Permanent contact phone for the responsible.
   *
   * @param   typeId  String
   *
   * @return  Returns True if there exist a contact phone for the responsible
   */
  public Boolean hasFuturePermanentContactPhone(String typeId) {
    if (StringUtils.hasText(typeId)) {
      FuturePermanentContactPhone phone = getFuturePermanentPhone(typeId);

      if (phone != null) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
    result = (prime * result)
      + ((firstName == null) ? 0 : firstName.hashCode());
    result = (prime * result) + ((gender == null) ? 0 : gender.hashCode());
    result = (prime * result)
      + ((lastName == null) ? 0 : lastName.hashCode());
    result = (prime * result) + ((ssn == null) ? 0 : ssn.hashCode());
    result = (prime * result) + ((userLogon == null) ? 0 : userLogon.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasPaymentLetterNotificationSent.
   *
   * @param   templateName  String
   * @param   payment       Payment
   *
   * @return  boolean
   */
  public boolean hasPaymentLetterNotificationSent(String templateName, Payment payment) {
    for (LetterChannelActualResult lcar : letterChannelActualResults) {
      if ((lcar.getPayment() != null) && (StringUtils.hasText(lcar.getTemplate()))
            && (templateName.equalsIgnoreCase(lcar.getTemplate()))
            && (payment.getPaymentId().equals(lcar.getPayment().getPaymentId()))) {
        return true;
      }

    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns True if there exist a Temporary contact phone for the responsible.
   *
   * @param   typeId  String
   *
   * @return  Returns True if there exist a contact phone for the responsible
   */
  public Boolean hasTemporaryContactPhone(String typeId) {
    if (StringUtils.hasText(typeId)) {
      TemporaryContactPhone phone = getTemporaryPhone(typeId);

      if (phone != null) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase debtor direct callin count.
   *
   * @return  increase debtor direct callin count.
   */
  public Integer increaseDirectCallCount() {
    initCount();

    return directCallCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase debtor ivr inbound count.
   *
   * @return  increase debtor ivr inbound count.
   */
  public Integer increaseIvrInboundCount() {
    initCount();

    return ivrInboundCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase right-party-contact count.
   *
   * @return  increase right-party-contact count.
   */
  public Integer increaseRpcCount() {
    initCount();

    return rpcCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Whether this person is bankrupt or not.
   *
   * @return  whether this person is bankrupt or not.
   */
  public boolean isBankrupt() {
    return bankruptcy != null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The zipCodeChanged.
   *
   * @return  the zipCodeChanged
   */
  public boolean isZipCodeChanged() {
    return this.zipCodeChanged;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for zip required full.
   *
   * @return  boolean
   */
  public boolean isZipRequiredFull() {
    return isZipRequiredFull;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupHistoricalAddress.
   *
   * @param   address  ContactAddress
   *
   * @return  ContactAddress
   */
  public ContactAddress lookupHistoricalAddress(ContactAddress address) {
    for (ContactAddress a : this.historicalAddresses) {
      if (a.equals(address)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupHistoricalAddress.
   *
   * @param   address  TemporaryContactAddress
   *
   * @return  TemporaryContactAddress
   */
  public TemporaryContactAddress lookupHistoricalAddress(TemporaryContactAddress address) {
    for (TemporaryContactAddress a : this.temporaryHistoricalAddresses) {
      if (a.equals(address)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupHistoricalAddress.
   *
   * @param   address  FuturePermanentContactAddress
   *
   * @return  FuturePermanentContactAddress
   */
  public FuturePermanentContactAddress lookupHistoricalAddress(FuturePermanentContactAddress address) {
    for (FuturePermanentContactAddress a : this.futurePermanentHistoricalAddresses) {
      if (a.equals(address)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupHistoricalEmail.
   *
   * @param   email  ContactEmail
   *
   * @return  ContactEmail
   */
  public ContactEmail lookupHistoricalEmail(ContactEmail email) {
    for (ContactEmail a : this.historicalEmails) {
      if (a.equals(email)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupHistoricalPhone.
   *
   * @param   phone  ContactPhone
   *
   * @return  ContactPhone
   */
  public ContactPhone lookupHistoricalPhone(ContactPhone phone) {
    for (ContactPhone a : this.historicalPhones) {
      if (a.equals(phone)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupHistoricalPhone.
   *
   * @param   phone  TemporaryContactPhone
   *
   * @return  TemporaryContactPhone
   */
  public TemporaryContactPhone lookupHistoricalPhone(TemporaryContactPhone phone) {
    for (TemporaryContactPhone a : this.temporaryHistoricalPhones) {
      if (a.equals(phone)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupHistoricalPhone.
   *
   * @param   phone  FuturePermanentContactPhone
   *
   * @return  FuturePermanentContactPhone
   */
  public FuturePermanentContactPhone lookupHistoricalPhone(FuturePermanentContactPhone phone) {
    for (FuturePermanentContactPhone a : this.futurePermanentHistoricalPhones) {
      if (a.equals(phone)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * markDoNotContactPhoneNum.
   *
   * @param   phoneNum           String
   * @param   doNotContactUntil  Date
   * @param   reason             DoNotContactReason
   * @param   reasonId           String
   *
   * @return  boolean
   */
  public boolean markDoNotContactPhoneNum(String phoneNum, Date doNotContactUntil, DoNotContactReason reason,
    String reasonId) {
    if (phoneNum == null) {
      return false;
    }

    for (ContactPhone phone : phones.values()) {
      if (phoneNum.equalsIgnoreCase(phone.getPhoneNum())) {
        return Boolean.TRUE.equals(phone.markDoNotContact(
              doNotContactUntil, reason, reasonId));
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Mark all Contact Phones having the given phonenumber for this responsible as Bad Phone number.
   *
   * @param  phoneNum  String
   */
  public void markPhoneNumBad(String phoneNum) {
    markPhoneNum(phoneNum, ContactStatus.BAD);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Mark all Contact Phones having the given phonenumber for this responsible as Verified Phone number.
   *
   * @param  phoneNum  String
   */
  public void markPhoneNumVerified(String phoneNum) {
    Set<ContactPhone> ps = getContactPhonesbyPhoneNum(phoneNum);

    if ((ps != null) && (ps.size() > 0)) {
      for (ContactPhone p : ps) {
        p.setStatus(ContactStatus.VERIFIED);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Mark all Contact Phones having the given phonenumber for this responsible as Bad Phone number.
   *
   * @param  phoneNum  String
   */
  public void markPhoneNumWrong(String phoneNum) {
    markPhoneNum(phoneNum, ContactStatus.WRONG);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove address.
   *
   * @param   address  type
   *
   * @return  remove address
   */
  public boolean removeAddress(ContactAddress address) {
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false; // no update happened
    }

    ContactAddress curAddress = addresses.remove(address.getAddressType().getTypeId().toString());

    if (curAddress != null) {
      curAddress.setHistorical(true);
      curAddress.setExitDate(new Date());
      historicalAddresses.add(curAddress);
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove emailAddress.
   *
   * @param   email  ContactEmail
   *
   * @return  remove emailAddress
   */
  public boolean removeEmail(ContactEmail email) {
    if ((email == null) || (email.getEmailType() == null)
          || (email.getEmailType().getTypeId() == null)) {
      return false; // no update happened
    }

    ContactEmail curEmail = emails.remove(email.getEmailType().getTypeId().toString());

    if (curEmail != null) {
      curEmail.setHistorical(true);
      curEmail.setExitDate(new Date());
      historicalEmails.add(curEmail);
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove funding account.
   *
   * @param   fundingAccountId  DOCUMENT ME!
   *
   * @return  remove funding account.
   */
  public String removeFundingAccount(Long fundingAccountId) {
    log.info("removeFundingAccount fundingAccountId:" + fundingAccountId);

    String                   nickName = null;
    Iterator<FundingAccount> it       = getFundingAccounts().iterator();

    while (it.hasNext()) {
      FundingAccount fundingAccount = it.next();

      if (fundingAccount.getFundingAccountId().equals(fundingAccountId)) {
        log.info("get nickName for funding account..");
        nickName = (fundingAccount.getFundingInformation() == null)
          ? null : fundingAccount.getFundingInformation().getNickName();
        log.info("nickName:" + nickName);
        it.remove();

        break;
      }
    }

    return nickName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove funding account.
   *
   * @param   fundingAccountId  String
   *
   * @return  remove funding account.
   */
  public String removeFundingAccount(String fundingAccountId) {
    return removeFundingAccount(new Long(fundingAccountId));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove phone.
   *
   * @param   phone  ContactPhone
   *
   * @return  remove phone
   */
  public boolean removePhone(ContactPhone phone) {
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false; // no update happened
    }

    ContactPhone curPhone = phones.remove(phone.getPhoneType().getTypeId().toString());

    if (curPhone != null) {
      curPhone.setHistorical(true);
      curPhone.setExitDate(new Date());
      historicalPhones.add(curPhone);
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * resetLoginFailureCount.
   */
  public void resetLoginFailureCount() {
    this.loginFailureCount = 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accepted payment programs.
   *
   * @param  acceptedPaymentPrograms  Set
   */
  public void setAcceptedPaymentPrograms(Set<PaymentProgram> acceptedPaymentPrograms) {
    this.acceptedPaymentPrograms = acceptedPaymentPrograms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the account which relate to this card holder.
   *
   * @param  account  the account to set
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for addresses.
   *
   * @param  addresses  Map
   */
  public void setAddresses(Map<String, ContactAddress> addresses) {
    this.addresses = addresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent call activities.
   *
   * @param  agentCallActivities  Set
   */
  public void setAgentCallActivities(Set<AgentCallActivity> agentCallActivities) {
    this.agentCallActivities = agentCallActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for appointments.
   *
   * @param  advisorAppointments  Set
   */
  public void setAppointments(Set<AdvisorAppointment> advisorAppointments) {
    this.appointments = advisorAppointments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the assets.
   *
   * @param  assets  the assets to set
   */
  public void setAssets(BigDecimal assets) {
    this.assets = assets;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for attorney.
   *
   * @param  attorney  Attorney
   */
  public void setAttorney(Attorney attorney) {
    this.attorney = attorney;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bankruptcy.
   *
   * @param  bankruptcy  Bankruptcy
   */
  public void setBankruptcy(Bankruptcy bankruptcy) {
    this.bankruptcy = bankruptcy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bankruptInd  DOCUMENT ME!
   */
  public void setBankruptInd(Boolean bankruptInd) {
    this.bankruptInd = bankruptInd;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau score.
   *
   * @param  bureauScore  Integer
   */
  public void setBureauScore(Integer bureauScore) {
    this.bureauScore = bureauScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for confirm letters.
   *
   * @param  confirmLetters  Set
   */
  public void setConfirmLetters(Set<NegotiateConfirmationLetter> confirmLetters) {
    this.confirmLetters = confirmLetters;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set custodial account.
   *
   * @param  custodialAccount  the custodialAccount to set
   */
  public void setCustodialAccount(Boolean custodialAccount) {
    this.custodialAccount = custodialAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer type.
   *
   * @param  customerType  CustomerType
   */
  public void setCustomerType(CustomerType customerType) {
    this.customerType = customerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set date of birth.
   *
   * @param  dateOfBirth  the dateOfBirth to set
   */
  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deceased date.
   *
   * @param  deceasedDate  Date
   */
  public void setDeceasedDate(Date deceasedDate) {
    this.deceasedDate = deceasedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer channel results.
   *
   * @param  dialerChannelResults  Set
   */
  public void setDialerChannelResults(Set<DialerChannelResult> dialerChannelResults) {
    this.dialerChannelResults = dialerChannelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for direct call count.
   *
   * @param  directCallCount  Integer
   */
  public void setDirectCallCount(Integer directCallCount) {
    this.directCallCount = directCallCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document histories.
   *
   * @param  documentHistories  Set
   */
  public void setDocumentHistories(Set<DocumentHistory> documentHistories) {
    this.documentHistories = documentHistories;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for documents.
   *
   * @param  documents  Set
   */
  public void setDocuments(Set<Document> documents) {
    this.documents = documents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email channel results.
   *
   * @param  emailChannelResults  Set
   */
  public void setEmailChannelResults(Set<EmailChannelResult> emailChannelResults) {
    this.emailChannelResults = emailChannelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for emails.
   *
   * @param  emails  Map
   */
  public void setEmails(Map<String, ContactEmail> emails) {
    this.emails = emails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer address.
   *
   * @param  employerAddress  String
   */
  public void setEmployerAddress(String employerAddress) {
    this.employerAddress = employerAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer name.
   *
   * @param  employerName  String
   */
  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for expenses.
   *
   * @param  expenses  Set
   */
  public void setExpenses(Set<Expense> expenses) {
    this.expenses = expenses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the first name.
   *
   * @param  firstName  the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexSitePaymentPrograms  DOCUMENT ME!
   */
  public void setFlexSitePaymentPrograms(Set<PaymentProgram> flexSitePaymentPrograms) {
    this.flexSitePaymentPrograms = flexSitePaymentPrograms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexSitePayments  DOCUMENT ME!
   */
  public void setFlexSitePayments(Set<Payment> flexSitePayments) {
    this.flexSitePayments = flexSitePayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for funding accounts.
   *
   * @param  fundingAccounts  Set
   */
  public void setFundingAccounts(Set<FundingAccount> fundingAccounts) {
    this.fundingAccounts = fundingAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for future permanent addresses.
   *
   * @param  futurePermanentAddresses  Map
   */
  public void setFuturePermanentAddresses(Map<String, FuturePermanentContactAddress> futurePermanentAddresses) {
    this.futurePermanentAddresses = futurePermanentAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for future permanent historical addresses.
   *
   * @param  futurePermanentHistoricalAddresses  Set
   */
  public void setFuturePermanentHistoricalAddresses(
    Set<FuturePermanentContactAddress> futurePermanentHistoricalAddresses) {
    this.futurePermanentHistoricalAddresses = futurePermanentHistoricalAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for future permanent historical phones.
   *
   * @param  futurePermanentHistoricalPhones  Set
   */
  public void setFuturePermanentHistoricalPhones(Set<FuturePermanentContactPhone> futurePermanentHistoricalPhones) {
    this.futurePermanentHistoricalPhones = futurePermanentHistoricalPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for future permanent phones.
   *
   * @param  futurePermanentPhones  Map
   */
  public void setFuturePermanentPhones(Map<String, FuturePermanentContactPhone> futurePermanentPhones) {
    this.futurePermanentPhones = futurePermanentPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the gender.
   *
   * @param  gender  the gender to set
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the flag of guarantor.
   *
   * @param  guarantor  the guarantor to set
   */
  public void setGuarantor(Boolean guarantor) {
    this.guarantor = guarantor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for historical addresses.
   *
   * @param  historicalAddresses  Set
   */
  public void setHistoricalAddresses(Set<ContactAddress> historicalAddresses) {
    this.historicalAddresses = historicalAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for historical emails.
   *
   * @param  historicalEmails  Set
   */
  public void setHistoricalEmails(Set<ContactEmail> historicalEmails) {
    this.historicalEmails = historicalEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for historical phones.
   *
   * @param  historicalPhones  Set
   */
  public void setHistoricalPhones(Set<ContactPhone> historicalPhones) {
    this.historicalPhones = historicalPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for home equity CTMSurveys.
   *
   * @param  homeEquityCTMSurveys  Set
   */
  public void setHomeEquityCTMSurveys(Set<HomeEquityCTMSurvey> homeEquityCTMSurveys) {
    this.homeEquityCTMSurveys = homeEquityCTMSurveys;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for home equity refi surveys.
   *
   * @param  homeEquityRefiSurveys  Set
   */
  public void setHomeEquityRefiSurveys(Set<HomeEquityRefiSurvey> homeEquityRefiSurveys) {
    this.homeEquityRefiSurveys = homeEquityRefiSurveys;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for home equity surveys.
   *
   * @param  homeEquitySurveys  Set
   */
  public void setHomeEquitySurveys(Set<HomeEquitySurvey> homeEquitySurveys) {
    this.homeEquitySurveys = homeEquitySurveys;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the flag of home owner.
   *
   * @param  homeowner  the homeowner to set
   */
  public void setHomeowner(Boolean homeowner) {
    this.homeowner = homeowner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the income.
   *
   * @param  income  the income to set
   */
  public void setIncome(BigDecimal income) {
    this.income = income;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for incomes.
   *
   * @param  incomes  Set
   */
  public void setIncomes(Set<Income> incomes) {
    this.incomes = incomes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr channel results.
   *
   * @param  ivrChannelResults  Set
   */
  public void setIvrChannelResults(Set<IvrChannelResult> ivrChannelResults) {
    this.ivrChannelResults = ivrChannelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr inbound count.
   *
   * @param  ivrInboundCount  Integer
   */
  public void setIvrInboundCount(Integer ivrInboundCount) {
    this.ivrInboundCount = ivrInboundCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last4 ssn.
   *
   * @param  last4Ssn  String
   */
  public void setLast4Ssn(String last4Ssn) {
    this.last4Ssn = last4Ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last contact date.
   *
   * @param  lastContactDate  Date
   */
  public void setLastContactDate(Date lastContactDate) {
    this.lastContactDate = lastContactDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last letter date.
   *
   * @param  lastLetterDate  Date
   */
  public void setLastLetterDate(Date lastLetterDate) {
    this.lastLetterDate = lastLetterDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last letter id.
   *
   * @param  lastLetterId  Long
   */
  public void setLastLetterId(Long lastLetterId) {
    this.lastLetterId = lastLetterId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last login date.
   *
   * @param  lastLoginDate  Date
   */
  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last login failure date.
   *
   * @param  lastLoginFailureDate  Date
   */
  public void setLastLoginFailureDate(Date lastLoginFailureDate) {
    this.lastLoginFailureDate = lastLoginFailureDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the last name.
   *
   * @param  lastName  the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter channel actual results.
   *
   * @param  letterChannelActualResults  Set
   */
  public void setLetterChannelActualResults(Set<LetterChannelActualResult> letterChannelActualResults) {
    this.letterChannelActualResults = letterChannelActualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter channel results.
   *
   * @param  letterChannelResults  Set
   */
  public void setLetterChannelResults(Set<LetterChannelResult> letterChannelResults) {
    this.letterChannelResults = letterChannelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for live chat sessions.
   *
   * @param  liveChatSessions  Set
   */
  public void setLiveChatSessions(Set<LiveChatSession> liveChatSessions) {
    this.liveChatSessions = liveChatSessions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loans.
   *
   * @param  loans  Set
   */
  public void setLoans(Set<Loan> loans) {
    this.loans = loans;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for locale.
   *
   * @param  locale  Locale
   */
  public void setLocale(Locale locale) {
    StringBuilder sb = new StringBuilder();
    sb.append(locale.getLanguage());
    sb.append("_");
    sb.append(locale.getCountry());

    if (StringUtils.hasText(locale.getVariant())) {
      sb.append("_");
      sb.append(locale.getVariant());
    }

    setLocaleString(sb.toString());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for locale string.
   *
   * @param  localeString  String
   */
  public void setLocaleString(String localeString) {
    this.localeString = localeString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for login failure count.
   *
   * @param  loginFailureCount  Integer
   */
  public void setLoginFailureCount(Integer loginFailureCount) {
    this.loginFailureCount = loginFailureCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for match confidence.
   *
   * @param  matchConfidence  String
   */
  public void setMatchConfidence(String matchConfidence) {
    this.matchConfidence = matchConfidence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set middle name.
   *
   * @param  middleName  the middleName to set
   */
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for monthly income.
   *
   * @param  monthlyIncome  BigDecimal
   */
  public void setMonthlyIncome(BigDecimal monthlyIncome) {
    this.monthlyIncome = monthlyIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for monthly payment.
   *
   * @param  monthlyPayment  BigDecimal
   */
  public void setMonthlyPayment(BigDecimal monthlyPayment) {
    this.monthlyPayment = monthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mother maiden name.
   *
   * @param  motherMaidenName  String
   */
  public void setMotherMaidenName(String motherMaidenName) {
    this.motherMaidenName = motherMaidenName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the name suffix.
   *
   * @param  nameSuffix  the nameSuffix to set
   */
  public void setNameSuffix(String nameSuffix) {
    this.nameSuffix = nameSuffix;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nonChargedOffLoans  DOCUMENT ME!
   */
  public void setNonChargedOffLoans(Set<Loan> nonChargedOffLoans) {
    this.nonChargedOffLoans = nonChargedOffLoans;
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
   * setter method for other monthly income.
   *
   * @param  otherMonthlyIncome  BigDecimal
   */
  public void setOtherMonthlyIncome(BigDecimal otherMonthlyIncome) {
    this.otherMonthlyIncome = otherMonthlyIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other monthly payment.
   *
   * @param  otherMonthlyPayment  BigDecimal
   */
  public void setOtherMonthlyPayment(BigDecimal otherMonthlyPayment) {
    this.otherMonthlyPayment = otherMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for password.
   *
   * @param  password  String
   */
  public void setPassword(String password) {
    this.password = password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment program.
   *
   * @param  paymentProgram  PaymentProgram
   */
  public void setPaymentProgram(PaymentProgram paymentProgram) {
    this.paymentProgram = paymentProgram;
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
   * setter method for persona accounts.
   *
   * @param  personaAccounts  Set
   */
  public void setPersonaAccounts(Set<PersonaAccount> personaAccounts) {
    this.personaAccounts = personaAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phones.
   *
   * @param  phones  Map
   */
  public void setPhones(Map<String, ContactPhone> phones) {
    this.phones = phones;
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
   * setter method for portfolio survey answer user saved values.
   *
   * @param  portfolioSurveyAnswerUserSavedValues  Set
   */
  public void setPortfolioSurveyAnswerUserSavedValues(
    Set<PortfolioSurveyAnswerUserSavedValue> portfolioSurveyAnswerUserSavedValues) {
    this.portfolioSurveyAnswerUserSavedValues = portfolioSurveyAnswerUserSavedValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prefer home address.
   *
   * @param  preferHomeAddress  Integer
   */
  public void setPreferHomeAddress(Integer preferHomeAddress) {
    this.preferHomeAddress = preferHomeAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prefer home email.
   *
   * @param  preferHomeEmail  Integer
   */
  public void setPreferHomeEmail(Integer preferHomeEmail) {
    this.preferHomeEmail = preferHomeEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prefer home phone.
   *
   * @param  preferHomePhone  Integer
   */
  public void setPreferHomePhone(Integer preferHomePhone) {
    this.preferHomePhone = preferHomePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prefer mobile phone.
   *
   * @param  preferMobilePhone  Integer
   */
  public void setPreferMobilePhone(Integer preferMobilePhone) {
    this.preferMobilePhone = preferMobilePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preferredContactMethod  DOCUMENT ME!
   */
  public void setPreferredContactMethod(String preferredContactMethod) {
    this.preferredContactMethod = preferredContactMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prefer text message.
   *
   * @param  preferTextMessage  Integer
   */
  public void setPreferTextMessage(Integer preferTextMessage) {
    this.preferTextMessage = preferTextMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prefer work phone.
   *
   * @param  preferWorkPhone  Integer
   */
  public void setPreferWorkPhone(Integer preferWorkPhone) {
    this.preferWorkPhone = preferWorkPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the flag of primaryHolder.
   *
   * @param  primaryHolder  the primaryHolder to set
   */
  public void setPrimaryHolder(Boolean primaryHolder) {
    this.primaryHolder = primaryHolder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for promises.
   *
   * @param  promises  Set
   */
  public void setPromises(Set<PromiseToPay> promises) {
    this.promises = promises;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the reason for delinquency.
   *
   * @param  reasonForDelinquency  the reasonForDelinquency to set
   */
  public void setReasonForDelinquency(String reasonForDelinquency) {
    this.reasonForDelinquency = reasonForDelinquency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible config.
   *
   * @param  responsibleConfig  ResponsibleConfig
   */
  public void setResponsibleConfig(ResponsibleConfig responsibleConfig) {
    this.responsibleConfig = responsibleConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible detail.
   *
   * @param  responsibleDetail  ResponsibleDetail
   */
  public void setResponsibleDetail(ResponsibleDetail responsibleDetail) {
    this.responsibleDetail = responsibleDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsibleExtensionBoolean  DOCUMENT ME!
   */
  public void setResponsibleExtensionBoolean(ResponsibleExtensionBoolean responsibleExtensionBoolean) {
    this.responsibleExtensionBoolean = responsibleExtensionBoolean;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsibleExtensionChar  DOCUMENT ME!
   */
  public void setResponsibleExtensionChar(ResponsibleExtensionChar responsibleExtensionChar) {
    this.responsibleExtensionChar = responsibleExtensionChar;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsibleExtensionDate  DOCUMENT ME!
   */
  public void setResponsibleExtensionDate(ResponsibleExtensionDate responsibleExtensionDate) {
    this.responsibleExtensionDate = responsibleExtensionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsibleExtensionDecimal  DOCUMENT ME!
   */
  public void setResponsibleExtensionDecimal(ResponsibleExtensionDecimal responsibleExtensionDecimal) {
    this.responsibleExtensionDecimal = responsibleExtensionDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsibleExtensionInteger  DOCUMENT ME!
   */
  public void setResponsibleExtensionInteger(ResponsibleExtensionInteger responsibleExtensionInteger) {
    this.responsibleExtensionInteger = responsibleExtensionInteger;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the card holder id.
   *
   * @param  ResponsibleId  the ResponsibleId to set
   */
  public void setResponsibleId(Long ResponsibleId) {
    this.responsibleId = ResponsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible identification number.
   *
   * @param  responsibleIdentificationNumber  String
   */
  public void setResponsibleIdentificationNumber(String responsibleIdentificationNumber) {
    this.responsibleIdentificationNumber = responsibleIdentificationNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible index.
   *
   * @param  responsibleIndex  ResponsibleIndex
   */
  public void setResponsibleIndex(ResponsibleIndex responsibleIndex) {
    this.responsibleIndex = responsibleIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible page visit.
   *
   * @param  responsiblePageVisit  ResponsiblePageVisit
   */
  public void setResponsiblePageVisit(ResponsiblePageVisit responsiblePageVisit) {
    this.responsiblePageVisit = responsiblePageVisit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible policies.
   *
   * @param  responsiblePolicies  Set
   */
  public void setResponsiblePolicies(Set<ResponsiblePolicy> responsiblePolicies) {
    this.responsiblePolicies = responsiblePolicies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible portfolio scores.
   *
   * @param  responsiblePortfolioScores  Set
   */
  public void setResponsiblePortfolioScores(Set<ResponsiblePortfolioScore> responsiblePortfolioScores) {
    this.responsiblePortfolioScores = responsiblePortfolioScores;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible scores.
   *
   * @param  responsibleScores  Set
   */
  public void setResponsibleScores(Set<ResponsibleScore> responsibleScores) {
    this.responsibleScores = responsibleScores;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set revised date time-stamp.
   *
   * @param  revisedDateTimestamp  the revisedDateTimestamp to set
   */
  public void setRevisedDateTimestamp(Date revisedDateTimestamp) {
    this.revisedDateTimestamp = revisedDateTimestamp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rpc count.
   *
   * @param  rpcCount  Integer
   */
  public void setRpcCount(Integer rpcCount) {
    this.rpcCount = rpcCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the second first name.
   *
   * @param  secondFirstName  DOCUMENT ME!
   */
  public void setSecondFirstName(String secondFirstName) {
    this.secondFirstName = secondFirstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the second last name.
   *
   * @param  secondLastName  String
   */
  public void setSecondLastName(String secondLastName) {
    this.secondLastName = secondLastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for second to last login date.
   *
   * @param  secondToLastLoginDate  Date
   */
  public void setSecondToLastLoginDate(Date secondToLastLoginDate) {
    this.secondToLastLoginDate = secondToLastLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for second to last login failure date.
   *
   * @param  secondToLastLoginFailureDate  Date
   */
  public void setSecondToLastLoginFailureDate(Date secondToLastLoginFailureDate) {
    this.secondToLastLoginFailureDate = secondToLastLoginFailureDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sequence num.
   *
   * @param  sequenceNum  Integer
   */
  public void setSequenceNum(Integer sequenceNum) {
    this.sequenceNum = sequenceNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms acceptance date.
   *
   * @param  smsAcceptanceDate  Date
   */
  public void setSmsAcceptanceDate(Date smsAcceptanceDate) {
    this.smsAcceptanceDate = smsAcceptanceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms channel results.
   *
   * @param  smsChannelResults  Set
   */
  public void setSmsChannelResults(Set<SmsChannelResult> smsChannelResults) {
    this.smsChannelResults = smsChannelResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the SSN.
   *
   * @param  ssn  the ssn to set
   */
  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey answers.
   *
   * @param  surveyAnswers  Set
   */
  public void setSurveyAnswers(Set<SurveyAnswer> surveyAnswers) {
    this.surveyAnswers = surveyAnswers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey round.
   *
   * @param  surveyRound  Integer
   */
  public void setSurveyRound(Integer surveyRound) {
    this.surveyRound = surveyRound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for temporary addresses.
   *
   * @param  temporaryAddresses  Map
   */
  public void setTemporaryAddresses(Map<String, TemporaryContactAddress> temporaryAddresses) {
    this.temporaryAddresses = temporaryAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for temporary historical addresses.
   *
   * @param  temporaryHistoricalAddresses  Set
   */
  public void setTemporaryHistoricalAddresses(Set<TemporaryContactAddress> temporaryHistoricalAddresses) {
    this.temporaryHistoricalAddresses = temporaryHistoricalAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for temporary historical phones.
   *
   * @param  temporaryHistoricalPhones  Set
   */
  public void setTemporaryHistoricalPhones(Set<TemporaryContactPhone> temporaryHistoricalPhones) {
    this.temporaryHistoricalPhones = temporaryHistoricalPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for temporary phones.
   *
   * @param  temporaryPhones  Map
   */
  public void setTemporaryPhones(Map<String, TemporaryContactPhone> temporaryPhones) {
    this.temporaryPhones = temporaryPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for term acceptance date.
   *
   * @param  termAcceptanceDate  Date
   */
  public void setTermAcceptanceDate(Date termAcceptanceDate) {
    this.termAcceptanceDate = termAcceptanceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the timezone.
   *
   * @param  timezone  the timezone to set
   */
  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for title.
   *
   * @param  title  String
   */
  public void setTitle(String title) {
    this.title = title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set the total house income.
   *
   * @param  totalHouseholdIncome  the totalHouseholdIncome to set
   */
  public void setTotalHouseholdIncome(BigDecimal totalHouseholdIncome) {
    this.totalHouseholdIncome = totalHouseholdIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys attorneys.
   *
   * @param  tsysAttorneys  Set
   */
  public void setTsysAttorneys(Set<TsysAttorney> tsysAttorneys) {
    this.tsysAttorneys = tsysAttorneys;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys bankruptcies.
   *
   * @param  tsysBankruptcies  Set
   */
  public void setTsysBankruptcies(Set<TsysBankruptcy> tsysBankruptcies) {
    this.tsysBankruptcies = tsysBankruptcies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys deceased.
   *
   * @param  tsysDeceased  TsysDeceased
   */
  public void setTsysDeceased(TsysDeceased tsysDeceased) {
    if (tsysDeceased != null) {
      tsysDeceased.setResponsible(this);
    }

    this.tsysDeceased = tsysDeceased;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys judgements.
   *
   * @param  tsysJudgements  Set
   */
  public void setTsysJudgements(Set<TsysJudgement> tsysJudgements) {
    this.tsysJudgements = tsysJudgements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for UCClient consent date.
   *
   * @param  consentDate  Date
   */
  public void setUCClientConsentDate(Date consentDate) {
    ResponsibleConfig responsibleConfig = this.getResponsibleConfig();

    if (responsibleConfig == null) {
      responsibleConfig = new ResponsibleConfig();
      responsibleConfig.setCreateDate(new Date());
      responsibleConfig.setLastUpdateDate(new Date());
      responsibleConfig.setResponsible(this);
      this.setResponsibleConfig(responsibleConfig);
    }

    responsibleConfig.setClientConsentDate(consentDate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user logon.
   *
   * @param  userLogon  String
   */
  public void setUserLogon(String userLogon) {
    this.userLogon = userLogon;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for voice mail activities.
   *
   * @param  voiceMailActivities  Set
   */
  public void setVoiceMailActivities(Set<VoiceMailActivity> voiceMailActivities) {
    this.voiceMailActivities = voiceMailActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web activities.
   *
   * @param  webActivities  Set
   */
  public void setWebActivities(Set<WebActivity> webActivities) {
    this.webActivities = webActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web payments.
   *
   * @param  webPayments  Set
   */
  public void setWebPayments(Set<Payment> webPayments) {
    this.webPayments = webPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web update address.
   *
   * @param  webUpdateAddress  Set
   */
  public void setWebUpdateAddress(Set<ContactAddress> webUpdateAddress) {
    this.webUpdateAddress = webUpdateAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web update emails.
   *
   * @param  webUpdateEmails  Set
   */
  public void setWebUpdateEmails(Set<ContactEmail> webUpdateEmails) {
    this.webUpdateEmails = webUpdateEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web update phones.
   *
   * @param  webUpdatePhones  Set
   */
  public void setWebUpdatePhones(Set<ContactPhone> webUpdatePhones) {
    this.webUpdatePhones = webUpdatePhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for zip code.
   *
   * @param  zipCode  String
   */
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for zip code changed.
   *
   * @param  zipCodeChanged  boolean
   */
  public void setZipCodeChanged(boolean zipCodeChanged) {
    this.zipCodeChanged = zipCodeChanged;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for zip required full.
   *
   * @param  isZipRequiredFull  boolean
   */
  public void setZipRequiredFull(boolean isZipRequiredFull) {
    this.isZipRequiredFull = isZipRequiredFull;
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

    retValue.append("Responsible ( ").append(TAB).append("assets = ").append(this.assets).append(TAB).append(
      "preferHomeAddress = ").append(this.preferHomeAddress).append(TAB).append(
      "preferHomeEmail = ").append(this.preferHomeEmail).append(TAB).append("preferHomePhone = ").append(
      this.preferHomePhone).append(
      TAB).append("preferMobilePhone = ").append(this.preferMobilePhone).append(TAB).append("preferTextMessage = ")
      .append(
        this.preferTextMessage).append(TAB).append("preferWorkPhone = ").append(this.preferWorkPhone).append(TAB)
      .append(
        "custodialAccount = ").append(this.custodialAccount).append(TAB).append("dateOfBirth = ").append(
      this.dateOfBirth).append(TAB).append("doNotContact = ").append(this.doNotContact).append(TAB).append(TAB).append(
      "firstName = ").append(this.firstName).append(
      TAB).append("gender = ").append(this.gender).append(TAB).append(
      "guarantor = ").append(this.guarantor).append(TAB).append(
      "homeowner = ").append(this.homeowner).append(TAB).append(
      "income = ").append(this.income).append(TAB).append("lastName = ").append(this.lastName).append(TAB).append(
      "middleName = ").append(
      this.middleName).append(TAB).append("originalDateTimestamp = ").append(this.originalDateTimestamp).append(TAB)
      .append(
        "primaryHolder = ").append(this.primaryHolder).append(TAB).append(
      "reasonForDelinquency = ").append(this.reasonForDelinquency).append(
      TAB).append("responsibleId = ").append(this.responsibleId).append(
      TAB).append("revisedDateTimestamp = ").append(
      this.revisedDateTimestamp).append(TAB).append("ssn = ").append(
      this.ssn).append(TAB).append("timezone = ").append(this.timezone).append(TAB).append("totalHouseholdIncome = ")
      .append(
        this.totalHouseholdIncome).append(TAB).append("zipCode = ").append(
      this.zipCode).append(TAB).append(" )");

    return retValue.toString();
  } // end method toString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update address.
   *
   * @param   address  ContactAddress
   *
   * @return  update address
   */
  public boolean updateAddress(ContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String         typeId    = address.getAddressType().getTypeId().toString();
    ContactAddress myAddress = this.addresses.get(typeId);
    Date           now       = new Date();

    // The address must have at least address1 or address 2 or city or
    // province.
    // requires email address, otherwise refuse to update
    if (!address.hasAddressInfo()) {
      if ((myAddress == null) || (myAddress.getAddressType() == null)
            || (myAddress.getAddressType().getTypeId() == null)
            || (!myAddress.hasAddressInfo())) {
        return false;
      } else {
        // remove current address since it was cleared
        myAddress = this.addresses.remove(typeId);
        myAddress.setHistorical(Boolean.TRUE);
        myAddress.setExitDate(now);
        myAddress.setLastUpdateDate(now);
        historicalAddresses.add(myAddress);

        return true;
      }
    }

    if (address.equals(myAddress)) {
      // new address is same as old address, check the status changes for this address
      if (((address.getStatus() == null) && (myAddress.getStatus() != null))
            || !address.getStatus().equals(myAddress.getStatus())) {
        myAddress.setStatus(address.getStatus());
        myAddress.setLastUpdateDate(now);
        this.addresses.put(typeId, myAddress);
      }

      if (((address.getAddressForeignFlag() == null) && (myAddress.getAddressForeignFlag() != null))
            || ((address.getAddressForeignFlag() != null)
              && !address.getAddressForeignFlag().equals(myAddress.getAddressForeignFlag()))) {
        myAddress.setAddressForeignFlag(address.getAddressForeignFlag());
        myAddress.setLastUpdateDate(now);
        this.addresses.put(typeId, myAddress);
      }

      // the new address is the same,no need update
      return false;
    } else {
      if (myAddress == null) {
        // New address for this type - first look it up and see if the
        // passed in
        // address is already in historicalAddresses
        myAddress = lookupHistoricalAddress(address);

        if (myAddress == null) {
          myAddress = new ContactAddress();
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setResponsible(this);
          myAddress.setEntryDate(now);
          myAddress.deepCopy(address);
        } else {
          this.historicalAddresses.remove(myAddress);
          myAddress.setExitDate(null);
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setLastUpdateDate(now);
          myAddress.setSource(address.getSource());
        }

        myAddress.setExternalReferenceId(address.getExternalReferenceId());
        this.addresses.put(typeId, myAddress);
      } else {
        // Already has an address for this type, and it is different -
        // move the
        // old address to historical address
        // NOTE: We are sure there is no address in historicalAddress
        // that
        // equals this address.

        myAddress = this.addresses.remove(typeId);
        myAddress.setHistorical(Boolean.TRUE);
        myAddress.setExitDate(now);
        myAddress.setLastUpdateDate(now);
        historicalAddresses.add(myAddress);

        ContactAddress newAddress = lookupHistoricalAddress(address);

        if (newAddress == null) {
          newAddress = new ContactAddress();
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setResponsible(this);
          newAddress.setEntryDate(now);
          newAddress.deepCopy(address);
        } else {
          historicalAddresses.remove(newAddress);
          newAddress.setExitDate(null);
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setLastUpdateDate(now);
          newAddress.setSource(address.getSource());
        }

        if (!StringUtils.hasText(newAddress.getExternalReferenceId())) {
          newAddress.setExternalReferenceId(myAddress.getExternalReferenceId());
        }

        this.addresses.put(typeId, newAddress);
      } // end if-else

      // update responsible zip code if it was a type '1'
      if (typeId.equals(
              ContactChannel.HOMEADDRESS.getTypeId().toString())
            && !isZipRequiredFull) {
        updateZipCode(address.getAddress().getPostalCode());
      } else if (typeId.equals(
              ContactChannel.HOMEADDRESS.getTypeId().toString())
            && isZipRequiredFull) {
        updateFullZipCode(address.getAddress().getPostalCode());
      }

      return true;
    } // end if-else
  }   // end method updateAddress

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateAddressExpressConsent.
   *
   * @param   address  ContactAddress
   *
   * @return  boolean
   */
  public boolean updateAddressExpressConsent(ContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String         typeId    = address.getAddressType().getTypeId().toString();
    ContactAddress myAddress = this.addresses.get(typeId);
    Date           now       = new Date();
    myAddress.setExpressConsent(address.getExpressConsent());
    myAddress.setLastExpressConsentAgent(address.getLastExpressConsentAgent());
    myAddress.setLastExpressConsentUpdateDate(now);
    this.addresses.put(typeId, myAddress);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateAddressExpressConsent.
   *
   * @param   address  TemporaryContactAddress
   *
   * @return  boolean
   */
  public boolean updateAddressExpressConsent(TemporaryContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String                  typeId    = address.getAddressType().getTypeId().toString();
    TemporaryContactAddress myAddress = this.temporaryAddresses.get(typeId);
    Date                    now       = new Date();
    myAddress.setExpressConsent(address.getExpressConsent());
    myAddress.setLastExpressConsentAgent(address.getLastExpressConsentAgent());
    myAddress.setLastExpressConsentUpdateDate(now);
    this.temporaryAddresses.put(typeId, myAddress);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateAddressExpressConsent.
   *
   * @param   address  FuturePermanentContactAddress
   *
   * @return  boolean
   */
  public boolean updateAddressExpressConsent(FuturePermanentContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String                        typeId    = address.getAddressType().getTypeId().toString();
    FuturePermanentContactAddress myAddress = this.futurePermanentAddresses.get(typeId);
    Date                          now       = new Date();
    myAddress.setExpressConsent(address.getExpressConsent());
    myAddress.setLastExpressConsentAgent(address.getLastExpressConsentAgent());
    myAddress.setLastExpressConsentUpdateDate(now);
    this.futurePermanentAddresses.put(typeId, myAddress);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateCurrentPhoneToHistorical.
   *
   * @param   contactChannel  ContactChannel
   *
   * @return  boolean
   */
  public boolean updateCurrentPhoneToHistorical(ContactChannel contactChannel) {
    String       typeId  = contactChannel.getStringTypeId();
    ContactPhone myPhone = phones.get(typeId);
    Date         now     = new Date();

    if (myPhone == null) {
      return false;
    } else {
      Account   account                     = this.getAccount();
      Portfolio portfolio                   = account.getPortfolio();
      Integer   updateContactNotAllowedDays = portfolio.getUpdateContactNotAllowedDays();
      Date      myPhoneCreateDate           = myPhone.getCreateDate();

      if ((updateContactNotAllowedDays != null)
            && DateUtil.hasDaysEarlierThanNow(myPhoneCreateDate, updateContactNotAllowedDays)) {
        // remove current phone since the number was cleared
        myPhone = this.phones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        historicalPhones.add(myPhone);

        return true;
      }

      return false;
    } // end if-else
  }   // end method updateCurrentPhoneToHistorical

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateDocument.
   *
   * @param  agent           User
   * @param  document        Document
   * @param  typeStatusType  DocumentTypeStatusType
   */
  public void updateDocument(User agent, Document document, DocumentTypeStatusType typeStatusType) {
    // copy to historical
    DocumentHistory documentHistory = new DocumentHistory(document);
    documentHistories.add(documentHistory);

    // found the document and marked it as inactive
    document.setTypeStatusType(typeStatusType);
    document.setLastUpdateAgent(agent);
    document.setLastUpdateDate(new Date());
    document.setResponsible(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update emailAddress.
   *
   * @param   email  ContactEmail
   *
   * @return  update emailAddress
   */
  public boolean updateEmail(ContactEmail email) {
    // requires email and email type
    if ((email == null) || (email.getEmailType() == null)
          || (email.getEmailType().getTypeId() == null)) {
      return false;
    }

    // requires email address, otherwise refuse to update
    /*
     * if (!StringUtils.hasText(email.getEmailAddress())) return false;
     */

    String       typeId  = email.getEmailType().getTypeId().toString();
    ContactEmail myEmail = this.emails.get(typeId);
    Date         now     = new Date();

    // requires email address, otherwise refuse to update
    if (!StringUtils.hasText(email.getEmailAddress())) {
      if ((myEmail == null) || (myEmail.getEmailType() == null)
            || (myEmail.getEmailType().getTypeId() == null)) {
        return false;
      } else {
        // remove current email address since it was cleared
        myEmail = this.emails.remove(typeId);
        myEmail.setHistorical(Boolean.TRUE);
        myEmail.setExitDate(now);
        myEmail.setLastUpdateDate(now);
        historicalEmails.add(myEmail);

        return true;
      }
    }

    if (email.businessEquals(myEmail)) {
      // new email is same as old email, check the status changes for this email
      if (((email.getStatus() == null) && (myEmail.getStatus() != null))
            || !email.getStatus().equals(myEmail.getStatus())) {
        myEmail.setStatus(email.getStatus());
        myEmail.setLastUpdateDate(now);
        this.emails.put(typeId, myEmail);
      }

      if ((email.getOptOut() != null) && !email.getOptOut().equals(myEmail.getOptOut())) {
        myEmail.setOptOut(email.getOptOut());
        this.emails.put(typeId, myEmail);
      }

      // same,no need update
      return false;
    } else {
      if (myEmail == null) {
        // New email for this type - first look it up and see if the
        // passed in
        // email is already in historicalEmails
        myEmail = lookupHistoricalEmail(email);

        if (myEmail == null) {
          myEmail = new ContactEmail();
          myEmail.setHistorical(Boolean.FALSE);
          myEmail.setResponsible(this);
          myEmail.setEntryDate(now);
          myEmail.deepCopy(email);
        } else {
          this.historicalEmails.remove(myEmail);
          myEmail.setExitDate(null);
          myEmail.setHistorical(Boolean.FALSE);
          myEmail.setLastUpdateDate(now);
          myEmail.setSource(email.getSource());
        }

        if (email.getOptOut() != null) {
          myEmail.setOptOut(email.getOptOut());
        }

        this.emails.put(typeId, myEmail);
      } else {
        // Already has an email for this type, and it is different -
        // move the
        // old email to historical email

        myEmail = this.emails.remove(typeId);
        myEmail.setHistorical(Boolean.TRUE);
        myEmail.setExitDate(now);
        myEmail.setLastUpdateDate(now);
        historicalEmails.add(myEmail);

        ContactEmail newEmail = lookupHistoricalEmail(email);

        if (newEmail == null) {
          newEmail = new ContactEmail();
          newEmail.setHistorical(Boolean.FALSE);
          newEmail.setResponsible(this);
          newEmail.setEntryDate(now);
          newEmail.deepCopy(email);
        } else {
          historicalEmails.remove(newEmail);
          newEmail.setExitDate(null);
          newEmail.setHistorical(Boolean.FALSE);
          newEmail.setLastUpdateDate(now);
          newEmail.setSource(email.getSource());
        }

        if (email.getOptOut() != null) {
          newEmail.setOptOut(email.getOptOut());
        }

        this.emails.put(typeId, newEmail);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updateEmail

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateEmailExpressConsent.
   *
   * @param   email  ContactEmail
   *
   * @return  boolean
   */
  public boolean updateEmailExpressConsent(ContactEmail email) {
    // address and address type are needed
    if ((email == null) || (email.getEmailType() == null)
          || (email.getEmailType().getTypeId() == null)) {
      return false;
    }

    String       typeId  = email.getEmailType().getTypeId().toString();
    ContactEmail myEmail = this.emails.get(typeId);
    Date         now     = new Date();
    myEmail.setExpressConsent(email.getExpressConsent());
    myEmail.setLastExpressConsentAgent(myEmail.getLastExpressConsentAgent());
    myEmail.setLastExpressConsentUpdateDate(now);
    this.emails.put(typeId, myEmail);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateFuturePermanentAddress.
   *
   * @param   address  FuturePermanentContactAddress
   *
   * @return  boolean
   */
  public boolean updateFuturePermanentAddress(FuturePermanentContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String                        typeId    = address.getAddressType().getTypeId().toString();
    FuturePermanentContactAddress myAddress = this.futurePermanentAddresses.get(typeId);
    Date                          now       = new Date();

    // The address must have at least address1 or address 2 or city or
    // province.
    // requires email address, otherwise refuse to update
    if (!address.hasAddressInfo()) {
      if ((myAddress == null) || (myAddress.getAddressType() == null)
            || (myAddress.getAddressType().getTypeId() == null)
            || (!myAddress.hasAddressInfo())) {
        return false;
      } else {
        // remove current address since it was cleared
        myAddress = this.futurePermanentAddresses.remove(typeId);
        myAddress.setHistorical(Boolean.TRUE);
        myAddress.setExitDate(now);
        myAddress.setLastUpdateDate(now);
        futurePermanentHistoricalAddresses.add(myAddress);

        return true;
      }
    }

    if (address.equals(myAddress)) {
      // the new address is the same,no need update
      return false;
    } else {
      if (myAddress == null) {
        // New address for this type - first look it up and see if the
        // passed in
        // address is already in historicalAddresses
        myAddress = lookupHistoricalAddress(address);

        if (myAddress == null) {
          myAddress = new FuturePermanentContactAddress();
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setResponsible(this);
          myAddress.setEntryDate(now);
          myAddress.deepCopy(address);
        } else {
          this.futurePermanentHistoricalAddresses.remove(myAddress);
          myAddress.setExitDate(null);
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setLastUpdateDate(now);
          myAddress.setSource(address.getSource());
        }

        this.futurePermanentAddresses.put(typeId, myAddress);
      } else {
        // Already has an address for this type, and it is different -
        // move the
        // old address to historical address
        // NOTE: We are sure there is no address in historicalAddress
        // that
        // equals this address.

        myAddress = this.futurePermanentAddresses.remove(typeId);
        myAddress.setHistorical(Boolean.TRUE);
        myAddress.setExitDate(now);
        myAddress.setLastUpdateDate(now);
        futurePermanentHistoricalAddresses.add(myAddress);

        FuturePermanentContactAddress newAddress = lookupHistoricalAddress(address);

        if (newAddress == null) {
          newAddress = new FuturePermanentContactAddress();
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setResponsible(this);
          newAddress.setEntryDate(now);
          newAddress.deepCopy(address);
        } else {
          futurePermanentHistoricalAddresses.remove(newAddress);
          newAddress.setExitDate(null);
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setLastUpdateDate(now);
          newAddress.setSource(address.getSource());
        }

        this.futurePermanentAddresses.put(typeId, newAddress);
      } // end if-else

      // update responsible zip code if it was a type '1'
      if (typeId.equals(
              ContactChannel.HOMEADDRESS.getTypeId().toString())
            && !isZipRequiredFull) {
        updateZipCode(address.getAddress().getPostalCode());
      } else if (typeId.equals(
              ContactChannel.HOMEADDRESS.getTypeId().toString())
            && isZipRequiredFull) {
        updateFullZipCode(address.getAddress().getPostalCode());
      }

      return true;
    } // end if-else
  }   // end method updateFuturePermanentAddress

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   emailAddress  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updateHomeEmail(String emailAddress) {
    EmailType    emailType    = new EmailType(ContactChannel.HOMEEMAIL.getTypeId(),
        ContactChannel.HOMEEMAIL.toString());
    ContactEmail contactEmail = createContactEmail(emailAddress, emailType);

    return updateEmail(contactEmail);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   phoneNumber  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updateMobilePhone(String phoneNumber) {
    PhoneType    phoneType    = new PhoneType(ContactChannel.MOBILEPHONE.getTypeId(),
        ContactChannel.MOBILEPHONE.toString());
    ContactPhone contactPhone = createContactPhone(phoneNumber, phoneType);

    return updatePhone(contactPhone);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateMraPhone.
   *
   * @param   phone          ContactPhone
   * @param   validCallType  boolean
   *
   * @return  boolean
   */
  public boolean updateMraPhone(ContactPhone phone, boolean validCallType) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String       typeId  = phone.getPhoneType().getTypeId().toString();
    ContactPhone myPhone = this.phones.get(typeId);
    Date         now     = new Date();

    // Format phone number: Should be number only in the DB.
    // US number should be 10 digits with area code.
    if (StringUtils.hasText(phone.getPhoneNum())) {
      phone.setPhoneNum(phone.getPhoneNum().replaceAll("[^0-9]", ""));
    }

    if (StringUtils.hasText(phone.getExtension())) {
      phone.setExtension(phone.getExtension().replaceAll("[^0-9]", ""));
    }

    // requires phone number, otherwise refuse to update
    if (!StringUtils.hasText(phone.getPhoneNum())) {
      if ((myPhone == null) || (myPhone.getPhoneType() == null)
            || (myPhone.getPhoneType().getTypeId() == null)) {
        return false;
      } else {
        // remove current phone since the number was cleared
        myPhone = this.phones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        historicalPhones.add(myPhone);

        return true;
      }
    }

    if (phone.equals(myPhone)) {
      Boolean updateCurrentPhone = false;

      // both the phone numbers are same but we also need to check the badNumber and isMobile indicator.
      // adding this block for upc
      // 1) if we update the equals method in contact phone to compare badNumber & isMobile,
      // then it will insert a new record in the contact phone with same phoneNumber but with different badNumber or isMobile status which is not desired
      // 2)To avoid duplicate number insertion we will compare badNumber and isMobile from phone object and mypPhone objects and update the status
      // 3) for isMobile for UPC we have three statuses Y, N and NULL
      if ((phone.getBadNumber() == null) && (myPhone.getBadNumber() == null)) {
        /* same BadNumber value,no need to update*/
      } else if (((phone.getBadNumber() == null) && (myPhone.getBadNumber() != null))
            || !phone.getBadNumber().equals(myPhone.getBadNumber())) {
        // update the existing phone as there is change in BadNumber
        myPhone.setBadNumber(phone.getBadNumber());
        updateCurrentPhone = true;
      }

      if ((phone.getIsMobile() == null) && (myPhone.getIsMobile() == null)) {
        /* same isMobile value, no need update*/
      } else if (((phone.getIsMobile() == null) && (myPhone.getIsMobile() != null))
            || !phone.getIsMobile().equals(myPhone.getIsMobile())) {
        // update the existing phone as there is change in isMobile
        myPhone.setIsMobile(phone.getIsMobile());
        updateCurrentPhone = true;
      }

      if (updateCurrentPhone) {
        myPhone.setLastUpdateDate(now);
        this.phones.put(typeId, myPhone);

        return true;
      }

      // just same,no need update
      return updateCurrentPhone;
    } else {
      if (myPhone == null) {
        // New phone for this type - first look it up and see if the
        // passed in
        // phone is already in historicalPhones
        myPhone = lookupHistoricalPhone(phone);

        if (myPhone == null) {
          myPhone = new ContactPhone();
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setResponsible(this);
          myPhone.setEntryDate(now);
          myPhone.deepCopy(phone);

          if (!validCallType) {
            myPhone.setCallType(null);
          }
        } else {
          this.historicalPhones.remove(myPhone);
          myPhone.setExitDate(null);
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setLastUpdateDate(now);
          myPhone.setSource(phone.getSource());
        }

        this.phones.put(typeId, myPhone);
      } else {
        // Already has an phone for this type, and it is different -
        // move the
        // old phone to historical phone

        myPhone = this.phones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        historicalPhones.add(myPhone);

        ContactPhone newPhone = lookupHistoricalPhone(phone);

        if (newPhone == null) {
          newPhone = new ContactPhone();
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setResponsible(this);
          newPhone.setEntryDate(now);
          newPhone.deepCopy(phone);

          if (!validCallType) {
            newPhone.setCallType(myPhone.getCallType());
          }
        } else {
          historicalPhones.remove(newPhone);
          newPhone.setExitDate(null);
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setLastUpdateDate(now);
          newPhone.setSource(phone.getSource());
        }

        this.phones.put(typeId, newPhone);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updateMraPhone

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateMraPhone.
   *
   * @param   phone          TemporaryContactPhone
   * @param   validCallType  boolean
   *
   * @return  boolean
   */
  public boolean updateMraPhone(TemporaryContactPhone phone, boolean validCallType) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                typeId  = phone.getPhoneType().getTypeId().toString();
    TemporaryContactPhone myPhone = this.temporaryPhones.get(typeId);
    Date                  now     = new Date();

    // Format phone number: Should be number only in the DB.
    // US number should be 10 digits with area code.
    if (StringUtils.hasText(phone.getPhoneNum())) {
      phone.setPhoneNum(phone.getPhoneNum().replaceAll("[^0-9]", ""));
    }

    if (StringUtils.hasText(phone.getExtension())) {
      phone.setExtension(phone.getExtension().replaceAll("[^0-9]", ""));
    }

    // requires phone number, otherwise refuse to update
    if (!StringUtils.hasText(phone.getPhoneNum())) {
      if ((myPhone == null) || (myPhone.getPhoneType() == null)
            || (myPhone.getPhoneType().getTypeId() == null)) {
        return false;
      } else {
        // remove current phone since the number was cleared
        myPhone = this.temporaryPhones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        temporaryHistoricalPhones.add(myPhone);

        return true;
      }
    }

    if (phone.equals(myPhone)) {
      Boolean updateCurrentPhone = false;

      // both the phone numbers are same but we also need to check the badNumber and isMobile indicator.
      // adding this block for upc
      // 1) if we update the equals method in contact phone to compare badNumber & isMobile,
      // then it will insert a new record in the contact phone with same phoneNumber but with different badNumber or isMobile status which is not desired
      // 2)To avoid duplicate number insertion we will compare badNumber and isMobile from phone object and mypPhone objects and update the status
      // 3) for isMobile for UPC we have three statuses Y, N and NULL
      if ((phone.getBadNumber() == null) && (myPhone.getBadNumber() == null)) {
        /* same BadNumber value,no need to update*/
      } else if (((phone.getBadNumber() == null) && (myPhone.getBadNumber() != null))
            || !phone.getBadNumber().equals(myPhone.getBadNumber())) {
        // update the existing phone as there is change in BadNumber
        myPhone.setBadNumber(phone.getBadNumber());
        updateCurrentPhone = true;
      }

      if ((phone.getIsMobile() == null) && (myPhone.getIsMobile() == null)) {
        /* same isMobile value, no need update*/
      } else if (((phone.getIsMobile() == null) && (myPhone.getIsMobile() != null))
            || !phone.getIsMobile().equals(myPhone.getIsMobile())) {
        // update the existing phone as there is change in isMobile
        myPhone.setIsMobile(phone.getIsMobile());
        updateCurrentPhone = true;
      }

      if (updateCurrentPhone) {
        myPhone.setLastUpdateDate(now);
        this.temporaryPhones.put(typeId, myPhone);

        return true;
      }

      // just same,no need update
      return updateCurrentPhone;
    } else {
      if (myPhone == null) {
        // New phone for this type - first look it up and see if the
        // passed in
        // phone is already in historicalPhones
        myPhone = lookupHistoricalPhone(phone);

        if (myPhone == null) {
          myPhone = new TemporaryContactPhone();
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setResponsible(this);
          myPhone.setEntryDate(now);
          myPhone.deepCopy(phone);

          if (!validCallType) {
            myPhone.setCallType(null);
          }
        } else {
          this.temporaryHistoricalPhones.remove(myPhone);
          myPhone.setExitDate(null);
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setLastUpdateDate(now);
          myPhone.setSource(phone.getSource());
        }

        this.temporaryPhones.put(typeId, myPhone);
      } else {
        // Already has an phone for this type, and it is different -
        // move the
        // old phone to historical phone

        myPhone = this.temporaryPhones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        temporaryHistoricalPhones.add(myPhone);

        TemporaryContactPhone newPhone = lookupHistoricalPhone(phone);

        if (newPhone == null) {
          newPhone = new TemporaryContactPhone();
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setResponsible(this);
          newPhone.setEntryDate(now);
          newPhone.deepCopy(phone);

          if (!validCallType) {
            newPhone.setCallType(myPhone.getCallType());
          }
        } else {
          temporaryHistoricalPhones.remove(newPhone);
          newPhone.setExitDate(null);
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setLastUpdateDate(now);
          newPhone.setSource(phone.getSource());
        }

        this.temporaryPhones.put(typeId, newPhone);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updateMraPhone

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   phone          DOCUMENT ME!
   * @param   validCallType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updateMraPhone(FuturePermanentContactPhone phone, boolean validCallType) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                      typeId  = phone.getPhoneType().getTypeId().toString();
    FuturePermanentContactPhone myPhone = this.futurePermanentPhones.get(typeId);
    Date                        now     = new Date();

    // Format phone number: Should be number only in the DB.
    // US number should be 10 digits with area code.
    if (StringUtils.hasText(phone.getPhoneNum())) {
      phone.setPhoneNum(phone.getPhoneNum().replaceAll("[^0-9]", ""));
    }

    if (StringUtils.hasText(phone.getExtension())) {
      phone.setExtension(phone.getExtension().replaceAll("[^0-9]", ""));
    }

    // requires phone number, otherwise refuse to update
    if (!StringUtils.hasText(phone.getPhoneNum())) {
      if ((myPhone == null) || (myPhone.getPhoneType() == null)
            || (myPhone.getPhoneType().getTypeId() == null)) {
        return false;
      } else {
        // remove current phone since the number was cleared
        myPhone = this.futurePermanentPhones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        futurePermanentHistoricalPhones.add(myPhone);

        return true;
      }
    }

    if (phone.equals(myPhone)) {
      Boolean updateCurrentPhone = false;

      // both the phone numbers are same but we also need to check the badNumber and isMobile indicator.
      // adding this block for upc
      // 1) if we update the equals method in contact phone to compare badNumber & isMobile,
      // then it will insert a new record in the contact phone with same phoneNumber but with different badNumber or isMobile status which is not desired
      // 2)To avoid duplicate number insertion we will compare badNumber and isMobile from phone object and mypPhone objects and update the status
      // 3) for isMobile for UPC we have three statuses Y, N and NULL
      if ((phone.getBadNumber() == null) && (myPhone.getBadNumber() == null)) {
        /* same BadNumber value,no need to update*/
      } else if (((phone.getBadNumber() == null) && (myPhone.getBadNumber() != null))
            || !phone.getBadNumber().equals(myPhone.getBadNumber())) {
        // update the existing phone as there is change in BadNumber
        myPhone.setBadNumber(phone.getBadNumber());
        updateCurrentPhone = true;
      }

      if ((phone.getIsMobile() == null) && (myPhone.getIsMobile() == null)) {
        /* same isMobile value, no need update*/
      } else if (((phone.getIsMobile() == null) && (myPhone.getIsMobile() != null))
            || !phone.getIsMobile().equals(myPhone.getIsMobile())) {
        // update the existing phone as there is change in isMobile
        myPhone.setIsMobile(phone.getIsMobile());
        updateCurrentPhone = true;
      }

      if (updateCurrentPhone) {
        myPhone.setLastUpdateDate(now);
        this.futurePermanentPhones.put(typeId, myPhone);

        return true;
      }

      // just same,no need update
      return updateCurrentPhone;
    } else {
      if (myPhone == null) {
        // New phone for this type - first look it up and see if the
        // passed in
        // phone is already in historicalPhones
        myPhone = lookupHistoricalPhone(phone);

        if (myPhone == null) {
          myPhone = new FuturePermanentContactPhone();
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setResponsible(this);
          myPhone.setEntryDate(now);
          myPhone.deepCopy(phone);

          if (!validCallType) {
            myPhone.setCallType(null);
          }
        } else {
          this.futurePermanentHistoricalPhones.remove(myPhone);
          myPhone.setExitDate(null);
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setLastUpdateDate(now);
          myPhone.setSource(phone.getSource());
        }

        this.futurePermanentPhones.put(typeId, myPhone);
      } else {
        // Already has an phone for this type, and it is different -
        // move the
        // old phone to historical phone

        myPhone = this.futurePermanentPhones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        futurePermanentHistoricalPhones.add(myPhone);

        FuturePermanentContactPhone newPhone = lookupHistoricalPhone(phone);

        if (newPhone == null) {
          newPhone = new FuturePermanentContactPhone();
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setResponsible(this);
          newPhone.setEntryDate(now);
          newPhone.deepCopy(phone);

          if (!validCallType) {
            newPhone.setCallType(myPhone.getCallType());
          }
        } else {
          futurePermanentHistoricalPhones.remove(newPhone);
          newPhone.setExitDate(null);
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setLastUpdateDate(now);
          newPhone.setSource(phone.getSource());
        }

        this.futurePermanentPhones.put(typeId, newPhone);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updateMraPhone

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Adding this for barclays pe account loader file to update the email address as empty.
   *
   * @param   email  ContactEmail
   *
   * @return  boolean
   */
  public boolean updateOrRemoveEmail(ContactEmail email) {
    // requires email and email type
    if ((email == null) || (email.getEmailType() == null)
          || (email.getEmailType().getTypeId() == null)) {
      return false;
    }

    // requires email address, otherwise refuse to update
    /*
     * if (!StringUtils.hasText(email.getEmailAddress())) return false;
     */

    String       typeId  = email.getEmailType().getTypeId().toString();
    ContactEmail myEmail = this.emails.get(typeId);
    Date         now     = new Date();

    if (email.equals(myEmail)) {
      // same,no need update
      return false;
    } else {
      if (myEmail == null) {
        // New email for this type - first look it up and see if the
        // passed in
        // email is already in historicalEmails
        myEmail = lookupHistoricalEmail(email);

        if (myEmail == null) {
          myEmail = new ContactEmail();
          myEmail.setHistorical(Boolean.FALSE);
          myEmail.setResponsible(this);
          myEmail.setEntryDate(now);
          myEmail.deepCopy(email);
        } else {
          this.historicalEmails.remove(myEmail);
          myEmail.setExitDate(null);
          myEmail.setHistorical(Boolean.FALSE);
          myEmail.setLastUpdateDate(now);
          myEmail.setSource(email.getSource());
        }

        this.emails.put(typeId, myEmail);
      } else {
        // Already has an email for this type, and it is different -
        // move the
        // old email to historical email

        myEmail = this.emails.remove(typeId);
        myEmail.setHistorical(Boolean.TRUE);
        myEmail.setExitDate(now);
        myEmail.setLastUpdateDate(now);
        historicalEmails.add(myEmail);

        ContactEmail newEmail = lookupHistoricalEmail(email);

        if (newEmail == null) {
          newEmail = new ContactEmail();
          newEmail.setHistorical(Boolean.FALSE);
          newEmail.setResponsible(this);
          newEmail.setEntryDate(now);
          newEmail.deepCopy(email);
        } else {
          historicalEmails.remove(newEmail);
          newEmail.setExitDate(null);
          newEmail.setHistorical(Boolean.FALSE);
          newEmail.setLastUpdateDate(now);
          newEmail.setSource(email.getSource());
        }

        this.emails.put(typeId, newEmail);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updateOrRemoveEmail

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * To Update Phone Number for the USB/Elan portfolio.This method will update the Phonenumber to Empty if string passed
   * from placement file has No digits/All Zeros/Any Special Characters. If the Phone number passed is of 10 digits/less
   * than 10 digits then it will update phone umber as it is available.
   *
   * @param   phoneNum        String
   * @param   contactChannel  ContactChannel
   * @param   contactSource   ContactSource
   * @param   contactStatus   ContactStatus
   *
   * @return  to Update Phone Number for the USB/Elan portfolio.This method will update the Phonenumber to Empty if
   *          string passed from placement file has No digits/All Zeros/Any Special Characters.
   */
  public boolean updateOrRemovePhone(String phoneNum, ContactChannel contactChannel, ContactSource contactSource,
    ContactStatus contactStatus) {
    phoneNum = phoneNum.replaceAll("[^0-9]", "");

    ContactPhone phone = new ContactPhone();
    phone.setPhoneType(new PhoneType(contactChannel.getTypeId(),
        contactChannel.toString()));
    phone.setPhoneNum(phoneNum);
    phone.setSource(contactSource);
    phone.setStatus(contactStatus);

    if (phone == null) {
      return false;
    }

    String       typeId  = phone.getPhoneType().getTypeId().toString();
    ContactPhone myPhone = this.phones.get(typeId);
    Date         now     = new Date();

    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    // Format phone number: Should be number only in the DB.
    // US number should be 10 digits with area code.
    if (StringUtils.hasText(phone.getPhoneNum())) {
      phone.setPhoneNum(phone.getPhoneNum().replaceAll("[^0-9]", ""));
    }

    if (StringUtils.hasText(phone.getExtension())) {
      phone.setExtension(phone.getExtension().replaceAll("[^0-9]", ""));
    }

    if (phone.equals(myPhone)) {
      // just same,no need update
      return false;
    } else {
      if (myPhone == null) {
        // New phone for this type - first look it up and see if the
        // passed in
        // phone is already in historicalPhones
        myPhone = lookupHistoricalPhone(phone);

        if (myPhone == null) {
          myPhone = new ContactPhone();
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setResponsible(this);
          myPhone.setEntryDate(now);
          myPhone.deepCopy(phone);
        } else {
          this.historicalPhones.remove(myPhone);
          myPhone.setExitDate(null);
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setLastUpdateDate(now);
          myPhone.setSource(phone.getSource());
        }

        this.phones.put(typeId, myPhone);
      } else {
        // Already has an phone for this type, and it is different -
        // move the
        // old phone to historical phone

        myPhone = this.phones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        historicalPhones.add(myPhone);

        ContactPhone newPhone = lookupHistoricalPhone(phone);

        if (newPhone == null) {
          newPhone = new ContactPhone();
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setResponsible(this);
          newPhone.setEntryDate(now);
          newPhone.deepCopy(phone);
        } else {
          historicalPhones.remove(newPhone);
          newPhone.setExitDate(null);
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setLastUpdateDate(now);
          newPhone.setSource(phone.getSource());
        }

        this.phones.put(typeId, newPhone);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updateOrRemovePhone

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update phone.
   *
   * @param   phone  DOCUMENT ME!
   *
   * @return  update phone
   */
  public boolean updatePhone(ContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String       typeId                   = phone.getPhoneType().getTypeId().toString();
    ContactPhone myPhone                  = this.phones.get(typeId);
    Date         now                      = new Date();
    Portfolio    portfolio                = (account != null) ? account.getPortfolio() : null;
    Boolean      overRidePhonetypeConsent = (portfolio != null) ? portfolio.getOverRidePhoneTypeExpressConsent()
                                                                : Boolean.FALSE;

    if (log.isDebugEnabled()) {
      log.debug("overRidePhonetypeConsent: " + overRidePhonetypeConsent);
    }

    // Format phone number: Should be number only in the DB.
    // US number should be 10 digits with area code.
    if (StringUtils.hasText(phone.getPhoneNum())) {
      phone.setPhoneNum(phone.getPhoneNum().replaceAll("[^0-9]", ""));
    }

    if (StringUtils.hasText(phone.getExternalReferenceId())) {
      phone.setExternalReferenceId(phone.getExternalReferenceId());
    }

    if (StringUtils.hasText(phone.getExtension())) {
      phone.setExtension(phone.getExtension().replaceAll("[^0-9]", ""));
    }

    if (StringUtils.hasText(phone.getTelephoneCountryCode())) {
      phone.setTelephoneCountryCode(phone.getTelephoneCountryCode());
    }

    if (StringUtils.hasText(phone.getCountryCode())) {
      phone.setCountryCode(phone.getCountryCode());
    }

    // requires phone number, otherwise refuse to update
    if (!StringUtils.hasText(phone.getPhoneNum())) {
      if ((myPhone == null) || (myPhone.getPhoneType() == null)
            || (myPhone.getPhoneType().getTypeId() == null)) {
        return false;
      } else {
        // remove current phone since the number was cleared
        myPhone = this.phones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        historicalPhones.add(myPhone);

        return true;
      }
    }

    if (phone.businessEquals(myPhone)) {
      Boolean updateCurrentPhone = false;

      // both the phone numbers are same but we also need to check the badNumber and isMobile indicator.
      // adding this block for upc
      // 1) if we update the equals method in contact phone to compare badNumber & isMobile,
      // then it will insert a new record in the contact phone with same phoneNumber but with different badNumber or isMobile status which is not desired
      // 2)To avoid duplicate number insertion we will compare badNumber and isMobile from phone object and mypPhone objects and update the status
      // 3) for isMobile for UPC we have three statuses Y, N and NULL
      if ((phone.getBadNumber() == null) && (myPhone.getBadNumber() == null)) {
        /* same BadNumber value,no need to update*/
      } else if (((phone.getBadNumber() == null) && (myPhone.getBadNumber() != null))
            || !phone.getBadNumber().equals(myPhone.getBadNumber())) {
        // update the existing phone as there is change in BadNumber
        myPhone.setBadNumber(phone.getBadNumber());
        updateCurrentPhone = true;
      }

      if ((phone.getIsMobile() == null) && (myPhone.getIsMobile() == null)) {
        /* same isMobile value, no need update*/
      } else if (((phone.getIsMobile() == null) && (myPhone.getIsMobile() != null))
            || !phone.getIsMobile().equals(myPhone.getIsMobile())) {
        // update the existing phone as there is change in isMobile
        myPhone.setIsMobile(phone.getIsMobile());
        updateCurrentPhone = true;
      }

      // new phone number is same as old phone number, check the status changes for this phone number
      if (((phone.getStatus() == null) && (myPhone.getStatus() != null))
            || !phone.getStatus().equals(myPhone.getStatus())) {
        myPhone.setStatus(phone.getStatus());
        updateCurrentPhone = true;
      }

      if (((phone.getLastContactStatus() == null) && (myPhone.getLastContactStatus() != null))
            || (!Objects.equals(phone.getLastContactStatus(), myPhone.getLastContactStatus()))) {
        myPhone.setLastContactStatus(phone.getLastContactStatus());
      }

      if (((phone.getExpressConsent() == null) && (myPhone.getExpressConsent() != null))
            || (!Objects.equals(phone.getExpressConsent(), myPhone.getExpressConsent()))) {
        myPhone.setExpressConsent(phone.getExpressConsent());
        myPhone.setExpressConsentSMS(phone.getExpressConsentSMS());
        myPhone.setExpressConsentVoice(phone.getExpressConsentVoice());

        myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentSMSAgent());
        myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentVoiceAgent());
        myPhone.setLastExpressConsentAgent(phone.getLastExpressConsentAgent());

        myPhone.setLastExpressConsentVoiceUpdateDate(phone.getLastExpressConsentVoiceUpdateDate());
        myPhone.setLastExpressConsentSMSUpdateDate(phone.getLastExpressConsentSMSUpdateDate());
        myPhone.setLastExpressConsentUpdateDate(phone.getLastExpressConsentUpdateDate());

        updateCurrentPhone = true;
      }

      if (((phone.getIsMobile() == null) && (myPhone.getIsMobile() != null))
            || ((phone.getIsMobile() != null) && (!Objects.equals(phone.getIsMobile(), myPhone.getIsMobile())))) {
        myPhone.setIsMobile(phone.getIsMobile());
        updateCurrentPhone = true;
      }

      if (updateCurrentPhone) {
        myPhone.setLastUpdateDate(now);
        this.phones.put(typeId, myPhone);

        return true;
      }

      // just same,no need update
      return updateCurrentPhone;
    } else {
      if (myPhone == null) {
        // New phone for this type - first look it up and see if the
        // passed in
        // phone is already in historicalPhones
        myPhone = lookupHistoricalPhone(phone);

        if (myPhone == null) {
          myPhone = new ContactPhone();
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setResponsible(this);
          myPhone.setEntryDate(now);
          myPhone.deepCopy(phone);
        } else {
          this.historicalPhones.remove(myPhone);
          myPhone.setExitDate(null);
          myPhone.setHistorical(Boolean.FALSE);
          myPhone.setLastUpdateDate(now);
          myPhone.setSource(phone.getSource());
        }

        if (((phone.getLastContactStatus() == null) && (myPhone.getLastContactStatus() != null))
              || (!Objects.equals(phone.getLastContactStatus(), myPhone.getLastContactStatus()))) {
          myPhone.setLastContactStatus(phone.getLastContactStatus());
        }

        // USB-1158 and as per Ye.. only for flexsite
        if ((overRidePhonetypeConsent != null) && overRidePhonetypeConsent) {
          myPhone.setLastExpressConsentSMSAgent(null);
          myPhone.setLastExpressConsentVoiceAgent(null);
          myPhone.setLastExpressConsentAgent(null);

          myPhone.setExpressConsentVoice(ExpressConsentType.YES);
          myPhone.setExpressConsentSMS(ExpressConsentType.YES);
          myPhone.setExpressConsent(ExpressConsentType.YES);

          myPhone.setLastExpressConsentVoiceUpdateDate(now);
          myPhone.setLastExpressConsentSMSUpdateDate(now);
          myPhone.setLastExpressConsentUpdateDate(now);
        }

        this.phones.put(typeId, myPhone);
      } else {
        // Already has an phone for this type, and it is different -
        // move the
        // old phone to historical phone

        myPhone = this.phones.remove(typeId);
        myPhone.setHistorical(Boolean.TRUE);
        myPhone.setExitDate(now);
        myPhone.setLastUpdateDate(now);
        historicalPhones.add(myPhone);

        ContactPhone newPhone = lookupHistoricalPhone(phone);

        if (newPhone == null) {
          newPhone = new ContactPhone();
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setResponsible(this);
          newPhone.setEntryDate(now);
          newPhone.deepCopy(phone);
        } else {
          historicalPhones.remove(newPhone);
          newPhone.setExitDate(null);
          newPhone.setHistorical(Boolean.FALSE);
          newPhone.setLastUpdateDate(now);
          newPhone.setSource(phone.getSource());
        }

        if (((phone.getLastContactStatus() == null) && (myPhone.getLastContactStatus() != null))
              || (!Objects.equals(phone.getLastContactStatus(), myPhone.getLastContactStatus()))) {
          myPhone.setLastContactStatus(phone.getLastContactStatus());
        }

        // USB-1158 and as per Ye.. only for flexsite
        if ((overRidePhonetypeConsent != null) && overRidePhonetypeConsent) {
          newPhone.setLastExpressConsentSMSAgent(null);
          newPhone.setLastExpressConsentVoiceAgent(null);
          newPhone.setLastExpressConsentAgent(null);

          newPhone.setExpressConsentVoice(ExpressConsentType.YES);
          newPhone.setExpressConsentSMS(ExpressConsentType.YES);
          newPhone.setExpressConsent(ExpressConsentType.YES);

          newPhone.setLastExpressConsentVoiceUpdateDate(now);
          newPhone.setLastExpressConsentSMSUpdateDate(now);
          newPhone.setLastExpressConsentUpdateDate(now);
        }

        this.phones.put(typeId, newPhone);
      } // end if-else

      return true;
    } // end if-else
  }   // end method updatePhone

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhone.
   *
   * @param   phoneNum        String
   * @param   contactChannel  ContactChannel
   * @param   contactSource   ContactSource
   * @param   contactStatus   ContactStatus
   *
   * @return  boolean
   */
  public boolean updatePhone(String phoneNum, ContactChannel contactChannel, ContactSource contactSource,
    ContactStatus contactStatus) {
    return updatePhone(convertToContactPhone(phoneNum, contactChannel,
          contactSource, contactStatus));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhone.
   *
   * @param   phoneNum        String
   * @param   contactChannel  ContactChannel
   * @param   contactSource   ContactSource
   * @param   contactStatus   ContactStatus
   * @param   expressConsent  ExpressConsentType
   * @param   isMobile        Boolean
   *
   * @return  boolean
   */
  public boolean updatePhone(String phoneNum, ContactChannel contactChannel, ContactSource contactSource,
    ContactStatus contactStatus, ExpressConsentType expressConsent, Boolean isMobile) {
    ContactPhone contactPhone = convertToContactPhone(phoneNum, contactChannel, contactSource, contactStatus);

    if (contactPhone != null) {
      Date now = new Date();
      contactPhone.setLastExpressConsentSMSAgent(null);
      contactPhone.setLastExpressConsentVoiceAgent(null);
      contactPhone.setLastExpressConsentAgent(null);

      contactPhone.setExpressConsentVoice(expressConsent);
      contactPhone.setExpressConsentSMS(expressConsent);
      contactPhone.setExpressConsent(expressConsent);

      contactPhone.setLastExpressConsentVoiceUpdateDate(now);
      contactPhone.setLastExpressConsentSMSUpdateDate(now);
      contactPhone.setLastExpressConsentUpdateDate(now);

      contactPhone.setIsMobile(isMobile);
    }

    return updatePhone(contactPhone);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsent.
   *
   * @param   phone  ContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsent(ContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String       typeId  = phone.getPhoneType().getTypeId().toString();
    ContactPhone myPhone = this.phones.get(typeId);
    Date         now     = new Date();
    myPhone.setExpressConsent(phone.getExpressConsent());
    myPhone.setLastExpressConsentAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentUpdateDate(now);
    myPhone.setExpressConsentSMS(phone.getExpressConsent());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    myPhone.setExpressConsentVoice(phone.getExpressConsent());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.phones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsent.
   *
   * @param   phone  TemporaryContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsent(TemporaryContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                typeId  = phone.getPhoneType().getTypeId().toString();
    TemporaryContactPhone myPhone = this.temporaryPhones.get(typeId);
    Date                  now     = new Date();
    myPhone.setExpressConsent(phone.getExpressConsent());
    myPhone.setLastExpressConsentAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentUpdateDate(now);
    myPhone.setExpressConsentSMS(phone.getExpressConsent());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    myPhone.setExpressConsentVoice(phone.getExpressConsent());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.temporaryPhones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsent.
   *
   * @param   phone  FuturePermanentContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsent(FuturePermanentContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                      typeId  = phone.getPhoneType().getTypeId().toString();
    FuturePermanentContactPhone myPhone = this.futurePermanentPhones.get(typeId);
    Date                        now     = new Date();
    myPhone.setExpressConsent(phone.getExpressConsent());
    myPhone.setLastExpressConsentAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentUpdateDate(now);
    myPhone.setExpressConsentSMS(phone.getExpressConsent());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    myPhone.setExpressConsentVoice(phone.getExpressConsent());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.futurePermanentPhones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsentSMS.
   *
   * @param   phone  ContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsentSMS(ContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String       typeId  = phone.getPhoneType().getTypeId().toString();
    ContactPhone myPhone = this.phones.get(typeId);
    Date         now     = new Date();
    myPhone.setExpressConsentSMS(phone.getExpressConsentSMS());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentSMSAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    this.phones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsentSMS.
   *
   * @param   phone  TemporaryContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsentSMS(TemporaryContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                typeId  = phone.getPhoneType().getTypeId().toString();
    TemporaryContactPhone myPhone = this.temporaryPhones.get(typeId);
    Date                  now     = new Date();
    myPhone.setExpressConsentSMS(phone.getExpressConsentSMS());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentSMSAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    this.temporaryPhones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsentSMS.
   *
   * @param   phone  FuturePermanentContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsentSMS(FuturePermanentContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                      typeId  = phone.getPhoneType().getTypeId().toString();
    FuturePermanentContactPhone myPhone = this.futurePermanentPhones.get(typeId);
    Date                        now     = new Date();
    myPhone.setExpressConsentSMS(phone.getExpressConsentSMS());
    myPhone.setLastExpressConsentSMSAgent(phone.getLastExpressConsentSMSAgent());
    myPhone.setLastExpressConsentSMSUpdateDate(now);
    this.futurePermanentPhones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsentVoice.
   *
   * @param   phone  ContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsentVoice(ContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String       typeId  = phone.getPhoneType().getTypeId().toString();
    ContactPhone myPhone = this.phones.get(typeId);
    Date         now     = new Date();
    myPhone.setExpressConsentVoice(phone.getExpressConsentVoice());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentVoiceAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.phones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsentVoice.
   *
   * @param   phone  TemporaryContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsentVoice(TemporaryContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                typeId  = phone.getPhoneType().getTypeId().toString();
    TemporaryContactPhone myPhone = this.temporaryPhones.get(typeId);
    Date                  now     = new Date();
    myPhone.setExpressConsentVoice(phone.getExpressConsentVoice());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentVoiceAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.temporaryPhones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePhoneExpressConsentVoice.
   *
   * @param   phone  FuturePermanentContactPhone
   *
   * @return  boolean
   */
  public boolean updatePhoneExpressConsentVoice(FuturePermanentContactPhone phone) {
    // nothing to update or Delete the Phone
    if ((phone == null) || (phone.getPhoneType() == null)
          || (phone.getPhoneType().getTypeId() == null)) {
      return false;
    }

    String                      typeId  = phone.getPhoneType().getTypeId().toString();
    FuturePermanentContactPhone myPhone = this.futurePermanentPhones.get(typeId);
    Date                        now     = new Date();
    myPhone.setExpressConsentVoice(phone.getExpressConsentVoice());
    myPhone.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentVoiceAgent());
    myPhone.setLastExpressConsentVoiceUpdateDate(now);
    this.futurePermanentPhones.put(typeId, myPhone);

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update preferHomeAddress.
   *
   * @param   preferHomeAddress  the preferHomeAddress to set
   *
   * @return  update preferHomeAddress
   */
  public boolean updatePreferHomeAddress(Integer preferHomeAddress) {
    if (isDifferent(preferHomeAddress, this.preferHomeAddress)) {
      this.preferHomeAddress = preferHomeAddress;

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update preferHomeEmail.
   *
   * @param   preferHomeEmail  the preferHomeEmail to set
   *
   * @return  update preferHomeEmail
   */
  public boolean updatePreferHomeEmail(Integer preferHomeEmail) {
    if (isDifferent(preferHomeEmail, this.preferHomeEmail)) {
      this.preferHomeEmail = preferHomeEmail;

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update preferHomePhone.
   *
   * @param   preferHomePhone  the preferHomePhone to set
   *
   * @return  update preferHomePhone
   */
  public boolean updatePreferHomePhone(Integer preferHomePhone) {
    if (isDifferent(preferHomePhone, this.preferHomePhone)) {
      this.preferHomePhone = preferHomePhone;

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update preferMobilePhone.
   *
   * @param   preferMobilePhone  the preferMobilePhone to set
   *
   * @return  update preferMobilePhone
   */
  public boolean updatePreferMobilePhone(Integer preferMobilePhone) {
    if (isDifferent(preferMobilePhone, this.preferMobilePhone)) {
      this.preferMobilePhone = preferMobilePhone;

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update preferTextMessage.
   *
   * @param   preferTextMessage  the preferTextMessage to set
   *
   * @return  update preferTextMessage
   */
  public boolean updatePreferTextMessage(Integer preferTextMessage) {
    if (isDifferent(preferTextMessage, this.preferTextMessage)) {
      this.preferTextMessage = preferTextMessage;

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update preferWorkPhone.
   *
   * @param   preferWorkPhone  the preferWorkPhone to set
   *
   * @return  update preferWorkPhone
   */
  public boolean updatePreferWorkPhone(Integer preferWorkPhone) {
    if (isDifferent(preferWorkPhone, this.preferWorkPhone)) {
      this.preferWorkPhone = preferWorkPhone;

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateTemporaryAddress.
   *
   * @param   address  TemporaryContactAddress
   *
   * @return  boolean
   */
  public boolean updateTemporaryAddress(TemporaryContactAddress address) {
    // address and address type are needed
    if ((address == null) || (address.getAddressType() == null)
          || (address.getAddressType().getTypeId() == null)) {
      return false;
    }

    String                  typeId    = address.getAddressType().getTypeId().toString();
    TemporaryContactAddress myAddress = this.temporaryAddresses.get(typeId);
    Date                    now       = new Date();

    // The address must have at least address1 or address 2 or city or
    // province.
    // requires email address, otherwise refuse to update
    if (!address.hasAddressInfo()) {
      if ((myAddress == null) || (myAddress.getAddressType() == null)
            || (myAddress.getAddressType().getTypeId() == null)
            || (!myAddress.hasAddressInfo())) {
        return false;
      } else {
        // remove current address since it was cleared
        myAddress = this.temporaryAddresses.remove(typeId);
        myAddress.setHistorical(Boolean.TRUE);
        myAddress.setExitDate(now);
        myAddress.setLastUpdateDate(now);
        temporaryHistoricalAddresses.add(myAddress);

        return true;
      }
    }

    if (address.equals(myAddress)) {
      // the new address is the same,no need update
      return false;
    } else {
      if (myAddress == null) {
        // New address for this type - first look it up and see if the
        // passed in
        // address is already in historicalAddresses
        myAddress = lookupHistoricalAddress(address);

        if (myAddress == null) {
          myAddress = new TemporaryContactAddress();
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setResponsible(this);
          myAddress.setEntryDate(now);
          myAddress.deepCopy(address);
        } else {
          this.temporaryHistoricalAddresses.remove(myAddress);
          myAddress.setExitDate(null);
          myAddress.setHistorical(Boolean.FALSE);
          myAddress.setLastUpdateDate(now);
          myAddress.setSource(address.getSource());
        }

        this.temporaryAddresses.put(typeId, myAddress);
      } else {
        // Already has an address for this type, and it is different -
        // move the
        // old address to historical address
        // NOTE: We are sure there is no address in historicalAddress
        // that
        // equals this address.

        myAddress = this.temporaryAddresses.remove(typeId);
        myAddress.setHistorical(Boolean.TRUE);
        myAddress.setExitDate(now);
        myAddress.setLastUpdateDate(now);
        temporaryHistoricalAddresses.add(myAddress);

        TemporaryContactAddress newAddress = lookupHistoricalAddress(address);

        if (newAddress == null) {
          newAddress = new TemporaryContactAddress();
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setResponsible(this);
          newAddress.setEntryDate(now);
          newAddress.deepCopy(address);
        } else {
          temporaryHistoricalAddresses.remove(newAddress);
          newAddress.setExitDate(null);
          newAddress.setHistorical(Boolean.FALSE);
          newAddress.setLastUpdateDate(now);
          newAddress.setSource(address.getSource());
        }

        this.temporaryAddresses.put(typeId, newAddress);
      } // end if-else

      // update responsible zip code if it was a type '1'
      if (typeId.equals(
              ContactChannel.HOMEADDRESS.getTypeId().toString())
            && !isZipRequiredFull) {
        updateZipCode(address.getAddress().getPostalCode());
      } else if (typeId.equals(
              ContactChannel.HOMEADDRESS.getTypeId().toString())
            && isZipRequiredFull) {
        updateFullZipCode(address.getAddress().getPostalCode());
      }

      return true;
    } // end if-else
  }   // end method updateTemporaryAddress

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Have visited payment page.
   *
   * @return  have visited payment page
   */
  public boolean visitedPaymentPage() {
    if (webActivities.size() > 0) {
      for (WebActivity webActivity : webActivities) {
        // find the view payment
        if ((webActivity.getActivityChannel()
                == WebActivityChannel.DEBTORSITE)
              && (webActivity.getName().equalsIgnoreCase(
                  "p_paymentFormView"))) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the last view payment page date.
   *
   * @return  get the last view payment page date
   */
  public Date visitedPaymentPageDate() {
    if (webActivities.size() > 0) {
      for (WebActivity webActivity : webActivities) {
        // find the view payment
        if ((webActivity.getActivityChannel()
                == WebActivityChannel.DEBTORSITE)
              && (webActivity.getName().equalsIgnoreCase(
                  "p_paymentFormView"))) {
          return webActivity.getCreateDate();
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Mark all Contact Phones having the given phonenumber for this responsible.
   *
   * @param  phoneNum  DOCUMENT ME!
   * @param  status    DOCUMENT ME!
   */
  protected void markPhoneNum(String phoneNum, ContactStatus status) {
    Set<ContactPhone> ps = getContactPhonesbyPhoneNum(phoneNum);

    if ((ps != null) && (ps.size() > 0)) {
      for (ContactPhone p : ps) {
        p.setStatus(status);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static UpdateEmailActivity getUpdateEmailActivity(
    WebActivity webActivity) {
    String activityName = ACTION_LOG_PREFIX + UPDATE_EMAIL;

    if (!activityName.equals(webActivity.getName())) {
      return null;
    }

    UpdateEmailActivity activity = new UpdateEmailActivity();
    setBaseWebActivity(activity, webActivity);
    activity.setEmailType(webActivity.getData1());
    activity.setOldEmailAddress(webActivity.getData2());
    activity.setNewEmailAddress(webActivity.getData3());

    return activity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static void setBaseWebActivity(BaseWebActivity baseWebActivity,
    WebActivity webActivity) {
    if (webActivity.getAccount() != null) {
      baseWebActivity.setAccountNum(webActivity.getAccount().getAccountNum().toString());
    }

    baseWebActivity.setActivityId(webActivity.getActivityId().toString());
    baseWebActivity.setActivityName(webActivity.getName());
    baseWebActivity.setBalance(webActivity.getBalance());

    String[] localeStr = null;

    if (webActivity.getLocale() != null) {
      localeStr = webActivity.getLocale().split("_");
    }

    Locale locale = null;

    if ((localeStr != null) && (localeStr.length > 1)) {
      locale = new Locale(localeStr[0], localeStr[1]);
      baseWebActivity.setBrowserLanguage(locale.getDisplayLanguage());
    }

    baseWebActivity.setCreateDate(webActivity.getCreateDate());
    baseWebActivity.setDelinquencyDays(webActivity.getDelinquencyDays());
    baseWebActivity.setIpAddress(webActivity.getIPAddress());
    baseWebActivity.setLastUpdateDate(webActivity.getLastUpdateDate());
    baseWebActivity.setLocale(webActivity.getLocale());

    if (webActivity.getResponsible() != null) {
      baseWebActivity.setResponsibleId(webActivity.getResponsible().getResponsibleId().toString());
    }
  } // end method setBaseWebActivity

  //~ ------------------------------------------------------------------------------------------------------------------

  private ContactEmail createContactEmail(String email, EmailType type) {
    ContactEmail contactEmail = new ContactEmail();
    contactEmail.setEmailAddress(email);
    contactEmail.setEmailType(type);
    contactEmail.setSource(ContactSource.DEBTOR);
    contactEmail.setStatus(ContactStatus.UNVERIFIED);

    return contactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private ContactPhone createContactPhone(String phoneNumber, PhoneType phoneType) {
    ContactPhone contactPhone = new ContactPhone();
    contactPhone.setSource(ContactSource.DEBTOR);
    contactPhone.setStatus(ContactStatus.UNVERIFIED);
    contactPhone.setPhoneType(phoneType);
    contactPhone.setPhoneNum(phoneNumber);

    // TODO adding this for temporary CBA demo and we need a logn term solution in the workflow
    Portfolio portfolio = this.getAccount().getPortfolio();
    contactPhone.setCountryCode(portfolio.getDefaultCountry());
    contactPhone.setTelephoneCountryCode(portfolio.getDefaultTelephoneCountryCode());

    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private HardShip getCitiHardShipType() {
    HomeEquitySurvey survey = getCitiSurvey();

    if (survey != null) {
      return survey.getHardShipType();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private HomeEquityRefiSurvey getCitiRefiSurvey() {
    if ((homeEquityRefiSurveys == null)
          || (homeEquityRefiSurveys.size() == 0)) {
      return null;
    }

    Iterator<HomeEquityRefiSurvey> it     = homeEquityRefiSurveys.iterator();
    HomeEquityRefiSurvey           survey = it.next();

    return survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private HomeEquitySurvey getCitiSurvey() {
    if ((homeEquitySurveys == null) || (homeEquitySurveys.size() == 0)) {
      return null;
    }

    Iterator<HomeEquitySurvey> it     = homeEquitySurveys.iterator();
    HomeEquitySurvey           survey = it.next();

    return survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private void initCount() {
    if ((directCallCount == null) || (directCallCount < 0)) {
      directCallCount = 0;
    }

    if ((ivrInboundCount == null) || (ivrInboundCount < 0)) {
      ivrInboundCount = 0;
    }

    if ((rpcCount == null) || (rpcCount < 0)) {
      rpcCount = 0;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether two Integers are different. nulls are considered the same.
   *
   * @param   i1  Integer
   * @param   i2  Integer
   *
   * @return  check whether two Integers are different.
   */
  private boolean isDifferent(Integer i1, Integer i2) {
    if (((i1 == null) && (i2 != null)) || ((i1 != null) && (i2 == null))) {
      return true;
    }

    if ((i1 == null) && (i2 == null)) {
      return false;
    }

    return i1.intValue() != i2.intValue();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether two string are equal, empty and null string consider equal.
   *
   * @param   str1  String
   * @param   str2  String
   *
   * @return  check whether two string are equal, empty and null string consider equal
   */
  private boolean isEqualString(String str1, String str2) {
    if ((str1 == null) || str1.equals("")) {
      // currently is empty
      if ((str2 == null) || str2.equals("")) {
        // consider same
        return true;
      }
    } else {
      // there is a value in the preference
      if (str1.equals(str2)) {
        // is same
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private boolean updateFullZipCode(String zipCode) {
    // DB supports ten char zipCode , check if zipCode exceeds ten chars .
    String zip = StringUtils.hasText(zipCode) ? ((zipCode.length() > 10) ? zipCode.substring(0, 10) : zipCode) : "";

    if (isEqualString(this.zipCode, zip)) {
      return false;
    } else {
      this.zipCode        = zip;
      this.password       = zip;
      this.zipCodeChanged = true;

      return true;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private boolean updateZipCode(String zipCode) {
    String zip = ((zipCode == null) || (zipCode.length() <= 5)) ? zipCode : zipCode.substring(0, 5);

    if (isEqualString(this.zipCode, zip)) {
      return false;
    } else {
      if (StringUtils.hasText(zipCode)) {
        this.zipCode = zipCode;

        if (zipCode.length() > 5) {
          this.password = zipCode.substring(0, 5);
          this.zipCode  = this.password;
        } else {
          this.password = zipCode;
        }

        this.zipCodeChanged = true;

        return true;
      }

      return false;
    }
  } // end method updateZipCode
} // end class Responsible
