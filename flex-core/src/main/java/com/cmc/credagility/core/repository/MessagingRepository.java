package com.cmc.credagility.core.repository;

import java.util.List;

import com.cmc.credagility.core.domain.message.MessageStaging;


/**
 * Created by wenchaoyong on 3/13/17.
 *
 * @author   <a href="mailto:wenchao.yong@ozstrategy.com">Wenchao Yong</a>
 * @version  03/13/2017 11:30
 */
public interface MessagingRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for message by message staging id.
   *
   * @param   messageStagingId  String
   *
   * @return  MessageStaging
   */
  MessageStaging getMessageByMessageStagingId(String messageStagingId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   uniqueSessionId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  MessageStaging getMessageByUniqueSessionId(String uniqueSessionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  List<MessageStaging> getMessages();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  message  DOCUMENT ME!
   */
  void removeMessage(MessageStaging message);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   message  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  MessageStaging saveMapMessage(MessageStaging message);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  message  DOCUMENT ME!
   */
  void saveMessage(MessageStaging message);
} // end interface MessagingRepository
