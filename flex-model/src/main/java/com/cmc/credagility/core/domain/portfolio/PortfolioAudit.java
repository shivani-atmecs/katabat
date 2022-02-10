package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

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
import javax.persistence.Table;

import com.cmc.credagility.core.domain.CurrencySymbolPosition;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created by IntelliJ IDEA. User: yzhang Date: Nov 8, 2010 Time: 1:13:22 AM To change this template use File | Settings
 * | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "portfolioIdIndex",
      columnList = "portfolioId"
    )
  }
)
public class PortfolioAudit extends AbstractPortfolio implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2529911972493387895L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "acceptedProgramShortTerm",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean acceptedProgramShortTerm = false;

  /** account level disclosure. */
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
    name             = "allowBankcard",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowBankcard = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowDynamicProgram",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowDynamicProgram = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowSurvey",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSurvey = false;

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
    name     = "interestStartDate",
    nullable = true,
    length   = 1
  )
  protected String interestStartDate;

  /** Last Updater. */
  @JoinColumn(
    name       = "lastUpdaterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User lastUpdater;


  /** portfolio name, default is "Default". */
  @Column(
    name     = "name",
    nullable = false,
    length   = 80
  )
  protected String name = "Default";

  /** TODO: DOCUMENT ME! */
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

  /** TODO: DOCUMENT ME! */
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

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowCredit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowCredit = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowDebit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowDebit = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowDinersClub",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowDinersClub = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowDiscover",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowDiscover = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowEditContact",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowEditContact;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowJCB",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowJCB = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowMasterCard",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowMasterCard = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowMultiplePromises",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowMultiplePromises = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowSplitPayment",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSplitPayment = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowUpdateContact",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowUpdateContact = Boolean.TRUE;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowVisa",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowVisa = false;

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

  /** Application languages such as English, Spanish. */
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

  /** Agent inactive time. */
  @Column(name = "awAgentInactiveTime")
  protected Integer awAgentInactiveTime = 0;

  /** Maximum days create future send date secured promise. */
  @Column(name = "awMaxDaysCreateFutureSendDateSecuredPromise")
  protected Integer awMaxDaysCreateFutureSendDateSecuredPromise = 10;

  /** Maximum days create future send date Un-secured Promise. */
  @Column(name = "awMaxDaysCreateFutureSendDateUnsecuredPromise")
  protected Integer awMaxDaysCreateFutureSendDateUnsecuredPromise = 10;

  /** Maximum days create past send date Un-secured promise. */
  @Column(name = "awMaxDaysCreatePastSendDateUnsecuredPromise")
  protected Integer awMaxDaysCreatePastSendDateUnsecuredPromise = 10;

  /** Maximum days send arrival date secured promise. */
  @Column(name = "awMaxDaysSendArrivalDateSecuredPromise")
  protected Integer awMaxDaysSendArrivalDateSecuredPromise = 10;

  /** Maximum days send arrival date un-secured promise. */
  @Column(name = "awMaxDaysSendArrivalDateUnsecuredPromise")
  protected Integer awMaxDaysSendArrivalDateUnsecuredPromise = 10;

  /** Message count. */
  @Column(
    name     = "awMessageCount",
    nullable = true
  )
  protected Integer awMessageCount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "cancelProgram",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean cancelProgram = false;


  /** channel vendor account. */
  @Column(length = 20)
  protected String channelVendorAccount;

  /** Charge off days. */
  @Column(
    name   = "chargeOffDays",
    length = 5
  )
  protected Integer chargeOffDays;

  /** Commission rate. */
  @Column(
    name      = "commissionRate",
    precision = 19,
    scale     = 4
  )
  protected BigDecimal commissionRate;

  // npelleti 08/17 Set CurrencySymbol to 4 and moved after commissionRate
  /** Currency symbol. */
  @Column(
    name   = "currencySymbol",
    length = 4
  )
  protected String currencySymbol;


  /** Default country. */
  @Column(
    name     = "defaultCountry",
    length   = 2,
    nullable = false
  )
  protected String defaultCountry;

  /** default payment reminder days. */
  @Column(
    name     = "defaultPaymentReminderDays",
    nullable = false
  )
  protected Integer defaultPaymentReminderDays = 10;

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

  /** How many rows will show, default is 4. */
  @Column protected Integer displayRow = 4;

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

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "enableProgramTrackingConfig",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enableProgramTrackingConfig = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "expressConsent",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean expressConsent = false;

  /** Express consent display. */
  @Column(
    name   = "expressConsentDisplay",

    // nullable = true,
    length = 1
  )
  protected String expressConsentDisplay;

  /** External reference Id. */
  @Column(
    name     = "externalReferenceId",
    nullable = true,
    length   = 30
  )
  protected String externalReferenceId;

  /** Fortnightly program tracking period. */
  @Column(nullable = true)
  protected Integer fortnightlyProgramTrackingPeriod;


  /** The help email address. */
  @Column(
    name   = "helpEmail",
    length = 128
  )
  protected String helpEmail;

  /** Hours. */
  @Column(
    name     = "hours",
    nullable = false,
    length   = 150
  )
  protected String hours;

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

  // npelleti 08/16 Alter column length 100
  /** Which page will show after login success. */
  @Column(
    name   = "landingView",
    length = 100
  )
  protected String landingView = "/html/acctSummary";

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

  /** Payment post code. */
  @Column(
    name     = "paymentPostalCode",
    nullable = false,
    length   = 15
  )
  protected String paymentPostalCode = "";

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

  /** portfolio PK portfolioId. */
  @Column(
    name     = "portfolioAuditId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioAuditId;

  /** portfolio PK portfolioId. */
  @Column(
    name     = "portfolioId",
    nullable = false
  )
  protected Long portfolioId;


  /** TODO: DOCUMENT ME! */
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

  /** TODO: DOCUMENT ME! */
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

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "saveReminderEmail",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean saveReminderEmail = false;

  /** show appointment description. */
  @Column(
    name             = "showApptComment",
    columnDefinition = "char",
    length           = 1,
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showApptComment = true;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "showCountry",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showCountry;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "showOverLimit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showOverLimit = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "speedBump",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean speedBump = false;


  /** Survey default locale, such as <code>EN-US.</code> */
  @Column(
    name   = "surveyDefaultLocale",
    length = 64
  )
  protected String surveyDefaultLocale;


  /** The page theme default is <code>default.</code> */
  @Column(
    name   = "theme",
    length = 30
  )
  protected String theme = "default";

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

  /** Update contact not allow days. */
  @Column(name = "updateContactNotAllowedDays")
  protected Integer updateContactNotAllowedDays;


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

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new PortfolioAudit object.
   */
  public PortfolioAudit() { }

  /**
   * Creates a new PortfolioAudit object.
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public PortfolioAudit(Portfolio portfolio) {
    this.createDate                                    = new Date();
    this.acceptedProgramShortTerm                      = portfolio.acceptedProgramShortTerm;
    this.accountLevelDisclosure                        = portfolio.accountLevelDisclosure;
    this.interestStartDate                             = portfolio.interestStartDate;
    this.allowDynamicProgram                           = portfolio.allowDynamicProgram;
    this.allowSurvey                                   = portfolio.allowSurvey;
    this.name                                          = portfolio.name;
    this.active                                        = portfolio.active;
    this.agentTimeZoneId                               = portfolio.agentTimeZoneId;
    this.allowAmericanExpress                          = portfolio.allowAmericanExpress;
    this.allowCallOnSaturday                           = portfolio.allowCallOnSaturday;
    this.allowCallOnSunday                             = portfolio.allowCallOnSunday;
    this.allowCredit                                   = portfolio.allowCredit;
    this.allowDebit                                    = portfolio.allowDebit;
    this.allowDinersClub                               = portfolio.allowDinersClub;
    this.allowDiscover                                 = portfolio.allowDiscover;
    this.allowEditContact                              = portfolio.allowEditContact;
    this.allowJCB                                      = portfolio.allowJCB;
    this.allowMasterCard                               = portfolio.allowMasterCard;
    this.allowBankcard                                 = portfolio.allowBankcard;
    this.accrueInterest                                = portfolio.accrueInterest;
    this.allowMultiplePromises                         = portfolio.allowMultiplePromises;
    this.allowSplitPayment                             = portfolio.allowSplitPayment;
    this.allowUpdateContact                            = portfolio.allowUpdateContact;
    this.allowVisa                                     = portfolio.allowVisa;
    this.apptEndDaysFromNow                            = portfolio.apptEndDaysFromNow;
    this.apptEndHoursFromNow                           = portfolio.apptEndHoursFromNow;
    this.apptEndTime                                   = portfolio.apptEndTime;
    this.apptEndTimeFriday                             = portfolio.apptEndTimeFriday;
    this.apptEndTimeMonday                             = portfolio.apptEndTimeMonday;
    this.apptEndTimeSaturday                           = portfolio.apptEndTimeSaturday;
    this.apptEndTimeSunday                             = portfolio.apptEndTimeSunday;
    this.apptEndTimeThursday                           = portfolio.apptEndTimeThursday;
    this.apptEndTimeTuesday                            = portfolio.apptEndTimeTuesday;
    this.apptEndTimeWednesday                          = portfolio.apptEndTimeWednesday;
    this.apptLanguages                                 = portfolio.apptLanguages;
    this.apptStartDaysFromNow                          = portfolio.apptStartDaysFromNow;
    this.apptStartHoursFromNow                         = portfolio.apptStartHoursFromNow;
    this.apptStartTime                                 = portfolio.apptStartTime;
    this.apptStartTimeFriday                           = portfolio.apptStartTimeFriday;
    this.apptStartTimeMonday                           = portfolio.apptStartTimeMonday;
    this.apptStartTimeSaturday                         = portfolio.apptStartTimeSaturday;
    this.apptStartTimeSunday                           = portfolio.apptStartTimeSunday;
    this.apptStartTimeThursday                         = portfolio.apptStartTimeThursday;
    this.apptStartTimeTuesday                          = portfolio.apptStartTimeTuesday;
    this.apptStartTimeWednesday                        = portfolio.apptStartTimeWednesday;
    this.awAgentInactiveTime                           = portfolio.awAgentInactiveTime;
    this.awMaxDaysCreateFutureSendDateSecuredPromise   = portfolio.awMaxDaysCreateFutureSendDateSecuredPromise;
    this.awMaxDaysCreateFutureSendDateUnsecuredPromise = portfolio.awMaxDaysCreateFutureSendDateUnsecuredPromise;
    this.awMaxDaysCreatePastSendDateUnsecuredPromise   = portfolio.awMaxDaysCreatePastSendDateUnsecuredPromise;
    this.awMaxDaysSendArrivalDateSecuredPromise        = portfolio.awMaxDaysSendArrivalDateSecuredPromise;
    this.awMaxDaysSendArrivalDateUnsecuredPromise      = portfolio.awMaxDaysSendArrivalDateUnsecuredPromise;
    this.awMessageCount                                = portfolio.awMessageCount;
    this.cancelProgram                                 = portfolio.cancelProgram;
    this.channelVendorAccount                          = portfolio.channelVendorAccount;
    this.chargeOffDays                                 = portfolio.chargeOffDays;
    this.commissionRate                                = portfolio.commissionRate;
    this.currencySymbol                                = portfolio.currencySymbol;
    this.currencySymbolPosition                        = portfolio.currencySymbolPosition;
    this.defaultCountry                                = portfolio.defaultCountry;
    this.defaultPaymentReminderDays                    = portfolio.defaultPaymentReminderDays;
    this.description                                   = portfolio.description;
    this.disclosureGroupName                           = portfolio.disclosureGroupName;
    this.displayRow                                    = portfolio.displayRow;
    this.doNotContactApptDays                          = portfolio.doNotContactApptDays;
    this.doNotContactDefaultDays                       = portfolio.doNotContactDefaultDays;
    this.doNotContactPaymentDays                       = portfolio.doNotContactPaymentDays;
    this.doNotContactPTPDays                           = portfolio.doNotContactPTPDays;
    this.doNotContactRpcDays                           = portfolio.doNotContactRpcDays;
    this.doNotContactWUPTPDays                         = portfolio.doNotContactWUPTPDays;
    this.duration                                      = portfolio.duration;
    this.enableProgramTrackingConfig                   = portfolio.enableProgramTrackingConfig;
    this.expressConsent                                = portfolio.expressConsent;
    this.expressConsentDisplay                         = portfolio.expressConsentDisplay;
    this.externalReferenceId                           = portfolio.externalReferenceId;
    this.fortnightlyProgramTrackingPeriod              = portfolio.fortnightlyProgramTrackingPeriod;
    this.helpEmail                                     = portfolio.helpEmail;
    this.hours                                         = portfolio.hours;
    this.ivrAgentPhoneNum                              = portfolio.ivrAgentPhoneNum;
    this.ivrPhoneNum                                   = portfolio.ivrPhoneNum;
    this.landingView                                   = portfolio.landingView;
    this.letterSignerName                              = portfolio.letterSignerName;
    this.loginCaptchaThreshold                         = portfolio.loginCaptchaThreshold;
    this.logoName                                      = portfolio.logoName;
    this.maxNumberOfRecurringPromisesAllowed           = portfolio.maxNumberOfRecurringPromisesAllowed;
    this.minDaysCreateArrivalDatePromise               = portfolio.minDaysCreateArrivalDatePromise;
    this.minPayment                                    = portfolio.minPayment;
    this.monthlyProgramTrackingPeriod                  = portfolio.monthlyProgramTrackingPeriod;
    this.notifyBccEmails                               = portfolio.notifyBccEmails;
    this.notifyCcEmails                                = portfolio.notifyCcEmails;
    this.notifySubject                                 = portfolio.notifySubject;
    this.notifyTemplate                                = portfolio.notifyTemplate;
    this.notifyToEmails                                = portfolio.notifyToEmails;
    this.offerRestrictionDays                          = portfolio.offerRestrictionDays;
    this.originalCreditor                              = portfolio.originalCreditor;
    this.payableName                                   = portfolio.payableName;
    this.paymentAddress1                               = portfolio.paymentAddress1;
    this.paymentAddress2                               = portfolio.paymentAddress2;
    this.paymentAdvanceDays                            = portfolio.paymentAdvanceDays;
    this.paymentCity                                   = portfolio.paymentCity;
    this.paymentCountry                                = portfolio.paymentCountry;
    this.paymentPostalCode                             = portfolio.paymentPostalCode;
    this.paymentProvince                               = portfolio.paymentProvince;
    this.paymentServiceId                              = portfolio.paymentServiceId;
    this.portfolioId                                   = portfolio.portfolioId;
    this.postChargeOffPayByDateValidate                = portfolio.postChargeOffPayByDateValidate;
    this.postChargeOffPayByDateValidateType            = portfolio.postChargeOffPayByDateValidateType;
    this.preChargeOffPayByDateValidate                 = portfolio.preChargeOffPayByDateValidate;
    this.preChargeOffPayByDateValidateType             = portfolio.preChargeOffPayByDateValidateType;
    this.processingFee                                 = portfolio.processingFee;
    this.programFirstDueDate                           = portfolio.programFirstDueDate;
    this.programTemplateCount                          = portfolio.programTemplateCount;
    this.ptpEvalToleranceDays                          = portfolio.ptpEvalToleranceDays;
    this.redirectURL                                   = portfolio.redirectURL;
    this.returnAddress1                                = portfolio.returnAddress1;
    this.returnAddress2                                = portfolio.returnAddress2;
    this.returnCity                                    = portfolio.returnCity;
    this.returnCountry                                 = portfolio.returnCountry;
    this.returnPostalCode                              = portfolio.returnPostalCode;
    this.returnProvince                                = portfolio.returnProvince;
    this.saveReminderEmail                             = portfolio.saveReminderEmail;
    this.showApptComment                               = portfolio.showApptComment;
    this.showCountry                                   = portfolio.showCountry;
    this.showOverLimit                                 = portfolio.showOverLimit;
    this.speedBump                                     = portfolio.speedBump;
    this.surveyDefaultLocale                           = portfolio.surveyDefaultLocale;
    this.theme                                         = portfolio.theme;
    this.timeZones                                     = portfolio.timeZones;
    this.totalProgramShown                             = portfolio.totalProgramShown;
    this.updateContactNotAllowedDays                   = portfolio.updateContactNotAllowedDays;
    this.webSiteUrl                                    = portfolio.webSiteUrl;
    this.weeklyProgramTrackingPeriod                   = portfolio.weeklyProgramTrackingPeriod;
    this.overBalanceToleranceAmount                    = portfolio.getOverBalanceToleranceAmount();
    this.overBalanceTolerancePercentage                = portfolio.getOverBalanceTolerancePercentage();
  } // end ctor PortfolioAudit

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  p  DOCUMENT ME!
   */
  public void copyPortfolio(Portfolio p) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAcceptedProgramShortTerm() {
    return acceptedProgramShortTerm;
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
   * getter method for accrue interest.
   *
   * @return  Boolean
   */
  public Boolean getAccrueInterest() {
    return accrueInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getActive() {
    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowCallOnSaturday() {
    return allowCallOnSaturday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowCallOnSunday() {
    return allowCallOnSunday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowCredit() {
    return allowCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowDebit() {
    return allowDebit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowDinersClub() {
    return allowDinersClub;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
    return allowDynamicProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowEditContact() {
    return allowEditContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowJCB() {
    return allowJCB;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowMasterCard() {
    return allowMasterCard;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowMultiplePromises() {
    return allowMultiplePromises;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowSplitPayment() {
    return allowSplitPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowSurvey() {
    return allowSurvey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowUpdateContact() {
    return allowUpdateContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
  public Integer getApptEndDaysFromNow() {
    return apptEndDaysFromNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getApptEndHoursFromNow() {
    return apptEndHoursFromNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptEndTime() {
    return apptEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptEndTimeFriday() {
    return apptEndTimeFriday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptEndTimeMonday() {
    return apptEndTimeMonday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptEndTimeSaturday() {
    return apptEndTimeSaturday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptEndTimeSunday() {
    return apptEndTimeSunday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptEndTimeThursday() {
    return apptEndTimeThursday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptEndTimeTuesday() {
    return apptEndTimeTuesday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptEndTimeWednesday() {
    return apptEndTimeWednesday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
  public Integer getApptStartDaysFromNow() {
    return apptStartDaysFromNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getApptStartHoursFromNow() {
    return apptStartHoursFromNow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptStartTime() {
    return apptStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptStartTimeFriday() {
    return apptStartTimeFriday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptStartTimeMonday() {
    return apptStartTimeMonday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptStartTimeSaturday() {
    return apptStartTimeSaturday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptStartTimeSunday() {
    return apptStartTimeSunday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptStartTimeThursday() {
    return apptStartTimeThursday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApptStartTimeTuesday() {
    return apptStartTimeTuesday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
  public Boolean getCancelProgram() {
    return cancelProgram;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getChargeOffDays() {
    return chargeOffDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getCommissionRate() {
    return commissionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDefaultCountry() {
    return defaultCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDefaultPaymentReminderDays() {
    return defaultPaymentReminderDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
  public Integer getDoNotContactApptDays() {
    return doNotContactApptDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDoNotContactDefaultDays() {
    return doNotContactDefaultDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDoNotContactPaymentDays() {
    return doNotContactPaymentDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDoNotContactPTPDays() {
    return doNotContactPTPDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDoNotContactRpcDays() {
    return doNotContactRpcDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDoNotContactWUPTPDays() {
    return doNotContactWUPTPDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
  public Boolean getEnableProgramTrackingConfig() {
    return enableProgramTrackingConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getExpressConsent() {
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
  public Integer getFortnightlyProgramTrackingPeriod() {
    return fortnightlyProgramTrackingPeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHelpEmail() {
    return helpEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHours() {
    return hours;
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
  public String getIvrAgentPhoneNum() {
    return ivrAgentPhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
  public String getLandingView() {
    return landingView;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getLastUpdater() {
    return lastUpdater;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMinDaysCreateArrivalDatePromise() {
    return minDaysCreateArrivalDatePromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNotifyBccEmails() {
    return notifyBccEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNotifyCcEmails() {
    return notifyCcEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNotifySubject() {
    return notifySubject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNotifyTemplate() {
    return notifyTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNotifyToEmails() {
    return notifyToEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getOfferRestrictionDays() {
    return offerRestrictionDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
  public String getPayableName() {
    return payableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentAddress1() {
    return paymentAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentAddress2() {
    return paymentAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPaymentAdvanceDays() {
    return paymentAdvanceDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentCity() {
    return paymentCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentCountry() {
    return paymentCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentPostalCode() {
    return paymentPostalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentProvince() {
    return paymentProvince;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentServiceId() {
    return paymentServiceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPortfolioAuditId() {
    return portfolioAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPortfolioId() {
    return portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getPostChargeOffPayByDateValidate() {
    return postChargeOffPayByDateValidate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPostChargeOffPayByDateValidateType() {
    return postChargeOffPayByDateValidateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getPreChargeOffPayByDateValidate() {
    return preChargeOffPayByDateValidate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreChargeOffPayByDateValidateType() {
    return preChargeOffPayByDateValidateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getProcessingFee() {
    return processingFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
  public String getRedirectURL() {
    return redirectURL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReturnAddress1() {
    return returnAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReturnAddress2() {
    return returnAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReturnCity() {
    return returnCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReturnCountry() {
    return returnCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReturnPostalCode() {
    return returnPostalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReturnProvince() {
    return returnProvince;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getSaveReminderEmail() {
    return saveReminderEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getShowApptComment() {
    return showApptComment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getShowCountry() {
    return showCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
    return speedBump;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSurveyDefaultLocale() {
    return surveyDefaultLocale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTheme() {
    return theme;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
  public Integer getTotalProgramShown() {
    return totalProgramShown;
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
   * @param  accountLevelDisclosure  DOCUMENT ME!
   */
  public void setAccountLevelDisclosure(String accountLevelDisclosure) {
    this.accountLevelDisclosure = accountLevelDisclosure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accrue interest.
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
   * @param  allowAmericanExpress  DOCUMENT ME!
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
   * @param  allowCallOnSaturday  DOCUMENT ME!
   */
  public void setAllowCallOnSaturday(Boolean allowCallOnSaturday) {
    this.allowCallOnSaturday = allowCallOnSaturday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowCallOnSunday  DOCUMENT ME!
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
   * @param  allowDinersClub  DOCUMENT ME!
   */
  public void setAllowDinersClub(Boolean allowDinersClub) {
    this.allowDinersClub = allowDinersClub;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowDiscover  DOCUMENT ME!
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
   * @param  allowEditContact  DOCUMENT ME!
   */
  public void setAllowEditContact(Boolean allowEditContact) {
    this.allowEditContact = allowEditContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowJCB  DOCUMENT ME!
   */
  public void setAllowJCB(Boolean allowJCB) {
    this.allowJCB = allowJCB;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowMasterCard  DOCUMENT ME!
   */
  public void setAllowMasterCard(Boolean allowMasterCard) {
    this.allowMasterCard = allowMasterCard;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowMultiplePromises  DOCUMENT ME!
   */
  public void setAllowMultiplePromises(Boolean allowMultiplePromises) {
    this.allowMultiplePromises = allowMultiplePromises;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
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
   * @param  allowVisa  DOCUMENT ME!
   */
  public void setAllowVisa(Boolean allowVisa) {
    this.allowVisa = allowVisa;
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
   * @param  apptEndTime  DOCUMENT ME!
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
   * @param  apptStartTime  DOCUMENT ME!
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
   * @param  awMessageCount  DOCUMENT ME!
   */
  public void setAwMessageCount(Integer awMessageCount) {
    this.awMessageCount = awMessageCount;
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
   * @param  defaultCountry  DOCUMENT ME!
   */
  public void setDefaultCountry(String defaultCountry) {
    this.defaultCountry = defaultCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  defaultPaymentReminderDays  DOCUMENT ME!
   */
  public void setDefaultPaymentReminderDays(
    Integer defaultPaymentReminderDays) {
    this.defaultPaymentReminderDays = defaultPaymentReminderDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  description  DOCUMENT ME!
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
   * @param  duration  DOCUMENT ME!
   */
  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  enableProgramTrackingConfig  DOCUMENT ME!
   */
  public void setEnableProgramTrackingConfig(
    Boolean enableProgramTrackingConfig) {
    this.enableProgramTrackingConfig = enableProgramTrackingConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expressConsent  DOCUMENT ME!
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
   * @param  fortnightlyProgramTrackingPeriod  DOCUMENT ME!
   */
  public void setFortnightlyProgramTrackingPeriod(
    Integer fortnightlyProgramTrackingPeriod) {
    this.fortnightlyProgramTrackingPeriod = fortnightlyProgramTrackingPeriod;
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
   * DOCUMENT ME!
   *
   * @param  hours  DOCUMENT ME!
   */
  public void setHours(String hours) {
    this.hours = hours;
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
   * @param  ivrAgentPhoneNum  DOCUMENT ME!
   */
  public void setIvrAgentPhoneNum(String ivrAgentPhoneNum) {
    this.ivrAgentPhoneNum = ivrAgentPhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ivrPhoneNum  DOCUMENT ME!
   */
  public void setIvrPhoneNum(String ivrPhoneNum) {
    this.ivrPhoneNum = ivrPhoneNum;
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
   * @param  lastUpdater  DOCUMENT ME!
   */
  public void setLastUpdater(User lastUpdater) {
    this.lastUpdater = lastUpdater;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  letterSignerName  DOCUMENT ME!
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
   * @param  logoName  DOCUMENT ME!
   */
  public void setLogoName(String logoName) {
    this.logoName = logoName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxNumberOfRecurringPromisesAllowed  DOCUMENT ME!
   */
  public void setMaxNumberOfRecurringPromisesAllowed(
    Integer maxNumberOfRecurringPromisesAllowed) {
    this.maxNumberOfRecurringPromisesAllowed = maxNumberOfRecurringPromisesAllowed;
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
   * @param  minPayment  DOCUMENT ME!
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
  public void setMonthlyProgramTrackingPeriod(
    Integer monthlyProgramTrackingPeriod) {
    this.monthlyProgramTrackingPeriod = monthlyProgramTrackingPeriod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  notifyBccEmails  DOCUMENT ME!
   */
  public void setNotifyBccEmails(String notifyBccEmails) {
    this.notifyBccEmails = notifyBccEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  notifyCcEmails  DOCUMENT ME!
   */
  public void setNotifyCcEmails(String notifyCcEmails) {
    this.notifyCcEmails = notifyCcEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  notifySubject  DOCUMENT ME!
   */
  public void setNotifySubject(String notifySubject) {
    this.notifySubject = notifySubject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  notifyTemplate  DOCUMENT ME!
   */
  public void setNotifyTemplate(String notifyTemplate) {
    this.notifyTemplate = notifyTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  notifyToEmails  DOCUMENT ME!
   */
  public void setNotifyToEmails(String notifyToEmails) {
    this.notifyToEmails = notifyToEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  offerRestrictionDays  DOCUMENT ME!
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
   * @param  payableName  DOCUMENT ME!
   */
  public void setPayableName(String payableName) {
    this.payableName = payableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentAddress1  DOCUMENT ME!
   */
  public void setPaymentAddress1(String paymentAddress1) {
    this.paymentAddress1 = paymentAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentAddress2  DOCUMENT ME!
   */
  public void setPaymentAddress2(String paymentAddress2) {
    this.paymentAddress2 = paymentAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentAdvanceDays  DOCUMENT ME!
   */
  public void setPaymentAdvanceDays(Integer paymentAdvanceDays) {
    this.paymentAdvanceDays = paymentAdvanceDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentCity  DOCUMENT ME!
   */
  public void setPaymentCity(String paymentCity) {
    this.paymentCity = paymentCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentCountry  DOCUMENT ME!
   */
  public void setPaymentCountry(String paymentCountry) {
    this.paymentCountry = paymentCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentPostalCode  DOCUMENT ME!
   */
  public void setPaymentPostalCode(String paymentPostalCode) {
    this.paymentPostalCode = paymentPostalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentProvince  DOCUMENT ME!
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
   * @param  portfolioAuditId  DOCUMENT ME!
   */
  public void setPortfolioAuditId(Long portfolioAuditId) {
    this.portfolioAuditId = portfolioAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioId  DOCUMENT ME!
   */
  public void setPortfolioId(Long portfolioId) {
    this.portfolioId = portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  postChargeOffPayByDateValidate  DOCUMENT ME!
   */
  public void setPostChargeOffPayByDateValidate(
    Boolean postChargeOffPayByDateValidate) {
    this.postChargeOffPayByDateValidate = postChargeOffPayByDateValidate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  postChargeOffPayByDateValidateType  DOCUMENT ME!
   */
  public void setPostChargeOffPayByDateValidateType(
    String postChargeOffPayByDateValidateType) {
    this.postChargeOffPayByDateValidateType = postChargeOffPayByDateValidateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preChargeOffPayByDateValidate  DOCUMENT ME!
   */
  public void setPreChargeOffPayByDateValidate(
    Boolean preChargeOffPayByDateValidate) {
    this.preChargeOffPayByDateValidate = preChargeOffPayByDateValidate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preChargeOffPayByDateValidateType  DOCUMENT ME!
   */
  public void setPreChargeOffPayByDateValidateType(
    String preChargeOffPayByDateValidateType) {
    this.preChargeOffPayByDateValidateType = preChargeOffPayByDateValidateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  processingFee  DOCUMENT ME!
   */
  public void setProcessingFee(BigDecimal processingFee) {
    this.processingFee = processingFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programFirstDueDate  DOCUMENT ME!
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
   * @param  redirectURL  DOCUMENT ME!
   */
  public void setRedirectURL(String redirectURL) {
    this.redirectURL = redirectURL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnAddress1  DOCUMENT ME!
   */
  public void setReturnAddress1(String returnAddress1) {
    this.returnAddress1 = returnAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnAddress2  DOCUMENT ME!
   */
  public void setReturnAddress2(String returnAddress2) {
    this.returnAddress2 = returnAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnCity  DOCUMENT ME!
   */
  public void setReturnCity(String returnCity) {
    this.returnCity = returnCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnCountry  DOCUMENT ME!
   */
  public void setReturnCountry(String returnCountry) {
    this.returnCountry = returnCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnPostalCode  DOCUMENT ME!
   */
  public void setReturnPostalCode(String returnPostalCode) {
    this.returnPostalCode = returnPostalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnProvince  DOCUMENT ME!
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
   * @param  showApptComment  DOCUMENT ME!
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
   * @param  surveyDefaultLocale  DOCUMENT ME!
   */
  public void setSurveyDefaultLocale(String surveyDefaultLocale) {
    this.surveyDefaultLocale = surveyDefaultLocale;
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
   * DOCUMENT ME!
   *
   * @param  timeZones  DOCUMENT ME!
   */
  public void setTimeZones(String timeZones) {
    this.timeZones = timeZones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  totalProgramShown  DOCUMENT ME!
   */
  public void setTotalProgramShown(Integer totalProgramShown) {
    this.totalProgramShown = totalProgramShown;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateContactNotAllowedDays  DOCUMENT ME!
   */
  public void setUpdateContactNotAllowedDays(
    Integer updateContactNotAllowedDays) {
    this.updateContactNotAllowedDays = updateContactNotAllowedDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  webSiteUrl  DOCUMENT ME!
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
  public void setWeeklyProgramTrackingPeriod(
    Integer weeklyProgramTrackingPeriod) {
    this.weeklyProgramTrackingPeriod = weeklyProgramTrackingPeriod;
  }
} // end class PortfolioAudit
