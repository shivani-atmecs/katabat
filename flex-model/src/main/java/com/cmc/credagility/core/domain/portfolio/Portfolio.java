package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import org.apache.commons.lang3.StringUtils;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmc.credagility.core.domain.CurrencySymbolPosition;
import com.cmc.credagility.core.domain.address.Timezone;
import com.cmc.credagility.core.domain.barclay.BarclayProgramCode;
import com.cmc.credagility.core.domain.client.Client;
import com.cmc.credagility.core.domain.client.Industry;
import com.cmc.credagility.core.domain.config.FlexSelectConfig;
import com.cmc.credagility.core.domain.event.Event;
import com.cmc.credagility.core.domain.payment.PaymentFeeConfiguration;
import com.cmc.credagility.core.domain.payment.PaymentServiceProvider;
import com.cmc.credagility.core.domain.payment.PtpPaymentMethodConfiguration;
import com.cmc.credagility.core.domain.queue.QueueSchedule;
import com.cmc.credagility.core.domain.sor.TransactionBatchHeader;
import com.cmc.credagility.core.domain.sor.TransactionCode;
import com.cmc.credagility.core.domain.survey.SurveyFlowVariable;
import com.cmc.credagility.core.domain.type.InvoiceCategory;
import com.cmc.credagility.core.domain.user.Division;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverterForPortfolio;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.ozstrategy.credagility.core.domain.PortfolioScoreType;
import com.ozstrategy.credagility.core.domain.Schedule;


/**
 * This class is used to store Client Portfolio information.
 *
 * <p><a href="Portfolio.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 *
 *           <p>table = "Portfolio"</p>
 */
@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property  = "portfolioId",
  scope     = Portfolio.class
)
@NamedEntityGraph(
  name           = "Portfolio.events",
  attributeNodes = @NamedAttributeNode("events")
)
@Table(
  name              = "Portfolio",
  uniqueConstraints = { @UniqueConstraint(columnNames = "name") }
)
public class Portfolio extends AbstractPortfolio implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** if @flexSiteMaxSubMenuWorkflowCount is null or empty then return this value. */
  public static final Integer DEFAULT_FLEXSITE_MAX_SUB_MENU_WORKFLOW_COUNT = 6;

  /** TODO: DOCUMENT ME! */
  public static final String POPUP = "P";

  /** TODO: DOCUMENT ME! */
  public static final String TAG = "T";

  private static final long serialVersionUID = 6350789036069647879L;

  /** DOCUMENT ME! */
  protected static final transient Logger logger = LoggerFactory.getLogger(Portfolio.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> accept the program short term. */
  @Column(
    name             = "acceptedProgramShortTerm",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean acceptedProgramShortTerm = false;

  /** <code>true</code> accept program with outstanding promise. */
  @Column(
    name             = "acceptProgramWithOutstandingPromise",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean acceptProgramWithOutstandingPromise = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Transient protected Set<BaseVariable> accessibleVariables = new HashSet<BaseVariable>();

  /** Account level disclosure. */
  @Column(
    name     = "accountLevelDisclosure",
    nullable = true,
    length   = 1
  )
  protected String accountLevelDisclosure;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "accrueInterest",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean accrueInterest = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "addressline1mandatory",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean addressline1mandatory = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowBankcard",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowBankcard = false;

  /** <code>true</code> allow dynamic program. */
  @Column(
    name             = "allowDynamicProgram",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowDynamicProgram = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowEditTelephoneCountryCode",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowEditTelephoneCountryCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowFlexSiteOverLimitMessage",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowFlexSiteOverLimitMessage = false;

  /**
   * <code>true</code> allow hot spot. It will trigger in flex site If <code>false</code> the workflow won't trigger in
   * flex site
   */
  @Column(
    name             = "allowHotSpot",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowHotSpot = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowInactiveAccountsDisposition",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowInactiveAccountsDisposition = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowOverBalancePayment",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowOverBalancePayment = false;

  /** allowSPOC: allow single point of contact */
  @Column(
    name             = "allowSPOC",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSPOC = false;

  /** <code>true</code> allow trigger survey. */
  @Column(
    name             = "allowSurvey",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSurvey = false;

  /** <code>true</code> allow re-accept offer default is <code>false.</code> */
  @Column(
    name             = "awAllowReacceptOffer",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean awAllowReacceptOffer = Boolean.FALSE;

  /** <code>true</code> allow cancel offer delete payment default is <code>false.</code> */
  @Column(
    name             = "awCancelOfferDeletePayment",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean awCancelOfferDeletePayment = Boolean.FALSE;

  /** <code>true</code> allow display address line 3, default is <code>false.</code> */
  @Column(
    name             = "awDisplayAddressLine3",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean awDisplayAddressLine3 = Boolean.FALSE;

  /** <code>true</code> allow display offer documents, default is <code>false.</code> */
  @Column(
    name             = "awDisplayOffersDocuments",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean awDisplayOffersDocuments = Boolean.FALSE;

  /** <code>true</code> allow display offer score, default is <code>false.</code> */
  @Column(
    name             = "awDisplayOffersScore",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean awDisplayOffersScore = Boolean.FALSE;

  /** <code>true</code> allow display province, default is <code>false.</code> */
  @Column(
    name             = "awDisplayProvince",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean awDisplayProvince = Boolean.TRUE;

  /**
   * <code>true</code> allow inactive account read only. When <code>true</code> user can read the data only, but can not
   * do any operation(create, update, delete), default is <code>true</code>
   */
  @Column(
    name             = "awInactiveAccountReadOnly",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean awInactiveAccountReadOnly = Boolean.TRUE;

  /**
   * phone number format, if this not null the phone number will be formatted by this <code>phoneNumberFormat:
   * ###-###-### phoneNumber: 332998001 the result will be: 332-229-001</code>
   */
  @Column(
    name   = "awPhoneNumberFormat",
    length = 20
  )
  protected String awPhoneNumberFormat;

  /** client. */
  @JoinColumn(
    name      = "clientId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Client client;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "currencySymbolPosition",
    nullable = true,
    length   = 30
  )
  @Enumerated(EnumType.STRING)
  protected CurrencySymbolPosition currencySymbolPosition = CurrencySymbolPosition.PREFIX;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "defaultLocale",
    length = 10
  )
  protected String defaultLocale;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "defaultTelephoneCountryCode",
    length = 10
  )
  protected String defaultTelephoneCountryCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "enforceComplianceOnDialPad",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enforceComplianceOnDialPad = true;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "flexStationDispositionCommentSize",
    length = 11
  )
  protected Integer flexStationDispositionCommentSize;

  /** <code>true</code> allow force promise with accept program, default is <code>false.</code> */
  @Column(
    name             = "forcePromiseWithAcceptProgram",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean forcePromiseWithAcceptProgram = Boolean.FALSE;

  /** client Industry. */
  @JoinColumn(
    name      = "industryId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Industry industry;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "interestStartDate",
    nullable = true,
    length   = 1
  )
  protected String interestStartDate;

  /**
   * The category of invoice.
   *
   * @see  com.cmc.credagility.core.domain.type.InvoiceCategory
   */
  @Column(
    name     = "invoiceCategory",
    nullable = true,
    length   = 30
  )
  @Enumerated(EnumType.STRING)
  protected InvoiceCategory invoiceCategory;

  /** <code>true</code> allow mra indicator, default is <code>false.</code> */
  @Column(
    name             = "mraIndicator",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean mraIndicator = false;

  /** portfolio name, default is "Default". */
  @Column(
    name     = "name",
// unique   = true,
    nullable = false,
    length   = 80
  )
  protected String name = "Default";

  /**
   * <code>true</code> is active, if <code>true</code> this portfolio is readable, else this portfolio is not readable,
   * default is <code>true.</code>
   */
  @Column(
    name             = "active",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active = Boolean.TRUE;

  /** the time zone Id of the agents who execute the appointments. */
  @Column(
    name     = "agentTimeZoneId",
    nullable = false,
    length   = 45
  )
  protected String agentTimeZoneId = "US/Eastern";

  /** <code>true</code> allow debit, default is <code>false.</code> */
  @Column(
    name             = "allowACH",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverterForPortfolio.class)
  protected Boolean allowACH = false;

  /** <code>true</code> allow american express, default is <code>false.</code> */
  @Column(
    name             = "allowAmericanExpress",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowAmericanExpress = false;

  /** allow call on Saturday. */
  @Column(
    name             = "allowCallOnSaturday",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowCallOnSaturday = false;

  /** allow call on Sunday. */
  @Column(
    name             = "allowCallOnSunday",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowCallOnSunday = false;

  /** <code>true</code> allow credit, default is <code>false.</code> */
  @Column(
    name             = "allowCredit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverterForPortfolio.class)
  protected Boolean allowCredit = false;

  /** <code>true</code> allow debit, default is <code>false.</code> */
  @Column(
    name             = "allowDebit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverterForPortfolio.class)
  protected Boolean allowDebit = false;

  /** <code>true</code> allow diner club, default is <code>false.</code> */
  @Column(
    name             = "allowDinersClub",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowDinersClub = false;

  /** <code>true</code> allow discover, default is <code>false.</code> */
  @Column(
    name             = "allowDiscover",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowDiscover = false;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.ALL }
  )
  protected Set<PortfolioChannelType> allowedChannelTypes = new LinkedHashSet<PortfolioChannelType>();

  /** <code>true</code> allow edit contact. */
  @Column(
    name             = "allowEditContact",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowEditContact;

  /** <code>true</code> allow JCB, default is <code>false.</code> */
  @Column(
    name             = "allowJCB",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowJCB = false;


  /** <code>true</code> support master card, default is <code>false.</code> */
  @Column(
    name             = "allowMasterCard",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowMasterCard = false;

  /** <code>true</code> allow multiple promise, default is <code>false.</code> */
  @Column(
    name             = "allowMultiplePromises",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowMultiplePromises = false;

  /** <code>true</code> allow split payment, default is <code>false.</code> */
  @Column(
    name             = "allowSplitPayment",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSplitPayment = false;

  /** <code>true</code> allow update contact info, default is <code>true.</code> */
  @Column(
    name             = "allowUpdateContact",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowUpdateContact = Boolean.TRUE;

  /** <code>true</code> support VISA, default is <code>false.</code> */
  @Column(
    name             = "allowVisa",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowVisa = false;

  /** <code>true</code> allow VISA debit, default is <code>false.</code> */
  @Column(
    name             = "allowVisaDebit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowVisaDebit = false;

  /** <code>true</code> allow VISA electron, default is <code>false.</code> */
  @Column(
    name             = "allowVisaElectron",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowVisaElectron = false;


  /** appointment end day offset from now. Similar to start day offset */
  @Column(
    name     = "apptEndDaysFromNow",
    nullable = false
  )
  protected Integer apptEndDaysFromNow = 30;

  /** appointment end hour offset from now. Similar to start day offset */
  @Column(
    name     = "apptEndHoursFromNow",
    nullable = false
  )
  protected Integer apptEndHoursFromNow = 0;

  /** appointment arrange end time, in format 20:00:00 (24h). */
  @Column(
    name     = "apptEndTime",
    length   = 8,
    nullable = false
  )
  protected String apptEndTime = "20:00:00";

  /** appointment arrange end time, in format 20:00:00 (24h). */
  @Column(
    name   = "apptEndTimeFriday",
    length = 8
  )
  protected String apptEndTimeFriday = null;

  /** appointment arrange end time, in format 20:00:00 (24h). */
  @Column(
    name   = "apptEndTimeMonday",
    length = 8
  )
  protected String apptEndTimeMonday = null;

  /** appointment arrange end time, in format 20:00:00 (24h). */
  @Column(
    name   = "apptEndTimeSaturday",
    length = 8
  )
  protected String apptEndTimeSaturday = null;

  /** appointment arrange end time, in format 20:00:00 (24h). */
  @Column(
    name   = "apptEndTimeSunday",
    length = 8
  )
  protected String apptEndTimeSunday = null;

  /** appointment arrange end time, in format 20:00:00 (24h). */
  @Column(
    name   = "apptEndTimeThursday",
    length = 8
  )
  protected String apptEndTimeThursday = null;

  /** appointment arrange end time, in format 20:00:00 (24h). */
  @Column(
    name   = "apptEndTimeTuesday",
    length = 8
  )
  protected String apptEndTimeTuesday = null;

  /** appointment arrange end time, in format 20:00:00 (24h). */
  @Column(
    name   = "apptEndTimeWednesday",
    length = 8
  )
  protected String apptEndTimeWednesday = null;

  /** Application languages, such as English, Spanish etc. */
  @Column(
    name     = "apptLanguages",
    length   = 200,
    nullable = false
  )
  protected String apptLanguages = "English, Spanish";


  /**
   * appointment start day offset from now. Note the earliest appt date time is now.plus(new
   * Period().withDays(apptStartDaysFromNow).withHours(apptStartHoursFromNow)
   */
  @Column(
    name     = "apptStartDaysFromNow",
    nullable = false
  )
  protected Integer apptStartDaysFromNow = 0;

  /** appointment start hour offset from now. */
  @Column(
    name     = "apptStartHoursFromNow",
    nullable = false
  )
  protected Integer apptStartHoursFromNow = 0;

  /** appointment arrange start time, in format 8:00:00 (24h). */
  @Column(
    name     = "apptStartTime",
    length   = 8,
    nullable = false
  )
  protected String apptStartTime = "8:00:00";

  /** appointment arrange start time, in format 8:00:00 (24h). */
  @Column(
    name   = "apptStartTimeFriday",
    length = 8
  )
  protected String apptStartTimeFriday = null;

  /** appointment arrange start time, in format 8:00:00 (24h). */
  @Column(
    name   = "apptStartTimeMonday",
    length = 8
  )
  protected String apptStartTimeMonday = null;

  /** appointment arrange start time, in format 8:00:00 (24h). */
  @Column(
    name   = "apptStartTimeSaturday",
    length = 8
  )
  protected String apptStartTimeSaturday = null;

  /** appointment arrange start time, in format 8:00:00 (24h). */
  @Column(
    name   = "apptStartTimeSunday",
    length = 8
  )
  protected String apptStartTimeSunday = null;

  /** appointment arrange start time, in format 8:00:00 (24h). */
  @Column(
    name   = "apptStartTimeThursday",
    length = 8
  )
  protected String apptStartTimeThursday = null;

  /** appointment arrange start time, in format 8:00:00 (24h). */
  @Column(
    name   = "apptStartTimeTuesday",
    length = 8
  )
  protected String apptStartTimeTuesday = null;

  /** appointment arrange start time, in format 8:00:00 (24h). */
  @Column(
    name   = "apptStartTimeWednesday",
    length = 8
  )
  protected String apptStartTimeWednesday = null;

  /** Agent Inactive Time. */
  @Column(name = "awAgentInactiveTime")
  protected Integer awAgentInactiveTime = 0;

  /** Date format. */
  @Column(
    nullable = true,
    length   = 20
  )
  protected String awDateFormat;

  /** TODO: DOCUMENT ME! */
  @Column(name = "awMaxDaysCreateFutureSendDateSecuredPromise")
  protected Integer awMaxDaysCreateFutureSendDateSecuredPromise = 10;

  /** TODO: DOCUMENT ME! */
  @Column(name = "awMaxDaysCreateFutureSendDateUnsecuredPromise")
  protected Integer awMaxDaysCreateFutureSendDateUnsecuredPromise = 10;

  /** TODO: DOCUMENT ME! */
  @Column(name = "awMaxDaysCreatePastSendDateUnsecuredPromise")
  protected Integer awMaxDaysCreatePastSendDateUnsecuredPromise = 10;

  /** TODO: DOCUMENT ME! */
  @Column(name = "awMaxDaysSendArrivalDateSecuredPromise")
  protected Integer awMaxDaysSendArrivalDateSecuredPromise = 10;

  /** TODO: DOCUMENT ME! */
  @Column(name = "awMaxDaysSendArrivalDateUnsecuredPromise")
  protected Integer awMaxDaysSendArrivalDateUnsecuredPromise = 10;

  /** If this config, it will show <code>awMessageCount</code> 'Notes' in flexStation, default is 5. */
  @Column(
    name     = "awMessageCount",
    nullable = true
  )
  protected Integer awMessageCount;

  /** <code>true</code> read only mode, default is <code>false.</code> */
  @Column(
    name             = "awReadOnly",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean awReadOnly = Boolean.FALSE;

  /** The Time format. */
  @Column(
    nullable = true,
    length   = 20
  )
  protected String awTimeFormat;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio"
  )
  protected Set<BarclayProgramCode> barclayProgramCodes = new LinkedHashSet<BarclayProgramCode>();


  /** DOCUMENT ME! */
  @Column(name = "blockWebEditDeletePTPDays")
  protected Integer blockWebEditDeletePTPDays;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.ALL }
  )
  @Where(clause = "effectiveDate=CURdate()")
  protected Set<BucketDelinquentData> bucketDelinquentData = new LinkedHashSet<BucketDelinquentData>();

  /** <code>true</code> allow cancel program, default is <code>false.</code> */
  @Column(
    name             = "cancelProgram",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean cancelProgram = false;

  /** TODO: DOCUMENT ME! */
  @MapKeyColumn(name = "channelTypeId")
  @OneToMany(
    cascade  = javax.persistence.CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio"
  )
  protected Map<String, PortfolioChannelExportConfiguration> channelExportConfigurations =
    new HashMap<String, PortfolioChannelExportConfiguration>();

  /**
   * Assign portfolio channel template.
   *
   * @see  com.cmc.credagility.core.domain.portfolio.PortfolioChannelTemplate
   */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.ALL }
  )
  @OrderBy("channelType ASC")
  @Where(clause = "active = 'Y'")
  protected Set<PortfolioChannelTemplate> channelTemplates = new LinkedHashSet<PortfolioChannelTemplate>();

  /** Channel vender account. */
  @Column(length = 20)
  protected String channelVendorAccount;

  /** charge off of days. */
  @Column(
    name   = "chargeOffDays",
    length = 5
  )
  protected Integer chargeOffDays;

  /** Commission rate <code>BigDecimal.</code> */
  @Column(
    name      = "commissionRate",
    precision = 19,
    scale     = 4
  )
  protected BigDecimal commissionRate;

  // npelleti 08/17 Set CurrencySymbol to 4 and moved after commissionRate
  /**
   * The Current symbol, if this not null, then all of data in this portfolio will use the same current symbol. <code>
   * Such as $, ¢ etc.</code>
   */
  @Column(
    name   = "currencySymbol",
    length = 4
  )
  protected String currencySymbol;

  /** Default arrival Date <code>Long.</code> */
  @Column(
    name   = "defaultArrivalDate",
    length = 20
  )
  protected Long defaultArrivalDate;

  /** Default Country. */
  @Column(
    name     = "defaultCountry",
    length   = 3,
    nullable = false
  )
  protected String defaultCountry;

  /** default payment reminder days. */
  @Column(
    name     = "defaultPaymentReminderDays",
    nullable = false
  )
  protected Integer defaultPaymentReminderDays = 10;

  /** <code>true</code> allow delete promise with cancel program, default is <code>false.</code> */
  @Column(
    name             = "deletePromiseWithCancelProgram",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deletePromiseWithCancelProgram = Boolean.FALSE;

  // npelleti 08/16, USB Alter column description after
  // defaultPaymentReminderDays
  /** protfolio description. */
  @Column(
    name   = "description",
    length = 1024
  )
  protected String description;

  /** Disclosure group name. */
  @Column(
    name     = "disclosureGroupName",
    nullable = true,
    length   = 20
  )
  protected String disclosureGroupName;

  /** How many rows will display. */
  @Column protected Integer displayRow = 4;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.REMOVE }
  )
  @OrderBy("displayOrder asc")
  protected Set<PortfolioDisplayVariable> displayVariables = new LinkedHashSet<PortfolioDisplayVariable>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.ALL }
  )
  protected Set<Division> divisions = new LinkedHashSet<Division>();

  /** If null, default is 1. Days do not contact for Appt . */
  @Column(name = "doNotContactApptDays")
  protected Integer doNotContactApptDays;

  /** If null, default is 3. Days do not contact for all other actions. */
  @Column(name = "doNotContactDefaultDays")
  protected Integer doNotContactDefaultDays;

  /** If null default is 1 meaning will not contact until 1 day after payment Date. */
  @Column(name = "doNotContactPaymentDays")
  protected Integer doNotContactPaymentDays;

  /** If null, default is 1. Days do not contact for normal PTP */
  @Column(name = "doNotContactPTPDays")
  protected Integer doNotContactPTPDays;

  /** If null, default is 5. Days do not contact for RPC. */
  @Column(name = "doNotContactRpcDays")
  protected Integer doNotContactRpcDays;

  /** If null, default is 1. Days do not contact for Western Union / MoneyGram PTP */
  @Column(name = "doNotContactWUPTPDays")
  protected Integer doNotContactWUPTPDays;

  /** appointment duration, in minutes. */
  @Column(
    name     = "duration",
    nullable = false
  )
  protected Integer duration = 30;


  /** Letter signer name. */
  @Column(
    name     = "editAccountContactInfoFlexSite",
    nullable = false,
    length   = 1
  )
  protected String editAccountContactInfoFlexSite;


  /** Letter signer name. */
  @Column(
    name     = "editDeleteScheduledPaymentFlexSite",
    nullable = false,
    length   = 1
  )
  protected String editDeleteScheduledPaymentFlexSite;


  /** <code>true</code> enable check duplicate phone, default is <code>false.</code> */
  @Column(
    name             = "enableCheckDuplicatePhone",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enableCheckDuplicatePhone = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "enableFlexSitePTP",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enableFlexSitePTP = false;


  /** DOCUMENT ME! */
  @Column(nullable = true)
  @Type(type = "yes_no")
  protected Boolean enablePaymentDisclosureText = false;

  /** DOCUMENT ME! */
  @Column(
    name             = "enableProgramOfferDisclosureText",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enableProgramOfferDisclosureText = false;

  /** <code>true</code> enable program tracking configuration, default is <code>false.</code> */
  @Column(
    name             = "enableProgramTrackingConfig",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enableProgramTrackingConfig = false;

  /** DOCUMENT ME! */
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean encryptScreenPopUrlSensitiveData = Boolean.TRUE;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected Set<Event> events = new LinkedHashSet<Event>();

  /** <code>true</code> allow expression content, default is <code>false.</code> */
  @Column(
    name             = "expressConsent",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean expressConsent = false;

  /** Expression consent display, default is <code>TAG.</code> */
  @Column(
    name   = "expressConsentDisplay",

    // nullable = true,
    length = 1
  )
  protected String expressConsentDisplay = TAG;

  /** External reference id. */
  @Column(
    name     = "externalReferenceId",
    nullable = true,
    length   = 30
  )
  protected String externalReferenceId;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected Set<FlexSelectConfig> flexSelectConfigs = new LinkedHashSet<FlexSelectConfig>();

  /** <code>true</code> allow flex site auto load primary survey, default is <code>true.</code> */
  @Column(
    name             = "flexSiteAutoLoadPrioritySurvey",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean flexSiteAutoLoadPrioritySurvey = true;


  /**
   * DOCUMENT ME! more details please review ticket CA-3460
   *
   * @url  https://jira.cmcassist.com/browse/CA-3480
   */
  @Column(length = 3)
  protected Integer flexSiteMaxSubMenuWorkflowCount;

  /** <code>true</code> allow flex site confirmation when payment, default is <code>false.</code> */
  @Column(
    name             = "flexSiteSurveyAsPaymentConfirmation",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean flexSiteSurveyAsPaymentConfirmation = false;

  /** <code>true</code> allow flex site confirmation when promise, default is <code>false.</code> */
  @Column(
    name             = "flexSiteSurveyAsProgramConfirmation",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean flexSiteSurveyAsProgramConfirmation = false;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.ALL }
  )
  @Where(clause = "variableType = 'SurveyFlow'")
  protected Set<SurveyFlowVariable> flowVariables = new LinkedHashSet<SurveyFlowVariable>();

  /** Fort nightly program tracking period. */
  @Column(nullable = true)
  protected Integer fortnightlyProgramTrackingPeriod;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.ALL }
  )
  protected Set<FrequencyDuration> frequencyDurations = new LinkedHashSet<FrequencyDuration>();

  /** The help email address. */
  @Column(
    name   = "helpEmail",
    length = 128
  )
  protected String helpEmail;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "hideFlexSiteHeaderandFooter",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean hideFlexSiteHeaderandFooter;

  /** Hours. */
  @Column(
    name     = "hours",
    nullable = false,
    length   = 150
  )
  protected String hours;

  /** DOCUMENT ME! */
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isScreenPopUrlCustomUniqueIdEncrypted = Boolean.FALSE;

  /** The phone number for agent ivr. */
  @Column(
    name     = "ivrAgentPhoneNum",
    nullable = false,
    length   = 20
  )
  protected String ivrAgentPhoneNum;

  /** The phone number for ivr. */
  @Column(
    name     = "ivrPhoneNum",
    nullable = false,
    length   = 20
  )
  protected String ivrPhoneNum;

  /** The java date format. */
  @Column(
    nullable = true,
    length   = 20
  )
  protected String javaDateFormat;

  /** the java time format. */
  @Column(
    nullable = true,
    length   = 20
  )
  protected String javaTimeFormat;

  // npelleti 08/16 Alter column length 100
  /** Which page will show after login success. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String landingView = "/html/acctSummary";


  /** DOCUMENT ME! */
  @Column(
    name     = "latestPlacementDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date latestPlacementDate;

  /** Letter signer name. */
  @Column(
    name     = "letterSignerName",
    nullable = false,
    length   = 150
  )
  protected String letterSignerName;

  /** Login captcha threshold default is <code>3.</code> */
  @Column(name = "loginCaptchaThreshold")
  protected Integer loginCaptchaThreshold = 3;

  /** Logo name. */
  @Column(
    name     = "logoName",
    nullable = false,
    length   = 100
  )
  protected String logoName;

  /** Maximum number of recurring promise allowed default is <code>1.</code> */
  @Column(
    name     = "maxNumberOfRecurringPromisesAllowed",
    nullable = true
  )
  protected Integer maxNumberOfRecurringPromisesAllowed = 1;

  /** Minimum days of create arrival date promise default is <code>10.</code> */
  @Column(
    name     = "minDaysCreateArrivalDatePromise",
    nullable = true
  )
  protected Integer minDaysCreateArrivalDatePromise = 10;

  /** minimum payment accept. */
  @Column(
    name     = "minPayment",
    nullable = false
  )
  protected BigDecimal minPayment = new BigDecimal(25.0);

  /** Monthly Program tracking period. */
  @Column(nullable = true)
  protected Integer monthlyProgramTrackingPeriod;

  /** Notify BCC email address. */
  @Column(
    name   = "notifyBccEmails",
    length = 255
  )
  protected String notifyBccEmails;

  /** Notify CC email address. */
  @Column(
    name   = "notifyCcEmails",
    length = 255
  )
  protected String notifyCcEmails;

  /** The subject for notify email. */
  @Column(
    name   = "notifySubject",
    length = 255
  )
  protected String notifySubject;

  /** The template for notify email. */
  @Column(
    name   = "notifyTemplate",
    length = 100
  )
  protected String notifyTemplate;

  /** Send to email address. */
  @Column(
    name   = "notifyToEmails",
    length = 255
  )
  protected String notifyToEmails;


  /** Offer restriction days default is <code>0.</code> */
  @Column(
    name   = "offerRestrictionDays",
    length = 2
  )
  protected Integer offerRestrictionDays = 0;

  /** Original creditor. */
  @Column(
    name   = "originalCreditor",
    length = 128
  )
  protected String originalCreditor = null;


  /** <code>true</code> over ride phone type express consent. */
  @Column(
    name             = "overRidePhoneTypeExpressConsent",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean overRidePhoneTypeExpressConsent;

  /** Payable name. */
  @Column(
    name     = "payableName",
    nullable = false,
    length   = 150
  )
  protected String payableName;

  /** Payment address. */
  @Column(
    name     = "paymentAddress1",
    nullable = false,
    length   = 150
  )
  protected String paymentAddress1 = "";

  /** Payment address 2. */
  @Column(
    name   = "paymentAddress2",
    length = 150
  )
  protected String paymentAddress2 = "";

  /** the max days from now on which debtor can schedule a payment. */
  @Column(
    name     = "paymentAdvanceDays",
    nullable = false
  )
  protected Integer paymentAdvanceDays = 90;

  /** Payment city. */
  @Column(
    name     = "paymentCity",
    nullable = false,
    length   = 50
  )
  protected String paymentCity = "";

  /** Payment country. */
  @Column(
    name     = "paymentCountry",
    nullable = false,
    length   = 100
  )
  protected String paymentCountry = "";

  /** <code>true</code> enable payment reminder, default is <code>false.</code> */
  @Column(
    name             = "paymentEmailReminder",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean paymentEmailReminder = false;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.ALL }
  )
  protected Set<PaymentFeeConfiguration> paymentFeeConfigurations = new LinkedHashSet<PaymentFeeConfiguration>();

  /** Payment post code. */
  @Column(
    name     = "paymentPostalCode",
    nullable = false,
    length   = 15
  )
  protected String paymentPostalCode = "";

  /** DOCUMENT ME! */
  @Column(
    name     = "paymentProviderIdSelector",
    nullable = true,
    length   = 255
  )
  protected String paymentProviderIdSelector;

  /** Payment province. */
  @Column(
    name     = "paymentProvince",
    nullable = false,
    length   = 100
  )
  protected String paymentProvince = "";

  /** paymentServiceId: to be sent to pmt service provider */
  @Column(
    name   = "paymentServiceId",
    length = 20
  )
  protected String paymentServiceId;

  /** payment service provider. */
  @JoinColumn(
    name     = "providerId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentServiceProvider paymentServiceProvider;

  /** <code>true</code> enable payment reminder, default is <code>false.</code> */
  @Column(
    name             = "paymentSMSReminder",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean paymentSMSReminder = false;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio"
  )
  protected Set<PortfolioAgentDispositionCode> portfolioAgentDispositionCode =
    new LinkedHashSet<PortfolioAgentDispositionCode>();

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio"
  )
  @OrderBy("portfolioApptReasonId asc")
  @Where(clause = "disable is null or disable='N'")
  protected Set<PortfolioApptReason> portfolioApptReasons = new LinkedHashSet<PortfolioApptReason>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio"
  )
  protected Set<PortfolioCardType> portfolioCardTypes = new LinkedHashSet<PortfolioCardType>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio"
  )
  @OrderBy("cycleNumber asc")
  protected Set<PortfolioCycleDate> portfolioCycleDates = new LinkedHashSet<PortfolioCycleDate>();

  // npelleti 08/16 USB Removed unique constraint.
  /** portfolio PK portfolioId. */
  @Column(
    name     = "portfolioId", /* unique = true, */
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioId;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio"
  )
  @OrderBy("priority asc")
  protected Set<PortfolioOutcomeType> portfolioOutcomeTypes = new LinkedHashSet<PortfolioOutcomeType>();

  /** <code>true</code> allow post charge off pay by date validate. */
  @Column(
    name             = "postChargeOffPayByDateValidate",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean postChargeOffPayByDateValidate;

  /** Post charge off pay by date validate type. */
  @Column(
    name   = "postChargeOffPayByDateValidateType",
    length = 10
  )
  protected String postChargeOffPayByDateValidateType;

  /** <code>true</code> allow pre charge off pay by date validate. */
  @Column(
    name             = "preChargeOffPayByDateValidate",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean preChargeOffPayByDateValidate;

  // Added by Etisbew on 05/13/09 for DFS Cycle Date-START
  /** Pre charge off pay by date validate type. */
  @Column(
    name   = "preChargeOffPayByDateValidateType",
    length = 10
  )
  protected String preChargeOffPayByDateValidateType;


  /** payment processing fee for this portfolio, default is 0.0. */
  @Column(
    name     = "processingFee",
    nullable = false
  )
  protected BigDecimal processingFee = new BigDecimal(0.0);


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "programDetailSection",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean programDetailSection = false;

  /** payment program first due date period,default is 7. */
  @Column(
    name     = "programFirstDueDate",
    nullable = false
  )
  protected Integer programFirstDueDate = 7;

  /** Program template count. */
  @Column(
    name     = "programTemplateCount",
    nullable = true
  )
  protected Integer programTemplateCount;

  /** Promise to pay evaluate tolerance days, default is <code>2.</code> */
  @Column(
    name     = "ptpEvalToleranceDays",
    nullable = true
  )
  protected Integer ptpEvalToleranceDays = 2;

  /** Relation Portfolio PtpPaymentMethodConfiguration: */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected Set<PtpPaymentMethodConfiguration> ptpPaymentMethodConfigurations =
    new LinkedHashSet<PtpPaymentMethodConfiguration>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected Set<PortfolioQuestion> questions = new LinkedHashSet<PortfolioQuestion>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected Set<QueueSchedule> queueSchedules = new LinkedHashSet<QueueSchedule>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "realtimeAccountDetails",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean realtimeAccountDetails;

  /** Number of activities to display in the Most Recent Activities . */
  @Column(name = "recentActivitiesNumber")
  protected Integer recentActivitiesNumber = 5;

  /** Which URL will redirect. */
  @Column(
    name   = "redirectURL",
    length = 255
  )
  protected String redirectURL;

  /** Return address. */
  @Column(
    name     = "returnAddress1",
    nullable = false,
    length   = 150
  )
  protected String returnAddress1 = "";

  /** Return address 2. */
  @Column(
    name   = "returnAddress2",
    length = 150
  )
  protected String returnAddress2 = "";

  /** Return City. */
  @Column(
    name     = "returnCity",
    nullable = false,
    length   = 50
  )
  protected String returnCity = "";

  /** Return country. */
  @Column(
    name     = "returnCountry",
    nullable = false,
    length   = 100
  )
  protected String returnCountry = "";

  /** Return post code. */
  @Column(
    name     = "returnPostalCode",
    nullable = false,
    length   = 15
  )
  protected String returnPostalCode = "";

  /** Return province. */
  @Column(
    name     = "returnProvince",
    nullable = false,
    length   = 100
  )
  protected String returnProvince = "";


  /** <code>true</code> allow save reminder email. */
  @Column(
    name             = "saveReminderEmail",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean saveReminderEmail = false;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = javax.persistence.CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio"
  )
  @Where(clause = "scheduleStatus='ACTIVE' or scheduleStatus='OLD'")
  protected Set<Schedule> schedules = new LinkedHashSet<Schedule>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected Set<PortfolioScoreType> scoreTypes = new LinkedHashSet<PortfolioScoreType>();

  /** DOCUMENT ME! */
  @Column(name = "screenPopUrlCustomUniqueIdSQL")
  @Type(type = "text")
  protected String screenPopUrlCustomUniqueIdSQL;

  /** <code>true</code> allow send MQ request, default is <code>false.</code> */
  @Column(
    name             = "sendMQRequest",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean sendMQRequest = false;

  /** <code>true</code> allow send MQ request, default is <code>false.</code> */
  @Column(
          name             = "allowCustomerPortalSendMQRequest",
          columnDefinition = "char",
          length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowCustomerPortalSendMQRequest = false;

  /** show appointment description. */
  @Column(
    name             = "showApptComment",
    columnDefinition = "char",
    length           = 1,
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showApptComment = true;

  /** <code>true</code> allow show country. */
  @Column(
    name             = "showCountry",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showCountry;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "showCountryCode",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showCountryCode;

  /** <code>true</code> allow show over limit, default is <code>false.</code> */
  @Column(
    name             = "showOverLimit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showOverLimit = false;

  /** <code>true</code> allow speed bump, default is <code>false.</code> */
  @Column(
    name             = "speedBump",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean speedBump = false;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.ALL }
  )
  @OrderBy("pageName ASC")
  protected Set<PortfolioStaticPage> staticPages = new LinkedHashSet<PortfolioStaticPage>();

  /** Survey default locale, such as <code>EN-US.</code> */
  @Column(
    name   = "surveyDefaultLocale",
    length = 64
  )
  protected String surveyDefaultLocale;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("priority asc")
  protected Set<PortfolioSurvey> surveys = new LinkedHashSet<PortfolioSurvey>();

  /** The page theme default is <code>default.</code> */
  @Column(
    name   = "theme",
    length = 30
  )
  protected String theme = "default";

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "PortfolioCustomerAppointmentTimeZone",
    joinColumns        = {
      @JoinColumn(
        name           = "portfolioId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "timezoneId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.EAGER,
    cascade = CascadeType.ALL
  )
  protected Set<Timezone> timezoneHashSet = new HashSet<Timezone>();

  /** accept timezones string '-5, -6, -7, -8'. */
  @Column(
    name     = "timeZones",
    nullable = false,
    length   = 200
  )
  protected String timeZones = "US/Eastern,US/Central,US/Mountain,US/Pacific";

  /** total program number which shown to customer. */
  @Column(
    name     = "totalProgramShown",
    nullable = false
  )
  protected Integer totalProgramShown = 3;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio"
  )
  protected Set<TransactionCode> transactionCodes = new LinkedHashSet<TransactionCode>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.ALL }
  )
  protected Set<TransactionBatchHeader> transBatchHeaders = new LinkedHashSet<TransactionBatchHeader>();

  /** TODO: DOCUMENT ME! */
  @Column(length = 20)
  protected String twilioCallerId;


  /** Update contact not allow days. */
  @Column(name = "updateContactNotAllowedDays")
  protected Integer updateContactNotAllowedDays;

  /** <code>true</code> allow update MRA contact information, default is <code>false.</code> */
  @Column(
    name             = "updateMraContactInformation",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean updateMraContactInformation = false;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolio",
    cascade  = { CascadeType.ALL }
  )
  @Where(clause = "variableType = 'Portfolio'")
  protected Set<PortfolioVariable> variables = new LinkedHashSet<PortfolioVariable>();


  /** The Credit Provider's branch code. For dev CA-4323 */
  @Column(length = 4)
  protected String vedaBranchCode;

  /** The Credit Provider's subscriber code. For dev CA-4323 */
  @Column(length = 4)
  protected String vedaSubscriberCode;

  /** Web site url. */
  @Column(
    name     = "webSiteUrl",
    nullable = false,
    length   = 150
  )
  protected String webSiteUrl;

  /** Weekly program tracking peroid. */
  @Column(nullable = true)
  protected Integer weeklyProgramTrackingPeriod;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bucketData  DOCUMENT ME!
   */
  /**
   * DOCUMENT ME!
   *
   * @param  bucketData  DOCUMENT ME!
   */
  public void addBucketDelinquentData(BucketDelinquentData bucketData) {
    bucketData.setPortfolio(this);
    this.bucketDelinquentData.add(bucketData);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  displayVariable  DOCUMENT ME!
   */
  public void addDisplayVariable(PortfolioDisplayVariable displayVariable) {
    displayVariable.setPortfolio(this);
    displayVariables.add(displayVariable);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  frequencyDuration  DOCUMENT ME!
   */
  public void addFrequencyDuration(FrequencyDuration frequencyDuration) {
    frequencyDuration.setPortfolio(this);
    this.frequencyDurations.add(frequencyDuration);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add new survey group.
   *
   * @param  survey  DOCUMENT ME!
   */
  public void addPortfolioSurvey(PortfolioSurvey survey) {
    survey.setPortfolio(this);

    this.surveys.add(survey);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  survey  DOCUMENT ME!
   */
  public void addSurvey(PortfolioSurvey survey) {
    survey.setPortfolio(this);
    this.surveys.add(survey);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * add portfolio survey question.
   *
   * @param  question  DOCUMENT ME!
   */
  public void addSurveyQuestion(PortfolioQuestion question) {
    question.setPortfolio(this);
    this.questions.add(question);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add new variable.
   *
   * @param  variable  DOCUMENT ME!
   */
  public void addVariable(PortfolioVariable variable) {
    variable.setPortfolio(this);
    variables.add(variable);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add new variable.
   *
   * @param  variable  DOCUMENT ME!
   */
  public void addVariable(SurveyFlowVariable variable) {
    variable.setPortfolio(this);
    flowVariables.add(variable);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   that  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean auditEquals(Portfolio that) {
    if (this == that) {
      return true;
    }

    if ((that == null) || (getClass() != that.getClass())) {
      return false;
    }

    if (!super.equals(that)) {
      return false;
    }

    if ((acceptedProgramShortTerm != null) ? (!acceptedProgramShortTerm.equals(
              that.acceptedProgramShortTerm)) : (that.acceptedProgramShortTerm != null)) {
      return false;
    }

    if ((accountLevelDisclosure != null) ? (!accountLevelDisclosure.equals(that.accountLevelDisclosure))
                                         : (that.accountLevelDisclosure != null)) {
      return false;
    }

    if ((active != null) ? (!active.equals(that.active)) : (that.active != null)) {
      return false;
    }

    if ((agentTimeZoneId != null) ? (!agentTimeZoneId.equals(that.agentTimeZoneId)) : (that.agentTimeZoneId != null)) {
      return false;
    }

    if ((allowAmericanExpress != null) ? (!allowAmericanExpress.equals(that.allowAmericanExpress))
                                       : (that.allowAmericanExpress != null)) {
      return false;
    }

    if ((addressline1mandatory != null) ? (!addressline1mandatory.equals(that.addressline1mandatory))
                                        : (that.addressline1mandatory != null)) {
      return false;
    }

    if ((allowCallOnSaturday != null) ? (!allowCallOnSaturday.equals(that.allowCallOnSaturday))
                                      : (that.allowCallOnSaturday != null)) {
      return false;
    }

    if ((allowCallOnSunday != null) ? (!allowCallOnSunday.equals(that.allowCallOnSunday))
                                    : (that.allowCallOnSunday != null)) {
      return false;
    }

    if ((allowCredit != null) ? (!allowCredit.equals(that.allowCredit)) : (that.allowCredit != null)) {
      return false;
    }

    if ((allowDebit != null) ? (!allowDebit.equals(that.allowDebit)) : (that.allowDebit != null)) {
      return false;
    }

    if ((allowDinersClub != null) ? (!allowDinersClub.equals(that.allowDinersClub)) : (that.allowDinersClub != null)) {
      return false;
    }

    if ((allowDiscover != null) ? (!allowDiscover.equals(that.allowDiscover)) : (that.allowDiscover != null)) {
      return false;
    }

    if ((allowVisaDebit != null) ? (!allowVisaDebit.equals(that.allowVisaDebit)) : (that.allowVisaDebit != null)) {
      return false;
    }

    if ((allowVisaElectron != null) ? (!allowVisaElectron.equals(that.allowVisaElectron))
                                    : (that.allowVisaElectron != null)) {
      return false;
    }

    if ((allowDynamicProgram != null) ? (!allowDynamicProgram.equals(that.allowDynamicProgram))
                                      : (that.allowDynamicProgram != null)) {
      return false;
    }

    if ((allowSPOC != null) ? (!allowSPOC.equals(that.allowSPOC)) : (that.allowSPOC != null)) {
      return false;
    }

    if ((allowEditContact != null) ? (!allowEditContact.equals(that.allowEditContact))
                                   : (that.allowEditContact != null)) {
      return false;
    }

    if ((allowJCB != null) ? (!allowJCB.equals(that.allowJCB)) : (that.allowJCB != null)) {
      return false;
    }

    if ((allowBankcard != null) ? (!allowBankcard.equals(that.allowBankcard)) : (that.allowBankcard != null)) {
      return false;
    }

    if ((accrueInterest != null) ? (!accrueInterest.equals(that.accrueInterest)) : (that.accrueInterest != null)) {
      return false;
    }

    if ((interestStartDate != null) ? (!interestStartDate.equals(that.interestStartDate))
                                    : (that.interestStartDate != null)) {
      return false;
    }

    if ((allowMasterCard != null) ? (!allowMasterCard.equals(that.allowMasterCard)) : (that.allowMasterCard != null)) {
      return false;
    }

    if ((addressline1mandatory != null) ? (!addressline1mandatory.equals(that.addressline1mandatory))
                                        : (that.addressline1mandatory != null)) {
      return false;
    }

    if ((allowMultiplePromises != null) ? (!allowMultiplePromises.equals(that.allowMultiplePromises))
                                        : (that.allowMultiplePromises != null)) {
      return false;
    }

    if ((allowSplitPayment != null) ? (!allowSplitPayment.equals(that.allowSplitPayment))
                                    : (that.allowSplitPayment != null)) {
      return false;
    }

    if ((allowSurvey != null) ? (!allowSurvey.equals(that.allowSurvey)) : (that.allowSurvey != null)) {
      return false;
    }

    if ((allowHotSpot != null) ? (!allowHotSpot.equals(that.allowHotSpot)) : (that.allowHotSpot != null)) {
      return false;
    }

    if ((allowUpdateContact != null) ? (!allowUpdateContact.equals(that.allowUpdateContact))
                                     : (that.allowUpdateContact != null)) {
      return false;
    }

    if ((allowVisa != null) ? (!allowVisa.equals(that.allowVisa)) : (that.allowVisa != null)) {
      return false;
    }

    if ((apptEndDaysFromNow != null) ? (!apptEndDaysFromNow.equals(that.apptEndDaysFromNow))
                                     : (that.apptEndDaysFromNow != null)) {
      return false;
    }

    if ((apptEndHoursFromNow != null) ? (!apptEndHoursFromNow.equals(that.apptEndHoursFromNow))
                                      : (that.apptEndHoursFromNow != null)) {
      return false;
    }

    if ((apptEndTime != null) ? (!apptEndTime.equals(that.apptEndTime)) : (that.apptEndTime != null)) {
      return false;
    }

    if ((apptEndTimeFriday != null) ? (!apptEndTimeFriday.equals(that.apptEndTimeFriday))
                                    : (that.apptEndTimeFriday != null)) {
      return false;
    }

    if ((apptEndTimeMonday != null) ? (!apptEndTimeMonday.equals(that.apptEndTimeMonday))
                                    : (that.apptEndTimeMonday != null)) {
      return false;
    }

    if ((apptEndTimeSaturday != null) ? (!apptEndTimeSaturday.equals(that.apptEndTimeSaturday))
                                      : (that.apptEndTimeSaturday != null)) {
      return false;
    }

    if ((apptEndTimeSunday != null) ? (!apptEndTimeSunday.equals(that.apptEndTimeSunday))
                                    : (that.apptEndTimeSunday != null)) {
      return false;
    }

    if ((apptEndTimeThursday != null) ? (!apptEndTimeThursday.equals(that.apptEndTimeThursday))
                                      : (that.apptEndTimeThursday != null)) {
      return false;
    }

    if ((apptEndTimeTuesday != null) ? (!apptEndTimeTuesday.equals(that.apptEndTimeTuesday))
                                     : (that.apptEndTimeTuesday != null)) {
      return false;
    }

    if ((apptEndTimeWednesday != null) ? (!apptEndTimeWednesday.equals(that.apptEndTimeWednesday))
                                       : (that.apptEndTimeWednesday != null)) {
      return false;
    }

    if ((apptLanguages != null) ? (!apptLanguages.equals(that.apptLanguages)) : (that.apptLanguages != null)) {
      return false;
    }

    if ((apptStartDaysFromNow != null) ? (!apptStartDaysFromNow.equals(that.apptStartDaysFromNow))
                                       : (that.apptStartDaysFromNow != null)) {
      return false;
    }

    if ((apptStartHoursFromNow != null) ? (!apptStartHoursFromNow.equals(that.apptStartHoursFromNow))
                                        : (that.apptStartHoursFromNow != null)) {
      return false;
    }

    if ((apptStartTime != null) ? (!apptStartTime.equals(that.apptStartTime)) : (that.apptStartTime != null)) {
      return false;
    }

    if ((apptStartTimeFriday != null) ? (!apptStartTimeFriday.equals(that.apptStartTimeFriday))
                                      : (that.apptStartTimeFriday != null)) {
      return false;
    }

    if ((apptStartTimeMonday != null) ? (!apptStartTimeMonday.equals(that.apptStartTimeMonday))
                                      : (that.apptStartTimeMonday != null)) {
      return false;
    }

    if ((apptStartTimeSaturday != null) ? (!apptStartTimeSaturday.equals(that.apptStartTimeSaturday))
                                        : (that.apptStartTimeSaturday != null)) {
      return false;
    }

    if ((apptStartTimeSunday != null) ? (!apptStartTimeSunday.equals(that.apptStartTimeSunday))
                                      : (that.apptStartTimeSunday != null)) {
      return false;
    }

    if ((apptStartTimeThursday != null) ? (!apptStartTimeThursday.equals(that.apptStartTimeThursday))
                                        : (that.apptStartTimeThursday != null)) {
      return false;
    }

    if ((apptStartTimeTuesday != null) ? (!apptStartTimeTuesday.equals(that.apptStartTimeTuesday))
                                       : (that.apptStartTimeTuesday != null)) {
      return false;
    }

    if ((apptStartTimeWednesday != null) ? (!apptStartTimeWednesday.equals(that.apptStartTimeWednesday))
                                         : (that.apptStartTimeWednesday != null)) {
      return false;
    }

    if ((awAgentInactiveTime != null) ? (!awAgentInactiveTime.equals(that.awAgentInactiveTime))
                                      : (that.awAgentInactiveTime != null)) {
      return false;
    }

    if ((awMaxDaysCreateFutureSendDateSecuredPromise != null)
          ? (!awMaxDaysCreateFutureSendDateSecuredPromise.equals(
              that.awMaxDaysCreateFutureSendDateSecuredPromise))
          : (that.awMaxDaysCreateFutureSendDateSecuredPromise != null)) {
      return false;
    }

    if ((awMaxDaysCreateFutureSendDateUnsecuredPromise != null)
          ? (!awMaxDaysCreateFutureSendDateUnsecuredPromise.equals(
              that.awMaxDaysCreateFutureSendDateUnsecuredPromise))
          : (that.awMaxDaysCreateFutureSendDateUnsecuredPromise
            != null)) {
      return false;
    }

    if ((awMaxDaysCreatePastSendDateUnsecuredPromise != null)
          ? (!awMaxDaysCreatePastSendDateUnsecuredPromise.equals(
              that.awMaxDaysCreatePastSendDateUnsecuredPromise))
          : (that.awMaxDaysCreatePastSendDateUnsecuredPromise != null)) {
      return false;
    }

    if ((awMaxDaysSendArrivalDateSecuredPromise != null)
          ? (!awMaxDaysSendArrivalDateSecuredPromise.equals(
              that.awMaxDaysSendArrivalDateSecuredPromise)) : (that.awMaxDaysSendArrivalDateSecuredPromise != null)) {
      return false;
    }

    if ((awMaxDaysSendArrivalDateUnsecuredPromise != null)
          ? (!awMaxDaysSendArrivalDateUnsecuredPromise.equals(
              that.awMaxDaysSendArrivalDateUnsecuredPromise))
          : (that.awMaxDaysSendArrivalDateUnsecuredPromise != null)) {
      return false;
    }

    if ((awMessageCount != null) ? (!awMessageCount.equals(that.awMessageCount)) : (that.awMessageCount != null)) {
      return false;
    }

    if ((awDateFormat != null) ? (!awDateFormat.equals(that.awDateFormat)) : (that.awDateFormat != null)) {
      return false;
    }

    if ((awTimeFormat != null) ? (!awTimeFormat.equals(that.awTimeFormat)) : (that.awTimeFormat != null)) {
      return false;
    }

    if ((hideFlexSiteHeaderandFooter != null) ? (!hideFlexSiteHeaderandFooter.equals(
              that.hideFlexSiteHeaderandFooter)) : (that.hideFlexSiteHeaderandFooter != null)) {
      return false;
    }

    if ((cancelProgram != null) ? (!cancelProgram.equals(that.cancelProgram)) : (that.cancelProgram != null)) {
      return false;
    }

    if ((channelVendorAccount != null) ? (!channelVendorAccount.equals(that.channelVendorAccount))
                                       : (that.channelVendorAccount != null)) {
      return false;
    }

    if ((chargeOffDays != null) ? (!chargeOffDays.equals(that.chargeOffDays)) : (that.chargeOffDays != null)) {
      return false;
    }

    if ((commissionRate != null) ? (!commissionRate.equals(that.commissionRate)) : (that.commissionRate != null)) {
      return false;
    }

    if ((currencySymbol != null) ? (!currencySymbol.equals(that.currencySymbol)) : (that.currencySymbol != null)) {
      return false;
    }

    if ((defaultCountry != null) ? (!defaultCountry.equals(that.defaultCountry)) : (that.defaultCountry != null)) {
      return false;
    }

    if ((defaultPaymentReminderDays != null) ? (!defaultPaymentReminderDays.equals(
              that.defaultPaymentReminderDays)) : (that.defaultPaymentReminderDays != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((disclosureGroupName != null) ? (!disclosureGroupName.equals(that.disclosureGroupName))
                                      : (that.disclosureGroupName != null)) {
      return false;
    }

    if ((awCancelOfferDeletePayment != null) ? (!awCancelOfferDeletePayment.equals(that.awCancelOfferDeletePayment))
                                             : (that.awCancelOfferDeletePayment != null)) {
      return false;
    }

    if ((displayRow != null) ? (!displayRow.equals(that.displayRow)) : (that.displayRow != null)) {
      return false;
    }

    if ((doNotContactApptDays != null) ? (!doNotContactApptDays.equals(that.doNotContactApptDays))
                                       : (that.doNotContactApptDays != null)) {
      return false;
    }

    if ((doNotContactDefaultDays != null) ? (!doNotContactDefaultDays.equals(
              that.doNotContactDefaultDays)) : (that.doNotContactDefaultDays != null)) {
      return false;
    }

    if ((doNotContactPTPDays != null) ? (!doNotContactPTPDays.equals(that.doNotContactPTPDays))
                                      : (that.doNotContactPTPDays != null)) {
      return false;
    }

    if ((doNotContactPaymentDays != null) ? (!doNotContactPaymentDays.equals(
              that.doNotContactPaymentDays)) : (that.doNotContactPaymentDays != null)) {
      return false;
    }

    if ((doNotContactRpcDays != null) ? (!doNotContactRpcDays.equals(that.doNotContactRpcDays))
                                      : (that.doNotContactRpcDays != null)) {
      return false;
    }

    if ((doNotContactWUPTPDays != null) ? (!doNotContactWUPTPDays.equals(that.doNotContactWUPTPDays))
                                        : (that.doNotContactWUPTPDays != null)) {
      return false;
    }

    if ((duration != null) ? (!duration.equals(that.duration)) : (that.duration != null)) {
      return false;
    }

    if ((enableProgramTrackingConfig != null) ? (!enableProgramTrackingConfig.equals(
              that.enableProgramTrackingConfig)) : (that.enableProgramTrackingConfig != null)) {
      return false;
    }

    if ((encryptScreenPopUrlSensitiveData != null)
          ? (!encryptScreenPopUrlSensitiveData.equals(
              that.encryptScreenPopUrlSensitiveData)) : (that.encryptScreenPopUrlSensitiveData != null)) {
      return false;
    }

    if ((expressConsent != null) ? (!expressConsent.equals(that.expressConsent)) : (that.expressConsent != null)) {
      return false;
    }

    if ((expressConsentDisplay != null) ? (!expressConsentDisplay.equals(that.expressConsentDisplay))
                                        : (that.expressConsentDisplay != null)) {
      return false;
    }

    if ((externalReferenceId != null) ? (!externalReferenceId.equals(that.externalReferenceId))
                                      : (that.externalReferenceId != null)) {
      return false;
    }

    if ((fortnightlyProgramTrackingPeriod != null)
          ? (!fortnightlyProgramTrackingPeriod.equals(
              that.fortnightlyProgramTrackingPeriod)) : (that.fortnightlyProgramTrackingPeriod != null)) {
      return false;
    }

    if ((helpEmail != null) ? (!helpEmail.equals(that.helpEmail)) : (that.helpEmail != null)) {
      return false;
    }

    if ((hours != null) ? (!hours.equals(that.hours)) : (that.hours != null)) {
      return false;
    }

    if ((ivrAgentPhoneNum != null) ? (!ivrAgentPhoneNum.equals(that.ivrAgentPhoneNum))
                                   : (that.ivrAgentPhoneNum != null)) {
      return false;
    }

    if ((ivrPhoneNum != null) ? (!ivrPhoneNum.equals(that.ivrPhoneNum)) : (that.ivrPhoneNum != null)) {
      return false;
    }

    if ((landingView != null) ? (!landingView.equals(that.landingView)) : (that.landingView != null)) {
      return false;
    }

    if ((letterSignerName != null) ? (!letterSignerName.equals(that.letterSignerName))
                                   : (that.letterSignerName != null)) {
      return false;
    }

    if ((loginCaptchaThreshold != null) ? (!loginCaptchaThreshold.equals(that.loginCaptchaThreshold))
                                        : (that.loginCaptchaThreshold != null)) {
      return false;
    }

    if ((logoName != null) ? (!logoName.equals(that.logoName)) : (that.logoName != null)) {
      return false;
    }

    if ((maxNumberOfRecurringPromisesAllowed != null)
          ? (!maxNumberOfRecurringPromisesAllowed.equals(
              that.maxNumberOfRecurringPromisesAllowed)) : (that.maxNumberOfRecurringPromisesAllowed != null)) {
      return false;
    }

    if ((minDaysCreateArrivalDatePromise != null)
          ? (!minDaysCreateArrivalDatePromise.equals(
              that.minDaysCreateArrivalDatePromise)) : (that.minDaysCreateArrivalDatePromise != null)) {
      return false;
    }

    if ((minPayment != null) ? (!minPayment.equals(that.minPayment)) : (that.minPayment != null)) {
      return false;
    }

    if ((monthlyProgramTrackingPeriod != null)
          ? (!monthlyProgramTrackingPeriod.equals(
              that.monthlyProgramTrackingPeriod)) : (that.monthlyProgramTrackingPeriod != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((notifyBccEmails != null) ? (!notifyBccEmails.equals(that.notifyBccEmails)) : (that.notifyBccEmails != null)) {
      return false;
    }

    if ((notifyCcEmails != null) ? (!notifyCcEmails.equals(that.notifyCcEmails)) : (that.notifyCcEmails != null)) {
      return false;
    }

    if ((notifySubject != null) ? (!notifySubject.equals(that.notifySubject)) : (that.notifySubject != null)) {
      return false;
    }

    if ((notifyTemplate != null) ? (!notifyTemplate.equals(that.notifyTemplate)) : (that.notifyTemplate != null)) {
      return false;
    }

    if ((notifyToEmails != null) ? (!notifyToEmails.equals(that.notifyToEmails)) : (that.notifyToEmails != null)) {
      return false;
    }

    if ((offerRestrictionDays != null) ? (!offerRestrictionDays.equals(that.offerRestrictionDays))
                                       : (that.offerRestrictionDays != null)) {
      return false;
    }

    if ((originalCreditor != null) ? (!originalCreditor.equals(that.originalCreditor))
                                   : (that.originalCreditor != null)) {
      return false;
    }

    if ((payableName != null) ? (!payableName.equals(that.payableName)) : (that.payableName != null)) {
      return false;
    }

    if ((paymentAddress1 != null) ? (!paymentAddress1.equals(that.paymentAddress1)) : (that.paymentAddress1 != null)) {
      return false;
    }

    if ((paymentAddress2 != null) ? (!paymentAddress2.equals(that.paymentAddress2)) : (that.paymentAddress2 != null)) {
      return false;
    }

    if ((paymentAdvanceDays != null) ? (!paymentAdvanceDays.equals(that.paymentAdvanceDays))
                                     : (that.paymentAdvanceDays != null)) {
      return false;
    }

    if ((paymentCity != null) ? (!paymentCity.equals(that.paymentCity)) : (that.paymentCity != null)) {
      return false;
    }

    if ((paymentCountry != null) ? (!paymentCountry.equals(that.paymentCountry)) : (that.paymentCountry != null)) {
      return false;
    }

    if ((paymentPostalCode != null) ? (!paymentPostalCode.equals(that.paymentPostalCode))
                                    : (that.paymentPostalCode != null)) {
      return false;
    }

    if ((paymentProvince != null) ? (!paymentProvince.equals(that.paymentProvince)) : (that.paymentProvince != null)) {
      return false;
    }

    if ((paymentServiceId != null) ? (!paymentServiceId.equals(that.paymentServiceId))
                                   : (that.paymentServiceId != null)) {
      return false;
    }

    if ((portfolioId != null) ? (!portfolioId.equals(that.portfolioId)) : (that.portfolioId != null)) {
      return false;
    }

    if ((postChargeOffPayByDateValidate != null)
          ? (!postChargeOffPayByDateValidate.equals(
              that.postChargeOffPayByDateValidate)) : (that.postChargeOffPayByDateValidate != null)) {
      return false;
    }

    if ((postChargeOffPayByDateValidateType != null)
          ? (!postChargeOffPayByDateValidateType.equals(
              that.postChargeOffPayByDateValidateType)) : (that.postChargeOffPayByDateValidateType != null)) {
      return false;
    }

    if ((preChargeOffPayByDateValidate != null)
          ? (!preChargeOffPayByDateValidate.equals(
              that.preChargeOffPayByDateValidate)) : (that.preChargeOffPayByDateValidate != null)) {
      return false;
    }

    if ((preChargeOffPayByDateValidateType != null)
          ? (!preChargeOffPayByDateValidateType.equals(
              that.preChargeOffPayByDateValidateType)) : (that.preChargeOffPayByDateValidateType != null)) {
      return false;
    }

    if ((processingFee != null) ? (!processingFee.equals(that.processingFee)) : (that.processingFee != null)) {
      return false;
    }

    if ((programFirstDueDate != null) ? (!programFirstDueDate.equals(that.programFirstDueDate))
                                      : (that.programFirstDueDate != null)) {
      return false;
    }

    if ((programTemplateCount != null) ? (!programTemplateCount.equals(that.programTemplateCount))
                                       : (that.programTemplateCount != null)) {
      return false;
    }

    if ((ptpEvalToleranceDays != null) ? (!ptpEvalToleranceDays.equals(that.ptpEvalToleranceDays))
                                       : (that.ptpEvalToleranceDays != null)) {
      return false;
    }

    if ((redirectURL != null) ? (!redirectURL.equals(that.redirectURL)) : (that.redirectURL != null)) {
      return false;
    }

    if ((returnAddress1 != null) ? (!returnAddress1.equals(that.returnAddress1)) : (that.returnAddress1 != null)) {
      return false;
    }

    if ((returnAddress2 != null) ? (!returnAddress2.equals(that.returnAddress2)) : (that.returnAddress2 != null)) {
      return false;
    }

    if ((returnCity != null) ? (!returnCity.equals(that.returnCity)) : (that.returnCity != null)) {
      return false;
    }

    if ((returnCountry != null) ? (!returnCountry.equals(that.returnCountry)) : (that.returnCountry != null)) {
      return false;
    }

    if ((returnPostalCode != null) ? (!returnPostalCode.equals(that.returnPostalCode))
                                   : (that.returnPostalCode != null)) {
      return false;
    }

    if ((returnProvince != null) ? (!returnProvince.equals(that.returnProvince)) : (that.returnProvince != null)) {
      return false;
    }

    if ((saveReminderEmail != null) ? (!saveReminderEmail.equals(that.saveReminderEmail))
                                    : (that.saveReminderEmail != null)) {
      return false;
    }

    if ((showApptComment != null) ? (!showApptComment.equals(that.showApptComment)) : (that.showApptComment != null)) {
      return false;
    }

    if ((showCountry != null) ? (!showCountry.equals(that.showCountry)) : (that.showCountry != null)) {
      return false;
    }

    if ((showOverLimit != null) ? (!showOverLimit.equals(that.showOverLimit)) : (that.showOverLimit != null)) {
      return false;
    }

    if ((speedBump != null) ? (!speedBump.equals(that.speedBump)) : (that.speedBump != null)) {
      return false;
    }

    if ((surveyDefaultLocale != null) ? (!surveyDefaultLocale.equals(that.surveyDefaultLocale))
                                      : (that.surveyDefaultLocale != null)) {
      return false;
    }

    if ((theme != null) ? (!theme.equals(that.theme)) : (that.theme != null)) {
      return false;
    }

    if ((timeZones != null) ? (!timeZones.equals(that.timeZones)) : (that.timeZones != null)) {
      return false;
    }

    if ((totalProgramShown != null) ? (!totalProgramShown.equals(that.totalProgramShown))
                                    : (that.totalProgramShown != null)) {
      return false;
    }

    if ((updateContactNotAllowedDays != null) ? (!updateContactNotAllowedDays.equals(
              that.updateContactNotAllowedDays)) : (that.updateContactNotAllowedDays != null)) {
      return false;
    }

    if ((webSiteUrl != null) ? (!webSiteUrl.equals(that.webSiteUrl)) : (that.webSiteUrl != null)) {
      return false;
    }

    if ((weeklyProgramTrackingPeriod != null) ? (!weeklyProgramTrackingPeriod.equals(
              that.weeklyProgramTrackingPeriod)) : (that.weeklyProgramTrackingPeriod != null)) {
      return false;
    }

    if ((paymentProviderIdSelector != null) ? (!paymentProviderIdSelector.equals(
              that.paymentProviderIdSelector)) : (that.paymentProviderIdSelector != null)) {
      return false;
    }

    if ((overBalanceToleranceAmount != null) ? (!overBalanceToleranceAmount.equals(
              that.overBalanceToleranceAmount)) : (that.overBalanceToleranceAmount != null)) {
      return false;
    }

    if ((overBalanceTolerancePercentage != null)
          ? (!overBalanceTolerancePercentage.equals(
              that.overBalanceTolerancePercentage)) : (that.overBalanceTolerancePercentage != null)) {
      return false;
    }

    return true;
  } // end method auditEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    Portfolio other = (Portfolio) obj;

    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   frequencyDuration  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public FrequencyDuration findFrequencyDuration(FrequencyDuration frequencyDuration) {
    for (FrequencyDuration curFrequencyDuration : this.frequencyDurations) {
      if (curFrequencyDuration.equals(frequencyDuration)) {
        return curFrequencyDuration;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   frequencyDuration  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public FrequencyDuration findOrCreateFrequencyDuration(FrequencyDuration frequencyDuration) {
    for (FrequencyDuration curFrequencyDuration : this.frequencyDurations) {
      if (curFrequencyDuration.equals(frequencyDuration)) {
        return curFrequencyDuration;
      }
    }

    frequencyDuration.setPortfolio(this);
    this.frequencyDurations.add(frequencyDuration);

    return frequencyDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAcceptedProgramShortTerm() {
    if (acceptedProgramShortTerm == null) {
      acceptedProgramShortTerm = Boolean.FALSE;
    }

    return acceptedProgramShortTerm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accept program with outstanding promise.
   *
   * @return  Boolean
   */
  public Boolean getAcceptProgramWithOutstandingPromise() {
    return acceptProgramWithOutstandingPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BaseVariable> getAccessibleVariables() {
    return accessibleVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAccountLevelDisclosure() {
    return accountLevelDisclosure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accrual interest.
   *
   * @return  Boolean
   */
  public Boolean getAccrueInterest() {
    if (accrueInterest == null) {
      return Boolean.FALSE;
    }

    return accrueInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getActive() {
    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for addressline1mandatory.
   *
   * @return  Boolean
   */
  public Boolean getAddressline1mandatory() {
    if (addressline1mandatory == null) {
      return Boolean.FALSE;
    }

    return addressline1mandatory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The agent time zone Id.
   *
   * @return  the agent time zone Id
   *
   *          <p>not-null = "true" length = "45"</p>
   */
  public String getAgentTimeZoneId() {
    return agentTimeZoneId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowACH() {
    logger.info("Portfolio -->allowACH-->" + allowACH);

    if (null == allowACH) {
      return Boolean.TRUE;
    } else if (allowACH.toString().trim().length() == 0) {
      return Boolean.TRUE;
    }

    return allowACH;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowAmericanExpress.
   *
   * @return  the allowAmericanExpress
   *
   *          <p>type = "yes_no" not-null = "false"</p>
   */
  public Boolean getAllowAmericanExpress() {
    return allowAmericanExpress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow bankcard.
   *
   * @return  Boolean
   */
  public Boolean getAllowBankcard() {
    return allowBankcard;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowCallOnSaturday.
   *
   * @return  the allowCallOnSaturday
   *
   *          <p>not-null = "false" type = "yes_no"</p>
   */
  public Boolean getAllowCallOnSaturday() {
    return allowCallOnSaturday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowCallOnSunday.
   *
   * @return  the allowCallOnSunday
   *
   *          <p>not-null = "false" type = "yes_no"</p>
   */
  public Boolean getAllowCallOnSunday() {
    return allowCallOnSunday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getAllowCredit() {
    logger.info("Portfolio -->allowCredit-->" + allowCredit);

    if (null == allowCredit) {
      return Boolean.TRUE;
    } else if (allowCredit.toString().trim().length() == 0) {
      return Boolean.TRUE;
    }

    return allowCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getAllowDebit() {
    logger.info("Portfolio -->allowDebit-->" + allowDebit);

    if (null == allowDebit) {
      return Boolean.TRUE;
    } else if (allowDebit.toString().trim().length() == 0) {
      return Boolean.TRUE;
    }

    return allowDebit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowDinersClub.
   *
   * @return  the allowDinersClub
   *
   *          <p>type = "yes_no" not-null = "false"</p>
   */
  public Boolean getAllowDinersClub() {
    return allowDinersClub;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowDiscover.
   *
   * @return  the allowDiscover
   *
   *          <p>type = "yes_no" not-null = "false"</p>
   */
  public Boolean getAllowDiscover() {
    return allowDiscover;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowDynamicProgram() {
    if (allowDynamicProgram == null) {
      return Boolean.FALSE;
    }

    return allowDynamicProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowedChannelTypes.
   *
   * @return  the allowedChannelTypes
   *
   *          <p>column = "portfolioId"</p>
   *
   *          <p>lazy = "extra" table = "PortfolioChannelType" inverse = "true" cascade = "save-update"</p>
   */
  public Set<PortfolioChannelType> getAllowedChannelTypes() {
    return allowedChannelTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getAllowEditContact() {
    return allowEditContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow edit telephone country code.
   *
   * @return  Boolean
   */
  public Boolean getAllowEditTelephoneCountryCode() {
    if (allowEditTelephoneCountryCode == null) {
      return Boolean.FALSE;
    }

    return allowEditTelephoneCountryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow flex site over limit message.
   *
   * @return  Boolean
   */
  public Boolean getAllowFlexSiteOverLimitMessage() {
    return allowFlexSiteOverLimitMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowHotSpot() {
    if (allowHotSpot == null) {
      return Boolean.FALSE;
    }

    return allowHotSpot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow inactive accounts disposition.
   *
   * @return  Boolean
   */
  public Boolean getAllowInactiveAccountsDisposition() {
    return allowInactiveAccountsDisposition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowJCB.
   *
   * @return  the allowJCB
   *
   *          <p>type = "yes_no" not-null = "false"</p>
   */
  public Boolean getAllowJCB() {
    return allowJCB;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowMasterCard.
   *
   * @return  the allowMasterCard
   *
   *          <p>type = "yes_no" not-null = "false"</p>
   */
  public Boolean getAllowMasterCard() {
    return allowMasterCard;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow multiple promises.
   *
   * @return  Boolean
   */
  public Boolean getAllowMultiplePromises() {
    return allowMultiplePromises;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow over balance payment.
   *
   * @return  Boolean
   */
  public Boolean getAllowOverBalancePayment() {
    if (null == allowOverBalancePayment) {
      return Boolean.FALSE;
    }

    return allowOverBalancePayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowSplitPayment() {
    if (allowSplitPayment == null) {
      return Boolean.FALSE;
    }

    return allowSplitPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowSPOC() {
    if (allowSPOC == null) {
      return Boolean.FALSE;
    }

    return allowSPOC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowSurvey() {
    if (allowSurvey == null) {
      return Boolean.FALSE;
    }

    return allowSurvey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getAllowUpdateContact() {
    return allowUpdateContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowVisa.
   *
   * @return  the allowVisa
   *
   *          <p>type = "yes_no" not-null = "false"</p>
   */
  public Boolean getAllowVisa() {
    return allowVisa;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowVisaDebit() {
    return allowVisaDebit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowVisaElectron() {
    return allowVisaElectron;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The appointment end day offset.
   *
   * @return  the appointment end day offset
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getApptEndDaysFromNow() {
    return apptEndDaysFromNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The appointment end hour offset.
   *
   * @return  the appointment end hour offset
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getApptEndHoursFromNow() {
    return apptEndHoursFromNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptEndTime.
   *
   * @return  the apptEndTime
   *
   *          <p>not-null = "true" length = "8"</p>
   */
  public String getApptEndTime() {
    return apptEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeFriday.
   *
   * @return  the apptStartTimeFriday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptEndTimeFriday() {
    return apptEndTimeFriday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeMonday.
   *
   * @return  the apptStartTimeMonday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptEndTimeMonday() {
    return apptEndTimeMonday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeSaturday.
   *
   * @return  the apptStartTimeSaturday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptEndTimeSaturday() {
    return apptEndTimeSaturday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeSunday.
   *
   * @return  the apptStartTimeSunday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptEndTimeSunday() {
    return apptEndTimeSunday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeThursday.
   *
   * @return  the apptStartTimeThursday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptEndTimeThursday() {
    return apptEndTimeThursday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeTueday.
   *
   * @return  the apptStartTimeTueday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptEndTimeTuesday() {
    return apptEndTimeTuesday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeWednesday.
   *
   * @return  the apptStartTimeWednesday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptEndTimeWednesday() {
    return apptEndTimeWednesday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The languages for appointment.
   *
   * @return  the languages for appointment
   *
   *          <p>not-null = "true" length = "200"</p>
   */
  public String getApptLanguages() {
    return apptLanguages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<String> getApptLanguageSet() {
    Set<String> set = new LinkedHashSet<String>();

    if (apptLanguages != null) {
      String[] parts = apptLanguages.split(",");

      for (String part : parts) {
        set.add(part);
      }
    }

    return set;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The appointment start day offset.
   *
   * @return  the appointment start day offset
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getApptStartDaysFromNow() {
    return apptStartDaysFromNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The appointment start hour offset.
   *
   * @return  the appointment start hour offset
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getApptStartHoursFromNow() {
    return apptStartHoursFromNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTime.
   *
   * @return  the apptStartTime
   *
   *          <p>not-null = "true" length = "8"</p>
   */
  public String getApptStartTime() {
    return apptStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeFriday.
   *
   * @return  the apptStartTimeFriday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptStartTimeFriday() {
    return apptStartTimeFriday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeMonday.
   *
   * @return  the apptStartTimeMonday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptStartTimeMonday() {
    return apptStartTimeMonday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeSaturday.
   *
   * @return  the apptStartTimeSaturday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptStartTimeSaturday() {
    return apptStartTimeSaturday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeSunday.
   *
   * @return  the apptStartTimeSunday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptStartTimeSunday() {
    return apptStartTimeSunday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeThursday.
   *
   * @return  the apptStartTimeThursday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptStartTimeThursday() {
    return apptStartTimeThursday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeTuesday.
   *
   * @return  the apptStartTimeTuesday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptStartTimeTuesday() {
    return apptStartTimeTuesday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The apptStartTimeWednesday.
   *
   * @return  the apptStartTimeWednesday
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getApptStartTimeWednesday() {
    return apptStartTimeWednesday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAwAgentInactiveTime() {
    return awAgentInactiveTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAwAllowReacceptOffer() {
    if (awAllowReacceptOffer == null) {
      return Boolean.FALSE;
    }

    return awAllowReacceptOffer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAwCancelOfferDeletePayment() {
    if (awCancelOfferDeletePayment == null) {
      return Boolean.FALSE;
    }

    return awCancelOfferDeletePayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAwDateFormat() {
    return awDateFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAwDateTimeFormat() {
    if ((this.getAwDateFormat() != null) && (this.getAwTimeFormat() != null)) {
      return awDateFormat + " " + awTimeFormat;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for aw display address line3.
   *
   * @return  Boolean
   */
  public Boolean getAwDisplayAddressLine3() {
    return awDisplayAddressLine3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAwDisplayOffersDocuments() {
    if (awDisplayOffersDocuments == null) {
      return Boolean.FALSE;
    }

    return awDisplayOffersDocuments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAwDisplayOffersScore() {
    if (awDisplayOffersScore == null) {
      return Boolean.FALSE;
    }

    return awDisplayOffersScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for aw display province.
   *
   * @return  Boolean
   */
  public Boolean getAwDisplayProvince() {
    return awDisplayProvince;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for aw inactive account read only.
   *
   * @return  Boolean
   */
  public Boolean getAwInactiveAccountReadOnly() {
    return awInactiveAccountReadOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAwMaxDaysCreateFutureSendDateSecuredPromise() {
    return awMaxDaysCreateFutureSendDateSecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAwMaxDaysCreateFutureSendDateUnsecuredPromise() {
    return awMaxDaysCreateFutureSendDateUnsecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAwMaxDaysCreatePastSendDateUnsecuredPromise() {
    return awMaxDaysCreatePastSendDateUnsecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAwMaxDaysSendArrivalDateSecuredPromise() {
    return awMaxDaysSendArrivalDateSecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAwMaxDaysSendArrivalDateUnsecuredPromise() {
    return awMaxDaysSendArrivalDateUnsecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAwMessageCount() {
    return awMessageCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAwPhoneNumberFormat() {
    return awPhoneNumberFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for aw read only.
   *
   * @return  Boolean
   */
  public Boolean getAwReadOnly() {
    return awReadOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAwTimeFormat() {
    return awTimeFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BarclayProgramCode> getBarclayProgramCodes() {
    return barclayProgramCodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getBlockWebEditDeletePTPDays() {
    return blockWebEditDeletePTPDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BucketDelinquentData> getBucketDelinquentData() {
    return bucketDelinquentData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BucketDelinquentData> getBucketDelinquentDataSet() {
    return bucketDelinquentData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getCancelProgram() {
    if (this.cancelProgram == null) {
      return Boolean.TRUE;
    }

    return cancelProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   channelTypeId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioChannelExportConfiguration getChannelExportConfigurationByType(String channelTypeId) {
    return getChannelExportConfigurations().get(channelTypeId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, PortfolioChannelExportConfiguration> getChannelExportConfigurations() {
    return channelExportConfigurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   templateId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioChannelTemplate getChannelTemplate(Long templateId) {
    for (PortfolioChannelTemplate template : channelTemplates) {
      if (template.getId().equals(templateId)) {
        return template;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   templateName  DOCUMENT ME!
   * @param   type          DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioChannelTemplate getChannelTemplateByNameAndType(String templateName, String type) {
    String tempName    = null;
    String channelType = null;

    for (PortfolioChannelTemplate template : this.channelTemplates) {
      tempName    = StringUtils.trim(template.getName());
      channelType = StringUtils.trim(template.getChannelType().getName());

      if (StringUtils.equalsIgnoreCase(templateName, tempName)
            && StringUtils.equalsIgnoreCase(type, channelType)) {
        return template;
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
  public Set<PortfolioChannelTemplate> getChannelTemplates() {
    return channelTemplates;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   typeId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioChannelTemplate> getChannelTemplatesByType(Long typeId) {
    Set<PortfolioChannelTemplate> result = new LinkedHashSet<PortfolioChannelTemplate>();

    for (PortfolioChannelTemplate template : channelTemplates) {
      if (template.getChannelType().getChannelTypeId().equals(typeId)) {
        result.add(template);
      }
    }

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getChannelVendorAccount() {
    return channelVendorAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The chargeOffDays.
   *
   * @return  the chargeOffDays
   *
   *          <p>length = "5"</p>
   */

  public Integer getChargeOffDays() {
    return chargeOffDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The client.
   *
   * @return  the client
   *
   *          <p>lazy = "false" column = "clientId" not-null = "true" class = "com.cmc.credagility.Client" insert =
   *          "true" update = "false"</p>
   */
  public Client getClient() {
    return client;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>precision = "19" scale = "4"</p>
   */
  public BigDecimal getCommissionRate() {
    return commissionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "false" length = "2"</p>
   */
  public String getCurrencySymbol() {
    return currencySymbol;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for currency symbol position.
   *
   * @return  CurrencySymbolPosition
   */
  public CurrencySymbolPosition getCurrencySymbolPosition() {
    return currencySymbolPosition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for currency symbol position str.
   *
   * @return  String
   */
  public String getCurrencySymbolPositionStr() {
    if (currencySymbolPosition != null) {
      return currencySymbolPosition.name();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>length = "20"</p>
   */
  public Long getDefaultArrivalDate() {
    return defaultArrivalDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>length = "2" not-null = "true"</p>
   */
  public String getDefaultCountry() {
    return defaultCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default locale.
   *
   * @return  String
   */
  public String getDefaultLocale() {
    return defaultLocale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The defaultPaymentReminderDays.
   *
   * @return  the defaultPaymentReminderDays
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getDefaultPaymentReminderDays() {
    return defaultPaymentReminderDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default telephone country code.
   *
   * @return  String
   */
  public String getDefaultTelephoneCountryCode() {
    return defaultTelephoneCountryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delete promise with cancel program.
   *
   * @return  Boolean
   */
  public Boolean getDeletePromiseWithCancelProgram() {
    return deletePromiseWithCancelProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The description.
   *
   * @return  the description
   *
   *          <p>not-null = "false" length = "1024"</p>
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDisclosureGroupName() {
    return disclosureGroupName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDisplayRow() {
    return displayRow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<Long, PortfolioDisplayVariable> getDisplayVariableMap() {
    Map<Long, PortfolioDisplayVariable> map = new HashMap<Long, PortfolioDisplayVariable>();

    for (PortfolioDisplayVariable displayVariable : displayVariables) {
      map.put(displayVariable.getVariable().getId(), displayVariable);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioDisplayVariable> getDisplayVariables() {
    return displayVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<Division> getDivisions() {
    return divisions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDoNotContactApptDays() {
    if (doNotContactApptDays == null) {
      return 1;
    }

    return doNotContactApptDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDoNotContactDefaultDays() {
    if (doNotContactDefaultDays == null) {
      return 3;
    }

    return doNotContactDefaultDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDoNotContactPaymentDays() {
    if (doNotContactPaymentDays == null) {
      return 1;
    }

    return doNotContactPaymentDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDoNotContactPTPDays() {
    if (doNotContactPTPDays == null) {
      return 5;
    }

    return doNotContactPTPDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDoNotContactRpcDays() {
    if (doNotContactRpcDays == null) {
      return 5;
    }

    return doNotContactRpcDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDoNotContactWUPTPDays() {
    if (doNotContactWUPTPDays == null) {
      return 2;
    }

    return doNotContactWUPTPDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The duration.
   *
   * @return  the duration
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getDuration() {
    return duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEditAccountContactInfoFlexSite() {
    return editAccountContactInfoFlexSite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEditDeleteScheduledPaymentFlexSite() {
    return editDeleteScheduledPaymentFlexSite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enable check duplicate phone.
   *
   * @return  Boolean
   */
  public Boolean getEnableCheckDuplicatePhone() {
    return enableCheckDuplicatePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enable flex site PTP.
   *
   * @return  Boolean
   */
  public Boolean getEnableFlexSitePTP() {
    if (enableFlexSitePTP == null) {
      return Boolean.FALSE;
    }

    return enableFlexSitePTP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getEnablePaymentDisclosureText() {
    if (enablePaymentDisclosureText == null) {
      return Boolean.FALSE;
    }

    return enablePaymentDisclosureText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getEnableProgramOfferDisclosureText() {
    if (enableProgramOfferDisclosureText == null) {
      return Boolean.FALSE;
    }

    return enableProgramOfferDisclosureText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getEnableProgramTrackingConfig() {
    if (enableProgramTrackingConfig == null) {
      return Boolean.FALSE;
    }

    return enableProgramTrackingConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getEncryptScreenPopUrlSensitiveData() {
    if (encryptScreenPopUrlSensitiveData == null) {
      return Boolean.TRUE;
    }

    return encryptScreenPopUrlSensitiveData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enforce compliance on dial pad.
   *
   * @return  Boolean
   */
  public Boolean getEnforceComplianceOnDialPad() {
    return enforceComplianceOnDialPad;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<Event> getEvents() {
    return events;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // Added by Etisbew on 05/13/09 for DFS Cycle Date-END
  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */

  /**
   * The expressConsent.
   *
   * @return  the expressConsent
   */
  public Boolean getExpressConsent() {
    if (expressConsent == null) {
      expressConsent = Boolean.FALSE;
    }

    return expressConsent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExpressConsentDisplay() {
    return expressConsentDisplay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExternalReferenceId() {
    return externalReferenceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<FlexSelectConfig> getFlexSelectConfigs() {
    return flexSelectConfigs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getFlexSiteAutoLoadPrioritySurvey() {
    if (flexSiteAutoLoadPrioritySurvey == null) {
      return Boolean.TRUE;
    }

    return flexSiteAutoLoadPrioritySurvey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site max sub menu workflow count.
   *
   * @return  Integer
   */
  public Integer getFlexSiteMaxSubMenuWorkflowCount() {
    if (null == flexSiteMaxSubMenuWorkflowCount) {
      return DEFAULT_FLEXSITE_MAX_SUB_MENU_WORKFLOW_COUNT;
    }

    return flexSiteMaxSubMenuWorkflowCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getFlexSiteSurveyAsPaymentConfirmation() {
    if (flexSiteSurveyAsPaymentConfirmation == null) {
      return Boolean.FALSE;
    }

    return flexSiteSurveyAsPaymentConfirmation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getFlexSiteSurveyAsProgramConfirmation() {
    if (flexSiteSurveyAsProgramConfirmation == null) {
      return Boolean.FALSE;
    }

    return flexSiteSurveyAsProgramConfirmation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex station disposition comment size.
   *
   * @return  Integer
   */
  public Integer getFlexStationDispositionCommentSize() {
    return flexStationDispositionCommentSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<SurveyFlowVariable> getFlowVariables() {
    return flowVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for force promise with accept program.
   *
   * @return  Boolean
   */
  public Boolean getForcePromiseWithAcceptProgram() {
    return forcePromiseWithAcceptProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getFortnightlyProgramTrackingPeriod() {
    return fortnightlyProgramTrackingPeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<FrequencyDuration> getFrequencies() {
    return frequencyDurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, FrequencyDuration> getFrequencyDurationKeyMap() {
    Map<String, FrequencyDuration> map = new HashMap<String, FrequencyDuration>();

    for (FrequencyDuration frequencyDuration : this.frequencyDurations) {
      String key = frequencyDuration.getFrequency() + ":"
        + frequencyDuration.getDuration();
      map.put(key, frequencyDuration);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<Long, FrequencyDuration> getFrequencyDurationMap() {
    Map<Long, FrequencyDuration> map = new HashMap<Long, FrequencyDuration>();

    for (FrequencyDuration frequencyDuration : this.frequencyDurations) {
      map.put(frequencyDuration.getId(), frequencyDuration);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<FrequencyDuration> getFrequencyDurations() {
    return frequencyDurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>length = "128"</p>
   */
  public String getHelpEmail() {
    return helpEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hide flex site headerand footer.
   *
   * @return  Boolean
   */
  public Boolean getHideFlexSiteHeaderandFooter() {
    if (null == hideFlexSiteHeaderandFooter) {
      return Boolean.FALSE;
    }

    return hideFlexSiteHeaderandFooter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The hours.
   *
   * @return  the hours
   *
   *          <p>not-null = "true" length = "150"</p>
   */
  public String getHours() {
    return hours;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The industry.
   *
   * @return  the industry
   *
   *          <p>lazy = "false" column = "industryId" not-null = "true" class = "com.cmc.credagility.Industry" insert =
   *          "true" update = "false"</p>
   */
  public Industry getIndustry() {
    return industry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for interest start date.
   *
   * @return  String
   */
  public String getInterestStartDate() {
    return interestStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public InvoiceCategory getInvoiceCategory() {
    return invoiceCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getIsScreenPopUrlCustomUniqueIdEncrypted() {
    if (isScreenPopUrlCustomUniqueIdEncrypted == null) {
      return Boolean.FALSE;
    }

    return isScreenPopUrlCustomUniqueIdEncrypted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The ivrAgentPhoneNum.
   *
   * @return  the ivrAgentPhoneNum
   *
   *          <p>not-null = "true" length = "20"</p>
   */
  public String getIvrAgentPhoneNum() {
    return ivrAgentPhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The ivrPhoneNum.
   *
   * @return  the ivrPhoneNum
   *
   *          <p>not-null = "true" length = "20"</p>
   */
  public String getIvrPhoneNum() {
    return ivrPhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getJavaDateFormat() {
    return javaDateFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getJavaDateTimeFormat() {
    if ((this.getJavaDateFormat() != null) && (this.getJavaTimeFormat() != null)) {
      return javaDateFormat + " " + javaTimeFormat;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getJavaTimeFormat() {
    return javaTimeFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "false" length = "100"</p>
   */
  public String getLandingView() {
    return landingView;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLatestPlacementDate() {
    return latestPlacementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The letterSignerName.
   *
   * @return  the letterSignerName
   *
   *          <p>not-null = "true" length = "150"</p>
   */
  public String getLetterSignerName() {
    return letterSignerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getLoginCaptchaThreshold() {
    return loginCaptchaThreshold;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The logoName.
   *
   * @return  the logoName
   *
   *          <p>not-null = "true" length = "100"</p>
   */
  public String getLogoName() {
    return logoName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMaxNumberOfRecurringPromisesAllowed() {
    return maxNumberOfRecurringPromisesAllowed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The maxPaymentAmount.
   *
   * @param   balance  Account.balance
   *
   *                   <p>overBalanceToleranceAmount is not null, maxPaymentAmount = @balance +
   *                   overBalanceToleranceAmount</p>
   *
   *                   <p>overBalanceTolerancePercentage is not null, maxPaymentAmount = @balance + (@balance *
   *                   (overBalanceTolerancePercentage/100))</p>
   *
   * @return  maxPaymentAmount
   */
  public BigDecimal getMaxPaymentAmount(BigDecimal balance) {
    BigDecimal maxPaymentAmount = null;

    if (getAllowOverBalancePayment()) {
      if (overBalanceToleranceAmount != null) {
        maxPaymentAmount = balance.add(overBalanceToleranceAmount);
      } else if (overBalanceTolerancePercentage != null) {
        maxPaymentAmount = balance.add(balance.multiply(
              new BigDecimal(new Double(overBalanceTolerancePercentage) / 100)));
      }

      if (maxPaymentAmount != null) {
        maxPaymentAmount = maxPaymentAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
      }
    }

    return maxPaymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMinDaysCreateArrivalDatePromise() {
    return minDaysCreateArrivalDatePromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The minPayment.
   *
   * @return  the minPayment
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getMinPayment() {
    return minPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMonthlyProgramTrackingPeriod() {
    return monthlyProgramTrackingPeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getMraIndicator() {
    if (mraIndicator == null) {
      return Boolean.FALSE;
    }

    return mraIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The name.
   *
   * @return  the name
   *
   *          <p>not-null = "true" length = "80" unique = "true"</p>
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Flag for need notification.
   *
   * @return  flag for need notification
   */
  public boolean getNeedNotification() {
    if ((notifyToEmails == null) || notifyToEmails.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The notifyBccEmails.
   *
   * @return  the notifyBccEmails
   *
   *          <p>not-null = "false" length = "255"</p>
   */
  public String getNotifyBccEmails() {
    return this.notifyBccEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The notifyCcEmails.
   *
   * @return  the notifyCcEmails
   *
   *          <p>not-null = "false" length = "255"</p>
   */
  public String getNotifyCcEmails() {
    return this.notifyCcEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The notifySubject.
   *
   * @return  the notifySubject
   *
   *          <p>not-null = "false" length = "255"</p>
   */
  public String getNotifySubject() {
    return this.notifySubject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The notifyTemplate.
   *
   * @return  the notifyTemplate
   *
   *          <p>not-null = "false" length = "100"</p>
   */
  public String getNotifyTemplate() {
    return this.notifyTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The notifyToEmails.
   *
   * @return  the notifyToEmails
   *
   *          <p>not-null = "false" length = "255"</p>
   */
  public String getNotifyToEmails() {
    return this.notifyToEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getOfferRestrictionByHours() {
    Integer restrictionByHr = 0;

    if (getOfferRestrictionDays() > 0) {
      restrictionByHr = getOfferRestrictionDays() * 24;
    }

    return restrictionByHr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getOfferRestrictionDays() {
    if (offerRestrictionDays == null) {
      return 0;
    }

    return offerRestrictionDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>length = "128"</p>
   */
  public String getOriginalCreditor() {
    return originalCreditor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getOverRidePhoneTypeExpressConsent() {
    return overRidePhoneTypeExpressConsent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The payableName.
   *
   * @return  the payableName
   *
   *          <p>not-null = "true" length = "150"</p>
   */
  public String getPayableName() {
    return payableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentAddress1.
   *
   * @return  the paymentAddress1
   *
   *          <p>not-null = "true" length = "150"</p>
   */
  public String getPaymentAddress1() {
    return this.paymentAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentAddress2.
   *
   * @return  the paymentAddress2
   *
   *          <p>not-null = "false" length = "150"</p>
   */
  public String getPaymentAddress2() {
    return this.paymentAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentAdvanceDays.
   *
   * @return  the paymentAdvanceDays
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getPaymentAdvanceDays() {
    return this.paymentAdvanceDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentCity.
   *
   * @return  the paymentCity
   *
   *          <p>not-null = "true" length = "50"</p>
   */
  public String getPaymentCity() {
    return this.paymentCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentCountry.
   *
   * @return  the paymentCountry
   *
   *          <p>not-null = "true" length = "100"</p>
   */
  public String getPaymentCountry() {
    return this.paymentCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getPaymentEmailReminder() {
    if (paymentEmailReminder == null) {
      return Boolean.FALSE;
    }

    return paymentEmailReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PaymentFeeConfiguration> getPaymentFeeConfigurations() {
    return paymentFeeConfigurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentPostalCode.
   *
   * @return  the paymentPostalCode
   *
   *          <p>not-null = "true" length = "15"</p>
   */
  public String getPaymentPostalCode() {
    return this.paymentPostalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentProviderIdSelector() {
    return paymentProviderIdSelector;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentProvince.
   *
   * @return  the paymentProvince
   *
   *          <p>not-null = "true" length = "100"</p>
   */
  public String getPaymentProvince() {
    return this.paymentProvince;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The payment service Id to be sent to payment service provider to identify which client this account belong to.
   * Normally this can be associated with a different CMC merchant bank account.
   *
   * @return  the payment service Id to be sent to payment service provider to identify which client this account belong
   *          to.
   *
   *          <p>length = "20"</p>
   */
  public String getPaymentServiceId() {
    return paymentServiceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentServiceProvider.
   *
   * @return  the paymentServiceProvider
   *
   *          <p>column = "providerId" not-null = "true" class = "com.cmc.credagility.PaymentServiceProvider" insert =
   *          "true" update = "true"</p>
   */
  public PaymentServiceProvider getPaymentServiceProvider() {
    return this.paymentServiceProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getPaymentSMSReminder() {
    if (paymentSMSReminder == null) {
      return Boolean.FALSE;
    }

    return paymentSMSReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioAgentDispositionCode> getPortfolioAgentDispositionCode() {
    return portfolioAgentDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioApptReason> getPortfolioApptReasons() {
    return portfolioApptReasons;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioCardType> getPortfolioCardTypes() {
    return portfolioCardTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioCycleDate> getPortfolioCycleDates() {
    return portfolioCycleDates;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The portfolioId.
   *
   * @return  the portfolioId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getPortfolioId() {
    return portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The portfolioOutcomeTypes.
   *
   * @return  the portfolioOutcomeTypes
   *
   *          <p>column = "portfolioId"</p>
   *
   *          <p>class = "com.cmc.credagility.PortfolioOutcomeType"</p>
   *
   *          <p>lazy = "true" table = "PortfolioOutcomeType" inverse = "true" order-by = "priority asc"</p>
   */
  public Set<PortfolioOutcomeType> getPortfolioOutcomeTypes() {
    return portfolioOutcomeTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The postChargeOffPayByDateValidate.
   *
   * @return  the postChargeOffPayByDateValidate
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getPostChargeOffPayByDateValidate() {
    return postChargeOffPayByDateValidate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The postChargeOffPayByDateValidateType.
   *
   * @return  the postChargeOffPayByDateValidateType
   *
   *          <p>length = "10"</p>
   */

  public String getPostChargeOffPayByDateValidateType() {
    return postChargeOffPayByDateValidateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The preChargeOffPayByDateValidate.
   *
   * @return  the preChargeOffPayByDateValidate
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getPreChargeOffPayByDateValidate() {
    return preChargeOffPayByDateValidate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // Added by Etisbew on 05/13/09 for Cycle Date-END
  /**
   * The preChargeOffPayByDateValidateType.
   *
   * @return  the preChargeOffPayByDateValidateType
   *
   *          <p>length = "10"</p>
   */

  public String getPreChargeOffPayByDateValidateType() {
    return preChargeOffPayByDateValidateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The processingFee.
   *
   * @return  the processingFee
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getProcessingFee() {
    return processingFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program detail section.
   *
   * @return  Boolean
   */
  public Boolean getProgramDetailSection() {
    return (programDetailSection == null) ? Boolean.FALSE : programDetailSection;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The programFirstDueDate.
   *
   * @return  the programFirstDueDate
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getProgramFirstDueDate() {
    return programFirstDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getProgramTemplateCount() {
    return programTemplateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPtpEvalToleranceDays() {
    return ptpEvalToleranceDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PtpPaymentMethodConfiguration> getPtpPaymentMethodConfigurations() {
    return ptpPaymentMethodConfigurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioQuestion> getQuestions() {
    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>column = "portfolioId"</p>
   *
   *          <p>class = "com.cmc.credagility.QueueSchedule"</p>
   *
   *          <p>lazy = "extra" table = "QueueSchedule" inverse = "true" cascade = "all-delete-orphan"</p>
   */
  public Set<QueueSchedule> getQueueSchedules() {
    return queueSchedules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for realtime account details.
   *
   * @return  Boolean
   */
  public Boolean getRealtimeAccountDetails() {
    if (this.realtimeAccountDetails == null) {
      return Boolean.FALSE;
    }

    return realtimeAccountDetails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getRecentActivitiesNumber() {
    return recentActivitiesNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>length = "255"</p>
   */
  public String getRedirectURL() {
    return redirectURL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The returnAddress1.
   *
   * @return  the returnAddress1
   *
   *          <p>not-null = "true" length = "150"</p>
   */
  public String getReturnAddress1() {
    return this.returnAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The returnAddress2.
   *
   * @return  the returnAddress2
   *
   *          <p>not-null = "false" length = "150"</p>
   */
  public String getReturnAddress2() {
    return this.returnAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The returnCity.
   *
   * @return  the returnCity
   *
   *          <p>not-null = "true" length = "50"</p>
   */
  public String getReturnCity() {
    return this.returnCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The returnCountry.
   *
   * @return  the returnCountry
   *
   *          <p>not-null = "true" length = "100"</p>
   */
  public String getReturnCountry() {
    return this.returnCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The returnPostalCode.
   *
   * @return  the returnPostalCode
   *
   *          <p>not-null = "true" length = "15"</p>
   */
  public String getReturnPostalCode() {
    return this.returnPostalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The returnProvince.
   *
   * @return  the returnProvince
   *
   *          <p>not-null = "true" length = "100"</p>
   */
  public String getReturnProvince() {
    return this.returnProvince;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getSaveReminderEmail() {
    if (saveReminderEmail == null) {
      saveReminderEmail = Boolean.FALSE;
    }

    return saveReminderEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<Schedule> getSchedules() {
    return schedules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioScoreType> getScoreTypes() {
    return scoreTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for screen Pop Url Custom Unique Id SQL.
   *
   * @return  String
   */
  public String getScreenPopUrlCustomUniqueIdSQL() {
    if (screenPopUrlCustomUniqueIdSQL == null) {
      return "Link";

    }

    return screenPopUrlCustomUniqueIdSQL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  public Boolean getAllowCustomerPortalSendMQRequest() {
    if (allowCustomerPortalSendMQRequest == null) {
      return false;
    }

    return allowCustomerPortalSendMQRequest;
  }

  public void setAllowCustomerPortalSendMQRequest(Boolean allowCustomerPortalSendMQRequest) {
    this.allowCustomerPortalSendMQRequest = allowCustomerPortalSendMQRequest;
  }

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getSendMQRequest() {
    if (sendMQRequest == null) {
      return false;
    }

    return sendMQRequest;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The showApptComment.
   *
   * @return  the showApptComment
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getShowApptComment() {
    return showApptComment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getShowCountry() {
    return showCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for show country code.
   *
   * @return  Boolean
   */
  public Boolean getShowCountryCode() {
    if (showCountryCode == null) {
      return Boolean.FALSE;
    }

    return showCountryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getShowOverLimit() {
    return showOverLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getSpeedBump() {
    if (speedBump == null) {
      speedBump = false;
    }

    return speedBump;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioStaticPage> getStaticPages() {
    return staticPages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The question text default locale.
   *
   * @return  the question text default locale
   *
   *          <p>length = "64"</p>
   */
  public String getSurveyDefaultLocale() {
    return surveyDefaultLocale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get portfolio survey question group map.
   *
   * @return  get portfolio survey question group map
   */
  public Map<Long, PortfolioSurvey> getSurveyMap() {
    Map<Long, PortfolioSurvey> map = new LinkedHashMap<Long, PortfolioSurvey>();

    for (PortfolioSurvey survey : surveys) {
      map.put(survey.getId(), survey);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<Long, PortfolioQuestion> getSurveyQuestionMap() {
    Map<Long, PortfolioQuestion> map = new LinkedHashMap<Long, PortfolioQuestion>();

    for (PortfolioQuestion question : questions) {
      map.put(question.getId(), question);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The questions.
   *
   * @return  the questions
   *
   *          <p>column = "portfolioId"</p>
   *
   *          <p>class = "com.cmc.credagility.PortfolioQuestion"</p>
   *
   *          <p>lazy = "extra" table = "PortfolioQuestion" inverse = "true" cascade = "save-update" order-by =
   *          "displayOrder asc"</p>
   */
  public Set<PortfolioQuestion> getSurveyQuestions() {
    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioSurvey> getSurveys() {
    return surveys;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The theme of this portfolio.
   *
   * @return  the theme of this portfolio
   *
   *          <p>not-null = "false" length = "30"</p>
   */
  public String getTheme() {
    return theme;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for timezone hash set.
   *
   * @return  Set
   */
  public Set<Timezone> getTimezoneHashSet() {
    return timezoneHashSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The timeZones.
   *
   * @return  the timeZones
   *
   *          <p>not-null = "true" length = "200"</p>
   */
  public String getTimeZones() {
    return timeZones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<String> getTimeZoneSet() {
    Set<String> set = new LinkedHashSet<String>();

    if (timeZones != null) {
      String[] parts = timeZones.split(",");

      for (String part : parts) {
        set.add(part);
      }
    }

    return set;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The totalProgramShown.
   *
   * @return  the totalProgramShown
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getTotalProgramShown() {
    return totalProgramShown;
  }

  // Added by Etisbew on 05/13/09 for Cycle Date-END

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction codes.
   *
   * @return  Set
   */
  public Set<TransactionCode> getTransactionCodes() {
    return transactionCodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans batch headers.
   *
   * @return  Set
   */
  public Set<TransactionBatchHeader> getTransBatchHeaders() {
    return transBatchHeaders;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio caller id.
   *
   * @return  String
   */
  public String getTwilioCallerId() {
    return twilioCallerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getUpdateContactNotAllowedDays() {
    return updateContactNotAllowedDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getUpdateMraContactInformation() {
    if (updateMraContactInformation == null) {
      return Boolean.FALSE;
    }

    return updateMraContactInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioVariable> getVariables() {
    return variables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for veda branch code.
   *
   * @return  String
   */
  public String getVedaBranchCode() {
    return vedaBranchCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for veda subscriber code.
   *
   * @return  String
   */
  public String getVedaSubscriberCode() {
    return vedaSubscriberCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The webSiteUrl.
   *
   * @return  the webSiteUrl
   *
   *          <p>not-null = "true" length = "150"</p>
   */
  public String getWebSiteUrl() {
    return webSiteUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getWeeklyProgramTrackingPeriod() {
    return weeklyProgramTrackingPeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((name == null) ? 0 : name.hashCode());
    result = (prime * result) + ((hideFlexSiteHeaderandFooter == null) ? 0 : hideFlexSiteHeaderandFooter.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isAcceptProgramWithOutstandingPromise() {
    if (acceptProgramWithOutstandingPromise == null) {
      return Boolean.FALSE;
    }

    return acceptProgramWithOutstandingPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow inactive accounts disposition.
   *
   * @return  Boolean
   */
  public Boolean isAllowInactiveAccountsDisposition() {
    if (allowInactiveAccountsDisposition == null) {
      return Boolean.FALSE;
    }

    return allowInactiveAccountsDisposition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isAllowMultiplePromises() {
    if (allowMultiplePromises != null) {
      return allowMultiplePromises;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isAwDisplayAddressLine3() {
    if (awDisplayAddressLine3 == null) {
      return Boolean.FALSE;
    }

    return awDisplayAddressLine3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isAwDisplayProvince() {
    if (awDisplayProvince == null) {
      return Boolean.TRUE;
    }

    return awDisplayProvince;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isAwInactiveAccountReadOnly() {
    if (awInactiveAccountReadOnly == null) {
      return Boolean.TRUE;
    }

    return awInactiveAccountReadOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isAwReadOnly() {
    if (awReadOnly == null) {
      return Boolean.FALSE;
    }

    return awReadOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isDeletePromiseWithCancelProgram() {
    if (deletePromiseWithCancelProgram == null) {
      return Boolean.FALSE;
    }

    return deletePromiseWithCancelProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isForcePromiseWithAcceptProgram() {
    if (forcePromiseWithAcceptProgram == null) {
      return Boolean.FALSE;
    }

    return forcePromiseWithAcceptProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether two portfolio are the same by portfolio id.
   *
   * @param   portfolio  DOCUMENT ME!
   *
   * @return  check whether two portfolio are the same by portfolio id
   */
  public boolean isSame(Portfolio portfolio) {
    if (this == portfolio) {
      return true;
    }

    if ((portfolio == null) || (this.getPortfolioId() == null)
          || (portfolio.getPortfolioId() == null)) {
      return false;
    }

    return this.getPortfolioId().equals(portfolio.getPortfolioId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  displayVariable  DOCUMENT ME!
   */
  public void removeDisplayVariable(PortfolioDisplayVariable displayVariable) {
    displayVariables.remove(displayVariable);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * remove portfolio survey group.
   *
   * @param   surveyId  groupId DOCUMENT ME!
   *
   * @return  removed portfolio survey question if found any
   */
  public PortfolioSurvey removeSurvey(Long surveyId) {
    if (surveyId == null) {
      return null;
    }

    for (PortfolioSurvey survey : surveys) {
      if (survey.getId().equals(surveyId)) {
        if (this.surveys.remove(survey)) {
          return survey;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  survey  DOCUMENT ME!
   */
  public void removeSurvey(PortfolioSurvey survey) {
    if (surveys.remove(survey)) {
      survey.setPortfolio(null);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * remove portfolio survey question.
   *
   * @param   questionId  DOCUMENT ME!
   *
   * @return  removed portfolio survey question if found any
   */
  public PortfolioQuestion removeSurveyQuestion(Long questionId) {
    if (questionId == null) {
      return null;
    }

    for (PortfolioQuestion question : questions) {
      if (question.getId().equals(questionId)) {
        if (this.questions.remove(question)) {
          return question;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  acceptedProgramShortTerm  DOCUMENT ME!
   */
  public void setAcceptedProgramShortTerm(Boolean acceptedProgramShortTerm) {
    this.acceptedProgramShortTerm = acceptedProgramShortTerm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  acceptProgramWithOutstandingPromise  DOCUMENT ME!
   */
  public void setAcceptProgramWithOutstandingPromise(Boolean acceptProgramWithOutstandingPromise) {
    this.acceptProgramWithOutstandingPromise = acceptProgramWithOutstandingPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accessibleVariables  DOCUMENT ME!
   */
  public void setAccessibleVariables(Set<BaseVariable> accessibleVariables) {
    this.accessibleVariables = accessibleVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountLevelDisclosure  DOCUMENT ME!
   */
  public void setAccountLevelDisclosure(String accountLevelDisclosure) {
    this.accountLevelDisclosure = accountLevelDisclosure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accrual interest.
   *
   * @param  accrueInterest  Boolean
   */
  public void setAccrueInterest(Boolean accrueInterest) {
    this.accrueInterest = accrueInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  active  DOCUMENT ME!
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for addressline1mandatory.
   *
   * @param  addressline1mandatory  Boolean
   */
  public void setAddressline1mandatory(Boolean addressline1mandatory) {
    this.addressline1mandatory = addressline1mandatory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentTimeZoneId  DOCUMENT ME!
   */
  public void setAgentTimeZoneId(String agentTimeZoneId) {
    this.agentTimeZoneId = agentTimeZoneId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowACH  DOCUMENT ME!
   */
  public void setAllowACH(Boolean allowACH) {
    this.allowACH = allowACH;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowAmericanExpress  the allowAmericanExpress to set
   */
  public void setAllowAmericanExpress(Boolean allowAmericanExpress) {
    this.allowAmericanExpress = allowAmericanExpress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow bankcard.
   *
   * @param  allowBankcard  Boolean
   */
  public void setAllowBankcard(Boolean allowBankcard) {
    this.allowBankcard = allowBankcard;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowCallOnSaturday  the allowCallOnSaturday to set
   */
  public void setAllowCallOnSaturday(Boolean allowCallOnSaturday) {
    this.allowCallOnSaturday = allowCallOnSaturday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowCallOnSunday  the allowCallOnSunday to set
   */
  public void setAllowCallOnSunday(Boolean allowCallOnSunday) {
    this.allowCallOnSunday = allowCallOnSunday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowCredit  DOCUMENT ME!
   */
  public void setAllowCredit(Boolean allowCredit) {
    this.allowCredit = allowCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowDebit  DOCUMENT ME!
   */
  public void setAllowDebit(Boolean allowDebit) {
    this.allowDebit = allowDebit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowDinersClub  the allowDinersClub to set
   */
  public void setAllowDinersClub(Boolean allowDinersClub) {
    this.allowDinersClub = allowDinersClub;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowDiscover  the allowDiscover to set
   */
  public void setAllowDiscover(Boolean allowDiscover) {
    this.allowDiscover = allowDiscover;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowDynamicProgram  DOCUMENT ME!
   */
  public void setAllowDynamicProgram(Boolean allowDynamicProgram) {
    this.allowDynamicProgram = allowDynamicProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowedChannelTypes  the allowedChannelTypes to set
   */
  public void setAllowedChannelTypes(Set<PortfolioChannelType> allowedChannelTypes) {
    this.allowedChannelTypes = allowedChannelTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowEditContact  DOCUMENT ME!
   */
  public void setAllowEditContact(Boolean allowEditContact) {
    this.allowEditContact = allowEditContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow edit telephone country code.
   *
   * @param  allowEditTelephoneCountryCode  Boolean
   */
  public void setAllowEditTelephoneCountryCode(Boolean allowEditTelephoneCountryCode) {
    this.allowEditTelephoneCountryCode = allowEditTelephoneCountryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow flex site over limit message.
   *
   * @param  allowFlexSiteOverLimitMessage  Boolean
   */
  public void setAllowFlexSiteOverLimitMessage(Boolean allowFlexSiteOverLimitMessage) {
    this.allowFlexSiteOverLimitMessage = allowFlexSiteOverLimitMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowHotSpot  DOCUMENT ME!
   */
  public void setAllowHotSpot(Boolean allowHotSpot) {
    this.allowHotSpot = allowHotSpot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow inactive accounts disposition.
   *
   * @param  allowInactiveAccountsDisposition  Boolean
   */
  public void setAllowInactiveAccountsDisposition(Boolean allowInactiveAccountsDisposition) {
    this.allowInactiveAccountsDisposition = allowInactiveAccountsDisposition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowJCB  the allowJCB to set
   */
  public void setAllowJCB(Boolean allowJCB) {
    this.allowJCB = allowJCB;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowMasterCard  the allowMasterCard to set
   */
  public void setAllowMasterCard(Boolean allowMasterCard) {
    this.allowMasterCard = allowMasterCard;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME! .mine
   *
   * @param  allowMultiplePromises  DOCUMENT ME!
   */
  public void setAllowMultiplePromises(Boolean allowMultiplePromises) {
    this.allowMultiplePromises = allowMultiplePromises;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow over balance payment.
   *
   * @param  allowOverBalancePayment  Boolean
   */
  public void setAllowOverBalancePayment(Boolean allowOverBalancePayment) {
    this.allowOverBalancePayment = allowOverBalancePayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * <p>=======</p>
   *
   * @param  allowSplitPayment  DOCUMENT ME!
   */
  public void setAllowSplitPayment(Boolean allowSplitPayment) {
    this.allowSplitPayment = allowSplitPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowSPOC  DOCUMENT ME!
   */
  public void setAllowSPOC(Boolean allowSPOC) {
    this.allowSPOC = allowSPOC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * <p>.r13905</p>
   *
   * @param  allowSurvey  DOCUMENT ME!
   */
  public void setAllowSurvey(Boolean allowSurvey) {
    this.allowSurvey = allowSurvey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowUpdateContact  DOCUMENT ME!
   */
  public void setAllowUpdateContact(Boolean allowUpdateContact) {
    this.allowUpdateContact = allowUpdateContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowVisa  the allowVisa to set
   */
  public void setAllowVisa(Boolean allowVisa) {
    this.allowVisa = allowVisa;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowVisaDebit  DOCUMENT ME!
   */
  public void setAllowVisaDebit(Boolean allowVisaDebit) {
    this.allowVisaDebit = allowVisaDebit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowVisaElectron  DOCUMENT ME!
   */
  public void setAllowVisaElectron(Boolean allowVisaElectron) {
    this.allowVisaElectron = allowVisaElectron;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptEndDaysFromNow  DOCUMENT ME!
   */
  public void setApptEndDaysFromNow(Integer apptEndDaysFromNow) {
    this.apptEndDaysFromNow = apptEndDaysFromNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptEndHoursFromNow  DOCUMENT ME!
   */
  public void setApptEndHoursFromNow(Integer apptEndHoursFromNow) {
    this.apptEndHoursFromNow = apptEndHoursFromNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptEndTime  the apptEndTime to set
   */
  public void setApptEndTime(String apptEndTime) {
    this.apptEndTime = apptEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptEndTimeFriday  DOCUMENT ME!
   */
  public void setApptEndTimeFriday(String apptEndTimeFriday) {
    this.apptEndTimeFriday = apptEndTimeFriday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptEndTimeMonday  DOCUMENT ME!
   */
  public void setApptEndTimeMonday(String apptEndTimeMonday) {
    this.apptEndTimeMonday = apptEndTimeMonday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptEndTimeSaturday  DOCUMENT ME!
   */
  public void setApptEndTimeSaturday(String apptEndTimeSaturday) {
    this.apptEndTimeSaturday = apptEndTimeSaturday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptEndTimeSunday  DOCUMENT ME!
   */
  public void setApptEndTimeSunday(String apptEndTimeSunday) {
    this.apptEndTimeSunday = apptEndTimeSunday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptEndTimeThursday  DOCUMENT ME!
   */
  public void setApptEndTimeThursday(String apptEndTimeThursday) {
    this.apptEndTimeThursday = apptEndTimeThursday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptEndTimeTuesday  DOCUMENT ME!
   */
  public void setApptEndTimeTuesday(String apptEndTimeTuesday) {
    this.apptEndTimeTuesday = apptEndTimeTuesday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptEndTimeWednesday  DOCUMENT ME!
   */
  public void setApptEndTimeWednesday(String apptEndTimeWednesday) {
    this.apptEndTimeWednesday = apptEndTimeWednesday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptLanguages  DOCUMENT ME!
   */
  public void setApptLanguages(String apptLanguages) {
    this.apptLanguages = apptLanguages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptStartDaysFromNow  DOCUMENT ME!
   */
  public void setApptStartDaysFromNow(Integer apptStartDaysFromNow) {
    this.apptStartDaysFromNow = apptStartDaysFromNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptStartHoursFromNow  DOCUMENT ME!
   */
  public void setApptStartHoursFromNow(Integer apptStartHoursFromNow) {
    this.apptStartHoursFromNow = apptStartHoursFromNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptStartTime  the apptStartTime to set
   */
  public void setApptStartTime(String apptStartTime) {
    this.apptStartTime = apptStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptStartTimeFriday  DOCUMENT ME!
   */
  public void setApptStartTimeFriday(String apptStartTimeFriday) {
    this.apptStartTimeFriday = apptStartTimeFriday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptStartTimeMonday  DOCUMENT ME!
   */
  public void setApptStartTimeMonday(String apptStartTimeMonday) {
    this.apptStartTimeMonday = apptStartTimeMonday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptStartTimeSaturday  DOCUMENT ME!
   */
  public void setApptStartTimeSaturday(String apptStartTimeSaturday) {
    this.apptStartTimeSaturday = apptStartTimeSaturday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptStartTimeSunday  DOCUMENT ME!
   */
  public void setApptStartTimeSunday(String apptStartTimeSunday) {
    this.apptStartTimeSunday = apptStartTimeSunday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptStartTimeThursday  DOCUMENT ME!
   */
  public void setApptStartTimeThursday(String apptStartTimeThursday) {
    this.apptStartTimeThursday = apptStartTimeThursday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptStartTimeTuesday  DOCUMENT ME!
   */
  public void setApptStartTimeTuesday(String apptStartTimeTuesday) {
    this.apptStartTimeTuesday = apptStartTimeTuesday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  apptStartTimeWednesday  DOCUMENT ME!
   */
  public void setApptStartTimeWednesday(String apptStartTimeWednesday) {
    this.apptStartTimeWednesday = apptStartTimeWednesday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awAgentInactiveTime  DOCUMENT ME!
   */
  public void setAwAgentInactiveTime(Integer awAgentInactiveTime) {
    this.awAgentInactiveTime = awAgentInactiveTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awAllowReacceptOffer  DOCUMENT ME!
   */
  public void setAwAllowReacceptOffer(Boolean awAllowReacceptOffer) {
    this.awAllowReacceptOffer = awAllowReacceptOffer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awCancelOfferDeletePayment  DOCUMENT ME!
   */
  public void setAwCancelOfferDeletePayment(Boolean awCancelOfferDeletePayment) {
    this.awCancelOfferDeletePayment = awCancelOfferDeletePayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awDateFormat  DOCUMENT ME!
   */
  public void setAwDateFormat(String awDateFormat) {
    this.awDateFormat = awDateFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awDateTimeFormat  DOCUMENT ME!
   */
  public void setAwDateTimeFormat(String awDateTimeFormat) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awDisplayAddressLine3  DOCUMENT ME!
   */
  public void setAwDisplayAddressLine3(Boolean awDisplayAddressLine3) {
    this.awDisplayAddressLine3 = awDisplayAddressLine3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awDisplayOffersDocuments  DOCUMENT ME!
   */
  public void setAwDisplayOffersDocuments(Boolean awDisplayOffersDocuments) {
    this.awDisplayOffersDocuments = awDisplayOffersDocuments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awDisplayOffersScore  DOCUMENT ME!
   */
  public void setAwDisplayOffersScore(Boolean awDisplayOffersScore) {
    this.awDisplayOffersScore = awDisplayOffersScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awDisplayProvince  DOCUMENT ME!
   */
  public void setAwDisplayProvince(Boolean awDisplayProvince) {
    this.awDisplayProvince = awDisplayProvince;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awInactiveAccountReadOnly  DOCUMENT ME!
   */
  public void setAwInactiveAccountReadOnly(Boolean awInactiveAccountReadOnly) {
    this.awInactiveAccountReadOnly = awInactiveAccountReadOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awMaxDaysCreateFutureSendDateSecuredPromise  DOCUMENT ME!
   */
  public void setAwMaxDaysCreateFutureSendDateSecuredPromise(Integer awMaxDaysCreateFutureSendDateSecuredPromise) {
    this.awMaxDaysCreateFutureSendDateSecuredPromise = awMaxDaysCreateFutureSendDateSecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awMaxDaysCreateFutureSendDateUnsecuredPromise  DOCUMENT ME!
   */
  public void setAwMaxDaysCreateFutureSendDateUnsecuredPromise(Integer awMaxDaysCreateFutureSendDateUnsecuredPromise) {
    this.awMaxDaysCreateFutureSendDateUnsecuredPromise = awMaxDaysCreateFutureSendDateUnsecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awMaxDaysCreatePastSendDateUnsecuredPromise  DOCUMENT ME!
   */
  public void setAwMaxDaysCreatePastSendDateUnsecuredPromise(Integer awMaxDaysCreatePastSendDateUnsecuredPromise) {
    this.awMaxDaysCreatePastSendDateUnsecuredPromise = awMaxDaysCreatePastSendDateUnsecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awMaxDaysSendArrivalDateSecuredPromise  DOCUMENT ME!
   */
  public void setAwMaxDaysSendArrivalDateSecuredPromise(Integer awMaxDaysSendArrivalDateSecuredPromise) {
    this.awMaxDaysSendArrivalDateSecuredPromise = awMaxDaysSendArrivalDateSecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awMaxDaysSendArrivalDateUnsecuredPromise  DOCUMENT ME!
   */
  public void setAwMaxDaysSendArrivalDateUnsecuredPromise(Integer awMaxDaysSendArrivalDateUnsecuredPromise) {
    this.awMaxDaysSendArrivalDateUnsecuredPromise = awMaxDaysSendArrivalDateUnsecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awMessageCount  cancelProgram awMessageCount DOCUMENT ME!
   */
  public void setAwMessageCount(Integer awMessageCount) {
    this.awMessageCount = awMessageCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awPhoneNumberFormat  DOCUMENT ME!
   */
  public void setAwPhoneNumberFormat(String awPhoneNumberFormat) {
    this.awPhoneNumberFormat = awPhoneNumberFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awReadOnly  DOCUMENT ME!
   */
  public void setAwReadOnly(Boolean awReadOnly) {
    this.awReadOnly = awReadOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  awTimeFormat  DOCUMENT ME!
   */
  public void setAwTimeFormat(String awTimeFormat) {
    this.awTimeFormat = awTimeFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  barclayProgramCodes  DOCUMENT ME!
   */
  public void setBarclayProgramCodes(Set<BarclayProgramCode> barclayProgramCodes) {
    this.barclayProgramCodes = barclayProgramCodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  blockWebEditDeletePTPDays  DOCUMENT ME!
   */
  public void setBlockWebEditDeletePTPDays(Integer blockWebEditDeletePTPDays) {
    this.blockWebEditDeletePTPDays = blockWebEditDeletePTPDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bucketDelinquentData  DOCUMENT ME!
   */
  public void setBucketDelinquentData(Set<BucketDelinquentData> bucketDelinquentData) {
    this.bucketDelinquentData = bucketDelinquentData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cancelProgram  DOCUMENT ME!
   */
  public void setCancelProgram(Boolean cancelProgram) {
    this.cancelProgram = cancelProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channelExportConfigurations  DOCUMENT ME!
   */
  public void setChannelExportConfigurations(
    Map<String, PortfolioChannelExportConfiguration> channelExportConfigurations) {
    this.channelExportConfigurations = channelExportConfigurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channelTemplates  DOCUMENT ME!
   */
  public void setChannelTemplates(Set<PortfolioChannelTemplate> channelTemplates) {
    this.channelTemplates = channelTemplates;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channelVendorAccount  DOCUMENT ME!
   */
  public void setChannelVendorAccount(String channelVendorAccount) {
    this.channelVendorAccount = channelVendorAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  chargeOffDays  DOCUMENT ME!
   */
  public void setChargeOffDays(Integer chargeOffDays) {
    this.chargeOffDays = chargeOffDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  client  the client to set
   */
  public void setClient(Client client) {
    this.client = client;
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
   * DOCUMENT ME!
   *
   * @param  currencySymbol  DOCUMENT ME!
   */
  public void setCurrencySymbol(String currencySymbol) {
    this.currencySymbol = currencySymbol;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for currency symbol position.
   *
   * @param  currencySymbolPosition  CurrencySymbolPosition
   */
  public void setCurrencySymbolPosition(CurrencySymbolPosition currencySymbolPosition) {
    this.currencySymbolPosition = currencySymbolPosition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  defaultArrivalDate  DOCUMENT ME!
   */
  public void setDefaultArrivalDate(Long defaultArrivalDate) {
    this.defaultArrivalDate = defaultArrivalDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  defaultCountry  DOCUMENT ME!
   */
  public void setDefaultCountry(String defaultCountry) {
    this.defaultCountry = defaultCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default locale.
   *
   * @param  defaultLocale  String
   */
  public void setDefaultLocale(String defaultLocale) {
    this.defaultLocale = defaultLocale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  defaultPaymentReminderDays  the defaultPaymentReminderDays to set
   */
  public void setDefaultPaymentReminderDays(Integer defaultPaymentReminderDays) {
    this.defaultPaymentReminderDays = defaultPaymentReminderDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default telephone country code.
   *
   * @param  defaultTelephoneCountryCode  String
   */
  public void setDefaultTelephoneCountryCode(String defaultTelephoneCountryCode) {
    this.defaultTelephoneCountryCode = defaultTelephoneCountryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  deletePromiseWithCancelProgram  DOCUMENT ME!
   */
  public void setDeletePromiseWithCancelProgram(Boolean deletePromiseWithCancelProgram) {
    this.deletePromiseWithCancelProgram = deletePromiseWithCancelProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  description  the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  disclosureGroupName  DOCUMENT ME!
   */
  public void setDisclosureGroupName(String disclosureGroupName) {
    this.disclosureGroupName = disclosureGroupName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  displayRow  DOCUMENT ME!
   */
  public void setDisplayRow(Integer displayRow) {
    this.displayRow = displayRow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  displayVariables  DOCUMENT ME!
   */
  public void setDisplayVariables(Set<PortfolioDisplayVariable> displayVariables) {
    this.displayVariables = displayVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  divisions  DOCUMENT ME!
   */
  public void setDivisions(Set<Division> divisions) {
    this.divisions = divisions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  doNotContactApptDays  DOCUMENT ME!
   */
  public void setDoNotContactApptDays(Integer doNotContactApptDays) {
    this.doNotContactApptDays = doNotContactApptDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  doNotContactDefaultDays  DOCUMENT ME!
   */
  public void setDoNotContactDefaultDays(Integer doNotContactDefaultDays) {
    this.doNotContactDefaultDays = doNotContactDefaultDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  doNotContactPaymentDays  DOCUMENT ME!
   */
  public void setDoNotContactPaymentDays(Integer doNotContactPaymentDays) {
    this.doNotContactPaymentDays = doNotContactPaymentDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  doNotContactPTPDays  DOCUMENT ME!
   */
  public void setDoNotContactPTPDays(Integer doNotContactPTPDays) {
    this.doNotContactPTPDays = doNotContactPTPDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  doNotContactRpcDays  DOCUMENT ME!
   */
  public void setDoNotContactRpcDays(Integer doNotContactRpcDays) {
    this.doNotContactRpcDays = doNotContactRpcDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  doNotContactWUPTPDays  DOCUMENT ME!
   */
  public void setDoNotContactWUPTPDays(Integer doNotContactWUPTPDays) {
    this.doNotContactWUPTPDays = doNotContactWUPTPDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  duration  the duration to set
   */
  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  editAccountContactInfoFlexSite  DOCUMENT ME!
   */
  public void setEditAccountContactInfoFlexSite(String editAccountContactInfoFlexSite) {
    this.editAccountContactInfoFlexSite = editAccountContactInfoFlexSite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  editDeleteScheduledPaymentFlexSite  DOCUMENT ME!
   */
  public void setEditDeleteScheduledPaymentFlexSite(String editDeleteScheduledPaymentFlexSite) {
    this.editDeleteScheduledPaymentFlexSite = editDeleteScheduledPaymentFlexSite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enable check duplicate phone.
   *
   * @param  enableCheckDuplicatePhone  Boolean
   */
  public void setEnableCheckDuplicatePhone(Boolean enableCheckDuplicatePhone) {
    this.enableCheckDuplicatePhone = enableCheckDuplicatePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enable flex site PTP.
   *
   * @param  enableFlexSitePTP  Boolean
   */
  public void setEnableFlexSitePTP(Boolean enableFlexSitePTP) {
    this.enableFlexSitePTP = enableFlexSitePTP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  enablePaymentDisclosureText  DOCUMENT ME!
   */
  public void setEnablePaymentDisclosureText(Boolean enablePaymentDisclosureText) {
    this.enablePaymentDisclosureText = enablePaymentDisclosureText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  enableProgramOfferDisclosureText  DOCUMENT ME!
   */
  public void setEnableProgramOfferDisclosureText(Boolean enableProgramOfferDisclosureText) {
    this.enableProgramOfferDisclosureText = enableProgramOfferDisclosureText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  enableProgramTrackingConfig  DOCUMENT ME!
   */
  public void setEnableProgramTrackingConfig(Boolean enableProgramTrackingConfig) {
    this.enableProgramTrackingConfig = enableProgramTrackingConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  encryptScreenPopUrlSensitiveData  DOCUMENT ME!
   */
  public void setEncryptScreenPopUrlSensitiveData(Boolean encryptScreenPopUrlSensitiveData) {
    this.encryptScreenPopUrlSensitiveData = encryptScreenPopUrlSensitiveData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enforce compliance on dial pad.
   *
   * @param  enforceComplianceOnDialPad  Boolean
   */
  public void setEnforceComplianceOnDialPad(Boolean enforceComplianceOnDialPad) {
    this.enforceComplianceOnDialPad = enforceComplianceOnDialPad;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  events  DOCUMENT ME!
   */
  public void setEvents(Set<Event> events) {
    this.events = events;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expressConsent  the expressConsent to set
   */
  public void setExpressConsent(Boolean expressConsent) {
    this.expressConsent = expressConsent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expressConsentDisplay  DOCUMENT ME!
   */
  public void setExpressConsentDisplay(String expressConsentDisplay) {
    this.expressConsentDisplay = expressConsentDisplay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  externalReferenceId  DOCUMENT ME!
   */
  public void setExternalReferenceId(String externalReferenceId) {
    this.externalReferenceId = externalReferenceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexSelectConfigs  DOCUMENT ME!
   */
  public void setFlexSelectConfigs(Set<FlexSelectConfig> flexSelectConfigs) {
    this.flexSelectConfigs = flexSelectConfigs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexSiteAutoLoadPrioritySurvey  DOCUMENT ME!
   */
  public void setFlexSiteAutoLoadPrioritySurvey(Boolean flexSiteAutoLoadPrioritySurvey) {
    this.flexSiteAutoLoadPrioritySurvey = flexSiteAutoLoadPrioritySurvey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site max sub menu workflow count.
   *
   * @param  flexSiteMaxSubMenuWorkflowCount  Integer
   */
  public void setFlexSiteMaxSubMenuWorkflowCount(Integer flexSiteMaxSubMenuWorkflowCount) {
    this.flexSiteMaxSubMenuWorkflowCount = flexSiteMaxSubMenuWorkflowCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexSiteSurveyAsPaymentConfirmation  DOCUMENT ME!
   */
  public void setFlexSiteSurveyAsPaymentConfirmation(Boolean flexSiteSurveyAsPaymentConfirmation) {
    this.flexSiteSurveyAsPaymentConfirmation = flexSiteSurveyAsPaymentConfirmation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexSiteSurveyAsProgramConfirmation  DOCUMENT ME!
   */
  public void setFlexSiteSurveyAsProgramConfirmation(Boolean flexSiteSurveyAsProgramConfirmation) {
    this.flexSiteSurveyAsProgramConfirmation = flexSiteSurveyAsProgramConfirmation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex station disposition comment size.
   *
   * @param  flexStationDispositionCommentSize  Integer
   */
  public void setFlexStationDispositionCommentSize(Integer flexStationDispositionCommentSize) {
    this.flexStationDispositionCommentSize = flexStationDispositionCommentSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flowVariables  DOCUMENT ME!
   */
  public void setFlowVariables(Set<SurveyFlowVariable> flowVariables) {
    this.flowVariables = flowVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  forcePromiseWithAcceptProgram  DOCUMENT ME!
   */
  public void setForcePromiseWithAcceptProgram(Boolean forcePromiseWithAcceptProgram) {
    this.forcePromiseWithAcceptProgram = forcePromiseWithAcceptProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fortnightlyProgramTrackingPeriod  DOCUMENT ME!
   */
  public void setFortnightlyProgramTrackingPeriod(Integer fortnightlyProgramTrackingPeriod) {
    this.fortnightlyProgramTrackingPeriod = fortnightlyProgramTrackingPeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  frequencyDurations  DOCUMENT ME!
   */
  public void setFrequencies(Set<FrequencyDuration> frequencyDurations) {
    this.frequencyDurations = frequencyDurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  frequencyDurations  DOCUMENT ME!
   */
  public void setFrequencyDurations(Set<FrequencyDuration> frequencyDurations) {
    this.frequencyDurations = frequencyDurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  helpEmail  DOCUMENT ME!
   */
  public void setHelpEmail(String helpEmail) {
    this.helpEmail = helpEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hide flex site headerand footer.
   *
   * @param  hideFlexSiteHeaderandFooter  Boolean
   */
  public void setHideFlexSiteHeaderandFooter(
    Boolean hideFlexSiteHeaderandFooter) {
    this.hideFlexSiteHeaderandFooter = hideFlexSiteHeaderandFooter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hours  the hours to set
   */
  public void setHours(String hours) {
    this.hours = hours;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  industry  the industry to set
   */
  public void setIndustry(Industry industry) {
    this.industry = industry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for interest start date.
   *
   * @param  interestStartDate  String
   */
  public void setInterestStartDate(String interestStartDate) {
    this.interestStartDate = interestStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  invoiceCategory  DOCUMENT ME!
   */
  public void setInvoiceCategory(InvoiceCategory invoiceCategory) {
    this.invoiceCategory = invoiceCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  isScreenPopUrlCustomUniqueIdEncrypted  DOCUMENT ME!
   */
  public void setIsScreenPopUrlCustomUniqueIdEncrypted(Boolean isScreenPopUrlCustomUniqueIdEncrypted) {
    this.isScreenPopUrlCustomUniqueIdEncrypted = isScreenPopUrlCustomUniqueIdEncrypted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ivrAgentPhoneNum  the ivrAgentPhoneNum to set
   */
  public void setIvrAgentPhoneNum(String ivrAgentPhoneNum) {
    this.ivrAgentPhoneNum = ivrAgentPhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ivrPhoneNum  the ivrPhoneNum to set
   */
  public void setIvrPhoneNum(String ivrPhoneNum) {
    this.ivrPhoneNum = ivrPhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  javaDateFormat  DOCUMENT ME!
   */
  public void setJavaDateFormat(String javaDateFormat) {
    this.javaDateFormat = javaDateFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  javaDateTimeFormat  DOCUMENT ME!
   */
  public void setJavaDateTimeFormat(String javaDateTimeFormat) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  javaTimeFormat  DOCUMENT ME!
   */
  public void setJavaTimeFormat(String javaTimeFormat) {
    this.javaTimeFormat = javaTimeFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  landingView  DOCUMENT ME!
   */
  public void setLandingView(String landingView) {
    this.landingView = landingView;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  latestPlacementDate  DOCUMENT ME!
   */
  public void setLatestPlacementDate(Date latestPlacementDate) {
    this.latestPlacementDate = latestPlacementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  letterSignerName  the letterSignerName to set
   */
  public void setLetterSignerName(String letterSignerName) {
    this.letterSignerName = letterSignerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  loginCaptchaThreshold  DOCUMENT ME!
   */
  public void setLoginCaptchaThreshold(Integer loginCaptchaThreshold) {
    this.loginCaptchaThreshold = loginCaptchaThreshold;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  logoName  the logoName to set
   */
  public void setLogoName(String logoName) {
    this.logoName = logoName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxNumberOfPromisesAllowed  DOCUMENT ME!
   */
  public void setMaxNumberOfRecurringPromisesAllowed(Integer maxNumberOfPromisesAllowed) {
    this.maxNumberOfRecurringPromisesAllowed = maxNumberOfPromisesAllowed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  minDaysCreateArrivalDatePromise  DOCUMENT ME!
   */
  public void setMinDaysCreateArrivalDatePromise(Integer minDaysCreateArrivalDatePromise) {
    this.minDaysCreateArrivalDatePromise = minDaysCreateArrivalDatePromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  minPayment  the minPayment to set
   */
  public void setMinPayment(BigDecimal minPayment) {
    this.minPayment = minPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  monthlyProgramTrackingPeriod  DOCUMENT ME!
   */
  public void setMonthlyProgramTrackingPeriod(Integer monthlyProgramTrackingPeriod) {
    this.monthlyProgramTrackingPeriod = monthlyProgramTrackingPeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  mraIndicator  DOCUMENT ME!
   */
  public void setMraIndicator(Boolean mraIndicator) {
    this.mraIndicator = mraIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  notifyBccEmails  the notifyBccEmails to set
   */
  public void setNotifyBccEmails(String notifyBccEmails) {
    this.notifyBccEmails = notifyBccEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  notifyCcEmails  the notifyCcEmails to set
   */
  public void setNotifyCcEmails(String notifyCcEmails) {
    this.notifyCcEmails = notifyCcEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  notifySubject  the notifySubject to set
   */
  public void setNotifySubject(String notifySubject) {
    this.notifySubject = notifySubject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  notifyTemplate  the notifyTemplate to set
   */
  public void setNotifyTemplate(String notifyTemplate) {
    this.notifyTemplate = notifyTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  notifyToEmails  the notifyToEmails to set
   */
  public void setNotifyToEmails(String notifyToEmails) {
    this.notifyToEmails = notifyToEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  offerRestrictionDays  OfferRestrictionDays DOCUMENT ME!
   */
  public void setOfferRestrictionDays(Integer offerRestrictionDays) {
    this.offerRestrictionDays = offerRestrictionDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  originalCreditor  DOCUMENT ME!
   */
  public void setOriginalCreditor(String originalCreditor) {
    this.originalCreditor = originalCreditor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  overRidePhoneTypeExpressConsent  DOCUMENT ME!
   */
  public void setOverRidePhoneTypeExpressConsent(Boolean overRidePhoneTypeExpressConsent) {
    this.overRidePhoneTypeExpressConsent = overRidePhoneTypeExpressConsent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  payableName  the payableName to set
   */
  public void setPayableName(String payableName) {
    this.payableName = payableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentAddress1  the paymentAddress1 to set
   */
  public void setPaymentAddress1(String paymentAddress1) {
    this.paymentAddress1 = paymentAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentAddress2  the paymentAddress2 to set
   */
  public void setPaymentAddress2(String paymentAddress2) {
    this.paymentAddress2 = paymentAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentAdvanceDays  the paymentAdvanceDays to set
   */
  public void setPaymentAdvanceDays(Integer paymentAdvanceDays) {
    this.paymentAdvanceDays = paymentAdvanceDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentCity  the paymentCity to set
   */
  public void setPaymentCity(String paymentCity) {
    this.paymentCity = paymentCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentCountry  the paymentCountry to set
   */
  public void setPaymentCountry(String paymentCountry) {
    this.paymentCountry = paymentCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentEmailReminder  DOCUMENT ME!
   */
  public void setPaymentEmailReminder(Boolean paymentEmailReminder) {
    this.paymentEmailReminder = paymentEmailReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentFeeConfigurations  DOCUMENT ME!
   */
  public void setPaymentFeeConfigurations(Set<PaymentFeeConfiguration> paymentFeeConfigurations) {
    this.paymentFeeConfigurations = paymentFeeConfigurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentPostalCode  the paymentPostalCode to set
   */
  public void setPaymentPostalCode(String paymentPostalCode) {
    this.paymentPostalCode = paymentPostalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentProviderIdSelector  DOCUMENT ME!
   */
  public void setPaymentProviderIdSelector(String paymentProviderIdSelector) {
    this.paymentProviderIdSelector = paymentProviderIdSelector;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentProvince  the paymentProvince to set
   */
  public void setPaymentProvince(String paymentProvince) {
    this.paymentProvince = paymentProvince;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentServiceId  DOCUMENT ME!
   */
  public void setPaymentServiceId(String paymentServiceId) {
    this.paymentServiceId = paymentServiceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentServiceProvider  the paymentServiceProvider to set
   */
  public void setPaymentServiceProvider(PaymentServiceProvider paymentServiceProvider) {
    this.paymentServiceProvider = paymentServiceProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentSMSReminder  DOCUMENT ME!
   */
  public void setPaymentSMSReminder(Boolean paymentSMSReminder) {
    this.paymentSMSReminder = paymentSMSReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioAgentDispositionCode  DOCUMENT ME!
   */
  public void setPortfolioAgentDispositionCode(Set<PortfolioAgentDispositionCode> portfolioAgentDispositionCode) {
    this.portfolioAgentDispositionCode = portfolioAgentDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioApptReasons  DOCUMENT ME!
   */
  public void setPortfolioApptReasons(Set<PortfolioApptReason> portfolioApptReasons) {
    this.portfolioApptReasons = portfolioApptReasons;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioCardTypes  DOCUMENT ME!
   */
  public void setPortfolioCardTypes(Set<PortfolioCardType> portfolioCardTypes) {
    this.portfolioCardTypes = portfolioCardTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioCycleDates  DOCUMENT ME!
   */
  public void setPortfolioCycleDates(Set<PortfolioCycleDate> portfolioCycleDates) {
    this.portfolioCycleDates = portfolioCycleDates;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioId  the portfolioId to set
   */
  public void setPortfolioId(Long portfolioId) {
    this.portfolioId = portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioOutcomeType  the portfolioOutcomeType to set
   */
  public void setPortfolioOutcomeTypes(Set<PortfolioOutcomeType> portfolioOutcomeType) {
    this.portfolioOutcomeTypes = portfolioOutcomeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  postChargeOffPayByDateValidate  DOCUMENT ME!
   */
  public void setPostChargeOffPayByDateValidate(Boolean postChargeOffPayByDateValidate) {
    this.postChargeOffPayByDateValidate = postChargeOffPayByDateValidate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  postChargeOffPayByDateValidateType  DOCUMENT ME!
   */
  public void setPostChargeOffPayByDateValidateType(String postChargeOffPayByDateValidateType) {
    this.postChargeOffPayByDateValidateType = postChargeOffPayByDateValidateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preChargeOffPayByDateValidate  DOCUMENT ME!
   */
  public void setPreChargeOffPayByDateValidate(Boolean preChargeOffPayByDateValidate) {
    this.preChargeOffPayByDateValidate = preChargeOffPayByDateValidate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preChargeOffPayByDateValidateType  DOCUMENT ME!
   */
  public void setPreChargeOffPayByDateValidateType(String preChargeOffPayByDateValidateType) {
    this.preChargeOffPayByDateValidateType = preChargeOffPayByDateValidateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  processingFee  the processingFee to set
   */
  public void setProcessingFee(BigDecimal processingFee) {
    this.processingFee = processingFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program detail section.
   *
   * @param  programDetailSection  Boolean
   */
  public void setProgramDetailSection(Boolean programDetailSection) {
    this.programDetailSection = programDetailSection;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programFirstDueDate  the programFirstDueDate to set
   */
  public void setProgramFirstDueDate(Integer programFirstDueDate) {
    this.programFirstDueDate = programFirstDueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programTemplateCount  DOCUMENT ME!
   */
  public void setProgramTemplateCount(Integer programTemplateCount) {
    this.programTemplateCount = programTemplateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ptpEvalToleranceDays  DOCUMENT ME!
   */
  public void setPtpEvalToleranceDays(Integer ptpEvalToleranceDays) {
    this.ptpEvalToleranceDays = ptpEvalToleranceDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ptpPaymentMethodConfigurations  DOCUMENT ME!
   */
  public void setPtpPaymentMethodConfigurations(Set<PtpPaymentMethodConfiguration> ptpPaymentMethodConfigurations) {
    this.ptpPaymentMethodConfigurations = ptpPaymentMethodConfigurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  questions  DOCUMENT ME!
   */
  public void setQuestions(Set<PortfolioQuestion> questions) {
    this.questions = questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  queueSchedules  DOCUMENT ME!
   */
  public void setQueueSchedules(Set<QueueSchedule> queueSchedules) {
    this.queueSchedules = queueSchedules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for realtime account details.
   *
   * @param  realtimeAccountDetails  Boolean
   */
  public void setRealtimeAccountDetails(Boolean realtimeAccountDetails) {
    this.realtimeAccountDetails = realtimeAccountDetails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  recentActivitiesNumber  DOCUMENT ME!
   */
  public void setRecentActivitiesNumber(Integer recentActivitiesNumber) {
    this.recentActivitiesNumber = recentActivitiesNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  redirectURL  DOCUMENT ME!
   */
  public void setRedirectURL(String redirectURL) {
    this.redirectURL = redirectURL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnAddress1  the returnAddress1 to set
   */
  public void setReturnAddress1(String returnAddress1) {
    this.returnAddress1 = returnAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnAddress2  the returnAddress2 to set
   */
  public void setReturnAddress2(String returnAddress2) {
    this.returnAddress2 = returnAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnCity  the returnCity to set
   */
  public void setReturnCity(String returnCity) {
    this.returnCity = returnCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnCountry  the returnCountry to set
   */
  public void setReturnCountry(String returnCountry) {
    this.returnCountry = returnCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnPostalCode  the returnPostalCode to set
   */
  public void setReturnPostalCode(String returnPostalCode) {
    this.returnPostalCode = returnPostalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnProvince  the returnProvince to set
   */
  public void setReturnProvince(String returnProvince) {
    this.returnProvince = returnProvince;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  saveReminderEmail  DOCUMENT ME!
   */
  public void setSaveReminderEmail(Boolean saveReminderEmail) {
    this.saveReminderEmail = saveReminderEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  schedules  DOCUMENT ME!
   */
  public void setSchedules(Set<Schedule> schedules) {
    this.schedules = schedules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  scoreTypes  DOCUMENT ME!
   */
  public void setScoreTypes(Set<PortfolioScoreType> scoreTypes) {
    this.scoreTypes = scoreTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for screen Pop Url Custom Unique Id SQL.
   *
   * @param  screenPopUrlCustomUniqueIdSQL  String
   */
  public void setScreenPopUrlCustomUniqueIdSQL(String screenPopUrlCustomUniqueIdSQL) {
    this.screenPopUrlCustomUniqueIdSQL = screenPopUrlCustomUniqueIdSQL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sendMQRequest  DOCUMENT ME!
   */
  public void setSendMQRequest(Boolean sendMQRequest) {
    this.sendMQRequest = sendMQRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  showApptComment  the showApptComment to set
   */
  public void setShowApptComment(Boolean showApptComment) {
    this.showApptComment = showApptComment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  showCountry  DOCUMENT ME!
   */
  public void setShowCountry(Boolean showCountry) {
    this.showCountry = showCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for show country code.
   *
   * @param  showCountryCode  Boolean
   */
  public void setShowCountryCode(Boolean showCountryCode) {
    this.showCountryCode = showCountryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  showOverLimit  DOCUMENT ME!
   */
  public void setShowOverLimit(Boolean showOverLimit) {
    this.showOverLimit = showOverLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  speedBump  DOCUMENT ME!
   */
  public void setSpeedBump(Boolean speedBump) {
    this.speedBump = speedBump;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  staticPages  DOCUMENT ME!
   */
  public void setStaticPages(Set<PortfolioStaticPage> staticPages) {
    this.staticPages = staticPages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyDefaultLocale  DOCUMENT ME!
   */
  public void setSurveyDefaultLocale(String surveyDefaultLocale) {
    this.surveyDefaultLocale = surveyDefaultLocale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get portfolio survey question groups.
   *
   * @param  questions  DOCUMENT ME!
   */
  public void setSurveyQuestions(Set<PortfolioQuestion> questions) {
    this.questions = questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveys  DOCUMENT ME!
   */
  public void setSurveys(Set<PortfolioSurvey> surveys) {
    this.surveys = surveys;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  theme  DOCUMENT ME!
   */
  public void setTheme(String theme) {
    this.theme = theme;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for timezone hash set.
   *
   * @param  timezoneHashSet  Set
   */
  public void setTimezoneHashSet(Set<Timezone> timezoneHashSet) {
    this.timezoneHashSet = timezoneHashSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  timeZones  the timeZones to set
   */
  public void setTimeZones(String timeZones) {
    this.timeZones = timeZones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  totalProgramShown  the totalProgramShown to set
   */
  public void setTotalProgramShown(Integer totalProgramShown) {
    this.totalProgramShown = totalProgramShown;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction codes.
   *
   * @param  transactionCodes  Set
   */
  public void setTransactionCodes(Set<TransactionCode> transactionCodes) {
    this.transactionCodes = transactionCodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans batch headers.
   *
   * @param  transBatchHeaders  Set
   */
  public void setTransBatchHeaders(Set<TransactionBatchHeader> transBatchHeaders) {
    this.transBatchHeaders = transBatchHeaders;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio caller id.
   *
   * @param  twilioCallerId  String
   */
  public void setTwilioCallerId(String twilioCallerId) {
    this.twilioCallerId = twilioCallerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateContactNotAllowedDays  DOCUMENT ME!
   */
  public void setUpdateContactNotAllowedDays(Integer updateContactNotAllowedDays) {
    this.updateContactNotAllowedDays = updateContactNotAllowedDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateMraContactInformation  DOCUMENT ME!
   */
  public void setUpdateMraContactInformation(Boolean updateMraContactInformation) {
    this.updateMraContactInformation = updateMraContactInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variables  DOCUMENT ME!
   */
  public void setVariables(Set<PortfolioVariable> variables) {
    this.variables = variables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for veda branch code.
   *
   * @param  vedaBranchCode  String
   */
  public void setVedaBranchCode(String vedaBranchCode) {
    this.vedaBranchCode = vedaBranchCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for veda subscriber code.
   *
   * @param  vedaSubscriberCode  String
   */
  public void setVedaSubscriberCode(String vedaSubscriberCode) {
    this.vedaSubscriberCode = vedaSubscriberCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  webSiteUrl  the webSiteUrl to set
   */
  public void setWebSiteUrl(String webSiteUrl) {
    this.webSiteUrl = webSiteUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  weeklyProgramTrackingPeriod  DOCUMENT ME!
   */
  public void setWeeklyProgramTrackingPeriod(Integer weeklyProgramTrackingPeriod) {
    this.weeklyProgramTrackingPeriod = weeklyProgramTrackingPeriod;
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

    retValue.append("Portfolio ( ").append("allowCallOnSaturday = ").append(
      this.allowCallOnSaturday).append(TAB).append("allowCallOnSunday = ").append(this.allowCallOnSunday).append(TAB)
      .append("client = ").append(this.client).append(TAB).append("description = ").append(
      this.description).append(TAB).append(
      "defaultPaymentReminderDays = ").append(
      this.defaultPaymentReminderDays).append(TAB).append("duration = ").append(this.duration).append(TAB).append(
      "endTime = ").append(
      this.apptEndTime).append(TAB).append("industry = ").append(
      this.industry).append(TAB).append("minPayment = ").append(
      this.minPayment).append(TAB).append("name = ").append(this.name).append(TAB).append("portfolioId = ").append(
      this.portfolioId).append(TAB).append("processingFee = ").append(this.processingFee).append(TAB).append(
      "programFirstDueDate = ").append(
      this.programFirstDueDate).append(TAB).append("showApptComment = ").append(this.showApptComment).append(TAB)
      .append("apptStartTime = ").append(this.apptStartTime).append(TAB).append("timeZones = ").append(this.timeZones)
      .append(TAB).append("totalProgramShown = ").append(this.totalProgramShown).append(TAB).append(
      "accountLevelDisclosure = ").append(this.accountLevelDisclosure).append(TAB).append("disclosureGroupName = ")
      .append(
        this.disclosureGroupName).append(TAB).append(
      "awCancelOfferDeletePayment = ").append(this.awCancelOfferDeletePayment).append(" )");

    return retValue.toString();
  } // end method toString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePortfolio.
   *
   * @param  other    Portfolio
   * @param  isAdmin  boolean
   */
  public void updatePortfolio(Portfolio other, boolean isAdmin) {
    super.updatePortfolio(other);
    updatePortfolio(other, isAdmin, true);
  } // end method updatePortfolio

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updatePortfolio.
   *
   * @param  other          Portfolio
   * @param  isAdmin        boolean
   * @param  updatedefault  boolean
   */
  public void updatePortfolio(Portfolio other, boolean isAdmin, boolean updatedefault) {
    this.allowAmericanExpress          = other.allowAmericanExpress;
    this.allowCredit                   = other.allowCredit;
    this.allowDebit                    = other.allowDebit;
    this.allowDinersClub               = other.allowDinersClub;
    this.allowDiscover                 = other.allowDiscover;
    this.allowJCB                      = other.allowJCB;
    this.allowOverBalancePayment       = other.allowOverBalancePayment;
    this.allowBankcard                 = other.allowBankcard;
    this.allowMasterCard               = other.allowMasterCard;
    this.allowVisa                     = other.allowVisa;
    this.allowVisaDebit                = other.allowVisaDebit;
    this.allowVisaElectron             = other.allowVisaElectron;
    this.apptEndDaysFromNow            = other.apptEndDaysFromNow;
    this.apptEndHoursFromNow           = other.apptEndHoursFromNow;
    this.apptEndTime                   = other.apptEndTime;
    this.apptLanguages                 = other.apptLanguages;
    this.apptStartDaysFromNow          = other.apptStartDaysFromNow;
    this.apptStartHoursFromNow         = other.apptStartHoursFromNow;
    this.apptStartTime                 = other.apptStartTime;
    this.currencySymbol                = other.currencySymbol;
    this.currencySymbolPosition        = other.currencySymbolPosition;
    this.defaultCountry                = other.defaultCountry;
    this.defaultPaymentReminderDays    = other.defaultPaymentReminderDays;
    this.description                   = other.description;
    this.duration                      = other.duration;
    this.hours                         = other.hours;
    this.ivrAgentPhoneNum              = other.ivrAgentPhoneNum;
    this.ivrPhoneNum                   = other.ivrPhoneNum;
    this.letterSignerName              = other.letterSignerName;
    this.loginCaptchaThreshold         = other.loginCaptchaThreshold;
    this.logoName                      = other.logoName;
    this.minPayment                    = other.minPayment;
    this.name                          = other.name;
    this.originalCreditor              = other.originalCreditor;
    this.payableName                   = other.payableName;
    this.paymentAddress1               = other.paymentAddress1;
    this.paymentAddress2               = other.paymentAddress2;
    this.paymentAdvanceDays            = other.paymentAdvanceDays;
    this.paymentCity                   = other.paymentCity;
    this.paymentCountry                = other.paymentCountry;
    this.paymentPostalCode             = other.paymentPostalCode;
    this.paymentProvince               = other.paymentProvince;
    this.paymentServiceId              = other.paymentServiceId;
    this.processingFee                 = other.processingFee;
    this.programFirstDueDate           = other.programFirstDueDate;
    this.returnAddress1                = other.returnAddress1;
    this.returnAddress2                = other.returnAddress2;
    this.returnCity                    = other.returnCity;
    this.returnCountry                 = other.returnCountry;
    this.returnPostalCode              = other.returnPostalCode;
    this.returnProvince                = other.returnProvince;
    this.showApptComment               = other.showApptComment;
    this.showCountry                   = other.showCountry;
    this.timeZones                     = other.timeZones;
    this.totalProgramShown             = other.totalProgramShown;
    this.webSiteUrl                    = other.webSiteUrl;
    this.notifyToEmails                = other.notifyToEmails;
    this.notifyCcEmails                = other.notifyCcEmails;
    this.notifyBccEmails               = other.notifyBccEmails;
    this.notifySubject                 = other.notifySubject;
    this.notifyTemplate                = other.notifyTemplate;
    this.allowSPOC                     = other.allowSPOC;
    this.allowHotSpot                  = other.allowHotSpot;
    this.allowEditTelephoneCountryCode = other.getAllowEditTelephoneCountryCode();
    this.showCountryCode               = other.getShowCountryCode();
    this.cutOffTime                    = other.getCutOffTime();
    this.realtimeAccountDetails        = other.getRealtimeAccountDetails();
    this.addressline1mandatory         = other.addressline1mandatory;

    this.overBalanceToleranceAmount     = other.getOverBalanceToleranceAmount();
    this.overBalanceTolerancePercentage = other.getOverBalanceTolerancePercentage();
    this.enablePaymentDisclosureText    = other.enablePaymentDisclosureText;
    this.allowCustomerPortalSendMQRequest = other.getAllowCustomerPortalSendMQRequest();

    if (updatedefault) {
      this.agentTimeZoneId = other.agentTimeZoneId;

      this.apptStartTimeSunday    = other.apptStartTimeSunday;
      this.apptStartTimeMonday    = other.apptStartTimeMonday;
      this.apptStartTimeTuesday   = other.apptStartTimeTuesday;
      this.apptStartTimeWednesday = other.apptStartTimeWednesday;
      this.apptStartTimeThursday  = other.apptStartTimeThursday;
      this.apptStartTimeFriday    = other.apptStartTimeFriday;
      this.apptStartTimeSaturday  = other.apptStartTimeSaturday;

      this.commissionRate = other.commissionRate;

      this.defaultTelephoneCountryCode = other.getDefaultTelephoneCountryCode();

      // this.surveys = other.surveys;
      // this.questions = other.questions;
      this.surveyDefaultLocale = other.surveyDefaultLocale;
    }


    // this.enableProgramTrackingConfig = other.enableProgramTrackingConfig;
    this.weeklyProgramTrackingPeriod      = other.weeklyProgramTrackingPeriod;
    this.fortnightlyProgramTrackingPeriod = other.fortnightlyProgramTrackingPeriod;
    this.monthlyProgramTrackingPeriod     = other.monthlyProgramTrackingPeriod;
    this.twilioCallerId                   = other.twilioCallerId;

    if (isAdmin) {
      // only allow admin to update
      this.allowCallOnSaturday = other.allowCallOnSaturday;
      this.allowCallOnSunday   = other.allowCallOnSunday;
      this.client              = other.client;
      this.industry            = other.industry;
      this.theme               = other.theme;

      // this.expressConsentDisplay  = other.expressConsentDisplay;
      this.paymentServiceProvider = other.paymentServiceProvider;
    }
  } // end method updatePortfolio

} // end class Portfolio
