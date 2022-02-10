package com.cmc.credagility.util.constant;

/**
 * Constants values used throughout the application.
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 18:15
 */
public class Constants {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** The name of the ResourceBundle used in this application. */
  public static final String BUNDLE_KEY = "ApplicationResources";

  /** The encryption algorithm key to be used for passwords. */
  public static final String ENC_ALGORITHM = "algorithm";

  /** A flag to indicate if passwords should be encrypted. */
  public static final String ENCRYPT_PASSWORD = "encryptPassword";

  /** File separator from System properties. */
  public static final String FILE_SEP = System.getProperty("file.separator");

  /** User home from System properties. */
  public static final String USER_HOME = System.getProperty("user.home")
    + FILE_SEP;

  /** The name of the configuration hashmap stored in application scope. */
  public static final String CONFIG = "appConfig";

  /** DOCUMENT ME! */
  public static final String REDIRECT_SURVEY_HOTSPOT = "REDIRECT_SURVEY_HOTSPOT";

  /**
   * Session scope attribute that holds the locale set by the user. By setting this key to the same one that Struts
   * uses, we get synchronization in Struts w/o having to do extra work or have two session-level variables.
   */
  public static final String PREFERRED_LOCALE_KEY = "LOCALE"; // "org.apache.struts.action.LOCALE";

  /** The request scope attribute under which an editable user form is stored. */
  public static final String USER_KEY = "userForm";

  /** The request scope attribute that holds the user list. */
  public static final String USER_LIST = "userList";

  /** The request scope attribute for indicating a newly-registered user. */
  public static final String REGISTERED = "registered";

  /** The name of the Administrator role, as specified in web.xml. */
  public static final String ADMIN_ROLE = "admin";

  /** The name of the Agency Administrator role, as specified in web.xml. */
  public static final String CALL_CENTER_ADMIN_ROLE = "callCenterAdmin";

  /** The name of the Manager role, as specified in web.xml. */
  public static final String MANAGER_ROLE = "manager";

  /** The name of the User role, as specified in web.xml. */
  public static final String USER_ROLE = "user";

  /** The name of the user's role list, a request-scoped attribute when adding/editing a user. */
  public static final String USER_ROLES = "userRoles";

  /** The name of the available roles list, a request-scoped attribute when adding/editing a user. */
  public static final String AVAILABLE_ROLES = "availableRoles";

  /** The name of the CSS Theme setting. */
  public static final String CSS_THEME = "csstheme";

  /** The name of the default Country . */
  public static final String COUNTRY = "country";

  /** The name of enfored currencySymbol. */
  public static final String CURRENCY_SYMBOL = "currencySymbol";

  /** The name of enfored currencySymbolPosition. */
  public static final String CURRENCY_SYMBOL_POSITION = "currencySymbolPosition";

  /** The name of time zone. */
  public static final String TIME_ZONE_ID = "agentTimeZoneId";

  public static final String DYNAMIC_LOGIN_TOKEN = "DYNAMIC_LOGIN_TOKEN";

  // Client-START
  /** The request scope attribute that holds the client form. */
  public static final String CLIENT_KEY = "clientForm";

  /** The request scope attribute that holds the client list. */
  public static final String CLIENT_LIST = "clientList";
  // Client-END

  // Industry-START
  /** The request scope attribute that holds the industry form. */
  public static final String INDUSTRY_KEY = "industryForm";

  /** The request scope attribute that holds the industry list. */
  public static final String INDUSTRY_LIST = "industryList";
  // Industry-END

  // FundingAccountType-START
  /** The request scope attribute that holds the fundingAccountType form. */
  public static final String FUNDINGACCOUNTTYPE_KEY = "fundingAccountTypeForm";

  /** The request scope attribute that holds the fundingAccountType list. */
  public static final String FUNDINGACCOUNTTYPE_LIST = "fundingAccountTypeList";
  // FundingAccountType-END

  // FundingAccount-START
  /** The request scope attribute that holds the fundingAccount form. */
  public static final String FUNDINGACCOUNT_KEY = "fundingAccountForm";

  /** The request scope attribute that holds the fundingAccount list. */
  public static final String FUNDINGACCOUNT_LIST = "fundingAccountList";
  // FundingAccount-END

  // PaymentProgramType-START
  /** The request scope attribute that holds the paymentProgramType form. */
  public static final String PAYMENTPROGRAMTYPE_KEY = "paymentProgramTypeForm";

  /** The request scope attribute that holds the paymentProgramType list. */
  public static final String PAYMENTPROGRAMTYPE_LIST = "paymentProgramTypeList";
  // PaymentProgramType-END

  // PaymentProgram-START
  /** The request scope attribute that holds the paymentProgram form. */
  public static final String PAYMENTPROGRAM_KEY = "paymentProgramForm";

  /** The request scope attribute that holds the paymentProgram list. */
  public static final String PAYMENTPROGRAM_LIST = "paymentProgramList";
  // PaymentProgram-END

  // PaymentServiceProvider-START
  /** The request scope attribute that holds the paymentServiceProvider form. */
  public static final String PAYMENTSERVICEPROVIDER_KEY = "paymentServiceProviderForm";

  /** The request scope attribute that holds the paymentServiceProvider list. */
  public static final String PAYMENTSERVICEPROVIDER_LIST = "paymentServiceProviderList";
  // PaymentServiceProvider-END

  // Portfolio-START
  /** The request scope attribute that holds the portfolio form. */
  public static final String PORTFOLIO_KEY = "portfolioForm";

  /** The request scope attribute that holds the portfolio list. */
  public static final String PORTFOLIO_LIST = "portfolioList";
  // Portfolio-END

  // AgencyQueue-START
  /** The request scope attribute that holds the agencyQueue form. */
  public static final String QUEUE_KEY = "queueForm";

  /** The request scope attribute that holds the agencyQueue list. */
  public static final String QUEUE_LIST = "queueList";
  // AgencyQueue-END

  // Payment-START
  /** The request scope attribute that holds the payment form. */
  public static final String PAYMENT_KEY = "paymentForm";

  /** The request scope attribute that holds the payment list. */
  public static final String PAYMENT_LIST = "paymentList";
  // Payment-END

  // Account-START
  /** The request scope attribute that holds the account form. */
  public static final String ACCOUNT_KEY = "accountForm";

  /** The request scope attribute that holds the account list. */
  public static final String ACCOUNT_LIST = "accountList";
  // Account-END

  // Responsible-START
  /** The request scope attribute that holds the responsible form. */
  public static final String CARDHOLDER_KEY = "responsibleForm";

  /** The request scope attribute that holds the responsible list. */
  public static final String RESPONSIBLE_LIST = "responsibleList";
  // Responsible-END

  // AdvisorAppointment-START
  /** The request scope attribute that holds the advisorAppointment form. */
  public static final String ADVISORAPPOINTMENT_KEY = "advisorAppointmentForm";

  /** The request scope attribute that holds the advisorAppointment list. */
  public static final String ADVISORAPPOINTMENT_LIST = "advisorAppointmentList";
  // AdvisorAppointment-END

  /** Command name for account summary page. */
  public static final String SUMMARY_COMMAND = "summaryCommand";

  /** DOCUMENT ME! */
  public static final String CUSTOMER_SUMMARY_COMMAND = "customerSummaryCommand";

  /** Command name for SLM Poppad Command page. */
  public static final String SLM_POPPAD_COMMAND = "SLMPoppadCommand";

  // ContactAddress-START

  /** The request scope attribute that holds the contactAddress form. */
  public static final String CONTACTADDRESS_KEY = "contactAddressForm";

  /** The request scope attribute that holds the contactAddress list. */
  public static final String CONTACTADDRESS_LIST = "contactAddressList";
  // ContactAddress-END

  // ContactEmail-START
  /** The request scope attribute that holds the contactEmail form. */
  public static final String CONTACTEMAIL_KEY = "contactEmailForm";

  /** The request scope attribute that holds the contactEmail list. */
  public static final String CONTACTEMAIL_LIST = "contactEmailList";
  // ContactEmail-END

  // ContactPhone-START
  /** The request scope attribute that holds the contactPhone form. */
  public static final String CONTACTPHONE_KEY = "contactPhoneForm";

  /** The request scope attribute that holds the contactPhone list. */
  public static final String CONTACTPHONE_LIST = "contactPhoneList";
  // ContactPhone-END

  /** contact. */
  public static final String HOME_PHONE = "homePhone";

  /** DOCUMENT ME! */
  public static final String MOBILE_PHONE = "mobilePhone";

  /** DOCUMENT ME! */
  public static final String WORK_PHONE = "workPhone";

  /** DOCUMENT ME! */
  public static final String OTHER_PHONE = "otherPhone";

  /** DOCUMENT ME! */
  public static final String SMS_PHONE = "smsPhone";

  /** DOCUMENT ME! */
  public static final String HOME_FAX = "homeFax";

  /** DOCUMENT ME! */
  public static final String WORK_FAX = "workFax";

  /** DOCUMENT ME! */
  public static final String HOME_EMAIL = "homeEmail";

  /** DOCUMENT ME! */
  public static final String WORK_EMAIL = "workEmail";

  /** DOCUMENT ME! */
  public static final String HOME_ADDRESS = "homeAddress";

  /** DOCUMENT ME! */
  public static final String WORK_ADRESS = "workAddress";

  /** Payment details. */
  public static final String PAYMENT_DETAIL = "paymentDetail";

  /** Invoice details. */
  public static final String INVOICE_LIST = "invoiceList";
  // OutcomeType-START

  /** The request scope attribute that holds the outcomeType form. */
  public static final String OUTCOMETYPE_KEY = "outcomeTypeForm";

  /** The request scope attribute that holds the outcomeType list. */
  public static final String OUTCOMETYPE_LIST = "outcomeTypeList";
  // OutcomeType-END

  // Agency-START
  /** The request scope attribute that holds the agency form. */
  public static final String AGENCY_KEY = "agencyForm";

  /** The request scope attribute that holds the agency list. */
  public static final String AGENCY_LIST = "agencyList";
  // Agency-END

  // HotAction-START
  /** The request scope attribute that holds the hotAction form. */
  public static final String HOTACTION_KEY = "hotActionForm";

  /** The request scope attribute that holds the hotAction list. */
  public static final String HOTACTION_LIST = "hotActionList";
  // HotAction-END

  // SurveyQuestion-START
  /** The request scope attribute that holds the question form. */
  public static final String SURVEYQUESTION_KEY = "surveyQuestionForm";

  /** The request scope attribute that holds the question list. */
  public static final String SURVEYQUESTION_LIST = "surveyQuestionList";
  // SurveyQuestion-END

  // SurveyAnswer-START
  /** The request scope attribute that holds the surveyAnswer form. */
  public static final String SURVEYANSWER_KEY = "surveyAnswerForm";

  /** The request scope attribute that holds the surveyAnswer list. */
  public static final String SURVEYANSWER_LIST = "surveyAnswerList";
  // SurveyAnswer-END

  // NegotiateProgramType-START
  /** The request scope attribute that holds the negotiateProgramTypes form. */
  public static final String ACCOUNTPROGRAMTYPES_KEY = "accountProgramTypesForm";

  /** The request scope attribute that holds the negotiateProgramTypes list. */
  public static final String ACCOUNTPROGRAMTYPES_LIST = "accountProgramTypesList";
  // NegotiateProgramType-END

  /** The request scope attribute that holds the stateParameter form. */
  public static final String STATEPARAMETER_KEY = "stateParameterForm";

  /** The request scope attribute that holds the stateParameter list. */
  public static final String STATEPARAMETER_LIST = "stateParameterList";

  // TemplateType-START
  /** The request scope attribute that holds the templateType form. */
  public static final String TEMPLATETYPE_KEY = "templateTypeForm";

  /** The request scope attribute that holds the templateType list. */
  public static final String TEMPLATETYPE_LIST = "templateTypeList";
  // TemplateType-END

  /** DOCUMENT ME! */
  public static final String PORTFOLIO_THEME_KEY_NAME = "portfolioThemeKeyName";

  /** DOCUMENT ME! */
  public static final String CMC_PORTFOLIO_THEME_KEY = "cmcPortfolioThemeKey";

  /** DOCUMENT ME! */
  public static final String REQUEST_SCOPE_PORTFOLIO_KEY = "portfolioResourceKey";

  // AccountStatusDetail-START
  /** The request scope attribute that holds the accountStatusDetail form. */
  public static final String ACCOUNTSTATUSDETAIL_KEY = "accountStatusDetailForm";

  /** The request scope attribute that holds the accountStatusDetail list. */
  public static final String ACCOUNTSTATUSDETAIL_LIST = "accountStatusDetailList";
  // AccountStatusDetail-END

  // AgencyTeam-START
  /** The request scope attribute that holds the agencyTeam form. */
  public static final String AGENCYTEAM_KEY = "agencyTeamForm";

  /** The request scope attribute that holds the agencyTeam list. */
  public static final String AGENCYTEAM_LIST = "agencyTeamList";
  // AgencyTeam-END

  /** DOCUMENT ME! */
  public static final String RESPONSIBLE_ID = "responsibleId";

  /** DOCUMENT ME! */
  public static final String MRAPORTFOLIO = "mraPortfolio";
  // Loan Details

  /** DOCUMENT ME! */
  public static final String MRALOGIN_RESPONSIBLEID = "mraLoginResponsibleId";

  /** DOCUMENT ME! */
  public static final String MRASWAP_RESPONSIBLEID = "mraSwap_ResponsibleId";

  /** DOCUMENT ME! */
  public static final String LOAN_COMMAND = "slmLoanCommand";

  // JMS Status
  /** DOCUMENT ME! */
  public static final String JMS_NEW = "NEW";

  /** DOCUMENT ME! */
  public static final String JMS_SENT = "SENT";

  /** DOCUMENT ME! */
  public static final String JMS_SEND_FAILED = "SEND_FAILED";

  /** DOCUMENT ME! */
  public static final String JMS_CLIENT_PASS = "CLIENT_PASS";

  /** DOCUMENT ME! */
  public static final String JMS_CLIENT_FAILURE = "CLIENT_FAILURE";

  /** DOCUMENT ME! */
  public static final String JMS_CLIENT_FAILURE_RETRY = "CLIENT_FAILURE_RETRY";

  /** DOCUMENT ME! */
  public static final String JMS_NOT_PROCESSED = "NOT_PROCESSED";

  /** DOCUMENT ME! */
  public static final String CONTEXT_CONFIG_LOCATION_ID = "contextId";

  /** DOCUMENT ME! */
  public static final String DYNAMIC_PROGRAM_TEMPLATES = "dynamicProgramTemplates";

  /** DOCUMENT ME! */
  public static final String DYNAMIC_PROGRAM_TOTAL_AMOUNTS = "dynamicProgramTotalAmounts";

  /** DOCUMENT ME! */
  public static final String DYNAMIC_PROGRAM_INSTALLMENT_AMOUNT = "dynamicProgramInstallmentAmount";

  /** DOCUMENT ME! */
  public static final String DYNAMIC_PROGRAMS = "dynamicPrograms";

  /** DOCUMENT ME! */
  public static final String CHANNEL_ORIGINATION_CODE = "COCODE";

  /** DOCUMENT ME! */
  public static final String FIRST_PAYMENT_CODE = "FPCODE";

  /** JMS CONSTANTS FOR Swiss Card START. */
  /** DOCUMENT ME! */
  public static final String PTP_ADD_COMMERCIAL = "ADDPTPCC";

  /** DOCUMENT ME! */
  public static final String PTP_ADD_CONSUMER = "ADDPTPCH";

  /** DOCUMENT ME! */
  public static final String PTP_DELETE_COMMERCIAL = "DELETEPTPCC";

  /** DOCUMENT ME! */
  public static final String PTP_DELETE_CONSUMER = "DELETEPTPCH";

  /** DOCUMENT ME! */
  public static final String PTP_UPDATE_COMMERCIAL = "UPDATEPTPCC";

  /** DOCUMENT ME! */
  public static final String PTP_UPDATE_CONSUMER = "UPDATEPTPCH";

  /** DOCUMENT ME! */
  public static final String NOT_PROCESSED_STATUS = "NOT_PROCESSED";

  /** DOCUMENT ME! */
  public static final String CUSTOMER_TYPE = "customerType";

  /** DOCUMENT ME! */
  public static final String REQUEST_START_TIME = "REQUEST_START_TIME";

  /** DOCUMENT ME! */
  public static final String BBL_SHOW_PRDI = "bblShowPrdi";

  /** JMS CONSTANTS FOR Swiss Card END. */

  public static final String ALLOW_MOBILE = "allowMobile";

  /** DOCUMENT ME! */
  public static final String AW_LANDING_VIEW_PAGE = "AW_Landing_View_Page";

  /** DOCUMENT ME! */
  public static final String TWILIO_TIME_PATTERN = "EEE, dd MMM yyyy HH:mm:ss Z";

  /** TODO: DOCUMENT ME! */
  public static final String SITE_WEB_FLOW_PREFIX = "/flow/";

  /** TODO: DOCUMENT ME! */
  public static final String URL_DECRYPT_MAP_NAME = "decryptMap";

  /** TODO: DOCUMENT ME! */
  public static final int FILE_SIZE_1M = 1024 * 1024;

  /** TODO: DOCUMENT ME! */
  public static final String ELIGIBLE_PROGRAM_NAMES = "_eligibleProgramNames";

  /** TODO: DOCUMENT ME! */
  public static final String LOGIN_TOKEN_ENCRYPTED_URL = "_LOGIN_TOKEN_ENCRYPTED_URL";

  /** TODO: DOCUMENT ME! */
  public static final String LOGIN_TOKEN_ENCRYPTED_URL_PREFIX = "/r_key_";

  /** TODO: DOCUMENT ME! */
  public static final String LOGIN_TOKEN_NAME = ".LOGIN_TOKEN_NAME_IN_REQUEST";

  /** use to jcr custom page folder. */
  public static final String CMC_CUSTOM_PAGE_PATH = "custom";

  /** use to jcr global contents folder. */
  public static final String CMC_GLOBAL_CONTENTS = "globalContents";

  /** use to jcr page contents folder. */
  public static final String CMC_PAGE_CONTENTS = "pageContents";

  /** DOCUMENT ME! */
  public static final String NON_AUTHENTICATED_WORKFLOW_URL_PREFIX = "/nonAuthenticated";

  /** DOCUMENT ME! */
  public static final String SHOW_CUSTOMER_SUMMARY = "showCustomerSummary";

  /** DOCUMENT ME! */
  public static final String DISPLAY_NAME = "displayName";

  /** DOCUMENT ME! */
  public static final String SHOW_CUSTOMER_SUMMARY_LINK = "showCustomerSummaryLink";

  /** TODO: DOCUMENT ME! */
  public static final String FLEX_SITE_SSO_LOGIN_OUT_URL = "flexSiteSSOLogoutURL";

  /** DOCUMENT ME! */
  public static final String FLEX_SITE_SSO_MYACCOUNT_OUT_URL = "custSiteURL";

  /** DOCUMENT ME! */
  public static final String THEME_LOGOUT_URL = "themeLogoutURL";

  /** DOCUMENT ME! */
  public static final String FLEX_SITE_SHOW_MYACCOUNT_BUTTON = "showMyAccount";

  /** DOCUMENT ME! */
  public static final String JSESSIONID_RKEY = "currentSessionRkey";

  /** DOCUMENT ME! */
  public static final String SHOW_CUSTOMER_SUMMARY_OPTION = "showCustomerSummaryOption";

  /** DOCUMENT ME! */
  public static final String SELECTED_LANGUAGE_CODE = "selectedLanguageCode";

  /** DOCUMENT ME! */
  public static final String LANGUAGE_CODES = "languageCodes";

  public static final String DEFAULT_LANGUAGE = "en_US";

  /** DOCUMENT ME! */
  public static final String IS_THIRD_PARTY_CUSTOMER = "isThirdPartyCustomer";

  public static final String HIDE_NAVIGATION_TOOLBAR = "hideNavigationToolBar";
} // end class Constants
