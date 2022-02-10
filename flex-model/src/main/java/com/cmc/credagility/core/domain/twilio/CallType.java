package com.cmc.credagility.core.domain.twilio;

/**
 * Created with IntelliJ IDEA. User: liuqian Date: 14-4-16 Time: AM10:04 To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public enum CallType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  ClickToDial, DialPad, InboundDirect, TransferDirect, TransferTwoStep, TransferManualCancel, TransferManualEndCall,
  TransferTwoStepComplete, ConferenceAgent, ConferenceDrop3rdParty, ConferenceManualCancel, AgentDisconnect,
  CustomerDisconnect, AgentHangup;
}
