package com.cmc.credagility.core.repository;

import java.util.List;

import org.hibernate.Query;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.message.MessageStaging;

import com.ozstrategy.credagility.core.repository.OzHibernateDaoSupport;


/**
 * Created by wenchaoyong on 3/13/17.
 *
 * @author   <a href="mailto:wenchao.yong@ozstrategy.com">Wenchao Yong</a>
 * @version  03/13/2017 11:32
 */
@Repository("messagingRepository")
public class MessagingRepositoryImpl extends OzHibernateDaoSupport implements MessagingRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  MessagingRepository#getMessageByMessageStagingId(String)
   */
  @Override public MessageStaging getMessageByMessageStagingId(String messageStagingId) {
    Query query = getSession().createQuery(
        "from MessageStaging r where r.messageStagingId =:messageStagingId");
    query.setString("messageStagingId", messageStagingId);

    return (MessageStaging) query.setMaxResults(1).uniqueResult();


  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  MessagingRepository#getMessageByUniqueSessionId(String)
   */
  @Override public MessageStaging getMessageByUniqueSessionId(String uniqueSessionId) {
    Query query = getSession().createQuery(
        "from MessageStaging r where r.uniqueSessionId =:uniqueSessionId");
    query.setString("uniqueSessionId", uniqueSessionId);

    MessageStaging message = (MessageStaging) query.setMaxResults(1).uniqueResult();

    return message;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override
  @SuppressWarnings("unchecked")
  public List<MessageStaging> getMessages() {
    Query query = getSession().createQuery("from MessageStaging");

    return query.list();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  MessagingRepository#removeMessage(com.cmc.credagility.core.domain.message.MessageStaging)
   */
  @Override public void removeMessage(MessageStaging message) {
    getSession().delete(message);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * saveMapMessage.
   *
   * @param   message  MessageStaging
   *
   * @return  MessageStaging
   */
  @Override public MessageStaging saveMapMessage(MessageStaging message) {
    getSession().saveOrUpdate(message);

    return message;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  MessagingRepository#saveMessage(com.cmc.credagility.core.domain.message.MessageStaging)
   */
  @Override public void saveMessage(MessageStaging message) {
    getSession().saveOrUpdate(message);
  }
} // end class MessagingRepositoryImpl
