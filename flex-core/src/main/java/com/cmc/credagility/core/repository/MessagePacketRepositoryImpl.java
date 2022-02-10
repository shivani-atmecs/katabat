package com.cmc.credagility.core.repository;

import java.util.List;

import org.hibernate.Query;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.message.MessagePacket;
import com.cmc.credagility.core.domain.message.MessagePacketStatus;

import com.ozstrategy.credagility.core.repository.OzHibernateDaoSupport;


/**
 * Created by wenchaoyong on 3/13/17.
 *
 * @author   <a href="mailto:wenchao.yong@ozstrategy.com">Wenchao Yong</a>
 * @version  03/13/2017 11:22
 */
@Repository("messagePacketRepository")
public class MessagePacketRepositoryImpl extends OzHibernateDaoSupport implements MessagePacketRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  MessagePacketRepository#getMessagePacket(String)
   */
  @Override public MessagePacket getMessagePacket(String dataPacketName) {
    Query query = getSession().createQuery("from MessagePacket r where r.packetName =:dataPacketName");
    query.setString("dataPacketName", dataPacketName);

    MessagePacket messagePacket = (MessagePacket) query.setMaxResults(1).uniqueResult();

    return messagePacket;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  MessagePacketRepository#getMessagePacketStatus(Long)
   */
  @Override public List<MessagePacketStatus> getMessagePacketStatus(Long portfolioId) {
    Query query = getSession().createQuery(
        "from MessagePacketStatus r where r.messageStaging.portfolio.portfolioId =:portfolioId");
    query.setLong("portfolioId", portfolioId);

    List<MessagePacketStatus> messagePacketStatusList = query.list();

    return messagePacketStatusList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  MessagePacketRepository#getMessagePacketStatus(String)
   */
  @Override public List<MessagePacketStatus> getMessagePacketStatus(String messageStagingId) {
    Query query = getSession().createQuery(
        "from MessagePacketStatus r where r.messageStaging.messageStagingId =:messageStagingId");
    query.setString("messageStagingId", messageStagingId);

    List<MessagePacketStatus> messagePacketStatusList = query.list();

    return messagePacketStatusList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  MessagePacketRepository#getMessagePacketStatusByUniqueSessionId(String)
   */
  @Override public List<MessagePacketStatus> getMessagePacketStatusByUniqueSessionId(String uniqueSessionId) {
    Query query = getSession().createQuery(
        "from MessagePacketStatus r where r.messageStaging.uniqueSessionId =:uniqueSessionId");
    query.setString("uniqueSessionId", uniqueSessionId);

    List<MessagePacketStatus> messagePacketStatusList = query.list();

    return messagePacketStatusList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveMessagePacketStatus.
   *
   * @param  messagePacketStatus  MessagePacketStatus
   */
  @Override public void saveMessagePacketStatus(MessagePacketStatus messagePacketStatus) {
    getSession().saveOrUpdate(messagePacketStatus);
  }
} // end class MessagePacketRepositoryImpl
