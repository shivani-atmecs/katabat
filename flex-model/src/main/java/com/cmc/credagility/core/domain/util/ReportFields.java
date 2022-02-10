package com.cmc.credagility.core.domain.util;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:16
 */
public interface ReportFields {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  String[] DCPRfields = new String[] {
    "reportDate",
    "newAccountsPlaced",
    "cumulativeAccountsPlaced",
    "newBalancePlaced",
    "averagePlacementBalance",
    "cumulativeBalancePlaced",
    "totalBalances",
    "inactiveAccounts",
    "activeAccounts",
    "totalAccounts",
    "accountsStrategizedForLetters",
    "accountsStrategizedForIvr",
    "accountsStrategizedForDialer",
    "accountsStrategizedForEmail",
    "accountsStrategizedForSms",
    "totalTreatmentsStrategized",
    "totalUniqueAccountsAccrossChannelsScheduledForTreatment",
    "uniqueAccountWebVisits",
    "agentReportedDirectInbound",
    "agentReportedDirectInboundRPC",
    "agentReportedIVRInbound",
    "agentReportedIVRInboundRPC",
    "totalInbound",
    "ivrOutbound",
    "agentReportedIvrOutbound",
    "agentReportedIvrOutboundRPC",
    "dialer",
    "agentReportedDialer",
    "agentReportedDialerRPC",
    "agentReportedGETNEXTCALL",
    "agentReportedGETNEXTCALLRPC",
    "agentReportedAGENTCALL",
    "agentReportedAGENTCALLRPC",
    "totalOutbound",
    "agentReportedNONCALLDOC",
    "agentReportedNONCALLDOCRPC",
    "uniqueAccountsPaidToday",
    "uniqueAccountsPaidMTD",
    "rejectedTodayPayments",
    "deletedTodayPayments",
    "balancesOfUniqueAccountsPaid",
    "agentChannelPaymentsCreatedTodayAndScheduledForToday",
    "cumulativeAgentChannelPaymentsCreatedTodayAndScheduledForToday",
    "clientDirectPaymentsCreatedTodayAndScheduledForToday",
    "cumulativeClientDirectPaymentsCreatedTodayAndScheduledForToday",
    "websitePaymentsCreatedTodayAndScheduledForToday",
    "cumulativeWebsitePaymentsCreatedTodayAndScheduledForToday",
    "ivrPaymentsCreatedTodayAndScheduledForToday",
    "cumulativeIvrPaymentsCreatedTodayAndScheduledForToday",
    "totalPaymentsCreatedTodayAndScheduledForToday",
    "numberOfPaymentsCreatedTodayScheduledForToday",
    "numberOfPaymentsCreatedTodayScheduledForFuture",
    "uniqueAccountsCreatedAPaymentTodayScheduledForToday",
    "uniqueAccountsCreatedAFuturePaymentToday",
    "futurePaymentsCreatedToday",
    "futurePaymentsCreatedTodayViaAgents",
    "futurePaymentsCreatedTodayViaWebSite",
    "futurePaymentsCreatedTodayViaIVR",
    "promiseToPayCreatedToday",
    "portfolioId"
  };

  /** TODO: DOCUMENT ME! */
  String[] WebActivityDailyFields = new String[] {
    "Date",
    "WebActivityName",
    "TodayNumberofactivities",
    "TodayUniquerefNums",
    "TodayUniqueaccounts",
    "TodayTotalbalances",
    "TodayTotalpayments",
    "MTDNumberofactivities",
    "MTDUniquerefNums",
    "MTDUniqueaccounts",
    "MTDTotalbalances",
    "MTDTotalpayments",
    "L30Numberofactivities",
    "L30UniquerefNums",
    "L30Uniqueaccounts",
    "L30Totalbalances",
    "L30Totalpayments",
    "PTDNumberofactivities",
    "PTDUniquerefNums",
    "PTDUniqueaccounts",
    "PTDTotalbalances",
    "PTDTotalpayments"
  };

  /** TODO: DOCUMENT ME! */
  String[] WebActivityHourlyFields = new String[] {
    "Hour",
    "TodayNumberOfWebActivities",
    "TodayNumberOfPayments",
    "TodayNumberOfPaymentProgramsAccepted",
    "TodayNumberOfPromiseToPays",
    "TodayNumberOfRequestedAppointments",
    "TodayAccountMaintenance",
    "TodayNumberOfPageViews",
    "PTDNumberOfWebActivities",
    "PTDNumberOfPayments",
    "PTDNumberOfPaymentProgramsAccepted",
    "PTDNumberOfPromiseToPays",
    "PTDNumberOfRequestedAppointments",
    "PTDAccountMaintenance",
    "PTDNumberOfPageViews"
  };

  /** TODO: DOCUMENT ME! */
  String[] WebActivityWeeklyFields = new String[] {
    "Date",
    "DayOfWeek",
    "PortfolioId",
    "TodayNumberOfWebActivities",
    "TodayNumberOfPayments",
    "TodayNumberOfPaymentProgramsAccepted",
    "TodayNumberOfPromiseToPays",
    "TodayNumberOfRequestedAppointments",
    "TodayAccountMaintenance",
    "TodayNumberOfPageViews",
    "PTDNumberOfWebActivities",
    "PTDNumberOfPayments",
    "PTDNumberOfPaymentProgramsAccepted",
    "PTDNumberOfPromiseToPays",
    "PTDNumberOfRequestedAppointments",
    "PTDAccountMaintenance",
    "PTDNumberOfPageViews",
  };
} // end interface ReportFields
