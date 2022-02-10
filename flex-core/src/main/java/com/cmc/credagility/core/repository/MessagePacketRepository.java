package com.cmc.credagility.core.repository;

import java.util.List;

import com.cmc.credagility.core.domain.message.MessagePacket;
import com.cmc.credagility.core.domain.message.MessagePacketStatus;


/**
 * Created by wenchaoyong on 3/13/17.
 *
 * @author   <a href="mailto:wenchao.yong@ozstrategy.com">Wenchao Yong</a>
 * @version  03/13/2017 11:20
 */
public interface MessagePacketRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for message packet.
   *
   * @param   dataPacketName  String
   *
   * @return  MessagePacket
   */
  MessagePacket getMessagePacket(String dataPacketName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   messageStagingId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  List<MessagePacketStatus> getMessagePacketStatus(String messageStagingId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   */
  List<MessagePacketStatus> getMessagePacketStatus(Long portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message packet status by unique session id.
   *
   * @param   uniqueSessionId  String
   *
   * @return  List
   */
  List<MessagePacketStatus> getMessagePacketStatusByUniqueSessionId(String uniqueSessionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  messagePacketStatus  DOCUMENT ME!
   */
  void saveMessagePacketStatus(MessagePacketStatus messagePacketStatus);
} // end interface MessagePacketRepository
