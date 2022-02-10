package com.cmc.credagility.core.domain.type;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:jia.zhang@ozstrategy.com">Jia Zhang</a>
 * @version  08/11/2016 17:17
 */
public enum WebhookEvent {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  PAYMENT_CREATED("PaymentCreated", "a_MakePayment"), PAYMENT_UPDATED("PaymentUpdated", "a_UpdatePayment"),
  PAYMENT_PROCESSED_BY_BATCH("PaymentProcessedByBatch", "a_ProcessPaymentByBatch"),
  PAYMENT_DELETED("PaymentDeleted", "a_DeletePayment"), FUND_ACCT_CREATED("FundAcctCreated", "a_AddFundAcct"),
  PAYMENT_REJECTED("PaymentRejected", "a_RejectPayment"), PAYMENT_PAID("PaymentPaid", "a_PayPayment"),
  FUND_ACCT_DELETED("FundAcctDeleted", "a_DeleteFundAcct"),
  FUND_ACCT_MADE_PRIMARY("FundAcctMadePrimary", "a_MakeDefaultFundAcct"),
  AUTODEBIT_CREATED("AutoDebitEnrolled", "a_enrollAutoDebit"),
  AUTODEBIT_CANCELLED("AutoDebitCancelled", "a_cancelAutoDebit"),
  AUTODEBIT_UPDATED("AutoDebitUpdated", "a_updateAutoDebit"), ADD_PHONE("AddPhone", "a_AddPhone"),
  DELETE_PHONE("DeletePhone", "a_DeletePhone"), UPDATE_PHONE("UpdatePhone", "a_UpdatePhone"),
  ADD_EMAIL("AddEmail", "a_addEmail"), DELETE_EMAIL("DeleteEmail", "a_deleteEmail"),
  UPDATE_EMAIL("UpdateEmail", "a_UpdateEmail"), ADD_ADDRESS("AddAddress", "a_addAddress"),
  DELETE_ADDRESS("DeleteAddress", "a_deleteAddress"), UPDATE_ADDRESS("UpdateAddress", "a_UpdateAddress"),
  GRANT_EXPRESS_CONSENT_PHONE_SMS("GrantExpressConsentPhoneSMS", "a_GrantExpressConsentPhoneSMS"),
  REMOVE_EXPRESS_CONSENT_PHONE_SMS("RemoveExpressConsentPhoneSMS", "a_RemoveExpressConsentPhoneSMS"),
  GRANT_EXPRESS_CONSENT_PHONE_VOICE("GrantExpressConsentPhoneVoice", "a_GrantExpressConsentPhoneVoice"),
  REMOVE_EXPRESS_CONSENT_PHONE_VOICE("RemoveExpressConsentPhoneVoice", "a_RemoveExpressConsentPhoneVoice"),
  GRANT_EXPRESS_CONSENT_ADDRESS("GrantExpressConsentAddress", "a_GrantExpressConsentAddress"),
  REMOVE_EXPRESS_CONSENT_ADDRESS("RemoveExpressConsentAddress", "a_RemoveExpressConsentAddress"),
  GRANT_EXPRESS_CONSENT_EMAIL("GrantExpressConsentEmail", "a_GrantExpressConsentEmail"),
  REMOVE_EXPRESS_CONSENT_EMAIL("RemoveExpressConsentEmail", "a_RemoveExpressConsentEmail"),
  DIALER_KILL_DISPOSITION("DialerKillDisposition", "a_DialerKillDisposition"),
  DIALER_KILL_PAYMENT_CREATED("DialerKillPaymentCreated", "a_DialerKillPaymentCreated"),
  DIALER_KILL_PAYMENT_UPDATED("DialerKillPaymentUpdated", "a_DialerKillPaymentUpdated"),
  PAYMENT_PROGRAM_CREATED("PaymentProgramCreated", "a_PaymentProgramCreated"),
  PAYMENT_PROGRAM_ACCEPTED_BY_CUSTOMER("PaymentProgramAcceptedByCustomer", "a_PaymentProgramAcceptedByCustomer"),
  PAYMENT_PROGRAM_ACCEPTED_BY_AGENT("PaymentProgramAcceptedByAgent", "a_PaymentProgramAcceptedByAgent"),
  PAYMENT_PROGRAM_CANCELLED_BY_CUSTOMER("PaymentProgramCancelledByCustomer", "a_PaymentProgramCancelledByCustomer"),
  PAYMENT_PROGRAM_CANCELLED_BY_AGENT("PaymentProgramCancelledByAgent", "a_PaymentProgramCancelledByAgent"),
  PAYMENT_PROGRAM_CANCELLED_DUE_TO_BROKEN_PROMISE("PaymentProgramCancelledDueToBrokenPromise",
    "a_PaymentProgramCancelledDueToBrokenPromise"),
  PAYMENT_PROGRAM_CANCELLED_DUE_TO_FUTURE_SCHEDULED_PAYMENT_REJECTED(
    "PaymentProgramCancelledDueToFutureScheduledPaymentRejected",
    "a_PaymentProgramCancelledDueToFutureScheduledPaymentRejected"),
  PAYMENT_PROGRAM_COMPLETED_BY_PROGRAM_MONITORING("PaymentProgramCompletedByProgramMonitoring",
    "a_PaymentProgramCompletedByProgramMonitoring"),
  PAYMENT_PROGRAM_FAILED_BY_PROGRAM_MONITORING("PaymentProgramFailedByProgramMonitoring",
    "a_PaymentProgramFailedByProgramMonitoring"),
  PAYMENT_PROGRAM_INSTALLMENT_FULFILLED_BY_PROGRAM_MONITORING("PaymentProgramInstallmentFulfilledByProgramMonitoring",
    "a_PaymentProgramInstallmentFulfilledByProgramMonitoring"),
  PAYMENT_PROGRAM_INSTALLMENT_FAILED_BY_PROGRAM_MONITORING("PaymentProgramInstallmentFulfilledByProgramMonitoring",
    "a_PaymentProgramInstallmentFulfilledByProgramMonitoring"),
  PAYMENT_PROGRAM_EXPIRED("PaymentProgramExpired", "a_PaymentProgramExpired"),
  PAYMENT_PROGRAM_ACCEPTED_BY_API("PaymentProgramAcceptedByAPI", "a_PaymentProgramAcceptedByAPI"),
  PAYMENT_PROGRAM_EXPIRED_BY_API("PaymentProgramExpiredByAPI", "a_PaymentProgramExpiredByAPI"),
  WORKFLOW_ACTIVITY_BUSINESS_CONTEXT_SUBMITTED_BY_CUSTOMER("WorkflowActivityBusContextSubmittedByCustomer" ,"a_WorkflowActivityBusContextSubmittedByCustomer"),
  WORKFLOW_ACTIVITY_RESPONSIBLE_CONTEXT_SUBMITTED_BY_CUSTOMER("WorkflowActivityRespContextSubmittedByCustomer","a_WorkflowActivityRespContextSubmittedByCustomer"),
  PROMISE_TO_PAYMENT_CREATED_BY_CUSTOMER("PromiseToPaymentCreatedByCustomer","a_PromiseToPaymentCreatedByCustomer"),
  PROMISE_TO_PAYMENT_UPDATED_BY_CUSTOMER("PromiseToPaymentUpdatedByCustomer","a_PromiseToPaymentUpdatedByCustomer"),
  PROMISE_TO_PAYMENT_DELETED_BY_CUSTOMER("PromiseToPaymentDeletedByCustomer","a_PromiseToPaymentDeletedByCustomer"),
  OVERALL_STATUS_UPDATED_BY_CUSTOMER_DUE_TO_WORKFLOW_ACTIVITY("OverallStatusUpdatedByCustomerDueToWorkflowActivity", "a_OverallStatusUpdatedByCustomerDueToWorkflowActivity");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String activityName;

  private String eventName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private WebhookEvent(String eventName, String activityName) {
    this.eventName    = eventName;
    this.activityName = activityName;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   activityName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static WebhookEvent activityNameToWebhookEvent(String activityName) {
    if (activityName == null) {
      return null;
    }

    for (WebhookEvent a : WebhookEvent.values()) {
      if (a.activityName().equalsIgnoreCase(activityName)) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   eventName  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static WebhookEvent eventNameToWebhookEvent(String eventName) {
    if (eventName == null) {
      return null;
    }

    for (WebhookEvent e : WebhookEvent.values()) {
      if (e.eventName().equalsIgnoreCase(eventName)) {
        return e;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if event is auto debit event.
   *
   * @param   eventName  String
   *
   * @return  boolean
   */
  public static boolean isAutoDebitEvent(String eventName) {
    if (AUTODEBIT_CREATED.eventName.equalsIgnoreCase(eventName)
          || AUTODEBIT_UPDATED.eventName.equalsIgnoreCase(eventName)
          || AUTODEBIT_CANCELLED.eventName.equalsIgnoreCase(eventName)) {
      return true;
    } else {
      return false;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fund acct event.
   *
   * @param   eventName  String
   *
   * @return  boolean
   */
  public static boolean isFundAcctEvent(String eventName) {
    if (FUND_ACCT_CREATED.eventName.equalsIgnoreCase(eventName)
          || FUND_ACCT_DELETED.eventName.equalsIgnoreCase(eventName)
          || FUND_ACCT_MADE_PRIMARY.eventName.equalsIgnoreCase(eventName)) {
      return true;
    } else {
      return false;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment event.
   *
   * @param   eventName  String
   *
   * @return  boolean
   */
  public static boolean isPaymentEvent(String eventName) {
    if (PAYMENT_CREATED.eventName.equalsIgnoreCase(eventName)
          || PAYMENT_UPDATED.eventName.equalsIgnoreCase(eventName)
          || PAYMENT_PROCESSED_BY_BATCH.eventName.equalsIgnoreCase(eventName)
          || PAYMENT_DELETED.eventName.equalsIgnoreCase(eventName)
          || PAYMENT_REJECTED.eventName.equalsIgnoreCase(eventName)
          || PAYMENT_PAID.eventName.equalsIgnoreCase(eventName)) {
      return true;
    } else {
      return false;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * activityName.
   *
   * @return  String
   */
  public String activityName() {
    return this.activityName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * eventName.
   *
   * @return  String
   */
  public String eventName() {
    return this.eventName;
  }
}
