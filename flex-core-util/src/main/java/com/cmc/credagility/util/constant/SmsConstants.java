package com.cmc.credagility.util.constant;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 18:20
 */
public class SmsConstants {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** The API request to send an SMS message was successful and the message is queued to be sent out. */
  public static final String QUEUED = "queued";

  /** Twilio is in the process of dispatching your message to the nearest upstream carrier in the SMS network. */
  public static final String SENDING = "sending";

  /** The message was sent to the nearest upstream carrier, and that carrier accepted the message. */
  public static final String SENT = "sent";


  /** TODO: DOCUMENT ME! */
  public static final String UNDELIVERED = "UNDELIVERED";


  /** TODO: DOCUMENT ME! */
  public static final String ERROR = "ERROR";


  /** TODO: DOCUMENT ME! */
  public static final String DELIVERED_TO_CARRIER = "DeliveredToCarrier";

  /** The message could not be sent, most likely because the "To" number is non-existent. */
  public static final String FAILED = "failed";

  /** On inbound messages only. The message was received by one of your Twilio numbers. */
  public static final String RECIEVED = "received";


  /** TODO: DOCUMENT ME! */
  public static final String SMS_SENDING = "SENDING";


  /** TODO: DOCUMENT ME! */
  public static final String SMS_DELIVERED = "DELIVERED";


  /** TODO: DOCUMENT ME! */
  public static final String SMS_FAILED = "FAILED";


  /** TODO: DOCUMENT ME! */
  public static final String DONOT_CONTACT_CLIENT = "DoNotContactClient";


  /** TODO: DOCUMENT ME! */
  public static final String DONOT_CONTACT = "DONOTCONTACT";


  /** TODO: DOCUMENT ME! */
  public static final String SMS_SENT = "SENT";


  /** TODO: DOCUMENT ME! */
  public static final String SMS_SEND_FAILED = "SEND_FAILED";

} // end class SmsConstants
